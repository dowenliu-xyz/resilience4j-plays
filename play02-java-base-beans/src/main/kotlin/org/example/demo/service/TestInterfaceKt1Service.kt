package org.example.demo.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TestInterfaceKt1Service : TestInterfaceKt1 {
    companion object {
        private val log = LoggerFactory.getLogger(TestInterfaceKt1Service::class.java)
    }
    override fun hello(name: String?): String {
        require(!name.isNullOrBlank()) { "name is blank" }
        return "hello, $name"
    }

    override val logger: Logger
        get() = log

    override fun fallback(name: String, throwable: Throwable): String? {
        log.debug("Throwable type: {}", throwable.javaClass.name)
        return "fallback, $name"
    }
}
