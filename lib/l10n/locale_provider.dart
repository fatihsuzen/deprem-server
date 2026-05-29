import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';

class LocaleProvider extends ChangeNotifier {
  static const String _localeKey = 'app_locale';
  static const String _languageSelectedKey = 'language_selected';

  /// Synchronous in-memory cache — set once at startup, updated on locale change.
  /// Use this to avoid the async-init locale flash in screens.
  static String cached = 'tr';

  Locale _locale = const Locale('tr'); // Default Turkish
  bool _isLanguageSelected = false;

  Locale get locale => _locale;
  bool get isLanguageSelected => _isLanguageSelected;

  LocaleProvider() {
    _loadLocale();
  }

  Future<void> _loadLocale() async {
    final prefs = await SharedPreferences.getInstance();
    final languageCode = prefs.getString(_localeKey) ?? 'tr';
    _isLanguageSelected = prefs.getBool(_languageSelectedKey) ?? false;
    _locale = Locale(languageCode);
    cached = languageCode;
    notifyListeners();
  }

  Future<void> setLocale(Locale locale) async {
    if (_locale == locale) return;

    _locale = locale;
    cached = locale.languageCode;
    final prefs = await SharedPreferences.getInstance();
    await prefs.setString(_localeKey, locale.languageCode);
    await prefs.setBool(_languageSelectedKey, true);
    _isLanguageSelected = true;
    notifyListeners();

    // Sunucudaki kullanıcı profilini güncelle (bildirimler doğru dilde gelsin)
    _syncLanguageToServer(prefs, locale.languageCode);
  }

  /// Kullanıcının dil tercihini sunucuya iletir (fire-and-forget).
  static void _syncLanguageToServer(SharedPreferences prefs, String languageCode) {
    final userId = prefs.getString('user_id');
    if (userId == null || userId.isEmpty) return;
    const baseUrl = 'http://188.132.202.24:3000/api';
    http.post(
      Uri.parse('$baseUrl/settings/$userId'),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode({'language': languageCode}),
    ).catchError((_) {}); // Sessizce hata yut — kritik değil
  }

  Future<void> markLanguageSelected() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_languageSelectedKey, true);
    _isLanguageSelected = true;
    notifyListeners();
  }

  static Future<bool> isFirstLaunch() async {
    final prefs = await SharedPreferences.getInstance();
    return !(prefs.getBool(_languageSelectedKey) ?? false);
  }

  static Future<Locale> getSavedLocale() async {
    final prefs = await SharedPreferences.getInstance();
    final languageCode = prefs.getString(_localeKey) ?? 'tr';
    return Locale(languageCode);
  }
}
