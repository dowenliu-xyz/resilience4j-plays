package org.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public class TestInterface3Service implements TestInterface3 {
    @Override
    public String hello(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is blank");
        }
        return "hello, " + name;
    }

    @Override
    public Logger getLogger() {
        return log;
    }

    @Override
    public String fallback(String name, Throwable throwable) {
        log.debug("Throwable type: {}", throwable.getClass().getName());
        return "fallback, " + name;
    }
}
