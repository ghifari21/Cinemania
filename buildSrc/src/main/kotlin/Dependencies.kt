object Dependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleRuntimeKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
    const val lottie = "com.airbnb.android:lottie-compose:${Versions.lottie}"

    object Compose {
        const val activity = "androidx.activity:activity-compose:${Versions.Compose.activity}"
        const val compose = "androidx.compose:compose-bom:${Versions.Compose.bom}"
        const val ui = "androidx.compose.ui:ui"
        const val uiGraphics = "androidx.compose.ui:ui-graphics"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val material3 = "androidx.compose.material3:material3"
        const val uiTooling = "androidx.compose.ui:ui-tooling"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
        const val navigation =
            "androidx.navigation:navigation-compose:${Versions.Compose.navigation}"
        const val icons =
            "androidx.compose.material:material-icons-extended:${Versions.Compose.compose}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.Hilt.hilt}"
        const val hiltAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.Hilt.hilt}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.Hilt.hiltCompiler}"
        const val hiltNavigationCompose =
            "androidx.hilt:hilt-navigation-compose:${Versions.Hilt.hiltNavigationCompose}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object Firebase {
        const val crashlytics =
            "com.google.firebase:firebase-crashlytics-ktx:${Versions.Firebase.crashlytics}"
        const val analytics =
            "com.google.firebase:firebase-analytics-ktx:${Versions.Firebase.analytics}"
        const val database =
            "com.google.firebase:firebase-database-ktx:${Versions.Firebase.database}"
        const val auth = "com.google.firebase:firebase-auth-ktx:${Versions.Firebase.auth}"
    }

    object OkHttp {
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    }

    object Paging {
        const val runtime = "androidx.paging:paging-runtime:${Versions.paging}"
        const val compose = "androidx.paging:paging-compose:${Versions.paging}"
    }

    object Test {
        const val jUnit = "junit:junit:${Versions.Test.jUnit}"
        const val extJUnit = "androidx.test.ext:junit:${Versions.Test.extJUnit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.Test.espresso}"
        const val composeTest = "androidx.compose.ui:ui-test-junit4"
    }
}