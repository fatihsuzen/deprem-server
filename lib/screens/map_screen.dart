import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:latlong2/latlong.dart';
import '../services/friends_service_backend.dart';
import '../services/earthquake_service.dart';
import '../services/user_preferences_service.dart';

class MapScreen extends StatefulWidget {
  @override
  _MapScreenState createState() => _MapScreenState();
}

class _MapScreenState extends State<MapScreen> with TickerProviderStateMixin {
  late MapController _mapController;
  final LatLng _userLocation =
      LatLng(41.0308, 28.5742); // İstanbul Büyükçekmece
  bool _showLatestQuakePopup = true; // Popup görünürlük kontrolü
  Map<String, dynamic>? _latestQuake; // Son deprem bilgisi
  late AnimationController _waveController;
  late Animation<double> _waveAnimation;

  // Toggle states
  bool _showEarthquakes = true;
  bool _showFriends = true;
  bool _showAssemblyAreas = true;

  // Friends data
  List<Map<String, dynamic>> _friends = [];

  // Earthquake data
  List<Map<String, dynamic>> _quakes = [];
  bool _earthquakesLoading = true;

  final FriendsService _friendsService = FriendsService();
  final EarthquakeService _earthquakeService = EarthquakeService();
  final UserPreferencesService _prefsService = UserPreferencesService();

  // Kullanıcı filtreleme ayarları
  double _minMagnitude = UserPreferencesService.defaultMinMagnitude;
  double _maxMagnitude = UserPreferencesService.defaultMaxMagnitude;
  double _notificationRadius = UserPreferencesService.defaultNotificationRadius;

  // Assembly areas (toplanma alanları) - örnek data
  final List<Map<String, dynamic>> _assemblyAreas = [
    {
      "lat": 41.0350,
      "lon": 28.5800,
      "name": "Büyükçekmece Sahil Parkı",
      "capacity": 5000,
      "type": "park",
    },
    {
      "lat": 41.0280,
      "lon": 28.5650,
      "name": "Belediye Meydanı",
      "capacity": 3000,
      "type": "meydan",
    },
    {
      "lat": 40.9200,
      "lon": 29.2100,
      "name": "Silivri Spor Tesisleri",
      "capacity": 8000,
      "type": "spor",
    },
  ];

  @override
  void initState() {
    super.initState();
    _mapController = MapController();

    // Kullanıcı ayarlarını yükle ve depremleri getir
    _loadUserSettingsAndEarthquakes();

    // Dalga animasyonu için
    _waveController = AnimationController(
      duration: const Duration(seconds: 2),
      vsync: this,
    )..repeat();

    _waveAnimation = Tween<double>(begin: 0.0, end: 1.0).animate(
      CurvedAnimation(parent: _waveController, curve: Curves.easeOut),
    );

    // Arkadaş listesini yükle
    _loadFriends();
  }

  Future<void> _loadUserSettingsAndEarthquakes() async {
    // Kullanıcı ayarlarını yükle
    final settings = await _prefsService.getAllSettings();
    setState(() {
      _minMagnitude = settings['minMagnitude'];
      _maxMagnitude = settings['maxMagnitude'];
      _notificationRadius = settings['notificationRadius'];
    });

    // Ayarlara göre depremleri yükle
    await _loadEarthquakes();
  }

  Future<void> _loadEarthquakes() async {
    setState(() => _earthquakesLoading = true);

    try {
      final earthquakes = await _earthquakeService.getRecentEarthquakes(
        limit: 100,
        minMagnitude: _minMagnitude,
        period: 'day',
        userLat: _userLocation.latitude,
        userLon: _userLocation.longitude,
        radius: 5000, // 5000 km yarıçap (global)
      );

      // Kullanıcının max magnitude ayarına göre filtrele
      final filteredEarthquakes = earthquakes.where((eq) {
        final magnitude = (eq['mag'] is int) 
            ? (eq['mag'] as int).toDouble() 
            : eq['mag'] as double;
        return magnitude <= _maxMagnitude;
      }).toList();

      setState(() {
        _quakes = filteredEarthquakes;
        _earthquakesLoading = false;

        // İlk depremi son deprem olarak kaydet (konum bazlı sıralandı)
        if (_quakes.isNotEmpty) {
          _latestQuake = _quakes[0];
        }
      });

      print(
          '✅ ${_quakes.length} deprem verisi yüklendi (${_minMagnitude.toStringAsFixed(1)}-${_maxMagnitude.toStringAsFixed(1)} aralığında)');
    } catch (e) {
      print('❌ Deprem verisi yükleme hatası: $e');
      setState(() => _earthquakesLoading = false);
    }
  }

  Future<void> _loadFriends() async {
    try {
      final friends = await _friendsService.getFriends();
      setState(() {
        _friends = friends;
      });
    } catch (e) {
      print('❌ Arkadaş listesi yükleme hatası: $e');
    }
  }

  @override
  void dispose() {
    _waveController.dispose();
    super.dispose();
  }

  String _formatTimeAgo(int minutes) {
    if (minutes < 1) return '< 1dk';
    if (minutes < 60) return '${minutes}dk';

    int hours = minutes ~/ 60;
    if (hours < 24) return '${hours}s';

    int days = hours ~/ 24;
    return '${days}g';
  }

  Color _colorForMag(double m) {
    if (m >= 4.5) return Colors.red;
    if (m >= 4.0) return Colors.deepOrange;
    if (m >= 3.0) return Colors.orange;
    return Colors.green;
  }

  void _showFriendInfo(Map<String, dynamic> friend) {
    final location = friend['location'];
    final isOnline = friend['isOnline'] ?? false;

    showModalBottomSheet(
      context: context,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) {
        return Padding(
          padding: const EdgeInsets.all(24),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              CircleAvatar(
                radius: 40,
                backgroundColor: Colors.purple,
                child: Text(
                  (friend['displayName'] ?? 'U')[0].toUpperCase(),
                  style: const TextStyle(
                    color: Colors.white,
                    fontSize: 32,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ),
              const SizedBox(height: 16),
              Text(
                friend['displayName'] ?? 'Bilinmeyen',
                style:
                    const TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 8),
              Container(
                padding:
                    const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                decoration: BoxDecoration(
                  color: isOnline
                      ? Colors.green.withOpacity(0.1)
                      : Colors.grey.withOpacity(0.1),
                  borderRadius: BorderRadius.circular(20),
                  border: Border.all(
                    color: isOnline ? Colors.green : Colors.grey,
                  ),
                ),
                child: Text(
                  isOnline ? 'Çevrimiçi' : 'Çevrimdışı',
                  style: TextStyle(
                    fontSize: 14,
                    color: isOnline ? Colors.green : Colors.grey,
                    fontWeight: FontWeight.w600,
                  ),
                ),
              ),
              if (location != null && location['address'] != null) ...[
                const SizedBox(height: 16),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    const Icon(Icons.location_on, size: 18, color: Colors.grey),
                    const SizedBox(width: 6),
                    Expanded(
                      child: Text(
                        location['address'],
                        textAlign: TextAlign.center,
                        style: const TextStyle(color: Colors.grey),
                      ),
                    ),
                  ],
                ),
              ],
              const SizedBox(height: 24),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  onPressed: () => Navigator.pop(ctx),
                  style: ElevatedButton.styleFrom(
                    backgroundColor: const Color(0xFFFF3A3D),
                    padding: const EdgeInsets.symmetric(vertical: 14),
                  ),
                  child: const Text('Kapat'),
                ),
              ),
            ],
          ),
        );
      },
    );
  }

  void _showAssemblyAreaInfo(Map<String, dynamic> area) {
    showModalBottomSheet(
      context: context,
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      builder: (ctx) {
        return Padding(
          padding: const EdgeInsets.all(24),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Row(
                children: [
                  Container(
                    width: 50,
                    height: 50,
                    decoration: BoxDecoration(
                      color: Colors.green,
                      borderRadius: BorderRadius.circular(12),
                    ),
                    child:
                        const Icon(Icons.group, color: Colors.white, size: 28),
                  ),
                  const SizedBox(width: 16),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        const Text(
                          'Toplanma Alanı',
                          style: TextStyle(fontSize: 14, color: Colors.grey),
                        ),
                        const SizedBox(height: 4),
                        Text(
                          area['name'] ?? 'Bilinmeyen Alan',
                          style: const TextStyle(
                              fontSize: 18, fontWeight: FontWeight.bold),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 24),
              _buildInfoRow(
                  Icons.people, 'Kapasite', '${area['capacity']} kişi'),
              const SizedBox(height: 12),
              _buildInfoRow(Icons.category, 'Tür',
                  area['type']?.toString().toUpperCase() ?? 'GENEL'),
              const SizedBox(height: 24),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  onPressed: () => Navigator.pop(ctx),
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.green,
                    padding: const EdgeInsets.symmetric(vertical: 14),
                  ),
                  child: const Text('Kapat'),
                ),
              ),
            ],
          ),
        );
      },
    );
  }

  Widget _buildInfoRow(IconData icon, String label, String value) {
    return Row(
      children: [
        Icon(icon, color: Colors.grey[600], size: 20),
        const SizedBox(width: 12),
        Text(
          '$label: ',
          style: TextStyle(color: Colors.grey[600], fontSize: 14),
        ),
        Text(
          value,
          style: const TextStyle(fontWeight: FontWeight.w600, fontSize: 14),
        ),
      ],
    );
  }

  Widget _buildCheckboxItem({
    required IconData icon,
    required String label,
    required bool isChecked,
    required Color color,
    required ValueChanged<bool?> onChanged,
  }) {
    return InkWell(
      onTap: () => onChanged(!isChecked),
      child: Padding(
        padding: const EdgeInsets.symmetric(vertical: 2),
        child: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            SizedBox(
              width: 18,
              height: 18,
              child: Checkbox(
                value: isChecked,
                onChanged: onChanged,
                activeColor: color,
                materialTapTargetSize: MaterialTapTargetSize.shrinkWrap,
                visualDensity: VisualDensity.compact,
              ),
            ),
            const SizedBox(width: 6),
            Icon(
              icon,
              color: color,
              size: 16,
            ),
            const SizedBox(width: 4),
            Text(
              label,
              style: TextStyle(
                color: Colors.black87,
                fontSize: 12,
                fontWeight: FontWeight.w500,
              ),
            ),
          ],
        ),
      ),
    );
  }

  void _onTapMarker(Map<String, dynamic> q) {
    final mag = (q['mag'] as num).toDouble();
    final place = q['place'] ?? 'Konum';
    final date = q['date'] ?? 'Tarih bilgisi yok';
    final time = q['time'] ?? '--:--';

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
                // Başlık
                Text(
                  'Deprem Bilgisi',
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
                      color: Color(0xFFFF3333),
                      size: 24,
                    ),
                    SizedBox(width: 12),
                    Text(
                      '$mag-${(mag + 0.5).toStringAsFixed(1)} Mw',
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.black87,
                      ),
                    ),
                    SizedBox(width: 8),
                    Text(
                      'Hafif sarsıntı',
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
                    Icon(
                      Icons.location_on,
                      color: Color(0xFFFF3333),
                      size: 24,
                    ),
                    SizedBox(width: 12),
                    Expanded(
                      child: Text(
                        place,
                        style: TextStyle(
                          fontSize: 16,
                          color: Colors.black87,
                        ),
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 20),

                // Tarih
                Row(
                  children: [
                    Icon(
                      Icons.calendar_today,
                      color: Color(0xFFFF3333),
                      size: 24,
                    ),
                    SizedBox(width: 12),
                    Text(
                      date,
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.black87,
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 20),

                // Saat
                Row(
                  children: [
                    Icon(
                      Icons.access_time,
                      color: Color(0xFFFF3333),
                      size: 24,
                    ),
                    SizedBox(width: 12),
                    Text(
                      time,
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.black87,
                      ),
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
        });
  }

  void _showEarthquakeReportSheet() {
    showModalBottomSheet(
      context: context,
      isScrollControlled: true,
      builder: (ctx) {
        return EarthquakeReportSheet();
      },
    );
  }

  void _zoomIn() {
    _mapController.move(_mapController.center, _mapController.zoom + 1);
  }

  void _zoomOut() {
    _mapController.move(_mapController.center, _mapController.zoom - 1);
  }

  void _focusUserLocation() {
    _mapController.move(_userLocation, 10.0);
  }

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: [
        FlutterMap(
          mapController: _mapController,
          options: MapOptions(center: _userLocation, zoom: 6.0),
          children: [
            TileLayer(
              urlTemplate: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
              subdomains: ['a', 'b', 'c'],
              userAgentPackageName: 'dev.deprem_bildirim',
            ),
            // Arkadaş marker'ları (en altta)
            if (_showFriends)
              MarkerLayer(
                markers: _friends.where((friend) {
                  final location = friend['location'];
                  return location != null &&
                      location['latitude'] != null &&
                      location['longitude'] != null;
                }).map((friend) {
                  final location = friend['location'];
                  final lat = (location['latitude'] is int)
                      ? (location['latitude'] as int).toDouble()
                      : location['latitude'] as double;
                  final lon = (location['longitude'] is int)
                      ? (location['longitude'] as int).toDouble()
                      : location['longitude'] as double;
                  final isOnline = friend['isOnline'] ?? false;

                  return Marker(
                    point: LatLng(lat, lon),
                    width: 45,
                    height: 45,
                    alignment: Alignment.center,
                    child: GestureDetector(
                      onTap: () => _showFriendInfo(friend),
                      child: Container(
                        decoration: BoxDecoration(
                          shape: BoxShape.circle,
                          color: Colors.purple,
                          border: Border.all(
                            color: isOnline ? Colors.green : Colors.grey,
                            width: 3,
                          ),
                          boxShadow: [
                            BoxShadow(color: Colors.black26, blurRadius: 4)
                          ],
                        ),
                        child: Center(
                          child: Text(
                            (friend['displayName'] ?? 'U')[0].toUpperCase(),
                            style: const TextStyle(
                              color: Colors.white,
                              fontSize: 18,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                        ),
                      ),
                    ),
                  );
                }).toList(),
              ),
            // Toplanma alanı marker'ları
            if (_showAssemblyAreas)
              MarkerLayer(
                markers: _assemblyAreas.map((area) {
                  final lat = (area['lat'] is int)
                      ? (area['lat'] as int).toDouble()
                      : area['lat'] as double;
                  final lon = (area['lon'] is int)
                      ? (area['lon'] as int).toDouble()
                      : area['lon'] as double;

                  return Marker(
                    point: LatLng(lat, lon),
                    width: 40,
                    height: 40,
                    alignment: Alignment.center,
                    child: GestureDetector(
                      onTap: () => _showAssemblyAreaInfo(area),
                      child: Container(
                        decoration: BoxDecoration(
                          shape: BoxShape.circle,
                          color: Colors.green,
                          boxShadow: [
                            BoxShadow(color: Colors.black26, blurRadius: 4)
                          ],
                        ),
                        child: const Center(
                          child: Icon(
                            Icons.group,
                            color: Colors.white,
                            size: 22,
                          ),
                        ),
                      ),
                    ),
                  );
                }).toList(),
              ),
            // Kullanıcı ve deprem marker'ları (en üstte - popup için)
            MarkerLayer(
              markers: [
                Marker(
                  point: _userLocation,
                  width: 35,
                  height: 35,
                  alignment: Alignment.center,
                  child: Container(
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      color: Colors.blue,
                      boxShadow: [
                        BoxShadow(color: Colors.black26, blurRadius: 4)
                      ],
                    ),
                    child: Center(
                      child: SvgPicture.asset(
                        'assets/Icons/user-stroke-rounded.svg',
                        width: 18.0,
                        height: 18.0,
                        colorFilter:
                            ColorFilter.mode(Colors.white, BlendMode.srcIn),
                      ),
                    ),
                  ),
                ),
                // Deprem marker'ları
                if (_showEarthquakes)
                  ..._quakes.asMap().entries.map((entry) {
                    final q = entry.value;
                    final lat = (q['lat'] is int) 
                        ? (q['lat'] as int).toDouble() 
                        : q['lat'] as double;
                    final lon = (q['lon'] is int) 
                        ? (q['lon'] as int).toDouble() 
                        : q['lon'] as double;
                    final mag = (q['mag'] as num).toDouble();
                    final color = _colorForMag(mag);

                    return Marker(
                      point: LatLng(lat, lon),
                      width: 100,
                      height: 110,
                      alignment: Alignment.center,
                      child: Stack(
                        clipBehavior: Clip.none,
                        alignment: Alignment.bottomCenter,
                        children: [
                          // Ana marker container (icon + wave + time label)
                          Positioned(
                            bottom: 0,
                            child: Column(
                              mainAxisSize: MainAxisSize.min,
                              children: [
                                // Dalga animasyonu + Deprem marker
                                SizedBox(
                                  width: 70,
                                  height: 70,
                                  child: Stack(
                                    alignment: Alignment.center,
                                    children: [
                                      // Dalga animasyonu (TÜM DEPREMLER için)
                                      AnimatedBuilder(
                                        animation: _waveAnimation,
                                        builder: (context, child) {
                                          return Container(
                                            width: 40 +
                                                (_waveAnimation.value * 30),
                                            height: 40 +
                                                (_waveAnimation.value * 30),
                                            decoration: BoxDecoration(
                                              shape: BoxShape.circle,
                                              border: Border.all(
                                                color: color.withOpacity(0.6 -
                                                    (_waveAnimation.value *
                                                        0.6)),
                                                width: 2,
                                              ),
                                            ),
                                          );
                                        },
                                      ),
                                      // Deprem marker icon (SABİT)
                                      GestureDetector(
                                        onTap: () => _onTapMarker(q),
                                        child: Container(
                                          width: 40,
                                          height: 40,
                                          decoration: BoxDecoration(
                                            shape: BoxShape.circle,
                                            color: color,
                                            boxShadow: [
                                              BoxShadow(
                                                  color: Colors.black26,
                                                  blurRadius: 4)
                                            ],
                                          ),
                                          child: Center(
                                            child: SvgPicture.asset(
                                              'assets/Icons/Logo.svg',
                                              width: 20,
                                              height: 20,
                                              colorFilter: ColorFilter.mode(
                                                  Colors.white,
                                                  BlendMode.srcIn),
                                            ),
                                          ),
                                        ),
                                      ),
                                    ],
                                  ),
                                ),
                                // Zaman gösterimi (marker'ın altında)
                                Container(
                                  padding: EdgeInsets.symmetric(
                                      horizontal: 6, vertical: 2),
                                  decoration: BoxDecoration(
                                    color: Colors.black.withOpacity(0.7),
                                    borderRadius: BorderRadius.circular(8),
                                  ),
                                  child: Text(
                                    _formatTimeAgo(q['minutesAgo'] as int),
                                    style: TextStyle(
                                      color: Colors.white,
                                      fontSize: 10,
                                      fontWeight: FontWeight.bold,
                                    ),
                                  ),
                                ),
                              ],
                            ),
                          ),
                        ],
                      ),
                    );
                  }).toList(),
              ],
            )
          ],
        ),
        // Son deprem popup'ı (haritanın üzerinde, merkeze yakın)
        if (_showLatestQuakePopup && _latestQuake != null)
          Positioned(
            top: MediaQuery.of(context).size.height * 0.25,
            left: (MediaQuery.of(context).size.width - 200) / 2,
            child: GestureDetector(
              onTap: () {
                print('🔴 Popup kapatma butonuna tıklandı');
                setState(() {
                  _showLatestQuakePopup = false;
                });
              },
              child: Container(
                width: 200,
                padding: EdgeInsets.fromLTRB(14, 10, 14, 14),
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(8),
                  boxShadow: [
                    BoxShadow(
                      color: Colors.black.withOpacity(0.3),
                      blurRadius: 8,
                      offset: Offset(0, 2),
                    ),
                  ],
                ),
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Text(
                          'Son Deprem',
                          style: TextStyle(
                            fontSize: 10,
                            fontWeight: FontWeight.w600,
                            color: Colors.grey[600],
                          ),
                        ),
                        Icon(
                          Icons.close,
                          size: 16,
                          color: Colors.grey[600],
                        ),
                      ],
                    ),
                    SizedBox(height: 8),
                    Row(
                      children: [
                        Text(
                          '${_latestQuake!['mag']} Mw',
                          style: TextStyle(
                            fontSize: 14,
                            fontWeight: FontWeight.bold,
                            color: _colorForMag(
                                (_latestQuake!['mag'] as num).toDouble()),
                          ),
                        ),
                        SizedBox(width: 8),
                        Expanded(
                          child: Text(
                            _latestQuake!['place'],
                            style: TextStyle(
                              fontSize: 11,
                              color: Colors.black87,
                              fontWeight: FontWeight.w500,
                            ),
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          ),
                        ),
                      ],
                    ),
                    SizedBox(height: 6),
                    Text(
                      '${_latestQuake!['minutesAgo']} dk önce',
                      style: TextStyle(
                        fontSize: 10,
                        color: Colors.grey[600],
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),
        // Checkbox listesi (sol üst köşe)
        Positioned(
          top: 12,
          left: 12,
          child: Container(
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(8),
              boxShadow: [
                BoxShadow(
                  color: Colors.black26,
                  blurRadius: 4,
                  offset: Offset(0, 2),
                ),
              ],
            ),
            padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                _buildCheckboxItem(
                  icon: Icons.warning,
                  label: 'Depremler',
                  isChecked: _showEarthquakes,
                  color: Colors.red,
                  onChanged: (value) {
                    setState(() => _showEarthquakes = value ?? false);
                  },
                ),
                _buildCheckboxItem(
                  icon: Icons.people,
                  label: 'Arkadaşlar',
                  isChecked: _showFriends,
                  color: Colors.purple,
                  onChanged: (value) {
                    setState(() => _showFriends = value ?? false);
                  },
                ),
                _buildCheckboxItem(
                  icon: Icons.group,
                  label: 'Toplanma',
                  isChecked: _showAssemblyAreas,
                  color: Colors.green,
                  onChanged: (value) {
                    setState(() => _showAssemblyAreas = value ?? false);
                  },
                ),
              ],
            ),
          ),
        ),
        Positioned(
          top: 12,
          right: 12,
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              FloatingActionButton(
                heroTag: 'zoom_in_btn',
                mini: true,
                onPressed: _zoomIn,
                backgroundColor: Colors.white,
                child: Icon(Icons.add, color: Color(0xFFFF3333)),
              ),
              SizedBox(height: 8),
              FloatingActionButton(
                heroTag: 'zoom_out_btn',
                mini: true,
                onPressed: _zoomOut,
                backgroundColor: Colors.white,
                child: Icon(Icons.remove, color: Color(0xFFFF3333)),
              ),
              SizedBox(height: 8),
              FloatingActionButton(
                heroTag: 'my_location_btn',
                mini: true,
                onPressed: _focusUserLocation,
                backgroundColor: Colors.white,
                child: Icon(Icons.my_location, color: Color(0xFFFF3333)),
              ),
            ],
          ),
        ),
        Align(
          alignment: Alignment(0, 0.88),
          child: ElevatedButton(
            onPressed: _showEarthquakeReportSheet,
            style: ElevatedButton.styleFrom(
              backgroundColor: Color(0xFFFF3333),
              foregroundColor: Colors.white,
              minimumSize: Size(250, 54),
              shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(999)),
            ),
            child: Text('Deprem Bildir',
                style: TextStyle(
                    color: Colors.white, fontWeight: FontWeight.w600)),
          ),
        )
      ],
    );
  }
}

class EarthquakeReportSheet extends StatefulWidget {
  @override
  _EarthquakeReportSheetState createState() => _EarthquakeReportSheetState();
}

class _EarthquakeReportSheetState extends State<EarthquakeReportSheet> {
  String _selectedCity = '';
  double _selectedMagnitude = 1.0;
  String _searchCity = '';
  bool _showCityList = false;

  final List<String> _cities = [
    'Adana',
    'Adıyaman',
    'Afyonkarahisar',
    'Ağrı',
    'Aksaray',
    'Amasya',
    'Ankara',
    'Antalya',
    'Ardahan',
    'Artvin',
    'Aydın',
    'Balıkesir',
    'Bartın',
    'Batman',
    'Bayburt',
    'Bingöl',
    'Bitlis',
    'Bolu',
    'Burdur',
    'Bursa',
    'Çanakkale',
    'Çankırı',
    'Çorum',
    'Denizli',
    'Diyarbakır',
    'Düzce',
    'Edirne',
    'Elazığ',
    'Erzincan',
    'Erzurum',
    'Eskişehir',
    'Gaziantep',
    'Giresun',
    'Gümüşhane',
    'Hakkari',
    'Hatay',
    'Iğdır',
    'Isparta',
    'İstanbul',
    'İzmir',
    'Kahraman Maraş',
    'Karabük',
    'Karaman',
    'Kars',
    'Kastamonu',
    'Kayseri',
    'Kırıkkale',
    'Kırklareli',
    'Kırşehir',
    'Kilis',
    'Kocaeli',
    'Konya',
    'Kütahya',
    'Malatya',
    'Manisa',
    'Mardin',
    'Muğla',
    'Muş',
    'Nevşehir',
    'Niğde',
    'Ordu',
    'Rize',
    'Sakarya',
    'Samsun',
    'Şanlıurfa',
    'Şırnak',
    'Siirt',
    'Sinop',
    'Sivas',
    'Tekirdağ',
    'Tokat',
    'Trabzon',
    'Uşak',
    'Van',
    'Yalova',
    'Yozgat',
    'Zonguldak',
  ];

  final List<Map<String, String>> magnitudes = [
    {'min': '1.0', 'max': '2.0', 'desc': 'Hissiyatı çok düşük.'},
    {'min': '2.0', 'max': '3.0', 'desc': 'Çok hafif sarsıntı hissi.'},
    {'min': '3.0', 'max': '4.0', 'desc': 'Hafif sarsıntı'},
    {'min': '4.0', 'max': '5.0', 'desc': 'Belirgin sarsıntı'},
    {'min': '5.0', 'max': '6.0', 'desc': 'Şiddetli sarsıntı'},
    {'min': '6.0', 'max': '7.0', 'desc': 'Çok şiddetli sarsıntı'},
    {'min': '7.0', 'max': '8.0', 'desc': 'Yıkıcı deprem'},
    {'min': '8.0', 'max': '9.0', 'desc': 'Büyük felaket'},
  ];

  List<String> get _filteredCities {
    if (_searchCity.isEmpty) return _cities;
    return _cities
        .where((city) => city.toLowerCase().contains(_searchCity.toLowerCase()))
        .toList();
  }

  @override
  Widget build(BuildContext context) {
    final screenHeight = MediaQuery.of(context).size.height;

    return Container(
      height: screenHeight * 0.7,
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      child: Column(
        children: [
          // Header section
          Padding(
            padding: EdgeInsets.fromLTRB(16, 16, 16, 16),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text('Deprem Bildir',
                    style:
                        TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
                SizedBox(height: 20),
                Text('Hangi İldesin',
                    style: TextStyle(
                        fontSize: 14,
                        fontWeight: FontWeight.w600,
                        color: Colors.black)),
                SizedBox(height: 8),
                _buildCitySearchField(),
              ],
            ),
          ),
          // Conditional content: City list OR Magnitude options
          Expanded(
            child: _showCityList
                ? _buildExpandedCityList()
                : _buildMagnitudeSection(),
          ),
          Container(
            padding: EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: Colors.white,
              boxShadow: [
                BoxShadow(
                  color: Colors.black.withOpacity(0.05),
                  blurRadius: 10,
                  offset: Offset(0, -5),
                ),
              ],
            ),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                SizedBox(
                  width: double.infinity,
                  child: ElevatedButton(
                    onPressed: () {
                      if (_selectedCity.isEmpty) {
                        ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(content: Text('Lütfen bir şehir seçiniz')),
                        );
                        return;
                      }
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                            content: Text(
                                '$_selectedCity bölgesinde deprem bildirildi!')),
                      );
                      Navigator.pop(context);
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Color(0xFFFF3333),
                      padding: EdgeInsets.symmetric(vertical: 14),
                      shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(30)),
                    ),
                    child: Text('Bildir',
                        style: TextStyle(
                            color: Colors.white,
                            fontSize: 16,
                            fontWeight: FontWeight.w600)),
                  ),
                ),
                SizedBox(height: 12),
                SizedBox(
                  width: double.infinity,
                  child: OutlinedButton(
                    onPressed: () => Navigator.pop(context),
                    style: OutlinedButton.styleFrom(
                      padding: EdgeInsets.symmetric(vertical: 14),
                      shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(30)),
                    ),
                    child: Text('Vazgeç',
                        style: TextStyle(color: Colors.black, fontSize: 16)),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildCitySearchField() {
    return Column(
      children: [
        TextField(
          decoration: InputDecoration(
            hintText: 'Şehir arayınız...',
            prefixIcon: Icon(Icons.search, color: Colors.grey),
            suffixIcon: _searchCity.isNotEmpty || _showCityList
                ? GestureDetector(
                    onTap: () => setState(() {
                      _searchCity = '';
                      _showCityList = false;
                    }),
                    child: Icon(Icons.clear, color: Colors.grey),
                  )
                : null,
            border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
            contentPadding: EdgeInsets.symmetric(horizontal: 12, vertical: 12),
          ),
          onTap: () => setState(() => _showCityList = true),
          onChanged: (val) => setState(() => _searchCity = val),
        ),
        if (_selectedCity.isNotEmpty && !_showCityList)
          Padding(
            padding: const EdgeInsets.only(top: 8.0),
            child: Container(
              width: double.infinity,
              padding: EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Colors.red.shade50,
                border: Border.all(color: Color(0xFFFF3333)),
                borderRadius: BorderRadius.circular(8),
              ),
              child: Row(
                children: [
                  Icon(Icons.check_circle, color: Color(0xFFFF3333), size: 20),
                  SizedBox(width: 8),
                  Text('Seçili: $_selectedCity',
                      style: TextStyle(
                          fontWeight: FontWeight.w600,
                          color: Color(0xFFFF3333))),
                ],
              ),
            ),
          ),
      ],
    );
  }

  Widget _buildExpandedCityList() {
    return Container(
      padding: EdgeInsets.symmetric(horizontal: 16),
      child: _filteredCities.isEmpty
          ? Center(
              child: Text('Sonuç bulunamadı',
                  style: TextStyle(color: Colors.grey)),
            )
          : ListView.builder(
              itemCount: _filteredCities.length,
              itemBuilder: (ctx, idx) {
                return ListTile(
                  title: Text(_filteredCities[idx]),
                  onTap: () {
                    setState(() {
                      _selectedCity = _filteredCities[idx];
                      _searchCity = '';
                      _showCityList = false;
                    });
                  },
                  selected: _selectedCity == _filteredCities[idx],
                  selectedTileColor: Colors.red.shade50,
                );
              },
            ),
    );
  }

  Widget _buildMagnitudeSection() {
    return SingleChildScrollView(
      padding: EdgeInsets.fromLTRB(16, 0, 16, 16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('Tahmini Büyüklük',
              style: TextStyle(fontSize: 14, fontWeight: FontWeight.w600)),
          SizedBox(height: 12),
          ..._buildMagnitudeOptions(),
          SizedBox(height: 16),
        ],
      ),
    );
  }

  List<Widget> _buildMagnitudeOptions() {
    return magnitudes.asMap().entries.map((entry) {
      Map<String, String> mag = entry.value;
      double magValue = double.parse(mag['min']!);
      bool isSelected = _selectedMagnitude == magValue;

      return Padding(
        padding: const EdgeInsets.only(bottom: 10.0),
        child: Container(
          decoration: BoxDecoration(
            border: Border.all(
              color: isSelected ? Color(0xFFFF3333) : Colors.grey.shade300,
              width: isSelected ? 2 : 1,
            ),
            borderRadius: BorderRadius.circular(12),
          ),
          padding: EdgeInsets.all(12),
          child: Row(
            children: [
              Radio<double>(
                value: magValue,
                groupValue: _selectedMagnitude,
                activeColor: Color(0xFFFF3333),
                onChanged: (val) {
                  setState(() => _selectedMagnitude = val ?? 1.0);
                },
              ),
              SizedBox(width: 8),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('${mag['min']}-${mag['max']} Mw',
                        style: TextStyle(
                            fontWeight: FontWeight.w600,
                            color:
                                isSelected ? Color(0xFFFF3333) : Colors.black)),
                    Text(mag['desc']!,
                        style: TextStyle(fontSize: 12, color: Colors.grey)),
                  ],
                ),
              ),
            ],
          ),
        ),
      );
    }).toList();
  }
}
