package org.example.demo.demos.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Greeting
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class JavaParentKotlinDemo : JavaParentForKotlin() {
    companion object {
        private val log = LoggerFactory.getLogger(JavaParentKotlinDemo::class.java)
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "fallback2")
    fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback2(thr: Throwable): String {
        log.error("Something wrong", thr)
        return "Hello there"
    }
}