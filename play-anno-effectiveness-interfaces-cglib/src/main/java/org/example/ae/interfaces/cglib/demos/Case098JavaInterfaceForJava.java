// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.interfaces.cglib.demos;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.ae.interfaces.cglib.biz.DemoCase;

@CircuitBreaker(name = "demo", fallbackMethod = "interfaceClassFallback")
public interface Case098JavaInterfaceForJava extends DemoCase {

}
