package org.example.ae.demos.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import jakarta.annotation.Nullable
import org.example.ae.biz.Greeting
import org.example.ae.biz.Greeting.doFallback
import org.springframework.stereotype.Component

@Component
class InterfaceNoOriginFallbackOverriddenMethodAnnoKotlinInterfaceKotlinDemo : InterfaceNoOriginFallbackOverriddenMethodAnnoKotlinInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    fun greeting(@Nullable name: String?): String {
        return Greeting.doGreeting(name)
    }

    override fun fallback(name: String?, e: Throwable?): String {
        return doFallback(name, e)
    }
}
