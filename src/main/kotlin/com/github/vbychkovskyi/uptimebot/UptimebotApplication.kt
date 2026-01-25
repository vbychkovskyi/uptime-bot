package com.github.vbychkovskyi.uptimebot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UptimebotApplication

fun main(args: Array<String>) {
    runApplication<UptimebotApplication>(*args)
}
