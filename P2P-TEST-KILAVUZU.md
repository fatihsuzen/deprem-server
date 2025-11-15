# P2P Deprem Algılama Sistemi Test Kılavuzu

## 📋 GENEL BAKIŞ

Bu test suite, P2P deprem algılama sisteminin 3 ana bileşenini test eder:
1. **Telefon → Server**: Sensör verisi gönderme
2. **Server Analiz**: P2P algoritması çalışması
3. **Server → Kullanıcılar**: Bildirim dağıtımı

---

## 🚀 HIZLI BAŞLANGIÇ

### Backend Test (Node.js)

```bash
cd "c:\Users\Fatih\Desktop\Deprem App2"
node test-p2p-system.js
```

**Menü Seçenekleri:**
- `1` - Tek Rapor (Tetiklenmemeli)
- `2` - 3 Rapor (Hala Tetiklenmemeli)
- `3` - **8 Rapor - 🚨 DEPREM TETİKLE!**
- `4` - False Positive Test
- `5` - Zaman Korelasyonu Test
- `6` - **TÜM TESTLERİ ÇALIŞTIR**
- `7` - Sistem İstatistikleri
- `8` - Çıkış

### Flutter Test (Mobil Uygulama)

1. Ayarlar ekranına git
2. "Geliştirici Araçları" bölümünü bul
3. "P2P Sistem Testi" tıkla
4. Test ekranı açılacak:
   - **Monitoring Başlat**: Sensörleri aktif et
   - **Test Raporu Gönder**: Sunucuya test verisi gönder
   - **Log Ekranı**: Tüm işlemleri takip et

---

## 🧪 TEST SENARYOLARI

### TEST 1: Tek Rapor (Tetiklenmemeli)
**Amaç**: Sistemin yanlışlıkla tek rapor ile deprem tetiklemediğini doğrula

**Beklenen Sonuç**:
```
✅ Rapor başarıyla gönderildi
   Bölge: İstanbul
   Toplam Rapor: 1
   Deprem Olasılığı: ~15-25%
   Deprem Tespit: ❌ HAYIR
```

**Kriter Kontrolleri**:
- ❌ Minimum rapor: 1 < 5 (BAŞARISIZ)
- ❌ Benzersiz kullanıcı: 1 < 3 (BAŞARISIZ)
- ❌ Olasılık: ~20% < 60% (BAŞARISIZ)

---

### TEST 2: 3 Rapor (Hala Tetiklenmemeli)
**Amaç**: Minimum eşik (5 rapor) altında deprem tetiklenmediğini doğrula

**Beklenen Sonuç**:
```
📤 [1/3] Ahmet - İstanbul Kadıköy rapor gönderiyor...
   ✅ Gönderildi - Bölgesel Rapor: 1
   📈 Olasılık: ~25%
   ⏳ Beklemede...

📤 [2/3] Mehmet - İstanbul Beşiktaş rapor gönderiyor...
   ✅ Gönderildi - Bölgesel Rapor: 2
   📈 Olasılık: ~35%
   ⏳ Beklemede...

📤 [3/3] Ayşe - İstanbul Üsküdar rapor gönderiyor...
   ✅ Gönderildi - Bölgesel Rapor: 3
   📈 Olasılık: ~45%
   ⏳ Beklemede...
```

**Kriter Kontrolleri**:
- ❌ Minimum rapor: 3 < 5 (BAŞARISIZ)
- ✅ Benzersiz kullanıcı: 3 >= 3 (BAŞARILI)
- ❌ Olasılık: ~45% < 60% (BAŞARISIZ)

---

### TEST 3: 8 Rapor - 🚨 DEPREM TETİKLENMELİ! 🚨
**Amaç**: Yeterli veri ile gerçek deprem tespiti

**Test Kullanıcıları** (İstanbul - 10km yarıçap):
1. Ahmet - Kadıköy (40.9880, 29.0256)
2. Mehmet - Beşiktaş (41.0428, 29.0080)
3. Ayşe - Üsküdar (41.0223, 29.0155)
4. Fatma - Bakırköy (40.9800, 28.8700)
5. Ali - Kartal (40.9014, 29.1925)
6. Zeynep - Şişli (41.0600, 28.9867)
7. Can - Maltepe (40.9296, 29.1410)
8. Elif - Beylikdüzü (41.0031, 28.6422)

**Simüle Edilen Deprem**:
- Büyüklük: 5.5 m/s² (ortalama)
- Süre: 3-5 saniye
- Olasılık Skoru: 60-90%
- Zaman Aralığı: 0-3 saniye (yüksek korelasyon)

**Beklenen Sonuç**:
```
🚨🚨🚨 DEPREM TESPİT EDİLDİ! 🚨🚨🚨

📍 Bölge: İstanbul
📊 Tahmini Büyüklük: M4.5-5.5
🎯 Merkez Üssü: 41.0123, 29.0045
👥 Toplam Rapor: 8
📈 Olasılık: 75-85%

Kriter Kontrolleri:
✅ Minimum rapor: 8 >= 5 (BAŞARILI)
✅ Benzersiz kullanıcı: 8 >= 3 (BAŞARILI)
✅ Olasılık: 80% >= 60% (BAŞARILI)
✅ Ortalama Büyüklük: 5.2 >= 3.0 (BAŞARILI)
✅ Zaman Korelasyonu: 100% >= 30% (BAŞARILI)
```

**Backend Otomatik İşlemler**:
1. ✅ Deprem database'e kaydedildi (P2P_timestamp_lat_lon)
2. ✅ Priority notification servisi tetiklendi
3. ✅ Tüm kullanıcılara push notification gönderildi
4. ✅ 5 dakika duplike önleme cache'i aktif

---

### TEST 4: False Positive Test
**Amaç**: Aynı kullanıcı tekrar rapor gönderirse skor düşürülsün

**Senaryo**:
1. Ahmet rapor gönder (skor: 75%)
2. 2 saniye bekle
3. Ahmet tekrar rapor gönder (aynı konum)

**Beklenen Sonuç**:
```
📤 Ahmet ilk rapor gönderiyor...
✅ Rapor kabul edildi - Olasılık: 75%

⏳ 2 saniye bekleniyor...

📤 Ahmet tekrar rapor gönderiyor (aynı konum)...
✅ Rapor kabul edildi (skor düşürüldü)
   Bölgesel Olasılık: 52.5%  (75% * 0.7)
   ⚠️ False positive filtresi çalıştı mı? EVET
```

**Algoritma**: Aynı kullanıcı 500m içinde tekrar rapor = Skor * 0.7

---

### TEST 5: Zaman Korelasyonu Test
**Amaç**: Gecikmeli raporlar düşük korelasyon = deprem tetiklenmemeli

**Senaryo**:
5 rapor, her biri 15 saniye aralıkla (toplam 60 saniye)

**Beklenen Sonuç**:
```
📤 [1/5] Ahmet rapor gönderiyor...
   Rapor: 1 | Olasılık: 25%
   ⏳ 15 saniye bekleniyor...

📤 [2/5] Mehmet rapor gönderiyor...
   Rapor: 2 | Olasılık: 30%
   ⏳ 15 saniye bekleniyor...

... (devam eder)

⚠️ Düşük zaman korelasyonu nedeniyle deprem tetiklenmemeli
```

**Zaman Korelasyon Skoru**:
- 0-5 saniye: 1.0 (100% - mükemmel)
- 5-10 saniye: 0.8 (80% - yüksek)
- 10-20 saniye: 0.5 (50% - orta)
- 20+ saniye: 0.2 (20% - düşük)

**Minimum Eşik**: 0.3 (30%) - TEST 5'te 0.2 olacak, **TETİKLENMEMELİ**

---

## 📊 SİSTEM İSTATİSTİKLERİ

```bash
node test-p2p-system.js
# Seçenek: 7
```

**Örnek Çıktı**:
```
📊 SİSTEM İSTATİSTİKLERİ:
   Aktif Raporlar (30sn): 12
   Tespit Edilen Depremler: 1

   Son Tespitler:
   1. İstanbul - M5.2
      Rapor: 8 | Olasılık: 82.3%
      Zaman: 14.11.2025 15:45:23
```

---

## 🎯 P2P ALGORİTMA KRİTERLERİ

### Tespit Kriterleri (HEPSİ SAĞLANMALI)

1. **Minimum Rapor Sayısı**: >= 5 rapor
   - Rationale: 5'ten az rapor güvenilir değil

2. **Minimum Benzersiz Kullanıcı**: >= 3 kullanıcı
   - Rationale: Tek kişi spam önleme

3. **Minimum Olasılık Skoru**: >= 60%
   - Rationale: %60 altı false positive riski yüksek

4. **Minimum Ortalama Büyüklük**: >= 3.0 m/s²
   - Rationale: 3 m/s² altı hissedilir deprem değil

5. **Zaman Korelasyonu**: >= 0.3 (30%)
   - Rationale: Raporlar eş zamanlı gelmeli

### Olasılık Hesaplama (0-100%)

**Formül Bileşenleri**:
- Rapor sayısı (0-30 puan):
  - 20+ rapor = 30
  - 10-19 rapor = 25
  - 5-9 rapor = 15
  - <5 rapor = (sayı/5) * 15

- Ortalama olasılık skoru (0-25 puan):
  - (avgProbabilityScore / 100) * 25

- Ortalama büyüklük (0-20 puan):
  - >= 5.0 m/s² = 20
  - >= 4.0 m/s² = 15
  - >= 3.0 m/s² = 10
  - < 3.0 m/s² = (mag/5.0) * 20

- Benzersiz kullanıcı (0-15 puan):
  - >= 10 kullanıcı = 15
  - >= 5 kullanıcı = 10
  - < 5 kullanıcı = (sayı/10) * 15

- Zaman korelasyonu (0-10 puan):
  - timeCorrelation * 10

**Örnek Hesaplama**:
```
Rapor: 8     → 15 puan
Olasılık: 75 → 18.75 puan
Büyüklük: 5.2 → 20 puan
Kullanıcı: 8  → 12 puan
Zaman: 1.0    → 10 puan
----------------------------
TOPLAM: 75.75%  ✅ (>= 60%)
```

---

## 🔧 SORUN GİDERME

### Backend Hatası: "Cannot connect to server"
```bash
# Server çalışıyor mu kontrol et
pm2 list

# Server loglarını incele
pm2 logs deprem-server

# Server restart
pm2 restart deprem-server
```

### Flutter Hatası: "Sensör izni yok"
1. Uygulama Ayarları → İzinler
2. "Fiziksel aktivite" izni ver (sensörler için)
3. Uygulamayı yeniden başlat

### Test Raporu Gönderilmiyor
- İnternet bağlantısını kontrol et
- Server URL'sini doğrula: `http://188.132.202.24:3000`
- Firewall/antivirus engeli var mı kontrol et

---

## 📱 FLUTTER TEST EKRANI KULLANIMI

### Özellikler

1. **Sistem İstatistikleri (Üst Panel)**
   - Aktif rapor sayısı (30 saniye içinde)
   - Tespit edilen deprem sayısı
   - Son tespitler listesi

2. **Kontrol Butonları**
   - `Monitoring Başlat`: Sensörleri aktif et (şarj veya ekran kapalı gerekli)
   - `Durdur`: Monitoring'i durdur
   - `Test Raporu Gönder`: Backend'e test verisi gönder

3. **Durum Göstergesi**
   - 🟢 Yeşil: Monitoring aktif
   - ⚪ Gri: Monitoring kapalı

4. **Log Ekranı (Siyah Alan)**
   - Tüm işlemlerin detaylı log'u
   - Zaman damgalı mesajlar
   - Temizle butonu ile log'ları sil

### Test Adımları

```
1. Settings → Geliştirici Araçları → P2P Sistem Testi

2. "Test Raporu Gönder" butonuna 1 kez bas
   → Log'da "✅ Rapor gönderildi" görmelisin
   → Sistem istatistikleri: "Aktif Raporlar: 1" olmalı

3. 5 saniye içinde 5-8 kez daha "Test Raporu Gönder" bas
   → Her basışta log'da yeni mesaj
   → 5+ rapor olunca: "🚨 DEPREM TESPİT!" uyarısı çıkmalı

4. Deprem uyarısı çıktıysa:
   → Kırmızı alert dialog açılır
   → Bölge, büyüklük, rapor sayısı görüntülenir
   → Sistem istatistikleri: "Tespit Edilen Depremler: 1" olmalı
```

---

## 🎓 SONUÇ DEĞERLENDİRME

### Başarılı Test Kriterleri

✅ **TEST 1**: Tek rapor deprem tetiklemedi
✅ **TEST 2**: 3 rapor deprem tetiklemedi
✅ **TEST 3**: 8 rapor deprem tetikledi (M4.5-5.5)
✅ **TEST 4**: False positive filtresi çalıştı (skor %30 düştü)
✅ **TEST 5**: Gecikmeli raporlar deprem tetiklemedi

### Beklenen Performans

- **Doğruluk Oranı**: >= 85% (gerçek depremleri yakala)
- **False Positive**: <= 5% (yanlış alarm)
- **Yanıt Süresi**: < 5 saniye (ilk rapordan tespite)
- **Database Kayıt**: %100 (tüm tespitler kaydedilmeli)
- **Bildirim Gönderimi**: >= 95% (kullanıcılara ulaşım)

---

## 📞 DESTEK

- Backend Logları: `pm2 logs deprem-server`
- Flutter Logları: Android Studio / VS Code Debug Console
- Test Dosyası: `test-p2p-system.js`
- Test Ekranı: `lib/screens/p2p_test_screen.dart`

**Hazırlayan**: GitHub Copilot  
**Tarih**: 14 Kasım 2025  
**Versiyon**: 1.0
