plugins {
    kotlin("jvm")
    kotlin("kapt")
    alias(libs.plugins.jetbrain.compose)
    alias(libs.plugins.jetbrain.kotlin.plugin.compose)
    alias(libs.plugins.ksp)
}

group = libs.versions.groupId.get()
version = libs.versions.version.get()

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    val javaVersion = libs.versions.supportLibJvmVersion.get().toInt()
    jvmToolchain(javaVersion)
}


compose.resources {
    publicResClass = true
    generateResClass = always
}

dependencies {
    implementation(compose.desktop.common)
    implementation(compose.components.resources)
    implementation(libs.material3)
    testImplementation(kotlin("test"))
}

