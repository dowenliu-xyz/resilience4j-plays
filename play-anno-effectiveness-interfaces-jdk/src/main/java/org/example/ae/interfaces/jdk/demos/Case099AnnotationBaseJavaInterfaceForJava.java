// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.jdk.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.interfaces.jdk.biz.DemoCase;

@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
public interface Case099AnnotationBaseJavaInterfaceForJava extends DemoCase {

}
