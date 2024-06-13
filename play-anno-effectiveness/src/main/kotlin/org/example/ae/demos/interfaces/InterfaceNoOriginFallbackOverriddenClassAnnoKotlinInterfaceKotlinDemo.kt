package org.example.ae.demos.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import jakarta.annotation.Nullable
import org.example.ae.biz.Greeting
import org.example.ae.biz.Greeting.doFallback
import org.springframework.stereotype.Component

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "fallback")
class InterfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceKotlinDemo : InterfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceForKotlin {
    fun greeting(@Nullable name: String?): String {
        return Greeting.doGreeting(name)
    }

    override fun fallback(name: String?, e: Throwable?): String {
        return doFallback(name, e)
    }
}
