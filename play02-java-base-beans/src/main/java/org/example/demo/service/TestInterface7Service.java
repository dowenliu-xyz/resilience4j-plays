package org.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestInterface7Service implements TestInterface7 {
    @Override
    public String hello(String name) {
        return null;
    }

    @Override
    public Logger getLogger() {
        return log;
    }
}
