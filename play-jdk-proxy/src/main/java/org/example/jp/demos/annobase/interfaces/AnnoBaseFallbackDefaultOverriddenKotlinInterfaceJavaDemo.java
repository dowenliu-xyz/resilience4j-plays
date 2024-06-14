package org.example.jp.demos.annobase.interfaces;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.jp.biz.Biz.doFallback;
import static org.example.jp.biz.Biz.doGreeting;

@Component
public class AnnoBaseFallbackDefaultOverriddenKotlinInterfaceJavaDemo implements AnnoBaseFallbackDefaultOverriddenKotlinInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback") // TODO 接口上定义的 fallback 是 default 方法时，这里重写的 fallback 是生效的。
    @NotNull
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    @NotNull
    @Override
    public String fallback(@Nullable String name, @Nullable Throwable thr) {
        return doFallback(name, thr);
    }
}
