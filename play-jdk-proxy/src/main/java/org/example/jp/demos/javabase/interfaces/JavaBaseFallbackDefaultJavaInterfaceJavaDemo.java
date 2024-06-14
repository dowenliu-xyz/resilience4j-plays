package org.example.jp.demos.javabase.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.jp.biz.Biz.doGreeting;

public class JavaBaseFallbackDefaultJavaInterfaceJavaDemo implements JavaBaseFallbackDefaultJavaInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO 接口上定义的 fallback 是 default 方法是生效的。
    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }
}
