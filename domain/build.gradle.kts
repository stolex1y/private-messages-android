import AppDependencies.androidAnnotation
import AppDependencies.coroutines
import AppDependencies.kotlinStdLib
import AppDependencies.moduleImplementation
import modules.DomainModuleConfig
import modules.Modules

plugins {
    id(Plugins.JAVA_LIBRARY)
    id(Plugins.KOTLIN_JVM)
    id(Plugins.JAVA)
}

val moduleConfig = DomainModuleConfig
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
    moduleImplementation(Modules.COMMON)
    kotlinStdLib()
    coroutines()
    androidAnnotation()
}
