package com.mq.activeMQ.service

import com.mq.activeMQ.dao.PersonDao
import com.mq.activeMQ.dto.PersonDto
import com.mq.activeMQ.model.person

interface PersonService {

    fun create(personIn: PersonDto)
    fun getAllPerson(): List<person>
}