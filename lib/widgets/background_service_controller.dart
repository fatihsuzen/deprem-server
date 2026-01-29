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
    // Özellik geçici olarak devre dışı - servis başlatılmayacak
    setState(() {
      _isRunning = false;
    });

    // Eğer eski kullanıcılarda çalışan bir servis varsa durdur
    final isRunning = await FlutterForegroundTask.isRunningService;
    if (isRunning) {
      await EarthquakeBackgroundService.stopService();
      debugPrint(
          '🔴 [BG] Arka plan servisi durduruldu (özellik geçici olarak devre dışı)');
    }

    // Prefs'i de false olarak güncelle
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool('background_notifications_enabled', false);
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

    // ÖZELLİK GEÇİCİ OLARAK DEVRE DIŞI - Kullanıcıya bilgi göster
    await showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Row(
          children: [
            Icon(Icons.info_outline, color: Color(0xFFFF3A3D), size: 28),
            SizedBox(width: 8),
            Expanded(
              child: Text(
                _currentLocale == 'tr'
                    ? 'Özellik Geliştiriliyor'
                    : 'Feature Under Development',
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
              _currentLocale == 'tr'
                  ? 'Arka plan bildirimleri özelliği şu anda geliştirme aşamasındadır.'
                  : 'Background notifications feature is currently under development.',
              style: TextStyle(fontSize: 14),
            ),
            SizedBox(height: 12),
            Container(
              padding: EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Color(0xFFFF3A3D).withOpacity(0.1),
                borderRadius: BorderRadius.circular(8),
                border: Border.all(color: Color(0xFFFF3A3D).withOpacity(0.3)),
              ),
              child: Row(
                children: [
                  Icon(Icons.people_outline,
                      color: Color(0xFFFF3A3D), size: 20),
                  SizedBox(width: 8),
                  Expanded(
                    child: Text(
                      _currentLocale == 'tr'
                          ? 'Yeterli kullanıcı sayısına ulaşıldığında bu özellik aktif edilecektir.'
                          : 'This feature will be activated when sufficient user count is reached.',
                      style: TextStyle(
                        fontSize: 12,
                        color: Color(0xFFFF3A3D),
                        fontWeight: FontWeight.w500,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
        actions: [
          ElevatedButton(
            onPressed: () => Navigator.of(context).pop(),
            style: ElevatedButton.styleFrom(
              backgroundColor: Color(0xFFFF3A3D),
              foregroundColor: Colors.white,
            ),
            child: Text(_currentLocale == 'tr' ? 'Anladım' : 'OK'),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations(Locale(_currentLocale));

    return Card(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: ListTile(
        leading: Icon(
          Icons.notifications_off, // Her zaman kapalı göster
          color: Colors.grey,
        ),
        title: Text(l10n.get('background_notifications')),
        subtitle: Text(
          _currentLocale == 'tr'
              ? 'Geliştiriliyor - Yakında aktif olacak'
              : 'Under development - Coming soon',
          style: TextStyle(
            fontSize: 12,
            color: Colors.grey,
          ),
        ),
        trailing: Switch(
          value: false, // Her zaman kapalı
          onChanged: (value) => _toggleService(), // Dialog göster
          activeColor: const Color(0xFFFF3A3D),
        ),
        onTap: () => _toggleService(), // ListTile'a da tıklanabilir yap
      ),
    );
  }
}
