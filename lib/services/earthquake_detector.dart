import 'package:sensors_plus/sensors_plus.dart';
import 'dart:math';
import 'package:geolocator/geolocator.dart';
import 'earthquake_report_service.dart';

/// Java algoritmasındaki eşik değerlerine sadık deprem algılama servisi
class EarthquakeDetector {
  // Eşik değerleri (Java algoritmasından alınmıştır)
  static const double shakeThreshold = 2.5; // m/s^2
  static const int minShakeCount = 3; // art arda kaç sarsıntı olmalı
  static const int shakeWindowMs = 2000; // sarsıntı aralığı (ms)

  int _shakeCount = 0;
  DateTime? _lastShakeTime;
  bool _listening = false;

  void startListening({
    required String deviceId,
    required EarthquakeReportService reportService,
  }) {
    if (_listening) return;
    _listening = true;
    accelerometerEvents.listen((AccelerometerEvent event) async {
      double magnitude = sqrt(
        event.x * event.x + event.y * event.y + event.z * event.z,
      );
      double delta = (magnitude - 9.8).abs();
      if (delta > shakeThreshold) {
        DateTime now = DateTime.now();
        if (_lastShakeTime == null ||
            now.difference(_lastShakeTime!).inMilliseconds > shakeWindowMs) {
          _shakeCount = 1;
        } else {
          _shakeCount++;
        }
        _lastShakeTime = now;
        if (_shakeCount >= minShakeCount) {
          _shakeCount = 0;
          // Deprem algılandı, konum al ve sunucuya gönder
          Position position = await Geolocator.getCurrentPosition(
              desiredAccuracy: LocationAccuracy.high);
          await reportService.sendEarthquakeReport(
            magnitude: delta,
            timestamp: now,
            position: position,
            deviceId: deviceId,
          );
        }
      }
    });
  }
}
