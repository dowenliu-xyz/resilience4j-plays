package org.example.ae.sic.biz;

import jakarta.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

public abstract class Greeting {

    public static final String FALLBACK_RESULT = "Hello, there";

    @NotNull
    public static String doGreeting(@Nullable String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name should not be null or blank");
        }
        return "Hello, " + name + "!";
    }

    @SuppressWarnings("SameReturnValue")
    public static @NotNull String doFallback(@Nullable String ignoredName, @Nullable Throwable ignored) {
        return FALLBACK_RESULT;
    }
}
