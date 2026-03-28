import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

// Load keystore properties outside the android block to avoid shadowing 'java'
val keystorePropertiesFile = rootProject.file("local.properties")
val keystoreProperties = Properties()
if (keystorePropertiesFile.exists()) {
    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
}

android {
    namespace = "com.prayertime.watchface"
    compileSdk = 34

    signingConfigs {
        create("release") {
            storeFile = keystoreProperties["keystore.path"]?.let { rootProject.file(it as String) }
            storePassword = keystoreProperties["keystore.password"] as String?
            keyAlias = keystoreProperties["keystore.alias"] as String?
            keyPassword = keystoreProperties["keystore.password"] as String?
        }
    }

    defaultConfig {
        applicationId = "com.prayertime.watchface"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

// Use modern compiler options for Kotlin
kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

dependencies {
    implementation("androidx.wear:wear:1.3.0")
    implementation("androidx.wear.watchface:watchface:1.2.1")
    implementation("androidx.wear.watchface:watchface-complications-data-source:1.2.1")
    implementation("androidx.wear.watchface:watchface-editor:1.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.core:core-ktx:1.12.0")
}
