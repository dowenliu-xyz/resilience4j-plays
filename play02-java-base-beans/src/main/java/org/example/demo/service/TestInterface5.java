package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;

/**
 * case: not bean; interface; annotation on interface method
 */
@SuppressWarnings("unused")
public interface TestInterface5 {
    @CircuitBreaker(name = "ti5", fallbackMethod = "fallback")
    String hello(String name);

    Logger getLogger();

    default String fallback(String name, Throwable throwable) {
        getLogger().debug("Throwable type: {}", throwable.getClass().getName());
        return "itf fallback, " + name;
    }
}
