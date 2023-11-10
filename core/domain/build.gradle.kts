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
    namespace = "com.gosty.core.domain"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

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
}

dependencies {
    implementation(project(Modules.data))
    implementation(project(Modules.model))
    implementation(project(Modules.common))

    testImplementation(Dependencies.Test.jUnit)
}

kapt {
    correctErrorTypes = true
}