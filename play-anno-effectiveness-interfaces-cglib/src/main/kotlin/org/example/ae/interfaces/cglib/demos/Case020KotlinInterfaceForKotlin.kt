// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.interfaces.cglib.biz.DemoCase
import org.example.ae.interfaces.cglib.biz.Greeting.doGreeting

@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
interface Case020KotlinInterfaceForKotlin : DemoCase {

    @CircuitBreaker(name = "demo", fallbackMethod = "interfaceMethodFallback")
    override fun greeting(name: String?): String {
        return "super:${doGreeting(name)}"
    }

}
