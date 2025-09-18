Mobile MQTT & Notification Test

Bu dosya, Android cihaz üzerinde MQTT tabanlı test altyapısını nasıl çalıştıracağınızı anlatır.

1) Sunucu hazırlığı
- VDS üzerinde `.env` dosyasını oluşturun ve `MQTT_BROKER_URL` değerini doğru broker adresine ayarlayın (ör: `mqtts://broker.example.com:8883`).
- Sunucuyu yeniden başlatın.
- Test endpoint'i: `POST /api/test/push` (kullanıcıya veya target'e göre test gönderir).

2) Mobil (Android) hazırlığı
- Flutter bağımlılıklarını yükleyin:
  ```
  flutter pub get
  ```
- Uygulamayı debug modda çalıştırın (cihaz bağlı):
  ```
  flutter run -d <device-id>
  ```

3) Uygulama içinde
- Uygulama ana ekranında (debug modda) AppBar sağında bir böcek (bug) ikonu göreceksiniz — buna basarak `MQTT Test` ekranını açabilirsiniz.
- Test ekranında `Start Foreground & Connect` tuşu ile foreground servis başlayacak ve MQTT broker'a bağlanacaktır.
- Bağlandıktan sonra sunucuda `/api/devices/register` kaydı oluşmalıdır.
- `Send test push via server` ile server üzerinden `mqtt_<clientId>` hedefli test bildirimi gönderin.

4) Hata durumları
- MQTT bağlanmıyorsa broker URL/port/credentials (TLS) doğru mu kontrol edin.
- Android 12+ üzerinde foreground service izinleri ve bildirim kanallarına dikkat edin.

5) Geri alma
- Test tamamlandığında `Stop Foreground` butonu ile servisi durdurabilirsiniz.

Not: iOS için APNs entegrasyonu ileride eklenecektir. Bu rehberi takip ederek önce Android tarafında working PoC oluşturabilirsiniz.
