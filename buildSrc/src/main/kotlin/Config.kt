import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate

object Config {
    const val API_BASE_URL = "\"https://api.themoviedb.org/3/\""
    const val API_TOKEN =
        "\"Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZmIyMzI4ZWI0MmIxOGY5ZjdiMDM3Mzk3MzJhNDlhNSIsInN1YiI6IjYzYTdjNzljYWFlYzcxMDA5NWNjNjZmMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.aLtSdTichEJH3blHXKpnJ9lcizD5_EUQyzaESTab978\""
    const val IMAGE_BASE_URL = "\"https://image.tmdb.org/t/p/w500\""
    const val compileSdk = 34
    const val targetSdk = 34
    const val minSdk = 24
    val javaVersion = JavaVersion.VERSION_17
    const val jvmTarget = "17"
    const val versionCode = 1
    const val versionName = "1.0"

    /***
     * This function is to inject common plugins into gradle module
     * @author GOsty
     * @since Oct 5th, 2023
     */
    fun Project.importCommonPlugins() {
        plugins.apply(Plugins.kotlinAndroid)
        plugins.apply(Plugins.crashlytics)
        plugins.apply(Plugins.hiltPlugin)
        plugins.apply(Plugins.parcelize)
    }

    /***
     * This function is to inject common dependencies into gradle module
     * @author GOsty
     * @since Oct 6th, 2023
     */
    fun Project.importCommonDependencies() {
        dependencies {
            val implementation by configurations
            val testImplementation by configurations
            val androidTestImplementation by configurations
            val kapt by configurations

            implementation(Dependencies.coreKtx)
            implementation(Dependencies.appCompat)
            implementation(Dependencies.material)
            implementation(Dependencies.timber)
            implementation(Dependencies.Paging.runtime)

            implementation(Dependencies.Firebase.crashlytics)
            implementation(Dependencies.Firebase.analytics)

            implementation(Dependencies.Hilt.hilt)
            kapt(Dependencies.Hilt.hiltAndroidCompiler)
            kapt(Dependencies.Hilt.hiltCompiler)

            testImplementation(Dependencies.Test.jUnit)
            androidTestImplementation(Dependencies.Test.espresso)
            androidTestImplementation(Dependencies.Test.extJUnit)
        }
    }

    fun Project.importComposeDependencies() {
        dependencies {
            val implementation by configurations
            val testImplementation by configurations
            val androidTestImplementation by configurations
            val debugImplementation by configurations
            val kapt by configurations

            implementation(platform(Dependencies.Compose.compose))
            implementation(Dependencies.Compose.activity)
            implementation(Dependencies.Compose.ui)
            implementation(Dependencies.Compose.navigation)
            implementation(Dependencies.Compose.material3)
            implementation(Dependencies.Compose.uiGraphics)
            implementation(Dependencies.Compose.uiToolingPreview)
            debugImplementation(Dependencies.Compose.uiTooling)
            debugImplementation(Dependencies.Compose.uiTestManifest)
            implementation(Dependencies.Hilt.hiltNavigationCompose)
            implementation(Dependencies.Paging.compose)
            implementation(Dependencies.Compose.icons)
        }
    }
}