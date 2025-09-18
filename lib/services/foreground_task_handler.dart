import 'dart:async';
import 'dart:isolate';
import 'package:flutter_foreground_task/flutter_foreground_task.dart';
import 'mqtt_service.dart';

/// Foreground task handler that ensures MQTT connection remains alive while the
/// Android foreground service is active.
class MqttForegroundTaskHandler implements TaskHandler {
  @override
  Future<void> onStart(DateTime timestamp, SendPort? sendPort) async {
    // Called when foreground task starts
    try {
      await MqttService.instance.connectAndSubscribe();
    } catch (_) {}
  }

  @override
  Future<void> onEvent(DateTime timestamp, SendPort? sendPort) async {
    // Periodic event — can be used to send heartbeats or reconnect checks
    // no-op
  }

  @override
  Future<void> onDestroy(DateTime timestamp, SendPort? sendPort) async {
    try {
      await MqttService.instance.disconnect();
    } catch (_) {}
  }

  @override
  void onButtonPressed(String id) {
    // Handle notification button presses if configured
  }

  @override
  void onNotificationPressed() {
    // Handle tap on notification - typically open app
  }
}
