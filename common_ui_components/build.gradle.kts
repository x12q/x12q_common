

plugins {
    kotlin("jvm")
    kotlin("kapt")
    alias(libs.plugins.jetbrain.compose)
    alias(libs.plugins.jetbrain.kotlin.plugin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.hot.reload)
}

group = libs.versions.groupId.get()
version = libs.versions.version.get()

tasks.test {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

kotlin {
    val javaVersion = libs.versions.supportUILibJvmVersion.get().toInt()
    jvmToolchain(javaVersion)
}
compose.resources {
    publicResClass = true
    generateResClass = always
}
dependencies {
    // implementation(compose.desktop.common)
    implementation(compose.desktop.currentOs)
    implementation(compose.components.resources)
    implementation(libs.material3)
    implementation(project(":x12q_common:common_utils"))

    implementation(libs.kotlin.datetime)

    implementation(libs.setting)
    implementation(libs.setting.coroutine)
    implementation(libs.kotlin.coroutine)
    implementation(libs.kotlin.coroutine.test)
    implementation(libs.turbine)

    implementation(libs.michaelbull.kotlinResult)
    implementation(libs.apache.common.text)
    implementation(libs.kotlin.serialization)

    testImplementation(kotlin("test"))
    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlin.datetime)
}
