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

rootProject.name = "ParsTasmimCodeChallengeEP"
include(":app")
include(":libraries:design_system")
include(":libraries:navigation")
include(":features:splash")
include(":features:home")
include(":features:search")
include(":features:details")
include(":features:add_book")
