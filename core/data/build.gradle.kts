import Config.importCommonDependencies
import Config.importCommonPlugins

plugins {
    id(Plugins.library)
    id(Plugins.kotlin)
    kotlin(Plugins.kapt)
}

importCommonPlugins()
importCommonDependencies()

android {
    namespace = "com.gosty.core.data"
    compileSdk = Config.sdk

    defaultConfig {
        minSdk = Config.minSdk
        buildConfigField("String", "API_BASE_URL", Config.API_BASE_URL)
        buildConfigField("String", "API_TOKEN", Config.API_TOKEN)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        buildConfig = true
    }
}

dependencies {
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.gson)
    implementation(Dependencies.OkHttp.okHttp)
    implementation(Dependencies.OkHttp.logging)

    implementation(Dependencies.Firebase.auth)
    implementation(Dependencies.Firebase.database)

    testImplementation(Dependencies.Test.jUnit)
}

kapt {
    correctErrorTypes = true
}