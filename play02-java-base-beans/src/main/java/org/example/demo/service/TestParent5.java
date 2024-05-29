package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

/**
 * case: bean (never be jdk-proxied) abstract parent; annotation on parent class
 */
@Slf4j
@CircuitBreaker(name = "tp5", fallbackMethod = "fallback")
public abstract class TestParent5 {
    public abstract String hello(String name);

    public String fallback(String name, Throwable e) {
        log.debug("Throwable type: {}", e.getClass().getName());
        return "parent fallback, " + name;
    }
}
