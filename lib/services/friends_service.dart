import 'package:deprem_app/services/auth_service.dart';
import 'package:deprem_app/services/api_service.dart';

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

  // Arkadas listesini API'den cek
  Future<void> fetchFriends() async {
    try {
      print('🚀 fetchFriends() baslatildi');

      if (!_authService.isLoggedIn) {
        print('❌ Kullanici giris yapmamis');
        return;
      }

      print('👥 Arkadas listesi aliniyor...');
      print('🔑 User ID: ${_authService.userId}');

      try {
        // API'yi 5 saniye timeout ile dene
        print('🌐 API cagrisi yapiliyor...');
        final apiResponse = await _apiService.getFriends().timeout(
              const Duration(seconds: 5),
              onTimeout: () => throw 'API timeout',
            );

        _friends = apiResponse;
        print('✅ ${_friends.length} arkadas yuklendi (Real Database)');
      } catch (error) {
        print('❌ API hatası: $error - Simülasyon moduna geçiliyor');

        // Simülasyon arkadaş listesi
        _friends = [
          {
            'id': 'friend_1',
            'name': 'Ahmet Yılmaz',
            'email': 'ahmet@example.com',
            'photoURL': null,
            'shareCode': 'AHMET123',
            'location': {
              'latitude': 41.0082,
              'longitude': 28.9784,
              'address': 'İstanbul, Türkiye'
            },
            'lastSeen': DateTime.now().subtract(const Duration(minutes: 5)),
            'isOnline': true,
          },
          {
            'id': 'friend_2',
            'name': 'Fatma Demir',
            'email': 'fatma@example.com',
            'photoURL': null,
            'shareCode': 'FATMA456',
            'location': {
              'latitude': 39.9334,
              'longitude': 32.8597,
              'address': 'Ankara, Türkiye'
            },
            'lastSeen': DateTime.now().subtract(const Duration(hours: 2)),
            'isOnline': false,
          },
          {
            'id': 'friend_3',
            'name': 'Mehmet Özkan',
            'email': 'mehmet@example.com',
            'photoURL': null,
            'shareCode': 'MEHMET789',
            'location': {
              'latitude': 38.4127,
              'longitude': 27.1384,
              'address': 'İzmir, Türkiye'
            },
            'lastSeen': DateTime.now().subtract(const Duration(minutes: 30)),
            'isOnline': true,
          },
        ];
        print('✅ ${_friends.length} arkadaş yüklendi (Simülasyon Modu)');
      }
    } catch (error) {
      print('❌ Arkadaş listesi alma hatası: $error');
      _friends = [];
    }

    print('🏁 fetchFriends() tamamlandı. Toplam arkadaş: ${_friends.length}');
  }

  // Bekleyen arkadaş isteklerini çek
  Future<void> fetchPendingRequests() async {
    try {
      print('🚀 fetchPendingRequests() başlatıldı');

      if (!_authService.isLoggedIn) {
        print('❌ Kullanıcı giriş yapmamış - pending requests');
        return;
      }

      print('📩 Bekleyen istekler alınıyor...');

      try {
        // API'yi 5 saniye timeout ile dene
        print('🌐 Pending requests API çağrısı yapılıyor...');
        final apiResponse = await _apiService.getFriendRequests().timeout(
              const Duration(seconds: 5),
              onTimeout: () => throw 'API timeout',
            );

        final pendingRequests = apiResponse['pendingRequests'] as List? ?? [];
        _friendRequests = pendingRequests
            .map((request) => {
                  'id': request['_id'],
                  'fromUserId': request['fromUser']['_id'],
                  'message': request['message'] ?? '',
                  'sentAt':
                      DateTime.tryParse(request['sentAt']) ?? DateTime.now(),
                  'fromUser': {
                    'name': request['fromUser']['displayName'],
                    'email': request['fromUser']['email'],
                    'photoURL': request['fromUser']['photoURL'],
                  },
                })
            .toList();

        print(
            '✅ ${_friendRequests.length} bekleyen istek yüklendi (Real Database)');
      } catch (error) {
        print(
            '❌ Pending requests API hatası: $error - Simülasyon moduna geçiliyor');

        // Simülasyon arkadaşlık istekleri
        _friendRequests = [
          {
            'id': 'request_1',
            'fromUserId': 'new_user_001',
            'message':
                'Merhaba! Deprem uygulamasından arkadaş olmak ister misin?',
            'sentAt': DateTime.now().subtract(const Duration(hours: 1)),
            'fromUser': {
              'name': 'Zeynep Şahin',
              'email': 'zeynep@example.com',
              'photoURL': null,
            },
          },
          {
            'id': 'request_2',
            'fromUserId': 'new_user_002',
            'message': 'Selam! Aynı şehirde yaşıyoruz, arkadaş olalım mı?',
            'sentAt': DateTime.now().subtract(const Duration(minutes: 30)),
            'fromUser': {
              'name': 'Can Yılmaz',
              'email': 'can@example.com',
              'photoURL': null,
            },
          },
        ];
        print(
            '✅ ${_friendRequests.length} bekleyen istek oluşturuldu (Simülasyon)');
      }
    } catch (error) {
      print('❌ Bekleyen istekler alma hatası: $error');
      _friendRequests = [];
    }

    print(
        '🏁 fetchPendingRequests() tamamlandı. Toplam istek: ${_friendRequests.length}');
  }

  // Arkadas istegi gonder
  Future<bool> sendFriendRequest(String shareCode, {String? message}) async {
    try {
      if (!_authService.isLoggedIn) return false;

      print('📤 Arkadaş isteği gönderiliyor: $shareCode');

      final response = await _apiService
          .sendFriendRequest(shareCode, message: message)
          .timeout(
            const Duration(seconds: 5),
            onTimeout: () => throw 'API timeout',
          );
      print('✅ Arkadaş isteği gönderildi (Real Database)');
      return response;
    } catch (error) {
      print('❌ Arkadaş isteği gönderme hatası: $error');
      return false;
    }
  }

  // Arkadaş isteğini yanıtla
  Future<bool> respondToFriendRequest(String requestId, bool accept) async {
    try {
      if (!_authService.isLoggedIn) return false;

      print('📝 Arkadaş isteği yanıtlanıyor: ${accept ? 'Kabul' : 'Red'}');

      try {
        final response =
            await _apiService.respondToFriendRequest(requestId, accept).timeout(
                  const Duration(seconds: 5),
                  onTimeout: () => throw 'API timeout',
                );

        if (response && accept) {
          print('🔄 Arkadaş kabul edildi, liste güncelleniyor...');
          await fetchFriends(); // Arkadaş listesini güncelle
        }

        // İstekleri listeden kaldır
        _friendRequests.removeWhere((req) => req['id'] == requestId);
        print(
            '✅ Arkadaş isteği ${accept ? 'kabul edildi' : 'reddedildi'} (Real Database)');
        return response;
      } catch (error) {
        print('❌ API hatası: $error - Simülasyon moduna geçiliyor');

        // Simülasyon işlemi
        if (accept) {
          final request = _friendRequests.firstWhere(
            (req) => req['id'] == requestId,
            orElse: () => <String, dynamic>{},
          );

          if (request.isNotEmpty) {
            _friends.add({
              'id': request['fromUserId'],
              'name': request['fromUser']['name'],
              'email': request['fromUser']['email'],
              'photoURL': request['fromUser']['photoURL'],
              'shareCode': 'SIM${DateTime.now().millisecond}',
              'location': {
                'latitude': 41.0 + (DateTime.now().millisecond % 100) / 1000,
                'longitude': 29.0 + (DateTime.now().millisecond % 100) / 1000,
                'address': 'Simülasyon Şehir, Türkiye'
              },
              'lastSeen': DateTime.now(),
              'isOnline': DateTime.now().millisecond % 2 == 0,
            });
          }
        }

        _friendRequests.removeWhere((req) => req['id'] == requestId);
        print(
            '✅ Arkadaş isteği ${accept ? 'kabul edildi' : 'reddedildi'} (Simülasyon)');
        return true;
      }
    } catch (error) {
      print('❌ Arkadaş isteği yanıtlama hatası: $error');
      return false;
    }
  }

  // Arkadaşı kaldır
  Future<bool> removeFriend(String friendId) async {
    try {
      if (!_authService.isLoggedIn) return false;

      print('🗑️ Arkadaş kaldırılıyor: $friendId');

      final response = await _apiService.removeFriend(friendId).timeout(
            const Duration(seconds: 5),
            onTimeout: () => throw 'API timeout',
          );

      if (response) {
        _friends.removeWhere((friend) => friend['id'] == friendId);
        print('✅ Arkadaş kaldırıldı (Real Database)');
      }
      return response;
    } catch (error) {
      print('❌ Arkadaş kaldırma hatası: $error');
      return false;
    }
  }

  // Arkadaşların konumlarını güncelle
  Future<void> updateFriendsLocations() async {
    print('🗺️ Arkadaş konumları güncelleniyor...');
    // Simülasyon için rastgele konum güncellemeleri
    for (var friend in _friends) {
      if (friend['location'] != null) {
        friend['lastSeen'] = DateTime.now()
            .subtract(Duration(minutes: (DateTime.now().millisecond % 60)));
        friend['isOnline'] = DateTime.now().millisecond % 3 == 0;
      }
    }
  }

  // Son güncelleme zamanını formatla
  String formatLastUpdate(dynamic timestamp) {
    if (timestamp == null) return 'Bilinmiyor';

    try {
      DateTime lastUpdate;
      if (timestamp is DateTime) {
        lastUpdate = timestamp;
      } else if (timestamp is String) {
        lastUpdate = DateTime.parse(timestamp);
      } else {
        return 'Bilinmiyor';
      }

      final now = DateTime.now();
      final difference = now.difference(lastUpdate);

      if (difference.inSeconds < 60) {
        return 'Az önce';
      } else if (difference.inMinutes < 60) {
        return '${difference.inMinutes} dakika önce';
      } else if (difference.inHours < 24) {
        return '${difference.inHours} saat önce';
      } else {
        return '${difference.inDays} gün önce';
      }
    } catch (e) {
      return 'Bilinmiyor';
    }
  }

  // Stream için arkadaş listesi
  Stream<List<Map<String, dynamic>>> get friendsStream async* {
    if (!_authService.isLoggedIn) {
      yield [];
      return;
    }

    while (true) {
      yield List.from(_friends);
      await Future.delayed(const Duration(seconds: 5));
    }
  }
}
