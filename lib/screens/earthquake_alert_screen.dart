import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'dart:async';

class EarthquakeAlertScreen extends StatefulWidget {
  final double magnitude;
  final String location;
  final double distance; // km cinsinden uzaklık
  final DateTime timestamp;
  final String source; // 'P2P' veya 'AFAD'

  const EarthquakeAlertScreen({
    super.key,
    required this.magnitude,
    required this.location,
    required this.distance,
    required this.timestamp,
    this.source = 'AFAD',
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

    // 30 saniye sonra otomatik kapat
    _autoCloseTimer = Timer(const Duration(seconds: 30), () {
      if (mounted) {
        _closeAlert();
      }
    });

    // Telefonun titreşimini başlat
    _startVibration();
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
    _autoCloseTimer?.cancel();
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.edgeToEdge);
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final alertColor = _getAlertColor();
    final screenHeight = MediaQuery.of(context).size.height;
    final screenWidth = MediaQuery.of(context).size.width;

    return Scaffold(
      backgroundColor: alertColor,
      body: SafeArea(
        child: Container(
          width: screenWidth,
          height: screenHeight,
          decoration: BoxDecoration(
            gradient: LinearGradient(
              begin: Alignment.topCenter,
              end: Alignment.bottomCenter,
              colors: [
                alertColor,
                alertColor.withOpacity(0.8),
              ],
            ),
          ),
          child: Stack(
            children: [
              // Arka plan dalgalar
              ...List.generate(3, (index) {
                return AnimatedBuilder(
                  animation: _pulseController,
                  builder: (context, child) {
                    return Positioned.fill(
                      child: Center(
                        child: Container(
                          width: screenWidth * (0.5 + index * 0.3) * _pulseAnimation.value,
                          height: screenWidth * (0.5 + index * 0.3) * _pulseAnimation.value,
                          decoration: BoxDecoration(
                            shape: BoxShape.circle,
                            border: Border.all(
                              color: Colors.white.withOpacity(0.3 - index * 0.1),
                              width: 2,
                            ),
                          ),
                        ),
                      ),
                    );
                  },
                );
              }),

              // İçerik
              Column(
                children: [
                  const SizedBox(height: 40),

                  // Kaynak badge
                  Container(
                    padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
                    decoration: BoxDecoration(
                      color: Colors.black.withOpacity(0.3),
                      borderRadius: BorderRadius.circular(20),
                    ),
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Icon(
                          widget.source == 'P2P' ? Icons.people : Icons.info_outline,
                          color: Colors.white,
                          size: 16,
                        ),
                        const SizedBox(width: 8),
                        Text(
                          widget.source == 'P2P' ? 'P2P ALGILAMA' : 'AFAD',
                          style: const TextStyle(
                            color: Colors.white,
                            fontSize: 14,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ],
                    ),
                  ),

                  const SizedBox(height: 20),

                  // Uyarı ikonu
                  ScaleTransition(
                    scale: _pulseAnimation,
                    child: Container(
                      width: 120,
                      height: 120,
                      decoration: BoxDecoration(
                        color: Colors.white,
                        shape: BoxShape.circle,
                        boxShadow: [
                          BoxShadow(
                            color: Colors.black.withOpacity(0.3),
                            blurRadius: 20,
                            spreadRadius: 5,
                          ),
                        ],
                      ),
                      child: Icon(
                        Icons.warning_rounded,
                        size: 70,
                        color: alertColor,
                      ),
                    ),
                  ),

                  const SizedBox(height: 30),

                  // Ana mesaj
                  Text(
                    _getAlertMessage(),
                    textAlign: TextAlign.center,
                    style: const TextStyle(
                      color: Colors.white,
                      fontSize: 32,
                      fontWeight: FontWeight.w900,
                      letterSpacing: 1.5,
                      shadows: [
                        Shadow(
                          color: Colors.black26,
                          offset: Offset(2, 2),
                          blurRadius: 4,
                        ),
                      ],
                    ),
                  ),

                  const SizedBox(height: 40),

                  // Deprem bilgileri kartı
                  Container(
                    margin: const EdgeInsets.symmetric(horizontal: 30),
                    padding: const EdgeInsets.all(24),
                    decoration: BoxDecoration(
                      color: Colors.white.withOpacity(0.95),
                      borderRadius: BorderRadius.circular(20),
                      boxShadow: [
                        BoxShadow(
                          color: Colors.black.withOpacity(0.2),
                          blurRadius: 15,
                          spreadRadius: 2,
                        ),
                      ],
                    ),
                    child: Column(
                      children: [
                        // Büyüklük
                        Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            const Text(
                              'BÜYÜKLÜK: ',
                              style: TextStyle(
                                fontSize: 20,
                                fontWeight: FontWeight.w600,
                                color: Colors.black87,
                              ),
                            ),
                            Text(
                              'M${widget.magnitude.toStringAsFixed(1)}',
                              style: TextStyle(
                                fontSize: 48,
                                fontWeight: FontWeight.w900,
                                color: alertColor,
                              ),
                            ),
                          ],
                        ),

                        const SizedBox(height: 20),

                        // Uzaklık
                        _buildInfoRow(
                          Icons.location_on,
                          'Uzaklık',
                          _getDistanceText(),
                          alertColor,
                        ),

                        const SizedBox(height: 12),

                        // Konum
                        _buildInfoRow(
                          Icons.place,
                          'Konum',
                          widget.location,
                          alertColor,
                        ),

                        const SizedBox(height: 12),

                        // Zaman
                        _buildInfoRow(
                          Icons.access_time,
                          'Zaman',
                          '${widget.timestamp.hour.toString().padLeft(2, '0')}:${widget.timestamp.minute.toString().padLeft(2, '0')}:${widget.timestamp.second.toString().padLeft(2, '0')}',
                          alertColor,
                        ),
                      ],
                    ),
                  ),

                  const Spacer(),

                  // Güvenlik talimatları
                  Container(
                    margin: const EdgeInsets.symmetric(horizontal: 30),
                    padding: const EdgeInsets.all(20),
                    decoration: BoxDecoration(
                      color: Colors.black.withOpacity(0.3),
                      borderRadius: BorderRadius.circular(15),
                    ),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        const Text(
                          '⚠️ GÜVENLİK TALİMATLARI',
                          style: TextStyle(
                            color: Colors.white,
                            fontSize: 16,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        const SizedBox(height: 12),
                        _buildSafetyInstruction('Sakin olun, panik yapmayın'),
                        _buildSafetyInstruction('Sağlam masa altına saklanın'),
                        _buildSafetyInstruction('Camlardan ve ağır eşyalardan uzak durun'),
                      ],
                    ),
                  ),

                  const SizedBox(height: 30),

                  // Kapat butonu
                  ElevatedButton(
                    onPressed: _closeAlert,
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.white,
                      foregroundColor: alertColor,
                      padding: const EdgeInsets.symmetric(
                        horizontal: 60,
                        vertical: 18,
                      ),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(30),
                      ),
                      elevation: 8,
                    ),
                    child: const Text(
                      'ANLADIM',
                      style: TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                        letterSpacing: 1.2,
                      ),
                    ),
                  ),

                  const SizedBox(height: 40),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildInfoRow(IconData icon, String label, String value, Color color) {
    return Row(
      children: [
        Icon(icon, color: color, size: 24),
        const SizedBox(width: 12),
        Expanded(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                label,
                style: const TextStyle(
                  fontSize: 12,
                  color: Colors.black54,
                  fontWeight: FontWeight.w500,
                ),
              ),
              const SizedBox(height: 2),
              Text(
                value,
                style: const TextStyle(
                  fontSize: 16,
                  color: Colors.black87,
                  fontWeight: FontWeight.w600,
                ),
              ),
            ],
          ),
        ),
      ],
    );
  }

  Widget _buildSafetyInstruction(String text) {
    return Padding(
      padding: const EdgeInsets.only(bottom: 8),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            '• ',
            style: TextStyle(
              color: Colors.white,
              fontSize: 14,
              fontWeight: FontWeight.bold,
            ),
          ),
          Expanded(
            child: Text(
              text,
              style: const TextStyle(
                color: Colors.white,
                fontSize: 14,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
