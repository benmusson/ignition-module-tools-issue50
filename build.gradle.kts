import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    base
    kotlin("jvm") version "2.0.0"
    id("io.ia.sdk.modl") version "0.3.0"
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

ignitionModule {
    name.set("ignition-module-tools-issue50")
    id.set("com.github.bmusson.ignition-module-tools-issue50")
    version = "0.1.0"
    fileName.set("ignition-module-tools-issue50.modl")
    freeModule.set(true)
    requiredIgnitionVersion.set("8.1.33")
}

val printSignedModulePath by tasks.registering {
    group = "issue"
    dependsOn(tasks.signModule)
    val path = tasks.signModule.flatMap { signModule ->
        signModule.signed.map { it.asFile.path }
    }
    println(path.get())
}


