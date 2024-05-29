package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

/**
 * case: java-base bean (maybe jdk-proxied) interface impl; annotation on override method
 */
@Slf4j
public class TestInterface2Service implements TestInterface2 {
    @CircuitBreaker(name = "ti2", fallbackMethod = "fallback")
    @Override
    public String hello(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is blank");
        }
        return "hello, " + name;
    }

    @Override
    public Logger getLogger() {
        return log;
    }

    @Override
    public String fallback(String name, Throwable throwable) {
        log.debug("Throwable type: {}", throwable.getClass().getName());
        return "fallback, " + name;
    }
}
