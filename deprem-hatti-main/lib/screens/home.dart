import 'package:flutter/material.dart';
import '../widgets/notification_card.dart';

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Örnek veri; ekran tasarımını göstermek için
    final sampleNotifications = [
      {
        'title': 'Kandilli Rasathanesi: 4.2 büyüklüğünde deprem',
        'body': 'İstanbul çevresinde 4.2 büyüklüğünde bir sarsıntı hissedildi.',
        'time': '2 dk önce'
      },
      {
        'title': 'AFAD: Silivri - 3.8',
        'body': 'Silivri merkezli 3.8 büyüklüğünde deprem kaydedildi.',
        'time': '1 saat önce'
      }
    ];

    return Scaffold(
      appBar: AppBar(
        title: Text('Deprem Bildirimleri'),
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(12.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              'Son bildirimler',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 10),
            Expanded(
              child: ListView.separated(
                itemCount: sampleNotifications.length,
                separatorBuilder: (_, __) => SizedBox(height: 8),
                itemBuilder: (ctx, idx) {
                  final n = sampleNotifications[idx];
                  return NotificationCard(
                    title: n['title']!,
                    body: n['body']!,
                    time: n['time']!,
                    onTap: () {
                      Navigator.pushNamed(context, '/detail', arguments: n);
                    },
                  );
                },
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.refresh),
        onPressed: () {
          // Gelecekte yenileme/çekme işlemi eklenecek
          final snack = SnackBar(content: Text('Bildirimler yenilendi (örnek).'));
          ScaffoldMessenger.of(context).showSnackBar(snack);
        },
      ),
    );
  }
}
