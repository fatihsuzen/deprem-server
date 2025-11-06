import 'package:flutter/material.dart';

class NotificationDetailScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final args = ModalRoute.of(context)!.settings.arguments as Map<String, String>?;
    final title = args != null ? args['title'] ?? 'Bildirim' : 'Bildirim';
    final body = args != null ? args['body'] ?? '' : '';
    final time = args != null ? args['time'] ?? '' : '';

    return Scaffold(
      appBar: AppBar(
        title: Text('Bildirim Detayı'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(title, style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
            SizedBox(height: 8),
            Text(time, style: TextStyle(color: Colors.grey)),
            SizedBox(height: 16),
            Expanded(child: SingleChildScrollView(child: Text(body, style: TextStyle(fontSize: 16)))),
          ],
        ),
      ),
    );
  }
}
