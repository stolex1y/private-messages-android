import AppDependencies.activityKtx
import AppDependencies.androidAnnotation
import AppDependencies.androidConstraintLayout
import AppDependencies.androidCoreKtx
import AppDependencies.androidTest
import AppDependencies.appcompat
import AppDependencies.coroutines
import AppDependencies.firebase
import AppDependencies.fragment
import AppDependencies.gson
import AppDependencies.hilt
import AppDependencies.hiltNavigation
import AppDependencies.hiltTest
import AppDependencies.hiltWorkManager
import AppDependencies.junit4
import AppDependencies.kotlinStdLib
import AppDependencies.lifecycle
import AppDependencies.material
import AppDependencies.moduleImplementation
import AppDependencies.navigation
import AppDependencies.preference
import AppDependencies.timberAndroid
import AppDependencies.workManager
import modules.Modules
import modules.SenderModuleConfig

plugins {
    id(Plugins.APPLICATION)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.KSP)
    id(Plugins.GMS)
    id(Plugins.NAV_SAFEARGS)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.HILT)
}

android {
    val moduleConfig = SenderModuleConfig
    namespace = moduleConfig.namespace
    compileSdk = moduleConfig.compileSdk

    defaultConfig {
        applicationId = moduleConfig.namespace
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
            isDebuggable = true
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
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
    moduleImplementation(Modules.COMMON)
    moduleImplementation(Modules.DATA)
    kotlinStdLib()
    androidCoreKtx()
    appcompat()
    androidConstraintLayout()
    lifecycle()
    firebase()
    activityKtx()
    fragment()
    androidTest()
    junit4()
    material()
    coroutines()
    timberAndroid()
    androidAnnotation()
    hilt()
    hiltNavigation()
    hiltWorkManager()
    hiltTest()
    navigation()
    workManager()
    gson()
    preference()
}
