package org.example.ae.demos.basic;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.example.ae.biz.Greeting.doFallback;
import static org.example.ae.biz.Greeting.doGreeting;

@SuppressWarnings("unused")
@Component
public class ProtectedMethodMethodAnnoJavaDemo {
    private ProtectedMethodMethodAnnoJavaDemo self;

    @Autowired
    public void setSelf(ProtectedMethodMethodAnnoJavaDemo self) {
        this.self = self;
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    protected String greeting(String name) {
        return doGreeting(name);
    }

    public String exportGreeting(String name) {
        return self.greeting(name);
    }

    private String fallback(String name, Throwable thr) {
        return doFallback(name, thr);
    }
}
