package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;

/**
 * case: annotation-base bean (never be jdk-proxied) interface; annotation on interface method
 */
public interface TestInterface7 {
    @CircuitBreaker(name = "ti7", fallbackMethod = "fallback")
    String hello(String name);

    Logger getLogger();

    default String fallback(String name, Throwable throwable) {
        getLogger().debug("Throwable type: {}", throwable.getClass().getName());
        return "itf fallback, " + name;
    }
}
