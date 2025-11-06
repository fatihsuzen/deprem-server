import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'screens/splash_screen.dart';
import 'screens/root.dart';
import 'screens/mqtt_test_screen.dart';
import 'screens/report_screen.dart';
import 'services/location_service.dart';
import 'services/notification_service.dart';

// Global navigation key
final GlobalKey<NavigatorState> navigatorKey = GlobalKey<NavigatorState>();

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Splash screen sırasında tam ekran moduna geç
  await SystemChrome.setEnabledSystemUIMode(SystemUiMode.immersiveSticky);

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
        '/home': (ctx) => const RootScreen(),
        '/debug/mqtt': (ctx) => const MqttTestScreen(),
        '/report': (ctx) => const ReportScreen(),
      },
    );
  }
}
