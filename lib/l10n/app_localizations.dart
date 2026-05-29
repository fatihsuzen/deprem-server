import 'package:flutter/material.dart';

class AppLocalizations {
  String get appTitle => get('app_name');
  String get loginSubtitle => get('welcome_select_language');
  String get loginWithGoogle => get('sign_in_google');
  String get continueAsGuest => get('continue_as_guest');
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
      'download': 'Download',
      'tiles': 'tiles',
      'keep_app_open': 'Do not close the app during download.',

      // Language Selection
      'select_language': 'Select Language',
      'language': 'Language',
      'turkish': 'Turkish',
      'english': 'English',
      'spanish': 'Spanish',
      'hindi': 'Hindi',
      'filipino': 'Filipino',
      'myanmar': 'Myanmar',
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
      'alert_take_cover_now': 'TAKE COVER NOW!',
      'alert_be_prepared': 'BE PREPARED!',
      'shaking_arriving_in': 'Shaking in {n} s',

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

      // Language Selection
      'please_select_language': 'Please select your language',

      // Offline Map
      'download_offline_map': 'Download Offline Map',
      'offline_map_status_checking': 'Checking...',
      'offline_map_downloading': 'Downloading',
      'offline_map_downloaded': 'Downloaded',
      'offline_map_description': '300 km radius, zoom 6-14 (~50 MB)',
      'offline_map_download_failed': 'Map download failed',
      'offline_map_redownload_info': 'tiles - tap to re-download',

      // Friends Screen
      'please_enter_friend_code': 'Please enter friend code',
      'friend_request_sent': 'Friend request sent!',
      'show_location': 'Show Location',
      'remove_friendship': 'Remove Friend',
      'reject': 'Reject',
      'accept': 'Accept',
      'code_copied': 'Code copied!',
      'remove_from_friends': 'Remove from Friends',
      'remove': 'Remove',
      'friend_removed': 'Removed from friend list',
      'close': 'Close',
      'show_on_map': 'Show on Map',
      'map_feature_coming_soon': 'Map feature coming soon',
      'last_update': 'Last update',
      'coordinates': 'Coordinates',
      'friend_request_accepted': 'Friend request accepted!',
      'friend_request_rejected': 'Friend request rejected',
      'my_friends': 'My Friends',
      'friends_tab': 'Friends',
      'requests_tab': 'Requests',
      'add_tab': 'Add',
      'no_friends_yet': 'No friends yet',
      'use_add_tab_to_add_friends': 'Use the "Add" tab to add friends',
      'location_unknown': 'Location unknown',
      'no_pending_requests': 'No pending requests',
      'my_friend_code': 'My Friend Code',
      'share_code_with_friends': 'Share this code with your friends',
      'add_friend': 'Add Friend',
      'friend_code': 'Friend Code',
      'friend_code_example': 'Example: ABC123',
      'message_optional': 'Message (Optional)',
      'friend_request_message_hint': 'Hi, would you like to be friends?',
      'sending': 'Sending...',
      'send_request': 'Send Request',

      // Login Screen
      'login_failed':
          'Login failed. Google account selection was cancelled or an error occurred.',
      'login_error': 'Login error',
      'guest_user': 'Guest User',
      'guest_login_failed': 'Guest login failed',
      'continue_as_guest': 'Continue as guest',

      // Developer Section
      'developer': 'Developer',
      'debug_test_mode': 'Debug & Test Mode',
      'view_sensor_service_status': 'View sensor and service status',

      // Offline Map Dialog
      'location_permission_required': 'Location permission required',
      'offline_map_dialog_title': 'Download Offline Map',
      'offline_map_dialog_description':
          'Map tiles within 300 km radius of your location will be downloaded.',
      'offline_map_zoom_info': '• Zoom level: 6-14',
      'offline_map_size_info': '• Approximate size: ~50 MB',
      'offline_map_duration_info': '• Duration: ~1-2 minutes',

      // Chat Screen
      'message_send_failed': 'Message could not be sent. Please try again.',
      'active_users_count': 'active users',
      'remove_from_favorites': 'Remove from favorites',
      'add_to_favorites': 'Add to favorites',
      'active_users': 'Active Users',
      'refresh': 'Refresh',
      'type_message': 'Type your message...',
      'no_messages_yet': 'No messages yet',
      'send_first_message': 'Send the first message! 👋',
      'no_active_users': 'No active users yet',
      'join_room_failed': 'Failed to join room. Please try again.',
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
      'download': 'İndir',
      'tiles': 'karo',
      'keep_app_open': 'İndirme sırasında uygulamaı kapatmayın.',

      // Language Selection
      'select_language': 'Dil Seçin',
      'language': 'Dil',
      'turkish': 'Türkçe',
      'english': 'İngilizce',
      'spanish': 'İspanyolca',
      'hindi': 'Hintçe',
      'filipino': 'Filipince',
      'myanmar': 'Myanmarca',
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
      'alert_take_cover_now': 'HEMEN SIĞINAK ALIN!',
      'alert_be_prepared': 'HAZIRLIKLI OLUN!',
      'shaking_arriving_in': 'Sarsıntı {n} sn sonra ulaşacak',

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

      // Language Selection
      'please_select_language': 'Lütfen dilinizi seçin',

      // Offline Map
      'download_offline_map': 'Çevrimdışı Harita İndir',
      'offline_map_status_checking': 'Kontrol ediliyor...',
      'offline_map_downloading': 'İndiriliyor',
      'offline_map_downloaded': 'İndirildi',
      'offline_map_description': '300 km yarıçap, zoom 6-14 (~50 MB)',
      'offline_map_download_failed': 'Harita indirilemedi',
      'offline_map_redownload_info': 'karo - yeniden indirmek için tıklayın',

      // Friends Screen
      'please_enter_friend_code': 'Lütfen arkadaş kodunu girin',
      'friend_request_sent': 'Arkadaş isteği gönderildi!',
      'show_location': 'Konumu Göster',
      'remove_friendship': 'Arkadaşlıktan Çıkar',
      'reject': 'Reddet',
      'accept': 'Kabul Et',
      'code_copied': 'Kod kopyalandı!',
      'remove_from_friends': 'Arkadaş Listesinden Çıkar',
      'remove': 'Çıkar',
      'friend_removed': 'Arkadaş listesinden çıkarıldı',
      'close': 'Kapat',
      'show_on_map': 'Haritada Göster',
      'map_feature_coming_soon': 'Harita özelliği yakında eklenecek',
      'last_update': 'Son güncelleme',
      'coordinates': 'Koordinatlar',

      // Login Screen
      'login_failed':
          'Giriş başarısız. Google hesap seçimi iptal edildi veya bir hata oluştu.',
      'login_error': 'Giriş hatası',
      'guest_user': 'Misafir Kullanıcı',
      'guest_login_failed': 'Misafir girişi başarısız',
      'continue_as_guest': 'Misafir olarak devam et',

      // Developer Section
      'developer': 'Geliştirici',
      'debug_test_mode': 'Debug & Test Modu',
      'view_sensor_service_status': 'Sensör ve servis durumunu görüntüle',

      // Offline Map Dialog
      'location_permission_required': 'Konum izni gerekli',
      'offline_map_dialog_title': 'Çevrimdışı Harita İndir',
      'offline_map_dialog_description':
          'Bulunduğunuz konumun 300 km yarıçapındaki harita karoları indirilecek.',
      'offline_map_zoom_info': '• Zoom seviyesi: 6-14',
      'offline_map_size_info': '• Yaklaşık boyut: ~50 MB',
      'offline_map_duration_info': '• Süre: ~1-2 dakika',

      // Chat Screen
      'message_send_failed': 'Mesaj gönderilemedi. Tekrar deneyin.',
      'active_users_count': 'aktif kullanıcı',
      'remove_from_favorites': 'Favorilerden çıkar',
      'add_to_favorites': 'Favorilere ekle',
      'active_users': 'Aktif Kullanıcılar',
      'refresh': 'Yenile',
      'type_message': 'Mesajınızı yazın...',
      'no_messages_yet': 'Henüz mesaj yok',
      'send_first_message': 'İlk mesajı siz gönderin! 👋',
      'no_active_users': 'Henüz aktif kullanıcı yok',
      'join_room_failed': 'Odaya katılma hatası. Lütfen tekrar deneyin.',
    },
    'es': {
      // App General
      'app_name': 'Línea de Terremoto',
      'loading': 'Cargando...',
      'error': 'Error',
      'success': 'Éxito',
      'cancel': 'Cancelar',
      'save': 'Guardar',
      'delete': 'Eliminar',
      'edit': 'Editar',
      'close': 'Cerrar',
      'ok': 'OK',
      'yes': 'Sí',
      'no': 'No',
      'retry': 'Reintentar',
      'back': 'Atrás',
      'next': 'Siguiente',
      'done': 'Hecho',
      'search': 'Buscar',
      'settings': 'Configuración',
      'logout': 'Cerrar sesión',
      'login': 'Iniciar sesión',
      'register': 'Registrarse',
      'download': 'Descargar',
      'tiles': 'azulejos',
      'keep_app_open': 'No cierres la aplicación durante la descarga.',

      // Language Selection
      'select_language': 'Seleccionar idioma',
      'language': 'Idioma',
      'turkish': 'Turco',
      'english': 'Inglés',
      'spanish': 'Español',
      'hindi': 'Hindi',
      'filipino': 'Filipino',
      'myanmar': 'Myanmar',
      'language_changed': 'Idioma cambiado',
      'welcome_select_language': '¡Bienvenido! Por favor seleccione su idioma',
      'continue_text': 'Continuar',

      // Bottom Navigation
      'nav_map': 'Mapa',
      'nav_list': 'Lista',
      'nav_friends': 'Amigos',
      'nav_profile': 'Perfil',

      // Map Screen
      'earthquake_map': 'Mapa de Terremotos',
      'show_fault_lines': 'Mostrar líneas de falla',
      'hide_fault_lines': 'Ocultar líneas de falla',
      'show_friends': 'Mostrar amigos',
      'hide_friends': 'Ocultar amigos',
      'my_location': 'Mi ubicación',
      'earthquake_details': 'Detalles del terremoto',
      'earthquake_info': 'Información del terremoto',
      'magnitude': 'Magnitud',
      'depth': 'Profundidad',
      'distance': 'Distancia',
      'location': 'Ubicación',
      'time': 'Tiempo',
      'source': 'Fuente',
      'km': 'km',
      'km_away': 'km de distancia',
      'minutes_ago': 'minutos atrás',
      'hours_ago': 'horas atrás',
      'days_ago': 'días atrás',
      'just_now': 'Justo ahora',

      // Earthquake List
      'earthquake_list': 'Lista de terremotos',
      'no_earthquakes': 'No se encontraron terremotos',
      'last_24_hours': 'Últimas 24 horas',
      'last_week': 'Última semana',
      'last_month': 'Último mes',
      'all_earthquakes': 'Todos los terremotos',
      'filter': 'Filtrar',
      'sort_by': 'Ordenar por',
      'newest_first': 'Más nuevo primero',
      'oldest_first': 'Más antiguo primero',
      'highest_magnitude': 'Mayor magnitud',
      'nearest_first': 'Más cercano primero',

      // Friends Screen
      'friends': 'Amigos',
      'add_friend': 'Agregar amigo',
      'friend_requests': 'Solicitudes de amistad',
      'pending_requests': 'Solicitudes pendientes',
      'no_friends': 'Aún no tienes amigos',
      'search_friends': 'Buscar amigos...',
      'send_request': 'Enviar solicitud',
      'accept': 'Aceptar',
      'reject': 'Rechazar',
      'remove_friend': 'Eliminar amigo',
      'friend_location': 'Ubicación del amigo',
      'last_seen': 'Visto por última vez',
      'online': 'En línea',
      'offline': 'Desconectado',

      // Profile Screen
      'profile': 'Perfil',
      'edit_profile': 'Editar perfil',
      'my_reports': 'Mis reportes',
      'notification_history': 'Historial de notificaciones',
      'emergency_contacts': 'Contactos de emergencia',
      'help_support': 'Ayuda y soporte',
      'about': 'Acerca de',
      'privacy_policy': 'Política de privacidad',
      'terms_of_service': 'Términos de servicio',
      'version': 'Versión',

      // Settings Screen
      'settings_title': 'Configuración',
      'appearance': 'Apariencia',
      'dark_theme': 'Tema oscuro',
      'dark_map_theme': 'Tema de mapa oscuro',
      'notifications': 'Notificaciones',
      'notification_sound': 'Sonido de notificación',
      'vibration': 'Vibración',
      'background_notifications': 'Notificaciones en segundo plano',
      'earthquake_settings': 'Configuración de terremotos',
      'notification_radius': 'Radio de notificación',
      'min_magnitude': 'Magnitud mínima',
      'max_magnitude': 'Magnitud máxima',
      'location_settings': 'Configuración de ubicación',
      'share_location': 'Compartir ubicación con amigos',
      'location_update_interval': 'Intervalo de actualización de ubicación',
      'earthquake_detection': 'Servicio de detección de terremotos',
      'earthquake_detection_desc':
          'Detectar terremotos usando sensores del dispositivo',
      'whistle': 'Silbato de emergencia',
      'whistle_desc': 'Sonido de silbato fuerte para emergencias',
      'play_whistle': 'Reproducir silbato',
      'stop_whistle': 'Detener silbato',
      'battery_info': 'Información de batería',
      'app_settings': 'Configuración de la aplicación',

      // Earthquake Alert
      'earthquake_alert': '¡ALERTA DE TERREMOTO!',
      'earthquake_detected': 'Terremoto detectado',
      'take_cover': '¡Busca refugio!',
      'stay_safe': 'Mantente a salvo',
      'emergency_call': 'Llamada de emergencia',
      'share_status': 'Compartir estado',
      'i_am_safe': 'Estoy a salvo',
      'i_need_help': 'Necesito ayuda',
      'report_earthquake': 'Reportar terremoto',
      'take_cover_message': 'Métete debajo de una mesa o ve a un lugar seguro',
      'alert_take_cover_now': '¡REFUGIARSE AHORA!',
      'alert_be_prepared': '¡PREPÁRATE!',
      'shaking_arriving_in': 'Sacudida en {n} s',

      // Report Screen
      'report': 'Reporte',
      'report_earthquake_title': 'Reportar terremoto',
      'did_you_feel': '¿Sentiste el terremoto?',
      'intensity': 'Intensidad',
      'describe_experience': 'Describe tu experiencia',
      'submit_report': 'Enviar reporte',
      'report_submitted': 'Reporte enviado exitosamente',
      'report_failed': 'Error al enviar el reporte',
      'which_city': '¿Qué ciudad?',
      'search_city': 'Buscar ciudad...',
      'select_city': 'Por favor selecciona una ciudad',
      'earthquake_reported': '¡Terremoto reportado en {city}!',
      'report_button': 'Reportar',
      'estimated_magnitude': 'Magnitud estimada',
      'selected': 'Seleccionado',
      'no_results': 'No se encontraron resultados',

      // Login Screen
      'welcome': 'Bienvenido',
      'sign_in_google': 'Iniciar sesión con Google',
      'sign_in_email': 'Iniciar sesión con correo',
      'email': 'Correo electrónico',
      'password': 'Contraseña',
      'forgot_password': '¿Olvidaste tu contraseña?',
      'no_account': '¿No tienes cuenta?',
      'create_account': 'Crear cuenta',

      // Error Messages
      'error_connection': 'Error de conexión. Por favor verifica tu internet.',
      'error_location':
          'No se pudo obtener la ubicación. Por favor activa el GPS.',
      'error_permission':
          'Permiso denegado. Por favor otorga los permisos requeridos.',
      'error_login': 'Error al iniciar sesión. Por favor intenta de nuevo.',
      'error_unknown': 'Ocurrió un error desconocido.',

      // Notifications
      'notification_earthquake': 'Alerta de terremoto',
      'notification_friend_request': 'Nueva solicitud de amistad',
      'notification_friend_safe': 'Amigo marcado como seguro',
      'notification_service_running': 'Monitoreo de terremotos activo',
      'stop': 'Detener',

      // Additional Settings
      'earthquake_detection_service': 'Servicio de detección de terremotos',
      'earthquake_detection_enabled':
          'El servicio de detección funciona cuando el dispositivo está cargando.',
      'earthquake_detection_disabled': 'Servicio de detección desactivado.',
      'earthquake_filtering': 'Filtrado de terremotos',
      'notification_settings': 'Configuración de notificaciones',
      'notification_sound_subtitle':
          'Reproducir sonido para notificaciones de terremotos',
      'vibration_subtitle': 'Vibrar para notificaciones de terremotos',
      'background_notifications_subtitle':
          'Recibir notificaciones cuando la app esté cerrada',
      'share_location_subtitle': 'Comparte tu ubicación con amigos',
      'earthquake_filter_info':
          'Los terremotos entre {min}-{max} se muestran en el mapa. Recibirás notificaciones de terremotos dentro de {radius} km.',
      'notification_sound_on': 'Sonido de notificación activado',
      'notification_sound_off': 'Sonido de notificación desactivado',
      'vibration_on': 'Vibración activada',
      'vibration_off': 'Vibración desactivada',
      'background_notifications_on':
          'Notificaciones en segundo plano activadas',
      'background_notifications_off':
          'Notificaciones en segundo plano desactivadas',
      'background_service_stopped':
          '⚠️ Servicio en segundo plano detenido - Las notificaciones pueden no funcionar',
      'background_service_started':
          '✅ Servicio en segundo plano iniciado - Recibirás notificaciones incluso con la app cerrada',
      'background_service_failed':
          '❌ Error al iniciar el servicio en segundo plano',
      'background_active':
          'Activo - Recibirás notificaciones incluso con la app cerrada',
      'background_inactive':
          'Inactivo - Solo recibirás notificaciones cuando la app esté abierta',
      'share_location_on': 'Compartir ubicación activado',
      'share_location_off': 'Compartir ubicación desactivado',
      'min_magnitude_set': 'Magnitud mínima: {value}',
      'max_magnitude_set': 'Magnitud máxima: {value}',
      'notification_radius_set': 'Radio de notificación: {value} km',
      'detection_enabled': 'Servicio de detección de terremotos activado.',
      'detection_disabled': 'Servicio de detección de terremotos desactivado.',
      'current_language': 'Actual: Español',
      'change_language': 'Toca para cambiar el idioma',

      // Whistle
      'emergency_whistle': 'Silbato de emergencia',
      'emergency_whistle_desc': 'Sonido de silbato fuerte para emergencias',
      'whistle_playing': 'Silbato sonando. Toca para detener.',
      'whistle_stopped': 'Silbato detenido.',

      // Battery
      'battery_status': 'Estado de batería',
      'battery_charging': 'Cargando',
      'battery_discharging': 'Descargando',
      'battery_full': 'Completa',
      'battery_unknown': 'Desconocido',

      // Theme
      'theme_settings': 'Configuración de tema',
      'use_dark_map': 'Usar tema de mapa oscuro',

      // Friends
      'friend_added': 'Amigo agregado',
      'friend_removed': 'Amigo eliminado',
      'request_sent': 'Solicitud de amistad enviada',
      'request_accepted': 'Solicitud de amistad aceptada',
      'request_rejected': 'Solicitud de amistad rechazada',
      'no_pending_requests': 'No hay solicitudes pendientes',
      'add_friend_by_email': 'Agregar amigo por correo',
      'enter_email': 'Ingresa dirección de correo',

      // Earthquake Details
      'felt_it': 'Lo sentí',
      'share': 'Compartir',
      'navigate': 'Navegar',
      'more_info': 'Más información',
      'epicenter': 'Epicentro',
      'felt_reports': 'Reportes de percepción',
      'no_felt_reports': 'Aún no hay reportes de percepción',

      // Time
      'second_ago': 'segundo atrás',
      'seconds_ago': 'segundos atrás',
      'minute_ago': 'minuto atrás',
      'hour_ago': 'hora atrás',
      'day_ago': 'día atrás',
      'ago': 'atrás',

      // Chat
      'login_required_chat': 'Por favor inicia sesión para acceder al chat',
      'loading_chat_rooms': 'Cargando salas de chat...',
      'unnamed_room': 'Sala sin nombre',
      'members': 'miembros',

      // Map
      'refresh': 'Actualizar',
      'center_on_location': 'Centrar en mi ubicación',
      'loading_earthquakes': 'Cargando terremotos...',
      'no_earthquakes_in_range': 'No hay terremotos en el rango seleccionado',
      'total_earthquakes': 'Total: {count} terremotos',

      // Tools
      'tools': 'Herramientas',
      'start': 'Iniciar',
      'whistle_help':
          'Usa para señalar tu ubicación cuando estés atrapado bajo escombros',
      'whistle_active': '🔊 Silbato sonando - ¡Señala tu ubicación!',
      'whistle_warning':
          '¡Silbato sonando! Ayuda a los equipos de rescate a encontrarte.',
      'whistle_started': '¡🔊 Silbato iniciado!',

      // Settings Details
      'dark_theme_active': 'Tema oscuro activo',
      'light_theme_active': 'Tema claro activo',
      'dark_map_active': 'Tema de mapa oscuro',
      'light_map_active': 'Tema de mapa claro',
      'auto_notification_service': 'Servicio de notificación automática',
      'auto_start_enabled':
          'El servicio se inicia automáticamente al abrir la app',
      'auto_start_disabled': 'El servicio no se inicia automáticamente',
      'auto_notification_enabled':
          'Servicio de notificación automática activado.',
      'auto_notification_disabled':
          'Servicio de notificación automática desactivado.',
      'settings_auto_save':
          'Tu configuración se guarda automáticamente y se aplica en el próximo inicio.',
      'language_selection': 'Selección de idioma',

      // Battery Optimization
      'battery_optimization': 'Optimización de batería',
      'battery_optimization_title': 'Optimización de batería requerida',
      'battery_optimization_description':
          'Requerido para que el monitoreo en segundo plano funcione correctamente',
      'battery_optimization_message':
          'Para que las notificaciones en segundo plano funcionen correctamente, necesitas desactivar la optimización de batería para esta app. De lo contrario, el sistema puede detener la app para ahorrar batería y perderás las notificaciones de terremotos.',
      'battery_optimization_hint':
          'Selecciona "Sin restricciones" o "No optimizar" en la configuración de batería',
      'battery_optimization_still_on':
          '⚠️ La optimización de batería aún está activa. Las notificaciones en segundo plano pueden no funcionar correctamente.',
      'battery_optimization_disabled': 'Optimización de batería desactivada',
      'battery_optimization_enabled': 'Optimización de batería activa',
      'disable_battery_optimization': 'Desactivar optimización de batería',
      'battery_optimization_success':
          'Optimización de batería desactivada exitosamente',
      'battery_optimization_failed':
          'Por favor desactiva la optimización de batería manualmente en configuración',
      'later': 'Más tarde',
      'open_settings': 'Abrir configuración',

      // Friends Screen Additional
      'user': 'Usuario',
      'my_share_code': 'Mi código de compartir',
      'friend_share_code': 'Código de compartir del amigo',
      'copy': 'Copiar',
      'share_code_copied': 'Código de compartir copiado',
      'enter_share_code': 'Por favor ingresa un código de compartir',
      'share_code_length': 'El código de compartir debe tener 6 caracteres',
      'data_load_failed': 'No se pudieron cargar los datos',
      'unknown': 'Desconocido',
      'incoming_requests': 'Entrantes',
      'outgoing_requests': 'Salientes',
      'no_incoming_requests': 'No hay solicitudes entrantes',
      'no_outgoing_requests': 'No hay solicitudes salientes',
      'add_friend_hint':
          'Agrega amigos ingresando el código de compartir arriba',
      'request_accept_failed': 'No se pudo aceptar la solicitud',
      'request_reject_failed': 'No se pudo rechazar la solicitud',
      'remove': 'Eliminar',
      'remove_friend_title': 'Eliminar amigo',
      'remove_friend_confirm': '¿Eliminar a {name} de amigos?',
      'friend_removed_success': '{name} eliminado de amigos',
      'friend_remove_failed': 'No se pudo eliminar al amigo',
      'waiting_for_approval': 'Esperando aprobación',

      // History Screen
      'filter_all': 'Todos',
      'filter_today': 'Hoy',
      'filter_this_week': 'Esta semana',
      'filter_this_month': 'Este mes',
      'no_earthquake_records': 'No se encontraron registros de terremotos',
      'unknown_location': 'Ubicación desconocida',
      'intensity_severe': 'Severo',
      'intensity_noticeable': 'Notable',
      'intensity_light': 'Leve',
      'intensity_very_light': 'Muy leve',
      'min_ago': 'min atrás',
      'hours_ago_short': 'horas atrás',
      'magnitude_label': 'Magnitud',
      'distance_label': 'Distancia',

      // Map Screen Additional
      'latest_earthquake': 'Último terremoto',
      'earthquakes': 'Terremotos',
      'assembly_areas': 'Áreas de reunión',
      'fault_lines': 'Líneas de falla',

      // Navigation
      'chat_rooms': 'Salas de chat',
      'past_earthquakes': 'Terremotos pasados',
      'chat': 'Chat',
      'history': 'Historial',
      'map_refreshed': 'Mapa actualizado',

      // Months
      'month_january': 'Enero',
      'month_february': 'Febrero',
      'month_march': 'Marzo',
      'month_april': 'Abril',
      'month_may': 'Mayo',
      'month_june': 'Junio',
      'month_july': 'Julio',
      'month_august': 'Agosto',
      'month_september': 'Septiembre',
      'month_october': 'Octubre',
      'month_november': 'Noviembre',
      'month_december': 'Diciembre',

      // Days
      'day_monday': 'Lunes',
      'day_tuesday': 'Martes',
      'day_wednesday': 'Miércoles',
      'day_thursday': 'Jueves',
      'day_friday': 'Viernes',
      'day_saturday': 'Sábado',
      'day_sunday': 'Domingo',

      // Magnitude descriptions
      'mag_micro': 'Micro terremoto',
      'mag_very_light': 'Muy leve',
      'mag_light': 'Leve',
      'mag_medium': 'Medio',
      'mag_strong': 'Fuerte',
      'mag_very_strong': 'Muy fuerte',
      'mag_destructive': 'Destructivo',

      // Map additional
      'unknown_user': 'Desconocido',
      'capacity': 'Capacidad',
      'type': 'Tipo',
      'persons': 'personas',
      'invalid_timestamp': 'Tipo de marca de tiempo inválido',
      'no_date_info': 'Sin información de fecha',

      // Chat additional
      'no_messages_yet': 'Aún no hay mensajes',
      'no_active_users': 'Aún no hay usuarios activos',
      'active_users': 'Usuarios activos',
      'send_first_message': '¡Envía el primer mensaje! 👋',

      // Alarm
      'take_shelter': 'BUSCA REFUGIO',
      'magnitude_display': 'MAGNITUD',

      // Sensor
      'no_saved_sessions': 'No hay sesiones guardadas',
      'export': 'Exportar',
      'delete_all': 'Eliminar todo',
      'no_recordings': 'Aún no hay grabaciones',

      // Settings Page Additional
      'allow_notifications': 'Permitir notificaciones',
      'receive_earthquake_notifications':
          'Recibir notificaciones de terremotos',
      'minimum_magnitude': 'Magnitud mínima',
      'between_mw': 'Entre {min}-{max} Mw',
      'notification_radius_setting': 'Radio de notificación',
      'earthquakes_within_km': 'Terremotos dentro de {radius} km',
      'sound_alert': 'Alerta de sonido',
      'device_vibrate': 'Vibrar dispositivo',
      'share_location_with_friends': 'Compartir ubicación con amigos',
      'update_location_every_2_hours': 'Actualizar ubicación cada 2 horas',
      'location_services': 'Servicios de ubicación',
      'show_nearby_earthquakes': 'Mostrar terremotos cercanos',
      'background_refresh': 'Actualización en segundo plano',
      'update_data_when_closed': 'Actualizar datos cuando la app esté cerrada',
      'clear_cache': 'Limpiar caché',
      'delete_stored_data': 'Eliminar datos almacenados',
      'rate_us': 'Califícanos',
      'rate_on_app_store': 'Calificar en App Store',
      'go_pro': 'Obtener Pro',
      'unlock_all_features': 'Desbloquear todas las funciones',
      'about_app': 'Acerca de la app',
      'terms_and_privacy': 'Términos de uso y privacidad',
      'report_bug': 'Reportar error',
      'having_issues': '¿Tienes problemas?',
      'account': 'Cuenta',
      'logout_from_account': 'Cerrar sesión de tu cuenta',
      'other': 'Otro',
      'earthquake_magnitude_range': 'Rango de magnitud de terremotos',
      'minimum': 'Mínimo',
      'maximum': 'Máximo',
      'earthquakes_between_shown':
          'Se mostrarán terremotos entre {min}-{max} Mw',
      'magnitude_range_set': 'Rango de magnitud establecido en {min}-{max}',
      'rate_us_title': 'Califícanos',
      'do_you_like_app':
          '¿Te gusta Línea de Terremoto? ¡Puedes apoyarnos calificándonos en App Store!',
      'rate': 'Calificar',
      'opening_app_store': 'Abriendo App Store...',
      'pro_version': 'Versión Pro',
      'pro_features': 'Características Pro:',
      'ad_free': '🚫 Experiencia sin anuncios',
      'detailed_analysis': '📊 Análisis detallado de terremotos',
      'priority_notifications': '🔔 Notificaciones prioritarias',
      'advanced_location': '📍 Seguimiento de ubicación avanzado',
      'historical_analysis': '📈 Análisis de datos históricos',
      'custom_themes': '🎨 Temas personalizados',
      'per_year': '/ Año',
      'purchase': 'Comprar',
      'starting_purchase': 'Iniciando compra...',
      'how_far_notifications':
          '¿A qué distancia quieres recibir notificaciones?',
      'between_km': 'Entre 10 km - 1000 km',
      'radius_set': 'Radio de notificación establecido en {radius} km',
      'your_location_shared': 'Tu ubicación se está compartiendo con amigos',
      'location_sharing_off': 'Compartir ubicación desactivado',
      'clear_cache_title': 'Limpiar caché',
      'clear_cache_confirm':
          'Todos los datos en caché serán eliminados. ¿Deseas continuar?',
      'cache_cleared': 'Caché limpiado',
      'clear': 'Limpiar',
      'earthquake_line': 'Línea de Terremoto',
      'comprehensive_app':
          'La aplicación de seguimiento de terremotos más completa de Turquía',
      'all_rights_reserved': 'Todos los derechos reservados.',
      'logout_title': 'Cerrar sesión',
      'logout_confirm': '¿Estás seguro de que quieres cerrar sesión?',
      'logged_out': 'Sesión cerrada',
      'bug_report_opening': 'Abriendo formulario de reporte de errores...',
      'whistle_play': 'Reproducir silbato',
      'whistle_playing_signal': '🔊 Silbato sonando - ¡Señala tu ubicación!',
      'whistle_use_debris':
          'Usa para señalar tu ubicación cuando estés atrapado bajo escombros',
      'whistle_help_rescue':
          '¡Silbato sonando! Ayuda a los equipos de rescate a encontrarte.',
      'version_text': 'Versión',
      'build_text': 'Build',

      // Location Permission Dialog
      'backgroundLocationTitle':
          'Se requiere permiso de ubicación en segundo plano',
      'locationPermissionTitle': 'Se requiere permiso de ubicación',
      'backgroundLocationMessage':
          'Esta app quiere acceder a tus datos de ubicación en segundo plano para el sistema de alerta temprana de terremotos.',
      'locationPermissionMessage':
          'Esta app quiere acceder a tus datos de ubicación para mostrarte información del terremoto más cercano.',
      'backgroundLocationReason1':
          'Detección de terremotos incluso con la app cerrada',
      'backgroundLocationReason2':
          'Alertas de terremotos en tiempo real específicas de ubicación',
      'backgroundLocationReason3':
          'Participar en la red de detección de terremotos P2P',
      'locationReason1': 'Mostrar terremotos más cercanos a ti',
      'locationReason2': 'Notificaciones de terremotos basadas en ubicación',
      'locationReason3': 'Mostrar tu ubicación en el mapa de terremotos',
      'locationPrivacyNote':
          'Tus datos de ubicación solo se usan para el sistema de alerta temprana de terremotos y no se comparten con terceros.',
      'backgroundLocationNote':
          'Nota: Deberás seleccionar la opción "Permitir siempre" en la siguiente pantalla.',
      'deny': 'Denegar',
      'allow': 'Permitir',

      // Language Selection
      'please_select_language': 'Por favor selecciona tu idioma',

      // Offline Map
      'download_offline_map': 'Descargar Mapa Sin Conexión',
      'offline_map_status_checking': 'Verificando...',
      'offline_map_downloading': 'Descargando',
      'offline_map_downloaded': 'Descargado',
      'offline_map_description': 'Radio de 300 km, zoom 6-14 (~50 MB)',
      'offline_map_download_failed': 'Falló la descarga del mapa',
      'offline_map_redownload_info': 'azulejos - toca para volver a descargar',

      // Friends Screen
      'please_enter_friend_code': 'Por favor ingresa el código de amigo',
      'friend_request_sent': '¡Solicitud de amistad enviada!',
      'show_location': 'Mostrar Ubicación',
      'remove_friendship': 'Eliminar Amistad',
      'reject': 'Rechazar',
      'accept': 'Aceptar',
      'code_copied': '¡Código copiado!',
      'remove_from_friends': 'Eliminar de Amigos',
      'remove': 'Eliminar',
      'friend_removed': 'Eliminado de la lista de amigos',
      'close': 'Cerrar',
      'show_on_map': 'Mostrar en el Mapa',
      'map_feature_coming_soon': 'Función de mapa próximamente',
      'last_update': 'Última actualización',
      'coordinates': 'Coordenadas',
      'friend_request_accepted': '¡Solicitud de amistad aceptada!',
      'friend_request_rejected': 'Solicitud de amistad rechazada',
      'my_friends': 'Mis Amigos',
      'friends_tab': 'Amigos',
      'requests_tab': 'Solicitudes',
      'add_tab': 'Agregar',
      'no_friends_yet': 'Aún no tienes amigos',
      'use_add_tab_to_add_friends':
          'Usa la pestaña "Agregar" para añadir amigos',
      'location_unknown': 'Ubicación desconocida',
      'no_pending_requests': 'No hay solicitudes pendientes',
      'my_friend_code': 'Mi Código de Amigo',
      'share_code_with_friends': 'Comparte este código con tus amigos',
      'add_friend': 'Agregar Amigo',
      'friend_code': 'Código de Amigo',
      'friend_code_example': 'Ejemplo: ABC123',
      'message_optional': 'Mensaje (Opcional)',
      'friend_request_message_hint': 'Hola, ¿te gustaría ser amigos?',
      'sending': 'Enviando...',
      'send_request': 'Enviar Solicitud',

      // Login Screen
      'login_failed':
          'Inicio de sesión fallido. Se canceló la selección de cuenta de Google o ocurrió un error.',
      'login_error': 'Error de inicio de sesión',
      'guest_user': 'Usuario Invitado',
      'guest_login_failed': 'Inicio de sesión de invitado fallido',
      'continue_as_guest': 'Continuar como invitado',

      // Developer Section
      'developer': 'Desarrollador',
      'debug_test_mode': 'Modo de Depuración y Prueba',
      'view_sensor_service_status': 'Ver estado de sensores y servicios',

      // Offline Map Dialog
      'location_permission_required': 'Permiso de ubicación requerido',
      'offline_map_dialog_title': 'Descargar Mapa Sin Conexión',
      'offline_map_dialog_description':
          'Se descargarán los azulejos del mapa dentro de un radio de 300 km de su ubicación.',
      'offline_map_zoom_info': '• Nivel de zoom: 6-14',
      'offline_map_size_info': '• Tamaño aproximado: ~50 MB',
      'offline_map_duration_info': '• Duración: ~1-2 minutos',

      // Chat Screen
      'message_send_failed':
          'No se pudo enviar el mensaje. Por favor, inténtelo de nuevo.',
      'active_users_count': 'usuarios activos',
      'remove_from_favorites': 'Quitar de favoritos',
      'add_to_favorites': 'Agregar a favoritos',
      'active_users': 'Usuarios Activos',
      'refresh': 'Actualizar',
      'type_message': 'Escribe tu mensaje...',
      'no_messages_yet': 'Aún no hay mensajes',
      'send_first_message': '¡Envía el primer mensaje! 👋',
      'no_active_users': 'Aún no hay usuarios activos',
      'join_room_failed':
          'Error al unirse a la sala. Por favor, inténtelo de nuevo.',
    },
    'hi': {
      // App General
      'app_name': 'भूकंप लाइन',
      'loading': 'लोड हो रहा है...',
      'error': 'त्रुटि',
      'success': 'सफलता',
      'cancel': 'रद्द करें',
      'save': 'सहेजें',
      'delete': 'हटाएं',
      'edit': 'संपादित करें',
      'close': 'बंद करें',
      'ok': 'ठीक है',
      'yes': 'हाँ',
      'no': 'नहीं',
      'retry': 'पुन: प्रयास करें',
      'back': 'वापस',
      'next': 'अगला',
      'done': 'हो गया',
      'search': 'खोजें',
      'settings': 'सेटिंग्स',
      'logout': 'लॉग आउट',
      'login': 'लॉग इन',
      'register': 'पंजीकरण करें',
      'download': 'डाउनलोड करें',
      'tiles': 'टाइल्स',
      'keep_app_open': 'डाउनलोड के दौरान ऐप बंद न करें।',

      // Language Selection
      'select_language': 'भाषा चुनें',
      'language': 'भाषा',
      'turkish': 'तुर्की',
      'english': 'अंग्रेज़ी',
      'spanish': 'स्पेनिश',
      'hindi': 'हिन्दी',
      'filipino': 'फिलिपिनो',
      'myanmar': 'म्यांमार',
      'language_changed': 'भाषा बदल दी गई',
      'welcome_select_language': 'स्वागत है! कृपया अपनी भाषा चुनें',
      'continue_text': 'जारी रखें',

      // Bottom Navigation
      'nav_map': 'मानचित्र',
      'nav_list': 'सूची',
      'nav_friends': 'मित्र',
      'nav_profile': 'प्रोफ़ाइल',

      // Map Screen
      'earthquake_map': 'भूकंप मानचित्र',
      'show_fault_lines': 'फॉल्ट लाइनें दिखाएं',
      'hide_fault_lines': 'फॉल्ट लाइनें छिपाएं',
      'show_friends': 'मित्रों को दिखाएं',
      'hide_friends': 'मित्रों को छिपाएं',
      'my_location': 'मेरा स्थान',
      'earthquake_details': 'भूकंप विवरण',
      'earthquake_info': 'भूकंप जानकारी',
      'magnitude': 'तीव्रता',
      'depth': 'गहराई',
      'distance': 'दूरी',
      'location': 'स्थान',
      'time': 'समय',
      'source': 'स्रोत',
      'km': 'कि.मी.',
      'km_away': 'कि.मी. दूर',
      'minutes_ago': 'मिनट पहले',
      'hours_ago': 'घंटे पहले',
      'days_ago': 'दिन पहले',
      'just_now': 'अभी-अभी',

      // Earthquake List
      'earthquake_list': 'भूकंप सूची',
      'no_earthquakes': 'कोई भूकंप नहीं मिला',
      'last_24_hours': 'पिछले 24 घंटे',
      'last_week': 'पिछला सप्ताह',
      'last_month': 'पिछला महीना',
      'all_earthquakes': 'सभी भूकंप',
      'filter': 'फ़िल्टर करें',
      'sort_by': 'क्रमबद्ध करें',
      'newest_first': 'सबसे नया पहले',
      'oldest_first': 'सबसे पुराना पहले',
      'highest_magnitude': 'सबसे अधिक तीव्रता',
      'nearest_first': 'सबसे निकटतम पहले',

      // Friends Screen
      'friends': 'मित्र',
      'add_friend': 'मित्र जोड़ें',
      'friend_requests': 'मित्र अनुरोध',
      'pending_requests': 'लंबित अनुरोध',
      'no_friends': 'अभी तक कोई मित्र नहीं',
      'search_friends': 'मित्र खोजें...',
      'send_request': 'अनुरोध भेजें',
      'accept': 'स्वीकार करें',
      'reject': 'अस्वीकार करें',
      'remove_friend': 'मित्र हटाएं',
      'friend_location': 'मित्र का स्थान',
      'last_seen': 'अंतिम बार देखा गया',
      'online': 'ऑनलाइन',
      'offline': 'ऑफ़लाइन',

      // Profile Screen
      'profile': 'प्रोफ़ाइल',
      'edit_profile': 'प्रोफ़ाइल संपादित करें',
      'my_reports': 'मेरी रिपोर्टें',
      'notification_history': 'सूचना इतिहास',
      'emergency_contacts': 'आपातकालीन संपर्क',
      'help_support': 'सहायता और समर्थन',
      'about': 'के बारे में',
      'privacy_policy': 'गोपनीयता नीति',
      'terms_of_service': 'सेवा की शर्तें',
      'version': 'संस्करण',

      // Settings Screen
      'settings_title': 'सेटिंग्स',
      'appearance': 'उपस्थिति',
      'dark_theme': 'डार्क थीम',
      'dark_map_theme': 'डार्क मैप थीम',
      'notifications': 'सूचनाएं',
      'notification_sound': 'सूचना ध्वनि',
      'vibration': 'कंपन',
      'background_notifications': 'पृष्ठभूमि सूचनाएं',
      'earthquake_settings': 'भूकंप सेटिंग्स',
      'notification_radius': 'सूचना त्रिज्या',
      'min_magnitude': 'न्यूनतम तीव्रता',
      'max_magnitude': 'अधिकतम तीव्रता',
      'location_settings': 'स्थान सेटिंग्स',
      'share_location': 'मित्रों के साथ स्थान साझा करें',
      'location_update_interval': 'स्थान अपडेट अंतराल',
      'earthquake_detection': 'भूकंप पहचान सेवा',
      'earthquake_detection_desc':
          'डिवाइस सेंसर का उपयोग करके भूकंप का पता लगाएं',
      'whistle': 'आपातकालीन सीटी',
      'whistle_desc': 'आपात स्थिति के लिए तेज सीटी की आवाज',
      'play_whistle': 'सीटी बजाएं',
      'stop_whistle': 'सीटी रोकें',
      'battery_info': 'बैटरी जानकारी',
      'app_settings': 'ऐप सेटिंग्स',

      // Earthquake Alert
      'earthquake_alert': 'भूकंप चेतावनी!',
      'earthquake_detected': 'भूकंप का पता चला',
      'take_cover': 'सुरक्षित स्थान पर जाएं!',
      'stay_safe': 'सुरक्षित रहें',
      'emergency_call': 'आपातकालीन कॉल',
      'share_status': 'स्थिति साझा करें',
      'i_am_safe': 'मैं सुरक्षित हूं',
      'i_need_help': 'मुझे मदद चाहिए',
      'report_earthquake': 'भूकंप की रिपोर्ट करें',
      'take_cover_message': 'मेज के नीचे जाएं या सुरक्षित स्थान पर जाएं',
      'alert_take_cover_now': 'अभी शरण लें!',
      'alert_be_prepared': 'तैयार रहें!',
      'shaking_arriving_in': 'कंपन {n} s में',

      // Report Screen
      'report': 'रिपोर्ट',
      'report_earthquake_title': 'भूकंप की रिपोर्ट करें',
      'did_you_feel': 'क्या आपने भूकंप महसूस किया?',
      'intensity': 'तीव्रता',
      'describe_experience': 'अपना अनुभव बताएं',
      'submit_report': 'रिपोर्ट सबमिट करें',
      'report_submitted': 'रिपोर्ट सफलतापूर्वक सबमिट की गई',
      'report_failed': 'रिपोर्ट सबमिट करने में विफल',
      'which_city': 'कौन सा शहर',
      'search_city': 'शहर खोजें...',
      'select_city': 'कृपया एक शहर चुनें',
      'earthquake_reported': '{city} में भूकंप की सूचना दी गई!',
      'report_button': 'रिपोर्ट करें',
      'estimated_magnitude': 'अनुमानित तीव्रता',
      'selected': 'चयनित',
      'no_results': 'कोई परिणाम नहीं मिला',

      // Login Screen
      'welcome': 'स्वागत है',
      'sign_in_google': 'Google से साइन इन करें',
      'sign_in_email': 'ईमेल से साइन इन करें',
      'email': 'ईमेल',
      'password': 'पासवर्ड',
      'forgot_password': 'पासवर्ड भूल गए?',
      'no_account': 'खाता नहीं है?',
      'create_account': 'खाता बनाएं',

      // Error Messages
      'error_connection': 'कनेक्शन त्रुटि। कृपया अपना इंटरनेट जांचें।',
      'error_location': 'स्थान प्राप्त नहीं हो सका। कृपया GPS सक्षम करें।',
      'error_permission':
          'अनुमति अस्वीकृत। कृपया आवश्यक अनुमतियां प्रदान करें।',
      'error_login': 'लॉग इन विफल। कृपया पुन: प्रयास करें।',
      'error_unknown': 'एक अज्ञात त्रुटि हुई।',

      // Notifications
      'notification_earthquake': 'भूकंप चेतावनी',
      'notification_friend_request': 'नया मित्र अनुरोध',
      'notification_friend_safe':
          'मित्र को सुरक्षित के रूप में चिह्नित किया गया',
      'notification_service_running': 'भूकंप निगरानी सक्रिय',
      'stop': 'रोकें',

      // Additional Settings
      'earthquake_detection_service': 'भूकंप पहचान सेवा',
      'earthquake_detection_enabled':
          'डिवाइस चार्ज होने पर भूकंप पहचान सेवा चलती है।',
      'earthquake_detection_disabled': 'भूकंप पहचान सेवा अक्षम है।',
      'earthquake_filtering': 'भूकंप फ़िल्टरिंग',
      'notification_settings': 'सूचना सेटिंग्स',
      'notification_sound_subtitle': 'भूकंप सूचनाओं के लिए ध्वनि बजाएं',
      'vibration_subtitle': 'भूकंप सूचनाओं के लिए कंपन करें',
      'background_notifications_subtitle':
          'ऐप बंद होने पर सूचनाएं प्राप्त करें',
      'share_location_subtitle': 'मित्रों के साथ अपना स्थान साझा करें',
      'earthquake_filter_info':
          'मानचित्र पर {min}-{max} के बीच के भूकंप दिखाए जाते हैं। आपको {radius} कि.मी. के भीतर के भूकंपों की सूचनाएं मिलेंगी।',
      'notification_sound_on': 'सूचना ध्वनि सक्षम',
      'notification_sound_off': 'सूचना ध्वनि अक्षम',
      'vibration_on': 'कंपन सक्षम',
      'vibration_off': 'कंपन अक्षम',
      'background_notifications_on': 'पृष्ठभूमि सूचनाएं सक्षम',
      'background_notifications_off': 'पृष्ठभूमि सूचनाएं अक्षम',
      'background_service_stopped':
          '⚠️ पृष्ठभूमि सेवा रुक गई - सूचनाएं काम नहीं कर सकतीं',
      'background_service_started':
          '✅ पृष्ठभूमि सेवा शुरू हो गई - ऐप बंद होने पर भी सूचनाएं प्राप्त होंगी',
      'background_service_failed': '❌ पृष्ठभूमि सेवा शुरू करने में विफल',
      'background_active': 'सक्रिय - ऐप बंद होने पर भी सूचनाएं प्राप्त होंगी',
      'background_inactive':
          'निष्क्रिय - केवल ऐप खुला होने पर सूचनाएं प्राप्त होंगी',
      'share_location_on': 'स्थान साझाकरण सक्षम',
      'share_location_off': 'स्थान साझाकरण अक्षम',
      'min_magnitude_set': 'न्यूनतम तीव्रता: {value}',
      'max_magnitude_set': 'अधिकतम तीव्रता: {value}',
      'notification_radius_set': 'सूचना त्रिज्या: {value} कि.मी.',
      'detection_enabled': 'भूकंप पहचान सेवा सक्षम।',
      'detection_disabled': 'भूकंप पहचान सेवा अक्षम।',
      'current_language': 'वर्तमान: हिन्दी',
      'change_language': 'भाषा बदलने के लिए टैप करें',

      // Whistle
      'emergency_whistle': 'आपातकालीन सीटी',
      'emergency_whistle_desc': 'आपात स्थिति के लिए तेज सीटी की आवाज',
      'whistle_playing': 'सीटी बज रही है। रोकने के लिए टैप करें।',
      'whistle_stopped': 'सीटी रुक गई।',

      // Battery
      'battery_status': 'बैटरी स्थिति',
      'battery_charging': 'चार्ज हो रही है',
      'battery_discharging': 'डिस्चार्ज हो रही है',
      'battery_full': 'पूरा',
      'battery_unknown': 'अज्ञात',

      // Theme
      'theme_settings': 'थीम सेटिंग्स',
      'use_dark_map': 'डार्क मैप थीम का उपयोग करें',

      // Friends
      'friend_added': 'मित्र जोड़ा गया',
      'friend_removed': 'मित्र हटाया गया',
      'request_sent': 'मित्र अनुरोध भेजा गया',
      'request_accepted': 'मित्र अनुरोध स्वीकार किया गया',
      'request_rejected': 'मित्र अनुरोध अस्वीकार किया गया',
      'no_pending_requests': 'कोई लंबित अनुरोध नहीं',
      'add_friend_by_email': 'ईमेल से मित्र जोड़ें',
      'enter_email': 'ईमेल पता दर्ज करें',

      // Earthquake Details
      'felt_it': 'मैंने महसूस किया',
      'share': 'साझा करें',
      'navigate': 'नेविगेट करें',
      'more_info': 'अधिक जानकारी',
      'epicenter': 'उपकेंद्र',
      'felt_reports': 'अनुभव रिपोर्टें',
      'no_felt_reports': 'अभी तक कोई अनुभव रिपोर्ट नहीं',

      // Time
      'second_ago': 'सेकंड पहले',
      'seconds_ago': 'सेकंड पहले',
      'minute_ago': 'मिनट पहले',
      'hour_ago': 'घंटा पहले',
      'day_ago': 'दिन पहले',
      'ago': 'पहले',

      // Chat
      'login_required_chat': 'चैट तक पहुंचने के लिए कृपया लॉग इन करें',
      'loading_chat_rooms': 'चैट रूम लोड हो रहे हैं...',
      'unnamed_room': 'अनाम रूम',
      'members': 'सदस्य',

      // Map
      'refresh': 'रीफ्रेश करें',
      'center_on_location': 'मेरे स्थान पर केंद्रित करें',
      'loading_earthquakes': 'भूकंप लोड हो रहे हैं...',
      'no_earthquakes_in_range': 'चयनित सीमा में कोई भूकंप नहीं',
      'total_earthquakes': 'कुल: {count} भूकंप',

      // Tools
      'tools': 'उपकरण',
      'start': 'शुरू करें',
      'whistle_help':
          'मलबे के नीचे फंसे होने पर अपना स्थान संकेत करने के लिए उपयोग करें',
      'whistle_active': '🔊 सीटी बज रही है - अपना स्थान संकेत करें!',
      'whistle_warning':
          'सीटी बज रही है! बचाव दलों को आपको खोजने में मदद करें।',
      'whistle_started': '🔊 सीटी शुरू हो गई!',

      // Settings Details
      'dark_theme_active': 'डार्क थीम सक्रिय',
      'light_theme_active': 'लाइट थीम सक्रिय',
      'dark_map_active': 'डार्क मैप थीम',
      'light_map_active': 'लाइट मैप थीम',
      'auto_notification_service': 'स्वचालित सूचना सेवा',
      'auto_start_enabled': 'ऐप लॉन्च पर सेवा स्वचालित रूप से शुरू होती है',
      'auto_start_disabled': 'सेवा स्वचालित रूप से शुरू नहीं होती',
      'auto_notification_enabled': 'स्वचालित सूचना सेवा सक्षम।',
      'auto_notification_disabled': 'स्वचालित सूचना सेवा अक्षम।',
      'settings_auto_save':
          'आपकी सेटिंग्स स्वचालित रूप से सहेजी जाती हैं और अगले लॉन्च पर लागू होती हैं।',
      'language_selection': 'भाषा चयन',

      // Battery Optimization
      'battery_optimization': 'बैटरी अनुकूलन',
      'battery_optimization_title': 'बैटरी अनुकूलन आवश्यक',
      'battery_optimization_description':
          'पृष्ठभूमि भूकंप निगरानी के सही ढंग से काम करने के लिए आवश्यक',
      'battery_optimization_message':
          'पृष्ठभूमि सूचनाओं के सही ढंग से काम करने के लिए, आपको इस ऐप के लिए बैटरी अनुकूलन को अक्षम करना होगा। अन्यथा, सिस्टम बैटरी बचाने के लिए ऐप को रोक सकता है और आप भूकंप सूचनाओं को मिस कर सकते हैं।',
      'battery_optimization_hint':
          'बैटरी सेटिंग्स में "अप्रतिबंधित" या "अनुकूलित न करें" चुनें',
      'battery_optimization_still_on':
          '⚠️ बैटरी अनुकूलन अभी भी सक्रिय है। पृष्ठभूमि सूचनाएं सही ढंग से काम नहीं कर सकतीं।',
      'battery_optimization_disabled': 'बैटरी अनुकूलन अक्षम',
      'battery_optimization_enabled': 'बैटरी अनुकूलन सक्रिय',
      'disable_battery_optimization': 'बैटरी अनुकूलन अक्षम करें',
      'battery_optimization_success':
          'बैटरी अनुकूलन सफलतापूर्वक अक्षम किया गया',
      'battery_optimization_failed':
          'कृपया सेटिंग्स में बैटरी अनुकूलन को मैन्युअल रूप से अक्षम करें',
      'later': 'बाद में',
      'open_settings': 'सेटिंग्स खोलें',

      // Friends Screen Additional
      'user': 'उपयोगकर्ता',
      'my_share_code': 'मेरा शेयर कोड',
      'friend_share_code': 'मित्र का शेयर कोड',
      'copy': 'कॉपी करें',
      'share_code_copied': 'शेयर कोड कॉपी किया गया',
      'enter_share_code': 'कृपया एक शेयर कोड दर्ज करें',
      'share_code_length': 'शेयर कोड 6 वर्णों का होना चाहिए',
      'data_load_failed': 'डेटा लोड नहीं हो सका',
      'unknown': 'अज्ञात',
      'incoming_requests': 'आने वाले',
      'outgoing_requests': 'जाने वाले',
      'no_incoming_requests': 'कोई आने वाले अनुरोध नहीं',
      'no_outgoing_requests': 'कोई जाने वाले अनुरोध नहीं',
      'add_friend_hint': 'ऊपर शेयर कोड दर्ज करके मित्र जोड़ें',
      'request_accept_failed': 'अनुरोध स्वीकार नहीं हो सका',
      'request_reject_failed': 'अनुरोध अस्वीकार नहीं हो सका',
      'remove': 'हटाएं',
      'remove_friend_title': 'मित्र हटाएं',
      'remove_friend_confirm': '{name} को मित्रों से हटाएं?',
      'friend_removed_success': '{name} मित्रों से हटा दिया गया',
      'friend_remove_failed': 'मित्र हटाया नहीं जा सका',
      'waiting_for_approval': 'अनुमोदन की प्रतीक्षा में',

      // History Screen
      'filter_all': 'सभी',
      'filter_today': 'आज',
      'filter_this_week': 'इस सप्ताह',
      'filter_this_month': 'इस महीने',
      'no_earthquake_records': 'कोई भूकंप रिकॉर्ड नहीं मिला',
      'unknown_location': 'अज्ञात स्थान',
      'intensity_severe': 'गंभीर',
      'intensity_noticeable': 'ध्यान देने योग्य',
      'intensity_light': 'हल्का',
      'intensity_very_light': 'बहुत हल्का',
      'min_ago': 'मिनट पहले',
      'hours_ago_short': 'घंटे पहले',
      'magnitude_label': 'तीव्रता',
      'distance_label': 'दूरी',

      // Map Screen Additional
      'latest_earthquake': 'नवीनतम भूकंप',
      'earthquakes': 'भूकंप',
      'assembly_areas': 'सभा क्षेत्र',
      'fault_lines': 'फॉल्ट लाइनें',

      // Navigation
      'chat_rooms': 'चैट रूम',
      'past_earthquakes': 'पिछले भूकंप',
      'chat': 'चैट',
      'history': 'इतिहास',
      'map_refreshed': 'मानचित्र रीफ्रेश किया गया',

      // Months
      'month_january': 'जनवरी',
      'month_february': 'फरवरी',
      'month_march': 'मार्च',
      'month_april': 'अप्रैल',
      'month_may': 'मई',
      'month_june': 'जून',
      'month_july': 'जुलाई',
      'month_august': 'अगस्त',
      'month_september': 'सितंबर',
      'month_october': 'अक्टूबर',
      'month_november': 'नवंबर',
      'month_december': 'दिसंबर',

      // Days
      'day_monday': 'सोमवार',
      'day_tuesday': 'मंगलवार',
      'day_wednesday': 'बुधवार',
      'day_thursday': 'गुरुवार',
      'day_friday': 'शुक्रवार',
      'day_saturday': 'शनिवार',
      'day_sunday': 'रविवार',

      // Magnitude descriptions
      'mag_micro': 'सूक्ष्म भूकंप',
      'mag_very_light': 'बहुत हल्का',
      'mag_light': 'हल्का',
      'mag_medium': 'मध्यम',
      'mag_strong': 'मजबूत',
      'mag_very_strong': 'बहुत मजबूत',
      'mag_destructive': 'विनाशकारी',

      // Map additional
      'unknown_user': 'अज्ञात',
      'capacity': 'क्षमता',
      'type': 'प्रकार',
      'persons': 'व्यक्ति',
      'invalid_timestamp': 'अमान्य टाइमस्टैम्प प्रकार',
      'no_date_info': 'कोई तिथि जानकारी नहीं',

      // Chat additional
      'no_messages_yet': 'अभी तक कोई संदेश नहीं',
      'no_active_users': 'अभी तक कोई सक्रिय उपयोगकर्ता नहीं',
      'active_users': 'सक्रिय उपयोगकर्ता',
      'send_first_message': 'पहला संदेश भेजें! 👋',

      // Alarm
      'take_shelter': 'आश्रय लें',
      'magnitude_display': 'तीव्रता',

      // Sensor
      'no_saved_sessions': 'कोई सहेजे गए सत्र नहीं',
      'export': 'निर्यात करें',
      'delete_all': 'सभी हटाएं',
      'no_recordings': 'अभी तक कोई रिकॉर्डिंग नहीं',

      // Settings Page Additional
      'allow_notifications': 'सूचनाओं की अनुमति दें',
      'receive_earthquake_notifications': 'भूकंप सूचनाएं प्राप्त करें',
      'minimum_magnitude': 'न्यूनतम तीव्रता',
      'between_mw': '{min}-{max} Mw के बीच',
      'notification_radius_setting': 'सूचना त्रिज्या',
      'earthquakes_within_km': '{radius} कि.मी. के भीतर भूकंप',
      'sound_alert': 'ध्वनि चेतावनी',
      'device_vibrate': 'डिवाइस को कंपन करें',
      'share_location_with_friends': 'मित्रों के साथ स्थान साझा करें',
      'update_location_every_2_hours': 'हर 2 घंटे में स्थान अपडेट करें',
      'location_services': 'स्थान सेवाएं',
      'show_nearby_earthquakes': 'निकटवर्ती भूकंप दिखाएं',
      'background_refresh': 'पृष्ठभूमि रीफ्रेश',
      'update_data_when_closed': 'ऐप बंद होने पर डेटा अपडेट करें',
      'clear_cache': 'कैश साफ करें',
      'delete_stored_data': 'संग्रहीत डेटा हटाएं',
      'rate_us': 'हमें रेट करें',
      'rate_on_app_store': 'ऐप स्टोर पर रेट करें',
      'go_pro': 'प्रो में जाएं',
      'unlock_all_features': 'सभी सुविधाओं को अनलॉक करें',
      'about_app': 'ऐप के बारे में',
      'terms_and_privacy': 'उपयोग की शर्तें और गोपनीयता',
      'report_bug': 'बग रिपोर्ट करें',
      'having_issues': 'समस्याएं हैं?',
      'account': 'खाता',
      'logout_from_account': 'अपने खाते से लॉग आउट करें',
      'other': 'अन्य',
      'earthquake_magnitude_range': 'भूकंप तीव्रता सीमा',
      'minimum': 'न्यूनतम',
      'maximum': 'अधिकतम',
      'earthquakes_between_shown':
          '{min}-{max} Mw के बीच के भूकंप दिखाए जाएंगे',
      'magnitude_range_set': 'तीव्रता सीमा {min}-{max} पर सेट की गई',
      'rate_us_title': 'हमें रेट करें',
      'do_you_like_app':
          'क्या आपको भूकंप लाइन पसंद है? आप ऐप स्टोर पर रेटिंग देकर हमारा समर्थन कर सकते हैं!',
      'rate': 'रेट करें',
      'opening_app_store': 'ऐप स्टोर खोला जा रहा है...',
      'pro_version': 'प्रो संस्करण',
      'pro_features': 'प्रो सुविधाएं:',
      'ad_free': '🚫 विज्ञापन मुक्त अनुभव',
      'detailed_analysis': '📊 विस्तृत भूकंप विश्लेषण',
      'priority_notifications': '🔔 प्राथमिकता सूचनाएं',
      'advanced_location': '📍 उन्नत स्थान ट्रैकिंग',
      'historical_analysis': '📈 ऐतिहासिक डेटा विश्लेषण',
      'custom_themes': '🎨 कस्टम थीम',
      'per_year': '/ वर्ष',
      'purchase': 'खरीदें',
      'starting_purchase': 'खरीदारी शुरू हो रही है...',
      'how_far_notifications':
          'आप कितनी दूर तक सूचनाएं प्राप्त करना चाहते हैं?',
      'between_km': '10 कि.मी. - 1000 कि.मी. के बीच',
      'radius_set': 'सूचना त्रिज्या {radius} कि.मी. पर सेट की गई',
      'your_location_shared': 'आपका स्थान मित्रों के साथ साझा किया जा रहा है',
      'location_sharing_off': 'स्थान साझाकरण अक्षम',
      'clear_cache_title': 'कैश साफ करें',
      'clear_cache_confirm':
          'सभी कैश किया गया डेटा हटा दिया जाएगा। क्या आप जारी रखना चाहते हैं?',
      'cache_cleared': 'कैश साफ किया गया',
      'clear': 'साफ करें',
      'earthquake_line': 'भूकंप लाइन',
      'comprehensive_app': 'तुर्की का सबसे व्यापक भूकंप ट्रैकिंग ऐप',
      'all_rights_reserved': 'सर्वाधिकार सुरक्षित।',
      'logout_title': 'लॉग आउट',
      'logout_confirm': 'क्या आप वाकई लॉग आउट करना चाहते हैं?',
      'logged_out': 'लॉग आउट किया गया',
      'bug_report_opening': 'बग रिपोर्ट फॉर्म खोला जा रहा है...',
      'whistle_play': 'सीटी बजाएं',
      'whistle_playing_signal': '🔊 सीटी बज रही है - अपना स्थान संकेत करें!',
      'whistle_use_debris':
          'मलबे के नीचे फंसे होने पर अपना स्थान संकेत करने के लिए उपयोग करें',
      'whistle_help_rescue':
          'सीटी बज रही है! बचाव दलों को आपको खोजने में मदद करें।',
      'version_text': 'संस्करण',
      'build_text': 'बिल्ड',

      // Location Permission Dialog
      'backgroundLocationTitle': 'पृष्ठभूमि स्थान अनुमति आवश्यक',
      'locationPermissionTitle': 'स्थान अनुमति आवश्यक',
      'backgroundLocationMessage':
          'यह ऐप भूकंप प्रारंभिक चेतावनी प्रणाली के लिए पृष्ठभूमि में आपके स्थान डेटा तक पहुंचना चाहता है।',
      'locationPermissionMessage':
          'यह ऐप आपको निकटतम भूकंप जानकारी दिखाने के लिए आपके स्थान डेटा तक पहुंचना चाहता है।',
      'backgroundLocationReason1': 'ऐप बंद होने पर भी भूकंप का पता लगाना',
      'backgroundLocationReason2':
          'स्थान-विशिष्ट वास्तविक समय भूकंप चेतावनियां',
      'backgroundLocationReason3': 'P2P भूकंप पहचान नेटवर्क में भाग लेना',
      'locationReason1': 'आपके निकटतम भूकंप दिखाना',
      'locationReason2': 'स्थान-आधारित भूकंप सूचनाएं',
      'locationReason3': 'भूकंप मानचित्र पर आपका स्थान दिखाना',
      'locationPrivacyNote':
          'आपका स्थान डेटा केवल भूकंप प्रारंभिक चेतावनी प्रणाली के लिए उपयोग किया जाता है और तीसरे पक्षों के साथ साझा नहीं किया जाता है।',
      'backgroundLocationNote':
          'नोट: आपको अगली स्क्रीन पर "हमेशा अनुमति दें" विकल्प चुनना होगा।',
      'deny': 'अस्वीकार करें',
      'allow': 'अनुमति दें',

      // Language Selection
      'please_select_language': 'कृपया अपनी भाषा चुनें',

      // Offline Map
      'download_offline_map': 'ऑफ़लाइन मानचित्र डाउनलोड करें',
      'offline_map_status_checking': 'जांच रहा है...',
      'offline_map_downloading': 'डाउनलोड हो रहा है',
      'offline_map_downloaded': 'डाउनलोड हो गया',
      'offline_map_description': '300 किमी त्रिज्या, ज़ूम 6-14 (~50 MB)',
      'offline_map_download_failed': 'मानचित्र डाउनलोड विफल',
      'offline_map_redownload_info': 'टाइल्स - पुनः डाउनलोड के लिए टैप करें',

      // Friends Screen
      'please_enter_friend_code': 'कृपया मित्र कोड दर्ज करें',
      'friend_request_sent': 'मित्र अनुरोध भेजा गया!',
      'show_location': 'स्थान दिखाएं',
      'remove_friendship': 'मित्रता हटाएं',
      'reject': 'अस्वीकार करें',
      'accept': 'स्वीकार करें',
      'code_copied': 'कोड कॉपी हो गया!',
      'remove_from_friends': 'मित्र सूची से हटाएं',
      'remove': 'हटाएं',
      'friend_removed': 'मित्र सूची से हटाया गया',
      'close': 'बंद करें',
      'last_update': 'अंतिम अपडेट',
      'coordinates': 'निर्देशांक',
      'show_on_map': 'मानचित्र पर दिखाएं',
      'map_feature_coming_soon': 'मानचित्र सुविधा जल्द आ रही है',

      // Login Screen
      'login_failed':
          'लॉगिन विफल। Google खाता चयन रद्द कर दिया गया या कोई त्रुटि हुई।',
      'login_error': 'लॉगिन त्रुटि',
      'guest_user': 'अतिथि उपयोगकर्ता',
      'guest_login_failed': 'अतिथि लॉगिन विफल',
      'continue_as_guest': 'अतिथि के रूप में जारी रखें',

      // Developer Section
      'developer': 'डेवलपर',
      'debug_test_mode': 'डिबग और टेस्ट मोड',
      'view_sensor_service_status': 'सेंसर और सेवा की स्थिति देखें',

      // Offline Map Dialog
      'location_permission_required': 'स्थान अनुमति आवश्यक है',
      'offline_map_dialog_title': 'ऑफ़लाइन मानचित्र डाउनलोड करें',
      'offline_map_dialog_description':
          'आपके स्थान के 300 किमी त्रिज्या के भीतर मानचित्र टाइलें डाउनलोड की जाएंगी।',
      'offline_map_zoom_info': '• ज़ूम स्तर: 6-14',
      'offline_map_size_info': '• अनुमानित आकार: ~50 MB',
      'offline_map_duration_info': '• अवधि: ~1-2 मिनट',

      // Chat Screen
      'message_send_failed': 'संदेश नहीं भेजा जा सका। कृपया पुनः प्रयास करें।',
      'active_users_count': 'सक्रिय उपयोगकर्ता',
      'remove_from_favorites': 'पसंदीदा से हटाएं',
      'add_to_favorites': 'पसंदीदा में जोड़ें',
      'active_users': 'सक्रिय उपयोगकर्ता',
      'refresh': 'रीफ़्रेश करें',
      'type_message': 'अपना संदेश लिखें...',
      'no_messages_yet': 'अभी तक कोई संदेश नहीं',
      'send_first_message': 'पहला संदेश भेजें! 👋',
      'join_room_failed': 'कमरे में शामिल नहीं हो सके। कृपया पुनः प्रयास करें।',
      'no_active_users': 'अभी तक कोई सक्रिय उपयोगकर्ता नहीं',
    },
    'fil': {
      // App General
      'app_name': 'Earthquake Line',
      'loading': 'Naglo-load...',
      'error': 'Error',
      'success': 'Tagumpay',
      'cancel': 'Kanselahin',
      'save': 'I-save',
      'delete': 'Tanggalin',
      'edit': 'I-edit',
      'close': 'Isara',
      'ok': 'OK',
      'yes': 'Oo',
      'no': 'Hindi',
      'retry': 'Subukan Muli',
      'back': 'Bumalik',
      'next': 'Susunod',
      'done': 'Tapos Na',
      'search': 'Maghanap',
      'settings': 'Mga Setting',
      'logout': 'Mag-logout',
      'login': 'Mag-login',
      'register': 'Magparehistro',
      'download': 'I-download',
      'tiles': 'tiles',
      'keep_app_open': 'Huwag isara ang app habang nagda-download.',

      // Language Selection
      'select_language': 'Pumili ng Wika',
      'language': 'Wika',
      'turkish': 'Turkish',
      'english': 'English',
      'spanish': 'Spanish',
      'hindi': 'Hindi',
      'filipino': 'Filipino',
      'myanmar': 'Myanmar',
      'language_changed': 'Nabago ang wika',
      'welcome_select_language':
          'Maligayang pagdating! Pakiselect ang inyong wika',
      'continue_text': 'Magpatuloy',

      // Bottom Navigation
      'nav_map': 'Mapa',
      'nav_list': 'Lista',
      'nav_friends': 'Mga Kaibigan',
      'nav_profile': 'Profile',

      // Map Screen
      'earthquake_map': 'Mapa ng Lindol',
      'show_fault_lines': 'Ipakita ang mga Fault Lines',
      'hide_fault_lines': 'Itago ang mga Fault Lines',
      'show_friends': 'Ipakita ang mga Kaibigan',
      'hide_friends': 'Itago ang mga Kaibigan',
      'my_location': 'Aking Lokasyon',
      'earthquake_details': 'Detalye ng Lindol',
      'earthquake_info': 'Impormasyon ng Lindol',
      'magnitude': 'Magnitude',
      'depth': 'Lalim',
      'distance': 'Distansya',
      'location': 'Lokasyon',
      'time': 'Oras',
      'source': 'Pinagmulan',
      'km': 'km',
      'km_away': 'km ang layo',
      'minutes_ago': 'minuto na ang nakalipas',
      'hours_ago': 'oras na ang nakalipas',
      'days_ago': 'araw na ang nakalipas',
      'just_now': 'Kakaganap lang',

      // Earthquake List
      'earthquake_list': 'Listahan ng Lindol',
      'no_earthquakes': 'Walang nahanap na lindol',
      'last_24_hours': 'Huling 24 na Oras',
      'last_week': 'Nakaraang Linggo',
      'last_month': 'Nakaraang Buwan',
      'all_earthquakes': 'Lahat ng Lindol',
      'filter': 'I-filter',
      'sort_by': 'Pagbukud-bukurin',
      'newest_first': 'Pinakabago Una',
      'oldest_first': 'Pinakaluma Una',
      'highest_magnitude': 'Pinakamataas na Magnitude',
      'nearest_first': 'Pinakamalapit Una',

      // Friends Screen
      'friends': 'Mga Kaibigan',
      'add_friend': 'Magdagdag ng Kaibigan',
      'friend_requests': 'Mga Kahilingan sa Kaibigan',
      'pending_requests': 'Mga Nakabinbin na Kahilingan',
      'no_friends': 'Wala pang mga kaibigan',
      'search_friends': 'Maghanap ng kaibigan...',
      'send_request': 'Magpadala ng Kahilingan',
      'accept': 'Tanggapin',
      'reject': 'Tanggihan',
      'remove_friend': 'Alisin ang Kaibigan',
      'friend_location': 'Lokasyon ng Kaibigan',
      'last_seen': 'Huling nakita',
      'online': 'Online',
      'offline': 'Offline',

      // Profile Screen
      'profile': 'Profile',
      'edit_profile': 'I-edit ang Profile',
      'my_reports': 'Aking mga Ulat',
      'notification_history': 'Kasaysayan ng Notification',
      'emergency_contacts': 'Mga Emergency Contact',
      'help_support': 'Tulong at Suporta',
      'about': 'Tungkol sa',
      'privacy_policy': 'Patakaran sa Privacy',
      'terms_of_service': 'Mga Tuntunin ng Serbisyo',
      'version': 'Bersyon',

      // Settings Screen
      'settings_title': 'Mga Setting',
      'appearance': 'Hitsura',
      'dark_theme': 'Madilim na Theme',
      'dark_map_theme': 'Madilim na Tema ng Mapa',
      'notifications': 'Mga Notification',
      'notification_sound': 'Tunog ng Notification',
      'vibration': 'Vibration',
      'background_notifications': 'Mga Notification sa Background',
      'earthquake_settings': 'Mga Setting ng Lindol',
      'notification_radius': 'Radius ng Notification',
      'min_magnitude': 'Minimum na Magnitude',
      'max_magnitude': 'Maximum na Magnitude',
      'location_settings': 'Mga Setting ng Lokasyon',
      'share_location': 'Ibahagi ang Lokasyon sa mga Kaibigan',
      'location_update_interval': 'Interval ng Pag-update ng Lokasyon',
      'earthquake_detection': 'Serbisyo ng Pagtuklas ng Lindol',
      'earthquake_detection_desc':
          'Tuklasin ang lindol gamit ang mga sensor ng device',
      'whistle': 'Emergency Whistle',
      'whistle_desc': 'Malakas na tunog ng whistle para sa emergency',
      'play_whistle': 'I-play ang Whistle',
      'stop_whistle': 'Itigil ang Whistle',
      'battery_info': 'Impormasyon ng Baterya',
      'app_settings': 'Mga Setting ng App',

      // Earthquake Alert
      'earthquake_alert': 'ALERTO NG LINDOL!',
      'earthquake_detected': 'May Natukoy na Lindol',
      'take_cover': 'Magtago!',
      'stay_safe': 'Manatiling Ligtas',
      'emergency_call': 'Emergency Call',
      'share_status': 'Ibahagi ang Status',
      'i_am_safe': 'Ligtas Ako',
      'i_need_help': 'Kailangan ko ng Tulong',
      'report_earthquake': 'I-report ang Lindol',
      'take_cover_message':
          'Pumasok sa ilalim ng mesa o lumipat sa ligtas na lugar',
      'alert_take_cover_now': 'MAGTAGO NA NGAYON!',
      'alert_be_prepared': 'MAGING HANDA!',
      'shaking_arriving_in': 'Lindol sa {n} s',

      // Report Screen
      'report': 'Ulat',
      'report_earthquake_title': 'I-report ang Lindol',
      'did_you_feel': 'Naramdaman mo ba ang lindol?',
      'intensity': 'Intensity',
      'describe_experience': 'Ilarawan ang inyong karanasan',
      'submit_report': 'Isumite ang Ulat',
      'report_submitted': 'Matagumpay na naisumite ang ulat',
      'report_failed': 'Nabigo ang pagsusumite ng ulat',
      'which_city': 'Aling Lungsod',
      'search_city': 'Maghanap ng lungsod...',
      'select_city': 'Pakipili ang isang lungsod',
      'earthquake_reported': 'Nag-ulat ng lindol sa {city}!',
      'report_button': 'I-report',
      'estimated_magnitude': 'Tinatayang Magnitude',
      'selected': 'Napili',
      'no_results': 'Walang nahanap na resulta',

      // Login Screen
      'welcome': 'Maligayang Pagdating',
      'sign_in_google': 'Mag-sign in gamit ang Google',
      'sign_in_email': 'Mag-sign in gamit ang Email',
      'email': 'Email',
      'password': 'Password',
      'forgot_password': 'Nakalimutan ang Password?',
      'no_account': 'Wala kang account?',
      'create_account': 'Gumawa ng Account',

      // Error Messages
      'error_connection': 'Error sa koneksyon. Pakicheck ang inyong internet.',
      'error_location': 'Hindi makuha ang lokasyon. Pakibukas ang GPS.',
      'error_permission':
          'Tinanggihan ang pahintulot. Pakibigay ang mga kinakailangang pahintulot.',
      'error_login': 'Nabigo ang pag-login. Pakisubukan muli.',
      'error_unknown': 'May naganap na hindi kilalang error.',

      // Notifications
      'notification_earthquake': 'Alerto ng Lindol',
      'notification_friend_request': 'Bagong Kahilingan sa Kaibigan',
      'notification_friend_safe': 'Ang Kaibigan ay Ligtas',
      'notification_service_running': 'Aktibo ang pagsubaybay ng lindol',
      'stop': 'Itigil',

      // Additional Settings
      'earthquake_detection_service': 'Serbisyo ng Pagtuklas ng Lindol',
      'earthquake_detection_enabled':
          'Ang serbisyo ng pagtuklas ay tumatakbo kapag nag-cha-charge ang device.',
      'earthquake_detection_disabled':
          'Hindi aktibo ang serbisyo ng pagtuklas.',
      'earthquake_filtering': 'Pag-filter ng Lindol',
      'notification_settings': 'Mga Setting ng Notification',
      'notification_sound_subtitle':
          'I-play ang tunog para sa mga notification ng lindol',
      'vibration_subtitle': 'Mag-vibrate para sa mga notification ng lindol',
      'background_notifications_subtitle':
          'Tumanggap ng mga notification kahit sarado ang app',
      'share_location_subtitle': 'Ibahagi ang inyong lokasyon sa mga kaibigan',
      'earthquake_filter_info':
          'Ang mga lindol sa pagitan ng {min}-{max} ay ipinapakita sa mapa. Makakatanggap kayo ng mga notification para sa mga lindol sa loob ng {radius} km.',
      'notification_sound_on': 'Na-enable ang tunog ng notification',
      'notification_sound_off': 'Na-disable ang tunog ng notification',
      'vibration_on': 'Na-enable ang vibration',
      'vibration_off': 'Na-disable ang vibration',
      'background_notifications_on':
          'Na-enable ang mga background notification',
      'background_notifications_off':
          'Na-disable ang mga background notification',
      'background_service_stopped':
          '⚠️ Tumigil ang background service - Maaaring hindi gumana ang mga notification',
      'background_service_started':
          '✅ Nagsimula ang background service - Makakatanggap kayo ng mga notification kahit sarado ang app',
      'background_service_failed':
          '❌ Nabigo ang pagsimula ng background service',
      'background_active':
          'Aktibo - Makakatanggap kayo ng mga notification kahit sarado ang app',
      'background_inactive':
          'Hindi aktibo - Makakatanggap lang kayo ng mga notification kapag bukas ang app',
      'share_location_on': 'Na-enable ang pagbabahagi ng lokasyon',
      'share_location_off': 'Na-disable ang pagbabahagi ng lokasyon',
      'min_magnitude_set': 'Minimum na magnitude: {value}',
      'max_magnitude_set': 'Maximum na magnitude: {value}',
      'notification_radius_set': 'Radius ng notification: {value} km',
      'detection_enabled': 'Na-enable ang serbisyo ng pagtuklas ng lindol.',
      'detection_disabled': 'Na-disable ang serbisyo ng pagtuklas ng lindol.',
      'current_language': 'Kasalukuyan: Filipino',
      'change_language': 'I-tap para baguhin ang wika',

      // Whistle
      'emergency_whistle': 'Emergency Whistle',
      'emergency_whistle_desc': 'Malakas na tunog ng whistle para sa emergency',
      'whistle_playing': 'Tumutunog ang whistle. I-tap para tigilan.',
      'whistle_stopped': 'Tumigil ang whistle.',

      // Battery
      'battery_status': 'Status ng Baterya',
      'battery_charging': 'Nag-cha-charge',
      'battery_discharging': 'Nag-di-discharge',
      'battery_full': 'Puno',
      'battery_unknown': 'Hindi Alam',

      // Theme
      'theme_settings': 'Mga Setting ng Theme',
      'use_dark_map': 'Gumamit ng madilim na tema ng mapa',

      // Friends
      'friend_added': 'Naidagdag ang kaibigan',
      'friend_removed': 'Naalis ang kaibigan',
      'request_sent': 'Naipadala ang kahilingan sa kaibigan',
      'request_accepted': 'Tinanggap ang kahilingan sa kaibigan',
      'request_rejected': 'Tinanggihan ang kahilingan sa kaibigan',
      'no_pending_requests': 'Walang nakabinbing kahilingan',
      'add_friend_by_email': 'Magdagdag ng kaibigan gamit ang email',
      'enter_email': 'Ilagay ang email address',

      // Earthquake Details
      'felt_it': 'Naramdaman ko',
      'share': 'Ibahagi',
      'navigate': 'Navigate',
      'more_info': 'Higit Pang Impormasyon',
      'epicenter': 'Epicenter',
      'felt_reports': 'Mga Ulat ng Naramdaman',
      'no_felt_reports': 'Wala pang mga ulat ng naramdaman',

      // Time
      'second_ago': 'segundo ang nakalipas',
      'seconds_ago': 'segundo ang nakalipas',
      'minute_ago': 'minuto ang nakalipas',
      'hour_ago': 'oras ang nakalipas',
      'day_ago': 'araw ang nakalipas',
      'ago': 'ang nakalipas',

      // Chat
      'login_required_chat': 'Pakikilang mag-login para ma-access ang chat',
      'loading_chat_rooms': 'Naglo-load ng mga chat room...',
      'unnamed_room': 'Walang Pangalan na Room',
      'members': 'mga miyembro',

      // Map
      'refresh': 'I-refresh',
      'center_on_location': 'I-center sa aking lokasyon',
      'loading_earthquakes': 'Naglo-load ng mga lindol...',
      'no_earthquakes_in_range': 'Walang mga lindol sa napiling range',
      'total_earthquakes': 'Kabuuan: {count} lindol',

      // Tools
      'tools': 'Mga Gamit',
      'start': 'Simulan',
      'whistle_help':
          'Gamitin para ipahiwatig ang inyong lokasyon kapag nakakulong sa ilalim ng guho',
      'whistle_active':
          '🔊 Tumutunog ang whistle - Ipahiwatig ang inyong lokasyon!',
      'whistle_warning':
          'Tumutunog ang whistle! Tulungan ang mga rescue team na mahanap kayo.',
      'whistle_started': '🔊 Nagsimula ang whistle!',

      // Settings Details
      'dark_theme_active': 'Aktibo ang madilim na theme',
      'light_theme_active': 'Aktibo ang maliwanag na theme',
      'dark_map_active': 'Madilim na tema ng mapa',
      'light_map_active': 'Maliwanag na tema ng mapa',
      'auto_notification_service': 'Automatic na Serbisyo ng Notification',
      'auto_start_enabled':
          'Awtomatikong nagsisimula ang serbisyo sa pagbukas ng app',
      'auto_start_disabled': 'Hindi awtomatikong nagsisimula ang serbisyo',
      'auto_notification_enabled':
          'Na-enable ang automatic na serbisyo ng notification.',
      'auto_notification_disabled':
          'Na-disable ang automatic na serbisyo ng notification.',
      'settings_auto_save':
          'Awtomatikong nase-save ang inyong mga setting at ina-apply sa susunod na pagbukas.',
      'language_selection': 'Pagpili ng Wika',

      // Battery Optimization
      'battery_optimization': 'Pag-optimize ng Baterya',
      'battery_optimization_title': 'Kinakailangan ang Pag-optimize ng Baterya',
      'battery_optimization_description':
          'Kinakailangan para gumana nang maayos ang pagsubaybay sa background',
      'battery_optimization_message':
          'Para gumana nang maayos ang mga background notification, kailangan ninyong i-disable ang pag-optimize ng baterya para sa app na ito. Kung hindi, maaaring patayin ng system ang app para makatipid ng baterya at makakaligtaan ninyo ang mga notification ng lindol.',
      'battery_optimization_hint':
          'Piliin ang "Unrestricted" o "Don\'t optimize" sa mga setting ng baterya',
      'battery_optimization_still_on':
          '⚠️ Aktibo pa rin ang pag-optimize ng baterya. Maaaring hindi gumana nang maayos ang mga background notification.',
      'battery_optimization_disabled': 'Na-disable ang pag-optimize ng baterya',
      'battery_optimization_enabled': 'Aktibo ang pag-optimize ng baterya',
      'disable_battery_optimization': 'I-disable ang Pag-optimize ng Baterya',
      'battery_optimization_success':
          'Matagumpay na na-disable ang pag-optimize ng baterya',
      'battery_optimization_failed':
          'Pakikilang i-disable ang pag-optimize ng baterya sa mga setting',
      'later': 'Mamaya na',
      'open_settings': 'Buksan ang Settings',

      // Friends Screen Additional
      'user': 'User',
      'my_share_code': 'Aking Share Code',
      'friend_share_code': 'Share Code ng Kaibigan',
      'copy': 'Kopyahin',
      'share_code_copied': 'Nakopya ang share code',
      'enter_share_code': 'Pakikilang maglagay ng share code',
      'share_code_length': 'Ang share code ay dapat 6 characters',
      'data_load_failed': 'Hindi ma-load ang data',
      'unknown': 'Hindi Alam',
      'incoming_requests': 'Papasok',
      'outgoing_requests': 'Papalabas',
      'no_incoming_requests': 'Walang papasok na kahilingan',
      'no_outgoing_requests': 'Walang papalabas na kahilingan',
      'add_friend_hint':
          'Magdagdag ng mga kaibigan sa pamamagitan ng paglagay ng share code sa itaas',
      'request_accept_failed': 'Hindi matanggap ang kahilingan',
      'request_reject_failed': 'Hindi matanggihan ang kahilingan',
      'remove': 'Alisin',
      'remove_friend_title': 'Alisin ang Kaibigan',
      'remove_friend_confirm': 'Alisin si {name} sa mga kaibigan?',
      'friend_removed_success': 'Naalis si {name} sa mga kaibigan',
      'friend_remove_failed': 'Hindi maalis ang kaibigan',
      'waiting_for_approval': 'Naghihintay ng approval',

      // History Screen
      'filter_all': 'Lahat',
      'filter_today': 'Ngayon',
      'filter_this_week': 'Linggong Ito',
      'filter_this_month': 'Buwang Ito',
      'no_earthquake_records': 'Walang nahanap na mga tala ng lindol',
      'unknown_location': 'Hindi Alam ang Lokasyon',
      'intensity_severe': 'Matindi',
      'intensity_noticeable': 'Napapansin',
      'intensity_light': 'Magaan',
      'intensity_very_light': 'Napakagaan',
      'min_ago': 'min ang nakalipas',
      'hours_ago_short': 'oras ang nakalipas',
      'magnitude_label': 'Magnitude',
      'distance_label': 'Distansya',

      // Map Screen Additional
      'latest_earthquake': 'Pinakabagong Lindol',
      'earthquakes': 'Mga Lindol',
      'assembly_areas': 'Mga Assembly Area',
      'fault_lines': 'Mga Fault Line',

      // Navigation
      'chat_rooms': 'Mga Chat Room',
      'past_earthquakes': 'Mga Nakaraang Lindol',
      'chat': 'Chat',
      'history': 'Kasaysayan',
      'map_refreshed': 'Na-refresh ang mapa',

      // Months
      'month_january': 'Enero',
      'month_february': 'Pebrero',
      'month_march': 'Marso',
      'month_april': 'Abril',
      'month_may': 'Mayo',
      'month_june': 'Hunyo',
      'month_july': 'Hulyo',
      'month_august': 'Agosto',
      'month_september': 'Setyembre',
      'month_october': 'Oktubre',
      'month_november': 'Nobyembre',
      'month_december': 'Disyembre',

      // Days
      'day_monday': 'Lunes',
      'day_tuesday': 'Martes',
      'day_wednesday': 'Miyerkules',
      'day_thursday': 'Huwebes',
      'day_friday': 'Biyernes',
      'day_saturday': 'Sabado',
      'day_sunday': 'Linggo',

      // Magnitude descriptions
      'mag_micro': 'Micro lindol',
      'mag_very_light': 'Napakagaan',
      'mag_light': 'Magaan',
      'mag_medium': 'Katamtaman',
      'mag_strong': 'Malakas',
      'mag_very_strong': 'Napakalakas',
      'mag_destructive': 'Mapangwasak',

      // Map additional
      'unknown_user': 'Hindi Alam',
      'capacity': 'Kapasidad',
      'type': 'Uri',
      'persons': 'mga tao',
      'invalid_timestamp': 'Invalid na timestamp type',
      'no_date_info': 'Walang impormasyon ng petsa',

      // Chat additional
      'no_messages_yet': 'Wala pang mga mensahe',
      'no_active_users': 'Wala pang mga active na user',
      'active_users': 'Mga Active na User',
      'send_first_message': 'Magpadala ng unang mensahe! 👋',

      // Alarm
      'take_shelter': 'MAGTAGO',
      'magnitude_display': 'MAGNITUDE',

      // Sensor
      'no_saved_sessions': 'Walang naka-save na mga session',
      'export': 'I-export',
      'delete_all': 'Tanggalin Lahat',
      'no_recordings': 'Wala pang mga recording',

      // Settings Page Additional
      'allow_notifications': 'Payagan ang mga Notification',
      'receive_earthquake_notifications':
          'Tumanggap ng mga notification ng lindol',
      'minimum_magnitude': 'Minimum na Magnitude',
      'between_mw': 'Sa pagitan ng {min}-{max} Mw',
      'notification_radius_setting': 'Radius ng Notification',
      'earthquakes_within_km': 'Mga lindol sa loob ng {radius} km',
      'sound_alert': 'Alerto ng Tunog',
      'device_vibrate': 'I-vibrate ang device',
      'share_location_with_friends': 'Ibahagi ang Lokasyon sa mga Kaibigan',
      'update_location_every_2_hours': 'I-update ang lokasyon kada 2 oras',
      'location_services': 'Mga Serbisyo ng Lokasyon',
      'show_nearby_earthquakes': 'Ipakita ang malapit na mga lindol',
      'background_refresh': 'Background Refresh',
      'update_data_when_closed': 'I-update ang data kapag sarado ang app',
      'clear_cache': 'I-clear ang Cache',
      'delete_stored_data': 'Tanggalin ang naka-store na data',
      'rate_us': 'I-rate Kami',
      'rate_on_app_store': 'I-rate sa App Store',
      'go_pro': 'Mag-upgrade sa Pro',
      'unlock_all_features': 'I-unlock ang lahat ng features',
      'about_app': 'Tungkol sa App',
      'terms_and_privacy': 'Mga tuntunin ng paggamit at privacy',
      'report_bug': 'I-report ang Bug',
      'having_issues': 'May mga problema?',
      'account': 'Account',
      'logout_from_account': 'Mag-logout sa inyong account',
      'other': 'Iba Pa',
      'earthquake_magnitude_range': 'Range ng Magnitude ng Lindol',
      'minimum': 'Minimum',
      'maximum': 'Maximum',
      'earthquakes_between_shown':
          'Ipapakita ang mga lindol sa pagitan ng {min}-{max} Mw',
      'magnitude_range_set': 'Naitakda ang range ng magnitude sa {min}-{max}',
      'rate_us_title': 'I-rate Kami',
      'do_you_like_app':
          'Gusto ninyo ba ang Earthquake Line? Maaari kayong sumuporta sa amin sa pamamagitan ng pag-rate sa App Store!',
      'rate': 'I-rate',
      'opening_app_store': 'Binubuksan ang App Store...',
      'pro_version': 'Pro Version',
      'pro_features': 'Mga Pro feature:',
      'ad_free': '🚫 Walang ads',
      'detailed_analysis': '📊 Detalyadong pagsusuri ng lindol',
      'priority_notifications': '🔔 Pangunahing mga notification',
      'advanced_location': '📍 Advanced na pagsubaybay ng lokasyon',
      'historical_analysis': '📈 Pagsusuri ng makasaysayang data',
      'custom_themes': '🎨 Mga custom na tema',
      'per_year': '/ Taon',
      'purchase': 'Bumili',
      'starting_purchase': 'Sinisimulan ang pagbili...',
      'how_far_notifications':
          'Gaano kalayo ang gusto ninyong makatanggap ng mga notification?',
      'between_km': 'Sa pagitan ng 10 km - 1000 km',
      'radius_set': 'Naitakda ang radius ng notification sa {radius} km',
      'your_location_shared': 'Ibinabahagi ang inyong lokasyon sa mga kaibigan',
      'location_sharing_off': 'Na-disable ang pagbabahagi ng lokasyon',
      'clear_cache_title': 'I-clear ang Cache',
      'clear_cache_confirm':
          'Tatanggalin ang lahat ng naka-cache na data. Gusto ninyong magpatuloy?',
      'cache_cleared': 'Na-clear ang cache',
      'clear': 'I-clear',
      'earthquake_line': 'Earthquake Line',
      'comprehensive_app':
          'Ang pinaka-komprehensibong earthquake tracking app ng Turkey',
      'all_rights_reserved': 'Lahat ng karapatan ay nakalaan.',
      'logout_title': 'Mag-logout',
      'logout_confirm': 'Sigurado kayong gusto ninyong mag-logout?',
      'logged_out': 'Nag-logout na',
      'bug_report_opening': 'Binubuksan ang bug report form...',
      'whistle_play': 'I-play ang Whistle',
      'whistle_playing_signal':
          '🔊 Tumutunog ang whistle - Ipahiwatig ang inyong lokasyon!',
      'whistle_use_debris':
          'Gamitin para ipahiwatig ang inyong lokasyon kapag nakakulong sa ilalim ng guho',
      'whistle_help_rescue':
          'Tumutunog ang whistle! Tulungan ang mga rescue team na mahanap kayo.',
      'version_text': 'Bersyon',
      'build_text': 'Build',

      // Location Permission Dialog
      'backgroundLocationTitle':
          'Kinakailangan ang Pahintulot sa Background Location',
      'locationPermissionTitle': 'Kinakailangan ang Pahintulot sa Lokasyon',
      'backgroundLocationMessage':
          'Ang app na ito ay nais na ma-access ang inyong location data sa background para sa earthquake early warning system.',
      'locationPermissionMessage':
          'Ang app na ito ay nais na ma-access ang inyong location data para maipakita sa inyo ang pinakamalapit na impormasyon ng lindol.',
      'backgroundLocationReason1': 'Pagtuklas ng lindol kahit sarado ang app',
      'backgroundLocationReason2':
          'Real-time na mga alerto ng lindol na nakabatay sa lokasyon',
      'backgroundLocationReason3':
          'Makilahok sa P2P earthquake detection network',
      'locationReason1': 'Ipakita ang pinakamalapit na mga lindol sa inyo',
      'locationReason2': 'Mga notification ng lindol na nakabatay sa lokasyon',
      'locationReason3': 'Ipakita ang inyong lokasyon sa earthquake map',
      'locationPrivacyNote':
          'Ang inyong location data ay ginagamit lamang para sa earthquake early warning system at hindi ibinabahagi sa mga third party.',
      'backgroundLocationNote':
          'Tandaan: Kailangan ninyong piliin ang "Allow all the time" option sa susunod na screen.',
      'deny': 'Tanggihan',
      'allow': 'Payagan',

      // Language Selection
      'please_select_language': 'Pumili ng inyong wika',

      // Offline Map
      'download_offline_map': 'I-download ang Offline Map',
      'offline_map_status_checking': 'Sinusuri...',
      'offline_map_downloading': 'Dina-download',
      'offline_map_downloaded': 'Na-download na',
      'offline_map_description': '300 km radius, zoom 6-14 (~50 MB)',
      'offline_map_download_failed': 'Nabigo ang pag-download ng mapa',
      'offline_map_redownload_info': 'tiles - i-tap para i-download muli',

      // Friends Screen
      'please_enter_friend_code': 'Pakilagay ang friend code',
      'friend_request_sent': 'Naipadala ang friend request!',
      'show_location': 'Ipakita ang Lokasyon',
      'remove_friendship': 'Alisin ang Kaibigan',
      'reject': 'Tanggihan',
      'accept': 'Tanggapin',
      'code_copied': 'Nakopya ang code!',
      'remove_from_friends': 'Alisin sa Listahan ng Kaibigan',
      'remove': 'Alisin',
      'friend_removed': 'Inalis sa listahan ng kaibigan',
      'close': 'Isara',
      'last_update': 'Huling update',
      'coordinates': 'Mga koordinado',
      'show_on_map': 'Ipakita sa Mapa',
      'map_feature_coming_soon': 'Malapit nang dumating ang map feature',

      // Login Screen
      'login_failed':
          'Nabigo ang pag-login. Kinansela ang pagpili ng Google account o may naganap na error.',
      'login_error': 'May error sa pag-login',
      'guest_user': 'Bisitang User',
      'guest_login_failed': 'Nabigo ang pag-login bilang bisita',
      'continue_as_guest': 'Magpatuloy bilang bisita',

      // Developer Section
      'developer': 'Developer',
      'debug_test_mode': 'Debug & Test Mode',
      'view_sensor_service_status': 'Tingnan ang status ng sensor at serbisyo',

      // Offline Map Dialog
      'location_permission_required': 'Kailangan ng pahintulot sa lokasyon',
      'offline_map_dialog_title': 'I-download ang Offline Map',
      'offline_map_dialog_description':
          'Ida-download ang mga map tile sa loob ng 300 km radius mula sa inyong lokasyon.',
      'offline_map_zoom_info': '• Zoom level: 6-14',
      'offline_map_size_info': '• Tinatayang laki: ~50 MB',
      'offline_map_duration_info': '• Tagal: ~1-2 minuto',

      // Chat Screen
      'message_send_failed': 'Hindi naipadala ang mensahe. Pakisubukan muli.',
      'active_users_count': 'aktibong user',
      'remove_from_favorites': 'Alisin sa mga paborito',
      'add_to_favorites': 'Idagdag sa mga paborito',
      'active_users': 'Mga Aktibong User',
      'refresh': 'I-refresh',
      'type_message': 'I-type ang iyong mensahe...',
      'no_messages_yet': 'Wala pang mga mensahe',
      'send_first_message': 'Magpadala ng unang mensahe! 👋',
      'join_room_failed': 'Nabigo ang pagsali sa kwarto. Pakisubukan muli.',
      'no_active_users': 'Wala pang aktibong user',
    },
    'my': {
      // App General
      'app_name': 'ငလျင်လိုင်း',
      'loading': 'ဖွင့်နေသည်...',
      'error': 'အမှား',
      'success': 'အောင်မြင်ပါသည်',
      'cancel': 'ပယ်ဖျက်မည်',
      'save': 'သိမ်းဆည်းမည်',
      'delete': 'ဖျက်မည်',
      'edit': 'တည်းဖြတ်မည်',
      'close': 'ပိတ်မည်',
      'ok': 'OK',
      'yes': 'ဟုတ်ကဲ့',
      'no': 'မဟုတ်ပါ',
      'retry': 'ထပ်လုပ်မည်',
      'back': 'နောက်သို့',
      'next': 'နောက်တစ်ဆင့်',
      'done': 'ပြီးပါပြီ',
      'search': 'ရှာမည်',
      'settings': 'ဆက်တင်များ',
      'logout': 'ထွက်မည်',
      'login': 'ဝင်မည်',
      'register': 'မှတ်ပုံတင်မည်',
      'download': 'ဒေါင်းလုဒ်လုပ်မည်',
      'tiles': 'tiles',
      'keep_app_open': 'ဒေါင်းလုဒ် လုပ်နေစဉ် အက်ပ် မပိတ်ပါနဲ့။',

      // Language Selection
      'select_language': 'ဘာသာစကား ရွေးချယ်ပါ',
      'language': 'ဘာသာစကား',
      'turkish': 'တူရကီ',
      'english': 'အင်္ဂလိပ်',
      'spanish': 'စပိန်',
      'hindi': 'ဟိန္ဒီ',
      'filipino': 'ဖိလစ်ပိုင်',
      'myanmar': 'မြန်မာ',
      'language_changed': 'ဘာသာစကား ပြောင်းလဲပြီးပါပြီ',
      'welcome_select_language': 'ကြိုဆိုပါတယ်! သင့်ဘာသာစကားကို ရွေးချယ်ပါ',
      'continue_text': 'ဆက်လုပ်မည်',

      // Bottom Navigation
      'nav_map': 'မြေပုံ',
      'nav_list': 'စာရင်း',
      'nav_friends': 'သူငယ်ချင်းများ',
      'nav_profile': 'ပရိုဖိုင်',

      // Map Screen
      'earthquake_map': 'ငလျင်မြေပုံ',
      'show_fault_lines': 'အမှားကြောင်းများ ပြရန်',
      'hide_fault_lines': 'အမှားကြောင်းများ ဖျောက်ရန်',
      'show_friends': 'သူငယ်ချင်းများ ပြရန်',
      'hide_friends': 'သူငယ်ချင်းများ ဖျောက်ရန်',
      'my_location': 'ကျွန်ုပ်၏တည်နေရာ',
      'earthquake_details': 'ငလျင်အသေးစိတ်',
      'earthquake_info': 'ငလျင်အချက်အလက်',
      'magnitude': 'ပြင်းအား',
      'depth': 'နက်ရှိုင်းမှု',
      'distance': 'အကွာအဝေး',
      'location': 'တည်နေရာ',
      'time': 'အချိန်',
      'source': 'ရင်းမြစ်',
      'km': 'ကီလိုမီတာ',
      'km_away': 'ကီလိုမီတာ အကွာ',
      'minutes_ago': 'မိနစ် အရင်က',
      'hours_ago': 'နာရီ အရင်က',
      'days_ago': 'ရက် အရင်က',
      'just_now': 'ယခုလေးတင်',

      // Earthquake List
      'earthquake_list': 'ငလျင်စာရင်း',
      'no_earthquakes': 'ငလျင်မတွေ့ပါ',
      'last_24_hours': 'နောက်ဆုံး ၂၄ နာရီ',
      'last_week': 'ပြီးခဲ့သော အပတ်',
      'last_month': 'ပြီးခဲ့သော လ',
      'all_earthquakes': 'ငလျင်အားလုံး',
      'filter': 'စစ်ထုတ်မည်',
      'sort_by': 'စီစဉ်မည်',
      'newest_first': 'အသစ်ဆုံး အရင်',
      'oldest_first': 'အဟောင်းဆုံး အရင်',
      'highest_magnitude': 'အပြင်းဆုံး',
      'nearest_first': 'အနီးဆုံး အရင်',

      // Friends Screen
      'friends': 'သူငယ်ချင်းများ',
      'add_friend': 'သူငယ်ချင်း ထည့်ရန်',
      'friend_requests': 'သူငယ်ချင်း တောင်းခံချက်များ',
      'pending_requests': 'စောင့်ဆိုင်းနေသော တောင်းခံချက်များ',
      'no_friends': 'သူငယ်ချင်း မရှိသေးပါ',
      'search_friends': 'သူငယ်ချင်း ရှာမည်...',
      'send_request': 'တောင်းခံချက် ပေးပို့မည်',
      'accept': 'လက်ခံမည်',
      'reject': 'ငြင်းပယ်မည်',
      'remove_friend': 'သူငယ်ချင်း ဖယ်ရှားမည်',
      'friend_location': 'သူငယ်ချင်း တည်နေရာ',
      'last_seen': 'နောက်ဆုံး မြင်တွေ့ခဲ့သည်',
      'online': 'အွန်လိုင်း',
      'offline': 'အော့ဖ်လိုင်း',

      // Profile Screen
      'profile': 'ပရိုဖိုင်',
      'edit_profile': 'ပရိုဖိုင် တည်းဖြတ်မည်',
      'my_reports': 'ကျွန်ုပ်၏ အစီရင်ခံစာများ',
      'notification_history': 'အကြောင်းကြားချက် မှတ်တမ်း',
      'emergency_contacts': 'အရေးပေါ် ဆက်သွယ်ရန် နံပါတ်များ',
      'help_support': 'အကူအညီနှင့် ပံ့ပိုးမှု',
      'about': 'အကြောင်း',
      'privacy_policy': 'ကိုယ်ရေးအချက်အလက် မူဝါဒ',
      'terms_of_service': 'ဝန်ဆောင်မှု စည်းကမ်းများ',
      'version': 'ဗားရှင်း',

      // Settings Screen
      'settings_title': 'ဆက်တင်များ',
      'appearance': 'အသွင်အပြင်',
      'dark_theme': 'အမှောင်သင့်ဆောင်း',
      'dark_map_theme': 'အမှောင်သင့် မြေပုံ သင့်ဆောင်း',
      'notifications': 'အကြောင်းကြားချက်များ',
      'notification_sound': 'အကြောင်းကြားချက် အသံ',
      'vibration': 'တုန်ခါမှု',
      'background_notifications': 'နောက်ခံ အကြောင်းကြားချက်များ',
      'earthquake_settings': 'ငလျင် ဆက်တင်များ',
      'notification_radius': 'အကြောင်းကြားချက် အကွာအဝေး',
      'min_magnitude': 'အနည်းဆုံး ပြင်းအား',
      'max_magnitude': 'အများဆုံး ပြင်းအား',
      'location_settings': 'တည်နေရာ ဆက်တင်များ',
      'share_location': 'သူငယ်ချင်းများနှင့် တည်နေရာ မျှဝေမည်',
      'location_update_interval': 'တည်နေရာ အပ်ဒိတ် ကြာချိန်',
      'earthquake_detection': 'ငလျင် ရှာဖွေရေး ဝန်ဆောင်မှု',
      'earthquake_detection_desc':
          'စက်ပစ္စည်း အာရုံခံကိရိယာများဖြင့် ငလျင် ရှာဖွေမည်',
      'whistle': 'အရေးပေါ် လေသံ',
      'whistle_desc': 'အရေးပေါ်အတွက် မြင့်မားသော လေသံ',
      'play_whistle': 'လေသံ ဖွင့်မည်',
      'stop_whistle': 'လေသံ ပိတ်မည်',
      'battery_info': 'ဘက်ထရီ အချက်အလက်',
      'app_settings': 'အက်ပလီကေးရှင်း ဆက်တင်များ',

      // Earthquake Alert
      'earthquake_alert': 'ငလျင် သတိပေးချက်!',
      'earthquake_detected': 'ငလျင် ရှာဖွေတွေ့ရှိပြီ',
      'take_cover': 'ဘေးကင်းရာ ရောက်ပါ!',
      'stay_safe': 'လုံခြုံစွာ နေပါ',
      'emergency_call': 'အရေးပေါ် ခေါ်ဆိုမှု',
      'share_status': 'အခြေအနေ မျှဝေမည်',
      'i_am_safe': 'ကျွန်ုပ် ဘေးကင်းပါသည်',
      'i_need_help': 'ကျွန်ုပ် အကူအညီ လိုအပ်ပါသည်',
      'report_earthquake': 'ငလျင် အစီရင်ခံမည်',
      'take_cover_message':
          'စားပွဲအောက်သို့ ရောက်ပါ သို့မဟုတ် ဘေးကင်းသော နေရာသို့ ပြောင်းပါ',
      'alert_take_cover_now': 'ချက်ချင်း ကာကွယ်ပါ!',
      'alert_be_prepared': 'အသင့်ဆင်ပါ!',
      'shaking_arriving_in': 'တုန်ခါမှု {n} s',

      // Report Screen
      'report': 'အစီရင်ခံစာ',
      'report_earthquake_title': 'ငလျင် အစီရင်ခံမည်',
      'did_you_feel': 'ငလျင် ခံစားရပါသလား?',
      'intensity': 'ပြင်းထန်မှု',
      'describe_experience': 'သင့်အတွေ့အကြုံကို ဖော်ပြပါ',
      'submit_report': 'အစီရင်ခံစာ တင်မည်',
      'report_submitted': 'အစီရင်ခံစာ အောင်မြင်စွာ တင်ပြီးပါပြီ',
      'report_failed': 'အစီရင်ခံစာ တင်ရန် မအောင်မြင်ပါ',
      'which_city': 'ဘယ်မြို့',
      'search_city': 'မြို့ ရှာမည်...',
      'select_city': 'ကျေးဇူးပြု၍ မြို့ တစ်ခု ရွေးချယ်ပါ',
      'earthquake_reported': '{city} တွင် ငလျင် အစီရင်ခံခဲ့သည်!',
      'report_button': 'အစီရင်ခံမည်',
      'estimated_magnitude': 'ခန့်မှန်းခြေ ပြင်းအား',
      'selected': 'ရွေးချယ်ပြီး',
      'no_results': 'ရလဒ် မတွေ့ပါ',

      // Login Screen
      'welcome': 'ကြိုဆိုပါတယ်',
      'sign_in_google': 'Google ဖြင့် ဝင်ရောက်မည်',
      'sign_in_email': 'အီးမေးလ်ဖြင့် ဝင်ရောက်မည်',
      'email': 'အီးမေးလ်',
      'password': 'စကားဝှက်',
      'forgot_password': 'စကားဝှက် မေ့နေပါသလား?',
      'no_account': 'အကောင့် မရှိပါသလား?',
      'create_account': 'အကောင့် ဖန်တီးမည်',

      // Error Messages
      'error_connection': 'ချိတ်ဆက်မှု အမှား။ သင့်အင်တာနက်ကို စစ်ဆေးပါ။',
      'error_location': 'တည်နေရာ ရယူ၍ မရပါ။ GPS ကို ဖွင့်ပါ။',
      'error_permission':
          'ခွင့်ပြုချက် ငြင်းပယ်ခံရပါသည်။ လိုအပ်သော ခွင့်ပြုချက်များကို ပေးပါ။',
      'error_login': 'ဝင်ရောက်ရန် မအောင်မြင်ပါ။ ထပ်လုပ်ကြည့်ပါ။',
      'error_unknown': 'မသိသော အမှား ဖြစ်ပွားခဲ့သည်။',

      // Notifications
      'notification_earthquake': 'ငလျင် သတိပေးချက်',
      'notification_friend_request': 'သူငယ်ချင်း တောင်းခံချက် အသစ်',
      'notification_friend_safe': 'သူငယ်ချင်း ဘေးကင်းကြောင်း မှတ်သားထားသည်',
      'notification_service_running': 'ငလျင် စောင့်ကြည့်မှု လုပ်ဆောင်နေသည်',
      'stop': 'ရပ်မည်',

      // Additional Settings
      'earthquake_detection_service': 'ငလျင် ရှာဖွေရေး ဝန်ဆောင်မှု',
      'earthquake_detection_enabled':
          'စက်ပစ္စည်း အားသွင်းနေသည့်အခါ ငလျင် ရှာဖွေရေး ဝန်ဆောင်မှု လုပ်ဆောင်သည်။',
      'earthquake_detection_disabled':
          'ငလျင် ရှာဖွေရေး ဝန်ဆောင်မှု ပိတ်ထားသည်။',
      'earthquake_filtering': 'ငလျင် စစ်ထုတ်ခြင်း',
      'notification_settings': 'အကြောင်းကြားချက် ဆက်တင်များ',
      'notification_sound_subtitle':
          'ငလျင် အကြောင်းကြားချက်များအတွက် အသံ ဖွင့်မည်',
      'vibration_subtitle': 'ငလျင် အကြောင်းကြားချက်များအတွက် တုန်ခါမည်',
      'background_notifications_subtitle':
          'အက်ပလီကေးရှင်း ပိတ်ထားသည့်အခါ အကြောင်းကြားချက်များ လက်ခံမည်',
      'share_location_subtitle': 'သင့်တည်နေရာကို သူငယ်ချင်းများနှင့် မျှဝေပါ',
      'earthquake_filter_info':
          '{min}-{max} အကြား ငလျင်များကို မြေပုံတွင် ပြသသည်။ {radius} ကီလိုမီတာ အတွင်းရှိ ငလျင်များ၏ အကြောင်းကြားချက်များ လက်ခံရမည်။',
      'notification_sound_on': 'အကြောင်းကြားချက် အသံ ဖွင့်ထားသည်',
      'notification_sound_off': 'အကြောင်းကြားချက် အသံ ပိတ်ထားသည်',
      'vibration_on': 'တုန်ခါမှု ဖွင့်ထားသည်',
      'vibration_off': 'တုန်ခါမှု ပိတ်ထားသည်',
      'background_notifications_on': 'နောက်ခံ အကြောင်းကြားချက်များ ဖွင့်ထားသည်',
      'background_notifications_off': 'နောက်ခံ အကြောင်းကြားချက်များ ပိတ်ထားသည်',
      'background_service_stopped':
          '⚠️ နောက်ခံ ဝန်ဆောင်မှု ရပ်ထားသည် - အကြောင်းကြားချက်များ အလုပ်မလုပ်နိုင်ပါ',
      'background_service_started':
          '✅ နောက်ခံ ဝန်ဆောင်မှု စတင်ပြီး - အက်ပလီကေးရှင်း ပိတ်ထားသော်လည်း အကြောင်းကြားချက်များ လက်ခံရမည်',
      'background_service_failed': '❌ နောက်ခံ ဝန်ဆောင်မှု စတင်ရန် မအောင်မြင်ပါ',
      'background_active':
          'လုပ်ဆောင်နေသည် - အက်ပလီကေးရှင်း ပိတ်ထားသော်လည်း အကြောင်းကြားချက်များ လက်ခံရမည်',
      'background_inactive':
          'မလုပ်ဆောင်ပါ - အက်ပလီကေးရှင်း ဖွင့်ထားသည့်အခါသာ အကြောင်းကြားချက်များ လက်ခံရမည်',
      'share_location_on': 'တည်နေရာ မျှဝေခြင်း ဖွင့်ထားသည်',
      'share_location_off': 'တည်နေရာ မျှဝေခြင်း ပိတ်ထားသည်',
      'min_magnitude_set': 'အနည်းဆုံး ပြင်းအား: {value}',
      'max_magnitude_set': 'အများဆုံး ပြင်းအား: {value}',
      'notification_radius_set': 'အကြောင်းကြားချက် အကွာအဝေး: {value} ကီလိုမီတာ',
      'detection_enabled': 'ငလျင် ရှာဖွေရေး ဝန်ဆောင်မှု ဖွင့်ထားပြီးပါပြီ။',
      'detection_disabled': 'ငလျင် ရှာဖွေရေး ဝန်ဆောင်မှု ပိတ်ထားပြီးပါပြီ။',
      'current_language': 'လက်ရှိ: မြန်မာ',
      'change_language': 'ဘာသာစကား ပြောင်းရန် နှိပ်ပါ',

      // Whistle
      'emergency_whistle': 'အရေးပေါ် လေသံ',
      'emergency_whistle_desc': 'အရေးပေါ်အတွက် မြင့်မားသော လေသံ',
      'whistle_playing': 'လေသံ မှုတ်နေသည်။ ရပ်ရန် နှိပ်ပါ။',
      'whistle_stopped': 'လေသံ ရပ်ပြီးပါပြီ။',

      // Battery
      'battery_status': 'ဘက်ထရီ အခြေအနေ',
      'battery_charging': 'အားသွင်းနေသည်',
      'battery_discharging': 'အားထုတ်နေသည်',
      'battery_full': 'ပြည့်ပြီ',
      'battery_unknown': 'မသိပါ',

      // Theme
      'theme_settings': 'သင့်ဆောင်း ဆက်တင်များ',
      'use_dark_map': 'အမှောင်သင့် မြေပုံ သင့်ဆောင်း သုံးမည်',

      // Friends
      'friend_added': 'သူငယ်ချင်း ထည့်ပြီးပါပြီ',
      'friend_removed': 'သူငယ်ချင်း ဖယ်ရှားပြီးပါပြီ',
      'request_sent': 'သူငယ်ချင်း တောင်းခံချက် ပေးပို့ပြီးပါပြီ',
      'request_accepted': 'သူငယ်ချင်း တောင်းခံချက် လက်ခံပြီးပါပြီ',
      'request_rejected': 'သူငယ်ချင်း တောင်းခံချက် ငြင်းပယ်ပြီးပါပြီ',
      'no_pending_requests': 'စောင့်ဆိုင်းနေသော တောင်းခံချက် မရှိပါ',
      'add_friend_by_email': 'အီးမေးလ်ဖြင့် သူငယ်ချင်း ထည့်မည်',
      'enter_email': 'အီးမေးလ် လိပ်စာ ထည့်ပါ',

      // Earthquake Details
      'felt_it': 'ခံစားရပါသည်',
      'share': 'မျှဝေမည်',
      'navigate': 'လမ်းညွှန်မည်',
      'more_info': 'နောက်ထပ် အချက်အလက်',
      'epicenter': 'လှိုင်းမွှား',
      'felt_reports': 'ခံစားရသော အစီရင်ခံစာများ',
      'no_felt_reports': 'ခံစားရသော အစီရင်ခံစာများ မရှိသေးပါ',

      // Time
      'second_ago': 'စက္ကန့် အရင်က',
      'seconds_ago': 'စက္ကန့် အရင်က',
      'minute_ago': 'မိနစ် အရင်က',
      'hour_ago': 'နာရီ အရင်က',
      'day_ago': 'ရက် အရင်က',
      'ago': 'အရင်က',

      // Chat
      'login_required_chat': 'ချတ် ဝင်ရောက်ရန် ကျေးဇူးပြု၍ လော့ဂ်အင်ဝင်ပါ',
      'loading_chat_rooms': 'ချတ် အခန်းများ ဖွင့်နေသည်...',
      'unnamed_room': 'အမည်မဲ့ အခန်း',
      'members': 'အသင်းဝင်များ',

      // Map
      'refresh': 'ပြန်လည် ဖွင့်မည်',
      'center_on_location': 'ကျွန်ုပ်၏တည်နေရာတွင် အလယ်ချမည်',
      'loading_earthquakes': 'ငလျင်များ ဖွင့်နေသည်...',
      'no_earthquakes_in_range': 'ရွေးချယ်ထားသော အကွာအဝေးတွင် ငလျင် မရှိပါ',
      'total_earthquakes': 'စုစုပေါင်း: {count} ငလျင်',

      // Tools
      'tools': 'ကိရိယာများ',
      'start': 'စတင်မည်',
      'whistle_help':
          'အပျက်အစီး အောက်တွင် ပိတ်မိနေသည့်အခါ သင့်တည်နေရာကို ပြရန် အသုံးပြုပါ',
      'whistle_active': '🔊 လေသံ မှုတ်နေသည် - သင့်တည်နေရာကို ပြပါ!',
      'whistle_warning':
          'လေသံ မှုတ်နေသည်! ကယ်ဆယ်ရေး အဖွဲ့များက သင့်ကို ရှာရန် ကူညီပါ။',
      'whistle_started': '🔊 လေသံ စတင်ပြီးပါပြီ!',

      // Settings Details
      'dark_theme_active': 'အမှောင်သင့်ဆောင်း လုပ်ဆောင်နေသည်',
      'light_theme_active': 'အလင်းသင့်ဆောင်း လုပ်ဆောင်နေသည်',
      'dark_map_active': 'အမှောင်သင့် မြေပုံ သင့်ဆောင်း',
      'light_map_active': 'အလင်းသင့် မြေပုံ သင့်ဆောင်း',
      'auto_notification_service': 'အလိုအလျောက် အကြောင်းကြားချက် ဝန်ဆောင်မှု',
      'auto_start_enabled':
          'အက်ပလီကေးရှင်း ဖွင့်သည့်အခါ ဝန်ဆောင်မှု အလိုအလျောက် စတင်သည်',
      'auto_start_disabled': 'ဝန်ဆောင်မှု အလိုအလျောက် မစတင်ပါ',
      'auto_notification_enabled':
          'အလိုအလျောက် အကြောင်းကြားချက် ဝန်ဆောင်မှု ဖွင့်ထားပြီးပါပြီ။',
      'auto_notification_disabled':
          'အလိုအလျောက် အကြောင်းကြားချက် ဝန်ဆောင်မှု ပိတ်ထားပြီးပါပြီ။',
      'settings_auto_save':
          'သင့်ဆက်တင်များကို အလိုအလျောက် သိမ်းဆည်းပြီး နောက်တစ်ကြိမ် ဖွင့်သည့်အခါ အသုံးပြုမည်။',
      'language_selection': 'ဘာသာစကား ရွေးချယ်ခြင်း',

      // Battery Optimization
      'battery_optimization': 'ဘက်ထရီ အကောင်းဆုံး အသုံးပြုခြင်း',
      'battery_optimization_title':
          'ဘက်ထရီ အကောင်းဆုံး အသုံးပြုခြင်း လိုအပ်သည်',
      'battery_optimization_description':
          'နောက်ခံ ငလျင် စောင့်ကြည့်မှု မှန်ကန်စွာ လုပ်ဆောင်ရန် လိုအပ်သည်',
      'battery_optimization_message':
          'နောက်ခံ အကြောင်းကြားချက်များ မှန်ကန်စွာ လုပ်ဆောင်ရန်အတွက်၊ ဤအက်ပလီကေးရှင်းအတွက် ဘက်ထရီ အကောင်းဆုံး အသုံးပြုခြင်းကို ပိတ်ရန် လိုအပ်သည်။ မဟုတ်ပါက၊ စနစ်သည် ဘက်ထရီ သက်သာရန် အက်ပလီကေးရှင်းကို ရပ်နိုင်ပြီး ငလျင် အကြောင်းကြားချက်များကို လက်လွတ်နိုင်သည်။',
      'battery_optimization_hint':
          'ဘက်ထရီ ဆက်တင်များတွင် "Unrestricted" သို့မဟုတ် "Don\'t optimize" ကို ရွေးချယ်ပါ',
      'battery_optimization_still_on':
          '⚠️ ဘက်ထရီ အကောင်းဆုံး အသုံးပြုခြင်း ဖွင့်ထားဆဲ ဖြစ်သည်။ နောက်ခံ အကြောင်းကြားချက်များ မှန်ကန်စွာ အလုပ်မလုပ်နိုင်ပါ။',
      'battery_optimization_disabled':
          'ဘက်ထရီ အကောင်းဆုံး အသုံးပြုခြင်း ပိတ်ထားသည်',
      'battery_optimization_enabled':
          'ဘက်ထရီ အကောင်းဆုံး အသုံးပြုခြင်း ဖွင့်ထားသည်',
      'disable_battery_optimization':
          'ဘက်ထရီ အကောင်းဆုံး အသုံးပြုခြင်း ပိတ်မည်',
      'battery_optimization_success':
          'ဘက်ထရီ အကောင်းဆုံး အသုံးပြုခြင်း အောင်မြင်စွာ ပိတ်ပြီးပါပြီ',
      'battery_optimization_failed':
          'ကျေးဇူးပြု၍ ဘက်ထရီ အကောင်းဆုံး အသုံးပြုခြင်းကို ဆက်တင်များတွင် လက်ဖြင့် ပိတ်ပါ',
      'later': 'နောက်မှ',
      'open_settings': 'ဆက်တင်များ ဖွင့်မည်',

      // Friends Screen Additional
      'user': 'အသုံးပြုသူ',
      'my_share_code': 'ကျွန်ုပ်၏ မျှဝေကုဒ်',
      'friend_share_code': 'သူငယ်ချင်း မျှဝေကုဒ်',
      'copy': 'ကူးယူမည်',
      'share_code_copied': 'မျှဝေကုဒ် ကူးယူပြီးပါပြီ',
      'enter_share_code': 'ကျေးဇူးပြု၍ မျှဝေကုဒ် ထည့်ပါ',
      'share_code_length': 'မျှဝေကုဒ် သည် ၆ လုံး ဖြစ်ရမည်',
      'data_load_failed': 'ဒေတာ ဖွင့်၍ မရပါ',
      'unknown': 'မသိပါ',
      'incoming_requests': 'ဝင်လာသော',
      'outgoing_requests': 'ထွက်သွားသော',
      'no_incoming_requests': 'ဝင်လာသော တောင်းခံချက် မရှိပါ',
      'no_outgoing_requests': 'ထွက်သွားသော တောင်းခံချက် မရှိပါ',
      'add_friend_hint': 'အထက်မှ မျှဝေကုဒ် ထည့်၍ သူငယ်ချင်းများ ထည့်ပါ',
      'request_accept_failed': 'တောင်းခံချက် လက်ခံ၍ မရပါ',
      'request_reject_failed': 'တောင်းခံချက် ငြင်းပယ်၍ မရပါ',
      'remove': 'ဖယ်ရှားမည်',
      'remove_friend_title': 'သူငယ်ချင်း ဖယ်ရှားမည်',
      'remove_friend_confirm': '{name} ကို သူငယ်ချင်းများမှ ဖယ်ရှားမလား?',
      'friend_removed_success': '{name} ကို သူငယ်ချင်းများမှ ဖယ်ရှားပြီးပါပြီ',
      'friend_remove_failed': 'သူငယ်ချင်း ဖယ်ရှား၍ မရပါ',
      'waiting_for_approval': 'ခွင့်ပြုချက် စောင့်ဆိုင်းနေသည်',

      // History Screen
      'filter_all': 'အားလုံး',
      'filter_today': 'ယနေ့',
      'filter_this_week': 'ဒီအပတ်',
      'filter_this_month': 'ဒီလ',
      'no_earthquake_records': 'ငလျင် မှတ်တမ်းများ မတွေ့ပါ',
      'unknown_location': 'မသိသော တည်နေရာ',
      'intensity_severe': 'ပြင်းထန်သော',
      'intensity_noticeable': 'သတိထားမိသော',
      'intensity_light': 'ပေါ့ပါးသော',
      'intensity_very_light': 'အလွန် ပေါ့ပါးသော',
      'min_ago': 'မိနစ် အရင်က',
      'hours_ago_short': 'နာရီ အရင်က',
      'magnitude_label': 'ပြင်းအား',
      'distance_label': 'အကွာအဝေး',

      // Map Screen Additional
      'latest_earthquake': 'နောက်ဆုံး ငလျင်',
      'earthquakes': 'ငလျင်များ',
      'assembly_areas': 'စုရုံးရာ နေရာများ',
      'fault_lines': 'အမှားကြောင်းများ',

      // Navigation
      'chat_rooms': 'ချတ် အခန်းများ',
      'past_earthquakes': 'ယခင် ငလျင်များ',
      'chat': 'ချတ်',
      'history': 'မှတ်တမ်း',
      'map_refreshed': 'မြေပုံ ပြန်လည် ဖွင့်ပြီးပါပြီ',

      // Months
      'month_january': 'ဇန်နဝါရီ',
      'month_february': 'ဖေဖော်ဝါရီ',
      'month_march': 'မတ်',
      'month_april': 'ဧပြီ',
      'month_may': 'မေ',
      'month_june': 'ဇွန်',
      'month_july': 'ဇူလိုင်',
      'month_august': 'သြဂုတ်',
      'month_september': 'စက်တင်ဘာ',
      'month_october': 'အောက်တိုဘာ',
      'month_november': 'နိုဝင်ဘာ',
      'month_december': 'ဒီဇင်ဘာ',

      // Days
      'day_monday': 'တနင်္လာနေ့',
      'day_tuesday': 'အင်္ဂါနေ့',
      'day_wednesday': 'ဗုဒ္ဓဟူးနေ့',
      'day_thursday': 'ကြာသပတေးနေ့',
      'day_friday': 'သောကြာနေ့',
      'day_saturday': 'စနေနေ့',
      'day_sunday': 'တနင်္ဂနွေနေ့',

      // Magnitude descriptions
      'mag_micro': 'အသေးစား ငလျင်',
      'mag_very_light': 'အလွန် ပေါ့ပါးသော',
      'mag_light': 'ပေါ့ပါးသော',
      'mag_medium': 'အလယ်အလတ်',
      'mag_strong': 'ပြင်းသော',
      'mag_very_strong': 'အလွန် ပြင်းသော',
      'mag_destructive': 'ဖျက်ဆီးတတ်သော',

      // Map additional
      'unknown_user': 'မသိပါ',
      'capacity': 'စွမ်းရည်',
      'type': 'အမျိုးအစား',
      'persons': 'လူများ',
      'invalid_timestamp': 'မမှန်ကန်သော timestamp အမျိုးအစား',
      'no_date_info': 'ရက်စွဲ အချက်အလက် မရှိပါ',

      // Chat additional
      'no_messages_yet': 'မက်ဆေ့ချ်များ မရှိသေးပါ',
      'no_active_users': 'တက်ကြွသော အသုံးပြုသူများ မရှိသေးပါ',
      'active_users': 'တက်ကြွသော အသုံးပြုသူများ',
      'send_first_message': 'ပထမဆုံး မက်ဆေ့ချ် ပေးပို့ပါ! 👋',

      // Alarm
      'take_shelter': 'ခိုလှုံရာ ရောက်ပါ',
      'magnitude_display': 'ပြင်းအား',

      // Sensor
      'no_saved_sessions': 'သိမ်းဆည်းထားသော စက်ရှင်များ မရှိပါ',
      'export': 'ထုတ်ယူမည်',
      'delete_all': 'အားလုံး ဖျက်မည်',
      'no_recordings': 'မှတ်တမ်းများ မရှိသေးပါ',

      // Settings Page Additional
      'allow_notifications': 'အကြောင်းကြားချက်များ ခွင့်ပြုမည်',
      'receive_earthquake_notifications': 'ငလျင် အကြောင်းကြားချက်များ လက်ခံမည်',
      'minimum_magnitude': 'အနည်းဆုံး ပြင်းအား',
      'between_mw': '{min}-{max} Mw အကြား',
      'notification_radius_setting': 'အကြောင်းကြားချက် အကွာအဝေး',
      'earthquakes_within_km': '{radius} ကီလိုမီတာ အတွင်းရှိ ငလျင်များ',
      'sound_alert': 'အသံ သတိပေးချက်',
      'device_vibrate': 'စက်ပစ္စည်း တုန်ခါမည်',
      'share_location_with_friends': 'သူငယ်ချင်းများနှင့် တည်နေရာ မျှဝေမည်',
      'update_location_every_2_hours': '၂ နာရီတစ်ကြိမ် တည်နေရာ အပ်ဒိတ်လုပ်မည်',
      'location_services': 'တည်နေရာ ဝန်ဆောင်မှုများ',
      'show_nearby_earthquakes': 'အနီးနားရှိ ငလျင်များ ပြမည်',
      'background_refresh': 'နောက်ခံ ပြန်လည် ဖွင့်ခြင်း',
      'update_data_when_closed':
          'အက်ပလီကေးရှင်း ပိတ်ထားသည့်အခါ ဒေတာ အပ်ဒိတ်လုပ်မည်',
      'clear_cache': 'ကက်ရှ် ဖယ်ရှားမည်',
      'delete_stored_data': 'သိမ်းဆည်းထားသော ဒေတာ ဖျက်မည်',
      'rate_us': 'ကျွန်ုပ်တို့ကို အဆင့်သတ်မှတ်မည်',
      'rate_on_app_store': 'App Store တွင် အဆင့်သတ်မှတ်မည်',
      'go_pro': 'Pro သို့ အဆင့်မြှင့်မည်',
      'unlock_all_features': 'အင်္ဂါရပ်များ အားလုံးကို လော့ခ်ဖွင့်မည်',
      'about_app': 'အက်ပလီကေးရှင်း အကြောင်း',
      'terms_and_privacy': 'အသုံးပြုမှု စည်းကမ်းများနှင့် ကိုယ်ရေးအချက်အလက်',
      'report_bug': 'ချို့ယွင်းချက် အစီရင်ခံမည်',
      'having_issues': 'ပြဿနာများ ရှိပါသလား?',
      'account': 'အကောင့်',
      'logout_from_account': 'သင့်အကောင့်မှ ထွက်မည်',
      'other': 'အခြား',
      'earthquake_magnitude_range': 'ငလျင် ပြင်းအား အပိုင်းအခြား',
      'minimum': 'အနည်းဆုံး',
      'maximum': 'အများဆုံး',
      'earthquakes_between_shown': '{min}-{max} Mw အကြား ငလျင်များကို ပြမည်',
      'magnitude_range_set':
          'ပြင်းအား အပိုင်းအခြားကို {min}-{max} သို့ သတ်မှတ်ပြီးပါပြီ',
      'rate_us_title': 'ကျွန်ုပ်တို့ကို အဆင့်သတ်မှတ်မည်',
      'do_you_like_app':
          'ငလျင်လိုင်းကို ကြိုက်နှစ်သက်ပါသလား? App Store တွင် အဆင့်သတ်မှတ်ပေးခြင်းဖြင့် ကျွန်ုပ်တို့ကို ပံ့ပိုးနိုင်ပါသည်!',
      'rate': 'အဆင့်သတ်မှတ်မည်',
      'opening_app_store': 'App Store ဖွင့်နေသည်...',
      'pro_version': 'Pro ဗားရှင်း',
      'pro_features': 'Pro အင်္ဂါရပ်များ:',
      'ad_free': '🚫 ကြော်ငြာ ကင်းစင်သော အတွေ့အကြုံ',
      'detailed_analysis': '📊 အသေးစိတ် ငလျင် ခွဲခြမ်းစိတ်ဖြာခြင်း',
      'priority_notifications': '🔔 ဦးစားပေး အကြောင်းကြားချက်များ',
      'advanced_location': '📍 အဆင့်မြင့် တည်နေရာ ခြေရာခံခြင်း',
      'historical_analysis': '📈 သမိုင်းဆိုင်ရာ ဒေတာ ခွဲခြမ်းစိတ်ဖြာခြင်း',
      'custom_themes': '🎨 စိတ်ကြိုက် သင့်ဆောင်းများ',
      'per_year': '/ နှစ်',
      'purchase': 'ဝယ်ယူမည်',
      'starting_purchase': 'ဝယ်ယူမှု စတင်နေသည်...',
      'how_far_notifications':
          'မည်မျှ အကွာအဝေးအတွက် အကြောင်းကြားချက်များ လက်ခံလိုပါသလဲ?',
      'between_km': '၁၀ ကီလိုမီတာ - ၁၀၀၀ ကီလိုမီတာ အကြား',
      'radius_set':
          'အကြောင်းကြားချက် အကွာအဝေးကို {radius} ကီလိုမီတာ သို့ သတ်မှတ်ပြီးပါပြီ',
      'your_location_shared': 'သင့်တည်နေရာကို သူငယ်ချင်းများနှင့် မျှဝေနေသည်',
      'location_sharing_off': 'တည်နေရာ မျှဝေခြင်း ပိတ်ထားသည်',
      'clear_cache_title': 'ကက်ရှ် ဖယ်ရှားမည်',
      'clear_cache_confirm':
          'ကက်ရှ်လုပ်ထားသော ဒေတာ အားလုံးကို ဖျက်မည်ဖြစ်သည်။ ဆက်လုပ်လိုပါသလား?',
      'cache_cleared': 'ကက်ရှ် ဖယ်ရှားပြီးပါပြီ',
      'clear': 'ဖယ်ရှားမည်',
      'earthquake_line': 'ငလျင်လိုင်း',
      'comprehensive_app': 'တူရကီ၏ အပြည့်အဝဆုံး ငလျင် ခြေရာခံ အက်ပလီကေးရှင်း',
      'all_rights_reserved': 'မူပိုင်ခွင့် အားလုံး သီးသန့်။',
      'logout_title': 'ထွက်မည်',
      'logout_confirm': 'ထွက်မည်ကို သေချာပါသလား?',
      'logged_out': 'ထွက်ပြီးပါပြီ',
      'bug_report_opening': 'ချို့ယွင်းချက် အစီရင်ခံစာ ဖောင် ဖွင့်နေသည်...',
      'whistle_play': 'လေသံ ဖွင့်မည်',
      'whistle_playing_signal': '🔊 လေသံ မှုတ်နေသည် - သင့်တည်နေရာကို ပြပါ!',
      'whistle_use_debris':
          'အပျက်အစီး အောက်တွင် ပိတ်မိနေသည့်အခါ သင့်တည်နေရာကို ပြရန် အသုံးပြုပါ',
      'whistle_help_rescue':
          'လေသံ မှုတ်နေသည်! ကယ်ဆယ်ရေး အဖွဲ့များက သင့်ကို ရှာရန် ကူညီပါ။',
      'version_text': 'ဗားရှင်း',
      'build_text': 'Build',

      // Location Permission Dialog
      'backgroundLocationTitle': 'နောက်ခံ တည်နေရာ ခွင့်ပြုချက် လိုအပ်သည်',
      'locationPermissionTitle': 'တည်နေရာ ခွင့်ပြုချက် လိုအပ်သည်',
      'backgroundLocationMessage':
          'ဤအက်ပလီကေးရှင်းသည် ငလျင် ကြိုတင် သတိပေးစနစ်အတွက် နောက်ခံတွင် သင့်တည်နေရာ ဒေတာကို ဝင်ရောက်လိုပါသည်။',
      'locationPermissionMessage':
          'ဤအက်ပလီကေးရှင်းသည် သင့်အနီးဆုံး ငလျင် အချက်အလက်ကို ပြရန် သင့်တည်နေရာ ဒေတာကို ဝင်ရောက်လိုပါသည်။',
      'backgroundLocationReason1':
          'အက်ပလီကေးရှင်း ပိတ်ထားသော်လည်း ငလျင် ရှာဖွေခြင်း',
      'backgroundLocationReason2':
          'တည်နေရာ အလိုက် အချိန်နှင့်တစ်ပြေးညီ ငလျင် သတိပေးချက်များ',
      'backgroundLocationReason3': 'P2P ငလျင် ရှာဖွေရေး ကွန်ရက်တွင် ပါဝင်ခြင်း',
      'locationReason1': 'သင့်အနီးဆုံး ငလျင်များကို ပြပါ',
      'locationReason2': 'တည်နေရာ အခြေခံ ငလျင် အကြောင်းကြားချက်များ',
      'locationReason3': 'ငလျင် မြေပုံတွင် သင့်တည်နေရာကို ပြပါ',
      'locationPrivacyNote':
          'သင့်တည်နေရာ ဒေတာကို ငလျင် ကြိုတင် သတိပေးစနစ်အတွက်သာ အသုံးပြုပြီး တတိယ ပါတီများနှင့် မျှဝေခြင်း မရှိပါ။',
      'backgroundLocationNote':
          'မှတ်ချက်: နောက်တစ်မျက်နှာတွင် "Allow all the time" ရွေးချယ်မှုကို ရွေးချယ်ရန် လိုအပ်ပါမည်။',
      'deny': 'ငြင်းပယ်မည်',
      'allow': 'ခွင့်ပြုမည်',

      // Language Selection
      'please_select_language': 'သင့်ဘာသာစကားကို ရွေးချယ်ပါ',

      // Offline Map
      'download_offline_map': 'အော့ဖ်လိုင်း မြေပုံ ဒေါင်းလုဒ်လုပ်မည်',
      'offline_map_status_checking': 'စစ်ဆေးနေသည်...',
      'offline_map_downloading': 'ဒေါင်းလုဒ်လုပ်နေသည်',
      'offline_map_downloaded': 'ဒေါင်းလုဒ်လုပ်ပြီးပါပြီ',
      'offline_map_description': '300 ကီလိုမီတာ အချင်းဝက်, zoom 6-14 (~50 MB)',
      'offline_map_download_failed': 'မြေပုံ ဒေါင်းလုဒ် မအောင်မြင်ပါ',
      'offline_map_redownload_info': 'tiles - ပြန်ဒေါင်းလုဒ်လုပ်ရန် တို့ပါ',

      // Friends Screen
      'please_enter_friend_code': 'သူငယ်ချင်း ကုဒ်ကို ထည့်ပါ',
      'friend_request_sent': 'သူငယ်ချင်း တောင်းဆိုမှု ပေးပို့ပြီးပါပြီ!',
      'show_location': 'တည်နေရာ ပြမည်',
      'remove_friendship': 'သူငယ်ချင်းမှ ဖယ်ရှားမည်',
      'reject': 'ငြင်းပယ်မည်',
      'accept': 'လက်ခံမည်',
      'code_copied': 'ကုဒ် ကူးယူပြီးပါပြီ!',
      'remove_from_friends': 'သူငယ်ချင်း စာရင်းမှ ဖယ်ရှားမည်',
      'remove': 'ဖယ်ရှားမည်',
      'last_update': 'နောက်ဆုံး အပ်ဒိတ်',
      'coordinates': 'ကိုဩဒိနိတ်များ',
      'friend_removed': 'သူငယ်ချင်း စာရင်းမှ ဖယ်ရှားပြီးပါပြီ',
      'close': 'ပိတ်မည်',
      'show_on_map': 'မြေပုံပေါ်တွင် ပြမည်',
      'map_feature_coming_soon': 'မြေပုံ လုပ်ဆောင်ချက် မကြာမီ ရောက်ရှိမည်',

      // Login Screen
      'login_failed':
          'လော့ဂ်အင် မအောင်မြင်ပါ။ Google အကောင့် ရွေးချယ်မှု ပယ်ဖျက်ခံရခြင်း သို့မဟုတ် အမှားတစ်ခု ဖြစ်ပွားခဲ့သည်။',
      'login_error': 'လော့ဂ်အင် အမှား',
      'guest_user': 'ဧည့်သည် အသုံးပြုသူ',
      'guest_login_failed': 'ဧည့်သည် လော့ဂ်အင် မအောင်မြင်ပါ',
      'continue_as_guest': 'ဧည့်သည်အဖြစ် ဆက်လက်လုပ်ဆောင်မည်',

      // Developer Section
      'developer': 'ဒီဗယ်လော့ပါ',
      'debug_test_mode': 'ဒီဗက်နှင့် စမ်းသပ်မှု မုဒ်',
      'view_sensor_service_status':
          'အာရုံခံကိရိယာနှင့် ဝန်ဆောင်မှု အခြေအနေကို ကြည့်ရှုမည်',

      // Offline Map Dialog
      'location_permission_required': 'တည်နေရာ ခွင့်ပြုချက် လိုအပ်ပါသည်',
      'offline_map_dialog_title': 'အော့ဖ်လိုင်း မြေပုံ ဒေါင်းလုဒ်လုပ်မည်',
      'offline_map_dialog_description':
          'သင့်တည်နေရာမှ 300 ကီလိုမီတာ အတွင်းရှိ မြေပုံ tiles များကို ဒေါင်းလုဒ်လုပ်မည်။',
      'offline_map_zoom_info': '• ဇူးမ် အဆင့်: 6-14',
      'offline_map_size_info': '• ခန့်မှန်း အရွယ်အစား: ~50 MB',
      'offline_map_duration_info': '• ကြာချိန်: ~1-2 မိနစ်',

      // Chat Screen
      'message_send_failed':
          'မက်ဆေ့ခ်ျ မပေးပို့နိုင်ပါ။ ကျေးဇူးပြု၍ ထပ်စမ်းကြည့်ပါ။',
      'active_users_count': 'လက်ရှိ အသုံးပြုသူများ',
      'remove_from_favorites': 'အကြိုက်ဆုံးများမှ ဖယ်ရှားမည်',
      'add_to_favorites': 'အကြိုက်ဆုံးများသို့ ထည့်မည်',
      'active_users': 'လက်ရှိ အသုံးပြုသူများ',
      'refresh': 'ပြန်လည်ဖွင့်မည်',
      'type_message': 'သင့်မက်ဆေ့ခ်ျကို ရေးပါ...',
      'no_messages_yet': 'မက်ဆေ့ခ်ျများ မရှိသေးပါ',
      'join_room_failed':
          'အခန်းမှ ဝင်ရောက်ရန် မအောင်မြင်ပါ။ ကျေးဇူးပြု၍ ထပ်စမ်းကြည့်ပါ။',
      'send_first_message': 'ပထမဆုံး မက်ဆေ့ခ်ျ ပို့ပါ! 👋',
      'no_active_users': 'လက်ရှိ အသုံးပြုသူများ မရှိသေးပါ',
    },
  };

  String get(String key) {
    final langCode = locale.languageCode;
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
    return ['en', 'tr', 'es', 'hi', 'fil', 'my'].contains(locale.languageCode);
  }

  @override
  Future<AppLocalizations> load(Locale locale) async {
    return AppLocalizations(locale);
  }

  @override
  bool shouldReload(_AppLocalizationsDelegate old) => false;
}
