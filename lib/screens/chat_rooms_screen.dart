import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../services/chat_service.dart';
import '../services/auth_service.dart';
import 'chat_screen.dart';

class ChatRoomsScreen extends StatefulWidget {
  const ChatRoomsScreen({super.key});

  @override
  State<ChatRoomsScreen> createState() => _ChatRoomsScreenState();
}

class _ChatRoomsScreenState extends State<ChatRoomsScreen> {
  final ChatService _chatService = ChatService();
  final AuthService _authService = AuthService();
  bool _isLoading = true;
  bool _isLoggedIn = false;
  String? _userName;
  Set<String> _favoriteRooms = {}; // Favori oda ID'leri
  late SharedPreferences _prefs;

  @override
  void initState() {
    super.initState();
    _initializeScreen();
  }

  Future<void> _initializeScreen() async {
    setState(() => _isLoading = true);

    try {
      // SharedPreferences'i başlat
      _prefs = await SharedPreferences.getInstance();

      // Favori odaları yükle
      await _loadFavoriteRooms();

      await _authService.loadUserData();
      setState(() {
        _isLoggedIn = _authService.isLoggedIn;
        _userName = _authService.currentUserName;
      });

      if (_isLoggedIn) {
        await _chatService.fetchChatRooms();
      }
    } catch (e) {
      print('Chat rooms ekran başlatma hatası: $e');
    }

    setState(() => _isLoading = false);
  }

  Future<void> _loadFavoriteRooms() async {
    final favorites = _prefs.getStringList('favorite_rooms') ?? [];
    setState(() {
      _favoriteRooms = Set.from(favorites);
    });
  }

  Future<void> _toggleFavorite(String roomId) async {
    setState(() {
      if (_favoriteRooms.contains(roomId)) {
        _favoriteRooms.remove(roomId);
        print('⭐ Favorilerden çıkarıldı: $roomId');
      } else {
        _favoriteRooms.add(roomId);
        print('⭐ Favorilere eklendi: $roomId');
      }
    });

    // SharedPreferences'e kaydet
    await _prefs.setStringList('favorite_rooms', _favoriteRooms.toList());
    print('💾 Favori odalar kaydedildi: ${_favoriteRooms.toList()}');

    // Kullanıcıya feedback göster
    if (mounted) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text(
            _favoriteRooms.contains(roomId)
                ? '⭐ Favorilere eklendi'
                : '✓ Favorilerden çıkarıldı',
          ),
          duration: const Duration(milliseconds: 1000),
          behavior: SnackBarBehavior.floating,
        ),
      );
    }
  }

  bool _isFavorite(String roomId) {
    return _favoriteRooms.contains(roomId);
  }

  Future<void> _refreshRooms() async {
    if (_isLoggedIn) {
      await _chatService.fetchChatRooms();
      setState(() {});
    }
  }

  @override
  Widget build(BuildContext context) {
    final primaryColor = Theme.of(context).colorScheme.primary;

    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      appBar: AppBar(
        title: Text(
          '💬 Chat Odaları',
          style: TextStyle(
            fontWeight: FontWeight.bold,
            color: Theme.of(context).colorScheme.onPrimary,
          ),
        ),
        backgroundColor: primaryColor,
        foregroundColor: Theme.of(context).colorScheme.onPrimary,
        actions: [
          IconButton(
            onPressed: _refreshRooms,
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
          : !_isLoggedIn
              ? _buildLoginRequired()
              : _buildChatRooms(),
    );
  }

  Widget _buildLoginRequired() {
    return Center(
      child: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(
              Icons.login,
              size: 80,
              color: Theme.of(context).colorScheme.primary.withOpacity(0.5),
            ),
            const SizedBox(height: 20),
            Text(
              'Chat Odalarına Erişim',
              style: TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
                color: Theme.of(context).colorScheme.onBackground,
              ),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 15),
            Text(
              'Chat odalarını kullanmak için giriş yapmanız gerekiyor.',
              style: TextStyle(
                fontSize: 16,
                color:
                    Theme.of(context).colorScheme.onBackground.withOpacity(0.7),
              ),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 30),
            ElevatedButton.icon(
              onPressed: () {
                Navigator.pop(context);
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Theme.of(context).colorScheme.primary,
                foregroundColor: Theme.of(context).colorScheme.onPrimary,
                padding:
                    const EdgeInsets.symmetric(horizontal: 30, vertical: 15),
              ),
              icon: const Icon(Icons.arrow_back),
              label: const Text(
                'Ana Sayfaya Dön',
                style: TextStyle(fontSize: 16),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildChatRooms() {
    final rooms = _chatService.chatRooms;

    if (rooms.isEmpty) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(
              Icons.chat_bubble_outline,
              size: 80,
              color: Theme.of(context).colorScheme.primary.withOpacity(0.5),
            ),
            const SizedBox(height: 20),
            Text(
              'Chat Odaları Yükleniyor...',
              style: TextStyle(
                fontSize: 18,
                color:
                    Theme.of(context).colorScheme.onBackground.withOpacity(0.7),
              ),
            ),
          ],
        ),
      );
    }

    // Odaları favorilere göre sırala
    final sortedRooms = _sortRoomsByFavorites(rooms);

    return RefreshIndicator(
      onRefresh: _refreshRooms,
      child: Column(
        children: [
          // Header with user info
          Container(
            width: double.infinity,
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              gradient: LinearGradient(
                begin: Alignment.topCenter,
                end: Alignment.bottomCenter,
                colors: [
                  Theme.of(context).colorScheme.primaryContainer,
                  Theme.of(context).colorScheme.background,
                ],
              ),
            ),
            child: Column(
              children: [
                Text(
                  'Merhaba, $_userName! 👋',
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                    color: Theme.of(context).colorScheme.onBackground,
                  ),
                ),
                const SizedBox(height: 6),
                Text(
                  'Sohbet etmek icin bir oda secin',
                  style: TextStyle(
                    fontSize: 13,
                    color: Theme.of(context)
                        .colorScheme
                        .onBackground
                        .withOpacity(0.7),
                  ),
                ),
              ],
            ),
          ),

          // Rooms list
          Expanded(
            child: ListView.separated(
              padding: const EdgeInsets.all(12),
              itemCount: sortedRooms.length,
              separatorBuilder: (context, index) => const SizedBox(height: 8),
              itemBuilder: (context, index) {
                final room = sortedRooms[index];
                return _buildRoomCard(room);
              },
            ),
          ),
        ],
      ),
    );
  }

  List<Map<String, dynamic>> _sortRoomsByFavorites(
      List<Map<String, dynamic>> rooms) {
    // Favori odaları öne çıkar
    final favoriteRooms =
        rooms.where((room) => _isFavorite(room['id'])).toList();
    final nonFavoriteRooms =
        rooms.where((room) => !_isFavorite(room['id'])).toList();

    print(
        '📊 Sıralama: ${favoriteRooms.length} favori, ${nonFavoriteRooms.length} normal oda');
    if (favoriteRooms.isNotEmpty) {
      print(
          '⭐ Favori odalar: ${favoriteRooms.map((r) => r['name']).join(', ')}');
    }

    return [...favoriteRooms, ...nonFavoriteRooms];
  }

  Widget _buildRoomCard(Map<String, dynamic> room) {
    final isDarkTheme = Theme.of(context).brightness == Brightness.dark;
    final activeUserCount = room['activeUserCount'] ?? 0;
    final lastMessage = room['lastMessage'];
    final isFavorite = _isFavorite(room['id']);

    return Stack(
      children: [
        Card(
          elevation: isFavorite ? 6 : 4,
          color: isFavorite
              ? Theme.of(context).colorScheme.primaryContainer.withOpacity(0.3)
              : Theme.of(context).colorScheme.surface,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(16),
            side: isFavorite
                ? BorderSide(
                    color: Colors.amber.withOpacity(0.5),
                    width: 2,
                  )
                : BorderSide.none,
          ),
          child: InkWell(
            borderRadius: BorderRadius.circular(16),
            onTap: () {
              print('🔵 Karta tıklandı: ${room['id']}');
              _joinRoom(room);
            },
            child: Padding(
              padding: const EdgeInsets.all(12),
              child: Row(
                children: [
                  // Boşluk bırak yıldız için (sol tarafta)
                  const SizedBox(width: 44),

                  // Flag and name
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Row(
                          children: [
                            Text(
                              room['flag'] ?? '🌍',
                              style: const TextStyle(fontSize: 20),
                            ),
                            const SizedBox(width: 10),
                            Expanded(
                              child: Text(
                                room['name'] ?? 'Adsiz Oda',
                                style: TextStyle(
                                  fontSize: 16,
                                  fontWeight: FontWeight.bold,
                                  color:
                                      Theme.of(context).colorScheme.onSurface,
                                ),
                              ),
                            ),
                          ],
                        ),
                        const SizedBox(height: 4),
                        Text(
                          room['description'] ?? '',
                          style: TextStyle(
                            fontSize: 12,
                            color: Theme.of(context)
                                .colorScheme
                                .onSurface
                                .withOpacity(0.6),
                          ),
                        ),
                        if (lastMessage != null) ...[
                          const SizedBox(height: 6),
                          Container(
                            padding: const EdgeInsets.symmetric(
                                horizontal: 6, vertical: 3),
                            decoration: BoxDecoration(
                              color: isDarkTheme
                                  ? Theme.of(context)
                                      .colorScheme
                                      .primaryContainer
                                      .withOpacity(0.3)
                                  : Colors.grey.shade100,
                              borderRadius: BorderRadius.circular(6),
                            ),
                            child: Text(
                              '${lastMessage['displayName']}: ${lastMessage['message']}',
                              style: TextStyle(
                                fontSize: 11,
                                color: Theme.of(context)
                                    .colorScheme
                                    .onSurface
                                    .withOpacity(0.8),
                              ),
                              maxLines: 1,
                              overflow: TextOverflow.ellipsis,
                            ),
                          ),
                        ],
                      ],
                    ),
                  ),

                  // User count and arrow
                  Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      // User count
                      Container(
                        padding: const EdgeInsets.symmetric(
                            horizontal: 10, vertical: 4),
                        decoration: BoxDecoration(
                          color: activeUserCount > 0
                              ? Colors.green.withOpacity(0.2)
                              : Colors.grey.withOpacity(0.2),
                          borderRadius: BorderRadius.circular(16),
                        ),
                        child: Row(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            Icon(
                              Icons.people,
                              size: 14,
                              color: activeUserCount > 0
                                  ? Colors.green.shade700
                                  : Colors.grey.shade600,
                            ),
                            const SizedBox(width: 3),
                            Text(
                              '$activeUserCount',
                              style: TextStyle(
                                fontSize: 13,
                                fontWeight: FontWeight.bold,
                                color: activeUserCount > 0
                                    ? Colors.green.shade700
                                    : Colors.grey.shade600,
                              ),
                            ),
                          ],
                        ),
                      ),
                      const SizedBox(height: 6),
                      Icon(
                        Icons.arrow_forward_ios,
                        size: 14,
                        color: Theme.of(context).colorScheme.primary,
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ),
        ),
        // Yıldız ikonu - Stack ile kartın üstünde (sol tarafta)
        Positioned(
          left: 4,
          top: 4,
          child: GestureDetector(
            onTap: () {
              print('🌟 Yıldıza tıklandı: ${room['id']}');
              _toggleFavorite(room['id']);
            },
            child: Container(
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Colors.white.withOpacity(0.9),
                borderRadius: BorderRadius.circular(20),
                boxShadow: [
                  BoxShadow(
                    color: Colors.black.withOpacity(0.1),
                    blurRadius: 4,
                    offset: const Offset(0, 2),
                  ),
                ],
              ),
              child: Icon(
                isFavorite ? Icons.star : Icons.star_border,
                color: isFavorite ? Colors.amber : Colors.grey.shade600,
                size: 24,
              ),
            ),
          ),
        ),
      ],
    );
  }

  Future<void> _joinRoom(Map<String, dynamic> room) async {
    final roomId = room['id'];
    final roomName = room['name'];

    print('🚪 $roomName odasina katilmaya calisiyor...');

    // Loading dialog göster
    showDialog(
      context: context,
      barrierDismissible: false,
      builder: (context) => AlertDialog(
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            CircularProgressIndicator(
              color: Theme.of(context).colorScheme.primary,
            ),
            const SizedBox(height: 16),
            Text(
              '$roomName odasina katiliniyor...',
              style: TextStyle(
                color: Theme.of(context).colorScheme.onSurface,
              ),
            ),
          ],
        ),
      ),
    );

    try {
      final success = await _chatService.joinRoom(roomId);

      if (mounted) {
        Navigator.pop(context); // Loading dialog'unu kapat

        if (success) {
          // Chat screen'e git
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => ChatScreen(roomId: roomId),
            ),
          ).then((_) {
            // Chat screen'den donunce odalardan ayril
            _chatService.leaveRoom(roomId);
            _refreshRooms();
          });
        } else {
          // Hata mesajı göster
          ScaffoldMessenger.of(context).showSnackBar(
            const SnackBar(
              content: Text('Odaya katilma hatasi. Lutfen tekrar deneyin.'),
              backgroundColor: Colors.red,
            ),
          );
        }
      }
    } catch (e) {
      if (mounted) {
        Navigator.pop(context); // Loading dialog'unu kapat

        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text('Hata: $e'),
            backgroundColor: Colors.red,
          ),
        );
      }
    }
  }
}
