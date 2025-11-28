import 'package:location/location.dart' as loc;
import 'package:geocoding/geocoding.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'dart:async';
import 'dart:io';
import 'package:path_provider/path_provider.dart';
import 'package:latlong2/latlong.dart';
import 'auth_service.dart';
import 'api_service.dart';
import 'friends_service_backend.dart';
import 'dart:math';

class LocationService {
  // Son konumu dosyaya kaydet
  Future<void> saveLastLocationToFile() async {
    if (_latitude == null || _longitude == null) return;
    try {
      final directory = await getApplicationDocumentsDirectory();
      final file = File('${directory.path}/user_location.json');
      final data = {
        'latitude': _latitude,
        'longitude': _longitude,
        'timestamp': DateTime.now().toIso8601String(),
      };
      await file.writeAsString(jsonEncode(data));
      print(
          '✅ Son konum dosyaya kaydedildi: ${data['latitude']},${data['longitude']}');
    } catch (e) {
      print('❌ Son konum dosyaya kaydedilemedi: $e');
    }
  }

  // Son kaydedilen konumu dosyadan oku
  Future<LatLng?> readLastLocationFromFile() async {
    try {
      final directory = await getApplicationDocumentsDirectory();
      final file = File('${directory.path}/user_location.json');
      if (!await file.exists()) return null;
      final content = await file.readAsString();
      final data = jsonDecode(content);
      final lat = data['latitude'] as double?;
      final lon = data['longitude'] as double?;
      if (lat != null && lon != null) {
        print('✅ Son konum dosyadan okundu: $lat,$lon');
        return LatLng(lat, lon);
      }
      return null;
    } catch (e) {
      print('❌ Son konum dosyadan okunamadı: $e');
      return null;
    }
  }

  static final LocationService _instance = LocationService._internal();
  factory LocationService() => _instance;
  LocationService._internal();

  static const String baseUrl = 'http://188.132.202.24:3000/api';
  Timer? _locationTimer;

  // Global konum bilgileri
  double? _latitude;
  double? _longitude;
  String? _locationText;
  String? _cityName;
  bool _isLocationInitialized = false;
  bool _isLocationLoading = false;

  // Getters
  double? get latitude => _latitude;
  double? get longitude => _longitude;
  String? get locationText => _locationText;
  String? get cityName => _cityName;
  bool get isLocationInitialized => _isLocationInitialized;
  bool get isLocationLoading => _isLocationLoading;

  // Alias for main.dart compatibility
  Future<bool> initialize() async {
    return await initializeLocation();
  }

  // Mevcut konumu al (WebSocket servisi için)
  Future<loc.LocationData> getCurrentLocation() async {
    try {
      loc.Location location = loc.Location();
      return await location.getLocation();
    } catch (e) {
      print('❌ Konum alınamadı: $e');
      rethrow;
    }
  }

  // Konum bilgisini uygulama başlangıcında al
  Future<bool> initializeLocation() async {
    if (_isLocationInitialized || _isLocationLoading) {
      return _isLocationInitialized;
    }

    _isLocationLoading = true;
    print('Konum servisi başlatılıyor...');

    try {
      loc.Location location = loc.Location();

      // Servis kontrol
      bool serviceEnabled = await location.serviceEnabled();
      if (!serviceEnabled) {
        serviceEnabled = await location.requestService();
        if (!serviceEnabled) {
          _setLocationError("Konum servisi kapalı");
          return false;
        }
      }

      // İzin kontrol
      loc.PermissionStatus permissionGranted = await location.hasPermission();
      if (permissionGranted == loc.PermissionStatus.denied) {
        permissionGranted = await location.requestPermission();
        if (permissionGranted != loc.PermissionStatus.granted) {
          _setLocationError("Konum izni verilmedi");
          return false;
        }
      }

      // Konum al
      loc.LocationData locationData = await location.getLocation();

      _latitude = locationData.latitude!;
      _longitude = locationData.longitude!;
      _locationText =
          "Enlem: ${_latitude!.toStringAsFixed(4)}, Boylam: ${_longitude!.toStringAsFixed(4)}";

      // Şehir bilgisini al (ReportService'ten)
      await _getCityName();

      // Konumu backend'e gönder
      await _sendLocationToBackend();

      _isLocationInitialized = true;
      _isLocationLoading = false;

      print('Konum başarıyla alındı: $_cityName ($_locationText)');
      await saveLastLocationToFile();
      return true;
    } catch (e) {
      _setLocationError("Konum alınamadı: ${e.toString()}");
      return false;
    }
  }

  Future<void> _getCityName() async {
    if (_latitude == null || _longitude == null) return;

    try {
      // ReportService'in şehir belirleme mantığını burada kullanıyoruz
      if (_isNearCity(_latitude!, _longitude!, 41.0082, 28.9784)) {
        _cityName = 'İstanbul';
      } else if (_isNearCity(_latitude!, _longitude!, 39.9334, 32.8597)) {
        _cityName = 'Ankara';
      } else if (_isNearCity(_latitude!, _longitude!, 38.4237, 27.1428)) {
        _cityName = 'İzmir';
      } else if (_isNearCity(_latitude!, _longitude!, 40.1826, 29.0665)) {
        _cityName = 'Bursa';
      } else if (_isNearCity(_latitude!, _longitude!, 36.8969, 30.7133)) {
        _cityName = 'Antalya';
      } else {
        _cityName = 'Türkiye';
      }
    } catch (e) {
      _cityName = 'Bilinmeyen Şehir';
      print('Şehir bilgisi alınamadı: $e');
    }
  }

  Future<void> _sendLocationToBackend() async {
    if (_latitude == null || _longitude == null) return;

    try {
      final friendsService = FriendsService();
      await friendsService.updateLocation(
        latitude: _latitude!,
        longitude: _longitude!,
        address: _cityName ?? _locationText,
      );
      print('📍 Konum backend\'e gönderildi: $_cityName');
    } catch (e) {
      print('❌ Konum gönderme hatası: $e');
      // Sessizce başarısız ol
    }
  }

  bool _isNearCity(double lat1, double lon1, double lat2, double lon2,
      {double thresholdKm = 50}) {
    final distance = _calculateDistance(lat1, lon1, lat2, lon2);
    return distance <= thresholdKm;
  }

  double _calculateDistance(
      double lat1, double lon1, double lat2, double lon2) {
    const double earthRadius = 6371; // km
    final double dLat = _degreesToRadians(lat2 - lat1);
    final double dLon = _degreesToRadians(lon2 - lon1);

    final double a = (dLat / 2) * (dLat / 2) +
        _degreesToRadians(lat1) *
            _degreesToRadians(lat2) *
            (dLon / 2) *
            (dLon / 2);
    final double c = 2 * atan2(sqrt(a), sqrt(1 - a));

    return earthRadius * c;
  }

  double _degreesToRadians(double degrees) {
    return degrees * (pi / 180);
  }

  void _setLocationError(String error) {
    _locationText = error;
    _cityName = "Konum Hatası";
    _isLocationInitialized = false;
    _isLocationLoading = false;
    print('Konum hatası: $error');
  }

  // Manuel konum yenileme (gerekirse)
  Future<bool> refreshLocation() async {
    _isLocationInitialized = false;
    return await initializeLocation();
  }

  // Konum bilgisini hem Firebase'a hem API'ye kaydet
  Future<void> saveLocationToFirebase() async {
    try {
      final authService = AuthService();
      final apiService = ApiService();

      if (authService.isLoggedIn && _latitude != null && _longitude != null) {
        // AuthService'e kaydet
        await authService.updateLocation(
          _latitude!,
          _longitude!,
        );

        // API'ye de kaydet
        try {
          await apiService.updateLocation(
            _latitude!,
            _longitude!,
          );
        } catch (apiError) {
          print('⚠️ API konum güncelleme hatası: $apiError');
        }

        print('✅ Konum AuthService ve API\'ye kaydedildi');
      }
    } catch (error) {
      print('❌ Konum kaydetme hatası: $error');
    }
  }

  // Otomatik konum güncellemesi başlat
  Future<void> startLocationUpdates() async {
    try {
      final loc.Location location = loc.Location();

      // Konum servisini dinle
      location.onLocationChanged.listen((loc.LocationData locationData) async {
        if (locationData.latitude != null && locationData.longitude != null) {
          _latitude = locationData.latitude;
          _longitude = locationData.longitude;

          // Şehir bilgisini güncelle
          await _getCityName();

          // Firebase'a kaydet
          await saveLocationToFirebase();

          print('📍 Konum otomatik güncellendi: $_cityName');
        }
      });

      print('✅ Otomatik konum güncellemesi başlatıldı');
    } catch (error) {
      print('❌ Otomatik konum güncelleme hatası: $error');
    }
  }

  // =============== YENİ TRACKING ÖZELLİKLERİ ===============

  // Konum tracking'i başlat (2 saatte bir)
  Future<void> startLocationTracking() async {
    print('🎯 Konum tracking başlatılıyor...');

    // İlk konumu hemen al
    await updateLocationOnAppStart();

    // 2 saatte bir konum güncellemesi
    _locationTimer = Timer.periodic(Duration(hours: 2), (timer) {
      _updateAndSendLocation();
    });

    print('✅ Konum tracking başlatıldı (2 saatte bir)');
  }

  // Konum tracking'i durdur
  void stopLocationTracking() {
    _locationTimer?.cancel();
    _locationTimer = null;
    print('🛑 Konum tracking durduruldu');
  }

  // Uygulama açıldığında konum güncelle
  Future<void> updateLocationOnAppStart() async {
    print('📍 Uygulama başlangıcında konum güncelleniyor...');
    await _updateAndSendLocation();
  }

  // Konum güncelleme ve server'a gönderme
  Future<void> _updateAndSendLocation() async {
    try {
      // Mevcut konum servisini kullan
      final bool success = await initializeLocation();

      if (success && _latitude != null && _longitude != null) {
        // Adres bilgisini al
        String address =
            await _getAddressFromCoordinates(_latitude!, _longitude!);

        // Server'a gönder
        await _sendLocationToServer(_latitude!, _longitude!, address);

        // Local'de kaydet
        await _saveLocationLocally(_latitude!, _longitude!, address);
      }
    } catch (e) {
      print('❌ Konum güncelleme hatası: $e');
    }
  }

  // Koordinatlardan adres al
  Future<String> _getAddressFromCoordinates(
      double latitude, double longitude) async {
    try {
      List<Placemark> placemarks =
          await placemarkFromCoordinates(latitude, longitude);

      if (placemarks.isNotEmpty) {
        Placemark place = placemarks[0];
        return '${place.locality ?? ''}, ${place.administrativeArea ?? ''}, ${place.country ?? ''}';
      }
    } catch (e) {
      print('⚠️ Adres alınamadı: $e');
    }
    return _cityName ?? 'Bilinmeyen Konum';
  }

  // Server'a konum gönder
  Future<void> _sendLocationToServer(
      double latitude, double longitude, String address) async {
    try {
      final authService = AuthService();
      await authService.loadUserData();
      final userId = authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış - konum gönderilmiyor');
        return;
      }

      final prefs = await SharedPreferences.getInstance();
      final fcmToken = prefs.getString('fcm_token');
      final response = await http.post(
        Uri.parse('$baseUrl/users/update-location'),
        headers: {
          'Content-Type': 'application/json',
          'x-firebase-uid': userId,
        },
        body: jsonEncode({
          'uid': userId,
          'fcmToken': fcmToken,
          'location': {
            'latitude': latitude,
            'longitude': longitude,
            'address': address,
          },
          'settings': {},
        }),
      );

      if (response.statusCode == 200) {
        print('✅ Konum server\'a gönderildi: $address');
      } else {
        print('❌ Konum gönderme hatası: ${response.body}');
      }
    } catch (e) {
      print('❌ Server konum gönderme hatası: $e');
    }
  }

  // Konumu local'de kaydet
  Future<void> _saveLocationLocally(
      double latitude, double longitude, String address) async {
    try {
      final prefs = await SharedPreferences.getInstance();

      final locationMap = {
        'latitude': latitude,
        'longitude': longitude,
        'address': address,
        'timestamp': DateTime.now().toIso8601String(),
      };

      await prefs.setString('last_location', jsonEncode(locationMap));
      print('💾 Konum local\'de kaydedildi');
    } catch (e) {
      print('❌ Local konum kaydetme hatası: $e');
    }
  }

  // Arkadaş konumlarını al
  Future<List<Map<String, dynamic>>> getFriendsLocations() async {
    try {
      final authService = AuthService();
      await authService.loadUserData();
      final userId = authService.currentUserId;

      if (userId == null) {
        print('❌ Kullanıcı girişi yapılmamış');
        return [];
      }

      final response = await http.get(
        Uri.parse('$baseUrl/friends/locations/$userId'),
        headers: {
          'Content-Type': 'application/json',
        },
      );

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        print('✅ Arkadaş konumları alındı: ${data['friendsLocations'].length}');
        return List<Map<String, dynamic>>.from(data['friendsLocations']);
      } else {
        print('❌ Arkadaş konumları alınamadı: ${response.body}');
        return [];
      }
    } catch (e) {
      print('❌ Arkadaş konumları hatası: $e');
      return [];
    }
  }

  // Harita için arkadaş konumlarını formatla
  Future<List<Map<String, dynamic>>> getFormattedFriendsForMap() async {
    try {
      final friendsService = FriendsService();
      final friends = await friendsService.getFriends();
      List<Map<String, dynamic>> friendsWithLocation = [];

      for (final friend in friends) {
        // Arkadaşın konum bilgisi var mı kontrol et
        if (friend['location'] != null) {
          final location = friend['location'];

          // latitude ve longitude var mı kontrol et
          if (location['latitude'] != null && location['longitude'] != null) {
            final lastSeenData = friend['lastSeen'];
            DateTime? lastSeenTime;

            if (lastSeenData != null) {
              if (lastSeenData is String) {
                lastSeenTime = DateTime.tryParse(lastSeenData);
              }
            }
            lastSeenTime ??= DateTime.now().subtract(const Duration(hours: 1));

            final now = DateTime.now();
            final diffMinutes = now.difference(lastSeenTime).inMinutes;

            String timeAgo;
            if (diffMinutes < 1) {
              timeAgo = 'az önce';
            } else if (diffMinutes < 60) {
              timeAgo = '${diffMinutes}dk önce';
            } else {
              final diffHours = diffMinutes ~/ 60;
              if (diffHours < 24) {
                timeAgo = '${diffHours}sa önce';
              } else {
                final diffDays = diffHours ~/ 24;
                timeAgo = '${diffDays}g önce';
              }
            }

            friendsWithLocation.add({
              'uid': friend['uid'],
              'name': friend['displayName'],
              'photoURL': friend['photoURL'],
              'latitude':
                  double.tryParse(location['latitude'].toString()) ?? 0.0,
              'longitude':
                  double.tryParse(location['longitude'].toString()) ?? 0.0,
              'address': location['address'] ?? 'Bilinmeyen konum',
              'timeAgo': timeAgo,
            });
          }
        }
      }

      print(
          '🗺️ Harita için ${friendsWithLocation.length} arkadaş konumu bulundu');
      return friendsWithLocation;
    } catch (e) {
      print('❌ Arkadaş konumları alınamadı: $e');
      return [];
    }
  }
}
