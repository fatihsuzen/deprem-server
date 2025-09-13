import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../main.dart';

class NotificationService {
  static final NotificationService _instance = NotificationService._internal();
  factory NotificationService() => _instance;
  NotificationService._internal();

  final FlutterLocalNotificationsPlugin _flutterLocalNotificationsPlugin =
      FlutterLocalNotificationsPlugin();

  Future<void> initialize() async {
    print('NotificationService başlatılıyor...');

    // Android ayarları - daha basit yaklaşım
    const AndroidInitializationSettings androidSettings =
        AndroidInitializationSettings('@mipmap/ic_launcher');

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
    print('Bildirim yanıtı işleniyor: ${response.payload}');
    // Bu işlem şimdilik basit log olarak kalacak
    // Navigator işlemleri daha sonra eklenecek
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

      // Exact alarms permission (Android 12+) - optional ve bir kez iste
      try {
        final prefs = await SharedPreferences.getInstance();
        final exactAlarmsRequested =
            prefs.getBool('exact_alarms_requested') ?? false;

        if (!exactAlarmsRequested) {
          await androidImplementation.requestExactAlarmsPermission();
          await prefs.setBool('exact_alarms_requested', true);
          print('✅ Exact alarms izni istendi (ilk kez)');
        } else {
          print('ℹ️ Exact alarms izni daha önce istendi');
        }
      } catch (e) {
        print('! Exact alarms izni hatası: $e');
      }
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
  }) async {
    print('Deprem bildirimi gönderiliyor: $title');

    // Kritik deprem bildirimi - rapor istemiyle
    const AndroidNotificationDetails androidDetails =
        AndroidNotificationDetails(
      'earthquake_alerts',
      'Deprem Uyarıları',
      channelDescription: 'Acil deprem bildirimleri',
      importance: Importance.max,
      priority: Priority.high,
      playSound: true,
      enableVibration: true,
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
          icon: DrawableResourceAndroidBitmap('@mipmap/ic_launcher'),
          showsUserInterface: true,
        ),
      ],
    );

    const NotificationDetails details = NotificationDetails(
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

  // Gelecekte kullanım için
  Future<void> cancelAllNotifications() async {
    await _flutterLocalNotificationsPlugin.cancelAll();
  }

  Future<void> cancelNotification(int id) async {
    await _flutterLocalNotificationsPlugin.cancel(id);
  }
}
