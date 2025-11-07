import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class SimpleFriendsScreen extends StatefulWidget {
  const SimpleFriendsScreen({super.key});

  @override
  State<SimpleFriendsScreen> createState() => _SimpleFriendsScreenState();
}

class _SimpleFriendsScreenState extends State<SimpleFriendsScreen>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;
  final TextEditingController _shareCodeController = TextEditingController();
  bool _isLoading = false;
  String _myShareCode = '123456';

  // Simülasyon arkadaş listesi
  final List<Map<String, dynamic>> _friends = [
    {
      'id': 'friend_1',
      'name': 'Ahmet Yılmaz',
      'email': 'ahmet@example.com',
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

  // Bekleyen istekler
  final List<Map<String, dynamic>> _pendingRequests = [
    {
      'id': 'request_1',
      'fromUserId': 'new_user_001',
      'message': 'Merhaba! Deprem uygulamasından arkadaş olmak ister misin?',
      'sentAt': DateTime.now().subtract(const Duration(hours: 1)),
      'fromUser': {
        'name': 'Zeynep Şahin',
        'email': 'zeynep@example.com',
      },
    },
  ];

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 3, vsync: this);
  }

  @override
  void dispose() {
    _tabController.dispose();
    _shareCodeController.dispose();
    super.dispose();
  }

  String _formatLastUpdate(DateTime timestamp) {
    final now = DateTime.now();
    final difference = now.difference(timestamp);

    if (difference.inSeconds < 60) {
      return 'Az önce';
    } else if (difference.inMinutes < 60) {
      return '${difference.inMinutes} dakika önce';
    } else if (difference.inHours < 24) {
      return '${difference.inHours} saat önce';
    } else {
      return '${difference.inDays} gün önce';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Arkadaşlar'),
        backgroundColor: const Color(0xFFFF5252),
        foregroundColor: Colors.white,
        bottom: TabBar(
          controller: _tabController,
          labelColor: Colors.white,
          unselectedLabelColor: Colors.white70,
          indicatorColor: Colors.white,
          tabs: [
            Tab(text: 'Arkadaşlar (${_friends.length})'),
            Tab(text: 'İstekler (${_pendingRequests.length})'),
            const Tab(text: 'Arkadaş Ekle'),
          ],
        ),
      ),
      body: TabBarView(
        controller: _tabController,
        children: [
          _buildFriendsList(),
          _buildRequestsList(),
          _buildAddFriend(),
        ],
      ),
    );
  }

  Widget _buildFriendsList() {
    if (_isLoading) {
      return const Center(child: CircularProgressIndicator());
    }

    if (_friends.isEmpty) {
      return const Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.people_outline, size: 80, color: Colors.grey),
            SizedBox(height: 16),
            Text(
              'Henüz arkadaşınız yok',
              style: TextStyle(fontSize: 18, color: Colors.grey),
            ),
          ],
        ),
      );
    }

    return ListView.builder(
      itemCount: _friends.length,
      itemBuilder: (context, index) {
        final friend = _friends[index];
        final isOnline = friend['isOnline'] as bool;
        final lastSeen = friend['lastSeen'] as DateTime;

        return Card(
          margin: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
          child: ListTile(
            leading: Stack(
              children: [
                CircleAvatar(
                  backgroundColor: const Color(0xFFFF5252),
                  child: Text(
                    friend['name'][0],
                    style: const TextStyle(color: Colors.white),
                  ),
                ),
                if (isOnline)
                  Positioned(
                    right: 0,
                    bottom: 0,
                    child: Container(
                      width: 12,
                      height: 12,
                      decoration: BoxDecoration(
                        color: Colors.green,
                        shape: BoxShape.circle,
                        border: Border.all(color: Colors.white, width: 2),
                      ),
                    ),
                  ),
              ],
            ),
            title: Text(
              friend['name'],
              style: const TextStyle(fontWeight: FontWeight.bold),
            ),
            subtitle: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(friend['location']['address']),
                Text(
                  isOnline
                      ? 'Çevrimiçi'
                      : 'Son görülme: ${_formatLastUpdate(lastSeen)}',
                  style: TextStyle(
                    fontSize: 12,
                    color: isOnline ? Colors.green : Colors.grey,
                  ),
                ),
              ],
            ),
            trailing: IconButton(
              icon: const Icon(Icons.location_on, color: Color(0xFFFF5252)),
              onPressed: () {
                _showFriendLocation(friend);
              },
            ),
          ),
        );
      },
    );
  }

  Widget _buildRequestsList() {
    if (_pendingRequests.isEmpty) {
      return const Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.inbox, size: 80, color: Colors.grey),
            SizedBox(height: 16),
            Text(
              'Bekleyen istek yok',
              style: TextStyle(fontSize: 18, color: Colors.grey),
            ),
          ],
        ),
      );
    }

    return ListView.builder(
      itemCount: _pendingRequests.length,
      itemBuilder: (context, index) {
        final request = _pendingRequests[index];
        final sentAt = request['sentAt'] as DateTime;

        return Card(
          margin: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
          child: ListTile(
            leading: CircleAvatar(
              backgroundColor: const Color(0xFFFF5252),
              child: Text(
                request['fromUser']['name'][0],
                style: const TextStyle(color: Colors.white),
              ),
            ),
            title: Text(
              request['fromUser']['name'],
              style: const TextStyle(fontWeight: FontWeight.bold),
            ),
            subtitle: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                if (request['message'] != null && request['message'].isNotEmpty)
                  Text(request['message']),
                Text(
                  _formatLastUpdate(sentAt),
                  style: const TextStyle(fontSize: 12, color: Colors.grey),
                ),
              ],
            ),
            trailing: Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                IconButton(
                  icon: const Icon(Icons.check, color: Colors.green),
                  onPressed: () {
                    _respondToRequest(request['id'], true);
                  },
                ),
                IconButton(
                  icon: const Icon(Icons.close, color: Colors.red),
                  onPressed: () {
                    _respondToRequest(request['id'], false);
                  },
                ),
              ],
            ),
          ),
        );
      },
    );
  }

  Widget _buildAddFriend() {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'Paylaşım Kodunuz',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          Card(
            color: const Color(0xFFFF5252),
            child: ListTile(
              title: Text(
                _myShareCode,
                style: const TextStyle(
                  color: Colors.white,
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  letterSpacing: 4,
                ),
                textAlign: TextAlign.center,
              ),
              trailing: IconButton(
                icon: const Icon(Icons.copy, color: Colors.white),
                onPressed: () {
                  Clipboard.setData(ClipboardData(text: _myShareCode));
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(content: Text('Kod kopyalandı')),
                  );
                },
              ),
            ),
          ),
          const SizedBox(height: 32),
          const Text(
            'Arkadaş Ekle',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          TextField(
            controller: _shareCodeController,
            decoration: const InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Arkadaş Kodu',
              hintText: '6 haneli kod girin',
            ),
            maxLength: 6,
            textCapitalization: TextCapitalization.characters,
          ),
          const SizedBox(height: 16),
          SizedBox(
            width: double.infinity,
            height: 50,
            child: ElevatedButton(
              onPressed: _isLoading ? null : _sendFriendRequest,
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color(0xFFFF5252),
                foregroundColor: Colors.white,
              ),
              child: _isLoading
                  ? const CircularProgressIndicator(color: Colors.white)
                  : const Text(
                      'Arkadaşlık İsteği Gönder',
                      style: TextStyle(fontSize: 16),
                    ),
            ),
          ),
        ],
      ),
    );
  }

  void _sendFriendRequest() {
    if (_shareCodeController.text.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('Lütfen arkadaş kodunu girin'),
          backgroundColor: Colors.orange,
        ),
      );
      return;
    }

    setState(() => _isLoading = true);

    Future.delayed(const Duration(seconds: 1), () {
      if (mounted) {
        setState(() => _isLoading = false);
        _shareCodeController.clear();
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('Arkadaşlık isteği gönderildi!'),
            backgroundColor: Colors.green,
          ),
        );
      }
    });
  }

  void _respondToRequest(String requestId, bool accept) {
    setState(() {
      _pendingRequests.removeWhere((req) => req['id'] == requestId);
    });

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(accept
            ? 'Arkadaş isteği kabul edildi!'
            : 'Arkadaş isteği reddedildi'),
        backgroundColor: accept ? Colors.green : Colors.orange,
      ),
    );
  }

  void _showFriendLocation(Map<String, dynamic> friend) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Text(friend['name']),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('📍 ${friend['location']['address']}'),
            const SizedBox(height: 8),
            Text(
                'Konum: ${friend['location']['latitude']}, ${friend['location']['longitude']}'),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: const Text('Kapat'),
          ),
        ],
      ),
    );
  }
}
