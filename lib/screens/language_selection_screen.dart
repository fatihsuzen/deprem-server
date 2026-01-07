import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../l10n/app_localizations.dart';

class LanguageSelectionScreen extends StatefulWidget {
  final bool isFromSettings;
  final Function(Locale)? onLanguageSelected;

  const LanguageSelectionScreen({
    super.key,
    this.isFromSettings = false,
    this.onLanguageSelected,
  });

  @override
  State<LanguageSelectionScreen> createState() =>
      _LanguageSelectionScreenState();
}

class _LanguageSelectionScreenState extends State<LanguageSelectionScreen> {
  String _selectedLanguage = 'tr';

  @override
  void initState() {
    super.initState();
    _loadCurrentLanguage();
  }

  Future<void> _loadCurrentLanguage() async {
    final prefs = await SharedPreferences.getInstance();
    setState(() {
      _selectedLanguage = prefs.getString('app_locale') ?? 'tr';
    });
  }

  Future<void> _saveLanguage(String languageCode) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setString('app_locale', languageCode);
    await prefs.setBool('language_selected', true);

    setState(() {
      _selectedLanguage = languageCode;
    });
  }

  @override
  Widget build(BuildContext context) {
    final loc = AppLocalizations.of(context);
    final isDark = Theme.of(context).brightness == Brightness.dark;

    return Scaffold(
      backgroundColor: isDark ? const Color(0xFF121212) : Colors.white,
      appBar: widget.isFromSettings
          ? AppBar(
              title: Text(loc?.get('language') ?? 'Dil'),
              backgroundColor: const Color(0xFFFF3A3D),
              foregroundColor: Colors.white,
            )
          : null,
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(24.0),
          child: Column(
            children: [
              if (!widget.isFromSettings) ...[
                const SizedBox(height: 60),
                // Logo veya ikon
                Container(
                  width: 120,
                  height: 120,
                  decoration: BoxDecoration(
                    color: const Color(0xFFFF3A3D).withOpacity(0.1),
                    shape: BoxShape.circle,
                  ),
                  child: const Icon(
                    Icons.language,
                    size: 60,
                    color: Color(0xFFFF3A3D),
                  ),
                ),
                const SizedBox(height: 32),
                Text(
                  'Hoş Geldiniz!\nWelcome!',
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    fontSize: 28,
                    fontWeight: FontWeight.bold,
                    color: isDark ? Colors.white : Colors.black87,
                  ),
                ),
                const SizedBox(height: 16),
                Text(
                  'Lütfen dilinizi seçin\nPlease select your language',
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    fontSize: 16,
                    color: isDark ? Colors.grey[400] : Colors.grey[600],
                  ),
                ),
                const SizedBox(height: 48),
              ],

              // Türkçe seçeneği
              _buildLanguageOption(
                languageCode: 'tr',
                languageName: 'Türkçe',
                flag: '🇹🇷',
                isDark: isDark,
              ),

              const SizedBox(height: 16),

              // İngilizce seçeneği
              _buildLanguageOption(
                languageCode: 'en',
                languageName: 'English',
                flag: '🇬🇧',
                isDark: isDark,
              ),

              const Spacer(),

              if (!widget.isFromSettings) ...[
                // Devam Et butonu
                SizedBox(
                  width: double.infinity,
                  height: 56,
                  child: ElevatedButton(
                    onPressed: () async {
                      // language_selected anahtarını kaydet
                      final prefs = await SharedPreferences.getInstance();
                      await prefs.setBool('language_selected', true);
                      if (widget.onLanguageSelected != null) {
                        widget.onLanguageSelected!(Locale(_selectedLanguage));
                      } else {
                        Navigator.of(context).pushReplacementNamed('/');
                      }
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: const Color(0xFFFF3A3D),
                      foregroundColor: Colors.white,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12),
                      ),
                      elevation: 0,
                    ),
                    child: Text(
                      _selectedLanguage == 'tr' ? 'Devam Et' : 'Continue',
                      style: const TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ),
                const SizedBox(height: 24),
              ],
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildLanguageOption({
    required String languageCode,
    required String languageName,
    required String flag,
    required bool isDark,
  }) {
    final isSelected = _selectedLanguage == languageCode;

    return GestureDetector(
      onTap: () async {
        await _saveLanguage(languageCode);
        if (widget.isFromSettings && mounted) {
          // Ayarlardan geliyorsa, uygulamayı yeniden başlatmak için bilgi ver
          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(
              content: Text(
                languageCode == 'tr'
                    ? 'Dil değiştirildi. Uygulama yeniden başlatılacak.'
                    : 'Language changed. App will restart.',
              ),
              backgroundColor: const Color(0xFFFF3A3D),
            ),
          );
          // Kısa bir gecikme sonra uygulamayı yenile
          await Future.delayed(const Duration(milliseconds: 500));
          if (mounted) {
            Navigator.of(context)
                .pop({'languageChanged': true, 'locale': languageCode});
          }
        }
      },
      child: AnimatedContainer(
        duration: const Duration(milliseconds: 200),
        padding: const EdgeInsets.all(20),
        decoration: BoxDecoration(
          color: isSelected
              ? const Color(0xFFFF3A3D).withOpacity(0.1)
              : (isDark ? Colors.grey[800] : Colors.grey[100]),
          borderRadius: BorderRadius.circular(16),
          border: Border.all(
            color: isSelected ? const Color(0xFFFF3A3D) : Colors.transparent,
            width: 2,
          ),
        ),
        child: Row(
          children: [
            // Bayrak
            Text(
              flag,
              style: const TextStyle(fontSize: 40),
            ),
            const SizedBox(width: 20),
            // Dil adı
            Expanded(
              child: Text(
                languageName,
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: isSelected ? FontWeight.bold : FontWeight.normal,
                  color: isSelected
                      ? const Color(0xFFFF3A3D)
                      : (isDark ? Colors.white : Colors.black87),
                ),
              ),
            ),
            // Seçim ikonu
            if (isSelected)
              Container(
                width: 28,
                height: 28,
                decoration: const BoxDecoration(
                  color: Color(0xFFFF3A3D),
                  shape: BoxShape.circle,
                ),
                child: const Icon(
                  Icons.check,
                  color: Colors.white,
                  size: 18,
                ),
              )
            else
              Container(
                width: 28,
                height: 28,
                decoration: BoxDecoration(
                  border: Border.all(
                    color: isDark ? Colors.grey[600]! : Colors.grey[400]!,
                    width: 2,
                  ),
                  shape: BoxShape.circle,
                ),
              ),
          ],
        ),
      ),
    );
  }
}
