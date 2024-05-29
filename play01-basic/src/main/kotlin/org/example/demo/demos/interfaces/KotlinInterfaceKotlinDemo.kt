package org.example.demo.demos.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Greeting
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Suppress("unused")
@Component
class KotlinInterfaceKotlinDemo : KotlinInterfaceForKotlin {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(JavaInterfaceKotlinDemo::class.java)
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }
}