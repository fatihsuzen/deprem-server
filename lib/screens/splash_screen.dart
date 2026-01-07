import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
// ...existing code...
import 'package:shared_preferences/shared_preferences.dart';
import '../l10n/app_localizations.dart';
import 'package:flutter_native_splash/flutter_native_splash.dart';
import 'dart:async';
import '../screens/earthquake_info_screen.dart';

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    FlutterNativeSplash.remove();
    Timer(const Duration(seconds: 2), () async {
      final prefs = await SharedPreferences.getInstance();
      final userId = prefs.getString('user_id');
      if (userId == null || userId.isEmpty) {
        // Kullanıcı giriş yapmamışsa login ekranına yönlendir
        Navigator.of(context).pushReplacementNamed('/login');
      } else {
        // Giriş yapılmışsa ana ekrana yönlendir
        Navigator.of(context).pushReplacementNamed('/home');
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    final locale = Localizations.localeOf(context);
    final isTurkish = locale.languageCode == 'tr';
    String splashImage = isTurkish
        ? 'assets/images/Splash_Screen-tr.png'
        : 'assets/images/Splash_Screen-eng.png';
    return Scaffold(
      backgroundColor: const Color(0xFFFF3A3D),
      body: Center(
        child: Image.asset(
          splashImage,
          width: 300,
          fit: BoxFit.contain,
        ),
      ),
    );
  }
}
