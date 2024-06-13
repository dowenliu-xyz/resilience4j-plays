// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting

@Suppress("unused", "UNUSED_PARAMETER")
open class ParentCase101KotlinParentForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "superFallback")
    open fun greeting(name: String?): String {
        return "parent: hello $name"
    }

    private fun superClassFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SuperClassAnno}:${FallbackLocation.Super}:${Greeting.doFallback(name, e)}"
    }

    private fun superFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SuperMethodAnno}:${FallbackLocation.Super}:${Greeting.doFallback(name, e)}"
    }

    private fun classFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SubClassAnno}:${FallbackLocation.Super}:${Greeting.doFallback(name, e)}"
    }

    private fun fallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SubMethodAnno}:${FallbackLocation.Super}:${Greeting.doFallback(name, e)}"
    }
}
