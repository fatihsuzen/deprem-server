import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

class LocaleProvider extends ChangeNotifier {
  static const String _localeKey = 'app_locale';
  static const String _languageSelectedKey = 'language_selected';

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
    notifyListeners();
  }

  Future<void> setLocale(Locale locale) async {
    if (_locale == locale) return;

    _locale = locale;
    final prefs = await SharedPreferences.getInstance();
    await prefs.setString(_localeKey, locale.languageCode);
    await prefs.setBool(_languageSelectedKey, true);
    _isLanguageSelected = true;
    notifyListeners();
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
