// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility in the flutter_test package. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:flutter_test/flutter_test.dart';

import 'package:deprem_app/main.dart';

void main() {
  testWidgets('Deprem App basic test', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const DepremApp());

    // Verify that our app shows the earthquake title
    expect(find.text('Deprem Bildirim Sistemi'), findsOneWidget);
    expect(find.text('Test Et'), findsOneWidget);
  });
}
