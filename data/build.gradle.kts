import AppDependencies.androidAnnotation
import AppDependencies.androidCoreKtx
import AppDependencies.androidTest
import AppDependencies.coroutines
import AppDependencies.firebase
import AppDependencies.gson
import AppDependencies.hilt
import AppDependencies.hiltTest
import AppDependencies.junit4
import AppDependencies.kotlinStdLib
import AppDependencies.moduleImplementation
import AppDependencies.timberAndroid
import modules.DataModuleConfig
import modules.Modules

plugins {
    id(Plugins.APPLICATION)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.GMS)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.HILT)
}

android {
    val moduleConfig = DataModuleConfig
    namespace = moduleConfig.namespace
    compileSdk = moduleConfig.compileSdk

    defaultConfig {
        minSdk = moduleConfig.minSdk
        version = moduleConfig.versionCode

        testInstrumentationRunner = moduleConfig.testInstrumentationRunner

        testProguardFiles(
            moduleConfig.testProguardRules
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                moduleConfig.proguardRules
            )
        }

        debug {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = moduleConfig.sourceJdk
        targetCompatibility = moduleConfig.targetJdk
    }
    kotlinOptions {
        jvmTarget = moduleConfig.targetJdk.majorVersion
    }
}

dependencies {
    moduleImplementation(Modules.DOMAIN)
    kotlinStdLib()
    androidCoreKtx()
    firebase()
    androidTest()
    junit4()
    coroutines()
    timberAndroid()
    androidAnnotation()
    hilt()
    hiltTest()
    gson()
}
