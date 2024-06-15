// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.interfaces.cglib.biz.DemoCase

@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
interface Case092KotlinInterfaceForJava : DemoCase {

    fun interfaceClassFallback(name: String?, thr: Throwable?): String

    fun interfaceMethodFallback(name: String?, thr: Throwable?): String

    fun classFallback(name: String?, thr: Throwable?): String

    fun methodFallback(name: String?, thr: Throwable?): String

}
