import 'dart:convert';
import 'package:http/http.dart' as http;
import 'auth_service_real.dart';

// Gerçek cihazlar için arkadaş servisi
class FriendsService {
  static final FriendsService _instance = FriendsService._internal();
  factory FriendsService() => _instance;
  FriendsService._internal();

  final AuthService _authService = AuthService();
  static const String baseUrl = 'http://192.168.1.104:3000/api';

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
          print(
              '👤 Arkadaş: ${friend['displayName']} (${friend['firebaseUid']})');
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

  // Bekleyen istekler (basit tutuluyor)
  Future<void> fetchPendingRequests() async {
    print('📤 Bekleyen istekler alınıyor...');
    _friendRequests = []; // Şimdilik basit
  }

  // Arkadaş konumlarını güncelle
  Future<void> updateFriendsLocations() async {
    print('📍 Arkadaş konumları güncelleniyor...');
    await Future.delayed(Duration(milliseconds: 200));
  }

  // Arkadaş ekleme
  Future<bool> sendFriendRequest(String userShareCode,
      {String? message}) async {
    print('➕ Arkadaş ekleme isteği: $userShareCode');
    await Future.delayed(Duration(milliseconds: 500));
    return true; // Mock success
  }

  // İstek yanıtlama
  Future<bool> respondToFriendRequest(String requestId, bool accept) async {
    print('${accept ? '✅' : '❌'} Arkadaş isteği yanıtı: $requestId');
    await Future.delayed(Duration(milliseconds: 500));
    return true; // Mock success
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

  // Arkadaş ekleme
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

      // Mock başarı
      await Future.delayed(Duration(milliseconds: 500));
      print('✅ Arkadaş ekleme başarılı');
      return 'success';
    } catch (e) {
      print('❌ Arkadaş ekleme hatası: $e');
      return 'Bağlantı hatası';
    }
  }
}
