package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

/**
 * case: bean (never be jdk-proxied) parent; annotation on parent class;
 *       origin method is NOT overridden.
 *       The aspect successfully CUT this call, but it can NOT find the annotation,
 *       since the real target it got is subclass rather than this parent class.
 */
@Slf4j
@CircuitBreaker(name = "tp7", fallbackMethod = "fallback")
public class TestParent7 {
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
