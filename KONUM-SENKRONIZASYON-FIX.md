# Konum Senkronizasyon Sorunu - Düzeltme

## 🐛 SORUN

**Belirtiler:**
1. ✅ Harita ekranı: İstanbul'daki depremleri doğru gösteriyor (50km range)
2. ❌ Geçmiş ekranı: Ankara'daki depremleri gösteriyor (Türkiye merkezi 39.0, 35.0 kullanıyor)
3. ❌ İki ekran farklı konumlar kullanıyor

**Kök Neden:**
- Map ekranı: Gerçek GPS konumunu kullanıyor (40.96, 29.22 - İstanbul)
- History ekranı: SharedPreferences'tan konum okumaya çalışıyor ama **orada konum yok**
- SharedPreferences'ta konum olmayınca varsayılan değer: **Türkiye merkezi (39.0, 35.0 - Ankara)**
- LocationUpdateService konumu sunucuya gönderiyor ama **SharedPreferences'a kaydetmiyor**

---

## ✅ ÇÖZÜM

### 1. LocationUpdateService - SharedPreferences'a Kayıt Ekle

**Dosya**: `lib/services/location_update_service.dart`

```dart
// Konum sunucuya gönderildikten sonra SharedPreferences'a da kaydet
if (response.statusCode == 200) {
  final data = jsonDecode(response.body);
  print('✅ Konum sunucuya gönderildi: ${data['location']['latitude']}, ${data['location']['longitude']}');
  
  await _saveLastUpdateTime();
  
  // 🆕 YENİ: SharedPreferences'a kaydet
  await _saveLocationToPrefs(locationData.latitude!, locationData.longitude!);
  
  return true;
}

// Yeni metod
Future<void> _saveLocationToPrefs(double latitude, double longitude) async {
  final prefs = await SharedPreferences.getInstance();
  await prefs.setDouble('lastLatitude', latitude);
  await prefs.setDouble('lastLongitude', longitude);
  print('💾 Konum SharedPreferences\'a kaydedildi: $latitude, $longitude');
}
```

**Sonuç**: Her 2 saatte bir konum güncellendiğinde SharedPreferences'a da yazılacak.

---

### 2. History Ekranı - Gerçek GPS Kullan

**Dosya**: `lib/screens/history.dart`

**ÖNCEKİ KOD** (Yanlış):
```dart
Future<void> _getUserLocation() async {
  // SharedPreferences'tan oku
  final prefs = await _prefsService.getAllSettings();
  if (prefs.containsKey('lastLatitude')) {
    _userLat = prefs['lastLatitude'];
    _userLon = prefs['lastLongitude'];
  } else {
    // ❌ SORUN: Türkiye merkezi kullanılıyor!
    _userLat = 39.0;  // Ankara
    _userLon = 35.0;
  }
}
```

**YENİ KOD** (Doğru):
```dart
import 'package:location/location.dart';

Future<void> _getUserLocation() async {
  try {
    print('📍 History - Gerçek GPS konumu alınıyor...');
    
    final location = Location();
    
    // Konum servisini kontrol et
    bool serviceEnabled = await location.serviceEnabled();
    if (!serviceEnabled) {
      await _loadCachedLocation(); // Cache'e düş
      return;
    }
    
    // İzin kontrol et
    PermissionStatus permission = await location.hasPermission();
    if (permission != PermissionStatus.granted) {
      await _loadCachedLocation(); // Cache'e düş
      return;
    }
    
    // ✅ Gerçek GPS konumu al (Map ile aynı)
    final locationData = await location.getLocation();
    
    if (locationData.latitude != null && locationData.longitude != null) {
      setState(() {
        _userLat = locationData.latitude;
        _userLon = locationData.longitude;
      });
      
      // Cache'e de kaydet
      final prefs = await SharedPreferences.getInstance();
      await prefs.setDouble('lastLatitude', _userLat!);
      await prefs.setDouble('lastLongitude', _userLon!);
      
      print('✅ History - GPS konumu: $_userLat, $_userLon');
    }
  } catch (e) {
    await _loadCachedLocation();
  }
}

// Fallback: Cache'den yükle
Future<void> _loadCachedLocation() async {
  final prefs = await SharedPreferences.getInstance();
  final lat = prefs.getDouble('lastLatitude');
  final lon = prefs.getDouble('lastLongitude');
  
  if (lat != null && lon != null) {
    setState(() {
      _userLat = lat;
      _userLon = lon;
    });
    print('📦 History - Cache\'den: $_userLat, $_userLon');
  } else {
    // ✅ Varsayılan: İstanbul merkezi (Ankara DEĞİL!)
    setState(() {
      _userLat = 41.0082;
      _userLon = 28.9784;
    });
    print('⚠️ History - Varsayılan: İstanbul');
  }
}
```

**Farklar:**
1. ✅ SharedPreferences'tan değil, **gerçek GPS'ten** konum alıyor
2. ✅ GPS başarısızsa cache'e düşüyor
3. ✅ Varsayılan değer **İstanbul** (Ankara değil)
4. ✅ Map ekranı ile **aynı mantık**

---

### 3. Map Ekranı - SharedPreferences'a Kaydet

**Dosya**: `lib/screens/map_screen.dart`

```dart
Future<void> _getUserLocation() async {
  // ... GPS konumu al ...
  
  if (locationData.latitude != null && locationData.longitude != null) {
    setState(() {
      _userLocation = LatLng(locationData.latitude!, locationData.longitude!);
      _locationLoading = false;
    });

    // 🆕 YENİ: SharedPreferences'a kaydet
    final prefs = await SharedPreferences.getInstance();
    await prefs.setDouble('lastLatitude', locationData.latitude!);
    await prefs.setDouble('lastLongitude', locationData.longitude!);

    print('✅ Konum alındı ve kaydedildi: ${locationData.latitude}, ${locationData.longitude}');
  }
}
```

**Sonuç**: Map ekranı açılınca konum hem kullanılıyor hem kaydediliyor.

---

## 🎯 TEST SENARYOSU

### Senaryo 1: İlk Kullanım (Cache Boş)

```
1. Uygulama ilk kez açılıyor
2. Map ekranı: GPS'ten konum alıyor → İstanbul (40.96, 29.22)
   ✅ SharedPreferences'a kayıt: 40.96, 29.22
   ✅ 50km içindeki depremleri göster
   
3. History ekranına geç
   ✅ GPS'ten konum alıyor → İstanbul (40.96, 29.22)
   ✅ SharedPreferences'a kayıt: 40.96, 29.22
   ✅ 50km içindeki depremleri göster
   
SONUÇ: ✅ İki ekran da İstanbul'daki depremleri gösteriyor
```

### Senaryo 2: GPS Kapalı / İzin Yok (Cache Kullanımı)

```
1. GPS kapalı veya izin yok
2. History ekranı açılıyor
   ⚠️ GPS başarısız
   ✅ Cache'den oku: 40.96, 29.22 (map'in kaydettiği)
   ✅ 50km içindeki depremleri göster
   
SONUÇ: ✅ Cache sayesinde doğru konum kullanılıyor
```

### Senaryo 3: Konum Değişikliği

```
1. Kullanıcı İstanbul'dan Ankara'ya gidiyor
2. Map ekranı açılıyor
   ✅ GPS'ten yeni konum: Ankara (39.93, 32.85)
   ✅ SharedPreferences güncelle: 39.93, 32.85
   ✅ Ankara'daki depremleri göster
   
3. History ekranına geç
   ✅ GPS'ten konum: Ankara (39.93, 32.85)
   ✅ SharedPreferences güncelle: 39.93, 32.85
   ✅ Ankara'daki depremleri göster
   
SONUÇ: ✅ Her iki ekran da güncel konumu kullanıyor
```

### Senaryo 4: Periyodik Güncelleme (2 Saat)

```
1. Arka planda LocationUpdateService çalışıyor
2. 2 saat sonra:
   ✅ GPS'ten konum al: 40.96, 29.22
   ✅ Sunucuya gönder: POST /api/users/update-location
   ✅ SharedPreferences'a kaydet: 40.96, 29.22
   
3. Uygulama açılınca History ekranı:
   ✅ Cache'den oku: 40.96, 29.22 (güncel)
   ✅ Doğru depremleri göster
   
SONUÇ: ✅ Arka plan güncellemesi de cache'i güncel tutuyor
```

---

## 📊 BEKLENEN LOG ÇIKTILARI

### Map Ekranı:
```
📍 Kullanıcı konumu alınıyor...
✅ Kullanıcı konumu alındı ve kaydedildi: 40.9594, 29.2197

🗺️ Map - Deprem verisi yükleniyor...
   Kullanıcı konumu: 40.9594, 29.2197
   Range: 50.0 km
   Magnitude: 2.5 - 10.0
   API'den 100 deprem çekildi
   Magnitude/zaman filtresinden sonra: 95 deprem
   
🗺️ Map Rendering: 95 toplam → 17 range içinde (GÖSTER)
✅ Map - 17 deprem yüklendi
```

### History Ekranı:
```
📍 History - Gerçek GPS konumu alınıyor...
✅ History - GERÇEK GPS konumu alındı: 40.9594, 29.2197

📊 History - Filtreleme başlıyor:
   Toplam deprem: 100
   Kullanıcı konumu: 40.9594, 29.2197
   Range: 50.0 km
   Magnitude: 2.5 - 10.0
   ✅ Geçti: Marmara Denizi - 15.2 km (M3.2)
   ✅ Geçti: İstanbul Silivri - 25.8 km (M2.8)
   ✅ Geçti: Bursa Gemlik - 48.3 km (M2.9)
   ❌ Uzak: Kahramanmaraş - 785.3 km (>50.0 km)
   ❌ Uzak: Ankara - 285.5 km (>50.0 km)
   
📈 History - Filtreleme sonucu:
   Magnitude filtresi: 5 elendi
   Mesafe filtresi: 78 elendi
   Geçenler: 17
   Gösterilecek: 17
```

**Önemli Noktalar:**
- ✅ Her iki ekran da **aynı konumu** kullanıyor: 40.9594, 29.2197
- ✅ Her iki ekran da **aynı range'i** kullanıyor: 50.0 km
- ✅ Her iki ekran da **aynı deprem sayısını** gösteriyor: 17
- ❌ Ankara depremi artık **görünmüyor** (285.5 km uzakta)

---

## 🔧 HATA AYIKLAMA

### Sorun: History hala Ankara depremlerini gösteriyor

**Kontrol Adımları:**

1. **Cache'i Temizle:**
```dart
// Uygulamayı kapat, cache'i temizle, tekrar aç
final prefs = await SharedPreferences.getInstance();
await prefs.remove('lastLatitude');
await prefs.remove('lastLongitude');
```

2. **Log'ları Kontrol Et:**
```
History - GPS konumu alındı: X.XX, Y.YY
  ↑ Bu değerler İstanbul'u göstermiyorsa GPS sorunu var
```

3. **GPS İzni Var mı?**
```
Ayarlar → Deprem Uygulaması → İzinler → Konum: AÇIK
```

4. **Location Service Çalışıyor mu?**
```
Telefon Ayarları → Konum → AÇIK
```

### Sorun: İki ekran farklı deprem sayısı gösteriyor

**Sebep**: Olabilir - Map'te **zaman filtresi** var (24 saat), History'de yok

**Map:**
```dart
// 24 saat (1440 dakika) kontrolü
return minutesAgo <= 1440;
```

**History:**
```dart
// Zaman kontrolü YOK, sadece magnitude ve mesafe
```

**Normal**: Map daha az deprem gösterebilir (eski olanlar eleniyor).

---

## 📝 ÖZET

**Değişiklikler:**
1. ✅ `LocationUpdateService`: SharedPreferences'a kayıt ekle
2. ✅ `history.dart`: GPS'ten konum al (cache değil)
3. ✅ `map_screen.dart`: SharedPreferences'a kayıt ekle
4. ✅ Varsayılan konum: İstanbul (Ankara değil)

**Sonuç:**
- ✅ Map ve History **aynı konumu** kullanıyor
- ✅ Her iki ekran da **gerçek GPS** verisi kullanıyor
- ✅ GPS başarısızsa **cache** devreye giriyor
- ✅ Cache her zaman **güncel** tutuluyor

**Test:**
```bash
flutter run
# Map ekranını aç → Log'lara bak
# History ekranını aç → Log'ları karşılaştır
# İki ekran da aynı koordinatları göstermeli!
```

---

**Tarih**: 15 Kasım 2025  
**Durum**: ✅ Çözüldü  
**Test**: Bekliyor
