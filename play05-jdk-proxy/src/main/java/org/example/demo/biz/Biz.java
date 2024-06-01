package org.example.demo.biz;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public abstract class Biz {
    public static @NotNull String doGreeting(@Nullable String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is null or empty");
        }
        return "Hello " + name + "!";
    }

    public static @NotNull String doFallback(@Nullable String name, @Nullable Throwable e) {
        return "fallback";
    }
}
