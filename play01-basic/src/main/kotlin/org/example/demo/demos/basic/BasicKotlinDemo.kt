package org.example.demo.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Greeting
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Suppress("unused", "UNUSED_PARAMETER")
@Component
class BasicKotlinDemo {
    companion object {
        private val log = LoggerFactory.getLogger(BasicKotlinDemo::class.java)
    }


    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback2(name: String?, thr: Throwable): String {
        log.error("Something wrong", thr)
        return "Hello there"
    }

    private fun fallback(thr: Throwable): String {
        log.error("Something wrong", thr)
        return "Hello there"
    }
}