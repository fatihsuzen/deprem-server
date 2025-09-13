import 'auth_service.dart';
import 'api_service.dart';

class FriendsService {
  static final FriendsService _instance = FriendsService._internal();
  factory FriendsService() => _instance;
  FriendsService._internal();

  final AuthService _authService = AuthService();
  final ApiService _apiService = ApiService();

  List<Map<String, dynamic>> _friends = [];
  List<Map<String, dynamic>> _friendRequests = [];

  List<Map<String, dynamic>> get friends => _friends;
  List<Map<String, dynamic>> get friendRequests => _friendRequests;
  List<Map<String, dynamic>> get pendingRequests => _friendRequests;

  int get friendCount => _friends.length;
  int get pendingRequestCount => _friendRequests.length;

  // Arkadaş listesini API'den çek
  Future<void> fetchFriends() async {
    try {
      if (!await _authService.isLoggedIn()) {
        print('❌ Kullanıcı giriş yapmamış');
        return;
      }

      print('👥 Arkadaş listesi API\'den alınıyor...');

      final response = await _apiService.getFriends();

      if (response['success'] == true && response['friends'] != null) {
        _friends = List<Map<String, dynamic>>.from(response['friends']);
        print('✅ ${_friends.length} arkadaş alındı');
      } else {
        print(
            '⚠️ Arkadaş listesi alınamadı: ${response['error'] ?? 'Bilinmeyen hata'}');
        _friends = [];
      }
    } catch (e) {
      print('❌ Arkadaş listesi alınırken hata: $e');
      _friends = [];
    }
  }

  // Bekleyen arkadaş isteklerini API'den çek
  Future<void> fetchPendingRequests() async {
    try {
      if (!await _authService.isLoggedIn()) {
        print('❌ Kullanıcı giriş yapmamış');
        return;
      }

      print('📨 Bekleyen istekler API\'den alınıyor...');

      final response = await _apiService.getPendingFriendRequests();

      if (response['success'] == true && response['requests'] != null) {
        _friendRequests = List<Map<String, dynamic>>.from(response['requests']);
        print('✅ ${_friendRequests.length} bekleyen istek alındı');
      } else {
        print(
            '⚠️ Bekleyen istekler alınamadı: ${response['error'] ?? 'Bilinmeyen hata'}');
        _friendRequests = [];
      }
    } catch (e) {
      print('❌ Bekleyen istekler alınırken hata: $e');
      _friendRequests = [];
    }
  }

  // Arkadaş isteğini kabul et veya reddet
  Future<bool> respondToFriendRequest(String requestId, bool accept) async {
    try {
      print(
          '📝 Arkadaş isteğine ${accept ? 'kabul' : 'red'} yanıtı gönderiliyor...');

      final response =
          await _apiService.respondToFriendRequest(requestId, accept);

      if (response['success'] == true) {
        print('✅ Arkadaş isteği ${accept ? 'kabul edildi' : 'reddedildi'}');

        // Listeleri güncelle
        await fetchPendingRequests();
        if (accept) {
          await fetchFriends();
        }

        return true;
      } else {
        print(
            '❌ Arkadaş isteği yanıtlanırken hata: ${response['error'] ?? 'Bilinmeyen hata'}');
        return false;
      }
    } catch (e) {
      print('❌ Arkadaş isteği yanıtlanırken hata: $e');
      return false;
    }
  }

  // Arkadaş kodu ile arkadaş ekleme
  Future<String> addFriendByCode(String shareCode) async {
    try {
      print('➕ Arkadaş kodu ile ekleme: $shareCode');

      final response = await _apiService.addFriendByCode(shareCode);

      if (response['success'] == true) {
        print('✅ Arkadaş ekleme isteği gönderildi');
        return 'success';
      } else if (response['error'] != null) {
        print('❌ Arkadaş ekleme hatası: ${response['error']}');
        return response['error'];
      } else {
        return 'Bilinmeyen hata oluştu';
      }
    } catch (e) {
      print('❌ Arkadaş ekleme hatası: $e');
      return 'Bağlantı hatası';
    }
  }

  // Kullanıcının paylaşım kodunu al
  Future<String> getShareCode() async {
    try {
      final response = await _apiService.getShareCode();

      if (response['success'] == true && response['shareCode'] != null) {
        return response['shareCode'];
      } else {
        return 'Kod alınamadı';
      }
    } catch (e) {
      return 'Bilinmiyor';
    }
  }

  // Stream için arkadaş listesi
  Stream<List<Map<String, dynamic>>> get friendsStream async* {
    final isLoggedIn = await _authService.isLoggedIn();
    if (!isLoggedIn) {
      yield [];
      return;
    }

    while (true) {
      yield List.from(_friends);
      await Future.delayed(const Duration(seconds: 5));
    }
  }
}
