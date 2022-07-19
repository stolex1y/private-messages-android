// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(ClasspathDependency.ANDROID_GRADLE)
        classpath(ClasspathDependency.KOTLIN)
        classpath(ClasspathDependency.GMS)
        classpath(ClasspathDependency.NAVIGATION)
        classpath(ClasspathDependency.SERIALIZATION)
    }

    repositories {
        mavenCentral()
        google()
    }
}

plugins {
    id(Plugins.APPLICATION) version PluginVersions.APPLICATION apply false
    id(Plugins.ANDROID_LIBRARY) version PluginVersions.ANDROID_LIBRARY apply false
    id(Plugins.SERIALIZATION) version PluginVersions.SERIALIZATION apply false
    id(Plugins.KSP) version PluginVersions.KSP apply false
    id(Plugins.KOTLIN_JVM) version PluginVersions.KOTLIN_JVM apply false
    id(Plugins.HILT) version PluginVersions.HILT apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
