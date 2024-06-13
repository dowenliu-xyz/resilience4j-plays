package org.example.ae.demos.interfaces;

import org.springframework.stereotype.Component;

import static org.example.ae.biz.Greeting.doFallback;

@SuppressWarnings("unused")
@Component
public class InterfaceOriginMethodDefaultMethodAnnoJavaInterfaceJavaDemo implements InterfaceOriginMethodDefaultMethodAnnoJavaInterfaceForJava {
    private String fallback(String name, Throwable e) {
        return doFallback(name, e);
    }
}
