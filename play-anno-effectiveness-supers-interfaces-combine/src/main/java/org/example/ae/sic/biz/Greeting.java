package org.example.ae.sic.biz;

import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

@Slf4j
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
        log.info("caught", ignored);
        return FALLBACK_RESULT;
    }
}
