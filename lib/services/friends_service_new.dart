import 'package:cloud_firestore/cloud_firestore.dart';
import 'auth_service.dart';

class FriendsService {
  static final FriendsService _instance = FriendsService._internal();
  factory FriendsService() => _instance;
  FriendsService._internal();

  final FirebaseFirestore _firestore = FirebaseFirestore.instance;
  final AuthService _authService = AuthService();

  List<Map<String, dynamic>> _friends = [];
  List<Map<String, dynamic>> _friendRequests = [];

  List<Map<String, dynamic>> get friends => _friends;
  List<Map<String, dynamic>> get pendingRequests => _friendRequests;

  int get friendCount => _friends.length;
  int get pendingRequestCount => _friendRequests.length;

  // Arkadaş listesini Firestore'dan çek
  Future<void> fetchFriends() async {
    try {
      if (!_authService.isLoggedIn) {
        print('❌ Kullanıcı giriş yapmamış');
        return;
      }

      print('👥 Arkadaş listesi alınıyor...');

      final userId = _authService.userId!;

      // Kullanıcının arkadaş listesini al
      final userDoc = await _firestore.collection('users').doc(userId).get();
      final userData = userDoc.data();

      if (userData != null && userData['friends'] != null) {
        final friendIds = List<String>.from(userData['friends']);

        _friends.clear();

        // Her arkadaşın bilgilerini al
        for (String friendId in friendIds) {
          final friendDoc =
              await _firestore.collection('users').doc(friendId).get();
          final friendData = friendDoc.data();

          if (friendData != null) {
            _friends.add({
              'id': friendId,
              'name': friendData['displayName'] ?? 'Bilinmeyen',
              'email': friendData['email'] ?? '',
              'photoURL': friendData['photoURL'],
              'location': friendData['location'],
              'lastSeen': friendData['lastSeen'],
            });
          }
        }
      }

      print('✅ ${_friends.length} arkadaş yüklendi');
    } catch (error) {
      print('❌ Arkadaş listesi alma hatası: $error');
    }
  }

  // Bekleyen arkadaş isteklerini çek
  Future<void> fetchPendingRequests() async {
    try {
      if (!_authService.isLoggedIn) return;

      print('📩 Bekleyen istekler alınıyor...');

      final userId = _authService.userId!;

      // Bana gelen arkadaş isteklerini al
      final requestsQuery = await _firestore
          .collection('friend_requests')
          .where('toUserId', isEqualTo: userId)
          .where('status', isEqualTo: 'pending')
          .get();

      _friendRequests.clear();

      for (var doc in requestsQuery.docs) {
        final requestData = doc.data();

        // İstek gönderen kullanıcının bilgilerini al
        final fromUserDoc = await _firestore
            .collection('users')
            .doc(requestData['fromUserId'])
            .get();

        final fromUserData = fromUserDoc.data();

        if (fromUserData != null) {
          _friendRequests.add({
            'id': doc.id,
            'fromUserId': requestData['fromUserId'],
            'message': requestData['message'] ?? '',
            'sentAt': requestData['sentAt'],
            'fromUser': {
              'name': fromUserData['displayName'] ?? 'Bilinmeyen',
              'email': fromUserData['email'] ?? '',
              'photoURL': fromUserData['photoURL'],
            },
          });
        }
      }

      print('✅ ${_friendRequests.length} bekleyen istek yüklendi');
    } catch (error) {
      print('❌ Bekleyen istekler alma hatası: $error');
    }
  }

  // Arkadaş isteği gönder
  Future<bool> sendFriendRequest(String shareCode, {String? message}) async {
    try {
      if (!_authService.isLoggedIn) return false;

      print('📤 Arkadaş isteği gönderiliyor: $shareCode');

      // Share code ile kullanıcı bul
      final usersQuery = await _firestore
          .collection('users')
          .where('shareCode', isEqualTo: shareCode)
          .get();

      if (usersQuery.docs.isEmpty) {
        throw 'Bu koda sahip kullanıcı bulunamadı';
      }

      final targetUser = usersQuery.docs.first;
      final targetUserId = targetUser.id;
      final currentUserId = _authService.userId!;

      if (targetUserId == currentUserId) {
        throw 'Kendinize arkadaş isteği gönderemezsiniz';
      }

      // Zaten arkadaş mı kontrol et
      final currentUserDoc =
          await _firestore.collection('users').doc(currentUserId).get();
      final friends =
          List<String>.from(currentUserDoc.data()?['friends'] ?? []);

      if (friends.contains(targetUserId)) {
        throw 'Bu kullanıcı zaten arkadaşınız';
      }

      // Zaten istek gönderilmiş mi kontrol et
      final existingRequest = await _firestore
          .collection('friend_requests')
          .where('fromUserId', isEqualTo: currentUserId)
          .where('toUserId', isEqualTo: targetUserId)
          .where('status', isEqualTo: 'pending')
          .get();

      if (existingRequest.docs.isNotEmpty) {
        throw 'Bu kullanıcıya zaten istek gönderilmiş';
      }

      // Arkadaş isteği oluştur
      await _firestore.collection('friend_requests').add({
        'fromUserId': currentUserId,
        'toUserId': targetUserId,
        'message': message ?? '',
        'status': 'pending',
        'sentAt': FieldValue.serverTimestamp(),
      });

      print('✅ Arkadaş isteği gönderildi');
      return true;
    } catch (error) {
      print('❌ Arkadaş isteği gönderme hatası: $error');
      throw error.toString();
    }
  }

  // Arkadaş isteğini yanıtla
  Future<bool> respondToFriendRequest(String requestId, bool accept) async {
    try {
      if (!_authService.isLoggedIn) return false;

      print('📝 Arkadaş isteği yanıtlanıyor: $accept');

      final requestDoc =
          await _firestore.collection('friend_requests').doc(requestId).get();
      final requestData = requestDoc.data();

      if (requestData == null) {
        throw 'İstek bulunamadı';
      }

      final fromUserId = requestData['fromUserId'];
      final toUserId = requestData['toUserId'];
      final currentUserId = _authService.userId!;

      if (toUserId != currentUserId) {
        throw 'Bu isteği yanıtlama yetkiniz yok';
      }

      if (accept) {
        // Arkadaş olarak ekle
        await _firestore.runTransaction((transaction) async {
          // Her iki kullanıcının arkadaş listesine ekle
          final fromUserRef = _firestore.collection('users').doc(fromUserId);
          final toUserRef = _firestore.collection('users').doc(toUserId);

          transaction.update(fromUserRef, {
            'friends': FieldValue.arrayUnion([toUserId])
          });

          transaction.update(toUserRef, {
            'friends': FieldValue.arrayUnion([fromUserId])
          });

          // İsteği kabul edildi olarak işaretle
          final requestRef =
              _firestore.collection('friend_requests').doc(requestId);
          transaction.update(requestRef, {
            'status': 'accepted',
            'respondedAt': FieldValue.serverTimestamp(),
          });
        });

        print('✅ Arkadaş isteği kabul edildi');
      } else {
        // İsteği reddet
        await _firestore.collection('friend_requests').doc(requestId).update({
          'status': 'rejected',
          'respondedAt': FieldValue.serverTimestamp(),
        });

        print('❌ Arkadaş isteği reddedildi');
      }

      return true;
    } catch (error) {
      print('❌ Arkadaş isteği yanıtlama hatası: $error');
      throw error.toString();
    }
  }

  // Arkadaşı kaldır
  Future<bool> removeFriend(String friendId) async {
    try {
      if (!_authService.isLoggedIn) return false;

      print('🗑️ Arkadaş kaldırılıyor: $friendId');

      final currentUserId = _authService.userId!;

      await _firestore.runTransaction((transaction) async {
        final currentUserRef =
            _firestore.collection('users').doc(currentUserId);
        final friendUserRef = _firestore.collection('users').doc(friendId);

        // Her iki kullanıcının arkadaş listesinden kaldır
        transaction.update(currentUserRef, {
          'friends': FieldValue.arrayRemove([friendId])
        });

        transaction.update(friendUserRef, {
          'friends': FieldValue.arrayRemove([currentUserId])
        });
      });

      print('✅ Arkadaş kaldırıldı');
      return true;
    } catch (error) {
      print('❌ Arkadaş kaldırma hatası: $error');
      return false;
    }
  }

  // Arkadaşların konumlarını güncelle
  Future<void> updateFriendsLocations() async {
    // Bu fonksiyon arkadaş listesi alındığında zaten güncel veriler geliyor
    // Gerekirse real-time listener eklenebilir
    print('🗺️ Arkadaş konumları güncelleniyor...');
  }

  // Son güncelleme zamanını formatla
  String formatLastUpdate(dynamic timestamp) {
    if (timestamp == null) return 'Bilinmiyor';

    try {
      DateTime lastUpdate;
      if (timestamp is Timestamp) {
        lastUpdate = timestamp.toDate();
      } else if (timestamp is DateTime) {
        lastUpdate = timestamp;
      } else {
        return 'Bilinmiyor';
      }

      final now = DateTime.now();
      final difference = now.difference(lastUpdate);

      if (difference.inMinutes < 1) {
        return 'Az önce';
      } else if (difference.inMinutes < 60) {
        return '${difference.inMinutes} dakika önce';
      } else if (difference.inHours < 24) {
        return '${difference.inHours} saat önce';
      } else if (difference.inDays < 30) {
        return '${difference.inDays} gün önce';
      } else {
        return 'Uzun zaman önce';
      }
    } catch (error) {
      return 'Bilinmiyor';
    }
  }

  // Real-time arkadaş konumları dinleyici
  Stream<List<Map<String, dynamic>>> getFriendsLocationStream() {
    if (!_authService.isLoggedIn) {
      return Stream.value([]);
    }

    final userId = _authService.userId!;

    return _firestore
        .collection('users')
        .doc(userId)
        .snapshots()
        .asyncMap((userDoc) async {
      final userData = userDoc.data();
      if (userData == null || userData['friends'] == null) {
        return <Map<String, dynamic>>[];
      }

      final friendIds = List<String>.from(userData['friends']);
      final friendsData = <Map<String, dynamic>>[];

      for (String friendId in friendIds) {
        final friendDoc =
            await _firestore.collection('users').doc(friendId).get();
        final friendData = friendDoc.data();

        if (friendData != null) {
          friendsData.add({
            'id': friendId,
            'name': friendData['displayName'] ?? 'Bilinmeyen',
            'email': friendData['email'] ?? '',
            'photoURL': friendData['photoURL'],
            'location': friendData['location'],
            'lastSeen': friendData['lastSeen'],
          });
        }
      }

      return friendsData;
    });
  }
}
