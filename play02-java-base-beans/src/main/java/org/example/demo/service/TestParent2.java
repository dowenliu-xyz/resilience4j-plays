package org.example.demo.service;

import lombok.extern.slf4j.Slf4j;

/**
 * case: bean (never be jdk-proxied) abstract parent; annotation on override method.
 */
@Slf4j
public abstract class TestParent2 {
    public abstract String hello(String name);

    public String fallback(String name, Throwable e) {
        log.debug("Throwable type: {}", e.getClass().getName());
        return "parent fallback, " + name;
    }
}
