import org.jetbrains.kotlin.org.apache.commons.lang3.SystemUtils

plugins {
    kotlin("jvm")
    alias(libs.plugins.jetbrain.compose)
    alias(libs.plugins.jetbrain.kotlin.plugin.compose)

    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.hot.reload)
    alias(libs.plugins.ksp)
    alias(libs.plugins.buildConfig)
}

group = "com.x12q"
version = "unspecified"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(libs.jetbrain.jewel.decorated.window)
    implementation(compose.desktop.currentOs)
    implementation(compose.components.resources)
    implementation(libs.material3)
    implementation(libs.compose.viewmodel)
    implementation(libs.kotlin.datetime)
    implementation(libs.kotlin.coroutine)
    implementation(libs.kotlin.coroutine.test)
    implementation(libs.michaelbull.kotlinResult)
    implementation(libs.apache.common.text)
    implementation(libs.apache.common.exec)
    implementation(libs.kotlin.serialization)
    testImplementation(kotlin("test"))
    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlin.datetime)
    implementation(libs.apache.common.io)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}