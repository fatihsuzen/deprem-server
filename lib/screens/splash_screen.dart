import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_svg/flutter_svg.dart';
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
    // Uygulama yüklenene kadar splash screen göster (3 saniye)
    Timer(const Duration(seconds: 3), () {
      // Normal UI mode'a geri dön
      SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
      if (mounted) {
        Navigator.of(context).pushReplacementNamed('/home');
      }
    });
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
