package org.example.ae.sic.demos.case02

import org.example.ae.sic.biz.Greeting
import org.springframework.stereotype.Component

@Component
class Case02JavaParentJavaInterfaceKotlinDemo : JavaParentForKotlin(), JavaInterfaceForKotlin {
    override fun greeting(name: String?): String {
        return super<JavaInterfaceForKotlin>.greeting(name)
    }

    fun fallbackBySuper(name: String?, e: Throwable?): String {
        return "bySuper:" + Greeting.doFallback(name, e)
    }

    fun fallbackByInterface(name: String?, e: Throwable?): String {
        return "byInterface:" + Greeting.doFallback(name, e)
    }
}
