package org.example.demo.demos.parents;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class JavaParentForJava {
    private String fallback(String name, Throwable thr) {
        log.error("Something wrong", thr);
        return "Hello there";
    }

    private String fallback(Throwable thr) {
        log.error("Something wrong", thr);
        return "Hello there";
    }
}
