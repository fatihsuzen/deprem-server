import 'dart:convert';
import 'package:http/http.dart' as http;
import 'auth_service.dart';

class ChatService {
  static final ChatService _instance = ChatService._internal();

  ChatService._internal();

  factory ChatService() => _instance;

  final AuthService _authService = AuthService();

  // Server URL
  static const String baseUrl = 'http://188.132.202.24:3000/api/chat';

  // Chat state
  List<Map<String, dynamic>> _chatRooms = [];
  List<Map<String, dynamic>> _messages = [];
  String? _currentRoomId;

  // Getters
  List<Map<String, dynamic>> get chatRooms => _chatRooms;
  List<Map<String, dynamic>> get messages => _messages;
  String? get currentRoomId => _currentRoomId;

  // Get user data for consistent session
  Future<Map<String, String>> _getUserHeaders() async {
    await _authService.loadUserData();
    final userId = _authService.currentUserId ??
        'anonymous-${DateTime.now().millisecondsSinceEpoch}';
    final displayName = (_authService.currentUserName ?? 'Kullanici')
        .replaceAll(' ', '_') // HTTP header'larda bosluk olamaz
        .replaceAll('ş', 's') // Turkce karakter sorunlari icin
        .replaceAll('ü', 'u')
        .replaceAll('ç', 'c')
        .replaceAll('ğ', 'g')
        .replaceAll('ı', 'i')
        .replaceAll('ö', 'o');

    final headers = {
      'Content-Type': 'application/json',
      'user-id': userId,
      'display-name': displayName,
    };

    print('🔧 Flutter Headers: user-id=$userId, display-name=$displayName');

    return headers;
  }

  // Fetch all chat rooms
  Future<void> fetchChatRooms() async {
    print('🏠 Chat rooms yukleniyor...');

    try {
      final headers = await _getUserHeaders();

      final response = await http.get(
        Uri.parse('$baseUrl/rooms'),
        headers: headers,
      );

      print('📡 Chat rooms API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);

        if (data['success']) {
          _chatRooms = List<Map<String, dynamic>>.from(data['rooms'] ?? []);
          print('✅ ${_chatRooms.length} oda yuklendi');

          // Print loaded rooms
          _chatRooms.forEach((room) {
            print(
                '   🏠 ${room['flag']} ${room['name']} (${room['activeUserCount']} aktif)');
          });
        }
      } else {
        print(
            '❌ Chat rooms API hatasi: ${response.statusCode} - ${response.body}');
      }
    } catch (e) {
      print('❌ Chat rooms yukleme hatasi: $e');
    }
  }

  // Join a chat room
  Future<bool> joinRoom(String roomId) async {
    print('🚪 $roomId odasina katiliniyor...');

    try {
      final headers = await _getUserHeaders();
      final displayName = headers['display-name'] ?? 'Kullanici';

      final response = await http.post(
        Uri.parse('$baseUrl/rooms/$roomId/join'),
        headers: headers,
        body: json.encode({
          'displayName': displayName,
          'photoURL': null,
        }),
      );

      print('📡 Join room API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        print('✅ Odaya katildi: ${data['message']}');
        _currentRoomId = roomId;
        return true;
      } else {
        print(
            '❌ Odaya katilma hatasi: ${response.statusCode} - ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Join room hatasi: $e');
      return false;
    }
  }

  // Leave a chat room
  Future<bool> leaveRoom(String roomId) async {
    print('👋 $roomId odasindan ayriliniyor...');

    try {
      final headers = await _getUserHeaders();

      final response = await http.post(
        Uri.parse('$baseUrl/rooms/$roomId/leave'),
        headers: headers,
      );

      print('📡 Leave room API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        print('✅ Odadan ayrildi: ${data['message']}');
        if (_currentRoomId == roomId) {
          _currentRoomId = null;
        }
        return true;
      } else {
        print(
            '❌ Odadan ayrilma hatasi: ${response.statusCode} - ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Leave room hatasi: $e');
      return false;
    }
  }

  // Get messages from a chat room
  Future<void> fetchMessages(String roomId,
      {int limit = 50, int offset = 0}) async {
    print('💬 $roomId odasi mesajlari yukleniyor...');

    try {
      final headers = await _getUserHeaders();

      final response = await http.get(
        Uri.parse(
            '$baseUrl/rooms/$roomId/messages?limit=$limit&offset=$offset'),
        headers: headers,
      );

      print('📡 Messages API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);

        if (data['success']) {
          _messages = List<Map<String, dynamic>>.from(data['messages'] ?? []);
          print('✅ ${_messages.length} mesaj yuklendi');
        }
      } else {
        print(
            '❌ Messages API hatasi: ${response.statusCode} - ${response.body}');
      }
    } catch (e) {
      print('❌ Messages yukleme hatasi: $e');
    }
  }

  // Send a message to a chat room
  Future<bool> sendMessage(String roomId, String message) async {
    print('📤 Mesaj gonderiliyor: $message');

    try {
      final headers = await _getUserHeaders();
      final displayName = headers['display-name'] ?? 'Kullanici';

      final response = await http.post(
        Uri.parse('$baseUrl/rooms/$roomId/messages'),
        headers: headers,
        body: json.encode({
          'message': message,
          'displayName': displayName,
        }),
      );

      print('📡 Send message API Response: ${response.statusCode}');

      if (response.statusCode == 200 || response.statusCode == 201) {
        final data = json.decode(response.body);
        print('✅ Mesaj gonderildi: ${data['message']}');

        // Refresh messages after sending
        await fetchMessages(roomId);
        return true;
      } else {
        print(
            '❌ Mesaj gonderme hatasi: ${response.statusCode} - ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Send message hatasi: $e');
      return false;
    }
  }

  // Get room users (for debugging)
  Future<void> fetchRoomUsers(String roomId) async {
    print('👥 $roomId odasi kullanicilari yukleniyor...');

    try {
      final headers = await _getUserHeaders();

      final response = await http.get(
        Uri.parse('$baseUrl/rooms/$roomId/users'),
        headers: headers,
      );

      print('📡 Room users API Response: ${response.statusCode}');

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        if (data['success']) {
          final users = data['users'] ?? [];
          print('✅ ${users.length} aktif kullanici yuklendi');
        }
      }
    } catch (e) {
      print('❌ Room users yukleme hatasi: $e');
    }
  }

  // Get room by ID (needed by ChatScreen)
  Map<String, dynamic>? getRoomById(String roomId) {
    try {
      return _chatRooms.firstWhere((room) => room['id'] == roomId);
    } catch (e) {
      print('⚠️ Room bulunamadi: $roomId');
      return null;
    }
  }

  // Get room users (needed by ChatScreen)
  Future<List<Map<String, dynamic>>> getRoomUsers(String roomId) async {
    print('👥 $roomId odasi kullanicilari aliniyor...');

    try {
      final headers = await _getUserHeaders();

      final response = await http.get(
        Uri.parse('$baseUrl/rooms/$roomId/users'),
        headers: headers,
      );

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        if (data['success']) {
          final users = List<Map<String, dynamic>>.from(data['users'] ?? []);
          print('✅ ${users.length} kullanici alindi');
          return users;
        }
      }

      print('❌ Room users API hatasi: ${response.statusCode}');
      return [];
    } catch (e) {
      print('❌ Room users hatasi: $e');
      return [];
    }
  }

  // Clean up when leaving chat
  void dispose() {
    _messages.clear();
    _currentRoomId = null;
  }
}
