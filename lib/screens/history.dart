import 'package:flutter/material.dart';
import '../services/earthquake_service.dart';
import '../services/user_preferences_service.dart';
import 'dart:math' show sin, cos, sqrt, asin;

class HistoryPage extends StatefulWidget {
  @override
  _HistoryPageState createState() => _HistoryPageState();
}

class _HistoryPageState extends State<HistoryPage> {
  String _selectedFilter = 'Tümü';
  List<Map<String, dynamic>> _earthquakes = [];
  bool _isLoading = true;
  final EarthquakeService _earthquakeService = EarthquakeService();
  final UserPreferencesService _prefsService = UserPreferencesService();
  
  double _minMagnitude = 2.5;
  double _maxMagnitude = 10.0;
  double _notificationRadius = 50.0;
  double? _userLat;
  double? _userLon;

  @override
  void initState() {
    super.initState();
    _loadSettings();
  }

  Future<void> _loadSettings() async {
    final settings = await _prefsService.getAllSettings();
    setState(() {
      _minMagnitude = settings['minMagnitude'];
      _maxMagnitude = settings['maxMagnitude'];
      _notificationRadius = settings['notificationRadius'];
    });
    await _getUserLocation();
    _loadEarthquakes();
  }

  Future<void> _getUserLocation() async {
    try {
      // LocationUpdateService'ten son bilinen konumu al
      final prefs = await _prefsService.getAllSettings();
      if (prefs.containsKey('lastLatitude') && prefs.containsKey('lastLongitude')) {
        setState(() {
          _userLat = prefs['lastLatitude'];
          _userLon = prefs['lastLongitude'];
        });
        print('📍 Konum alındı: $_userLat, $_userLon');
      } else {
        // Varsayılan: Türkiye merkezi
        setState(() {
          _userLat = 39.0;
          _userLon = 35.0;
        });
        print('⚠️ Kayıtlı konum yok, Türkiye merkezi kullanılıyor');
      }
    } catch (e) {
      print('⚠️ Konum alınamadı: $e');
      setState(() {
        _userLat = 39.0;
        _userLon = 35.0;
      });
    }
  }

  double _calculateDistance(double lat1, double lon1, double lat2, double lon2) {
    const R = 6371; // Dünya yarıçapı (km)
    final dLat = _toRadians(lat2 - lat1);
    final dLon = _toRadians(lon2 - lon1);
    final a = 
      sin(dLat / 2) * sin(dLat / 2) +
      cos(_toRadians(lat1)) * cos(_toRadians(lat2)) *
      sin(dLon / 2) * sin(dLon / 2);
    final c = 2 * asin(sqrt(a));
    return R * c;
  }

  double _toRadians(double degree) {
    return degree * 3.14159265359 / 180;
  }

  Future<void> _loadEarthquakes() async {
    try {
      setState(() {
        _isLoading = true;
      });

      final earthquakes = await _earthquakeService.getRecentEarthquakes(
        limit: 100, // Daha fazla çek, sonra filtrele
        minMagnitude: _minMagnitude,
        period: 'day',
        userLat: _userLat,
        userLon: _userLon,
      );

      // Magnitude range ve mesafeye göre filtrele
      final filtered = earthquakes.where((eq) {
        final mag = (eq['mag'] is int) 
            ? (eq['mag'] as int).toDouble() 
            : eq['mag'] as double;
        
        // Magnitude kontrolü
        if (mag < _minMagnitude || mag > _maxMagnitude) {
          return false;
        }

        // Mesafe kontrolü (eğer konum varsa)
        if (_userLat != null && _userLon != null) {
          final lat = (eq['lat'] is int) 
              ? (eq['lat'] as int).toDouble() 
              : eq['lat'] as double;
          final lon = (eq['lon'] is int) 
              ? (eq['lon'] as int).toDouble() 
              : eq['lon'] as double;
          
          final distance = _calculateDistance(
            _userLat!,
            _userLon!,
            lat,
            lon,
          );
          
          return distance <= _notificationRadius;
        }
        
        return true;
      }).take(30).toList();

      setState(() {
        _earthquakes = filtered;
        _isLoading = false;
      });

      print('✅ ${filtered.length} geçmiş deprem yüklendi (${_minMagnitude}-${_maxMagnitude} arası, ${_notificationRadius.toInt()} km içinde)');
    } catch (e) {
      print('❌ Geçmiş depremler yükleme hatası: $e');
      setState(() {
        _isLoading = false;
      });
    }
  }

  String _getTimeAgoText(int minutesAgo) {
    if (minutesAgo < 60) {
      return '$minutesAgo dk önce';
    } else if (minutesAgo < 1440) { // 24 saat = 1440 dakika
      final hours = (minutesAgo / 60).floor();
      return '$hours saat önce';
    } else {
      return '1 gün önce';
    }
  }

  List<Map<String, dynamic>> get _filteredEarthquakes {
    // Maksimum 30 deprem göster
    return _earthquakes.take(30).toList();
  }

  String _getIntensity(double magnitude) {
    if (magnitude >= 5.0) return 'Şiddetli';
    if (magnitude >= 4.0) return 'Belirgin';
    if (magnitude >= 3.0) return 'Hafif';
    return 'Çok Hafif';
  }

  Color _getMagnitudeColor(double magnitude) {
    if (magnitude >= 5.0) return Color(0xFFFF3333);
    if (magnitude >= 4.0) return Colors.deepOrange;
    if (magnitude >= 3.0) return Colors.orange;
    return Colors.green;
  }

  IconData _getMagnitudeIcon(double magnitude) {
    if (magnitude >= 5.0) return Icons.warning_rounded;
    if (magnitude >= 4.0) return Icons.error_outline;
    if (magnitude >= 3.0) return Icons.info_outline;
    return Icons.circle;
  }

  void _showEarthquakeDetail(Map<String, dynamic> earthquake) {
    final magnitude = (earthquake['mag'] is int) 
        ? (earthquake['mag'] as int).toDouble() 
        : earthquake['mag'] as double;
    final depth = (earthquake['depth'] is int)
        ? (earthquake['depth'] as int).toDouble()
        : earthquake['depth'] as double;
    final intensity = _getIntensity(magnitude);
    
    showModalBottomSheet(
      context: context,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) {
        return Container(
          padding: const EdgeInsets.all(24.0),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                'Deprem Detayları',
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                ),
              ),
              SizedBox(height: 24),
              
              // Büyüklük
              Row(
                children: [
                  Icon(
                    Icons.warning_rounded,
                    color: _getMagnitudeColor(magnitude),
                    size: 24,
                  ),
                  SizedBox(width: 12),
                  Text(
                    '${magnitude.toStringAsFixed(1)} Mw',
                    style: TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.bold,
                      color: Colors.black87,
                    ),
                  ),
                  SizedBox(width: 8),
                  Text(
                    intensity,
                    style: TextStyle(
                      fontSize: 14,
                      color: Colors.grey[600],
                    ),
                  ),
                ],
              ),
              SizedBox(height: 20),
              
              // Konum
              Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Icon(Icons.location_on, color: Color(0xFFFF3333), size: 24),
                  SizedBox(width: 12),
                  Expanded(
                    child: Text(
                      earthquake['place'] ?? 'Bilinmeyen Konum',
                      style: TextStyle(fontSize: 16, color: Colors.black87),
                    ),
                  ),
                ],
              ),
              SizedBox(height: 20),
              
              // Derinlik
              Row(
                children: [
                  Icon(Icons.layers, color: Color(0xFFFF3333), size: 24),
                  SizedBox(width: 12),
                  Text(
                    'Derinlik: ${depth.toStringAsFixed(1)} km',
                    style: TextStyle(fontSize: 16, color: Colors.black87),
                  ),
                ],
              ),
              SizedBox(height: 20),
              
              // Zaman
              Row(
                children: [
                  Icon(Icons.access_time, color: Color(0xFFFF3333), size: 24),
                  SizedBox(width: 12),
                  Text(
                    _getTimeAgoText(earthquake['minutesAgo'] as int),
                    style: TextStyle(fontSize: 16, color: Colors.black87),
                  ),
                ],
              ),
              SizedBox(height: 20),
              
              // Kaynak
              if (earthquake['source'] != null)
                Row(
                  children: [
                    Icon(Icons.source, color: Color(0xFFFF3333), size: 24),
                    SizedBox(width: 12),
                    Text(
                      'Kaynak: ${earthquake['source']}',
                      style: TextStyle(fontSize: 16, color: Colors.black87),
                    ),
                  ],
                ),
              SizedBox(height: 32),
              
              // Kapat Butonu
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  onPressed: () => Navigator.pop(ctx),
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Color(0xFFFF3333),
                    padding: EdgeInsets.symmetric(vertical: 14),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(30),
                    ),
                  ),
                  child: Text(
                    'Kapat',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                ),
              ),
            ],
          ),
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        // Filtre butonları ve ayarlar bilgisi
        Container(
          padding: EdgeInsets.symmetric(horizontal: 16, vertical: 12),
          decoration: BoxDecoration(
            color: Colors.white,
            boxShadow: [
              BoxShadow(
                color: Colors.black.withOpacity(0.05),
                blurRadius: 4,
                offset: Offset(0, 2),
              ),
            ],
          ),
          child: Column(
            children: [
              SizedBox(height: 8),
              // Magnitude range ve mesafe bilgisi
              Container(
                padding: EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                decoration: BoxDecoration(
                  color: Colors.grey[100],
                  borderRadius: BorderRadius.circular(8),
                ),
                child: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Icon(Icons.filter_alt, size: 14, color: Colors.grey[600]),
                    SizedBox(width: 6),
                    Text(
                      'Büyüklük: ${_minMagnitude.toStringAsFixed(1)}-${_maxMagnitude.toStringAsFixed(1)} | Mesafe: ${_notificationRadius.toInt()} km',
                      style: TextStyle(
                        fontSize: 12,
                        color: Colors.grey[700],
                        fontWeight: FontWeight.w500,
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
        
        // Deprem listesi
        Expanded(
          child: _isLoading
              ? Center(
                  child: CircularProgressIndicator(
                    color: Color(0xFFFF3333),
                  ),
                )
              : _filteredEarthquakes.isEmpty
                  ? Center(
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Icon(
                            Icons.inbox_outlined,
                            size: 64,
                            color: Colors.grey[400],
                          ),
                          SizedBox(height: 16),
                          Text(
                            'Deprem kaydı bulunamadı',
                            style: TextStyle(
                              fontSize: 16,
                              color: Colors.grey[600],
                            ),
                          ),
                          SizedBox(height: 16),
                          ElevatedButton.icon(
                            onPressed: _loadEarthquakes,
                            icon: Icon(Icons.refresh),
                            label: Text('Yenile'),
                            style: ElevatedButton.styleFrom(
                              backgroundColor: Color(0xFFFF3333),
                              foregroundColor: Colors.white,
                            ),
                          ),
                        ],
                      ),
                    )
                  : RefreshIndicator(
                      onRefresh: _loadEarthquakes,
                      color: Color(0xFFFF3333),
                      child: ListView.builder(
                        padding: EdgeInsets.all(16),
                        itemCount: _filteredEarthquakes.length,
                        itemBuilder: (context, index) {
                          final earthquake = _filteredEarthquakes[index];
                          return _buildEarthquakeCard(earthquake);
                        },
                      ),
                    ),
        ),
      ],
    );
  }

  Widget _buildFilterChip(String label) {
    final isSelected = _selectedFilter == label;
    return GestureDetector(
      onTap: () {
        setState(() {
          _selectedFilter = label;
        });
      },
      child: Container(
        padding: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
        decoration: BoxDecoration(
          color: isSelected ? Color(0xFFFF3333) : Colors.grey[200],
          borderRadius: BorderRadius.circular(20),
        ),
        child: Text(
          label,
          style: TextStyle(
            color: isSelected ? Colors.white : Colors.grey[700],
            fontWeight: isSelected ? FontWeight.w600 : FontWeight.normal,
            fontSize: 14,
          ),
        ),
      ),
    );
  }

  Widget _buildEarthquakeCard(Map<String, dynamic> earthquake) {
    final magnitude = (earthquake['mag'] is int) 
        ? (earthquake['mag'] as int).toDouble() 
        : earthquake['mag'] as double;
    final depth = (earthquake['depth'] is int)
        ? (earthquake['depth'] as int).toDouble()
        : earthquake['depth'] as double;
    final color = _getMagnitudeColor(magnitude);
    final minutesAgo = earthquake['minutesAgo'] as int;
    
    return Container(
      margin: EdgeInsets.only(bottom: 12),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: Colors.grey[200]!),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.05),
            blurRadius: 8,
            offset: Offset(0, 2),
          ),
        ],
      ),
      child: Material(
        color: Colors.transparent,
        child: InkWell(
          onTap: () => _showEarthquakeDetail(earthquake),
          borderRadius: BorderRadius.circular(16),
          child: Padding(
            padding: EdgeInsets.all(16),
            child: Row(
              children: [
                // Magnitude badge
                Container(
                  width: 60,
                  height: 60,
                  decoration: BoxDecoration(
                    color: color.withOpacity(0.1),
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Icon(
                        _getMagnitudeIcon(magnitude),
                        color: color,
                        size: 24,
                      ),
                      SizedBox(height: 4),
                      Text(
                        magnitude.toStringAsFixed(1),
                        style: TextStyle(
                          fontSize: 14,
                          fontWeight: FontWeight.bold,
                          color: color,
                        ),
                      ),
                    ],
                  ),
                ),
                SizedBox(width: 16),
                
                // Deprem bilgileri
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        earthquake['place'] ?? 'Bilinmeyen Konum',
                        style: TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.w600,
                          color: Colors.black87,
                        ),
                        maxLines: 2,
                        overflow: TextOverflow.ellipsis,
                      ),
                      SizedBox(height: 6),
                      Row(
                        children: [
                          Icon(
                            Icons.layers,
                            size: 14,
                            color: Colors.grey[600],
                          ),
                          SizedBox(width: 4),
                          Text(
                            '${depth.toStringAsFixed(1)} km',
                            style: TextStyle(
                              fontSize: 13,
                              color: Colors.grey[600],
                            ),
                          ),
                          SizedBox(width: 12),
                          Icon(
                            Icons.access_time,
                            size: 14,
                            color: Colors.grey[600],
                          ),
                          SizedBox(width: 4),
                          Text(
                            earthquake['time'] ?? '',
                            style: TextStyle(
                              fontSize: 13,
                              color: Colors.grey[600],
                            ),
                          ),
                        ],
                      ),
                      SizedBox(height: 4),
                      Row(
                        children: [
                          Text(
                            _getTimeAgoText(minutesAgo),
                            style: TextStyle(
                              fontSize: 12,
                              color: Colors.grey[500],
                            ),
                          ),
                          if (earthquake['source'] != null) ...[
                            SizedBox(width: 8),
                            Container(
                              padding: EdgeInsets.symmetric(horizontal: 6, vertical: 2),
                              decoration: BoxDecoration(
                                color: Colors.grey[200],
                                borderRadius: BorderRadius.circular(4),
                              ),
                              child: Text(
                                earthquake['source'],
                                style: TextStyle(
                                  fontSize: 10,
                                  color: Colors.grey[700],
                                  fontWeight: FontWeight.w600,
                                ),
                              ),
                            ),
                          ],
                        ],
                      ),
                    ],
                  ),
                ),
                
                // Chevron
                Icon(
                  Icons.chevron_right,
                  color: Colors.grey[400],
                  size: 24,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
