package org.example.ae.demos.interfaces;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static org.example.ae.biz.Greeting.doFallback;

@Component
public class InterfaceOriginMethodDefaultMethodAnnoFallbackOverriddenKotlinInterfaceJavaDemo implements InterfaceOriginMethodDefaultMethodAnnoFallbackOverriddenKotlinInterfaceForJava {
    @NotNull
    @Override
    public String fallback(String name, Throwable e) {
        return doFallback(name, e);
    }
}
