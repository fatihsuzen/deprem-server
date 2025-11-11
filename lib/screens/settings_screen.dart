import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../services/mqtt_service.dart';
import '../services/user_preferences_service.dart';
import '../services/location_update_service.dart';

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

  // Deprem filtreleme ayarları
  final UserPreferencesService _prefsService = UserPreferencesService();
  final LocationUpdateService _locationUpdateService = LocationUpdateService();
  double _minMagnitude = UserPreferencesService.defaultMinMagnitude;
  double _maxMagnitude = UserPreferencesService.defaultMaxMagnitude;
  double _notificationRadius = UserPreferencesService.defaultNotificationRadius;

  @override
  void initState() {
    super.initState();
    _loadSettings();
  }

  Future<void> _loadSettings() async {
    final prefs = await SharedPreferences.getInstance();
    final earthquakeSettings = await _prefsService.getAllSettings();

    setState(() {
      isDarkTheme = prefs.getBool('isDarkTheme') ?? false;
      isDarkMapTheme = prefs.getBool('isDarkMapTheme') ?? false;
      autoStartMqtt = prefs.getBool('auto_start_mqtt_service') ?? true;

      // Deprem ayarları
      _minMagnitude = earthquakeSettings['minMagnitude'];
      _maxMagnitude = earthquakeSettings['maxMagnitude'];
      _notificationRadius = earthquakeSettings['notificationRadius'];

      isLoading = false;
    });
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
              onChanged: (value) async {
                if (value < _maxMagnitude) {
                  await _prefsService.setMinMagnitude(value);
                  setState(() => _minMagnitude = value);
                  _showSnackBar(
                      'Minimum büyüklük: ${value.toStringAsFixed(1)}');
                  await _syncSettingsToServer();
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
              onChanged: (value) async {
                if (value > _minMagnitude) {
                  await _prefsService.setMaxMagnitude(value);
                  setState(() => _maxMagnitude = value);
                  _showSnackBar(
                      'Maksimum büyüklük: ${value.toStringAsFixed(1)}');
                  await _syncSettingsToServer();
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
              onChanged: (value) async {
                await _prefsService.setNotificationRadius(value);
                setState(() => _notificationRadius = value);
                _showSnackBar('Bildirim yarıçapı: ${value.toInt()} km');
                
                // Sunucuya gönder
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
}
