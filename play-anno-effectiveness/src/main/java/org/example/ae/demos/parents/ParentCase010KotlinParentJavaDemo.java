// Generated by genParentsMatrix task, DO NOT MODIFY
package org.example.ae.demos.parents;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
@CircuitBreaker(name = "demo", fallbackMethod = "classFallback")
public class ParentCase010KotlinParentJavaDemo extends ParentCase010KotlinParentForJava {
}
