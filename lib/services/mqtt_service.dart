import 'dart:convert';
import 'package:flutter/foundation.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:mqtt_client/mqtt_client.dart' as mqtt;
import 'package:mqtt_client/mqtt_server_client.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:http/http.dart' as http;
import 'package:flutter_foreground_task/flutter_foreground_task.dart';
import 'foreground_task_handler.dart';

// Simple MQTT service for Android (persistent connection in foreground)
class MqttService with ChangeNotifier {
  MqttService._privateConstructor();
  static final MqttService instance = MqttService._privateConstructor();

  MqttServerClient? _client;
  String? clientId;
  String? brokerUrl; // e.g. broker.example.com
  int brokerPort = 8883;
  bool useTls = true;

  final FlutterLocalNotificationsPlugin _localNotifications =
      FlutterLocalNotificationsPlugin();

  Future<void> initLocalNotifications() async {
    const androidInit =
        AndroidInitializationSettings('@drawable/ic_notification');
    const iOSInit = DarwinInitializationSettings();
    const initSettings =
        InitializationSettings(android: androidInit, iOS: iOSInit);
    await _localNotifications.initialize(initSettings);
  }

  Future<void> configure(
      {required String brokerUrlWithScheme, int? port, bool? tls}) async {
    brokerUrl = brokerUrlWithScheme;
    if (port != null) brokerPort = port;
    if (tls != null) useTls = tls;

    await initLocalNotifications();

    // Load stored clientId or create a new one
    final prefs = await SharedPreferences.getInstance();
    clientId = prefs.getString('mqtt_client_id');
    if (clientId == null) {
      clientId = 'android_${DateTime.now().millisecondsSinceEpoch}';
      await prefs.setString('mqtt_client_id', clientId!);
    }
  }

  Future<void> connectAndSubscribe() async {
    if (brokerUrl == null || clientId == null) return;

    final uri = Uri.parse(brokerUrl!);
    final host = uri.host;
    final port = uri.hasPort ? uri.port : brokerPort;

    _client = MqttServerClient.withPort(host, clientId!, port);
    _client!.secure = useTls;
    _client!.logging(on: false);
    _client!.keepAlivePeriod = 20;
    _client!.onDisconnected = _onDisconnected;
    _client!.onConnected = _onConnected;
    _client!.pongCallback = _onPong;

    final connMess = mqtt.MqttConnectMessage()
        .withClientIdentifier(clientId!)
        .startClean()
        .withWillQos(mqtt.MqttQos.atLeastOnce);
    _client!.connectionMessage = connMess;

    try {
      await _client!.connect();
    } catch (e) {
      debugPrint('MQTT connection error: $e');
      _client?.disconnect();
      return;
    }

    if (_client!.connectionStatus?.state ==
        mqtt.MqttConnectionState.connected) {
      debugPrint('MQTT connected as $clientId');
      // register device with server using mqttClientId
      await _registerWithServer();

      final topic = 'devices/$clientId/notifications';
      _client!.subscribe(topic, mqtt.MqttQos.atLeastOnce);

      _client!.updates
          ?.listen((List<mqtt.MqttReceivedMessage<mqtt.MqttMessage?>>? c) {
        final recMess = c![0].payload as mqtt.MqttPublishMessage;
        final pt = mqtt.MqttPublishPayload.bytesToStringAsString(
            recMess.payload.message);
        _handleIncoming(pt);
      });
    } else {
      debugPrint(
          'MQTT connection failed - status is ${_client?.connectionStatus}');
    }
  }

  void _onConnected() {
    debugPrint('MQTT onConnected');
  }

  void _onDisconnected() {
    debugPrint('MQTT disconnected');
    // try reconnect with backoff
    Future.delayed(const Duration(seconds: 5), () {
      connectAndSubscribe();
    });
  }

  void _onPong() {
    debugPrint('MQTT pong');
  }

  Future<void> _registerWithServer() async {
    try {
      final url = Uri.parse('${_serverBaseUrl()}/api/devices/register');
      final body = {
        'deviceId': clientId,
        'mqttClientId': clientId,
        'platform': 'android'
      };
      final r = await http.post(url, body: jsonEncode(body), headers: {
        'Content-Type': 'application/json'
      }).timeout(const Duration(seconds: 10));
      debugPrint('Device register response: ${r.statusCode} ${r.body}');
    } catch (e) {
      debugPrint('Device register failed: $e');
    }
  }

  String _serverBaseUrl() {
    // TODO: read from config or env; for now assume same host as API
    return 'http://your-server:3000';
  }

  Future<void> _handleIncoming(String payload) async {
    debugPrint('MQTT message payload: $payload');
    try {
      final data = jsonDecode(payload);
      final title = data['title'] ?? 'Deprem Uyarısı';
      final body = data['body'] ?? data['message'] ?? '';

      const androidDetails = AndroidNotificationDetails(
        'earthquake_alerts',
        'Earthquake Alerts',
        channelDescription: 'Deprem uyarıları',
        importance: Importance.max,
        priority: Priority.high,
        playSound: true,
        ticker: 'ticker',
      );
      const iOSDetails = DarwinNotificationDetails();
      const platform =
          NotificationDetails(android: androidDetails, iOS: iOSDetails);

      await _localNotifications.show(
        DateTime.now().millisecondsSinceEpoch ~/ 1000,
        title,
        body,
        platform,
        payload: payload,
      );
    } catch (e) {
      debugPrint('Failed to show notification: $e');
    }
  }

  Future<void> disconnect() async {
    try {
      _client?.disconnect();
    } catch (e) {}
  }

  // Start Android foreground task which will keep the service alive
  Future<void> startForegroundTask() async {
    // Request to start foreground task with a notification
    FlutterForegroundTask.init(
      androidNotificationOptions: AndroidNotificationOptions(
        channelId: 'foreground_channel',
        channelName: 'Foreground Service',
        channelDescription: 'Keeps MQTT connection alive',
        channelImportance: NotificationChannelImportance.HIGH,
        priority: NotificationPriority.MAX,
      ),
      iosNotificationOptions: const IOSNotificationOptions(),
      foregroundTaskOptions: ForegroundTaskOptions(
          eventAction: ForegroundTaskEventAction.repeat(5000)),
    );
    // Register the handler and start the service
    FlutterForegroundTask.setTaskHandler(MqttForegroundTaskHandler());
    await FlutterForegroundTask.startService(
      notificationTitle: 'Deprem App',
      notificationText: 'Bağlanıyor...',
    );
  }

  // Return whether the foreground service is currently running.
  Future<bool> isServiceRunning() async {
    try {
      // FlutterForegroundTask exposes a boolean future indicating running state
      final running = await FlutterForegroundTask.isRunningService;
      return running;
    } catch (e) {
      debugPrint('isServiceRunning check failed: $e');
      return false;
    }
  }

  Future<void> stopForegroundTask() async {
    await FlutterForegroundTask.stopService();
  }
}
