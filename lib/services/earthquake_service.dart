import 'dart:convert';
import 'package:http/http.dart' as http;

class EarthquakeService {
  static const String baseUrl = 'http://188.132.202.24:3000/api/earthquakes';

  // Singleton pattern
  static final EarthquakeService _instance = EarthquakeService._internal();
  factory EarthquakeService() => _instance;
  EarthquakeService._internal();

  /// Son depremleri getir (Global - konum bazlı sıralama)
  ///
  /// [limit] - Kaç deprem verisi getirileceği (varsayılan: 100)
  /// [minMagnitude] - Minimum büyüklük filtresi (varsayılan: 2.5)
  /// [period] - Zaman aralığı: 'hour', 'day', 'week', 'month'
  /// [userLat] - Kullanıcı enlem (konuma göre sıralama için)
  /// [userLon] - Kullanıcı boylam (konuma göre sıralama için)
  /// [radius] - Yarıçap filtresi (km)
  /// [region] - Bölge filtresi: 'Turkey', 'Japan', 'California', vb.
  Future<List<Map<String, dynamic>>> getRecentEarthquakes({
    int limit = 100,
    double minMagnitude = 2.5,
    String period = 'day',
    double? userLat,
    double? userLon,
    double? radius,
    String? region,
  }) async {
    try {
      final queryParams = {
        'limit': limit.toString(),
        'minMagnitude': minMagnitude.toString(),
        'period': period,
      };

      if (userLat != null) queryParams['lat'] = userLat.toString();
      if (userLon != null) queryParams['lon'] = userLon.toString();
      if (radius != null) queryParams['radius'] = radius.toString();
      if (region != null) queryParams['region'] = region;

      final uri = Uri.parse(baseUrl).replace(queryParameters: queryParams);

      print('📡 Deprem verileri isteniyor: $uri');

      final response = await http.get(
        uri,
        headers: {'Content-Type': 'application/json'},
      ).timeout(const Duration(seconds: 20));

      if (response.statusCode == 200) {
        final data = json.decode(response.body);

        if (data['success'] == true && data['earthquakes'] != null) {
          final earthquakes =
              List<Map<String, dynamic>>.from(data['earthquakes']);

          print('✅ ${earthquakes.length} deprem verisi alındı');

          // İstatistikleri logla
          if (data['stats'] != null) {
            print('📊 İstatistikler: ${data['stats']}');
          }

          return earthquakes;
        } else {
          print('⚠️ API başarısız yanıt döndü');
          return [];
        }
      } else {
        print('❌ API hatası: ${response.statusCode}');
        return [];
      }
    } catch (e) {
      print('❌ Deprem verisi çekme hatası: $e');
      return [];
    }
  }

  /// En son depremi getir
  ///
  /// [sortBy] - Sıralama: 'time', 'magnitude', 'distance'
  /// [userLat] - Kullanıcı enlem (distance sıralaması için gerekli)
  /// [userLon] - Kullanıcı boylam (distance sıralaması için gerekli)
  Future<Map<String, dynamic>?> getLatestEarthquake({
    String sortBy = 'time',
    double? userLat,
    double? userLon,
  }) async {
    try {
      final queryParams = {'sortBy': sortBy};

      if (userLat != null) queryParams['lat'] = userLat.toString();
      if (userLon != null) queryParams['lon'] = userLon.toString();

      final uri =
          Uri.parse('$baseUrl/latest').replace(queryParameters: queryParams);

      print('📡 Son deprem isteniyor: $uri');

      final response = await http.get(
        uri,
        headers: {'Content-Type': 'application/json'},
      ).timeout(const Duration(seconds: 15));

      if (response.statusCode == 200) {
        final data = json.decode(response.body);

        if (data['success'] == true && data['earthquake'] != null) {
          print('✅ Son deprem alındı: ${data['earthquake']['place']}');
          return Map<String, dynamic>.from(data['earthquake']);
        }
      }

      return null;
    } catch (e) {
      print('❌ Son deprem çekme hatası: $e');
      return null;
    }
  }

  /// Önemli depremleri getir (M4.5+, son 7 gün)
  Future<List<Map<String, dynamic>>> getSignificantEarthquakes() async {
    try {
      final uri = Uri.parse('$baseUrl/significant');

      print('📡 Önemli depremler isteniyor...');

      final response = await http.get(
        uri,
        headers: {'Content-Type': 'application/json'},
      ).timeout(const Duration(seconds: 15));

      if (response.statusCode == 200) {
        final data = json.decode(response.body);

        if (data['success'] == true && data['earthquakes'] != null) {
          final earthquakes =
              List<Map<String, dynamic>>.from(data['earthquakes']);
          print('✅ ${earthquakes.length} önemli deprem alındı');
          return earthquakes;
        }
      }

      return [];
    } catch (e) {
      print('❌ Önemli depremler çekme hatası: $e');
      return [];
    }
  }

  /// Belirli bir bölgedeki depremleri getir
  Future<List<Map<String, dynamic>>> getRegionEarthquakes(
    String region, {
    int limit = 50,
    double minMagnitude = 2.0,
  }) async {
    try {
      final queryParams = {
        'limit': limit.toString(),
        'minMagnitude': minMagnitude.toString(),
      };

      final uri = Uri.parse('$baseUrl/region/$region')
          .replace(queryParameters: queryParams);

      print('📡 $region bölgesi depremleri isteniyor...');

      final response = await http.get(
        uri,
        headers: {'Content-Type': 'application/json'},
      ).timeout(const Duration(seconds: 15));

      if (response.statusCode == 200) {
        final data = json.decode(response.body);

        if (data['success'] == true && data['earthquakes'] != null) {
          final earthquakes =
              List<Map<String, dynamic>>.from(data['earthquakes']);
          print('✅ ${earthquakes.length} deprem alındı ($region)');
          return earthquakes;
        }
      }

      return [];
    } catch (e) {
      print('❌ Bölge depremleri çekme hatası: $e');
      return [];
    }
  }

  /// Mevcut bölgeleri listele
  Future<List<String>> getAvailableRegions() async {
    try {
      final uri = Uri.parse('$baseUrl/regions');

      final response = await http.get(
        uri,
        headers: {'Content-Type': 'application/json'},
      ).timeout(const Duration(seconds: 10));

      if (response.statusCode == 200) {
        final data = json.decode(response.body);

        if (data['success'] == true && data['regions'] != null) {
          return List<String>.from(data['regions']);
        }
      }

      return [];
    } catch (e) {
      print('❌ Bölge listesi çekme hatası: $e');
      return [];
    }
  }

  /// Deprem rengini büyüklüğe göre belirle
  static int getColorForMagnitude(double magnitude) {
    if (magnitude >= 7.0) return 0xFF8B0000; // Koyu kırmızı - Great
    if (magnitude >= 6.0) return 0xFFFF0000; // Kırmızı - Major
    if (magnitude >= 5.0) return 0xFFFF4500; // Turuncu-kırmızı - Strong
    if (magnitude >= 4.0) return 0xFFFF8C00; // Koyu turuncu - Moderate
    if (magnitude >= 3.0) return 0xFFFFA500; // Turuncu - Light
    if (magnitude >= 2.0) return 0xFFFFD700; // Altın - Minor
    return 0xFF90EE90; // Açık yeşil - Micro
  }

  /// Zamanı formatla (örn: "5 dk önce", "2 saat önce")
  static String formatTimeAgo(int minutesAgo) {
    if (minutesAgo < 1) return 'Now';
    if (minutesAgo < 60) return '${minutesAgo}m ago';

    final hours = minutesAgo ~/ 60;
    if (hours < 24) return '${hours}h ago';

    final days = hours ~/ 24;
    if (days < 7) return '${days}d ago';

    final weeks = days ~/ 7;
    return '${weeks}w ago';
  }

  /// Derinliği formatla
  static String formatDepth(double depth) {
    return '${depth.toStringAsFixed(1)} km';
  }

  /// Mesafeyi formatla
  static String formatDistance(double distance) {
    if (distance < 1) return '${(distance * 1000).toStringAsFixed(0)} m';
    if (distance < 10) return '${distance.toStringAsFixed(1)} km';
    return '${distance.toStringAsFixed(0)} km';
  }
}
