package org.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BfmApplication

fun main(args: Array<String>) {
    runApplication<BfmApplication>(*args)
}