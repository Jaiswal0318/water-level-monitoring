plugins {
    id("com.android.application")
    id("kotlin-android")
    // Firebase Google Services plugin
    id("com.google.gms.google-services")
    // Flutter Gradle Plugin (must be last)
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.waterlevel.monitoring"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        // ⚡ Must match the package name you used in Firebase console
        applicationId = "com.waterlevel.monitoring"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // Firebase BOM (keeps versions aligned)
    implementation(platform("com.google.firebase:firebase-bom:34.3.0"))

    // Firebase core features
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
}
