plugins {
    kotlin("jvm") version "1.9.20"
    id("org.jlleitschuh.gradle.ktlint") version "11.6.1"
}

group = "com.harmellaw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.arrow-kt:arrow-core:1.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
    implementation("org.jetbrains.kotlin:kotlin-test:1.9.20")
}

tasks.test {
    useJUnitPlatform()
}
