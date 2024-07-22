import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.6"
//    id("org.springframework.boot") version "2.7.18"
//    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
}

extra["resilience4j.version"] = "2.2.0" // produce the issue; java 17, spring 3.3.2, resilience4j-spring-boot3
//extra["resilience4j.version"] = "2.1.0" // produce the issue; java 17, spring 3.3.2, resilience4j-spring-boot3
//extra["resilience4j.version"] = "2.0.2" // produce the issue; java 17, spring 3.3.2, resilience4j-spring-boot3
//extra["resilience4j.version"] = "2.0.1" // produce the issue; java 17, spring 3.3.2, resilience4j-spring-boot3
//extra["resilience4j.version"] = "2.0.0" // produce the issue; java 17, spring 2.7.18, resilience4j-spring-boot2
//extra["resilience4j.version"] = "1.7.1" // no issue; java 17, spring 2.7.18, resilience4j-spring-boot2

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("io.github.resilience4j:resilience4j-spring-boot3:${property("resilience4j.version")}")
//    implementation("io.github.resilience4j:resilience4j-spring-boot2:${property("resilience4j.version")}")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xjvm-default=all")
        jvmTarget.set(JvmTarget.JVM_17)
    }
}
