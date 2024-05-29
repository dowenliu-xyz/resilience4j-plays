package org.example.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestInterface8Service implements TestInterface8 {
    @CircuitBreaker(name = "ti8", fallbackMethod = "fallback")
    @Override
    public String hello(String name) {
        return null;
    }

    @Override
    public Logger getLogger() {
        return log;
    }
}
