package org.example.ae.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "fallback")
class ProtectedMethodClassAnnoKotlinDemo {
    private var self: ProtectedMethodClassAnnoKotlinDemo? = null

    @Autowired
    fun setSelf(self: ProtectedMethodClassAnnoKotlinDemo?) {
        this.self = self
    }

    protected fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    fun exportGreeting(name: String?): String {
        return self!!.greeting(name)
    }

    private fun fallback(name: String, thr: Throwable): String {
        return Greeting.doFallback(name, thr)
    }
}
