import 'dart:convert';
import 'package:http/http.dart' as http;
import 'auth_service.dart';

// Gerçek API ile çalışan arkadaş servisi
class FriendsService {
  static final FriendsService _instance = FriendsService._internal();
  factory FriendsService() => _instance;
  FriendsService._internal();

  final AuthService _authService = AuthService();
  static const String _baseUrl = 'http://10.0.2.2:3000/api';

  // Arkadaş listesi
  List<Map<String, dynamic>> _friends = [];
  List<Map<String, dynamic>> _friendRequests = [];

  // Mock arkadaş verisi - gerçek uygulamada database'den gelecek
  List<Map<String, dynamic>> get friends => _friends;
  List<Map<String, dynamic>> get pendingRequests => _friendRequests;

  int get friendCount => _friends.length;
  int get pendingRequestCount => _friendRequests.length;

  // Gerçek API'den arkadaş listesini al
  Future<void> fetchFriends() async {
    print('👥 Arkadaş listesi alınıyor...');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return;
      }

      final response = await http.get(
        Uri.parse('$_baseUrl/friends'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
      );

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        _friends = List<Map<String, dynamic>>.from(data['friends'] ?? []);
        print('✅ ${_friends.length} arkadaş yüklendi');
      } else {
        print('❌ HTTP Hatası: ${response.statusCode}');
        _friends = [];
      }
    } catch (e) {
      print('❌ Arkadaş listesi yüklenirken hata: $e');
      _friends = [];
    }
  }

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
        Uri.parse('$_baseUrl/requests'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
      );

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        if (data['success'] == true) {
          _friendRequests =
              List<Map<String, dynamic>>.from(data['requests'] ?? []);
          print('✅ ${_friendRequests.length} bekleyen istek yüklendi');
        } else {
          print('❌ API Hatası: ${data['message']}');
          _friendRequests = [];
        }
      } else {
        print('❌ HTTP Hatası: ${response.statusCode}');
        _friendRequests = [];
      }
    } catch (e) {
      print('❌ Bekleyen istekler yüklenirken hata: $e');
      _friendRequests = [];
    }
  }

  Future<void> updateFriendsLocations() async {
    print('📍 Arkadaş konumları güncelleniyor...');
    // Bu metod şu anda gerekli değil, API otomatik konum güncellemesi yapıyor
    await Future.delayed(Duration(milliseconds: 200));
  }

  Future<bool> sendFriendRequest(String userShareCode,
      {String? message}) async {
    return await addFriendByCode(userShareCode) == 'success';
  }

  Future<bool> respondToFriendRequest(String requestId, bool accept) async {
    print('${accept ? '✅' : '❌'} Arkadaş isteği yanıtlanıyor: $requestId');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return false;
      }

      final response = await http.post(
        Uri.parse('$_baseUrl/requests/$requestId/respond'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
        body: json.encode({
          'accept': accept,
        }),
      );

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        if (data['success'] == true) {
          // Başarılı yanıt sonrası listeyi güncelle
          await fetchPendingRequests();
          if (accept) {
            await fetchFriends(); // Kabul edilirse arkadaş listesini güncelle
          }
          print('✅ Arkadaş isteği yanıtlandı');
          return true;
        } else {
          print('❌ API Hatası: ${data['message']}');
          return false;
        }
      } else {
        print('❌ HTTP Hatası: ${response.statusCode}');
        return false;
      }
    } catch (e) {
      print('❌ Arkadaş isteği yanıtlanırken hata: $e');
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
        // Eğer share code yoksa AuthService'ten yeni oluştur
        return _authService.generateShareCode();
      }
    } catch (e) {
      print('❌ Share code alınırken hata: $e');
      return 'HATA';
    }
  }

  // Arkadaş kodu ile ekleme
  Future<String> addFriendByCode(String shareCode) async {
    print('➕ Arkadaş ekleniyor: $shareCode');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return 'Kullanıcı girişi yapılmamış';
      }

      final response = await http.post(
        Uri.parse('$_baseUrl/send-request'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
        body: json.encode({
          'targetShareCode': shareCode,
          'message': 'Deprem uygulamasından arkadaş olmak istiyorum.',
        }),
      );

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        if (data['success'] == true) {
          print('✅ Arkadaş ekleme isteği gönderildi');
          return 'success';
        } else {
          print('❌ API Hatası: ${data['message']}');
          return data['message'] ?? 'Bilinmeyen hata';
        }
      } else {
        print('❌ HTTP Hatası: ${response.statusCode}');
        return 'Sunucu hatası';
      }
    } catch (e) {
      print('❌ Arkadaş ekleme hatası: $e');
      return 'Bağlantı hatası';
    }
  }
}
