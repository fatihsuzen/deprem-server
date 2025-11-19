import 'dart:async';
import 'dart:math';
import 'package:sensors_plus/sensors_plus.dart';
// import 'package:battery_plus/battery_plus.dart'; // Optional
// import 'package:screen_state/screen_state.dart'; // Optional
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'notification_service.dart';
import 'earthquake_websocket_service.dart';
import 'package:shared_preferences/shared_preferences.dart';

/// P2P Deprem Algılama Servisi
/// Jiroskop ve ivmeölçer sensörlerini kullanarak deprem benzeri sarsıntıları algılar
class P2PEarthquakeDetectionService {
  static const String baseUrl = 'http://188.132.202.24:3000/api';

  // Sensör parametreleri - GERÇEKÇİ DEPREM ALGILAMA
  static const double GRAVITY = 9.8; // m/s² - Yer çekimi
  static const double NOISE_THRESHOLD = 0.3; // m/s² - Normal titreşim eşiği
  static const double SHAKE_THRESHOLD =
      0.8; // m/s² - Hafif sarsıntı (3.0 deprem için)
  static const double STRONG_SHAKE_THRESHOLD = 2.0; // m/s² - Güçlü sarsıntı
  static const Duration SHAKE_WINDOW = Duration(seconds: 3); // Deprem süresi
  static const int MIN_SHAKE_COUNT = 5; // Minimum ani değişim sayısı
  static const Duration COOLDOWN_PERIOD =
      Duration(minutes: 2); // Tekrar rapor engeli

  // Servis durumu
  StreamSubscription<AccelerometerEvent>? _accelerometerSubscription;
  StreamSubscription<GyroscopeEvent>? _gyroscopeSubscription;
  bool _isMonitoring = false;
  bool _isCharging = false;
  bool _isScreenOff = false;
  DateTime? _lastReportTime;

  // Gravity filtreleme için baseline
  double _baselineX = 0.0;
  double _baselineY = 0.0;
  double _baselineZ = GRAVITY;
  int _calibrationCount = 0;
  static const int CALIBRATION_SAMPLES = 20; // İlk 20 örnek ile kalibrasyon

  // Önceki değerler (delta hesabı için)
  double _prevMagnitude = 0.0;
  DateTime? _prevTime;

  // Sarsıntı verileri
  List<double> _recentMagnitudes = [];
  List<DateTime> _recentShakeTimes = [];
  List<double> _recentDeltas = []; // Ani değişimler
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


  /// İvmeölçer verisi işle
  void _onAccelerometerData(AccelerometerEvent event) {
    final now = DateTime.now();

    // 1. KALİBRASYON: İlk 20 örnekte baseline oluştur (telefon sabit dururken)
    if (_calibrationCount < CALIBRATION_SAMPLES) {
      _baselineX += event.x;
      _baselineY += event.y;
      _baselineZ += event.z;
      _calibrationCount++;

      if (_calibrationCount == CALIBRATION_SAMPLES) {
        _baselineX /= CALIBRATION_SAMPLES;
        _baselineY /= CALIBRATION_SAMPLES;
        _baselineZ /= CALIBRATION_SAMPLES;
        print(
            '📐 Kalibrasyon tamamlandı: baseline = (${_baselineX.toStringAsFixed(2)}, ${_baselineY.toStringAsFixed(2)}, ${_baselineZ.toStringAsFixed(2)})');
      }
      return;
    }

    // 2. GRAVİTY FİLTRELEME: Baseline'dan sapmaları hesapla (sadece dinamik hareket)
    final deltaX = event.x - _baselineX;
    final deltaY = event.y - _baselineY;
    final deltaZ = event.z - _baselineZ;

    // 3. TOPLAM HASSASİYET: Üç eksendeki değişimin toplamı
    final magnitude = sqrt(pow(deltaX, 2) + pow(deltaY, 2) + pow(deltaZ, 2));

    // 4. ANİ DEĞİŞİM: Önceki ölçümle arasındaki fark (jerk/sarsıntı)
    double delta = 0.0;
    if (_prevTime != null) {
      final timeDiff = now.difference(_prevTime!).inMilliseconds / 1000.0;
      if (timeDiff > 0) {
        delta =
            (magnitude - _prevMagnitude).abs() / timeDiff; // m/s² değişim hızı
      }
    }
    _prevMagnitude = magnitude;
    _prevTime = now;

    // 5. NOISE FİLTRELEME: Normal titreşimleri yoksay
    if (magnitude < NOISE_THRESHOLD) {
      return; // Çok küçük, önemsiz
    }

    // 6. SARSINTIYI KAYDET: Eşik aşıldıysa kaydet
    if (magnitude > SHAKE_THRESHOLD || delta > SHAKE_THRESHOLD) {
      _recordShake(magnitude, delta);
    }

    // 7. ESKİ VERİLERİ TEMİZLE
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
  void _recordShake(double magnitude, double delta) {
    final now = DateTime.now();

    _recentMagnitudes.add(magnitude);
    _recentShakeTimes.add(now);
    _recentDeltas.add(delta);
    _shakeCount++;

    // Güçlü sarsıntı tespiti (hem büyüklük hem de ani değişim)
    if (magnitude > STRONG_SHAKE_THRESHOLD || delta > STRONG_SHAKE_THRESHOLD) {
      print(
          '⚠️ GÜÇLÜ SARSINTILAR: mag=${magnitude.toStringAsFixed(2)} m/s², delta=${delta.toStringAsFixed(2)} m/s²/s');
    }

    // Yeterli veri toplandıysa analiz et
    if (_shakeCount >= MIN_SHAKE_COUNT) {
      _analyzeShakePattern();
    }
  }

  /// Eski verileri temizle
  void _cleanOldData() {
    final cutoffTime = DateTime.now().subtract(SHAKE_WINDOW);

    // Pencere dışındaki verileri çıkar
    while (_recentShakeTimes.isNotEmpty &&
        _recentShakeTimes.first.isBefore(cutoffTime)) {
      _recentShakeTimes.removeAt(0);
      _recentMagnitudes.removeAt(0);
      _recentDeltas.removeAt(0);
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
    final avgDelta = _recentDeltas.isEmpty
        ? 0.0
        : _recentDeltas.reduce((a, b) => a + b) / _recentDeltas.length;
    final maxDelta = _recentDeltas.isEmpty
        ? 0.0
        : _recentDeltas.reduce((a, b) => a > b ? a : b);
    final duration = _recentShakeTimes.last.difference(_recentShakeTimes.first);

    // Deprem olasılığı skoru (0-100) - GERÇEKÇİ HESAPLAMA
    final score = _calculateEarthquakeProbability(
      avgMagnitude: avgMagnitude,
      maxMagnitude: maxMagnitude,
      avgDelta: avgDelta,
      maxDelta: maxDelta,
      shakeCount: _shakeCount,
      duration: duration,
    );

    print('📊 Deprem Analizi:');
    print('   - Ort Büyüklük: ${avgMagnitude.toStringAsFixed(2)} m/s²');
    print('   - Max Büyüklük: ${maxMagnitude.toStringAsFixed(2)} m/s²');
    print('   - Ort Değişim: ${avgDelta.toStringAsFixed(2)} m/s²/s');
    print('   - Max Değişim: ${maxDelta.toStringAsFixed(2)} m/s²/s');
    print('   - Sarsıntı: $_shakeCount adet');
    print('   - Süre: ${duration.inMilliseconds}ms');
    print('   - Deprem Skoru: ${score.toStringAsFixed(1)}/100');

    // Yüksek skor = muhtemel deprem, server'a bildir
    if (score >= 70.0) {
      print('🚨 DEPREM OLASİLIĞI YÜKSEK - RAPOR GÖNDERİLİYOR!');
      _reportToServer(
        avgMagnitude: avgMagnitude,
        maxMagnitude: maxMagnitude,
        shakeCount: _shakeCount,
        duration: duration,
        score: score,
      );
    } else {
      print('ℹ️ Düşük skor - normal titreşim veya kasıtlı hareket');
    }

    // Verileri temizle
    _recentMagnitudes.clear();
    _recentShakeTimes.clear();
    _recentDeltas.clear();
    _shakeCount = 0;
  }

  /// Deprem olasılık skoru hesapla - GERÇEKÇİ ALGORİTMA
  /// 3.0 büyüklüğünde deprem: hafif sarsıntı, masa üstünde hissedilir
  double _calculateEarthquakeProbability({
    required double avgMagnitude,
    required double maxMagnitude,
    required double avgDelta,
    required double maxDelta,
    required int shakeCount,
    required Duration duration,
  }) {
    double score = 0.0;

    // 1. ORTALAMA BÜYÜKLÜK (0-25 puan) - 3.0 deprem için ~0.8-1.5 m/s²
    if (avgMagnitude > 2.0) {
      score += 25.0; // Çok güçlü
    } else if (avgMagnitude > 1.2) {
      score += 20.0; // Güçlü deprem (4.0+)
    } else if (avgMagnitude > 0.8) {
      score += 15.0; // Orta deprem (3.0-4.0)
    } else if (avgMagnitude > 0.5) {
      score += 10.0; // Hafif deprem (2.0-3.0)
    } else {
      score += (avgMagnitude / 0.5) * 10.0; // Çok hafif
    }

    // 2. MAKSIMUM BÜYÜKLÜK (0-20 puan)
    if (maxMagnitude > 3.0) {
      score += 20.0; // Çok güçlü pik
    } else if (maxMagnitude > 2.0) {
      score += 15.0; // Güçlü pik
    } else if (maxMagnitude > 1.0) {
      score += 10.0; // Orta pik
    } else {
      score += (maxMagnitude / 3.0) * 20.0;
    }

    // 3. ANİ DEĞİŞİM ORTALAMASI (0-20 puan) - Depremde ani sarsıntılar olur
    if (avgDelta > 1.5) {
      score += 20.0; // Çok ani değişimler
    } else if (avgDelta > 1.0) {
      score += 15.0; // Ani değişimler
    } else if (avgDelta > 0.5) {
      score += 10.0; // Orta değişimler
    } else {
      score += (avgDelta / 1.5) * 20.0;
    }

    // 4. MAX ANİ DEĞİŞİM (0-15 puan)
    if (maxDelta > 2.0) {
      score += 15.0; // Çok ani pik
    } else if (maxDelta > 1.0) {
      score += 10.0; // Ani pik
    } else {
      score += (maxDelta / 2.0) * 15.0;
    }

    // 5. SARSINTILAR SAYISI (0-10 puan) - Deprem sürekli sarsıntılıdır
    if (shakeCount > 15) {
      score += 10.0; // Çok fazla sarsıntı
    } else if (shakeCount > 10) {
      score += 8.0; // Fazla sarsıntı
    } else if (shakeCount >= MIN_SHAKE_COUNT) {
      score += 5.0; // Yeterli sarsıntı
    } else {
      score += (shakeCount / 15.0) * 10.0;
    }

    // 6. SÜRE (0-10 puan) - Deprem birkaç saniye sürer
    final durationSec = duration.inMilliseconds / 1000.0;
    if (durationSec > 2.0 && durationSec < 10.0) {
      score += 10.0; // İdeal deprem süresi (2-10 saniye)
    } else if (durationSec > 1.0 && durationSec < 15.0) {
      score += 7.0; // Makul süre
    } else if (durationSec < 1.0) {
      score += 2.0; // Çok kısa - ani sarsıntı olabilir
    } else {
      score += 3.0; // Çok uzun - muhtemelen kasıtlı
    }

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
        print('⏳ Cooldown: ${COOLDOWN_PERIOD.inSeconds - timeSinceLastReport.inSeconds}s kaldı');
        return;
      }
    }

    try {
      print('🚨 SERVER\'A RAPOR GÖNDERİLİYOR (Skor: ${score.toStringAsFixed(1)})');
      final prefs = await SharedPreferences.getInstance();
      final userId = prefs.getString('userId');
      final latitude = prefs.getDouble('last_latitude');
      final longitude = prefs.getDouble('last_longitude');
      if (latitude == null || longitude == null) {
        print('⚠️ Konum bilgisi yok, rapor gönderilemedi');
        return;
      }
      final deviceId = prefs.getString('deviceId');
      final batteryLevel = 100;
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
      // WebSocket ile deprem bildirimi gönder
      EarthquakeWebSocketService().sendP2PEarthquakeReport(payload);
      final response = await http.post(
        Uri.parse('$baseUrl/p2p/shake-report'),
        headers: {'Content-Type': 'application/json'},
        body: json.encode(payload),
      );
      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        print('✅ Rapor gönderildi: ${data['message']}');
        if (data['analysis'] != null) {
          final analysis = data['analysis'];
          print('📊 Server Analizi:');
          print('   - Bölge: ${analysis['region']}');
          print('   - Toplam Rapor: ${analysis['totalReports']}');
          print('   - Deprem Olasılığı: ${analysis['earthquakeProbability']}%');
          if (analysis['isEarthquakeDetected'] == true) {
            print('🚨🚨🚨 DEPREM ALGILANDI! 🚨🚨🚨');
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
    // LocalNotification servisi üzerinden tam ekran ve wake-up notification göster
    print('🔔 Kullanıcıya deprem uyarısı gösteriliyor...');
    final double magnitude = (analysis['magnitude'] ?? 0.0).toDouble();
    final String location = (analysis['region'] ?? 'Bilinmiyor').toString();
    final double distance = (analysis['distance'] ?? 0.0).toDouble();
    // Tam ekran deprem uyarısı ve wake-up notification
    NotificationService().showWakeUpNotification(magnitude, location, distance);
    NotificationService().showAlertScreen(magnitude, location, distance, 'P2P');
  }

  /// Servisi durdur
  void stopMonitoring() {
    _stopSensorListening();
    _isMonitoring = false;
    print('⏹️ P2P monitoring durduruldu');
  }

  /// Sensör dinlemeyi durdur
  void _stopSensorListening() {
    _accelerometerSubscription?.cancel();
    _gyroscopeSubscription?.cancel();
    _accelerometerSubscription = null;
    _gyroscopeSubscription = null;
  }

  /// Servis durumu
  bool get isMonitoring => _isMonitoring;
}
