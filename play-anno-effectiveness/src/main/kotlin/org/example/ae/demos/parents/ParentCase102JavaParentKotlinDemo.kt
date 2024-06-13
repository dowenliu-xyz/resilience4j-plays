// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting
import org.springframework.stereotype.Component

@Suppress("unused", "UNUSED_PARAMETER")
@Component
class ParentCase102JavaParentKotlinDemo : ParentCase102JavaParentForKotlin() {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    override fun greeting(name: String?): String {
        return Greeting.doGreeting(name)
    }

    private fun superClassFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SuperClassAnno}:${FallbackLocation.Sub}:${Greeting.doFallback(name, e)}"
    }

    private fun superFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SuperMethodAnno}:${FallbackLocation.Sub}:${Greeting.doFallback(name, e)}"
    }

    private fun classFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SubClassAnno}:${FallbackLocation.Sub}:${Greeting.doFallback(name, e)}"
    }

    private fun fallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SubMethodAnno}:${FallbackLocation.Sub}:${Greeting.doFallback(name, e)}"
    }
}
