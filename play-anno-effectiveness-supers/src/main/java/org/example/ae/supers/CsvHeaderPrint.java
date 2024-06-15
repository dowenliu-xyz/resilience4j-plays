package org.example.ae.supers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class CsvHeaderPrint implements CommandLineRunner {
    @Override
    public void run(String... args) {
        log.info("case result: {}", String.join(",",
                "sn",
                "ClassAnnotationOnSuper",
                "OriginMethodInSuper",
                "FallbackInSuper",
                "ClassAnnotationOnSub",
                "OriginMethodInSub",
                "FallbackInSub",
                "EffectiveAnnotation",
                "EffectiveFallback"));
    }
}
