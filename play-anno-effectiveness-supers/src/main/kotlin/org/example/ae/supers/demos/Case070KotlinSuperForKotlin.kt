// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.supers.biz.DemoCase

@CircuitBreaker(name = "demo", fallbackMethod = "superClassFallback")
abstract class Case070KotlinSuperForKotlin : DemoCase {

    @CircuitBreaker(name = "demo", fallbackMethod = "superMethodFallback")
    abstract override fun greeting(name: String?): String

    abstract fun superClassFallback(name: String?, thr: Throwable?): String

    abstract fun superMethodFallback(name: String?, thr: Throwable?): String

    abstract fun classFallback(name: String?, thr: Throwable?): String

    abstract fun methodFallback(name: String?, thr: Throwable?): String

}