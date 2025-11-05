import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'screens/mqtt_test_screen.dart';
import 'screens/home_screen_simple.dart' as home_simple;
import 'screens/demo_screen.dart';
import 'screens/splash_screen.dart';
import 'screens/report_screen.dart';
import 'services/location_service.dart';
import 'services/notification_service.dart';

// Global navigation key
final GlobalKey<NavigatorState> navigatorKey = GlobalKey<NavigatorState>();

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Servisleri initialize et
  try {
    await NotificationService().initialize();
    print('✅ Notification service initialized');

    final locationService = LocationService();
    await locationService.initialize();
    print('✅ Location service initialized');

    // Konum tracking'i başlat
    await locationService.startLocationTracking();
    print('✅ Location tracking started');
  } catch (error) {
    print('❌ Service initialization error: $error');
  }

  runApp(const DepremApp());
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

  // theme toggling removed for test screen

  @override
  Widget build(BuildContext context) {
    if (isLoading) {
      return MaterialApp(
        home: Scaffold(
          body: Center(
            child: CircularProgressIndicator(),
          ),
        ),
      );
    }

    return MaterialApp(
      title: 'Deprem Bildirim',
      navigatorKey: navigatorKey,
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
      ),
      themeMode: isDarkTheme ? ThemeMode.dark : ThemeMode.light,
      home: const SplashScreen(), // Splash ekranından başla
      routes: {
        '/debug/mqtt': (_) => const MqttTestScreen(),
        '/home': (_) => const DemoScreen(), // Ana ekran artık DemoScreen
        '/old-home': (_) => home_simple.HomeScreen(onThemeChanged: (v) {}),
        '/report': (_) => const ReportScreen(), // Deprem bildir ekranı
      },
      debugShowCheckedModeBanner: false,
    );
  }
}
