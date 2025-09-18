import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import '../services/earthquake_api.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

class PastEarthquakesScreen extends StatefulWidget {
  const PastEarthquakesScreen({Key? key}) : super(key: key);

  @override
  _PastEarthquakesScreenState createState() => _PastEarthquakesScreenState();
}

class _PastEarthquakesScreenState extends State<PastEarthquakesScreen> {
  bool loading = false;
  List<Map<String, dynamic>> earthquakes = [];
  int daysBack = 30;
  double minMagnitude = 0.0;

  @override
  void initState() {
    super.initState();
    _load();
  }

  Future<void> _load() async {
    setState(() => loading = true);
    try {
      final since = DateTime.now().subtract(Duration(days: daysBack));
      final list = await EarthquakeApi.fetchRecent(
        limit: 200,
        minMagnitude: minMagnitude,
        since: since,
      );
      setState(() => earthquakes = list);
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Deprem verisi yüklenirken hata: $e')),
      );
    } finally {
      setState(() => loading = false);
    }
  }

  String _formatDate(String iso) {
    try {
      final dt = DateTime.parse(iso);
      return DateFormat('yyyy-MM-dd HH:mm').format(dt.toLocal());
    } catch (_) {
      return iso;
    }
  }

  void _openMap(Map<String, dynamic> quake) {
    final lat = quake['location']?['lat'] ?? quake['lat'] ?? 0.0;
    final lon =
        quake['location']?['lon'] ?? quake['lng'] ?? quake['lon'] ?? 0.0;

    Navigator.of(context).push(MaterialPageRoute(builder: (_) {
      return Scaffold(
        appBar: AppBar(title: Text('Deprem Konumu')),
        body: GoogleMap(
          initialCameraPosition:
              CameraPosition(target: LatLng(lat, lon), zoom: 7),
          markers: {
            Marker(
              markerId:
                  MarkerId(quake['id']?.toString() ?? UniqueKey().toString()),
              position: LatLng(lat, lon),
              infoWindow: InfoWindow(
                title: quake['place'] ?? 'Deprem',
                snippet: 'Mw ${quake['magnitude'] ?? quake['mag'] ?? ''}',
              ),
            )
          },
        ),
      );
    }));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Geçmiş Depremler'),
        actions: [
          IconButton(
            icon: Icon(Icons.refresh),
            onPressed: _load,
          )
        ],
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              children: [
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('Gün (son)'),
                      Slider(
                        value: daysBack.toDouble(),
                        min: 1,
                        max: 365,
                        divisions: 364,
                        label: '$daysBack',
                        onChanged: (v) => setState(() => daysBack = v.toInt()),
                        onChangeEnd: (_) => _load(),
                      ),
                    ],
                  ),
                ),
                SizedBox(width: 12),
                Column(
                  children: [
                    Text('Min Mw'),
                    SizedBox(
                      width: 120,
                      child: Row(
                        children: [
                          Expanded(
                            child: Slider(
                              value: minMagnitude,
                              min: 0,
                              max: 9,
                              divisions: 90,
                              label: minMagnitude.toStringAsFixed(1),
                              onChanged: (v) =>
                                  setState(() => minMagnitude = v),
                              onChangeEnd: (_) => _load(),
                            ),
                          ),
                        ],
                      ),
                    )
                  ],
                )
              ],
            ),
          ),
          Expanded(
            child: loading
                ? Center(child: CircularProgressIndicator())
                : ListView.builder(
                    itemCount: earthquakes.length,
                    itemBuilder: (ctx, i) {
                      final q = earthquakes[i];
                      final mag = q['magnitude'] ?? q['mag'] ?? 0;
                      final place = q['place'] ?? q['title'] ?? '';

                      return ListTile(
                        title: Text('${mag.toString()} — $place'),
                        subtitle: Text(_formatDate(
                            q['timestamp'] ?? q['time'] ?? q['date'] ?? '')),
                        trailing: Icon(Icons.map),
                        onTap: () => _openMap(q),
                      );
                    },
                  ),
          )
        ],
      ),
    );
  }
}
