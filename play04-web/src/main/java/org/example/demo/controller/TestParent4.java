package org.example.demo.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TestParent4 {
    @CircuitBreaker(name = "tp4", fallbackMethod = "fallback")
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
