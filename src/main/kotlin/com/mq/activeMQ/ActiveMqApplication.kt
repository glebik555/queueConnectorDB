package com.mq.activeMQ

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jms.annotation.EnableJms

@SpringBootApplication
@EnableJms
class ActiveMqApplication

fun main(args: Array<String>) {
	runApplication<ActiveMqApplication>(*args)
}
