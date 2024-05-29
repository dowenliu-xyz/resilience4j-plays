package org.example.demo.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TestInterfaceKt6Service : TestInterface6 {
    companion object {
        private val log = LoggerFactory.getLogger(TestInterfaceKt6Service::class.java)
    }

    override fun hello(name: String): String {
        require(name.isNotBlank()) { "name is blank" }
        return "hello, $name"
    }

    override fun getLogger(): Logger {
        return log
    }

    override fun fallback(name: String, throwable: Throwable): String {
        log.debug("Throwable type: {}", throwable.javaClass.name)
        return "fallback, $name"
    }
}
