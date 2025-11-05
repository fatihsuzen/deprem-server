import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../services/auth_service.dart';
import 'demo_screen.dart';

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
      final user = await _authService.signInWithGoogle();

      if (user != null && mounted) {
        print('✅ Login screen: Giriş başarılı, ana sayfaya yönlendiriliyor');
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(
              builder: (context) => const DemoScreen()),
        );
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
      // Misafir kullanıcı için temporary login
      final user = await _authService.signInWithGoogle();
      if (user != null && mounted) {
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(
              builder: (context) => const DemoScreen()),
        );
      }
    } catch (error) {
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
                Stack(
                  alignment: Alignment.center,
                  children: [
                    // Dış halka
                    Container(
                      width: 140,
                      height: 140,
                      decoration: BoxDecoration(
                        shape: BoxShape.circle,
                        border: Border.all(
                          color: Colors.white.withOpacity(0.3),
                          width: 2,
                        ),
                      ),
                    ),
                    // İç ikon
                    Container(
                      width: 110,
                      height: 110,
                      decoration: const BoxDecoration(
                        color: Colors.white,
                        shape: BoxShape.circle,
                      ),
                      child: const Icon(
                        Icons.favorite,
                        size: 50,
                        color: Color(0xFFFF3A3D),
                      ),
                    ),
                  ],
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
                            valueColor: AlwaysStoppedAnimation<Color>(Color(0xFFFF3A3D)),
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
                    padding: const EdgeInsets.symmetric(horizontal: 24, vertical: 12),
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
