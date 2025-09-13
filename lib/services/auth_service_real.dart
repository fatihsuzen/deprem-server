import 'dart:convert';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:http/http.dart' as http;

class AuthService {
  static final AuthService _instance = AuthService._internal();
  factory AuthService() => _instance;
  AuthService._internal();

  final GoogleSignIn _googleSignIn = GoogleSignIn();

  String? _currentUserId;
  String? _currentUserName;
  String? _currentUserEmail;
  String? _currentUserShareCode;
  String? _currentUserPhotoUrl;

  static const String baseUrl =
      'http://192.168.1.104:3000/api'; // WiFi IP adresi

  // Getters
  String? get currentUserId => _currentUserId;
  String? get currentUserName => _currentUserName;
  String? get currentUserEmail => _currentUserEmail;
  String? get currentUserShareCode => _currentUserShareCode;
  String? get currentUserPhotoUrl => _currentUserPhotoUrl;

  // Kullanıcı giriş yapılmış mı kontrol et
  bool get isLoggedIn => _currentUserId != null;

  // Hesap oluştur/giriş yap (Google ile gerçek giriş)
  Future<Map<String, dynamic>?> signInWithGoogle() async {
    try {
      print('🔑 Google Sign-In başlatılıyor...');

      final GoogleSignInAccount? googleUser = await _googleSignIn.signIn();
      if (googleUser == null) {
        print('❌ Kullanıcı Google girişini iptal etti');
        return null;
      }

      print('✅ Google kullanıcısı alındı: ${googleUser.email}');

      final userData = {
        'uid': googleUser.id,
        'displayName': googleUser.displayName ?? 'Kullanıcı',
        'email': googleUser.email,
        'photoURL': googleUser.photoUrl,
      };

      print('💾 Kullanıcı verileri kaydediliyor...');
      await _saveUserData(userData);

      // Server'a da kaydet
      try {
        await _createOrUpdateUserInDatabase(userData);
        print('✅ Kullanıcı server\'a kaydedildi');
      } catch (dbError) {
        print('⚠️ Server kayıt hatası: $dbError');
      }

      return userData;
    } catch (e) {
      print('❌ Google Sign-In hatası: $e');
      return null;
    }
  }

  // Kullanıcı verilerini local storage'a kaydet
  Future<void> _saveUserData(Map<String, dynamic> userData) async {
    final prefs = await SharedPreferences.getInstance();

    _currentUserId = userData['uid'];
    _currentUserName = userData['displayName'];
    _currentUserEmail = userData['email'];
    _currentUserPhotoUrl = userData['photoURL'];

    // Share code oluştur (Firebase UID'den unique kod)
    _currentUserShareCode = _generateShareCodeFromUID(userData['uid']);

    await prefs.setString('user_id', _currentUserId!);
    await prefs.setString('user_name', _currentUserName!);
    await prefs.setString('user_email', _currentUserEmail!);
    await prefs.setString('user_photo_url', _currentUserPhotoUrl ?? '');
    await prefs.setString('user_share_code', _currentUserShareCode!);

    print('💾 Kullanıcı verileri local storage\'a kaydedildi');
    print('🆔 User ID: $_currentUserId');
    print('👤 Name: $_currentUserName');
    print('📧 Email: $_currentUserEmail');
    print('🔗 Share Code: $_currentUserShareCode');
  }

  // Kullanıcıyı server'a kaydet/güncelle
  Future<Map<String, dynamic>?> _createOrUpdateUserInDatabase(
      Map<String, dynamic> userData) async {
    try {
      final response = await http.post(
        Uri.parse('$baseUrl/register'),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode({
          'firebaseUid': userData['uid'],
          'email': userData['email'],
          'displayName': userData['displayName'],
          'shareCode': _currentUserShareCode,
        }),
      );

      if (response.statusCode == 200 || response.statusCode == 201) {
        final responseData = jsonDecode(response.body);
        print('✅ Server kayıt/güncelleme başarılı');
        return responseData;
      } else {
        print('❌ Server kayıt hatası: ${response.statusCode}');
        print('📄 Response: ${response.body}');
        return null;
      }
    } catch (e) {
      print('❌ Server isteği hatası: $e');
      return null;
    }
  }

  // Uygulama başlarken kullanıcı verilerini yükle
  Future<bool> loadUserData() async {
    try {
      print('📚 Kullanıcı verileri yükleniyor...');

      final prefs = await SharedPreferences.getInstance();

      _currentUserId = prefs.getString('user_id');
      _currentUserName = prefs.getString('user_name');
      _currentUserEmail = prefs.getString('user_email');
      _currentUserPhotoUrl = prefs.getString('user_photo_url');
      _currentUserShareCode = prefs.getString('user_share_code');

      if (_currentUserId != null) {
        print('✅ Kullanıcı verileri yüklendi');
        print('🆔 User ID: $_currentUserId');
        print('👤 Name: $_currentUserName');
        print('📧 Email: $_currentUserEmail');
        return true;
      } else {
        print('❌ Kayıtlı kullanıcı verisi bulunamadı');
        return false;
      }
    } catch (e) {
      print('❌ Kullanıcı verileri yükleme hatası: $e');
      return false;
    }
  }

  // Share code oluşturucu (Firebase UID'den)
  String _generateShareCodeFromUID(String uid) {
    // UID'nin son 6 karakterini al ve büyük harfe çevir
    String code = uid.length >= 6
        ? uid.substring(uid.length - 6).toUpperCase()
        : uid.toUpperCase();

    // Alfanumerik karakterleri koruyarak temizle
    code = code.replaceAll(RegExp(r'[^A-Z0-9]'), '');

    // En az 4 karakter olsun
    if (code.length < 4) {
      code = code.padRight(4, '0');
    }

    return code.substring(0, 6); // Maksimum 6 karakter
  }

  // Çıkış yap
  Future<void> signOut() async {
    try {
      await _googleSignIn.signOut();

      final prefs = await SharedPreferences.getInstance();
      await prefs.clear();

      _currentUserId = null;
      _currentUserName = null;
      _currentUserEmail = null;
      _currentUserShareCode = null;
      _currentUserPhotoUrl = null;

      print('✅ Çıkış yapıldı');
    } catch (e) {
      print('❌ Çıkış yapma hatası: $e');
    }
  }
}
