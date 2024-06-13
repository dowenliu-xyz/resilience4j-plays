package org.example.ae.demos.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting

@Suppress("unused")
@CircuitBreaker(name = "demo", fallbackMethod = "parentClassFallback")
open class ParentCase02KotlinParentForKotlin {
    @CircuitBreaker(name = "demo", fallbackMethod = "parentMethodFallback")
    open fun greeting(name: String?): String {
        return "parent: hello $name"
    }

    private fun parentClassFallback(name: String?, e: Throwable?): String {
        return ""
    }

    private fun parentMethodFallback(name: String?, e: Throwable?): String {
        return ""
    }

    private fun fallback(name: String?, e: Throwable?): String {
        return Greeting.doFallback(name, e)
    }
}
