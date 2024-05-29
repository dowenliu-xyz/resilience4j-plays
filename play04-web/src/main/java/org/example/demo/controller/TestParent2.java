package org.example.demo.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract public class TestParent2 {
    public abstract String hello(String name);

    public String fallback(String name, Throwable e) {
        log.debug("Throwable type: {}", e.getClass().getName());
        return "parent fallback, " + name;
    }
}
