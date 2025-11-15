import 'dart:async';
import 'dart:math';
import 'package:sensors_plus/sensors_plus.dart';
// import 'package:battery_plus/battery_plus.dart'; // Optional
// import 'package:screen_state/screen_state.dart'; // Optional
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:shared_preferences/shared_preferences.dart';

/// P2P Deprem Algılama Servisi
/// Jiroskop ve ivmeölçer sensörlerini kullanarak deprem benzeri sarsıntıları algılar
class P2PEarthquakeDetectionService {
  static const String baseUrl = 'http://188.132.202.24:3000/api';

  // Sensör parametreleri - TEST İÇİN HASSAS AYARLAR
  static const double SHAKE_THRESHOLD = 1.5; // m/s² - Düşük eşik (masa sallama için)
  static const double STRONG_SHAKE_THRESHOLD = 3.0; // m/s² - Güçlü sarsıntı (daha düşük)
  static const Duration SHAKE_WINDOW =
      Duration(seconds: 2); // Sarsıntı penceresi (daha kısa)
  static const int MIN_SHAKE_COUNT = 3; // Minimum sarsıntı sayısı (daha az)
  static const Duration COOLDOWN_PERIOD =
      Duration(seconds: 30); // Tekrar gönderim engeli (test için kısa)

  // Servis durumu
  StreamSubscription<AccelerometerEvent>? _accelerometerSubscription;
  StreamSubscription<GyroscopeEvent>? _gyroscopeSubscription;
  // final Battery _battery = Battery(); // Optional - disabled
  // final Screen _screen = Screen(); // Optional - disabled

  bool _isMonitoring = false;
  bool _isCharging = false; // Varsayılan: şarj olmuyor
  bool _isScreenOff = false; // Varsayılan: ekran açık
  DateTime? _lastReportTime;

  // Sarsıntı verileri
  List<double> _recentMagnitudes = [];
  List<DateTime> _recentShakeTimes = [];
  int _shakeCount = 0;

  // Singleton
  static final P2PEarthquakeDetectionService _instance =
      P2PEarthquakeDetectionService._internal();
  factory P2PEarthquakeDetectionService() => _instance;
  P2PEarthquakeDetectionService._internal();

  /// Servisi başlat
  Future<void> startMonitoring() async {
    if (_isMonitoring) return;

    print('🔍 P2P Deprem algılama servisi başlatılıyor...');

    // Koşulları kontrol et (basitleştirilmiş - battery/screen özellikleri devre dışı)
    _isCharging = false; // Battery durumu kontrolü devre dışı
    _isScreenOff = false; // Screen durumu kontrolü devre dışı
    
    // Not: Battery ve Screen özellikleri isteğe bağlı olarak eklenebilir
    // Şu an için tüm koşullarda monitoring aktif

    // Sensörleri başlat
    _startSensorListening();

    _isMonitoring = true;
    print('✅ P2P monitoring aktif');
  }

  /// Koşulları kontrol et (basitleştirilmiş versiyon)
  Future<void> _checkConditions() async {
    // Battery ve Screen kontrolleri devre dışı
    _isCharging = false;
    _isScreenOff = false;
    
    // Her zaman monitoring aktif
  }

  /// Monitoring durumunu güncelle
  void _updateMonitoringState() {
    final shouldMonitor = _isScreenOff || _isCharging;

    if (shouldMonitor && !_isMonitoring) {
      print(
          '✅ Monitoring koşulları sağlandı (Charging: $_isCharging, Screen: ${_isScreenOff ? "OFF" : "ON"})');
      _startSensorListening();
    } else if (!shouldMonitor && _isMonitoring) {
      print(
          '⏸️ Monitoring duraklatıldı (Charging: $_isCharging, Screen: ${_isScreenOff ? "OFF" : "ON"})');
      _stopSensorListening();
    }
  }

  /// Sensör dinlemeyi başlat
  void _startSensorListening() {
    // İvmeölçer (accelerometer) - Ana sensör
    _accelerometerSubscription =
        accelerometerEvents.listen((AccelerometerEvent event) {
      _onAccelerometerData(event);
    });

    // Jiroskop (gyroscope) - Doğrulama için
    _gyroscopeSubscription = gyroscopeEvents.listen((GyroscopeEvent event) {
      _onGyroscopeData(event);
    });

    print('📡 Sensörler dinleniyor...');
  }

  /// Sensör dinlemeyi durdur
  void _stopSensorListening() {
    _accelerometerSubscription?.cancel();
    _gyroscopeSubscription?.cancel();
    _accelerometerSubscription = null;
    _gyroscopeSubscription = null;
  }

  /// İvmeölçer verisi işle
  void _onAccelerometerData(AccelerometerEvent event) {
    // Toplam ivme büyüklüğünü hesapla (yerçekimi hariç)
    final magnitude =
        sqrt(pow(event.x, 2) + pow(event.y, 2) + pow(event.z - 9.8, 2));

    // Eşik kontrolü
    if (magnitude > SHAKE_THRESHOLD) {
      _recordShake(magnitude);
    }

    // Eski verileri temizle (3 saniyeden eski)
    _cleanOldData();
  }

  /// Jiroskop verisi işle (doğrulama için)
  void _onGyroscopeData(GyroscopeEvent event) {
    // Rotasyonel hareket kontrolü (telefonu sallama vs. ayırt etmek için)
    final rotationMagnitude =
        sqrt(pow(event.x, 2) + pow(event.y, 2) + pow(event.z, 2));

    // Çok yüksek rotasyon = kasıtlı sallama (deprem değil)
    if (rotationMagnitude > 5.0) {
      // Bu kasıtlı sallama, deprem değil - verileri temizle
      _recentMagnitudes.clear();
      _recentShakeTimes.clear();
      _shakeCount = 0;
    }
  }

  /// Sarsıntıyı kaydet
  void _recordShake(double magnitude) {
    final now = DateTime.now();

    _recentMagnitudes.add(magnitude);
    _recentShakeTimes.add(now);
    _shakeCount++;

    // Güçlü sarsıntı tespiti
    if (magnitude > STRONG_SHAKE_THRESHOLD) {
      print(
          '⚠️ GÜÇLÜ SARSINTILAR ALGILANDI: ${magnitude.toStringAsFixed(2)} m/s²');
    }

    // Yeterli veri toplandıysa analiz et
    if (_shakeCount >= MIN_SHAKE_COUNT) {
      _analyzeShakePattern();
    }
  }

  /// Eski verileri temizle
  void _cleanOldData() {
    final cutoffTime = DateTime.now().subtract(SHAKE_WINDOW);

    // 3 saniyeden eski verileri çıkar
    while (_recentShakeTimes.isNotEmpty &&
        _recentShakeTimes.first.isBefore(cutoffTime)) {
      _recentShakeTimes.removeAt(0);
      _recentMagnitudes.removeAt(0);
      _shakeCount--;
    }
  }

  /// Sarsıntı paternini analiz et
  void _analyzeShakePattern() {
    if (_recentMagnitudes.isEmpty) return;

    // İstatistikler
    final avgMagnitude =
        _recentMagnitudes.reduce((a, b) => a + b) / _recentMagnitudes.length;
    final maxMagnitude = _recentMagnitudes.reduce((a, b) => a > b ? a : b);
    final duration = _recentShakeTimes.last.difference(_recentShakeTimes.first);

    // Deprem olasılığı skoru (0-100)
    final score = _calculateEarthquakeProbability(
      avgMagnitude: avgMagnitude,
      maxMagnitude: maxMagnitude,
      shakeCount: _shakeCount,
      duration: duration,
    );

    print('📊 Sarsıntı Analizi:');
    print('   - Ortalama: ${avgMagnitude.toStringAsFixed(2)} m/s²');
    print('   - Maksimum: ${maxMagnitude.toStringAsFixed(2)} m/s²');
    print('   - Sayı: $_shakeCount');
    print('   - Süre: ${duration.inMilliseconds}ms');
    print('   - Skor: ${score.toStringAsFixed(1)}/100');

    // Yüksek skor = server'a bildir
    if (score >= 60.0) {
      _reportToServer(
        avgMagnitude: avgMagnitude,
        maxMagnitude: maxMagnitude,
        shakeCount: _shakeCount,
        duration: duration,
        score: score,
      );
    }

    // Verileri temizle
    _recentMagnitudes.clear();
    _recentShakeTimes.clear();
    _shakeCount = 0;
  }

  /// Deprem olasılık skoru hesapla
  double _calculateEarthquakeProbability({
    required double avgMagnitude,
    required double maxMagnitude,
    required int shakeCount,
    required Duration duration,
  }) {
    double score = 0.0;

    // 1. Ortalama büyüklük (0-40 puan)
    if (avgMagnitude > 5.0)
      score += 40.0;
    else if (avgMagnitude > 4.0)
      score += 30.0;
    else if (avgMagnitude > 3.0)
      score += 20.0;
    else
      score += (avgMagnitude / 3.0) * 20.0;

    // 2. Maksimum büyüklük (0-30 puan)
    if (maxMagnitude > 8.0)
      score += 30.0;
    else if (maxMagnitude > 6.0)
      score += 25.0;
    else if (maxMagnitude > 4.0)
      score += 15.0;
    else
      score += (maxMagnitude / 8.0) * 30.0;

    // 3. Sarsıntı sayısı (0-20 puan)
    if (shakeCount > 10)
      score += 20.0;
    else if (shakeCount > 7)
      score += 15.0;
    else
      score += (shakeCount / 10.0) * 20.0;

    // 4. Süre (0-10 puan) - Uzun süre = gerçek deprem
    final durationSeconds = duration.inMilliseconds / 1000.0;
    if (durationSeconds >= 2.0)
      score += 10.0;
    else if (durationSeconds >= 1.0)
      score += 5.0;
    else
      score += (durationSeconds / 2.0) * 10.0;

    return score.clamp(0.0, 100.0);
  }

  /// Server'a bildir
  Future<void> _reportToServer({
    required double avgMagnitude,
    required double maxMagnitude,
    required int shakeCount,
    required Duration duration,
    required double score,
  }) async {
    // Cooldown kontrolü (son 2 dakikada rapor gönderildiyse tekrar gönderme)
    if (_lastReportTime != null) {
      final timeSinceLastReport = DateTime.now().difference(_lastReportTime!);
      if (timeSinceLastReport < COOLDOWN_PERIOD) {
        print(
            '⏳ Cooldown: ${COOLDOWN_PERIOD.inSeconds - timeSinceLastReport.inSeconds}s kaldı');
        return;
      }
    }

    try {
      print(
          '🚨 SERVER\'A RAPOR GÖNDERİLİYOR (Skor: ${score.toStringAsFixed(1)})');

      // Kullanıcı bilgilerini al
      final prefs = await SharedPreferences.getInstance();
      final userId = prefs.getString('userId');

      // Konum al (son bilinen konum)
      final latitude = prefs.getDouble('last_latitude');
      final longitude = prefs.getDouble('last_longitude');

      if (latitude == null || longitude == null) {
        print('⚠️ Konum bilgisi yok, rapor gönderilemedi');
        return;
      }

      // Cihaz bilgileri
      final deviceId = prefs.getString('deviceId');
      final batteryLevel = 100; // Battery kontrolü devre dışı

      // Rapor payload
      final payload = {
        'userId': userId,
        'deviceId': deviceId,
        'location': {
          'latitude': latitude,
          'longitude': longitude,
        },
        'sensorData': {
          'avgMagnitude': avgMagnitude,
          'maxMagnitude': maxMagnitude,
          'shakeCount': shakeCount,
          'durationMs': duration.inMilliseconds,
          'probabilityScore': score,
        },
        'deviceState': {
          'batteryLevel': batteryLevel,
          'isCharging': _isCharging,
          'isScreenOff': _isScreenOff,
        },
        'timestamp': DateTime.now().toIso8601String(),
      };

      final response = await http
          .post(
            Uri.parse('$baseUrl/p2p/shake-report'),
            headers: {'Content-Type': 'application/json'},
            body: json.encode(payload),
          )
          .timeout(Duration(seconds: 10));

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        print('✅ Rapor gönderildi: ${data['message']}');

        // Server'dan gelen analiz sonucu
        if (data['analysis'] != null) {
          final analysis = data['analysis'];
          print('📊 Server Analizi:');
          print('   - Bölge: ${analysis['region']}');
          print('   - Toplam Rapor: ${analysis['totalReports']}');
          print('   - Deprem Olasılığı: ${analysis['earthquakeProbability']}%');

          // Eğer server deprem algıladıysa kullanıcıya göster
          if (analysis['isEarthquakeDetected'] == true) {
            print('🚨🚨🚨 DEPREM ALGILANDI! 🚨🚨🚨');
            // LocalNotification göster
            _showEarthquakeAlert(analysis);
          }
        }

        _lastReportTime = DateTime.now();
      } else {
        print('❌ Rapor gönderilemedi: ${response.statusCode}');
      }
    } catch (e) {
      print('❌ Server rapor hatası: $e');
    }
  }

  /// Deprem uyarısı göster
  void _showEarthquakeAlert(Map<String, dynamic> analysis) {
    // LocalNotification servisi üzerinden bildirim göster
    // Bu kısım NotificationService'e entegre edilecek
    print('🔔 Kullanıcıya deprem uyarısı gösteriliyor...');
  }

  /// Servisi durdur
  void stopMonitoring() {
    _stopSensorListening();
    _isMonitoring = false;
    print('⏹️ P2P monitoring durduruldu');
  }

  /// Servis durumu
  bool get isMonitoring => _isMonitoring;
}
