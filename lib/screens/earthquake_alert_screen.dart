import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';
import 'dart:async';
import 'dart:math';
import '../services/location_service.dart';

class EarthquakeAlertScreen extends StatefulWidget {
  final double magnitude;
  final String location;
  final double distance; // km cinsinden uzaklık
  final DateTime timestamp;
  final String source; // 'P2P' veya 'AFAD'
  final String? userLocation;
  final double? epicenterLat; // Deprem merkezi enlemi
  final double? epicenterLon; // Deprem merkezi boylamı

  const EarthquakeAlertScreen({
    super.key,
    required this.magnitude,
    required this.location,
    required this.distance,
    required this.timestamp,
    this.source = 'AFAD',
    this.userLocation,
    this.epicenterLat,
    this.epicenterLon,
  });

  @override
  State<EarthquakeAlertScreen> createState() => _EarthquakeAlertScreenState();
}

class _EarthquakeAlertScreenState extends State<EarthquakeAlertScreen>
    with TickerProviderStateMixin {
  late AnimationController _pulseController;
  late AnimationController _shakeController;
  late Animation<double> _pulseAnimation;
  Timer? _autoCloseTimer;
  int _secondsLeft = 120;
  late AnimationController _waveController;
  late Animation<double> _waveAnimation;
  late LatLng userLatLng;
  late LatLng quakeLatLng;
  bool _isLocationReady = false;
  double distanceKm = 0.0;
  double waveBase = 0.0;

  @override
  void initState() {
    super.initState();

    // Tam ekran modu
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.immersiveSticky);

    // Nabız animasyonu
    _pulseController = AnimationController(
      duration: const Duration(milliseconds: 1500),
      vsync: this,
    )..repeat(reverse: true);

    _pulseAnimation = Tween<double>(begin: 0.95, end: 1.05).animate(
      CurvedAnimation(parent: _pulseController, curve: Curves.easeInOut),
    );

    // Titreşim animasyonu
    _shakeController = AnimationController(
      duration: const Duration(milliseconds: 500),
      vsync: this,
    )..repeat(reverse: true);

    // Deprem merkezi konumu
    double quakeLat = 39.0;
    double quakeLon = 35.0;
    
    // Önce epicenterLat/epicenterLon parametrelerini kontrol et
    if (widget.epicenterLat != null && widget.epicenterLon != null &&
        !widget.epicenterLat!.isNaN && !widget.epicenterLon!.isNaN) {
      quakeLat = widget.epicenterLat!;
      quakeLon = widget.epicenterLon!;
      print('📍 Deprem merkezi (epicenter params): $quakeLat, $quakeLon');
    } else {
      // Fallback: location string'inden parse et
      final locParts = widget.location.split(',');
      if (locParts.length == 2) {
        try {
          quakeLat = double.parse(locParts[0].trim());
          quakeLon = double.parse(locParts[1].trim());
          if (quakeLat.isNaN || quakeLon.isNaN) {
            quakeLat = 39.0;
            quakeLon = 35.0;
          }
          print('📍 Deprem merkezi (location parse): $quakeLat, $quakeLon');
        } catch (e) {
          print('⚠️ Location parse hatası, varsayılan konum kullanılıyor');
          quakeLat = 39.0;
          quakeLon = 35.0;
        }
      } else {
        print('⚠️ Location formatı uygun değil: ${widget.location}, varsayılan konum kullanılıyor');
      }
    }
    quakeLatLng = LatLng(quakeLat, quakeLon);
    print('🗺️ Final deprem konumu: $quakeLatLng');

    // Kullanıcı konumu (server/gps'ten gelen)
    Future<void> setUserLocation() async {
      LatLng? lastLocation;
      final userLocParts = (widget.userLocation ?? '').split(',');
      if (widget.userLocation != null && userLocParts.length == 2) {
        userLatLng = LatLng(double.parse(userLocParts[0].trim()),
            double.parse(userLocParts[1].trim()));
      } else {
        // Dosyadan son konumu oku
        try {
          final locationService = LocationService();
          lastLocation = await locationService.readLastLocationFromFile();
        } catch (e) {
          lastLocation = null;
        }
        userLatLng =
            lastLocation ?? LatLng(39.0, 35.0); // fallback: Türkiye merkezi
      }
      setState(() {
        distanceKm =
            const Distance().as(LengthUnit.Kilometer, quakeLatLng, userLatLng);
        _isLocationReady = true;
      });

      // Sismik dalga animasyonu: deprem merkezinden kullanıcıya yayılma
      // Dalga yayılma hızı (7 km/sn)
      const double waveSpeedKmPerSec = 7.0;
      final int secondsToReach =
          max(3, (distanceKm / waveSpeedKmPerSec).ceil());
      final waveDuration = Duration(seconds: secondsToReach);
      _waveController = AnimationController(
        duration: waveDuration,
        vsync: this,
      );
      _waveAnimation = Tween<double>(begin: 0.0, end: 1.0).animate(
        CurvedAnimation(parent: _waveController, curve: Curves.linear),
      );

      // Dalga animasyonu ekran kapanana kadar sürekli tekrar etsin
      void repeatWave() {
        if (mounted) {
          _waveController.forward(from: 0.0).then((_) {
            if (mounted) {
              setState(() {
                waveBase += 0.5;
              });
              repeatWave();
            }
          });
        }
      }

      repeatWave();

      // Dinamik geri sayım: Sismik dalga kullanıcıya ulaşana kadar
      setState(() {
        _secondsLeft = secondsToReach;
      });
      _autoCloseTimer = Timer.periodic(const Duration(seconds: 1), (timer) {
        if (!mounted) return;
        setState(() {
          _secondsLeft--;
        });
        if (_secondsLeft <= 0) {
          timer.cancel();
          // Otomatik kapatma kaldırıldı, sadece kullanıcı kapatınca kapanacak
        }
      });

      // Telefonun titreşimini başlat
      _startVibration();
    }

    setUserLocation();
  }

  void _startVibration() {
    // Yoğun titreşim paterni
    HapticFeedback.heavyImpact();
    Future.delayed(const Duration(milliseconds: 500), () {
      if (mounted) {
        HapticFeedback.heavyImpact();
        Future.delayed(const Duration(milliseconds: 500), () {
          if (mounted) {
            HapticFeedback.heavyImpact();
          }
        });
      }
    });
  }

  void _closeAlert() {
    // Deprem parametrelerini native tarafta temizle
    const MethodChannel paramsChannel =
        MethodChannel('deprem_app/earthquake_params');
    paramsChannel.invokeMethod('clearEarthquakeParams');
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
    Navigator.of(context).pop();
  }

  Color _getAlertColor() {
    if (widget.magnitude >= 6.0) return Colors.red.shade900;
    if (widget.magnitude >= 5.0) return Colors.red.shade700;
    if (widget.magnitude >= 4.0) return Colors.orange.shade700;
    return Colors.orange.shade500;
  }

  String _getAlertMessage() {
    if (widget.distance < 10) {
      return 'HEMEN SIĞINAK ALIN!';
    } else if (widget.distance < 50) {
      return 'GÜVENLİ BİR YERE GEÇİN!';
    } else {
      return 'HAZIRLIKLI OLUN!';
    }
  }

  String _getDistanceText() {
    if (widget.distance < 1) {
      return '${(widget.distance * 1000).toStringAsFixed(0)} metre';
    }
    return '${widget.distance.toStringAsFixed(1)} km';
  }

  @override
  void dispose() {
    _pulseController.dispose();
    _shakeController.dispose();
    _waveController.dispose();
    _autoCloseTimer?.cancel();
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    debugPrint(
        '[ALERT_SCREEN] build: source=${widget.source}, magnitude=${widget.magnitude}, location=${widget.location}, distance=${widget.distance}, timestamp=${widget.timestamp}, userLocation=${widget.userLocation}');
    final alertColor = _getAlertColor();
    final screenHeight = MediaQuery.of(context).size.height;
    final screenWidth = MediaQuery.of(context).size.width;

    // Eğer konumlar null ise loading spinner göster
    if (!_isLocationReady) {
      return Scaffold(
        backgroundColor: Colors.black,
        body: const Center(
          child: CircularProgressIndicator(color: Colors.redAccent),
        ),
      );
    }

    // Harita view: hem deprem hem kullanıcı markerı, dalga animasyonu depremden kullanıcıya doğru
    return Scaffold(
      backgroundColor: Colors.black,
      body: SafeArea(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                width: screenWidth * 0.85,
                height: screenHeight * 0.45,
                decoration: BoxDecoration(
                  color: Colors.black,
                  borderRadius: BorderRadius.circular(24),
                  boxShadow: [
                    BoxShadow(color: Colors.black54, blurRadius: 16),
                  ],
                ),
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(24),
                  child: Stack(
                    children: [
                      FlutterMap(
                        options: MapOptions(
                          initialCenter: LatLng(
                            (quakeLatLng.latitude + userLatLng.latitude) / 2,
                            (quakeLatLng.longitude + userLatLng.longitude) / 2,
                          ),
                          initialZoom: 7.0,
                          interactionOptions: const InteractionOptions(
                              enableMultiFingerGestureRace: false,
                              flags: InteractiveFlag.none),
                        ),
                        children: [
                          TileLayer(
                            urlTemplate:
                                'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
                            subdomains: ['a', 'b', 'c'],
                            userAgentPackageName: 'dev.deprem_bildirim',
                          ),
                          MarkerLayer(
                            markers: [
                              // Deprem merkezi markerı ve dalga animasyonu
                              Marker(
                                point: quakeLatLng,
                                width: 600,
                                height: 600,
                                child: AnimatedBuilder(
                                  animation: _waveAnimation,
                                  builder: (context, child) {
                                    final maxRadiusKm = distanceKm + 100;
                                    final waveRadiusKm = maxRadiusKm *
                                        (waveBase + _waveAnimation.value);
                                    final wavePixel = 40.0 + waveRadiusKm * 2;
                                    return Stack(
                                      alignment: Alignment.center,
                                      children: [
                                        Container(
                                          width: wavePixel,
                                          height: wavePixel,
                                          decoration: BoxDecoration(
                                            shape: BoxShape.circle,
                                            color: Colors.red.withOpacity(0.45 -
                                                _waveAnimation.value * 0.15),
                                            border: Border.all(
                                              color: Colors.redAccent
                                                  .withOpacity(0.7 -
                                                      _waveAnimation.value *
                                                          0.3),
                                              width: 4,
                                            ),
                                          ),
                                        ),
                                        Container(
                                          width: 38,
                                          height: 38,
                                          decoration: BoxDecoration(
                                            shape: BoxShape.circle,
                                            color: alertColor,
                                            boxShadow: [
                                              BoxShadow(
                                                  color: Colors.black38,
                                                  blurRadius: 8),
                                            ],
                                          ),
                                          child: Icon(Icons.location_on,
                                              color: Colors.white, size: 26),
                                        ),
                                      ],
                                    );
                                  },
                                ),
                              ),
                              // Kullanıcı konumu markerı
                              Marker(
                                point: userLatLng,
                                width: 38,
                                height: 38,
                                child: Container(
                                  decoration: BoxDecoration(
                                    shape: BoxShape.circle,
                                    color: Colors.blueAccent,
                                    boxShadow: [
                                      BoxShadow(
                                          color: Colors.black38, blurRadius: 8),
                                    ],
                                  ),
                                  child: Icon(Icons.person_pin_circle,
                                      color: Colors.white, size: 26),
                                ),
                              ),
                            ],
                          ),
                          // Dalga animasyonu: depremden kullanıcıya doğru bir çizgi
                          PolylineLayer(
                            polylines: [
                              Polyline(
                                points: [quakeLatLng, userLatLng],
                                color: alertColor.withOpacity(0.5),
                                strokeWidth: 4,
                              ),
                            ],
                          ),
                        ],
                      ),
                      // ...potansiyel deprem açıklaması kaldırıldı...
                    ],
                  ),
                ),
              ),
              const SizedBox(height: 32),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    _getAlertMessage(),
                    style: TextStyle(
                      fontSize: 22,
                      fontWeight: FontWeight.bold,
                      color: alertColor,
                    ),
                  ),
                  const SizedBox(width: 18),
                  Container(
                    padding:
                        const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
                    decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(16),
                    ),
                    child: Row(
                      children: [
                        Icon(Icons.timer, color: alertColor, size: 22),
                        const SizedBox(width: 6),
                        Text(
                          '$_secondsLeft',
                          style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                            color: alertColor,
                          ),
                        ),
                        const SizedBox(width: 2),
                        const Text('sn', style: TextStyle(fontSize: 16)),
                      ],
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 24),
              Text(
                'Tahmini Deprem: ${widget.magnitude.toStringAsFixed(1)}',
                style: const TextStyle(
                  fontSize: 22,
                  color: Colors.red,
                  fontWeight: FontWeight.bold,
                  letterSpacing: 1.2,
                  shadows: [
                    Shadow(
                        color: Colors.black,
                        blurRadius: 4,
                        offset: Offset(1, 1)),
                  ],
                ),
              ),
              const SizedBox(height: 8),
              Text(
                _getDistanceText(),
                style: TextStyle(
                  fontSize: 16,
                  color: Colors.white70,
                ),
              ),
              const SizedBox(height: 32),
              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  backgroundColor: alertColor,
                  foregroundColor: Colors.white,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(24),
                  ),
                  padding:
                      const EdgeInsets.symmetric(horizontal: 32, vertical: 14),
                ),
                onPressed: _closeAlert,
                child: const Text('Kapat',
                    style:
                        TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
