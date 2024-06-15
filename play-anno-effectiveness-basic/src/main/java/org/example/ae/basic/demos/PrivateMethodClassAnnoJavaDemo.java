package org.example.ae.basic.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.example.ae.basic.biz.Greeting.doFallback;
import static org.example.ae.basic.biz.Greeting.doGreeting;

@SuppressWarnings("unused")
@Component
@CircuitBreaker(name = "demo", fallbackMethod = "fallback")
public class PrivateMethodClassAnnoJavaDemo {
    private PrivateMethodClassAnnoJavaDemo self;

    @Autowired
    public void setSelf(PrivateMethodClassAnnoJavaDemo self) {
        this.self = self;
    }

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
