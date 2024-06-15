// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.interfaces.jdk.biz.DemoCase

@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
interface Case090AnnotationBaseKotlinInterfaceForJava : DemoCase {

    fun interfaceClassFallback(name: String?, thr: Throwable?): String

    fun interfaceMethodFallback(name: String?, thr: Throwable?): String

    fun classFallback(name: String?, thr: Throwable?): String

    fun methodFallback(name: String?, thr: Throwable?): String

}
