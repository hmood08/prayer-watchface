plugins {
    id("com.android.application")
}

android {
    namespace = "com.prayertime.watchface"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.prayertime.watchface"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

// لا dependencies — وجه الساعة WFF لا يحتاج كود
