import 'package:flutter/material.dart';
import 'package:flutter_foreground_task/flutter_foreground_task.dart';
import '../services/earthquake_background_service.dart';

/// Background service kontrolü için widget
/// Settings sayfasında gösterilebilir
class BackgroundServiceController extends StatefulWidget {
  const BackgroundServiceController({super.key});

  @override
  State<BackgroundServiceController> createState() => _BackgroundServiceControllerState();
}

class _BackgroundServiceControllerState extends State<BackgroundServiceController> {
  bool _isRunning = false;

  @override
  void initState() {
    super.initState();
    _checkServiceStatus();
  }

  Future<void> _checkServiceStatus() async {
    final isRunning = await FlutterForegroundTask.isRunningService;
    setState(() {
      _isRunning = isRunning;
    });
  }

  Future<void> _toggleService() async {
    if (_isRunning) {
      // Servisi durdur
      await EarthquakeBackgroundService.stopService();
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('⚠️ Arka plan servisi durduruldu - Bildirimler çalışmayabilir'),
          backgroundColor: Colors.orange,
        ),
      );
    } else {
      // Servisi başlat
      final started = await EarthquakeBackgroundService.startService();
      if (started) {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('✅ Arka plan servisi başlatıldı - Uygulama kapalıyken bile bildirim alacaksınız'),
            backgroundColor: Colors.green,
          ),
        );
      } else {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('❌ Arka plan servisi başlatılamadı'),
            backgroundColor: Colors.red,
          ),
        );
      }
    }
    
    await _checkServiceStatus();
  }

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: ListTile(
        leading: Icon(
          _isRunning ? Icons.notifications_active : Icons.notifications_off,
          color: _isRunning ? Colors.green : Colors.grey,
        ),
        title: const Text('Arka Plan Bildirimleri'),
        subtitle: Text(
          _isRunning 
            ? 'Aktif - Uygulama kapalıyken bile bildirim alırsınız'
            : 'Kapalı - Sadece uygulama açıkken bildirim alırsınız',
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
