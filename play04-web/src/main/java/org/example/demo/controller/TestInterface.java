package org.example.demo.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;

public interface TestInterface {
    @CircuitBreaker(name = "ti", fallbackMethod = "fallback")
    String hello(String name);

    Logger getLogger();

    default String fallback(String name, Throwable throwable) {
        getLogger().debug("Throwable type: {}", throwable.getClass().getName());
        return "itf fallback, " + name;
    }
}
