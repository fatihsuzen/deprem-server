# Android 14+ Foreground Service Hatası Çözümü

## Hata Açıklaması
```
ForegroundServiceStartNotAllowedException: 
Time limit already exhausted for foreground service type dataSync
```

## Problem
- Android 14+ (API Level 34+) sürümlerinde `dataSync` tipi foreground servisler **maksimum 6 saat** çalışabilir
- Deprem erken uyarı sistemi **7/24 kesintisiz** çalışması gereken kritik bir servis
- Zaman sınırı aşıldığında servis kapanıyor ve yeniden başlatılamıyor

## Çözüm (Uygulandı ✅)

### 1. AndroidManifest.xml Değişiklikleri

#### İzinler Güncellendi:
```xml
<!-- ESKİ (Kaldırıldı) -->
<uses-permission android:name="android.permission.FOREGROUND_SERVICE_DATA_SYNC" />

<!-- YENİ (Eklendi) -->
<uses-permission android:name="android.permission.FOREGROUND_SERVICE_LOCATION" />
<uses-permission android:name="android.permission.FOREGROUND_SERVICE_SPECIAL_USE" />
```

#### Service Type Değiştirildi:
```xml
<!-- ESKİ -->
<service android:name="com.pravera.flutter_foreground_task.service.ForegroundService"
    android:exported="false"
    android:foregroundServiceType="dataSync" />

<!-- YENİ -->
<service android:name="com.pravera.flutter_foreground_task.service.ForegroundService"
    android:exported="false"
    android:foregroundServiceType="location|specialUse">
    <!-- Android 14+ için zorunlu açıklama -->
    <property
        android:name="android.app.PROPERTY_SPECIAL_USE_FGS_SUBTYPE"
        android:value="deprem_erken_uyari_sistemi" />
</service>
```

### 2. Neden Bu Service Type'lar?

#### `location` Type:
- ✅ Sürekli konum izleme için tasarlandı
- ✅ Sınırsız süre çalışabilir
- ✅ Arka plan konum izni (`ACCESS_BACKGROUND_LOCATION`) ile uyumlu
- ✅ Deprem erken uyarı için konum takibi gerekli

#### `specialUse` Type:
- ✅ Özel kullanım senaryoları için (deprem algılama gibi)
- ✅ Android 14+ gereksinimi: `PROPERTY_SPECIAL_USE_FGS_SUBTYPE` property'si zorunlu
- ✅ Play Store review sırasında açıklama gerektirir

### 3. Android Foreground Service Type Karşılaştırması

| Service Type | Maksimum Süre | Kullanım Amacı | Uygulamaya Uygunluk |
|--------------|---------------|----------------|---------------------|
| `dataSync` | **6 saat** ⚠️ | Veri senkronizasyonu | ❌ Yetersiz |
| `location` | **Sınırsız** ✅ | Konum takibi | ✅ Uygun |
| `specialUse` | **Sınırsız** ✅ | Özel durumlar | ✅ Uygun |
| `mediaPlayback` | Sınırsız | Müzik/video oynatma | ❌ Uygun değil |

## Deployment Adımları

### 1. Uygulamayı Yeniden Derleyin
```bash
# Cache'i temizle
flutter clean

# Bağımlılıkları güncelle
flutter pub get

# Release APK oluştur
flutter build apk --release

# Veya AAB (Play Store için)
flutter build appbundle --release
```

### 2. Version Numarasını Artırın
`pubspec.yaml` dosyasında:
```yaml
version: 1.3.7+15  # Önceki: 1.3.6+14
```

### 3. Play Console'a Yükleyin
1. Play Console'a giriş yapın
2. Üretim/İç Test track'ine yeni APK/AAB yükleyin
3. Release notes'a ekleyin: "Android 14+ uyumluluk iyileştirmesi"

## Test Senaryoları

### Test 1: Kısa Süre Test
```
1. Uygulamayı başlatın
2. Arka plan servisini etkinleştirin
3. 1-2 saat bekleyin
4. Servisisin hala çalıştığını doğrulayın
```

### Test 2: Uzun Süre Test (Kritik)
```
1. Uygulamayı başlatın
2. Arka plan servisini etkinleştirin
3. 12-24 saat bekleyin
4. Servisin kesintisiz çalıştığını doğrulayın
5. Logları kontrol edin: "Time limit exhausted" hatası olmamalı
```

### Test 3: Android 14+ Özel Test
```
Cihaz: Android 14, 15 (API 34+)
1. Uygulamayı yükleyin
2. Tüm izinleri verin (özellikle "Arka planda her zaman" konum)
3. Servisi başlatın
4. Settings > Apps > Deprem Hattı > Battery > "Unrestricted" seçin
5. 6+ saat test edin
```

## Log Kontrolü

### Başarılı Başlatma:
```
[BG] Foreground servis başlatılıyor...
[BG] Arka plan konum izni verildi.
```

### Hata Durumu (Eskiden):
```
ForegroundServiceStartNotAllowedException: 
Time limit already exhausted for foreground service type dataSync
```

### Başarılı Durum (Yeni):
```
Service started with types: LOCATION | SPECIAL_USE
Service running for 12+ hours without issues
```

## Play Store Review İçin Notlar

### specialUse Type Açıklaması:
```
Uygulamamız, deprem erken uyarı sistemi olarak hayat kurtarıcı bir hizmet sunmaktadır.
Sürekli arka plan servisi aşağıdaki kritik işlemler için gereklidir:

1. **Deprem Sensörü İzleme**: Cihazın ivme sensörlerini sürekli izleyerek 
   P-dalgalarını (birincil deprem dalgaları) algılar.

2. **Gerçek Zamanlı Konum Takibi**: Kullanıcının konumuna göre en yakın 
   depremleri ve olası etkilenmeyi hesaplar.

3. **P2P Erken Uyarı**: S-dalgaları (yıkıcı deprem dalgaları) gelmeden önce 
   diğer kullanıcıları uyarır (saniyeler kritiktir).

4. **7/24 Hazır Bekleme**: Depremler önceden bilinemez, sistem sürekli 
   aktif olmalıdır.

Bu özellikler, specialUse foreground service type kullanımını zorunlu kılar.
```

## Ek Güvenlik Önlemleri

### 1. Battery Optimization Exempt
```dart
// Zaten uygulamada mevcut
await FlutterForegroundTask.requestIgnoreBatteryOptimization();
```

### 2. Auto-start Permission (Xiaomi, Huawei vb.)
Kullanıcılara manuel olarak açıklanmalı:
```
Settings > Apps > Deprem Hattı > Auto-start > Enable
```

### 3. Background Location Always Allow
```xml
<!-- Zaten mevcut -->
<uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION" />
```

## Sorun Devam Ederse

### 1. flutter_foreground_task Versiyonunu Güncelleyin
```yaml
# pubspec.yaml
flutter_foreground_task: ^8.17.0  # Veya en son versiyon
```

### 2. Alternatif: WorkManager Kullanımı
Eğer foreground service hala sorun yaşıyorsa, kritik olmayan işlemler için 
WorkManager kullanılabilir (ancak deprem algılama için uygun değil).

### 3. Play Store ile İletişim
specialUse kullanımı için ek açıklama istenirse, yukarıdaki "Play Store 
Review İçin Notlar" bölümünü kullanın.

## Değişiklik Tarihi
- **2026-01-29**: Android 14+ uyumluluk düzeltmesi uygulandı
- Foreground service type: `dataSync` → `location|specialUse`
- Gerekli izinler ve property'ler eklendi

## İlgili Dosyalar
- `android/app/src/main/AndroidManifest.xml`
- `lib/services/earthquake_background_service.dart`
- `pubspec.yaml`

## Referanslar
- [Android 14 Foreground Services](https://developer.android.com/about/versions/14/changes/fgs-types-required)
- [flutter_foreground_task Docs](https://pub.dev/packages/flutter_foreground_task)
- [Service Type Restrictions](https://developer.android.com/develop/background-work/services/fgs/service-types)
