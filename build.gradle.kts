// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val kotlinVersion = "1.8.10"
    val hiltVersion = "2.45"

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
    repositories {
        mavenCentral()
    }

}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.45" apply false
}