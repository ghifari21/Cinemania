pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Cinemania"
include(":app")
include(":core:data")
include(":core:domain")
include(":core:model")
include(":core:common")
include(":core:response")
include(":core:entity")
include(":features:home")
include(":features:favorite")
include(":features:profile")
include(":features:detail")
include(":features:explore")
