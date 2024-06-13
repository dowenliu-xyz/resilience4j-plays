package org.example.ae.demos.interfaces

import org.example.ae.biz.Greeting

interface InterfaceNoOriginFallbackOverriddenMethodAnnoKotlinInterfaceForJava {
    fun fallback(name: String?, e: Throwable?): String {
        return ""
    }
}
