import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'screens/splash_screen.dart';
import 'screens/notification_detail.dart';
import 'screens/root.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  // Splash screen sırasında status bar'ı gizle
  SystemChrome.setEnabledSystemUIMode(SystemUiMode.immersiveSticky);
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Deprem Hattı',
      theme: ThemeData(
        primarySwatch: Colors.red,
        scaffoldBackgroundColor: Colors.white,
      ),
      // Splash screen ile başla
      initialRoute: '/',
      routes: {
        '/': (ctx) => SplashScreen(),
        '/home': (ctx) => RootScreen(),
        '/detail': (ctx) => NotificationDetailScreen(),
      },
    );
  }
}
