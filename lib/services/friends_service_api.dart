import '../services/api_service.dart';

// Gerçek API ile çalışan arkadaş servisi
class FriendsService {
  static final FriendsService _instance = FriendsService._internal();
  factory FriendsService() => _instance;
  FriendsService._internal();

  final ApiService _apiService = ApiService();

  // Arkadaş listesi
  List<Map<String, dynamic>> _friends = [];
  List<Map<String, dynamic>> _friendRequests = [];

  // Getters
  List<Map<String, dynamic>> get friends => _friends;
  List<Map<String, dynamic>> get pendingRequests => _friendRequests;

  int get friendCount => _friends.length;
  int get pendingRequestCount => _friendRequests.length;

  // Gerçek API'den arkadaş listesi al
  Future<void> fetchFriends() async {
    print('👥 Arkadaş listesi alınıyor (API)...');

    try {
      final friendsData = await _apiService.getFriends();
      _friends = friendsData.map((friend) {
        return <String, dynamic>{
          'id': friend['_id'] ?? friend['id'],
          'name': friend['displayName'] ?? friend['name'] ?? 'Bilinmeyen',
          'email': friend['email'] ?? '',
          'shareCode': friend['shareCode'] ?? '',
          'status': 'online',
          'lastSeen': DateTime.now().millisecondsSinceEpoch,
        };
      }).toList();

      print('✅ ${_friends.length} arkadaş alındı');
    } catch (e) {
      print('❌ API hatası (friends): $e');
    }
  }

  Future<void> fetchPendingRequests() async {
    print('📤 Bekleyen istekler alınıyor (API)...');

    try {
      final response = await _apiService.getFriendRequests();
      final requestsData = response['pendingRequests'] as List<dynamic>;
      _friendRequests = requestsData.map((request) {
        return <String, dynamic>{
          'id': request['_id'] ?? request['id'],
          'fromUserName': request['fromUser']['displayName'] ?? 'Bilinmeyen',
          'fromUserEmail': request['fromUser']['email'] ?? '',
          'message': request['message'] ?? '',
          'timestamp': request['sentAt'] ?? DateTime.now().toIso8601String(),
        };
      }).toList();

      print('✅ ${_friendRequests.length} istek alındı');
    } catch (e) {
      print('❌ API hatası (requests): $e');
    }
  }

  Future<bool> respondToFriendRequest(String requestId, bool accept) async {
    print(
        '${accept ? '✅' : '❌'} Arkadaş isteği yanıtlanıyor (API): $requestId');

    try {
      final success =
          await _apiService.respondToFriendRequest(requestId, accept);
      if (success) {
        // Başarılıysa listelerden güncelle
        await fetchPendingRequests(); // İstekleri yenile
        if (accept) {
          await fetchFriends(); // Arkadaşları yenile
        }
        print('✅ İstek yanıtlandı');
        return true;
      } else {
        print('❌ İstek yanıtlanamadı');
        return false;
      }
    } catch (e) {
      print('❌ API hatası (respond): $e');
      return false;
    }
  }

  // Paylaşım kodunu al
  Future<String> getShareCode() async {
    // Gerçek uygulamada API'den alınacak
    return 'TEST123XYZ';
  }

  // Arkadaş kodu ile ekleme
  Future<String> addFriendByCode(String shareCode) async {
    print('➕ Arkadaş ekleniyor (API): $shareCode');

    try {
      final success = await _apiService.sendFriendRequest(shareCode,
          message: 'Arkadaş olmak ister misin?');
      if (success) {
        print('✅ Arkadaş ekleme isteği gönderildi');
        return 'success';
      } else {
        print('❌ İstek gönderilemedi');
        return 'İstek gönderilemedi';
      }
    } catch (e) {
      print('❌ API hatası (add friend): $e');
      return 'Bağlantı hatası: $e';
    }
  }
}
