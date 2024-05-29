package org.example.demo.demos.interfaces;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public interface JavaInterfaceForJava {
    @NotNull
    Logger getLogger();

    default String fallback(String name, Throwable thr) {
        getLogger().error("Something wrong", thr);
        return "Hello there";
    }

    default String fallback(Throwable thr) {
        getLogger().error("Something wrong", thr);
        return "Hello there";
    }
}
