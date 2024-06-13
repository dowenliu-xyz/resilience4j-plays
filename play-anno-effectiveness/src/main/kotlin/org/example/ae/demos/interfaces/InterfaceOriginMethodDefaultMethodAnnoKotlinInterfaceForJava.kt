package org.example.ae.demos.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import jakarta.annotation.Nullable
import org.example.ae.biz.Greeting

interface InterfaceOriginMethodDefaultMethodAnnoKotlinInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO 没有找到 fallbackMethod
    fun greeting(@Nullable name: String?): String {
        return Greeting.doGreeting(name)
    }
}
