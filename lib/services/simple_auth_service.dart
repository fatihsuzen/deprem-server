import 'dart:convert';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:http/http.dart' as http;

class SimpleAuthService {
  static final SimpleAuthService _instance = SimpleAuthService._internal();
  factory SimpleAuthService() => _instance;
  SimpleAuthService._internal();

  String? _currentUserId;
  String? _currentUserName;
  String? _currentUserEmail;
  String? _currentUserShareCode;

  // VDS Server URL
  static String get baseUrl {
    return 'http://188.132.202.24:3000/api';
  }

  // Getters
  String? get currentUserId => _currentUserId;
  String? get currentUserName => _currentUserName;
  String? get currentUserEmail => _currentUserEmail;
  String? get currentUserShareCode => _currentUserShareCode;

  // Basit giris - email/isim ile
  Future<Map<String, dynamic>?> signInWithEmail(
      String email, String name) async {
    try {
      print('📧 Email ile giris baslatiliyor: $email');

      // Kullanici ID'si olustur (email'den)
      final userId = 'user_${email.replaceAll('@', '_').replaceAll('.', '_')}';
      final shareCode = _generateShareCodeFromEmail(email);

      final userData = {
        'uid': userId,
        'displayName': name,
        'email': email,
        'photoURL': null,
        'shareCode': shareCode,
      };

      // VDS'ye kullanici kaydet
      await _registerUserToVDS(userData);

      // Local'de kaydet
      await _saveUserData(userData);

      print('✅ Email girişi başarılı');
      return userData;
    } catch (e) {
      print('❌ Email giriş hatası: $e');
      return null;
    }
  }

  // Email'den share code oluştur
  String _generateShareCodeFromEmail(String email) {
    final emailHash = email.hashCode.abs();
    final timeHash = DateTime.now().millisecondsSinceEpoch % 100000;
    return (emailHash % 900000 + 100000 + timeHash % 10000).toString();
  }

  // VDS'ye kullanıcı kaydet
  Future<void> _registerUserToVDS(Map<String, dynamic> userData) async {
    try {
      final response = await http.post(
        Uri.parse('$baseUrl/users/register'),
        headers: {'Content-Type': 'application/json'},
        body: json.encode({
          'uid': userData['uid'],
          'displayName': userData['displayName'],
          'email': userData['email'],
          'shareCode': userData['shareCode'],
          'photoURL': userData['photoURL'],
          'signInMethod': 'email',
        }),
      );

      if (response.statusCode == 200 || response.statusCode == 409) {
        print('✅ Kullanıcı VDS\'ye kaydedildi');
      } else {
        print('⚠️ VDS kayıt hatası: ${response.statusCode}');
      }
    } catch (e) {
      print('❌ VDS kayıt hatası: $e');
    }
  }

  // Kullanıcı verilerini kaydet
  Future<void> _saveUserData(Map<String, dynamic> userData) async {
    final prefs = await SharedPreferences.getInstance();

    _currentUserId = userData['uid'];
    _currentUserName = userData['displayName'];
    _currentUserEmail = userData['email'];
    _currentUserShareCode = userData['shareCode'];

    await prefs.setString('user_id', _currentUserId!);
    await prefs.setString('user_name', _currentUserName!);
    await prefs.setString('user_email', _currentUserEmail!);
    await prefs.setString('user_share_code', _currentUserShareCode!);

    print('💾 Kullanıcı verileri kaydedildi');
  }

  // Kayıtlı kullanıcı verilerini yükle
  Future<Map<String, dynamic>?> loadUserData() async {
    try {
      print('📚 Kullanıcı verileri yükleniyor...');
      final prefs = await SharedPreferences.getInstance();

      final userId = prefs.getString('user_id');
      final userName = prefs.getString('user_name');
      final userEmail = prefs.getString('user_email');
      final userShareCode = prefs.getString('user_share_code');

      if (userId != null && userName != null && userEmail != null) {
        _currentUserId = userId;
        _currentUserName = userName;
        _currentUserEmail = userEmail;
        _currentUserShareCode = userShareCode;

        final userData = {
          'uid': userId,
          'displayName': userName,
          'email': userEmail,
          'shareCode': userShareCode,
        };

        print('✅ Kullanıcı verileri yüklendi');
        print('🆔 User ID: $userId');
        print('👤 Name: $userName');
        print('📧 Email: $userEmail');

        return userData;
      } else {
        print('❌ Kayıtlı kullanıcı verisi bulunamadı');
        return null;
      }
    } catch (e) {
      print('❌ Kullanıcı verisi yükleme hatası: $e');
      return null;
    }
  }

  // Çıkış yap
  Future<void> signOut() async {
    try {
      print('🚪 Çıkış yapılıyor...');
      await clearUserData();
      print('✅ Çıkış yapıldı');
    } catch (e) {
      print('❌ Çıkış hatası: $e');
    }
  }

  // Kullanıcı verilerini temizle
  Future<void> clearUserData() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.remove('user_id');
    await prefs.remove('user_name');
    await prefs.remove('user_email');
    await prefs.remove('user_share_code');

    _currentUserId = null;
    _currentUserName = null;
    _currentUserEmail = null;
    _currentUserShareCode = null;

    print('🗑️ Kullanıcı verileri temizlendi');
  }

  // Giriş durumu kontrolü
  bool get isSignedIn => _currentUserId != null;
}
