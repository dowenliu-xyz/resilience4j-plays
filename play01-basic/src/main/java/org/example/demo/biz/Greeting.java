package org.example.demo.biz;

import org.jetbrains.annotations.NotNull;

public class Greeting {
    public static @NotNull String doGreeting(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is null or empty");
        return "Hello " + name + "!";
    }
}
