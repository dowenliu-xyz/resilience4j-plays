package org.example.demo.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Greeting
import org.example.demo.biz.Greeting.doFallback
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Suppress("unused")
@Component
@CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO 添加限流示例，会观察到 fallback 也被限流而不会被执行
class ClassLevelKotlinDemo {
    @CircuitBreaker(name = "demo")
    fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun fallback(name: String?, thr: Throwable): String {
        return doFallback(name, thr)
    }
}