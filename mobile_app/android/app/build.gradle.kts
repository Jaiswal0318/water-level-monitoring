plugins {
    id("com.android.application")
<<<<<<< HEAD
    id("kotlin-android")
    // Firebase Google Services plugin
    id("com.google.gms.google-services")
    // Flutter Gradle Plugin (must be last)
=======
    // START: FlutterFire Configuration
    id("com.google.gms.google-services")
    // END: FlutterFire Configuration
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
>>>>>>> 30fef52e967bdcb7869f2953d52f3ced20dfb625
    id("dev.flutter.flutter-gradle-plugin")
}

android {
<<<<<<< HEAD
    namespace = "com.waterlevel.monitoring"
=======
    namespace = "com.example.mobile_app"
>>>>>>> 30fef52e967bdcb7869f2953d52f3ced20dfb625
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
<<<<<<< HEAD
        // ⚡ Must match the package name you used in Firebase console
        applicationId = "com.waterlevel.monitoring"
=======
        // TODO: Specify your own unique Application ID (https://developer.android.com/studio/build/application-id.html).
        applicationId = "com.example.mobile_app"
        // You can update the following values to match your application needs.
        // For more information, see: https://flutter.dev/to/review-gradle-config.
>>>>>>> 30fef52e967bdcb7869f2953d52f3ced20dfb625
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
<<<<<<< HEAD
=======
            // TODO: Add your own signing config for the release build.
            // Signing with the debug keys for now, so `flutter run --release` works.
>>>>>>> 30fef52e967bdcb7869f2953d52f3ced20dfb625
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}
<<<<<<< HEAD

dependencies {
    // Firebase BOM (keeps versions aligned)
    implementation(platform("com.google.firebase:firebase-bom:34.3.0"))

    // Firebase core features
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
}
=======
>>>>>>> 30fef52e967bdcb7869f2953d52f3ced20dfb625
