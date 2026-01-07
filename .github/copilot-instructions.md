# Copilot Instructions for Deprem Erken Uyarı Sistemi

## Project Overview
- **Purpose:** Peer-to-peer (P2P) earthquake early warning system. Combines a Flutter mobile app and Node.js backend. Uses device sensors to detect P-waves and notifies users before S-waves arrive.
- **Major Components:**
  - `lib/` — Flutter app code (UI, services, widgets)
  - `server/` — Node.js backend (API endpoints, notification logic)
  - `android/`, `ios/` — Native platform code for mobile deployment
  - `deprem-hatti-main/` — Flutter UI prototype (reference only)

## Key Workflows
- **Flutter App:**
  - Install dependencies: `flutter pub get`
  - Run: `flutter run`
  - Main entry: `lib/main.dart`
  - Services: `lib/services/` (API, MQTT, notifications, location, friends)
  - Localization: `lib/l10n/`
  - Widgets: `lib/widgets/`
- **Backend:**
  - Start server: `cd server && npm install && npm start`
  - API endpoints: see `README.md` (e.g., `/api/earthquakes/recent`, `/api/chat/rooms`)
- **Testing:**
  - Flutter: `test/` (see `widget_test.dart`)
  - Backend: (no standard test folder, check for scripts or manual tests)

## Project-Specific Patterns
- **Service Layer:** All network and background logic is in `lib/services/`. Use these for API, MQTT, notifications, and location updates.
- **Dark Theme:** Fully supported, see `lib/main.dart` and `lib/widgets/` for Material 3 usage.
- **Localization:** Use `lib/l10n/locale_provider.dart` and `app_localizations.dart` for multi-language support.
- **API Integration:** Use `api_service.dart` for HTTP, `mqtt_service.dart` for real-time updates.
- **Friend/Location:** Friend and location logic is split across several `friends_service_*.dart` and `location_service.dart` files.

## Conventions & Tips
- **Do not hardcode API URLs:** Use the service layer and environment configs.
- **Cross-platform:** Always test on both Android and iOS.
- **Sensitive logic:** Earthquake detection and notification logic is critical—review changes carefully.
- **Refer to `README.md` for API contracts and setup.**

## Integration Points
- **MQTT:** Real-time messaging for alerts (see `mqtt_service.dart`).
- **Firebase:** Used for push notifications (see `firebase_options.dart`).
- **Node.js API:** All data flows through REST endpoints in `server/`.

## Example: Adding a New API Call
1. Add method in `lib/services/api_service.dart`.
2. Expose via a provider or controller.
3. Use in a widget or screen.

---
For more, see `README.md`, `PRIORITY-NOTIFICATION-SYSTEM.md`, and code comments in `lib/services/`.
