import 'package:flutter/material.dart';

class SplashScreen extends StatelessWidget {
  const SplashScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFFF393C),
      body: SafeArea(
        child: Center(
          child: Text(
            'Deprem Hattı',
            style: TextStyle(
              color: Colors.white,
              fontSize: 48,
              fontFamily: 'Gabarito',
              fontWeight: FontWeight.w600,
              height: 1.0,
              letterSpacing: -2.4,
            ),
            textAlign: TextAlign.center,
          ),
        ),
      ),
    );
  }
}
