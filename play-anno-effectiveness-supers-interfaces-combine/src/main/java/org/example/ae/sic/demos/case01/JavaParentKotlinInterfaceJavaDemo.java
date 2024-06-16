package org.example.ae.sic.demos.case01;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.sic.biz.Greeting.doGreeting;

@Component
public class JavaParentKotlinInterfaceJavaDemo extends JavaParentForJava implements KotlinInterfaceForJava {
    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
    @NotNull
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }
}
