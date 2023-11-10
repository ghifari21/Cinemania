import Config.importCommonDependencies
import Config.importCommonPlugins
import Config.importComposeDependencies

plugins {
    id(Plugins.application)
    id(Plugins.googleServices)
    id(Plugins.kotlin)
    kotlin(Plugins.kapt)
}

importCommonPlugins()
importCommonDependencies()
importComposeDependencies()

android {
    namespace = "com.gosty.cinemania"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "com.gosty.cinemania"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies.lifecycleViewModelKtx)

    // Modules
    implementation(project(Modules.domain))
    implementation(project(Modules.model))
    implementation(project(Modules.common))
    implementation(project(Modules.home))
    implementation(project(Modules.detail))
    implementation(project(Modules.explore))
    implementation(project(Modules.favorite))
    implementation(project(Modules.profile))

    // Firebase
    implementation(Dependencies.Firebase.crashlytics)
    implementation(Dependencies.Firebase.analytics)
    implementation(Dependencies.Firebase.auth)

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