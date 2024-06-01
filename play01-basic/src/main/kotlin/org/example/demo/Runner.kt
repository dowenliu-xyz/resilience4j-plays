package org.example.demo

import org.example.demo.demos.basic.BasicJavaDemo
import org.example.demo.demos.basic.BasicKotlinDemo
import org.example.demo.demos.basic.FinalMethodJavaDemo
import org.example.demo.demos.basic.FinalMethodKotlinDemo
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Runner(
    private val basicJavaDemo: BasicJavaDemo,
    private val basicKotlinDemo: BasicKotlinDemo,
    private val finalMethodJavaDemo: FinalMethodJavaDemo,
    private val finalMethodKotlinDemo: FinalMethodKotlinDemo,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        run {
            expectConflict(basicJavaDemo::greeting)
            expectConflict(basicKotlinDemo::greeting)
            expectFallbackNotTakeEffect(finalMethodJavaDemo::greeting)
            expectFallbackNotTakeEffect(finalMethodKotlinDemo::greeting)
        }
        run {

        }
    }
}

internal fun expectConflict(function: (String) -> String) {
    try {
        val result = function("")
        throw AssertionError("expect conflict, but got \"$result\"")
    } catch (e: IllegalStateException) {
        e.message?.let {
            if (it.startsWith("You have more that one fallback method that cover the same exception type")) {
                return
            }
        }
        throw e
    }
}

internal fun expectFallbackNotTakeEffect(function: (String) -> String, aspectClass: String = "CircuitBreakerAspect") {
    try {
        val result = function("")
        throw AssertionError("expect error, but got \"$result\"")
    } catch (e: IllegalArgumentException) {
        if (e.stackTrace.any { it.className.contains(aspectClass) }) {
            throw AssertionError("expect aspect not take effect", e)
        }
        e.message?.let {
            if ("name is null or empty" == it) return
        }
        throw e
    } catch (e: Throwable) {
        if (e.stackTrace.any { it.className.contains(aspectClass) }) {
            throw AssertionError("expect aspect not take effect", e)
        }
        throw e
    }
}
