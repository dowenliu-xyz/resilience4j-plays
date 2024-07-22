package org.example.issue2097;

import io.github.resilience4j.retry.RetryRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Runner implements CommandLineRunner {
    private final Biz biz;
    private final RetryRegistry retryRegistry;

    @Override
    public void run(String... args) {
        retryRegistry.retry("foo").getEventPublisher()
                .onRetry(event -> log.info("foo: retry: {}", event))
                .onError(event -> log.error("foo: error: {}", event))
                .onSuccess(event -> log.info("foo: success: {}", event));

        biz.foo(null);
    }
}
