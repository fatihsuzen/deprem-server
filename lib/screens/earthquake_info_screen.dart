import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../l10n/app_localizations.dart';

/// Bildirime tıklandığında gösterilen sakin deprem bilgi ekranı
/// Harita üzerinde deprem noktası ve kullanıcı konumu gösterir
class EarthquakeInfoScreen extends StatefulWidget {
  final double magnitude;
  final String location;
  final double distance;
  final DateTime timestamp;
  final String source;
  final double? epicenterLat;
  final double? epicenterLon;
  final double? depth;

  const EarthquakeInfoScreen({
    super.key,
    required this.magnitude,
    required this.location,
    required this.distance,
    required this.timestamp,
    this.source = 'AFAD',
    this.epicenterLat,
    this.epicenterLon,
    this.depth,
  });

  @override
  State<EarthquakeInfoScreen> createState() => _EarthquakeInfoScreenState();
}

class _EarthquakeInfoScreenState extends State<EarthquakeInfoScreen> {
  String _formatTime() {
    final diff = DateTime.now().toUtc().difference(widget.timestamp.toUtc());
    if (diff.isNegative || diff.inSeconds < 60) {
      return AppLocalizations(Locale(_currentLocale)).get('just_now');
    } else if (diff.inMinutes < 60) {
      final min = diff.inMinutes;
      return '$min ${AppLocalizations(Locale(_currentLocale)).get('minutes_ago')}';
    } else if (diff.inHours < 24) {
      final hours = diff.inHours;
      return '$hours ${AppLocalizations(Locale(_currentLocale)).get('hours_ago')}';
    } else {
      final days = diff.inDays;
      return '$days ${AppLocalizations(Locale(_currentLocale)).get('days_ago')}';
    }
  }

  // Son konumu SharedPreferences ile kaydet
  Future<void> saveLastLocation(double latitude, double longitude) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setDouble('last_latitude', latitude);
    await prefs.setDouble('last_longitude', longitude);
  }

  Future<void> _loadSettings() async {
    final prefs = await SharedPreferences.getInstance();
    if (mounted) {
      setState(() {
        _currentLocale = prefs.getString('app_locale') ?? 'tr';
        _isDarkTheme = prefs.getBool('dark_theme') ?? false;
      });
    }
  }

  late LatLng quakeLatLng;
  bool _isLocationReady = false;
  String _currentLocale = 'tr';
  bool _isDarkTheme = false;
  @override
  void initState() {
    super.initState();
    debugPrint('🔔 EarthquakeInfoScreen received:');
    debugPrint('   magnitude: ${widget.magnitude}');
    debugPrint('   location: ${widget.location}');
    debugPrint('   distance: ${widget.distance}');
    debugPrint('   epicenterLat: ${widget.epicenterLat}');
    debugPrint('   epicenterLon: ${widget.epicenterLon}');
    debugPrint('   source: ${widget.source}');
    debugPrint(
        '   depth: ${widget.depth} (${widget.depth == null ? "NULL" : widget.depth! > 0 ? "VALID" : "ZERO OR NEGATIVE"})');
    _loadSettings();
    _initializeLocation();
  }

  Future<void> _initializeLocation() async {
    double? quakeLat;
    double? quakeLon;
    bool validLocation = false;
    debugPrint('🟡 _initializeLocation ÇAĞRILDI');
    debugPrint('  widget.epicenterLat: ${widget.epicenterLat}');
    debugPrint('  widget.epicenterLon: ${widget.epicenterLon}');
    debugPrint('  widget.location: ${widget.location}');
    if (widget.epicenterLat != null &&
        widget.epicenterLon != null &&
        !widget.epicenterLat!.isNaN &&
        !widget.epicenterLon!.isNaN) {
      quakeLat = widget.epicenterLat!;
      quakeLon = widget.epicenterLon!;
      validLocation = true;
      debugPrint(
          '✅ epicenterLat/Lon parametreleri kullanıldı: lat=$quakeLat, lon=$quakeLon');
      await saveLastLocation(quakeLat, quakeLon);
    }
    if (!validLocation) {
      final locParts = widget.location.split(',');
      debugPrint('🔵 location string split: $locParts');
      if (locParts.length == 2) {
        try {
          final lat = double.parse(locParts[0].trim());
          final lon = double.parse(locParts[1].trim());
          debugPrint('🔵 location string parse edildi: lat=$lat, lon=$lon');
          if (!lat.isNaN && !lon.isNaN) {
            quakeLat = lat;
            quakeLon = lon;
            validLocation = true;
            debugPrint(
                '✅ location string koordinat olarak kullanıldı: lat=$quakeLat, lon=$quakeLon');
            await saveLastLocation(lat, lon);
          }
        } catch (e) {
          debugPrint('❌ location string parse hatası: $e');
        }
      } else {
        debugPrint(
            '❌ location string koordinat formatında değil: ${widget.location}');
      }
    }
    if (validLocation && quakeLat != null && quakeLon != null) {
      quakeLatLng = LatLng(quakeLat, quakeLon);
      debugPrint('🟢 quakeLatLng set: $quakeLatLng');
      if (mounted) {
        setState(() {
          _isLocationReady = true;
        });
      }
    } else {
      debugPrint('🔴 Konum bulunamadı, harita gösterilmeyecek');
      if (mounted) {
        setState(() {
          _isLocationReady = false;
        });
      }
    }
  }

  Color _getMagnitudeColor() {
    if (widget.magnitude >= 6.0) return Colors.red.shade700;
    if (widget.magnitude >= 5.0) return Colors.deepOrange;
    if (widget.magnitude >= 4.0) return Colors.orange;
    if (widget.magnitude >= 3.0) return Colors.amber;
    return Colors.green;
  }

  String _getMagnitudeDescription(AppLocalizations? l10n) {
    if (widget.magnitude >= 7.0)
      return l10n?.get('mag_destructive') ?? 'Yıkıcı';
    if (widget.magnitude >= 6.0)
      return l10n?.get('mag_very_strong') ?? 'Çok Kuvvetli';
    if (widget.magnitude >= 5.0) return l10n?.get('mag_strong') ?? 'Kuvvetli';
    if (widget.magnitude >= 4.0) return l10n?.get('mag_medium') ?? 'Orta';
    if (widget.magnitude >= 3.0) return l10n?.get('mag_light') ?? 'Hafif';
    if (widget.magnitude >= 2.0)
      return l10n?.get('mag_very_light') ?? 'Çok Hafif';
    return l10n?.get('mag_micro') ?? 'Mikro';
  }

  String _getDistanceText() {
    final dist = widget.distance;
    if (dist < 1) {
      return '${(dist * 1000).toStringAsFixed(0)} m';
    }
    return '${dist.toStringAsFixed(1)} km';
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations(Locale(_currentLocale));
    final magnitudeColor = _getMagnitudeColor();
    final screenHeight = MediaQuery.of(context).size.height;
    final screenWidth = MediaQuery.of(context).size.width;
    // Responsive oranlar
    double rFont(double size) =>
        size * (screenWidth / 360.0); // 360 referans alınarak
    double rHeight(double size) =>
        size * (screenHeight / 720.0); // 720 referans alınarak
    double rWidth(double size) => size * (screenWidth / 360.0);
    debugPrint(
        '🟣 build() çağrıldı, _isLocationReady=$_isLocationReady, quakeLatLng=$quakeLatLng');

    // Konum bulunamadıysa kullanıcıya mesaj göster
    if (!_isLocationReady) {
      return Scaffold(
        backgroundColor: _isDarkTheme ? Colors.grey[900] : Colors.grey[100],
        appBar: AppBar(
          title: Text(l10n.get('earthquake_info')),
          backgroundColor: magnitudeColor,
          foregroundColor: Colors.white,
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Icon(Icons.error_outline, color: Colors.red, size: rFont(48)),
              SizedBox(height: rHeight(16)),
              Text(
                l10n.get('location_not_found') ??
                    'Deprem merkezi konumu bulunamadı',
                style: TextStyle(
                  fontSize: rFont(18),
                  color: _isDarkTheme ? Colors.white : Colors.black87,
                  fontWeight: FontWeight.w500,
                ),
                textAlign: TextAlign.center,
              ),
            ],
          ),
        ),
      );
    }

    return PopScope(
      canPop: false,
      onPopInvokedWithResult: (_, __) => Navigator.of(context).pushNamedAndRemoveUntil('/home', (route) => false),
      child: Scaffold(
      backgroundColor: _isDarkTheme ? Colors.grey[900] : Colors.grey[100],
      appBar: AppBar(
        title: Text(l10n.get('earthquake_info')),
        backgroundColor: magnitudeColor,
        foregroundColor: Colors.white,
        elevation: 0,
        leading: IconButton(
          icon: const Icon(Icons.close),
          onPressed: () => Navigator.of(context).pushNamedAndRemoveUntil('/home', (route) => false),
        ),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            // Üst bilgi kartı
            Container(
              width: double.infinity,
              padding: EdgeInsets.all(rWidth(20)),
              decoration: BoxDecoration(
                color: magnitudeColor,
                borderRadius: const BorderRadius.only(
                  bottomLeft: Radius.circular(30),
                  bottomRight: Radius.circular(30),
                ),
              ),
              child: Column(
                children: [
                  // Büyüklük
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.end,
                    children: [
                      Text(
                        'M',
                        style: TextStyle(
                          fontSize: rFont(28),
                          fontWeight: FontWeight.w300,
                          color: Colors.white.withOpacity(0.9),
                        ),
                      ),
                      Text(
                        widget.magnitude.toStringAsFixed(1),
                        style: TextStyle(
                          fontSize: rFont(64),
                          fontWeight: FontWeight.bold,
                          color: Colors.white,
                        ),
                      ),
                    ],
                  ),
                  SizedBox(height: rHeight(8)),
                  // Büyüklük açıklaması
                  Container(
                    padding:
                        const EdgeInsets.symmetric(horizontal: 16, vertical: 6),
                    decoration: BoxDecoration(
                      color: Colors.white.withOpacity(0.2),
                      borderRadius: BorderRadius.circular(20),
                    ),
                    child: Text(
                      _getMagnitudeDescription(l10n),
                      style: TextStyle(
                        fontSize: rFont(16),
                        fontWeight: FontWeight.w500,
                        color: Colors.white,
                      ),
                    ),
                  ),
                  SizedBox(height: rHeight(16)),
                  // Zaman ve kaynak
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      // Geri sayım/zaman kaldırıldı
                      // Icon(Icons.access_time,
                      //     color: Colors.white.withOpacity(0.8),
                      //     size: rFont(18)),
                      // SizedBox(width: rWidth(6)),
                      // Text(
                      //   _formatTime(),
                      //   style: TextStyle(
                      //     fontSize: rFont(14),
                      //     color: Colors.white.withOpacity(0.9),
                      //   ),
                      // ),
                      // SizedBox(width: rWidth(16)),
                      Icon(Icons.source,
                          color: Colors.white.withOpacity(0.8),
                          size: rFont(18)),
                      SizedBox(width: rWidth(6)),
                      Text(
                        widget.source.toUpperCase(),
                        style: TextStyle(
                          fontSize: rFont(14),
                          color: Colors.white.withOpacity(0.9),
                          fontWeight: FontWeight.w500,
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),

            const SizedBox(height: 16),

            // Harita
            Container(
              margin: const EdgeInsets.symmetric(horizontal: 16),
              height: screenHeight *
                  0.35, // Harita oranı sabit kalabilir, istenirse rHeight ile değiştirilebilir
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(20),
                boxShadow: [
                  BoxShadow(
                    color: Colors.black.withOpacity(0.1),
                    blurRadius: 10,
                    offset: const Offset(0, 4),
                  ),
                ],
              ),
              child: ClipRRect(
                borderRadius: BorderRadius.circular(20),
                child: FlutterMap(
                  options: MapOptions(
                    initialCenter: quakeLatLng,
                    initialZoom: 7.0,
                  ),
                  children: [
                    TileLayer(
                      urlTemplate: _isDarkTheme
                          ? 'https://{s}.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}{r}.png'
                          : 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
                      subdomains: const ['a', 'b', 'c'],
                      userAgentPackageName: 'dev.deprem_bildirim',
                    ),
                    // Sadece deprem merkezi marker'ı
                    MarkerLayer(
                      markers: [
                        // Deprem merkezi
                        Marker(
                          point: quakeLatLng,
                          width: 60,
                          height: 60,
                          child: Container(
                            decoration: BoxDecoration(
                              shape: BoxShape.circle,
                              color: magnitudeColor,
                              border: Border.all(color: Colors.white, width: 3),
                              boxShadow: [
                                BoxShadow(
                                  color: magnitudeColor.withOpacity(0.5),
                                  blurRadius: 15,
                                  spreadRadius: 5,
                                ),
                              ],
                            ),
                            child: const Icon(
                              Icons.location_on,
                              color: Colors.white,
                              size: 32,
                            ),
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            ),

            const SizedBox(height: 16),

            // Detay bilgileri
            Container(
              margin: const EdgeInsets.symmetric(horizontal: 16),
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: _isDarkTheme ? Colors.grey[850] : Colors.white,
                borderRadius: BorderRadius.circular(16),
                boxShadow: [
                  BoxShadow(
                    color: Colors.black.withOpacity(0.05),
                    blurRadius: 10,
                    offset: const Offset(0, 2),
                  ),
                ],
              ),
              child: Column(
                children: [
                  // Mesafe
                  _buildInfoRow(
                    icon: Icons.straighten,
                    iconColor: Colors.blue,
                    label: l10n.get('distance'),
                    value: _getDistanceText(),
                  ),
                  Divider(color: Colors.grey.withOpacity(0.2)),
                  // Konum
                  _buildInfoRow(
                    icon: Icons.place,
                    iconColor: magnitudeColor,
                    label: l10n.get('location'),
                    value: widget.location.length > 30
                        ? '${widget.location.substring(0, 30)}...'
                        : widget.location,
                  ),
                  Divider(color: Colors.grey.withOpacity(0.2)),
                  // Derinlik
                  if (widget.depth != null && widget.depth != 0)
                    _buildInfoRow(
                      icon: Icons.arrow_downward,
                      iconColor: Colors.orange,
                      label: l10n.get('depth'),
                      value: '${widget.depth!.abs().toStringAsFixed(1)} km',
                    ),
                  if (widget.depth != null && widget.depth != 0)
                    Divider(color: Colors.grey.withOpacity(0.2)),
                  // Koordinatlar
                  _buildInfoRow(
                    icon: Icons.my_location,
                    iconColor: Colors.green,
                    label: l10n.get('coordinates'),
                    value:
                        '${quakeLatLng.latitude.toStringAsFixed(4)}, ${quakeLatLng.longitude.toStringAsFixed(4)}',
                  ),
                ],
              ),
            ),

            const SizedBox(height: 16),

            // Lejant - Sadece deprem noktası
            Container(
              margin: const EdgeInsets.symmetric(horizontal: 16),
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: _isDarkTheme ? Colors.grey[850] : Colors.white,
                borderRadius: BorderRadius.circular(12),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  // Deprem noktası lejantı
                  Row(
                    children: [
                      Container(
                        width: 24,
                        height: 24,
                        decoration: BoxDecoration(
                          shape: BoxShape.circle,
                          color: magnitudeColor,
                          border: Border.all(color: Colors.white, width: 2),
                        ),
                        child: const Icon(Icons.location_on,
                            color: Colors.white, size: 14),
                      ),
                      const SizedBox(width: 8),
                      Text(
                        l10n.get('epicenter'),
                        style: TextStyle(
                          fontSize: 12,
                          color:
                              _isDarkTheme ? Colors.white70 : Colors.grey[700],
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),

            const SizedBox(height: 48),

            // Kapat butonu
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 16),
              child: SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  onPressed: () {
                    // Deprem parametrelerini native tarafta temizle
                    const MethodChannel paramsChannel =
                        MethodChannel('deprem_app/earthquake_params');
                    paramsChannel.invokeMethod('clearEarthquakeParams');
                    Navigator.of(context).pushNamedAndRemoveUntil('/home', (route) => false);
                  },
                  style: ElevatedButton.styleFrom(
                    backgroundColor: magnitudeColor,
                    foregroundColor: Colors.white,
                    padding: const EdgeInsets.symmetric(vertical: 16),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(12),
                    ),
                  ),
                  child: Text(
                    l10n.get('close'),
                    style: const TextStyle(
                      fontSize: 16,
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                ),
              ),
            ),
            const SizedBox(height: 16),

            const SizedBox(height: 24),
          ],
        ),
      ),
    ),
    );
  }

  Widget _buildInfoRow({
    required IconData icon,
    required Color iconColor,
    required String label,
    required String value,
  }) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8),
      child: Row(
        children: [
          Container(
            padding: const EdgeInsets.all(8),
            decoration: BoxDecoration(
              color: iconColor.withOpacity(0.1),
              borderRadius: BorderRadius.circular(8),
            ),
            child: Icon(icon, color: iconColor, size: 20),
          ),
          const SizedBox(width: 12),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  label,
                  style: TextStyle(
                    fontSize: 12,
                    color: _isDarkTheme ? Colors.white54 : Colors.grey[600],
                  ),
                ),
                const SizedBox(height: 2),
                Text(
                  value,
                  style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.w500,
                    color: _isDarkTheme ? Colors.white : Colors.black87,
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
