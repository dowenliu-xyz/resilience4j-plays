package org.example.ae.demos.interfaces;

import org.jetbrains.annotations.Nullable;

public interface InterfaceNoOriginFallbackOverriddenMethodAnnoJavaInterfaceForKotlin {
    default String fallback(@Nullable String name, @Nullable Throwable e) {
        return "";
    }
}
