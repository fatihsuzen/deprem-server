import 'package:flutter/material.dart';
import 'dart:async';
import 'package:shared_preferences/shared_preferences.dart';
import '../services/chat_service.dart';
import '../services/auth_service.dart';
import '../l10n/app_localizations.dart';

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
  bool _isFavorite = false;

  @override
  void initState() {
    super.initState();
    _initializeChat();

    // Her 2 saniyede bir mesajları yenile (real-time hissi)
    _refreshTimer = Timer.periodic(const Duration(seconds: 2), (timer) {
      _refreshMessages();
    });
  }

  @override
  void dispose() {
    _refreshTimer?.cancel();
    _messageController.dispose();
    _scrollController.dispose();

    // Odadan ayrıl
    print('👋 Odadan ayrılınıyor: ${widget.roomId}');
    _chatService.leaveRoom(widget.roomId);

    super.dispose();
  }

  Future<void> _initializeChat() async {
    setState(() => _isLoading = true);

    try {
      await _authService.loadUserData();
      _currentUserId = _authService.currentUserId;

      // Odaya katıl (backend üyelik kontrolü için gerekli)
      print('🚪 Odaya katılınıyor: ${widget.roomId}');
      await _chatService.joinRoom(widget.roomId);

      // Room bilgilerini al
      _roomInfo = _chatService.getRoomById(widget.roomId);

      // Favori durumunu yükle
      await _loadFavoriteStatus();

      // Mesajları ve aktif kullanıcıları yükle
      await _loadChatData();
    } catch (e) {
      print('Chat ekran başlatma hatası: $e');
    }

    setState(() => _isLoading = false);
  }

  Future<void> _loadFavoriteStatus() async {
    final prefs = await SharedPreferences.getInstance();
    final favorites = prefs.getStringList('favorite_rooms') ?? [];
    setState(() {
      _isFavorite = favorites.contains(widget.roomId);
    });
  }

  Future<void> _toggleFavorite() async {
    final prefs = await SharedPreferences.getInstance();
    final favorites = prefs.getStringList('favorite_rooms') ?? [];

    setState(() {
      if (_isFavorite) {
        favorites.remove(widget.roomId);
        _isFavorite = false;
      } else {
        favorites.add(widget.roomId);
        _isFavorite = true;
      }
    });

    await prefs.setStringList('favorite_rooms', favorites);

    // Snackbar göster
    if (mounted) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text(
              _isFavorite ? 'Favorilere eklendi' : 'Favorilerden çıkarıldı'),
          duration: const Duration(seconds: 1),
          backgroundColor: _isFavorite ? Colors.green : Colors.grey,
        ),
      );
    }
  }

  Future<void> _loadChatData() async {
    await Future.wait([
      _chatService.fetchMessages(widget.roomId),
      _loadActiveUsers(),
    ]);

    // Scroll'u en alta kaydır (reverse=true olduğu için 0 position)
    WidgetsBinding.instance.addPostFrameCallback((_) {
      if (_scrollController.hasClients) {
        _scrollController.animateTo(
          0, // reverse ListView'de en son mesaj 0 position'da
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
      // Önceki mesaj sayısını kaydet
      final oldMessageCount = _chatService.messages.length;

      await _chatService.fetchMessages(widget.roomId);

      if (mounted) {
        final newMessageCount = _chatService.messages.length;
        setState(() {});

        // Yeni mesaj varsa scroll'u en alta kaydır
        if (newMessageCount > oldMessageCount) {
          WidgetsBinding.instance.addPostFrameCallback((_) {
            if (_scrollController.hasClients) {
              _scrollController.animateTo(
                0, // reverse ListView'de en son mesaj 0 position'da
                duration: const Duration(milliseconds: 300),
                curve: Curves.easeOut,
              );
            }
          });
        }
      }
    } catch (e) {
      print('Mesaj yenileme hatası: $e');
    }
  }

  Future<void> _sendMessage() async {
    final message = _messageController.text.trim();
    if (message.isEmpty) return;

    print('📤 MESAJ GÖNDERİLİYOR: $message');

    // UI'da mesajı hemen göster (optimistic update)
    _messageController.clear();

    try {
      final success = await _chatService.sendMessage(widget.roomId, message);
      print('📡 MESAJ GÖNDERİM SONUCU: $success');

      if (success) {
        setState(() {});
        print('🎯 STATE UPDATED - SCROLL BAŞLIYOR');

        // Scroll'u en alta kaydır (reverse=true olduğu için 0 position)
        WidgetsBinding.instance.addPostFrameCallback((_) {
          if (_scrollController.hasClients) {
            print('📜 SCROLL YAPILIYOR - position: 0');
            _scrollController.animateTo(
              0, // reverse ListView'de en son mesaj 0 position'da
              duration: const Duration(milliseconds: 300),
              curve: Curves.easeOut,
            );
          } else {
            print('❌ SCROLL CONTROLLER HAS NO CLIENTS');
          }
        });
      } else {
        print('❌ MESAJ GÖNDERİLEMEDİ - UI\'a geri koyuluyor');
        // Hata durumunda mesajı geri koy
        _messageController.text = message;
        if (mounted) {
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(
              content: Text(
                  AppLocalizations.of(context)!.get('message_send_failed')),
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
    final primaryColor = isDarkTheme
        ? Theme.of(context).colorScheme.primary
        : Colors.deepPurple[600];

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
                    '${_activeUsers.length} ${AppLocalizations.of(context)!.get('active_users_count')}',
                    style: TextStyle(
                      fontSize: 12,
                      color: Theme.of(context)
                          .colorScheme
                          .onPrimary
                          .withOpacity(0.8),
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
            onPressed: _toggleFavorite,
            icon: Icon(_isFavorite ? Icons.star : Icons.star_border),
            tooltip: _isFavorite
                ? AppLocalizations.of(context)!.get('remove_from_favorites')
                : AppLocalizations.of(context)!.get('add_to_favorites'),
            color: _isFavorite ? Colors.amber : Colors.white,
          ),
          IconButton(
            onPressed: _showActiveUsers,
            icon: const Icon(Icons.people),
            tooltip: AppLocalizations.of(context)!.get('active_users'),
          ),
          IconButton(
            onPressed: _refreshMessages,
            icon: const Icon(Icons.refresh),
            tooltip: AppLocalizations.of(context)!.get('refresh'),
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
    final messages =
        _chatService.messages.reversed.toList(); // Mesajları ters çevir
    final l10n = AppLocalizations.of(context);

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
              l10n?.get('no_messages_yet') ?? 'Henüz mesaj yok',
              style: TextStyle(
                fontSize: 16,
                color:
                    Theme.of(context).colorScheme.onBackground.withOpacity(0.6),
              ),
            ),
            const SizedBox(height: 8),
            Text(
              l10n?.get('send_first_message') ?? 'İlk mesajı siz gönderin! 👋',
              style: TextStyle(
                fontSize: 14,
                color:
                    Theme.of(context).colorScheme.onBackground.withOpacity(0.4),
              ),
            ),
          ],
        ),
      );
    }

    return ListView.builder(
      controller: _scrollController,
      reverse: true, // En son mesaj en altta görünsün
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
      padding: const EdgeInsets.symmetric(
          vertical: 2), // Mesajlar arası boşluk azaltıldı
      child: Row(
        mainAxisAlignment:
            isMyMessage ? MainAxisAlignment.end : MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.end,
        children: [
          Flexible(
            child: Container(
              padding: const EdgeInsets.symmetric(
                  horizontal: 12, vertical: 8), // Küçültülmüş padding
              decoration: BoxDecoration(
                color: isMyMessage
                    ? Theme.of(context).colorScheme.primary
                    : Theme.of(context).colorScheme.surfaceVariant,
                borderRadius: BorderRadius.circular(16).copyWith(
                  // Küçültülmüş radius
                  bottomLeft: Radius.circular(isMyMessage ? 16 : 4),
                  bottomRight: Radius.circular(isMyMessage ? 4 : 20),
                ),
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  if (!isMyMessage)
                    Padding(
                      padding: const EdgeInsets.only(
                          bottom: 2), // Küçültülmüş padding
                      child: Text(
                        message['displayName'] ?? 'Anonim',
                        style: TextStyle(
                          fontSize: 10, // Küçültülmüş font
                          fontWeight: FontWeight.w500, // Daha az kalın
                          color: Theme.of(context)
                              .colorScheme
                              .onSurfaceVariant
                              .withOpacity(0.6), // Daha soluk
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
                              ? Theme.of(context)
                                  .colorScheme
                                  .onPrimary
                                  .withOpacity(0.7)
                              : Theme.of(context)
                                  .colorScheme
                                  .onSurfaceVariant
                                  .withOpacity(0.7),
                        ),
                      ),
                    ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildMessageInput() {
    final l10n = AppLocalizations.of(context);
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
                  hintText: l10n?.get('type_message') ?? 'Mesajınızı yazın...',
                  hintStyle: TextStyle(
                    color: Theme.of(context)
                        .colorScheme
                        .onSurface
                        .withOpacity(0.5),
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
    final l10n = AppLocalizations.of(context);

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
                    '${l10n?.get('active_users') ?? 'Aktif Kullanıcılar'} (${_activeUsers.length})',
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
                  l10n?.get('no_active_users') ?? 'Henüz aktif kullanıcı yok',
                  style: TextStyle(
                    color: Theme.of(context)
                        .colorScheme
                        .onSurface
                        .withOpacity(0.6),
                  ),
                )
              else
                ...List.generate(_activeUsers.length, (index) {
                  final user = _activeUsers[index];
                  return ListTile(
                    leading: CircleAvatar(
                      backgroundColor: Theme.of(context)
                          .colorScheme
                          .primary
                          .withOpacity(0.2),
                      child: Text(
                        (user['displayName'] as String?)
                                ?.substring(0, 1)
                                .toUpperCase() ??
                            '?',
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
                        color: Theme.of(context)
                            .colorScheme
                            .onSurface
                            .withOpacity(0.6),
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
