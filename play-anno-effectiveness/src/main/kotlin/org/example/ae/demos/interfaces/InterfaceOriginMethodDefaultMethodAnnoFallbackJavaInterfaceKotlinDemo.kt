package org.example.ae.demos.interfaces

import org.example.ae.biz.Greeting
import org.springframework.stereotype.Component

@Component
class InterfaceOriginMethodDefaultMethodAnnoFallbackJavaInterfaceKotlinDemo :
    InterfaceOriginMethodDefaultMethodAnnoFallbackJavaInterfaceForKotlin {
    override fun fallback(name: String, e: Throwable): String {
        return Greeting.doFallback(name, e)
    }
}
