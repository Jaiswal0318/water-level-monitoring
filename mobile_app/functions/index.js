const functions = require("firebase-functions");

// 🔹 Firestore trigger: runs whenever waterLevel/{id} changes
exports.onWaterLevelChange = functions.firestore
  .document("waterLevel/{id}")
  .onWrite((change, context) => {
    const data = change.after.exists ? change.after.data() : null;
    console.log("✅ Water level updated:", data);
    return null;
  });

// 🔹 Simple HTTP endpoint
exports.helloWorld = functions.https.onRequest((req, res) => {
  res.send("🌍 Hello from Firebase Functions!");
});
