import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //std lib
    private const val kotlinStdLib =
        "org.jetbrains.kotlin:kotlin-stdlib:${DependencyVersion.kotlin}"

    fun DependencyHandler.kotlinStdLib() {
        add(ConfigurationName.IMPLEMENTATION.configName, kotlinStdLib)
    }

    //android core
    private const val coreKtx = "androidx.core:core-ktx:${DependencyVersion.coreKtx}"

    fun DependencyHandler.androidCoreKtx() {
        add(ConfigurationName.IMPLEMENTATION.configName, coreKtx)
    }

    //android ui
    private const val appcompat = "androidx.appcompat:appcompat:${DependencyVersion.appCompat}"

    fun DependencyHandler.appcompat() {
        add(ConfigurationName.IMPLEMENTATION.configName, appcompat)
    }

    private const val activityKtx =
        "androidx.activity:activity-ktx:${DependencyVersion.activityKtx}"

    fun DependencyHandler.activityKtx() {
        add(ConfigurationName.IMPLEMENTATION.configName, activityKtx)
    }

    private const val fragmentKtx =
        "androidx.fragment:fragment-ktx:${DependencyVersion.fragmentKtx}"
    private const val fragmentTesting =
        "androidx.fragment:fragment-testing:${DependencyVersion.fragmentTesting}"

    fun DependencyHandler.fragment() {
        add(ConfigurationName.IMPLEMENTATION.configName, fragmentKtx)
//        add(ConfigurationName.DEBUG_IMPLEMENTATION.configName, fragmentTesting)
    }

    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${DependencyVersion.constraintLayout}"

    fun DependencyHandler.androidConstraintLayout() {
        add(ConfigurationName.IMPLEMENTATION.configName, constraintLayout)
    }

    private const val material =
        "com.google.android.material:material:${DependencyVersion.material}"

    fun DependencyHandler.material() {
        add(ConfigurationName.IMPLEMENTATION.configName, material)
    }

    //android lifecycle
    private const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${DependencyVersion.lifecycle}"
    private const val lifecycleLivedataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${DependencyVersion.lifecycle}"
    private const val lifecycleViewmodelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${DependencyVersion.lifecycle}"

    fun DependencyHandler.lifecycle() {
        add(ConfigurationName.IMPLEMENTATION.configName, lifecycleRuntimeKtx)
        add(ConfigurationName.IMPLEMENTATION.configName, lifecycleLivedataKtx)
        add(ConfigurationName.IMPLEMENTATION.configName, lifecycleViewmodelKtx)
    }

    //dagger
    private const val dagger = "com.google.dagger:dagger:${DependencyVersion.dagger}"
    private const val daggerCompiler =
        "com.google.dagger:dagger-compiler:${DependencyVersion.dagger}"

    fun DependencyHandler.dagger() {
        add(ConfigurationName.KAPT.configName, daggerCompiler)
        add(ConfigurationName.IMPLEMENTATION.configName, dagger)
    }

    private const val hilt = "com.google.dagger:hilt-android:${DependencyVersion.hilt}"
    private const val hiltCompiler = "com.google.dagger:hilt-compiler:${DependencyVersion.hilt}"
    private const val hiltAndroidCompiler =
        "androidx.hilt:hilt-compiler:${DependencyVersion.hiltAndroidCompiler}"
    private const val hiltWorkManager =
        "androidx.hilt:hilt-work:${DependencyVersion.hiltWorkManager}"
    private const val hiltNavigation =
        "androidx.hilt:hilt-navigation-fragment:${DependencyVersion.hiltNavigation}"
    private const val hiltAndroidTest =
        "com.google.dagger:hilt-android-testing:${DependencyVersion.hilt}"

    fun DependencyHandler.hilt() {
        add(ConfigurationName.KAPT.configName, hiltCompiler)
        add(ConfigurationName.KAPT.configName, hiltAndroidCompiler)
        add(ConfigurationName.IMPLEMENTATION.configName, hilt)
    }

    fun DependencyHandler.hiltWorkManager() {
        add(ConfigurationName.IMPLEMENTATION.configName, hiltWorkManager)
    }

    fun DependencyHandler.hiltNavigation() {
        add(ConfigurationName.IMPLEMENTATION.configName, hiltNavigation)
    }

    fun DependencyHandler.hiltTest() {
        add(ConfigurationName.KAPT_TEST.configName, hiltCompiler)
        add(ConfigurationName.ANDROID_TEST_IMPLEMENTATION.configName, hiltAndroidTest)
        add(ConfigurationName.KAPT_ANDROID_TEST.configName, hiltAndroidTest)

    }

    //room
    private const val roomRuntime = "androidx.room:room-runtime:${DependencyVersion.room}"
    private const val roomKtx = "androidx.room:room-ktx:${DependencyVersion.room}"
    private const val roomCompiler = "androidx.room:room-compiler:${DependencyVersion.room}"
    private const val roomTesting = "androidx.room:room-testing:${DependencyVersion.room}"

    fun DependencyHandler.room() {
        add(ConfigurationName.IMPLEMENTATION.configName, roomRuntime)
        add(ConfigurationName.IMPLEMENTATION.configName, roomKtx)
        add(ConfigurationName.KSP.configName, roomCompiler)
        add(ConfigurationName.TEST_IMPLEMENTATION.configName, roomTesting)
    }

    //firebase
    private const val firebaseBom =
        "com.google.firebase:firebase-bom:${DependencyVersion.firebaseBom}"
    private const val firebaseAnalyticsKtx =
        "com.google.firebase:firebase-analytics-ktx:${DependencyVersion.firebaseAnalyticsKtx}"

    fun DependencyHandler.firebase() {
        platform(firebaseBom)
        add(ConfigurationName.IMPLEMENTATION.configName, firebaseAnalyticsKtx)
    }

    //test libs
    private const val junit4 = "junit:junit:${DependencyVersion.junit4}"
    private const val junit5 =
        "org.junit.jupiter:junit-jupiter-api:${DependencyVersion.junit5Jupiter}"
    private const val junit5PlatformLauncher =
        "org.junit.platform:junit-platform-launcher:${DependencyVersion.junit5Platform}"
    private const val junit5PlatformEngine =
        "org.junit.platform:junit-platform-engine:${DependencyVersion.junit5Platform}"
    private const val junit5PlatformRunner =
        "org.junit.platform:junit-platform-runner:${DependencyVersion.junit5Platform}"

    private const val testRunner = "androidx.test:runner:${DependencyVersion.testRunner}"
    private const val testRules = "androidx.test:rules:${DependencyVersion.testRules}"
    private const val extJUnit = "androidx.test.ext:junit:${DependencyVersion.extJunit}"
    private const val extJUnitKtx = "androidx.test.ext:junit-ktx:${DependencyVersion.extJunit}"
    private const val espressoCore =
        "androidx.test.espresso:espresso-core:${DependencyVersion.espresso}"
    private const val conditionWatcher =
        "com.azimolabs.conditionwatcher:conditionwatcher:${DependencyVersion.conditionWatcher}"

    fun DependencyHandler.androidTest(
        configuration: ConfigurationName = ConfigurationName.ANDROID_TEST_IMPLEMENTATION
    ) {
        add(configuration.configName, extJUnit)
        add(configuration.configName, extJUnitKtx)
        add(configuration.configName, espressoCore)
        add(configuration.configName, testRules)
        add(configuration.configName, testRunner)
        add(configuration.configName, conditionWatcher)
    }

    fun DependencyHandler.junit4(
        configuration: ConfigurationName = ConfigurationName.TEST_IMPLEMENTATION
    ) {
        add(configuration.configName, junit4)
    }

    fun DependencyHandler.junit5() {
        add(ConfigurationName.TEST_IMPLEMENTATION.configName, junit5)
        add(ConfigurationName.TEST_IMPLEMENTATION.configName, junit5PlatformLauncher)
        add(ConfigurationName.TEST_IMPLEMENTATION.configName, junit5PlatformEngine)
        add(ConfigurationName.TEST_IMPLEMENTATION.configName, junit5PlatformRunner)
    }

    //kotlin coroutines
    private const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependencyVersion.coroutinesAndroid}"
    private const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${DependencyVersion.coroutinesTest}"

    fun DependencyHandler.coroutines() {
        add(ConfigurationName.IMPLEMENTATION.configName, coroutinesAndroid)
        add(ConfigurationName.TEST_IMPLEMENTATION.configName, coroutinesTest)
    }

    //timber
    private const val timberAndroid =
        "com.jakewharton.timber:timber:${DependencyVersion.timberAndroid}"
    private const val timberJdk = "com.jakewharton.timber:timber-jdk:${DependencyVersion.timberJdk}"

    fun DependencyHandler.timberAndroid() {
        add(ConfigurationName.IMPLEMENTATION.configName, timberAndroid)
    }

    fun DependencyHandler.timberJdk() {
        add(ConfigurationName.IMPLEMENTATION.configName, timberJdk)
    }

    //androidx annotation
    private const val androidAnnotation =
        "androidx.annotation:annotation:${DependencyVersion.androidAnnotation}"

    fun DependencyHandler.androidAnnotation() {
        add(ConfigurationName.IMPLEMENTATION.configName, androidAnnotation)
    }

    //jvm annotation
    private const val jvmAnnotation =
        "androidx.annotation:annotation-jvm:${DependencyVersion.jvmAnnotation}"

    fun DependencyHandler.jvmAnnotation() {
        add(ConfigurationName.IMPLEMENTATION.configName, jvmAnnotation)
    }

    //navigation
    private const val navigationUiKtx =
        "androidx.navigation:navigation-ui-ktx:${DependencyVersion.navigation}"
    private const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${DependencyVersion.navigation}"
    private const val navigationTesting =
        "androidx.navigation:navigation-testing:${DependencyVersion.navigation}"

    fun DependencyHandler.navigation() {
        add(ConfigurationName.IMPLEMENTATION.configName, navigationUiKtx)
        add(ConfigurationName.IMPLEMENTATION.configName, navigationFragmentKtx)
        add(ConfigurationName.API.configName, navigationFragmentKtx)
        add(ConfigurationName.ANDROID_TEST_IMPLEMENTATION.configName, navigationTesting)
    }

    //work manager
    private const val workManager =
        "androidx.work:work-runtime-ktx:${DependencyVersion.workManager}"
    private const val workManagerTesting =
        "androidx.work:work-testing:${DependencyVersion.workManager}"

    fun DependencyHandler.workManager() {
        add(ConfigurationName.IMPLEMENTATION.configName, workManager)
        add(ConfigurationName.ANDROID_TEST_IMPLEMENTATION.configName, workManagerTesting)
    }

    //json
    private const val gson = "com.google.code.gson:gson:${DependencyVersion.gson}"

    fun DependencyHandler.gson() {
        add(ConfigurationName.IMPLEMENTATION.configName, gson)
    }

    //preferences
    private const val preference = "androidx.preference:preference:${DependencyVersion.preference}"

    fun DependencyHandler.preference() {
        add(ConfigurationName.IMPLEMENTATION.configName, preference)
    }

    fun DependencyHandler.moduleImplementation(module: String) {
        add(ConfigurationName.IMPLEMENTATION.configName, project(mapOf("path" to ":$module")))
    }

    fun DependencyHandler.moduleTestImplementation(module: String) {
        add(ConfigurationName.TEST_IMPLEMENTATION.configName, project(mapOf("path" to ":$module")))
    }

    fun DependencyHandler.moduleAndroidTestImplementation(module: String) {
        add(
            ConfigurationName.ANDROID_TEST_IMPLEMENTATION.configName,
            project(mapOf("path" to ":$module"))
        )
    }

    enum class ConfigurationName(val configName: String) {
        KAPT("kapt"),
        IMPLEMENTATION("implementation"),
        ANDROID_TEST_IMPLEMENTATION("androidTestImplementation"),
        TEST_IMPLEMENTATION("testImplementation"),
        KSP("ksp"),
        RUNTIME_ONLY("runtimeOnly"),
        API("api"),
        DEBUG_IMPLEMENTATION("debugImplementation"),
        KAPT_TEST("kaptTest"),
        KAPT_ANDROID_TEST("kaptAndroidTest"),
    }
}

