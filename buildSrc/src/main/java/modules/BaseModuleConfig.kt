package modules

import org.gradle.api.JavaVersion

abstract class BaseModuleConfig {
    abstract val namespace: String
    abstract val versionCode: Int
    abstract val versionName: String

    open val compileSdk = 33
    open val minSdk = 24
    open val targetSdk = 33

    open val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    open val proguardConsumerRules = "consumer-rules.pro"
    open val testProguardRules = "consumer-rules.pro"
    open val proguardRules = "proguard-rules.pro"
    open val dimension = "environment"

    open val sourceJdk = JavaVersion.VERSION_17
    open val targetJdk = JavaVersion.VERSION_17
}
