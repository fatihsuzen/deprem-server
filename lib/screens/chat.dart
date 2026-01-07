import 'package:flutter/material.dart';
import 'dart:async';
import '../services/chat_service.dart';
import '../services/auth_service.dart';
import '../l10n/app_localizations.dart';
import 'chat_screen.dart';

class ChatPage extends StatefulWidget {
  @override
  _ChatPageState createState() => _ChatPageState();
}

class _ChatPageState extends State<ChatPage> {
  final ChatService _chatService = ChatService();
  final AuthService _authService = AuthService();
  bool _isLoading = true;
  bool _isLoggedIn = false;

  @override
  void initState() {
    super.initState();
    _initializeScreen();
  }

  Future<void> _initializeScreen() async {
    setState(() => _isLoading = true);

    try {
      await _authService.loadUserData();
      setState(() {
        _isLoggedIn = _authService.isLoggedIn;
      });

      if (_isLoggedIn) {
        await _chatService.fetchChatRooms();
      }
    } catch (e) {
      print('Chat rooms ekran başlatma hatası: $e');
    }

    setState(() => _isLoading = false);
  }

  Future<void> _refreshRooms() async {
    if (_isLoggedIn) {
      await _chatService.fetchChatRooms();
      setState(() {});
    }
  }

  void _openChatRoom(Map<String, dynamic> room) {
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => ChatScreen(roomId: room['id']),
      ),
    ).then((_) {
      // Chat screen'den dönünce odaları yenile
      _refreshRooms();
    });
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context);

    if (_isLoading) {
      return Center(
        child: CircularProgressIndicator(
          color: Color(0xFFFF3A3D),
        ),
      );
    }

    if (!_isLoggedIn) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.login, size: 64, color: Colors.grey[400]),
            SizedBox(height: 16),
            Text(
              l10n?.get('login_required_chat') ?? 'Please login to access chat',
              style: TextStyle(fontSize: 16, color: Colors.grey[600]),
            ),
          ],
        ),
      );
    }

    final chatRooms = _chatService.chatRooms;

    if (chatRooms.isEmpty) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.chat_bubble_outline, size: 64, color: Colors.grey[400]),
            SizedBox(height: 16),
            Text(
              l10n?.get('loading_chat_rooms') ?? 'Loading chat rooms...',
              style: TextStyle(fontSize: 16, color: Colors.grey[600]),
            ),
          ],
        ),
      );
    }

    return Column(
      children: [
        // Chat odaları listesi
        Expanded(
          child: RefreshIndicator(
            onRefresh: _refreshRooms,
            color: Color(0xFFFF3A3D),
            child: ListView.builder(
              padding: EdgeInsets.all(16),
              itemCount: chatRooms.length,
              itemBuilder: (context, index) {
                return _buildChatRoomCard(chatRooms[index]);
              },
            ),
          ),
        ),
      ],
    );
  }

  Widget _buildChatRoomCard(Map<String, dynamic> room) {
    final activeUserCount = room['activeUserCount'] ?? 0;
    final lastMessage = room['lastMessage'];

    return Container(
      margin: EdgeInsets.only(bottom: 12),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: Colors.grey[200]!),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.05),
            blurRadius: 8,
            offset: Offset(0, 2),
          ),
        ],
      ),
      child: Material(
        color: Colors.transparent,
        child: InkWell(
          onTap: () => _openChatRoom(room),
          borderRadius: BorderRadius.circular(16),
          child: Padding(
            padding: EdgeInsets.all(16),
            child: Row(
              children: [
                // Şehir/Oda ikonu
                Container(
                  width: 56,
                  height: 56,
                  decoration: BoxDecoration(
                    color: Color(0xFFFF3A3D).withOpacity(0.1),
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: Center(
                    child: Text(
                      room['flag'] ?? room['name']?.substring(0, 1) ?? '?',
                      style: TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ),
                SizedBox(width: 16),

                // Oda bilgileri
                Expanded(
                  child: Builder(
                    builder: (context) {
                      final l10n = AppLocalizations.of(context);
                      return Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Row(
                            children: [
                              Text(
                                room['name'] ??
                                    l10n?.get('unnamed_room') ??
                                    'Unnamed Room',
                                style: TextStyle(
                                  fontSize: 17,
                                  fontWeight: FontWeight.bold,
                                  color: Colors.black87,
                                ),
                              ),
                            ],
                          ),
                          SizedBox(height: 6),
                          Row(
                            children: [
                              Icon(Icons.people,
                                  size: 14, color: Colors.grey[600]),
                              SizedBox(width: 4),
                              Text(
                                '$activeUserCount ${l10n?.get('members') ?? 'members'}',
                                style: TextStyle(
                                  fontSize: 12,
                                  color: Colors.grey[600],
                                ),
                              ),
                              if (lastMessage != null) ...[
                                SizedBox(width: 12),
                                Icon(Icons.access_time,
                                    size: 14, color: Colors.grey[600]),
                                SizedBox(width: 4),
                                Text(
                                  l10n?.get('just_now') ?? 'Just now',
                                  style: TextStyle(
                                    fontSize: 12,
                                    color: Colors.grey[600],
                                  ),
                                ),
                              ],
                            ],
                          ),
                          if (lastMessage != null) ...[
                            SizedBox(height: 6),
                            Text(
                              '${lastMessage['displayName']}: ${lastMessage['message']}',
                              style: TextStyle(
                                fontSize: 13,
                                color: Colors.grey[700],
                              ),
                              maxLines: 1,
                              overflow: TextOverflow.ellipsis,
                            ),
                          ],
                        ],
                      );
                    },
                  ),
                ),

                // Chevron
                Icon(
                  Icons.chevron_right,
                  color: Colors.grey[400],
                  size: 24,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
