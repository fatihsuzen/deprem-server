import 'package:flutter/material.dart';
import '../services/friends_service_minimal.dart';

class FriendsScreen extends StatefulWidget {
  const FriendsScreen({super.key});

  @override
  State<FriendsScreen> createState() => _FriendsScreenState();
}

class _FriendsScreenState extends State<FriendsScreen>
    with TickerProviderStateMixin {
  final FriendsService _friendsService = FriendsService();
  final TextEditingController _shareCodeController = TextEditingController();

  late TabController _tabController;
  bool _isLoading = false;
  String _shareCode = '';

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 3, vsync: this);
    _loadData();
  }

  @override
  void dispose() {
    _tabController.dispose();
    _shareCodeController.dispose();
    super.dispose();
  }

  Future<void> _loadData() async {
    setState(() => _isLoading = true);

    try {
      await _friendsService.fetchFriends();
      await _friendsService.fetchPendingRequests();
      await _loadShareCode();
    } catch (e) {
      print('Veri yükleme hatası: $e');
    }

    setState(() => _isLoading = false);
  }

  Future<void> _loadShareCode() async {
    final code = await _friendsService.getShareCode();
    setState(() => _shareCode = code);
  }

  @override
  Widget build(BuildContext context) {
    final isDarkTheme = Theme.of(context).brightness == Brightness.dark;
    final primaryColor = isDarkTheme
        ? Theme.of(context).colorScheme.primary
        : Colors.deepOrange[600];

    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      appBar: AppBar(
        title: Text(
          '👥 Arkadaşlarım',
          style: TextStyle(
            fontWeight: FontWeight.bold,
            color: Theme.of(context).colorScheme.onPrimary,
          ),
        ),
        backgroundColor: primaryColor,
        foregroundColor: Theme.of(context).colorScheme.onPrimary,
        bottom: TabBar(
          controller: _tabController,
          labelColor: Theme.of(context).colorScheme.onPrimary,
          unselectedLabelColor: isDarkTheme
              ? Theme.of(context).colorScheme.onPrimary.withOpacity(0.6)
              : Colors.deepOrange[200],
          indicatorColor: Theme.of(context).colorScheme.onPrimary,
          tabs: [
            Tab(
              text: 'Arkadaşlarım (${_friendsService.friendCount ?? 0})',
              icon: const Icon(Icons.people),
            ),
            Tab(
              text: 'İstekler (${_friendsService.pendingRequestCount ?? 0})',
              icon: const Icon(Icons.person_add),
            ),
            Tab(
              text: 'Arkadaş Ekle',
              icon: const Icon(Icons.add_circle),
            ),
          ],
        ),
      ),
      body: _isLoading
          ? Center(
              child: CircularProgressIndicator(
                color: Theme.of(context).colorScheme.primary,
              ),
            )
          : TabBarView(
              controller: _tabController,
              children: [
                _buildFriendsTab(),
                _buildRequestsTab(),
                _buildAddFriendTab(),
              ],
            ),
    );
  }

  Widget _buildFriendsTab() {
    final friends = _friendsService.friends;

    if (friends.isEmpty) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.people_outline, size: 80, color: Colors.grey[400]),
            const SizedBox(height: 16),
            Text(
              'Henüz arkadaşın yok',
              style: TextStyle(fontSize: 18, color: Colors.grey[600]),
            ),
            const SizedBox(height: 8),
            Text(
              'Arkadaş eklemek için + tuşuna bas',
              style: TextStyle(color: Colors.grey[500]),
            ),
          ],
        ),
      );
    }

    return ListView.builder(
      padding: const EdgeInsets.all(16),
      itemCount: friends.length,
      itemBuilder: (context, index) {
        final friend = friends[index];
        final name = friend['displayName']?.toString() ?? 'Bilinmeyen';
        final lastSeenData = friend['lastSeen'];

        // LastSeen parsing
        DateTime? lastSeenTime;
        if (lastSeenData != null) {
          if (lastSeenData is String) {
            lastSeenTime = DateTime.tryParse(lastSeenData);
          }
        }
        lastSeenTime ??= DateTime.now().subtract(const Duration(hours: 1));

        final timeAgo = _formatTimeAgo(lastSeenTime);
        final isRecent = DateTime.now().difference(lastSeenTime).inMinutes < 30;

        return Card(
          elevation: 2,
          margin: const EdgeInsets.only(bottom: 12),
          child: ListTile(
            contentPadding: const EdgeInsets.all(16),
            leading: Stack(
              children: [
                CircleAvatar(
                  radius: 25,
                  backgroundColor: Colors.deepOrange[100],
                  child: Text(
                    name.isNotEmpty ? name[0].toUpperCase() : '?',
                    style: TextStyle(
                      color: Colors.deepOrange[800],
                      fontWeight: FontWeight.bold,
                      fontSize: 20,
                    ),
                  ),
                ),
                if (isRecent)
                  Positioned(
                    right: 0,
                    bottom: 0,
                    child: Container(
                      width: 16,
                      height: 16,
                      decoration: const BoxDecoration(
                        color: Colors.green,
                        shape: BoxShape.circle,
                        border: Border.fromBorderSide(
                          BorderSide(color: Colors.white, width: 2),
                        ),
                      ),
                    ),
                  ),
              ],
            ),
            title: Text(
              name,
              style: const TextStyle(
                fontWeight: FontWeight.w600,
                fontSize: 16,
              ),
            ),
            subtitle: Text(
              isRecent ? '🟢 Çevrimiçi' : '⚪ Son görülme: $timeAgo',
              style: TextStyle(
                color: isRecent ? Colors.green[700] : Colors.grey[600],
                fontSize: 13,
                fontWeight: isRecent ? FontWeight.w500 : FontWeight.normal,
              ),
            ),
            trailing: PopupMenuButton<String>(
              icon: const Icon(Icons.more_vert, color: Colors.deepOrange),
              onSelected: (value) {
                switch (value) {
                  case 'message':
                    _showMessageDialog(friend);
                    break;
                  case 'location':
                    _showLocationInfo(friend);
                    break;
                  case 'remove':
                    _confirmRemoveFriend(friend);
                    break;
                }
              },
              itemBuilder: (context) => [
                const PopupMenuItem(
                  value: 'message',
                  child: Row(
                    children: [
                      Icon(Icons.chat_bubble, color: Colors.blue),
                      SizedBox(width: 12),
                      Text('Mesaj Gönder'),
                    ],
                  ),
                ),
                const PopupMenuItem(
                  value: 'location',
                  child: Row(
                    children: [
                      Icon(Icons.location_on, color: Colors.green),
                      SizedBox(width: 12),
                      Text('Konum Göster'),
                    ],
                  ),
                ),
                const PopupMenuItem(
                  value: 'remove',
                  child: Row(
                    children: [
                      Icon(Icons.remove_circle, color: Colors.red),
                      SizedBox(width: 12),
                      Text('Arkadaşlıktan Çıkar',
                          style: TextStyle(color: Colors.red)),
                    ],
                  ),
                ),
              ],
            ),
            onTap: () {
              _showMessageDialog(friend);
            },
          ),
        );
      },
    );
  }

  Widget _buildAddFriendTab() {
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          // Arkadaş kodu ile ekleme kartı
          Card(
            child: Padding(
              padding: const EdgeInsets.all(20),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    children: [
                      Icon(Icons.person_add,
                          color: Colors.deepOrange[600], size: 24),
                      const SizedBox(width: 8),
                      const Text(
                        'Arkadaş Kodu ile Ekle',
                        style: TextStyle(
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 16),
                  TextField(
                    controller: _shareCodeController,
                    decoration: InputDecoration(
                      labelText: 'Arkadaş Kodu',
                      hintText: 'Örn: USR12345678',
                      border: const OutlineInputBorder(),
                      prefixIcon:
                          Icon(Icons.code, color: Colors.deepOrange[600]),
                    ),
                  ),
                  const SizedBox(height: 16),
                  SizedBox(
                    width: double.infinity,
                    child: ElevatedButton.icon(
                      onPressed: _addFriend,
                      icon: const Icon(Icons.add),
                      label: const Text('Arkadaş Ekle'),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.deepOrange[600],
                        foregroundColor: Colors.white,
                        padding: const EdgeInsets.symmetric(vertical: 12),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
          const SizedBox(height: 20),
          // Paylaşım kodu kartı
          Card(
            child: Padding(
              padding: const EdgeInsets.all(20),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    children: [
                      Icon(Icons.share,
                          color: Colors.deepOrange[600], size: 24),
                      const SizedBox(width: 8),
                      const Text(
                        'Senin Kodun',
                        style: TextStyle(
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 16),
                  Container(
                    padding: const EdgeInsets.all(16),
                    decoration: BoxDecoration(
                      color: Colors.deepOrange[50],
                      borderRadius: BorderRadius.circular(8),
                      border: Border.all(color: Colors.deepOrange[200]!),
                    ),
                    child: Column(
                      children: [
                        const Text(
                          'Arkadaşlarınla bu kodu paylaş:',
                          style: TextStyle(fontSize: 14),
                        ),
                        const SizedBox(height: 8),
                        SelectableText(
                          _shareCode,
                          style: const TextStyle(
                            fontSize: 24,
                            fontWeight: FontWeight.bold,
                            fontFamily: 'monospace',
                          ),
                        ),
                        const SizedBox(height: 12),
                        SizedBox(
                          width: double.infinity,
                          child: ElevatedButton.icon(
                            onPressed: _copyShareCode,
                            icon: const Icon(Icons.copy),
                            label: const Text('Kodu Kopyala'),
                            style: ElevatedButton.styleFrom(
                              backgroundColor: Colors.grey[700],
                              foregroundColor: Colors.white,
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          ),
          const SizedBox(height: 20),
          // Bilgi kartı
          Card(
            color: Colors.blue[50],
            child: Padding(
              padding: const EdgeInsets.all(16),
              child: Column(
                children: [
                  Icon(Icons.info_outline, color: Colors.blue[600], size: 28),
                  const SizedBox(height: 8),
                  const Text(
                    'Nasıl Arkadaş Eklenir?',
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 16,
                    ),
                  ),
                  const SizedBox(height: 8),
                  const Text(
                    '1. Arkadaşından kodunu iste\n'
                    '2. Kodu yukarıdaki alana yaz\n'
                    '3. "Arkadaş Ekle" butonuna bas\n'
                    '4. Arkadaşın isteği kabul ettiğinde arkadaş olursunuz',
                    style: TextStyle(fontSize: 14),
                    textAlign: TextAlign.left,
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  void _copyShareCode() {
    // Kodu kopyalama işlemi
    ScaffoldMessenger.of(context).showSnackBar(
      const SnackBar(
        content: Text('Kod kopyalandı!'),
        backgroundColor: Colors.green,
        duration: Duration(seconds: 2),
      ),
    );
  }

  Widget _buildRequestsTab() {
    final requests = _friendsService.pendingRequests;

    if (requests.isEmpty) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.inbox_outlined, size: 80, color: Colors.grey[400]),
            const SizedBox(height: 16),
            Text(
              'Bekleyen istek yok',
              style: TextStyle(fontSize: 18, color: Colors.grey[600]),
            ),
          ],
        ),
      );
    }

    return ListView.builder(
      padding: const EdgeInsets.all(16),
      itemCount: requests.length,
      itemBuilder: (context, index) {
        final request = requests[index];
        return _buildRequestCard(request);
      },
    );
  }

  Widget _buildRequestCard(Map<String, dynamic> request) {
    return Card(
      margin: const EdgeInsets.only(bottom: 12),
      child: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              children: [
                CircleAvatar(
                  backgroundColor: Colors.orange[100],
                  child: Text(
                    request['fromUserName']?[0]?.toUpperCase() ?? '?',
                    style: TextStyle(
                      color: Colors.orange[800],
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
                const SizedBox(width: 12),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        request['fromUserName'] ?? 'Bilinmeyen',
                        style: const TextStyle(
                          fontWeight: FontWeight.w500,
                          fontSize: 16,
                        ),
                      ),
                      Text(
                        request['fromUserEmail'] ?? '',
                        style: TextStyle(
                          color: Colors.grey[600],
                          fontSize: 14,
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
            if (request['message'] != null &&
                request['message'].isNotEmpty) ...[
              const SizedBox(height: 12),
              Container(
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  color: Colors.grey[100],
                  borderRadius: BorderRadius.circular(8),
                ),
                width: double.infinity,
                child: Text(
                  request['message'],
                  style: const TextStyle(fontStyle: FontStyle.italic),
                ),
              ),
            ],
            const SizedBox(height: 16),
            Row(
              children: [
                Expanded(
                  child: ElevatedButton.icon(
                    onPressed: () => _respondToRequest(request['id'], true),
                    icon: const Icon(Icons.check),
                    label: const Text('Kabul Et'),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.green,
                      foregroundColor: Colors.white,
                    ),
                  ),
                ),
                const SizedBox(width: 12),
                Expanded(
                  child: ElevatedButton.icon(
                    onPressed: () => _respondToRequest(request['id'], false),
                    icon: const Icon(Icons.close),
                    label: const Text('Reddet'),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.red,
                      foregroundColor: Colors.white,
                    ),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }

  Future<void> _addFriend() async {
    final code = _shareCodeController.text.trim();
    if (code.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('Lütfen bir arkadaş kodu girin!'),
          backgroundColor: Colors.orange,
        ),
      );
      return;
    }

    setState(() => _isLoading = true);

    final result = await _friendsService.addFriendByCode(code);

    setState(() => _isLoading = false);

    if (result == 'success') {
      _shareCodeController.clear();
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('Arkadaş ekleme isteği gönderildi!'),
          backgroundColor: Colors.green,
        ),
      );
    } else {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text('Hata: $result'),
          backgroundColor: Colors.red,
        ),
      );
    }
  }

  Future<void> _respondToRequest(String requestId, bool accept) async {
    setState(() => _isLoading = true);

    final success =
        await _friendsService.respondToFriendRequest(requestId, accept);

    setState(() => _isLoading = false);

    if (success) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text(accept ? 'Arkadaş eklendi!' : 'İstek reddedildi'),
          backgroundColor: accept ? Colors.green : Colors.orange,
        ),
      );
    } else {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('İşlem başarısız'),
          backgroundColor: Colors.red,
        ),
      );
    }
  }

  void _showMessageDialog(Map<String, dynamic> friend) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Text('${friend['displayName']} için'),
        content: const Text('Mesajlaşma özelliği yakında geliyor!'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: const Text('Tamam'),
          ),
        ],
      ),
    );
  }

  void _showLocationInfo(Map<String, dynamic> friend) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Text('${friend['displayName']} Konum'),
        content: const Text('Konum gösterme özelliği yakında geliyor!'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: const Text('Tamam'),
          ),
        ],
      ),
    );
  }

  void _confirmRemoveFriend(Map<String, dynamic> friend) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Arkadaşlıktan Çıkar'),
        content: Text(
            '${friend['displayName']} ile arkadaşlığı sonlandırmak istiyor musun?'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: const Text('İptal'),
          ),
          ElevatedButton(
            onPressed: () {
              Navigator.pop(context);
              // Arkadaşı çıkar
            },
            style: ElevatedButton.styleFrom(backgroundColor: Colors.red),
            child: const Text('Çıkar', style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  String _formatTimeAgo(DateTime time) {
    final now = DateTime.now();
    final diff = now.difference(time);

    if (diff.inMinutes < 1) {
      return 'az önce';
    } else if (diff.inMinutes < 60) {
      return '${diff.inMinutes} dakika önce';
    } else if (diff.inHours < 24) {
      return '${diff.inHours} saat önce';
    } else if (diff.inDays < 30) {
      return '${diff.inDays} gün önce';
    } else {
      return 'uzun zaman önce';
    }
  }
}
