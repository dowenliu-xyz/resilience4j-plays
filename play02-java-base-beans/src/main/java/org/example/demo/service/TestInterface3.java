package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;

/**
 * case: java-base bean (maybe jdk-proxied) interface; annotation on interface class
 */
@CircuitBreaker(name = "ti3", fallbackMethod = "fallback")
public interface TestInterface3 {
    String hello(String name);

    Logger getLogger();

    default String fallback(String name, Throwable throwable) {
        getLogger().debug("Throwable type: {}", throwable.getClass().getName());
        return "itf fallback, " + name;
    }
}
