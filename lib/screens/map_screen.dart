import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:latlong2/latlong.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:location/location.dart';
import 'dart:math' show sin, cos, sqrt, atan2;
import '../services/auth_service.dart';
import '../services/friends_service_backend.dart';
import '../services/earthquake_service.dart';
import '../services/user_preferences_service.dart';

class MapScreen extends StatefulWidget {
  const MapScreen({Key? key}) : super(key: key);

  @override
  _MapScreenState createState() => _MapScreenState();
}

class _MapScreenState extends State<MapScreen> with TickerProviderStateMixin {
  late MapController _mapController;
  LatLng _userLocation = LatLng(39.0, 35.0); // Türkiye merkezi (başlangıç)
  bool _locationLoading = true;
  final Location _location = Location();
  bool _showLatestQuakePopup = true; // Popup görünürlük kontrolü
  Map<String, dynamic>? _latestQuake; // Son deprem bilgisi
  late AnimationController _waveController;
  late Animation<double> _waveAnimation;

  // Toggle states
  bool _showEarthquakes = true;
  bool _showFriends = true;
  bool _showAssemblyAreas = true;
  bool _showFaultLines = true;
  int _lastLoggedMarkerCount = -1; // Debug için marker sayısı takibi

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

  // Fay hatları - Dünya genelinde önemli aktif faylar (Global coverage)
  final List<Map<String, dynamic>> _faultLines = [
    // TÜRKİYE - KUZEY ANADOLU FAY HATTI (KAFH)
    {
      'name': 'KAFH',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(40.76, 26.55),
        LatLng(40.78, 27.20),
        LatLng(40.77, 27.85),
        LatLng(40.76, 28.35),
        LatLng(40.75, 28.85),
        LatLng(40.78, 29.35),
        LatLng(40.82, 29.95),
        LatLng(40.85, 30.45),
        LatLng(40.88, 30.95),
        LatLng(40.90, 31.45),
        LatLng(40.94, 32.85),
        LatLng(40.75, 34.95),
        LatLng(40.60, 36.35),
        LatLng(40.40, 37.95),
        LatLng(39.70, 41.05),
      ]
    },
    // TÜRKİYE - DOĞU ANADOLU FAY HATTI (DAFH)
    {
      'name': 'DAFH',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(39.70, 41.05),
        LatLng(38.68, 39.22),
        LatLng(38.05, 37.90),
        LatLng(37.55, 36.70),
        LatLng(36.85, 36.25),
        LatLng(36.50, 36.20),
      ]
    },
    // TÜRKİYE - EGE GRABENLERİ
    {
      'name': 'Gediz',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(38.72, 28.52),
        LatLng(38.66, 28.72),
        LatLng(38.48, 29.12)
      ]
    },
    {
      'name': 'Menderes',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(37.85, 27.85),
        LatLng(37.83, 28.35),
        LatLng(37.77, 29.08)
      ]
    },

    // AMERİKA - SAN ANDREAS FAULT
    {
      'name': 'San Andreas',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(33.0, -116.0),
        LatLng(34.0, -117.5),
        LatLng(35.0, -119.0),
        LatLng(36.0, -120.5),
        LatLng(36.5, -121.0),
        LatLng(37.0, -121.8),
        LatLng(37.7, -122.5),
        LatLng(38.4, -122.8),
      ]
    },
    {
      'name': 'Cascadia',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(40.5, -124.5),
        LatLng(42.0, -125.0),
        LatLng(44.0, -125.5),
        LatLng(46.0, -125.5),
        LatLng(48.0, -125.0),
        LatLng(49.0, -127.0),
      ]
    },

    // JAPONYA - RING OF FIRE
    {
      'name': 'Japan Trench',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(40.0, 143.0),
        LatLng(39.0, 143.5),
        LatLng(38.0, 143.8),
        LatLng(37.0, 144.0),
        LatLng(36.0, 144.0),
        LatLng(35.0, 141.5),
      ]
    },
    {
      'name': 'Nankai Trough',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(33.0, 135.0),
        LatLng(32.5, 136.5),
        LatLng(32.0, 138.0),
        LatLng(31.5, 139.5),
        LatLng(31.0, 141.0),
      ]
    },

    // ENDONEZYA - SUNDA MEGATHRUST
    {
      'name': 'Sunda Megathrust',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(-6.0, 105.0),
        LatLng(-5.0, 103.0),
        LatLng(-3.5, 100.5),
        LatLng(-2.0, 98.0),
        LatLng(-0.5, 96.0),
        LatLng(1.0, 94.5),
        LatLng(3.0, 93.5),
        LatLng(5.0, 92.5),
      ]
    },
    {
      'name': 'Sumatra',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(5.5, 95.5),
        LatLng(3.0, 97.0),
        LatLng(1.0, 98.5),
        LatLng(-1.0, 100.0),
        LatLng(-3.0, 101.5),
        LatLng(-5.0, 103.0),
      ]
    },

    // ŞİLİ - NAZCA PLATE
    {
      'name': 'Chile Trench',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(-18.0, -70.5),
        LatLng(-23.0, -70.2),
        LatLng(-28.0, -71.0),
        LatLng(-33.0, -71.5),
        LatLng(-38.0, -73.0),
        LatLng(-43.0, -74.0),
      ]
    },

    // MEKSİKA
    {
      'name': 'Mexico Subduction',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(16.0, -98.0),
        LatLng(17.0, -100.5),
        LatLng(18.0, -103.0),
        LatLng(19.0, -105.0),
        LatLng(20.0, -107.0),
      ]
    },

    // YENİ ZELANDA
    {
      'name': 'Alpine Fault',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(-46.0, 166.5),
        LatLng(-44.5, 168.0),
        LatLng(-43.0, 170.0),
        LatLng(-42.0, 172.0),
      ]
    },
    {
      'name': 'Hikurangi',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(-42.0, 174.0),
        LatLng(-40.5, 175.5),
        LatLng(-39.0, 177.0),
        LatLng(-37.5, 178.5),
      ]
    },

    // HİNDİSTAN - HİMALAYA
    {
      'name': 'Himalayan Thrust',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(28.0, 80.0),
        LatLng(28.5, 82.0),
        LatLng(29.0, 84.0),
        LatLng(29.5, 86.0),
        LatLng(28.5, 88.0),
        LatLng(27.5, 90.0),
      ]
    },

    // İRAN - ZAGROS
    {
      'name': 'Zagros Thrust',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(38.0, 45.0),
        LatLng(37.5, 47.0),
        LatLng(36.5, 49.0),
        LatLng(35.5, 51.0),
        LatLng(34.0, 53.0),
        LatLng(32.0, 55.0),
      ]
    },

    // İTALYA
    {
      'name': 'Apennine',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(43.5, 10.5),
        LatLng(43.0, 12.0),
        LatLng(42.5, 13.5),
        LatLng(41.5, 14.5),
        LatLng(40.5, 15.5),
      ]
    },

    // YUNANİSTAN
    {
      'name': 'Hellenic Arc',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(36.5, 21.0),
        LatLng(35.5, 23.0),
        LatLng(35.0, 25.0),
        LatLng(35.5, 27.0),
        LatLng(36.5, 28.5),
      ]
    },

    // FİLİPİNLER
    {
      'name': 'Philippine Fault',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(6.0, 126.0),
        LatLng(8.0, 124.5),
        LatLng(10.0, 123.5),
        LatLng(12.0, 123.0),
        LatLng(14.0, 122.0),
        LatLng(16.0, 121.0),
      ]
    },

    // PAPUA YENİ GİNE
    {
      'name': 'Papua Thrust',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(-5.0, 145.0),
        LatLng(-6.0, 147.0),
        LatLng(-7.0, 148.5),
        LatLng(-8.0, 150.0),
        LatLng(-9.0, 151.0),
      ]
    },

    // ALASKA
    {
      'name': 'Aleutian Trench',
      'color': Color(0xFFFF0000),
      'points': [
        LatLng(55.0, -160.0),
        LatLng(54.0, -165.0),
        LatLng(53.0, -170.0),
        LatLng(52.0, -175.0),
        LatLng(51.5, 180.0),
      ]
    },
  ];

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

    // Toggle durumlarını yükle
    _loadToggleStates();

    // Dalga animasyonu için
    _waveController = AnimationController(
      duration: const Duration(seconds: 2),
      vsync: this,
    )..repeat();

    _waveAnimation = Tween<double>(begin: 0.0, end: 1.0).animate(
      CurvedAnimation(parent: _waveController, curve: Curves.easeOut),
    );

    // Konum ve verileri yükle
    _initializeMapData();
  }

  Future<void> _initializeMapData() async {
    // 1. User data'yı yükle (Google Sign-In session)
    final authService = AuthService();
    await authService.loadUserData();
    print('✅ User session yüklendi');

    // 2. Kayıtlı konum var mı kontrol et (ÖNCE KONUM)
    await _loadOrFetchLocation();

    // 3. Konum alındıktan sonra haritayı konuma focus et
    if (mounted && !_locationLoading) {
      _mapController.move(_userLocation, 11.0);
      print(
          '🗺️  Harita odaklandı: ${_userLocation.latitude}, ${_userLocation.longitude}');
    }

    // 4. KONUM ALINDIKTAN SONRA ayarları yükle ve depremleri çek
    await _loadUserSettingsAndEarthquakes();

    // 5. Arkadaş listesini yükle
    if (mounted) {
      _loadFriends();
    }
  }

  // Kayıtlı konum varsa kullan, yoksa fetch et
  Future<void> _loadOrFetchLocation() async {
    try {
      final prefs = await SharedPreferences.getInstance();
      final savedLat = prefs.getDouble('cached_user_lat');
      final savedLon = prefs.getDouble('cached_user_lon');

      if (savedLat != null && savedLon != null) {
        // Kayıtlı konum kullan
        setState(() {
          _userLocation = LatLng(savedLat, savedLon);
          _locationLoading = false;
        });
        print('📍 Kayıtlı konum kullanıldı: $savedLat, $savedLon');
      } else {
        // İlk defa, konum çek
        await _getUserLocation();
        // Konumu kaydet
        if (_userLocation.latitude != 39.0) {
          await prefs.setDouble('cached_user_lat', _userLocation.latitude);
          await prefs.setDouble('cached_user_lon', _userLocation.longitude);
          print('💾 Konum kaydedildi');
        }
      }
    } catch (e) {
      print('❌ Konum yükleme hatası: $e');
      await _getUserLocation();
    }
  }

  Future<void> _getUserLocation() async {
    try {
      print('📍 Kullanıcı konumu alınıyor...');
      bool serviceEnabled = await _location.serviceEnabled();
      if (!serviceEnabled) {
        serviceEnabled = await _location.requestService();
        if (!serviceEnabled) {
          setState(() => _locationLoading = false);
          print('❌ Konum servisi kapalı');
          return;
        }
      }

      PermissionStatus permissionGranted = await _location.hasPermission();
      if (permissionGranted == PermissionStatus.denied) {
        permissionGranted = await _location.requestPermission();
        if (permissionGranted != PermissionStatus.granted) {
          setState(() => _locationLoading = false);
          return;
        }
      }

      final locationData = await _location.getLocation();
      if (locationData.latitude != null && locationData.longitude != null) {
        setState(() {
          _userLocation =
              LatLng(locationData.latitude!, locationData.longitude!);
          _locationLoading = false;
        });

        // SharedPreferences'a kaydet (History ekranı ile senkronize)
        final prefs = await SharedPreferences.getInstance();
        await prefs.setDouble('lastLatitude', locationData.latitude!);
        await prefs.setDouble('lastLongitude', locationData.longitude!);

        print(
            '✅ Kullanıcı konumu alındı ve kaydedildi: ${locationData.latitude}, ${locationData.longitude}');
      }
    } catch (e) {
      print('❌ Konum alma hatası: $e');
      setState(() => _locationLoading = false);
    }
  }

  Future<void> _loadToggleStates() async {
    final prefs = await SharedPreferences.getInstance();
    setState(() {
      _showEarthquakes = prefs.getBool('mapToggle_earthquakes') ?? true;
      _showFriends = prefs.getBool('mapToggle_friends') ?? true;
      _showAssemblyAreas = prefs.getBool('mapToggle_assembly') ?? true;
      _showFaultLines = prefs.getBool('mapToggle_faultLines') ?? true;
    });
  }

  Future<void> _saveToggleState(String key, bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool('mapToggle_$key', value);
  }

  Future<void> _loadUserSettingsAndEarthquakes() async {
    // Kullanıcı ayarlarını yükle
    final settings = await _prefsService.getAllSettings();
    setState(() {
      _minMagnitude = settings['minMagnitude'];
      _maxMagnitude = settings['maxMagnitude'];
      _notificationRadius = settings['notificationRadius'];
    });

    print(
        '⚙️  Ayarlar yüklendi - Radius: $_notificationRadius km, Magnitude: $_minMagnitude-$_maxMagnitude');

    // KONUM HAZIR, şimdi depremleri yükle
    await _loadEarthquakes();
  }

  Future<void> _loadEarthquakes() async {
    setState(() => _earthquakesLoading = true);

    try {
      print('\n🗺️ Map - Deprem verisi yükleniyor...');
      print(
          '   Kullanıcı konumu: ${_userLocation.latitude}, ${_userLocation.longitude}');
      print('   Range: $_notificationRadius km');
      print('   Magnitude: $_minMagnitude - $_maxMagnitude');

      // Kullanıcının gerçek konumunu kullan
      final earthquakes = await _earthquakeService.getRecentEarthquakes(
        limit: 100,
        minMagnitude: _minMagnitude,
        period: 'day',
        userLat: _userLocation.latitude,
        userLon: _userLocation.longitude,
        radius: 5000, // 5000 km yarıçap (global)
        region: 'Global', // Global depremler
      );

      print('   API\'den ${earthquakes.length} deprem çekildi');

      // Kullanıcının ayarlarına göre filtrele:
      // 1. Max magnitude
      // 2. 24 saat içinde
      // NOT: Range filtresi marker rendering'de uygulanıyor
      final filteredEarthquakes = earthquakes.where((eq) {
        final magnitude = (eq['mag'] is int)
            ? (eq['mag'] as int).toDouble()
            : eq['mag'] as double;

        // Magnitude kontrolü
        if (magnitude > _maxMagnitude) return false;

        // 24 saat (1440 dakika) kontrolü
        final minutesAgo = (eq['minutesAgo'] is int)
            ? eq['minutesAgo'] as int
            : (eq['minutesAgo'] as double).toInt();

        return minutesAgo <= 1440; // 24 saat = 1440 dakika
      }).toList();

      print(
          '   Magnitude/zaman filtresinden sonra: ${filteredEarthquakes.length} deprem');
      print('   (Range filtresi marker rendering\'de uygulanacak)\n');

      setState(() {
        _quakes = filteredEarthquakes;
        _earthquakesLoading = false;

        // EN YENİ depremi bul (minutesAgo en küçük olan)
        if (_quakes.isNotEmpty) {
          _latestQuake = _quakes.reduce((a, b) {
            final aMinutes = (a['minutesAgo'] is int)
                ? a['minutesAgo'] as int
                : (a['minutesAgo'] as double).toInt();
            final bMinutes = (b['minutesAgo'] is int)
                ? b['minutesAgo'] as int
                : (b['minutesAgo'] as double).toInt();
            return aMinutes < bMinutes ? a : b;
          });

          final latestMinutes = (_latestQuake!['minutesAgo'] is int)
              ? _latestQuake!['minutesAgo'] as int
              : (_latestQuake!['minutesAgo'] as double).toInt();
          print(
              '   📍 En yeni deprem: ${_latestQuake!['place']} - $latestMinutes dk önce');
        }
      });

      print('✅ Map - ${_quakes.length} deprem yüklendi');
    } catch (e) {
      print('❌ Deprem verisi yükleme hatası: $e');
      setState(() => _earthquakesLoading = false);
    }
  }

  Future<void> _loadFriends() async {
    try {
      print('👥 Arkadaş listesi yükleniyor...');
      final friends = await _friendsService.getFriends();
      print('✅ ${friends.length} arkadaş yüklendi');

      // Her arkadaşın konum bilgisini kontrol et
      int withLocation = 0;
      int withoutLocation = 0;
      for (var friend in friends) {
        final location = friend['location'];
        if (location != null &&
            location['latitude'] != null &&
            location['longitude'] != null) {
          print(
              '  📍 ${friend['displayName']}: ${location['latitude']}, ${location['longitude']}');
          withLocation++;
        } else {
          print('  ⚠️  ${friend['displayName']}: Konum bilgisi yok');
          withoutLocation++;
        }
      }

      print(
          '📊 Konum istatistikleri: $withLocation konumlu, $withoutLocation konumsuz');
      print('🗺️  Arkadaş toggle durumu: $_showFriends');

      if (mounted) {
        setState(() {
          _friends = friends;
        });
        print(
            '✅ Arkadaş listesi state güncellendi, marker sayısı: ${_friends.where((f) => f['location'] != null && f['location']['latitude'] != null).length}');
      }
    } catch (e) {
      print('❌ Arkadaş listesi yükleme hatası: $e');
      // Hata olursa boş liste bırak, uygulama çökmesin
      if (mounted) {
        setState(() {
          _friends = [];
        });
      }
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
    final time = q['time'] ?? '--:--';

    // Debug: Tüm deprem verisini logla
    print(
        '🔍 Deprem verisi: timestamp=${q['timestamp']}, date=${q['date']}, time=${q['time']}');

    // Tarih formatını düzelt
    String formattedDate = 'Tarih bilgisi yok';
    if (q['timestamp'] != null) {
      try {
        DateTime dt;
        // Timestamp int (milisaniye) veya string (ISO) olabilir
        if (q['timestamp'] is int) {
          dt = DateTime.fromMillisecondsSinceEpoch(q['timestamp']).toLocal();
        } else if (q['timestamp'] is String) {
          dt = DateTime.parse(q['timestamp']).toLocal();
        } else {
          throw Exception('Geçersiz timestamp tipi');
        }

        print('✅ Parse edilen tarih: ${dt.toString()}');

        final months = [
          'Ocak',
          'Şubat',
          'Mart',
          'Nisan',
          'Mayıs',
          'Haziran',
          'Temmuz',
          'Ağustos',
          'Eylül',
          'Ekim',
          'Kasım',
          'Aralık'
        ];
        final days = [
          'Pazartesi',
          'Salı',
          'Çarşamba',
          'Perşembe',
          'Cuma',
          'Cumartesi',
          'Pazar'
        ];
        formattedDate =
            '${dt.day} ${months[dt.month - 1]} ${days[dt.weekday - 1]} ${dt.year}';
        print('📅 Formatlanmış tarih: $formattedDate');
      } catch (e) {
        print(
            '❌ Tarih parse hatası: $e, timestamp: ${q['timestamp']}, type: ${q['timestamp'].runtimeType}');
        formattedDate = q['date'] ?? 'Tarih bilgisi yok';
      }
    } else if (q['date'] != null) {
      formattedDate = q['date'];
    }

    // Magnitude açıklaması
    String magDescription = '';
    if (mag < 2.0) {
      magDescription = 'Mikro deprem';
    } else if (mag < 3.0) {
      magDescription = 'Çok hafif';
    } else if (mag < 4.0) {
      magDescription = 'Hafif';
    } else if (mag < 5.0) {
      magDescription = 'Orta';
    } else if (mag < 6.0) {
      magDescription = 'Kuvvetli';
    } else if (mag < 7.0) {
      magDescription = 'Çok kuvvetli';
    } else {
      magDescription = 'Yıkıcı';
    }

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
                      '${mag.toStringAsFixed(1)} Mw',
                      style: TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                        color: Colors.black87,
                      ),
                    ),
                    SizedBox(width: 8),
                    Text(
                      magDescription,
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
                      formattedDate,
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

  void _zoomIn() {
    _mapController.move(_mapController.center, _mapController.zoom + 1);
  }

  void _zoomOut() {
    _mapController.move(_mapController.center, _mapController.zoom - 1);
  }

  void _focusUserLocation() {
    _mapController.move(_userLocation, 10.0);
  }

  // Haversine formülü ile iki nokta arasındaki mesafeyi hesapla (km)
  double _calculateDistance(
      double lat1, double lon1, double lat2, double lon2) {
    const double earthRadius = 6371; // km
    final double dLat = _toRadians(lat2 - lat1);
    final double dLon = _toRadians(lon2 - lon1);

    final double a = sin(dLat / 2) * sin(dLat / 2) +
        cos(_toRadians(lat1)) *
            cos(_toRadians(lat2)) *
            sin(dLon / 2) *
            sin(dLon / 2);

    final double c = 2 * atan2(sqrt(a), sqrt(1 - a));
    return earthRadius * c;
  }

  double _toRadians(double degrees) {
    return degrees * 3.141592653589793 / 180;
  }

  @override
  @override
  Widget build(BuildContext context) {
    // Marker rendering istatistikleri
    final earthquakesInRange = _quakes.where((q) {
      final lat =
          (q['lat'] is int) ? (q['lat'] as int).toDouble() : q['lat'] as double;
      final lon =
          (q['lon'] is int) ? (q['lon'] as int).toDouble() : q['lon'] as double;
      final distance = _calculateDistance(
          _userLocation.latitude, _userLocation.longitude, lat, lon);
      return distance <= _notificationRadius;
    }).length;

    if (earthquakesInRange != _lastLoggedMarkerCount) {
      print(
          '🗺️ Map Rendering: ${_quakes.length} toplam → $earthquakesInRange range içinde ($_showEarthquakes ? "GÖSTER" : "GİZLE")');
      _lastLoggedMarkerCount = earthquakesInRange;
    }

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
            // Fay hatları katmanı
            if (_showFaultLines)
              PolylineLayer(
                polylines: _faultLines.map((fault) {
                  return Polyline(
                    points: fault['points'] as List<LatLng>,
                    strokeWidth: 1.5,
                    color: (fault['color'] as Color).withOpacity(0.7),
                    borderStrokeWidth: 0.3,
                    borderColor: Colors.white.withOpacity(0.9),
                  );
                }).toList(),
              ),
            // Arkadaş marker'ları
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
                // Deprem marker'ları (range filtreli)
                if (_showEarthquakes)
                  ..._quakes.where((q) {
                    // Kullanıcının belirlediği range içinde mi kontrol et
                    final lat = (q['lat'] is int)
                        ? (q['lat'] as int).toDouble()
                        : q['lat'] as double;
                    final lon = (q['lon'] is int)
                        ? (q['lon'] as int).toDouble()
                        : q['lon'] as double;

                    // Kullanıcıya uzaklık hesapla (km)
                    final distance = _calculateDistance(
                      _userLocation.latitude,
                      _userLocation.longitude,
                      lat,
                      lon,
                    );

                    // NotificationRadius (km) içinde mi?
                    return distance <= _notificationRadius;
                  }).map((q) {
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
                                    _formatTimeAgo((q['minutesAgo'] is int)
                                        ? q['minutesAgo'] as int
                                        : (q['minutesAgo'] as double).toInt()),
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
                    _saveToggleState('earthquakes', value ?? false);
                  },
                ),
                _buildCheckboxItem(
                  icon: Icons.people,
                  label: 'Arkadaşlar',
                  isChecked: _showFriends,
                  color: Colors.purple,
                  onChanged: (value) {
                    setState(() => _showFriends = value ?? false);
                    _saveToggleState('friends', value ?? false);
                  },
                ),
                _buildCheckboxItem(
                  icon: Icons.group,
                  label: 'Toplanma',
                  isChecked: _showAssemblyAreas,
                  color: Colors.green,
                  onChanged: (value) {
                    setState(() => _showAssemblyAreas = value ?? false);
                    _saveToggleState('assembly', value ?? false);
                  },
                ),
                _buildCheckboxItem(
                  icon: Icons.format_line_spacing,
                  label: 'Fay Hatları',
                  isChecked: _showFaultLines,
                  color: Colors.red,
                  onChanged: (value) {
                    setState(() => _showFaultLines = value ?? false);
                    _saveToggleState('faultLines', value ?? false);
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
