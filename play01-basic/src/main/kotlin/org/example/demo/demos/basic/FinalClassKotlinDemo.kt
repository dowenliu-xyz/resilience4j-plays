package org.example.demo.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Greeting
import org.springframework.stereotype.Component

// TODO 提示 final 类不能作为 Bean? 这似乎是 Spring 插件应该提供的功能，而不是 r4j 插件应该做的事。
//      至少提示注解不生效。
//@Component // Enable this will cause bootstrap failure.
class FinalClassKotlinDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback(name: String, thr: Throwable): String {
        return Greeting.doFallback(name, thr)
    }

    private fun fallback(thr: Throwable): String {
        return Greeting.doFallback(thr)
    }
}
