import 'package:flutter/material.dart';
import 'package:deprem_app/screens/home_screen.dart';

void main() {
  runApp(const DepremApp());
}

class DepremApp extends StatelessWidget {
  const DepremApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Deprem Bildirim Uygulaması',
      theme: ThemeData(
        primarySwatch: Colors.red,
        useMaterial3: true,
      ),
      home: const HomeScreen(),
      debugShowCheckedModeBanner: false,
    );
  }
}
