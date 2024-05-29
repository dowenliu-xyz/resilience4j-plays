package org.example.demo.demos.basic;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static org.example.demo.biz.Greeting.doGreeting;

@Component
@SuppressWarnings("unused")
@Slf4j
public class BasicJavaDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback2")
    public String greeting(String name) {
        return doGreeting(name);
    }

    private String fallback2(String name, Throwable thr) {
        log.error("Something wrong", thr);
        return "Hello there";
    }

    private String fallback(Throwable thr) {
        log.error("Something wrong", thr);
        return "Hello there";
    }
}
