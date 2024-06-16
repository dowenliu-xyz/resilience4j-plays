// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.interfaces.jdk.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.example.ae.interfaces.jdk.biz.Greeting.doGreeting;

@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
public interface Case043AnnotationBaseJavaInterfaceForKotlin extends DemoCase {

    @NotNull
    @Override
    default String greeting(@Nullable String name) {
        return "super:" + doGreeting(name);
    }

    @SuppressWarnings("unused")
    @NotNull
    String interfaceClassFallback(@Nullable String name, @Nullable Throwable thr);

    @SuppressWarnings("unused")
    @NotNull
    String interfaceMethodFallback(@Nullable String name, @Nullable Throwable thr);

    @SuppressWarnings("unused")
    @NotNull
    String classFallback(@Nullable String name, @Nullable Throwable thr);

    @SuppressWarnings("unused")
    @NotNull
    String methodFallback(@Nullable String name, @Nullable Throwable thr);

}