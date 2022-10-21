package de.moritzluedtke.daiqserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DaiqServerApplication

fun main(args: Array<String>) {
	runApplication<DaiqServerApplication>(*args)
}
