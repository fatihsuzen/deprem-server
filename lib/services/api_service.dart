import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:deprem_app/services/auth_service.dart';

class ApiService {
  static final ApiService _instance = ApiService._internal();
  factory ApiService() => _instance;
  ApiService._internal();

  final AuthService _authService = AuthService();
  static const String _baseUrl = 'http://188.132.202.24:3000/api';

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

  // Arkadaş isteklerini getir
  Future<Map<String, dynamic>> getFriendRequests() async {
    try {
      if (!_authService.isLoggedIn) return {'pendingRequests': []};

      final response = await http.get(
        Uri.parse('$_baseUrl/friends/friend-requests'),
        headers: await _getHeaders(),
      );

      if (response.statusCode == 200) {
        return jsonDecode(response.body);
      } else {
        print('❌ Arkadaş istekleri hatası: ${response.statusCode}');
        return {'pendingRequests': []};
      }
    } catch (e) {
      print('❌ Arkadaş istekleri isteği hatası: $e');
      return {'pendingRequests': []};
    }
  }

  // Arkadaş isteği gönder
  Future<bool> sendFriendRequest(String shareCode, {String? message}) async {
    try {
      if (!_authService.isLoggedIn) return false;

      final response = await http.post(
        Uri.parse('$_baseUrl/friends/add-by-code'),
        headers: await _getHeaders(),
        body: jsonEncode({
          'shareCode': shareCode,
          'message': message ?? 'Arkadaş olmak istiyor',
        }),
      );

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        print('✅ Arkadaş isteği gönderildi: ${data['message']}');
        return true;
      } else {
        print('❌ Arkadaş isteği gönderme hatası: ${response.statusCode}');
        return false;
      }
    } catch (e) {
      print('❌ Arkadaş isteği gönderme isteği hatası: $e');
      return false;
    }
  }

  // Arkadaş isteğini yanıtla
  Future<bool> respondToFriendRequest(String requestId, bool accept) async {
    try {
      if (!_authService.isLoggedIn) return false;

      final response = await http.put(
        Uri.parse('$_baseUrl/friends/friend-request/$requestId'),
        headers: await _getHeaders(),
        body: jsonEncode({
          'action': accept ? 'accept' : 'reject',
        }),
      );

      return response.statusCode == 200;
    } catch (e) {
      print('❌ Arkadaş isteği yanıtlama hatası: $e');
      return false;
    }
  }

  // Arkadaşı kaldır
  Future<bool> removeFriend(String friendId) async {
    try {
      if (!_authService.isLoggedIn) return false;

      final response = await http.delete(
        Uri.parse('$_baseUrl/friends/$friendId'),
        headers: await _getHeaders(),
      );

      return response.statusCode == 200;
    } catch (e) {
      print('❌ Arkadaş kaldırma hatası: $e');
      return false;
    }
  }
}
