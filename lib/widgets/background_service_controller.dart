import '../services/user_preferences_service.dart';
import 'package:flutter/material.dart';
import 'package:flutter_foreground_task/flutter_foreground_task.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../services/earthquake_background_service.dart';
import '../l10n/app_localizations.dart';

/// Background service kontrolü için widget
/// Settings sayfasında gösterilebilir
class BackgroundServiceController extends StatefulWidget {
  const BackgroundServiceController({super.key});

  @override
  State<BackgroundServiceController> createState() =>
      _BackgroundServiceControllerState();
}

class _BackgroundServiceControllerState
    extends State<BackgroundServiceController> {
  bool _isRunning = false;
  String _currentLocale = 'tr';

  @override
  void initState() {
    super.initState();
    _loadLocale();
    _initBackgroundService();
  }

  Future<void> _initBackgroundService() async {
    await _checkServiceStatus();
    final prefsService = UserPreferencesService();
    final enabled = await prefsService.getBackgroundNotifications();
    if (enabled) {
      debugPrint(
          '🟢 [BG] background_notifications_enabled: TRUE (servis başlatılacak)');
      final isRunning = await FlutterForegroundTask.isRunningService;
      if (!isRunning) {
        await EarthquakeBackgroundService.startService();
        await _checkServiceStatus();
      }
    } else {
      debugPrint(
          '🔴 [BG] background_notifications_enabled: FALSE (servis başlatılmayacak)');
      // Eğer servis çalışıyorsa ve pref false ise durdur
      final isRunning = await FlutterForegroundTask.isRunningService;
      if (isRunning) {
        await EarthquakeBackgroundService.stopService();
        await _checkServiceStatus();
      }
    }
  }

  Future<void> _loadLocale() async {
    final prefs = await SharedPreferences.getInstance();
    final locale = prefs.getString('app_locale') ?? 'tr';
    if (mounted) {
      setState(() {
        _currentLocale = locale;
      });
    }
  }

  Future<void> _checkServiceStatus() async {
    final isRunning = await FlutterForegroundTask.isRunningService;
    if (mounted) {
      setState(() {
        _isRunning = isRunning;
      });
    }
  }

  /// Pil optimizasyonu kontrolü ve dialog gösterimi
  Future<bool> _checkBatteryOptimization() async {
    final l10n = AppLocalizations(Locale(_currentLocale));

    try {
      // Uygulama pil optimizasyonundan muaf mı kontrol et
      final isIgnoringBatteryOptimizations =
          await FlutterForegroundTask.isIgnoringBatteryOptimizations;

      print(
          '🔋 Pil optimizasyonu muafiyet durumu: $isIgnoringBatteryOptimizations');

      if (!isIgnoringBatteryOptimizations) {
        // Pil optimizasyonu açık (uygulama kısıtlı), kullanıcıya bilgi ver
        if (!mounted) return false;

        final shouldOpenSettings = await showDialog<bool>(
          context: context,
          barrierDismissible: false,
          builder: (context) => AlertDialog(
            title: Row(
              children: [
                Icon(Icons.battery_alert, color: Colors.orange, size: 28),
                SizedBox(width: 8),
                Expanded(
                  child: Text(
                    l10n.get('battery_optimization_title'),
                    style: TextStyle(fontSize: 18),
                  ),
                ),
              ],
            ),
            content: Column(
              mainAxisSize: MainAxisSize.min,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  l10n.get('battery_optimization_message'),
                  style: TextStyle(fontSize: 14),
                ),
                SizedBox(height: 12),
                Container(
                  padding: EdgeInsets.all(12),
                  decoration: BoxDecoration(
                    color: Colors.orange.withOpacity(0.1),
                    borderRadius: BorderRadius.circular(8),
                    border: Border.all(color: Colors.orange.withOpacity(0.3)),
                  ),
                  child: Row(
                    children: [
                      Icon(Icons.info_outline, color: Colors.orange, size: 20),
                      SizedBox(width: 8),
                      Expanded(
                        child: Text(
                          l10n.get('battery_optimization_hint'),
                          style: TextStyle(
                              fontSize: 12, color: Colors.orange[800]),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
            actions: [
              TextButton(
                onPressed: () => Navigator.of(context).pop(false),
                child: Text(l10n.get('later')),
              ),
              ElevatedButton(
                onPressed: () => Navigator.of(context).pop(true),
                style: ElevatedButton.styleFrom(
                  backgroundColor: Color(0xFFFF3A3D),
                  foregroundColor: Colors.white,
                ),
                child: Text(l10n.get('open_settings')),
              ),
            ],
          ),
        );

        if (shouldOpenSettings == true) {
          // Pil optimizasyonu ayarlarını aç - izin iste
          final result =
              await FlutterForegroundTask.requestIgnoreBatteryOptimization();
          print('🔋 Pil optimizasyonu izin sonucu: $result');

          // Kullanıcı ayarlardan döndükten sonra tekrar kontrol et
          await Future.delayed(Duration(milliseconds: 500));
          final nowIgnoring =
              await FlutterForegroundTask.isIgnoringBatteryOptimizations;

          if (!nowIgnoring && mounted) {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(
                content: Text(l10n.get('battery_optimization_still_on')),
                backgroundColor: Colors.orange,
                duration: Duration(seconds: 4),
              ),
            );
          } else if (nowIgnoring && mounted) {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(
                content: Text(l10n.get('battery_optimization_success')),
                backgroundColor: Colors.green,
                duration: Duration(seconds: 2),
              ),
            );
          }

          return nowIgnoring;
        }

        return false;
      }

      return true; // Pil optimizasyonu zaten kapalı (muaf), devam edebiliriz
    } catch (e) {
      print('🔋 Pil optimizasyonu kontrolü hatası: $e');
      return true; // Hata durumunda devam et
    }
  }

  Future<void> _toggleService() async {
    final l10n = AppLocalizations(Locale(_currentLocale));
    final prefs = await SharedPreferences.getInstance();

    if (_isRunning) {
      // Servisi durdur
      await EarthquakeBackgroundService.stopService();
      await prefs.setBool('background_notifications_enabled', false);
      if (mounted) {
        setState(() {
          _isRunning = false;
        });
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text(l10n.get('background_service_stopped')),
            backgroundColor: Colors.orange,
          ),
        );
      }
    } else {
      // 1. Pil optimizasyonunu kontrol et
      await _checkBatteryOptimization();

      // 2. Prefs'i güncelle
      await prefs.setBool('background_notifications_enabled', true);
      final backgroundEnabled =
          prefs.getBool('background_notifications_enabled') ?? false;
      print(
          '🟢 PREFS background_notifications_enabled (set): $backgroundEnabled');
      if (!backgroundEnabled) {
        if (mounted) {
          setState(() {
            _isRunning = false;
          });
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(
              content: Text('Arka plan bildirimleri ayarlardan kapalı!'),
              backgroundColor: Colors.red,
            ),
          );
        }
        await _checkServiceStatus();
        return;
      }

      // 3. Servisi başlat
      final started = await EarthquakeBackgroundService.startService();
      if (mounted) {
        setState(() {
          _isRunning = started;
        });
        if (started) {
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(
              content: Text(l10n.get('background_service_started')),
              backgroundColor: Colors.green,
            ),
          );
        } else {
          // Prefi tekrar false yap
          await prefs.setBool('background_notifications_enabled', false);
          setState(() {
            _isRunning = false;
          });
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(
              content: Text(l10n.get('background_service_failed')),
              backgroundColor: Colors.red,
            ),
          );
        }
      }
    }

    await _checkServiceStatus();
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations(Locale(_currentLocale));

    return Card(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: ListTile(
        leading: Icon(
          _isRunning ? Icons.notifications_active : Icons.notifications_off,
          color: _isRunning ? Colors.green : Colors.grey,
        ),
        title: Text(l10n.get('background_notifications')),
        subtitle: Text(
          _isRunning
              ? l10n.get('background_active')
              : l10n.get('background_inactive'),
          style: TextStyle(
            fontSize: 12,
            color: _isRunning ? Colors.green : Colors.orange,
          ),
        ),
        trailing: Switch(
          value: _isRunning,
          onChanged: (value) => _toggleService(),
          activeColor: const Color(0xFFFF3A3D),
        ),
      ),
    );
  }
}
