package org.example.demo.demos.timelimiter.returntype;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static org.example.demo.biz.Greeting.doGreeting;

@SuppressWarnings("unused")
@Component
@RequiredArgsConstructor
public class TimeLimiterReturnTypeDemo {
    private final ExecutorService timeLimiterExecutor;

    @TimeLimiter(name = "demo")
    public CompletionStage<String> slowGreeting(String name) {
        return CompletableFuture.runAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException ignored) {
                    }
                }, timeLimiterExecutor)
                .thenApply((v) -> doGreeting(name));
    }
}
