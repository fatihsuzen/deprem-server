import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:url_launcher/url_launcher.dart';
import '../services/user_preferences_service.dart';
import '../services/location_update_service.dart';
import '../widgets/background_service_controller.dart';
import '../services/whistle_service.dart';
import '../l10n/app_localizations.dart';
import 'debug_screen.dart';

class SettingsPage extends StatefulWidget {
  @override
  _SettingsPageState createState() => _SettingsPageState();
}

class _SettingsPageState extends State<SettingsPage> {
  void _enforceLocationDependencies() async {
    if (!_locationServicesEnabled || !_backgroundRefreshEnabled) {
      if (_shareLocationWithFriends) {
        setState(() {
          _shareLocationWithFriends = false;
        });
        await _prefsService.setShareLocation(false);
      }
    }
  }

  final UserPreferencesService _prefsService = UserPreferencesService();
  final LocationUpdateService _locationUpdateService = LocationUpdateService();
  final WhistleService _whistleService = WhistleService();

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
  bool _isWhistlePlaying = false;
  String _currentLocale = 'tr';

  @override
  void initState() {
    super.initState();
    _loadSettings();
  }

  @override
  void dispose() {
    // Düdük çalıyorsa durdur
    if (_isWhistlePlaying) {
      _whistleService.stopWhistle();
    }
    super.dispose();
  }

  Future<void> _loadSettings() async {
    // Load locale and custom settings from SharedPreferences
    final prefs = await SharedPreferences.getInstance();
    final savedLocale = prefs.getString('app_locale') ?? 'tr';
    final locationServicesEnabled =
        prefs.getBool('location_services_enabled') ?? true;
    final backgroundRefreshEnabled =
        prefs.getBool('background_refresh_enabled') ?? true;

    // Ayarları UserPreferencesService üzerinden yükle
    final allSettings = await _prefsService.getAllSettings();
    final notificationsEnabled = await _prefsService.getNotificationsEnabled();
    final notificationSound = await _prefsService.getNotificationSound();
    final vibration = await _prefsService.getVibration();

    if (!mounted) return;
    setState(() {
      _minimumMagnitude = allSettings['minMagnitude'];
      _maximumMagnitude = allSettings['maxMagnitude'];
      _notificationRadius = allSettings['notificationRadius'];
      _shareLocationWithFriends = allSettings['shareLocation'];

      _notificationsEnabled = notificationsEnabled; // Ana bildirim ayarı
      _soundEnabled = notificationSound;
      _vibrationEnabled = vibration;

      _currentLocale = savedLocale;
      _locationServicesEnabled = locationServicesEnabled;
      _backgroundRefreshEnabled = backgroundRefreshEnabled;
      _isLoading = false;
    });

    _enforceLocationDependencies();

    print('📱 Local ayarlar yüklendi:');
    print('   Ana Bildirimler: $_notificationsEnabled');
    print('   Yarıçap: $_notificationRadius km');
    print('   Büyüklük: $_minimumMagnitude - $_maximumMagnitude');
    print('   Bildirim Sesi: $_soundEnabled');
    print('   Titreşim: $_vibrationEnabled');
    print('   Dil: $_currentLocale');
    print('   Konum Servisleri: $_locationServicesEnabled');
    print('   Arkaplan Yenileme: $_backgroundRefreshEnabled');

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
      print('✅ Ayarlar sunucuya senkronize edildi sa');
    } catch (e) {
      print('⚠️  Ayar senkronizasyonu hatası: $e');
    }
  }

  void _showMagnitudeDialog() {
    final l10n = AppLocalizations(Locale(_currentLocale));
    double tempMinMagnitude = _minimumMagnitude;
    double tempMaxMagnitude = _maximumMagnitude;
    showDialog(
      context: context,
      builder: (ctx) => StatefulBuilder(
        builder: (context, setDialogState) => AlertDialog(
          title: Text(l10n.get('earthquake_magnitude_range')),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(l10n
                      .get('earthquakes_between_shown')
                      .replaceAll('{min}', '')
                      .replaceAll('{max}', '')
                      .replaceAll('-', '')
                      .trim()
                      .isEmpty
                  ? 'Select the magnitude range for earthquakes'
                  : l10n
                      .get('earthquakes_between_shown')
                      .replaceAll('{min}', tempMinMagnitude.toStringAsFixed(1))
                      .replaceAll(
                          '{max}', tempMaxMagnitude.toStringAsFixed(1))),
              SizedBox(height: 20),
              // Minimum Büyüklük
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text('${l10n.get('minimum')}:',
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
                  Text('${l10n.get('maximum')}:',
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
                l10n
                    .get('earthquakes_between_shown')
                    .replaceAll('{min}', tempMinMagnitude.toStringAsFixed(1))
                    .replaceAll('{max}', tempMaxMagnitude.toStringAsFixed(1)),
                style: TextStyle(fontSize: 12, color: Colors.grey[600]),
              ),
            ],
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(ctx),
              child: Text(l10n.get('cancel'),
                  style: TextStyle(color: Colors.grey[600])),
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
                    content: Text(l10n
                        .get('magnitude_range_set')
                        .replaceAll(
                            '{min}', tempMinMagnitude.toStringAsFixed(1))
                        .replaceAll(
                            '{max}', tempMaxMagnitude.toStringAsFixed(1))),
                    backgroundColor: Color(0xFF4CAF50),
                  ),
                );
              },
              style:
                  ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
              child:
                  Text(l10n.get('save'), style: TextStyle(color: Colors.white)),
            ),
          ],
        ),
      ),
    );
  }

  void _showRatingDialog() {
    final l10n = AppLocalizations(Locale(_currentLocale));
    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: Row(
          children: [
            Icon(Icons.star, color: Colors.amber, size: 28),
            SizedBox(width: 8),
            Text(l10n.get('rate_us_title')),
          ],
        ),
        content: Text(
          l10n.get('do_you_like_app'),
          style: TextStyle(fontSize: 15),
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx),
            child: Text(l10n.get('later'),
                style: TextStyle(color: Colors.grey[600])),
          ),
          ElevatedButton(
            onPressed: () async {
              Navigator.pop(ctx);
              final url = Uri.parse(
                  'https://play.google.com/store/apps/details?id=com.fsapps.earthquake_line');
              try {
                if (await canLaunchUrl(url)) {
                  await launchUrl(url, mode: LaunchMode.externalApplication);
                } else {
                  if (context.mounted) {
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(
                        content: Text(_currentLocale == 'tr'
                            ? 'Play Store açılamadı'
                            : 'Could not open Play Store'),
                        backgroundColor: Colors.red,
                      ),
                    );
                  }
                }
              } catch (e) {
                if (context.mounted) {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                      content: Text(
                          _currentLocale == 'tr' ? 'Hata: $e' : 'Error: $e'),
                      backgroundColor: Colors.red,
                    ),
                  );
                }
              }
            },
            style: ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
            child:
                Text(l10n.get('rate'), style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  void _showProDialog() {
    final l10n = AppLocalizations(Locale(_currentLocale));
    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: Row(
          children: [
            Icon(Icons.workspace_premium, color: Colors.amber, size: 28),
            SizedBox(width: 8),
            Text(l10n.get('pro_version')),
          ],
        ),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(
              padding: EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Colors.amber.withOpacity(0.1),
                borderRadius: BorderRadius.circular(8),
                border: Border.all(color: Colors.amber.withOpacity(0.3)),
              ),
              child: Row(
                children: [
                  Icon(Icons.info_outline, color: Colors.amber, size: 20),
                  SizedBox(width: 8),
                  Expanded(
                    child: Text(
                      _currentLocale == 'tr'
                          ? 'Pro sürüm yakında kullanıma sunulacak!'
                          : 'Pro version coming soon!',
                      style: TextStyle(
                        fontSize: 13,
                        color: Colors.amber[900],
                        fontWeight: FontWeight.w500,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: 16),
            Text(
              _currentLocale == 'tr'
                  ? 'Planlanmış Özellikler'
                  : 'Planned Features',
              style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 12),
            _buildProFeature(l10n.get('ad_free')),
            _buildProFeature(l10n.get('detailed_analysis')),
            _buildProFeature(l10n.get('priority_notifications')),
            _buildProFeature(l10n.get('advanced_location')),
            _buildProFeature(l10n.get('historical_analysis')),
            _buildProFeature(l10n.get('custom_themes')),
          ],
        ),
        actions: [
          ElevatedButton(
            onPressed: () => Navigator.pop(ctx),
            style: ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
            child: Text(_currentLocale == 'tr' ? 'Anladım' : 'OK',
                style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  void _showRadiusDialog() {
    final l10n = AppLocalizations(Locale(_currentLocale));
    double tempRadius = _notificationRadius;
    showDialog(
      context: context,
      builder: (ctx) => StatefulBuilder(
        builder: (context, setDialogState) => AlertDialog(
          title: Text(l10n.get('notification_radius')),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(l10n.get('how_far_notifications')),
              SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text('${tempRadius.toInt()} km',
                      style: TextStyle(
                          fontSize: 24,
                          fontWeight: FontWeight.bold,
                          color: Color(0xFFFFAA00))),
                  IconButton(
                    icon: Icon(Icons.gps_fixed, color: Color(0xFFFF3333)),
                    tooltip: 'Konumdan al',
                    onPressed: () async {
                      // GPS ile konumdan radius hesapla (örnek: 100km)
                      // Burada gerçek bir hesaplama yapılabilir, örnek olarak 100km atanıyor
                      double gpsRadius = 100.0;
                      setDialogState(() {
                        tempRadius = gpsRadius;
                      });
                      await _prefsService.setNotificationRadius(gpsRadius);
                      setState(() {
                        _notificationRadius = gpsRadius;
                      });
                      print(
                          '📍 GPS tuşu ile yarıçap güncellendi ve kaydedildi: $gpsRadius');
                    },
                  ),
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
                l10n.get('between_km'),
                style: TextStyle(fontSize: 12, color: Colors.grey[600]),
              ),
            ],
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(ctx),
              child: Text(l10n.get('cancel'),
                  style: TextStyle(color: Colors.grey[600])),
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
                    content: Text(l10n
                        .get('radius_set')
                        .replaceAll('{radius}', tempRadius.toInt().toString())),
                    backgroundColor: Color(0xFF4CAF50),
                  ),
                );
                print('✅ Yarıçap kaydedildi ve uygulandı: $tempRadius');
              },
              style:
                  ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
              child:
                  Text(l10n.get('save'), style: TextStyle(color: Colors.white)),
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
    final l10n = AppLocalizations(Locale(_currentLocale));

    // Debug: Check locale and translation
    print('🔍 DEBUG: _currentLocale = $_currentLocale');
    print(
        '🔍 DEBUG: locale.languageCode = ${Locale(_currentLocale).languageCode}');
    print(
        '🔍 DEBUG: share_location_with_friends = ${l10n.get('share_location_with_friends')}');

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
        _buildSectionHeader(l10n.get('notifications')),
        _buildSettingTile(
          icon: Icons.notifications_active,
          title: l10n.get('allow_notifications'),
          subtitle: l10n.get('receive_earthquake_notifications'),
          trailing: CupertinoSwitch(
            value: _notificationsEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: (value) async {
              await _prefsService.setNotificationsEnabled(value);
              setState(() {
                _notificationsEnabled = value;
              });
              print('🔔 Ana bildirim ayarı kaydedildi: $value');
            },
          ),
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.speed,
          title: l10n.get('minimum_magnitude'),
          subtitle: l10n
              .get('between_mw')
              .replaceAll('{min}', _minimumMagnitude.toStringAsFixed(1))
              .replaceAll('{max}', _maximumMagnitude.toStringAsFixed(1)),
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: _showMagnitudeDialog,
          enabled: _notificationsEnabled,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.place,
          title: l10n.get('notification_radius'),
          subtitle: l10n
              .get('earthquakes_within_km')
              .replaceAll('{radius}', _notificationRadius.toInt().toString()),
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: _showRadiusDialog,
          enabled: _notificationsEnabled,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.volume_up,
          title: l10n.get('notification_sound'),
          subtitle: l10n.get('sound_alert'),
          trailing: CupertinoSwitch(
            value: _soundEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: _notificationsEnabled
                ? (value) async {
                    setState(() {
                      _soundEnabled = value;
                    });
                    await _prefsService.setNotificationSound(value);
                  }
                : null,
          ),
          enabled: _notificationsEnabled,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.vibration,
          title: l10n.get('vibration'),
          subtitle: l10n.get('device_vibrate'),
          trailing: CupertinoSwitch(
            value: _vibrationEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: _notificationsEnabled
                ? (value) async {
                    setState(() {
                      _vibrationEnabled = value;
                    });
                    await _prefsService.setVibration(value);
                  }
                : null,
          ),
          enabled: _notificationsEnabled,
        ),

        SizedBox(height: 16),

        // Araçlar Bölümü
        _buildSectionHeader(l10n.get('tools')),
        _buildWhistleTile(l10n),

        SizedBox(height: 16),

        // Diğer Bölümü
        _buildSectionHeader(l10n.get('other')),
        _buildSettingTile(
          icon: Icons.share_location,
          title: l10n.get('share_location_with_friends'),
          subtitle: l10n.get('update_location_every_2_hours'),
          trailing: CupertinoSwitch(
            value: _shareLocationWithFriends,
            activeColor: Color(0xFFFF3333),
            onChanged: (!_locationServicesEnabled || !_backgroundRefreshEnabled)
                ? null
                : (value) async {
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
                            content: Text(l10n.get('your_location_shared'))),
                      );
                    } else {
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                            content: Text(l10n.get('location_sharing_off'))),
                      );
                    }
                  },
          ),
          enabled: _locationServicesEnabled && _backgroundRefreshEnabled,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.location_on,
          title: l10n.get('location_services'),
          subtitle: l10n.get('show_nearby_earthquakes'),
          trailing: CupertinoSwitch(
            value: _locationServicesEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: (value) async {
              setState(() {
                _locationServicesEnabled = value;
              });
              final prefs = await SharedPreferences.getInstance();
              await prefs.setBool('location_services_enabled', value);
              _enforceLocationDependencies();
            },
          ),
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.refresh,
          title: l10n.get('background_refresh'),
          subtitle: l10n.get('update_data_when_closed'),
          trailing: CupertinoSwitch(
            value: _backgroundRefreshEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: (value) async {
              setState(() {
                _backgroundRefreshEnabled = value;
              });
              final prefs = await SharedPreferences.getInstance();
              await prefs.setBool('background_refresh_enabled', value);
              _enforceLocationDependencies();
            },
          ),
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.storage,
          title: l10n.get('clear_cache'),
          subtitle: l10n.get('delete_stored_data'),
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            showDialog(
              context: context,
              builder: (ctx) => AlertDialog(
                title: Text(l10n.get('clear_cache_title')),
                content: Text(l10n.get('clear_cache_confirm')),
                actions: [
                  TextButton(
                    onPressed: () => Navigator.pop(ctx),
                    child: Text(l10n.get('cancel'),
                        style: TextStyle(color: Colors.grey[600])),
                  ),
                  ElevatedButton(
                    onPressed: () {
                      Navigator.pop(ctx);
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                          content: Text(l10n.get('cache_cleared')),
                          backgroundColor: Color(0xFF4CAF50),
                        ),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                        backgroundColor: Color(0xFFFF3333)),
                    child: Text(l10n.get('clear'),
                        style: TextStyle(color: Colors.white)),
                  ),
                ],
              ),
            );
          },
        ),

        SizedBox(height: 16),

        // Debug Bölümü
        _buildSectionHeader('Geliştirici'),
        _buildSettingTile(
          icon: Icons.bug_report,
          title: 'Debug & Test Modu',
          subtitle: 'Sensör ve servis durumunu görüntüle',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => DebugScreen()),
            );
          },
        ),

        SizedBox(height: 16),

        // Hakkında Bölümü
        _buildSectionHeader(l10n.get('about')),
        _buildSettingTile(
          icon: Icons.star,
          title: l10n.get('rate_us'),
          subtitle: l10n.get('rate_on_app_store'),
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: _showRatingDialog,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.workspace_premium,
          title: l10n.get('go_pro'),
          subtitle: l10n.get('unlock_all_features'),
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
          title: l10n.get('about_app'),
          subtitle: l10n.get('terms_and_privacy'),
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            showDialog(
              context: context,
              builder: (ctx) => AlertDialog(
                title: Row(
                  children: [
                    Icon(Icons.info_outline,
                        color: Color(0xFFFF3333), size: 28),
                    SizedBox(width: 8),
                    Expanded(child: Text(l10n.get('earthquake_line'))),
                  ],
                ),
                content: SingleChildScrollView(
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        _currentLocale == 'tr'
                            ? 'Dünyanın En Gelişmiş Deprem Takip ve Erken Uyarı Platformu'
                            : 'World\'s Most Advanced Earthquake Tracking and Early Warning Platform',
                        style: TextStyle(
                          fontSize: 14,
                          fontWeight: FontWeight.bold,
                          color: Color(0xFFFF3333),
                        ),
                      ),
                      SizedBox(height: 16),

                      // P2P Network Açıklaması
                      _buildAboutSection(
                        icon: Icons.network_check,
                        title: _currentLocale == 'tr'
                            ? 'P2P Deprem Ağı'
                            : 'P2P Earthquake Network',
                        description: _currentLocale == 'tr'
                            ? 'Kullanıcıların cihaz sensörlerini kullanarak gerçek zamanlı deprem algılama yapan yenilikçi bir peer-to-peer ağı. Binlerce cihazdan gelen veriler analiz edilerek erken uyarı sistemi oluşturulur.'
                            : 'An innovative peer-to-peer network that detects earthquakes in real-time using device sensors. Data from thousands of devices is analyzed to create an early warning system.',
                      ),

                      SizedBox(height: 12),

                      // Özellikler
                      _buildAboutSection(
                        icon: Icons.featured_play_list,
                        title: _currentLocale == 'tr'
                            ? 'Temel Özellikler'
                            : 'Key Features',
                        description: _currentLocale == 'tr'
                            ? '• Gerçek zamanlı deprem bildirimleri\n• USGS, EMSC, AFAD ve Kandilli verilerini anlık takip\n• İnteraktif deprem haritası\n• Arkadaşlarınızla konum paylaşımı\n• Geçmiş deprem kayıtları ve analizler\n• Çoklu dil desteği (TR/EN)'
                            : '• Real-time earthquake notifications\n• Live tracking of USGS, EMSC, AFAD and Kandilli data\n• Interactive earthquake map\n• Location sharing with friends\n• Historical earthquake records and analysis\n• Multi-language support (TR/EN)',
                      ),

                      SizedBox(height: 12),

                      // Veri Kaynakları
                      _buildAboutSection(
                        icon: Icons.source,
                        title: _currentLocale == 'tr'
                            ? 'Veri Kaynakları'
                            : 'Data Sources',
                        description: _currentLocale == 'tr'
                            ? '• USGS (Amerika Birleşik Devletleri Jeoloji Araştırmaları)\n• EMSC (Avrupa-Akdeniz Sismolojik Merkezi)\n• T.C. AFAD (Afet ve Acil Durum Yönetimi)\n• Kandilli Rasathanesi\n• Kullanıcı sensör verileri (P2P)'
                            : '• USGS (United States Geological Survey)\n• EMSC (European-Mediterranean Seismological Centre)\n• T.R. AFAD (Disaster and Emergency Management)\n• Kandilli Observatory\n• User sensor data (P2P)',
                      ),

                      SizedBox(height: 16),
                      Divider(),
                      SizedBox(height: 8),

                      Text('© 2025 ${l10n.get('earthquake_line')}',
                          style:
                              TextStyle(fontSize: 12, color: Colors.grey[600])),
                      SizedBox(height: 4),
                      Text(l10n.get('all_rights_reserved'),
                          style:
                              TextStyle(fontSize: 12, color: Colors.grey[600])),
                      SizedBox(height: 4),
                      Text('v1.0.0',
                          style:
                              TextStyle(fontSize: 12, color: Colors.grey[600])),
                    ],
                  ),
                ),
                actions: [
                  ElevatedButton(
                    onPressed: () => Navigator.pop(ctx),
                    style: ElevatedButton.styleFrom(
                        backgroundColor: Color(0xFFFF3333)),
                    child: Text(l10n.get('ok'),
                        style: TextStyle(color: Colors.white)),
                  ),
                ],
              ),
            );
          },
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.bug_report,
          title: l10n.get('report_bug'),
          subtitle: l10n.get('having_issues'),
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(
                content: Text(l10n.get('bug_report_opening')),
                backgroundColor: Color(0xFF4CAF50),
              ),
            );
          },
        ),

        SizedBox(height: 16),

        // Hesap Bölümü
        _buildSectionHeader(l10n.get('account')),
        _buildSettingTile(
          icon: Icons.logout,
          title: l10n.get('logout'),
          subtitle: l10n.get('logout_from_account'),
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            showDialog(
              context: context,
              builder: (ctx) => AlertDialog(
                title: Text(l10n.get('logout_title')),
                content: Text(l10n.get('logout_confirm')),
                actions: [
                  TextButton(
                    onPressed: () => Navigator.pop(ctx),
                    child: Text(l10n.get('cancel'),
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
                          content: Text(l10n.get('logged_out')),
                          backgroundColor: Color(0xFF4CAF50),
                        ),
                      );
                    },
                    style: ElevatedButton.styleFrom(
                        backgroundColor: Color(0xFFFF3333)),
                    child: Text(l10n.get('logout'),
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
            '${l10n.get('version_text')} 1.0.0',
            style: TextStyle(
              fontSize: 12,
              color: Colors.grey[500],
            ),
          ),
        ),
        SizedBox(height: 8),
        Center(
          child: Text(
            '${l10n.get('build_text')} 2024110601',
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

  Widget _buildWhistleTile(AppLocalizations l10n) {
    return Container(
      margin: EdgeInsets.symmetric(horizontal: 0),
      decoration: BoxDecoration(
        color: Colors.white,
        border:
            _isWhistlePlaying ? Border.all(color: Colors.red, width: 2) : null,
      ),
      child: Padding(
        padding: EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              children: [
                Container(
                  width: 40,
                  height: 40,
                  decoration: BoxDecoration(
                    color: _isWhistlePlaying
                        ? Colors.red.withOpacity(0.1)
                        : Color(0xFFFF3333).withOpacity(0.1),
                    borderRadius: BorderRadius.circular(10),
                  ),
                  child: Icon(
                    _isWhistlePlaying ? Icons.volume_up : Icons.campaign,
                    color: _isWhistlePlaying ? Colors.red : Color(0xFFFF3333),
                    size: 22,
                  ),
                ),
                SizedBox(width: 16),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        l10n.get('whistle_play'),
                        style: TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.w500,
                          color: Colors.black87,
                        ),
                      ),
                      Text(
                        _isWhistlePlaying
                            ? l10n.get('whistle_playing_signal')
                            : l10n.get('whistle_use_debris'),
                        style: TextStyle(
                          fontSize: 13,
                          color:
                              _isWhistlePlaying ? Colors.red : Colors.grey[600],
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
            SizedBox(height: 16),
            Row(
              children: [
                Expanded(
                  child: ElevatedButton.icon(
                    onPressed: _isWhistlePlaying
                        ? null
                        : () async {
                            await _whistleService.startWhistle();
                            setState(() => _isWhistlePlaying = true);
                            ScaffoldMessenger.of(context).showSnackBar(
                              SnackBar(
                                content: Text(l10n.get('whistle_started')),
                                backgroundColor: Colors.green,
                              ),
                            );
                          },
                    icon: Icon(Icons.play_arrow),
                    label: Text(l10n.get('start')),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.green,
                      foregroundColor: Colors.white,
                      disabledBackgroundColor: Colors.grey,
                      padding: EdgeInsets.symmetric(vertical: 12),
                    ),
                  ),
                ),
                SizedBox(width: 12),
                Expanded(
                  child: ElevatedButton.icon(
                    onPressed: !_isWhistlePlaying
                        ? null
                        : () async {
                            await _whistleService.stopWhistle();
                            setState(() => _isWhistlePlaying = false);
                            ScaffoldMessenger.of(context).showSnackBar(
                              SnackBar(
                                content: Text(l10n.get('whistle_stopped')),
                                backgroundColor: Colors.orange,
                              ),
                            );
                          },
                    icon: Icon(Icons.stop),
                    label: Text(l10n.get('stop')),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.red,
                      foregroundColor: Colors.white,
                      disabledBackgroundColor: Colors.grey,
                      padding: EdgeInsets.symmetric(vertical: 12),
                    ),
                  ),
                ),
              ],
            ),
            if (_isWhistlePlaying) ...[
              SizedBox(height: 12),
              Container(
                padding: EdgeInsets.all(12),
                decoration: BoxDecoration(
                  color: Colors.red.withOpacity(0.1),
                  borderRadius: BorderRadius.circular(8),
                  border: Border.all(color: Colors.red.withOpacity(0.3)),
                ),
                child: Row(
                  children: [
                    Icon(Icons.warning_amber, color: Colors.red, size: 20),
                    SizedBox(width: 8),
                    Expanded(
                      child: Text(
                        l10n.get('whistle_help_rescue'),
                        style: TextStyle(
                          fontSize: 12,
                          color: Colors.red[700],
                          fontWeight: FontWeight.w500,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ],
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

  Widget _buildAboutSection({
    required IconData icon,
    required String title,
    required String description,
  }) {
    return Container(
      padding: EdgeInsets.all(12),
      decoration: BoxDecoration(
        color: Colors.grey[50],
        borderRadius: BorderRadius.circular(8),
        border: Border.all(color: Colors.grey[200]!),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            children: [
              Icon(icon, color: Color(0xFFFF3333), size: 20),
              SizedBox(width: 8),
              Text(
                title,
                style: TextStyle(
                  fontSize: 14,
                  fontWeight: FontWeight.bold,
                  color: Colors.black87,
                ),
              ),
            ],
          ),
          SizedBox(height: 8),
          Text(
            description,
            style: TextStyle(
              fontSize: 13,
              color: Colors.grey[700],
              height: 1.4,
            ),
          ),
        ],
      ),
    );
  }
}
