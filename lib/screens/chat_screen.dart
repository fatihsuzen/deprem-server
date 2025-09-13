import 'package:flutter/material.dart';
import 'dart:async';
import '../services/chat_service.dart';
import '../services/auth_service.dart';

class ChatScreen extends StatefulWidget {
  final String roomId;

  const ChatScreen({super.key, required this.roomId});

  @override
  State<ChatScreen> createState() => _ChatScreenState();
}

class _ChatScreenState extends State<ChatScreen> {
  final ChatService _chatService = ChatService();
  final AuthService _authService = AuthService();
  final TextEditingController _messageController = TextEditingController();
  final ScrollController _scrollController = ScrollController();
  
  Timer? _refreshTimer;
  bool _isLoading = true;
  Map<String, dynamic>? _roomInfo;
  List<Map<String, dynamic>> _activeUsers = [];
  String? _currentUserId;

  @override
  void initState() {
    super.initState();
    _initializeChat();
    
    // Her 5 saniyede bir mesajları yenile
    _refreshTimer = Timer.periodic(const Duration(seconds: 5), (timer) {
      _refreshMessages();
    });
  }

  @override
  void dispose() {
    _refreshTimer?.cancel();
    _messageController.dispose();
    _scrollController.dispose();
    super.dispose();
  }

  Future<void> _initializeChat() async {
    setState(() => _isLoading = true);

    try {
      await _authService.loadUserData();
      _currentUserId = _authService.currentUserId;

      // Room bilgilerini al
      _roomInfo = _chatService.getRoomById(widget.roomId);
      
      // Mesajları ve aktif kullanıcıları yükle
      await _loadChatData();

    } catch (e) {
      print('Chat ekran başlatma hatası: $e');
    }

    setState(() => _isLoading = false);
  }

  Future<void> _loadChatData() async {
    await Future.wait([
      _chatService.fetchMessages(widget.roomId),
      _loadActiveUsers(),
    ]);

    // Scroll'u en alta kaydır
    WidgetsBinding.instance.addPostFrameCallback((_) {
      if (_scrollController.hasClients) {
        _scrollController.animateTo(
          _scrollController.position.maxScrollExtent,
          duration: const Duration(milliseconds: 300),
          curve: Curves.easeOut,
        );
      }
    });
  }

  Future<void> _loadActiveUsers() async {
    try {
      _activeUsers = await _chatService.getRoomUsers(widget.roomId);
    } catch (e) {
      print('Aktif kullanıcılar yükleme hatası: $e');
    }
  }

  Future<void> _refreshMessages() async {
    try {
      await _chatService.fetchMessages(widget.roomId);
      if (mounted) {
        setState(() {});
      }
    } catch (e) {
      print('Mesaj yenileme hatası: $e');
    }
  }

  Future<void> _sendMessage() async {
    final message = _messageController.text.trim();
    if (message.isEmpty) return;

    // UI'da mesajı hemen göster (optimistic update)
    _messageController.clear();
    
    try {
      final success = await _chatService.sendMessage(widget.roomId, message);
      
      if (success) {
        setState(() {});
        
        // Scroll'u en alta kaydır
        WidgetsBinding.instance.addPostFrameCallback((_) {
          if (_scrollController.hasClients) {
            _scrollController.animateTo(
              _scrollController.position.maxScrollExtent,
              duration: const Duration(milliseconds: 300),
              curve: Curves.easeOut,
            );
          }
        });
      } else {
        // Hata durumunda mesajı geri koy
        _messageController.text = message;
        if (mounted) {
          ScaffoldMessenger.of(context).showSnackBar(
            const SnackBar(
              content: Text('Mesaj gönderilemedi. Tekrar deneyin.'),
              backgroundColor: Colors.red,
            ),
          );
        }
      }
    } catch (e) {
      print('Mesaj gönderme hatası: $e');
      _messageController.text = message;
    }
  }

  @override
  Widget build(BuildContext context) {
    final isDarkTheme = Theme.of(context).brightness == Brightness.dark;
    final primaryColor = isDarkTheme ? Theme.of(context).colorScheme.primary : Colors.deepPurple[600];

    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      appBar: AppBar(
        title: Row(
          children: [
            Text(
              _roomInfo?['flag'] ?? '💬',
              style: const TextStyle(fontSize: 20),
            ),
            const SizedBox(width: 8),
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    _roomInfo?['name'] ?? 'Chat',
                    style: TextStyle(
                      fontSize: 16,
                      fontWeight: FontWeight.bold,
                      color: Theme.of(context).colorScheme.onPrimary,
                    ),
                  ),
                  Text(
                    '${_activeUsers.length} aktif kullanıcı',
                    style: TextStyle(
                      fontSize: 12,
                      color: Theme.of(context).colorScheme.onPrimary.withOpacity(0.8),
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
        backgroundColor: primaryColor,
        foregroundColor: Theme.of(context).colorScheme.onPrimary,
        actions: [
          IconButton(
            onPressed: _showActiveUsers,
            icon: const Icon(Icons.people),
            tooltip: 'Aktif Kullanıcılar',
          ),
          IconButton(
            onPressed: _refreshMessages,
            icon: const Icon(Icons.refresh),
            tooltip: 'Yenile',
          ),
        ],
      ),
      body: _isLoading
          ? Center(
              child: CircularProgressIndicator(
                color: Theme.of(context).colorScheme.primary,
              ),
            )
          : Column(
              children: [
                // Messages area
                Expanded(
                  child: _buildMessagesList(),
                ),
                
                // Message input
                _buildMessageInput(),
              ],
            ),
    );
  }

  Widget _buildMessagesList() {
    final messages = _chatService.messages;

    if (messages.isEmpty) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(
              Icons.chat_bubble_outline,
              size: 60,
              color: Theme.of(context).colorScheme.primary.withOpacity(0.5),
            ),
            const SizedBox(height: 16),
            Text(
              'Henüz mesaj yok',
              style: TextStyle(
                fontSize: 16,
                color: Theme.of(context).colorScheme.onBackground.withOpacity(0.6),
              ),
            ),
            const SizedBox(height: 8),
            Text(
              'İlk mesajı siz gönderin! 👋',
              style: TextStyle(
                fontSize: 14,
                color: Theme.of(context).colorScheme.onBackground.withOpacity(0.4),
              ),
            ),
          ],
        ),
      );
    }

    return ListView.builder(
      controller: _scrollController,
      padding: const EdgeInsets.all(16),
      itemCount: messages.length,
      itemBuilder: (context, index) {
        final message = messages[index];
        final isMyMessage = message['uid'] == _currentUserId;
        return _buildMessageBubble(message, isMyMessage);
      },
    );
  }

  Widget _buildMessageBubble(Map<String, dynamic> message, bool isMyMessage) {
    final timestamp = message['timestamp'] as String?;
    DateTime? messageTime;
    
    if (timestamp != null) {
      messageTime = DateTime.tryParse(timestamp);
    }

    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 4),
      child: Row(
        mainAxisAlignment: isMyMessage ? MainAxisAlignment.end : MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.end,
        children: [
          if (!isMyMessage) ...[
            CircleAvatar(
              radius: 16,
              backgroundColor: Theme.of(context).colorScheme.primary.withOpacity(0.2),
              child: Text(
                (message['displayName'] as String?)?.substring(0, 1).toUpperCase() ?? '?',
                style: TextStyle(
                  fontSize: 12,
                  fontWeight: FontWeight.bold,
                  color: Theme.of(context).colorScheme.primary,
                ),
              ),
            ),
            const SizedBox(width: 8),
          ],
          
          Flexible(
            child: Container(
              padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 10),
              decoration: BoxDecoration(
                color: isMyMessage
                    ? Theme.of(context).colorScheme.primary
                    : Theme.of(context).colorScheme.surfaceVariant,
                borderRadius: BorderRadius.circular(20).copyWith(
                  bottomLeft: Radius.circular(isMyMessage ? 20 : 4),
                  bottomRight: Radius.circular(isMyMessage ? 4 : 20),
                ),
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  if (!isMyMessage)
                    Padding(
                      padding: const EdgeInsets.only(bottom: 4),
                      child: Text(
                        message['displayName'] ?? 'Anonim',
                        style: TextStyle(
                          fontSize: 12,
                          fontWeight: FontWeight.bold,
                          color: Theme.of(context).colorScheme.onSurfaceVariant.withOpacity(0.7),
                        ),
                      ),
                    ),
                  Text(
                    message['message'] ?? '',
                    style: TextStyle(
                      fontSize: 16,
                      color: isMyMessage
                          ? Theme.of(context).colorScheme.onPrimary
                          : Theme.of(context).colorScheme.onSurfaceVariant,
                    ),
                  ),
                  if (messageTime != null)
                    Padding(
                      padding: const EdgeInsets.only(top: 4),
                      child: Text(
                        '${messageTime.hour.toString().padLeft(2, '0')}:${messageTime.minute.toString().padLeft(2, '0')}',
                        style: TextStyle(
                          fontSize: 10,
                          color: isMyMessage
                              ? Theme.of(context).colorScheme.onPrimary.withOpacity(0.7)
                              : Theme.of(context).colorScheme.onSurfaceVariant.withOpacity(0.7),
                        ),
                      ),
                    ),
                ],
              ),
            ),
          ),
          
          if (isMyMessage) ...[
            const SizedBox(width: 8),
            CircleAvatar(
              radius: 16,
              backgroundColor: Theme.of(context).colorScheme.primary.withOpacity(0.2),
              child: Text(
                (message['displayName'] as String?)?.substring(0, 1).toUpperCase() ?? '?',
                style: TextStyle(
                  fontSize: 12,
                  fontWeight: FontWeight.bold,
                  color: Theme.of(context).colorScheme.primary,
                ),
              ),
            ),
          ],
        ],
      ),
    );
  }

  Widget _buildMessageInput() {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: Theme.of(context).colorScheme.surface,
        border: Border(
          top: BorderSide(
            color: Theme.of(context).colorScheme.outline.withOpacity(0.2),
          ),
        ),
      ),
      child: SafeArea(
        child: Row(
          children: [
            Expanded(
              child: TextField(
                controller: _messageController,
                decoration: InputDecoration(
                  hintText: 'Mesajınızı yazın...',
                  hintStyle: TextStyle(
                    color: Theme.of(context).colorScheme.onSurface.withOpacity(0.5),
                  ),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(25),
                    borderSide: BorderSide.none,
                  ),
                  filled: true,
                  fillColor: Theme.of(context).colorScheme.background,
                  contentPadding: const EdgeInsets.symmetric(
                    horizontal: 20,
                    vertical: 10,
                  ),
                ),
                maxLines: null,
                textInputAction: TextInputAction.send,
                onSubmitted: (_) => _sendMessage(),
              ),
            ),
            const SizedBox(width: 12),
            CircleAvatar(
              backgroundColor: Theme.of(context).colorScheme.primary,
              child: IconButton(
                onPressed: _sendMessage,
                icon: Icon(
                  Icons.send,
                  color: Theme.of(context).colorScheme.onPrimary,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  void _showActiveUsers() {
    showModalBottomSheet(
      context: context,
      backgroundColor: Theme.of(context).colorScheme.surface,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (context) {
        return Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Row(
                children: [
                  Icon(
                    Icons.people,
                    color: Theme.of(context).colorScheme.primary,
                  ),
                  const SizedBox(width: 8),
                  Text(
                    'Aktif Kullanıcılar (${_activeUsers.length})',
                    style: TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.bold,
                      color: Theme.of(context).colorScheme.onSurface,
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 16),
              if (_activeUsers.isEmpty)
                Text(
                  'Henüz aktif kullanıcı yok',
                  style: TextStyle(
                    color: Theme.of(context).colorScheme.onSurface.withOpacity(0.6),
                  ),
                )
              else
                ...List.generate(_activeUsers.length, (index) {
                  final user = _activeUsers[index];
                  return ListTile(
                    leading: CircleAvatar(
                      backgroundColor: Theme.of(context).colorScheme.primary.withOpacity(0.2),
                      child: Text(
                        (user['displayName'] as String?)?.substring(0, 1).toUpperCase() ?? '?',
                        style: TextStyle(
                          fontWeight: FontWeight.bold,
                          color: Theme.of(context).colorScheme.primary,
                        ),
                      ),
                    ),
                    title: Text(
                      user['displayName'] ?? 'Anonim',
                      style: TextStyle(
                        color: Theme.of(context).colorScheme.onSurface,
                      ),
                    ),
                    subtitle: Text(
                      user['uid'] == _currentUserId ? 'Siz' : 'Aktif',
                      style: TextStyle(
                        fontSize: 12,
                        color: Theme.of(context).colorScheme.onSurface.withOpacity(0.6),
                      ),
                    ),
                  );
                }),
            ],
          ),
        );
      },
    );
  }
}