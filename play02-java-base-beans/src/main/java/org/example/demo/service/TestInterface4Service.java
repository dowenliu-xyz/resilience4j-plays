package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

/**
 * case: java-base bean (maybe jdk-proxied) interface impl; annotation on impl class
 */
@Slf4j
@CircuitBreaker(name = "ti4", fallbackMethod = "fallback")
public class TestInterface4Service implements TestInterface4 {
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
