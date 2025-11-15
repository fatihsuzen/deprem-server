import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:location/location.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'user_preferences_service.dart';

class LocationUpdateService {
  static const String baseUrl = 'http://188.132.202.24:3000/api'; // VDS IP
  static const Duration updateInterval = Duration(hours: 2); // 2 saatte bir

  final Location _location = Location();
  Timer? _periodicTimer;
  bool _isRunning = false;

  // Singleton pattern
  static final LocationUpdateService _instance =
      LocationUpdateService._internal();
  factory LocationUpdateService() => _instance;
  LocationUpdateService._internal();

  /// Periyodik konum güncelleme başlat
  Future<void> startPeriodicUpdates() async {
    if (_isRunning) {
      print('⚠️  Konum güncellemeleri zaten çalışıyor');
      return;
    }

    print('🚀 Periyodik konum güncellemeleri başlatılıyor...');
    _isRunning = true;

    // İlk güncellemeyi hemen yap
    await sendLocationUpdate();

    // 2 saatte bir güncelle
    _periodicTimer = Timer.periodic(updateInterval, (timer) async {
      await sendLocationUpdate();
    });

    print(
        '✅ Periyodik konum güncellemeleri başlatıldı (${updateInterval.inHours} saat aralıklarla)');
  }

  /// Periyodik güncellemeleri durdur
  void stopPeriodicUpdates() {
    if (_periodicTimer != null) {
      _periodicTimer!.cancel();
      _periodicTimer = null;
      _isRunning = false;
      print('⏹️  Periyodik konum güncellemeleri durduruldu');
    }
  }

  /// Konum iznini kontrol et ve iste
  Future<bool> checkAndRequestPermission() async {
    bool serviceEnabled;
    PermissionStatus permissionGranted;

    // Servis aktif mi kontrol et
    serviceEnabled = await _location.serviceEnabled();
    if (!serviceEnabled) {
      serviceEnabled = await _location.requestService();
      if (!serviceEnabled) {
        print('❌ Konum servisi kapalı');
        return false;
      }
    }

    // İzin kontrolü
    permissionGranted = await _location.hasPermission();
    if (permissionGranted == PermissionStatus.denied) {
      permissionGranted = await _location.requestPermission();
      if (permissionGranted != PermissionStatus.granted) {
        print('❌ Konum izni verilmedi');
        return false;
      }
    }

    print('✅ Konum izni var');
    return true;
  }

  /// Mevcut konumu al ve sunucuya gönder
  Future<bool> sendLocationUpdate() async {
    try {
      // Konum paylaşım ayarını kontrol et
      final prefsService = UserPreferencesService();
      final shareLocation = await prefsService.getShareLocation();

      if (!shareLocation) {
        print('⏭️  Konum paylaşımı kapalı, güncelleme atlandı');
        return false;
      }

      // İzin kontrolü
      final hasPermission = await checkAndRequestPermission();
      if (!hasPermission) {
        print('⏭️  Konum izni yok, güncelleme atlandı');
        return false;
      }

      // Firebase UID al
      final user = FirebaseAuth.instance.currentUser;
      if (user == null) {
        print('⚠️  Kullanıcı oturum açmamış, konum güncellenemedi');
        return false;
      }

      // Mevcut konumu al
      final locationData = await _location.getLocation();

      if (locationData.latitude == null || locationData.longitude == null) {
        print('❌ Konum bilgisi alınamadı');
        return false;
      }

      print(
          '📍 Konum alındı: ${locationData.latitude}, ${locationData.longitude}');

      // Sunucuya gönder
      final response = await http
          .post(
            Uri.parse('$baseUrl/users/update-location'),
            headers: {
              'Content-Type': 'application/json',
              'x-firebase-uid': user.uid,
            },
            body: jsonEncode({
              'latitude': locationData.latitude,
              'longitude': locationData.longitude,
              'address': '', // Opsiyonel: Geocoding ile adres eklenebilir
            }),
          )
          .timeout(const Duration(seconds: 15));

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        print(
            '✅ Konum sunucuya gönderildi: ${data['location']['latitude']}, ${data['location']['longitude']}');

        // Son güncelleme zamanını kaydet
        await _saveLastUpdateTime();

        // SharedPreferences'a da kaydet (History ekranı için)
        await _saveLocationToPrefs(
            locationData.latitude!, locationData.longitude!);

        return true;
      } else {
        print(
            '❌ Konum gönderme hatası: ${response.statusCode} - ${response.body}');
        return false;
      }
    } catch (e) {
      print('❌ Konum güncelleme hatası: $e');
      return false;
    }
  }

  /// Bildirim ayarlarını sunucuya gönder
  Future<bool> sendNotificationSettings({
    required double notificationRadius,
    required double minMagnitude,
    required double maxMagnitude,
    bool? shareLocationWithFriends,
  }) async {
    try {
      final user = FirebaseAuth.instance.currentUser;
      if (user == null) {
        print('⚠️  Kullanıcı oturum açmamış');
        return false;
      }

      final body = <String, dynamic>{
        'notificationRadius': notificationRadius,
        'minMagnitude': minMagnitude,
        'maxMagnitude': maxMagnitude,
      };

      if (shareLocationWithFriends != null) {
        body['shareLocationWithFriends'] = shareLocationWithFriends;
      }

      final response = await http
          .post(
            Uri.parse('$baseUrl/users/notification-settings'),
            headers: {
              'Content-Type': 'application/json',
              'x-firebase-uid': user.uid,
            },
            body: jsonEncode(body),
          )
          .timeout(const Duration(seconds: 10));

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        print('✅ Bildirim ayarları sunucuya gönderildi');
        print('   Yarıçap: ${data['settings']['notificationRadius']} km');
        print(
            '   Büyüklük: ${data['settings']['minMagnitude']}-${data['settings']['maxMagnitude']}');
        if (shareLocationWithFriends != null) {
          print(
              '   Konum paylaşımı: ${data['settings']['shareLocationWithFriends']}');
        }
        return true;
      } else {
        print('❌ Ayar gönderme hatası: ${response.statusCode}');
        return false;
      }
    } catch (e) {
      print('❌ Bildirim ayarları gönderme hatası: $e');
      return false;
    }
  }

  /// Device token'ı sunucuya gönder (FCM için)
  Future<bool> sendDeviceToken(String token, String platform) async {
    try {
      final user = FirebaseAuth.instance.currentUser;
      if (user == null) {
        print('⚠️  Kullanıcı oturum açmamış');
        return false;
      }

      final response = await http
          .post(
            Uri.parse('$baseUrl/users/device-token'),
            headers: {
              'Content-Type': 'application/json',
              'x-firebase-uid': user.uid,
            },
            body: jsonEncode({
              'token': token,
              'platform': platform,
            }),
          )
          .timeout(const Duration(seconds: 10));

      if (response.statusCode == 200) {
        print('✅ Device token sunucuya kaydedildi ($platform)');
        return true;
      } else {
        print('❌ Device token kaydetme hatası: ${response.statusCode}');
        return false;
      }
    } catch (e) {
      print('❌ Device token gönderme hatası: $e');
      return false;
    }
  }

  /// Son güncelleme zamanını kaydet
  Future<void> _saveLastUpdateTime() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setInt(
        'last_location_update', DateTime.now().millisecondsSinceEpoch);
  }

  /// Konumu SharedPreferences'a kaydet (History ekranı için)
  Future<void> _saveLocationToPrefs(double latitude, double longitude) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setDouble('lastLatitude', latitude);
    await prefs.setDouble('lastLongitude', longitude);
    print('💾 Konum SharedPreferences\'a kaydedildi: $latitude, $longitude');
  }

  /// Son güncelleme zamanını al
  Future<DateTime?> getLastUpdateTime() async {
    final prefs = await SharedPreferences.getInstance();
    final timestamp = prefs.getInt('last_location_update');
    if (timestamp != null) {
      return DateTime.fromMillisecondsSinceEpoch(timestamp);
    }
    return null;
  }

  /// Uygulama açılışında konum gönder (eğer 2 saatten fazla geçmişse)
  Future<void> sendLocationOnAppStart() async {
    print('🔄 Uygulama açılışı: Konum kontrolü yapılıyor...');

    final lastUpdate = await getLastUpdateTime();

    if (lastUpdate == null) {
      // Hiç güncelleme yapılmamış
      print('📍 İlk konum güncellemesi yapılıyor...');
      await sendLocationUpdate();
      return;
    }

    final timeSinceLastUpdate = DateTime.now().difference(lastUpdate);

    if (timeSinceLastUpdate >= updateInterval) {
      print(
          '📍 Son güncellemeden ${timeSinceLastUpdate.inMinutes} dakika geçmiş, konum güncelleniyor...');
      await sendLocationUpdate();
    } else {
      final remainingMinutes =
          updateInterval.inMinutes - timeSinceLastUpdate.inMinutes;
      print(
          '⏭️  Son güncelleme ${timeSinceLastUpdate.inMinutes} dakika önce, ${remainingMinutes} dakika sonra güncellenecek');
    }
  }

  /// Servis durumu
  bool get isRunning => _isRunning;

  /// Dispose
  void dispose() {
    stopPeriodicUpdates();
  }
}
