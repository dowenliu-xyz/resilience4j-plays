package org.example.ae.sic.demos.case02

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.sic.biz.Greeting

interface KotlinInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallbackByInterface")
    fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }
}
