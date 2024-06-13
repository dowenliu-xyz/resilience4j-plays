// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.biz.Greeting

@Suppress("unused", "UNUSED_PARAMETER")
open class ParentCase112KotlinParentForKotlin {
    open fun greeting(name: String?): String {
        return "parent: hello $name"
    }

    protected open fun superClassFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SuperClassAnno}:${FallbackLocation.Super}:${Greeting.doFallback(name, e)}"
    }

    protected open fun superFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SuperMethodAnno}:${FallbackLocation.Super}:${Greeting.doFallback(name, e)}"
    }

    protected open fun classFallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SubClassAnno}:${FallbackLocation.Super}:${Greeting.doFallback(name, e)}"
    }

    protected open fun fallback(name: String?, e: Throwable?): String {
        return "${TakeEffectAnno.SubMethodAnno}:${FallbackLocation.Super}:${Greeting.doFallback(name, e)}"
    }
}
