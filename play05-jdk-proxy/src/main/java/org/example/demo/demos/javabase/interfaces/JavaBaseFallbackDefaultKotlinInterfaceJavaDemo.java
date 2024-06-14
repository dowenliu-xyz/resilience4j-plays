package org.example.demo.demos.javabase.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.demo.biz.Biz.doGreeting;

public class JavaBaseFallbackDefaultKotlinInterfaceJavaDemo implements JavaBaseFallbackDefaultKotlinInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO 接口上定义的 fallback 是 default 方法是生效的。
    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }
}
