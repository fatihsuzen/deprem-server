import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:firebase_core/firebase_core.dart';
import 'notification_service.dart';

@pragma('vm:entry-point')
Future<void> firebaseMessagingBackgroundHandler(RemoteMessage message) async {
  await Firebase.initializeApp();
  print('🔥 BACKGROUND FCM MESSAGE: ${message.data}');
  if (message.data['type'] == 'earthquake_alert') {
    final magnitude = double.tryParse(message.data['magnitude'] ?? '0') ?? 0.0;
    final location = message.data['location'] ?? 'Bilinmeyen';
    final distance = double.tryParse(message.data['distance'] ?? '0') ?? 0.0;
    // Deprem merkezi koordinatları
    final epicenterLat = double.tryParse(message.data['epicenter_lat'] ?? '');
    final epicenterLon = double.tryParse(message.data['epicenter_lon'] ?? '');
    print('📍 Background FCM Epicenter: lat=$epicenterLat, lon=$epicenterLon');
    
    final notificationService = NotificationService();
    await notificationService.showFullScreenEarthquakeAlert(
      magnitude: magnitude,
      location: location,
      distance: distance,
      source: message.data['source'] ?? 'FCM',
      earthquakeLat: epicenterLat,
      earthquakeLon: epicenterLon,
    );
  }
}

// FCM servisi devre dışı
// class FCMService {
//   static final FCMService _instance = FCMService._internal();
//   factory FCMService() => _instance;
//   FCMService._internal();
//   final FirebaseMessaging _firebaseMessaging = FirebaseMessaging.instance;
//   String? _fcmToken;
//   String? get fcmToken => _fcmToken;
//   Future<void> initialize(String userId) async {}
//   void _handleForegroundMessage(RemoteMessage message) {}
//   void _handleMessageOpenedApp(RemoteMessage message) {}
//   Future<void> _sendTokenToServer(String token) async {}
//   Future<void> subscribeToEarthquakeAlerts() async {}
// }

//  // Topic'ten unsubscribe
//  Future<void> unsubscribeFromEarthquakeAlerts() async {
//    await _firebaseMessaging.unsubscribeFromTopic('earthquake_alerts');
//    print('❌ Deprem uyarıları topic\'inden unsubscribe olundu');
//  }
//}
