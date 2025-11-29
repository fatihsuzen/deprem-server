import 'package:flutter/services.dart';

class ScreenStateService {
  static const platform = MethodChannel('deprem_app/screen_state');

  static Future<bool> isScreenOn() async {
    try {
      final bool result = await platform.invokeMethod('isScreenOn');
      return result;
    } catch (e) {
      print('Screen state kontrol hatası: $e');
      return true; // Varsayılan olarak ekran açık kabul edilir
    }
  }
}