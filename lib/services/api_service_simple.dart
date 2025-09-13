import 'dart:convert';
import 'package:http/http.dart' as http;
import 'auth_service.dart';

class ApiService {
  static final ApiService _instance = ApiService._internal();
  factory ApiService() => _instance;
  ApiService._internal();

  final AuthService _authService = AuthService();
  static const String _baseUrl = 'http://192.168.1.104:3000/api';

  // Genel başlık oluşturucu
  Future<Map<String, String>> _getHeaders() async {
    final headers = {
      'Content-Type': 'application/json',
    };

    if (_authService.isLoggedIn) {
      headers['x-firebase-uid'] = _authService.userId!;
    }

    return headers;
  }

  // Kullanıcı kaydı/güncelleme
  Future<Map<String, dynamic>?> createOrUpdateUser() async {
    try {
      if (!_authService.isLoggedIn) {
        print('❌ Kullanıcı giriş yapmamış, kayıt yapılamıyor');
        return null;
      }

      final userData = {
        'firebaseUid': _authService.userId,
        'email': _authService.userEmail,
        'displayName': _authService.userName,
        'photoURL': _authService.userPhotoUrl,
      };

      final response = await http.post(
        Uri.parse('$_baseUrl/register'),
        headers: await _getHeaders(),
        body: jsonEncode(userData),
      );

      if (response.statusCode == 200 || response.statusCode == 201) {
        return jsonDecode(response.body);
      } else {
        print('❌ Kullanıcı kayıt hatası: ${response.statusCode}');
        return null;
      }
    } catch (e) {
      print('❌ Kullanıcı kayıt isteği hatası: $e');
      return null;
    }
  }

  // Arkadaş listesi getir
  Future<List<Map<String, dynamic>>> getFriends() async {
    try {
      if (!_authService.isLoggedIn) return [];

      final response = await http.get(
        Uri.parse('$_baseUrl/friends'),
        headers: await _getHeaders(),
      );

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        return List<Map<String, dynamic>>.from(data['friends'] ?? []);
      } else {
        print('❌ Arkadaş listesi hatası: ${response.statusCode}');
        return [];
      }
    } catch (e) {
      print('❌ Arkadaş listesi isteği hatası: $e');
      return [];
    }
  }

  // Konum güncelle
  Future<bool> updateLocation(double latitude, double longitude) async {
    try {
      if (!_authService.isLoggedIn) return false;

      final response = await http.post(
        Uri.parse('$_baseUrl/location'),
        headers: await _getHeaders(),
        body: jsonEncode({
          'latitude': latitude,
          'longitude': longitude,
        }),
      );

      return response.statusCode == 200;
    } catch (e) {
      print('❌ Konum güncelleme hatası: $e');
      return false;
    }
  }
}
