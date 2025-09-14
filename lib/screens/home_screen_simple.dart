import 'package:flutter/material.dart';
import 'package:package_info_plus/package_info_plus.dart';
import '../services/notification_service.dart';
import '../services/location_service.dart';
import '../services/auth_service.dart';
import './map_screen.dart';
import 'report_screen.dart';
import 'login_screen.dart';
import 'friends_screen_simple.dart';
import 'settings_screen.dart';
import 'chat_rooms_screen.dart';

class HomeScreen extends StatefulWidget {
  final Function(bool)? onThemeChanged;

  const HomeScreen({super.key, this.onThemeChanged});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final LocationService _locationService = LocationService();
  final NotificationService _notificationService = NotificationService();
  final AuthService _authService = AuthService();
  bool _isLocationLoading = true;
  bool _isLoggedIn = false;
  String? _userName;
  String? _userEmail;
  String? _shareCode;
  String _appVersion = '';

  @override
  void initState() {
    super.initState();
    _initializeServices();
    _loadAppVersion();
  }

  Future<void> _loadAppVersion() async {
    try {
      final packageInfo = await PackageInfo.fromPlatform();
      print(
          '📱 PackageInfo - Version: ${packageInfo.version}, BuildNumber: ${packageInfo.buildNumber}');
      setState(() {
        _appVersion = 'v${packageInfo.version}+${packageInfo.buildNumber}';
      });
      print('✅ App version set to: $_appVersion');
    } catch (e) {
      print('❌ App version yüklenemedi: $e');
      setState(() {
        _appVersion = 'v1.3.1';
      });
    }
  }

  Future<void> _initializeServices() async {
    try {
      // Auth servisini kontrol et
      await _authService.loadUserData();

      if (mounted) {
        setState(() {
          _isLoggedIn = _authService.isLoggedIn;
          _userName = _authService.currentUserName;
          _userEmail = _authService.currentUserEmail;
          _shareCode = _authService.currentUserShareCode;
        });
      }

      // Notification servisini başlat
      await _notificationService.initialize();
      print('✅ Notification service başlatıldı');

      // Konum servisini başlat
      final locationSuccess = await _locationService.initializeLocation();
      if (locationSuccess) {
        print('✅ Location service başlatıldı');
      } else {
        print('❌ Location service başlatılamadı');
      }
    } catch (e) {
      print('❌ Service başlatma hatası: $e');
    } finally {
      if (mounted) {
        setState(() {
          _isLocationLoading = false;
        });
      }
    }
  }

  void _showEarthquakeAlert(BuildContext context) async {
    print('Test bildirim butonu basıldı');

    // Önce sistem bildirimi gönder
    try {
      await _notificationService.showTestNotification();
      print('showTestNotification çağrıldı');
    } catch (e) {
      print('Bildirim gönderme hatası: $e');
    }

    // Kullanıcıya bildir
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: const Text(
            '📱 Sistem bildirimi gönderildi! Üst paneli kontrol edin.'),
        backgroundColor: Colors.green.shade600,
        duration: const Duration(seconds: 3),
      ),
    );

    // Sonra dialog göster
    showDialog(
      context: context,
      barrierDismissible: false,
      builder: (BuildContext context) {
        return AlertDialog(
          backgroundColor: Colors.red.shade50,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(20),
          ),
          title: Row(
            children: [
              Icon(
                Icons.warning_amber_rounded,
                color: Colors.red.shade700,
                size: 30,
              ),
              const SizedBox(width: 10),
              Text(
                'DEPREM UYARISI!',
                style: TextStyle(
                  color: Colors.red.shade800,
                  fontWeight: FontWeight.bold,
                  fontSize: 18,
                ),
              ),
            ],
          ),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                'Bölgenizde deprem meydana geldi!',
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.w600,
                  color: Colors.red.shade800,
                ),
              ),
              const SizedBox(height: 10),
              Container(
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(10),
                  border: Border.all(color: Colors.red.shade200),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    _buildInfoRow('Büyüklük:', '5.2'),
                    const SizedBox(height: 5),
                    _buildInfoRow('Konum:', 'İstanbul, Türkiye'),
                    const SizedBox(height: 5),
                    _buildInfoRow('Derinlik:', '12 km'),
                    const SizedBox(height: 5),
                    _buildInfoRow(
                        'Zaman:', DateTime.now().toString().substring(0, 16)),
                  ],
                ),
              ),
              const SizedBox(height: 15),
              Text(
                '• Sakin olun ve güvenli bir yere geçin\n• Sarsıntı bitene kadar bekleyin\n• Bina dışına çıkmaya çalışmayın',
                style: TextStyle(
                  fontSize: 14,
                  color: Colors.grey.shade700,
                ),
              ),
            ],
          ),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text(
                'Anladım',
                style: TextStyle(
                  color: Colors.red.shade700,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.of(context).pop();
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => const MapScreen(),
                  ),
                );
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.red.shade700,
                foregroundColor: Colors.white,
              ),
              child: const Text('Haritayı Gör'),
            ),
          ],
        );
      },
    );
  }

  Widget _buildInfoRow(String label, String value) {
    return Row(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        SizedBox(
          width: 70,
          child: Text(
            label,
            style: TextStyle(
              fontWeight: FontWeight.w600,
              color: Colors.grey.shade700,
              fontSize: 13,
            ),
          ),
        ),
        Expanded(
          child: Text(
            value,
            style: TextStyle(
              color: Colors.red.shade800,
              fontWeight: FontWeight.w600,
              fontSize: 13,
            ),
          ),
        ),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    final isDarkTheme = Theme.of(context).brightness == Brightness.dark;
    final backgroundColor =
        isDarkTheme ? Theme.of(context).colorScheme.background : Colors.white;
    final cardColor =
        isDarkTheme ? Theme.of(context).colorScheme.surface : Colors.white;
    final textColor = Theme.of(context).colorScheme.onBackground;
    final primaryColor = isDarkTheme
        ? Theme.of(context).colorScheme.primary
        : Colors.red.shade700;

    return Scaffold(
      backgroundColor: backgroundColor,
      appBar: AppBar(
        title: Text(
          'Deprem Bildirim',
          style: TextStyle(
            color: Theme.of(context).colorScheme.onPrimary,
            fontWeight: FontWeight.bold,
          ),
        ),
        backgroundColor: primaryColor,
        elevation: 0,
        actions: [
          // Settings butonu
          IconButton(
            onPressed: () async {
              final result = await Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => const SettingsScreen(),
                ),
              );

              // Settings'den döndüğünde tema değişti mi kontrol et
              if (result != null && result['themeChanged'] == true) {
                widget.onThemeChanged?.call(result['isDarkTheme']);
              }
            },
            icon: Icon(Icons.settings,
                color: Theme.of(context).colorScheme.onPrimary),
            tooltip: 'Ayarlar',
          ),
          if (_isLoggedIn)
            IconButton(
              onPressed: () async {
                await _authService.signOut();
                setState(() {
                  _isLoggedIn = false;
                });
                ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Çıkış yapıldı')),
                );
              },
              icon: Icon(Icons.logout,
                  color: Theme.of(context).colorScheme.onPrimary),
              tooltip: 'Çıkış Yap',
            ),
          if (_isLocationLoading)
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: SizedBox(
                width: 20,
                height: 20,
                child: CircularProgressIndicator(
                  color: Theme.of(context).colorScheme.onPrimary,
                  strokeWidth: 2,
                ),
              ),
            ),
        ],
      ),
      body: Container(
        decoration: BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topCenter,
            end: Alignment.bottomCenter,
            colors: isDarkTheme
                ? [
                    Theme.of(context).colorScheme.background,
                    Theme.of(context).colorScheme.surface,
                  ]
                : [
                    Colors.red.shade50,
                    Colors.white,
                  ],
          ),
        ),
        child: SingleChildScrollView(
          child: Padding(
            padding: const EdgeInsets.all(20.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                // Deprem ikonu
                Container(
                  padding: const EdgeInsets.all(30),
                  decoration: BoxDecoration(
                    color: isDarkTheme
                        ? primaryColor.withOpacity(0.2)
                        : Colors.red.shade100,
                    shape: BoxShape.circle,
                  ),
                  child: Icon(
                    Icons.warning_rounded,
                    size: 80,
                    color: primaryColor,
                  ),
                ),
                const SizedBox(height: 30),
                // Başlık
                Text(
                  'Deprem Bildirim Sistemi',
                  style: TextStyle(
                    fontSize: 28,
                    fontWeight: FontWeight.bold,
                    color: primaryColor,
                  ),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 15),
                // Alt başlık
                Text(
                  'Bölgenizdeki son depremleri takip edin',
                  style: TextStyle(
                    fontSize: 16,
                    color: textColor.withOpacity(0.7),
                  ),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 8),
                // Build Version
                Container(
                  padding:
                      const EdgeInsets.symmetric(horizontal: 12, vertical: 4),
                  decoration: BoxDecoration(
                    color: isDarkTheme
                        ? Theme.of(context).colorScheme.primaryContainer
                        : Colors.blue.shade50,
                    borderRadius: BorderRadius.circular(20),
                    border: Border.all(
                      color: isDarkTheme
                          ? Theme.of(context).colorScheme.primary
                          : Colors.blue.shade200,
                    ),
                  ),
                  child: Text(
                    'Build $_appVersion - Temporary Simple Auth',
                    style: TextStyle(
                      fontSize: 12,
                      color: isDarkTheme
                          ? Theme.of(context).colorScheme.onPrimaryContainer
                          : Colors.blue.shade700,
                      fontWeight: FontWeight.w500,
                    ),
                  ),
                ),
                const SizedBox(height: 50),
                // Harita butonu
                SizedBox(
                  width: double.infinity,
                  height: 60,
                  child: ElevatedButton.icon(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => const MapScreen(),
                        ),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: primaryColor,
                      foregroundColor: Theme.of(context).colorScheme.onPrimary,
                      elevation: 3,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    icon: _isLocationLoading
                        ? SizedBox(
                            width: 20,
                            height: 20,
                            child: CircularProgressIndicator(
                              color: Theme.of(context).colorScheme.onPrimary,
                              strokeWidth: 2,
                            ),
                          )
                        : const Icon(Icons.map_outlined, size: 24),
                    label: Text(
                      _isLocationLoading ? 'Konum Alınıyor...' : 'Haritayı Aç',
                      style: const TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ),
                ),
                const SizedBox(height: 20),
                // Geçmiş depremler butonu
                SizedBox(
                  width: double.infinity,
                  height: 60,
                  child: OutlinedButton.icon(
                    onPressed: () {
                      // Geçmiş depremler sayfası (şimdilik boş)
                      ScaffoldMessenger.of(context).showSnackBar(
                        const SnackBar(
                          content: Text(
                              'Geçmiş depremler özelliği yakında eklenecek'),
                        ),
                      );
                    },
                    style: OutlinedButton.styleFrom(
                      foregroundColor: primaryColor,
                      side: BorderSide(color: primaryColor, width: 2),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    icon: const Icon(Icons.history, size: 24),
                    label: const Text(
                      'Geçmiş Depremler',
                      style: TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ),
                ),
                const SizedBox(height: 15),
                // Chat Odaları butonu
                SizedBox(
                  width: double.infinity,
                  height: 60,
                  child: ElevatedButton.icon(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => const ChatRoomsScreen(),
                        ),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: isDarkTheme
                          ? Colors.deepPurple.shade700
                          : Colors.deepPurple.shade600,
                      foregroundColor: Colors.white,
                      elevation: 3,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    icon: const Icon(Icons.chat_bubble_rounded, size: 24),
                    label: const Text(
                      'Chat Odaları',
                      style: TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ),
                ),
                const SizedBox(height: 15),
                // Rapor Et butonu
                SizedBox(
                  width: double.infinity,
                  height: 60,
                  child: ElevatedButton.icon(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => const ReportScreen(),
                        ),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.orange.shade600,
                      foregroundColor: Colors.white,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    icon: const Icon(Icons.report_problem, size: 24),
                    label: const Text(
                      'Deprem Rapor Et',
                      style: TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ),
                ),
                const SizedBox(height: 20),
                // Giriş/Arkadaşlar butonu
                SizedBox(
                  width: double.infinity,
                  height: 60,
                  child: ElevatedButton.icon(
                    onPressed: () {
                      if (_isLoggedIn) {
                        // Arkadaşlar sayfasına git
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => const FriendsScreen(),
                          ),
                        );
                      } else {
                        // Giriş sayfasına git
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => const LoginScreen(),
                          ),
                        ).then((_) {
                          // Giriş sayfasından döndükten sonra durumu güncelle
                          _initializeServices();
                        });
                      }
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: _isLoggedIn
                          ? Colors.green.shade600
                          : Colors.blue.shade600,
                      foregroundColor: Colors.white,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    icon: Icon(
                      _isLoggedIn ? Icons.people : Icons.login,
                      size: 24,
                    ),
                    label: Text(
                      _isLoggedIn ? 'Arkadaşlarım' : 'Giriş Yap',
                      style: const TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ),
                ),
                const SizedBox(height: 20),
                // Test Bildirim butonu
                SizedBox(
                  width: double.infinity,
                  height: 60,
                  child: ElevatedButton.icon(
                    onPressed: () {
                      _showEarthquakeAlert(context);
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: isDarkTheme
                          ? Colors.orange.shade700
                          : Colors.orange.shade600,
                      foregroundColor: Colors.white,
                      elevation: 3,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                    ),
                    icon: const Icon(Icons.notifications_active, size: 24),
                    label: const Text(
                      'Test Bildirim',
                      style: TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ),
                ),
                const SizedBox(height: 15),
                // Bildirim İzni Kontrol butonu
                SizedBox(
                  width: double.infinity,
                  height: 50,
                  child: OutlinedButton.icon(
                    onPressed: () async {
                      await _checkNotificationPermissions();
                    },
                    style: OutlinedButton.styleFrom(
                      foregroundColor: isDarkTheme
                          ? Colors.blue.shade300
                          : Colors.blue.shade700,
                      side: BorderSide(
                        color: isDarkTheme
                            ? Colors.blue.shade300
                            : Colors.blue.shade300,
                      ),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12),
                      ),
                    ),
                    icon: const Icon(Icons.settings, size: 20),
                    label: const Text(
                      'Bildirim İzinlerini Kontrol Et',
                      style: TextStyle(
                        fontSize: 14,
                        fontWeight: FontWeight.w500,
                      ),
                    ),
                  ),
                ),
                const SizedBox(height: 15),
                // Çıkış Yap butonu (DEBUG)
                if (_isLoggedIn)
                  SizedBox(
                    width: double.infinity,
                    height: 45,
                    child: OutlinedButton.icon(
                      onPressed: () async {
                        await _signOut();
                      },
                      style: OutlinedButton.styleFrom(
                        foregroundColor: isDarkTheme
                            ? Colors.red.shade300
                            : Colors.red.shade600,
                        side: BorderSide(
                          color: isDarkTheme
                              ? Colors.red.shade300
                              : Colors.red.shade300,
                        ),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(12),
                        ),
                      ),
                      icon: const Icon(Icons.logout, size: 18),
                      label: const Text(
                        'Çıkış Yap (Veri Temizle)',
                        style: TextStyle(
                          fontSize: 13,
                          fontWeight: FontWeight.w500,
                        ),
                      ),
                    ),
                  ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  // Bildirim izinlerini kontrol et - DEBUG
  Future<void> _checkNotificationPermissions() async {
    try {
      print('🔧 Manual permission check triggered');

      // Debug method'unu çağır
      await _notificationService.checkPermissionStatus();

      // Mevcut durumu kontrol et
      final bool enabled = await _notificationService.areNotificationsEnabled();

      // Kullanıcıya sonucu göster
      if (mounted) {
        showDialog(
          context: context,
          builder: (context) => AlertDialog(
            title: Row(
              children: [
                Icon(
                  enabled ? Icons.check_circle : Icons.error,
                  color: enabled ? Colors.green : Colors.red,
                ),
                SizedBox(width: 8),
                Text('Bildirim Durumu'),
              ],
            ),
            content: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Text(
                  enabled ? '✅ Bildirimler aktif!' : '❌ Bildirimler kapalı!',
                  style: TextStyle(
                    color: enabled ? Colors.green : Colors.red,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                if (!enabled) ...[
                  SizedBox(height: 12),
                  Text(
                      'Android Ayarlar → Uygulamalar → Deprem App → Bildirimler'),
                  SizedBox(height: 8),
                  Text('Tüm bildirim türlerini açın.'),
                ],
              ],
            ),
            actions: [
              if (!enabled)
                TextButton(
                  onPressed: () {
                    Navigator.pop(context);
                    _notificationService.initialize(); // Reinitialize
                  },
                  child: Text('Tekrar Dene'),
                ),
              ElevatedButton(
                onPressed: () => Navigator.pop(context),
                child: Text('Tamam'),
              ),
            ],
          ),
        );
      }
    } catch (e) {
      print('Permission check error: $e');

      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text('İzin kontrolü hatası: $e'),
            backgroundColor: Colors.red,
          ),
        );
      }
    }
  }

  // Çıkış yap ve verileri temizle (DEBUG)
  Future<void> _signOut() async {
    try {
      print('🚪 Çıkış yapılıyor...');

      // AuthService ile çıkış yap
      await _authService.signOut();

      // Local state'i temizle
      setState(() {
        _isLoggedIn = false;
        _userName = null;
        _userEmail = null;
        _shareCode = null;
      });

      print('✅ Çıkış başarılı');

      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('Çıkış yapıldı. Yeniden giriş yapabilirsiniz.'),
            backgroundColor: Colors.green,
          ),
        );
      }
    } catch (e) {
      print('❌ Çıkış hatası: $e');

      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text('Çıkış hatası: $e'),
            backgroundColor: Colors.red,
          ),
        );
      }
    }
  }
}
