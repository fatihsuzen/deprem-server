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

  String _getContinueText() {
    switch (_selectedLanguage) {
      case 'tr':
        return 'Devam Et';
      case 'en':
        return 'Continue';
      case 'es':
        return 'Continuar';
      case 'hi':
        return 'जारी रखें';
      case 'fil':
        return 'Magpatuloy';
      case 'my':
        return 'ဆက်လုပ်မည်';
      default:
        return 'Continue';
    }
  }

  String _getWelcomeText() {
    switch (_selectedLanguage) {
      case 'tr':
        return 'Hoş Geldiniz!';
      case 'en':
        return 'Welcome!';
      case 'es':
        return '¡Bienvenido!';
      case 'hi':
        return 'स्वागत है!';
      case 'fil':
        return 'Maligayang Pagdating!';
      case 'my':
        return 'ကြိုဆိုပါတဲ!';
      default:
        return 'Welcome!';
    }
  }

  String _getSelectLanguageText() {
    switch (_selectedLanguage) {
      case 'tr':
        return 'Lütfen dilinizi seçin';
      case 'en':
        return 'Please select your language';
      case 'es':
        return 'Por favor selecciona tu idioma';
      case 'hi':
        return 'कृपया अपनी भाषा चुनें';
      case 'fil':
        return 'Pumili ng inyong wika';
      case 'my':
        return 'သင့်ဘာသာစကားकို ရွေးချတ်ပါ';
      default:
        return 'Please select your language';
    }
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
        child: Column(
          children: [
            if (!widget.isFromSettings) ...[
              const SizedBox(height: 40),
              // Logo veya ikon
              Container(
                width: 100,
                height: 100,
                decoration: BoxDecoration(
                  color: const Color(0xFFFF3A3D).withOpacity(0.1),
                  shape: BoxShape.circle,
                ),
                child: const Icon(
                  Icons.language,
                  size: 50,
                  color: Color(0xFFFF3A3D),
                ),
              ),
              const SizedBox(height: 20),
              Text(
                _getWelcomeText(),
                textAlign: TextAlign.center,
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  color: isDark ? Colors.white : Colors.black87,
                ),
              ),
              const SizedBox(height: 12),
              Text(
                _getSelectLanguageText(),
                textAlign: TextAlign.center,
                style: TextStyle(
                  fontSize: 14,
                  color: isDark ? Colors.grey[400] : Colors.grey[600],
                ),
              ),
              const SizedBox(height: 24),
            ],

            // Scrollable language options
            Expanded(
              child: SingleChildScrollView(
                padding: const EdgeInsets.symmetric(horizontal: 24.0),
                child: Column(
                  children: [
                    // English - First
                    _buildLanguageOption(
                      languageCode: 'en',
                      languageName: 'English',
                      flag: '🇬🇧',
                      isDark: isDark,
                    ),

                    const SizedBox(height: 12),

                    // Spanish - Second
                    _buildLanguageOption(
                      languageCode: 'es',
                      languageName: 'Español',
                      flag: '🇪🇸',
                      isDark: isDark,
                    ),

                    const SizedBox(height: 12),

                    // Turkish - Third
                    _buildLanguageOption(
                      languageCode: 'tr',
                      languageName: 'Türkçe',
                      flag: '🇹🇷',
                      isDark: isDark,
                    ),

                    const SizedBox(height: 12),

                    // Hindi
                    _buildLanguageOption(
                      languageCode: 'hi',
                      languageName: 'हिन्दी',
                      flag: '🇮🇳',
                      isDark: isDark,
                    ),

                    const SizedBox(height: 12),

                    // Filipino
                    _buildLanguageOption(
                      languageCode: 'fil',
                      languageName: 'Filipino',
                      flag: '🇵🇭',
                      isDark: isDark,
                    ),

                    const SizedBox(height: 12),

                    // Myanmar
                    _buildLanguageOption(
                      languageCode: 'my',
                      languageName: 'မြန်မာ',
                      flag: '🇲🇲',
                      isDark: isDark,
                    ),

                    const SizedBox(height: 24),
                  ],
                ),
              ),
            ),

            if (!widget.isFromSettings) ...[
              Padding(
                padding: const EdgeInsets.all(24.0),
                child: SizedBox(
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
                      _getContinueText(),
                      style: const TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ),
              ),
            ] else
              const SizedBox(height: 24),
          ],
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
          String message;
          switch (languageCode) {
            case 'tr':
              message = 'Dil değiştirildi. Uygulama yeniden başlatılacak.';
              break;
            case 'en':
              message = 'Language changed. App will restart.';
              break;
            case 'es':
              message = 'Idioma cambiado. La aplicación se reiniciará.';
              break;
            case 'hi':
              message = 'भाषा बदल दी गई। ऐप पुनः प्रारंभ होगा।';
              break;
            case 'fil':
              message = 'Nabago ang wika. Mag-restart ang app.';
              break;
            case 'my':
              message = 'ဘာသာစကား ပြောင်းလဲပြီးပါပြီ။ အက်ပ် ပြန်စတင်မည်။';
              break;
            default:
              message = 'Language changed. App will restart.';
          }

          ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(
              content: Text(message),
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
