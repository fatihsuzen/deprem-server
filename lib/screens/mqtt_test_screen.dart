import 'package:flutter/material.dart';
import '../services/mqtt_service.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class MqttTestScreen extends StatefulWidget {
  const MqttTestScreen({super.key});

  @override
  State<MqttTestScreen> createState() => _MqttTestScreenState();
}

class _MqttTestScreenState extends State<MqttTestScreen> {
  final _serverBase = 'http://your-server:3000';
  String _status = 'idle';
  String _clientId = '';

  @override
  void initState() {
    super.initState();
    _loadClientId();
  }

  Future<void> _loadClientId() async {
    final id = MqttService.instance.clientId;
    setState(() {
      _clientId = id ?? '';
    });
  }

  Future<void> _startForeground() async {
    setState(() => _status = 'starting');
    await MqttService.instance.startForegroundTask();
    await Future.delayed(const Duration(seconds: 1));
    setState(() => _status = 'started');
    _loadClientId();
  }

  Future<void> _stopForeground() async {
    setState(() => _status = 'stopping');
    await MqttService.instance.stopForegroundTask();
    setState(() => _status = 'stopped');
  }

  Future<void> _testPush() async {
    if (_clientId.isEmpty) {
      setState(() => _status = 'no-client');
      return;
    }
    final target = 'mqtt_$_clientId';
    final url = Uri.parse('$_serverBase/api/test/push');
    final body = jsonEncode({ 'target': target, 'title': 'Test', 'body': 'MQTT test mesajı' });
    try {
      final r = await http.post(url, body: body, headers: {'Content-Type': 'application/json'}).timeout(const Duration(seconds: 10));
      setState(() => _status = 'sent ${r.statusCode}');
    } catch (e) {
      setState(() => _status = 'error $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('MQTT Test')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text('ClientId: $_clientId'),
            const SizedBox(height: 12),
            ElevatedButton(onPressed: _startForeground, child: const Text('Start Foreground & Connect')),
            const SizedBox(height: 8),
            ElevatedButton(onPressed: _stopForeground, child: const Text('Stop Foreground')),
            const SizedBox(height: 12),
            ElevatedButton(onPressed: _testPush, child: const Text('Send test push via server')),
            const SizedBox(height: 12),
            Text('Status: $_status')
          ],
        ),
      ),
    );
  }
}
