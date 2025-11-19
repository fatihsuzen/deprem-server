import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../services/user_preferences_service.dart';
import '../services/location_update_service.dart';
import '../widgets/background_service_controller.dart';
import 'p2p_test_screen.dart';

class SettingsPage extends StatefulWidget {
  @override
  _SettingsPageState createState() => _SettingsPageState();
}

class _SettingsPageState extends State<SettingsPage> {
  final UserPreferencesService _prefsService = UserPreferencesService();
  final LocationUpdateService _locationUpdateService = LocationUpdateService();

  bool _notificationsEnabled = true;
  double _minimumMagnitude = UserPreferencesService.defaultMinMagnitude;
  double _maximumMagnitude = UserPreferencesService.defaultMaxMagnitude;
  double _notificationRadius = UserPreferencesService.defaultNotificationRadius;
  bool _soundEnabled = true;
  bool _vibrationEnabled = true;
  bool _locationServicesEnabled = true;
  bool _backgroundRefreshEnabled = true;
  bool _shareLocationWithFriends = true;
  bool _isLoading = true;

  @override
  void initState() {
    super.initState();
    _loadSettings();
  }

  Future<void> _loadSettings() async {
    final settings = await _prefsService.getAllSettings();
    setState(() {
      _minimumMagnitude = settings['minMagnitude'];
      _maximumMagnitude = settings['maxMagnitude'];
      _notificationRadius = settings['notificationRadius'];
      _shareLocationWithFriends = settings['shareLocation'];
      _isLoading = false;
    });

    print('📱 Local ayarlar yüklendi:');
    print('   Yarıçap: $_notificationRadius km');
    print('   Büyüklük: $_minimumMagnitude - $_maximumMagnitude');

    // Ayarlar yüklendikten sonra servera senkronize et
    print('🔄 Ayarlar servera gönderiliyor...');
    await _syncSettingsToServer();
  }

  Future<void> _syncSettingsToServer() async {
    try {
      await _locationUpdateService.sendNotificationSettings(
        notificationRadius: _notificationRadius,
        minMagnitude: _minimumMagnitude,
        maxMagnitude: _maximumMagnitude,
        shareLocationWithFriends: _shareLocationWithFriends,
      );
      print('✅ Ayarlar sunucuya senkronize edildi');
    } catch (e) {
      print('⚠️  Ayar senkronizasyonu hatası: $e');
    }
  }

  void _showMagnitudeDialog() {
    double tempMinMagnitude = _minimumMagnitude;
    double tempMaxMagnitude = _maximumMagnitude;
    showDialog(
      context: context,
      builder: (ctx) => StatefulBuilder(
        builder: (context, setDialogState) => AlertDialog(
          title: Text('Deprem Büyüklük Aralığı'),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                  'Haritada görmek istediğiniz deprem büyüklük aralığını seçin'),
              SizedBox(height: 20),
              // Minimum Büyüklük
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text('Minimum:',
                      style: TextStyle(fontWeight: FontWeight.bold)),
                  Text('${tempMinMagnitude.toStringAsFixed(1)} Mw',
                      style: TextStyle(
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                          color: Color(0xFFFF9800))),
                ],
              ),
              Slider(
                value: tempMinMagnitude,
                min: 0.0,
                max: 9.0,
                divisions: 90,
                activeColor: Color(0xFFFF9800),
                label: '${tempMinMagnitude.toStringAsFixed(1)}',
                onChanged: (value) {
                  if (value < tempMaxMagnitude) {
                    setDialogState(() {
                      tempMinMagnitude = value;
                    });
                  }
                },
              ),
              SizedBox(height: 20),
              // Maximum Büyüklük
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text('Maksimum:',
                      style: TextStyle(fontWeight: FontWeight.bold)),
                  Text('${tempMaxMagnitude.toStringAsFixed(1)} Mw',
                      style: TextStyle(
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                          color: Color(0xFFFF3333))),
                ],
              ),
              Slider(
                value: tempMaxMagnitude,
                min: 1.0,
                max: 10.0,
                divisions: 90,
                activeColor: Color(0xFFFF3333),
                label: '${tempMaxMagnitude.toStringAsFixed(1)}',
                onChanged: (value) {
                  if (value > tempMinMagnitude) {
                    setDialogState(() {
                      tempMaxMagnitude = value;
                    });
                  }
                },
              ),
              SizedBox(height: 10),
              Text(
                '${tempMinMagnitude.toStringAsFixed(1)} - ${tempMaxMagnitude.toStringAsFixed(1)} Mw arası depremler gösterilecek',
                style: TextStyle(fontSize: 12, color: Colors.grey[600]),
              ),
            ],
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(ctx),
              child: Text('İptal', style: TextStyle(color: Colors.grey[600])),
            ),
            ElevatedButton(
              onPressed: () async {
                await _prefsService.setMinMagnitude(tempMinMagnitude);
                await _prefsService.setMaxMagnitude(tempMaxMagnitude);
                setState(() {
                  _minimumMagnitude = tempMinMagnitude;
                  _maximumMagnitude = tempMaxMagnitude;
                });
                await _syncSettingsToServer();
                Navigator.pop(ctx);
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    content: Text(
                        'Büyüklük aralığı ${tempMinMagnitude.toStringAsFixed(1)}-${tempMaxMagnitude.toStringAsFixed(1)} olarak ayarlandı'),
                    backgroundColor: Color(0xFF4CAF50),
                  ),
                );
              },
              style:
                  ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
              child: Text('Kaydet', style: TextStyle(color: Colors.white)),
            ),
          ],
        ),
      ),
    );
  }

  void _showRatingDialog() {
    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: Row(
          children: [
            Icon(Icons.star, color: Colors.amber, size: 28),
            SizedBox(width: 8),
            Text('Bizi Değerlendirin'),
          ],
        ),
        content: Text(
          'Deprem Hattı\'nı beğendiniz mi? App Store\'da değerlendirerek bizi destekleyebilirsiniz!',
          style: TextStyle(fontSize: 15),
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx),
            child:
                Text('Daha Sonra', style: TextStyle(color: Colors.grey[600])),
          ),
          ElevatedButton(
            onPressed: () {
              Navigator.pop(ctx);
              ScaffoldMessenger.of(context).showSnackBar(
                SnackBar(
                  content: Text('App Store açılıyor...'),
                  backgroundColor: Color(0xFF4CAF50),
                ),
              );
            },
            style: ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
            child: Text('Değerlendir', style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  void _showProDialog() {
    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: Row(
          children: [
            Icon(Icons.workspace_premium, color: Colors.amber, size: 28),
            SizedBox(width: 8),
            Text('Pro Sürüm'),
          ],
        ),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              'Pro özellikler:',
              style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 12),
            _buildProFeature('🚫 Reklamsız deneyim'),
            _buildProFeature('📊 Detaylı deprem analizi'),
            _buildProFeature('🔔 Öncelikli bildirimler'),
            _buildProFeature('📍 Gelişmiş konum takibi'),
            _buildProFeature('📈 Geçmiş veri analizi'),
            _buildProFeature('🎨 Özel temalar'),
            SizedBox(height: 16),
            Center(
              child: Text(
                '₺49,99 / Yıl',
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  color: Color(0xFFFF3333),
                ),
              ),
            ),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx),
            child: Text('İptal', style: TextStyle(color: Colors.grey[600])),
          ),
          ElevatedButton(
            onPressed: () {
              Navigator.pop(ctx);
              ScaffoldMessenger.of(context).showSnackBar(
                SnackBar(
                  content: Text('Satın alma işlemi başlatılıyor...'),
                  backgroundColor: Color(0xFF4CAF50),
                ),
              );
            },
            style: ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
            child: Text('Satın Al', style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  void _showRadiusDialog() {
    double tempRadius = _notificationRadius;
    showDialog(
      context: context,
      builder: (ctx) => StatefulBuilder(
        builder: (context, setDialogState) => AlertDialog(
          title: Text('Bildirim Yarıçapı'),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text('Kaç km içindeki depremlerden bildirim almak istersiniz?'),
              SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text('${tempRadius.toInt()} km',
                      style: TextStyle(
                          fontSize: 24,
                          fontWeight: FontWeight.bold,
                          color: Color(0xFFFFAA00))),
                ],
              ),
              Slider(
                value: tempRadius,
                min: 10.0,
                max: 1000.0,
                divisions: 99,
                activeColor: Color(0xFFFFAA00),
                label: '${tempRadius.toInt()} km',
                onChanged: (value) {
                  setDialogState(() {
                    tempRadius = value;
                  });
                },
              ),
              Text(
                '10 km - 1000 km arası',
                style: TextStyle(fontSize: 12, color: Colors.grey[600]),
              ),
            ],
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(ctx),
              child: Text('İptal', style: TextStyle(color: Colors.grey[600])),
            ),
            ElevatedButton(
              onPressed: () async {
                await _prefsService.setNotificationRadius(tempRadius);
                setState(() {
                  _notificationRadius = tempRadius;
                });
                await _syncSettingsToServer();
                Navigator.pop(ctx);
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    content: Text(
                        'Bildirim yarıçapı ${tempRadius.toInt()} km olarak ayarlandı'),
                    backgroundColor: Color(0xFF4CAF50),
                  ),
                );
              },
              style:
                  ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
              child: Text('Kaydet', style: TextStyle(color: Colors.white)),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildProFeature(String text) {
    return Padding(
      padding: EdgeInsets.symmetric(vertical: 4),
      child: Row(
        children: [
          Text(text, style: TextStyle(fontSize: 14)),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    if (_isLoading) {
      return Center(
        child: CircularProgressIndicator(color: Color(0xFFFF3333)),
      );
    }

    return ListView(
      padding: EdgeInsets.all(0),
      children: [
        // Arka Plan Servisi Kontrolü
        const BackgroundServiceController(),

        // Bildirimler Bölümü
        _buildSectionHeader('Bildirimler'),
        _buildSettingTile(
          icon: Icons.notifications_active,
          title: 'Bildirimlere İzin Ver',
          subtitle: 'Deprem bildirimleri al',
          trailing: CupertinoSwitch(
            value: _notificationsEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: (value) {
              setState(() {
                _notificationsEnabled = value;
              });
            },
          ),
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.speed,
          title: 'Minimum Büyüklük',
          subtitle:
              '${_minimumMagnitude.toStringAsFixed(1)}-${_maximumMagnitude.toStringAsFixed(1)} Mw arası',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: _showMagnitudeDialog,
          enabled: _notificationsEnabled,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.place,
          title: 'Bildirim Yarıçapı',
          subtitle: '${_notificationRadius.toInt()} km içindeki depremler',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: _showRadiusDialog,
          enabled: _notificationsEnabled,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.volume_up,
          title: 'Bildirim Sesi',
          subtitle: 'Sesli uyarı',
          trailing: CupertinoSwitch(
            value: _soundEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: _notificationsEnabled
                ? (value) {
                    setState(() {
                      _soundEnabled = value;
                    });
                  }
                : null,
          ),
          enabled: _notificationsEnabled,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.vibration,
          title: 'Titreşim',
          subtitle: 'Cihazı titret',
          trailing: CupertinoSwitch(
            value: _vibrationEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: _notificationsEnabled
                ? (value) {
                    setState(() {
                      _vibrationEnabled = value;
                    });
                  }
                : null,
          ),
          enabled: _notificationsEnabled,
        ),

        SizedBox(height: 16),

        // Geliştirici Araçları
        _buildSectionHeader('Geliştirici Araçları'),
        _buildSettingTile(
          icon: Icons.science_outlined,
          title: 'P2P Deprem Simülasyonu',
          subtitle: 'Telefonu sallayarak test et',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => P2PTestScreen(),
              ),
            );
          },
        ),

        SizedBox(height: 16),

        // Diğer Bölümü
        _buildSectionHeader('Diğer'),
        _buildSettingTile(
          icon: Icons.share_location,
          title: 'Konumumu Arkadaşlarla Paylaş',
          subtitle: '2 saatte bir konum güncelle',
          trailing: CupertinoSwitch(
            value: _shareLocationWithFriends,
            activeColor: Color(0xFFFF3333),
            onChanged: (value) async {
              setState(() {
                _shareLocationWithFriends = value;
              });
              await _prefsService.setShareLocation(value);

              // Backend'e hemen gönder
              await _locationUpdateService.sendNotificationSettings(
                notificationRadius: _notificationRadius,
                minMagnitude: _minimumMagnitude,
                maxMagnitude: _maximumMagnitude,
                shareLocationWithFriends: value,
              );

              // Konum paylaşımı açıldıysa hemen bir güncelleme yap
              if (value) {
                await _locationUpdateService.sendLocationUpdate();
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                      content: Text('Konumunuz arkadaşlarınızla paylaşılıyor')),
                );
              } else {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('Konum paylaşımı kapatıldı')),
                );
              }
            },
          ),
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.location_on,
          title: 'Konum Servisleri',
          subtitle: 'Konumunuza yakın depremleri göster',
          trailing: CupertinoSwitch(
            value: _locationServicesEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: (value) {
              setState(() {
                _locationServicesEnabled = value;
              });
            },
          ),
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.refresh,
          title: 'Arka Plan Yenileme',
          subtitle: 'Uygulama kapalıyken veri güncelle',
          trailing: CupertinoSwitch(
            value: _backgroundRefreshEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: (value) {
              setState(() {
                _backgroundRefreshEnabled = value;
              });
            },
          ),
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.storage,
          title: 'Önbelleği Temizle',
          subtitle: 'Depolanan verileri sil',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            showDialog(
              context: context,
              builder: (ctx) => AlertDialog(
                title: Text('Önbelleği Temizle'),
                content: Text(
                    'Tüm önbelleğe alınmış veriler silinecek. Devam etmek istiyor musunuz?'),
                actions: [
                  TextButton(
                    onPressed: () => Navigator.pop(ctx),
                    child: Text('İptal',
                        style: TextStyle(color: Colors.grey[600])),
                  ),
                  ElevatedButton(
                    onPressed: () {
                      Navigator.pop(ctx);
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                          content: Text('Önbellek temizlendi'),
                          backgroundColor: Color(0xFF4CAF50),
                        ),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                        backgroundColor: Color(0xFFFF3333)),
                    child:
                        Text('Temizle', style: TextStyle(color: Colors.white)),
                  ),
                ],
              ),
            );
          },
        ),

        SizedBox(height: 16),

        // Hakkında Bölümü
        _buildSectionHeader('Hakkında'),
        _buildSettingTile(
          icon: Icons.star,
          title: 'Bizi Puanla',
          subtitle: 'App Store\'da değerlendir',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: _showRatingDialog,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.workspace_premium,
          title: 'Pro Sürüme Geç',
          subtitle: 'Tüm özelliklerin kilidini aç',
          trailing: Container(
            padding: EdgeInsets.symmetric(horizontal: 8, vertical: 4),
            decoration: BoxDecoration(
              color: Colors.amber,
              borderRadius: BorderRadius.circular(12),
            ),
            child: Text(
              'PRO',
              style: TextStyle(
                color: Colors.white,
                fontSize: 11,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
          onTap: _showProDialog,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.info_outline,
          title: 'Uygulama Hakkında',
          subtitle: 'Kullanım şartları ve gizlilik',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            showDialog(
              context: context,
              builder: (ctx) => AlertDialog(
                title: Text('Deprem Hattı'),
                content: Column(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('Türkiye\'nin en kapsamlı deprem takip uygulaması'),
                    SizedBox(height: 12),
                    Text('© 2025 Deprem Hattı',
                        style:
                            TextStyle(fontSize: 12, color: Colors.grey[600])),
                    SizedBox(height: 8),
                    Text('Tüm hakları saklıdır.',
                        style:
                            TextStyle(fontSize: 12, color: Colors.grey[600])),
                  ],
                ),
                actions: [
                  ElevatedButton(
                    onPressed: () => Navigator.pop(ctx),
                    style: ElevatedButton.styleFrom(
                        backgroundColor: Color(0xFFFF3333)),
                    child: Text('Tamam', style: TextStyle(color: Colors.white)),
                  ),
                ],
              ),
            );
          },
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.bug_report,
          title: 'Hata Bildir',
          subtitle: 'Sorun mu yaşıyorsunuz?',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(
                content: Text('Hata bildirimi formu açılıyor...'),
                backgroundColor: Color(0xFF4CAF50),
              ),
            );
          },
        ),

        SizedBox(height: 16),

        // Hesap Bölümü
        _buildSectionHeader('Hesap'),
        _buildSettingTile(
          icon: Icons.logout,
          title: 'Çıkış Yap',
          subtitle: 'Hesabınızdan çıkış yapın',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            showDialog(
              context: context,
              builder: (ctx) => AlertDialog(
                title: Text('Çıkış Yap'),
                content: Text(
                    'Hesabınızdan çıkış yapmak istediğinize emin misiniz?'),
                actions: [
                  TextButton(
                    onPressed: () => Navigator.pop(ctx),
                    child: Text('İptal',
                        style: TextStyle(color: Colors.grey[600])),
                  ),
                  ElevatedButton(
                    onPressed: () async {
                      // Kullanıcı bilgilerini temizle (use AuthService compatible keys)
                      final prefs = await SharedPreferences.getInstance();
                      await prefs.remove('user_id');
                      await prefs.remove('user_name');
                      await prefs.remove('user_email');
                      await prefs.remove('user_photo_url');

                      if (!mounted) return;
                      Navigator.pop(ctx);

                      // Login ekranına yönlendir
                      Navigator.pushNamedAndRemoveUntil(
                        context,
                        '/login',
                        (route) => false,
                      );

                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                          content: Text('Çıkış yapıldı'),
                          backgroundColor: Color(0xFF4CAF50),
                        ),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                        backgroundColor: Color(0xFFFF3333)),
                    child: Text('Çıkış Yap',
                        style: TextStyle(color: Colors.white)),
                  ),
                ],
              ),
            );
          },
        ),

        SizedBox(height: 32),

        // Versiyon Numarası
        Center(
          child: Text(
            'Versiyon 1.0.0',
            style: TextStyle(
              fontSize: 12,
              color: Colors.grey[500],
            ),
          ),
        ),
        SizedBox(height: 8),
        Center(
          child: Text(
            'Build 2024110601',
            style: TextStyle(
              fontSize: 10,
              color: Colors.grey[400],
            ),
          ),
        ),
        SizedBox(height: 32),
      ],
    );
  }

  Widget _buildSectionHeader(String title) {
    return Container(
      padding: EdgeInsets.fromLTRB(16, 16, 16, 8),
      child: Text(
        title.toUpperCase(),
        style: TextStyle(
          fontSize: 13,
          fontWeight: FontWeight.w600,
          color: Colors.grey[600],
          letterSpacing: 0.5,
        ),
      ),
    );
  }

  Widget _buildSettingTile({
    required IconData icon,
    required String title,
    required String subtitle,
    required Widget trailing,
    VoidCallback? onTap,
    bool enabled = true,
  }) {
    return Container(
      color: Colors.white,
      child: ListTile(
        leading: Container(
          width: 40,
          height: 40,
          decoration: BoxDecoration(
            color: enabled
                ? Color(0xFFFF3333).withOpacity(0.1)
                : Colors.grey.withOpacity(0.1),
            borderRadius: BorderRadius.circular(10),
          ),
          child: Icon(
            icon,
            color: enabled ? Color(0xFFFF3333) : Colors.grey,
            size: 22,
          ),
        ),
        title: Text(
          title,
          style: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.w500,
            color: enabled ? Colors.black87 : Colors.grey,
          ),
        ),
        subtitle: Text(
          subtitle,
          style: TextStyle(
            fontSize: 13,
            color: enabled ? Colors.grey[600] : Colors.grey[400],
          ),
        ),
        trailing: trailing,
        onTap: enabled ? onTap : null,
      ),
    );
  }

  Widget _buildDivider() {
    return Divider(height: 1, indent: 72, color: Colors.grey[200]);
  }
}
