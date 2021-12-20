package com.mq.activeMQ.dao

import com.mq.activeMQ.model.person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component

@Component
interface PersonDao : CrudRepository<person,Int> {
}