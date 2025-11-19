import 'package:flutter/foundation.dart';
import 'dart:async';
import 'dart:math' as math;
import 'package:socket_io_client/socket_io_client.dart' as IO;
import 'notification_service.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'location_service.dart';

class EarthquakeWebSocketService {
  // P2P deprem bildirimi gönder
  void sendP2PEarthquakeReport(Map<String, dynamic> payload) {
    if (_socket != null && _isConnected) {
      print('🌍 WebSocket ile P2P deprem bildirimi gönderiliyor: $payload');
      _socket!.emit('p2p_earthquake_report', payload);
    } else {
      print('❌ WebSocket bağlı değil, P2P deprem bildirimi gönderilemedi');
    }
  }

  static final EarthquakeWebSocketService _instance =
      EarthquakeWebSocketService._internal();
  factory EarthquakeWebSocketService() => _instance;
  EarthquakeWebSocketService._internal();

  IO.Socket? _socket;
  final NotificationService _notificationService = NotificationService();
  final LocationService _locationService = LocationService();
  bool _isConnected = false;

  // Server URL - değiştirin
  static const String SERVER_URL = 'http://188.132.202.24:3000';

  Future<void> connect() async {
    if (_isConnected) {
      print('✅ WebSocket zaten bağlı');
      return;
    }

    try {
      print('🔌 WebSocket bağlanıyor: $SERVER_URL');

      // Socket.IO bağlantısı
      _socket = IO.io(
        SERVER_URL,
        IO.OptionBuilder()
            .setTransports(['websocket'])
            .enableAutoConnect()
            .setReconnectionAttempts(999)
            .setReconnectionDelay(2000)
            .build(),
      );

      // Bağlantı olayları
      _socket?.on('connect', (_) {
        print('✅ WebSocket bağlandı!');
        _isConnected = true;
        _registerDevice();
      });

      _socket?.on('disconnect', (_) {
        print('❌ WebSocket bağlantısı kesildi');
        _isConnected = false;
      });

      _socket?.on('error', (error) {
        print('❌ WebSocket hatası: $error');
      });

      _socket?.on('reconnect', (attempt) {
        print('🔄 WebSocket yeniden bağlanıyor... (deneme: $attempt)');
      });

      // DEPREM UYARI OLAYLARI
      _socket?.on('earthquake_warning', (data) {
        print('🚨 DEPREM UYARISI ALINDI: $data');
        _handleEarthquakeWarning(data);
      });

      _socket?.on('earthquake_alert', (data) {
        print('🚨🚨 DEPREM ALERT ALINDI: $data');
        _handleEarthquakeAlert(data);
      });

      _socket?.on('p2p_earthquake_detected', (data) {
        print('🌍 P2P DEPREM ALGILANDI: $data');
        _handleP2PEarthquake(data);
      });

      _socket?.connect();
    } catch (e) {
      print('❌ WebSocket bağlantı hatası: $e');
    }
  }

  // Cihazı server'a kaydet
  Future<void> _registerDevice() async {
    try {
      final prefs = await SharedPreferences.getInstance();
      final userId = prefs.getString('userId') ??
          'guest_${DateTime.now().millisecondsSinceEpoch}';
      final deviceId = prefs.getString('deviceId') ??
          'device_${DateTime.now().millisecondsSinceEpoch}';

      // Konum al
      final position = await _locationService.getCurrentLocation();
      if (position.latitude == null || position.longitude == null) {
        print('⚠️ Konum bilgisi eksik');
        return;
      }

      final deviceData = {
        'userId': userId,
        'deviceId': deviceId,
        'location': {
          'latitude': position.latitude!,
          'longitude': position.longitude!,
        },
        'platform': defaultTargetPlatform.toString(),
        'timestamp': DateTime.now().toIso8601String(),
      };

      print('📡 Cihaz kaydediliyor: $deviceData');
      _socket?.emit('register', deviceData);

      // User ID ve Device ID'yi kaydet
      await prefs.setString('userId', userId);
      await prefs.setString('deviceId', deviceId);
    } catch (e) {
      print('❌ Cihaz kayıt hatası: $e');
    }
  }

  // Kullanıcının mevcut konumunu al
  Future<Map<String, double>?> _getUserLocation() async {
    try {
      final position = await _locationService.getCurrentLocation();
      if (position.latitude == null || position.longitude == null) {
        return null;
      }
      return {
        'latitude': position.latitude!,
        'longitude': position.longitude!,
      };
    } catch (e) {
      print('⚠️ Konum alınamadı: $e');
      return null;
    }
  }

  // Haversine mesafe hesaplama (km)
  double _calculateDistance(
    double lat1,
    double lon1,
    double lat2,
    double lon2,
  ) {
    const double earthRadius = 6371; // km
    final dLat = _toRadians(lat2 - lat1);
    final dLon = _toRadians(lon2 - lon1);

    final a = (math.sin(dLat / 2) * math.sin(dLat / 2)) +
        math.cos(_toRadians(lat1)) *
            math.cos(_toRadians(lat2)) *
            (math.sin(dLon / 2) * math.sin(dLon / 2));

    final c = 2 * math.asin(math.sqrt(a));
    return earthRadius * c;
  }

  double _toRadians(double degrees) => degrees * (math.pi / 180);

  // Deprem uyarısı işle
  Future<void> _handleEarthquakeWarning(dynamic data) async {
    try {
      final magnitude = (data['magnitude'] ?? 0.0).toDouble();
      final epicenter = data['epicenter'];
      final earthquakeLat = (epicenter['latitude'] ?? 0.0).toDouble();
      final earthquakeLon = (epicenter['longitude'] ?? 0.0).toDouble();

      // Kullanıcının konumunu al
      final userLocation = await _getUserLocation();
      if (userLocation == null) {
        print('⚠️ Kullanıcı konumu alınamadı, bildirim gönderilemiyor');
        return;
      }

      final userLat = userLocation['latitude']!;
      final userLon = userLocation['longitude']!;

      // Mesafeyi hesapla
      final distance =
          _calculateDistance(userLat, userLon, earthquakeLat, earthquakeLon);

      print('📍 Deprem mesafesi: ${distance.toStringAsFixed(1)} km');

      // Kullanıcının bildirim ayarlarını kontrol et
      final prefs = await SharedPreferences.getInstance();
      final notificationRadius = prefs.getDouble('notificationRadius') ?? 50.0;
      final minMagnitude = prefs.getDouble('minMagnitude') ?? 4.0;

      if (magnitude < minMagnitude) {
        print(
            '⚠️ Deprem büyüklüğü minimum eşiğin altında: M$magnitude < M$minMagnitude');
        return;
      }

      if (distance > notificationRadius) {
        print(
            '⚠️ Deprem yarıçap dışında: ${distance.toStringAsFixed(1)} km > ${notificationRadius.toInt()} km');
        return;
      }

      // TAM EKRAN UYARI GÖSTER
      await _notificationService.showFullScreenEarthquakeAlert(
        magnitude: magnitude,
        location: data['place'] ?? 'Bilinmeyen Konum',
        distance: distance,
        source: data['source'] ?? 'AFAD',
        earthquakeLat: earthquakeLat,
        earthquakeLon: earthquakeLon,
        userLat: userLat,
        userLon: userLon,
      );

      print('✅ Tam ekran deprem uyarısı gösterildi');
    } catch (e) {
      print('❌ Deprem uyarısı işleme hatası: $e');
    }
  }

  // Deprem alert işle (daha kritik)
  Future<void> _handleEarthquakeAlert(dynamic data) async {
    try {
      print('🚨 Alert data işleniyor: $data');

      final magnitude = (data['magnitude'] ?? 0.0).toDouble();
      final location = data['location'] ?? 'Bilinmeyen Konum';

      // Koordinatlar direkt data'da (epicenter altında değil)
      final earthquakeLat = (data['lat'] ?? 0.0).toDouble();
      final earthquakeLon = (data['lon'] ?? 0.0).toDouble();

      // Kullanıcının konumunu al
      final userLocation = await _getUserLocation();
      if (userLocation == null) {
        print('⚠️ Kullanıcı konumu alınamadı, bildirim gönderilemiyor');
        return;
      }

      final userLat = userLocation['latitude']!;
      final userLon = userLocation['longitude']!;

      // Mesafeyi hesapla
      final distance =
          _calculateDistance(userLat, userLon, earthquakeLat, earthquakeLon);

      print('📍 Deprem mesafesi: ${distance.toStringAsFixed(1)} km');

      // Kullanıcının bildirim ayarlarını kontrol et
      final prefs = await SharedPreferences.getInstance();
      final notificationRadius =
          prefs.getDouble('notification_radius') ?? 100.0;
      final minMagnitude = prefs.getDouble('min_magnitude') ?? 2.5;

      if (magnitude < minMagnitude) {
        print(
            '⚠️ Deprem büyüklüğü minimum eşiğin altında: M$magnitude < M$minMagnitude');
        return;
      }

      if (distance > notificationRadius) {
        print(
            '⚠️ Deprem yarıçap dışında: ${distance.toStringAsFixed(1)} km > ${notificationRadius.toInt()} km');
        return;
      }

      print('✅ Bildirim koşulları sağlandı, tam ekran uyarı gösteriliyor...');

      // TAM EKRAN UYARI GÖSTER
      await _notificationService.showFullScreenEarthquakeAlert(
        magnitude: magnitude,
        location: location,
        distance: distance,
        source: data['source'] ?? 'TEST',
        earthquakeLat: earthquakeLat,
        earthquakeLon: earthquakeLon,
        userLat: userLat,
        userLon: userLon,
      );

      print('✅ Tam ekran deprem uyarısı gösterildi');
    } catch (e, stackTrace) {
      print('❌ Deprem alert işleme hatası: $e');
      print('Stack trace: $stackTrace');
    }
  }

  // P2P deprem tespiti işle
  Future<void> _handleP2PEarthquake(dynamic data) async {
    try {
      print('🌍 P2P DEPREM: ${data.toString()}');

      final earthquake = data['earthquake'];
      if (earthquake == null) return;

      final magnitude =
          (earthquake['mag'] ?? earthquake['magnitude'] ?? 0.0).toDouble();
      final coordinates = earthquake['coordinates'];
      final earthquakeLat = (coordinates['coordinates']?[1] ?? 0.0).toDouble();
      final earthquakeLon = (coordinates['coordinates']?[0] ?? 0.0).toDouble();

      // Kullanıcının konumunu al
      final userLocation = await _getUserLocation();
      if (userLocation == null) {
        print('⚠️ Kullanıcı konumu alınamadı');
        return;
      }

      final userLat = userLocation['latitude']!;
      final userLon = userLocation['longitude']!;

      // Mesafeyi hesapla
      final distance =
          _calculateDistance(userLat, userLon, earthquakeLat, earthquakeLon);

      print('📍 P2P Deprem mesafesi: ${distance.toStringAsFixed(1)} km');

      // Kullanıcının bildirim ayarlarını kontrol et
      final prefs = await SharedPreferences.getInstance();
      final notificationRadius = prefs.getDouble('notificationRadius') ?? 50.0;

      if (distance > notificationRadius) {
        print('⚠️ P2P Deprem yarıçap dışında');
        return;
      }

      // P2P depremleri için minimum büyüklük 3.0
      if (magnitude < 3.0) {
        print('⚠️ P2P Deprem çok küçük: M$magnitude');
        return;
      }

      // TAM EKRAN UYARI GÖSTER (P2P)
      await _notificationService.showFullScreenEarthquakeAlert(
        magnitude: magnitude,
        location: earthquake['place'] ?? 'P2P Detected',
        distance: distance,
        source: 'P2P',
        earthquakeLat: earthquakeLat,
        earthquakeLon: earthquakeLon,
        userLat: userLat,
        userLon: userLon,
      );

      print('✅ P2P tam ekran uyarısı gösterildi');
    } catch (e) {
      print('❌ P2P deprem işleme hatası: $e');
    }
  }

  // Bağlantıyı kes
  void disconnect() {
    _socket?.disconnect();
    _socket?.dispose();
    _isConnected = false;
    print('🔌 WebSocket bağlantısı kapatıldı');
  }

  // Bağlantı durumunu kontrol et
  bool get isConnected => _isConnected;
}
