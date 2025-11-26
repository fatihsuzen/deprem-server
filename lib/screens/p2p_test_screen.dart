import 'package:flutter/material.dart';
import '../services/p2p_earthquake_detection_service.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:sensors_plus/sensors_plus.dart';
import 'dart:async';
import 'dart:math';

/// P2P Deprem Simülasyon Ekranı
/// Masa üzerinde telefonu sallayarak test için
class P2PTestScreen extends StatefulWidget {
  const P2PTestScreen({Key? key}) : super(key: key);

  @override
  State<P2PTestScreen> createState() => _P2PTestScreenState();
}

class _P2PTestScreenState extends State<P2PTestScreen> {
  // ...existing code...
  // Deprem ve kullanıcı hareketi ayırt etmek için pencere
  List<Map<String, dynamic>> _shakeEvents = [];
  static const int SHAKE_WINDOW_MS = 3000; // pencere süresi 3 saniye
  static const int DEPREM_SHAKE_COUNT = 2; // olay sayısı 2'ye düşürüldü
  // ...existing code...
  final P2PEarthquakeDetectionService _p2pService =
      P2PEarthquakeDetectionService();

  bool _isMonitoring = false;
  List<String> _logs = [];

  // Gerçek zamanlı sensör verileri
  double _currentMagnitude = 0.0;
  double _maxMagnitude = 0.0;
  int _shakeCount = 0;
  int _reportsSent = 0;
  StreamSubscription<AccelerometerEvent>? _accelerometerSubscription;
  DateTime? _lastShakeTime;

  // GERÇEKÇİ DEPREM ALGORİTMASI - 3.0 DEPREM TESTİ
  static const double GRAVITY = 9.8;
  static const double NOISE_THRESHOLD = 0.3; // m/s² - Normal titreşim
  static const double SHAKE_THRESHOLD =
      0.8; // m/s² - 3.0 deprem (hafif sarsıntı)
  static const double REPORT_THRESHOLD = 1.2; // m/s² - Rapor eşiği

  // Baseline kalibrasyon
  double _baselineX = 0.0;
  double _baselineY = 0.0;
  double _baselineZ = GRAVITY;
  int _calibrationCount = 0;
  static const int CALIBRATION_SAMPLES = 20;

  @override
  void initState() {
    super.initState();
    _addLog('📱 P2P Test Ekranı hazır');
    _addLog('ℹ️ Telefonu masaya koy ve masayı salla');
  }

  @override
  void dispose() {
    _stopMonitoring();
    super.dispose();
  }

  void _startMonitoring() {
    if (_isMonitoring) return;

    setState(() {
      _isMonitoring = true;
      _maxMagnitude = 0.0;
      _shakeCount = 0;
      _reportsSent = 0;
      _logs.clear();
    });

    _addLog('🟢 İzleme başladı');
    _addLog('📐 Kalibrasyon yapılıyor... (20 örnek)');
    _addLog('📊 3.0 deprem eşiği: ${SHAKE_THRESHOLD.toStringAsFixed(1)} m/s²');

    // P2P servisini başlat
    _p2pService.startMonitoring();

    // Kalibrasyon ve baseline sıfırla
    _calibrationCount = 0;
    _baselineX = 0.0;
    _baselineY = 0.0;
    _baselineZ = GRAVITY;

    // Manuel sensör dinleme (görsel feedback için)
    _accelerometerSubscription =
        accelerometerEvents.listen((AccelerometerEvent event) {
      if (!mounted) return;
      // 1. KALİBRASYON: İlk 20 örnek
      if (_calibrationCount < CALIBRATION_SAMPLES) {
        _baselineX += event.x;
        _baselineY += event.y;
        _baselineZ += event.z;
        _calibrationCount++;

        if (_calibrationCount == CALIBRATION_SAMPLES) {
          _baselineX /= CALIBRATION_SAMPLES;
          _baselineY /= CALIBRATION_SAMPLES;
          _baselineZ /= CALIBRATION_SAMPLES;
          _addLog(
              '✅ Kalibrasyon tamamlandı: (${_baselineX.toStringAsFixed(2)}, ${_baselineY.toStringAsFixed(2)}, ${_baselineZ.toStringAsFixed(2)})');
        }
        return;
      }

      // 2. GRAVİTY FİLTRELEME
      final deltaX = event.x - _baselineX;
      final deltaY = event.y - _baselineY;
      final deltaZ = event.z - _baselineZ;
      double magnitude =
          sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

      setState(() {
        _currentMagnitude = magnitude;

        if (magnitude > _maxMagnitude) {
          _maxMagnitude = magnitude;
        }

        // 3. NOISE FİLTRELEME
        if (magnitude < NOISE_THRESHOLD) {
          return; // Çok küçük, normal titreşim
        }

        // 4. SARSINTIYI ALGILA
        if (magnitude > SHAKE_THRESHOLD) {
          final now = DateTime.now();

          // Sarsıntı olaylarını pencereye ekle (zaman ve eksenler)
          _shakeEvents.add({
            'time': now,
            'deltaX': deltaX.abs(),
            'deltaY': deltaY.abs(),
            'deltaZ': deltaZ.abs(),
          });
          // Pencere dışındaki eski olayları temizle
          _shakeEvents = _shakeEvents
              .where((e) =>
                  now.difference(e['time']).inMilliseconds <= SHAKE_WINDOW_MS)
              .toList();

          // Spam önleme - 0.5 saniyede bir log
          if (_lastShakeTime == null ||
              now.difference(_lastShakeTime!).inMilliseconds >= 500) {
            _shakeCount++;
            _lastShakeTime = now;
            _addLog('⚡ Sarsıntı! ${magnitude.toStringAsFixed(2)} m/s²');

            // Deprem mi kullanıcı hareketi mi?
            // 1. Pencere içinde olay sayısı
            int shakeCount = _shakeEvents.length;
            // 2. Olaylar arası ortalama süre
            double avgInterval = 0;
            if (shakeCount > 1) {
              List<int> intervals = [];
              for (int i = 1; i < _shakeEvents.length; i++) {
                intervals.add(_shakeEvents[i]['time']
                    .difference(_shakeEvents[i - 1]['time'])
                    .inMilliseconds);
              }
              avgInterval =
                  intervals.reduce((a, b) => a + b) / intervals.length;
            }
            // 3. Eksenlerdeki ani değişim (en az 1 eksende threshold üstü)
            int multiAxisCount = _shakeEvents
                .where((e) =>
                    (e['deltaX'] > SHAKE_THRESHOLD &&
                        e['deltaY'] > SHAKE_THRESHOLD) ||
                    (e['deltaX'] > SHAKE_THRESHOLD &&
                        e['deltaZ'] > SHAKE_THRESHOLD) ||
                    (e['deltaY'] > SHAKE_THRESHOLD &&
                        e['deltaZ'] > SHAKE_THRESHOLD))
                .length;

            if (shakeCount >= DEPREM_SHAKE_COUNT &&
                avgInterval < 900 &&
                multiAxisCount >= 1) {
              _addLog(
                  '🌍 Deprem sarsıntısı algılandı (pencere: $shakeCount olay, ort. aralık: ${avgInterval.toStringAsFixed(0)}ms, çoklu eksen: $multiAxisCount)');
              // Rapor gönderme eşiği
              if (magnitude > REPORT_THRESHOLD) {
                _addLog('📤 RAPOR! ${magnitude.toStringAsFixed(2)} m/s²');
                _reportsSent++;
              }
            } else {
              _addLog(
                  '👤 Kullanıcı hareketi algılandı (pencere: $shakeCount olay, ort. aralık: ${avgInterval.toStringAsFixed(0)}ms, çoklu eksen: $multiAxisCount)');
            }

            // Sarsıntıdan sonra otomatik kalibrasyon başlat
            _addLog('🔄 Sarsıntı sonrası otomatik kalibrasyon başlatıldı');
            _calibrationCount = 0;
            _baselineX = 0.0;
            _baselineY = 0.0;
            _baselineZ = GRAVITY;
          }
        }
      });
    });

    _addLog('✅ Sensörler aktif');
  }

  void _stopMonitoring() {
    if (!_isMonitoring) return;

    setState(() => _isMonitoring = false);

    _accelerometerSubscription?.cancel();
    _accelerometerSubscription = null;
    _p2pService.stopMonitoring();

    _addLog('🔴 İzleme durduruldu');
    _addLog('📊 Toplam sarsıntı: $_shakeCount');
    _addLog('📊 Gönderilen rapor: $_reportsSent');
    _addLog('📊 Max şiddet: ${_maxMagnitude.toStringAsFixed(1)} m/s²');
  }

  Future<void> _checkServerStats() async {
    try {
      _addLog('🔄 Sunucu istatistikleri kontrol ediliyor...');

      final response = await http
          .get(
            Uri.parse('http://188.132.202.24:3000/api/p2p/stats'),
          )
          .timeout(const Duration(seconds: 10));

      if (response.statusCode == 200) {
        final stats = json.decode(response.body);
        _addLog('✅ Sunucu yanıtı alındı');
        _addLog('📊 Toplam rapor: ${stats['totalReports'] ?? 0}');
        _addLog('📊 Son 30sn rapor: ${stats['reportsLast30Sec'] ?? 0}');
        _addLog(
            '📊 Tespit edilen deprem: ${stats['detectedEarthquakes'] ?? 0}');
      } else {
        _addLog('❌ Sunucu hatası: ${response.statusCode}');
      }
    } catch (e) {
      _addLog('❌ Bağlantı hatası: $e');
    }
  }

  Future<void> _sendTestReport() async {
    try {
      _addLog('🧪 Test raporu gönderiliyor...');

      final testReport = {
        'userId': 'test_user_${DateTime.now().millisecondsSinceEpoch}',
        'location': {
          'latitude': 40.9594 + (Random().nextDouble() - 0.5) * 0.01,
          'longitude': 29.2197 + (Random().nextDouble() - 0.5) * 0.01,
          'accuracy': 10.0,
        },
        'sensorData': {
          'accelerationMagnitude': 25.0 + Random().nextDouble() * 10,
          'probabilityScore': 75 + Random().nextInt(20),
          'duration': 3.0,
          'peakAcceleration': 30.0,
        },
        'deviceInfo': {
          'platform': 'Android',
          'model': 'Test Device',
        },
        'timestamp': DateTime.now().toIso8601String(),
      };

      final response = await http
          .post(
            Uri.parse('http://188.132.202.24:3000/api/p2p/shake-report'),
            headers: {'Content-Type': 'application/json'},
            body: json.encode(testReport),
          )
          .timeout(const Duration(seconds: 10));

      if (response.statusCode == 200) {
        final result = json.decode(response.body);
        _addLog('✅ Test raporu başarılı');
        _addLog('📊 Analiz: ${result['message']}');
        if (result['analysis'] != null) {
          _addLog('📍 Bölge: ${result['analysis']['region']}');
          _addLog(
              '📈 Olasılık: ${result['analysis']['earthquakeProbability']}%');
        }
      } else {
        _addLog('❌ Sunucu hatası: ${response.statusCode}');
      }
    } catch (e) {
      _addLog('❌ Test raporu hatası: $e');
    }
  }

  void _clearLogs() {
    setState(() {
      _logs.clear();
      _shakeCount = 0;
      _reportsSent = 0;
      _maxMagnitude = 0.0;
    });
    _addLog('🗑️ Loglar temizlendi');
  }

  void _addLog(String message) {
    setState(() {
      final timestamp = DateTime.now().toString().substring(11, 19);
      _logs.insert(0, '[$timestamp] $message');

      // Max 50 log tut
      if (_logs.length > 50) {
        _logs.removeLast();
      }
    });
  }

  Color _getMagnitudeColor() {
    if (_currentMagnitude > REPORT_THRESHOLD) return Colors.red;
    if (_currentMagnitude > SHAKE_THRESHOLD) return Colors.orange;
    return Colors.green;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('P2P Deprem Simülasyonu'),
        backgroundColor: const Color(0xFFFF3A3D),
        actions: [
          IconButton(
            icon: const Icon(Icons.delete_outline),
            onPressed: _clearLogs,
            tooltip: 'Logları Temizle',
          ),
        ],
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text('P2P Deprem Testi',
                    style: Theme.of(context).textTheme.titleLarge),
                const SizedBox(height: 8),
                Text(
                    'Telefonu masaya koyup sallayarak deprem simülasyonu yapabilirsin.',
                    style: Theme.of(context).textTheme.bodyLarge),
                const SizedBox(height: 16),
                Row(
                  children: [
                    ElevatedButton(
                      onPressed: _isMonitoring ? null : _startMonitoring,
                      child: const Text('İzlemeyi Başlat'),
                    ),
                    const SizedBox(width: 12),
                    ElevatedButton(
                      onPressed: _isMonitoring ? _stopMonitoring : null,
                      child: const Text('Durdur'),
                    ),
                  ],
                ),
                const SizedBox(height: 16),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceAround,
                  children: [
                    _buildStatBox(
                        'Sarsıntı', _shakeCount.toString(), Icons.vibration),
                    _buildStatBox('Rapor', _reportsSent.toString(), Icons.send),
                    _buildStatBox('Max', '${_maxMagnitude.toStringAsFixed(1)}',
                        Icons.arrow_upward),
                  ],
                ),
                const SizedBox(height: 16),
                Row(
                  children: [
                    Expanded(
                      child: ElevatedButton.icon(
                        onPressed: _sendTestReport,
                        icon: const Icon(Icons.science),
                        label: const Text('Test Raporu Gönder'),
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.blue,
                          padding: const EdgeInsets.symmetric(vertical: 12),
                        ),
                      ),
                    ),
                    const SizedBox(width: 8),
                    Expanded(
                      child: ElevatedButton.icon(
                        onPressed: _checkServerStats,
                        icon: const Icon(Icons.analytics),
                        label: const Text('Sunucu İstatistik'),
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.purple,
                          padding: const EdgeInsets.symmetric(vertical: 12),
                        ),
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 16),
                // ...existing code...
              ],
            ),
          ),
          Expanded(
            child: Container(
              color: Colors.black87,
              child: _logs.isEmpty
                  ? const Center(
                      child: Text(
                        'Henüz log yok\n\n"İzlemeyi Başlat" butonuna bas\nve telefonu salla',
                        textAlign: TextAlign.center,
                        style: TextStyle(
                          color: Colors.white54,
                          fontSize: 16,
                        ),
                      ),
                    )
                  : ListView.builder(
                      padding: const EdgeInsets.all(8),
                      itemCount: _logs.length,
                      itemBuilder: (context, index) {
                        final log = _logs[index];
                        return Padding(
                          padding: const EdgeInsets.symmetric(vertical: 2),
                          child: Text(
                            log,
                            style: TextStyle(
                              color: log.contains('❌')
                                  ? Colors.red[300]
                                  : log.contains('✅')
                                      ? Colors.green[300]
                                      : log.contains('⚡')
                                          ? Colors.orange[300]
                                          : Colors.white,
                              fontFamily: 'monospace',
                              fontSize: 13,
                            ),
                          ),
                        );
                      },
                    ),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildStatBox(String label, String value, IconData icon) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      decoration: BoxDecoration(
        color: Colors.grey[100],
        borderRadius: BorderRadius.circular(8),
      ),
      child: Column(
        children: [
          Icon(icon, size: 20, color: Colors.grey[700]),
          const SizedBox(height: 4),
          Text(
            value,
            style: TextStyle(
              fontSize: 18,
              fontWeight: FontWeight.bold,
              color: Colors.grey[800],
            ),
          ),
          Text(
            label,
            style: TextStyle(
              fontSize: 12,
              color: Colors.grey[600],
            ),
          ),
        ],
      ),
    );
  }
}
