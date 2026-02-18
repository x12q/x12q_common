plugins {
    kotlin("jvm")
}

group = libs.versions.groupId.get()
version = libs.versions.version.get()

repositories {
    mavenCentral()
}

dependencies {
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
    implementation(libs.oshi)
}

tasks.test {
    useJUnitPlatform()
}
 kotlin {
    val javaVersion = libs.versions.supportLibJvmVersion.get().toInt()
    jvmToolchain(javaVersion)
}
