import 'dart:async';
import 'dart:math';
import 'dart:io';
import 'dart:convert';
import 'package:flutter/services.dart';
import 'package:path_provider/path_provider.dart';
import 'package:flutter_foreground_task/flutter_foreground_task.dart';
import 'package:sensors_plus/sensors_plus.dart';
import 'package:geolocator/geolocator.dart';
import 'package:battery_plus/battery_plus.dart';
import 'package:deprem_app/services/earthquake_report_service.dart';
import 'package:deprem_app/services/screen_state_service.dart';
import 'package:socket_io_client/socket_io_client.dart' as IO;
import 'package:shared_preferences/shared_preferences.dart';
import 'notification_service.dart';

class EarthquakeBackgroundService {
  static Future<Map<String, String>> _getLocalizedNotificationTexts() async {
    final prefs = await SharedPreferences.getInstance();
    final languageCode = prefs.getString('language_code') ?? 'tr';

    switch (languageCode) {
      case 'en':
        return {
          'title': 'Earthquake Line Monitoring',
          'text': 'Monitoring earthquakes',
          'button': 'Stop',
        };
      case 'es':
        return {
          'title': 'Línea de Terremoto Monitoreando',
          'text': 'Monitoreando terremotos',
          'button': 'Detener',
        };
      case 'hi':
        return {
          'title': 'भूकंप लाइन निगरानी',
          'text': 'भूकंप की निगरानी',
          'button': 'रोकें',
        };
      case 'fil':
        return {
          'title': 'Pagsubaybay sa Lindol',
          'text': 'Sinusubaybayan ang lindol',
          'button': 'Ihinto',
        };
      case 'my':
        return {
          'title': 'ငလျင် စောင့်ကြည့်မှု',
          'text': 'ငလျင် စောင့်ကြည့်နေသည်',
          'button': 'ရပ်မည်',
        };
      case 'tr':
      default:
        return {
          'title': 'Deprem Hattı İzlemede',
          'text': 'Deprem hattı izliyor',
          'button': 'Durdur',
        };
    }
  }

  static void initializeService() {
    FlutterForegroundTask.init(
      androidNotificationOptions: AndroidNotificationOptions(
        channelId: 'earthquake_alert_high',
        channelName: 'Deprem Hattı',
        channelDescription: 'Deprem hattı izleme servisi',
        channelImportance:
            NotificationChannelImportance.LOW, // Normal takip için LOW
        priority: NotificationPriority.LOW, // Normal takip için LOW
        visibility:
            NotificationVisibility.VISIBILITY_SECRET, // Normal takipte gizli
        playSound: false, // Normal takipte ses yok
        enableVibration: false, // Normal takipte titreşim yok
        showWhen: true,
      ),
      iosNotificationOptions: const IOSNotificationOptions(
        showNotification: true,
        playSound: false,
      ),
      foregroundTaskOptions: ForegroundTaskOptions(
        eventAction: ForegroundTaskEventAction.repeat(5000),
        autoRunOnBoot: true,
        autoRunOnMyPackageReplaced: true,
        allowWakeLock: true,
        allowWifiLock: true,
      ),
    );

    // Ekran uyandırma için wake lock aktif
    FlutterForegroundTask.setOnLockScreenVisibility(true);
  }

  static Future<bool> startService() async {
    if (await FlutterForegroundTask.isRunningService) {
      print(
          '[BG] Foreground servis zaten çalışıyor (kontrol: isRunningService)');
      return true;
    }

    print('[BG] Foreground servis başlatılıyor...');

    // Arka plan konum izni kontrolü (Android 10+)
    // NOT: İzin isteme işlemi UI tarafından (PermissionService ile) yapılmalıdır
    // Burada sadece mevcut durumu kontrol ediyoruz
    try {
      final geolocator = GeolocatorPlatform.instance;
      LocationPermission permission = await geolocator.checkPermission();

      if (permission != LocationPermission.always) {
        print(
            '[BG] UYARI: Arka plan konum izni verilmedi! Servisi başlatmadan önce UI\'dan izin alın.');
        print('[BG] Mevcut izin durumu: $permission');
        // Servis yine de başlatılabilir, ancak arka plan konumu olmayacak
      } else {
        print('[BG] Arka plan konum izni verildi.');
      }
    } catch (e) {
      print('[BG] Arka plan konum izni kontrolünde hata: $e');
    }

    final localizedTexts = await _getLocalizedNotificationTexts();

    await FlutterForegroundTask.startService(
      notificationTitle: localizedTexts['title']!,
      notificationText: localizedTexts['text']!,
      notificationButtons: [
        NotificationButton(id: 'stop', text: localizedTexts['button']!),
      ],
      callback: startCallback,
    );

    return true;
  }

  static Future<bool> stopService() async {
    await FlutterForegroundTask.stopService();
    return true;
  }
}

// Top-level callback fonksiyonu (isolate'da calisir)
@pragma('vm:entry-point')
void startCallback() {
  FlutterForegroundTask.setTaskHandler(EarthquakeTaskHandler());
}

class EarthquakeTaskHandler extends TaskHandler {
  // Pending rapor ve timer kodları kaldırıldı
  StreamSubscription<AccelerometerEvent>? _subscription;
  int _shakeCount = 0;
  DateTime? _lastShakeTime;
  bool _listening = false;

  // Pil ve şarj kontrolü
  final Battery _battery = Battery();
  StreamSubscription<BatteryState>? _batteryStateSubscription;
  Timer? _batteryCheckTimer;
  bool _isCharging = false;
  int _batteryLevel = 0;
  bool _isScreenOn = true; // Ekran açık mı?
  static const int minBatteryLevel = 35; // Minimum pil seviyesi

  // ============ DEPREM AĞI ALGORİTMASI DEĞİŞKENLERİ ============
  // Veri tamponları (Deprem Ağı gibi)
  static const int bufferSize =
      128; // Örnek tamponu boyutu (~2.5 saniye @ 50Hz) - HIZLI ALGILAMA
  final List<double> _deltaBuffer = []; // Delta değerleri tamponu
  final List<int> _timestampBuffer = []; // Zaman damgaları (ms)

  // Baseline değerleri
  double _baselineMin = 9999.0; // Minimum baseline
  double _baselineMax = -9999.0; // Maximum baseline
  double _baselineStd = 9999.0; // Baseline standart sapma

  // Algılama durumu
  bool _isDetecting = false; // Deprem algılama modunda mı
  int _detectionSampleCount = 0; // Algılama sırasındaki örnek sayısı
  int _consecutiveEvents = 0; // Ardışık olay sayısı
  double _cumulativeDuration = 0.0; // Kümülatif süre

  // ============ DEPREM ALGILAMA EŞİKLERİ (HASSASİYET DAHA DA AZALTILDI) ============
  // Gerçek deprem verileri:
  // - Zayıf deprem: STD ~0.01, Delta ~0.07
  // - Orta deprem: STD ~0.017, Delta ~0.16
  // - Güçlü deprem: STD ~0.05, Delta ~0.3+
  // Normal (sabit telefon): STD ~0.003-0.008, Delta ~0.01-0.03

  // HASSASİYET AZALTILDI - YANLIŞ POZİTİFLERİ ÖNLEMEK İÇİN DEĞERLER DAHA DA ARTIRILDI
  static const double stdMultiplier =
      5.0; // Baseline STD'nin 5 katı = anomali (Önceki: 4.0)
  static const double deltaMultiplier =
      5.0; // Delta çarpanı (Önceki: 5.0 - aynı kaldı)
  static const int minConsecutiveSamples =
      15; // Minimum ardışık örnek (~0.30 saniye) (Önceki: 12)
  static const double minDuration = 1.0; // Minimum süre (saniye) - 1 SANİYE
  static const int stabilizationTime = 3; // Stabilizasyon süresi (saniye)
  static const bool instantReport = true; // Anında raporlama
  static const double minAbsoluteThreshold =
      0.04; // Min mutlak delta eşiği (Önceki: 0.02)

  // Minimum STD eşiği - bu değerin altında anomali sayılmaz
  // Telefon titreşimi veya küçük hareketleri filtreler
  // DEĞER ARTIRILDI - EN ÖNEMLİ DEĞİŞİKLİK
  static const double minStdForAnomaly =
      0.025; // Minimum STD eşiği (Önceki: 0.018)

  // Son değerler
  double _lastMagnitude = 0.0;
  bool _firstSampleSkipped = false; // İlk örneği atla (delta ~9.8 olur)
  bool _stabilizationComplete = false; // Stabilizasyon tamamlandı mı?
  int _sampleIndex = 0;
  DateTime? _monitoringStartTime;

  // Cooldown mekanizması - aynı deprem için tekrar rapor göndermemek
  DateTime? _lastReportTime;
  static const int reportCooldownSeconds = 30; // 30 saniye cooldown
  bool _reportInProgress = false; // Rapor gönderimi devam ediyor mu

  // Potansiyel deprem bildirimi için cooldown ve eşik
  DateTime? _lastPotentialReportTime;
  static const int potentialReportCooldownSeconds =
      5; // 5 saniye cooldown - HIZLI
  static const double potentialReportThreshold =
      2.0; // Potansiyel rapor için baseline'ın 2 katı

  // Detection timeout cooldown - yanlış pozitif döngüsünü önle
  DateTime? _lastDetectionTimeoutTime;
  static const int detectionTimeoutCooldownSeconds =
      3; // 3 saniye cooldown - HIZLI
  // ============================================================

  // Ekran durumunu dosyadan oku (isolate'da MethodChannel çalışmadığından)
  Future<bool> _checkScreenState() async {
    try {
      // Android filesDir yolunu doğrudan kullan
      // Android'de: /data/data/com.fsapps.earthquake_line/files/screen_state.json
      const String packageName = 'com.fsapps.earthquake_line';
      final String filesPath = '/data/data/$packageName/files';
      final file = File('$filesPath/screen_state.json');

      if (await file.exists()) {
        final jsonStr = await file.readAsString();
        final json = jsonDecode(jsonStr);
        final isScreenOn = json['isScreenOn'] ?? false;
        final timestamp = json['timestamp'] ?? 0;
        final age = DateTime.now().millisecondsSinceEpoch - timestamp;

        // ScreenStateService 5 saniyede bir günceller
        // 30 saniyeden eski ise service çalışmıyor olabilir ama yine de dosyadaki değeri kullan
        print(
            '[BG] 📱 Ekran durumu: isScreenOn=$isScreenOn (${age ~/ 1000}s önce güncellendi)');

        return isScreenOn;
      } else {
        print(
            '[BG] ⚠️ screen_state.json dosyası bulunamadı, ekran KAPALI kabul ediliyor');
        return false; // Dosya yoksa ekran kapalı kabul et
      }
    } catch (e) {
      print('[BG] ❌ Ekran durumu okuma hatası: $e');
      return false; // Hata varsa ekran kapalı kabul et
    }
  }

  // Pil durumunu kontrol et ve sensör dinlemeyi yönet
  Future<void> _checkBatteryAndManageSensor() async {
    try {
      _batteryLevel = await _battery.batteryLevel;
      final batteryState = await _battery.batteryState;
      _isCharging = batteryState == BatteryState.charging ||
          batteryState == BatteryState.full;

      // Ekran durumunu kontrol et
      _isScreenOn = await _checkScreenState();

      // Koşullar: Şarjda + Pil >= 35% + Ekran kapalı
      final shouldListen =
          _isCharging && _batteryLevel >= minBatteryLevel && !_isScreenOn;

      print(
          '[BG] 🔋 Pil: $_batteryLevel%, Şarjda: $_isCharging, Ekran açık: $_isScreenOn, Dinleme aktif olmalı: $shouldListen');

      if (shouldListen && !_listening) {
        print('[BG] ✅ Tüm koşullar sağlandı! Sensör dinleme başlatılıyor...');
        _startSensorListening();
      } else if (!shouldListen && _listening) {
        print('[BG] ⏸️ Koşullar sağlanmıyor. Sensör dinleme duraklatılıyor...');
        _stopSensorListening();
      }
      // Her durumda sabit notification göster - lokalize edilmiş metin kullan
      final prefs = await SharedPreferences.getInstance();
      final languageCode = prefs.getString('language_code') ?? 'tr';

      String title, text;
      switch (languageCode) {
        case 'en':
          title = 'Earthquake Line Monitoring';
          text = 'Monitoring earthquakes';
          break;
        case 'es':
          title = 'Línea de Terremoto Monitoreando';
          text = 'Monitoreando terremotos';
          break;
        case 'hi':
          title = 'भूकंप लाइन निगरानी';
          text = 'भूकंप की निगरानी';
          break;
        case 'fil':
          title = 'Pagsubaybay sa Lindol';
          text = 'Sinusubaybayan ang lindol';
          break;
        case 'my':
          title = 'ငလျင် စောင့်ကြည့်မှု';
          text = 'ငလျင် စောင့်ကြည့်နေသည်';
          break;
        case 'tr':
        default:
          title = 'Deprem Hattı İzlemede';
          text = 'Deprem hattı izliyor';
          break;
      }

      _updateNotification(title, text);
    } catch (e) {
      print('[BG] ❌ Pil/Ekran kontrolü hatası: $e');
    }
  }

  // Pil durumu değişikliklerini dinle
  void _startBatteryMonitoring() {
    print('[BG] 🔋 Pil izleme başlatılıyor...');

    // Pil durumu değişikliklerini dinle (şarj takıldı/çıkarıldı)
    _batteryStateSubscription =
        _battery.onBatteryStateChanged.listen((BatteryState state) {
      print('[BG] 🔌 Şarj durumu değişti: $state');
      _isCharging =
          state == BatteryState.charging || state == BatteryState.full;
      _checkBatteryAndManageSensor();
    });

    // Her 30 saniyede bir pil seviyesini kontrol et
    _batteryCheckTimer = Timer.periodic(const Duration(seconds: 30), (timer) {
      _checkBatteryAndManageSensor();
    });

    // İlk kontrolü hemen yap
    _checkBatteryAndManageSensor();
  }

  void _stopBatteryMonitoring() {
    try {
      _batteryStateSubscription?.cancel();
    } catch (e) {
      print('[BG] Battery subscription cancel error: $e');
    }
    _batteryStateSubscription = null;
    try {
      _batteryCheckTimer?.cancel();
    } catch (e) {
      print('[BG] Battery timer cancel error: $e');
    }
    _batteryCheckTimer = null;
  }

  void _updateNotification(String title, String text) {
    FlutterForegroundTask.updateService(
      notificationTitle: title,
      notificationText: text,
    );
  }

  // Sensör dinlemeyi durdur
  void _stopSensorListening() {
    if (!_listening) return;
    print('[BG] Sensör dinleme durduruluyor...');
    try {
      _subscription?.cancel();
    } catch (e) {
      print('[BG] Sensor subscription cancel error: $e');
    }
    _subscription = null;
    _listening = false;
    // Foreground servis durdurulurken tüm stream ve timer'ları güvenli şekilde kapat
    Future<void> onDestroy() async {
      print(
          '[BG] Foreground servis durduruluyor, tüm stream ve timerlar kapatılıyor...');
      _stopBatteryMonitoring();
      _stopSensorListening();
    }

    // Deprem Ağı değişkenlerini sıfırla
    _resetDetectionState();
  }

  // Algılama durumunu sıfırla (Deprem Ağı'ndan)
  void _resetDetectionState() {
    _deltaBuffer.clear();
    _timestampBuffer.clear();
    _baselineMin = 9999.0;
    _baselineMax = -9999.0;
    _baselineStd = 9999.0;
    _isDetecting = false;
    _detectionSampleCount = 0;
    _consecutiveEvents = 0;
    _cumulativeDuration = 0.0;
    _lastMagnitude = 0.0;
    _firstSampleSkipped = false; // İlk örnek flag'ını sıfırla
    _stabilizationComplete = false; // Stabilizasyon flag'ını sıfırla
    _sampleIndex = 0;
    _shakeCount = 0;
    _lastShakeTime = null;
    _monitoringStartTime = null;
    // Cooldown değişkenlerini de sıfırla
    _lastReportTime = null;
    _reportInProgress = false;
    _lastDetectionTimeoutTime = null; // Timeout cooldown'ı sıfırla
  }

  // Sensör dinleme ve deprem raporlama (DEPREM AĞI ALGORİTMASI)
  void _startSensorListening() {
    if (_listening) {
      print('[BG] Sensör dinleme zaten aktif.');
      return;
    }
    print('[BG] 🌍 Sensör dinleme başlatılıyor (Deprem Ağı algoritması)...');
    _listening = true;
    _resetDetectionState(); // ÖNCE sıfırla
    _monitoringStartTime = DateTime.now(); // SONRA zamanı ayarla

    _subscription =
        accelerometerEvents.listen((AccelerometerEvent event) async {
      final now = DateTime.now();
      final nowMs = now.millisecondsSinceEpoch;

      // İvme büyüklüğü hesapla
      final double magnitude = sqrt(
        event.x * event.x + event.y * event.y + event.z * event.z,
      );

      // İLK ÖRNEĞİ ATLA - _lastMagnitude=0 olduğunda delta ~9.8 olur!
      if (_lastMagnitude == 0.0) {
        _lastMagnitude = magnitude;
        print(
            '[BG] ⚠️ İlk örnek atlandı (magnitude=${magnitude.toStringAsFixed(2)})');
        return;
      }

      // Delta: Ardışık ölçümler arasındaki fark
      final double delta = (magnitude - _lastMagnitude).abs();
      _lastMagnitude = magnitude;

      // Aşırı değerleri filtrele (sensör hatası veya ani hareket)
      if (delta > 0.5) {
        print('[BG] ⚠️ Aşırı delta filtrelendi: ${delta.toStringAsFixed(4)}');
        return;
      }

      _sampleIndex++;

      // ========== STABİLİZASYON FAZINDA ==========
      if (!_stabilizationComplete) {
        // Tampona ekle
        _deltaBuffer.add(delta);
        while (_deltaBuffer.length > 64) {
          _deltaBuffer.removeAt(0);
        }

        // Baseline hesapla (32+ örnek olduğunda)
        if (_deltaBuffer.length >= 32) {
          final std = _calculateStd(_deltaBuffer);
          if (std < _baselineStd) {
            _baselineStd = std;
            _baselineMin = _deltaBuffer.reduce((a, b) => a < b ? a : b);
            _baselineMax = _deltaBuffer.reduce((a, b) => a > b ? a : b);
          }
        }

        // Stabilizasyon süresi doldu mu?
        final monitoringStart = _monitoringStartTime;
        if (monitoringStart != null &&
            now.difference(monitoringStart).inSeconds >= stabilizationTime) {
          // Baseline oluştu mu kontrol et
          if (_baselineStd < 9999.0 && _baselineStd > 0) {
            // UYARI: Baseline çok yüksekse (>0.02) telefon stabil değil demektir
            // Normal baseline: 0.003-0.008 arasında olmalı
            if (_baselineStd > 0.02) {
              print(
                  '[BG] ⚠️ UYARI: Baseline çok yüksek! (${_baselineStd.toStringAsFixed(4)})');
              print(
                  '[BG] 📱 Telefon sabit bir yüzeyde değil veya titreşimli ortam!');
              print('[BG] 💡 Normal baseline: 0.003-0.008 arası olmalı');
            }
            _stabilizationComplete = true;
            print('[BG] ✅ Stabilizasyon tamamlandı!');
            print('[BG] 📊 Baseline STD: ${_baselineStd.toStringAsFixed(6)}');
            print(
                '[BG] 📊 Baseline Min: ${_baselineMin.toStringAsFixed(4)}, Max: ${_baselineMax.toStringAsFixed(4)}');
            print('[BG] 🗑️ Ana algılama için buffer temizleniyor...');
            _deltaBuffer.clear();
            _timestampBuffer.clear();
          } else {
            // Baseline oluşmadı, daha fazla veri bekle
            if (_sampleIndex % 100 == 0) {
              print(
                  '[BG] ⏳ Baseline henüz oluşmadı, bekleniyor... (buffer=${_deltaBuffer.length})');
            }
          }
        } else if (monitoringStart != null) {
          // Stabilizasyon devam ediyor
          if (_sampleIndex % 100 == 0) {
            final remaining =
                stabilizationTime - now.difference(monitoringStart).inSeconds;
            print(
                '[BG] ⏳ Stabilizasyon: ${remaining}s kaldı (baseline=${_baselineStd.toStringAsFixed(6)}, buffer=${_deltaBuffer.length})');
          }
        }
        return; // Stabilizasyon bitmeden ana algılamaya geçme
      }

      // ========== ANA ALGILAMA FAZINDA ==========
      // Tampona ekle
      _deltaBuffer.add(delta);
      _timestampBuffer.add(nowMs);

      // Tampon boyutunu sınırla
      while (_deltaBuffer.length > bufferSize) {
        _deltaBuffer.removeAt(0);
        _timestampBuffer.removeAt(0);
      }

      _sampleIndex++;

      // Her 500 örnekte bir durum bildir (log spam önleme)
      if (_sampleIndex % 500 == 0) {
        print(
            '[BG] 📊 Örnek: $_sampleIndex, Buffer: ${_deltaBuffer.length}, Baseline std: ${_baselineStd.toStringAsFixed(4)}');
      }

      // Yeterli veri yoksa bekle
      if (_deltaBuffer.length < 64) return;

      // ============ DEPREM AĞI ALGILAMA ALGORİTMASI ============

      // Mevcut standart sapma hesapla
      final currentStd = _calculateStd(_deltaBuffer);

      // Baseline güncelle (sadece sakin dönemlerde)
      if (!_isDetecting && currentStd < _baselineStd) {
        _baselineStd = currentStd;
        _baselineMin = _deltaBuffer.reduce((a, b) => a < b ? a : b);
        _baselineMax = _deltaBuffer.reduce((a, b) => a > b ? a : b);
        if (_sampleIndex % 200 == 0) {
          print(
              '[BG] 📈 Baseline güncellendi: std=${_baselineStd.toStringAsFixed(4)}, min=${_baselineMin.toStringAsFixed(4)}, max=${_baselineMax.toStringAsFixed(4)}');
        }
      }

      // Anomali tespiti:
      // 1. Standart sapma baseline'ın stdMultiplier katından büyük olmalı
      // 2. Current STD minimum eşiğin üzerinde olmalı (küçük titreşimleri filtrele)
      // 3. Baseline geçerli olmalı
      final double threshold = _baselineStd * stdMultiplier;
      final bool isAnomaly = currentStd > threshold &&
          currentStd > minStdForAnomaly &&
          _baselineStd < 9999.0;

      // Her 200 örnekte detaylı log (debug için - log spam önleme)
      if (_sampleIndex % 200 == 0) {
        print(
            '[BG] 🔬 DEBUG: delta=${delta.toStringAsFixed(4)}, std=${currentStd.toStringAsFixed(4)}, baseline=${_baselineStd.toStringAsFixed(4)}, threshold=${threshold.toStringAsFixed(4)}, isAnomaly=$isAnomaly');
      }

      // Büyük delta değerleri logla - SADECE her 100 örnekte bir (log spam önleme)
      // 0.1'den büyük delta'lar gerçek sarsıntı olabilir
      if (delta > 0.1 && _sampleIndex % 20 == 0) {
        print(
            '[BG] 📳 Delta spike: ${delta.toStringAsFixed(4)}, std=${currentStd.toStringAsFixed(4)}, threshold=${threshold.toStringAsFixed(4)}, anomaly=$isAnomaly');
      }

      // Timeout cooldown kontrolü - son timeout'tan 5 saniye geçmeden yeni detection başlatma
      final detectionCooldownOk = _lastDetectionTimeoutTime == null ||
          now.difference(_lastDetectionTimeoutTime!).inSeconds >=
              detectionTimeoutCooldownSeconds;

      if (isAnomaly && !_isDetecting && detectionCooldownOk) {
        // Potansiyel deprem başlangıcı
        _isDetecting = true;
        _detectionSampleCount = 0;
        print(
            '[BG] 🔍 Potansiyel deprem algılandı! std=$currentStd, baseline=$_baselineStd');

        // ===== POTANSİYEL DEPREMİ SUNUCUYA BİLDİR =====
        // Sadece yeterince güçlü anomalilerde bildir (baseline'ın 1.5 katı)
        // Böylece yanlış pozitifler sunucuya gitmez
        final double potentialThreshold =
            _baselineStd * potentialReportThreshold;
        final bool isStrongEnough = currentStd > potentialThreshold;
        final now = DateTime.now();
        final canSendPotential = _lastPotentialReportTime == null ||
            now.difference(_lastPotentialReportTime!).inSeconds >=
                potentialReportCooldownSeconds;

        if (isStrongEnough && canSendPotential) {
          _lastPotentialReportTime = now;
          print(
              '[BG] 📤 Güçlü anomali tespit edildi (${currentStd.toStringAsFixed(4)} > ${potentialThreshold.toStringAsFixed(4)}), sunucuya bildiriliyor...');

          // ANLIK cihaz durumu kontrolü - potansiyel rapor için de
          _checkRealTimeDeviceState().then((deviceStateOk) {
            if (deviceStateOk) {
              _sendPotentialEarthquakeReport(currentStd, _baselineStd)
                  .then((_) {
                print('[BG] ✅ Potansiyel deprem bildirimi gönderildi');
              }).catchError((e) {
                print('[BG] ⚠️ Potansiyel deprem bildirimi gönderilemedi: $e');
              });
            } else {
              print(
                  '[BG] ⚠️ Anlık durum uygun değil, potansiyel rapor iptal edildi');
            }
          });
        } else if (!isStrongEnough) {
          print(
              '[BG] 📊 Anomali zayıf (${currentStd.toStringAsFixed(4)} <= ${potentialThreshold.toStringAsFixed(4)}), potansiyel bildirim gönderilmiyor');
        }
      }

      if (_isDetecting) {
        _detectionSampleCount++;

        // Aşırı değerler ara - DAHA YÜKSEK eşik (yanlış pozitif önleme)
        // Eşik: baseline std'nin 2.5 katı VEYA minimum mutlak eşik (hangisi büyükse)
        // ARTIRILDI: 0.8→2.5 - hafif dokunuşlar algılanmasın
        final double extremeThreshold =
            max(_baselineStd * deltaMultiplier, minAbsoluteThreshold);
        int extremeCount = 0;
        int extremeStart = -1;
        int extremeEnd = -1;

        for (int i = 0; i < _deltaBuffer.length; i++) {
          final d = _deltaBuffer[i];
          // Delta değeri eşikten büyükse aşırı değer say
          final bool isExtreme = d > extremeThreshold;
          if (isExtreme) {
            extremeCount++;
            if (extremeStart < 0) extremeStart = i;
            extremeEnd = i;
          }
        }

        // Log ekle - sadece her 25 detection sample'da (log spam önleme)
        if (_detectionSampleCount % 25 == 0) {
          print(
              '[BG] 📊 DETECTION[$_detectionSampleCount]: extremeCount=$extremeCount, eşik=${extremeThreshold.toStringAsFixed(4)}, std=${currentStd.toStringAsFixed(4)}');
        }

        // Ardışık aşırı örnek sayısı
        final int consecutiveSamples = (extremeStart >= 0 && extremeEnd >= 0)
            ? (extremeEnd - extremeStart + 1)
            : 0;

        // Süre hesapla
        double duration = 0.0;
        if (extremeStart >= 0 &&
            extremeEnd >= 0 &&
            _timestampBuffer.length > extremeEnd) {
          duration =
              (_timestampBuffer[extremeEnd] - _timestampBuffer[extremeStart]) /
                  1000.0;
        }

        // Debug: Tüm koşulları kontrol et
        // HIZLI ALGILAMA: baseline'ın 2.5 katı veya minimum 0.01 STD
        final double minStdThreshold = max(_baselineStd * 2.5, 0.01);
        final bool cond1 = consecutiveSamples >= minConsecutiveSamples;
        final bool cond2 = duration >= minDuration;
        final bool cond3 = extremeCount >= 5; // Minimum 5 aşırı değer
        final bool cond4 = currentStd >= minStdThreshold;
        final bool allConditionsMet = cond1 && cond2 && cond3 && cond4;

        // SADECE her 50 sample'da log bas (koşullar sağlansa bile spam önleme)
        if (_detectionSampleCount % 50 == 0) {
          print(
              '[BG] 🎯 KOŞULLAR: consecutive=$consecutiveSamples>=${minConsecutiveSamples}($cond1), duration=${duration.toStringAsFixed(3)}>=${minDuration}($cond2), extreme=$extremeCount>=5($cond3), std=${currentStd.toStringAsFixed(4)}>=${minStdThreshold.toStringAsFixed(4)}($cond4)');
        }

        // ============ DEPREM TESPİTİ (ANINDA RAPORLAMA) ============
        // HIZLI ALGILAMA: 8+ ardışık örnek VE 0.3+ saniye süre VE 5+ aşırı değer
        // ANINDA RAPOR: Deprem tespit edildiği anda hemen gönder!
        if (allConditionsMet) {
          // Cooldown kontrolü - son rapordan beri yeterli süre geçti mi?
          final now = DateTime.now();
          final canReport = _lastReportTime == null ||
              now.difference(_lastReportTime!).inSeconds >=
                  reportCooldownSeconds;

          // Rapor gönderimi devam ediyorsa atla
          if (_reportInProgress) {
            return; // Bu event'i atla
          }

          if (canReport) {
            _reportInProgress = true;
            _consecutiveEvents++;
            _cumulativeDuration += duration;

            print('[BG] 🌍 DEPREM TESPİT EDİLDİ!');
            print('[BG]   Ardışık örnekler: $consecutiveSamples');
            print('[BG]   Süre: ${duration.toStringAsFixed(2)}s');
            print('[BG]   Toplam olay: $_consecutiveEvents');
            print(
                '[BG]   Kümülatif süre: ${_cumulativeDuration.toStringAsFixed(2)}s');

            // Rapor zamanını kaydet (cooldown için)
            _lastReportTime = now;

            // HEMEN detection'ı durdur - async rapor gönderimi sırasında log spam önle
            _isDetecting = false;
            _detectionSampleCount = 0;

            // Rapor gönder (async - arka planda)
            _sendEarthquakeReport(currentStd, duration, consecutiveSamples)
                .then((_) {
              _reportInProgress = false;
              print(
                  '[BG] ✅ Rapor gönderimi tamamlandı, ${reportCooldownSeconds}s cooldown başladı');

              // ===== RAPOR SONRASI TÜM VERİLERİ SIFIRLA =====
              // Baseline dahil her şeyi sıfırla, yeni baştan başla
              _deltaBuffer.clear();
              _timestampBuffer.clear();
              _baselineMin = 9999.0;
              _baselineMax = -9999.0;
              _baselineStd = 9999.0;
              _consecutiveEvents = 0;
              _cumulativeDuration = 0.0;
              _lastMagnitude = 0.0;
              _sampleIndex = 0;
              _stabilizationComplete = false; // Yeniden stabilizasyon gerekli
              _monitoringStartTime = DateTime.now();
              print(
                  '[BG] 🔄 Tüm veriler sıfırlandı, yeni baseline oluşturulacak');
            }).catchError((e) {
              _reportInProgress = false;
              print('[BG] ❌ Rapor gönderim hatası: $e');
            });

            return; // Bu event'i bitir, yeni data toplanmaya başlasın
          } else {
            final remaining = reportCooldownSeconds -
                now.difference(_lastReportTime!).inSeconds;
            if (_detectionSampleCount % 50 == 0) {
              print('[BG] ⏳ Cooldown: ${remaining}s kaldı, rapor atlandı');
            }
          }
        }

        // 2 saniye içinde yeterli olay yoksa iptal - HIZLI
        if (_detectionSampleCount > 100) {
          // ~2 saniye @ 50Hz
          print('[BG] ⏱️ Algılama zaman aşımı, sıfırlanıyor...');
          _isDetecting = false;
          _detectionSampleCount = 0;
          // Timeout cooldown başlat - yeni detection'dan önce bekle
          _lastDetectionTimeoutTime = DateTime.now();
          print('[BG] ⏸️ ${detectionTimeoutCooldownSeconds}s cooldown başladı');
        }
      }
    });
  }

  // Baseline güncelleme (stabilizasyon sırasında)
  void _updateBaseline(AccelerometerEvent event) {
    final double magnitude = sqrt(
      event.x * event.x + event.y * event.y + event.z * event.z,
    );

    // İLK ÖRNEĞİ ATLA - _lastMagnitude=0 olduğunda delta ~9.8 olur!
    if (!_firstSampleSkipped) {
      _lastMagnitude = magnitude;
      _firstSampleSkipped = true;
      print(
          '[BG] ⚠️ İlk örnek atlandı (magnitude=${magnitude.toStringAsFixed(2)})');
      return;
    }

    final double delta = (magnitude - _lastMagnitude).abs();
    _lastMagnitude = magnitude;

    // AŞırı değerleri filtrele (0.5'ten büyük delta'lar gerçekçi değil)
    // Normal delta değerleri 0.001-0.1 arasında olmalı
    if (delta > 0.5) {
      print('[BG] ⚠️ Aşırı delta filtrelendi: ${delta.toStringAsFixed(4)}');
      return;
    }

    _deltaBuffer.add(delta);
    while (_deltaBuffer.length > 64) {
      _deltaBuffer.removeAt(0);
    }

    if (_deltaBuffer.length >= 32) {
      final std = _calculateStd(_deltaBuffer);
      if (std < _baselineStd) {
        _baselineStd = std;
        _baselineMin = _deltaBuffer.reduce((a, b) => a < b ? a : b);
        _baselineMax = _deltaBuffer.reduce((a, b) => a > b ? a : b);
        if (_sampleIndex % 20 == 0) {
          print(
              '[BG] 📈 Baseline: std=${std.toStringAsFixed(6)}, min=${_baselineMin.toStringAsFixed(4)}, max=${_baselineMax.toStringAsFixed(4)}');
        }
      }
    }
  }

  // Standart sapma hesapla
  double _calculateStd(List<double> values) {
    if (values.isEmpty) return 0.0;
    final mean = values.reduce((a, b) => a + b) / values.length;
    final variance =
        values.map((v) => pow(v - mean, 2)).reduce((a, b) => a + b) /
            values.length;
    return sqrt(variance);
  }

  // ===== ANLIK CİHAZ DURUMU KONTROLÜ =====
  // Native Android'den gerçek zamanlı ekran ve şarj durumu al
  // Bu fonksiyon dosyadan okuma yerine ANLIK sistem durumunu kontrol eder
  Future<bool> _checkRealTimeDeviceState() async {
    try {
      const channel = MethodChannel('deprem_app/device_state');
      final result = await channel.invokeMethod('getRealTimeDeviceState');

      if (result != null && result is Map) {
        final isScreenOn = result['isScreenOn'] as bool? ?? true;
        final isCharging = result['isCharging'] as bool? ?? false;
        final batteryLevel = result['batteryLevel'] as int? ?? 0;

        print(
            '[BG] 📱 ANLIK DURUM: Ekran=${isScreenOn ? "AÇIK" : "KAPALI"}, Şarj=${isCharging ? "EVET" : "HAYIR"}, Pil=$batteryLevel%');

        // Koşullar: Ekran KAPALI olmalı VE Şarjda olmalı VE Pil >= 35%
        if (isScreenOn) {
          print('[BG] ❌ Ekran AÇIK - kullanıcı telefonu kullanıyor olabilir');
          return false;
        }
        if (!isCharging) {
          print('[BG] ❌ Şarjda DEĞİL - telefon hareket ediyor olabilir');
          return false;
        }
        if (batteryLevel < 35) {
          print('[BG] ❌ Pil seviyesi düşük: $batteryLevel%');
          return false;
        }

        print(
            '[BG] ✅ Tüm koşullar sağlandı: Ekran kapalı, şarjda, pil yeterli');
        return true;
      }

      print('[BG] ⚠️ Native durum alınamadı, dosyadan kontrol ediliyor...');
      // Fallback: Dosyadan kontrol et (eski yöntem)
      return await _checkScreenStateFromFile();
    } catch (e) {
      print('[BG] ⚠️ Anlık durum kontrolü hatası: $e');
      // Hata durumunda dosyadan kontrol et
      return await _checkScreenStateFromFile();
    }
  }

  // Fallback: Dosyadan ekran durumu kontrolü
  Future<bool> _checkScreenStateFromFile() async {
    try {
      final screenOff = !(await _checkScreenState());
      final battery = Battery();
      final batteryState = await battery.batteryState;
      final isCharging = batteryState == BatteryState.charging ||
          batteryState == BatteryState.full;
      final batteryLevel = await battery.batteryLevel;

      print(
          '[BG] 📁 Dosya kontrolü: Ekran=${screenOff ? "KAPALI" : "AÇIK"}, Şarj=${isCharging ? "EVET" : "HAYIR"}, Pil=$batteryLevel%');

      return screenOff && isCharging && batteryLevel >= 35;
    } catch (e) {
      print('[BG] ⚠️ Dosya kontrolü hatası: $e');
      return false; // Güvenli tarafta kal, gönderme
    }
  }

  // Deprem raporu gönder
  Future<void> _sendEarthquakeReport(
      double magnitude, double duration, int samples) async {
    print('[BG] 📍 Deprem raporu hazırlanıyor...');

    // ===== ANLIK CİHAZ DURUMU KONTROLÜ =====
    // Rapor göndermeden önce gerçek zamanlı ekran ve şarj durumunu kontrol et
    // Bu, kullanıcının telefonu eline alıp sallamasından kaynaklanan yanlış pozitifleri önler
    final deviceStateOk = await _checkRealTimeDeviceState();
    if (!deviceStateOk) {
      print('[BG] ⚠️ Anlık cihaz durumu uygun değil, rapor gönderilmiyor!');
      print(
          '[BG] 📱 Kullanıcı muhtemelen telefonu eline aldı veya şarjdan çıkardı.');
      return;
    }
    print('[BG] ✅ Anlık cihaz durumu kontrol edildi: Ekran kapalı ve şarjda');

    final now = DateTime.now();
    Position? position;
    bool konumAlindi = false;
    String? userId;
    String? deviceId;

    // ÖNCE dosyadan konum ve kullanıcı bilgisi oku (daha hızlı ve güvenilir)
    try {
      final dir = await getApplicationDocumentsDirectory();
      final file = File('${dir.path}/user_location.json');
      if (await file.exists()) {
        final jsonStr = await file.readAsString();
        final json = jsonDecode(jsonStr);
        final lat = json['latitude'];
        final lon = json['longitude'];
        userId = json['userId'] as String?;
        deviceId = json['deviceId'] as String?;
        if (lat != null && lon != null) {
          position = Position(
            latitude: (lat is int) ? lat.toDouble() : lat,
            longitude: (lon is int) ? lon.toDouble() : lon,
            accuracy: 0.0,
            altitude: 0.0,
            heading: 0.0,
            speed: 0.0,
            speedAccuracy: 0.0,
            altitudeAccuracy: 0.0,
            headingAccuracy: 0.0,
            timestamp: now,
          );
          print(
              '[BG] ✅ Konum dosyadan alındı: ${position.latitude},${position.longitude}');
          konumAlindi = true;
        }
      }
    } catch (e) {
      print('[BG] Konum dosyadan okunamadı: $e');
    }

    // Dosyadan alınamadıysa Geolocator dene
    if (!konumAlindi) {
      try {
        position = await Geolocator.getCurrentPosition(
          desiredAccuracy: LocationAccuracy.low,
        ).timeout(
          const Duration(seconds: 5),
          onTimeout: () => throw Exception('Geolocator timeout'),
        );
        print(
            '[BG] ✅ Konum Geolocator ile alındı: ${position.latitude},${position.longitude}');
        konumAlindi = true;
      } catch (e) {
        print('[BG] ❌ Geolocator hatası: $e');
      }
    }

    // Konum alındıysa rapor gönder
    if (konumAlindi && position != null) {
      try {
        final client = HttpClient();
        client.connectionTimeout = const Duration(seconds: 10);

        final request = await client.postUrl(
            Uri.parse('http://188.132.202.24:3000/api/p2p/shake-report'));
        request.headers.set('Content-Type', 'application/json');

        final jsonBody = jsonEncode({
          'location': {
            'latitude': position.latitude,
            'longitude': position.longitude,
          },
          'sensorData': {
            'magnitude': magnitude,
            'duration': duration,
            'samples': samples,
            'timestamp': now.toIso8601String(),
            'algorithm': 'deprem-agi-v2',
          },
          'deviceId': deviceId ??
              'device-${position.latitude.toStringAsFixed(4)}-${position.longitude.toStringAsFixed(4)}',
          'userId': userId ??
              'user-${position.latitude.toStringAsFixed(4)}-${position.longitude.toStringAsFixed(4)}',
        });

        print('[BG] 📤 Gönderilen JSON: $jsonBody');
        request.write(jsonBody);
        final response = await request.close();
        final responseBody = await response.transform(utf8.decoder).join();

        if (response.statusCode == 200 || response.statusCode == 201) {
          print('⚡ [BG] Deprem raporu GİTTİ! Status: ${response.statusCode}');
        } else {
          print('❌ [BG] HTTP hatası: ${response.statusCode} - $responseBody');
        }
        client.close();
      } catch (e) {
        print('❌ [BG] Rapor gönderilemedi: $e');
      }
    } else {
      print('[BG] ❌ Konum alınamadı, rapor gönderilmiyor.');
    }
  }

  // ===== POTANSİYEL DEPREM BİLDİRİMİ GÖNDER =====
  // Deprem kesinleşmeden önce sunucuya bildir
  // Sunucu birden fazla cihazdan gelen verileri analiz edebilir
  Future<void> _sendPotentialEarthquakeReport(
      double currentStd, double baselineStd) async {
    print('[BG] 🔔 Potansiyel deprem bildirimi hazırlanıyor...');
    final now = DateTime.now();
    Position? position;
    bool konumAlindi = false;
    String? userId;
    String? deviceId;

    // Dosyadan konum ve kullanıcı bilgisi oku
    try {
      final dir = await getApplicationDocumentsDirectory();
      final file = File('${dir.path}/user_location.json');
      if (await file.exists()) {
        final jsonStr = await file.readAsString();
        final json = jsonDecode(jsonStr);
        final lat = json['latitude'];
        final lon = json['longitude'];
        userId = json['userId'] as String?;
        deviceId = json['deviceId'] as String?;
        if (lat != null && lon != null) {
          position = Position(
            latitude: (lat is int) ? lat.toDouble() : lat,
            longitude: (lon is int) ? lon.toDouble() : lon,
            accuracy: 0.0,
            altitude: 0.0,
            heading: 0.0,
            speed: 0.0,
            speedAccuracy: 0.0,
            altitudeAccuracy: 0.0,
            headingAccuracy: 0.0,
            timestamp: now,
          );
          konumAlindi = true;
        }
      }
    } catch (e) {
      print('[BG] Konum dosyadan okunamadı: $e');
    }

    if (konumAlindi && position != null) {
      try {
        final client = HttpClient();
        client.connectionTimeout = const Duration(seconds: 5);

        // Potansiyel deprem için ayrı endpoint kullan
        final request = await client.postUrl(
            Uri.parse('http://188.132.202.24:3000/api/p2p/potential-shake'));
        request.headers.set('Content-Type', 'application/json');

        final jsonBody = jsonEncode({
          'location': {
            'latitude': position.latitude,
            'longitude': position.longitude,
          },
          'sensorData': {
            'currentStd': currentStd,
            'baselineStd': baselineStd,
            'ratio': currentStd / baselineStd,
            'timestamp': now.toIso8601String(),
            'algorithm': 'deprem-agi-v2',
            'type': 'potential', // Potansiyel - henüz kesinleşmedi
          },
          'deviceId': deviceId ??
              'device-${position.latitude.toStringAsFixed(4)}-${position.longitude.toStringAsFixed(4)}',
          'userId': userId ??
              'user-${position.latitude.toStringAsFixed(4)}-${position.longitude.toStringAsFixed(4)}',
        });

        print('[BG] 📤 Potansiyel deprem JSON: $jsonBody');
        request.write(jsonBody);
        final response = await request.close();

        if (response.statusCode == 200 || response.statusCode == 201) {
          print(
              '🔔 [BG] Potansiyel deprem bildirimi GİTTİ! Status: ${response.statusCode}');
        } else {
          print(
              '⚠️ [BG] Potansiyel bildirim HTTP hatası: ${response.statusCode}');
        }
        client.close();
      } catch (e) {
        print('⚠️ [BG] Potansiyel bildirim gönderilemedi: $e');
      }
    }
  }

  @override
  Future<void> onStart(DateTime timestamp, TaskStarter starter) async {
    print('[BG] onStart: Foreground servis başlatıldı');
    print('[BG] onStart: Pil izleme başlatılıyor...');

    // Arka plan konum izni kontrolü
    bool hasBackgroundLocation = false;
    try {
      final geolocator = GeolocatorPlatform.instance;
      LocationPermission permission = await Geolocator.checkPermission();
      if (permission == LocationPermission.denied ||
          permission == LocationPermission.deniedForever) {
        permission = await Geolocator.requestPermission();
      }
      if (permission == LocationPermission.always) {
        hasBackgroundLocation = true;
      }
    } catch (e) {
      print('[BG] Konum izin kontrolünde hata: $e');
    }
    if (!hasBackgroundLocation) {
      print('[BG] UYARI: Arka plan konum izni verilmedi!');
    }

    // Pil izlemeyi başlat - sensör dinleme pil durumuna göre otomatik yönetilecek
    _startBatteryMonitoring();
  }

  Future<void> _handleEarthquakeData(dynamic data, String type) async {
    try {
      final prefs = await SharedPreferences.getInstance();
      final notificationRadius =
          prefs.getDouble('notification_radius') ?? 100.0;
      final minMagnitude = prefs.getDouble('min_magnitude') ?? 2.5;

      final magnitude = (data['magnitude'] ?? 0.0).toDouble();
      final location = data['location'] ?? 'Bilinmeyen';
      final earthquakeLat = (data['lat'] ?? 0.0).toDouble();
      final earthquakeLon = (data['lon'] ?? 0.0).toDouble();

      print(
          '📍 Deprem: M$magnitude - $location ($earthquakeLat, $earthquakeLon)');
      print(
          '📏 Filtreler: Min M$minMagnitude, Yaricap ${notificationRadius}km');

      // Magnitude filtresi
      if (magnitude < minMagnitude) {
        print('⏭️  Magnitude cok dusuk ($magnitude < $minMagnitude), atlandi');
        return;
      }

      // Kullanicinin son bilinen konumunu al (SharedPreferences'tan)
      final userLat = prefs.getDouble('last_latitude');
      final userLon = prefs.getDouble('last_longitude');

      if (userLat == null || userLon == null) {
        print('⚠️  Kullanici konumu bilinmiyor, mesafe kontrolu yapilamiyor');
        print('   Bildirim yine de gosteriliyor...');
      } else {
        // Mesafe hesapla
        final distance =
            _calculateDistance(userLat, userLon, earthquakeLat, earthquakeLon);
        print('📏 Mesafe: ${distance.toStringAsFixed(1)} km');

        if (distance > notificationRadius) {
          print(
              '⏭️  Mesafe cok uzak (${distance.toStringAsFixed(1)} km > $notificationRadius km), atlandi');
          return;
        }
      }

      // Ekran durumu kontrolü
      bool isScreenOn = await ScreenStateService.isScreenOn();
      final notificationService = NotificationService();
      if (!isScreenOn) {
        print('🚨 Ekran kapalı, tam ekran afiş açılıyor...');
        try {
          final prefs = await SharedPreferences.getInstance();
          final userLat = prefs.getDouble('last_latitude');
          final userLon = prefs.getDouble('last_longitude');
          double distance = 0;
          if (userLat != null && userLon != null) {
            distance = _calculateDistance(
                userLat, userLon, earthquakeLat, earthquakeLon);
          }
          await notificationService.showFullScreenEarthquakeAlert(
            magnitude: magnitude,
            location: location,
            distance: distance,
            source: type.toUpperCase(),
            earthquakeLat: earthquakeLat,
            earthquakeLon: earthquakeLon,
            userLat: userLat,
            userLon: userLon,
          );
          print('✅ Tam ekran alarm gonderildi');
        } catch (e) {
          print('❌ Alarm gonderme hatasi: $e');
        }
      } else {
        print('📲 Ekran açık, sadece bildirim gönderiliyor...');
        await notificationService.showNotification(
          title: 'Deprem Algılandı!',
          body: 'M$magnitude - $location',
        );
      }

      // Ekranı uyandır
      try {
        FlutterForegroundTask.wakeUpScreen();
        print('✅ Ekran uyandirma cagrisi yapildi');
      } catch (e) {
        print('⚠️  Ekran uyandirma hatasi: $e');
      }

      // Background service notification'ı güncelle - deprem bildirimi sonrası normale dön
      FlutterForegroundTask.updateService(
        notificationTitle: 'Deprem Hattı İzlemede',
        notificationText: 'Deprem hattı izliyor',
      );

      print('✅ Background notification gosterildi: M$magnitude - $location');
    } catch (e) {
      print('❌ Deprem data isleme hatasi: $e');
    }
  }

  // Mesafe hesaplama (Haversine formulu)
  double _calculateDistance(
      double lat1, double lon1, double lat2, double lon2) {
    const double earthRadius = 6371; // km
    final dLat = _toRadians(lat2 - lat1);
    final dLon = _toRadians(lon2 - lon1);

    final a = sin(dLat / 2) * sin(dLat / 2) +
        cos(_toRadians(lat1)) *
            cos(_toRadians(lat2)) *
            sin(dLon / 2) *
            sin(dLon / 2);

    final c = 2 * atan2(sqrt(a), sqrt(1 - a));
    return earthRadius * c;
  }

  double _toRadians(double degrees) {
    return degrees * (pi / 180.0);
  }

  @override
  void onRepeatEvent(DateTime timestamp) {
    // FCM ile bildirim altyapısı kullanılacak. Burada arka plan güncellemesi yapılmıyor.
    // ...existing code...
  }

  @override
  Future<void> onDestroy(DateTime timestamp) async {
    print('🔴 Background task durduruluyor');
    try {
      _stopBatteryMonitoring();
    } catch (e) {
      print('[BG] Battery monitoring stop error: $e');
    }
    try {
      _stopSensorListening();
    } catch (e) {
      print('[BG] Sensor listening stop error: $e');
    }
  }

  @override
  void onNotificationPressed() {
    FlutterForegroundTask.launchApp();
  }

  @override
  void onNotificationButtonPressed(String id) {
    if (id == 'stop') {
      print('[BG] 🛑 Durdur butonuna basıldı, servis durduruluyor...');
      _stopBatteryMonitoring();
      _stopSensorListening();
      FlutterForegroundTask.stopService();
    }
  }

  @override
  void onNotificationDismissed() {
    // Notification kapatıldığında bir şey yapma
    print('[BG] Notification kapatıldı');
  }
}
