package org.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
@Slf4j
public class Runner implements CommandLineRunner {
    private final TestInterface1 ti1;
    private final TestParent1 tp1;
    private final TestParent2 tp2;
    private final TestParent3 tp3;
    private final TestParent4 tp4;
    private final TestParent5 tp5;
    private final TestParent6 tp6;
    private final TestParent7 tp7;

    @Override
    public void run(String... args) {
        // run("接口方法注解", () -> ti1.hello(null)); // 接口上注解**不**生效
        // run("父类抽象方法注解", () -> tp1.hello(null)); // 父类抽象方法注解**不**生效
        // run("当前类方法注解", () -> tp2.hello(null)); // 当前类方法注解生效
//         run("父类被重写方法注解", () -> tp3.hello(null)); // 父类被重写方法注解**不**生效
        // run("父类未被重写方法注解", () -> tp4.hello(null)); // 父类未被重写方法注解生效
        // run("父类类注解（抽象方法）", () -> tp5.hello(null)); // 父类类注解（抽象方法）**不**生效
        // run("父类类注解（重写方法）", () -> tp6.hello(null)); // 父类类注解(重写方法）**不**生效
//        run("父类类注解（无重写）", () -> tp7.hello(null)); // 父类类注解（无重写）**不**生效 // 被 AOP 切到，但查找注解以创建 FallbackMethod 时只检查方法注解和当前类注解，不检查父类的注解
    }

    private void run(String name, Supplier<Object> s) {
       run(name, s, 1);
    }

    private void run(String name, Supplier<Object> s, @SuppressWarnings("SameParameterValue") int times) {
        log.debug("start run {}", name);
        boolean fallbackWorked = false;
        for (int i = 0; i < times; i++) {
            try {
                log.debug("{}, result: {}", i, s.get());
                fallbackWorked = true;
            } catch (Throwable e) {
                log.debug("{}, caught {}", i, e.getClass().getName(), e);
            }
        }
        log.debug("finish run {}", name);
        log.info("{}{}生效", name, fallbackWorked ? "" : "**不**");
    }
}
