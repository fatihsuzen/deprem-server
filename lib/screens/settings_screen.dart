import 'package:flutter/material.dart';
import 'package:battery_plus/battery_plus.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../services/mqtt_service.dart';
import '../services/user_preferences_service.dart';
import '../services/location_update_service.dart';
import '../services/whistle_service.dart';
import 'p2p_test_screen.dart';

class SettingsScreen extends StatefulWidget {
  const SettingsScreen({super.key});

  @override
  State<SettingsScreen> createState() => _SettingsScreenState();
}

class _SettingsScreenState extends State<SettingsScreen> {
  bool isDarkTheme = false;
  bool isDarkMapTheme = false;
  bool autoStartMqtt = true;
  bool isLoading = true;
  bool _earthquakeDetectionEnabled = false;
  EarthquakeDetector? _earthquakeDetector;
  EarthquakeReportService? _reportService;
  String _deviceId = "";

  // Deprem filtreleme ayarları
  final UserPreferencesService _prefsService = UserPreferencesService();
  final LocationUpdateService _locationUpdateService = LocationUpdateService();
  double _minMagnitude = UserPreferencesService.defaultMinMagnitude;
  double _maxMagnitude = UserPreferencesService.defaultMaxMagnitude;
  double _notificationRadius = UserPreferencesService.defaultNotificationRadius;
  
  // Bildirim ayarları
  bool _notificationSoundEnabled = true;
  bool _vibrationEnabled = true;
  bool _backgroundNotificationsEnabled = true;
  bool _shareLocationEnabled = true;
  
  // Düdük servisi
  final WhistleService _whistleService = WhistleService();
  bool _isWhistlePlaying = false;

  Stream<BatteryState>? _batteryStream;
  @override
  void initState() {
    super.initState();
    _loadSettings();
    // Şarj durumu değişimini dinle
    final battery = Battery();
    _batteryStream = battery.onBatteryStateChanged;
    _batteryStream?.listen((BatteryState state) {
      // Sadece kullanıcı servisi aktif ettiyse kontrol et
      if (_earthquakeDetectionEnabled) {
        _checkAndStartDetection();
      }
    });
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
    final prefs = await SharedPreferences.getInstance();
    final earthquakeSettings = await _prefsService.getAllSettings();

    setState(() {
      isDarkTheme = prefs.getBool('isDarkTheme') ?? false;
      isDarkMapTheme = prefs.getBool('isDarkMapTheme') ?? false;
      autoStartMqtt = prefs.getBool('auto_start_mqtt_service') ?? true;
      _earthquakeDetectionEnabled = prefs.getBool('earthquake_detection_enabled') ?? false;

      // Deprem ayarları
      _minMagnitude = earthquakeSettings['minMagnitude'];
      _maxMagnitude = earthquakeSettings['maxMagnitude'];
      _notificationRadius = earthquakeSettings['notificationRadius'];
      
      // Bildirim ayarları
      _notificationSoundEnabled = earthquakeSettings['notificationSound'] ?? true;
      _vibrationEnabled = earthquakeSettings['vibration'] ?? true;
      _backgroundNotificationsEnabled = earthquakeSettings['backgroundNotifications'] ?? true;
      _shareLocationEnabled = earthquakeSettings['shareLocation'] ?? true;

      isLoading = false;
    });
    // Cihaz ID'si ve servisleri başlat
    _deviceId = prefs.getString('device_id') ?? "test-device";
    _reportService = EarthquakeReportService('http://188.132.202.24:3000/api/p2p-earthquake');
    _earthquakeDetector = EarthquakeDetector();
    _checkAndStartDetection();
  }

  Future<void> _saveAppTheme(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool('isDarkTheme', value);
    setState(() {
      isDarkTheme = value;
    });

    // Ana uygulama temasını güncelle
    if (mounted) {
      // Ana widget'a tema değişikliğini bildir
      Navigator.of(context).pop({'themeChanged': true, 'isDarkTheme': value});
    }
  }

  Future<void> _saveMapTheme(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool('isDarkMapTheme', value);
    setState(() {
      isDarkMapTheme = value;
    });
  }

  @override
  Widget build(BuildContext context) {
    if (isLoading) {
      return Scaffold(
        appBar: AppBar(
          title: const Text('Ayarlar'),
        ),
        body: const Center(
          child: CircularProgressIndicator(),
        ),
      );
    }
    return Scaffold(
      appBar: AppBar(
        title: const Text('Ayarlar'),
        backgroundColor: isDarkTheme ? Colors.grey[900] : Colors.blue,
        foregroundColor: isDarkTheme ? Colors.white : Colors.white,
      ),
      backgroundColor: isDarkTheme ? Colors.grey[850] : Colors.white,
      body: SingleChildScrollView(

              const SizedBox(height: 32),

              // Earthquake Detection Service Toggle
              Text(
                'Deprem Algılama Servisi',
                style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                      color: isDarkTheme ? Colors.white : Colors.black87,
                      fontWeight: FontWeight.bold,
                    ),
              ),
              const SizedBox(height: 16),
              Container(
                padding: const EdgeInsets.all(16),
                decoration: BoxDecoration(
                  color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
                  borderRadius: BorderRadius.circular(12),
                  border: Border.all(
                    color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
                  ),
                ),
                child: Row(
                  children: [
                    Icon(
                      Icons.sensors,
                      color: isDarkTheme ? Colors.orange : Colors.blue,
                      size: 28,
                    ),
                    const SizedBox(width: 16),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            'Deprem Algılama Servisi',
                            style: TextStyle(
                              fontSize: 16,
                              fontWeight: FontWeight.w600,
                              color: isDarkTheme ? Colors.white : Colors.black87,
                            ),
                          ),
                          Text(
                            _earthquakeDetectionEnabled
                                ? 'Cihaz şarjda olduğunda deprem algılama servisi çalışır.'
                                : 'Deprem algılama servisi devre dışı.',
                            style: TextStyle(
                              fontSize: 14,
                              color: isDarkTheme
                                  ? Colors.grey[300]
                                  : Colors.grey[600],
                            ),
                          ),
                        ],
                      ),
                    ),
                    Switch.adaptive(
                      value: _earthquakeDetectionEnabled,
                      onChanged: (v) async {
                        final prefs = await SharedPreferences.getInstance();
                        await prefs.setBool('earthquake_detection_enabled', v);
                        setState(() {
                          _earthquakeDetectionEnabled = v;
                        });
                        if (mounted) {
                          ScaffoldMessenger.of(context).showSnackBar(
                            SnackBar(
                              content: Text(v
                                  ? 'Deprem algılama servisi etkinleştirildi.'
                                  : 'Deprem algılama servisi devre dışı bırakıldı.'),
                              duration: const Duration(seconds: 2),
                            ),
                          );
                        }
                        _checkAndStartDetection();
                      },
                        // Şarjda olup olmadığını kontrol et
                        Future<bool> _isDeviceCharging() async {
                          final battery = Battery();
                          final status = await battery.batteryState;
                          // BatteryState.charging veya BatteryState.full ise şarja takılı
                          return status == BatteryState.charging || status == BatteryState.full;
                        }

                        // Servisi başlat/durdur
                        Future<void> _checkAndStartDetection() async {
                          if (_earthquakeDetectionEnabled && await _isDeviceCharging()) {
                            // Servisi başlat
                            if (_earthquakeDetector != null && _reportService != null) {
                              _earthquakeDetector!.startListening(
                                deviceId: _deviceId,
                                reportService: _reportService!,
                              );
                            }
                          } else {
                            // Servisi durdur (geliştirilebilir)
                            // Şu an için dinlemeyi durdurma fonksiyonu yok, eklenebilir
                          }
                        }
                      activeColor: Colors.orange,
                      activeTrackColor: Colors.orange.withOpacity(0.3),
                    ),
                  ],
                ),
              ),
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Deprem Filtreleme Bölümü (YENİ)
            Text(
              'Deprem Filtreleme',
              style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.bold,
                  ),
            ),
            const SizedBox(height: 16),

            // Minimum Büyüklük
            _buildMagnitudeSlider(
              title: 'Minimum Büyüklük',
              value: _minMagnitude,
              min: 0.0,
              max: 9.0,
              onChanged: (value) {
                if (value < _maxMagnitude) {
                  setState(() => _minMagnitude = value);
                }
              },
              onChangeEnd: (value) async {
                if (value < _maxMagnitude) {
                  await _prefsService.setMinMagnitude(value);
                  _showSnackBar(
                      'Minimum büyüklük: ${value.toStringAsFixed(1)}');
                  await _syncSettingsToServer();
                  // Harita verilerini yenile
                  if (mounted) {
                    Navigator.of(context).pop({'reloadEarthquakes': true});
                  }
                }
              },
              color: Colors.orange,
            ),

            const SizedBox(height: 16),

            // Maximum Büyüklük
            _buildMagnitudeSlider(
              title: 'Maksimum Büyüklük',
              value: _maxMagnitude,
              min: 1.0,
              max: 10.0,
              onChanged: (value) {
                if (value > _minMagnitude) {
                  setState(() => _maxMagnitude = value);
                }
              },
              onChangeEnd: (value) async {
                if (value > _minMagnitude) {
                  await _prefsService.setMaxMagnitude(value);
                  _showSnackBar(
                      'Maksimum büyüklük: ${value.toStringAsFixed(1)}');
                  await _syncSettingsToServer();
                  // Harita verilerini yenile
                  if (mounted) {
                    Navigator.of(context).pop({'reloadEarthquakes': true});
                  }
                }
              },
              color: Colors.red,
            ),

            const SizedBox(height: 16),

            // Bildirim Yarıçapı
            _buildRadiusSlider(
              title: 'Bildirim Yarıçapı',
              value: _notificationRadius,
              min: 10.0,
              max: 1000.0,
              onChanged: (value) {
                setState(() => _notificationRadius = value);
              },
              onChangeEnd: (value) async {
                await _prefsService.setNotificationRadius(value);
                _showSnackBar('Bildirim yarıçapı: ${value.toInt()} km');
                await _syncSettingsToServer();
              },
            ),

            const SizedBox(height: 8),
            Container(
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: isDarkTheme
                    ? Colors.grey[800]?.withOpacity(0.5)
                    : Colors.blue[50],
                borderRadius: BorderRadius.circular(8),
                border: Border.all(
                  color: isDarkTheme ? Colors.grey[700]! : Colors.blue[200]!,
                ),
              ),
              child: Row(
                children: [
                  Icon(
                    Icons.info_outline,
                    color: isDarkTheme ? Colors.orange : Colors.blue,
                    size: 20,
                  ),
                  const SizedBox(width: 8),
                  Expanded(
                    child: Text(
                      'Haritada ${_minMagnitude.toStringAsFixed(1)}-${_maxMagnitude.toStringAsFixed(1)} arası depremler gösterilir. ${_notificationRadius.toInt()} km içindeki depremlerden bildirim alırsınız.',
                      style: TextStyle(
                        fontSize: 12,
                        color:
                            isDarkTheme ? Colors.grey[300] : Colors.blue[900],
                      ),
                    ),
                  ),
                ],
              ),
            ),

            const SizedBox(height: 32),

            // Bildirim Ayarları Bölümü
            Text(
              'Bildirim Ayarları',
              style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.bold,
                  ),
            ),
            const SizedBox(height: 16),
            
            // Bildirim Sesi
            _buildNotificationSwitch(
              title: 'Bildirim Sesi',
              subtitle: 'Deprem bildirimlerinde ses çal',
              icon: Icons.volume_up,
              value: _notificationSoundEnabled,
              onChanged: (value) async {
                setState(() => _notificationSoundEnabled = value);
                await _prefsService.setNotificationSound(value);
                _showSnackBar(value ? 'Bildirim sesi açıldı' : 'Bildirim sesi kapatıldı');
              },
            ),
            
            const SizedBox(height: 12),
            
            // Titreşim
            _buildNotificationSwitch(
              title: 'Titreşim',
              subtitle: 'Deprem bildirimlerinde titret',
              icon: Icons.vibration,
              value: _vibrationEnabled,
              onChanged: (value) async {
                setState(() => _vibrationEnabled = value);
                await _prefsService.setVibration(value);
                _showSnackBar(value ? 'Titreşim açıldı' : 'Titreşim kapatıldı');
              },
            ),
            
            const SizedBox(height: 12),
            
            // Arka Plan Bildirimleri
            _buildNotificationSwitch(
              title: 'Arka Plan Bildirimleri',
              subtitle: 'Uygulama kapalıyken bildirim al',
              icon: Icons.notifications_active,
              value: _backgroundNotificationsEnabled,
              onChanged: (value) async {
                setState(() => _backgroundNotificationsEnabled = value);
                await _prefsService.setBackgroundNotifications(value);
                _showSnackBar(value ? 'Arka plan bildirimleri açıldı' : 'Arka plan bildirimleri kapatıldı');
              },
            ),
            
            const SizedBox(height: 12),
            
            // Konum Paylaşma
            _buildNotificationSwitch(
              title: 'Konum Paylaşma',
              subtitle: 'Arkadaşlarınızla konumunuzu paylaşın',
              icon: Icons.location_on,
              value: _shareLocationEnabled,
              onChanged: (value) async {
                setState(() => _shareLocationEnabled = value);
                await _prefsService.setShareLocation(value);
                await _syncSettingsToServer();
                _showSnackBar(value ? 'Konum paylaşma açıldı' : 'Konum paylaşma kapatıldı');
              },
            ),

            const SizedBox(height: 32),

            // Uygulama Teması Bölümü
            Text(
              'Uygulama Görünümü',
              style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.bold,
                  ),
            ),
            const SizedBox(height: 16),
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
                borderRadius: BorderRadius.circular(12),
                border: Border.all(
                  color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
                ),
              ),
              child: Row(
                children: [
                  Icon(
                    isDarkTheme ? Icons.dark_mode : Icons.light_mode,
                    color: isDarkTheme ? Colors.orange : Colors.blue,
                    size: 28,
                  ),
                  const SizedBox(width: 16),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          'Koyu Tema',
                          style: TextStyle(
                            fontSize: 16,
                            fontWeight: FontWeight.w600,
                            color: isDarkTheme ? Colors.white : Colors.black87,
                          ),
                        ),
                        Text(
                          isDarkTheme ? 'Koyu tema aktif' : 'Açık tema aktif',
                          style: TextStyle(
                            fontSize: 14,
                            color: isDarkTheme
                                ? Colors.grey[300]
                                : Colors.grey[600],
                          ),
                        ),
                      ],
                    ),
                  ),
                  Switch.adaptive(
                    value: isDarkTheme,
                    onChanged: _saveAppTheme,
                    activeColor: Colors.orange,
                    activeTrackColor: Colors.orange.withOpacity(0.3),
                  ),
                ],
              ),
            ),

            const SizedBox(height: 32),

            // MQTT Auto-start toggle
            Text(
              'Bildirim Servisi',
              style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.bold,
                  ),
            ),
            const SizedBox(height: 16),
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
                borderRadius: BorderRadius.circular(12),
                border: Border.all(
                  color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
                ),
              ),
              child: Row(
                children: [
                  Icon(
                    Icons.notifications_active_outlined,
                    color: isDarkTheme ? Colors.orange : Colors.blue,
                    size: 28,
                  ),
                  const SizedBox(width: 16),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          'Otomatik Bildirim Servisi',
                          style: TextStyle(
                            fontSize: 16,
                            fontWeight: FontWeight.w600,
                            color: isDarkTheme ? Colors.white : Colors.black87,
                          ),
                        ),
                        Text(
                          autoStartMqtt
                              ? 'Uygulama girişinde servis otomatik başlatılır'
                              : 'Servis otomatik başlatılmaz',
                          style: TextStyle(
                            fontSize: 14,
                            color: isDarkTheme
                                ? Colors.grey[300]
                                : Colors.grey[600],
                          ),
                        ),
                      ],
                    ),
                  ),
                  Switch.adaptive(
                    value: autoStartMqtt,
                    onChanged: (v) async {
                      final prefs = await SharedPreferences.getInstance();
                      await prefs.setBool('auto_start_mqtt_service', v);
                      setState(() {
                        autoStartMqtt = v;
                      });
                      // UX: show feedback
                      if (mounted) {
                        ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(
                            content: Text(v
                                ? 'Otomatik bildirim servisi etkinleştirildi.'
                                : 'Otomatik bildirim servisi devre dışı bırakıldı.'),
                            duration: const Duration(seconds: 2),
                          ),
                        );
                      }
                      // If user disabled auto-start, stop service if running
                      if (!v) {
                        try {
                          await MqttService.instance.stopForegroundTask();
                        } catch (_) {}
                      }
                    },
                    activeColor: Colors.orange,
                    activeTrackColor: Colors.orange.withOpacity(0.3),
                  ),
                ],
              ),
            ),

            // Harita Teması Bölümü
            Text(
              'Harita Görünümü',
              style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.bold,
                  ),
            ),
            const SizedBox(height: 16),
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
                borderRadius: BorderRadius.circular(12),
                border: Border.all(
                  color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
                ),
              ),
              child: Row(
                children: [
                  Icon(
                    isDarkMapTheme ? Icons.map_outlined : Icons.map,
                    color: isDarkTheme ? Colors.orange : Colors.blue,
                    size: 28,
                  ),
                  const SizedBox(width: 16),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          'Koyu Harita',
                          style: TextStyle(
                            fontSize: 16,
                            fontWeight: FontWeight.w600,
                            color: isDarkTheme ? Colors.white : Colors.black87,
                          ),
                        ),
                        Text(
                          isDarkMapTheme
                              ? 'Koyu harita teması'
                              : 'Açık harita teması',
                          style: TextStyle(
                            fontSize: 14,
                            color: isDarkTheme
                                ? Colors.grey[300]
                                : Colors.grey[600],
                          ),
                        ),
                      ],
                    ),
                  ),
                  Switch.adaptive(
                    value: isDarkMapTheme,
                    onChanged: _saveMapTheme,
                    activeColor: Colors.orange,
                    activeTrackColor: Colors.orange.withOpacity(0.3),
                  ),
                ],
              ),
            ),

            const SizedBox(height: 32),

            // Bilgi Bölümü
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
                borderRadius: BorderRadius.circular(12),
                border: Border.all(
                  color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
                ),
              ),
              child: Row(
                children: [
                  Icon(
                    Icons.info_outline,
                    color: isDarkTheme ? Colors.orange : Colors.blue,
                    size: 28,
                  ),
                  const SizedBox(width: 16),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          'Tema Ayarları',
                          style: TextStyle(
                            fontSize: 16,
                            fontWeight: FontWeight.w600,
                            color: isDarkTheme ? Colors.white : Colors.black87,
                          ),
                        ),
                        Text(
                          'Ayarlarınız otomatik olarak kaydedilir ve bir sonraki açılışta uygulanır.',
                          style: TextStyle(
                            fontSize: 14,
                            color: isDarkTheme
                                ? Colors.grey[300]
                                : Colors.grey[600],
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),

            // ARAÇLAR BÖLÜMÜ
            const SizedBox(height: 32),
            Text(
              'Araçlar',
              style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.bold,
                  ),
            ),
            const SizedBox(height: 16),
            
            // Düdük Çal Aracı
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
                borderRadius: BorderRadius.circular(12),
                border: Border.all(
                  color: _isWhistlePlaying 
                      ? Colors.red 
                      : (isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!),
                  width: _isWhistlePlaying ? 2 : 1,
                ),
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    children: [
                      Icon(
                        _isWhistlePlaying ? Icons.volume_up : Icons.campaign,
                        color: _isWhistlePlaying ? Colors.red : (isDarkTheme ? Colors.orange : Colors.blue),
                        size: 32,
                      ),
                      const SizedBox(width: 16),
                      Expanded(
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              'Düdük Çal',
                              style: TextStyle(
                                fontSize: 18,
                                fontWeight: FontWeight.bold,
                                color: isDarkTheme ? Colors.white : Colors.black87,
                              ),
                            ),
                            Text(
                              _isWhistlePlaying 
                                  ? '🔊 Düdük çalıyor - Yerini belli et!'
                                  : 'Enkaz altındayken yerini belli etmek için kullan',
                              style: TextStyle(
                                fontSize: 13,
                                color: _isWhistlePlaying 
                                    ? Colors.red 
                                    : (isDarkTheme ? Colors.grey[400] : Colors.grey[600]),
                              ),
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 16),
                  Row(
                    children: [
                      Expanded(
                        child: ElevatedButton.icon(
                          onPressed: _isWhistlePlaying ? null : () async {
                            await _whistleService.startWhistle();
                            setState(() => _isWhistlePlaying = true);
                            _showSnackBar('🔊 Düdük çalmaya başladı!');
                          },
                          icon: const Icon(Icons.play_arrow),
                          label: const Text('Başlat'),
                          style: ElevatedButton.styleFrom(
                            backgroundColor: Colors.green,
                            foregroundColor: Colors.white,
                            disabledBackgroundColor: Colors.grey,
                            padding: const EdgeInsets.symmetric(vertical: 12),
                          ),
                        ),
                      ),
                      const SizedBox(width: 12),
                      Expanded(
                        child: ElevatedButton.icon(
                          onPressed: !_isWhistlePlaying ? null : () async {
                            await _whistleService.stopWhistle();
                            setState(() => _isWhistlePlaying = false);
                            _showSnackBar('🔇 Düdük durduruldu');
                          },
                          icon: const Icon(Icons.stop),
                          label: const Text('Durdur'),
                          style: ElevatedButton.styleFrom(
                            backgroundColor: Colors.red,
                            foregroundColor: Colors.white,
                            disabledBackgroundColor: Colors.grey,
                            padding: const EdgeInsets.symmetric(vertical: 12),
                          ),
                        ),
                      ),
                    ],
                  ),
                  if (_isWhistlePlaying) ...[
                    const SizedBox(height: 12),
                    Container(
                      padding: const EdgeInsets.all(12),
                      decoration: BoxDecoration(
                        color: Colors.red.withOpacity(0.1),
                        borderRadius: BorderRadius.circular(8),
                        border: Border.all(color: Colors.red.withOpacity(0.3)),
                      ),
                      child: Row(
                        children: [
                          const Icon(Icons.warning_amber, color: Colors.red, size: 20),
                          const SizedBox(width: 8),
                          Expanded(
                            child: Text(
                              'Düdük sesi çalıyor! Kurtarma ekiplerinin sizi bulmasına yardımcı olun.',
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

            // GELİŞTİRİCİ ARAÇLARI (YENİ)
            const SizedBox(height: 32),
            Text(
              'Geliştirici Araçları',
              style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.bold,
                  ),
            ),
            const SizedBox(height: 16),
            Card(
              color: isDarkTheme ? Colors.grey[800] : Colors.white,
              elevation: 2,
              child: ListTile(
                leading: Icon(
                  Icons.science,
                  color: Colors.orange,
                  size: 32,
                ),
                title: Text(
                  'P2P Sistem Testi',
                  style: TextStyle(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.w600,
                  ),
                ),
                subtitle: Text(
                  'Sensör ve backend testleri',
                  style: TextStyle(
                    color: isDarkTheme ? Colors.grey[400] : Colors.grey[600],
                  ),
                ),
                trailing: Icon(
                  Icons.arrow_forward_ios,
                  color: isDarkTheme ? Colors.grey[400] : Colors.grey[600],
                ),
                onTap: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => const P2PTestScreen(),
                    ),
                  );
                },
              ),
            ),
            const SizedBox(height: 12),
            Card(
              color: isDarkTheme ? Colors.grey[800] : Colors.white,
              elevation: 2,
              child: ListTile(
                leading: Icon(
                  Icons.sensors,
                  color: Colors.purple,
                  size: 32,
                ),
                title: Text(
                  'Sensör Veri Kaydedici',
                  style: TextStyle(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.w600,
                  ),
                ),
                subtitle: Text(
                  'Deprem simülasyonu ve algoritma ayarı',
                  style: TextStyle(
                    color: isDarkTheme ? Colors.grey[400] : Colors.grey[600],
                  ),
                ),
                trailing: Icon(
                  Icons.arrow_forward_ios,
                  color: isDarkTheme ? Colors.grey[400] : Colors.grey[600],
                ),
                onTap: () {
                  Navigator.pushNamed(context, '/sensor-recorder');
                },
              ),
            ),
          ],
        ),
      ),
    );
  }

  void _showSnackBar(String message) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(message),
        duration: const Duration(seconds: 1),
        backgroundColor: Colors.green,
      ),
    );
  }

  // Ayarları sunucuya senkronize et
  Future<void> _syncSettingsToServer() async {
    try {
      await _locationUpdateService.sendNotificationSettings(
        notificationRadius: _notificationRadius,
        minMagnitude: _minMagnitude,
        maxMagnitude: _maxMagnitude,
      );
      print('✅ Ayarlar sunucuya senkronize edildi');
    } catch (e) {
      print('⚠️  Ayar senkronizasyonu hatası: $e');
    }
  }

  Widget _buildMagnitudeSlider({
    required String title,
    required double value,
    required double min,
    required double max,
    required Function(double) onChanged,
    Function(double)? onChangeEnd,
    required Color color,
  }) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
        borderRadius: BorderRadius.circular(12),
        border: Border.all(
          color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
        ),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                title,
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.w600,
                  color: isDarkTheme ? Colors.white : Colors.black87,
                ),
              ),
              Container(
                padding:
                    const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                decoration: BoxDecoration(
                  color: color.withOpacity(0.2),
                  borderRadius: BorderRadius.circular(20),
                ),
                child: Text(
                  value.toStringAsFixed(1),
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    color: color,
                  ),
                ),
              ),
            ],
          ),
          const SizedBox(height: 8),
          SliderTheme(
            data: SliderTheme.of(context).copyWith(
              activeTrackColor: color,
              inactiveTrackColor: color.withOpacity(0.3),
              thumbColor: color,
              overlayColor: color.withOpacity(0.2),
            ),
            child: Slider(
              value: value,
              min: min,
              max: max,
              divisions: 90,
              onChanged: onChanged,
              onChangeEnd: onChangeEnd,
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                min.toStringAsFixed(1),
                style: TextStyle(
                  fontSize: 12,
                  color: isDarkTheme ? Colors.grey[400] : Colors.grey[600],
                ),
              ),
              Text(
                max.toStringAsFixed(1),
                style: TextStyle(
                  fontSize: 12,
                  color: isDarkTheme ? Colors.grey[400] : Colors.grey[600],
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }

  Widget _buildRadiusSlider({
    required String title,
    required double value,
    required double min,
    required double max,
    required Function(double) onChanged,
    Function(double)? onChangeEnd,
  }) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
        borderRadius: BorderRadius.circular(12),
        border: Border.all(
          color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
        ),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                title,
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.w600,
                  color: isDarkTheme ? Colors.white : Colors.black87,
                ),
              ),
              Container(
                padding:
                    const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                decoration: BoxDecoration(
                  color: Colors.amber.withOpacity(0.2),
                  borderRadius: BorderRadius.circular(20),
                ),
                child: Text(
                  '${value.toInt()} km',
                  style: const TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.bold,
                    color: Colors.amber,
                  ),
                ),
              ),
            ],
          ),
          const SizedBox(height: 8),
          SliderTheme(
            data: SliderTheme.of(context).copyWith(
              activeTrackColor: Colors.amber,
              inactiveTrackColor: Colors.amber.withOpacity(0.3),
              thumbColor: Colors.amber,
              overlayColor: Colors.amber.withOpacity(0.2),
            ),
            child: Slider(
              value: value,
              min: min,
              max: max,
              divisions: 99,
              onChanged: onChanged,
              onChangeEnd: onChangeEnd,
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                '${min.toInt()} km',
                style: TextStyle(
                  fontSize: 12,
                  color: isDarkTheme ? Colors.grey[400] : Colors.grey[600],
                ),
              ),
              Text(
                '${max.toInt()} km',
                style: TextStyle(
                  fontSize: 12,
                  color: isDarkTheme ? Colors.grey[400] : Colors.grey[600],
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }

  Widget _buildNotificationSwitch({
    required String title,
    required String subtitle,
    required IconData icon,
    required bool value,
    required ValueChanged<bool> onChanged,
  }) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
        borderRadius: BorderRadius.circular(12),
        border: Border.all(
          color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
        ),
      ),
      child: Row(
        children: [
          Icon(
            icon,
            color: value 
                ? (isDarkTheme ? Colors.orange : Colors.blue)
                : Colors.grey,
            size: 28,
          ),
          const SizedBox(width: 16),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  title,
                  style: TextStyle(
                    fontSize: 16,
                    fontWeight: FontWeight.w600,
                    color: isDarkTheme ? Colors.white : Colors.black87,
                  ),
                ),
                const SizedBox(height: 4),
                Text(
                  subtitle,
                  style: TextStyle(
                    fontSize: 12,
                    color: isDarkTheme ? Colors.grey[400] : Colors.grey[600],
                  ),
                ),
              ],
            ),
          ),
          Switch(
            value: value,
            onChanged: onChanged,
            activeColor: isDarkTheme ? Colors.orange : Colors.blue,
          ),
        ],
      ),
    );
  }
}
