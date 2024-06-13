// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting
import org.springframework.stereotype.Component

@Suppress("unused", "UNUSED_PARAMETER")
@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
class ParentCase021KotlinParentKotlinDemo : ParentCase021KotlinParentForKotlin() {

    override fun superClassFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SuperClassAnno}:${FallbackLocation.Sub}:${Greeting.doFallback(name, e)}"
    }

    override fun superFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SuperMethodAnno}:${FallbackLocation.Sub}:${Greeting.doFallback(name, e)}"
    }

    override fun classFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SubClassAnno}:${FallbackLocation.Sub}:${Greeting.doFallback(name, e)}"
    }

    override fun fallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SubMethodAnno}:${FallbackLocation.Sub}:${Greeting.doFallback(name, e)}"
    }
}
