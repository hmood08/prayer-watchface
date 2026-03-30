plugins {
    id("com.android.application")
}

android {
    namespace = "com.prayertime.watchface"
    compileSdk = 34

       bundle  {
        language { enableSplit = false }
        density { enableSplit = false }
        abi { enableSplit = false }
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
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
