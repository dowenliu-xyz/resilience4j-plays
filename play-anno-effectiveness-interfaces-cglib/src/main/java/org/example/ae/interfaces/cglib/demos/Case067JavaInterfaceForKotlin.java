// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.interfaces.cglib.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.ae.interfaces.cglib.biz.DemoCase.EffectiveAnnotation.*;
import static org.example.ae.interfaces.cglib.biz.DemoCase.EffectiveFallback.FallbackInInterface;
import static org.example.ae.interfaces.cglib.biz.Greeting.doFallback;

@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
public interface Case067JavaInterfaceForKotlin extends DemoCase {

    @CircuitBreaker(name = "demo", fallbackMethod = "interfaceMethodFallback")
    @NotNull
    String greeting(@Nullable String name);

    @SuppressWarnings("unused")
    @NotNull
    default String interfaceClassFallback(@Nullable String name, @Nullable Throwable thr) {
        return ClassAnnotationOnInterface + ":" + FallbackInInterface + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    default String interfaceMethodFallback(@Nullable String name, @Nullable Throwable thr) {
        return MethodAnnotationInInterface + ":" + FallbackInInterface + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    default String classFallback(@Nullable String name, @Nullable Throwable thr) {
        return ClassAnnotationOnClass + ":" + FallbackInInterface + ":" + doFallback(name, thr);
    }

    @SuppressWarnings("unused")
    @NotNull
    default String methodFallback(@Nullable String name, @Nullable Throwable thr) {
        return MethodAnnotationInClass + ":" + FallbackInInterface + ":" + doFallback(name, thr);
    }

}
