import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();

  // Sign in anonymously (Spark Plan safe)
  await FirebaseAuth.instance.signInAnonymously();

  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Water Level Monitoring",
      theme: ThemeData(primarySwatch: Colors.blue),
      home: WaterLevelScreen(),
    );
  }
}

class WaterLevelScreen extends StatelessWidget {
  final String deviceId = "device1"; // Example device

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Water Level Monitoring")),
      body: StreamBuilder<DocumentSnapshot>(
        stream: FirebaseFirestore.instance
            .collection("waterLevel")
            .doc(deviceId)
            .snapshots(),
        builder: (context, snapshot) {
          if (!snapshot.hasData) {
            return Center(child: CircularProgressIndicator());
          }

          var data = snapshot.data!.data() as Map<String, dynamic>?;
          if (data == null) return Center(child: Text("No data available"));

          int level = data["level"] ?? 0;

          // Decide status
          String status;
          Color color;
          if (level < 20) {
            status = "⚠️ Low water level!";
            color = Colors.red;
          } else if (level > 80) {
            status = "⚠️ Tank almost full!";
            color = Colors.orange;
          } else {
            status = "✅ Normal";
            color = Colors.green;
          }

          return Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text("Water Level: $level%",
                    style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold)),
                SizedBox(height: 20),
                Text(status, style: TextStyle(fontSize: 22, color: color)),
              ],
            ),
          );
        },
      ),
    );
  }
}
