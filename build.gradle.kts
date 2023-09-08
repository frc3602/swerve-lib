plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.8.10"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()

    maven {
        url = uri("https://frcmaven.wpi.edu/artifactory/release/")
    }

    maven {
        url = uri("https://maven.ctr-electronics.com/release/")
    }

    maven {
        url = uri("https://maven.revrobotics.com/")
    }
}

dependencies {
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.apache.commons:commons-math3:3.6.1")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:31.1-jre")

    implementation("edu.wpi.first.wpilibj:wpilibj-java:2023.4.3")
    implementation("edu.wpi.first.wpimath:wpimath-java:2023.4.3")

    implementation("com.ctre.phoenix:api-java:5.30.4")
    implementation("com.ctre.phoenix:wpiapi-java:5.30.4")

    implementation("com.revrobotics.frc:REVLib-java:2023.1.3")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
