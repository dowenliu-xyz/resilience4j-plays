package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

/**
 * case: bean (never be jdk-proxied) parent; annotation on parent class;
 *       origin method is overridden.
 *       The aspect never cut this call.
 */
@Slf4j
@CircuitBreaker(name = "tp6", fallbackMethod = "fallback")
public class TestParent6 {
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
