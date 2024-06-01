package org.example.demo.demos.basic

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FinalConfig {
    // Enable this will cause bootstrap failure.
//    @Bean
//    fun finalClassKotlinDemo(): FinalClassKotlinDemo {
//        return FinalClassKotlinDemo()
//    }

    @Bean
    fun finalMethodKotlinDemo(): FinalMethodKotlinDemo {
        return FinalMethodKotlinDemo()
    }
}