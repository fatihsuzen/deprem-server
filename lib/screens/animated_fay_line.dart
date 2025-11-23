import 'package:flutter/material.dart';
import 'package:latlong2/latlong.dart' show LatLng;
import 'dart:ui';
import 'dart:ui';
import 'dart:math';

class AnimatedFayLine extends StatefulWidget {
  final List<LatLng> points;
  const AnimatedFayLine({Key? key, required this.points}) : super(key: key);

  @override
  State<AnimatedFayLine> createState() => _AnimatedFayLineState();
}

class _AnimatedFayLineState extends State<AnimatedFayLine>
    with SingleTickerProviderStateMixin {
  late AnimationController _controller;
  late Animation<double> _animation;

  @override
  void initState() {
    super.initState();
    _controller = AnimationController(
      vsync: this,
      duration: const Duration(seconds: 3),
    )..repeat(reverse: false);
    _animation = CurvedAnimation(parent: _controller, curve: Curves.easeInOut);
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return AnimatedBuilder(
      animation: _animation,
      builder: (context, child) {
        return CustomPaint(
          painter: FayLinePainter(
            widget.points,
            _animation.value,
          ),
        );
      },
    );
  }
}

class FayLinePainter extends CustomPainter {
  final List<LatLng> points;
  final double animValue;
  FayLinePainter(this.points, this.animValue);

  @override
  void paint(Canvas canvas, Size size) {
    if (points.length < 2) return;

    // Ekran koordinatına dönüştürmek için basit bir projeksiyon (örnek)
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

    // Gradient
    final gradient = LinearGradient(
      colors: [
        Colors.redAccent,
        Colors.orangeAccent,
        Colors.yellowAccent,
        Colors.redAccent,
      ],
      stops: [0.0, animValue, animValue + 0.2, 1.0],
    );

    final path = Path();
    path.moveTo(offsets.first.dx, offsets.first.dy);
    for (var o in offsets.skip(1)) {
      path.lineTo(o.dx, o.dy);
    }

    // Glow efekti
    final glowPaint = Paint()
      ..color = Colors.redAccent.withOpacity(0.4)
      ..strokeWidth = 10
      ..style = PaintingStyle.stroke
      ..maskFilter = MaskFilter.blur(BlurStyle.normal, 8);
    canvas.drawPath(path, glowPaint);

    // Gölge efekti
    final shadowPaint = Paint()
      ..color = Colors.black.withOpacity(0.2)
      ..strokeWidth = 8
      ..style = PaintingStyle.stroke;
    // Gölge için path'i offset ile çizmek yerine, path'i tekrar çiziyoruz (daha basit)
    canvas.save();
    canvas.translate(2, 2);
    canvas.drawPath(path, shadowPaint);
    canvas.restore();

    // Gradient çizgi
    final rect = Rect.fromLTWH(0, 0, w, h);
    final gradientPaint = Paint()
      ..shader = gradient.createShader(rect)
      ..strokeWidth = 5
      ..style = PaintingStyle.stroke;
    canvas.drawPath(path, gradientPaint);

    // Ana çizgi (daha opak ve kalın)
    final mainPaint = Paint()
      ..color = Colors.red.withOpacity(0.95)
      ..strokeWidth = 3
      ..style = PaintingStyle.stroke;
    canvas.drawPath(path, mainPaint);
  }

  @override
  bool shouldRepaint(covariant FayLinePainter oldDelegate) {
    return oldDelegate.animValue != animValue || oldDelegate.points != points;
  }
}
