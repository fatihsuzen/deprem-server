# Firebase Cloud Messaging (FCM) Entegrasyonu

## ✅ YAPILAN DEĞİŞİKLİKLER

### 1. Flutter (Client) Tarafı

#### Yeni Servis: `lib/services/fcm_service.dart`
- **FCM Token yönetimi** - Her cihaz için unique token
- **Background message handler** - Uygulama kapalıyken çalışır
- **Foreground message handler** - Uygulama açıkken çalışır
- **Topic subscription** - "earthquake_alerts" topic'ine abone
- **Token server'a gönderme** - `/api/fcm/register` endpoint'ine

#### `main.dart` Değişiklikleri
```dart
// Firebase initialize
await Firebase.initializeApp();

// Background handler kaydet
FirebaseMessaging.onBackgroundMessage(firebaseMessagingBackgroundHandler);

// FCM Service başlat
final fcmService = FCMService();
await fcmService.initialize();
await fcmService.subscribeToEarthquakeAlerts();
```

#### `pubspec.yaml` 
```yaml
firebase_messaging: ^14.7.9
```

### 2. Server Tarafı

#### Yeni Route: `routes/fcm.js`
- **POST `/api/fcm/register`** - FCM token kaydetme
- **`sendEarthquakeNotificationToAll()`** - Topic'e bildirim gönder
- **`sendEarthquakeNotificationToUsers()`** - Belirli kullanıcılara gönder

#### `server.js` Değişiklikleri
```javascript
// FCM route ekle
const { router: fcmRoutes } = require('./routes/fcm');
app.use('/api/fcm', fcmRoutes);

// Test endpoint'inde FCM kullan
const { sendEarthquakeNotificationToAll } = require('./routes/fcm');
await sendEarthquakeNotificationToAll(testEarthquake);
```

## 🚀 NASIL ÇALIŞIR?

### Akış Diyagramı
```
1. Kullanıcı uygulamayı açar
   └─> FCM Token alınır
       └─> Token server'a gönderilir
           └─> "earthquake_alerts" topic'ine subscribe olur

2. Deprem oluşur (AFAD/Kandilli)
   └─> Server depremi algılar
       └─> FCM ile "earthquake_alerts" topic'ine bildirim gönderir
           ├─> Uygulama açık ise: foreground handler çalışır
           ├─> Uygulama arka planda ise: background handler çalışır
           └─> Uygulama kapalı ise: Android sistem bildirimi + background handler
               └─> Tam ekran alarm gösterilir
```

### WebSocket vs FCM

| Özellik | WebSocket | FCM |
|---------|-----------|-----|
| Uygulama açık | ✅ Çalışır | ✅ Çalışır |
| Arka plan | ✅ Çalışır (foreground service) | ✅ Çalışır |
| **Tamamen kapalı** | ❌ **ÇALIŞMAZ** | ✅ **ÇALIŞIR** |
| Batarya tüketimi | 🔴 Yüksek | 🟢 Düşük |
| Gerçek zamanlı | ✅ Anında | ⚠️ ~1-2 saniye gecikme |

**KARAR:** 
- **FCM** → Deprem bildirimleri (kritik, uygulama kapalıyken bile)
- **WebSocket** → Harita güncellemeleri (gerçek zamanlı, opsiyonel)

## 🔧 KURULUM ADIMLARı

### 1. Firebase Console Setup
1. https://console.firebase.google.com/ → Projeyi seç
2. **Project Settings** → **Cloud Messaging** → **Server Key** kopyala
3. **Service Accounts** → **Generate New Private Key** → JSON indir

### 2. Server Setup
```bash
cd server
npm install firebase-admin
```

`routes/fcm.js` dosyasında:
```javascript
const serviceAccount = require('./path/to/serviceAccountKey.json');
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount)
});
```

### 3. Database (Optional)
```sql
CREATE TABLE user_fcm_tokens (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id VARCHAR(255) NOT NULL,
  fcm_token TEXT NOT NULL,
  platform VARCHAR(50),
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY unique_user (user_id)
);
```

### 4. Android Manifest
Zaten eklendi:
```xml
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
<uses-permission android:name="android.permission.USE_FULL_SCREEN_INTENT" />
```

## 📱 TEST ETME

### Manuel Test
1. Uygulamayı kapat (swipe away)
2. Browser'dan test endpoint'ini çağır:
   ```
   http://188.132.202.24:3000/api/test/earthquake-notification
   ```
3. **Beklenen:** 
   - Telefon ekranı uyanır
   - Tam ekran bildirim çıkar
   - "🚨 DEPREM! M4.5" görünür

### FCM Token Kontrolü
```dart
// Debug log
final fcmService = FCMService();
print('FCM Token: ${fcmService.fcmToken}');
```

### Server Log
```bash
# Terminal'de server loglarını izle
tail -f server.log

# Beklenen çıktı:
✅ FCM Token kaydedildi - User: 123456789
🔥 FCM Deprem bildirimi gönderiliyor: M4.5 - İstanbul
✅ FCM mesaj gönderildi: projects/xxx/messages/xxx
```

## 🔍 SORUN GİDERME

### Problem: FCM Token alınamıyor
**Çözüm:**
- `google-services.json` dosyasını `android/app/` klasörüne ekle
- Firebase Console'da Android uygulaması eklenmiş mi kontrol et
- Package name doğru mu: `com.fsapps.earthquake_line`

### Problem: Bildirim gelmiyor
**Kontrol:**
```dart
// Bildirim izni verilmiş mi?
NotificationSettings settings = await FirebaseMessaging.instance.requestPermission();
print(settings.authorizationStatus); // authorized olmalı
```

### Problem: Background handler çalışmıyor
**Çözüm:**
- `@pragma('vm:entry-point')` annotation'ı ekli mi?
- `main.dart` içinde `onBackgroundMessage` kayıtlı mı?
- Logları görmek için: `adb logcat -s flutter`

## 📊 AVANTAJLAR

✅ **Uygulama kapalıyken bile çalışır** - En kritik özellik
✅ **Batarya dostu** - Google'ın native push sistemi
✅ **Güvenilir** - %99.9 uptime
✅ **Ölçeklenebilir** - Milyonlarca cihaza aynı anda
✅ **Ücretsiz** - Firebase Spark plan yeterli
✅ **Cross-platform** - Android + iOS

## 🎯 SONRAKI ADIMLAR

1. ✅ FCM entegrasyonu tamamlandı
2. ⏳ Firebase Service Account Key ekle
3. ⏳ Production'da test et
4. ⏳ Topic-based targeting optimize et
5. ⏳ Analytics ekle (kaç bildirim gönderildi, açıldı)
6. ⏳ iOS için APNs sertifikası ekle

## 📝 NOTLAR

- **WebSocket tamamen kaldırılmadı** - Harita güncellemeleri için kullanılabilir
- **Background service hala çalışıyor** - Konum güncellemeleri için
- **FCM priority: HIGH** - Android Doze mode'u bypass eder
- **fullScreenIntent: true** - Ekranı otomatik açar
