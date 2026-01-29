# Farklı Kaynaklar İçin Akıllı Duplicate Kontrol Sistemi

## 📊 Problem

Farklı deprem kaynakları aynı depremi **farklı ölçüyor**:

### Örnek Senaryo: Aynı Deprem, 3 Farklı Kaynak

| Kaynak    | Konum           | Magnitude | Fark                    |
|-----------|-----------------|-----------|-------------------------|
| **AFAD**  | 38.45°N, 27.23°E| M 5.0     | Referans                |
| **Kandilli** | 38.47°N, 27.21°E | M 5.3  | +0.02° lat, -0.02° lon, +0.3M |
| **USGS**  | 38.43°N, 27.25°E| M 4.8     | -0.02° lat, +0.02° lon, -0.2M |

**Sorun:** Eski sistem bu 3 depremi **AYRI** deprem sanıyordu → **3 bildirim** gönderiyordu! ❌

---

## ✅ Çözüm: Adaptive Earthquake Matching

### 1️⃣ **Esnek ID Oluşturma**

#### ❌ ESKİ (Çok Hassas):
```javascript
generateEarthquakeId(earthquake) {
  const lat = earthquake.lat.toFixed(2);  // 38.45
  const lon = earthquake.lon.toFixed(2);  // 27.23
  const mag = earthquake.magnitude.toFixed(1); // 5.0
  // → ID: "38.45_27.23_5.0_12345"
}
```

**Sonuç:** 38.45 ≠ 38.47 → Farklı ID → Duplicate tespit edilemedi! ❌

#### ✅ YENİ (Esnek):
```javascript
generateEarthquakeId(earthquake) {
  // Konum: 0.1° hassasiyet (~11 km tolerans)
  const lat = earthquake.lat.toFixed(1);  // 38.5
  const lon = earthquake.lon.toFixed(1);  // 27.2
  // Magnitude: 0.5 bloklar (M5.0-5.4 = 5.0, M5.5-5.9 = 5.5)
  const mag = Math.floor(earthquake.magnitude * 2) / 2; // 5.0
  // → ID: "38.5_27.2_5.0_12345"
}
```

**Sonuç:** 
- AFAD: 38.45 → **38.5** ✅
- Kandilli: 38.47 → **38.5** ✅  
- USGS: 38.43 → **38.4** (biraz farklı ama fine-grained match yapacak)

---

### 2️⃣ **İki Katmanlı Duplicate Kontrol**

#### A) Coarse-Grained Match (Kaba Eşleşme)
```javascript
if (lastNotif.earthquakeId === earthquakeId) {
  // Aynı ID → Kesinlikle aynı deprem
  console.log('🔁 Duplicate - ATLANDI');
  continue;
}
```

**Eşleşme Toleransları:**
- Konum: ±0.05° (~5.5 km)
- Magnitude: ±0.25
- Zaman: 10 dakika

#### B) Fine-Grained Match (Detaylı Eşleşme)
```javascript
if (timeSinceLastNotif < 15 * 60 * 1000) {
  const magDiff = Math.abs(lastNotif.magnitude - earthquake.magnitude);
  const approxDistance = calculateDistance(lastNotif, earthquake);
  
  // Daha geniş toleranslar (farklı kaynaklar için)
  if (magDiff <= 0.6 && approxDistance <= 35) {
    console.log('🔁 Benzer deprem - ATLANDI');
    continue;
  }
}
```

**Eşleşme Toleransları:**
- Konum: ~35 km (0.3°)
- Magnitude: ±0.6
- Zaman: 15 dakika

---

### 3️⃣ **Kaynak Güvenilirlik Önceliği**

Farklı kaynakların doğruluk seviyeleri:

```javascript
getSourcePriority(source) {
  return {
    'Kandilli': 1,  // ⭐ En güvenilir (Türkiye için)
    'AFAD': 2,      // ⭐ Resmi kaynak
    'USGS': 3,      // ⭐ Global güvenilir
    'EMSC': 4,      // Avrupa-Akdeniz
    'P2P': 5        // P2P algılama
  }[source];
}
```

**Kullanım:**
```javascript
// Eğer aynı deprem birden fazla kaynaktan gelirse
// En güvenilir kaynağın verisini kullan
selectBetterEarthquakeData(afadData, kandilliData);
// → Kandilli seçilir (öncelik: 1 < 2)
```

---

## 🎯 Sonuç: Karşılaştırma

### Senaryo: M5.0 Deprem, 3 Farklı Kaynak

#### ❌ ESKİ SİSTEM:
```
10:00:00 - AFAD: M5.0, 38.45°N, 27.23°E
   → Bildirim gönderildi ✅

10:01:00 - Kandilli: M5.3, 38.47°N, 27.21°E
   → ID farklı (38.45 ≠ 38.47)
   → Bildirim gönderildi ✅ (YANLIŞ!)

10:02:00 - USGS: M4.8, 38.43°N, 27.25°E
   → ID farklı
   → Bildirim gönderildi ✅ (YANLIŞ!)

TOPLAM: 3 BİLDİRİM ❌
```

#### ✅ YENİ SİSTEM:
```
10:00:00 - AFAD: M5.0, 38.45°N, 27.23°E
   → ID: "38.5_27.2_5.0_12345"
   → Bildirim gönderildi ✅

10:01:00 - Kandilli: M5.3, 38.47°N, 27.21°E
   → ID: "38.5_27.2_5.0_12345" (AYNI!)
   → 🔁 Duplicate - ATLANDI ✅

10:02:00 - USGS: M4.8, 38.43°N, 27.25°E
   → ID: "38.4_27.2_5.0_12345" (Biraz farklı)
   → Fine-grained kontrol:
      - ΔM = 0.2 (< 0.6 ✓)
      - ΔD = 2.2 km (< 35 km ✓)
      - Δt = 120s (< 15 dak ✓)
   → 🔁 Benzer deprem - ATLANDI ✅

TOPLAM: 1 BİLDİRİM ✅
```

---

## 📈 Avantajlar

### 1. Kullanıcı Deneyimi
- ✅ **Spam yok** - Aynı deprem için tek bildirim
- ✅ **Doğru bilgi** - En güvenilir kaynaktan veri

### 2. Sunucu Performansı
- ✅ **FCM quota azalır** - Gereksiz bildirim yok
- ✅ **Database yükü azalır** - Daha az kayıt
- ✅ **Log okunabilirliği** - Duplicate işaretli

### 3. Akıllı Toleranslar

| Parametre | Değer | Açıklama |
|-----------|-------|----------|
| **Konum (ID)** | ±5.5 km | 0.1° hassasiyet |
| **Konum (Fine)** | ±35 km | 0.3° tolerans |
| **Magnitude (ID)** | ±0.25 | 0.5 bloklar |
| **Magnitude (Fine)** | ±0.6 | Kaynak farkları için |
| **Zaman (ID)** | 10 dak | Bloklar |
| **Zaman (Fine)** | 15 dak | Fine-grained window |

---

## 🧪 Test Senaryoları

### Test 1: Aynı Deprem, Farklı Kaynaklar
```bash
# AFAD
curl -X POST http://localhost:5000/api/test/earthquake \
  -H "Content-Type: application/json" \
  -d '{"latitude":38.45,"longitude":27.23,"magnitude":5.0,"source":"AFAD"}'

# Kandilli (2 dakika sonra, biraz farklı)
curl -X POST http://localhost:5000/api/test/earthquake \
  -H "Content-Type: application/json" \
  -d '{"latitude":38.47,"longitude":27.21,"magnitude":5.3,"source":"Kandilli"}'

# Beklenen: 1 bildirim (ikincisi atlanmalı)
```

### Test 2: Farklı Depremler
```bash
# İlk deprem
curl -X POST http://localhost:5000/api/test/earthquake \
  -H "Content-Type: application/json" \
  -d '{"latitude":38.45,"longitude":27.23,"magnitude":5.0}'

# Farklı konum (100 km uzakta)
curl -X POST http://localhost:5000/api/test/earthquake \
  -H "Content-Type: application/json" \
  -d '{"latitude":39.45,"longitude":27.23,"magnitude":5.0}'

# Beklenen: 2 bildirim (farklı depremler)
```

---

## 📝 Log Örnekleri

### Başarılı Duplicate Tespiti:
```
🚨 Öncelikli bildirim sistemi başlatıldı
📍 Deprem: M5.3 - Akhisar-Manisa
📍 Koordinatlar: 38.47, 27.21
📡 Kaynak: Kandilli
🆔 Deprem ID: 38.5_27.2_5.0_12345 (0.1° konum + 0.5M tolerans)

👤 Kullanıcı1:
   🔁 Duplicate deprem (ID: 38.5_27.2_5.0_12345) - ATLANDI

👤 Kullanıcı2:
   🔁 Benzer deprem (120s önce, ΔM=0.3, ΔD=2.2km) - ATLANDI
```

---

## 🔧 Yapılandırma

### Toleransları Değiştirme

`services/priorityNotificationService.js`:
```javascript
// Konum toleransı (derece)
const LOCATION_TOLERANCE = 0.3; // ~33 km

// Magnitude toleransı
const MAGNITUDE_TOLERANCE = 0.6;

// Zaman penceresi (ms)
const TIME_WINDOW = 15 * 60 * 1000; // 15 dakika
```

---

## 📅 Değişiklik Tarihi
- **2026-01-29**: Adaptive Earthquake Matching sistemi eklendi
- Konum hassasiyeti: 0.01° → 0.1° (~11 km tolerans)
- Magnitude toleransı: ±0.1 → ±0.6
- Zaman penceresi: 5 dak → 15 dak
- Kaynak öncelik sistemi eklendi

## 📚 İlgili Dosyalar
- `services/priorityNotificationService.js`
- `services/earthquakeMonitor.js`
- `models/User.js`
