package org.example.ae.demos.interfaces;

import static org.example.ae.biz.Greeting.doFallback;

public interface InterfaceNoOriginFallbackMethodAnnoJavaInterfaceForJava {
    default String fallback(String name, Throwable e) {
        return doFallback(name, e);
    }
}
