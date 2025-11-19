import 'dart:async';
import 'dart:math';
import 'package:flutter_foreground_task/flutter_foreground_task.dart';
import 'package:socket_io_client/socket_io_client.dart' as IO;
import 'package:shared_preferences/shared_preferences.dart';
import 'notification_service.dart';

class EarthquakeBackgroundService {
  static void initializeService() {
    FlutterForegroundTask.init(
      androidNotificationOptions: AndroidNotificationOptions(
        channelId: 'earthquake_alert_high',
        channelName: 'Deprem Acil Uyarıları',
        channelDescription: 'Yüksek öncelikli deprem uyarıları',
        channelImportance:
            NotificationChannelImportance.LOW, // Normal takip için LOW
        priority: NotificationPriority.LOW, // Normal takip için LOW
        visibility:
            NotificationVisibility.VISIBILITY_SECRET, // Normal takipte gizli
        playSound: false, // Normal takipte ses yok
        enableVibration: false, // Normal takipte titreşim yok
        showWhen: true,
      ),
      iosNotificationOptions: const IOSNotificationOptions(
        showNotification: true,
        playSound: false,
      ),
      foregroundTaskOptions: ForegroundTaskOptions(
        eventAction: ForegroundTaskEventAction.repeat(5000),
        autoRunOnBoot: true,
        autoRunOnMyPackageReplaced: true,
        allowWakeLock: true,
        allowWifiLock: true,
      ),
    );

    // Ekran uyandırma için wake lock aktif
    FlutterForegroundTask.setOnLockScreenVisibility(true);
  }

  static Future<bool> startService() async {
    if (await FlutterForegroundTask.isRunningService) {
      print('Background servis zaten calisiyor');
      return true;
    }

    print('Background servis baslatiliyor...');

    await FlutterForegroundTask.startService(
      notificationTitle: 'Deprem Takip Aktif',
      notificationText: 'Deprem uyarilari icin bekleniyor...',
      callback: startCallback,
    );

    return true;
  }

  static Future<bool> stopService() async {
    await FlutterForegroundTask.stopService();
    return true;
  }
}

// Top-level callback fonksiyonu (isolate'da calisir)
@pragma('vm:entry-point')
void startCallback() {
  FlutterForegroundTask.setTaskHandler(EarthquakeTaskHandler());
}

class EarthquakeTaskHandler extends TaskHandler {
  IO.Socket? _socket;
  int _updateCount = 0;

  @override
  Future<void> onStart(DateTime timestamp, TaskStarter starter) async {
    print('🔧 Background WebSocket baslaniyor...');

    try {
      // WebSocket baglantisi kur
      _socket = IO.io(
          'http://188.132.202.24:3000',
          IO.OptionBuilder()
              .setTransports(['websocket'])
              .disableAutoConnect()
              .build());

      _socket?.on('connect', (_) {
        print('✅ Background WebSocket baglandi');
        FlutterForegroundTask.updateService(
          notificationTitle: 'Deprem Takip Aktif',
          notificationText: 'WebSocket baglantisi aktif',
        );
      });

      _socket?.on('earthquake_alert', (data) async {
        print('🚨 BACKGROUND ALERT: $data');
        await _handleEarthquakeData(data, 'earthquake_alert');
      });

      _socket?.on('earthquake_warning', (data) async {
        print('⚠️  BACKGROUND WARNING: $data');
        await _handleEarthquakeData(data, 'earthquake_warning');
      });

      _socket?.on('disconnect', (_) {
        print('❌ Background WebSocket baglanti kesildi');
      });

      _socket?.connect();
    } catch (e) {
      print('❌ Background WebSocket hatasi: $e');
    }
  }

  Future<void> _handleEarthquakeData(dynamic data, String type) async {
    try {
      final prefs = await SharedPreferences.getInstance();
      final notificationRadius =
          prefs.getDouble('notification_radius') ?? 100.0;
      final minMagnitude = prefs.getDouble('min_magnitude') ?? 2.5;

      final magnitude = (data['magnitude'] ?? 0.0).toDouble();
      final location = data['location'] ?? 'Bilinmeyen';
      final earthquakeLat = (data['lat'] ?? 0.0).toDouble();
      final earthquakeLon = (data['lon'] ?? 0.0).toDouble();

      print(
          '📍 Deprem: M$magnitude - $location ($earthquakeLat, $earthquakeLon)');
      print(
          '📏 Filtreler: Min M$minMagnitude, Yaricap ${notificationRadius}km');

      // Magnitude filtresi
      if (magnitude < minMagnitude) {
        print('⏭️  Magnitude cok dusuk ($magnitude < $minMagnitude), atlandi');
        return;
      }

      // Kullanicinin son bilinen konumunu al (SharedPreferences'tan)
      final userLat = prefs.getDouble('last_latitude');
      final userLon = prefs.getDouble('last_longitude');

      if (userLat == null || userLon == null) {
        print('⚠️  Kullanici konumu bilinmiyor, mesafe kontrolu yapilamiyor');
        print('   Bildirim yine de gosteriliyor...');
      } else {
        // Mesafe hesapla
        final distance =
            _calculateDistance(userLat, userLon, earthquakeLat, earthquakeLon);
        print('📏 Mesafe: ${distance.toStringAsFixed(1)} km');

        if (distance > notificationRadius) {
          print(
              '⏭️  Mesafe cok uzak (${distance.toStringAsFixed(1)} km > $notificationRadius km), atlandi');
          return;
        }
      }

      // 🚨 TAM EKRAN ALARM - NotificationService ile
      print('🚨 TAM EKRAN ALARM ACILIYOR...');

      try {
        // Mesafe bilgisini hesapla
        final prefs = await SharedPreferences.getInstance();
        final userLat = prefs.getDouble('last_latitude');
        final userLon = prefs.getDouble('last_longitude');

        double distance = 0;
        if (userLat != null && userLon != null) {
          distance = _calculateDistance(
              userLat, userLon, earthquakeLat, earthquakeLon);
        }

        // TAM EKRAN ALARM GÖNDER
        final notificationService = NotificationService();
        await notificationService.showFullScreenEarthquakeAlert(
          magnitude: magnitude,
          location: location,
          distance: distance,
          source: type.toUpperCase(),
          earthquakeLat: earthquakeLat,
          earthquakeLon: earthquakeLon,
          userLat: userLat,
          userLon: userLon,
        );

        print('✅ Tam ekran alarm gonderildi');
      } catch (e) {
        print('❌ Alarm gonderme hatasi: $e');
      }

      // Ekranı uyandır
      try {
        FlutterForegroundTask.wakeUpScreen();
        print('✅ Ekran uyandirma cagrisi yapildi');
      } catch (e) {
        print('⚠️  Ekran uyandirma hatasi: $e');
      }

      // Background service notification'ı güncelle
      FlutterForegroundTask.updateService(
        notificationTitle: '🚨 DEPREM! M$magnitude',
        notificationText: '$location - ŞİMDİ OLDU',
      );

      print('✅ Background notification gosterildi: M$magnitude - $location');
    } catch (e) {
      print('❌ Deprem data isleme hatasi: $e');
    }
  }

  // Mesafe hesaplama (Haversine formulu)
  double _calculateDistance(
      double lat1, double lon1, double lat2, double lon2) {
    const double earthRadius = 6371; // km
    final dLat = _toRadians(lat2 - lat1);
    final dLon = _toRadians(lon2 - lon1);

    final a = sin(dLat / 2) * sin(dLat / 2) +
        cos(_toRadians(lat1)) *
            cos(_toRadians(lat2)) *
            sin(dLon / 2) *
            sin(dLon / 2);

    final c = 2 * atan2(sqrt(a), sqrt(1 - a));
    return earthRadius * c;
  }

  double _toRadians(double degrees) {
    return degrees * (pi / 180.0);
  }

  @override
  void onRepeatEvent(DateTime timestamp) {
    // FCM ile bildirim altyapısı kullanılacak. Burada arka plan güncellemesi yapılmıyor.
    // ...existing code...
  }

  @override
  Future<void> onDestroy(DateTime timestamp) async {
    print('🔴 Background task durduruluyor');
    // WebSocket kaldırıldı
  }

  @override
  void onNotificationPressed() {
    FlutterForegroundTask.launchApp(); // ...existing code...
  }
}
