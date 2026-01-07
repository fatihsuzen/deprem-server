import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:permission_handler/permission_handler.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../widgets/nav_svg_icon.dart';
// ...existing code...
import '../l10n/app_localizations.dart';
import '../services/permission_service.dart';
import 'map_screen.dart';
import 'friends_page_api.dart';
import 'chat.dart';
import 'history.dart';
import 'settings_page.dart';

class RootScreen extends StatefulWidget {
  const RootScreen({super.key});

  @override
  State<RootScreen> createState() => _RootScreenState();
}

class _RootScreenState extends State<RootScreen> {
  int _selectedIndex = 2; // default to map
  Key _mapScreenKey = UniqueKey();
  bool _permissionsChecked = false;
  // FMTC ve cache kaldırıldı

  @override
  void initState() {
    super.initState();
    // İlk açılışta izinleri kontrol et
    WidgetsBinding.instance.addPostFrameCallback((_) {
      _checkAndRequestPermissions();
    });
  }

  /// İlk açılışta konum izinlerini kontrol et ve gerekiyorsa iste
  Future<void> _checkAndRequestPermissions() async {
    if (_permissionsChecked) return;
    _permissionsChecked = true;

    final prefs = await SharedPreferences.getInstance();
    final hasAskedPermission =
        prefs.getBool('location_permission_asked') ?? false;

    // Eğer daha önce izin istenmemişse, şimdi iste
    if (!hasAskedPermission && mounted) {
      final permissionService = PermissionService();

      // Temel konum iznini iste
      final hasLocationPermission =
          await permissionService.requestLocationPermission(
        context,
        showDialog: true,
      );

      if (hasLocationPermission && mounted) {
        // Arka plan konum iznini iste
        await permissionService.requestBackgroundLocationPermission(
          context,
          showDialog: true,
        );
      }

      // İzin isteme durumunu kaydet (bir daha sorulmasın)
      await prefs.setBool('location_permission_asked', true);
    }
  }

  List<Widget> _getPages() => [
        const FriendsPageAPI(),
        ChatPage(),
        MapScreen(key: _mapScreenKey),
        HistoryPage(),
        SettingsPage(),
      ];

  List<String> _getTitles(AppLocalizations? l10n) => [
        l10n?.get('friends') ?? 'Friends',
        l10n?.get('chat_rooms') ?? 'Chat Rooms',
        l10n?.get('earthquake_map') ?? 'Earthquake Map',
        l10n?.get('past_earthquakes') ?? 'Past Earthquakes',
        l10n?.get('settings') ?? 'Settings',
      ];

  void _onItemTapped(int index) {
    // Ayarlardan haritaya geçildiğinde haritayı yeniden oluştur
    if (_selectedIndex == 4 && index == 2) {
      setState(() {
        _mapScreenKey = UniqueKey(); // Yeni key ile harita yeniden oluşturulur
        _selectedIndex = index;
      });
    } else {
      setState(() {
        _selectedIndex = index;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    final l10n = AppLocalizations.of(context);
    final titles = _getTitles(l10n);

    return Scaffold(
      appBar: AppBar(
        backgroundColor: const Color(0xFFFF3A3D),
        elevation: 0,
        centerTitle: false,
        toolbarHeight: 78,
        title: Padding(
          padding: const EdgeInsets.only(left: 12.0, top: 8.0),
          child: Text(
            titles[_selectedIndex],
            style: const TextStyle(
              color: Colors.white,
              fontSize: 20,
              fontWeight: FontWeight.w600,
            ),
          ),
        ),
        actions: _selectedIndex == 2
            ? [
                Padding(
                  padding: const EdgeInsets.only(right: 12.0),
                  child: Center(
                    child: GestureDetector(
                      onTap: () {
                        ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                            content: Text(l10n?.get('map_refreshed') ??
                                'Map refreshed')));
                      },
                      child: SvgPicture.asset(
                        'assets/Icons/Refresh.svg',
                        colorFilter: const ColorFilter.mode(
                            Colors.white, BlendMode.srcIn),
                        width: 22,
                        height: 22,
                      ),
                    ),
                  ),
                )
              ]
            : null,
      ),
      body: _getPages()[_selectedIndex],
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        backgroundColor: Colors.white,
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
        showSelectedLabels: true,
        showUnselectedLabels: true,
        selectedItemColor: const Color(0xFFFF3A3D),
        unselectedItemColor: Colors.grey,
        items: [
          BottomNavigationBarItem(
            icon: NavSvgIcon(
              assetPath: 'assets/Icons/Friends.svg',
              selected: _selectedIndex == 0,
              width: 26,
              height: 26,
              semanticsLabel: l10n?.get('friends') ?? 'Friends',
            ),
            label: l10n?.get('friends') ?? 'Friends',
          ),
          BottomNavigationBarItem(
            icon: NavSvgIcon(
              assetPath: 'assets/Icons/Chat.svg',
              selected: _selectedIndex == 1,
              width: 26,
              height: 26,
              semanticsLabel: l10n?.get('chat') ?? 'Chat',
            ),
            label: l10n?.get('chat') ?? 'Chat',
          ),
          BottomNavigationBarItem(
            icon: NavSvgIcon(
              assetPath: 'assets/Icons/Map.svg',
              selected: _selectedIndex == 2,
              width: 30,
              height: 30,
              semanticsLabel: l10n?.get('nav_map') ?? 'Map',
            ),
            label: l10n?.get('nav_map') ?? 'Map',
          ),
          BottomNavigationBarItem(
            icon: NavSvgIcon(
              assetPath: 'assets/Icons/History.svg',
              selected: _selectedIndex == 3,
              width: 26,
              height: 26,
              semanticsLabel: l10n?.get('history') ?? 'History',
            ),
            label: l10n?.get('history') ?? 'History',
          ),
          BottomNavigationBarItem(
            icon: NavSvgIcon(
              assetPath: 'assets/Icons/Settings.svg',
              selected: _selectedIndex == 4,
              width: 26,
              height: 26,
              semanticsLabel: l10n?.get('settings') ?? 'Settings',
            ),
            label: l10n?.get('settings') ?? 'Settings',
          ),
        ],
      ),
    );
  }
}
