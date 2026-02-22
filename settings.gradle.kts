
pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
plugins {

    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "x12q_common"
include("common_ui_components")
include("common_utils")
include("common_icon")
include("common_di")