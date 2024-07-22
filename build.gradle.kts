allprojects {
    group = "org.example"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    extra["springCloudVersion"] = "2023.0.1"
    extra["resilience4j.version"] = "2.2.0"

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
