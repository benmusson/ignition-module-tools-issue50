rootProject.name = "ignition-module-tools-issue50"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://nexus.inductiveautomation.com/repository/public/")
        mavenLocal()
    }
}

include(":")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")