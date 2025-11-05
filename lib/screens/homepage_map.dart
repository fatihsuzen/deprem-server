import 'package:flutter/material.dart';

class HomepageMap extends StatelessWidget {
  const HomepageMap({super.key});

  Widget _marker(Color color, {double size = 28}) {
    return Container(
      width: size,
      height: size,
      decoration: BoxDecoration(
        color: color,
        shape: BoxShape.circle,
        boxShadow: [
          BoxShadow(color: Colors.black.withOpacity(0.25), blurRadius: 5, offset: Offset(0, 4)),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;

    return Scaffold(
      body: Stack(
        children: [
          // Background image (placeholder)
          Positioned.fill(
            child: Image.network(
              'https://placehold.co/402x779',
              fit: BoxFit.cover,
            ),
          ),

          // Sample markers placed using fractions of screen
          Positioned(
            left: size.width * 0.3,
            top: size.height * 0.2,
            child: _marker(const Color(0xFFFF863A)),
          ),
          Positioned(
            left: size.width * 0.34,
            top: size.height * 0.2,
            child: _marker(const Color(0xFF1FD834)),
          ),
          Positioned(
            left: size.width * 0.48,
            top: size.height * 0.18,
            child: _marker(const Color(0xFF008CFF), size: 36),
          ),

          // Top bar
          Positioned(
            left: 0,
            right: 0,
            top: 0,
            child: Container(
              height: 110,
              color: const Color(0xFFFF393C),
              padding: const EdgeInsets.symmetric(horizontal: 12),
              alignment: Alignment.bottomCenter,
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  const Text('Deprem Haritası', style: TextStyle(color: Colors.white, fontSize: 20, fontWeight: FontWeight.w500)),
                  Row(children: const [Icon(Icons.search, color: Colors.white), SizedBox(width: 8)]),
                ],
              ),
            ),
          ),

          // Bottom action area
          Positioned(
            left: 0,
            right: 0,
            bottom: 0,
            child: Container(
              height: 110,
              color: Colors.white,
              child: Column(
                children: [
                  const Spacer(),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 45, vertical: 12),
                    child: ElevatedButton(
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color(0xFFFF393C),
                        minimumSize: const Size.fromHeight(45),
                        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(46)),
                      ),
                      onPressed: () {},
                      child: const Text('Deprem Bildir', style: TextStyle(fontSize: 16, fontWeight: FontWeight.w500)),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}
