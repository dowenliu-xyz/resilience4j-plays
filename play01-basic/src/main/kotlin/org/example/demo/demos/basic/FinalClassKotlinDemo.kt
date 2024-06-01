package org.example.demo.demos.basic

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.demo.biz.Greeting
import org.springframework.stereotype.Component

// Kotlin spring 插件明确说明只对特定注解标注的类应用 allopen，java-base 配置的不会自动 open
// 当前类为 final 的
// 在 FinalClassConfig 类中解除注释来启用 bean
@CircuitBreaker(name = "demo")
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
