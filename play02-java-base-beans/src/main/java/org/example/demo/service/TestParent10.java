package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

/**
 * case: not bean; abstract class; annotation on abstract method
 */
@SuppressWarnings("unused")
@Slf4j
public abstract class TestParent10 {
    @CircuitBreaker(name = "tp10", fallbackMethod = "fallback")
    public abstract String hello(String name);

    public String fallback(String name, Throwable e) {
        log.debug("Throwable type: {}", e.getClass().getName());
        return "parent fallback, " + name;
    }
}
