// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.supers.biz.DemoCase
import org.example.ae.supers.biz.DemoCase.EffectiveAnnotation.*
import org.example.ae.supers.biz.DemoCase.EffectiveFallback.FallbackInSuper
import org.example.ae.supers.biz.Greeting.doFallback
import org.example.ae.supers.biz.Greeting.doGreeting

abstract class Case103KotlinSuperForKotlin : DemoCase {

    @CircuitBreaker(name = "demo", fallbackMethod = "superMethodFallback")
    override fun greeting(name: String?): String {
        return "super:${doGreeting(name)}"
    }

    open fun superClassFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnSuper:$FallbackInSuper:${doFallback(name, thr)}"
    }

    open fun superMethodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInSuper:$FallbackInSuper:${doFallback(name, thr)}"
    }

    open fun classFallback(name: String?, thr: Throwable?): String {
        return "$ClassAnnotationOnSub:$FallbackInSuper:${doFallback(name, thr)}"
    }

    open fun methodFallback(name: String?, thr: Throwable?): String {
        return "$MethodAnnotationInSub:$FallbackInSuper:${doFallback(name, thr)}"
    }

}
