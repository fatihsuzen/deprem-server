import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'screens/splash_screen.dart';
import 'screens/root.dart';
import 'screens/login_screen.dart';
import 'screens/mqtt_test_screen.dart';
import 'screens/report_screen.dart';
import 'services/location_service.dart';
import 'services/notification_service.dart';
import 'services/location_update_service.dart';
import 'services/user_preferences_service.dart';
import 'services/earthquake_websocket_service.dart';

// Global navigation key
final GlobalKey<NavigatorState> navigatorKey = GlobalKey<NavigatorState>();

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Splash screen sırasında tam ekran moduna geç
  await SystemChrome.setEnabledSystemUIMode(SystemUiMode.immersiveSticky);

  // Servis başlatmayı arka plana alıyoruz - uygulama açılırken bekletmeyelim
  _initializeServicesInBackground();

  runApp(const DepremApp());
}

// Servisleri arka planda başlat
void _initializeServicesInBackground() async {
  try {
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

    // WebSocket bağlantısını başlat (Deprem uyarıları için)
    final websocketService = EarthquakeWebSocketService();
    await websocketService.connect();
    print('✅ WebSocket connected for earthquake alerts');

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
            child: CircularProgressIndicator(
              color: Color(0xFFFF3A3D),
            ),
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
        fontFamily: 'Gabarito',
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
        fontFamily: 'Gabarito',
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
    );
  }
}
