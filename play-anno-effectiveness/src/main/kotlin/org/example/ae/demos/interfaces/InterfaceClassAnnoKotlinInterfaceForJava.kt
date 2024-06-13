package org.example.ae.demos.interfaces

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker

@CircuitBreaker(name = "demo", fallbackMethod = "fallback")
interface InterfaceClassAnnoKotlinInterfaceForJava 
