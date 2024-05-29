package org.example.demo;

import org.example.demo.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public TestInterface1 ti1() {
        return new TestInterface1Service();
    }

    @Bean
    public TestInterface3 ti3() {
        return new TestInterface3Service();
    }

    @Bean
    public TestInterface4 ti4() {
        return new TestInterface4Service();
    }

    @Bean
    public TestInterface2 ti6() {
        return new TestInterface2Service();
    }

    @Bean
    public TestParent1 tp1() {
        return new TestParent1Service();
    }

    @Bean
    public TestParent2 tp2() {
        return new TestParent2Service();
    }

    @Bean
    public TestParent3 tp3() {
        return new TestParent3Service();
    }

    @Bean
    public TestParent4 tp4() {
        return new TestParent4Service();
    }

    @Bean
    public TestParent5 tp5() {
        return new TestParent5Service();
    }

    @Bean
    public TestParent6 tp6() {
        return new TestParent6Service();
    }

    @Bean
    public TestParent7 tp7() {
        return new TestParent7Service();
    }
}
