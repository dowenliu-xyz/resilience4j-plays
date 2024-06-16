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
    private final Case01JavaParentJavaInterfaceJavaDemo case01JavaParentJavaInterfaceJavaDemo;
    private final Case01JavaParentJavaInterfaceKotlinDemo case01JavaParentJavaInterfaceKotlinDemo;
    private final Case01JavaParentKotlinInterfaceJavaDemo case01JavaParentKotlinInterfaceJavaDemo;
    private final Case01JavaParentKotlinInterfaceKotlinDemo Case01JavaParentKotlinInterfaceKotlinDemo;
    private final Case01KotlinParentJavaInterfaceJavaDemo case01KotlinParentJavaInterfaceJavaDemo;
    private final Case01KotlinParentJavaInterfaceKotlinDemo case01KotlinParentJavaInterfaceKotlinDemo;
    private final Case01KotlinParentKotlinInterfaceJavaDemo case01KotlinParentKotlinInterfaceJavaDemo;
    private final Case01KotlinParentKotlinInterfaceKotlinDemo case01KotlinParentKotlinInterfaceKotlinDemo;

    @Override
    public void run(String... args) {
        log.info("JavaParentJavaInterfaceJavaDemo.greeting('') = {}", case01JavaParentJavaInterfaceJavaDemo.greeting(""));
        log.info("JavaParentJavaInterfaceKotlinDemo.greeting('') = {}", case01JavaParentJavaInterfaceKotlinDemo.greeting(""));
        log.info("JavaParentKotlinInterfaceJavaDemo.greeting('') = {}", case01JavaParentKotlinInterfaceJavaDemo.greeting(""));
        log.info("JavaParentKotlinInterfaceKotlinDemo.greeting('') = {}", Case01JavaParentKotlinInterfaceKotlinDemo.greeting(""));
        log.info("KotlinParentJavaInterfaceJavaDemo.greeting('') = {}", case01KotlinParentJavaInterfaceJavaDemo.greeting(""));
        log.info("KotlinParentJavaInterfaceKotlinDemo.greeting('') = {}", case01KotlinParentJavaInterfaceKotlinDemo.greeting(""));
        log.info("KotlinParentKotlinInterfaceJavaDemo.greeting('') = {}", case01KotlinParentKotlinInterfaceJavaDemo.greeting(""));
        log.info("KotlinParentKotlinInterfaceKotlinDemo.greeting('') = {}", case01KotlinParentKotlinInterfaceKotlinDemo.greeting(""));
    }
}
