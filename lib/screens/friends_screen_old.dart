import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:cached_network_image/cached_network_image.dart';
import '../services/auth_service.dart';
import '../services/friends_service.dart';

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
    setState(() {
      _isLoading = true;
    });

    try {
      _myShareCode = _authService.generateShareCode();
      await _friendsService.fetchFriends();
      await _friendsService.fetchPendingRequests();
      await _friendsService.updateFriendsLocations();
    } catch (error) {
      print('Veri yükleme hatası: $error');
    } finally {
      if (mounted) {
        setState(() {
          _isLoading = false;
        });
      }
    }
  }

  Future<void> _sendFriendRequest() async {
    final shareCode = _shareCodeController.text.trim().toUpperCase();
    if (shareCode.isEmpty) {
      _showMessage('Lütfen arkadaş kodunu girin', isError: true);
      return;
    }

    if (shareCode == _myShareCode) {
      _showMessage('Kendi kodunuzu ekleyemezsiniz', isError: true);
      return;
    }

    setState(() {
      _isLoading = true;
    });

    try {
      final success = await _friendsService.sendFriendRequest(
        shareCode,
        message: _messageController.text.trim(),
      );

      if (success) {
        _shareCodeController.clear();
        _messageController.clear();
        Navigator.pop(context);
        _showMessage('Arkadaş isteği gönderildi!');
      } else {
        _showMessage('Arkadaş isteği gönderilemedi', isError: true);
      }
    } catch (error) {
      _showMessage('Hata: $error', isError: true);
    } finally {
      setState(() {
        _isLoading = false;
      });
    }
  }

  Future<void> _respondToRequest(String requestId, bool accept) async {
    final success =
        await _friendsService.respondToFriendRequest(requestId, accept);

    if (success) {
      setState(() {});
      _showMessage(accept ? 'Arkadaş eklendi!' : 'İstek reddedildi');
    } else {
      _showMessage('İşlem başarısız', isError: true);
    }
  }

  void _showAddFriendDialog() {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Arkadaş Ekle'),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            TextField(
              controller: _shareCodeController,
              decoration: const InputDecoration(
                labelText: 'Arkadaş Kodu',
                hintText: 'Örnek: ABC123',
                border: OutlineInputBorder(),
              ),
              textCapitalization: TextCapitalization.characters,
            ),
            const SizedBox(height: 15),
            TextField(
              controller: _messageController,
              decoration: const InputDecoration(
                labelText: 'Mesaj (opsiyonel)',
                hintText: 'Merhaba, arkadaş olalım!',
                border: OutlineInputBorder(),
              ),
              maxLines: 2,
            ),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: const Text('İptal'),
          ),
          ElevatedButton(
            onPressed: _isLoading ? null : _sendFriendRequest,
            child: _isLoading
                ? const SizedBox(
                    width: 20,
                    height: 20,
                    child: CircularProgressIndicator(strokeWidth: 2),
                  )
                : const Text('Gönder'),
          ),
        ],
      ),
    );
  }

  void _showMyShareCode() {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Arkadaş Kodunuz'),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              padding: const EdgeInsets.all(20),
              decoration: BoxDecoration(
                color: Colors.red.shade50,
                borderRadius: BorderRadius.circular(10),
                border: Border.all(color: Colors.red.shade200),
              ),
              child: Column(
                children: [
                  Text(
                    _myShareCode,
                    style: TextStyle(
                      fontSize: 32,
                      fontWeight: FontWeight.bold,
                      color: Colors.red.shade700,
                      letterSpacing: 4,
                    ),
                  ),
                  const SizedBox(height: 10),
                  Text(
                    'Bu kodu arkadaşlarınızla paylaşın',
                    style: TextStyle(
                      color: Colors.grey.shade600,
                      fontSize: 14,
                    ),
                  ),
                ],
              ),
            ),
            const SizedBox(height: 15),
            Row(
              children: [
                Expanded(
                  child: OutlinedButton.icon(
                    onPressed: () {
                      Clipboard.setData(ClipboardData(text: _myShareCode));
                      _showMessage('Kod kopyalandı!');
                    },
                    icon: const Icon(Icons.copy),
                    label: const Text('Kopyala'),
                  ),
                ),
                const SizedBox(width: 10),
                Expanded(
                  child: OutlinedButton.icon(
                    onPressed: () {
                      // Paylaşım özelliği eklenebilir
                      _showMessage('Paylaşım özelliği yakında eklenecek');
                    },
                    icon: const Icon(Icons.share),
                    label: const Text('Paylaş'),
                  ),
                ),
              ],
            ),
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

  void _showMessage(String message, {bool isError = false}) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(message),
        backgroundColor: isError ? Colors.red : Colors.green,
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Arkadaşlarım',
          style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
        ),
        backgroundColor: Colors.red.shade700,
        iconTheme: const IconThemeData(color: Colors.white),
        bottom: TabBar(
          controller: _tabController,
          indicatorColor: Colors.white,
          labelColor: Colors.white,
          unselectedLabelColor: Colors.white70,
          tabs: [
            Tab(
              text: 'Arkadaşlar',
              icon: Badge(
                isLabelVisible: _friendsService.friendCount > 0,
                label: Text('${_friendsService.friendCount}'),
                child: const Icon(Icons.people),
              ),
            ),
            Tab(
              text: 'İstekler',
              icon: Badge(
                isLabelVisible: _friendsService.pendingRequestCount > 0,
                label: Text('${_friendsService.pendingRequestCount}'),
                child: const Icon(Icons.person_add),
              ),
            ),
            Tab(
              text: 'Acil Durum',
              icon: Badge(
                isLabelVisible: _friendsService.onlineFriends.isNotEmpty,
                label: Text('${_friendsService.onlineFriends.length}'),
                child: const Icon(Icons.emergency),
              ),
            ),
          ],
        ),
        actions: [
          IconButton(
            onPressed: _showMyShareCode,
            icon: const Icon(Icons.qr_code),
            tooltip: 'Arkadaş Kodum',
          ),
          IconButton(
            onPressed: _loadData,
            icon: const Icon(Icons.refresh),
          ),
        ],
      ),
      body: TabBarView(
        controller: _tabController,
        children: [
          _buildFriendsTab(),
          _buildRequestsTab(),
          _buildEmergencyTab(),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _showAddFriendDialog,
        backgroundColor: Colors.red.shade700,
        child: const Icon(Icons.person_add, color: Colors.white),
      ),
    );
  }

  Widget _buildFriendsTab() {
    if (_isLoading) {
      return const Center(child: CircularProgressIndicator());
    }

    if (_friendsService.friends.isEmpty) {
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
              'Henüz arkadaşınız yok',
              style: TextStyle(
                fontSize: 18,
                color: Colors.grey.shade600,
              ),
            ),
            const SizedBox(height: 10),
            Text(
              'Arkadaş kodunuzu paylaşın veya\narkadaş kodu ile arkadaş ekleyin',
              textAlign: TextAlign.center,
              style: TextStyle(
                color: Colors.grey.shade500,
              ),
            ),
            const SizedBox(height: 30),
            ElevatedButton.icon(
              onPressed: _showAddFriendDialog,
              icon: const Icon(Icons.person_add),
              label: const Text('Arkadaş Ekle'),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.red.shade700,
                foregroundColor: Colors.white,
              ),
            ),
          ],
        ),
      );
    }

    return RefreshIndicator(
      onRefresh: _loadData,
      child: ListView.builder(
        padding: const EdgeInsets.all(16),
        itemCount: _friendsService.friends.length,
        itemBuilder: (context, index) {
          final friend = _friendsService.friends[index];
          return _buildFriendCard(friend);
        },
      ),
    );
  }

  Widget _buildFriendCard(Friend friend) {
    return Card(
      margin: const EdgeInsets.only(bottom: 12),
      child: ListTile(
        leading: CircleAvatar(
          backgroundColor: friend.isOnline ? Colors.green : Colors.grey,
          child: friend.photoUrl != null
              ? CachedNetworkImage(
                  imageUrl: friend.photoUrl!,
                  imageBuilder: (context, imageProvider) => Container(
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      image: DecorationImage(
                        image: imageProvider,
                        fit: BoxFit.cover,
                      ),
                    ),
                  ),
                  placeholder: (context, url) =>
                      const CircularProgressIndicator(),
                  errorWidget: (context, url, error) => Text(
                    friend.name.isNotEmpty ? friend.name[0].toUpperCase() : '?',
                    style: const TextStyle(
                        color: Colors.white, fontWeight: FontWeight.bold),
                  ),
                )
              : Text(
                  friend.name.isNotEmpty ? friend.name[0].toUpperCase() : '?',
                  style: const TextStyle(
                      color: Colors.white, fontWeight: FontWeight.bold),
                ),
        ),
        title: Text(
          friend.name,
          style: const TextStyle(fontWeight: FontWeight.w600),
        ),
        subtitle: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(friend.email),
            Row(
              children: [
                Icon(
                  friend.isOnline ? Icons.circle : Icons.circle_outlined,
                  size: 12,
                  color: friend.isOnline ? Colors.green : Colors.grey,
                ),
                const SizedBox(width: 5),
                Text(
                  friend.isOnline
                      ? 'Çevrimiçi'
                      : _getLastSeenText(friend.lastSeen),
                  style: TextStyle(
                    fontSize: 12,
                    color: friend.isOnline ? Colors.green : Colors.grey,
                  ),
                ),
                if (friend.latitude != null && friend.longitude != null) ...[
                  const SizedBox(width: 10),
                  Icon(
                    Icons.location_on,
                    size: 12,
                    color: Colors.red.shade700,
                  ),
                  const Text(
                    'Konum paylaşılıyor',
                    style: TextStyle(fontSize: 12),
                  ),
                ],
              ],
            ),
          ],
        ),
        trailing: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            if (friend.latitude != null && friend.longitude != null)
              IconButton(
                onPressed: () {
                  // Haritada konumu göster
                  _showFriendOnMap(friend);
                },
                icon: Icon(Icons.map, color: Colors.red.shade700),
                tooltip: 'Haritada Göster',
              ),
            PopupMenuButton<String>(
              onSelected: (value) {
                if (value == 'remove') {
                  _confirmRemoveFriend(friend);
                }
              },
              itemBuilder: (context) => [
                const PopupMenuItem(
                  value: 'remove',
                  child: ListTile(
                    leading: Icon(Icons.person_remove, color: Colors.red),
                    title: Text('Arkadaşlıktan Çıkar'),
                  ),
                ),
              ],
            ),
          ],
        ),
        isThreeLine: true,
      ),
    );
  }

  Widget _buildRequestsTab() {
    if (_friendsService.pendingRequests.isEmpty) {
      return const Center(
        child: Text('Bekleyen arkadaş isteği yok'),
      );
    }

    return ListView.builder(
      padding: const EdgeInsets.all(16),
      itemCount: _friendsService.pendingRequests.length,
      itemBuilder: (context, index) {
        final request = _friendsService.pendingRequests[index];
        return Card(
          child: ListTile(
            leading: CircleAvatar(
              child: request.fromUserPhoto != null
                  ? CachedNetworkImage(
                      imageUrl: request.fromUserPhoto!,
                      imageBuilder: (context, imageProvider) => Container(
                        decoration: BoxDecoration(
                          shape: BoxShape.circle,
                          image: DecorationImage(
                            image: imageProvider,
                            fit: BoxFit.cover,
                          ),
                        ),
                      ),
                      placeholder: (context, url) =>
                          const CircularProgressIndicator(),
                      errorWidget: (context, url, error) => Text(
                        request.fromUserName[0].toUpperCase(),
                        style: const TextStyle(
                            color: Colors.white, fontWeight: FontWeight.bold),
                      ),
                    )
                  : Text(
                      request.fromUserName[0].toUpperCase(),
                      style: const TextStyle(
                          color: Colors.white, fontWeight: FontWeight.bold),
                    ),
            ),
            title: Text(request.fromUserName),
            subtitle: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(request.fromUserEmail),
                if (request.message != null && request.message!.isNotEmpty)
                  Text(
                    '"${request.message}"',
                    style: const TextStyle(fontStyle: FontStyle.italic),
                  ),
                Text(
                  _getTimeAgoText(request.requestedAt),
                  style: TextStyle(
                    fontSize: 12,
                    color: Colors.grey.shade600,
                  ),
                ),
              ],
            ),
            trailing: Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                IconButton(
                  onPressed: () => _respondToRequest(request.id, true),
                  icon: const Icon(Icons.check, color: Colors.green),
                  tooltip: 'Kabul Et',
                ),
                IconButton(
                  onPressed: () => _respondToRequest(request.id, false),
                  icon: const Icon(Icons.close, color: Colors.red),
                  tooltip: 'Reddet',
                ),
              ],
            ),
            isThreeLine: true,
          ),
        );
      },
    );
  }

  Widget _buildEmergencyTab() {
    return ListView(
      padding: const EdgeInsets.all(16),
      children: [
        Card(
          color: Colors.red.shade50,
          child: Padding(
            padding: const EdgeInsets.all(16),
            child: Column(
              children: [
                Icon(
                  Icons.emergency,
                  size: 40,
                  color: Colors.red.shade700,
                ),
                const SizedBox(height: 10),
                Text(
                  'Acil Durum Kontrol',
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                    color: Colors.red.shade700,
                  ),
                ),
                const SizedBox(height: 10),
                Text(
                  'Deprem anında arkadaşlarınızın durumunu kontrol edin',
                  textAlign: TextAlign.center,
                  style: TextStyle(color: Colors.grey.shade700),
                ),
                const SizedBox(height: 15),
                ElevatedButton.icon(
                  onPressed: () async {
                    final emergencyFriends =
                        await _friendsService.getEmergencyFriendStatus();
                    _showEmergencyStatus(emergencyFriends);
                  },
                  icon: const Icon(Icons.search),
                  label: const Text('Durumu Kontrol Et'),
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.red.shade700,
                    foregroundColor: Colors.white,
                  ),
                ),
              ],
            ),
          ),
        ),
        const SizedBox(height: 20),
        Text(
          'Çevrimiçi Arkadaşlar',
          style: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.bold,
            color: Colors.grey.shade700,
          ),
        ),
        const SizedBox(height: 10),
        ..._friendsService.onlineFriends
            .map((friend) => _buildEmergencyFriendCard(friend)),
        if (_friendsService.onlineFriends.isEmpty)
          const Card(
            child: Padding(
              padding: EdgeInsets.all(16),
              child: Text(
                'Şu anda çevrimiçi arkadaş yok',
                textAlign: TextAlign.center,
              ),
            ),
          ),
      ],
    );
  }

  Widget _buildEmergencyFriendCard(Friend friend) {
    return Card(
      child: ListTile(
        leading: Stack(
          children: [
            CircleAvatar(
              child: friend.photoUrl != null
                  ? CachedNetworkImage(
                      imageUrl: friend.photoUrl!,
                      imageBuilder: (context, imageProvider) => Container(
                        decoration: BoxDecoration(
                          shape: BoxShape.circle,
                          image: DecorationImage(
                            image: imageProvider,
                            fit: BoxFit.cover,
                          ),
                        ),
                      ),
                      placeholder: (context, url) =>
                          const CircularProgressIndicator(),
                      errorWidget: (context, url, error) => Text(
                        friend.name[0].toUpperCase(),
                        style: const TextStyle(
                            color: Colors.white, fontWeight: FontWeight.bold),
                      ),
                    )
                  : Text(
                      friend.name[0].toUpperCase(),
                      style: const TextStyle(
                          color: Colors.white, fontWeight: FontWeight.bold),
                    ),
            ),
            Positioned(
              right: 0,
              bottom: 0,
              child: Container(
                width: 12,
                height: 12,
                decoration: BoxDecoration(
                  color: friend.status == 'in_emergency'
                      ? Colors.red
                      : Colors.green,
                  shape: BoxShape.circle,
                  border: Border.all(color: Colors.white, width: 2),
                ),
              ),
            ),
          ],
        ),
        title: Text(friend.name),
        subtitle: Text(_getEmergencyStatus(friend)),
        trailing: friend.latitude != null && friend.longitude != null
            ? IconButton(
                onPressed: () => _showFriendOnMap(friend),
                icon: Icon(Icons.map, color: Colors.red.shade700),
              )
            : null,
      ),
    );
  }

  String _getLastSeenText(DateTime? lastSeen) {
    if (lastSeen == null) return 'Hiçbir zaman';

    final diff = DateTime.now().difference(lastSeen);
    if (diff.inMinutes < 5) return 'Az önce';
    if (diff.inHours < 1) return '${diff.inMinutes} dakika önce';
    if (diff.inDays < 1) return '${diff.inHours} saat önce';
    return '${diff.inDays} gün önce';
  }

  String _getTimeAgoText(DateTime dateTime) {
    final diff = DateTime.now().difference(dateTime);
    if (diff.inMinutes < 5) return 'Az önce';
    if (diff.inHours < 1) return '${diff.inMinutes} dakika önce';
    if (diff.inDays < 1) return '${diff.inHours} saat önce';
    return '${diff.inDays} gün önce';
  }

  String _getEmergencyStatus(Friend friend) {
    if (friend.status == 'in_emergency') return 'ACİL DURUM!';
    if (friend.isOnline) return 'Güvende - Çevrimiçi';
    if (friend.lastSeen != null) {
      final diff = DateTime.now().difference(friend.lastSeen!);
      if (diff.inMinutes < 30) return 'Güvende - Az önce çevrimiçiydi';
    }
    return 'Durum belirsiz';
  }

  void _confirmRemoveFriend(Friend friend) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Arkadaşlıktan Çıkar'),
        content: Text(
            '${friend.name} adlı kişiyi arkadaş listenizden çıkarmak istediğinizden emin misiniz?'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: const Text('İptal'),
          ),
          ElevatedButton(
            onPressed: () async {
              Navigator.pop(context);
              final success = await _friendsService.removeFriend(friend.id);
              if (success) {
                setState(() {});
                _showMessage('${friend.name} arkadaş listesinden çıkarıldı');
              } else {
                _showMessage('İşlem başarısız', isError: true);
              }
            },
            style: ElevatedButton.styleFrom(backgroundColor: Colors.red),
            child: const Text('Çıkar', style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  void _showFriendOnMap(Friend friend) {
    // MapScreen'e arkadaşın konumu ile git
    _showMessage('Harita özelliği yakında eklenecek');
  }

  void _showEmergencyStatus(List<Friend> emergencyFriends) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Row(
          children: [
            Icon(Icons.emergency, color: Colors.red.shade700),
            const SizedBox(width: 10),
            const Text('Acil Durum Raporu'),
          ],
        ),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text(
                '${emergencyFriends.length} arkadaşınızın durumu kontrol edildi'),
            const SizedBox(height: 10),
            ...emergencyFriends.map((friend) => ListTile(
                  leading: CircleAvatar(
                    backgroundColor: friend.status == 'in_emergency'
                        ? Colors.red
                        : Colors.green,
                    child: Text(friend.name[0].toUpperCase()),
                  ),
                  title: Text(friend.name),
                  subtitle: Text(_getEmergencyStatus(friend)),
                )),
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
