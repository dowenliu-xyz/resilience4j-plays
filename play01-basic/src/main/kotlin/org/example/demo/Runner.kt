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

internal fun expectFallbackNotTakeEffect(function: (String) -> String) {
    try {
        val result = function("")
        // Fallback takes effect
        throw AssertionError("expect fallback does not take effect, but got \"$result\"")
    } catch (e: Throwable) {
        // Fallback does not take effect, but we have to check whether aspect takes effect.
        if (e.stackTrace.any { it.className.startsWith("io.github.resilience4j.spring") }) {
            throw AssertionError("expect aspect not take effect", e)
        }
        e.message?.let {
            if ("name is null or empty" == it && e is IllegalArgumentException) return
        }
        throw e
    }
}
