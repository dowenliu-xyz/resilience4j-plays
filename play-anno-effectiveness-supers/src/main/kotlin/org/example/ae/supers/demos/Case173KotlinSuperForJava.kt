// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.supers.biz.DemoCase

abstract class Case173KotlinSuperForJava : DemoCase {

    @CircuitBreaker(name = "demo", fallbackMethod = "superMethodFallback")
    abstract override fun greeting(name: String?): String

}
