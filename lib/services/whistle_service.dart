import 'dart:async';
import 'package:flutter/services.dart';

/// Enkaz altında kalan kişilerin yerini belli etmesi için
/// aralıksız düdük sesi çalan servis
class WhistleService {
  static final WhistleService _instance = WhistleService._internal();
  factory WhistleService() => _instance;
  WhistleService._internal();

  bool _isPlaying = false;
  Timer? _whistleTimer;
  
  // Platform channel for native audio
  static const MethodChannel _channel = MethodChannel('deprem_app/whistle');

  bool get isPlaying => _isPlaying;

  /// Düdük çalmaya başla - aralıksız tekrar eder
  Future<void> startWhistle() async {
    if (_isPlaying) return;
    
    _isPlaying = true;
    
    // Native tarafta düdük sesini başlat
    try {
      await _channel.invokeMethod('startWhistle');
    } catch (e) {
      print('[Whistle] Native çağrı hatası: $e');
      // Fallback: Timer ile sistem sesi çal
      _startFallbackWhistle();
    }
  }

  /// Düdük çalmayı durdur
  Future<void> stopWhistle() async {
    if (!_isPlaying) return;
    
    _isPlaying = false;
    _whistleTimer?.cancel();
    _whistleTimer = null;
    
    try {
      await _channel.invokeMethod('stopWhistle');
    } catch (e) {
      print('[Whistle] Native durdurma hatası: $e');
    }
  }

  /// Fallback: Sistem sesi ile düdük simülasyonu
  void _startFallbackWhistle() {
    // Her 500ms'de bir sistem sesi çal
    _whistleTimer = Timer.periodic(const Duration(milliseconds: 500), (timer) {
      if (!_isPlaying) {
        timer.cancel();
        return;
      }
      // Sistem beep sesi
      SystemSound.play(SystemSoundType.click);
    });
  }

  /// Servis dispose edildiğinde temizle
  void dispose() {
    stopWhistle();
  }
}
