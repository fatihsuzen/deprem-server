// Firebase bağımlılıkları devre dışı olduğu için geçici olarak devre dışı
// Bu dosya gelecekte Firebase entegrasyonu için hazır
class FriendsService {
  static final FriendsService _instance = FriendsService._internal();
  factory FriendsService() => _instance;
  FriendsService._internal();

  // Mock methods - Firebase entegrasyonu için hazır
  Future<bool> sendFriendRequest(String userShareCode,
      {String? message}) async {
    print('📤 Mock arkadaş isteği gönderiliyor: $userShareCode');
    return true;
  }

  Future<List<Map<String, dynamic>>> getFriendRequests() async {
    print('📤 Mock arkadaş istekleri alınıyor');
    return [];
  }

  Future<bool> acceptFriendRequest(String requestId) async {
    print('✅ Mock arkadaş isteği kabul edildi: $requestId');
    return true;
  }

  Future<bool> rejectFriendRequest(String requestId) async {
    print('❌ Mock arkadaş isteği reddedildi: $requestId');
    return true;
  }

  Future<List<Map<String, dynamic>>> getFriendsList() async {
    print('👥 Mock arkadaş listesi alınıyor');
    return [];
  }

  Future<bool> removeFriend(String friendId) async {
    print('❌ Mock arkadaş silindi: $friendId');
    return true;
  }

  Future<Map<String, dynamic>?> getFriendLocation(String friendId) async {
    print('📍 Mock arkadaş konumu alınıyor: $friendId');
    return null;
  }

  Future<bool> shareLocation(double latitude, double longitude) async {
    print('📍 Mock konum paylaşıldı: $latitude, $longitude');
    return true;
  }

  Future<bool> stopLocationSharing() async {
    print('🛑 Mock konum paylaşımı durduruldu');
    return true;
  }

  Future<List<Map<String, dynamic>>> getFriendsNearby(
      double latitude, double longitude,
      {double radiusKm = 5.0}) async {
    print('🔍 Mock yakındaki arkadaşlar aranıyor');
    return [];
  }
}
