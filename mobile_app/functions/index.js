<<<<<<< HEAD
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
=======
/**
 * Import function triggers from their respective submodules:
 *
 * const {onCall} = require("firebase-functions/v2/https");
 * const {onDocumentWritten} = require("firebase-functions/v2/firestore");
 *
 * See a full list of supported triggers at https://firebase.google.com/docs/functions
 */

const {setGlobalOptions} = require("firebase-functions");
const {onRequest} = require("firebase-functions/https");
const logger = require("firebase-functions/logger");

// For cost control, you can set the maximum number of containers that can be
// running at the same time. This helps mitigate the impact of unexpected
// traffic spikes by instead downgrading performance. This limit is a
// per-function limit. You can override the limit for each function using the
// `maxInstances` option in the function's options, e.g.
// `onRequest({ maxInstances: 5 }, (req, res) => { ... })`.
// NOTE: setGlobalOptions does not apply to functions using the v1 API. V1
// functions should each use functions.runWith({ maxInstances: 10 }) instead.
// In the v1 API, each function can only serve one request per container, so
// this will be the maximum concurrent request count.
setGlobalOptions({ maxInstances: 10 });

// Create and deploy your first functions
// https://firebase.google.com/docs/functions/get-started

// exports.helloWorld = onRequest((request, response) => {
//   logger.info("Hello logs!", {structuredData: true});
//   response.send("Hello from Firebase!");
// });
>>>>>>> 30fef52e967bdcb7869f2953d52f3ced20dfb625
