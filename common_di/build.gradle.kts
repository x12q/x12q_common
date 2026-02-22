
plugins {
    kotlin("jvm")
    alias(libs.plugins.jetbrain.compose)
    alias(libs.plugins.jetbrain.kotlin.plugin.compose)
    alias(libs.plugins.ksp)
}

group = libs.versions.groupId.get()
version = libs.versions.version.get()

repositories {
    mavenCentral()
    google()
}

kotlin {
    val javaVersion = libs.versions.appJvmVersion.get().toInt()
    jvmToolchain(javaVersion)
}

dependencies {
    ksp(libs.kotlin.inject.compiler)
    kspTest(libs.kotlin.inject.compiler)
    implementation(libs.kotlin.inject.runtime)
    ksp (libs.amazon.anvil.compiler)
    implementation (libs.amazon.anvil.runtime)
    implementation (libs.amazon.anvil.runtime.optional)
    implementation(compose.desktop.currentOs)
    implementation(compose.components.resources)
    implementation(libs.compose.viewmodel)
    implementation(libs.kotlin.datetime)
    implementation(libs.setting.coroutine)
    implementation(libs.kotlin.coroutine)
    implementation(libs.kotlin.coroutine.test)
    implementation(libs.turbine)
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
