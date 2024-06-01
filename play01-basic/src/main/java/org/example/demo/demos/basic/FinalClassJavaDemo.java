package org.example.demo.demos.basic;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

import static org.example.demo.biz.Greeting.doFallback;
import static org.example.demo.biz.Greeting.doGreeting;

// TODO 提示 final 类不能作为 Bean? 这似乎是 Spring 插件应该提供的功能，而不是 r4j 插件应该做的事。
//      至少提示注解不生效。
//@Component // Enable this will cause bootstrap failure.
public final class FinalClassJavaDemo {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    public String greeting(String name) {
        return doGreeting(name);
    }

    private String fallback(String name, Throwable thr) {
        return doFallback(name, thr);
    }

    private String fallback(Throwable thr) {
        return doFallback(thr);
    }
}
