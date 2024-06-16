package org.example.ae.sic.demos.case02

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.sic.biz.Greeting

open class KotlinParentForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallbackBySuper")
    open fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }
}
