import 'services/fcm_service.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_map_tile_caching/flutter_map_tile_caching.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'l10n/locale_provider.dart';
import 'package:onesignal_flutter/onesignal_flutter.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:flutter_foreground_task/flutter_foreground_task.dart';
// ...existing code...
import 'screens/splash_screen.dart';
import 'screens/root.dart';
import 'screens/login_screen.dart';
import 'screens/mqtt_test_screen.dart';
import 'screens/report_screen.dart';
import 'screens/sensor_data_recorder_screen.dart';
import 'screens/earthquake_alarm_screen.dart';
import 'screens/language_selection_screen.dart';
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
import 'l10n/app_localizations.dart';
import 'screens/earthquake_info_screen.dart';

// Global navigation key
final GlobalKey<NavigatorState> navigatorKey = GlobalKey<NavigatorState>();

// Global app key for restarting
final GlobalKey<_DepremAppState> appKey = GlobalKey<_DepremAppState>();

// Function to restart app
void restartApp() {
  appKey.currentState?.restartApp();
}

// ...existing code...
void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Uygulamanın sadece dikey modda çalışmasını sağla
  await SystemChrome.setPreferredOrientations([
    DeviceOrientation.portraitUp,
    DeviceOrientation.portraitDown,
  ]);

  // Native deprem alert activity'den gelen parametreyi kontrol et
  final MethodChannel paramsChannel = const MethodChannel(
    'deprem_app/earthquake_params',
  );
  final rawParams = await paramsChannel.invokeMethod('getEarthquakeParams');
  Map<String, dynamic>? earthquakeParams;
  if (rawParams != null) {
    try {
      earthquakeParams = Map<String, dynamic>.from(rawParams as Map);
    } catch (e) {
      debugPrint('[DepremApp] main.dart: earthquakeParams cast hatası: $e');
      earthquakeParams = null;
    }
  }
  debugPrint('[DepremApp] main.dart: earthquakeParams = $earthquakeParams');
  if (earthquakeParams == null) {
    debugPrint(
      '[DepremApp] main.dart: earthquakeParams NULL, ana ekran açılacak!',
    );
  } else {
    debugPrint(
      '[DepremApp] main.dart: earthquakeParams mevcut, circle ekran açılacak!',
    );
  }
  // Kullanılmayan değişkenler kaldırıldı
  // MethodChannel handler'ları ekleniyor
  const MethodChannel wakeLockChannel = MethodChannel('deprem_app/wake_lock');
  const MethodChannel alertActivityChannel = MethodChannel(
    'deprem_app/alert_activity',
  );

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
  // Firebase'i sadece daha önce başlatılmamışsa başlat
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

  // OneSignal başlat
  OneSignal.initialize("37c0591e-7d1c-4754-b65c-1328feafd933");
  OneSignal.Notifications.requestPermission(true);

  // FCM background handler kaydı
  FirebaseMessaging.onBackgroundMessage(firebaseMessagingBackgroundHandler);

  // FCM notification setup
  // Duplicate deprem bildirimi engelleme
  String? lastEarthquakeId;
  FirebaseMessaging.onMessage.listen((RemoteMessage message) {
    print(
      '📲 Yeni bildirim: ${message.notification?.title} - ${message.notification?.body}',
    );
    if (message.data['type'] == 'earthquake_alert') {
      // Benzersiz deprem id'si oluştur (location+timestamp)
      final location = message.data['location'] ?? '';
      final timestampStr =
          message.data['timestamp'] ?? DateTime.now().toIso8601String();
      final eqId = '$location|$timestampStr';
      if (lastEarthquakeId == eqId) {
        print('[FCM] Duplicate deprem bildirimi engellendi: $eqId');
        return;
      }
      lastEarthquakeId = eqId;
      // Alanları kontrol et
      final magnitude =
          double.tryParse(message.data['magnitude']?.toString() ?? '') ?? 0.0;
      final distance =
          double.tryParse(message.data['distance']?.toString() ?? '') ?? 0.0;
      // Deprem merkezi koordinatları - earthquakeLat/Lon veya epicenter_lat/lon
      final epicenterLat =
          double.tryParse(message.data['epicenter_lat']?.toString() ?? '') ??
              double.tryParse(message.data['earthquakeLat']?.toString() ?? '');
      final epicenterLon =
          double.tryParse(message.data['epicenter_lon']?.toString() ?? '') ??
              double.tryParse(message.data['earthquakeLon']?.toString() ?? '');
      final depth = double.tryParse(message.data['depth']?.toString() ?? '');
      print(
        '📍 FCM Deprem Merkezi: lat=$epicenterLat, lon=$epicenterLon, depth=$depth',
      );

      String safeLocation = location;
      if (safeLocation.isEmpty ||
          safeLocation == 'NaN,NaN' ||
          safeLocation.contains('object')) {
        safeLocation = 'Bilinmeyen';
      }

      // P2P deprem mi kontrol et
      final isP2P = message.data['p2p_circle'] == 'true';
      // Gerçek kaynağı al (AFAD, Kandilli, USGS, EMSC, P2P vb.)
      final source = message.data['source'] ?? (isP2P ? 'P2P' : 'AFAD');
      print(
        '🔍 FCM Deprem tipi: ${isP2P ? "P2P (sismik dalgalı ekran)" : "Normal (bilgi ekranı)"} - Kaynak: $source',
      );

      if (isP2P) {
        // P2P deprem - Sismik dalgalı animasyon ekranı
        navigatorKey.currentState?.push(
          MaterialPageRoute(
            builder: (_) => EarthquakeAlertScreen(
              magnitude: magnitude,
              location: safeLocation,
              distance: distance.isNaN ? 0.0 : distance,
              timestamp: DateTime.tryParse(timestampStr) ?? DateTime.now(),
              source: source,
              epicenterLat: epicenterLat,
              epicenterLon: epicenterLon,
            ),
          ),
        );
      } else {
        // Normal deprem - Bilgi ekranı (animasyon yok)
        NotificationService().showInfoScreen(
          magnitude,
          safeLocation,
          distance.isNaN ? 0.0 : distance,
          source,
          epicenterLat: epicenterLat,
          epicenterLon: epicenterLon,
          depth: depth,
        );
      }
    }
    // Diğer bildirimler için navigasyon yapma - sadece log'la
    // else bloğu kaldırıldı - restart sorununa neden oluyordu
  });

  // Background service'i initialize et
  EarthquakeBackgroundService.initializeService();

  // FMTC harita cache'ini başlat (runApp öncesinde, tek seferlik)
  try {
    await FMTCObjectBoxBackend().initialise();
    await FMTCStore('mapCache').manage.create();
    debugPrint('✅ FMTC harita cache başlatıldı');
  } on RootAlreadyInitialised {
    debugPrint('ℹ️ FMTC zaten başlatılmış, atlanıyor');
  } catch (e) {
    debugPrint('⚠️ FMTC başlatma hatası (normal network kullanılacak): $e');
  }

  // Splash screen sırasında tam ekran moduna geç
  await SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);

  // Servis başlatmayı arka plana alıyoruz - uygulama açılırken bekletmeyelim
  _initializeServicesInBackground();

  // Her durumda tek bir runApp çağırarak uygulamayı başlat
  // Bu, Firebase'in çift başlatılması hatasını çözer
  runApp(DepremApp(key: appKey, earthquakeParams: earthquakeParams));
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

    // ===== FCM TOKEN AL VE KAYDET =====
    await _initializeFCMToken();

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

    // Background service GEÇİCİ OLARAK DEVRE DIŞI
    // Yeterli kullanıcı sayısına ulaşıldığında aktif edilecek
    print(
      '⚪️ Background service geçici olarak devre dışı (özellik geliştiriliyor)',
    );

    // Eğer eski kullanıcılarda çalışan bir servis varsa durdur
    final isRunning = await FlutterForegroundTask.isRunningService;
    if (isRunning) {
      await EarthquakeBackgroundService.stopService();
      print('🔴 Arka plan servisi durduruldu');
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

// FCM Token'ı al, kaydet ve dinle
Future<void> _initializeFCMToken() async {
  try {
    final messaging = FirebaseMessaging.instance;
    final prefs = await SharedPreferences.getInstance();

    // Mevcut token'ı al
    String? token = await messaging.getToken();
    if (token != null) {
      print('🔑 FCM Token alındı: ${token.substring(0, 20)}...');
      await prefs.setString('fcm_token', token);
      print('✅ FCM Token SharedPreferences\'a kaydedildi');

      // Token'ı HEMEN sunucuya gönder (konum izni beklemeden)
      try {
        final locationUpdateService = LocationUpdateService();
        final userId = prefs.getString('user_id');
        if (userId != null) {
          final success = await locationUpdateService.sendDeviceToken(
            token,
            'android',
          );
          if (success) {
            print('✅ FCM Token sunucuya kaydedildi');
          } else {
            print('⚠️ FCM Token sunucuya gönderilemedi');
          }
        } else {
          print('⚠️ Kullanıcı oturum açmamış, token daha sonra gönderilecek');
        }
      } catch (e) {
        print('⚠️ Token sunucuya gönderim hatası: $e');
      }
    } else {
      print('⚠️ FCM Token alınamadı!');
    }

    // Token yenilendiğinde dinle
    messaging.onTokenRefresh.listen((newToken) async {
      print('🔄 FCM Token yenilendi: ${newToken.substring(0, 20)}...');
      await prefs.setString('fcm_token', newToken);
      print('✅ Yeni FCM Token kaydedildi');

      // Yeni token'ı sunucuya da gönder (konum izni beklemeden)
      try {
        final locationUpdateService = LocationUpdateService();
        final userId = prefs.getString('user_id');
        if (userId != null) {
          final success = await locationUpdateService.sendDeviceToken(
            newToken,
            'android',
          );
          if (success) {
            print('✅ Yeni token sunucuya gönderildi');
          } else {
            print('⚠️ Yeni token sunucuya gönderilemedi');
          }
        }
      } catch (e) {
        print('⚠️ Yeni token sunucuya gönderim hatası: $e');
      }
    });

    print('✅ FCM Token initialized');
  } catch (e) {
    print('❌ FCM Token initialization error: $e');
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
      shareLocationWithFriends: settings['shareLocation'],
    );

    print('✅ User settings synced to server');
  } catch (e) {
    print('⚠️  User settings sync error: $e');
  }
}

class DepremApp extends StatefulWidget {
  const DepremApp({this.earthquakeParams, super.key});

  final Map<String, dynamic>? earthquakeParams;

  @override
  State<DepremApp> createState() => _DepremAppState();
}

class _DepremAppState extends State<DepremApp> {
  bool isDarkTheme = false;
  bool isLoading = true;
  Locale _locale = const Locale('tr');
  bool _isFirstLaunch = false;
  Key _appKey = UniqueKey();

  @override
  void initState() {
    super.initState();
    _loadPreferences();
  }

  void restartApp() {
    setState(() {
      _appKey = UniqueKey();
      isLoading = true;
    });
    _loadPreferences();
  }

  Future<void> _loadPreferences() async {
    final prefs = await SharedPreferences.getInstance();
    final languageSelected = prefs.getBool('language_selected') ?? false;
    String languageCode = prefs.getString('app_locale') ?? 'tr';

    // Desteklenen diller: tr, en, es, hi, fil, my
    const supportedCodes = ['tr', 'en', 'es', 'hi', 'fil', 'my'];
    if (!supportedCodes.contains(languageCode)) {
      languageCode = 'en';
    }

    debugPrint('🌐 Language Settings:');
    debugPrint('   language_selected: $languageSelected');
    debugPrint('   app_locale: $languageCode');
    debugPrint('   _isFirstLaunch will be: ${!languageSelected}');

    setState(() {
      isDarkTheme = prefs.getBool('isDarkTheme') ?? false;
      _locale = Locale(languageCode);
      _isFirstLaunch = !languageSelected;
      isLoading = false;
    });
    LocaleProvider.cached = languageCode;
  }

  void _setLocale(Locale locale) {
    const supportedCodes = ['tr', 'en', 'es', 'hi', 'fil', 'my'];
    final code = supportedCodes.contains(locale.languageCode)
        ? locale.languageCode
        : 'en';
    LocaleProvider.cached = code;
    setState(() {
      _locale = Locale(code);
    });
  }

  @override
  Widget build(BuildContext context) {
    if (isLoading) {
      return const MaterialApp(
        home: Scaffold(
          body: Center(
            child: CircularProgressIndicator(color: Color(0xFFFF3A3D)),
          ),
        ),
      );
    }

    // 1. Deprem parametresi varsa, p2p_circle parametresine göre ekranı aç
    if (widget.earthquakeParams != null) {
      final params = widget.earthquakeParams!;
      final epicenterLat = double.tryParse(
        params['epicenter_lat']?.toString() ?? '',
      );
      final epicenterLon = double.tryParse(
        params['epicenter_lon']?.toString() ?? '',
      );
      final depth = double.tryParse(params['depth']?.toString() ?? '');
      final magnitude =
          double.tryParse(params['magnitude']?.toString() ?? '') ?? 0.0;
      final distance =
          double.tryParse(params['distance']?.toString() ?? '') ?? 0.0;
      final source = params['source']?.toString() ?? 'AFAD';
      final isP2P = params['p2p_circle']?.toString() == 'true';

      return MaterialApp(
        debugShowCheckedModeBanner: false,
        home: isP2P
            ? EarthquakeAlertScreen(
                magnitude: magnitude,
                location: params['location'] as String? ?? '',
                distance: distance,
                timestamp: DateTime.now(),
                source: source,
                epicenterLat: epicenterLat,
                epicenterLon: epicenterLon,
              )
            : EarthquakeInfoScreen(
                magnitude: magnitude,
                location: params['location'] as String? ?? '',
                distance: distance,
                timestamp: DateTime.now(),
                source: source,
                epicenterLat: epicenterLat,
                epicenterLon: epicenterLon,
                depth: depth,
              ),
      );
    }

    // 2. İlk açılışta dil seçim ekranı göster
    if (_isFirstLaunch) {
      return MaterialApp(
        debugShowCheckedModeBanner: false,
        locale: _locale,
        supportedLocales: const [
          Locale('en'),
          Locale('es'),
          Locale('tr'),
          Locale('hi'),
          Locale('fil'),
          Locale('my'),
        ],
        localizationsDelegates: const [
          AppLocalizations.delegate,
          GlobalMaterialLocalizations.delegate,
          GlobalWidgetsLocalizations.delegate,
          GlobalCupertinoLocalizations.delegate,
        ],
        theme: ThemeData(
          colorScheme: ColorScheme.light(primary: const Color(0xFFFF3A3D)),
          useMaterial3: true,
        ),
        home: LanguageSelectionScreen(
          isFromSettings: false,
          onLanguageSelected: (locale) {
            _setLocale(locale);
            setState(() {
              _isFirstLaunch = false;
            });
          },
        ),
      );
    }

    return MaterialApp(
      title: 'Deprem Hattı',
      navigatorKey: navigatorKey,
      debugShowCheckedModeBanner: false,
      locale: _locale,
      supportedLocales: const [
        Locale('en'),
        Locale('es'),
        Locale('tr'),
        Locale('hi'),
        Locale('fil'),
        Locale('my'),
      ],
      localizationsDelegates: const [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
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
        '/sensor-recorder': (ctx) => const SensorDataRecorderScreen(),
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
