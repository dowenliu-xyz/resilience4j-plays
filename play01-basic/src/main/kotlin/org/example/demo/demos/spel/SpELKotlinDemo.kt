package org.example.demo.demos.spel

import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import org.example.demo.biz.Greeting
import org.springframework.stereotype.Component

@Suppress("unused", "UNUSED_PARAMETER")
@Component
class SpELKotlinDemo {
    @RateLimiter(name = "#root.className + '-' + #root.methodName", fallbackMethod = "#a0 == 'jack' ? 'jackFallback' : 'fallback'")
    fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun jackFallback(thr: Throwable): String {
        return "Hey buddy"
    }

    private fun fallback(thr: Throwable): String {
        return "Hello there"
    }
}