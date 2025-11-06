import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'login_screen.dart';
import 'demo_screen.dart';

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    _checkLoginStatus();
  }

  Future<void> _checkLoginStatus() async {
    await Future.delayed(const Duration(seconds: 3));
    
    if (!mounted) return;
    
    final prefs = await SharedPreferences.getInstance();
    final userId = prefs.getString('user_id');
    
    if (userId != null && userId.isNotEmpty) {
      // Kullanıcı giriş yapmış, ana sayfaya git
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(
          builder: (context) => const DemoScreen(),
        ),
      );
    } else {
      // Kullanıcı giriş yapmamış, login sayfasına git
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(
          builder: (context) => const LoginScreen(),
        ),
      );
    }
  }



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SizedBox(
        width: double.infinity,
        height: double.infinity,
        child: Image.asset(
          'assets/images/Splash_Screen.png',
          fit: BoxFit.cover, // Tam ekran, kırpmadan kapla
        ),
      ),
    );
  }
}


