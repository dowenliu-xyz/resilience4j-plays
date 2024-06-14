package org.example.demo.demos.annobase.interfaces

@Suppress("unused")
interface AnnoBaseFallbackDefaultOverriddenKotlinInterfaceForKotlin {
    fun greeting(name: String?): String

    fun fallback(name: String?, thr: Throwable?): String {
        return ""
    }
}
