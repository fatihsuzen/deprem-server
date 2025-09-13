import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../services/location_service.dart';

class MapScreen extends StatefulWidget {
  const MapScreen({super.key});

  @override
  State<MapScreen> createState() => _MapScreenState();
}

class _MapScreenState extends State<MapScreen> with TickerProviderStateMixin {
  final MapController _mapController = MapController();
  final LocationService _locationService = LocationService();

  List<Map<String, dynamic>> _friendsLocations = [];
  List<Map<String, dynamic>> _earthquakes = [];
  bool _isLoading = true;
  LatLng? _userLocation;
  bool _isDarkMapTheme = false;

  // Animation controllers for earthquake ripple effects
  late List<AnimationController> _animationControllers;
  late List<Animation<double>> _animations;

  @override
  void initState() {
    super.initState();
    _initializeAnimations();
    _loadMapTheme();
    _initializeMap();
  }

  Future<void> _loadMapTheme() async {
    final prefs = await SharedPreferences.getInstance();
    setState(() {
      _isDarkMapTheme = prefs.getBool('isDarkMapTheme') ?? false;
    });
  }

  void _initializeAnimations() {
    // Initialize animation controllers for earthquakes
    _animationControllers = [];
    _animations = [];
  }

  Future<void> _initializeMap() async {
    setState(() => _isLoading = true);

    try {
      // Kullanıcının konumunu al
      if (_locationService.latitude != null &&
          _locationService.longitude != null) {
        _userLocation =
            LatLng(_locationService.latitude!, _locationService.longitude!);
      }

      // Arkadaş konumlarını al
      _friendsLocations = await _locationService.getFormattedFriendsForMap();

      // Son depremleri al - Basit veri kullan
      _earthquakes = [
        {
          'magnitude': 4.2,
          'latitude': 40.0,
          'longitude': 28.0,
          'location': 'İstanbul',
          'time': DateTime.now().subtract(Duration(hours: 2)).toString(),
          'depth': 15,
        },
        {
          'magnitude': 3.8,
          'latitude': 39.9,
          'longitude': 32.8,
          'location': 'Ankara',
          'time': DateTime.now().subtract(Duration(hours: 5)).toString(),
          'depth': 12,
        },
      ];

      // Create animations for each earthquake
      _setupEarthquakeAnimations();

      print(
          '📍 Harita yüklendi: ${_friendsLocations.length} arkadaş, ${_earthquakes.length} deprem');
    } catch (e) {
      print('❌ Harita yükleme hatası: $e');
    } finally {
      setState(() => _isLoading = false);
    }
  }

  void _setupEarthquakeAnimations() {
    // Dispose existing controllers
    for (var controller in _animationControllers) {
      controller.dispose();
    }
    _animationControllers.clear();
    _animations.clear();

    print('📍 Setting up animations for ${_earthquakes.length} earthquakes');

    // Create new controllers for each earthquake
    for (int i = 0; i < _earthquakes.length; i++) {
      final controller = AnimationController(
        duration: Duration(seconds: 2),
        vsync: this,
      );

      final animation = Tween<double>(
        begin: 0.0,
        end: 1.0,
      ).animate(CurvedAnimation(
        parent: controller,
        curve: Curves.easeOut,
      ));

      _animationControllers.add(controller);
      _animations.add(animation);

      print(
          '📍 Animation ${i} created for earthquake ${_earthquakes[i]['magnitude']}');

      // Start animation with delay
      Future.delayed(Duration(milliseconds: i * 500), () {
        if (mounted && controller.isCompleted == false) {
          controller.repeat();
          print('📍 Animation ${i} started');
        }
      });
    }
  }

  @override
  void dispose() {
    for (var controller in _animationControllers) {
      controller.dispose();
    }
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Harita'),
        backgroundColor: Colors.blue.shade700,
        foregroundColor: Colors.white,
        actions: [
          IconButton(
            icon: const Icon(Icons.refresh),
            onPressed: _initializeMap,
          ),
        ],
      ),
      body: _isLoading
          ? const Center(child: CircularProgressIndicator())
          : Stack(
              children: [
                FlutterMap(
                  mapController: _mapController,
                  options: MapOptions(
                    initialCenter:
                        _userLocation ?? LatLng(39.9334, 32.8597), // Ankara
                    initialZoom: _userLocation != null ? 13.0 : 6.0,
                    minZoom: 5.0,
                    maxZoom: 18.0,
                    interactionOptions: InteractionOptions(
                      flags: InteractiveFlag.all,
                    ),
                  ),
                  children: [
                    // Tile Layer - Theme based
                    TileLayer(
                      urlTemplate: _isDarkMapTheme
                          ? 'https://server.arcgisonline.com/ArcGIS/rest/services/Canvas/World_Dark_Gray_Base/MapServer/tile/{z}/{y}/{x}'
                          : 'https://server.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer/tile/{z}/{y}/{x}',
                      userAgentPackageName: 'com.example.deprem_app',
                    ),

                    // Kullanıcının konumu
                    if (_userLocation != null)
                      MarkerLayer(
                        markers: [
                          Marker(
                            point: _userLocation!,
                            width: 60,
                            height: 60,
                            alignment: Alignment.center,
                            child: Container(
                              decoration: BoxDecoration(
                                color: Colors.blue,
                                shape: BoxShape.circle,
                                border:
                                    Border.all(color: Colors.white, width: 3),
                                boxShadow: [
                                  BoxShadow(
                                    color: Colors.black26,
                                    blurRadius: 4,
                                    offset: Offset(0, 2),
                                  ),
                                ],
                              ),
                              child: const Icon(
                                Icons.person,
                                color: Colors.white,
                                size: 30,
                              ),
                            ),
                          ),
                        ],
                      ),

                    // Arkadaş konumları
                    if (_friendsLocations.isNotEmpty)
                      MarkerLayer(
                        markers: _friendsLocations.map((friend) {
                          return Marker(
                            point:
                                LatLng(friend['latitude'], friend['longitude']),
                            width: 80,
                            height: 100,
                            alignment: Alignment.bottomCenter,
                            child: GestureDetector(
                              onTap: () => _showFriendInfo(friend),
                              child: Column(
                                mainAxisSize: MainAxisSize.min,
                                children: [
                                  // Zaman bilgisi
                                  Container(
                                    padding: EdgeInsets.symmetric(
                                        horizontal: 6, vertical: 2),
                                    decoration: BoxDecoration(
                                      color: Colors.black87,
                                      borderRadius: BorderRadius.circular(12),
                                    ),
                                    child: Text(
                                      friend['timeAgo'],
                                      style: TextStyle(
                                        color: Colors.white,
                                        fontSize: 10,
                                        fontWeight: FontWeight.bold,
                                      ),
                                    ),
                                  ),
                                  SizedBox(height: 4),
                                  // Avatar
                                  Container(
                                    width: 40,
                                    height: 40,
                                    decoration: BoxDecoration(
                                      shape: BoxShape.circle,
                                      border: Border.all(
                                          color: Colors.green, width: 3),
                                      boxShadow: [
                                        BoxShadow(
                                          color: Colors.black26,
                                          blurRadius: 4,
                                          offset: Offset(0, 2),
                                        ),
                                      ],
                                    ),
                                    child: ClipOval(
                                      child: friend['photoURL'] != null
                                          ? Image.network(
                                              friend['photoURL'],
                                              fit: BoxFit.cover,
                                              errorBuilder:
                                                  (context, error, stackTrace) {
                                                return Container(
                                                  color: Colors.grey.shade300,
                                                  child: Icon(Icons.person,
                                                      color:
                                                          Colors.grey.shade600),
                                                );
                                              },
                                            )
                                          : Container(
                                              color: Colors.grey.shade300,
                                              child: Icon(Icons.person,
                                                  color: Colors.grey.shade600),
                                            ),
                                    ),
                                  ),
                                  // İsim
                                  Container(
                                    padding: EdgeInsets.symmetric(
                                        horizontal: 4, vertical: 1),
                                    decoration: BoxDecoration(
                                      color: Colors.white,
                                      borderRadius: BorderRadius.circular(8),
                                      border: Border.all(
                                          color: Colors.grey.shade300),
                                    ),
                                    child: Text(
                                      friend['name'].toString().length > 8
                                          ? '${friend['name'].toString().substring(0, 8)}...'
                                          : friend['name'],
                                      style: TextStyle(
                                        fontSize: 10,
                                        fontWeight: FontWeight.bold,
                                        color: Colors.black87,
                                      ),
                                    ),
                                  ),
                                ],
                              ),
                            ),
                          );
                        }).toList(),
                      ),

                    // Deprem noktaları - Animasyonlu
                    if (_earthquakes.isNotEmpty)
                      MarkerLayer(
                        markers: _earthquakes.asMap().entries.map((entry) {
                          final index = entry.key;
                          final earthquake = entry.value;
                          final magnitude = earthquake['magnitude'] ?? 0.0;
                          final color = _getEarthquakeColor(magnitude);

                          return Marker(
                            point: LatLng(earthquake['latitude'],
                                earthquake['longitude']),
                            width: 100,
                            height: 100,
                            alignment: Alignment.center,
                            child: GestureDetector(
                              onTap: () => _showEarthquakeInfo(earthquake),
                              child: AnimatedBuilder(
                                animation: index < _animations.length &&
                                        index < _animationControllers.length
                                    ? _animations[index]
                                    : AlwaysStoppedAnimation(0.0),
                                builder: (context, child) {
                                  final animationValue = index <
                                              _animations.length &&
                                          index < _animationControllers.length
                                      ? _animations[index].value
                                      : 0.0;

                                  // Debug log
                                  if (index == 0 && animationValue > 0) {
                                    // Only log first earthquake to avoid spam
                                    print(
                                        '📍 Animation value for earthquake ${magnitude}: ${animationValue}');
                                  }

                                  return Stack(
                                    alignment: Alignment.center,
                                    children: [
                                      // Ripple effects - 3 concentric circles (bigger)
                                      if (animationValue >
                                          0) // Only show ripples when animating
                                        for (int i = 0; i < 3; i++)
                                          Container(
                                            width: 30 +
                                                (i * 20) +
                                                (animationValue *
                                                    60), // Increased from 20, 15, 40
                                            height: 30 +
                                                (i * 20) +
                                                (animationValue *
                                                    60), // Increased from 20, 15, 40
                                            decoration: BoxDecoration(
                                              shape: BoxShape.circle,
                                              border: Border.all(
                                                color: color.withOpacity(
                                                    (1.0 - animationValue) *
                                                        (0.6 - i * 0.2)),
                                                width: 2,
                                              ),
                                            ),
                                          ),

                                      // Main earthquake marker
                                      Container(
                                        width: 30,
                                        height: 30,
                                        decoration: BoxDecoration(
                                          color: color,
                                          shape: BoxShape.circle,
                                          border: Border.all(
                                              color: Colors.white, width: 2),
                                          boxShadow: [
                                            BoxShadow(
                                              color: Colors.black26,
                                              blurRadius: 4,
                                              offset: Offset(0, 2),
                                            ),
                                          ],
                                        ),
                                        child: Center(
                                          child: Text(
                                            magnitude.toStringAsFixed(1),
                                            style: TextStyle(
                                              color: Colors.white,
                                              fontSize: 9,
                                              fontWeight: FontWeight.bold,
                                            ),
                                          ),
                                        ),
                                      ),
                                    ],
                                  );
                                },
                              ),
                            ),
                          );
                        }).toList(),
                      ),
                  ],
                ),

                // Zoom butonları - sağ üst köşede
                Positioned(
                  top: 16,
                  right: 16,
                  child: Column(
                    children: [
                      // Zoom In butonu
                      Container(
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
                        child: Material(
                          color: Colors.transparent,
                          child: InkWell(
                            borderRadius: BorderRadius.circular(8),
                            onTap: () {
                              final currentZoom = _mapController.camera.zoom;
                              _mapController.move(
                                _mapController.camera.center,
                                currentZoom + 1,
                              );
                            },
                            child: Container(
                              width: 44,
                              height: 44,
                              child: Icon(
                                Icons.add,
                                color: Colors.grey.shade700,
                                size: 20,
                              ),
                            ),
                          ),
                        ),
                      ),

                      SizedBox(height: 2),

                      // Zoom Out butonu
                      Container(
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
                        child: Material(
                          color: Colors.transparent,
                          child: InkWell(
                            borderRadius: BorderRadius.circular(8),
                            onTap: () {
                              final currentZoom = _mapController.camera.zoom;
                              _mapController.move(
                                _mapController.camera.center,
                                currentZoom - 1,
                              );
                            },
                            child: Container(
                              width: 44,
                              height: 44,
                              child: Icon(
                                Icons.remove,
                                color: Colors.grey.shade700,
                                size: 20,
                              ),
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
      floatingActionButton: _userLocation != null
          ? FloatingActionButton(
              onPressed: () {
                _mapController.move(_userLocation!, 15.0);
              },
              backgroundColor: Colors.blue.shade700,
              child: const Icon(Icons.my_location, color: Colors.white),
            )
          : null,
    );
  }

  void _showFriendInfo(Map<String, dynamic> friend) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Row(
          children: [
            if (friend['photoURL'] != null)
              ClipOval(
                child: Image.network(
                  friend['photoURL'],
                  width: 40,
                  height: 40,
                  fit: BoxFit.cover,
                  errorBuilder: (context, error, stackTrace) {
                    return Icon(Icons.person, size: 40);
                  },
                ),
              )
            else
              Icon(Icons.person, size: 40),
            SizedBox(width: 12),
            Expanded(
              child: Text(
                friend['name'],
                style: TextStyle(fontSize: 18),
              ),
            ),
          ],
        ),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('📍 Konum: ${friend['address']}'),
            SizedBox(height: 8),
            Text('🕐 Son görülme: ${friend['timeAgo']}'),
            SizedBox(height: 8),
            Text(
                '📊 Koordinatlar: ${friend['latitude'].toStringAsFixed(4)}, ${friend['longitude'].toStringAsFixed(4)}'),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: Text('Tamam'),
          ),
        ],
      ),
    );
  }

  void _showEarthquakeInfo(Map<String, dynamic> earthquake) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Row(
          children: [
            Icon(Icons.warning,
                color: _getEarthquakeColor(earthquake['magnitude'] ?? 0.0)),
            SizedBox(width: 8),
            Text('Deprem Bilgisi'),
          ],
        ),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('📊 Büyüklük: ${earthquake['magnitude']?.toStringAsFixed(1)}'),
            SizedBox(height: 8),
            Text('📍 Konum: ${earthquake['location'] ?? 'Bilinmiyor'}'),
            SizedBox(height: 8),
            Text('🕐 Zaman: ${earthquake['time'] ?? 'Bilinmiyor'}'),
            SizedBox(height: 8),
            Text('🌊 Derinlik: ${earthquake['depth'] ?? 'Bilinmiyor'} km'),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: Text('Tamam'),
          ),
        ],
      ),
    );
  }

  Color _getEarthquakeColor(double magnitude) {
    if (magnitude >= 7.0) return Colors.red.shade800;
    if (magnitude >= 6.0) return Colors.red.shade600;
    if (magnitude >= 5.0) return Colors.orange.shade600;
    if (magnitude >= 4.0)
      return Colors.orange.shade600; // Changed from yellow to orange
    return Colors.green.shade600;
  }
}
