import 'services/fcm_service.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:onesignal_flutter/onesignal_flutter.dart';
// ...existing code...
import 'screens/splash_screen.dart';
import 'screens/root.dart';
import 'screens/login_screen.dart';
import 'screens/mqtt_test_screen.dart';
import 'screens/report_screen.dart';
import 'screens/earthquake_alarm_screen.dart';
import 'services/auth_service.dart';
import 'services/location_service.dart';
import 'services/notification_service.dart';
import 'services/location_update_service.dart';
import 'services/user_preferences_service.dart';
import 'services/earthquake_background_service.dart';
import 'firebase_options.dart';
import 'package:firebase_core/firebase_core.dart';
// ...existing code...
import 'package:firebase_messaging/firebase_messaging.dart';
import 'screens/earthquake_alert_screen.dart';

// Global navigation key
final GlobalKey<NavigatorState> navigatorKey = GlobalKey<NavigatorState>();

// ...existing code...
void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Native deprem alert activity'den gelen parametreyi kontrol et
  final MethodChannel paramsChannel =
      const MethodChannel('deprem_app/earthquake_params');
  final earthquakeParams =
      await paramsChannel.invokeMethod('getEarthquakeParams');
  debugPrint('[DepremApp] main.dart: earthquakeParams = $earthquakeParams');
  if (earthquakeParams == null) {
    debugPrint(
        '[DepremApp] main.dart: earthquakeParams NULL, ana ekran açılacak!');
  } else {
    debugPrint(
        '[DepremApp] main.dart: earthquakeParams mevcut, circle ekran açılacak!');
  }
  // Kullanılmayan değişkenler kaldırıldı
  // MethodChannel handler'ları ekleniyor
  const MethodChannel wakeLockChannel = MethodChannel('deprem_app/wake_lock');
  const MethodChannel alertActivityChannel =
      MethodChannel('deprem_app/alert_activity');

  wakeLockChannel.setMethodCallHandler((call) async {
    if (call.method == 'wakeUpScreen') {
      debugPrint('[DepremApp] Flutter: wakeUpScreen çağrıldı!');
      // Ekranı uyandırmak için native kod tetikleniyor
    }
  });

  alertActivityChannel.setMethodCallHandler((call) async {
    if (call.method == 'showEarthquakeAlertActivity') {
      debugPrint('[DepremApp] Flutter: showEarthquakeAlertActivity çağrıldı!');
      // Native deprem alert activity tetikleniyor
    }
  });
  // Firebase başlat
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );

  // OneSignal başlat
  OneSignal.initialize("37c0591e-7d1c-4754-b65c-1328feafd933");
  OneSignal.Notifications.requestPermission(true);

  // FCM background handler kaydı
  FirebaseMessaging.onBackgroundMessage(firebaseMessagingBackgroundHandler);

  // FCM notification setup
  FirebaseMessaging.onMessage.listen((RemoteMessage message) {
    print(
        '📲 Yeni bildirim: ${message.notification?.title} - ${message.notification?.body}');
    if (message.data['type'] == 'earthquake_alert') {
      final magnitude =
          double.tryParse(message.data['magnitude']?.toString() ?? '') ?? 0.0;
      final distance =
          double.tryParse(message.data['distance']?.toString() ?? '') ?? 0.0;
      final location = message.data['location'] ?? '';
      navigatorKey.currentState?.push(
        MaterialPageRoute(
          builder: (_) => EarthquakeAlertScreen(
            magnitude: magnitude,
            location: location,
            distance: distance,
            timestamp: DateTime.now(),
            source: 'P2P',
          ),
        ),
      );
    }
  });

  // Background service'i initialize et
  EarthquakeBackgroundService.initializeService();

  // Splash screen sırasında tam ekran moduna geç
  await SystemChrome.setEnabledSystemUIMode(SystemUiMode.immersiveSticky);

  // Servis başlatmayı arka plana alıyoruz - uygulama açılırken bekletmeyelim
  _initializeServicesInBackground();

  if (earthquakeParams != null) {
    debugPrint(
        '[DepremApp] main.dart: Circle ekran açılıyor! Parametre: $earthquakeParams');
    debugPrint(
        '[DepremApp] main.dart: EarthquakeAlertScreen navigation başlatıldı!');
    runApp(MaterialApp(
      debugShowCheckedModeBanner: false,
      home: EarthquakeAlertScreen(
        magnitude: (earthquakeParams['magnitude'] as num?)?.toDouble() ?? 0.0,
        location: earthquakeParams['location'] as String? ?? '',
        distance: (earthquakeParams['distance'] as num?)?.toDouble() ?? 0.0,
        timestamp: DateTime.now(),
        source: 'P2P',
      ),
    ));
  } else {
    debugPrint('[DepremApp] main.dart: DepremApp ana ekran başlatıldı!');
    runApp(const DepremApp());
  }
}

// Servisleri arka planda başlat
void _initializeServicesInBackground() async {
  try {
    // Kullanıcı verilerini yükle (Google Sign-In session)
    final authService = AuthService();
    await authService.loadUserData();
    print('✅ User data loaded');

    await NotificationService().initialize();
    print('✅ Notification service initialized');

    final locationService = LocationService();
    await locationService.initialize();
    print('✅ Location service initialized');

    // Konum tracking'i başlat
    await locationService.startLocationTracking();
    print('✅ Location tracking started');

    // Uygulama açılışında konum gönder (sunucuya)
    final locationUpdateService = LocationUpdateService();
    await locationUpdateService.sendLocationOnAppStart();

    // Periyodik konum güncellemelerini başlat (2 saatte bir)
    await locationUpdateService.startPeriodicUpdates();
    print('✅ Location update service started');

    // Kullanıcı ayarlarını sunucuya gönder
    await _syncUserSettings();

    // OneSignal başlatıldı
    print('✅ OneSignal başlatıldı');

    // Background service'i başlat (WebSocket yerine artık FCM kullanılacak)
    // WebSocket sadece gerçek zamanlı harita güncellemeleri için
    print('🚀 Background service başlatılıyor...');
    final backgroundServiceStarted =
        await EarthquakeBackgroundService.startService();
    if (backgroundServiceStarted) {
      print('✅ Background service started');
      print('   NOT: Deprem bildirimleri artık FCM üzerinden gelecek');
    } else {
      print('❌ Background service başlatılamadı!');
    }

    // WebSocket artık sadece harita güncellemeleri için (opsiyonel)

    // P2P Deprem Algılama Sistemini Başlat (opsiyonel - sensör tabanlı)
    // final p2pService = P2PEarthquakeDetectionService();
    // await p2pService.startMonitoring();
    // print('✅ P2P Earthquake Detection started');
  } catch (error) {
    print('❌ Service initialization error: $error');
  }
}

// Kullanıcı ayarlarını sunucuya senkronize et
Future<void> _syncUserSettings() async {
  try {
    final prefsService = UserPreferencesService();
    final settings = await prefsService.getAllSettings();

    final locationUpdateService = LocationUpdateService();
    await locationUpdateService.sendNotificationSettings(
      notificationRadius: settings['notificationRadius'],
      minMagnitude: settings['minMagnitude'],
      maxMagnitude: settings['maxMagnitude'],
    );

    print('✅ User settings synced to server');
  } catch (e) {
    print('⚠️  User settings sync error: $e');
  }
}

class DepremApp extends StatefulWidget {
  const DepremApp({super.key});

  @override
  State<DepremApp> createState() => _DepremAppState();
}

class _DepremAppState extends State<DepremApp> {
  bool isDarkTheme = false;
  bool isLoading = true;

  @override
  void initState() {
    super.initState();
    _loadThemePreference();
  }

  Future<void> _loadThemePreference() async {
    final prefs = await SharedPreferences.getInstance();
    setState(() {
      isDarkTheme = prefs.getBool('isDarkTheme') ?? false;
      isLoading = false;
    });
  }

  @override
  Widget build(BuildContext context) {
    if (isLoading) {
      return MaterialApp(
        home: Scaffold(
          body: Center(
            child: CircularProgressIndicator(color: Color(0xFFFF3A3D)),
          ),
        ),
      );
    }

    return MaterialApp(
      title: 'Deprem Hattı',
      navigatorKey: navigatorKey,
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.light(
          primary: const Color(0xFFFF3A3D),
          secondary: const Color(0xFFFF3A3D),
          surface: Colors.white,
          background: Colors.white,
          error: Colors.red,
          onPrimary: Colors.white,
          onSecondary: Colors.white,
          onSurface: Colors.black,
          onBackground: Colors.black,
          onError: Colors.white,
        ),
        useMaterial3: true,
        primaryColor: const Color(0xFFFF3A3D),
        scaffoldBackgroundColor: Colors.white,
        appBarTheme: const AppBarTheme(
          backgroundColor: Color(0xFFFF3A3D),
          foregroundColor: Colors.white,
          elevation: 0,
          centerTitle: false,
        ),
      ),
      darkTheme: ThemeData(
        colorScheme: ColorScheme.dark(
          primary: const Color(0xFFFF3A3D),
          secondary: const Color(0xFFFF3A3D),
          surface: const Color(0xFF1E1E1E),
          background: const Color(0xFF121212),
          error: Colors.red,
          onPrimary: Colors.white,
          onSecondary: Colors.white,
          onSurface: Colors.white,
          onBackground: Colors.white,
          onError: Colors.white,
        ),
        useMaterial3: true,
        primaryColor: const Color(0xFFFF3A3D),
        scaffoldBackgroundColor: const Color(0xFF121212),
        appBarTheme: const AppBarTheme(
          backgroundColor: Color(0xFFFF3A3D),
          foregroundColor: Colors.white,
          elevation: 0,
          centerTitle: false,
        ),
      ),
      themeMode: isDarkTheme ? ThemeMode.dark : ThemeMode.light,
      initialRoute: '/',
      routes: {
        '/': (ctx) => const SplashScreen(),
        '/login': (ctx) => const LoginScreen(),
        '/home': (ctx) => const RootScreen(),
        '/debug/mqtt': (ctx) => const MqttTestScreen(),
        '/report': (ctx) => const ReportScreen(),
      },
      onGenerateRoute: (settings) {
        // Deprem alarm ekranı - URL parametreleri ile
        if (settings.name?.startsWith('/earthquake-alarm') ?? false) {
          final uri = Uri.parse(settings.name!);
          final magnitude =
              double.tryParse(uri.queryParameters['magnitude'] ?? '0') ?? 0.0;
          final location = uri.queryParameters['location'] ?? 'Bilinmeyen';
          final time = uri.queryParameters['time'] ?? 'Şimdi';

          return MaterialPageRoute(
            builder: (ctx) => EarthquakeAlarmScreen(
              magnitude: magnitude,
              location: location,
              time: time,
            ),
            fullscreenDialog: true,
          );
        }
        return null;
      },
    );
  }
}
