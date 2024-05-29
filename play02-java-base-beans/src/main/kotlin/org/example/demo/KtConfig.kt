package org.example.demo

import org.example.demo.service.TestInterfaceKt1
import org.example.demo.service.TestInterfaceKt1Service
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KtConfig {
    @Bean
    fun tik1(): TestInterfaceKt1 {
        return TestInterfaceKt1Service()
    }
}