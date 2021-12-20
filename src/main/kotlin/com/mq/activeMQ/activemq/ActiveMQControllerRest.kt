package com.mq.activeMQ.activemq

import com.mq.activeMQ.dto.PersonDto
import com.mq.activeMQ.model.person
import com.mq.activeMQ.service.PersonService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.MediaType
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.*
import java.beans.XMLDecoder


@RestController
@RequestMapping("/active")
class ActiveMQControllerRest(
    @Autowired
    private val jmsTemplate: JmsTemplate,
    @Qualifier("personServiceImpl") @Autowired
    private val personService: PersonService,
) {
    @PostMapping(value = ["/send"], produces = [MediaType.APPLICATION_XML_VALUE], consumes=[MediaType.APPLICATION_XML_VALUE])
    fun sendMessage(@RequestBody personDtoList: String):String{
        println(personDtoList)
        jmsTemplate.convertAndSend("Person", personDtoList)
        return "done"
    }

}