// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos

import org.example.ae.interfaces.jdk.biz.DemoCase
import org.example.ae.interfaces.jdk.biz.Greeting.doGreeting

interface Case147AnnotationBaseKotlinInterfaceForKotlin : DemoCase {

    override fun greeting(name: String?): String {
        return "super:${doGreeting(name)}"
    }

    fun interfaceClassFallback(name: String?, thr: Throwable?): String

    fun interfaceMethodFallback(name: String?, thr: Throwable?): String

    fun classFallback(name: String?, thr: Throwable?): String

    fun methodFallback(name: String?, thr: Throwable?): String

}
