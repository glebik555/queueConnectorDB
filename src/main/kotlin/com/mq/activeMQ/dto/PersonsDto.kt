package com.mq.activeMQ.dto

import org.simpleframework.xml.ElementList
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component("personsDto")

data class PersonsDto (
    @Value("personsDto")
    @field:ElementList(inline = true, required = false)
     var person: ArrayList<PersonDto> = arrayListOf()
){
    fun getList():ArrayList<PersonDto> = person
}
