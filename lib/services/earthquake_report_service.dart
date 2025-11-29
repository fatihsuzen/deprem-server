import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:geolocator/geolocator.dart';

class EarthquakeReportService {
  final String serverUrl;

  EarthquakeReportService(this.serverUrl);

  Future<void> sendEarthquakeReport({
    required double magnitude,
    required DateTime timestamp,
    required Position position,
    required String deviceId,
  }) async {
    final data = {
      'userId': deviceId,
      'timestamp': timestamp.toIso8601String(),
      'location': {
        'latitude': position.latitude,
        'longitude': position.longitude,
        'accuracy': position.accuracy,
      },
      'sensorData': {
        'accelerationMagnitude': magnitude,
        'probabilityScore': 80, // örnek sabit değer
        'duration': 2.0, // örnek sabit değer
        'peakAcceleration': magnitude, // örnek sabit değer
      },
      'deviceInfo': {
        'platform': 'Android',
        'model': 'Test Device',
      },
    };
    print('[BG] Deprem raporu HTTP isteği başlatılıyor: $serverUrl');
    try {
      final response = await http.post(
        Uri.parse(serverUrl),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode(data),
      );
      print('[BG] HTTP response status: ${response.statusCode}');
      print('[BG] HTTP response body: ${response.body}');
      if (response.statusCode != 200) {
        print('[BG] Deprem raporu gönderilemedi! Status: ${response.statusCode}, Body: ${response.body}');
        throw Exception('Deprem raporu gönderilemedi: ${response.body}');
      } else {
        print('[BG] Deprem raporu başarıyla gönderildi!');
      }
    } catch (e) {
      print('[BG] Deprem raporu gönderim hatası: $e');
      rethrow;
    }
  }
}
