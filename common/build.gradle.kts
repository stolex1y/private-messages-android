import AppDependencies.androidAnnotation
import AppDependencies.coroutines
import AppDependencies.gson
import AppDependencies.kotlinStdLib
import modules.CommonModuleConfig

plugins {
    id(Plugins.JAVA_LIBRARY)
    id(Plugins.KOTLIN_JVM)
    id(Plugins.JAVA)
}

val moduleConfig = CommonModuleConfig
group = moduleConfig.namespace
version = moduleConfig.versionCode

java {
    toolchain {
        sourceCompatibility = moduleConfig.sourceJdk
        targetCompatibility = moduleConfig.targetJdk
    }
}

kotlin {
    jvmToolchain(moduleConfig.targetJdk.majorVersion.toInt())
}

dependencies {
    androidAnnotation()
    kotlinStdLib()
    coroutines()
    gson()
}
