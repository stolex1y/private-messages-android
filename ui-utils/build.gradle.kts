import AppDependencies.activityKtx
import AppDependencies.androidAnnotation
import AppDependencies.androidConstraintLayout
import AppDependencies.androidCoreKtx
import AppDependencies.androidTest
import AppDependencies.appcompat
import AppDependencies.coroutines
import AppDependencies.fragment
import AppDependencies.gson
import AppDependencies.hilt
import AppDependencies.hiltWorkManager
import AppDependencies.junit4
import AppDependencies.kotlinStdLib
import AppDependencies.lifecycle
import AppDependencies.material
import AppDependencies.moduleImplementation
import AppDependencies.timberAndroid
import AppDependencies.workManager
import modules.Modules
import modules.UiUtilsModuleConfig

plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.HILT)
}

android {
    val moduleConfig = UiUtilsModuleConfig
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
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
    moduleImplementation(Modules.COMMON)
    kotlinStdLib()
    appcompat()
    activityKtx()
    fragment()
    androidConstraintLayout()
    material()
    lifecycle()
    androidCoreKtx()
    androidTest()
    junit4()
    workManager()
    hiltWorkManager()
    hilt()
    coroutines()
    timberAndroid()
    androidAnnotation()
    gson()
}
