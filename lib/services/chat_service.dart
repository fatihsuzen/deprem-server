import 'dart:convert';
import 'package:http/http.dart' as http;
import 'auth_service.dart';

class ChatService {
  static final ChatService _instance = ChatService._internal();
  factory ChatService() => _instance;
  ChatService._internal();

  final AuthService _authService = AuthService();
  static const String baseUrl = 'http://188.132.202.24:3000/api/chat';

  List<Map<String, dynamic>> _chatRooms = [];
  List<Map<String, dynamic>> _messages = [];
  String? _currentRoomId;

  List<Map<String, dynamic>> get chatRooms => _chatRooms;
  List<Map<String, dynamic>> get messages => _messages;
  String? get currentRoomId => _currentRoomId;

  // Get all chat rooms with active user counts
  Future<void> fetchChatRooms() async {
    print('🏠 Chat odaları yükleniyor...');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return;
      }

      final response = await http.get(
        Uri.parse('$baseUrl/rooms'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
      );

      print('📡 Chat rooms API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        print('📄 Response Body: ${response.body}');

        if (data['success']) {
          _chatRooms = List<Map<String, dynamic>>.from(data['rooms'] ?? []);
          print('✅ ${_chatRooms.length} chat odası yüklendi');

          _chatRooms.forEach((room) {
            print(
                '   🏠 ${room['flag']} ${room['name']} (${room['activeUserCount']} aktif)');
          });
        }
      } else {
        print(
            '❌ Chat rooms API hatası: ${response.statusCode} - ${response.body}');
      }
    } catch (e) {
      print('❌ Chat rooms yükleme hatası: $e');
    }
  }

  // Join a chat room
  Future<bool> joinRoom(String roomId) async {
    print('🚪 $roomId odasına katılınıyor...');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;
      final displayName = _authService.currentUserName;
      // final photoURL = _authService.currentUserPhotoURL; // Bu property yok şimdilik null gönderelim

      if (userId == null || displayName == null) {
        print('❌ Kullanıcı bilgileri eksik');
        return false;
      }

      final response = await http.post(
        Uri.parse('$baseUrl/rooms/$roomId/join'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
        body: json.encode({
          'displayName': displayName,
          'photoURL': null, // Şimdilik null
        }),
      );

      print('📡 Join room API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        print('✅ Odaya katıldı: ${data['message']}');
        _currentRoomId = roomId;
        return true;
      } else {
        print(
            '❌ Odaya katılma hatası: ${response.statusCode} - ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Join room hatası: $e');
      return false;
    }
  }

  // Leave a chat room
  Future<bool> leaveRoom(String roomId) async {
    print('👋 $roomId odasından ayrılınıyor...');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return false;
      }

      final response = await http.post(
        Uri.parse('$baseUrl/rooms/$roomId/leave'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
      );

      print('📡 Leave room API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        print('✅ Odadan ayrıldı: ${data['message']}');
        if (_currentRoomId == roomId) {
          _currentRoomId = null;
        }
        return true;
      } else {
        print(
            '❌ Odadan ayrılma hatası: ${response.statusCode} - ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Leave room hatası: $e');
      return false;
    }
  }

  // Get messages from a chat room
  Future<void> fetchMessages(String roomId,
      {int limit = 50, int offset = 0}) async {
    print('💬 $roomId odası mesajları yükleniyor...');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return;
      }

      final response = await http.get(
        Uri.parse(
            '$baseUrl/rooms/$roomId/messages?limit=$limit&offset=$offset'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
      );

      print('📡 Messages API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);

        if (data['success']) {
          _messages = List<Map<String, dynamic>>.from(data['messages'] ?? []);
          print('✅ ${_messages.length} mesaj yüklendi');
        }
      } else {
        print(
            '❌ Messages API hatası: ${response.statusCode} - ${response.body}');
      }
    } catch (e) {
      print('❌ Messages yükleme hatası: $e');
    }
  }

  // Send a message to a chat room
  Future<bool> sendMessage(String roomId, String message) async {
    print('📤 Mesaj gönderiliyor: $message');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;
      final displayName = _authService.currentUserName;

      if (userId == null || displayName == null) {
        print('❌ Kullanıcı bilgileri eksik');
        return false;
      }

      final response = await http.post(
        Uri.parse('$baseUrl/rooms/$roomId/messages'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
        body: json.encode({
          'message': message,
          'displayName': displayName,
        }),
      );

      print('📡 Send message API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        print('✅ Mesaj gönderildi: ${data['message']}');

        // Mesaj listesini güncelle
        if (data['messageObj'] != null) {
          _messages.add(data['messageObj']);
        }

        return true;
      } else {
        print(
            '❌ Mesaj gönderme hatası: ${response.statusCode} - ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Send message hatası: $e');
      return false;
    }
  }

  // Get active users in a room
  Future<List<Map<String, dynamic>>> getRoomUsers(String roomId) async {
    print('👥 $roomId odası kullanıcıları yükleniyor...');

    try {
      await _authService.loadUserData();
      final userId = _authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return [];
      }

      final response = await http.get(
        Uri.parse('$baseUrl/rooms/$roomId/users'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
      );

      print('📡 Room users API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);

        if (data['success']) {
          final users = List<Map<String, dynamic>>.from(data['users'] ?? []);
          print('✅ ${users.length} aktif kullanıcı yüklendi');
          return users;
        }
      } else {
        print(
            '❌ Room users API hatası: ${response.statusCode} - ${response.body}');
      }
    } catch (e) {
      print('❌ Room users yükleme hatası: $e');
    }

    return [];
  }

  // Get global chat statistics
  Future<Map<String, dynamic>?> getChatStats() async {
    print('📊 Chat istatistikleri yükleniyor...');

    try {
      final response = await http.get(
        Uri.parse('$baseUrl/stats'),
        headers: {
          'Content-Type': 'application/json',
        },
      );

      print('📡 Stats API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);

        if (data['success']) {
          print('✅ Chat istatistikleri yüklendi');
          return data['stats'];
        }
      } else {
        print('❌ Stats API hatası: ${response.statusCode} - ${response.body}');
      }
    } catch (e) {
      print('❌ Stats yükleme hatası: $e');
    }

    return null;
  }

  // Clear messages (for UI refresh)
  void clearMessages() {
    _messages.clear();
    _currentRoomId = null;
  }

  // Get room by ID
  Map<String, dynamic>? getRoomById(String roomId) {
    try {
      return _chatRooms.firstWhere((room) => room['id'] == roomId);
    } catch (e) {
      return null;
    }
  }
}
