import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:shared_preferences/shared_preferences.dart';
import 'notification_service.dart';

// BACKGROUND MESSAGE HANDLER - Uygulama kapalıyken çalışır
@pragma('vm:entry-point')
Future<void> firebaseMessagingBackgroundHandler(RemoteMessage message) async {
  await Firebase.initializeApp();
  print('🔥 BACKGROUND FCM MESSAGE: ${message.messageId}');
  print('   Data: ${message.data}');
  
  // Deprem verisi varsa işle
  if (message.data.containsKey('type') && message.data['type'] == 'earthquake') {
    final magnitude = double.tryParse(message.data['magnitude'] ?? '0') ?? 0.0;
    final location = message.data['location'] ?? 'Bilinmeyen';
    final distance = double.tryParse(message.data['distance'] ?? '0') ?? 0.0;
    
    print('🚨 DEPREM ALARMI (Background): M$magnitude - $location');
    
    // Tam ekran bildirim göster
    final notificationService = NotificationService();
    await notificationService.showFullScreenEarthquakeAlert(
      magnitude: magnitude,
      location: location,
      distance: distance,
      source: message.data['source'] ?? 'FCM',
    );
  }
}

class FCMService {
  static final FCMService _instance = FCMService._internal();
  factory FCMService() => _instance;
  FCMService._internal();

  final FirebaseMessaging _firebaseMessaging = FirebaseMessaging.instance;
  String? _fcmToken;

  // FCM Token
  String? get fcmToken => _fcmToken;

  // Initialize FCM
  Future<void> initialize() async {
    print('🔥 FCM Service başlatılıyor...');

    // İzin iste (iOS ve Android 13+)
    NotificationSettings settings = await _firebaseMessaging.requestPermission(
      alert: true,
      announcement: false,
      badge: true,
      carPlay: false,
      criticalAlert: true,
      provisional: false,
      sound: true,
    );

    print('📱 Bildirim izni: ${settings.authorizationStatus}');

    if (settings.authorizationStatus == AuthorizationStatus.authorized) {
      print('✅ Bildirim izni verildi');
      
      // FCM Token al
      _fcmToken = await _firebaseMessaging.getToken();
      print('🔑 FCM Token: $_fcmToken');
      
      // Token'ı SharedPreferences'a kaydet
      final prefs = await SharedPreferences.getInstance();
      if (_fcmToken != null) {
        await prefs.setString('fcm_token', _fcmToken!);
        
        // Server'a gönder
        await _sendTokenToServer(_fcmToken!);
      }

      // Token yenilendiğinde
      _firebaseMessaging.onTokenRefresh.listen((newToken) {
        print('🔄 FCM Token yenilendi: $newToken');
        _fcmToken = newToken;
        prefs.setString('fcm_token', newToken);
        _sendTokenToServer(newToken);
      });

      // Foreground mesaj handler
      FirebaseMessaging.onMessage.listen(_handleForegroundMessage);

      // Bildirime tıklandığında (uygulama açık)
      FirebaseMessaging.onMessageOpenedApp.listen(_handleMessageOpenedApp);

      // Uygulama kapalıyken gelen bildirimleri kontrol et
      RemoteMessage? initialMessage = await _firebaseMessaging.getInitialMessage();
      if (initialMessage != null) {
        print('📲 Uygulama bildirimden açıldı');
        _handleMessageOpenedApp(initialMessage);
      }

      print('✅ FCM Service başlatıldı');
    } else {
      print('❌ Bildirim izni verilmedi');
    }
  }

  // Foreground mesaj (uygulama açık)
  void _handleForegroundMessage(RemoteMessage message) {
    print('🔥 FOREGROUND FCM MESSAGE: ${message.messageId}');
    print('   Title: ${message.notification?.title}');
    print('   Body: ${message.notification?.body}');
    print('   Data: ${message.data}');

    // Deprem verisi varsa işle
    if (message.data.containsKey('type') && message.data['type'] == 'earthquake') {
      final magnitude = double.tryParse(message.data['magnitude'] ?? '0') ?? 0.0;
      final location = message.data['location'] ?? 'Bilinmeyen';
      final distance = double.tryParse(message.data['distance'] ?? '0') ?? 0.0;
      
      print('🚨 DEPREM ALARMI (Foreground): M$magnitude - $location');
      
      // Tam ekran bildirim göster
      final notificationService = NotificationService();
      notificationService.showFullScreenEarthquakeAlert(
        magnitude: magnitude,
        location: location,
        distance: distance,
        source: message.data['source'] ?? 'FCM',
      );
    }
  }

  // Bildirime tıklandığında
  void _handleMessageOpenedApp(RemoteMessage message) {
    print('📱 Bildirime tıklandı: ${message.messageId}');
    print('   Data: ${message.data}');
    
    // Deprem detay sayfasına yönlendir (opsiyonel)
    // navigatorKey.currentState?.pushNamed('/earthquake-detail', arguments: message.data);
  }

  // FCM Token'ı server'a gönder
  Future<void> _sendTokenToServer(String token) async {
    try {
      final prefs = await SharedPreferences.getInstance();
      final userId = prefs.getString('user_id');
      
      if (userId == null) {
        print('⚠️  User ID yok, token gönderilemedi');
        return;
      }

      final response = await http.post(
        Uri.parse('http://188.132.202.24:3000/api/fcm/register'),
        headers: {'Content-Type': 'application/json'},
        body: json.encode({
          'userId': userId,
          'fcmToken': token,
          'platform': 'android',
        }),
      );

      if (response.statusCode == 200) {
        print('✅ FCM Token server\'a gönderildi');
      } else {
        print('❌ Token gönderme hatası: ${response.statusCode}');
      }
    } catch (e) {
      print('❌ Token gönderme hatası: $e');
    }
  }

  // Tüm topic'lere subscribe
  Future<void> subscribeToEarthquakeAlerts() async {
    await _firebaseMessaging.subscribeToTopic('earthquake_alerts');
    print('✅ Deprem uyarıları topic\'ine subscribe olundu');
  }

  // Topic'ten unsubscribe
  Future<void> unsubscribeFromEarthquakeAlerts() async {
    await _firebaseMessaging.unsubscribeFromTopic('earthquake_alerts');
    print('❌ Deprem uyarıları topic\'inden unsubscribe olundu');
  }
}
