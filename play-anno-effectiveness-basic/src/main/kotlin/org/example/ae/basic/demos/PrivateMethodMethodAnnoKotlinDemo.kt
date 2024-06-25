package org.example.ae.basic.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.basic.biz.Greeting
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PrivateMethodMethodAnnoKotlinDemo {
    private var self: PrivateMethodMethodAnnoKotlinDemo? = null

    @Autowired
    fun setSelf(self: PrivateMethodMethodAnnoKotlinDemo?) {
        this.self = self
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    private fun greeting(name: String): String {
        return Greeting.doGreeting(name)
    }

    fun exportGreeting(name: String): String {
        return self!!.greeting(name)
    }

    private fun fallback(name: String, thr: Throwable): String {
        return Greeting.doFallback(name, thr)
    }
}
