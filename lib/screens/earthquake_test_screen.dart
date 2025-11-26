import 'package:flutter/material.dart';
import 'package:sensors_plus/sensors_plus.dart';
import 'dart:math';

class EarthquakeTestScreen extends StatefulWidget {
  @override
  _EarthquakeTestScreenState createState() => _EarthquakeTestScreenState();
}

class _EarthquakeTestScreenState extends State<EarthquakeTestScreen> {
  String _status = 'Bekleniyor...';
  double _lastMagnitude = 0.0;
  DateTime? _lastDetection;
  static const double thresholdG = 0.2; // Eşik (g)
  static const int windowMs = 2000; // 2 saniye pencere
  List<double> _magnitudes = [];

  @override
  void initState() {
    super.initState();
    accelerometerEvents.listen((event) {
      double magnitude =
          sqrt(event.x * event.x + event.y * event.y + event.z * event.z) /
              9.81;
      _magnitudes.add(magnitude);
      if (_magnitudes.length > windowMs ~/ 20) {
        _magnitudes.removeAt(0);
      }
      if (_magnitudes.any((m) => m > thresholdG)) {
        if (_lastDetection == null ||
            DateTime.now().difference(_lastDetection!) >
                Duration(seconds: 10)) {
          _lastDetection = DateTime.now();
          setState(() {
            _lastMagnitude = magnitude;
            _status =
                'Deprem algılandı! Ivme: ${magnitude.toStringAsFixed(2)}g';
          });
          // Burada sunucuya iletim kodu eklenebilir
        }
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Deprem Algılama Testi')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(_status, style: TextStyle(fontSize: 24)),
            SizedBox(height: 24),
            Text('Son ivme: ${_lastMagnitude.toStringAsFixed(3)}g',
                style: TextStyle(fontSize: 18)),
            SizedBox(height: 24),
            Text('Telefonu sallayın veya titreşim oluşturun.',
                style: TextStyle(fontSize: 16)),
          ],
        ),
      ),
    );
  }
}
