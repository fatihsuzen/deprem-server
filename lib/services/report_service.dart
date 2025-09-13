import 'dart:convert';
import 'dart:math';
// import 'package:http/http.dart' as http; // TODO: Server kurulduğunda uncomment edilecek

class ReportService {
  static const String baseUrl =
      'https://your-server.com/api'; // TODO: Gerçek server URL'i eklenecek

  // Singleton pattern
  static final ReportService _instance = ReportService._internal();
  factory ReportService() => _instance;
  ReportService._internal();

  // Şehirdeki 24 saat içindeki rapor sayısını al
  Future<int> getCityReportCount(
      String cityName, double latitude, double longitude) async {
    try {
      // TODO: Server kurulduğunda gerçek API endpoint'i kullanılacak
      // Şimdilik mock data döndürüyoruz

      /*
      final response = await http.get(
        Uri.parse('$baseUrl/reports/city-count'),
        headers: {
          'Content-Type': 'application/json',
        },
      ).timeout(const Duration(seconds: 10));
      
      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        return data['count'] ?? 0;
      }
      */

      // Mock data - şehre göre farklı sayılar
      await Future.delayed(
          const Duration(milliseconds: 500)); // Network delay simülasyonu

      if (cityName.toLowerCase().contains('istanbul')) {
        return 2150;
      } else if (cityName.toLowerCase().contains('ankara')) {
        return 850;
      } else if (cityName.toLowerCase().contains('izmir')) {
        return 650;
      } else if (cityName.toLowerCase().contains('bursa')) {
        return 420;
      } else if (cityName.toLowerCase().contains('antalya')) {
        return 380;
      } else {
        // Diğer şehirler için koordinata göre hesaplama
        return _calculateMockReportCount(latitude, longitude);
      }
    } catch (e) {
      print('Rapor sayısı alınamadı: $e');
      return 0;
    }
  }

  // Konum bilgisinden şehir ismini al (Geocoding)
  Future<String> getCityName(double latitude, double longitude) async {
    try {
      // TODO: Server kurulduğunda gerçek geocoding API kullanılacak
      // Şimdilik mock data

      await Future.delayed(const Duration(milliseconds: 300));

      // Türkiye'nin büyük şehirlerine yakınlık kontrolü
      if (_isNearCity(latitude, longitude, 41.0082, 28.9784)) {
        return 'İstanbul';
      } else if (_isNearCity(latitude, longitude, 39.9334, 32.8597)) {
        return 'Ankara';
      } else if (_isNearCity(latitude, longitude, 38.4237, 27.1428)) {
        return 'İzmir';
      } else if (_isNearCity(latitude, longitude, 40.1826, 29.0665)) {
        return 'Bursa';
      } else if (_isNearCity(latitude, longitude, 36.8969, 30.7133)) {
        return 'Antalya';
      } else {
        return 'Türkiye';
      }
    } catch (e) {
      print('Şehir bilgisi alınamadı: $e');
      return 'Bilinmeyen Şehir';
    }
  }

  // Rapor gönder
  Future<bool> submitReport({
    required int intensityLevel,
    required double latitude,
    required double longitude,
    required String cityName,
  }) async {
    try {
      // TODO: Server kurulduğunda gerçek API endpoint'i kullanılacak

      /*
      final response = await http.post(
        Uri.parse('$baseUrl/reports/submit'),
        headers: {
          'Content-Type': 'application/json',
        },
        body: jsonEncode({
          'intensity': intensityLevel,
          'latitude': latitude,
          'longitude': longitude,
          'city': cityName,
          'timestamp': DateTime.now().toIso8601String(),
        }),
      ).timeout(const Duration(seconds: 10));
      
      return response.statusCode == 200;
      */

      // Mock success response
      await Future.delayed(const Duration(seconds: 1));
      print('Rapor gönderildi: Şiddet $intensityLevel, Şehir: $cityName');
      return true;
    } catch (e) {
      print('Rapor gönderilemedi: $e');
      return false;
    }
  }

  // İki koordinat arasındaki mesafeyi kontrol et (yaklaşık)
  bool _isNearCity(double lat1, double lon1, double lat2, double lon2,
      {double thresholdKm = 50}) {
    final distance = _calculateDistance(lat1, lon1, lat2, lon2);
    return distance <= thresholdKm;
  }

  // Haversine formülü ile mesafe hesapla
  double _calculateDistance(
      double lat1, double lon1, double lat2, double lon2) {
    const double earthRadius = 6371; // km
    final double dLat = _degreesToRadians(lat2 - lat1);
    final double dLon = _degreesToRadians(lon2 - lon1);

    final double a = sin(dLat / 2) * sin(dLat / 2) +
        cos(_degreesToRadians(lat1)) *
            cos(_degreesToRadians(lat2)) *
            sin(dLon / 2) *
            sin(dLon / 2);
    final double c = 2 * atan2(sqrt(a), sqrt(1 - a));

    return earthRadius * c;
  }

  double _degreesToRadians(double degrees) {
    return degrees * (pi / 180);
  }

  // Mock rapor sayısı hesapla (koordinata göre)
  int _calculateMockReportCount(double latitude, double longitude) {
    // Basit bir algoritma: koordinat değerlerine göre rapor sayısı
    final int base = ((latitude + longitude).abs() * 100).round();
    return (base % 1000) + 50; // 50-1050 arası bir sayı
  }
}
