import 'dart:convert';
import 'package:http/http.dart' as http;
import 'auth_service.dart';

// Gerçek cihazlar için arkadaş servisi
class FriendsService {
  static final FriendsService _instance = FriendsService._internal();
  factory FriendsService() => _instance;
  FriendsService._internal();

  final AuthService _authService = AuthService();
  // VDS Server URL - Production IP
  static const String baseUrl =
      'http://188.132.202.24:3000/api'; // VDS IP adresi

  // Local test için (geliştirme):
  // static const String baseUrl = 'http://192.168.1.104:3000/api'; // WiFi IP

  // Arkadaş listesi
  List<Map<String, dynamic>> _friends = [];
  List<Map<String, dynamic>> _friendRequests = [];

  List<Map<String, dynamic>> get friends => _friends;
  List<Map<String, dynamic>> get pendingRequests => _friendRequests;

  int get friendCount => _friends.length;
  int get pendingRequestCount => _friendRequests.length;

  // Server'dan arkadaş listesini al
  Future<void> fetchFriends() async {
    print('👥 Arkadaş listesi alınıyor...');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      print('🔍 Current User ID: $userId');
      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return;
      }

      final url = '$baseUrl/friends';
      print('🌐 API URL: $url');
      print('🔑 Headers: x-firebase-uid = $userId');

      final response = await http.get(
        Uri.parse(url),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
      );

      print('📡 API Response: ${response.statusCode}');
      print('📄 Response Body: ${response.body}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        print('📊 Parsed Data: $data');
        _friends = List<Map<String, dynamic>>.from(data['friends'] ?? []);
        print('✅ ${_friends.length} arkadaş yüklendi');

        // Debug: Arkadaş detayları
        for (var friend in _friends) {
          print('👤 Arkadaş: ${friend['displayName']} (${friend['uid']})');
          if (friend['location'] != null) {
            print(
                '   📍 Konum: lat=${friend['location']['latitude']}, lng=${friend['location']['longitude']}');
          }
        }
      } else {
        print('❌ HTTP Hatası: ${response.statusCode} - ${response.body}');
        _friends = [];
      }
    } catch (e) {
      print('❌ Arkadaş listesi yüklenirken hata: $e');
      _friends = [];
    }
  }

  // Bekleyen istekler - Gerçek API
  Future<void> fetchPendingRequests() async {
    print('📤 Bekleyen istekler alınıyor...');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return;
      }

      final response = await http.get(
        Uri.parse('$baseUrl/friends/friend-requests'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
      );

      print('📡 Friend Requests API Response: ${response.statusCode}');
      print('📄 Response Body: ${response.body}');

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        final List<dynamic> pendingList = data['pendingRequests'] ?? [];

        _friendRequests = pendingList
            .map((request) => {
                  'id': request['_id'],
                  'fromUser': {
                    'uid': request['fromUser']['uid'],
                    'displayName': request['fromUser']['displayName'],
                    'email': request['fromUser']['email'],
                    'photoURL': request['fromUser']['photoURL'],
                  },
                  'message': request['message'] ?? 'Arkadaş olmak istiyor',
                  'createdAt': request['createdAt'],
                  'status': request['status'],
                })
            .toList();

        print('✅ ${_friendRequests.length} bekleyen istek alındı');

        // Debug: İstek detayları
        for (var request in _friendRequests) {
          print(
              '📩 İstek: ${request['fromUser']['displayName']} → ${request['message']}');
        }
      } else {
        print(
            '❌ Bekleyen istekler alınamadı: ${response.statusCode} - ${response.body}');
        _friendRequests = [];
      }
    } catch (e) {
      print('❌ Bekleyen istekler hatası: $e');
      _friendRequests = [];
    }
  }

  // Arkadaş konumlarını güncelle
  Future<void> updateFriendsLocations() async {
    print('📍 Arkadaş konumları güncelleniyor...');
    await Future.delayed(Duration(milliseconds: 200));
  }

  // Arkadaş ekleme - Gerçek API
  Future<bool> sendFriendRequest(String userShareCode,
      {String? message}) async {
    print('➕ Arkadaş ekleme isteği: $userShareCode');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return false;
      }

      final response = await http.post(
        Uri.parse('$baseUrl/friends/send-request'),
        headers: {
          'Content-Type': 'application/json',
        },
        body: jsonEncode({
          'fromUserId': userId,
          'toUserShareCode': userShareCode,
          'message': message ?? 'Arkadaş olmak istiyor',
        }),
      );

      print('📤 API Response Status: ${response.statusCode}');
      print('📤 API Response Body: ${response.body}');

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        print('✅ Arkadaş isteği gönderildi: ${data['message']}');
        return true;
      } else {
        final error = jsonDecode(response.body);
        print('❌ Arkadaş isteği gönderilemedi: ${error['message']}');
        return false;
      }
    } catch (e) {
      print('❌ Arkadaş ekleme hatası: $e');
      return false;
    }
  }

  // İstek yanıtlama - Gerçek API
  Future<bool> respondToFriendRequest(String requestId, bool accept) async {
    print('${accept ? '✅' : '❌'} Arkadaş isteği yanıtı: $requestId');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return false;
      }

      final response = await http.put(
        Uri.parse('$baseUrl/friends/friend-request/$requestId'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
        body: jsonEncode({
          'action': accept ? 'accept' : 'reject',
        }),
      );

      print('📡 Friend Request Response API: ${response.statusCode}');
      print('📄 Response Body: ${response.body}');

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        print('✅ Arkadaş isteği yanıtlandı: ${data['message'] ?? 'Başarılı'}');

        // Listeleri yenile
        await fetchFriends();
        await fetchPendingRequests();

        return true;
      } else {
        print(
            '❌ Arkadaş isteği yanıtlanamadı: ${response.statusCode} - ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Arkadaş isteği yanıtı hatası: $e');
      return false;
    }
  }

  // Paylaşım kodunu al
  Future<String> getShareCode() async {
    try {
      await _authService.loadUserData();
      final shareCode = _authService.currentUserShareCode;

      if (shareCode != null && shareCode.isNotEmpty) {
        return shareCode;
      } else {
        return 'ERROR';
      }
    } catch (e) {
      print('❌ Share code alınırken hata: $e');
      return 'HATA';
    }
  }

  // Arkadaş ekleme - Gerçek API
  Future<String> addFriendByCode(String shareCode) async {
    print('➕ Arkadaş ekleniyor: $shareCode');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return 'Kullanıcı girişi yapılmamış';
      }

      if (shareCode.isEmpty || shareCode.length < 3) {
        return 'Geçersiz arkadaş kodu';
      }

      final response = await http.post(
        Uri.parse('$baseUrl/friends/add-by-code'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
        body: jsonEncode({
          'shareCode': shareCode,
        }),
      );

      print('📤 Add Friend Response: ${response.statusCode}');
      print('📄 Response Body: ${response.body}');

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        print('✅ Arkadaş ekleme başarılı: ${data['message'] ?? 'Başarılı'}');

        // Listeleri yenile
        await fetchFriends();
        await fetchPendingRequests();

        return 'success';
      } else {
        final error = jsonDecode(response.body);
        final errorMessage =
            error['error'] ?? error['message'] ?? 'Bilinmeyen hata';
        print('❌ Arkadaş ekleme hatası: $errorMessage');
        return errorMessage;
      }
    } catch (e) {
      print('❌ Arkadaş ekleme exception: $e');
      return 'Bağlantı hatası';
    }
  }
}
