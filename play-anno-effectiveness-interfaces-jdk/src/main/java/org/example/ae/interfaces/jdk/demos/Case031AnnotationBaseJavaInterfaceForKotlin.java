// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.interfaces.jdk.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.ae.interfaces.jdk.biz.DemoCase.EffectiveAnnotation.*;
import static org.example.ae.interfaces.jdk.biz.DemoCase.EffectiveFallback.FallbackInInterface;
import static org.example.ae.interfaces.jdk.biz.Greeting.doFallback;
import static org.example.ae.interfaces.jdk.biz.Greeting.doGreeting;

@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
public interface Case031AnnotationBaseJavaInterfaceForKotlin extends DemoCase {

    @NotNull
    @Override
    default String greeting(@Nullable String name) {
        return "super:" + doGreeting(name);
    }

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
