# Öncelikli Bildirim Sistemi

## Sistem Mimarisi

Deprem algılandığında, kullanıcılara **deprem merkezine olan uzaklıklarına göre sıralı bildirim** gönderilir. En yakın kullanıcılar en erken bildirimi alır.

### Akış Şeması

```
[DEPREM ALGILIYOR]
        ↓
[Tüm Kullanıcıları Veritabanından Al]
        ↓
[Her kullanıcı için mesafe hesapla (Haversine)]
        ↓
[Kullanıcıları mesafeye göre sırala (YAKINDAN UZAĞA)]
        ↓
[Her kullanıcı için sırayla:]
    ├─ Kullanıcının notificationRadius ayarını kontrol et
    ├─ Eğer mesafe > notificationRadius → ATLA
    ├─ Eğer mesafe ≤ notificationRadius → BİLDİRİM GÖNDER
    └─ Sonraki kullanıcıya geç
        ↓
[İSTATİSTİKLER: Gönderilen, Atlanan, Hata]
```

---

## Backend Özellikleri

### 1. PriorityNotificationService

**Dosya:** `services/priorityNotificationService.js`

#### Ana Metod: `sendPriorityEarthquakeNotifications(earthquake)`

```javascript
const earthquake = {
  lat: 41.0082,      // Deprem enlemi
  lon: 28.9784,      // Deprem boylamı
  magnitude: 5.2,    // Deprem büyüklüğü
  location: 'İstanbul',
  depth: 10,         // km
  time: new Date()
};

await priorityNotificationService.sendPriorityEarthquakeNotifications(earthquake);
```

**Çalışma Prensibi:**

1. **Kullanıcıları Al:**
   ```javascript
   const users = await User.find({
     location: { $exists: true },
     'location.coordinates': { $exists: true, $ne: null }
   });
   ```

2. **Mesafe Hesapla (Haversine):**
   ```javascript
   const distance = calculateDistance(
     earthquake.lat, earthquake.lon,
     user.location.coordinates[1], // userLat
     user.location.coordinates[0]  // userLon
   );
   ```

3. **Sırala (Yakından Uzağa):**
   ```javascript
   usersWithDistance.sort((a, b) => a.distance - b.distance);
   ```

4. **Filtrele ve Gönder:**
   ```javascript
   for (const item of usersWithDistance) {
     const notificationRadius = user.notificationSettings?.notificationRadius || 100;
     
     if (distance > notificationRadius) {
       console.log('⏭️  Kullanıcı range dışında, atlandı');
       continue;
     }
     
     // Bildirim gönder
     await notificationService.sendToUser(user.uid, notificationData);
   }
   ```

**Çıktı:**
```javascript
{
  success: true,
  earthquake: { magnitude: 5.2, location: 'İstanbul' },
  stats: {
    totalUsers: 150,
    sent: 45,      // Bildirim gönderilen
    skipped: 102,  // Range dışında
    errors: 3      // Hata
  },
  closestUsers: [
    { name: 'Ali', distance: '2.5 km' },
    { name: 'Ayşe', distance: '5.1 km' },
    // En yakın 10 kullanıcı
  ]
}
```

---

### 2. API Endpoints

#### POST `/api/users/update-location`

Kullanıcı konumunu günceller.

**Headers:**
```
x-firebase-uid: <firebase-user-id>
```

**Body:**
```json
{
  "latitude": 41.0308,
  "longitude": 28.5742,
  "address": "İstanbul Büyükçekmece"
}
```

**Response:**
```json
{
  "success": true,
  "location": {
    "latitude": 41.0308,
    "longitude": 28.5742,
    "address": "İstanbul Büyükçekmece",
    "lastUpdate": "2025-11-11T10:30:00.000Z"
  }
}
```

**Kullanım:**
- **2 saatte bir** otomatik (LocationUpdateService)
- **Uygulama açılışında** (eğer 2+ saat geçmişse)

---

#### POST `/api/users/notification-settings`

Kullanıcının bildirim ayarlarını günceller.

**Headers:**
```
x-firebase-uid: <firebase-user-id>
```

**Body:**
```json
{
  "notificationRadius": 200,
  "minMagnitude": 3.0,
  "maxMagnitude": 8.0
}
```

**Response:**
```json
{
  "success": true,
  "settings": {
    "notificationRadius": 200,
    "minMagnitude": 3.0,
    "maxMagnitude": 8.0
  }
}
```

**Kullanım:**
- Ayarlar ekranında slider değiştiğinde otomatik gönderilir
- Uygulama açılışında senkronize edilir

---

#### POST `/api/test/priority-notification`

Test amaçlı öncelikli bildirim gönder.

**Body:**
```json
{
  "lat": 41.0082,
  "lon": 28.9784,
  "magnitude": 5.2,
  "location": "İstanbul - Kadıköy",
  "depth": 10
}
```

**Response:**
```json
{
  "success": true,
  "earthquake": {
    "magnitude": 5.2,
    "location": "İstanbul - Kadıköy",
    "coordinates": [41.0082, 28.9784]
  },
  "stats": {
    "totalUsers": 150,
    "sent": 45,
    "skipped": 102,
    "errors": 3
  },
  "closestUsers": [...]
}
```

---

## Frontend Özellikleri

### 1. LocationUpdateService

**Dosya:** `lib/services/location_update_service.dart`

#### Otomatik Konum Güncelleme

```dart
final locationUpdateService = LocationUpdateService();

// Periyodik güncellemeleri başlat (2 saatte bir)
await locationUpdateService.startPeriodicUpdates();

// Uygulama açılışında konum gönder
await locationUpdateService.sendLocationOnAppStart();
```

**Özellikler:**
- ✅ 2 saatte bir otomatik konum gönderimi
- ✅ Uygulama açılışında akıllı kontrol (son 2 saat kontrolü)
- ✅ İzin yönetimi (location permissions)
- ✅ Hata yönetimi ve log'lama

#### Bildirim Ayarlarını Senkronize Et

```dart
await locationUpdateService.sendNotificationSettings(
  notificationRadius: 200,
  minMagnitude: 3.0,
  maxMagnitude: 8.0,
);
```

**Kullanım:**
- `main.dart` → Uygulama açılışında
- `settings_screen.dart` → Slider değiştiğinde

---

### 2. Ayarlar Ekranı Entegrasyonu

**Dosya:** `lib/screens/settings_screen.dart`

Slider'larda değişiklik yapıldığında ayarlar **otomatik olarak sunucuya senkronize edilir:**

```dart
onChanged: (value) async {
  await _prefsService.setNotificationRadius(value);
  setState(() => _notificationRadius = value);
  
  // Sunucuya gönder
  await _syncSettingsToServer();
}
```

---

## Veritabanı Şeması

### User Model

```javascript
{
  uid: 'firebase-user-id',
  displayName: 'Ali Yılmaz',
  email: 'ali@example.com',
  
  // Konum (GeoJSON Point)
  location: {
    type: 'Point',
    coordinates: [28.5742, 41.0308], // [longitude, latitude]
    address: 'İstanbul Büyükçekmece',
    lastUpdate: Date('2025-11-11T10:30:00Z')
  },
  
  // Bildirim Ayarları
  notificationSettings: {
    notificationRadius: 200,    // km
    minMagnitude: 3.0,
    maxMagnitude: 8.0
  },
  
  // Device Tokens (FCM için)
  deviceTokens: [
    {
      token: 'fcm-device-token-123',
      platform: 'android',
      addedAt: Date('2025-11-10T08:00:00Z')
    }
  ]
}
```

**Index:**
```javascript
location.coordinates: '2dsphere' // Geospatial index for location queries
```

---

## Test Senaryoları

### Senaryo 1: Yakın Deprem

**Test Verileri:**
```
Deprem: M5.2 - İstanbul Kadıköy (41.0082, 28.9784)

Kullanıcılar:
- Ali: İstanbul Kadıköy (3 km uzaklık, radius=100 km)  → ✅ Bildirim AL
- Ayşe: İstanbul Üsküdar (8 km uzaklık, radius=50 km) → ✅ Bildirim AL
- Mehmet: Ankara (350 km uzaklık, radius=100 km)      → ❌ Range dışı
- Fatma: İzmir (450 km uzaklık, radius=200 km)        → ❌ Range dışı
```

**Test Komutu:**
```bash
curl -X POST http://localhost:3000/api/test/priority-notification \
  -H "Content-Type: application/json" \
  -d '{
    "lat": 41.0082,
    "lon": 28.9784,
    "magnitude": 5.2,
    "location": "İstanbul - Kadıköy",
    "depth": 10
  }'
```

**Beklenen Çıktı:**
```
📊 Mesafe sıralaması:
  1. Ali: 3.00 km
  2. Ayşe: 8.00 km
  3. Mehmet: 350.00 km
  4. Fatma: 450.00 km

✅ Ali: 3.0km (bildirim gönderildi)
✅ Ayşe: 8.0km (bildirim gönderildi)
⏭️  Mehmet: 350.00 km > 100 km (range dışı, atlandı)
⏭️  Fatma: 450.00 km > 200 km (range dışı, atlandı)

📈 Bildirim Özeti:
  ✅ Gönderilen: 2
  ⏭️  Atlanan: 2
  ❌ Hata: 0
  📊 Toplam: 4 kullanıcı
```

---

### Senaryo 2: Çok Uzak Deprem

**Test Verileri:**
```
Deprem: M6.5 - Çin (39.9075, 116.3972)

Tüm Türkiye kullanıcıları:
- En yakın kullanıcı bile ~5000 km uzaklıkta
- Maksimum radius ayarı: 1000 km

Sonuç: Hiçbir kullanıcıya bildirim gönderilmez
```

---

## Performans Optimizasyonları

### 1. Rate Limiting
```javascript
// Her bildirim arasında 100ms gecikme
await this.delay(100);
```

### 2. Geospatial Index
```javascript
// MongoDB 2dsphere index
location.coordinates: '2dsphere'

// Hızlı mesafe sorguları için
User.find({
  location: {
    $near: {
      $geometry: { type: 'Point', coordinates: [lon, lat] },
      $maxDistance: 100000 // 100 km (metre cinsinden)
    }
  }
});
```

### 3. Batch Processing
- Tüm kullanıcılar bir kerede alınır
- Mesafe hesaplamaları memory'de yapılır
- Sıralama ve filtreleme memory'de

---

## Güvenlik

### 1. Authentication
```javascript
// Her request'te Firebase UID kontrolü
const uid = req.headers['x-firebase-uid'];
if (!uid) {
  return res.status(401).json({ error: 'Firebase UID gerekli' });
}
```

### 2. Validation
```javascript
// Koordinat validasyonu
if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
  return res.status(400).json({ error: 'Geçersiz koordinatlar' });
}
```

### 3. Rate Limiting
- Bildirim gönderimi arasında gecikme
- Konum güncelleme: 2 saatte bir (abuse prevention)

---

## Monitoring ve Log'lama

### Server Logs

```
🚨 Öncelikli bildirim sistemi başlatıldı
📍 Deprem: M5.2 - İstanbul
📍 Koordinatlar: 41.0082, 28.9784
👥 150 kullanıcı bulundu

📊 Mesafe sıralaması:
  1. Ali: 3.00 km
  2. Ayşe: 8.00 km
  ...

✅ Ali: 3.0km (bildirim gönderildi)
✅ Ayşe: 8.0km (bildirim gönderildi)
⏭️  Mehmet: 350.00 km > 100 km (range dışı, atlandı)

📈 Bildirim Özeti:
  ✅ Gönderilen: 45
  ⏭️  Atlanan: 102
  ❌ Hata: 3
  📊 Toplam: 150 kullanıcı
```

### Flutter Logs

```
✅ Location update service started
📍 Konum alındı: 41.0308, 28.5742
✅ Konum sunucuya gönderildi
✅ Bildirim ayarları sunucuya senkronize edildi
   Yarıçap: 200 km
   Büyüklük: 3.0-8.0
```

---

## Sorun Giderme

### Kullanıcıya bildirim gelmiyor

**Kontrol Listesi:**
1. ✅ Kullanıcının konumu sunucuda kayıtlı mı?
   ```bash
   # MongoDB'de kontrol et
   db.users.findOne({ uid: 'user-id' })
   ```

2. ✅ Kullanıcının notificationRadius ayarı deprem mesafesini kapsıyor mu?
   ```javascript
   // Örnek: Deprem 150 km uzakta, radius=100 km → Bildirim GİTMEZ
   ```

3. ✅ Device token kayıtlı mı?
   ```javascript
   user.deviceTokens // Boş olmamalı
   ```

4. ✅ FCM servisi çalışıyor mu?

### Konum güncellenmiyor

**Kontrol Listesi:**
1. ✅ Konum izni verilmiş mi?
2. ✅ Firebase Auth aktif mi?
3. ✅ Server URL doğru mu? (`LocationUpdateService.baseUrl`)
4. ✅ Network bağlantısı var mı?

---

## Sonuç

✅ **Yakın kullanıcılar öncelikli bildirim alır**  
✅ **Range kontrolü ile gereksiz bildirimler engellenir**  
✅ **Otomatik konum senkronizasyonu (2 saatte bir)**  
✅ **Ayarlar değiştiğinde otomatik server senkronizasyonu**  
✅ **Performanslı ve ölçeklenebilir mimari**

Sistem tam otomatik çalışır, manuel müdahale gerekmez! 🚀
