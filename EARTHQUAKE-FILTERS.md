# Deprem Filtreleme ve Bildirim Ayarları

## Özellikler

### 1. Deprem Büyüklüğü Filtresi
- **Minimum Büyüklük**: 0.0 - 9.0 arası (varsayılan: 2.5)
- **Maksimum Büyüklük**: 1.0 - 10.0 arası (varsayılan: 10.0)
- Haritada sadece bu aralıktaki depremler gösterilir

### 2. Bildirim Yarıçapı
- **Yarıçap**: 10 km - 1000 km arası (varsayılan: 100 km)
- Sadece bu yarıçap içindeki depremlerden bildirim alırsınız
- Kullanıcı konumundan otomatik mesafe hesaplanır (Haversine formülü)

## Kullanım

### Ayarlar Ekranı
1. Ana menüden **Ayarlar**'a gidin
2. **Deprem Filtreleme** bölümünde:
   - **Minimum Büyüklük**: Haritada gösterilecek en küçük deprem
   - **Maksimum Büyüklük**: Haritada gösterilecek en büyük deprem
   - **Bildirim Yarıçapı**: Bildirim alınacak maksimum mesafe

### Ayarların Etkisi

#### Harita Ekranı
```dart
// Örnek: Sadece 3.0-7.0 arası depremleri göster
Minimum: 3.0
Maksimum: 7.0

// Sonuç: 
// ✅ M3.5 deprem → Gösterilir
// ✅ M5.2 deprem → Gösterilir
// ❌ M2.8 deprem → Gösterilmez (minimum altı)
// ❌ M8.1 deprem → Gösterilmez (maksimum üstü)
```

#### Bildirimler
```dart
// Örnek: 200 km yarıçap ayarı
Kullanıcı konumu: İstanbul (41.03°N, 28.57°E)

// Deprem 1: İzmit M4.5 (100 km uzaklık)
// ✅ Bildirim gönderilir (200 km içinde)

// Deprem 2: Ankara M5.0 (350 km uzaklık)
// ❌ Bildirim gönderilmez (200 km dışında)

// Deprem 3: Çanakkale M3.8 (180 km uzaklık)
// ✅ Bildirim gönderilir (200 km içinde)
```

## Kod Entegrasyonu

### Bildirim Gönderirken
```dart
// NotificationService ile bildirim gönderme
await notificationService.showEarthquakeNotificationWithReport(
  title: 'Deprem Uyarısı!',
  body: 'M5.2 - İstanbul',
  magnitude: 5.2,
  location: 'İstanbul',
  depth: '10 km',
  earthquakeLat: 41.0082,   // Deprem konumu
  earthquakeLon: 28.9784,
  userLat: 41.0308,          // Kullanıcı konumu
  userLon: 28.5742,
);

// Servis otomatik olarak:
// 1. Kullanıcının bildirim yarıçapı ayarını alır
// 2. Mesafeyi hesaplar (Haversine)
// 3. Eğer yarıçap içindeyse bildirimi gönderir
// 4. Eğer yarıçap dışındaysa bildirimi atlar
```

### Harita Ekranında Filtreleme
```dart
// MapScreen otomatik olarak:
// 1. initState'te kullanıcı ayarlarını yükler
// 2. API'den depremleri çeker (minimum magnitude ile)
// 3. Maximum magnitude'a göre filtreler
// 4. Sadece filtrelenmiş depremleri gösterir

// Ayarlar değiştiğinde harita otomatik güncellenir
```

## Varsayılan Değerler

```dart
// UserPreferencesService
static const double defaultMinMagnitude = 2.5;
static const double defaultMaxMagnitude = 10.0;
static const double defaultNotificationRadius = 100.0; // km
```

## Ayarları Sıfırlama

Ayarlar ekranında sağ üst köşedeki **yenile** ikonuna basarak tüm ayarları varsayılan değerlere döndürebilirsiniz.

## Performans Notları

- Ayarlar `SharedPreferences` ile kaydedilir (kalıcı)
- Harita yükleme sırasında ayarlar otomatik uygulanır
- Bildirim kontrolü her deprem için sadece bir kez yapılır
- Mesafe hesaplaması Haversine formülü ile doğru sonuç verir

## Örnek Senaryolar

### Senaryo 1: Şehir İçi Kullanım
```
Minimum: 2.0
Maksimum: 8.0
Yarıçap: 50 km

→ Yakın çevredeki tüm depremleri göster
→ Sadece çok yakın depremlerden bildirim al
```

### Senaryo 2: Bölgesel İzleme
```
Minimum: 3.5
Maksimum: 10.0
Yarıçap: 300 km

→ Orta-büyük depremleri göster
→ Geniş bir bölgeden bildirim al
```

### Senaryo 3: Sadece Büyük Depremler
```
Minimum: 5.0
Maksimum: 10.0
Yarıçap: 1000 km

→ Sadece büyük depremleri göster
→ Ülke genelinde büyük depremlerden bildirim al
```

## Test

```dart
// Ayarları test etme
final prefs = UserPreferencesService();

// Ayarları değiştir
await prefs.setMinMagnitude(3.0);
await prefs.setMaxMagnitude(7.0);
await prefs.setNotificationRadius(200);

// Ayarları oku
final settings = await prefs.getAllSettings();
print(settings);
// Output: {
//   minMagnitude: 3.0,
//   maxMagnitude: 7.0,
//   notificationRadius: 200.0,
//   ...
// }
```

## Sorun Giderme

### Depremler gösterilmiyor
- Minimum/maksimum aralığını kontrol edin
- Ayarları varsayılana döndürün
- Log'da "✅ X deprem verisi yüklendi" mesajını kontrol edin

### Bildirim gelmiyor
- Bildirim yarıçapını artırın
- Uygulama bildirim izinlerini kontrol edin
- Log'da "✅ Deprem yarıçap içinde" mesajını kontrol edin

### Çok fazla bildirim geliyor
- Bildirim yarıçapını azaltın
- Minimum büyüklüğü artırın
