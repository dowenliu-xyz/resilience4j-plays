package org.example.ae.demos.interfaces

import org.example.ae.biz.Greeting
import org.springframework.stereotype.Component

@Suppress("unused")
@Component
class InterfaceOriginMethodDefaultMethodAnnoJavaInterfaceKotlinDemo :
    InterfaceOriginMethodDefaultMethodAnnoJavaInterfaceForKotlin {
    private fun fallback(name: String, e: Throwable): String {
        return Greeting.doFallback(name, e)
    }
}
