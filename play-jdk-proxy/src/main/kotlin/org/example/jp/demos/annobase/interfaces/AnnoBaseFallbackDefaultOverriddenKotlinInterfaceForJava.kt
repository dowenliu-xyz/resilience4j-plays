package org.example.jp.demos.annobase.interfaces

@Suppress("unused")
interface AnnoBaseFallbackDefaultOverriddenKotlinInterfaceForJava {
    fun greeting(name: String?): String

    fun fallback(name: String?, thr: Throwable?): String {
        return ""
    }
}
