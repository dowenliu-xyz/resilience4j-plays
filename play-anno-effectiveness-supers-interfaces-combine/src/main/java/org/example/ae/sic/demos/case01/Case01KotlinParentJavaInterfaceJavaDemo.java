package org.example.ae.sic.demos.case01;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.sic.biz.Greeting.doGreeting;

@Component
public class Case01KotlinParentJavaInterfaceJavaDemo extends KotlinParentForJava implements JavaInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    @NotNull
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }
}
