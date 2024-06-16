package org.example.ae.sic.demos.case01;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "run.only", havingValue = "case01", matchIfMissing = true)
@Component
@Order(1)
@RequiredArgsConstructor
@Slf4j
public class Case01Runner implements CommandLineRunner {
    private final JavaParentJavaInterfaceJavaDemo javaParentJavaInterfaceJavaDemo;
    private final JavaParentJavaInterfaceKotlinDemo javaParentJavaInterfaceKotlinDemo;
    private final JavaParentKotlinInterfaceJavaDemo javaParentKotlinInterfaceJavaDemo;
    private final JavaParentKotlinInterfaceKotlinDemo JavaParentKotlinInterfaceKotlinDemo;
    private final KotlinParentJavaInterfaceJavaDemo kotlinParentJavaInterfaceJavaDemo;
    private final KotlinParentJavaInterfaceKotlinDemo kotlinParentJavaInterfaceKotlinDemo;
    private final KotlinParentKotlinInterfaceJavaDemo kotlinParentKotlinInterfaceJavaDemo;
    private final KotlinParentKotlinInterfaceKotlinDemo kotlinParentKotlinInterfaceKotlinDemo;

    @Override
    public void run(String... args) {
        log.info("JavaParentJavaInterfaceJavaDemo.greeting('') = {}", javaParentJavaInterfaceJavaDemo.greeting(""));
        log.info("JavaParentJavaInterfaceKotlinDemo.greeting('') = {}", javaParentJavaInterfaceKotlinDemo.greeting(""));
        log.info("JavaParentKotlinInterfaceJavaDemo.greeting('') = {}", javaParentKotlinInterfaceJavaDemo.greeting(""));
        log.info("JavaParentKotlinInterfaceKotlinDemo.greeting('') = {}", JavaParentKotlinInterfaceKotlinDemo.greeting(""));
        log.info("KotlinParentJavaInterfaceJavaDemo.greeting('') = {}", kotlinParentJavaInterfaceJavaDemo.greeting(""));
        log.info("KotlinParentJavaInterfaceKotlinDemo.greeting('') = {}", kotlinParentJavaInterfaceKotlinDemo.greeting(""));
        log.info("KotlinParentKotlinInterfaceJavaDemo.greeting('') = {}", kotlinParentKotlinInterfaceJavaDemo.greeting(""));
        log.info("KotlinParentKotlinInterfaceKotlinDemo.greeting('') = {}", kotlinParentKotlinInterfaceKotlinDemo.greeting(""));
    }
}
