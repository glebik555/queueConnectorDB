package com.mq.activeMQ.activemq

import com.mq.activeMQ.dto.PersonDto
import com.mq.activeMQ.dto.PersonsDto
import com.mq.activeMQ.service.PersonService
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component


@Component
class ActiveMQConsumer(
    @Qualifier("personServiceImpl") @Autowired
    private val personService: PersonService,
    private val personDto: PersonDto,
) {
    @JmsListener(destination = "Person")
    fun processPersons(personDtoList: String) {

        val serializer: Serializer = Persister()
        val newPersonsDto: PersonsDto = serializer.read(PersonsDto::class.java, personDtoList)
        for (i in newPersonsDto.person) {
            println(i.name + " " + i.lastname)
        }
        var flag: Boolean = true
        for (index in 0 until newPersonsDto.person.size) {

            for (j in personService.getAllPerson()) {
                if (newPersonsDto.person[index].name == j.name && newPersonsDto.person[index].lastname == j.lastname) {
                    flag = false
                    println("ignoring person: ${newPersonsDto.person[index].name} ${newPersonsDto.person[index].lastname}")
                }
            }
            if (flag) {
                personService.create(newPersonsDto.person[index])
            }
            flag = true
        }
    }
}