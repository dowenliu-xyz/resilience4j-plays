package org.example.demo.demos.javabase.interfaces

@Suppress("unused")
interface JavaBaseFallbackDefaultOverriddenKotlinInterfaceForKotlin {
    fun greeting(name: String?): String

    fun fallback(name: String?, thr: Throwable?): String {
        return ""
    }
}
