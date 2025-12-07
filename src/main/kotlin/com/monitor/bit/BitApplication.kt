package com.monitor.bit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class BitApplication

fun main(args: Array<String>) {
	runApplication<BitApplication>(*args)
}
