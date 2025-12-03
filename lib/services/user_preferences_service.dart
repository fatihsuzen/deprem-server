import 'package:shared_preferences/shared_preferences.dart';

class UserPreferencesService {
  static const String _keyMinMagnitude = 'min_magnitude';
  static const String _keyMaxMagnitude = 'max_magnitude';
  static const String _keyNotificationRadius = 'notification_radius';
  static const String _keyShowEarthquakes = 'show_earthquakes';
  static const String _keyShowFriends = 'show_friends';
  static const String _keyShowShelters = 'show_shelters';
  static const String _keyShareLocation = 'share_location_with_friends';
  static const String _keyNotificationSound = 'notification_sound_enabled';
  static const String _keyVibration = 'vibration_enabled';
  static const String _keyBackgroundNotifications =
      'background_notifications_enabled';

  // Varsayılan değerler
  static const double defaultMinMagnitude = 2.5;
  static const double defaultMaxMagnitude = 10.0;
  static const double defaultNotificationRadius = 300.0; // km
  static const bool defaultShareLocation = true; // Varsayılan olarak açık
  static const bool defaultNotificationSound = true;
  static const bool defaultVibration = true;
  static const bool defaultBackgroundNotifications = true;

  // Magnitude Ayarları
  Future<void> setMinMagnitude(double value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setDouble(_keyMinMagnitude, value);
  }

  Future<double> getMinMagnitude() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getDouble(_keyMinMagnitude) ?? defaultMinMagnitude;
  }

  Future<void> setMaxMagnitude(double value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setDouble(_keyMaxMagnitude, value);
  }

  Future<double> getMaxMagnitude() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getDouble(_keyMaxMagnitude) ?? defaultMaxMagnitude;
  }

  // Bildirim Yarıçapı Ayarları
  Future<void> setNotificationRadius(double value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setDouble(_keyNotificationRadius, value);
  }

  Future<double> getNotificationRadius() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getDouble(_keyNotificationRadius) ?? defaultNotificationRadius;
  }

  // Harita Görünürlük Ayarları
  Future<void> setShowEarthquakes(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyShowEarthquakes, value);
  }

  Future<bool> getShowEarthquakes() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getBool(_keyShowEarthquakes) ?? true;
  }

  Future<void> setShowFriends(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyShowFriends, value);
  }

  Future<bool> getShowFriends() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getBool(_keyShowFriends) ?? true;
  }

  Future<void> setShowShelters(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyShowShelters, value);
  }

  Future<bool> getShowShelters() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getBool(_keyShowShelters) ?? true;
  }

  // Konum Paylaşım Ayarı
  Future<void> setShareLocation(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyShareLocation, value);
  }

  Future<bool> getShareLocation() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getBool(_keyShareLocation) ?? defaultShareLocation;
  }

  // Bildirim Sesi Ayarı
  Future<void> setNotificationSound(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyNotificationSound, value);
  }

  Future<bool> getNotificationSound() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getBool(_keyNotificationSound) ?? defaultNotificationSound;
  }

  // Titreşim Ayarı
  Future<void> setVibration(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyVibration, value);
  }

  Future<bool> getVibration() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getBool(_keyVibration) ?? defaultVibration;
  }

  // Arka Plan Bildirimleri Ayarı
  Future<void> setBackgroundNotifications(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyBackgroundNotifications, value);
  }

  Future<bool> getBackgroundNotifications() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getBool(_keyBackgroundNotifications) ??
        defaultBackgroundNotifications;
  }

  // Tüm ayarları al (tek seferde)
  Future<Map<String, dynamic>> getAllSettings() async {
    return {
      'minMagnitude': await getMinMagnitude(),
      'maxMagnitude': await getMaxMagnitude(),
      'notificationRadius': await getNotificationRadius(),
      'showEarthquakes': await getShowEarthquakes(),
      'showFriends': await getShowFriends(),
      'showShelters': await getShowShelters(),
      'shareLocation': await getShareLocation(),
      'notificationSound': await getNotificationSound(),
      'vibration': await getVibration(),
      'backgroundNotifications': await getBackgroundNotifications(),
    };
  }

  // Ayarları sıfırla
  Future<void> resetToDefaults() async {
    await setMinMagnitude(defaultMinMagnitude);
    await setMaxMagnitude(defaultMaxMagnitude);
    await setNotificationRadius(defaultNotificationRadius);
    await setShowEarthquakes(true);
    await setShowFriends(true);
    await setShowShelters(true);
  }

  // Ayarları dışa aktar (JSON string)
  Future<String> exportSettings() async {
    final settings = await getAllSettings();
    return settings.toString();
  }
}
