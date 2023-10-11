import Config.importCommonDependencies
import Config.importCommonPlugins

plugins {
    id(Plugins.application)
    id(Plugins.kotlin)
    kotlin(Plugins.kapt)
}

importCommonPlugins()
importCommonDependencies()

android {
    namespace = "com.gosty.cinemania"
    compileSdk = Config.sdk

    defaultConfig {
        applicationId = "com.gosty.cinemania"
        minSdk = Config.minSdk
        targetSdk = Config.sdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        buildConfigField("String", "IMAGE_BASE_URL", Config.IMAGE_BASE_URL)

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
    implementation(Dependencies.coil)

    // Modules
    implementation(project(Modules.domain))

    // Compose
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