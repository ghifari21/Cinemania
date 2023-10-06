import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate

object Config {
    const val API_BASE_URL = "\"https://api.themoviedb.org/3/\""
    const val IMAGE_BASE_URL = "\"https://image.tmdb.org/t/p/\""
    const val sdk = 34
    const val minSdk = 24
    val javaVersion = JavaVersion.VERSION_17
    const val jvmTarget = "17"

    /***
     * This function is to inject common plugins into gradle module
     * @author GOsty
     * @since Oct 5th, 2023
     */
    fun Project.importCommonPlugins() {
        plugins.apply("kotlin-android")
        plugins.apply("kotlin-android-extensions")
        plugins.apply("com.android.application")
        plugins.apply("org.jetbrains.kotlin")
        plugins.apply("com.google.gms.google-services")
        plugins.apply("com.google.firebase.crashlytics")
        plugins.apply("kotlin-kapt")
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
}