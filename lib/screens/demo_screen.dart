import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'map_screen.dart';
import 'simple_friends_screen.dart';
import 'chat_rooms_screen.dart';
import 'past_earthquakes_screen.dart';
import 'settings_screen.dart';

class DemoScreen extends StatefulWidget {
  const DemoScreen({super.key});

  @override
  State<DemoScreen> createState() => _DemoScreenState();
}

class _DemoScreenState extends State<DemoScreen> {
  int _selectedIndex = 2; // Harita sekmesi başlangıçta seçili

  // Tüm ekranlar
  late final List<Widget> _screens;

  @override
  void initState() {
    super.initState();
    _screens = [
      const SimpleFriendsScreen(), // 0 - Arkadaşlar
      const ChatRoomsScreen(), // 1 - Chat
      MapScreen(), // 2 - Harita
      const PastEarthquakesScreen(), // 3 - Geçmiş Depremler
      const SettingsScreen(), // 4 - Ayarlar
    ];
  }

  void _onNavItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _screens[_selectedIndex],

      // Alt navigasyon çubuğu
      bottomNavigationBar: Container(
        decoration: BoxDecoration(
          color: Colors.white,
          boxShadow: [
            BoxShadow(
              color: Colors.black.withOpacity(0.1),
              blurRadius: 8,
              offset: const Offset(0, -2),
            ),
          ],
        ),
        child: SafeArea(
          child: Padding(
            padding: const EdgeInsets.symmetric(vertical: 8),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                _buildNavItem(
                  icon: 'Icons/Icons/Friends.svg',
                  label: 'Arkadaşlar',
                  index: 0,
                ),
                _buildNavItem(
                  icon: 'Icons/Icons/Chat.svg',
                  label: 'Chat',
                  index: 1,
                ),
                _buildNavItem(
                  icon: 'Icons/Icons/Map.svg',
                  label: 'Harita',
                  index: 2,
                ),
                _buildNavItem(
                  icon: 'Icons/Icons/History.svg',
                  label: 'Geçmiş',
                  index: 3,
                ),
                _buildNavItem(
                  icon: 'Icons/Icons/Settings.svg',
                  label: 'Ayarlar',
                  index: 4,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Widget _buildNavItem({
    required String icon,
    required String label,
    required int index,
  }) {
    final isSelected = _selectedIndex == index;
    return GestureDetector(
      onTap: () => _onNavItemTapped(index),
      child: Container(
        padding: const EdgeInsets.symmetric(vertical: 8, horizontal: 12),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            SvgPicture.asset(
              icon,
              width: 28,
              height: 28,
              colorFilter: ColorFilter.mode(
                isSelected ? const Color(0xFFFF5252) : Colors.grey,
                BlendMode.srcIn,
              ),
            ),
            const SizedBox(height: 4),
            Text(
              label,
              style: TextStyle(
                fontSize: 11,
                color: isSelected ? const Color(0xFFFF5252) : Colors.grey,
                fontWeight: isSelected ? FontWeight.bold : FontWeight.normal,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
