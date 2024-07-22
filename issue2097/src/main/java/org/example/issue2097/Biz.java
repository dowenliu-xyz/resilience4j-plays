package org.example.issue2097;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Biz {
    @Retry(name = "foo", fallbackMethod = "fallback")
    public void foo(@Nullable String input) {
        if (input == null || input.isBlank()) throw new IllegalArgumentException("input is blank");
        log.info("input is {}", input);
    }

    private void fallback(String input, Throwable ignoredThrowable) {
        log.error("fallback for input {}", input);
    }
}
