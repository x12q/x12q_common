plugins {
    val kotlinVersion = libs.versions.kotlinVersion.get()
    kotlin("jvm") version kotlinVersion apply false
    kotlin("kapt") version kotlinVersion apply false
    alias(libs.plugins.jetbrain.compose) apply false
    alias(libs.plugins.jetbrain.kotlin.plugin.compose) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.compose.hot.reload) apply false

}