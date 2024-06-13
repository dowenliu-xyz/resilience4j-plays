package org.example.ae.demos.interfaces

import org.example.ae.biz.Greeting

interface InterfaceNoOriginFallbackOverriddenClassAnnoKotlinInterfaceForKotlin {
    fun fallback(name: String?, e: Throwable?): String {
        return ""
    }
}
