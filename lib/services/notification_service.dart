import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'dart:math';
import '../main.dart';
import 'user_preferences_service.dart';
import '../screens/earthquake_alert_screen.dart';
import '../screens/earthquake_info_screen.dart';
import 'package:flutter/services.dart';

class NativeAlertService {
  static const platform = MethodChannel('deprem_app/alert_activity');

  static Future<void> showNativeEarthquakeAlertActivity({
    required double magnitude,
    required String location,
    required double distance,
  }) async {
    try {
      await platform.invokeMethod('showEarthquakeAlertActivity', {
        'magnitude': magnitude,
        'location': location,
        'distance': distance,
      });
    } catch (e) {
      print('Native alert error: $e');
    }
  }
}

class WakeLockService {
  static const platform = MethodChannel('deprem_app/wake_lock');

  static Future<void> wakeUpScreen() async {
    try {
      await platform.invokeMethod('wakeUpScreen');
    } catch (e) {
      print('WakeLock error: $e');
    }
  }
}

class NotificationService {
  Future<void> showNotification(
      {required String title, required String body}) async {
    const AndroidNotificationDetails androidDetails =
        AndroidNotificationDetails(
      'deprem_channel',
      'Deprem Bildirimleri',
      channelDescription: 'Deprem algılandığında bildirim gönderir',
      importance: Importance.max,
      priority: Priority.high,
      ticker: 'ticker',
    );
    const NotificationDetails platformDetails =
        NotificationDetails(android: androidDetails);
    await _flutterLocalNotificationsPlugin.show(
      0,
      title,
      body,
      platformDetails,
    );
  }

  static final NotificationService _instance = NotificationService._internal();
  factory NotificationService() => _instance;
  NotificationService._internal();

  final FlutterLocalNotificationsPlugin _flutterLocalNotificationsPlugin =
      FlutterLocalNotificationsPlugin();
  final UserPreferencesService _prefsService = UserPreferencesService();

  Future<void> initialize() async {
    print('NotificationService başlatılıyor...');

    // Android ayarları - özel bildirim ikonu kullan
    const AndroidInitializationSettings androidSettings =
        AndroidInitializationSettings('@drawable/ic_notification');

    // Genel ayarlar
    const InitializationSettings initSettings = InitializationSettings(
      android: androidSettings,
    );

    bool? initialized = await _flutterLocalNotificationsPlugin.initialize(
      initSettings,
      onDidReceiveNotificationResponse: (NotificationResponse response) {
        print('Bildirime tıklandı: ${response.payload}');
        _handleNotificationTap(response);
      },
    );

    print('Notification plugin initialized: $initialized');

    // Android için bildirim kanalı oluştur
    await _createNotificationChannels();

    // İzin kontrolü ve isteme
    await _requestPermissions();
    print('NotificationService başlatıldı!');
  }

  Future<void> _createNotificationChannels() async {
    const AndroidNotificationChannel testChannel = AndroidNotificationChannel(
      'test_channel',
      'Test Kanalı',
      description: 'Test bildirimleri için kanal',
      importance: Importance.high,
      playSound: true,
      enableVibration: true,
      showBadge: true,
    );

    const AndroidNotificationChannel earthquakeChannel =
        AndroidNotificationChannel(
      'earthquake_alerts',
      'Deprem Uyarıları',
      description: 'Acil deprem bildirimleri',
      importance: Importance.max,
      playSound: true,
      enableVibration: true,
      showBadge: true,
      enableLights: true,
      ledColor: Color(0xFFD32F2F),
    );

    await _flutterLocalNotificationsPlugin
        .resolvePlatformSpecificImplementation<
            AndroidFlutterLocalNotificationsPlugin>()
        ?.createNotificationChannel(testChannel);

    await _flutterLocalNotificationsPlugin
        .resolvePlatformSpecificImplementation<
            AndroidFlutterLocalNotificationsPlugin>()
        ?.createNotificationChannel(earthquakeChannel);

    print('Bildirim kanalları oluşturuldu');
  }

  void _handleNotificationTap(NotificationResponse response) {
    print('🔔 Bildirim yanıtı işleniyor: ${response.payload}');

    // Deprem bildirimine tıklandığında bilgi ekranı aç
    if (response.payload != null &&
        response.payload!.startsWith('earthquake_alert|')) {
      final parts = response.payload!.split('|');
      print('🔔 Payload parts: $parts (count: ${parts.length})');

      if (parts.length >= 4) {
        final magnitude = double.tryParse(parts[1]) ?? 0.0;
        final location = parts[2];
        final distance = double.tryParse(parts[3]) ?? 0.0;
        // Epicenter koordinatları (parts[4] ve parts[5])
        final epicenterLat =
            parts.length > 4 ? double.tryParse(parts[4]) : null;
        final epicenterLon =
            parts.length > 5 ? double.tryParse(parts[5]) : null;
        // Source parametresi (parts[6]) - P2P, AFAD, Kandilli, USGS, EMSC vb.
        final source = parts.length > 6 ? parts[6] : 'AFAD';
        // Depth parametresi (parts[7])
        final depth = parts.length > 7 ? double.tryParse(parts[7]) : null;
        final isP2P = source == 'P2P';

        print('🔔 Parsed data:');
        print('   magnitude: $magnitude (raw: ${parts[1]})');
        print('   location: $location');
        print('   distance: $distance');
        print(
            '   epicenterLat: $epicenterLat (raw: ${parts.length > 4 ? parts[4] : "N/A"})');
        print(
            '   epicenterLon: $epicenterLon (raw: ${parts.length > 5 ? parts[5] : "N/A"})');
        print(
            '   source: $source (raw: ${parts.length > 6 ? parts[6] : "N/A"})');
        print('   depth: $depth (raw: ${parts.length > 7 ? parts[7] : "N/A"})');
        print('   isP2P: $isP2P');
        print('   location: $location');
        print('   distance: $distance (raw: ${parts[3]})');
        print('   epicenterLat: $epicenterLat, epicenterLon: $epicenterLon');
        print('   source: $source, isP2P: $isP2P');

        if (isP2P) {
          // P2P deprem - Sismik dalgalı animasyon ekranı
          print('🔔 P2P deprem tespit edildi, sismik dalgalı ekran açılıyor');
          showAlertScreen(
            magnitude,
            location,
            distance,
            source,
            epicenterLat: epicenterLat,
            epicenterLon: epicenterLon,
          );
        } else {
          // Normal deprem - Sakin bilgi ekranı
          print('🔔 Normal deprem tespit edildi, bilgi ekranı açılıyor');
          showInfoScreen(
            magnitude,
            location,
            distance,
            source,
            epicenterLat: epicenterLat,
            epicenterLon: epicenterLon,
            depth: depth,
          );
        }
      }
    } else {
      // Normal bildirimde ana ekrana yönlendir
      navigatorKey.currentState?.pushNamedAndRemoveUntil('/', (route) => false);
    }
  }

  Future<void> _requestPermissions() async {
    print('İzinler kontrol ediliyor...');

    final androidImplementation =
        _flutterLocalNotificationsPlugin.resolvePlatformSpecificImplementation<
            AndroidFlutterLocalNotificationsPlugin>();

    if (androidImplementation != null) {
      // İlk önce mevcut durumu kontrol et
      bool? enabled = await androidImplementation.areNotificationsEnabled();
      print('Mevcut bildirim durumu: $enabled');

      if (enabled != true) {
        print('🔔 Bildirim izni isteniyor...');

        try {
          final bool? granted =
              await androidImplementation.requestNotificationsPermission();
          print('Android bildirim izni sonucu: $granted');

          if (granted == true) {
            print('✅ Bildirim izni verildi');
          } else if (granted == false) {
            print('❌ Bildirim izni reddedildi');
            await _showPermissionDialog();
          } else {
            print('⚠️ Bildirim izni belirsiz durumda');
          }
        } catch (e) {
          print('⚠️ Bildirim izni hatası: $e');
          // Fallback - kullanıcıyı manuel ayarlara yönlendir
          await _showPermissionDialog();
        }
      } else {
        print('✅ Bildirim izinleri zaten verilmiş');
      }

      // Exact alarms permission (Android 12+) kaldırıldı. Artık istenmiyor.
    } else {
      print('❌ Android implementation bulunamadı');
    }
  }

  // Kullanıcıya izin dialogu göster
  Future<void> _showPermissionDialog() async {
    if (navigatorKey.currentContext != null) {
      showDialog(
        context: navigatorKey.currentContext!,
        barrierDismissible: false,
        builder: (BuildContext context) {
          return AlertDialog(
            title: Row(
              children: [
                Icon(Icons.notifications_off, color: Colors.orange),
                SizedBox(width: 8),
                Expanded(child: Text('Bildirim İzni Gerekli')),
              ],
            ),
            content: Column(
              mainAxisSize: MainAxisSize.min,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text('🚨 Deprem uyarıları için bildirim izni gerekli.'),
                SizedBox(height: 12),
                Text('📱 Manuel izin verme:'),
                SizedBox(height: 4),
                Text(
                  'Ayarlar → Uygulamalar → Deprem App → Bildirimler → İzin Ver',
                  style: TextStyle(fontSize: 12, color: Colors.grey[600]),
                ),
              ],
            ),
            actions: [
              TextButton(
                onPressed: () {
                  Navigator.of(context).pop();
                },
                child: Text('Daha Sonra'),
              ),
              ElevatedButton(
                onPressed: () {
                  Navigator.of(context).pop();
                  // Tekrar dene
                  _retryPermissionRequest();
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.blue,
                  foregroundColor: Colors.white,
                ),
                child: Text('Tekrar Dene'),
              ),
            ],
          );
        },
      );
    }
  }

  // İzin isteğini tekrar dene
  Future<void> _retryPermissionRequest() async {
    print('🔄 İzin isteği tekrar deneniyor...');

    final androidImplementation =
        _flutterLocalNotificationsPlugin.resolvePlatformSpecificImplementation<
            AndroidFlutterLocalNotificationsPlugin>();

    if (androidImplementation != null) {
      try {
        final bool? granted =
            await androidImplementation.requestNotificationsPermission();
        print('Retry - Android bildirim izni sonucu: $granted');

        if (granted != true) {
          // Hala izin yoksa, kullanıcıya manuel talimat ver
          _showManualInstructions();
        }
      } catch (e) {
        print('Retry izin hatası: $e');
        _showManualInstructions();
      }
    }
  }

  // Manuel talimatlar göster
  Future<void> _showManualInstructions() async {
    if (navigatorKey.currentContext != null) {
      showDialog(
        context: navigatorKey.currentContext!,
        builder: (BuildContext context) {
          return AlertDialog(
            title: Text('📱 Manuel İzin Verme'),
            content: Column(
              mainAxisSize: MainAxisSize.min,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text('1. Android Ayarlar\'a gidin'),
                Text('2. Uygulamalar\'ı seçin'),
                Text('3. "Deprem App"\'i bulun'),
                Text('4. Bildirimler\'e tıklayın'),
                Text('5. Tüm izinleri açın'),
                SizedBox(height: 8),
                Container(
                  padding: EdgeInsets.all(8),
                  decoration: BoxDecoration(
                    color: Colors.orange.shade50,
                    borderRadius: BorderRadius.circular(8),
                    border: Border.all(color: Colors.orange.shade200),
                  ),
                  child: Text(
                    '⚠️ Bu izin deprem uyarıları için kritik öneme sahiptir!',
                    style:
                        TextStyle(color: Colors.orange.shade800, fontSize: 12),
                  ),
                ),
              ],
            ),
            actions: [
              ElevatedButton(
                onPressed: () => Navigator.of(context).pop(),
                child: Text('Anladım'),
              ),
            ],
          );
        },
      );
    }
  }

  Future<bool> areNotificationsEnabled() async {
    final androidImplementation =
        _flutterLocalNotificationsPlugin.resolvePlatformSpecificImplementation<
            AndroidFlutterLocalNotificationsPlugin>();

    if (androidImplementation != null) {
      final bool? enabled =
          await androidImplementation.areNotificationsEnabled();
      print('🔍 Notification status check: $enabled');
      return enabled ?? false;
    }
    return false;
  }

  // Debug method - izin durumunu kontrol et
  Future<void> checkPermissionStatus() async {
    print('🔧 === NOTIFICATION PERMISSION DEBUG ===');

    final androidImplementation =
        _flutterLocalNotificationsPlugin.resolvePlatformSpecificImplementation<
            AndroidFlutterLocalNotificationsPlugin>();

    if (androidImplementation != null) {
      try {
        final bool? enabled =
            await androidImplementation.areNotificationsEnabled();
        print('📱 Notifications enabled: $enabled');

        if (enabled != true) {
          print('⚠️ Notifications are NOT enabled');
          print('🔧 Attempting to request permission...');

          final bool? result =
              await androidImplementation.requestNotificationsPermission();
          print('📋 Permission request result: $result');
        } else {
          print('✅ Notifications are already enabled');
        }
      } catch (e) {
        print('❌ Permission check error: $e');
      }
    } else {
      print('❌ Android implementation not found');
    }

    print('🔧 === END DEBUG ===');
  }

  Future<void> showEarthquakeNotificationWithReport({
    required String title,
    required String body,
    required double magnitude,
    required String location,
    required String depth,
    double? earthquakeLat,
    double? earthquakeLon,
    double? userLat,
    double? userLon,
  }) async {
    print('Deprem bildirimi kontrol ediliyor: $title');

    // Kullanıcının bildirim ayarlarını al
    final notificationRadius = await _prefsService.getNotificationRadius();
    final soundEnabled = await _prefsService.getNotificationSound();
    final vibrationEnabled = await _prefsService.getVibration();
    final backgroundNotificationsEnabled =
        await _prefsService.getBackgroundNotifications();

    // Arka plan bildirimleri kapalıysa bildirim gönderme
    if (!backgroundNotificationsEnabled) {
      print('❌ Arka plan bildirimleri kapalı, bildirim gönderilmedi');
      return;
    }

    // Eğer deprem ve kullanıcı konumu verilmişse, mesafeyi kontrol et
    if (earthquakeLat != null &&
        earthquakeLon != null &&
        userLat != null &&
        userLon != null) {
      final distance =
          _calculateDistance(userLat, userLon, earthquakeLat, earthquakeLon);

      print(
          'Deprem mesafesi: ${distance.toStringAsFixed(1)} km (limit: ${notificationRadius.toInt()} km)');

      // Eğer deprem belirlenen yarıçap dışındaysa, bildirim gönderme
      if (distance > notificationRadius) {
        print('❌ Deprem yarıçap dışında, bildirim gönderilmedi');
        return;
      }

      print('✅ Deprem yarıçap içinde, bildirim gönderiliyor');
    }

    print(
        '📢 Bildirim ayarları - Ses: $soundEnabled, Titreşim: $vibrationEnabled');

    // Kritik deprem bildirimi - rapor istemiyle
    final AndroidNotificationDetails androidDetails =
        AndroidNotificationDetails(
      'earthquake_alerts',
      'Deprem Uyarıları',
      channelDescription: 'Acil deprem bildirimleri',
      importance: Importance.max,
      priority: Priority.high,
      playSound: soundEnabled,
      enableVibration: vibrationEnabled,
      autoCancel: false,
      ongoing: false,
      showWhen: true,
      color: Color(0xFFD32F2F),
      colorized: true,
      ticker: '🚨 DEPREM UYARISI!',
      actions: <AndroidNotificationAction>[
        AndroidNotificationAction(
          'report_action',
          'RAPOR ET',
          icon: DrawableResourceAndroidBitmap('@drawable/ic_notification'),
          showsUserInterface: true,
        ),
      ],
    );

    final NotificationDetails details = NotificationDetails(
      android: androidDetails,
    );

    try {
      final int notificationId =
          DateTime.now().millisecondsSinceEpoch.remainder(100000);
      print('Deprem bildirim ID: $notificationId');

      await _flutterLocalNotificationsPlugin.show(
        notificationId,
        title,
        '$body\n\nDepremi hissettiyseniz rapor edin!',
        details,
        payload: 'earthquake_report_request',
      );

      print('Deprem bildirimi rapor istemiyle gönderildi!');
    } catch (e) {
      print('Deprem bildirimi gönderilirken hata: $e');
    }
  }

  // Basit deprem bildirimi (eski versiyon)
  Future<void> showEarthquakeNotification({
    required String title,
    required String body,
    required double magnitude,
    required String location,
    required String depth,
  }) async {
    await showEarthquakeNotificationWithReport(
      title: title,
      body: body,
      magnitude: magnitude,
      location: location,
      depth: depth,
    );
  }

  // Mesafe hesaplama (Haversine formülü)
  double _calculateDistance(
      double lat1, double lon1, double lat2, double lon2) {
    const double earthRadius = 6371; // km

    final dLat = _toRadians(lat2 - lat1);
    final dLon = _toRadians(lon2 - lon1);

    final a = (sin(dLat / 2) * sin(dLat / 2)) +
        cos(_toRadians(lat1)) *
            cos(_toRadians(lat2)) *
            (sin(dLon / 2) * sin(dLon / 2));

    final c = 2 * asin(sqrt(a));

    return earthRadius * c;
  }

  double _toRadians(double degrees) {
    return degrees * (pi / 180);
  }

  // TAM EKRAN DEPREM UYARISI - Ekran kapalıyken bile gösterilir
  Future<void> showFullScreenEarthquakeAlert({
    required double magnitude,
    required String location,
    required double distance,
    String source = 'AFAD',
    double? earthquakeLat,
    double? earthquakeLon,
    double? userLat,
    double? userLon,
    double? depth,
    bool isP2P = false,
  }) async {
    print('🚨 TAM EKRAN DEPREM UYARISI: M$magnitude - $location');
    print('📍 Epicenter: lat=$earthquakeLat, lon=$earthquakeLon, depth=$depth');
    print('🔍 Deprem tipi: ${isP2P ? "P2P" : "Normal"} - Kaynak: $source');

    // SADECE P2P depremler için telefonu uyandır ve bildirim göster
    if (isP2P) {
      print('⚠️ P2P DEPREMI - Telefon uyandırılıyor ve bildirim gösteriliyor');
      await showWakeUpNotification(
        magnitude,
        location,
        distance,
        epicenterLat: earthquakeLat,
        epicenterLon: earthquakeLon,
        depth: depth,
        isP2P: isP2P,
        source: source,
      );
    } else {
      print(
          'ℹ️ Normal deprem - FCM notification yeterli, ekstra bildirim gösterilmiyor');
    }

    // Native tam ekran alerti sadece P2P depremlerde çağır
    if (isP2P) {
      await NativeAlertService.showNativeEarthquakeAlertActivity(
        magnitude: magnitude,
        location: location,
        distance: distance,
      );
    }

    // Eğer uygulama açıksa ekranı aç
    if (navigatorKey.currentContext != null) {
      if (isP2P) {
        // P2P - Sismik dalgalı animasyon ekranı
        print('✅ P2P deprem - Sismik dalgalı ekran açılıyor');
        showAlertScreen(
          magnitude,
          location,
          distance,
          source,
          epicenterLat: earthquakeLat,
          epicenterLon: earthquakeLon,
        );
      } else {
        // Normal deprem - Bilgi ekranı
        print('✅ Normal deprem - Bilgi ekranı açılıyor');
        showInfoScreen(
          magnitude,
          location,
          distance,
          source,
          epicenterLat: earthquakeLat,
          epicenterLon: earthquakeLon,
          depth: depth,
        );
      }
    } else {
      print('ℹ️ Uygulama arka planda, sadece bildirim gösterildi');
    }
  }

  // Ekranı uyandıran bildirim
  Future<void> showWakeUpNotification(
    double magnitude,
    String location,
    double distance, {
    double? epicenterLat,
    double? epicenterLon,
    double? depth,
    bool isP2P = false,
    String source = 'AFAD',
  }) async {
    final AndroidNotificationDetails androidDetails =
        AndroidNotificationDetails(
      'earthquake_alerts',
      'Deprem Uyarıları',
      channelDescription: 'Acil deprem bildirimleri',
      importance: Importance.max,
      priority: Priority.max,
      playSound: true,
      enableVibration: true,
      fullScreenIntent: true, // TAM EKRAN AÇMA
      autoCancel: true, // Bildirime tıklandığında otomatik silinsin
      ongoing: false, // Kalıcı bildirim olmasın, kullanıcı silebilsin
      category: AndroidNotificationCategory.alarm,
      visibility: NotificationVisibility.public,
      color: const Color(0xFFD32F2F),
      colorized: true,
      ticker: '🚨 DEPREM UYARISI!',
      styleInformation: BigTextStyleInformation(
        'Büyüklük: M${magnitude.toStringAsFixed(1)}\nUzaklık: ${distance.toStringAsFixed(1)} km\nKonum: $location\n\nGÜVENLİ BİR YERE GEÇİN!',
        htmlFormatBigText: true,
        contentTitle: '🚨 DEPREM ALGILANDI!',
        htmlFormatContentTitle: true,
      ),
    );
    final NotificationDetails details =
        NotificationDetails(android: androidDetails);
    try {
      double? lat = epicenterLat;
      double? lon = epicenterLon;
      // Eğer epicenterLat/Lon boşsa, location string'inden doldur
      if ((lat == null || lon == null || lat.isNaN || lon.isNaN) &&
          location.contains(',')) {
        final locParts = location.split(',');
        if (locParts.length == 2) {
          try {
            lat = double.parse(locParts[0].trim());
            lon = double.parse(locParts[1].trim());
          } catch (e) {
            print('❌ Location string parse hatası (bildirim): $e');
          }
        }
      }
      // Payload'a epicenter koordinatlarını ve kaynak bilgisini ekle
      // Not: source parametresi çağıran taraftan geliyor (P2P, AFAD, Kandilli, USGS, EMSC vb.)
      // isP2P sadece ekran tipini belirlemek için kullanılıyor
      final payload =
          'earthquake_alert|$magnitude|$location|$distance|${lat ?? ""}|${lon ?? ""}|$source|${depth ?? ""}';

      print('📦 Notification payload created: $payload');
      print('   depth value: $depth (${depth == null ? "NULL" : "VALID"})');

      // P2P bildirimleri için benzersiz ID, normal depremler için sabit ID
      final notificationId =
          isP2P ? DateTime.now().millisecondsSinceEpoch.remainder(100000) : 0;

      await _flutterLocalNotificationsPlugin.show(
        notificationId,
        '🚨 DEPREM ALGILANDI!',
        'M$magnitude - ${distance.toStringAsFixed(1)} km uzakta',
        details,
        payload: payload,
      );

      print(
          '✅ Uyandırma bildirimi gönderildi! (ID: $notificationId, isP2P: $isP2P)');
    } catch (e) {
      print('❌ Uyandırma bildirimi hatası: $e');
    }
  }

  // Tam ekran alert göster (sismik dalga animasyonlu - acil durumlar için)
  void showAlertScreen(
    double magnitude,
    String location,
    double distance,
    String source, {
    double? epicenterLat,
    double? epicenterLon,
  }) {
    if (navigatorKey.currentContext == null) {
      print('❌ Navigator context yok, tam ekran gösterilemiyor');
      return;
    }

    print(
        '✅ Tam ekran alert gösteriliyor (epicenter: $epicenterLat, $epicenterLon)');

    Navigator.of(navigatorKey.currentContext!).push(
      MaterialPageRoute(
        builder: (context) => EarthquakeAlertScreen(
          magnitude: magnitude,
          location: location,
          distance: distance,
          timestamp: DateTime.now(),
          source: source,
          epicenterLat: epicenterLat,
          epicenterLon: epicenterLon,
        ),
        fullscreenDialog: true,
      ),
    );
  }

  // Sakin deprem bilgi ekranı (bildirime tıklandığında)
  void showInfoScreen(
    double magnitude,
    String location,
    double distance,
    String source, {
    double? epicenterLat,
    double? epicenterLon,
    double? depth,
  }) {
    if (navigatorKey.currentContext == null) {
      print('❌ Navigator context yok, bilgi ekranı gösterilemiyor');
      return;
    }

    print(
        '✅ Deprem bilgi ekranı gösteriliyor (epicenter: $epicenterLat, $epicenterLon, depth: $depth)');

    Navigator.of(navigatorKey.currentContext!).push(
      MaterialPageRoute(
        builder: (context) => EarthquakeInfoScreen(
          magnitude: magnitude,
          location: location,
          distance: distance,
          timestamp: DateTime.now(),
          source: source,
          epicenterLat: epicenterLat,
          epicenterLon: epicenterLon,
          depth: depth,
        ),
      ),
    );
  }

  // Basit test bildirimi
  Future<void> showTestNotification() async {
    print('Test bildirimi gönderiliyor...');

    const AndroidNotificationDetails androidDetails =
        AndroidNotificationDetails(
      'test_channel',
      'Test Kanalı',
      channelDescription: 'Test bildirimleri',
      importance: Importance.high,
      priority: Priority.high,
      playSound: true,
      enableVibration: true,
      ticker: 'Test Bildirimi',
    );

    const NotificationDetails details = NotificationDetails(
      android: androidDetails,
    );

    try {
      await _flutterLocalNotificationsPlugin.show(
        999,
        'Test Bildirimi',
        'Bu bir test bildirimi. Sistem bildirimleri çalışıyor!',
        details,
        payload: 'test',
      );
      print('Test bildirimi gönderildi!');
    } catch (e) {
      print('Test bildirimi hatası: $e');
    }
  }

  // Test deprem bildirimi - Info ekranını test etmek için
  Future<void> showTestEarthquakeNotification() async {
    print('🧪 Test deprem bildirimi gönderiliyor...');

    const AndroidNotificationDetails androidDetails =
        AndroidNotificationDetails(
      'earthquake_channel',
      'Deprem Uyarıları',
      channelDescription: 'Test deprem bildirimi',
      importance: Importance.high,
      priority: Priority.high,
      playSound: true,
      enableVibration: true,
      ticker: 'Test Deprem',
    );

    const NotificationDetails details = NotificationDetails(
      android: androidDetails,
    );

    // Test verileri
    const double magnitude = 5.2;
    const String location = 'İstanbul - Test Bölgesi';
    const double distance = 45.5;
    const double epicenterLat = 40.9;
    const double epicenterLon = 29.0;

    final payload =
        'earthquake_alert|$magnitude|$location|$distance|$epicenterLat|$epicenterLon';

    try {
      await _flutterLocalNotificationsPlugin.show(
        998,
        '🧪 TEST: DEPREM ALGILANDI!',
        'M$magnitude - ${distance.toStringAsFixed(1)} km uzakta - $location',
        details,
        payload: payload,
      );
      print('✅ Test deprem bildirimi gönderildi! Payload: $payload');
    } catch (e) {
      print('❌ Test deprem bildirimi hatası: $e');
    }
  }

  // Gelecekte kullanım için
  Future<void> cancelAllNotifications() async {
    await _flutterLocalNotificationsPlugin.cancelAll();
  }

  Future<void> cancelNotification(int id) async {
    await _flutterLocalNotificationsPlugin.cancel(id);
  }
}
