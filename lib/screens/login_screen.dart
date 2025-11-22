import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../services/auth_service.dart';

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
        _showError(
            'Giriş yapılamadı. Google hesap seçimi iptal edildi veya hata oluştu.');
      }
    } catch (error) {
      print('❌ Login screen hatası: $error');
      _showError('Giriş hatası: $error');
    } finally {
      if (mounted) {
        setState(() {
          _isLoading = false;
        });
      }
    }
  }

  Future<void> _continueAsGuest() async {
    setState(() {
      _isLoading = true;
    });

    try {
      // Misafir kullanıcı için geçici ID oluştur (use AuthService compatible keys)
      final prefs = await SharedPreferences.getInstance();
      final guestId = 'guest_${DateTime.now().millisecondsSinceEpoch}';
      await prefs.setString('user_id', guestId);
      await prefs.setString('user_name', 'Misafir Kullanıcı');
      await prefs.setString('user_email', 'guest@depremhatti.com');
      await prefs.setString('user_photo_url', '');

      print('✅ Misafir olarak giriş yapıldı: $guestId');

      if (mounted) {
        Navigator.pushReplacementNamed(context, '/home');
      }
    } catch (error) {
      print('❌ Misafir giriş hatası: $error');
      _showError('Misafir girişi başarısız: $error');
    } finally {
      if (mounted) {
        setState(() {
          _isLoading = false;
        });
      }
    }
  }

  void _showError(String message) {
    if (mounted) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text(message),
          backgroundColor: Colors.red,
        ),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        width: double.infinity,
        height: double.infinity,
        decoration: const BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: [
              Color(0xFFFF3A3D),
              Color(0xFFE63235),
            ],
          ),
        ),
        child: SafeArea(
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 32.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                const Spacer(),

                // Logo
                SvgPicture.asset(
                  'assets/Icons/Logo.svg',
                  width: 140,
                  height: 140,
                  colorFilter: const ColorFilter.mode(
                    Colors.white,
                    BlendMode.srcIn,
                  ),
                ),

                const SizedBox(height: 40),

                // Başlık
                const Text(
                  'Deprem Hattı',
                  style: TextStyle(
                    fontSize: 36,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                    letterSpacing: 1.5,
                  ),
                ),

                const SizedBox(height: 12),

                const Text(
                  'Deprem anında sevdiklerinize ulaşın',
                  style: TextStyle(
                    fontSize: 15,
                    color: Colors.white70,
                    letterSpacing: 0.5,
                  ),
                  textAlign: TextAlign.center,
                ),

                const Spacer(),

                // Giriş butonu (Google ile)
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
                        : const Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              Icon(Icons.login, size: 22),
                              SizedBox(width: 12),
                              Text(
                                'Google ile Giriş Yap',
                                style: TextStyle(
                                  fontSize: 16,
                                  fontWeight: FontWeight.w600,
                                ),
                              ),
                            ],
                          ),
                  ),
                ),

                const SizedBox(height: 16),

                // Misafir giriş butonu
                TextButton(
                  onPressed: _isLoading ? null : _continueAsGuest,
                  style: TextButton.styleFrom(
                    padding: const EdgeInsets.symmetric(
                        horizontal: 24, vertical: 12),
                  ),
                  child: const Text(
                    'Misafir olarak devam et',
                    style: TextStyle(
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
    );
  }
}
