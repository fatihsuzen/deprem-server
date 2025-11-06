import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';

class SettingsPage extends StatefulWidget {
  @override
  _SettingsPageState createState() => _SettingsPageState();
}

class _SettingsPageState extends State<SettingsPage> {
  bool _notificationsEnabled = true;
  double _minimumMagnitude = 3.0;
  bool _soundEnabled = true;
  bool _vibrationEnabled = true;
  bool _locationServicesEnabled = true;
  bool _backgroundRefreshEnabled = true;

  void _showMagnitudeDialog() {
    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: Text('Minimum Büyüklük'),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text('Bildirim almak istediğiniz minimum deprem büyüklüğünü seçin'),
            SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('${_minimumMagnitude.toStringAsFixed(1)}+ Mw',
                    style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold, color: Color(0xFFFF3333))),
              ],
            ),
            Slider(
              value: _minimumMagnitude,
              min: 1.0,
              max: 7.0,
              divisions: 60,
              activeColor: Color(0xFFFF3333),
              label: '${_minimumMagnitude.toStringAsFixed(1)}+',
              onChanged: (value) {
                setState(() {
                  _minimumMagnitude = value;
                });
              },
            ),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx),
            child: Text('İptal', style: TextStyle(color: Colors.grey[600])),
          ),
          ElevatedButton(
            onPressed: () {
              Navigator.pop(ctx);
              ScaffoldMessenger.of(context).showSnackBar(
                SnackBar(
                  content: Text('Minimum büyüklük ${_minimumMagnitude.toStringAsFixed(1)}+ olarak ayarlandı'),
                  backgroundColor: Color(0xFF4CAF50),
                ),
              );
            },
            style: ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
            child: Text('Kaydet', style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  void _showRatingDialog() {
    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: Row(
          children: [
            Icon(Icons.star, color: Colors.amber, size: 28),
            SizedBox(width: 8),
            Text('Bizi Değerlendirin'),
          ],
        ),
        content: Text(
          'Deprem Hattı\'nı beğendiniz mi? App Store\'da değerlendirerek bizi destekleyebilirsiniz!',
          style: TextStyle(fontSize: 15),
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx),
            child: Text('Daha Sonra', style: TextStyle(color: Colors.grey[600])),
          ),
          ElevatedButton(
            onPressed: () {
              Navigator.pop(ctx);
              ScaffoldMessenger.of(context).showSnackBar(
                SnackBar(
                  content: Text('App Store açılıyor...'),
                  backgroundColor: Color(0xFF4CAF50),
                ),
              );
            },
            style: ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
            child: Text('Değerlendir', style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  void _showProDialog() {
    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: Row(
          children: [
            Icon(Icons.workspace_premium, color: Colors.amber, size: 28),
            SizedBox(width: 8),
            Text('Pro Sürüm'),
          ],
        ),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              'Pro özellikler:',
              style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 12),
            _buildProFeature('🚫 Reklamsız deneyim'),
            _buildProFeature('📊 Detaylı deprem analizi'),
            _buildProFeature('🔔 Öncelikli bildirimler'),
            _buildProFeature('📍 Gelişmiş konum takibi'),
            _buildProFeature('📈 Geçmiş veri analizi'),
            _buildProFeature('🎨 Özel temalar'),
            SizedBox(height: 16),
            Center(
              child: Text(
                '₺49,99 / Yıl',
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  color: Color(0xFFFF3333),
                ),
              ),
            ),
          ],
        ),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(ctx),
            child: Text('İptal', style: TextStyle(color: Colors.grey[600])),
          ),
          ElevatedButton(
            onPressed: () {
              Navigator.pop(ctx);
              ScaffoldMessenger.of(context).showSnackBar(
                SnackBar(
                  content: Text('Satın alma işlemi başlatılıyor...'),
                  backgroundColor: Color(0xFF4CAF50),
                ),
              );
            },
            style: ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
            child: Text('Satın Al', style: TextStyle(color: Colors.white)),
          ),
        ],
      ),
    );
  }

  Widget _buildProFeature(String text) {
    return Padding(
      padding: EdgeInsets.symmetric(vertical: 4),
      child: Row(
        children: [
          Text(text, style: TextStyle(fontSize: 14)),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return ListView(
      padding: EdgeInsets.all(0),
      children: [
        // Bildirimler Bölümü
        _buildSectionHeader('Bildirimler'),
        _buildSettingTile(
          icon: Icons.notifications_active,
          title: 'Bildirimlere İzin Ver',
          subtitle: 'Deprem bildirimleri al',
          trailing: CupertinoSwitch(
            value: _notificationsEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: (value) {
              setState(() {
                _notificationsEnabled = value;
              });
            },
          ),
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.speed,
          title: 'Minimum Büyüklük',
          subtitle: '${_minimumMagnitude.toStringAsFixed(1)}+ Mw ve üzeri',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: _showMagnitudeDialog,
          enabled: _notificationsEnabled,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.volume_up,
          title: 'Bildirim Sesi',
          subtitle: 'Sesli uyarı',
          trailing: CupertinoSwitch(
            value: _soundEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: _notificationsEnabled ? (value) {
              setState(() {
                _soundEnabled = value;
              });
            } : null,
          ),
          enabled: _notificationsEnabled,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.vibration,
          title: 'Titreşim',
          subtitle: 'Cihazı titret',
          trailing: CupertinoSwitch(
            value: _vibrationEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: _notificationsEnabled ? (value) {
              setState(() {
                _vibrationEnabled = value;
              });
            } : null,
          ),
          enabled: _notificationsEnabled,
        ),

        SizedBox(height: 16),

        // Konum ve Veriler Bölümü
        _buildSectionHeader('Konum ve Veriler'),
        _buildSettingTile(
          icon: Icons.location_on,
          title: 'Konum Servisleri',
          subtitle: 'Konumunuza yakın depremleri göster',
          trailing: CupertinoSwitch(
            value: _locationServicesEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: (value) {
              setState(() {
                _locationServicesEnabled = value;
              });
            },
          ),
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.refresh,
          title: 'Arka Plan Yenileme',
          subtitle: 'Uygulama kapalıyken veri güncelle',
          trailing: CupertinoSwitch(
            value: _backgroundRefreshEnabled,
            activeColor: Color(0xFFFF3333),
            onChanged: (value) {
              setState(() {
                _backgroundRefreshEnabled = value;
              });
            },
          ),
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.storage,
          title: 'Önbelleği Temizle',
          subtitle: 'Depolanan verileri sil',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            showDialog(
              context: context,
              builder: (ctx) => AlertDialog(
                title: Text('Önbelleği Temizle'),
                content: Text('Tüm önbelleğe alınmış veriler silinecek. Devam etmek istiyor musunuz?'),
                actions: [
                  TextButton(
                    onPressed: () => Navigator.pop(ctx),
                    child: Text('İptal', style: TextStyle(color: Colors.grey[600])),
                  ),
                  ElevatedButton(
                    onPressed: () {
                      Navigator.pop(ctx);
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                          content: Text('Önbellek temizlendi'),
                          backgroundColor: Color(0xFF4CAF50),
                        ),
                      );
                    },
                    style: ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
                    child: Text('Temizle', style: TextStyle(color: Colors.white)),
                  ),
                ],
              ),
            );
          },
        ),

        SizedBox(height: 16),

        // Hakkında Bölümü
        _buildSectionHeader('Hakkında'),
        _buildSettingTile(
          icon: Icons.star,
          title: 'Bizi Puanla',
          subtitle: 'App Store\'da değerlendir',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: _showRatingDialog,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.workspace_premium,
          title: 'Pro Sürüme Geç',
          subtitle: 'Tüm özelliklerin kilidini aç',
          trailing: Container(
            padding: EdgeInsets.symmetric(horizontal: 8, vertical: 4),
            decoration: BoxDecoration(
              color: Colors.amber,
              borderRadius: BorderRadius.circular(12),
            ),
            child: Text(
              'PRO',
              style: TextStyle(
                color: Colors.white,
                fontSize: 11,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
          onTap: _showProDialog,
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.info_outline,
          title: 'Uygulama Hakkında',
          subtitle: 'Kullanım şartları ve gizlilik',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            showDialog(
              context: context,
              builder: (ctx) => AlertDialog(
                title: Text('Deprem Hattı'),
                content: Column(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('Türkiye\'nin en kapsamlı deprem takip uygulaması'),
                    SizedBox(height: 12),
                    Text('© 2025 Deprem Hattı', style: TextStyle(fontSize: 12, color: Colors.grey[600])),
                    SizedBox(height: 8),
                    Text('Tüm hakları saklıdır.', style: TextStyle(fontSize: 12, color: Colors.grey[600])),
                  ],
                ),
                actions: [
                  ElevatedButton(
                    onPressed: () => Navigator.pop(ctx),
                    style: ElevatedButton.styleFrom(backgroundColor: Color(0xFFFF3333)),
                    child: Text('Tamam', style: TextStyle(color: Colors.white)),
                  ),
                ],
              ),
            );
          },
        ),
        _buildDivider(),
        _buildSettingTile(
          icon: Icons.bug_report,
          title: 'Hata Bildir',
          subtitle: 'Sorun mu yaşıyorsunuz?',
          trailing: Icon(Icons.chevron_right, color: Colors.grey[400]),
          onTap: () {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(
                content: Text('Hata bildirimi formu açılıyor...'),
                backgroundColor: Color(0xFF4CAF50),
              ),
            );
          },
        ),

        SizedBox(height: 32),

        // Versiyon Numarası
        Center(
          child: Text(
            'Versiyon 1.0.0',
            style: TextStyle(
              fontSize: 12,
              color: Colors.grey[500],
            ),
          ),
        ),
        SizedBox(height: 8),
        Center(
          child: Text(
            'Build 2024110601',
            style: TextStyle(
              fontSize: 10,
              color: Colors.grey[400],
            ),
          ),
        ),
        SizedBox(height: 32),
      ],
    );
  }

  Widget _buildSectionHeader(String title) {
    return Container(
      padding: EdgeInsets.fromLTRB(16, 16, 16, 8),
      child: Text(
        title.toUpperCase(),
        style: TextStyle(
          fontSize: 13,
          fontWeight: FontWeight.w600,
          color: Colors.grey[600],
          letterSpacing: 0.5,
        ),
      ),
    );
  }

  Widget _buildSettingTile({
    required IconData icon,
    required String title,
    required String subtitle,
    required Widget trailing,
    VoidCallback? onTap,
    bool enabled = true,
  }) {
    return Container(
      color: Colors.white,
      child: ListTile(
        leading: Container(
          width: 40,
          height: 40,
          decoration: BoxDecoration(
            color: enabled ? Color(0xFFFF3333).withOpacity(0.1) : Colors.grey.withOpacity(0.1),
            borderRadius: BorderRadius.circular(10),
          ),
          child: Icon(
            icon,
            color: enabled ? Color(0xFFFF3333) : Colors.grey,
            size: 22,
          ),
        ),
        title: Text(
          title,
          style: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.w500,
            color: enabled ? Colors.black87 : Colors.grey,
          ),
        ),
        subtitle: Text(
          subtitle,
          style: TextStyle(
            fontSize: 13,
            color: enabled ? Colors.grey[600] : Colors.grey[400],
          ),
        ),
        trailing: trailing,
        onTap: enabled ? onTap : null,
      ),
    );
  }

  Widget _buildDivider() {
    return Divider(height: 1, indent: 72, color: Colors.grey[200]);
  }
}
