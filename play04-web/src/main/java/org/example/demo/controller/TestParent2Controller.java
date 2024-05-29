package org.example.demo.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestParent2Controller extends TestParent2 {
    @Override
    @CircuitBreaker(name = "tp2", fallbackMethod = "fallback")
    @GetMapping("tp2")
    public String hello(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is blank");
        }
        return "hello, " + name;
    }

    public String fallback(String name, Throwable e) {
        log.debug("Throwable type: {}", e.getClass().getName());
        return "fallback, " + name;
    }
}
