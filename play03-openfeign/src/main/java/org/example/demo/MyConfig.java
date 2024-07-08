package org.example.demo;

import feign.Target;
import org.springframework.cloud.openfeign.CircuitBreakerNameResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class MyConfig {
//    @Bean
    public CircuitBreakerNameResolver circuitBreakerNameResolver() {
//        return (feignClientName, target, method) -> "just a demo";
        return new MyResolver();
    }

    private static class MyResolver implements CircuitBreakerNameResolver {
        @Override
        public String resolveCircuitBreakerName(String feignClientName, Target<?> target, Method method) {
            return "something";
        }
    }
}
