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
public class KotlinInterfaceJavaDemo implements KotlinInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public String greeting(String name) {
        return doGreeting(name);
    }

    private String fallback2(String name, Throwable thr) {
        log.error("Something wrong", thr);
        return "Hello there";
    }
}
