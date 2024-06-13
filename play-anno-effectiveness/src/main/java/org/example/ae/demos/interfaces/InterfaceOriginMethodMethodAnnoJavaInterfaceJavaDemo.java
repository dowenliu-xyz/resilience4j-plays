package org.example.ae.demos.interfaces;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import static org.example.ae.biz.Greeting.doFallback;
import static org.example.ae.biz.Greeting.doGreeting;

@SuppressWarnings("unused")
@Component
public class InterfaceOriginMethodMethodAnnoJavaInterfaceJavaDemo implements InterfaceOriginMethodMethodAnnoJavaInterfaceForJava {
    @Override
    public String greeting(@Nullable String name) {
        return doGreeting(name);
    }

    private String fallback(String name, Throwable e) {
        return doFallback(name, e);
    }
}
