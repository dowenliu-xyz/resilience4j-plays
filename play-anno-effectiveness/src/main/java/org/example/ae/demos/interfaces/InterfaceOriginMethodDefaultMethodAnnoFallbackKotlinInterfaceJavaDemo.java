package org.example.ae.demos.interfaces;

import org.springframework.stereotype.Component;

import static org.example.ae.biz.Greeting.doFallback;

@Component
public class InterfaceOriginMethodDefaultMethodAnnoFallbackKotlinInterfaceJavaDemo implements InterfaceOriginMethodDefaultMethodAnnoFallbackKotlinInterfaceForJava {
    @Override
    public String fallback(String name, Throwable e) {
        return doFallback(name, e);
    }
}
