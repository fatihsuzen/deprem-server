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
      'magnitude': magnitude,
      'timestamp': timestamp.toIso8601String(),
      'latitude': position.latitude,
      'longitude': position.longitude,
      'accuracy': position.accuracy,
      'deviceId': deviceId,
    };
    final response = await http.post(
      Uri.parse(serverUrl),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(data),
    );
    if (response.statusCode != 200) {
      throw Exception('Deprem raporu gönderilemedi: ${response.body}');
    }
  }
}
