import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;

import 'package:shared_preferences/shared_preferences.dart';
import '../services/auth_service.dart';
import '../l10n/app_localizations.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final AuthService _authService = AuthService();
  bool _isLoading = false;

  Future<void> _signInWithGoogle() async {
    setState(() {
      _isLoading = true;
    });
    try {
      print('🔄 Login screen: Giriş başlatılıyor...');
      final user = await _authService.signInWithGoogleFirebase();
      if (user != null && mounted) {
        print('✅ Login screen: Giriş başarılı, ana sayfaya yönlendiriliyor');
        Navigator.pushReplacementNamed(context, '/home');
      } else {
        print('❌ Login screen: Kullanıcı null döndü');
        _showError(AppLocalizations.of(context)!.get('login_failed'));
      }
    } catch (error) {
      print('❌ Login screen hatası: $error');
      _showError('${AppLocalizations.of(context)!.get('login_error')}: $error');
    } finally {
      if (mounted) {
        setState(() {
          _isLoading = false;
        });
      }
    }
  }

  void _showError(String message) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text(message), backgroundColor: Colors.red),
    );
  }

  Future<void> _continueAsGuest() async {
    setState(() {
      _isLoading = true;
    });
    try {
      final prefs = await SharedPreferences.getInstance();
      final guestId = 'guest_{DateTime.now().millisecondsSinceEpoch}';
      await prefs.setString('user_id', guestId);
      await prefs.setString(
          'user_name', AppLocalizations.of(context)!.get('guest_user'));
      await prefs.setString('user_email', 'guest@depremhatti.com');
      await prefs.setString('user_photo_url', '');
      print('✅ Misafir olarak giriş yapıldı: $guestId');

      // Misafir girişi sonrası FCM token'ı gönder
      try {
        final fcmToken = prefs.getString('fcm_token');
        if (fcmToken != null) {
          final response = await http.post(
            Uri.parse('http://188.132.202.24:3000/api/users/device-token'),
            headers: {
              'Content-Type': 'application/json',
              'x-firebase-uid': guestId,
            },
            body: jsonEncode({
              'token': fcmToken,
              'platform': 'android',
            }),
          );
          if (response.statusCode == 200) {
            print('✅ FCM Token misafir girişi sonrası gönderildi');
          }
        }
      } catch (tokenError) {
        print('⚠️ Token gönderme hatası: $tokenError');
      }

      if (mounted) {
        Navigator.pushReplacementNamed(context, '/home');
      }
    } catch (error) {
      print('❌ Misafir giriş hatası: $error');
      _showError(
          '${AppLocalizations.of(context)!.get('guest_login_failed')}: $error');
    } finally {
      if (mounted) {
        setState(() {
          _isLoading = false;
        });
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    final locale = Localizations.localeOf(context);
    final isTurkish = locale.languageCode == 'tr';
    String splashImage = isTurkish
        ? 'assets/images/Splash_Screen-tr.png'
        : 'assets/images/Splash_Screen-eng.png';
    return Scaffold(
      body: Container(
        decoration: BoxDecoration(
          color: const Color(0xFFFF3A3D),
          image: DecorationImage(
            image:
                AssetImage(splashImage), // Sadece splash arka planı, logo yok
            fit: BoxFit.cover,
            alignment: Alignment.center,
          ),
        ),
        child: Container(
          color: Colors.black.withOpacity(0.35),
          child: SafeArea(
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: 32.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  const Spacer(),
                  // Logo tamamen kaldırıldı
                  // Uygulama ismi ve hoşgeldin yazısı kaldırıldı
                  const Spacer(),
                  Container(
                    width: double.infinity,
                    height: 56,
                    decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(30),
                      boxShadow: [
                        BoxShadow(
                          color: Colors.black.withOpacity(0.2),
                          blurRadius: 10,
                          offset: const Offset(0, 5),
                        ),
                      ],
                    ),
                    child: ElevatedButton(
                      onPressed: _isLoading ? null : _signInWithGoogle,
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.white,
                        foregroundColor: const Color(0xFFFF3A3D),
                        elevation: 0,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(30),
                        ),
                      ),
                      child: _isLoading
                          ? const CircularProgressIndicator(
                              valueColor: AlwaysStoppedAnimation<Color>(
                                  Color(0xFFFF3A3D)),
                            )
                          : Row(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                const Icon(Icons.login, size: 22),
                                const SizedBox(width: 12),
                                Text(
                                  AppLocalizations.of(context)
                                          ?.loginWithGoogle ??
                                      'Sign in with Google',
                                  style: const TextStyle(
                                    fontSize: 16,
                                    fontWeight: FontWeight.w600,
                                  ),
                                ),
                              ],
                            ),
                    ),
                  ),
                  const SizedBox(height: 16),
                  TextButton(
                    onPressed: _isLoading ? null : _continueAsGuest,
                    style: TextButton.styleFrom(
                      padding: const EdgeInsets.symmetric(
                          horizontal: 24, vertical: 12),
                    ),
                    child: Text(
                      AppLocalizations.of(context)?.continueAsGuest ??
                          'Continue as guest',
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 15,
                        fontWeight: FontWeight.w500,
                      ),
                    ),
                  ),
                  const SizedBox(height: 40),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
