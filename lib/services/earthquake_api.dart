import 'dart:convert';
import 'package:http/http.dart' as http;

class EarthquakeApi {
  static const String baseUrl = 'http://188.132.202.24:3000/api/earthquakes';

  // Fetch recent earthquakes with optional filters
  static Future<List<Map<String, dynamic>>> fetchRecent({
    int limit = 50,
    double minMagnitude = 0,
    DateTime? since,
  }) async {
    final params = <String, String>{
      'limit': limit.toString(),
    };
    if (minMagnitude > 0) params['minMagnitude'] = minMagnitude.toString();
    if (since != null) params['since'] = since.toIso8601String();

    final uri = Uri.parse(baseUrl).replace(queryParameters: params);

    final res = await http.get(uri).timeout(const Duration(seconds: 8));

    if (res.statusCode == 200) {
      final body = json.decode(res.body);
      if (body['success'] == true) {
        return List<Map<String, dynamic>>.from(body['earthquakes'] ?? []);
      }
      return [];
    } else {
      throw Exception('API Error: ${res.statusCode}');
    }
  }
}
