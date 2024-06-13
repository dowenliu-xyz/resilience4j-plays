package org.example.ae.demos.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import jakarta.annotation.Nullable

interface InterfaceOriginMethodMethodAnnoKotlinInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    fun greeting(@Nullable name: String?): String
}
