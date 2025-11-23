import 'dart:convert';
import 'package:http/http.dart' as http;
import 'auth_service.dart';

class FriendsService {
  static final FriendsService _instance = FriendsService._internal();
  factory FriendsService() => _instance;
  FriendsService._internal();

  final String baseUrl = 'http://188.132.202.24:3000/api/friends';
  final AuthService _authService = AuthService();

  Map<String, String> _getHeaders() {
    final userId = _authService.currentUserId;
    if (userId == null || userId.isEmpty) {
      throw Exception('Kullanıcı girişi yapılmamış');
    }

    return {
      'Content-Type': 'application/json',
      'x-firebase-uid': userId,
    };
  }

  // Get or create user profile
  Future<Map<String, dynamic>> getOrCreateProfile({
    required String email,
    required String displayName,
    String? photoURL,
  }) async {
    try {
      print('📋 Profile alınıyor/oluşturuluyor: $displayName');

      final userId = _authService.currentUserId;
      final response = await http.post(
        Uri.parse('$baseUrl/profile'),
        headers: {
          'Content-Type': 'application/json',
          'x-user-id': userId ?? '',
        },
        body: jsonEncode({
          'email': email,
          'displayName': displayName,
          'photoURL': photoURL,
        }),
      );

      print('📡 Profile API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        print('✅ Profile yüklendi: ${data['user']['shareCode']}');
        return data['user'];
      } else {
        print('❌ Profile hatası: ${response.body}');
        throw Exception('Profile yüklenemedi: ${response.statusCode}');
      }
    } catch (e) {
      print('❌ Profile exception: $e');
      rethrow;
    }
  }

  // Update user location
  Future<bool> updateLocation({
    required double latitude,
    required double longitude,
    String? address,
  }) async {
    try {
      print('📍 Konum güncelleniyor: $latitude, $longitude');

      final response = await http.put(
        Uri.parse('$baseUrl/location'),
        headers: _getHeaders(),
        body: jsonEncode({
          'latitude': latitude,
          'longitude': longitude,
          'address': address ?? '',
        }),
      );

      print('📡 Location API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        print('✅ Konum güncellendi');
        return true;
      } else {
        print('❌ Konum güncelleme hatası: ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Location update exception: $e');
      return false;
    }
  }

  // Get friends list
  Future<List<Map<String, dynamic>>> getFriends() async {
    try {
      print('👥 Arkadaş listesi alınıyor...');

      final response = await http.get(
        Uri.parse(baseUrl),
        headers: _getHeaders(),
      );

      print('📡 Friends API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        final friends = List<Map<String, dynamic>>.from(data['friends'] ?? []);
        print('✅ ${friends.length} arkadaş yüklendi');
        return friends;
      } else if (response.statusCode == 404) {
        print('ℹ️ Kullanıcı profili bulunamadı');
        return [];
      } else {
        print('❌ Friends list hatası: ${response.body}');
        return [];
      }
    } catch (e) {
      print('❌ Friends list exception: $e');
      return [];
    }
  }

  // Send friend request by share code
  Future<Map<String, dynamic>> sendFriendRequest(String shareCode) async {
    try {
      print('📤 Arkadaşlık isteği gönderiliyor: $shareCode');

      final response = await http.post(
        Uri.parse('$baseUrl/add-by-code'),
        headers: _getHeaders(),
        body: jsonEncode({
          'shareCode': shareCode.toUpperCase(),
        }),
      );

      print('📡 Friend Request API Response: ${response.statusCode}');

      final data = jsonDecode(response.body);

      if (response.statusCode == 200) {
        print(
            '✅ Arkadaşlık isteği gönderildi: ${data['targetUser']['displayName']}');
        return {
          'success': true,
          'message': data['message'],
          'targetUser': data['targetUser'],
        };
      } else {
        print('❌ Arkadaşlık isteği hatası: ${data['error']}');
        return {
          'success': false,
          'message': data['error'] ?? 'Bilinmeyen hata',
        };
      }
    } catch (e) {
      print('❌ Friend request exception: $e');
      return {
        'success': false,
        'message': 'Bağlantı hatası: $e',
      };
    }
  }

  // Get pending friend requests
  Future<Map<String, dynamic>> getFriendRequests() async {
    try {
      print('📬 Arkadaşlık istekleri alınıyor...');

      final response = await http.get(
        Uri.parse('$baseUrl/friend-requests'),
        headers: _getHeaders(),
      );

      print('📡 Friend Requests API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        print(
            '✅ Gelen: ${data['pendingCount']}, Gönderilen: ${data['sentCount']}');
        return {
          'pendingRequests':
              List<Map<String, dynamic>>.from(data['pendingRequests'] ?? []),
          'sentRequests':
              List<Map<String, dynamic>>.from(data['sentRequests'] ?? []),
        };
      } else {
        print('❌ Friend requests hatası: ${response.body}');
        return {
          'pendingRequests': [],
          'sentRequests': [],
        };
      }
    } catch (e) {
      print('❌ Friend requests exception: $e');
      return {
        'pendingRequests': [],
        'sentRequests': [],
      };
    }
  }

  // Accept friend request
  Future<bool> acceptFriendRequest(String requestId) async {
    try {
      print('✅ Arkadaşlık isteği kabul ediliyor: $requestId');

      final response = await http.put(
        Uri.parse('$baseUrl/friend-request/$requestId'),
        headers: _getHeaders(),
        body: jsonEncode({
          'action': 'accept',
        }),
      );

      print('📡 Accept Request API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        print('✅ Arkadaşlık isteği kabul edildi');
        return true;
      } else {
        print('❌ Kabul hatası: ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Accept request exception: $e');
      return false;
    }
  }

  // Reject friend request
  Future<bool> rejectFriendRequest(String requestId) async {
    try {
      print('❌ Arkadaşlık isteği reddediliyor: $requestId');

      final response = await http.put(
        Uri.parse('$baseUrl/friend-request/$requestId'),
        headers: _getHeaders(),
        body: jsonEncode({
          'action': 'reject',
        }),
      );

      print('📡 Reject Request API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        print('✅ Arkadaşlık isteği reddedildi');
        return true;
      } else {
        print('❌ Reddetme hatası: ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Reject request exception: $e');
      return false;
    }
  }

  // Remove friend
  Future<bool> removeFriend(String friendUID) async {
    try {
      print('🗑️ Arkadaş kaldırılıyor: $friendUID');

      final response = await http.delete(
        Uri.parse('$baseUrl/friend/$friendUID'),
        headers: _getHeaders(),
      );

      print('📡 Remove Friend API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        print('✅ Arkadaş kaldırıldı');
        return true;
      } else {
        print('❌ Arkadaş kaldırma hatası: ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Remove friend exception: $e');
      return false;
    }
  }

  // Ping server to update last seen
  Future<void> ping() async {
    try {
      await http.post(
        Uri.parse('$baseUrl/ping'),
        headers: _getHeaders(),
      );
    } catch (e) {
      // Sessizce başarısız ol
    }
  }
}
