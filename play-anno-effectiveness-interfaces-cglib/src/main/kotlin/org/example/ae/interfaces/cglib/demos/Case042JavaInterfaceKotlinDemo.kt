// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos

import org.example.ae.interfaces.cglib.biz.DemoCase
import org.springframework.stereotype.Component

@Component
class Case042JavaInterfaceKotlinDemo : Case042JavaInterfaceForKotlin {

    override fun sn(): String {
        return "042"
    }

    override fun hasClassAnnotationOnInterface(): Boolean {
        return true
    }

    override fun originMethodInInterface(): DemoCase.OriginMethodInInterface {
        return DemoCase.OriginMethodInInterface.DefaultWithoutAnnotation
    }

    override fun fallbackInInterface(): DemoCase.FallbackInInterface {
        return DemoCase.FallbackInInterface.Default
    }

    override fun hasClassAnnotationOnClass(): Boolean {
        return false
    }

    override fun originMethodInClass(): DemoCase.OriginMethodInClass {
        return DemoCase.OriginMethodInClass.None
    }

    override fun hasFallbackInClass(): Boolean {
        return false
    }

}
