import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:firebase_core/firebase_core.dart';
import 'notification_service.dart';
import '../firebase_options.dart';

@pragma('vm:entry-point')
Future<void> firebaseMessagingBackgroundHandler(RemoteMessage message) async {
  // Arka plan izolatında Firebase'i yalnızca başlatılmamışsa başlat
  try {
    if (Firebase.apps.isEmpty) {
      await Firebase.initializeApp(
        options: DefaultFirebaseOptions.currentPlatform,
      );
    }
  } catch (e) {
    if (e.toString().contains('A Firebase App named')) {
      // Duplicate app hatasını yut
    } else {
      rethrow;
    }
  }
  print('🔥 BACKGROUND FCM MESSAGE: ${message.data}');
  if (message.data['type'] == 'earthquake_alert') {
    final magnitude = double.tryParse(message.data['magnitude'] ?? '0') ?? 0.0;
    final location = message.data['location'] ?? 'Bilinmeyen';
    final distance = double.tryParse(message.data['distance'] ?? '0') ?? 0.0;
    // Deprem merkezi koordinatları - earthquakeLat/Lon veya epicenter_lat/lon
    final epicenterLat = double.tryParse(message.data['epicenter_lat'] ?? '') ??
        double.tryParse(message.data['earthquakeLat'] ?? '');
    final epicenterLon = double.tryParse(message.data['epicenter_lon'] ?? '') ??
        double.tryParse(message.data['earthquakeLon'] ?? '');
    print('📍 Background FCM Epicenter: lat=$epicenterLat, lon=$epicenterLon');

    // P2P deprem mi kontrol et
    final isP2P = message.data['p2p_circle'] == 'true';
    // Gerçek kaynağı al (AFAD, Kandilli, USGS, EMSC, P2P vb.)
    final source = message.data['source'] ?? (isP2P ? 'P2P' : 'AFAD');
    print('🔍 Background FCM Deprem tipi: ${isP2P ? "P2P" : "Normal"} - Kaynak: $source');

    final notificationService = NotificationService();
    await notificationService.showFullScreenEarthquakeAlert(
      magnitude: magnitude,
      location: location,
      distance: distance,
      source: source,
      earthquakeLat: epicenterLat,
      earthquakeLon: epicenterLon,
      isP2P: isP2P,
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
