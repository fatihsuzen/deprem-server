import 'package:google_sign_in/google_sign_in.dart';

class AuthService {
  static final AuthService _instance = AuthService._internal();
  factory AuthService() => _instance;
  AuthService._internal();

  final GoogleSignIn _googleSignIn = GoogleSignIn();
  // Firebase ve Firestore kaldırıldı

  // Sadece GoogleSignIn ile giriş
  GoogleSignInAccount? _currentUser;
  bool get isLoggedIn => _currentUser != null;
  String? get userId => _currentUser?.id;
  String? get userEmail => _currentUser?.email;
  String? get userName => _currentUser?.displayName;
  String? get userPhotoUrl => _currentUser?.photoUrl;

  // Google Sign In
  Future<bool> signInWithGoogle() async {
    try {
      print('🔐 Google Sign-In başlatılıyor...');
      final GoogleSignInAccount? googleUser = await _googleSignIn.signIn();
      if (googleUser == null) {
        print('❌ Google Sign-In iptal edildi');
        return false;
      }
      _currentUser = googleUser;
      print('✅ Google Sign-In başarılı: ${googleUser.email}');
      // Sunucuya kaydetmek için userId, email, displayName, photoUrl kullanılabilir
      return true;
    } catch (error) {
      print('❌ Google Sign-In hatası: $error');
      return false;
    }
  }

  // Firestore ile ilgili kodlar kaldırıldı

  // Konum güncelleme sunucuya yapılacaksa burada eklenebilir

  // Sign out
  Future<void> signOut() async {
    try {
      await _googleSignIn.signOut();
      await _auth.signOut();
      print('✅ Çıkış yapıldı');
    } catch (error) {
      print('❌ Çıkış hatası: $error');
    }
  }

  // Auth status check
  Future<bool> checkAuthStatus() async {
    return currentUser != null;
  }

  // Share code generation
  String generateShareCode() {
    if (currentUser != null) {
      final hashCode = currentUser!.uid.hashCode.abs().toString();
      return hashCode.substring(0, 6).toUpperCase();
    }
    return 'NOUSER';
  }

  // User unique ID
  String getUserUniqueId() {
    return currentUser?.uid ??
        'anonymous_${DateTime.now().millisecondsSinceEpoch}';
  }

  // Profile update
  Future<void> updateProfile({String? displayName, String? photoURL}) async {
    try {
      if (currentUser != null) {
        await currentUser!.updateDisplayName(displayName);
        await currentUser!.updatePhotoURL(photoURL);

        // Firestore'u da güncelle
        await _firestore.collection('users').doc(currentUser!.uid).update({
          'displayName': displayName,
          'photoURL': photoURL,
          'lastSeen': FieldValue.serverTimestamp(),
        });

        print('✅ Profil güncellendi');
      }
    } catch (error) {
      print('❌ Profil güncelleme hatası: $error');
    }
  }

  // Delete account
  Future<void> deleteAccount() async {
    try {
      if (currentUser != null) {
        final uid = currentUser!.uid;

        // Firestore'dan kullanıcı verilerini sil
        await _firestore.collection('users').doc(uid).delete();

        // Firebase Auth'dan hesabı sil
        await currentUser!.delete();

        print('✅ Hesap silindi');
      }
    } catch (error) {
      print('❌ Hesap silme hatası: $error');
    }
  }

  // Re-authentication check
  Future<bool> requiresRecentLogin() async {
    return false; // Şimdilik false, gerekirse implement edilecek
  }

  // Re-authenticate
  Future<void> reauthenticate() async {
    try {
      await signInWithGoogle();
      print('✅ Re-authentication başarılı');
    } catch (error) {
      print('❌ Re-authentication hatası: $error');
    }
  }
}
