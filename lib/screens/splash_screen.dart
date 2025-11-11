import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'dart:async';

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    // Uygulama yüklenene kadar splash screen göster (1.5 saniye - optimize edildi)
    Timer(const Duration(milliseconds: 1500), () {
      // Normal UI mode'a geri dön
      SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
      _checkLoginStatus();
    });
  }

  Future<void> _checkLoginStatus() async {
    if (!mounted) return;

    try {
      final prefs = await SharedPreferences.getInstance();
      final userId = prefs.getString('user_id');
      final userName = prefs.getString('user_name');
      final userEmail = prefs.getString('user_email');

      if (mounted) {
        // Kullanıcı bilgileri varsa home'a, yoksa login'e git
        if (userId != null && userId.isNotEmpty) {
          print('✅ Kullanıcı giriş yapmış: $userName ($userEmail)');
          Navigator.of(context).pushReplacementNamed('/home');
        } else {
          print('ℹ️ Kullanıcı giriş yapmamış, login ekranına yönlendiriliyor');
          Navigator.of(context).pushReplacementNamed('/login');
        }
      }
    } catch (e) {
      print('❌ Login kontrolü hatası: $e');
      if (mounted) {
        Navigator.of(context).pushReplacementNamed('/login');
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFFF3A3D), // Uygulama kırmızısı
      body: Stack(
        children: [
          // Arka planda büyük, soluk logo - ekran dışına taşan, sağa kaydırılmış
          Positioned(
            left: 150,
            child: Center(
              child: Opacity(
                opacity: 0.05,
                child: SvgPicture.asset(
                  'assets/Icons/Logo.svg',
                  width: MediaQuery.of(context).size.width * 2.5,
                  height: MediaQuery.of(context).size.width * 2.5,
                  colorFilter:
                      const ColorFilter.mode(Colors.white, BlendMode.srcIn),
                ),
              ),
            ),
          ),
          // Ön planda merkez içerik
          Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                // Ana logo
                SvgPicture.asset(
                  'assets/Icons/Logo.svg',
                  width: 180,
                  height: 180,
                  colorFilter:
                      const ColorFilter.mode(Colors.white, BlendMode.srcIn),
                ),
                const SizedBox(height: 30),
                // Deprem Hattı yazısı
                const Text(
                  'Deprem Hattı',
                  style: TextStyle(
                    fontSize: 36,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                    letterSpacing: 1.2,
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
