import 'package:flutter/material.dart';

class AppLocalizations {
  String get appTitle => get('app_name');
  String get loginSubtitle => get('welcome_select_language');
  String get loginWithGoogle => get('sign_in_google');
  String get continueAsGuest => get('continue_text');
  final Locale locale;

  AppLocalizations(this.locale);

  static AppLocalizations? of(BuildContext context) {
    return Localizations.of<AppLocalizations>(context, AppLocalizations);
  }

  static const LocalizationsDelegate<AppLocalizations> delegate =
      _AppLocalizationsDelegate();

  static final Map<String, Map<String, String>> _localizedValues = {
    'en': {
      // App General
      'app_name': 'Earthquake Line',
      'loading': 'Loading...',
      'error': 'Error',
      'success': 'Success',
      'cancel': 'Cancel',
      'save': 'Save',
      'delete': 'Delete',
      'edit': 'Edit',
      'close': 'Close',
      'ok': 'OK',
      'yes': 'Yes',
      'no': 'No',
      'retry': 'Retry',
      'back': 'Back',
      'next': 'Next',
      'done': 'Done',
      'search': 'Search',
      'settings': 'Settings',
      'logout': 'Logout',
      'login': 'Login',
      'register': 'Register',

      // Language Selection
      'select_language': 'Select Language',
      'language': 'Language',
      'turkish': 'Turkish',
      'english': 'English',
      'language_changed': 'Language changed',
      'welcome_select_language': 'Welcome! Please select your language',
      'continue_text': 'Continue',

      // Bottom Navigation
      'nav_map': 'Map',
      'nav_list': 'List',
      'nav_friends': 'Friends',
      'nav_profile': 'Profile',

      // Map Screen
      'earthquake_map': 'Earthquake Map',
      'show_fault_lines': 'Show Fault Lines',
      'hide_fault_lines': 'Hide Fault Lines',
      'show_friends': 'Show Friends',
      'hide_friends': 'Hide Friends',
      'my_location': 'My Location',
      'earthquake_details': 'Earthquake Details',
      'earthquake_info': 'Earthquake Information',
      'magnitude': 'Magnitude',
      'depth': 'Depth',
      'distance': 'Distance',
      'location': 'Location',
      'time': 'Time',
      'source': 'Source',
      'km': 'km',
      'km_away': 'km away',
      'minutes_ago': 'minutes ago',
      'hours_ago': 'hours ago',
      'days_ago': 'days ago',
      'just_now': 'Just now',

      // Earthquake List
      'earthquake_list': 'Earthquake List',
      'no_earthquakes': 'No earthquakes found',
      'last_24_hours': 'Last 24 Hours',
      'last_week': 'Last Week',
      'last_month': 'Last Month',
      'all_earthquakes': 'All Earthquakes',
      'filter': 'Filter',
      'sort_by': 'Sort By',
      'newest_first': 'Newest First',
      'oldest_first': 'Oldest First',
      'highest_magnitude': 'Highest Magnitude',
      'nearest_first': 'Nearest First',

      // Friends Screen
      'friends': 'Friends',
      'add_friend': 'Add Friend',
      'friend_requests': 'Friend Requests',
      'pending_requests': 'Pending Requests',
      'no_friends': 'No friends yet',
      'search_friends': 'Search friends...',
      'send_request': 'Send Request',
      'accept': 'Accept',
      'reject': 'Reject',
      'remove_friend': 'Remove Friend',
      'friend_location': 'Friend Location',
      'last_seen': 'Last seen',
      'online': 'Online',
      'offline': 'Offline',

      // Profile Screen
      'profile': 'Profile',
      'edit_profile': 'Edit Profile',
      'my_reports': 'My Reports',
      'notification_history': 'Notification History',
      'emergency_contacts': 'Emergency Contacts',
      'help_support': 'Help & Support',
      'about': 'About',
      'privacy_policy': 'Privacy Policy',
      'terms_of_service': 'Terms of Service',
      'version': 'Version',

      // Settings Screen
      'settings_title': 'Settings',
      'appearance': 'Appearance',
      'dark_theme': 'Dark Theme',
      'dark_map_theme': 'Dark Map Theme',
      'notifications': 'Notifications',
      'notification_sound': 'Notification Sound',
      'vibration': 'Vibration',
      'background_notifications': 'Background Notifications',
      'earthquake_settings': 'Earthquake Settings',
      'notification_radius': 'Notification Radius',
      'min_magnitude': 'Minimum Magnitude',
      'max_magnitude': 'Maximum Magnitude',
      'location_settings': 'Location Settings',
      'share_location': 'Share Location with Friends',
      'location_update_interval': 'Location Update Interval',
      'earthquake_detection': 'Earthquake Detection Service',
      'earthquake_detection_desc': 'Detect earthquakes using device sensors',
      'whistle': 'Emergency Whistle',
      'whistle_desc': 'Loud whistle sound for emergencies',
      'play_whistle': 'Play Whistle',
      'stop_whistle': 'Stop Whistle',
      'battery_info': 'Battery Info',
      'app_settings': 'App Settings',

      // Earthquake Alert
      'earthquake_alert': 'EARTHQUAKE ALERT!',
      'earthquake_detected': 'Earthquake Detected',
      'take_cover': 'Take Cover!',
      'stay_safe': 'Stay Safe',
      'emergency_call': 'Emergency Call',
      'share_status': 'Share Status',
      'i_am_safe': 'I am Safe',
      'i_need_help': 'I Need Help',
      'report_earthquake': 'Report Earthquake',
      'take_cover_message': 'Get under a table or move to a safe place',

      // Report Screen
      'report': 'Report',
      'report_earthquake_title': 'Report Earthquake',
      'did_you_feel': 'Did you feel the earthquake?',
      'intensity': 'Intensity',
      'describe_experience': 'Describe your experience',
      'submit_report': 'Submit Report',
      'report_submitted': 'Report submitted successfully',
      'report_failed': 'Failed to submit report',
      'which_city': 'Which City',
      'search_city': 'Search city...',
      'select_city': 'Please select a city',
      'earthquake_reported': '{city} earthquake reported!',
      'report_button': 'Report',
      'estimated_magnitude': 'Estimated Magnitude',
      'selected': 'Selected',
      'no_results': 'No results found',

      // Login Screen
      'welcome': 'Welcome',
      'sign_in_google': 'Sign in with Google',
      'sign_in_email': 'Sign in with Email',
      'email': 'Email',
      'password': 'Password',
      'forgot_password': 'Forgot Password?',
      'no_account': 'Don\'t have an account?',
      'create_account': 'Create Account',

      // Error Messages
      'error_connection': 'Connection error. Please check your internet.',
      'error_location': 'Could not get location. Please enable GPS.',
      'error_permission':
          'Permission denied. Please grant the required permissions.',
      'error_login': 'Login failed. Please try again.',
      'error_unknown': 'An unknown error occurred.',

      // Notifications
      'notification_earthquake': 'Earthquake Alert',
      'notification_friend_request': 'New Friend Request',
      'notification_friend_safe': 'Friend Marked Safe',
      'notification_service_running': 'Earthquake monitoring active',
      'stop': 'Stop',

      // Additional Settings
      'earthquake_detection_service': 'Earthquake Detection Service',
      'earthquake_detection_enabled':
          'Earthquake detection service runs when device is charging.',
      'earthquake_detection_disabled':
          'Earthquake detection service is disabled.',
      'earthquake_filtering': 'Earthquake Filtering',
      'notification_settings': 'Notification Settings',
      'notification_sound_subtitle': 'Play sound for earthquake notifications',
      'vibration_subtitle': 'Vibrate for earthquake notifications',
      'background_notifications_subtitle':
          'Receive notifications when app is closed',
      'share_location_subtitle': 'Share your location with friends',
      'earthquake_filter_info':
          'Earthquakes between {min}-{max} are shown on map. You will receive notifications for earthquakes within {radius} km.',
      'notification_sound_on': 'Notification sound enabled',
      'notification_sound_off': 'Notification sound disabled',
      'vibration_on': 'Vibration enabled',
      'vibration_off': 'Vibration disabled',
      'background_notifications_on': 'Background notifications enabled',
      'background_notifications_off': 'Background notifications disabled',
      'background_service_stopped':
          '⚠️ Background service stopped - Notifications may not work',
      'background_service_started':
          '✅ Background service started - You will receive notifications even when app is closed',
      'background_service_failed': '❌ Failed to start background service',
      'background_active':
          'Active - You will receive notifications even when app is closed',
      'background_inactive':
          'Inactive - You will only receive notifications when app is open',
      'share_location_on': 'Location sharing enabled',
      'share_location_off': 'Location sharing disabled',
      'min_magnitude_set': 'Minimum magnitude: {value}',
      'max_magnitude_set': 'Maximum magnitude: {value}',
      'notification_radius_set': 'Notification radius: {value} km',
      'detection_enabled': 'Earthquake detection service enabled.',
      'detection_disabled': 'Earthquake detection service disabled.',
      'current_language': 'Current: English',
      'change_language': 'Tap to change language',

      // Whistle
      'emergency_whistle': 'Emergency Whistle',
      'emergency_whistle_desc': 'Loud whistle sound for emergencies',
      'whistle_playing': 'Whistle is playing. Tap to stop.',
      'whistle_stopped': 'Whistle stopped.',

      // Battery
      'battery_status': 'Battery Status',
      'battery_charging': 'Charging',
      'battery_discharging': 'Discharging',
      'battery_full': 'Full',
      'battery_unknown': 'Unknown',

      // Theme
      'theme_settings': 'Theme Settings',
      'use_dark_map': 'Use dark map theme',

      // Friends
      'friend_added': 'Friend added',
      'friend_removed': 'Friend removed',
      'request_sent': 'Friend request sent',
      'request_accepted': 'Friend request accepted',
      'request_rejected': 'Friend request rejected',
      'no_pending_requests': 'No pending requests',
      'add_friend_by_email': 'Add friend by email',
      'enter_email': 'Enter email address',

      // Earthquake Details
      'felt_it': 'I felt it',
      'share': 'Share',
      'navigate': 'Navigate',
      'more_info': 'More Info',
      'epicenter': 'Epicenter',
      'felt_reports': 'Felt Reports',
      'no_felt_reports': 'No felt reports yet',

      // Time
      'second_ago': 'second ago',
      'seconds_ago': 'seconds ago',
      'minute_ago': 'minute ago',
      'hour_ago': 'hour ago',
      'day_ago': 'day ago',
      'ago': 'ago',

      // Chat
      'login_required_chat': 'Please login to access chat',
      'loading_chat_rooms': 'Loading chat rooms...',
      'unnamed_room': 'Unnamed Room',
      'members': 'members',

      // Map
      'refresh': 'Refresh',
      'center_on_location': 'Center on my location',
      'loading_earthquakes': 'Loading earthquakes...',
      'no_earthquakes_in_range': 'No earthquakes in selected range',
      'total_earthquakes': 'Total: {count} earthquakes',

      // Tools
      'tools': 'Tools',
      'start': 'Start',
      'whistle_help': 'Use to signal your location when trapped under debris',
      'whistle_active': '🔊 Whistle is playing - Signal your location!',
      'whistle_warning': 'Whistle is playing! Help rescue teams find you.',
      'whistle_started': '🔊 Whistle started!',

      // Settings Details
      'dark_theme_active': 'Dark theme active',
      'light_theme_active': 'Light theme active',
      'dark_map_active': 'Dark map theme',
      'light_map_active': 'Light map theme',
      'auto_notification_service': 'Auto Notification Service',
      'auto_start_enabled': 'Service starts automatically on app launch',
      'auto_start_disabled': 'Service does not start automatically',
      'auto_notification_enabled': 'Auto notification service enabled.',
      'auto_notification_disabled': 'Auto notification service disabled.',
      'settings_auto_save':
          'Your settings are automatically saved and applied on next launch.',
      'language_selection': 'Language Selection',

      // Battery Optimization
      'battery_optimization': 'Battery Optimization',
      'battery_optimization_title': 'Battery Optimization Required',
      'battery_optimization_description':
          'Required for background earthquake monitoring to work properly',
      'battery_optimization_message':
          'For background notifications to work properly, you need to disable battery optimization for this app. Otherwise, the system may stop the app to save battery and you will miss earthquake notifications.',
      'battery_optimization_hint':
          'Select "Unrestricted" or "Don\'t optimize" in battery settings',
      'battery_optimization_still_on':
          '⚠️ Battery optimization is still active. Background notifications may not work properly.',
      'battery_optimization_disabled': 'Battery optimization disabled',
      'battery_optimization_enabled': 'Battery optimization active',
      'disable_battery_optimization': 'Disable Battery Optimization',
      'battery_optimization_success':
          'Battery optimization disabled successfully',
      'battery_optimization_failed':
          'Please disable battery optimization manually in settings',
      'later': 'Later',
      'open_settings': 'Open Settings',

      // Friends Screen Additional
      'user': 'User',
      'my_share_code': 'My Share Code',
      'friend_share_code': 'Friend Share Code',
      'copy': 'Copy',
      'share_code_copied': 'Share code copied',
      'enter_share_code': 'Please enter a share code',
      'share_code_length': 'Share code must be 6 characters',
      'data_load_failed': 'Data could not be loaded',
      'unknown': 'Unknown',
      'incoming_requests': 'Incoming',
      'outgoing_requests': 'Outgoing',
      'no_incoming_requests': 'No incoming requests',
      'no_outgoing_requests': 'No outgoing requests',
      'add_friend_hint': 'Add friends by entering share code above',
      'request_accept_failed': 'Could not accept request',
      'request_reject_failed': 'Could not reject request',
      'remove': 'Remove',
      'remove_friend_title': 'Remove Friend',
      'remove_friend_confirm': 'Remove {name} from friends?',
      'friend_removed_success': '{name} removed from friends',
      'friend_remove_failed': 'Could not remove friend',
      'waiting_for_approval': 'Waiting for approval',

      // History Screen
      'filter_all': 'All',
      'filter_today': 'Today',
      'filter_this_week': 'This Week',
      'filter_this_month': 'This Month',
      'no_earthquake_records': 'No earthquake records found',
      'unknown_location': 'Unknown Location',
      'intensity_severe': 'Severe',
      'intensity_noticeable': 'Noticeable',
      'intensity_light': 'Light',
      'intensity_very_light': 'Very Light',
      'min_ago': 'min ago',
      'hours_ago_short': 'hours ago',
      'magnitude_label': 'Magnitude',
      'distance_label': 'Distance',

      // Map Screen Additional
      'latest_earthquake': 'Latest Earthquake',
      'earthquakes': 'Earthquakes',
      'assembly_areas': 'Assembly Areas',
      //'friends': 'Friends',
      'fault_lines': 'Fault Lines',

      // Navigation
      'chat_rooms': 'Chat Rooms',
      'past_earthquakes': 'Past Earthquakes',
      'chat': 'Chat',
      'history': 'History',
      'map_refreshed': 'Map refreshed',

      // Months
      'month_january': 'January',
      'month_february': 'February',
      'month_march': 'March',
      'month_april': 'April',
      'month_may': 'May',
      'month_june': 'June',
      'month_july': 'July',
      'month_august': 'August',
      'month_september': 'September',
      'month_october': 'October',
      'month_november': 'November',
      'month_december': 'December',

      // Days
      'day_monday': 'Monday',
      'day_tuesday': 'Tuesday',
      'day_wednesday': 'Wednesday',
      'day_thursday': 'Thursday',
      'day_friday': 'Friday',
      'day_saturday': 'Saturday',
      'day_sunday': 'Sunday',

      // Magnitude descriptions
      'mag_micro': 'Micro earthquake',
      'mag_very_light': 'Very light',
      'mag_light': 'Light',
      'mag_medium': 'Medium',
      'mag_strong': 'Strong',
      'mag_very_strong': 'Very strong',
      'mag_destructive': 'Destructive',

      // Map additional
      'unknown_user': 'Unknown',
      'capacity': 'Capacity',
      'type': 'Type',
      'persons': 'persons',
      'invalid_timestamp': 'Invalid timestamp type',
      'no_date_info': 'No date info',

      // Chat additional
      'no_messages_yet': 'No messages yet',
      'no_active_users': 'No active users yet',
      'active_users': 'Active Users',
      'send_first_message': 'Send the first message! 👋',

      // Alarm
      'take_shelter': 'TAKE SHELTER',
      'magnitude_display': 'MAGNITUDE',

      // Sensor
      'no_saved_sessions': 'No saved sessions',
      'export': 'Export',
      'delete_all': 'Delete All',
      'no_recordings': 'No recordings yet',

      // Settings Page Additional
      'allow_notifications': 'Allow Notifications',
      'receive_earthquake_notifications': 'Receive earthquake notifications',
      'minimum_magnitude': 'Minimum Magnitude',
      'between_mw': 'Between {min}-{max} Mw',
      'notification_radius_setting': 'Notification Radius',
      'earthquakes_within_km': 'Earthquakes within {radius} km',
      'sound_alert': 'Sound Alert',
      'device_vibrate': 'Vibrate device',
      'share_location_with_friends': 'Share Location with Friends',
      'update_location_every_2_hours': 'Update location every 2 hours',
      'location_services': 'Location Services',
      'show_nearby_earthquakes': 'Show nearby earthquakes',
      'background_refresh': 'Background Refresh',
      'update_data_when_closed': 'Update data when app is closed',
      'clear_cache': 'Clear Cache',
      'delete_stored_data': 'Delete stored data',
      'rate_us': 'Rate Us',
      'rate_on_app_store': 'Rate on App Store',
      'go_pro': 'Go Pro',
      'unlock_all_features': 'Unlock all features',
      'about_app': 'About App',
      'terms_and_privacy': 'Terms of use and privacy',
      'report_bug': 'Report Bug',
      'having_issues': 'Having issues?',
      'account': 'Account',
      'logout_from_account': 'Logout from your account',
      'other': 'Other',
      'earthquake_magnitude_range': 'Earthquake Magnitude Range',
      'minimum': 'Minimum',
      'maximum': 'Maximum',
      'earthquakes_between_shown':
          'Earthquakes between {min}-{max} Mw will be shown',
      'magnitude_range_set': 'Magnitude range set to {min}-{max}',
      'rate_us_title': 'Rate Us',
      'do_you_like_app':
          'Do you like Earthquake Line? You can support us by rating on App Store!',
      'later': 'Later',
      'rate': 'Rate',
      'opening_app_store': 'Opening App Store...',
      'pro_version': 'Pro Version',
      'pro_features': 'Pro features:',
      'ad_free': '🚫 Ad-free experience',
      'detailed_analysis': '📊 Detailed earthquake analysis',
      'priority_notifications': '🔔 Priority notifications',
      'advanced_location': '📍 Advanced location tracking',
      'historical_analysis': '📈 Historical data analysis',
      'custom_themes': '🎨 Custom themes',
      'per_year': '/ Year',
      'purchase': 'Purchase',
      'starting_purchase': 'Starting purchase...',
      'how_far_notifications': 'How far do you want to receive notifications?',
      'between_km': 'Between 10 km - 1000 km',
      'radius_set': 'Notification radius set to {radius} km',
      'your_location_shared': 'Your location is being shared with friends',
      'location_sharing_off': 'Location sharing disabled',
      'clear_cache_title': 'Clear Cache',
      'clear_cache_confirm':
          'All cached data will be deleted. Do you want to continue?',
      'cache_cleared': 'Cache cleared',
      'clear': 'Clear',
      'earthquake_line': 'Earthquake Line',
      'comprehensive_app':
          'Turkey\'s most comprehensive earthquake tracking app',
      'all_rights_reserved': 'All rights reserved.',
      'logout_title': 'Logout',
      'logout_confirm': 'Are you sure you want to logout?',
      'logged_out': 'Logged out',
      'bug_report_opening': 'Opening bug report form...',
      'whistle_play': 'Play Whistle',
      'whistle_playing_signal': '🔊 Whistle is playing - Signal your location!',
      'whistle_use_debris':
          'Use to signal your location when trapped under debris',
      'whistle_help_rescue': 'Whistle is playing! Help rescue teams find you.',
      'version_text': 'Version',
      'build_text': 'Build',

      // Location Permission Dialog
      'backgroundLocationTitle': 'Background Location Permission Required',
      'locationPermissionTitle': 'Location Permission Required',
      'backgroundLocationMessage':
          'This app wants to access your location data in the background for the earthquake early warning system.',
      'locationPermissionMessage':
          'This app wants to access your location data to show you the nearest earthquake information.',
      'backgroundLocationReason1':
          'Earthquake detection even when app is closed',
      'backgroundLocationReason2':
          'Location-specific real-time earthquake alerts',
      'backgroundLocationReason3':
          'Participate in P2P earthquake detection network',
      'locationReason1': 'Show nearest earthquakes to you',
      'locationReason2': 'Location-based earthquake notifications',
      'locationReason3': 'Show your location on earthquake map',
      'locationPrivacyNote':
          'Your location data is only used for the earthquake early warning system and is not shared with third parties.',
      'backgroundLocationNote':
          'Note: You will need to select "Allow all the time" option on the next screen.',
      'deny': 'Deny',
      'allow': 'Allow',
    },
    'tr': {
      // App General
      'app_name': 'Deprem Hattı',
      'loading': 'Yükleniyor...',
      'error': 'Hata',
      'success': 'Başarılı',
      'cancel': 'İptal',
      'save': 'Kaydet',
      'delete': 'Sil',
      'edit': 'Düzenle',
      'close': 'Kapat',
      'ok': 'Tamam',
      'yes': 'Evet',
      'no': 'Hayır',
      'retry': 'Tekrar Dene',
      'back': 'Geri',
      'next': 'İleri',
      'done': 'Bitti',
      'search': 'Ara',
      'settings': 'Ayarlar',
      'logout': 'Çıkış Yap',
      'login': 'Giriş Yap',
      'register': 'Kayıt Ol',

      // Language Selection
      'select_language': 'Dil Seçin',
      'language': 'Dil',
      'turkish': 'Türkçe',
      'english': 'İngilizce',
      'language_changed': 'Dil değiştirildi',
      'welcome_select_language': 'Hoş geldiniz! Lütfen dilinizi seçin',
      'continue_text': 'Devam Et',

      // Bottom Navigation
      'nav_map': 'Harita',
      'nav_list': 'Liste',
      'nav_friends': 'Arkadaşlar',
      'nav_profile': 'Profil',

      // Map Screen
      'earthquake_map': 'Deprem Haritası',
      'show_fault_lines': 'Fay Hatlarını Göster',
      'hide_fault_lines': 'Fay Hatlarını Gizle',
      'show_friends': 'Arkadaşları Göster',
      'hide_friends': 'Arkadaşları Gizle',
      'my_location': 'Konumum',
      'earthquake_details': 'Deprem Detayları',
      'earthquake_info': 'Deprem Bilgisi',
      'magnitude': 'Büyüklük',
      'depth': 'Derinlik',
      'distance': 'Uzaklık',
      'location': 'Konum',
      'time': 'Zaman',
      'source': 'Kaynak',
      'km': 'km',
      'km_away': 'km uzakta',
      'minutes_ago': 'dakika önce',
      'hours_ago': 'saat önce',
      'days_ago': 'gün önce',
      'just_now': 'Az önce',

      // Earthquake List
      'earthquake_list': 'Deprem Listesi',
      'no_earthquakes': 'Deprem bulunamadı',
      'last_24_hours': 'Son 24 Saat',
      'last_week': 'Son Hafta',
      'last_month': 'Son Ay',
      'all_earthquakes': 'Tüm Depremler',
      'filter': 'Filtrele',
      'sort_by': 'Sırala',
      'newest_first': 'En Yeni',
      'oldest_first': 'En Eski',
      'highest_magnitude': 'En Büyük',
      'nearest_first': 'En Yakın',

      // Friends Screen
      'friends': 'Arkadaşlar',
      'add_friend': 'Arkadaş Ekle',
      'friend_requests': 'Arkadaşlık İstekleri',
      'pending_requests': 'Bekleyen İstekler',
      'no_friends': 'Henüz arkadaşınız yok',
      'search_friends': 'Arkadaş ara...',
      'send_request': 'İstek Gönder',
      'accept': 'Kabul Et',
      'reject': 'Reddet',
      'remove_friend': 'Arkadaşı Kaldır',
      'friend_location': 'Arkadaş Konumu',
      'last_seen': 'Son görülme',
      'online': 'Çevrimiçi',
      'offline': 'Çevrimdışı',

      // Profile Screen
      'profile': 'Profil',
      'edit_profile': 'Profili Düzenle',
      'my_reports': 'Raporlarım',
      'notification_history': 'Bildirim Geçmişi',
      'emergency_contacts': 'Acil Durum Kişileri',
      'help_support': 'Yardım ve Destek',
      'about': 'Hakkında',
      'privacy_policy': 'Gizlilik Politikası',
      'terms_of_service': 'Kullanım Koşulları',
      'version': 'Sürüm',

      // Settings Screen
      'settings_title': 'Ayarlar',
      'appearance': 'Görünüm',
      'dark_theme': 'Karanlık Tema',
      'dark_map_theme': 'Karanlık Harita Teması',
      'notifications': 'Bildirimler',
      'notification_sound': 'Bildirim Sesi',
      'vibration': 'Titreşim',
      'background_notifications': 'Arka Plan Bildirimleri',
      'earthquake_settings': 'Deprem Ayarları',
      'notification_radius': 'Bildirim Yarıçapı',
      'min_magnitude': 'Minimum Büyüklük',
      'max_magnitude': 'Maksimum Büyüklük',
      'location_settings': 'Konum Ayarları',
      'share_location': 'Arkadaşlarla Konumu Paylaş',
      'location_update_interval': 'Konum Güncelleme Aralığı',
      'earthquake_detection': 'Deprem Algılama Servisi',
      'earthquake_detection_desc': 'Cihaz sensörleriyle deprem algıla',
      'whistle': 'Acil Durum Düdüğü',
      'whistle_desc': 'Acil durumlar için yüksek sesli düdük',
      'play_whistle': 'Düdüğü Çal',
      'stop_whistle': 'Düdüğü Durdur',
      'battery_info': 'Batarya Bilgisi',
      'app_settings': 'Uygulama Ayarları',

      // Earthquake Alert
      'earthquake_alert': 'DEPREM UYARISI!',
      'earthquake_detected': 'Deprem Algılandı',
      'take_cover': 'Güvenli Yere Geçin!',
      'stay_safe': 'Güvende Kalın',
      'emergency_call': 'Acil Arama',
      'share_status': 'Durum Paylaş',
      'i_am_safe': 'Güvendeyim',
      'i_need_help': 'Yardıma İhtiyacım Var',
      'report_earthquake': 'Deprem Bildir',
      'take_cover_message': 'Masa altına girin veya güvenli bir yere geçin',

      // Report Screen
      'report': 'Rapor',
      'report_earthquake_title': 'Deprem Bildir',
      'did_you_feel': 'Depremi hissettiniz mi?',
      'intensity': 'Şiddet',
      'describe_experience': 'Deneyiminizi açıklayın',
      'submit_report': 'Raporu Gönder',
      'report_submitted': 'Rapor başarıyla gönderildi',
      'report_failed': 'Rapor gönderilemedi',
      'which_city': 'Hangi İldesin',
      'search_city': 'Şehir arayınız...',
      'select_city': 'Lütfen bir şehir seçiniz',
      'earthquake_reported': '{city} bölgesinde deprem bildirildi!',
      'report_button': 'Bildir',
      'estimated_magnitude': 'Tahmini Büyüklük',
      'selected': 'Seçili',
      'no_results': 'Sonuç bulunamadı',

      // Login Screen
      'welcome': 'Hoş Geldiniz',
      'sign_in_google': 'Google ile Giriş Yap',
      'sign_in_email': 'E-posta ile Giriş Yap',
      'email': 'E-posta',
      'password': 'Şifre',
      'forgot_password': 'Şifremi Unuttum',
      'no_account': 'Hesabınız yok mu?',
      'create_account': 'Hesap Oluştur',

      // Error Messages
      'error_connection': 'Bağlantı hatası. Lütfen internetinizi kontrol edin.',
      'error_location': 'Konum alınamadı. Lütfen GPS\'i açın.',
      'error_permission': 'İzin reddedildi. Lütfen gerekli izinleri verin.',
      'error_login': 'Giriş başarısız. Lütfen tekrar deneyin.',
      'error_unknown': 'Bilinmeyen bir hata oluştu.',

      // Notifications
      'notification_earthquake': 'Deprem Uyarısı',
      'notification_friend_request': 'Yeni Arkadaşlık İsteği',
      'notification_friend_safe': 'Arkadaş Güvende',
      'notification_service_running': 'Deprem hattı izliyor',
      'stop': 'Durdur',

      // Additional Settings
      'earthquake_detection_service': 'Deprem Algılama Servisi',
      'earthquake_detection_enabled':
          'Cihaz şarjda olduğunda deprem algılama servisi çalışır.',
      'earthquake_detection_disabled': 'Deprem algılama servisi devre dışı.',
      'earthquake_filtering': 'Deprem Filtreleme',
      'notification_settings': 'Bildirim Ayarları',
      'notification_sound_subtitle': 'Deprem bildirimlerinde ses çal',
      'vibration_subtitle': 'Deprem bildirimlerinde titret',
      'background_notifications_subtitle': 'Uygulama kapalıyken bildirim al',
      'share_location_subtitle': 'Arkadaşlarınızla konumunuzu paylaşın',
      'earthquake_filter_info':
          'Haritada {min}-{max} arası depremler gösterilir. {radius} km içindeki depremlerden bildirim alırsınız.',
      'notification_sound_on': 'Bildirim sesi açıldı',
      'notification_sound_off': 'Bildirim sesi kapatıldı',
      'vibration_on': 'Titreşim açıldı',
      'vibration_off': 'Titreşim kapatıldı',
      'background_notifications_on': 'Arka plan bildirimleri açıldı',
      'background_notifications_off': 'Arka plan bildirimleri kapatıldı',
      'background_service_stopped':
          '⚠️ Arka plan servisi durduruldu - Bildirimler çalışmayabilir',
      'background_service_started':
          '✅ Arka plan servisi başlatıldı - Uygulama kapalıyken bile bildirim alacaksınız',
      'background_service_failed': '❌ Arka plan servisi başlatılamadı',
      'background_active':
          'Aktif - Uygulama kapalıyken bile bildirim alırsınız',
      'background_inactive':
          'Kapalı - Sadece uygulama açıkken bildirim alırsınız',
      'share_location_on': 'Konum paylaşma açıldı',
      'share_location_off': 'Konum paylaşma kapatıldı',
      'min_magnitude_set': 'Minimum büyüklük: {value}',
      'max_magnitude_set': 'Maksimum büyüklük: {value}',
      'notification_radius_set': 'Bildirim yarıçapı: {value} km',
      'detection_enabled': 'Deprem algılama servisi etkinleştirildi.',
      'detection_disabled': 'Deprem algılama servisi devre dışı bırakıldı.',
      'current_language': 'Mevcut: Türkçe',
      'change_language': 'Dili değiştirmek için dokunun',

      // Whistle
      'emergency_whistle': 'Acil Durum Düdüğü',
      'emergency_whistle_desc': 'Acil durumlar için yüksek sesli düdük',
      'whistle_playing': 'Düdük çalıyor. Durdurmak için dokunun.',
      'whistle_stopped': 'Düdük durduruldu.',

      // Battery
      'battery_status': 'Batarya Durumu',
      'battery_charging': 'Şarj oluyor',
      'battery_discharging': 'Şarj olmuyor',
      'battery_full': 'Tam dolu',
      'battery_unknown': 'Bilinmiyor',

      // Theme
      'theme_settings': 'Tema Ayarları',
      'use_dark_map': 'Karanlık harita teması kullan',

      // Friends
      'friend_added': 'Arkadaş eklendi',
      'friend_removed': 'Arkadaş kaldırıldı',
      'request_sent': 'Arkadaşlık isteği gönderildi',
      'request_accepted': 'Arkadaşlık isteği kabul edildi',
      'request_rejected': 'Arkadaşlık isteği reddedildi',
      'no_pending_requests': 'Bekleyen istek yok',
      'add_friend_by_email': 'E-posta ile arkadaş ekle',
      'enter_email': 'E-posta adresi girin',

      // Earthquake Details
      'felt_it': 'Hissettim',
      'share': 'Paylaş',
      'navigate': 'Yol Tarifi',
      'more_info': 'Daha Fazla',
      'epicenter': 'Merkez Üssü',
      'felt_reports': 'Hissedilme Raporları',
      'no_felt_reports': 'Henüz hissedilme raporu yok',

      // Time
      'second_ago': 'saniye önce',
      'seconds_ago': 'saniye önce',
      'minute_ago': 'dakika önce',
      'hour_ago': 'saat önce',
      'day_ago': 'gün önce',
      'ago': 'önce',

      // Chat
      'login_required_chat': 'Sohbet için giriş yapmanız gerekiyor',
      'loading_chat_rooms': 'Chat odaları yükleniyor...',
      'unnamed_room': 'Adsız Oda',
      'members': 'üye',

      // Map
      'refresh': 'Yenile',
      'center_on_location': 'Konumuma odakla',
      'loading_earthquakes': 'Depremler yükleniyor...',
      'no_earthquakes_in_range': 'Seçili aralıkta deprem yok',
      'total_earthquakes': 'Toplam: {count} deprem',

      // Tools
      'tools': 'Araçlar',
      'start': 'Başlat',
      'whistle_help': 'Enkaz altındayken yerini belli etmek için kullan',
      'whistle_active': '🔊 Düdük çalıyor - Yerini belli et!',
      'whistle_warning':
          'Düdük sesi çalıyor! Kurtarma ekiplerinin sizi bulmasına yardımcı olun.',
      'whistle_started': '🔊 Düdük çalmaya başladı!',

      // Settings Details
      'dark_theme_active': 'Koyu tema aktif',
      'light_theme_active': 'Açık tema aktif',
      'dark_map_active': 'Koyu harita teması',
      'light_map_active': 'Açık harita teması',
      'auto_notification_service': 'Otomatik Bildirim Servisi',
      'auto_start_enabled': 'Uygulama girişinde servis otomatik başlatılır',
      'auto_start_disabled': 'Servis otomatik başlatılmaz',
      'auto_notification_enabled': 'Otomatik bildirim servisi etkinleştirildi.',
      'auto_notification_disabled':
          'Otomatik bildirim servisi devre dışı bırakıldı.',
      'settings_auto_save':
          'Ayarlarınız otomatik olarak kaydedilir ve bir sonraki açılışta uygulanır.',
      'language_selection': 'Dil Seçimi',

      // Battery Optimization
      'battery_optimization': 'Pil Optimizasyonu',
      'battery_optimization_title': 'Pil Optimizasyonu Gerekli',
      'battery_optimization_description':
          'Arka planda deprem izlemenin düzgün çalışması için gerekli',
      'battery_optimization_message':
          'Arka plan bildirimlerinin düzgün çalışması için bu uygulama için pil optimizasyonunu devre dışı bırakmanız gerekiyor. Aksi takdirde sistem pil tasarrufu için uygulamayı durdurabiliyor ve deprem bildirimlerini kaçırabilirsiniz.',
      'battery_optimization_hint':
          'Pil ayarlarında "Kısıtlanmamış" veya "Optimize etme" seçeneğini seçin',
      'battery_optimization_still_on':
          '⚠️ Pil optimizasyonu hala aktif. Arka plan bildirimleri düzgün çalışmayabilir.',
      'battery_optimization_disabled': 'Pil optimizasyonu devre dışı',
      'battery_optimization_enabled': 'Pil optimizasyonu aktif',
      'disable_battery_optimization': 'Pil Optimizasyonunu Devre Dışı Bırak',
      'battery_optimization_success':
          'Pil optimizasyonu başarıyla devre dışı bırakıldı',
      'battery_optimization_failed':
          'Lütfen pil optimizasyonunu ayarlardan manuel olarak devre dışı bırakın',
      'later': 'Sonra',
      'open_settings': 'Ayarları Aç',

      // Friends Screen Additional
      'user': 'Kullanıcı',
      'my_share_code': 'Benim Share Code\'um',
      'friend_share_code': 'Arkadaş Share Code',
      'copy': 'Kopyala',
      'share_code_copied': 'Share code kopyalandı',
      'enter_share_code': 'Lütfen bir share code girin',
      'share_code_length': 'Share code 6 karakter olmalıdır',
      'data_load_failed': 'Veriler yüklenemedi',
      'unknown': 'Bilinmeyen',
      'incoming_requests': 'Gelen',
      'outgoing_requests': 'Giden',
      'no_incoming_requests': 'Gelen istek yok',
      'no_outgoing_requests': 'Giden istek yok',
      'add_friend_hint': 'Yukarıdan share code girerek arkadaş ekleyin',
      'request_accept_failed': 'İstek kabul edilemedi',
      'request_reject_failed': 'İstek reddedilemedi',
      'remove': 'Kaldır',
      'remove_friend_title': 'Arkadaşı Kaldır',
      'remove_friend_confirm': '{name} arkadaşlarınızdan kaldırılsın mı?',
      'friend_removed_success': '{name} arkadaşlarınızdan kaldırıldı',
      'friend_remove_failed': 'Arkadaş kaldırılamadı',
      'waiting_for_approval': 'Onay bekleniyor',

      // History Screen
      'filter_all': 'Tümü',
      'filter_today': 'Bugün',
      'filter_this_week': 'Bu Hafta',
      'filter_this_month': 'Bu Ay',
      'no_earthquake_records': 'Deprem kaydı bulunamadı',
      'unknown_location': 'Bilinmeyen Konum',
      'intensity_severe': 'Şiddetli',
      'intensity_noticeable': 'Belirgin',
      'intensity_light': 'Hafif',
      'intensity_very_light': 'Çok Hafif',
      'min_ago': 'dk önce',
      'hours_ago_short': 'saat önce',
      'magnitude_label': 'Büyüklük',
      'distance_label': 'Mesafe',

      // Map Screen Additional
      'latest_earthquake': 'Son Deprem',
      'earthquakes': 'Depremler',
      'assembly_areas': 'Toplanma Alanları',
      //'friends': 'Arkadaşlar',
      'fault_lines': 'Fay Hatları',

      // Navigation
      'chat_rooms': 'Sohbet Odaları',
      'past_earthquakes': 'Geçmiş Depremler',
      'chat': 'Sohbet',
      'history': 'Geçmiş',
      'map_refreshed': 'Harita yenilendi',

      // Months
      'month_january': 'Ocak',
      'month_february': 'Şubat',
      'month_march': 'Mart',
      'month_april': 'Nisan',
      'month_may': 'Mayıs',
      'month_june': 'Haziran',
      'month_july': 'Temmuz',
      'month_august': 'Ağustos',
      'month_september': 'Eylül',
      'month_october': 'Ekim',
      'month_november': 'Kasım',
      'month_december': 'Aralık',

      // Days
      'day_monday': 'Pazartesi',
      'day_tuesday': 'Salı',
      'day_wednesday': 'Çarşamba',
      'day_thursday': 'Perşembe',
      'day_friday': 'Cuma',
      'day_saturday': 'Cumartesi',
      'day_sunday': 'Pazar',

      // Magnitude descriptions
      'mag_micro': 'Mikro deprem',
      'mag_very_light': 'Çok hafif',
      'mag_light': 'Hafif',
      'mag_medium': 'Orta',
      'mag_strong': 'Kuvvetli',
      'mag_very_strong': 'Çok kuvvetli',
      'mag_destructive': 'Yıkıcı',

      // Map additional
      'unknown_user': 'Bilinmeyen',
      'capacity': 'Kapasite',
      'type': 'Tür',
      'persons': 'kişi',
      'invalid_timestamp': 'Geçersiz timestamp tipi',
      'no_date_info': 'Tarih bilgisi yok',

      // Chat additional
      'no_messages_yet': 'Henüz mesaj yok',
      'no_active_users': 'Henüz aktif kullanıcı yok',
      'active_users': 'Aktif Kullanıcılar',
      'send_first_message': 'İlk mesajı siz gönderin! 👋',

      // Alarm
      'take_shelter': 'SIĞINAK ALIN',
      'magnitude_display': 'BÜYÜKLÜK',

      // Sensor
      'no_saved_sessions': 'Kaydedilmiş oturum yok',
      'export': 'Dışa Aktar',
      'delete_all': 'Tümünü Sil',
      'no_recordings': 'Henüz kayıt yok',

      // Settings Page Additional
      'allow_notifications': 'Bildirimlere İzin Ver',
      'receive_earthquake_notifications': 'Deprem bildirimleri al',
      'minimum_magnitude': 'Minimum Büyüklük',
      'between_mw': '{min}-{max} Mw arası',
      'notification_radius_setting': 'Bildirim Yarıçapı',
      'earthquakes_within_km': '{radius} km içindeki depremler',
      'sound_alert': 'Bildirim Sesi',
      'device_vibrate': 'Cihazı titret',
      'share_location_with_friends': 'Konumumu Arkadaşlarla Paylaş',
      'update_location_every_2_hours': '2 saatte bir konum güncelle',
      'location_services': 'Konum Servisleri',
      'show_nearby_earthquakes': 'Konumunuza yakın depremleri göster',
      'background_refresh': 'Arka Plan Yenileme',
      'update_data_when_closed': 'Uygulama kapalıyken veri güncelle',
      'clear_cache': 'Önbelleği Temizle',
      'delete_stored_data': 'Depolanan verileri sil',
      'rate_us': 'Bizi Puanla',
      'rate_on_app_store': 'App Store\'da değerlendir',
      'go_pro': 'Pro Sürüme Geç',
      'unlock_all_features': 'Tüm özelliklerin kilidini aç',
      'about_app': 'Uygulama Hakkında',
      'terms_and_privacy': 'Kullanım şartları ve gizlilik',
      'report_bug': 'Hata Bildir',
      'having_issues': 'Sorun mu yaşıyorsunuz?',
      'account': 'Hesap',
      'logout_from_account': 'Hesabınızdan çıkış yapın',
      'other': 'Diğer',
      'earthquake_magnitude_range': 'Deprem Büyüklük Aralığı',
      'minimum': 'Minimum',
      'maximum': 'Maksimum',
      'earthquakes_between_shown':
          '{min}-{max} Mw arası depremler gösterilecek',
      'magnitude_range_set': 'Büyüklük aralığı {min}-{max} olarak ayarlandı',
      'rate_us_title': 'Bizi Değerlendirin',
      'do_you_like_app':
          'Deprem Hattı\'nı beğendiniz mi? App Store\'da değerlendirerek bizi destekleyebilirsiniz!',
      'later': 'Daha Sonra',
      'rate': 'Değerlendir',
      'opening_app_store': 'App Store açılıyor...',
      'pro_version': 'Pro Sürüm',
      'pro_features': 'Pro özellikler:',
      'ad_free': '🚫 Reklamsız deneyim',
      'detailed_analysis': '📊 Detaylı deprem analizi',
      'priority_notifications': '🔔 Öncelikli bildirimler',
      'advanced_location': '📍 Gelişmiş konum takibi',
      'historical_analysis': '📈 Geçmiş veri analizi',
      'custom_themes': '🎨 Özel temalar',
      'per_year': '/ Yıl',
      'purchase': 'Satın Al',
      'starting_purchase': 'Satın alma işlemi başlatılıyor...',
      'how_far_notifications':
          'Kaç km içindeki depremlerden bildirim almak istersiniz?',
      'between_km': '10 km - 1000 km arası',
      'radius_set': 'Bildirim yarıçapı {radius} km olarak ayarlandı',
      'your_location_shared': 'Konumunuz arkadaşlarınızla paylaşılıyor',
      'location_sharing_off': 'Konum paylaşımı kapatıldı',
      'clear_cache_title': 'Önbelleği Temizle',
      'clear_cache_confirm':
          'Tüm önbelleğe alınmış veriler silinecek. Devam etmek istiyor musunuz?',
      'cache_cleared': 'Önbellek temizlendi',
      'clear': 'Temizle',
      'earthquake_line': 'Deprem Hattı',
      'comprehensive_app': 'Türkiye\'nin en kapsamlı deprem takip uygulaması',
      'all_rights_reserved': 'Tüm hakları saklıdır.',
      'logout_title': 'Çıkış Yap',
      'logout_confirm': 'Hesabınızdan çıkış yapmak istediğinize emin misiniz?',
      'logged_out': 'Çıkış yapıldı',
      'bug_report_opening': 'Hata bildirimi formu açılıyor...',
      'whistle_play': 'Düdük Çal',
      'whistle_playing_signal': '🔊 Düdük çalıyor - Yerini belli et!',
      'whistle_use_debris': 'Enkaz altındayken yerini belli etmek için kullan',
      'whistle_help_rescue':
          'Düdük sesi çalıyor! Kurtarma ekiplerinin sizi bulmasına yardımcı olun.',
      'version_text': 'Versiyon',
      'build_text': 'Build',

      // Konum İzni Dialog
      'backgroundLocationTitle': 'Arka Plan Konum İzni Gerekiyor',
      'locationPermissionTitle': 'Konum İzni Gerekiyor',
      'backgroundLocationMessage':
          'Bu uygulama, deprem erken uyarı sistemi için arka planda konum verilerinize erişmek istiyor.',
      'locationPermissionMessage':
          'Bu uygulama, size en yakın deprem bilgilerini göstermek için konum verilerinize erişmek istiyor.',
      'backgroundLocationReason1': 'Uygulama kapalıyken bile deprem algılama',
      'backgroundLocationReason2': 'Konumunuza özel anlık deprem uyarıları',
      'backgroundLocationReason3': 'P2P deprem algılama ağına katılma',
      'locationReason1': 'Size en yakın depremleri gösterme',
      'locationReason2': 'Konumunuza özel deprem bildirimleri',
      'locationReason3': 'Deprem haritasında konumunuzu gösterme',
      'locationPrivacyNote':
          'Konum verileriniz yalnızca deprem erken uyarı sistemi için kullanılır ve üçüncü taraflarla paylaşılmaz.',
      'backgroundLocationNote':
          'Not: Sonraki ekranda "Her zaman izin ver" seçeneğini seçmeniz gerekecektir.',
      'deny': 'Reddet',
      'allow': 'İzin Ver',
    },
  };

  String get(String key) {
    final langCode = locale.languageCode;

    // Debug only for specific key
    if (key == 'share_location_with_friends') {
      print('🔍 get($key) - langCode: $langCode');
      print(
          '🔍 _localizedValues has en: ${_localizedValues.containsKey('en')}');
      print(
          '🔍 _localizedValues has tr: ${_localizedValues.containsKey('tr')}');
      print('🔍 en has key $key: ${_localizedValues['en']?.containsKey(key)}');
      print('🔍 tr has key $key: ${_localizedValues['tr']?.containsKey(key)}');
      print('🔍 en value: ${_localizedValues['en']?[key]}');
      print('🔍 tr value: ${_localizedValues['tr']?[key]}');
    }

    final result =
        _localizedValues[langCode]?[key] ?? _localizedValues['en']?[key] ?? key;

    return result;
  }

  // Convenience getters for common strings
  String get appName => get('app_name');
  String get loading => get('loading');
  String get error => get('error');
  String get success => get('success');
  String get cancel => get('cancel');
  String get save => get('save');
  String get close => get('close');
  String get ok => get('ok');
  String get settings => get('settings');
  String get language => get('language');
  String get selectLanguage => get('select_language');

  // Location Permission Dialog getters
  String get backgroundLocationTitle => get('backgroundLocationTitle');
  String get locationPermissionTitle => get('locationPermissionTitle');
  String get backgroundLocationMessage => get('backgroundLocationMessage');
  String get locationPermissionMessage => get('locationPermissionMessage');
  String get backgroundLocationReason1 => get('backgroundLocationReason1');
  String get backgroundLocationReason2 => get('backgroundLocationReason2');
  String get backgroundLocationReason3 => get('backgroundLocationReason3');
  String get locationReason1 => get('locationReason1');
  String get locationReason2 => get('locationReason2');
  String get locationReason3 => get('locationReason3');
  String get locationPrivacyNote => get('locationPrivacyNote');
  String get backgroundLocationNote => get('backgroundLocationNote');
  String get deny => get('deny');
  String get allow => get('allow');
}

class _AppLocalizationsDelegate
    extends LocalizationsDelegate<AppLocalizations> {
  const _AppLocalizationsDelegate();

  @override
  bool isSupported(Locale locale) {
    return ['en', 'tr'].contains(locale.languageCode);
  }

  @override
  Future<AppLocalizations> load(Locale locale) async {
    return AppLocalizations(locale);
  }

  @override
  bool shouldReload(_AppLocalizationsDelegate old) => false;
}
