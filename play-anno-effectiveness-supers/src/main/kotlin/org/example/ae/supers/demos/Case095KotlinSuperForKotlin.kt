// Generated by generateDemo task, DO NOT MODIFY
package org.example.ae.supers.demos

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.example.ae.supers.biz.DemoCase

@CircuitBreaker(name = "demo", fallbackMethod = "superClassFallback")
abstract class Case095KotlinSuperForKotlin : DemoCase
