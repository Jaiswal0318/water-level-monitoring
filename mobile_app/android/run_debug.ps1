# Navigate to project root
cd "C:\FlutterProjects\water-level-monitoring\mobile_app"

Write-Host "🧹 Cleaning old build..."
flutter clean

Write-Host "📦 Getting dependencies..."
flutter pub get

Write-Host "🔍 Checking connected devices..."
$devices = & adb devices

if ($devices -match "device`r") {
    Write-Host "✅ Device detected. Running Flutter in debug mode..."

    # Run Flutter app in debug mode (with hot reload support)
    flutter run -d android
} else {
    Write-Host "⚠️ No Android device detected via adb."
    Write-Host "👉 Make sure:"
    Write-Host "   1. USB Debugging is enabled in Developer Options."
    Write-Host "   2. You have authorized the computer on your phone."
    Write-Host "   3. Run 'adb devices' to confirm."
}
