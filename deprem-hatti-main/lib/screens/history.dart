import 'package:flutter/material.dart';

class HistoryPage extends StatefulWidget {
  @override
  _HistoryPageState createState() => _HistoryPageState();
}

class _HistoryPageState extends State<HistoryPage> {
  String _selectedFilter = 'Tümü';
  
  final List<Map<String, dynamic>> _earthquakes = [
    {
      'magnitude': 5.2,
      'location': 'Silivri Açıkları (İstanbul)',
      'depth': '12.5 km',
      'minutesAgo': 10,
      'time': '17:20',
      'intensity': 'Şiddetli'
    },
    {
      'magnitude': 4.8,
      'location': 'Burdur - Gölhisar',
      'depth': '8.3 km',
      'minutesAgo': 125,
      'time': '22:45',
      'intensity': 'Belirgin'
    },
    {
      'magnitude': 4.2,
      'location': 'İstanbul Merkez',
      'depth': '15.2 km',
      'minutesAgo': 280,
      'time': '14:35',
      'intensity': 'Belirgin'
    },
    {
      'magnitude': 3.8,
      'location': 'Balıkesir Merkez',
      'depth': '10.0 km',
      'minutesAgo': 450,
      'time': '14:35',
      'intensity': 'Hafif'
    },
    {
      'magnitude': 3.5,
      'location': 'İzmir - Seferihisar',
      'depth': '7.8 km',
      'minutesAgo': 680,
      'time': '09:12',
      'intensity': 'Hafif'
    },
    {
      'magnitude': 2.9,
      'location': 'Manisa - Akhisar',
      'depth': '5.4 km',
      'minutesAgo': 890,
      'time': '03:45',
      'intensity': 'Çok Hafif'
    },
    {
      'magnitude': 2.6,
      'location': 'Aydın - Söke',
      'depth': '6.2 km',
      'minutesAgo': 1200,
      'time': '09:15',
      'intensity': 'Çok Hafif'
    },
  ];

  String _getTimeAgoText(int minutesAgo) {
    if (minutesAgo < 60) {
      return '$minutesAgo dk önce';
    } else if (minutesAgo < 1440) { // 24 saat = 1440 dakika
      final hours = (minutesAgo / 60).floor();
      return '$hours saat önce';
    } else {
      return '1 gün önce';
    }
  }

  List<Map<String, dynamic>> get _filteredEarthquakes {
    // Son 24 saat içindeki depremleri filtrele (1440 dakika)
    final last24Hours = _earthquakes.where((eq) => eq['minutesAgo'] <= 1440).toList();
    
    if (_selectedFilter == 'Tümü') {
      return last24Hours;
    } else if (_selectedFilter == 'Bugün') {
      return last24Hours.where((eq) => eq['minutesAgo'] <= 720).toList(); // 12 saat
    } else if (_selectedFilter == 'Bu Hafta') {
      return last24Hours; // 24 saat zaten
    }
    return last24Hours;
  }

  Color _getMagnitudeColor(double magnitude) {
    if (magnitude >= 5.0) return Color(0xFFFF3333);
    if (magnitude >= 4.0) return Colors.deepOrange;
    if (magnitude >= 3.0) return Colors.orange;
    return Colors.green;
  }

  IconData _getMagnitudeIcon(double magnitude) {
    if (magnitude >= 5.0) return Icons.warning_rounded;
    if (magnitude >= 4.0) return Icons.error_outline;
    if (magnitude >= 3.0) return Icons.info_outline;
    return Icons.circle;
  }

  void _showEarthquakeDetail(Map<String, dynamic> earthquake) {
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
              Text(
                'Deprem Detayları',
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
                    color: _getMagnitudeColor(earthquake['magnitude']),
                    size: 24,
                  ),
                  SizedBox(width: 12),
                  Text(
                    '${earthquake['magnitude']} Mw',
                    style: TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.bold,
                      color: Colors.black87,
                    ),
                  ),
                  SizedBox(width: 8),
                  Text(
                    earthquake['intensity'],
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
                  Icon(Icons.location_on, color: Color(0xFFFF3333), size: 24),
                  SizedBox(width: 12),
                  Expanded(
                    child: Text(
                      earthquake['location'],
                      style: TextStyle(fontSize: 16, color: Colors.black87),
                    ),
                  ),
                ],
              ),
              SizedBox(height: 20),
              
              // Derinlik
              Row(
                children: [
                  Icon(Icons.layers, color: Color(0xFFFF3333), size: 24),
                  SizedBox(width: 12),
                  Text(
                    'Derinlik: ${earthquake['depth']}',
                    style: TextStyle(fontSize: 16, color: Colors.black87),
                  ),
                ],
              ),
              SizedBox(height: 20),
              
              // Zaman
              Row(
                children: [
                  Icon(Icons.access_time, color: Color(0xFFFF3333), size: 24),
                  SizedBox(width: 12),
                  Text(
                    _getTimeAgoText(earthquake['minutesAgo']),
                    style: TextStyle(fontSize: 16, color: Colors.black87),
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
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        // Filtre butonları
        Container(
          padding: EdgeInsets.symmetric(horizontal: 16, vertical: 12),
          decoration: BoxDecoration(
            color: Colors.white,
            boxShadow: [
              BoxShadow(
                color: Colors.black.withOpacity(0.05),
                blurRadius: 4,
                offset: Offset(0, 2),
              ),
            ],
          ),
          child: Row(
            children: [
              _buildFilterChip('Tümü'),
              SizedBox(width: 8),
              _buildFilterChip('Bugün'),
              SizedBox(width: 8),
              _buildFilterChip('Bu Hafta'),
            ],
          ),
        ),
        
        // Deprem listesi
        Expanded(
          child: _filteredEarthquakes.isEmpty
              ? Center(
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Icon(
                        Icons.inbox_outlined,
                        size: 64,
                        color: Colors.grey[400],
                      ),
                      SizedBox(height: 16),
                      Text(
                        'Deprem kaydı bulunamadı',
                        style: TextStyle(
                          fontSize: 16,
                          color: Colors.grey[600],
                        ),
                      ),
                    ],
                  ),
                )
              : ListView.builder(
                  padding: EdgeInsets.all(16),
                  itemCount: _filteredEarthquakes.length,
                  itemBuilder: (context, index) {
                    final earthquake = _filteredEarthquakes[index];
                    return _buildEarthquakeCard(earthquake);
                  },
                ),
        ),
      ],
    );
  }

  Widget _buildFilterChip(String label) {
    final isSelected = _selectedFilter == label;
    return GestureDetector(
      onTap: () {
        setState(() {
          _selectedFilter = label;
        });
      },
      child: Container(
        padding: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
        decoration: BoxDecoration(
          color: isSelected ? Color(0xFFFF3333) : Colors.grey[200],
          borderRadius: BorderRadius.circular(20),
        ),
        child: Text(
          label,
          style: TextStyle(
            color: isSelected ? Colors.white : Colors.grey[700],
            fontWeight: isSelected ? FontWeight.w600 : FontWeight.normal,
            fontSize: 14,
          ),
        ),
      ),
    );
  }

  Widget _buildEarthquakeCard(Map<String, dynamic> earthquake) {
    final magnitude = earthquake['magnitude'] as double;
    final color = _getMagnitudeColor(magnitude);
    
    return Container(
      margin: EdgeInsets.only(bottom: 12),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: Colors.grey[200]!),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.05),
            blurRadius: 8,
            offset: Offset(0, 2),
          ),
        ],
      ),
      child: Material(
        color: Colors.transparent,
        child: InkWell(
          onTap: () => _showEarthquakeDetail(earthquake),
          borderRadius: BorderRadius.circular(16),
          child: Padding(
            padding: EdgeInsets.all(16),
            child: Row(
              children: [
                // Magnitude badge
                Container(
                  width: 60,
                  height: 60,
                  decoration: BoxDecoration(
                    color: color.withOpacity(0.1),
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Icon(
                        _getMagnitudeIcon(magnitude),
                        color: color,
                        size: 24,
                      ),
                      SizedBox(height: 4),
                      Text(
                        '${magnitude}',
                        style: TextStyle(
                          fontSize: 14,
                          fontWeight: FontWeight.bold,
                          color: color,
                        ),
                      ),
                    ],
                  ),
                ),
                SizedBox(width: 16),
                
                // Deprem bilgileri
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        earthquake['location'],
                        style: TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.w600,
                          color: Colors.black87,
                        ),
                        maxLines: 2,
                        overflow: TextOverflow.ellipsis,
                      ),
                      SizedBox(height: 6),
                      Row(
                        children: [
                          Icon(
                            Icons.layers,
                            size: 14,
                            color: Colors.grey[600],
                          ),
                          SizedBox(width: 4),
                          Text(
                            earthquake['depth'],
                            style: TextStyle(
                              fontSize: 13,
                              color: Colors.grey[600],
                            ),
                          ),
                          SizedBox(width: 12),
                          Icon(
                            Icons.access_time,
                            size: 14,
                            color: Colors.grey[600],
                          ),
                          SizedBox(width: 4),
                          Text(
                            earthquake['time'],
                            style: TextStyle(
                              fontSize: 13,
                              color: Colors.grey[600],
                            ),
                          ),
                        ],
                      ),
                      SizedBox(height: 4),
                      Text(
                        _getTimeAgoText(earthquake['minutesAgo']),
                        style: TextStyle(
                          fontSize: 12,
                          color: Colors.grey[500],
                        ),
                      ),
                    ],
                  ),
                ),
                
                // Chevron
                Icon(
                  Icons.chevron_right,
                  color: Colors.grey[400],
                  size: 24,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
