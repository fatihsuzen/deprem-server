import 'dart:async';
import 'dart:convert';
import 'dart:io';
import 'dart:math';
import 'package:flutter/material.dart';
import 'package:sensors_plus/sensors_plus.dart';
import 'package:path_provider/path_provider.dart';
import 'package:share_plus/share_plus.dart';

/// Sensör Veri Kaydedici
/// Manuel olarak deprem simüle edip verileri kayıt altına alır
/// Bu veriler algoritma eşik değerlerini ayarlamak için kullanılır
class SensorDataRecorderScreen extends StatefulWidget {
  const SensorDataRecorderScreen({super.key});

  @override
  State<SensorDataRecorderScreen> createState() =>
      _SensorDataRecorderScreenState();
}

class _SensorDataRecorderScreenState extends State<SensorDataRecorderScreen> {
  // Sensör aboneliği
  StreamSubscription<AccelerometerEvent>? _subscription;

  // Kayıt durumu
  bool _isRecording = false;
  String _recordingType = ''; // 'normal', 'weak', 'medium', 'strong'
  DateTime? _recordingStartTime;

  // Kayıtlı veriler
  final List<Map<String, dynamic>> _recordedData = [];

  // Anlık değerler
  double _currentX = 0;
  double _currentY = 0;
  double _currentZ = 0;
  double _currentMagnitude = 0;
  double _lastMagnitude = 0;
  double _currentDelta = 0;

  // İstatistikler
  final List<double> _deltaBuffer = [];
  double _maxDelta = 0;
  double _avgDelta = 0;
  double _stdDelta = 0;

  // Kaydedilmiş oturumlar
  final List<Map<String, dynamic>> _savedSessions = [];

  @override
  void initState() {
    super.initState();
    _startListening();
    _loadSavedSessions();
  }

  @override
  void dispose() {
    _subscription?.cancel();
    super.dispose();
  }

  void _startListening() {
    _subscription = accelerometerEventStream(
      samplingPeriod: const Duration(milliseconds: 20), // 50 Hz
    ).listen((event) {
      final magnitude =
          sqrt(event.x * event.x + event.y * event.y + event.z * event.z);
      final delta = (magnitude - _lastMagnitude).abs();

      setState(() {
        _currentX = event.x;
        _currentY = event.y;
        _currentZ = event.z;
        _currentMagnitude = magnitude;
        _currentDelta = delta;
        _lastMagnitude = magnitude;
      });

      // Kayıt modundaysa veriyi kaydet
      if (_isRecording) {
        final dataPoint = {
          'timestamp': DateTime.now().toIso8601String(),
          'elapsed_ms':
              DateTime.now().difference(_recordingStartTime!).inMilliseconds,
          'x': event.x,
          'y': event.y,
          'z': event.z,
          'magnitude': magnitude,
          'delta': delta,
        };
        _recordedData.add(dataPoint);

        // İstatistikleri güncelle
        _deltaBuffer.add(delta);
        if (delta > _maxDelta) _maxDelta = delta;
        _avgDelta = _deltaBuffer.reduce((a, b) => a + b) / _deltaBuffer.length;

        // Standart sapma hesapla
        if (_deltaBuffer.length > 1) {
          double sumSquares = 0;
          for (var d in _deltaBuffer) {
            sumSquares += pow(d - _avgDelta, 2);
          }
          _stdDelta = sqrt(sumSquares / _deltaBuffer.length);
        }
      }
    });
  }

  Future<void> _loadSavedSessions() async {
    try {
      final dir = await getApplicationDocumentsDirectory();
      final file = File('${dir.path}/sensor_sessions.json');
      if (await file.exists()) {
        final content = await file.readAsString();
        final List<dynamic> sessions = jsonDecode(content);
        setState(() {
          _savedSessions.clear();
          _savedSessions.addAll(sessions.cast<Map<String, dynamic>>());
        });
      }
    } catch (e) {
      print('Oturumlar yüklenemedi: $e');
    }
  }

  Future<void> _saveSessions() async {
    try {
      final dir = await getApplicationDocumentsDirectory();
      final file = File('${dir.path}/sensor_sessions.json');
      await file.writeAsString(jsonEncode(_savedSessions));
    } catch (e) {
      print('Oturumlar kaydedilemedi: $e');
    }
  }

  void _startRecording(String type) {
    setState(() {
      _isRecording = true;
      _recordingType = type;
      _recordingStartTime = DateTime.now();
      _recordedData.clear();
      _deltaBuffer.clear();
      _maxDelta = 0;
      _avgDelta = 0;
      _stdDelta = 0;
    });

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text('📹 Kayıt başladı: $type'),
        backgroundColor: Colors.red,
      ),
    );
  }

  Future<void> _stopRecording() async {
    if (!_isRecording) return;

    final duration = DateTime.now().difference(_recordingStartTime!);

    // Oturum özeti oluştur
    final session = {
      'id': DateTime.now().millisecondsSinceEpoch.toString(),
      'type': _recordingType,
      'startTime': _recordingStartTime!.toIso8601String(),
      'duration_ms': duration.inMilliseconds,
      'sampleCount': _recordedData.length,
      'stats': {
        'maxDelta': _maxDelta,
        'avgDelta': _avgDelta,
        'stdDelta': _stdDelta,
      },
      'data': _recordedData.toList(),
    };

    setState(() {
      _isRecording = false;
      _savedSessions.add(session);
    });

    await _saveSessions();

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(
            '✅ Kayıt tamamlandı: ${_recordedData.length} örnek, ${duration.inSeconds}s'),
        backgroundColor: Colors.green,
      ),
    );

    // Özet göster
    _showSessionSummary(session);
  }

  void _showSessionSummary(Map<String, dynamic> session) {
    final stats = session['stats'] as Map<String, dynamic>;
    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: Text('📊 Kayıt Özeti: ${session['type']}'),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
                'Süre: ${(session['duration_ms'] / 1000).toStringAsFixed(1)} saniye'),
            Text('Örnek Sayısı: ${session['sampleCount']}'),
            const Divider(),
            Text(
                'Max Delta: ${(stats['maxDelta'] as double).toStringAsFixed(4)}'),
            Text(
                'Ort. Delta: ${(stats['avgDelta'] as double).toStringAsFixed(4)}'),
            Text(
                'Std Sapma: ${(stats['stdDelta'] as double).toStringAsFixed(4)}'),
            const Divider(),
            const Text('💡 Önerilen Eşikler:',
                style: TextStyle(fontWeight: FontWeight.bold)),
            if (session['type'] == 'normal')
              Text(
                  'Baseline STD: ${(stats['stdDelta'] as double).toStringAsFixed(4)}'),
            if (session['type'] != 'normal')
              Text(
                  'Algılama Eşiği: ${((stats['stdDelta'] as double) * 0.8).toStringAsFixed(4)}'),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx),
            child: const Text('Tamam'),
          ),
        ],
      ),
    );
  }

  Future<void> _exportAllSessions() async {
    if (_savedSessions.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Kaydedilmiş oturum yok')),
      );
      return;
    }

    try {
      final dir = await getApplicationDocumentsDirectory();
      final exportFile = File(
          '${dir.path}/sensor_export_${DateTime.now().millisecondsSinceEpoch}.json');

      // Analiz özeti oluştur
      final analysis = _analyzeAllSessions();

      final exportData = {
        'exportDate': DateTime.now().toIso8601String(),
        'sessionCount': _savedSessions.length,
        'analysis': analysis,
        'sessions': _savedSessions,
      };

      await exportFile.writeAsString(
          const JsonEncoder.withIndent('  ').convert(exportData));

      // Paylaş
      await Share.shareXFiles(
        [XFile(exportFile.path)],
        subject: 'Deprem Sensör Verileri',
      );
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Export hatası: $e')),
      );
    }
  }

  Map<String, dynamic> _analyzeAllSessions() {
    // Tüm oturumları türe göre grupla
    final Map<String, List<Map<String, dynamic>>> byType = {};
    for (var session in _savedSessions) {
      final type = session['type'] as String;
      byType.putIfAbsent(type, () => []);
      byType[type]!.add(session);
    }

    // Her tür için istatistik hesapla
    final Map<String, dynamic> analysis = {};

    byType.forEach((type, sessions) {
      double totalMaxDelta = 0;
      double totalAvgDelta = 0;
      double totalStdDelta = 0;

      for (var s in sessions) {
        final stats = s['stats'] as Map<String, dynamic>;
        totalMaxDelta += stats['maxDelta'] as double;
        totalAvgDelta += stats['avgDelta'] as double;
        totalStdDelta += stats['stdDelta'] as double;
      }

      analysis[type] = {
        'sessionCount': sessions.length,
        'avgMaxDelta': totalMaxDelta / sessions.length,
        'avgAvgDelta': totalAvgDelta / sessions.length,
        'avgStdDelta': totalStdDelta / sessions.length,
      };
    });

    // Önerilen eşik değerlerini hesapla
    if (analysis.containsKey('normal') && analysis.keys.length > 1) {
      final normalStd = analysis['normal']['avgStdDelta'] as double;

      // En düşük deprem türünü bul (weak > medium > strong sırasında)
      double? lowestEarthquakeStd;
      for (var type in ['weak', 'medium', 'strong']) {
        if (analysis.containsKey(type)) {
          final std = analysis[type]['avgStdDelta'] as double;
          if (lowestEarthquakeStd == null || std < lowestEarthquakeStd) {
            lowestEarthquakeStd = std;
          }
        }
      }

      if (lowestEarthquakeStd != null) {
        // Önerilen çarpan: en düşük deprem STD / normal STD
        final suggestedMultiplier = lowestEarthquakeStd / normalStd;
        analysis['recommendations'] = {
          'baselineStd': normalStd,
          'lowestEarthquakeStd': lowestEarthquakeStd,
          'suggestedStdMultiplier':
              suggestedMultiplier * 0.9, // %10 güvenlik payı
          'suggestedAbsoluteThreshold':
              lowestEarthquakeStd * 0.8, // %20 güvenlik payı
        };
      }
    }

    return analysis;
  }

  void _showAnalysis() {
    final analysis = _analyzeAllSessions();

    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: const Text('📈 Veri Analizi'),
        content: SingleChildScrollView(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              ...analysis.entries
                  .where((e) => e.key != 'recommendations')
                  .map((e) {
                final type = e.key;
                final data = e.value as Map<String, dynamic>;
                return Padding(
                  padding: const EdgeInsets.only(bottom: 12),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('📁 $type (${data['sessionCount']} oturum)',
                          style: const TextStyle(fontWeight: FontWeight.bold)),
                      Text(
                          '  Ort. Max Delta: ${(data['avgMaxDelta'] as double).toStringAsFixed(4)}'),
                      Text(
                          '  Ort. Avg Delta: ${(data['avgAvgDelta'] as double).toStringAsFixed(4)}'),
                      Text(
                          '  Ort. STD: ${(data['avgStdDelta'] as double).toStringAsFixed(4)}'),
                    ],
                  ),
                );
              }),
              if (analysis.containsKey('recommendations')) ...[
                const Divider(),
                const Text('🎯 ÖNERİLEN DEĞİŞKENLER:',
                    style: TextStyle(
                        fontWeight: FontWeight.bold, color: Colors.green)),
                const SizedBox(height: 8),
                Text(
                    'stdMultiplier: ${(analysis['recommendations']['suggestedStdMultiplier'] as double).toStringAsFixed(2)}'),
                Text(
                    'minAbsoluteThreshold: ${(analysis['recommendations']['suggestedAbsoluteThreshold'] as double).toStringAsFixed(4)}'),
              ],
            ],
          ),
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx),
            child: const Text('Kapat'),
          ),
          TextButton(
            onPressed: () {
              Navigator.pop(ctx);
              _exportAllSessions();
            },
            child: const Text('Dışa Aktar'),
          ),
        ],
      ),
    );
  }

  void _clearAllSessions() {
    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: const Text('⚠️ Tüm Kayıtları Sil'),
        content:
            const Text('Tüm kaydedilmiş oturumlar silinecek. Emin misiniz?'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx),
            child: const Text('İptal'),
          ),
          TextButton(
            onPressed: () async {
              Navigator.pop(ctx);
              setState(() {
                _savedSessions.clear();
              });
              await _saveSessions();
              ScaffoldMessenger.of(context).showSnackBar(
                const SnackBar(content: Text('Tüm kayıtlar silindi')),
              );
            },
            child: const Text('Sil', style: TextStyle(color: Colors.red)),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('🔬 Sensör Kaydedici'),
        backgroundColor: _isRecording ? Colors.red : null,
        actions: [
          IconButton(
            icon: const Icon(Icons.analytics),
            onPressed: _savedSessions.isNotEmpty ? _showAnalysis : null,
            tooltip: 'Analiz',
          ),
          IconButton(
            icon: const Icon(Icons.delete_forever),
            onPressed: _savedSessions.isNotEmpty ? _clearAllSessions : null,
            tooltip: 'Tümünü Sil',
          ),
        ],
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            // Anlık değerler kartı
            Card(
              child: Padding(
                padding: const EdgeInsets.all(16),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text('📱 Anlık Sensör Değerleri',
                        style: TextStyle(
                            fontSize: 18, fontWeight: FontWeight.bold)),
                    const SizedBox(height: 12),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        _buildValueBox('X', _currentX, Colors.red),
                        _buildValueBox('Y', _currentY, Colors.green),
                        _buildValueBox('Z', _currentZ, Colors.blue),
                      ],
                    ),
                    const Divider(),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        _buildValueBox(
                            'Magnitude', _currentMagnitude, Colors.purple),
                        _buildValueBox('Delta', _currentDelta, Colors.orange),
                      ],
                    ),
                  ],
                ),
              ),
            ),

            const SizedBox(height: 16),

            // Kayıt durumu
            if (_isRecording) ...[
              Card(
                color: Colors.red.shade50,
                child: Padding(
                  padding: const EdgeInsets.all(16),
                  child: Column(
                    children: [
                      Row(
                        children: [
                          const Icon(Icons.fiber_manual_record,
                              color: Colors.red),
                          const SizedBox(width: 8),
                          Text('KAYIT: $_recordingType',
                              style: const TextStyle(
                                  fontWeight: FontWeight.bold,
                                  color: Colors.red)),
                        ],
                      ),
                      const SizedBox(height: 8),
                      Text('Örnek: ${_recordedData.length}'),
                      Text('Max Delta: ${_maxDelta.toStringAsFixed(4)}'),
                      Text('Ort. Delta: ${_avgDelta.toStringAsFixed(4)}'),
                      Text('STD: ${_stdDelta.toStringAsFixed(4)}'),
                      const SizedBox(height: 12),
                      ElevatedButton.icon(
                        onPressed: _stopRecording,
                        icon: const Icon(Icons.stop),
                        label: const Text('KAYDI DURDUR'),
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.red,
                          foregroundColor: Colors.white,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ] else ...[
              // Kayıt başlatma butonları
              const Text('📹 Kayıt Başlat:',
                  style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
              const SizedBox(height: 8),
              const Text(
                  'Telefonu masada sabit tutarak veya hareket ettirerek kayıt alın.',
                  style: TextStyle(color: Colors.grey)),
              const SizedBox(height: 12),

              Wrap(
                spacing: 8,
                runSpacing: 8,
                children: [
                  _buildRecordButton(
                      'normal', '📱 Normal (Sabit)', Colors.grey),
                  _buildRecordButton('weak', '🟢 Zayıf Sallama', Colors.green),
                  _buildRecordButton(
                      'medium', '🟡 Orta Sallama', Colors.orange),
                  _buildRecordButton('strong', '🔴 Güçlü Sallama', Colors.red),
                ],
              ),
            ],

            const SizedBox(height: 24),

            // Kaydedilmiş oturumlar
            Card(
              child: Padding(
                padding: const EdgeInsets.all(16),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Text(
                            '📁 Kaydedilmiş Oturumlar (${_savedSessions.length})',
                            style: const TextStyle(
                                fontSize: 16, fontWeight: FontWeight.bold)),
                        if (_savedSessions.isNotEmpty)
                          TextButton.icon(
                            onPressed: _exportAllSessions,
                            icon: const Icon(Icons.share, size: 18),
                            label: const Text('Dışa Aktar'),
                          ),
                      ],
                    ),
                    const SizedBox(height: 8),
                    if (_savedSessions.isEmpty)
                      const Text('Henüz kayıt yok',
                          style: TextStyle(color: Colors.grey))
                    else
                      ..._savedSessions.reversed.take(5).map((s) => ListTile(
                            dense: true,
                            leading: _getTypeIcon(s['type']),
                            title: Text(s['type']),
                            subtitle: Text(
                                '${s['sampleCount']} örnek, STD: ${(s['stats']['stdDelta'] as double).toStringAsFixed(4)}'),
                            trailing: IconButton(
                              icon: const Icon(Icons.delete, size: 20),
                              onPressed: () {
                                setState(() {
                                  _savedSessions.remove(s);
                                });
                                _saveSessions();
                              },
                            ),
                          )),
                  ],
                ),
              ),
            ),

            const SizedBox(height: 24),

            // Kullanım talimatları
            const Card(
              child: Padding(
                padding: EdgeInsets.all(16),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('📋 Kullanım Talimatları',
                        style: TextStyle(
                            fontSize: 16, fontWeight: FontWeight.bold)),
                    SizedBox(height: 8),
                    Text(
                        '1. "Normal" kaydı alın - telefonu sabit tutun (5-10 sn)'),
                    Text('2. "Zayıf Sallama" - hafif titretme (3-5 sn)'),
                    Text('3. "Orta Sallama" - orta şiddette sallama (3-5 sn)'),
                    Text('4. "Güçlü Sallama" - güçlü sallama (3-5 sn)'),
                    Text(
                        '5. "Analiz" butonuna tıklayarak önerilen değerleri görün'),
                    SizedBox(height: 8),
                    Text('💡 Her türden en az 3-5 kayıt alın!',
                        style: TextStyle(fontWeight: FontWeight.bold)),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildValueBox(String label, double value, Color color) {
    return Column(
      children: [
        Text(label,
            style: TextStyle(color: color, fontWeight: FontWeight.bold)),
        Text(value.toStringAsFixed(3), style: const TextStyle(fontSize: 16)),
      ],
    );
  }

  Widget _buildRecordButton(String type, String label, Color color) {
    return ElevatedButton(
      onPressed: () => _startRecording(type),
      style: ElevatedButton.styleFrom(
        backgroundColor: color,
        foregroundColor: Colors.white,
        padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
      ),
      child: Text(label),
    );
  }

  Icon _getTypeIcon(String type) {
    switch (type) {
      case 'normal':
        return const Icon(Icons.phone_android, color: Colors.grey);
      case 'weak':
        return const Icon(Icons.vibration, color: Colors.green);
      case 'medium':
        return const Icon(Icons.vibration, color: Colors.orange);
      case 'strong':
        return const Icon(Icons.vibration, color: Colors.red);
      default:
        return const Icon(Icons.help);
    }
  }
}
