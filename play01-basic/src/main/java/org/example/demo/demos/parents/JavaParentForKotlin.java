package org.example.demo.demos.parents;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class JavaParentForKotlin {
    protected String fallback(@SuppressWarnings("unused") String name, Throwable thr) {
        log.error("Something wrong", thr);
        return "Hello there";
    }
}
