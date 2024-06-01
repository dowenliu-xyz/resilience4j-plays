package org.example.demo.demos.annobase.interfaces

interface AnnoBaseKotlinInterfaceForJava {
    fun greeting(name: String?): String

    fun fallback(name: String?, thr: Throwable?): String
}
