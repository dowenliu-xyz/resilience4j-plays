package org.example.ae.sic.demos.case01

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.sic.biz.Greeting
import org.springframework.stereotype.Component

@Component
class JavaParentKotlinInterfaceKotlinDemo : JavaParentForKotlin(), KotlinInterfaceForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    override fun fallback(name: String?, e: Throwable?): String {
        return super<JavaParentForKotlin>.fallback(name, e)
    }
}