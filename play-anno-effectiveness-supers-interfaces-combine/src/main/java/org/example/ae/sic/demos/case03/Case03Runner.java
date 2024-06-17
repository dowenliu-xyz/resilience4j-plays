package org.example.ae.sic.demos.case03;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@ConditionalOnProperty(name = "run.only", havingValue = "case03", matchIfMissing = true)
@Component
@Order(3)
@RequiredArgsConstructor
@Slf4j
public class Case03Runner implements CommandLineRunner {
    private final Case03JavaParentJavaInterfaceJavaDemo case03JavaParentJavaInterfaceJavaDemo;
    private final Case03JavaParentKotlinInterfaceJavaDemo case03JavaParentKotlinInterfaceJavaDemo;
    private final Case03KotlinParentJavaInterfaceJavaDemo case03KotlinParentJavaInterfaceJavaDemo;
    private final Case03KotlinParentKotlinInterfaceJavaDemo case03KotlinParentKotlinInterfaceJavaDemo;

    @Override
    public void run(String... args) {
        expectNoAop("case03JavaParentJavaInterfaceJavaDemo", () -> case03JavaParentJavaInterfaceJavaDemo.greeting(""));
        expectNoAop("case03JavaParentKotlinInterfaceJavaDemo", () -> case03JavaParentKotlinInterfaceJavaDemo.greeting(""));
        expectNoAop("case03KotlinParentJavaInterfaceJavaDemo", () -> case03KotlinParentJavaInterfaceJavaDemo.greeting(""));
        expectNoAop("case03KotlinParentKotlinInterfaceJavaDemo", () -> case03KotlinParentKotlinInterfaceJavaDemo.greeting(""));
    }

    private static void expectNoAop(String name, Runnable r) {
        try {
            r.run();
        } catch (IllegalArgumentException e) {
            if (!"name should not be null or blank".equals(e.getMessage())) {
                throw e;
            }
            if (Arrays.stream(e.getStackTrace()).anyMatch(s -> s.getClassName().contains(".fallback.FallbackExecutor"))) {
                throw e;
            }
        }
        log.info("{}: no AOP take effect", name);
    }
}
