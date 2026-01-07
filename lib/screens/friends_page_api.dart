import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import '../services/friends_service_backend.dart';
import '../services/auth_service.dart';
import '../l10n/app_localizations.dart';

class FriendsPageAPI extends StatefulWidget {
  const FriendsPageAPI({super.key});

  @override
  State<FriendsPageAPI> createState() => _FriendsPageAPIState();
}

class _FriendsPageAPIState extends State<FriendsPageAPI>
    with SingleTickerProviderStateMixin {
  final FriendsService _friendsService = FriendsService();
  final AuthService _authService = AuthService();
  final TextEditingController _shareCodeController = TextEditingController();

  late TabController _tabController;
  bool _isLoading = true;
  String _myShareCode = '';
  List<Map<String, dynamic>> _friends = [];
  List<Map<String, dynamic>> _pendingRequests = [];
  List<Map<String, dynamic>> _sentRequests = [];

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
      // Kullanıcı bilgilerini yükle
      await _authService.loadUserData();

      // Profile bilgilerini al
      final profile = await _friendsService.getOrCreateProfile(
        email: _authService.currentUserEmail ?? '',
        displayName: _authService.currentUserName ?? 'Kullanıcı',
        photoURL: _authService.currentUserPhotoUrl,
      );

      // Arkadaş listesini al
      final friends = await _friendsService.getFriends();

      // Bekleyen istekleri al
      final requests = await _friendsService.getFriendRequests();

      setState(() {
        _myShareCode = profile['shareCode'] ?? '';
        _friends = friends;
        _pendingRequests = requests['pendingRequests'] ?? [];
        _sentRequests = requests['sentRequests'] ?? [];
        _isLoading = false;
      });
    } catch (e) {
      print('❌ Veri yükleme hatası: $e');
      setState(() => _isLoading = false);
      _showSnackBarLocalized('data_load_failed', isError: true);
    }
  }

  Future<void> _addFriendByCode() async {
    final code = _shareCodeController.text.trim().toUpperCase();
    if (code.isEmpty) {
      _showSnackBarLocalized('enter_share_code', isError: true);
      return;
    }

    if (code.length != 6) {
      _showSnackBarLocalized('share_code_length', isError: true);
      return;
    }

    setState(() => _isLoading = true);

    final result = await _friendsService.sendFriendRequest(code);

    setState(() => _isLoading = false);

    if (result['success']) {
      _shareCodeController.clear();
      _showSnackBar(result['message'], isError: false);
      await _loadData(); // Listeyi yenile
    } else {
      _showSnackBar(result['message'], isError: true);
    }
  }

  Future<void> _acceptRequest(String requestId) async {
    setState(() => _isLoading = true);

    final success = await _friendsService.acceptFriendRequest(requestId);

    if (success) {
      _showSnackBarLocalized('request_accepted', isError: false);
      await _loadData();
    } else {
      _showSnackBarLocalized('request_accept_failed', isError: true);
      setState(() => _isLoading = false);
    }
  }

  Future<void> _rejectRequest(String requestId) async {
    setState(() => _isLoading = true);

    final success = await _friendsService.rejectFriendRequest(requestId);

    if (success) {
      _showSnackBarLocalized('request_rejected', isError: false);
      await _loadData();
    } else {
      _showSnackBarLocalized('request_reject_failed', isError: true);
      setState(() => _isLoading = false);
    }
  }

  Future<void> _removeFriend(String friendUID, String friendName) async {
    final l10n = AppLocalizations.of(context);
    final confirmed = await showDialog<bool>(
      context: context,
      builder: (ctx) => AlertDialog(
        title: Text(l10n?.get('remove_friend_title') ?? 'Remove Friend'),
        content: Text(
            '${l10n?.get('remove_friend_confirm')?.replaceAll('{name}', friendName) ?? 'Remove $friendName from friends?'}'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx, false),
            child: Text(l10n?.get('cancel') ?? 'Cancel'),
          ),
          ElevatedButton(
            onPressed: () => Navigator.pop(ctx, true),
            style: ElevatedButton.styleFrom(backgroundColor: Colors.red),
            child: Text(l10n?.get('remove') ?? 'Remove'),
          ),
        ],
      ),
    );

    if (confirmed != true) return;

    setState(() => _isLoading = true);

    final success = await _friendsService.removeFriend(friendUID);

    if (success) {
      _showSnackBar(
          l10n
                  ?.get('friend_removed_success')
                  ?.replaceAll('{name}', friendName) ??
              '$friendName removed from friends',
          isError: false);
      await _loadData();
    } else {
      _showSnackBarLocalized('friend_remove_failed', isError: true);
      setState(() => _isLoading = false);
    }
  }

  void _copyShareCode() {
    final l10n = AppLocalizations.of(context);
    Clipboard.setData(ClipboardData(text: _myShareCode));
    _showSnackBar(
        '${l10n?.get('share_code_copied') ?? 'Share code copied'}: $_myShareCode',
        isError: false);
  }

  void _showSnackBarLocalized(String key, {required bool isError}) {
    final l10n = AppLocalizations.of(context);
    _showSnackBar(l10n?.get(key) ?? key, isError: isError);
  }

  void _showSnackBar(String message, {required bool isError}) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Row(
          children: [
            Icon(
              isError ? Icons.error_outline : Icons.check_circle,
              color: Colors.white,
            ),
            const SizedBox(width: 12),
            Expanded(child: Text(message)),
          ],
        ),
        backgroundColor:
            isError ? const Color(0xFFFF3333) : const Color(0xFF4CAF50),
        behavior: SnackBarBehavior.floating,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context);
    return Scaffold(
      body: Column(
        children: [
          // Share Code Card
          Container(
            margin: const EdgeInsets.all(16),
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              gradient: const LinearGradient(
                colors: [Color(0xFFFF3A3D), Color(0xFFFF6B6D)],
                begin: Alignment.topLeft,
                end: Alignment.bottomRight,
              ),
              borderRadius: BorderRadius.circular(16),
              boxShadow: [
                BoxShadow(
                  color: const Color(0xFFFF3A3D).withOpacity(0.3),
                  blurRadius: 12,
                  offset: const Offset(0, 4),
                ),
              ],
            ),
            child: Column(
              children: [
                Text(
                  l10n?.get('my_share_code') ?? 'My Share Code',
                  style: const TextStyle(
                    color: Colors.white70,
                    fontSize: 14,
                  ),
                ),
                const SizedBox(height: 8),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(
                      _myShareCode.isEmpty ? '------' : _myShareCode,
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 28,
                        fontWeight: FontWeight.bold,
                        letterSpacing: 4,
                      ),
                    ),
                    const SizedBox(width: 12),
                    IconButton(
                      onPressed: _myShareCode.isEmpty ? null : _copyShareCode,
                      icon: const Icon(Icons.copy, color: Colors.white),
                      tooltip: l10n?.get('copy') ?? 'Copy',
                    ),
                  ],
                ),
              ],
            ),
          ),

          // Add Friend Input
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            child: Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: _shareCodeController,
                    decoration: InputDecoration(
                      hintText:
                          l10n?.get('friend_share_code') ?? 'Friend Share Code',
                      prefixIcon: const Icon(Icons.person_add),
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(30),
                      ),
                      contentPadding:
                          const EdgeInsets.symmetric(horizontal: 20),
                    ),
                    textCapitalization: TextCapitalization.characters,
                    maxLength: 6,
                    buildCounter: (context,
                            {required currentLength,
                            maxLength,
                            required isFocused}) =>
                        null,
                  ),
                ),
                const SizedBox(width: 12),
                ElevatedButton(
                  onPressed: _isLoading ? null : _addFriendByCode,
                  style: ElevatedButton.styleFrom(
                    backgroundColor: const Color(0xFFFF3A3D),
                    foregroundColor: Colors.white,
                    shape: const CircleBorder(),
                    padding: const EdgeInsets.all(16),
                  ),
                  child: _isLoading
                      ? const SizedBox(
                          width: 20,
                          height: 20,
                          child: CircularProgressIndicator(
                            color: Colors.white,
                            strokeWidth: 2,
                          ),
                        )
                      : const Icon(Icons.send),
                ),
              ],
            ),
          ),

          const SizedBox(height: 16),

          // Tabs
          TabBar(
            controller: _tabController,
            labelColor: const Color(0xFFFF3A3D),
            unselectedLabelColor: Colors.grey,
            indicatorColor: const Color(0xFFFF3A3D),
            tabs: [
              Tab(
                  text:
                      '${l10n?.get('friends') ?? 'Friends'} (${_friends.length})'),
              Tab(
                  text:
                      '${l10n?.get('incoming_requests') ?? 'Incoming'} (${_pendingRequests.length})'),
              Tab(
                  text:
                      '${l10n?.get('outgoing_requests') ?? 'Outgoing'} (${_sentRequests.length})'),
            ],
          ),

          // Tab Content
          Expanded(
            child: _isLoading
                ? const Center(child: CircularProgressIndicator())
                : TabBarView(
                    controller: _tabController,
                    children: [
                      _buildFriendsList(l10n),
                      _buildPendingRequestsList(l10n),
                      _buildSentRequestsList(l10n),
                    ],
                  ),
          ),
        ],
      ),
    );
  }

  Widget _buildFriendsList(AppLocalizations? l10n) {
    if (_friends.isEmpty) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.people_outline, size: 64, color: Colors.grey[400]),
            const SizedBox(height: 16),
            Text(
              l10n?.get('no_friends') ?? 'No friends yet',
              style: TextStyle(color: Colors.grey[600], fontSize: 16),
            ),
            const SizedBox(height: 8),
            Text(
              l10n?.get('add_friend_hint') ??
                  'Add friends by entering share code above',
              style: TextStyle(color: Colors.grey[500], fontSize: 14),
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
        itemCount: _friends.length,
        itemBuilder: (context, index) {
          final friend = _friends[index];
          final isOnline = friend['isOnline'] ?? false;
          final location = friend['location'];

          return Card(
            margin: const EdgeInsets.only(bottom: 12),
            elevation: 2,
            shape:
                RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
            child: ListTile(
              contentPadding: const EdgeInsets.all(12),
              leading: Stack(
                children: [
                  CircleAvatar(
                    radius: 28,
                    backgroundColor: const Color(0xFFFF3A3D),
                    backgroundImage: friend['photoURL'] != null &&
                            friend['photoURL'].toString().isNotEmpty
                        ? NetworkImage(friend['photoURL'])
                        : null,
                    child: friend['photoURL'] == null ||
                            friend['photoURL'].toString().isEmpty
                        ? Text(
                            (friend['displayName'] ?? 'U')[0].toUpperCase(),
                            style: const TextStyle(
                                color: Colors.white,
                                fontSize: 24,
                                fontWeight: FontWeight.bold),
                          )
                        : null,
                  ),
                  if (isOnline)
                    Positioned(
                      bottom: 0,
                      right: 0,
                      child: Container(
                        width: 14,
                        height: 14,
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
                friend['displayName'] ?? l10n?.get('unknown') ?? 'Unknown',
                style: const TextStyle(fontWeight: FontWeight.bold),
              ),
              subtitle: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  const SizedBox(height: 4),
                  if (location != null && location['address'] != null)
                    Row(
                      children: [
                        const Icon(Icons.location_on,
                            size: 14, color: Colors.grey),
                        const SizedBox(width: 4),
                        Expanded(
                          child: Text(
                            location['address'],
                            style: const TextStyle(
                                fontSize: 12, color: Colors.grey),
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          ),
                        ),
                      ],
                    ),
                  const SizedBox(height: 4),
                  Container(
                    padding:
                        const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
                    decoration: BoxDecoration(
                      color: isOnline
                          ? Colors.green.withOpacity(0.1)
                          : Colors.grey.withOpacity(0.1),
                      borderRadius: BorderRadius.circular(12),
                    ),
                    child: Text(
                      isOnline
                          ? l10n?.get('online') ?? 'Online'
                          : l10n?.get('offline') ?? 'Offline',
                      style: TextStyle(
                        fontSize: 11,
                        color: isOnline ? Colors.green : Colors.grey,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ),
                ],
              ),
              trailing: IconButton(
                icon: const Icon(Icons.more_vert),
                onPressed: () => _showFriendOptions(friend),
              ),
            ),
          );
        },
      ),
    );
  }

  Widget _buildPendingRequestsList(AppLocalizations? l10n) {
    if (_pendingRequests.isEmpty) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.inbox_outlined, size: 64, color: Colors.grey[400]),
            const SizedBox(height: 16),
            Text(
              l10n?.get('no_incoming_requests') ?? 'No incoming requests',
              style: TextStyle(color: Colors.grey[600], fontSize: 16),
            ),
          ],
        ),
      );
    }

    return ListView.builder(
      padding: const EdgeInsets.all(16),
      itemCount: _pendingRequests.length,
      itemBuilder: (context, index) {
        final request = _pendingRequests[index];
        final fromUser = request['fromUser'];

        return Card(
          margin: const EdgeInsets.only(bottom: 12),
          elevation: 2,
          shape:
              RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
          child: Padding(
            padding: const EdgeInsets.all(12),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  children: [
                    CircleAvatar(
                      radius: 24,
                      backgroundColor: const Color(0xFFFF3A3D),
                      backgroundImage: fromUser['photoURL'] != null &&
                              fromUser['photoURL'].toString().isNotEmpty
                          ? NetworkImage(fromUser['photoURL'])
                          : null,
                      child: fromUser['photoURL'] == null ||
                              fromUser['photoURL'].toString().isEmpty
                          ? Text(
                              (fromUser['displayName'] ?? 'U')[0].toUpperCase(),
                              style: const TextStyle(
                                  color: Colors.white,
                                  fontSize: 20,
                                  fontWeight: FontWeight.bold),
                            )
                          : null,
                    ),
                    const SizedBox(width: 12),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            fromUser['displayName'] ??
                                l10n?.get('unknown') ??
                                'Unknown',
                            style: const TextStyle(
                                fontWeight: FontWeight.bold, fontSize: 16),
                          ),
                          Text(
                            fromUser['email'] ?? '',
                            style: const TextStyle(
                                color: Colors.grey, fontSize: 12),
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
                if (request['message'] != null &&
                    request['message'].toString().isNotEmpty) ...[
                  const SizedBox(height: 12),
                  Container(
                    padding: const EdgeInsets.all(12),
                    decoration: BoxDecoration(
                      color: Colors.grey[100],
                      borderRadius: BorderRadius.circular(8),
                    ),
                    child: Text(
                      request['message'],
                      style: const TextStyle(fontSize: 14),
                    ),
                  ),
                ],
                const SizedBox(height: 12),
                Row(
                  children: [
                    Expanded(
                      child: ElevatedButton.icon(
                        onPressed: _isLoading
                            ? null
                            : () => _acceptRequest(request['_id']),
                        icon: const Icon(Icons.check),
                        label: Text(l10n?.get('accept') ?? 'Accept'),
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.green,
                          foregroundColor: Colors.white,
                        ),
                      ),
                    ),
                    const SizedBox(width: 12),
                    Expanded(
                      child: OutlinedButton.icon(
                        onPressed: _isLoading
                            ? null
                            : () => _rejectRequest(request['_id']),
                        icon: const Icon(Icons.close),
                        label: Text(l10n?.get('reject') ?? 'Reject'),
                        style: OutlinedButton.styleFrom(
                          foregroundColor: Colors.red,
                        ),
                      ),
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

  Widget _buildSentRequestsList(AppLocalizations? l10n) {
    if (_sentRequests.isEmpty) {
      return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.send_outlined, size: 64, color: Colors.grey[400]),
            const SizedBox(height: 16),
            Text(
              l10n?.get('no_outgoing_requests') ?? 'No outgoing requests',
              style: TextStyle(color: Colors.grey[600], fontSize: 16),
            ),
          ],
        ),
      );
    }

    return ListView.builder(
      padding: const EdgeInsets.all(16),
      itemCount: _sentRequests.length,
      itemBuilder: (context, index) {
        final request = _sentRequests[index];
        final toUser = request['toUser'];

        return Card(
          margin: const EdgeInsets.only(bottom: 12),
          elevation: 2,
          shape:
              RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
          child: ListTile(
            contentPadding: const EdgeInsets.all(12),
            leading: CircleAvatar(
              radius: 24,
              backgroundColor: const Color(0xFFFF3A3D),
              backgroundImage: toUser['photoURL'] != null &&
                      toUser['photoURL'].toString().isNotEmpty
                  ? NetworkImage(toUser['photoURL'])
                  : null,
              child: toUser['photoURL'] == null ||
                      toUser['photoURL'].toString().isEmpty
                  ? Text(
                      (toUser['displayName'] ?? 'U')[0].toUpperCase(),
                      style: const TextStyle(
                          color: Colors.white,
                          fontSize: 20,
                          fontWeight: FontWeight.bold),
                    )
                  : null,
            ),
            title: Text(
              toUser['displayName'] ?? l10n?.get('unknown') ?? 'Unknown',
              style: const TextStyle(fontWeight: FontWeight.bold),
            ),
            subtitle: Text(
              l10n?.get('waiting_for_approval') ?? 'Waiting for approval...',
              style: TextStyle(color: Colors.grey[600], fontSize: 12),
            ),
            trailing: Icon(Icons.schedule, color: Colors.orange[700]),
          ),
        );
      },
    );
  }

  void _showFriendOptions(Map<String, dynamic> friend) {
    final l10n = AppLocalizations.of(context);
    showModalBottomSheet(
      context: context,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      isScrollControlled: true,
      builder: (ctx) {
        final location = friend['location'];
        return Padding(
          padding: const EdgeInsets.all(24),
          child: Container(
            constraints: BoxConstraints(
              minHeight: MediaQuery.of(ctx).size.height * 0.35,
              maxHeight: MediaQuery.of(ctx).size.height * 0.60,
            ),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                CircleAvatar(
                  radius: 36,
                  backgroundColor: const Color(0xFFFF3A3D),
                  backgroundImage: friend['photoURL'] != null &&
                          friend['photoURL'].toString().isNotEmpty
                      ? NetworkImage(friend['photoURL'])
                      : null,
                  child: friend['photoURL'] == null ||
                          friend['photoURL'].toString().isEmpty
                      ? Text(
                          (friend['displayName'] ?? 'U')[0].toUpperCase(),
                          style: const TextStyle(
                              color: Colors.white,
                              fontSize: 28,
                              fontWeight: FontWeight.bold),
                        )
                      : null,
                ),
                const SizedBox(height: 16),
                Text(
                  friend['displayName'] ?? l10n?.get('unknown') ?? 'Unknown',
                  style: const TextStyle(
                      fontSize: 20, fontWeight: FontWeight.bold),
                ),
                const SizedBox(height: 8),
                // Email bilgisi kaldırıldı
                // Konum bilgisi kaldırıldı
                const SizedBox(height: 24),
                SizedBox(
                  width: double.infinity,
                  child: OutlinedButton.icon(
                    onPressed: () {
                      Navigator.pop(ctx);
                      _removeFriend(
                          friend['uid'],
                          friend['displayName'] ??
                              l10n?.get('unknown') ??
                              'Unknown');
                    },
                    icon: const Icon(Icons.person_remove, color: Colors.red),
                    label: Text(l10n?.get('remove_friend') ?? 'Remove Friend'),
                    style: OutlinedButton.styleFrom(
                      foregroundColor: Colors.red,
                      side: const BorderSide(color: Colors.red),
                      padding: const EdgeInsets.symmetric(vertical: 14),
                    ),
                  ),
                ),
              ],
            ),
          ),
        );
      },
    );
  }
}
