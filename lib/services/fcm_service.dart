
// FCM altyapısı devre dışı
// BACKGROUND MESSAGE HANDLER - Uygulama kapalıyken çalışır
// @pragma('vm:entry-point')
// Future<void> firebaseMessagingBackgroundHandler(RemoteMessage message) async {
//   await Firebase.initializeApp();
//   print('🔥 BACKGROUND FCM MESSAGE: 
//   Data: 
//   // Deprem verisi varsa işle
//   if (message.data.containsKey('type') &&
//       message.data['type'] == 'earthquake') {
//     final magnitude = double.tryParse(message.data['magnitude'] ?? '0') ?? 0.0;
//     final location = message.data['location'] ?? 'Bilinmeyen';
//     final distance = double.tryParse(message.data['distance'] ?? '0') ?? 0.0;
//     print('🚨 DEPREM ALARMI (Background): M$magnitude - $location');
//     // Tam ekran bildirim göster
//     final notificationService = NotificationService();
//     await notificationService.showFullScreenEarthquakeAlert(
//       magnitude: magnitude,
//       location: location,
//       distance: distance,
//       source: message.data['source'] ?? 'FCM',
//     );
//   }
// }

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
