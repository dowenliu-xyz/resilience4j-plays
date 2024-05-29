package org.example.demo.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestParent1Service extends TestParent1 {
    @Override
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
