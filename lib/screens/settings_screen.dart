import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

class SettingsScreen extends StatefulWidget {
  const SettingsScreen({super.key});

  @override
  State<SettingsScreen> createState() => _SettingsScreenState();
}

class _SettingsScreenState extends State<SettingsScreen> {
  bool isDarkTheme = false;
  bool isDarkMapTheme = false;
  bool isLoading = true;

  @override
  void initState() {
    super.initState();
    _loadSettings();
  }

  Future<void> _loadSettings() async {
    final prefs = await SharedPreferences.getInstance();
    setState(() {
      isDarkTheme = prefs.getBool('isDarkTheme') ?? false;
      isDarkMapTheme = prefs.getBool('isDarkMapTheme') ?? false;
      isLoading = false;
    });
  }

  Future<void> _saveAppTheme(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool('isDarkTheme', value);
    setState(() {
      isDarkTheme = value;
    });

    // Ana uygulama temasını güncelle
    if (mounted) {
      // Ana widget'a tema değişikliğini bildir
      Navigator.of(context).pop({'themeChanged': true, 'isDarkTheme': value});
    }
  }

  Future<void> _saveMapTheme(bool value) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool('isDarkMapTheme', value);
    setState(() {
      isDarkMapTheme = value;
    });
  }

  @override
  Widget build(BuildContext context) {
    if (isLoading) {
      return Scaffold(
        appBar: AppBar(
          title: const Text('Ayarlar'),
        ),
        body: const Center(
          child: CircularProgressIndicator(),
        ),
      );
    }

    return Scaffold(
      appBar: AppBar(
        title: const Text('Ayarlar'),
        backgroundColor: isDarkTheme ? Colors.grey[900] : Colors.blue,
        foregroundColor: isDarkTheme ? Colors.white : Colors.white,
      ),
      backgroundColor: isDarkTheme ? Colors.grey[850] : Colors.white,
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Uygulama Teması Bölümü
            Text(
              'Uygulama Görünümü',
              style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.bold,
                  ),
            ),
            const SizedBox(height: 16),
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
                borderRadius: BorderRadius.circular(12),
                border: Border.all(
                  color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
                ),
              ),
              child: Row(
                children: [
                  Icon(
                    isDarkTheme ? Icons.dark_mode : Icons.light_mode,
                    color: isDarkTheme ? Colors.orange : Colors.blue,
                    size: 28,
                  ),
                  const SizedBox(width: 16),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          'Koyu Tema',
                          style: TextStyle(
                            fontSize: 16,
                            fontWeight: FontWeight.w600,
                            color: isDarkTheme ? Colors.white : Colors.black87,
                          ),
                        ),
                        Text(
                          isDarkTheme ? 'Koyu tema aktif' : 'Açık tema aktif',
                          style: TextStyle(
                            fontSize: 14,
                            color: isDarkTheme
                                ? Colors.grey[300]
                                : Colors.grey[600],
                          ),
                        ),
                      ],
                    ),
                  ),
                  Switch.adaptive(
                    value: isDarkTheme,
                    onChanged: _saveAppTheme,
                    activeColor: Colors.orange,
                    activeTrackColor: Colors.orange.withOpacity(0.3),
                  ),
                ],
              ),
            ),

            const SizedBox(height: 32),

            // Harita Teması Bölümü
            Text(
              'Harita Görünümü',
              style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                    color: isDarkTheme ? Colors.white : Colors.black87,
                    fontWeight: FontWeight.bold,
                  ),
            ),
            const SizedBox(height: 16),
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
                borderRadius: BorderRadius.circular(12),
                border: Border.all(
                  color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
                ),
              ),
              child: Row(
                children: [
                  Icon(
                    isDarkMapTheme ? Icons.map_outlined : Icons.map,
                    color: isDarkTheme ? Colors.orange : Colors.blue,
                    size: 28,
                  ),
                  const SizedBox(width: 16),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          'Koyu Harita',
                          style: TextStyle(
                            fontSize: 16,
                            fontWeight: FontWeight.w600,
                            color: isDarkTheme ? Colors.white : Colors.black87,
                          ),
                        ),
                        Text(
                          isDarkMapTheme
                              ? 'Koyu harita teması'
                              : 'Açık harita teması',
                          style: TextStyle(
                            fontSize: 14,
                            color: isDarkTheme
                                ? Colors.grey[300]
                                : Colors.grey[600],
                          ),
                        ),
                      ],
                    ),
                  ),
                  Switch.adaptive(
                    value: isDarkMapTheme,
                    onChanged: _saveMapTheme,
                    activeColor: Colors.orange,
                    activeTrackColor: Colors.orange.withOpacity(0.3),
                  ),
                ],
              ),
            ),

            const SizedBox(height: 32),

            // Bilgi Bölümü
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: isDarkTheme ? Colors.grey[800] : Colors.grey[100],
                borderRadius: BorderRadius.circular(12),
                border: Border.all(
                  color: isDarkTheme ? Colors.grey[700]! : Colors.grey[300]!,
                ),
              ),
              child: Row(
                children: [
                  Icon(
                    Icons.info_outline,
                    color: isDarkTheme ? Colors.orange : Colors.blue,
                    size: 28,
                  ),
                  const SizedBox(width: 16),
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          'Tema Ayarları',
                          style: TextStyle(
                            fontSize: 16,
                            fontWeight: FontWeight.w600,
                            color: isDarkTheme ? Colors.white : Colors.black87,
                          ),
                        ),
                        Text(
                          'Ayarlarınız otomatik olarak kaydedilir ve bir sonraki açılışta uygulanır.',
                          style: TextStyle(
                            fontSize: 14,
                            color: isDarkTheme
                                ? Colors.grey[300]
                                : Colors.grey[600],
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
