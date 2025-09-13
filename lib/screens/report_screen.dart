import 'package:flutter/material.dart';
import '../services/report_service.dart';
import '../services/location_service.dart';

class ReportScreen extends StatefulWidget {
  const ReportScreen({Key? key}) : super(key: key);

  @override
  State<ReportScreen> createState() => _ReportScreenState();
}

class _ReportScreenState extends State<ReportScreen> {
  final ReportService _reportService = ReportService();
  final LocationService _locationService = LocationService();

  int? selectedIntensity;
  String? userLocation;
  bool isLoadingLocation = false;

  // Dinamik veriler için
  String cityName = 'Şehir Yükleniyor...';
  int reportCount = 0;
  bool isLoadingReports = true;
  double? latitude;
  double? longitude;

  final List<Map<String, dynamic>> intensityLevels = [
    {
      'level': 2,
      'title': 'II - Zar zor algılanan',
      'description': 'Sadece hassas kişiler tarafından hissedilir',
      'color': Colors.blue.shade100,
      'textColor': Colors.blue.shade800,
    },
    {
      'level': 3,
      'title': 'III - Geçen bir kamyona benzer titreşimler',
      'description': 'Evde oturan kişiler tarafından hissedilir',
      'color': Colors.lightBlue.shade100,
      'textColor': Colors.lightBlue.shade800,
    },
    {
      'level': 4,
      'title':
          'IV - Pencerelerin titreşimleri, asılı nesnelerin hafif salınımları',
      'description': 'Çoğu kişi tarafından hissedilir, uyuyanlar uyanabilir',
      'color': Colors.cyan.shade100,
      'textColor': Colors.cyan.shade800,
    },
    {
      'level': 5,
      'title': 'V - Raflardan düşen nesneler',
      'description': 'Herkes tarafından hissedilir, küçük eşyalar düşer',
      'color': Colors.green.shade200,
      'textColor': Colors.green.shade800,
    },
    {
      'level': 6,
      'title': 'VI - Binalarda ve kırık camlarda küçük çatlaklar',
      'description': 'Mobilyalar hareket eder, duvarlar çatlar',
      'color': Colors.yellow.shade300,
      'textColor': Colors.yellow.shade800,
    },
    {
      'level': 7,
      'title': 'VII - Binalarda hasarlar, ayakta durmakta zorluk',
      'description': 'Ayakta durmak zor, yapılarda önemli hasarlar',
      'color': Colors.orange.shade400,
      'textColor': Colors.orange.shade800,
    },
    {
      'level': 8,
      'title': 'VIII - Binalarda bariz hasarlar ve kısmi çökmeler',
      'description': 'Yapısal hasarlar, bazı binalar çökebilir',
      'color': Colors.deepOrange.shade500,
      'textColor': Colors.white,
    },
    {
      'level': 9,
      'title': 'IX - Binalarda sürekli çökmeler, insanların yere savrılması',
      'description': 'Çok sayıda bina çöker, insanlar ayakta duramaz',
      'color': Colors.red.shade600,
      'textColor': Colors.white,
    },
    {
      'level': 10,
      'title': 'X - Bütün binalar çöktü',
      'description': 'Tüm yapılar yıkılır, büyük çapta tahribat',
      'color': Colors.red.shade800,
      'textColor': Colors.white,
    },
    {
      'level': 11,
      'title': 'XI - Zeminde büyük yarıklar',
      'description': 'Toprak yarılır, coğrafi değişiklikler oluşur',
      'color': Colors.red.shade900,
      'textColor': Colors.white,
    },
    {
      'level': 12,
      'title': 'XII - Tamamen yıkıcı',
      'description': 'Topografya değişir, nehirler yön değiştirir',
      'color': Colors.black,
      'textColor': Colors.white,
    },
  ];

  @override
  void initState() {
    super.initState();
    _loadLocationAndReports();
  }

  Future<void> _loadLocationAndReports() async {
    setState(() {
      isLoadingLocation = true;
      isLoadingReports = true;
    });

    try {
      // LocationService'ten konum bilgilerini al
      if (_locationService.isLocationInitialized) {
        userLocation = _locationService.locationText;
        cityName = _locationService.cityName ?? 'Bilinmeyen Şehir';
        latitude = _locationService.latitude;
        longitude = _locationService.longitude;

        // Rapor sayısını al
        if (_locationService.latitude != null &&
            _locationService.longitude != null) {
          reportCount = await _reportService.getCityReportCount(cityName,
              _locationService.latitude!, _locationService.longitude!);
        }
      } else {
        userLocation = "Konum bilgisi henüz alınmadı";
        cityName = "Konum Bekleniyor";
      }

      setState(() {
        isLoadingLocation = false;
        isLoadingReports = false;
      });
    } catch (e) {
      print('Konum ve rapor yükleme hatası: $e');
      setState(() {
        userLocation = "Konum alınamadı";
        cityName = "Hata";
        isLoadingLocation = false;
        isLoadingReports = false;
      });
    }
  }

  void _submitReport() async {
    if (selectedIntensity == null) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('Lütfen bir şiddet seviyesi seçin'),
          backgroundColor: Colors.red,
        ),
      );
      return;
    }

    if (latitude == null || longitude == null) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('Konum bilgisi alınamadı. Lütfen tekrar deneyin.'),
          backgroundColor: Colors.red,
        ),
      );
      return;
    }

    // Loading dialog göster
    showDialog(
      context: context,
      barrierDismissible: false,
      builder: (context) => const Center(
        child: CircularProgressIndicator(),
      ),
    );

    try {
      final ReportService reportService = ReportService();

      final bool success = await reportService.submitReport(
        intensityLevel: selectedIntensity!,
        latitude: latitude!,
        longitude: longitude!,
        cityName: cityName,
      );

      // Loading dialog'unu kapat
      Navigator.of(context).pop();

      if (success) {
        _showSuccessDialog();
      } else {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('Rapor gönderilemedi. Lütfen tekrar deneyin.'),
            backgroundColor: Colors.red,
          ),
        );
      }
    } catch (e) {
      // Loading dialog'unu kapat
      Navigator.of(context).pop();

      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text('Hata: ${e.toString()}'),
          backgroundColor: Colors.red,
        ),
      );
    }
  }

  void _showSuccessDialog() {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(20),
          ),
          title: const Row(
            children: [
              Icon(Icons.check_circle, color: Colors.green, size: 30),
              SizedBox(width: 10),
              Text('Rapor Gönderildi'),
            ],
          ),
          content: const Text(
            'Deprem raporunuz başarıyla kaydedildi. Katılımınız için teşekkürler!',
          ),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
                Navigator.of(context).pop();
              },
              child: const Text('Tamam'),
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    final isDarkTheme = Theme.of(context).brightness == Brightness.dark;

    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      body: Container(
        decoration: BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topCenter,
            end: Alignment.bottomCenter,
            colors: isDarkTheme
                ? [
                    Theme.of(context).colorScheme.primary.withOpacity(0.3),
                    Theme.of(context).colorScheme.secondary.withOpacity(0.2),
                    Theme.of(context).colorScheme.surface,
                  ]
                : [
                    Colors.red.shade400,
                    Colors.orange.shade300,
                    Colors.yellow.shade200,
                  ],
          ),
        ),
        child: SafeArea(
          child: Column(
            children: [
              // App Bar
              Padding(
                padding: const EdgeInsets.all(16.0),
                child: Row(
                  children: [
                    IconButton(
                      onPressed: () => Navigator.pop(context),
                      icon: Icon(
                        Icons.arrow_back,
                        color: isDarkTheme
                            ? Theme.of(context).colorScheme.onBackground
                            : Colors.white,
                      ),
                    ),
                    Expanded(
                      child: Text(
                        'Deprem Raporu',
                        style: TextStyle(
                          fontSize: 24,
                          fontWeight: FontWeight.bold,
                          color: isDarkTheme
                              ? Theme.of(context).colorScheme.onBackground
                              : Colors.white,
                        ),
                        textAlign: TextAlign.center,
                      ),
                    ),
                    const SizedBox(width: 48), // Balance the back button
                  ],
                ),
              ),

              // Content
              Expanded(
                child: Container(
                  margin: const EdgeInsets.all(16),
                  decoration: BoxDecoration(
                    color: isDarkTheme
                        ? Theme.of(context).colorScheme.surface
                        : Colors.white,
                    borderRadius: BorderRadius.circular(20),
                    boxShadow: [
                      BoxShadow(
                        color: isDarkTheme
                            ? Colors.black.withOpacity(0.3)
                            : Colors.black.withOpacity(0.1),
                        blurRadius: 10,
                        offset: const Offset(0, 5),
                      ),
                    ],
                  ),
                  child: Padding(
                    padding: const EdgeInsets.all(20),
                    child: Column(
                      children: [
                        // Header Stats
                        Container(
                          padding: const EdgeInsets.all(20),
                          decoration: BoxDecoration(
                            gradient: LinearGradient(
                              colors: isDarkTheme
                                  ? [
                                      Theme.of(context)
                                          .colorScheme
                                          .primaryContainer,
                                      Theme.of(context)
                                          .colorScheme
                                          .primaryContainer
                                          .withOpacity(0.7),
                                    ]
                                  : [Colors.blue.shade50, Colors.blue.shade100],
                            ),
                            borderRadius: BorderRadius.circular(15),
                          ),
                          child: Column(
                            children: [
                              Text(
                                'RAPORLAR - ${cityName.toUpperCase()}',
                                style: TextStyle(
                                  fontSize: 16,
                                  fontWeight: FontWeight.w500,
                                  color: isDarkTheme
                                      ? Theme.of(context)
                                          .colorScheme
                                          .onSurface
                                          .withOpacity(0.7)
                                      : Colors.grey,
                                ),
                              ),
                              const SizedBox(height: 5),
                              isLoadingReports
                                  ? CircularProgressIndicator(
                                      color:
                                          Theme.of(context).colorScheme.primary,
                                    )
                                  : Text(
                                      reportCount.toString(),
                                      style: TextStyle(
                                        fontSize: 48,
                                        fontWeight: FontWeight.bold,
                                        color: Colors.red.shade600,
                                      ),
                                    ),
                              const Text(
                                'son 24 saatteki raporlar',
                                style: TextStyle(
                                  fontSize: 14,
                                  color: Colors.grey,
                                ),
                              ),
                              const SizedBox(height: 15),
                              Wrap(
                                alignment: WrapAlignment.spaceEvenly,
                                spacing: 8,
                                children: [
                                  _buildSocialButton(Icons.flutter_dash,
                                      'Twitter', Colors.blue),
                                  _buildSocialButton(
                                      Icons.map, 'HARİTA', Colors.grey),
                                  _buildSocialButton(
                                      Icons.telegram, 'Telegram', Colors.blue),
                                ],
                              ),
                            ],
                          ),
                        ),

                        const SizedBox(height: 20),

                        // Location Info
                        Container(
                          width: double.infinity,
                          padding: const EdgeInsets.all(15),
                          decoration: BoxDecoration(
                            color: isDarkTheme
                                ? Theme.of(context).colorScheme.primaryContainer
                                : Colors.blue.shade50,
                            borderRadius: BorderRadius.circular(10),
                            border: Border.all(
                              color: isDarkTheme
                                  ? Theme.of(context).colorScheme.primary
                                  : Colors.blue.shade200,
                            ),
                          ),
                          child: Row(
                            children: [
                              Icon(
                                Icons.location_on,
                                color: isDarkTheme
                                    ? Theme.of(context).colorScheme.primary
                                    : Colors.blue.shade600,
                              ),
                              const SizedBox(width: 10),
                              Expanded(
                                child: isLoadingLocation
                                    ? Text(
                                        'Konum alınıyor...',
                                        style: TextStyle(
                                          color: Theme.of(context)
                                              .colorScheme
                                              .onSurface,
                                        ),
                                      )
                                    : Text(
                                        userLocation ?? 'Konum bulunamadı',
                                        style: TextStyle(
                                          fontSize: 14,
                                          color: Theme.of(context)
                                              .colorScheme
                                              .onSurface,
                                        ),
                                      ),
                              ),
                            ],
                          ),
                        ),

                        const SizedBox(height: 15),

                        Text(
                          'Bir deprem hissettim!',
                          style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                            color: isDarkTheme
                                ? Theme.of(context).colorScheme.primary
                                : Colors.blue,
                          ),
                        ),

                        const SizedBox(height: 10),

                        // Intensity Selection
                        Expanded(
                          child: ListView.builder(
                            itemCount: intensityLevels.length,
                            itemBuilder: (context, index) {
                              final intensity = intensityLevels[index];
                              final isSelected =
                                  selectedIntensity == intensity['level'];

                              return Container(
                                margin: const EdgeInsets.symmetric(vertical: 4),
                                decoration: BoxDecoration(
                                  color: intensity['color'],
                                  borderRadius: BorderRadius.circular(10),
                                  border: Border.all(
                                    color: isSelected
                                        ? Colors.black
                                        : intensity['color'],
                                    width: isSelected ? 2 : 1,
                                  ),
                                ),
                                child: RadioListTile<int>(
                                  value: intensity['level'],
                                  groupValue: selectedIntensity,
                                  onChanged: (value) {
                                    setState(() {
                                      selectedIntensity = value;
                                    });
                                  },
                                  title: Text(
                                    intensity['title'],
                                    style: TextStyle(
                                      fontWeight: FontWeight.w500,
                                      color: intensity['textColor'],
                                      fontSize: 14,
                                    ),
                                  ),
                                  subtitle: Text(
                                    intensity['description'],
                                    style: TextStyle(
                                      color: intensity['textColor']
                                          .withOpacity(0.8),
                                      fontSize: 12,
                                    ),
                                  ),
                                  activeColor: Colors.black,
                                ),
                              );
                            },
                          ),
                        ),

                        const SizedBox(height: 20),

                        // Submit Button
                        SizedBox(
                          width: double.infinity,
                          height: 50,
                          child: ElevatedButton(
                            onPressed: _submitReport,
                            style: ElevatedButton.styleFrom(
                              backgroundColor: Colors.red.shade600,
                              foregroundColor: Colors.white,
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(15),
                              ),
                            ),
                            child: const Text(
                              'RAPOR GÖNDER',
                              style: TextStyle(
                                fontSize: 18,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildSocialButton(IconData icon, String label, Color color) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(20),
        border: Border.all(color: Colors.grey.shade300),
      ),
      child: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          Icon(icon, color: color, size: 16),
          const SizedBox(width: 5),
          Text(
            label,
            style: TextStyle(
              color: color,
              fontSize: 12,
              fontWeight: FontWeight.w500,
            ),
          ),
        ],
      ),
    );
  }
}
