package com.mq.activeMQ.dto

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component("personDto")
@Root(name = "person")
data class PersonDto (
    @Value("personDto.name")
    @field:Element(name="name")
    var name: String = "",
    @Value("personDto.lastname")
    @field:Element(name =  "lastname")
    var lastname: String = "",
)