package org.example.ae.demos.interfaces;

import org.jetbrains.annotations.Nullable;

import static org.example.ae.biz.Greeting.doFallback;

public interface InterfaceNoOriginFallbackMethodAnnoJavaInterfaceForKotlin {
    default String fallback(@Nullable String name, @Nullable Throwable e) {
        return doFallback(name, e);
    }
}
