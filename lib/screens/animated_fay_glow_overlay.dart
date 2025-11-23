import 'package:flutter/material.dart';
import 'package:latlong2/latlong.dart' show LatLng;
import 'dart:math';
import 'dart:ui';

class AnimatedFayGlowOverlay extends StatefulWidget {
  final List<LatLng> points;
  const AnimatedFayGlowOverlay({Key? key, required this.points})
      : super(key: key);

  @override
  State<AnimatedFayGlowOverlay> createState() => _AnimatedFayGlowOverlayState();
}

class _AnimatedFayGlowOverlayState extends State<AnimatedFayGlowOverlay>
    with SingleTickerProviderStateMixin {
  late AnimationController _controller;
  late Animation<double> _animation;

  @override
  void initState() {
    super.initState();
    _controller = AnimationController(
      vsync: this,
      duration: const Duration(seconds: 4),
    )..repeat();
    _animation = CurvedAnimation(parent: _controller, curve: Curves.easeInOut);
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return IgnorePointer(
      child: AnimatedBuilder(
        animation: _animation,
        builder: (context, child) {
          return CustomPaint(
            painter: FayGlowPainter(widget.points, _animation.value),
            size: Size.infinite,
          );
        },
      ),
    );
  }
}

class FayGlowPainter extends CustomPainter {
  final List<LatLng> points;
  final double animValue;
  FayGlowPainter(this.points, this.animValue);

  @override
  void paint(Canvas canvas, Size size) {
    if (points.length < 2) return;

    // Basit ekran projeksiyonu (örnek, harita ile tam uyumlu olmayabilir)
    double minLat = points.map((p) => p.latitude).reduce(min);
    double maxLat = points.map((p) => p.latitude).reduce(max);
    double minLon = points.map((p) => p.longitude).reduce(min);
    double maxLon = points.map((p) => p.longitude).reduce(max);
    double w = size.width;
    double h = size.height;
    List<Offset> offsets = points.map((p) {
      double x = ((p.longitude - minLon) / (maxLon - minLon + 0.0001)) * w;
      double y = h - ((p.latitude - minLat) / (maxLat - minLat + 0.0001)) * h;
      return Offset(x, y);
    }).toList();

    // Animasyonlu glow noktası fay hattı boyunca hareket ediyor
    int segCount = offsets.length - 1;
    double totalLength = 0;
    List<double> segLengths = [];
    for (int i = 0; i < segCount; i++) {
      double l = (offsets[i + 1] - offsets[i]).distance;
      segLengths.add(l);
      totalLength += l;
    }
    double glowPos = animValue * totalLength;
    Offset? glowOffset;
    double acc = 0;
    for (int i = 0; i < segCount; i++) {
      if (acc + segLengths[i] >= glowPos) {
        double t = (glowPos - acc) / segLengths[i];
        glowOffset = Offset.lerp(offsets[i], offsets[i + 1], t);
        break;
      }
      acc += segLengths[i];
    }
    if (glowOffset != null) {
      final glowPaint = Paint()
        ..color = Colors.yellowAccent.withOpacity(0.7)
        ..maskFilter = MaskFilter.blur(BlurStyle.normal, 16);
      canvas.drawCircle(glowOffset, 18, glowPaint);
      final corePaint = Paint()..color = Colors.orangeAccent.withOpacity(0.9);
      canvas.drawCircle(glowOffset, 8, corePaint);
    }
  }

  @override
  bool shouldRepaint(covariant FayGlowPainter oldDelegate) {
    return oldDelegate.animValue != animValue || oldDelegate.points != points;
  }
}
