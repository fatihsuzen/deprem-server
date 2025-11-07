import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import '../widgets/nav_svg_icon.dart';
import 'map_screen.dart';
import 'friends.dart';
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

  final List<Widget> _pages = [
    FriendsPage(),
    ChatPage(),
    MapScreen(),
    HistoryPage(),
    SettingsPage(),
  ];

  final List<String> _titles = [
    'Bağlantılar',
    'Sohbet Odaları',
    'Deprem Haritası',
    'Geçmiş Depremler',
    'Ayarlar'
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: const Color(0xFFFF3A3D),
        elevation: 0,
        centerTitle: false,
        toolbarHeight: 78,
        title: Padding(
          padding: const EdgeInsets.only(left: 12.0, top: 8.0),
          child: Text(
            _titles[_selectedIndex],
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
                        ScaffoldMessenger.of(context).showSnackBar(
                            const SnackBar(content: Text('Harita yenilendi')));
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
      body: _pages[_selectedIndex],
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
              semanticsLabel: 'Bağlantılar',
            ),
            label: 'Bağlantılar',
          ),
          BottomNavigationBarItem(
            icon: NavSvgIcon(
              assetPath: 'assets/Icons/Chat.svg',
              selected: _selectedIndex == 1,
              width: 26,
              height: 26,
              semanticsLabel: 'Sohbet',
            ),
            label: 'Sohbet',
          ),
          BottomNavigationBarItem(
            icon: NavSvgIcon(
              assetPath: 'assets/Icons/Map.svg',
              selected: _selectedIndex == 2,
              width: 30,
              height: 30,
              semanticsLabel: 'Harita',
            ),
            label: 'Harita',
          ),
          BottomNavigationBarItem(
            icon: NavSvgIcon(
              assetPath: 'assets/Icons/History.svg',
              selected: _selectedIndex == 3,
              width: 26,
              height: 26,
              semanticsLabel: 'Geçmiş',
            ),
            label: 'Geçmiş',
          ),
          BottomNavigationBarItem(
            icon: NavSvgIcon(
              assetPath: 'assets/Icons/Settings.svg',
              selected: _selectedIndex == 4,
              width: 26,
              height: 26,
              semanticsLabel: 'Ayarlar',
            ),
            label: 'Ayarlar',
          ),
        ],
      ),
    );
  }
}
