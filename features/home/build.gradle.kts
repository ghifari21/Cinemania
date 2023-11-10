import Config.importCommonDependencies
import Config.importCommonPlugins
import Config.importComposeDependencies

plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    kotlin(Plugins.kapt)
}

importCommonPlugins()
importCommonDependencies()
importComposeDependencies()

android {
    namespace = "com.gosty.home"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    // Module
    implementation(project(Modules.model))
    implementation(project(Modules.common))
    implementation(project(Modules.domain))

    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies.lifecycleViewModelKtx)
    implementation(Dependencies.coil)
    implementation(Dependencies.lottie)

    // Test
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.extJUnit)
    androidTestImplementation(platform(Dependencies.Compose.compose))
    androidTestImplementation(Dependencies.Test.composeTest)
    androidTestImplementation(Dependencies.Test.espresso)
}

kapt {
    correctErrorTypes = true
}