import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'dart:async';
import 'root.dart';

class SplashScreen extends StatefulWidget {
  @override
  _SplashScreenState createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    // Uygulama yüklenene kadar splash screen göster (5 saniye)
    Timer(Duration(seconds: 5), () {
      // Normal UI mode'a geri dön
      SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
      Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (_) => RootScreen()),
      );
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFFFF3333), // Uygulama kırmızısı
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
                  color: Colors.white,
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
                  color: Colors.white,
                ),
                SizedBox(height: 30),
                // Deprem Hattı yazısı
                Text(
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
