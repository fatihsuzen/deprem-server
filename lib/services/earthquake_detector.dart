import 'package:sensors_plus/sensors_plus.dart';
import 'dart:math';
import 'dart:async';
import 'package:geolocator/geolocator.dart';
import 'earthquake_report_service.dart';
import 'screen_state_service.dart'; // EKLENDİ

/// Java algoritmasındaki eşik değerlerine sadık deprem algılama servisi
class EarthquakeDetector {
  // Eşik değerleri (Hassasiyet düşürüldü ve zaman penceresi daraltıldı)
  static const double shakeThreshold = 1.8; // m/s^2 (Daha güçlü sarsıntı eşiği)
  static const int minShakeCount = 3; // Art arda gereken sarsıntı sayısı
  static const int shakeWindowMs = 1000; // Sarsıntı zaman penceresi 1 saniyeye düşürüldü
  StreamSubscription<AccelerometerEvent>? _subscription;

  int _shakeCount = 0;
  DateTime? _lastShakeTime;
  bool _listening = false;

  void startListening({
    required String deviceId,
    required EarthquakeReportService reportService,
    void Function(String log)? onDetected,
  }) {
    if (_listening) return;
    _listening = true;
    _subscription =
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

          // YENİ KONTROL: Ekran açıksa rapor gönderme
          if (await ScreenStateService.isScreenOn()) {
            if (onDetected != null) {
              onDetected('Ekran açık olduğu için P2P raporu gönderilmedi.');
            }
            return; // Rapor göndermeyi durdur
          }

          // Deprem algılandı, konum al ve sunucuya gönder
          Position position = await Geolocator.getCurrentPosition(
              desiredAccuracy: LocationAccuracy.high);
          await reportService.sendEarthquakeReport(
            magnitude: delta,
            timestamp: now,
            position: position,
            deviceId: deviceId,
          );
          if (onDetected != null) {
            onDetected(
                '⚡ Deprem algılandı! Magnitude: ${delta.toStringAsFixed(2)}, Konum: ${position.latitude},${position.longitude}, Zaman: $now');
          }
        }
      }
    });
  }

  void stopListening() {
    _subscription?.cancel();
    _listening = false;
  }
}
