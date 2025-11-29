import 'dart:async';
import 'dart:math';
import 'dart:io';
import 'dart:convert';
import 'package:path_provider/path_provider.dart';
import 'package:flutter_foreground_task/flutter_foreground_task.dart';
import 'package:sensors_plus/sensors_plus.dart';
import 'package:geolocator/geolocator.dart';
import 'package:deprem_app/services/earthquake_report_service.dart';
import 'package:deprem_app/services/screen_state_service.dart';
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
      print('[BG] Foreground servis zaten çalışıyor (kontrol: isRunningService)');
      return true;
    }

    print('[BG] Foreground servis başlatılıyor...');

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
      // Pending rapor ve timer kodları kaldırıldı
    StreamSubscription<AccelerometerEvent>? _subscription;
    int _shakeCount = 0;
    DateTime? _lastShakeTime;
    bool _listening = false;

    // Sensör dinleme ve deprem raporlama
    void _startSensorListening() {
      if (_listening) {
        print('[BG] Sensör dinleme zaten aktif.');
        return;
      }
      print('[BG] Sensör dinleme başlatılıyor...');
      _listening = true;
      _subscription = accelerometerEvents.listen((AccelerometerEvent event) async {
        double magnitude = sqrt(
          event.x * event.x + event.y * event.y + event.z * event.z,
        );
        double delta = (magnitude - 9.8).abs();
        if (delta > 1.2) {
          DateTime now = DateTime.now();
          print('[BG] Sarsıntı algılandı! delta=$delta, time=$now');
          if (_lastShakeTime == null ||
              now.difference(_lastShakeTime!).inMilliseconds > 3000) {
            _shakeCount = 1;
          } else {
            _shakeCount++;
          }
          _lastShakeTime = now;
          print('[BG] Shake count: $_shakeCount');
          if (_shakeCount >= 2) {
            _shakeCount = 0;
            print('[BG] Deprem algılandı! Konum alınacak...');
            Position? position;
            try {
              position = await Geolocator.getCurrentPosition(
                  desiredAccuracy: LocationAccuracy.high);
              print('[BG] Konum alındı: ${position.latitude},${position.longitude}');
            } catch (geoError) {
              print('[BG] Konum alınamadı! Hata: $geoError');
              print('[BG] Konum json dosyasından alınmaya çalışılıyor...');
              try {
                final dir = await getApplicationDocumentsDirectory();
                final file = File('${dir.path}/last_location.json');
                if (await file.exists()) {
                  final jsonStr = await file.readAsString();
                  final json = jsonDecode(jsonStr);
                  position = Position(
                    latitude: json['latitude'] ?? 0.0,
                    longitude: json['longitude'] ?? 0.0,
                    accuracy: json['accuracy'] ?? 0.0,
                    altitude: 0.0,
                    heading: 0.0,
                    speed: 0.0,
                    speedAccuracy: 0.0,
                    altitudeAccuracy: 0.0,
                    headingAccuracy: 0.0,
                    timestamp: DateTime.now(),
                  );
                  print('[BG] Konum dosyadan alındı: ${position.latitude},${position.longitude}');
                } else {
                  print('[BG] Konum dosyası bulunamadı, rapor gönderilemiyor.');
                  return;
                }
              } catch (fileError) {
                print('[BG] Konum dosyadan alınamadı! Hata: $fileError');
                return;
              }
            }
            if (position != null) {
              print('[BG] Deprem raporu gönderiliyor...');
              final reportService = EarthquakeReportService(
                  'http://188.132.202.24:3000/api/p2p/shake-report');
              try {
                await reportService.sendEarthquakeReport(
                  magnitude: delta,
                  timestamp: now,
                  position: position,
                  deviceId: 'background-device',
                );
                print('⚡ [BG] Deprem raporu GİTTİ!');
              } catch (e) {
                print('❌ [BG] Deprem raporu GİTMEDİ! Hata: $e');
              }
            } else {
              print('[BG] Konum alınamadı, rapor gönderilmiyor.');
            }
          }
        }
      });
    }
  @override
  Future<void> onStart(DateTime timestamp, TaskStarter starter) async {
    print('[BG] onStart: Foreground servis başlatıldı (WebSocket kapalı)');
    print('[BG] onStart: Sensör dinleme başlatılıyor...');
    _startSensorListening();
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

      // Ekran durumu kontrolü
      bool isScreenOn = await ScreenStateService.isScreenOn();
      final notificationService = NotificationService();
      if (!isScreenOn) {
        print('🚨 Ekran kapalı, tam ekran afiş açılıyor...');
        try {
          final prefs = await SharedPreferences.getInstance();
          final userLat = prefs.getDouble('last_latitude');
          final userLon = prefs.getDouble('last_longitude');
          double distance = 0;
          if (userLat != null && userLon != null) {
            distance = _calculateDistance(
                userLat, userLon, earthquakeLat, earthquakeLon);
          }
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
      } else {
        print('📲 Ekran açık, sadece bildirim gönderiliyor...');
        await notificationService.showNotification(
          title: 'Deprem Algılandı!',
          body: 'M$magnitude - $location',
        );
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
    _subscription?.cancel();
    _listening = false;
  }

  @override
  void onNotificationPressed() {
    FlutterForegroundTask.launchApp(); // ...existing code...
  }
}
