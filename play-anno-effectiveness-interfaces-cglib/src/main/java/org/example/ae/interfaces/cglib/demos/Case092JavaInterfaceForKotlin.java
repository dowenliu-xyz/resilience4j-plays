// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.interfaces.cglib.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
public interface Case092JavaInterfaceForKotlin extends DemoCase {

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
