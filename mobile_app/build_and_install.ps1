# Navigate to project root
cd "C:\FlutterProjects\water-level-monitoring\mobile_app"

Write-Host "🧹 Cleaning old build..."
flutter clean

Write-Host "📦 Getting dependencies..."
flutter pub get

Write-Host "🏗️ Building APK..."
flutter build apk --release

# Path to APK
$apkPath = "build\app\outputs\flutter-apk\app-release.apk"

if (Test-Path $apkPath) {
    Write-Host "📱 Checking for connected device..."
    $devices = & adb devices

    if ($devices -match "device`r") {
        Write-Host "✅ Device detected. Installing APK..."
        adb install -r $apkPath

        Write-Host "🚀 Launching app on phone..."
        $packageName = "com.example.mobile_app"
        adb shell monkey -p $packageName -c android.intent.category.LAUNCHER 1

        Write-Host "🎉 App launched on your phone!"
    } else {
        Write-Host "⚠️ No device detected via adb. Copy the APK manually from:"
        Write-Host $apkPath
    }
} else {
    Write-Host "❌ APK build failed. Check Flutter build logs."
}
