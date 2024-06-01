package org.example.demo.demos.basic;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

import static org.example.demo.biz.Greeting.doFallback;
import static org.example.demo.biz.Greeting.doGreeting;

@Component
public class FinalMethodJavaDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO 没有提示 final 方法 aspect 不生效
    public final String greeting(String name) {
        return doGreeting(name);
    }

    private String fallback(String name, Throwable thr) {
        return doFallback(name, thr);
    }

    private String fallback(Throwable thr) {
        return doFallback(thr);
    }
}
