// Tüm importlar en üstte
import 'dart:convert';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';

class AuthService {
  static final AuthService _instance = AuthService._internal();
  factory AuthService() => _instance;
  AuthService._internal();

  // OneSignal deviceId sunucuya kaydet
  Future<void> saveOneSignalIdToServer(String onesignalId) async {
    final prefs = await SharedPreferences.getInstance();
    final userId = prefs.getString('user_id');
    if (userId == null) return;
    final response = await http.post(
      Uri.parse('${AuthService.baseUrl}/users/onesignal-id'),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode({'userId': userId, 'onesignalId': onesignalId}),
    );
    if (response.statusCode == 200) {
      print('✅ OneSignal ID sunucuya kaydedildi');
    } else {
      print('❌ OneSignal ID kaydedilemedi: ${response.statusCode}');
    }
  }

  final GoogleSignIn _googleSignIn = GoogleSignIn(
    // Android için scopes yeterli, serverClientId olmadan dene
    scopes: ['email', 'profile'],
  );

  String? _currentUserId;
  String? _currentUserName;
  String? _currentUserEmail;
  String? _currentUserShareCode;
  String? _currentUserPhotoUrl;

  // VDS Server URL - Production IP
  static String get baseUrl {
    return 'http://188.132.202.24:3000/api';
  }

  // Getters
  String? get currentUserId => _currentUserId;
  String? get currentUserName => _currentUserName;
  String? get currentUserEmail => _currentUserEmail;
  String? get currentUserShareCode => _currentUserShareCode;
  String? get currentUserPhotoUrl => _currentUserPhotoUrl;

  // FriendsService uyumluluğu için
  String? get userId => _currentUserId;
  String? get userEmail => _currentUserEmail;
  String? get userName => _currentUserName;
  String? get userPhotoUrl => _currentUserPhotoUrl;

  // Kullanıcı giriş yapılmış mı kontrol et
  bool get isLoggedIn => _currentUserId != null;

  // Firebase ile Google Sign-In
  Future<Map<String, dynamic>?> signInWithGoogleFirebase() async {
    try {
      print('🔑 Google Sign-In (Firebase) başlatılıyor...');
      final GoogleSignInAccount? googleUser = await _googleSignIn.signIn();
      if (googleUser == null) {
        print('❌ Kullanıcı Google girişini iptal etti veya hata oluştu');
        return null;
      }
      final GoogleSignInAuthentication? googleAuth =
          await googleUser.authentication;
      final credential = GoogleAuthProvider.credential(
        accessToken: googleAuth?.accessToken,
        idToken: googleAuth?.idToken,
      );
      final userCredential =
          await FirebaseAuth.instance.signInWithCredential(credential);
      final user = userCredential.user;
      if (user == null) return null;
      _currentUserId = user.uid;
      _currentUserEmail = user.email;
      _currentUserName = user.displayName;
      _currentUserPhotoUrl = user.photoURL;
      final userData = {
        'uid': user.uid,
        'email': user.email,
        'displayName': user.displayName ?? 'Google Kullanıcı',
        'photoURL': googleUser.photoUrl,
      };

      print('💾 Kullanıcı verileri kaydediliyor...');
      await _saveUserData(userData);

      try {
        await _createOrUpdateUserInDatabase(userData);
        print("✅ Kullanıcı sunucuya kaydedildi");
      } catch (dbError) {
        print('⚠️ Server kayıt hatası: $dbError');
      }

      // Giriş yapıldıktan sonra FCM token'ı gönder
      try {
        final prefs = await SharedPreferences.getInstance();
        final fcmToken = prefs.getString('fcm_token');
        if (fcmToken != null) {
          // LocationUpdateService'i import etmek yerine doğrudan endpoint'e istek yapalım
          final response = await http.post(
            Uri.parse('${AuthService.baseUrl}/users/device-token'),
            headers: {
              'Content-Type': 'application/json',
              'x-firebase-uid': user.uid,
            },
            body: jsonEncode({
              'token': fcmToken,
              'platform': 'android',
            }),
          );
          if (response.statusCode == 200) {
            print('✅ FCM Token giriş sonrası sunucuya gönderildi');
          } else {
            print('⚠️ FCM Token gönderme hatası: ${response.statusCode}');
          }
        } else {
          print('⚠️ FCM Token bulunamadı, daha sonra gönderilecek');
        }
      } catch (tokenError) {
        print('⚠️ FCM Token gönderme hatası: $tokenError');
      }

      return userData;
    } catch (e) {
      print('❌ Google Sign-In hatası: $e');
      print('🔍 Hata tipi: ${e.runtimeType}');
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
    _currentUserShareCode = _generateShareCodeFromUID(userData['uid']);

    await prefs.setString('user_id', _currentUserId!);
    await prefs.setString('user_name', _currentUserName!);
    await prefs.setString('user_email', _currentUserEmail!);
    await prefs.setString('user_photo_url', _currentUserPhotoUrl ?? '');
    await prefs.setString('user_share_code', _currentUserShareCode!);

    print('💾 Kullanıcı verileri kaydedildi');
    print('🆔 User ID: $_currentUserId');
    print('👤 Name: $_currentUserName');
    print('📧 Email: $_currentUserEmail');
    print('🔗 Share Code: $_currentUserShareCode');
  }

  // Server'a kaydet
  Future<Map<String, dynamic>?> _createOrUpdateUserInDatabase(
    Map<String, dynamic> userData,
  ) async {
    try {
      final response = await http.post(
        Uri.parse('${AuthService.baseUrl}/register'),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode({
          'firebaseUid': userData['uid'],
          'email': userData['email'],
          'displayName': userData['displayName'],
          'shareCode': _currentUserShareCode,
        }),
      );

      if (response.statusCode == 200 || response.statusCode == 201) {
        print('✅ Server kayıt başarılı');
        return jsonDecode(response.body);
      } else {
        print('❌ Server kayıt hatası: ${response.statusCode}');
        return null;
      }
    } catch (e) {
      print('❌ Server isteği hatası: $e');
      return null;
    }
  }

  // Kullanıcı verilerini yükle
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

  // Share code oluştur (private)
  String _generateShareCodeFromUID(String uid) {
    int hash = uid.hashCode.abs();
    String code = (hash % 999999).toString().padLeft(6, '0');
    return code;
  }

  // Share code oluştur (public - FriendsScreen için)
  String generateShareCode() {
    if (_currentUserId != null) {
      return _generateShareCodeFromUID(_currentUserId!);
    }
    return _currentUserShareCode ?? '000000';
  }

  // Konum güncelle
  Future<void> updateLocation(double latitude, double longitude) async {
    try {
      if (_currentUserId == null) return;

      final response = await http.put(
        Uri.parse('${AuthService.baseUrl}/users/update-location'),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode({'latitude': latitude, 'longitude': longitude}),
      );

      if (response.statusCode == 200) {
        print('✅ Konum güncellendi');
      }
    } catch (e) {
      print('❌ Konum güncelleme hatası: $e');
    }
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
