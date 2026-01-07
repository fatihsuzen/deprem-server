# Google Play Store Konum İzni Uyumluluk Düzeltmeleri

## Sorun
Google Play Store, BACKGROUND_LOCATION iznine erişmeden önce kullanıcıya belirgin bir açıklama gösterilmesini gerektiren Kullanıcı Verileri Politikası'na uygun değildi.

## Çözüm

### 1. Yeni Dosyalar Eklendi

#### `lib/widgets/location_permission_dialog.dart`
- Google Play Store politikalarına uygun konum izni açıklama dialog'u
- Kullanıcıya konum verilerinin neden toplandığını ve nasıl kullanılacağını açıkça gösterir
- Hem temel konum hem de arka plan konum izinleri için ayrı açıklamalar

#### `lib/services/permission_service.dart`
- Merkezi izin yönetim servisi
- UI tarafından kullanılmak üzere tasarlandı (context gerektirir)
- İzin isteme işlemlerini Google Play Store politikalarına uygun şekilde yönetir

### 2. Güncellenen Dosyalar

#### `lib/services/earthquake_background_service.dart`
- **Değişiklik:** Artık izin istemiyor, sadece kontrol ediyor
- **Neden:** Background servis UI gösteremez, izin isteme UI'dan yapılmalı
- İzin yoksa uyarı veriyor ama servisi yine de başlatıyor

#### `lib/services/location_service.dart`
- **Değişiklik:** `initializeLocation()` artık izin istemiyor, sadece kontrol ediyor
- **Neden:** Servis katmanı UI gösteremez
- İzin yoksa hata mesajı veriyor

#### `lib/services/location_update_service.dart`
- **Değişiklik:** `checkAndRequestPermission()` artık izin istemiyor
- Sadece mevcut izin durumunu kontrol ediyor

#### `lib/screens/map_screen.dart`
- **Değişiklik:** `_getUserLocation()` izin isteme kodunu kaldırdı
- Sadece izin kontrolü yapıyor

#### `lib/screens/history.dart`
- **Değişiklik:** İzin isteme kodu kaldırıldı
- Kullanıcıyı ayarlara yönlendiriyor

#### `lib/screens/root.dart`
- **Yeni Özellik:** İlk açılışta izin isteme mantığı eklendi
- `_checkAndRequestPermissions()` methodu ile:
  1. Önce temel konum izni isteniyor (dialog ile)
  2. Ardından arka plan konum izni isteniyor (dialog ile)
- İzin durumu `SharedPreferences`'a kaydediliyor (bir daha sorulmasın)

#### `lib/l10n/app_localizations.dart`
- **Eklenen Metinler (TR ve EN):**
  - `backgroundLocationTitle`
  - `locationPermissionTitle`
  - `backgroundLocationMessage`
  - `locationPermissionMessage`
  - `backgroundLocationReason1`, `backgroundLocationReason2`, `backgroundLocationReason3`
  - `locationReason1`, `locationReason2`, `locationReason3`
  - `locationPrivacyNote`
  - `backgroundLocationNote`
  - `deny`, `allow`

### 3. Akış Diyagramı

```
Uygulama Başlangıcı
    ↓
RootScreen → initState()
    ↓
_checkAndRequestPermissions()
    ↓
İzin daha önce istendi mi? (SharedPreferences)
    ↓
HAYIR → PermissionService.requestLocationPermission()
    ↓
LocationPermissionDialog.show() [TEMEL KONUM]
    ↓
Kullanıcı Kabul Etti mi?
    ↓
EVET → Sistem İzin Dialog'u
    ↓
İzin Verildi mi?
    ↓
EVET → PermissionService.requestBackgroundLocationPermission()
    ↓
LocationPermissionDialog.show() [ARKA PLAN KONUM]
    ↓
Kullanıcı Kabul Etti mi?
    ↓
EVET → Sistem İzin Dialog'u ("Her zaman izin ver" seçeneği)
    ↓
location_permission_asked = true (SharedPreferences)
```

## Google Play Store Politikasına Uygunluk

### ✅ Yapılan İyileştirmeler

1. **Belirgin Açıklama (Prominent Disclosure)**
   - ✅ İzin istenmeden ÖNCE kullanıcıya açık bir dialog gösteriliyor
   - ✅ Konum verilerinin neden toplandığı açıklanıyor
   - ✅ Verilerin nasıl kullanılacağı belirtiliyor
   - ✅ Gizlilik notu eklendi

2. **Arka Plan Konum İzni**
   - ✅ Normal konum izninden AYRI bir dialog gösteriliyor
   - ✅ Kullanıcıya "Her zaman izin ver" seçeneğini seçmesi gerektiği bildiriliyor
   - ✅ Arka plan kullanımının nedenleri açıkça belirtiliyor

3. **Kullanıcı Deneyimi**
   - ✅ Kullanıcı dilediğinde reddedebiliyor
   - ✅ Ayarları açma seçeneği sunuluyor
   - ✅ İzin bir kez isteniyor (tekrar sorulmuyor)

## Test Adımları

1. **İlk Kurulum Testi:**
   - Uygulamayı temiz kurun
   - Root ekranı açıldığında izin dialog'larının gösterildiğini doğrulayın
   - Her iki dialog'da da açıklamaların gösterildiğini kontrol edin

2. **İzin Reddetme Testi:**
   - İlk dialog'da "Reddet" seçin
   - Uygulamanın çalışmaya devam ettiğini doğrulayın
   - Konum gerektiren özelliklerde uygun hata mesajları gösterildiğini kontrol edin

3. **Arka Plan İzni Testi:**
   - Temel konum iznini verin
   - Arka plan izni dialog'unu onaylayın
   - Sistem dialog'unda "Her zaman izin ver" seçeneğinin gösterildiğini doğrulayın

4. **Tekrar Açılış Testi:**
   - Uygulamayı kapatıp tekrar açın
   - İzin dialog'larının tekrar gösterilMEdiğini doğrulayın

## Önemli Notlar

- ⚠️ Android Manifest'teki `ACCESS_BACKGROUND_LOCATION` izni zaten mevcut
- ⚠️ İzin isteme logic'i artık yalnızca UI katmanında (RootScreen)
- ⚠️ Servis ve utility katmanları artık izin istemiyor, sadece kontrol ediyor
- ⚠️ İlk açılışta izinler isteniyor, tekrar sorulmuyor

## Google Play Store Gönderimi İçin Kontrol Listesi

- [x] Arka plan konum izni için belirgin açıklama mevcut
- [x] Açıklama izin istenmeden ÖNCE gösteriliyor
- [x] Verilerin kullanım amacı açıkça belirtilmiş
- [x] Gizlilik notu eklendi
- [x] Kullanıcı reddetme hakkına sahip
- [x] Çoklu dil desteği (TR/EN)
- [x] Material 3 tasarım uyumlu
- [x] Erişilebilirlik özellikleri mevcut

## Sonraki Adımlar

1. Uygulamayı test edin
2. Gerekirse ek düzenlemeler yapın
3. Google Play Store'a yeniden gönderin
4. İnceleme sürecini takip edin

---
**Not:** Bu değişiklikler Google Play Store'un "Prominent Disclosure and Consent" gereksinimlerini karşılamak için yapılmıştır.
