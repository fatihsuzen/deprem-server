import 'dart:async';
import 'package:audioplayers/audioplayers.dart';

/// Enkaz altında kalan kişilerin yerini belli etmesi için
/// aralıksız SOS sesi çalan servis
class WhistleService {
  static final WhistleService _instance = WhistleService._internal();
  factory WhistleService() => _instance;
  WhistleService._internal();

  bool _isPlaying = false;
  final AudioPlayer _audioPlayer = AudioPlayer();

  bool get isPlaying => _isPlaying;

  /// SOS sesini çalmaya başla - döngüde tekrar eder
  Future<void> startWhistle() async {
    if (_isPlaying) return;

    _isPlaying = true;

    try {
      // Döngü modunu ayarla
      await _audioPlayer.setReleaseMode(ReleaseMode.loop);
      
      // Ses seviyesini maksimuma ayarla
      await _audioPlayer.setVolume(1.0);
      
      // Assets'teki sos.mp3'ü çal
      await _audioPlayer.play(AssetSource('sos.mp3'));
      
      print('[Whistle] SOS sesi başlatıldı');
    } catch (e) {
      print('[Whistle] Ses çalma hatası: $e');
      _isPlaying = false;
    }
  }

  /// SOS sesini durdur
  Future<void> stopWhistle() async {
    if (!_isPlaying) return;

    _isPlaying = false;

    try {
      await _audioPlayer.stop();
      print('[Whistle] SOS sesi durduruldu');
    } catch (e) {
      print('[Whistle] Ses durdurma hatası: $e');
    }
  }

  /// Servis dispose edildiğinde temizle
  void dispose() {
    stopWhistle();
    _audioPlayer.dispose();
  }
}
