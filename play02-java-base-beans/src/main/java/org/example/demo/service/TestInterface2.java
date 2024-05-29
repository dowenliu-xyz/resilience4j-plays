package org.example.demo.service;

import org.slf4j.Logger;

/**
 * case: java-base bean (maybe jdk-proxied) interface; annotation on override method
 */
public interface TestInterface2 {
    String hello(String name);

    Logger getLogger();

    default String fallback(String name, Throwable throwable) {
        getLogger().debug("Throwable type: {}", throwable.getClass().getName());
        return "itf fallback, " + name;
    }
}
