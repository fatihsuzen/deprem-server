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
    final displayName = (_authService.currentUserName ?? 'Kullanıcı')
        .replaceAll(' ', '_') // HTTP header'larda boşluk olamaz
        .replaceAll('ş', 's') // Türkçe karakter sorunları için
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
    print('🏠 Chat rooms yükleniyor...');

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
          print('✅ ${_chatRooms.length} oda yüklendi');

          // Print loaded rooms
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
      final headers = await _getUserHeaders();
      final displayName = headers['display-name'] ?? 'Kullanıcı';

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
      final headers = await _getUserHeaders();

      final response = await http.post(
        Uri.parse('$baseUrl/rooms/$roomId/leave'),
        headers: headers,
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
      final headers = await _getUserHeaders();
      final displayName = headers['display-name'] ?? 'Kullanıcı';

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
        print('✅ Mesaj gönderildi: ${data['message']}');

        // Refresh messages after sending
        await fetchMessages(roomId);
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

  // Get room users (for debugging)
  Future<void> fetchRoomUsers(String roomId) async {
    print('👥 $roomId odası kullanıcıları yükleniyor...');

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
          print('✅ ${users.length} aktif kullanıcı yüklendi');
        }
      }
    } catch (e) {
      print('❌ Room users yükleme hatası: $e');
    }
  }

  // Get room by ID (needed by ChatScreen)
  Map<String, dynamic>? getRoomById(String roomId) {
    try {
      return _chatRooms.firstWhere((room) => room['id'] == roomId);
    } catch (e) {
      print('⚠️ Room bulunamadı: $roomId');
      return null;
    }
  }

  // Get room users (needed by ChatScreen)
  Future<List<Map<String, dynamic>>> getRoomUsers(String roomId) async {
    print('👥 $roomId odası kullanıcıları alınıyor...');

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
          print('✅ ${users.length} kullanıcı alındı');
          return users;
        }
      }

      print('❌ Room users API hatası: ${response.statusCode}');
      return [];
    } catch (e) {
      print('❌ Room users hatası: $e');
      return [];
    }
  }

  // Clean up when leaving chat
  void dispose() {
    _messages.clear();
    _currentRoomId = null;
  }
}
