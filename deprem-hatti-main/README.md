# Deprem Bildirim - Flutter UI Taslağı

Bu proje, mobilde çalışacak bir deprem bildirim uygulamasının front-end (UI) iskeletini içerir. Backend daha sonra eklenecek.

İçindekiler
- `lib/main.dart`: Uygulama başlangıcı ve rotalar
- `lib/screens/home.dart`: Ana ekran - bildirim listesi
- `lib/screens/notification_detail.dart`: Bildirim detay ekranı
- `lib/widgets/notification_card.dart`: Bildirim kartı widget'ı

Çalıştırma (Windows PowerShell):

```powershell
# Flutter SDK yüklü olmalı
cd c:\Users\KAAN\Desktop\Development\DepremHatti
flutter pub get
flutter run -d <device-id>
```

Sonraki adımlar:
- Bana ekran tasarımlarını (screenshot) gönderin; ben UI'yi bu görüntülere göre düzenleyip ekranları güncelleyeceğim.
- Daha sonra backend API kontratlarını belirleyip entegrasyon ekleyebiliriz.
