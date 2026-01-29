import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:location/location.dart';
import '../services/earthquake_service.dart';
import '../services/user_preferences_service.dart';
import '../l10n/app_localizations.dart';
import 'dart:math' show sin, cos, sqrt, asin;
import 'earthquake_info_screen.dart';

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
    if (!mounted) return;
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
      print('📍 History - Gerçek GPS konumu alınıyor...');

      final location = Location();

      // Konum servisini kontrol et
      bool serviceEnabled = await location.serviceEnabled();
      if (!serviceEnabled) {
        serviceEnabled = await location.requestService();
        if (!serviceEnabled) {
          print('⚠️ History - Konum servisi kapalı, cache kullanılıyor');
          await _loadCachedLocation();
          return;
        }
      }

      // İzin kontrol et
      PermissionStatus permission = await location.hasPermission();
      if (permission == PermissionStatus.denied) {
        // İzin isteme işlemi PermissionService ile UI'dan yapılmalıdır
        print('❌ Konum izni yok. Lütfen uygulama ayarlarından izin verin.');
        return;
        if (permission != PermissionStatus.granted) {
          print('⚠️ History - Konum izni yok, cache kullanılıyor');
          await _loadCachedLocation();
          return;
        }
      }

      // Gerçek konumu al (Map ile aynı şekilde)
      final locationData = await location.getLocation();

      if (locationData.latitude != null && locationData.longitude != null) {
        if (!mounted) return;
        setState(() {
          _userLat = locationData.latitude;
          _userLon = locationData.longitude;
        });

        // Cache'e de kaydet
        final prefs = await SharedPreferences.getInstance();
        await prefs.setDouble('lastLatitude', _userLat!);
        await prefs.setDouble('lastLongitude', _userLon!);

        print('✅ History - GERÇEK GPS konumu alındı: $_userLat, $_userLon');
      } else {
        print('⚠️ History - Konum null, cache kullanılıyor');
        await _loadCachedLocation();
      }
    } catch (e) {
      print('❌ History - Konum hatası: $e, cache kullanılıyor');
      await _loadCachedLocation();
    }
  }

  /// Cache'den konum yükle (fallback)
  Future<void> _loadCachedLocation() async {
    final prefs = await SharedPreferences.getInstance();
    final lat = prefs.getDouble('lastLatitude');
    final lon = prefs.getDouble('lastLongitude');

    if (!mounted) return;
    if (lat != null && lon != null) {
      setState(() {
        _userLat = lat;
        _userLon = lon;
      });
      print('📦 History - Cache\'den konum yüklendi: $_userLat, $_userLon');
    } else {
      // Varsayılan: İstanbul merkezi (Türkiye merkezi DEĞİL!)
      setState(() {
        _userLat = 41.0082;
        _userLon = 28.9784;
      });
      print('⚠️ History - Hiç konum yok, İstanbul merkezi kullanılıyor');
    }
  }

  double _calculateDistance(
    double lat1,
    double lon1,
    double lat2,
    double lon2,
  ) {
    const R = 6371; // Dünya yarıçapı (km)
    final dLat = _toRadians(lat2 - lat1);
    final dLon = _toRadians(lon2 - lon1);
    final a = sin(dLat / 2) * sin(dLat / 2) +
        cos(_toRadians(lat1)) *
            cos(_toRadians(lat2)) *
            sin(dLon / 2) *
            sin(dLon / 2);
    final c = 2 * asin(sqrt(a));
    return R * c;
  }

  double _toRadians(double degree) {
    return degree * 3.14159265359 / 180;
  }

  Future<void> _loadEarthquakes() async {
    try {
      if (!mounted) return;
      setState(() {
        _isLoading = true;
      });

      final earthquakes = await _earthquakeService.getRecentEarthquakes(
        limit: 100,
        minMagnitude: _minMagnitude,
        period: 'day',
        userLat: _userLat,
        userLon: _userLon,
        radius: _notificationRadius, // ✅ API'ye radius gönder
      );

      // Magnitude range'e göre filtrele (API zaten mesafe filtrelemesi yaptı)
      print('\n📊 History - Filtreleme başlıyor:');
      print('   Toplam deprem: ${earthquakes.length}');
      print('   Kullanıcı konumu: $_userLat, $_userLon');
      print('   Range: $_notificationRadius km (API tarafından filtrelendi)');
      print('   Magnitude: $_minMagnitude - $_maxMagnitude');

      int magFiltered = 0;
      int passed = 0;

      // API zaten mesafe filtresi uyguladı (radius parametresi ile)
      // Burada sadece magnitude range kontrolü yapıyoruz
      final filtered = earthquakes.where((eq) {
        final mag = (eq['mag'] is int)
            ? (eq['mag'] as int).toDouble()
            : eq['mag'] as double;

        // Magnitude kontrolü
        if (mag < _minMagnitude || mag > _maxMagnitude) {
          magFiltered++;
          return false;
        }

        passed++;
        if (passed <= 5) {
          final distance = eq['distance'] ?? 0.0;
          print(
              '   ✅ Geçti: ${eq['place']} - ${distance.toStringAsFixed(1)} km (M${mag.toStringAsFixed(1)})');
        }
        return true;
      }).toList();

      // Zamana göre sırala - en yeni deprem en üstte
      filtered.sort((a, b) {
        try {
          final timeA = a['time'] as String? ?? '';
          final timeB = b['time'] as String? ?? '';

          // DateTime'a parse et
          DateTime? dateA = DateTime.tryParse(timeA);
          DateTime? dateB = DateTime.tryParse(timeB);

          // AFAD formatı (HH:mm) için bugünün tarihiyle birleştir
          if (dateA == null && timeA.contains(':') && !timeA.contains('T')) {
            try {
              final now = DateTime.now();
              final parts = timeA.split(':');
              if (parts.length >= 2) {
                final hour = int.tryParse(parts[0]);
                final minute = int.tryParse(parts[1]);
                if (hour != null && minute != null) {
                  dateA = DateTime(now.year, now.month, now.day, hour, minute);
                  // Eğer gelecek bir saat ise (gece yarısından sonra), dün olarak kabul et
                  if (dateA.isAfter(now)) {
                    dateA = dateA.subtract(Duration(days: 1));
                  }
                }
              }
            } catch (e) {
              // Parse hatasını yoksay
            }
          }

          if (dateB == null && timeB.contains(':') && !timeB.contains('T')) {
            try {
              final now = DateTime.now();
              final parts = timeB.split(':');
              if (parts.length >= 2) {
                final hour = int.tryParse(parts[0]);
                final minute = int.tryParse(parts[1]);
                if (hour != null && minute != null) {
                  dateB = DateTime(now.year, now.month, now.day, hour, minute);
                  // Eğer gelecek bir saat ise (gece yarısından sonra), dün olarak kabul et
                  if (dateB.isAfter(now)) {
                    dateB = dateB.subtract(Duration(days: 1));
                  }
                }
              }
            } catch (e) {
              // Parse hatasını yoksay
            }
          }

          // Eğer hala parse edilemezse string karşılaştır
          if (dateA == null || dateB == null) {
            return timeB.compareTo(timeA);
          }

          // DateTime'a göre sırala (en yeni önce)
          return dateB.compareTo(dateA);
        } catch (e) {
          print('⚠️ Zaman sıralama hatası: $e');
          return 0;
        }
      });

      // Debug: İlk 5 depremin zaman ve kaynak bilgisi
      print('\n🔍 İlk 5 deprem (sıralama sonrası):');
      for (int i = 0; i < (filtered.length > 5 ? 5 : filtered.length); i++) {
        final eq = filtered[i];
        final timeStr = eq['time'] as String? ?? '';
        final source = eq['source'] ?? 'UNKNOWN';
        final place = eq['place'] ?? 'Unknown';
        final parsedTime = DateTime.tryParse(timeStr);
        final now = DateTime.now();
        final diff = parsedTime != null ? now.difference(parsedTime) : null;
        print('   ${i + 1}. [$source] $place');
        print('      Time: $timeStr');
        print('      Parsed: $parsedTime');
        print(
            '      Ago: ${diff != null ? "${diff.inMinutes} dakika" : "PARSE ERROR"}');
      }

      // En fazla 30 deprem göster
      final limited = filtered.take(30).toList();

      print('\n📈 History - Filtreleme sonucu:');
      print('   Magnitude filtresi: $magFiltered elendi');
      print('   Mesafe filtresi: API tarafından uygulandı');
      print('   Geçen depremler: $passed');
      print('   Gösterilecek: ${limited.length}');
      print('   Geçenler: $passed');
      print('   Gösterilecek: ${limited.length}\n');

      if (!mounted) return;
      setState(() {
        _earthquakes = limited;
        _isLoading = false;
      });

      print(
        '✅ ${limited.length} geçmiş deprem yüklendi (${_minMagnitude}-${_maxMagnitude} arası, ${_notificationRadius.toInt()} km içinde), zamana göre sıralandı',
      );
    } catch (e) {
      print('❌ Geçmiş depremler yükleme hatası: $e');
      if (!mounted) return;
      setState(() {
        _isLoading = false;
      });
    }
  }

  String _getTimeAgoText(int minutesAgo, {BuildContext? ctx}) {
    final l10n = ctx != null ? AppLocalizations.of(ctx) : null;
    if (minutesAgo < 60) {
      return '$minutesAgo ${l10n?.get('min_ago') ?? 'min ago'}';
    } else if (minutesAgo < 1440) {
      // 24 saat = 1440 dakika
      final hours = (minutesAgo / 60).floor();
      return '$hours ${l10n?.get('hours_ago_short') ?? 'hours ago'}';
    } else {
      return l10n?.get('day_ago') ?? '1 day ago';
    }
  }

  String _formatTime(dynamic timeValue) {
    if (timeValue == null) return '';
    
    try {
      final String timeStr = timeValue.toString();
      
      // Eğer zaten saat formatındaysa (HH:mm), direkt döndür
      if (timeStr.contains(':') && !timeStr.contains('T')) {
        return timeStr;
      }
      
      // ISO formatı (2026-01-28T20:44:27.000Z) ise parse et
      if (timeStr.contains('T')) {
        final dateTime = DateTime.parse(timeStr);
        // Local timezone'a çevir ve sadece saat:dakika göster
        final localTime = dateTime.toLocal();
        final hour = localTime.hour.toString().padLeft(2, '0');
        final minute = localTime.minute.toString().padLeft(2, '0');
        return '$hour:$minute';
      }
      
      return timeStr;
    } catch (e) {
      return timeValue.toString();
    }
  }

  List<Map<String, dynamic>> get _filteredEarthquakes {
    // Maksimum 30 deprem göster
    return _earthquakes.take(30).toList();
  }

  String _getIntensity(double magnitude, {BuildContext? ctx}) {
    final l10n = ctx != null ? AppLocalizations.of(ctx) : null;
    if (magnitude >= 5.0) return l10n?.get('intensity_severe') ?? 'Severe';
    if (magnitude >= 4.0)
      return l10n?.get('intensity_noticeable') ?? 'Noticeable';
    if (magnitude >= 3.0) return l10n?.get('intensity_light') ?? 'Light';
    return l10n?.get('intensity_very_light') ?? 'Very Light';
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
        : (earthquake['depth'] as double?) ?? 10.0;
    final lat = (earthquake['lat'] is int)
        ? (earthquake['lat'] as int).toDouble()
        : (earthquake['lat'] as double?) ?? 0.0;
    final lon = (earthquake['lon'] is int)
        ? (earthquake['lon'] as int).toDouble()
        : (earthquake['lon'] as double?) ?? 0.0;

    // Mesafe hesapla
    double distance = 0.0;
    if (_userLat != null && _userLon != null) {
      distance = _calculateDistance(_userLat!, _userLon!, lat, lon);
    }

    // Zaman parse et
    DateTime timestamp;
    try {
      if (earthquake['timestamp'] is String) {
        timestamp = DateTime.parse(earthquake['timestamp']);
      } else if (earthquake['time'] is String) {
        timestamp = DateTime.parse(earthquake['time']);
      } else {
        timestamp = DateTime.now();
      }
    } catch (e) {
      timestamp = DateTime.now();
    }

    // EarthquakeInfoScreen'i aç (popup yerine tam ekran)
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => EarthquakeInfoScreen(
          magnitude: magnitude,
          location: earthquake['place'] ?? 'Unknown',
          distance: distance,
          timestamp: timestamp,
          source: earthquake['source'] ?? 'Unknown',
          epicenterLat: lat,
          epicenterLon: lon,
          depth: depth,
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context);
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
                      '${l10n?.get('magnitude_label') ?? 'Magnitude'}: ${_minMagnitude.toStringAsFixed(1)}-${_maxMagnitude.toStringAsFixed(1)} | ${l10n?.get('distance_label') ?? 'Distance'}: ${_notificationRadius.toInt()} km',
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
                  child: CircularProgressIndicator(color: Color(0xFFFF3333)),
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
                            l10n?.get('no_earthquake_records') ??
                                'No earthquake records found',
                            style: TextStyle(
                                fontSize: 16, color: Colors.grey[600]),
                          ),
                          SizedBox(height: 16),
                          ElevatedButton.icon(
                            onPressed: _loadEarthquakes,
                            icon: Icon(Icons.refresh),
                            label: Text(l10n?.get('refresh') ?? 'Refresh'),
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
                          Icon(Icons.layers, size: 14, color: Colors.grey[600]),
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
                            _formatTime(earthquake['time']),
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
                            _getTimeAgoText(minutesAgo, ctx: context),
                            style: TextStyle(
                              fontSize: 12,
                              color: Colors.grey[500],
                            ),
                          ),
                          if (earthquake['source'] != null) ...[
                            SizedBox(width: 8),
                            Container(
                              padding: EdgeInsets.symmetric(
                                horizontal: 6,
                                vertical: 2,
                              ),
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
                Icon(Icons.chevron_right, color: Colors.grey[400], size: 24),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
