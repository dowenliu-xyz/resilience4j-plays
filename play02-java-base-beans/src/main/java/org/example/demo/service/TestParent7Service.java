package org.example.demo.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestParent7Service extends TestParent7 {
    public String fallback(String name, Throwable e) {
        log.debug("Throwable type: {}", e.getClass().getName());
        return "fallback, " + name;
    }
}
