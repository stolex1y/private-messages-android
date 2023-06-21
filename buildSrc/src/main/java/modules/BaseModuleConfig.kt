package modules

import org.gradle.api.JavaVersion

abstract class BaseModuleConfig {
    val appNamespace = "ru.stolexiy.pmsg"
    open val moduleNamespace: String = ""
    open val moduleName: String
        get() = moduleNamespace

    val namespace: String
        get() = if (moduleNamespace == "")
            appNamespace
        else
            "$appNamespace.$moduleNamespace"

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
