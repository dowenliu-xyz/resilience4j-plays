// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.interfaces.cglib.biz.DemoCase
import org.example.ae.interfaces.cglib.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
class Case176JavaInterfaceKotlinDemo : Case176KotlinInterfaceForJava {

    override fun sn(): String {
        return "176"
    }

    override fun hasClassAnnotationOnInterface(): Boolean {
        return false
    }

    override fun originMethodInInterface(): DemoCase.OriginMethodInInterface {
        return DemoCase.OriginMethodInInterface.AbstractWithAnnotation
    }

    override fun fallbackInInterface(): DemoCase.FallbackInInterface {
        return DemoCase.FallbackInInterface.None
    }

    override fun hasClassAnnotationOnClass(): Boolean {
        return true
    }

    override fun originMethodInClass(): DemoCase.OriginMethodInClass {
        return DemoCase.OriginMethodInClass.WithoutAnnotation
    }

    override fun hasFallbackInClass(): Boolean {
        return false
    }

    override fun greeting(name: String?): String {
        return doGreeting(name)
    }

}
