package org.example.jp.demos.annobase.interfaces

interface AnnoBaseKotlinInterfaceForKotlin {
    fun greeting(name: String?): String

    fun fallback(name: String?, thr: Throwable?): String
}
