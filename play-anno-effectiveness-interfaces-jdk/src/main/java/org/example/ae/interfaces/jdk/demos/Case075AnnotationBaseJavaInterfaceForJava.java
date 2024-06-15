// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.interfaces.jdk.biz.DemoCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
public interface Case075AnnotationBaseJavaInterfaceForJava extends DemoCase {

    @CircuitBreaker(name = "demo", fallbackMethod = "interfaceMethodFallback")
    @NotNull
    String greeting(@Nullable String name);

}
