package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

/**
 * case: not bean; class; annotation on method
 */
@SuppressWarnings("unused")
@Slf4j
public class TestParent11 {
    @CircuitBreaker(name = "tp11", fallbackMethod = "fallback")
    public String hello(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is blank");
        }
        return "hello, " + name;
    }

    public String fallback(String name, Throwable e) {
        log.debug("Throwable type: {}", e.getClass().getName());
        return "parent fallback, " + name;
    }
}
