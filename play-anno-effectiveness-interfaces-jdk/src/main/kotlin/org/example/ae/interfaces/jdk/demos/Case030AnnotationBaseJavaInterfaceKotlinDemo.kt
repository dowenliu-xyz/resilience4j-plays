// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos

import org.example.ae.interfaces.jdk.biz.DemoCase
import org.springframework.stereotype.Component

@Component
class Case030AnnotationBaseJavaInterfaceKotlinDemo : Case030AnnotationBaseJavaInterfaceForKotlin {

    override fun sn(): String {
        return "030"
    }

    override fun hasClassAnnotationOnInterface(): Boolean {
        return true
    }

    override fun originMethodInInterface(): DemoCase.OriginMethodInInterface {
        return DemoCase.OriginMethodInInterface.DefaultWithAnnotation
    }

    override fun fallbackInInterface(): DemoCase.FallbackInInterface {
        return DemoCase.FallbackInInterface.None
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