package org.example.ae.sic.demos.case02;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SuppressWarnings("GrazieInspection")
@ConditionalOnProperty(name = "run.only", havingValue = "case02", matchIfMissing = true)
@Component
@Order(2)
@RequiredArgsConstructor
@Slf4j
public class Case02Runner implements CommandLineRunner {
    private final Case02JavaParentJavaInterfaceJavaDemo case02JavaParentJavaInterfaceJavaDemo;
    // private final Case02JavaParentJavaInterfaceKotlinDemo case02JavaParentJavaInterfaceKotlinDemo;
    private final Case02JavaParentKotlinInterfaceJavaDemo case02JavaParentKotlinInterfaceJavaDemo;
    private final Case02KotlinParentJavaInterfaceJavaDemo case02KotlinParentJavaInterfaceJavaDemo;
    private final Case02KotlinParentKotlinInterfaceJavaDemo case02KotlinParentKotlinInterfaceJavaDemo;

    @Override
    public void run(String... args) {
        log.info("javaParentJavaInterfaceJavaDemo.greeting('') = {}", case02JavaParentJavaInterfaceJavaDemo.greeting(""));
        // 测试 kotlin demo 没有意义，其语法要求必须在 class 中重写 greeting 方法
        // log.info("javaParentJavaInterfaceKotlinDemo.greeting('') = {}", case02JavaParentJavaInterfaceKotlinDemo.greeting(""));
        log.info("javaParentKotlinInterfaceJavaDemo.greeting('') = {}", case02JavaParentKotlinInterfaceJavaDemo.greeting(""));
        log.info("kotlinParentJavaInterfaceJavaDemo.greeting('') = {}", case02KotlinParentJavaInterfaceJavaDemo.greeting(""));
        log.info("kotlinParentKotlinInterfaceJavaDemo.greeting('') = {}", case02KotlinParentKotlinInterfaceJavaDemo.greeting(""));
    }
}
