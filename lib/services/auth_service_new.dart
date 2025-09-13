import 'package:google_sign_in/google_sign_in.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class AuthService {
  static final AuthService _instance = AuthService._internal();
  factory AuthService() => _instance;
  AuthService._internal();

  final GoogleSignIn _googleSignIn = GoogleSignIn();
  final FirebaseAuth _auth = FirebaseAuth.instance;
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  User? get currentUser => _auth.currentUser;
  bool get isLoggedIn => currentUser != null;

  String? get userId => currentUser?.uid;
  String? get userEmail => currentUser?.email;
  String? get userName => currentUser?.displayName;
  String? get userPhotoUrl => currentUser?.photoURL;

  // Google Sign In
  Future<bool> signInWithGoogle() async {
    try {
      print('🔐 Google Sign-In başlatılıyor...');

      // Google Sign-In flow
      final GoogleSignInAccount? googleUser = await _googleSignIn.signIn();
      if (googleUser == null) {
        print('❌ Google Sign-In iptal edildi');
        return false;
      }

      final GoogleSignInAuthentication googleAuth =
          await googleUser.authentication;

      // Firebase credential oluştur
      final credential = GoogleAuthProvider.credential(
        accessToken: googleAuth.accessToken,
        idToken: googleAuth.idToken,
      );

      // Firebase'e giriş yap
      final UserCredential userCredential =
          await _auth.signInWithCredential(credential);
      final User? user = userCredential.user;

      if (user != null) {
        print('✅ Google Sign-In başarılı: ${user.email}');

        // Kullanıcı bilgilerini Firestore'a kaydet/güncelle
        await _saveUserToFirestore(user);

        return true;
      } else {
        print('❌ Firebase authentication başarısız');
        return false;
      }
    } catch (error) {
      print('❌ Google Sign-In hatası: $error');
      return false;
    }
  }

  // Kullanıcı bilgilerini Firestore'a kaydet
  Future<void> _saveUserToFirestore(User user) async {
    try {
      await _firestore.collection('users').doc(user.uid).set({
        'uid': user.uid,
        'email': user.email,
        'displayName': user.displayName,
        'photoURL': user.photoURL,
        'createdAt': FieldValue.serverTimestamp(),
        'lastSeen': FieldValue.serverTimestamp(),
        'shareCode': generateShareCode(),
      }, SetOptions(merge: true));

      print('✅ Kullanıcı Firestore\'a kaydedildi');
    } catch (error) {
      print('❌ Firestore kaydetme hatası: $error');
    }
  }

  // Konum güncelleme
  Future<void> updateLocation(
      double latitude, double longitude, String address) async {
    try {
      if (currentUser == null) return;

      await _firestore.collection('users').doc(currentUser!.uid).update({
        'location': {
          'latitude': latitude,
          'longitude': longitude,
          'address': address,
          'lastUpdate': FieldValue.serverTimestamp(),
        },
        'lastSeen': FieldValue.serverTimestamp(),
      });

      print('✅ Konum güncellendi: $address');
    } catch (error) {
      print('❌ Konum güncelleme hatası: $error');
    }
  }

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
