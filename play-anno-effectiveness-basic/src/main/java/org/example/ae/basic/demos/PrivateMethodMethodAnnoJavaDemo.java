package org.example.ae.basic.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.example.ae.basic.biz.Greeting.doFallback;
import static org.example.ae.basic.biz.Greeting.doGreeting;

@SuppressWarnings("unused")
@Component
public class PrivateMethodMethodAnnoJavaDemo {
    private PrivateMethodMethodAnnoJavaDemo self;

    @Autowired
    public void setSelf(PrivateMethodMethodAnnoJavaDemo self) {
        this.self = self;
    }

    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    private String greeting(String name) {
        return doGreeting(name);
    }

    public String exportGreeting(String name) {
        return self.greeting(name);
    }

    private String fallback(String name, Throwable thr) {
        return doFallback(name, thr);
    }
}
