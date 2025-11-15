import 'package:flutter/material.dart';
import '../services/p2p_earthquake_detection_service.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

/// P2P Sistem Test Ekranı
/// Backend ve sensör testleri için
class P2PTestScreen extends StatefulWidget {
  const P2PTestScreen({Key? key}) : super(key: key);

  @override
  State<P2PTestScreen> createState() => _P2PTestScreenState();
}

class _P2PTestScreenState extends State<P2PTestScreen> {
  final P2PEarthquakeDetectionService _p2pService =
      P2PEarthquakeDetectionService();

  bool _isMonitoring = false;
  Map<String, dynamic>? _systemStats;
  List<String> _logs = [];
  bool _isLoading = false;

  @override
  void initState() {
    super.initState();
    _loadSystemStats();
  }

  Future<void> _loadSystemStats() async {
    setState(() => _isLoading = true);
    try {
      final response = await http.get(
        Uri.parse('http://188.132.202.24:3000/api/p2p/stats'),
      );

      if (response.statusCode == 200) {
        setState(() {
          _systemStats = json.decode(response.body);
          _isLoading = false;
        });
      }
    } catch (e) {
      _addLog('❌ İstatistik yükleme hatası: $e');
      setState(() => _isLoading = false);
    }
  }

  void _addLog(String message) {
    setState(() {
      _logs.insert(0,
          '${DateTime.now().toIso8601String().substring(11, 19)} - $message');
      if (_logs.length > 50) _logs.removeLast();
    });
  }

  Future<void> _startMonitoring() async {
    _addLog('🔍 P2P monitoring başlatılıyor...');
    try {
      await _p2pService.startMonitoring();
      setState(() => _isMonitoring = true);
      _addLog('✅ Monitoring aktif');
    } catch (e) {
      _addLog('❌ Başlatma hatası: $e');
    }
  }

  Future<void> _stopMonitoring() async {
    _addLog('⏹️ P2P monitoring durduruluyor...');
    await _p2pService.stopMonitoring();
    setState(() => _isMonitoring = false);
    _addLog('✅ Monitoring durduruldu');
  }

  Future<void> _sendTestReport() async {
    _addLog('📤 Test raporu gönderiliyor...');

    // Simüle edilmiş test verisi
    final testReport = {
      'userId': 'test_flutter_user',
      'deviceId': 'test_device_001',
      'location': {
        'latitude': 41.0082,
        'longitude': 28.9784,
      },
      'sensorData': {
        'maxMagnitude': 5.5,
        'avgMagnitude': 3.8,
        'duration': 4000,
        'shakeCount': 18,
        'probabilityScore': 75.0,
        'gyroData': {
          'maxRotation': 2.8,
          'avgRotation': 1.5,
        }
      },
      'timestamp': DateTime.now().toIso8601String(),
    };

    try {
      final response = await http.post(
        Uri.parse('http://188.132.202.24:3000/api/p2p/shake-report'),
        headers: {'Content-Type': 'application/json'},
        body: json.encode(testReport),
      );

      if (response.statusCode == 200) {
        final result = json.decode(response.body);
        _addLog('✅ Rapor gönderildi');
        if (result['analysis'] != null) {
          final analysis = result['analysis'];
          _addLog('   📍 Bölge: ${analysis['region']}');
          _addLog('   📊 Rapor Sayısı: ${analysis['totalReports']}');
          _addLog(
              '   📈 Olasılık: ${analysis['earthquakeProbability']?.toStringAsFixed(1)}%');
          _addLog(
              '   ${analysis['isEarthquakeDetected'] ? '🚨 DEPREM TESPİT!' : '⏳ Beklemede'}');

          if (analysis['isEarthquakeDetected']) {
            _showEarthquakeAlert(analysis);
          }
        }
        await _loadSystemStats();
      } else {
        _addLog('❌ Hata: ${response.statusCode}');
      }
    } catch (e) {
      _addLog('❌ Gönderim hatası: $e');
    }
  }

  void _showEarthquakeAlert(Map<String, dynamic> analysis) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        backgroundColor: Colors.red[900],
        title: Row(
          children: [
            Icon(Icons.warning_amber_rounded, color: Colors.white, size: 32),
            SizedBox(width: 12),
            Text(
              'DEPREM TESPİT EDİLDİ!',
              style:
                  TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
            ),
          ],
        ),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              'Bölge: ${analysis['region']}',
              style: TextStyle(color: Colors.white, fontSize: 16),
            ),
            SizedBox(height: 8),
            Text(
              'Tahmini Büyüklük: M${analysis['estimatedMagnitude']}',
              style: TextStyle(
                  color: Colors.white,
                  fontSize: 18,
                  fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 8),
            Text(
              'Toplam Rapor: ${analysis['totalReports']}',
              style: TextStyle(color: Colors.white70),
            ),
            Text(
              'Olasılık: ${analysis['earthquakeProbability']?.toStringAsFixed(1)}%',
              style: TextStyle(color: Colors.white70),
            ),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: Text('KAPAT', style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('P2P Sistem Testi'),
        backgroundColor: Colors.deepOrange,
        actions: [
          IconButton(
            icon: Icon(Icons.refresh),
            onPressed: _loadSystemStats,
          ),
        ],
      ),
      body: Column(
        children: [
          // Sistem İstatistikleri
          Container(
            color: Colors.grey[900],
            padding: EdgeInsets.all(16),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  '📊 SİSTEM İSTATİSTİKLERİ',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                SizedBox(height: 12),
                if (_isLoading)
                  Center(child: CircularProgressIndicator())
                else if (_systemStats != null) ...[
                  _buildStatRow(
                    'Aktif Raporlar (30sn)',
                    '${_systemStats!['totalReports'] ?? 0}',
                    Icons.description,
                  ),
                  _buildStatRow(
                    'Tespit Edilen Depremler',
                    '${_systemStats!['detectedEarthquakes'] ?? 0}',
                    Icons.warning_amber_rounded,
                  ),
                  if (_systemStats!['recentDetections'] != null &&
                      (_systemStats!['recentDetections'] as List)
                          .isNotEmpty) ...[
                    SizedBox(height: 12),
                    Text(
                      'Son Tespitler:',
                      style: TextStyle(color: Colors.white70, fontSize: 14),
                    ),
                    SizedBox(height: 8),
                    ...(_systemStats!['recentDetections'] as List).map(
                      (det) => Padding(
                        padding: EdgeInsets.only(bottom: 4),
                        child: Text(
                          '🚨 ${det['regionName']} - M${det['estimatedMagnitude']} (${det['totalReports']} rapor)',
                          style:
                              TextStyle(color: Colors.red[300], fontSize: 12),
                        ),
                      ),
                    ),
                  ],
                ] else
                  Text(
                    'İstatistikler yüklenemedi',
                    style: TextStyle(color: Colors.white70),
                  ),
              ],
            ),
          ),

          // Kontrol Butonları
          Container(
            padding: EdgeInsets.all(16),
            child: Column(
              children: [
                Row(
                  children: [
                    Expanded(
                      child: ElevatedButton.icon(
                        onPressed: _isMonitoring ? null : _startMonitoring,
                        icon: Icon(Icons.play_arrow),
                        label: Text('Monitoring Başlat'),
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.green,
                          padding: EdgeInsets.symmetric(vertical: 12),
                        ),
                      ),
                    ),
                    SizedBox(width: 12),
                    Expanded(
                      child: ElevatedButton.icon(
                        onPressed: _isMonitoring ? _stopMonitoring : null,
                        icon: Icon(Icons.stop),
                        label: Text('Durdur'),
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.red,
                          padding: EdgeInsets.symmetric(vertical: 12),
                        ),
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 12),
                SizedBox(
                  width: double.infinity,
                  child: ElevatedButton.icon(
                    onPressed: _sendTestReport,
                    icon: Icon(Icons.send),
                    label: Text('Test Raporu Gönder'),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.orange,
                      padding: EdgeInsets.symmetric(vertical: 12),
                    ),
                  ),
                ),
                SizedBox(height: 12),
                Container(
                  padding: EdgeInsets.all(12),
                  decoration: BoxDecoration(
                    color: _isMonitoring ? Colors.green[100] : Colors.grey[200],
                    borderRadius: BorderRadius.circular(8),
                  ),
                  child: Row(
                    children: [
                      Icon(
                        _isMonitoring
                            ? Icons.radio_button_checked
                            : Icons.radio_button_off,
                        color: _isMonitoring ? Colors.green : Colors.grey,
                      ),
                      SizedBox(width: 8),
                      Text(
                        _isMonitoring
                            ? 'Monitoring Aktif'
                            : 'Monitoring Kapalı',
                        style: TextStyle(
                          fontWeight: FontWeight.bold,
                          color: _isMonitoring
                              ? Colors.green[900]
                              : Colors.grey[700],
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),

          // Log Ekranı
          Expanded(
            child: Container(
              color: Colors.black,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Padding(
                    padding: EdgeInsets.all(12),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Text(
                          '📜 LOG',
                          style: TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        TextButton(
                          onPressed: () => setState(() => _logs.clear()),
                          child: Text('Temizle',
                              style: TextStyle(color: Colors.orange)),
                        ),
                      ],
                    ),
                  ),
                  Expanded(
                    child: ListView.builder(
                      padding: EdgeInsets.symmetric(horizontal: 12),
                      itemCount: _logs.length,
                      itemBuilder: (context, index) {
                        return Padding(
                          padding: EdgeInsets.only(bottom: 4),
                          child: Text(
                            _logs[index],
                            style: TextStyle(
                              color: Colors.green[300],
                              fontFamily: 'monospace',
                              fontSize: 12,
                            ),
                          ),
                        );
                      },
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildStatRow(String label, String value, IconData icon) {
    return Padding(
      padding: EdgeInsets.only(bottom: 8),
      child: Row(
        children: [
          Icon(icon, color: Colors.orange, size: 20),
          SizedBox(width: 8),
          Expanded(
            child: Text(
              label,
              style: TextStyle(color: Colors.white70),
            ),
          ),
          Text(
            value,
            style: TextStyle(
              color: Colors.white,
              fontSize: 18,
              fontWeight: FontWeight.bold,
            ),
          ),
        ],
      ),
    );
  }

  @override
  void dispose() {
    if (_isMonitoring) {
      _p2pService.stopMonitoring();
    }
    super.dispose();
  }
}
