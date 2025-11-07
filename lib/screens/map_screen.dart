import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:latlong2/latlong.dart';

class MapScreen extends StatefulWidget {
  @override
  _MapScreenState createState() => _MapScreenState();
}

class _MapScreenState extends State<MapScreen> with TickerProviderStateMixin {
  late MapController _mapController;
  final LatLng _userLocation =
      LatLng(41.0308, 28.5742); // İstanbul Büyükçekmece
  bool _showLatestQuakePopup = true; // Popup görünürlük kontrolü
  late AnimationController _waveController;
  late Animation<double> _waveAnimation;

  final List<Map<String, dynamic>> _quakes = [
    {
      "lat": 40.90,
      "lon": 29.20,
      "mag": 4.2,
      "place": "Silivri Açıkları (İstanbul)",
      "date": "11 Ekim Cumartesi 2025",
      "time": "17:20",
      "minutesAgo": 10
    },
    {
      "lat": 39.04,
      "lon": 27.52,
      "mag": 3.8,
      "place": "Balıkesir Merkez",
      "date": "10 Ekim Cuma 2025",
      "time": "14:35",
      "minutesAgo": 125
    },
    {
      "lat": 37.07,
      "lon": 29.34,
      "mag": 2.6,
      "place": "Aydın - Söke",
      "date": "9 Ekim Perşembe 2025",
      "time": "09:15",
      "minutesAgo": 450
    },
    {
      "lat": 37.0,
      "lon": 31.5,
      "mag": 4.8,
      "place": "Burdur - Gölhisar",
      "date": "8 Ekim Çarşamba 2025",
      "time": "22:45",
      "minutesAgo": 1200
    },
  ];

  @override
  void initState() {
    super.initState();
    _mapController = MapController();
    
    // Dalga animasyonu için
    _waveController = AnimationController(
      duration: const Duration(seconds: 2),
      vsync: this,
    )..repeat();
    
    _waveAnimation = Tween<double>(begin: 0.0, end: 1.0).animate(
      CurvedAnimation(parent: _waveController, curve: Curves.easeOut),
    );
  }

  @override
  void dispose() {
    _waveController.dispose();
    super.dispose();
  }

  String _formatTimeAgo(int minutes) {
    if (minutes < 1) return '< 1dk';
    if (minutes < 60) return '${minutes}dk';
    
    int hours = minutes ~/ 60;
    if (hours < 24) return '${hours}s';
    
    int days = hours ~/ 24;
    return '${days}g';
  }

  Color _colorForMag(double m) {
    if (m >= 4.5) return Colors.red;
    if (m >= 4.0) return Colors.deepOrange;
    if (m >= 3.0) return Colors.orange;
    return Colors.green;
  }

  void _onTapMarker(Map<String, dynamic> q) {
    final mag = (q['mag'] as num).toDouble();
    final place = q['place'] ?? 'Konum';
    final date = q['date'] ?? 'Tarih bilgisi yok';
    final time = q['time'] ?? '--:--';

    showModalBottomSheet(
        context: context,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
        ),
        builder: (ctx) {
          return Container(
            padding: const EdgeInsets.all(24.0),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                // Başlık
                Text(
                  'Deprem Bilgisi',
                  style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                SizedBox(height: 24),

                // Büyüklük
                Row(
                  children: [
                    Icon(
                      Icons.warning_rounded,
                      color: Color(0xFFFF3333),
                      size: 24,
                    ),
                    SizedBox(width: 12),
                    Text(
                      '$mag-${(mag + 0.5).toStringAsFixed(1)} Mw',
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.black87,
                      ),
                    ),
                    SizedBox(width: 8),
                    Text(
                      'Hafif sarsıntı',
                      style: TextStyle(
                        fontSize: 14,
                        color: Colors.grey[600],
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 20),

                // Konum
                Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Icon(
                      Icons.location_on,
                      color: Color(0xFFFF3333),
                      size: 24,
                    ),
                    SizedBox(width: 12),
                    Expanded(
                      child: Text(
                        place,
                        style: TextStyle(
                          fontSize: 16,
                          color: Colors.black87,
                        ),
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 20),

                // Tarih
                Row(
                  children: [
                    Icon(
                      Icons.calendar_today,
                      color: Color(0xFFFF3333),
                      size: 24,
                    ),
                    SizedBox(width: 12),
                    Text(
                      date,
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.black87,
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 20),

                // Saat
                Row(
                  children: [
                    Icon(
                      Icons.access_time,
                      color: Color(0xFFFF3333),
                      size: 24,
                    ),
                    SizedBox(width: 12),
                    Text(
                      time,
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.black87,
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 32),

                // Kapat Butonu
                SizedBox(
                  width: double.infinity,
                  child: ElevatedButton(
                    onPressed: () => Navigator.pop(ctx),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Color(0xFFFF3333),
                      padding: EdgeInsets.symmetric(vertical: 14),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(30),
                      ),
                    ),
                    child: Text(
                      'Kapat',
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 16,
                        fontWeight: FontWeight.w600,
                      ),
                    ),
                  ),
                ),
              ],
            ),
          );
        });
  }

  void _showEarthquakeReportSheet() {
    showModalBottomSheet(
      context: context,
      isScrollControlled: true,
      builder: (ctx) {
        return EarthquakeReportSheet();
      },
    );
  }

  void _zoomIn() {
    _mapController.move(_mapController.center, _mapController.zoom + 1);
  }

  void _zoomOut() {
    _mapController.move(_mapController.center, _mapController.zoom - 1);
  }

  void _focusUserLocation() {
    _mapController.move(_userLocation, 10.0);
  }

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: [
        FlutterMap(
          mapController: _mapController,
          options: MapOptions(center: _userLocation, zoom: 6.0),
          children: [
            TileLayer(
              urlTemplate: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
              subdomains: ['a', 'b', 'c'],
              userAgentPackageName: 'dev.deprem_bildirim',
            ),
            MarkerLayer(
              markers: [
                Marker(
                  point: _userLocation,
                  width: 35,
                  height: 35,
                  child: Container(
                    decoration: BoxDecoration(
                      shape: BoxShape.circle,
                      color: Colors.blue,
                      boxShadow: [
                        BoxShadow(color: Colors.black26, blurRadius: 4)
                      ],
                    ),
                    child: Center(
                      child: SvgPicture.asset(
                        'assets/Icons/user-stroke-rounded.svg',
                        width: 18.0,
                        height: 18.0,
                        colorFilter:
                            ColorFilter.mode(Colors.white, BlendMode.srcIn),
                      ),
                    ),
                  ),
                ),
                ..._quakes.asMap().entries.map((entry) {
                  final index = entry.key;
                  final q = entry.value;
                  final lat = q['lat'] as double;
                  final lon = q['lon'] as double;
                  final mag = (q['mag'] as num).toDouble();
                  final color = _colorForMag(mag);
                  final isLastQuake = index == 0;

                  return Marker(
                    point: LatLng(lat, lon),
                    width: isLastQuake ? 200 : 60,
                    height: isLastQuake ? 155 : 60,
                    child: Column(
                      mainAxisSize: MainAxisSize.min,
                      mainAxisAlignment: MainAxisAlignment.end,
                      children: [
                        // Son deprem için popup
                        if (isLastQuake && _showLatestQuakePopup)
                          Container(
                            width: 200,
                            height: 90,
                            padding: EdgeInsets.all(14),
                            margin: EdgeInsets.only(bottom: 2),
                            decoration: BoxDecoration(
                              color: Colors.white,
                              borderRadius: BorderRadius.circular(8),
                              boxShadow: [
                                BoxShadow(
                                  color: Colors.black.withOpacity(0.3),
                                  blurRadius: 8,
                                  offset: Offset(0, 2),
                                ),
                              ],
                            ),
                            child: Stack(
                              children: [
                                Column(
                                  mainAxisSize: MainAxisSize.min,
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  mainAxisAlignment: MainAxisAlignment.center,
                                  children: [
                                    Text(
                                      'Son Deprem',
                                      style: TextStyle(
                                        fontSize: 10,
                                        fontWeight: FontWeight.w600,
                                        color: Colors.grey[600],
                                      ),
                                    ),
                                    SizedBox(height: 8),
                                    Row(
                                      children: [
                                        Text(
                                          '${q['mag']} Mw',
                                          style: TextStyle(
                                            fontSize: 14,
                                            fontWeight: FontWeight.bold,
                                            color: color,
                                          ),
                                        ),
                                        SizedBox(width: 8),
                                        Expanded(
                                          child: Text(
                                            q['place'],
                                            style: TextStyle(
                                              fontSize: 11,
                                              color: Colors.black87,
                                              fontWeight: FontWeight.w500,
                                            ),
                                            maxLines: 1,
                                            overflow: TextOverflow.ellipsis,
                                          ),
                                        ),
                                      ],
                                    ),
                                    SizedBox(height: 6),
                                    Text(
                                      '${q['minutesAgo']} dk önce',
                                      style: TextStyle(
                                        fontSize: 10,
                                        color: Colors.grey[600],
                                      ),
                                    ),
                                  ],
                                ),
                                // Kapatma butonu
                                Positioned(
                                  top: 0,
                                  right: 0,
                                  child: GestureDetector(
                                    onTap: () {
                                      setState(() {
                                        _showLatestQuakePopup = false;
                                      });
                                    },
                                    child: Container(
                                      padding: EdgeInsets.all(2),
                                      child: Icon(
                                        Icons.close,
                                        size: 16,
                                        color: Colors.grey[600],
                                      ),
                                    ),
                                  ),
                                ),
                              ],
                            ),
                          ),
                        // Dalga animasyonu + Deprem marker
                        Stack(
                          alignment: Alignment.center,
                          children: [
                            // Dalga animasyonu (sadece en son deprem için)
                            if (isLastQuake)
                              AnimatedBuilder(
                                animation: _waveAnimation,
                                builder: (context, child) {
                                  return Container(
                                    width: 40 + (_waveAnimation.value * 30),
                                    height: 40 + (_waveAnimation.value * 30),
                                    decoration: BoxDecoration(
                                      shape: BoxShape.circle,
                                      border: Border.all(
                                        color: color.withOpacity(0.6 - (_waveAnimation.value * 0.6)),
                                        width: 2,
                                      ),
                                    ),
                                  );
                                },
                              ),
                            // Deprem marker icon
                            GestureDetector(
                              onTap: () => _onTapMarker(q),
                              child: Container(
                                width: 40,
                                height: 40,
                                decoration: BoxDecoration(
                                  shape: BoxShape.circle,
                                  color: color,
                                  boxShadow: [
                                    BoxShadow(color: Colors.black26, blurRadius: 4)
                                  ],
                                ),
                                child: Center(
                                  child: SvgPicture.asset(
                                    'assets/Icons/Logo.svg',
                                    width: 20,
                                    height: 20,
                                    colorFilter: ColorFilter.mode(
                                        Colors.white, BlendMode.srcIn),
                                  ),
                                ),
                              ),
                            ),
                          ],
                        ),
                        // Zaman gösterimi (marker'ın altında)
                        SizedBox(height: 4),
                        Container(
                          padding: EdgeInsets.symmetric(horizontal: 6, vertical: 2),
                          decoration: BoxDecoration(
                            color: Colors.black.withOpacity(0.7),
                            borderRadius: BorderRadius.circular(8),
                          ),
                          child: Text(
                            _formatTimeAgo(q['minutesAgo'] as int),
                            style: TextStyle(
                              color: Colors.white,
                              fontSize: 10,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                        ),
                      ],
                    ),
                  );
                }).toList(),
              ],
            )
          ],
        ),
        Positioned(
          top: 12,
          right: 12,
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              FloatingActionButton(
                heroTag: 'zoom_in_btn',
                mini: true,
                onPressed: _zoomIn,
                backgroundColor: Colors.white,
                child: Icon(Icons.add, color: Color(0xFFFF3333)),
              ),
              SizedBox(height: 8),
              FloatingActionButton(
                heroTag: 'zoom_out_btn',
                mini: true,
                onPressed: _zoomOut,
                backgroundColor: Colors.white,
                child: Icon(Icons.remove, color: Color(0xFFFF3333)),
              ),
              SizedBox(height: 8),
              FloatingActionButton(
                heroTag: 'my_location_btn',
                mini: true,
                onPressed: _focusUserLocation,
                backgroundColor: Colors.white,
                child: Icon(Icons.my_location, color: Color(0xFFFF3333)),
              ),
            ],
          ),
        ),
        Align(
          alignment: Alignment(0, 0.88),
          child: ElevatedButton(
            onPressed: _showEarthquakeReportSheet,
            style: ElevatedButton.styleFrom(
              backgroundColor: Color(0xFFFF3333),
              foregroundColor: Colors.white,
              minimumSize: Size(250, 54),
              shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(999)),
            ),
            child: Text('Deprem Bildir',
                style: TextStyle(
                    color: Colors.white, fontWeight: FontWeight.w600)),
          ),
        )
      ],
    );
  }
}

class EarthquakeReportSheet extends StatefulWidget {
  @override
  _EarthquakeReportSheetState createState() => _EarthquakeReportSheetState();
}

class _EarthquakeReportSheetState extends State<EarthquakeReportSheet> {
  String _selectedCity = '';
  double _selectedMagnitude = 1.0;
  String _searchCity = '';
  bool _showCityList = false;

  final List<String> _cities = [
    'Adana',
    'Adıyaman',
    'Afyonkarahisar',
    'Ağrı',
    'Aksaray',
    'Amasya',
    'Ankara',
    'Antalya',
    'Ardahan',
    'Artvin',
    'Aydın',
    'Balıkesir',
    'Bartın',
    'Batman',
    'Bayburt',
    'Bingöl',
    'Bitlis',
    'Bolu',
    'Burdur',
    'Bursa',
    'Çanakkale',
    'Çankırı',
    'Çorum',
    'Denizli',
    'Diyarbakır',
    'Düzce',
    'Edirne',
    'Elazığ',
    'Erzincan',
    'Erzurum',
    'Eskişehir',
    'Gaziantep',
    'Giresun',
    'Gümüşhane',
    'Hakkari',
    'Hatay',
    'Iğdır',
    'Isparta',
    'İstanbul',
    'İzmir',
    'Kahraman Maraş',
    'Karabük',
    'Karaman',
    'Kars',
    'Kastamonu',
    'Kayseri',
    'Kırıkkale',
    'Kırklareli',
    'Kırşehir',
    'Kilis',
    'Kocaeli',
    'Konya',
    'Kütahya',
    'Malatya',
    'Manisa',
    'Mardin',
    'Muğla',
    'Muş',
    'Nevşehir',
    'Niğde',
    'Ordu',
    'Rize',
    'Sakarya',
    'Samsun',
    'Şanlıurfa',
    'Şırnak',
    'Siirt',
    'Sinop',
    'Sivas',
    'Tekirdağ',
    'Tokat',
    'Trabzon',
    'Uşak',
    'Van',
    'Yalova',
    'Yozgat',
    'Zonguldak',
  ];

  final List<Map<String, String>> magnitudes = [
    {'min': '1.0', 'max': '2.0', 'desc': 'Hissiyatı çok düşük.'},
    {'min': '2.0', 'max': '3.0', 'desc': 'Çok hafif sarsıntı hissi.'},
    {'min': '3.0', 'max': '4.0', 'desc': 'Hafif sarsıntı'},
    {'min': '4.0', 'max': '5.0', 'desc': 'Belirgin sarsıntı'},
    {'min': '5.0', 'max': '6.0', 'desc': 'Şiddetli sarsıntı'},
    {'min': '6.0', 'max': '7.0', 'desc': 'Çok şiddetli sarsıntı'},
    {'min': '7.0', 'max': '8.0', 'desc': 'Yıkıcı deprem'},
    {'min': '8.0', 'max': '9.0', 'desc': 'Büyük felaket'},
  ];

  List<String> get _filteredCities {
    if (_searchCity.isEmpty) return _cities;
    return _cities
        .where((city) => city.toLowerCase().contains(_searchCity.toLowerCase()))
        .toList();
  }

  @override
  Widget build(BuildContext context) {
    final screenHeight = MediaQuery.of(context).size.height;

    return Container(
      height: screenHeight * 0.7,
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.vertical(top: Radius.circular(20)),
      ),
      child: Column(
        children: [
          // Header section
          Padding(
            padding: EdgeInsets.fromLTRB(16, 16, 16, 16),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text('Deprem Bildir',
                    style:
                        TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
                SizedBox(height: 20),
                Text('Hangi İldesin',
                    style: TextStyle(
                        fontSize: 14,
                        fontWeight: FontWeight.w600,
                        color: Colors.black)),
                SizedBox(height: 8),
                _buildCitySearchField(),
              ],
            ),
          ),
          // Conditional content: City list OR Magnitude options
          Expanded(
            child: _showCityList
                ? _buildExpandedCityList()
                : _buildMagnitudeSection(),
          ),
          Container(
            padding: EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: Colors.white,
              boxShadow: [
                BoxShadow(
                  color: Colors.black.withOpacity(0.05),
                  blurRadius: 10,
                  offset: Offset(0, -5),
                ),
              ],
            ),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                SizedBox(
                  width: double.infinity,
                  child: ElevatedButton(
                    onPressed: () {
                      if (_selectedCity.isEmpty) {
                        ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(content: Text('Lütfen bir şehir seçiniz')),
                        );
                        return;
                      }
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                            content: Text(
                                '$_selectedCity bölgesinde deprem bildirildi!')),
                      );
                      Navigator.pop(context);
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Color(0xFFFF3333),
                      padding: EdgeInsets.symmetric(vertical: 14),
                      shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(30)),
                    ),
                    child: Text('Bildir',
                        style: TextStyle(
                            color: Colors.white,
                            fontSize: 16,
                            fontWeight: FontWeight.w600)),
                  ),
                ),
                SizedBox(height: 12),
                SizedBox(
                  width: double.infinity,
                  child: OutlinedButton(
                    onPressed: () => Navigator.pop(context),
                    style: OutlinedButton.styleFrom(
                      padding: EdgeInsets.symmetric(vertical: 14),
                      shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(30)),
                    ),
                    child: Text('Vazgeç',
                        style: TextStyle(color: Colors.black, fontSize: 16)),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildCitySearchField() {
    return Column(
      children: [
        TextField(
          decoration: InputDecoration(
            hintText: 'Şehir arayınız...',
            prefixIcon: Icon(Icons.search, color: Colors.grey),
            suffixIcon: _searchCity.isNotEmpty || _showCityList
                ? GestureDetector(
                    onTap: () => setState(() {
                      _searchCity = '';
                      _showCityList = false;
                    }),
                    child: Icon(Icons.clear, color: Colors.grey),
                  )
                : null,
            border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
            contentPadding: EdgeInsets.symmetric(horizontal: 12, vertical: 12),
          ),
          onTap: () => setState(() => _showCityList = true),
          onChanged: (val) => setState(() => _searchCity = val),
        ),
        if (_selectedCity.isNotEmpty && !_showCityList)
          Padding(
            padding: const EdgeInsets.only(top: 8.0),
            child: Container(
              width: double.infinity,
              padding: EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Colors.red.shade50,
                border: Border.all(color: Color(0xFFFF3333)),
                borderRadius: BorderRadius.circular(8),
              ),
              child: Row(
                children: [
                  Icon(Icons.check_circle, color: Color(0xFFFF3333), size: 20),
                  SizedBox(width: 8),
                  Text('Seçili: $_selectedCity',
                      style: TextStyle(
                          fontWeight: FontWeight.w600,
                          color: Color(0xFFFF3333))),
                ],
              ),
            ),
          ),
      ],
    );
  }

  Widget _buildExpandedCityList() {
    return Container(
      padding: EdgeInsets.symmetric(horizontal: 16),
      child: _filteredCities.isEmpty
          ? Center(
              child: Text('Sonuç bulunamadı',
                  style: TextStyle(color: Colors.grey)),
            )
          : ListView.builder(
              itemCount: _filteredCities.length,
              itemBuilder: (ctx, idx) {
                return ListTile(
                  title: Text(_filteredCities[idx]),
                  onTap: () {
                    setState(() {
                      _selectedCity = _filteredCities[idx];
                      _searchCity = '';
                      _showCityList = false;
                    });
                  },
                  selected: _selectedCity == _filteredCities[idx],
                  selectedTileColor: Colors.red.shade50,
                );
              },
            ),
    );
  }

  Widget _buildMagnitudeSection() {
    return SingleChildScrollView(
      padding: EdgeInsets.fromLTRB(16, 0, 16, 16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('Tahmini Büyüklük',
              style: TextStyle(fontSize: 14, fontWeight: FontWeight.w600)),
          SizedBox(height: 12),
          ..._buildMagnitudeOptions(),
          SizedBox(height: 16),
        ],
      ),
    );
  }

  List<Widget> _buildMagnitudeOptions() {
    return magnitudes.asMap().entries.map((entry) {
      Map<String, String> mag = entry.value;
      double magValue = double.parse(mag['min']!);
      bool isSelected = _selectedMagnitude == magValue;

      return Padding(
        padding: const EdgeInsets.only(bottom: 10.0),
        child: Container(
          decoration: BoxDecoration(
            border: Border.all(
              color: isSelected ? Color(0xFFFF3333) : Colors.grey.shade300,
              width: isSelected ? 2 : 1,
            ),
            borderRadius: BorderRadius.circular(12),
          ),
          padding: EdgeInsets.all(12),
          child: Row(
            children: [
              Radio<double>(
                value: magValue,
                groupValue: _selectedMagnitude,
                activeColor: Color(0xFFFF3333),
                onChanged: (val) {
                  setState(() => _selectedMagnitude = val ?? 1.0);
                },
              ),
              SizedBox(width: 8),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('${mag['min']}-${mag['max']} Mw',
                        style: TextStyle(
                            fontWeight: FontWeight.w600,
                            color:
                                isSelected ? Color(0xFFFF3333) : Colors.black)),
                    Text(mag['desc']!,
                        style: TextStyle(fontSize: 12, color: Colors.grey)),
                  ],
                ),
              ),
            ],
          ),
        ),
      );
    }).toList();
  }
}
