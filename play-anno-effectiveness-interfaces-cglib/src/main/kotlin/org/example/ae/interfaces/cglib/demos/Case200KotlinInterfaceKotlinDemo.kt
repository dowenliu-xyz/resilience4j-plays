// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos

import org.example.ae.interfaces.cglib.biz.DemoCase
import org.example.ae.interfaces.cglib.biz.Greeting.doGreeting
import org.springframework.stereotype.Component

@Component
class Case200KotlinInterfaceKotlinDemo : Case200KotlinInterfaceForKotlin {

    override fun sn(): String {
        return "200"
    }

    override fun hasClassAnnotationOnInterface(): Boolean {
        return false
    }

    override fun originMethodInInterface(): DemoCase.OriginMethodInInterface {
        return DemoCase.OriginMethodInInterface.AbstractWithoutAnnotation
    }

    override fun fallbackInInterface(): DemoCase.FallbackInInterface {
        return DemoCase.FallbackInInterface.None
    }

    override fun hasClassAnnotationOnClass(): Boolean {
        return false
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
