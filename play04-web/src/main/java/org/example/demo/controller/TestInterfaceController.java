package org.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestInterfaceController implements TestInterface {
    @GetMapping("ti")
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
