package org.example.demo.demos.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import static org.example.demo.biz.Greeting.doGreeting;

@SuppressWarnings("unused")
@Component
@Slf4j
public class JavaInterfaceJavaDemo implements JavaInterfaceForJava {
    @Override
    public @NotNull Logger getLogger() {
        return log;
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public String greeting(String name) {
        return doGreeting(name);
    }
}
