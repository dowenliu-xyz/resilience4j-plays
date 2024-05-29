package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;

/**
 * case: not bean; interface; annotation on interface class
 */
@CircuitBreaker(name = "ti6", fallbackMethod = "fallback")
public interface TestInterface6 {
    String hello(String name);

    Logger getLogger();

    default String fallback(String name, Throwable throwable) {
        getLogger().debug("Throwable type: {}", throwable.getClass().getName());
        return "itf fallback, " + name;
    }
}
