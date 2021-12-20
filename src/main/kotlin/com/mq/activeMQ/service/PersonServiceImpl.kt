package com.mq.activeMQ.service

import com.mq.activeMQ.dao.PersonDao
import com.mq.activeMQ.dto.PersonDto
import com.mq.activeMQ.model.person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
@Component("personServiceImpl")
class PersonServiceImpl(

    @Autowired
    private val personDto: PersonDto, val personDao: PersonDao,
    @Autowired
    private val jmsTemplate: JmsTemplate
) : PersonService, ApplicationListener<ApplicationReadyEvent> {

    override fun getAllPerson(): List<person> = personDao.findAll().toList()

    override fun create(personIn: PersonDto) {
        val newPerson = person(
            name = personIn.name,
            lastname = personIn.lastname,
        )
        println(newPerson.name)
        personDao.save(newPerson)
    }

    override fun onApplicationEvent(event: ApplicationReadyEvent) {

    }
}