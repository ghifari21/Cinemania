buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0")
        classpath("com.google.gms:google-services:4.4.0")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.9")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.application) version Versions.Plugin.android apply false
    id(Plugins.kotlin) version Versions.Plugin.kotlin apply false
    id(Plugins.library) version Versions.Plugin.android apply false
    id(Plugins.hilt) version Versions.Plugin.hilt apply false
}