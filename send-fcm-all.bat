@echo off
REM Node.js ile FCM HTTP v1 API üzerinden tüm kullanıcılara bildirim gönder
REM Önce gerekli paketleri yükleyin: npm install googleapis axios

echo Bildirim gönderiliyor...
node send-fcm.js
pause@echo off
REM Tüm kullanıcılara FCM ile deprem bildirimi göndermek için örnek komut dosyası
REM Gerekli: curl, server'ın FCM endpoint'i ve FCM server key

setlocal enabledelayedexpansion

REM FCM server key (buraya kendi anahtarınızı girin)
set FCM_SERVER_KEY=YOUR_FCM_SERVER_KEY_HERE

REM Bildirim başlığı ve mesajı
set TITLE=Deprem Uyarısı
set BODY=Yeni deprem algılandı! Lütfen güvenli bir yere geçin.

REM FCM endpoint
set FCM_URL=https://fcm.googleapis.com/fcm/send

REM Tüm kullanıcılara göndermek için topic kullanılır ("all" topic örneği)
set TOPIC=/topics/all

REM JSON payload oluştur
set PAYLOAD={"to":"!TOPIC!","notification":{"title":"!TITLE!","body":"!BODY!"}}

REM Bildirimi gönder
curl -X POST !FCM_URL! -H "Authorization: key=!FCM_SERVER_KEY!" -H "Content-Type: application/json" -d "!PAYLOAD!"

echo Bildirim gönderildi.
pause
