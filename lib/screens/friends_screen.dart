import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:deprem_app/services/services.dart';

class FriendsScreen extends StatefulWidget {
  const FriendsScreen({super.key});

  @override
  State<FriendsScreen> createState() => _FriendsScreenState();
}

class _FriendsScreenState extends State<FriendsScreen>
    with TickerProviderStateMixin {
  final AuthService _authService = AuthService();
  final FriendsService _friendsService = FriendsService();
  final TextEditingController _shareCodeController = TextEditingController();
  final TextEditingController _messageController = TextEditingController();

  late TabController _tabController;
  bool _isLoading = false;
  String _myShareCode = '';

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
    _messageController.dispose();
    super.dispose();
  }

  Future<void> _loadData() async {
    print('🚀 FriendsScreen _loadData() başlatıldı');
    setState(() {
      _isLoading = true;
    });

    try {
      print('📋 Profil sunucudan alınıyor...');
      final userProfile = await _friendsService.getOrCreateProfile(
        email: _authService.currentUserEmail ?? '',
        displayName: _authService.currentUserName ?? '',
        photoURL: _authService.currentUserPhotoUrl,
      );
      _myShareCode = userProfile['shareCode'] ?? '';
      print('🔑 Share code (gerçek): $_myShareCode');

      print('👥 Arkadaş listesi getiriliyor...');
      await _friendsService.fetchFriends();
      print('📊 Arkadaş sayısı: ${_friendsService.friends.length}');

      print('📩 Bekleyen istekler getiriliyor...');
      await _friendsService.fetchPendingRequests();
      print(
          '📊 Bekleyen istek sayısı: ${_friendsService.friendRequests.length}');

      print('🗺️ Konumlar güncelleniyor...');
      await _friendsService.updateFriendsLocations();

      print('✅ Tüm veriler yüklendi');
    } catch (error) {
      print('❌ Veri yükleme hatası: $error');
    } finally {
      if (mounted) {
        setState(() {
          _isLoading = false;
        });
      }
    }
  }

  Future<void> _sendFriendRequest() async {
    final l10n = AppLocalizations.of(context);
    if (_shareCodeController.text.trim().isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text(l10n.get('please_enter_friend_code')),
          backgroundColor: Colors.orange,
        ),
      );
      return;
    }

    setState(() {
      _isLoading = true;
    });

    try {
      final success = await _friendsService.sendFriendRequest(
        _shareCodeController.text.trim(),
        message: _messageController.text.trim(),
      );

      if (success && mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text(l10n.get('friend_request_sent')),
            backgroundColor: Colors.green,
          ),
        );
        _shareCodeController.clear();
        _messageController.clear();
      }
    } catch (error) {
      if (mounted) {
        final l10n = AppLocalizations.of(context);
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text('${l10n.get('error')}: $error'),
            backgroundColor: Colors.red,
          ),
        );
      }
    } finally {
      if (mounted) {
        setState(() {
          _isLoading = false;
        });
      }
    }
  }

  Future<void> _respondToFriendRequest(String requestId, bool accept) async {
    try {
      final success =
          await _friendsService.respondToFriendRequest(requestId, accept);

      if (success && mounted) {
        await _loadData(); // Verileri yenile
        final l10n = AppLocalizations.of(context);
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text(accept
                ? l10n.get('friend_request_accepted')
                : l10n.get('friend_request_rejected')),
            backgroundColor: accept ? Colors.green : Colors.orange,
          ),
        );
      }
    } catch (error) {
      if (mounted) {
        final l10n = AppLocalizations.of(context);
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text('${l10n.get('error')}: $error'),
            backgroundColor: Colors.red,
          ),
        );
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context);
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        title: Text(
          l10n.get('my_friends'),
          style: const TextStyle(
            color: Colors.white,
            fontWeight: FontWeight.bold,
          ),
        ),
        backgroundColor: Colors.red.shade700,
        elevation: 0,
        bottom: TabBar(
          controller: _tabController,
          indicatorColor: Colors.white,
          labelColor: Colors.white,
          unselectedLabelColor: Colors.red.shade100,
          tabs: [
            Tab(
              icon: Icon(Icons.people),
              text:
                  '${l10n.get('friends_tab')} (${_friendsService.friendCount})',
            ),
            Tab(
              icon: Icon(Icons.person_add),
              text:
                  '${l10n.get('requests_tab')} (${_friendsService.pendingRequestCount})',
            ),
            Tab(
              icon: Icon(Icons.add),
              text: l10n.get('add_tab'),
            ),
          ],
        ),
      ),
      body: _isLoading
          ? const Center(
              child: CircularProgressIndicator(
                color: Colors.red,
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
    print('🎯 _buildFriendsTab() çağrıldı - Arkadaş sayısı: ${friends.length}');
    print('📋 Arkadaş listesi: ${friends.map((f) => f['name']).join(', ')}');

    if (friends.isEmpty) {
      print('⚠️ Arkadaş listesi boş - boş ekran gösteriliyor');
      final l10n = AppLocalizations.of(context);
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(
              Icons.people_outline,
              size: 80,
              color: Colors.grey.shade400,
            ),
            const SizedBox(height: 20),
            Text(
              l10n.get('no_friends_yet'),
              style: TextStyle(
                fontSize: 18,
                color: Colors.grey.shade600,
                fontWeight: FontWeight.w600,
              ),
            ),
            const SizedBox(height: 10),
            Text(
              l10n.get('use_add_tab_to_add_friends'),
              style: TextStyle(
                fontSize: 14,
                color: Colors.grey.shade500,
              ),
              textAlign: TextAlign.center,
            ),
          ],
        ),
      );
    }

    return RefreshIndicator(
      onRefresh: _loadData,
      child: ListView.builder(
        padding: const EdgeInsets.all(16),
        itemCount: friends.length,
        itemBuilder: (context, index) {
          final friend = friends[index];
          final location = friend['location'];

          return Card(
            elevation: 2,
            margin: const EdgeInsets.only(bottom: 12),
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(12),
            ),
            child: ListTile(
              contentPadding: const EdgeInsets.all(16),
              leading: CircleAvatar(
                backgroundColor: Colors.red.shade100,
                child: Text(
                  friend['name']?.substring(0, 1).toUpperCase() ?? '?',
                  style: TextStyle(
                    color: Colors.red.shade700,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ),
              title: Builder(
                builder: (context) {
                  final l10n = AppLocalizations.of(context);
                  return Text(
                    friend['name'] ?? l10n.get('unknown'),
                    style: const TextStyle(
                      fontWeight: FontWeight.w600,
                      fontSize: 16,
                    ),
                  );
                },
              ),
              subtitle: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  const SizedBox(height: 4),
                  if (location != null) ...[
                    Row(
                      children: [
                        Icon(
                          Icons.location_on,
                          size: 16,
                          color: Colors.green.shade600,
                        ),
                        const SizedBox(width: 4),
                        Expanded(
                          child: Builder(
                            builder: (context) {
                              final l10n = AppLocalizations.of(context);
                              return Text(
                                location['address'] ??
                                    l10n.get('location_unknown'),
                                style: TextStyle(
                                  color: Colors.grey.shade700,
                                  fontSize: 13,
                                ),
                              );
                            },
                          ),
                        ),
                      ],
                    ),
                    const SizedBox(height: 2),
                    Row(
                      children: [
                        Icon(
                          Icons.access_time,
                          size: 16,
                          color: Colors.blue.shade600,
                        ),
                        const SizedBox(width: 4),
                        Text(
                          _friendsService.formatLastUpdate(friend['lastSeen']),
                          style: TextStyle(
                            color: Colors.grey.shade600,
                            fontSize: 12,
                          ),
                        ),
                      ],
                    ),
                  ] else ...[
                    Text(
                      'Konum paylaşılmıyor',
                      style: TextStyle(
                        color: Colors.grey.shade500,
                        fontSize: 13,
                      ),
                    ),
                  ],
                ],
              ),
              trailing: PopupMenuButton<String>(
                onSelected: (value) {
                  if (value == 'remove') {
                    _showRemoveFriendDialog(friend);
                  } else if (value == 'location' && location != null) {
                    _showLocationDialog(friend);
                  }
                },
                itemBuilder: (context) {
                  final l10n = AppLocalizations.of(context);
                  return [
                    if (location != null)
                      PopupMenuItem(
                        value: 'location',
                        child: Row(
                          children: [
                            Icon(Icons.location_on, size: 18),
                            SizedBox(width: 8),
                            Text(l10n.get('show_location')),
                          ],
                        ),
                      ),
                    PopupMenuItem(
                      value: 'remove',
                      child: Row(
                        children: [
                          Icon(Icons.remove_circle,
                              size: 18, color: Colors.red),
                          SizedBox(width: 8),
                          Text(l10n.get('remove_friendship'),
                              style: TextStyle(color: Colors.red)),
                        ],
                      ),
                    ),
                  ];
                },
              ),
            ),
          );
        },
      ),
    );
  }

  Widget _buildRequestsTab() {
    final requests = _friendsService.pendingRequests;

    if (requests.isEmpty) {
      final l10n = AppLocalizations.of(context);
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(
              Icons.inbox_outlined,
              size: 80,
              color: Colors.grey.shade400,
            ),
            const SizedBox(height: 20),
            Text(
              l10n.get('no_pending_requests'),
              style: TextStyle(
                fontSize: 18,
                color: Colors.grey.shade600,
                fontWeight: FontWeight.w600,
              ),
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
        final fromUser = request['fromUser'];

        return Card(
          elevation: 2,
          margin: const EdgeInsets.only(bottom: 12),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(12),
          ),
          child: Padding(
            padding: const EdgeInsets.all(16),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  children: [
                    CircleAvatar(
                      backgroundColor: Colors.blue.shade100,
                      child: Text(
                        fromUser['name']?.substring(0, 1).toUpperCase() ?? '?',
                        style: TextStyle(
                          color: Colors.blue.shade700,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    const SizedBox(width: 12),
                    Expanded(
                      child: Builder(
                        builder: (context) {
                          final l10n = AppLocalizations.of(context);
                          return Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                fromUser['name'] ?? l10n.get('unknown'),
                                style: const TextStyle(
                                  fontWeight: FontWeight.w600,
                                  fontSize: 16,
                                ),
                              ),
                              Text(
                                fromUser['email'] ?? '',
                                style: TextStyle(
                                  color: Colors.grey.shade600,
                                  fontSize: 13,
                                ),
                              ),
                            ],
                          );
                        },
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
                      color: Colors.grey.shade50,
                      borderRadius: BorderRadius.circular(8),
                    ),
                    child: Text(
                      request['message'],
                      style: TextStyle(
                        color: Colors.grey.shade700,
                        fontSize: 14,
                      ),
                    ),
                  ),
                ],
                const SizedBox(height: 16),
                Row(
                  children: [
                    Expanded(
                      child: Builder(builder: (context) {
                        final l10n = AppLocalizations.of(context);
                        return ElevatedButton.icon(
                          onPressed: () =>
                              _respondToFriendRequest(request['id'], false),
                          style: ElevatedButton.styleFrom(
                            backgroundColor: Colors.grey.shade200,
                            foregroundColor: Colors.grey.shade700,
                            elevation: 0,
                          ),
                          icon: const Icon(Icons.close, size: 18),
                          label: Text(l10n.get('reject')),
                        );
                      }),
                    ),
                    const SizedBox(width: 12),
                    Expanded(
                      child: Builder(builder: (context) {
                        final l10n = AppLocalizations.of(context);
                        return ElevatedButton.icon(
                          onPressed: () =>
                              _respondToFriendRequest(request['id'], true),
                          style: ElevatedButton.styleFrom(
                            backgroundColor: Colors.green,
                            foregroundColor: Colors.white,
                          ),
                          icon: const Icon(Icons.check, size: 18),
                          label: Text(l10n.get('accept')),
                        );
                      }),
                    ),
                  ],
                ),
              ],
            ),
          ),
        );
      },
    );
  }

  Widget _buildAddFriendTab() {
    return SingleChildScrollView(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          // Benim paylaşım kodum
          Card(
            elevation: 2,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(12),
            ),
            child: Padding(
              padding: const EdgeInsets.all(20),
              child: Column(
                children: [
                  Icon(
                    Icons.qr_code_2,
                    size: 50,
                    color: Colors.red.shade700,
                  ),
                  const SizedBox(height: 12),
                  Builder(
                    builder: (context) {
                      final l10n = AppLocalizations.of(context);
                      return Text(
                        l10n.get('my_friend_code'),
                        style: const TextStyle(
                          fontSize: 18,
                          fontWeight: FontWeight.w600,
                        ),
                      );
                    },
                  ),
                  const SizedBox(height: 8),
                  Container(
                    padding: const EdgeInsets.symmetric(
                        horizontal: 16, vertical: 12),
                    decoration: BoxDecoration(
                      color: Colors.grey.shade100,
                      borderRadius: BorderRadius.circular(8),
                    ),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Text(
                          _myShareCode,
                          style: TextStyle(
                            fontSize: 24,
                            fontWeight: FontWeight.bold,
                            color: Colors.red.shade700,
                            letterSpacing: 2,
                          ),
                        ),
                        const SizedBox(width: 12),
                        GestureDetector(
                          onTap: () {
                            final l10n = AppLocalizations.of(context);
                            Clipboard.setData(
                                ClipboardData(text: _myShareCode));
                            ScaffoldMessenger.of(context).showSnackBar(
                              SnackBar(
                                content: Text(l10n.get('code_copied')),
                                duration: Duration(seconds: 2),
                              ),
                            );
                          },
                          child: Icon(
                            Icons.copy,
                            color: Colors.red.shade700,
                            size: 20,
                          ),
                        ),
                      ],
                    ),
                  ),
                  const SizedBox(height: 8),
                  Builder(
                    builder: (context) {
                      final l10n = AppLocalizations.of(context);
                      return Text(
                        l10n.get('share_code_with_friends'),
                        style: TextStyle(
                          color: Colors.grey.shade600,
                          fontSize: 13,
                        ),
                      );
                    },
                  ),
                ],
              ),
            ),
          ),

          const SizedBox(height: 24),

          // Arkadaş ekleme formu
          Card(
            elevation: 2,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(12),
            ),
            child: Padding(
              padding: const EdgeInsets.all(20),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: [
                  Builder(
                    builder: (context) {
                      final l10n = AppLocalizations.of(context);
                      return Text(
                        l10n.get('add_friend'),
                        style: const TextStyle(
                          fontSize: 18,
                          fontWeight: FontWeight.w600,
                        ),
                      );
                    },
                  ),
                  const SizedBox(height: 16),
                  Builder(
                    builder: (context) {
                      final l10n = AppLocalizations.of(context);
                      return TextField(
                        controller: _shareCodeController,
                        decoration: InputDecoration(
                          labelText: l10n.get('friend_code'),
                          hintText: l10n.get('friend_code_example'),
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(8),
                          ),
                          prefixIcon: const Icon(Icons.person_add),
                        ),
                        textCapitalization: TextCapitalization.characters,
                      );
                    },
                  ),
                  const SizedBox(height: 16),
                  Builder(
                    builder: (context) {
                      final l10n = AppLocalizations.of(context);
                      return TextField(
                        controller: _messageController,
                        decoration: InputDecoration(
                          labelText: l10n.get('message_optional'),
                          hintText: l10n.get('friend_request_message_hint'),
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(8),
                          ),
                          prefixIcon: const Icon(Icons.message),
                        ),
                        maxLines: 3,
                      );
                    },
                  ),
                  const SizedBox(height: 20),
                  Builder(
                    builder: (context) {
                      final l10n = AppLocalizations.of(context);
                      return ElevatedButton.icon(
                        onPressed: _isLoading ? null : _sendFriendRequest,
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.red.shade700,
                          foregroundColor: Colors.white,
                          padding: const EdgeInsets.symmetric(vertical: 16),
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(8),
                          ),
                        ),
                        icon: _isLoading
                            ? const SizedBox(
                                width: 20,
                                height: 20,
                                child: CircularProgressIndicator(
                                  color: Colors.white,
                                  strokeWidth: 2,
                                ),
                              )
                            : const Icon(Icons.send),
                        label: Text(_isLoading
                            ? l10n.get('sending')
                            : l10n.get('send_request')),
                      );
                    },
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  void _showRemoveFriendDialog(Map<String, dynamic> friend) {
    final l10n = AppLocalizations.of(context);
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Text(l10n.get('remove_from_friends')),
        content:
            Text('${friend['name']} - ${l10n.get('remove_from_friends')}?'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: Text(l10n.get('cancel')),
          ),
          ElevatedButton(
            onPressed: () async {
              Navigator.pop(context);
              await _friendsService.removeFriend(friend['id']);
              await _loadData();
              if (mounted) {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    content: Text(l10n.get('friend_removed')),
                    backgroundColor: Colors.orange,
                  ),
                );
              }
            },
            style: ElevatedButton.styleFrom(backgroundColor: Colors.red),
            child:
                Text(l10n.get('remove'), style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  void _showLocationDialog(Map<String, dynamic> friend) {
    final l10n = AppLocalizations.of(context);
    final location = friend['location'];
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Text('${friend['name']} - ${l10n.get('location')}'),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              children: [
                const Icon(Icons.location_on, color: Colors.red),
                const SizedBox(width: 8),
                Expanded(
                  child: Text(
                    location['address'] ?? l10n.get('unknown'),
                    style: const TextStyle(fontWeight: FontWeight.w600),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 12),
            Row(
              children: [
                const Icon(Icons.access_time, color: Colors.blue),
                const SizedBox(width: 8),
                Text(
                    '${l10n.get('last_update')}: ${_friendsService.formatLastUpdate(friend['lastSeen'])}'),
              ],
            ),
            const SizedBox(height: 12),
            Text(
              '${l10n.get('coordinates')}: ${location['latitude']?.toStringAsFixed(4)}, ${location['longitude']?.toStringAsFixed(4)}',
              style: TextStyle(
                color: Colors.grey.shade600,
                fontSize: 12,
              ),
            ),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: Text(l10n.get('close')),
          ),
          ElevatedButton(
            onPressed: () {
              Navigator.pop(context);
              // Burada harita açılabilir
              ScaffoldMessenger.of(context).showSnackBar(
                SnackBar(
                  content: Text(l10n.get('map_feature_coming_soon')),
                ),
              );
            },
            child: Text(l10n.get('show_on_map')),
          ),
        ],
      ),
    );
  }
}
