@echo off
REM OneSignal ile tüm kullanıcılara bildirim gönder
REM Sunucu tarafında MongoDB'den onesignalId'leri çekip API'ye gönderir

setlocal enabledelayedexpansion

REM OneSignal App ID ve REST API Key
set ONESIGNAL_APP_ID=37c0591e-7d1c-4754-b65c-1328feafd933
set ONESIGNAL_API_KEY=YOUR_ONESIGNAL_REST_API_KEY

REM Bildirim başlığı ve mesajı
set TITLE=Deprem Uyarısı
set MESSAGE=Deprem algılandı! Lütfen güvenli bir yere geçin.

REM Sunucudan onesignalId listesini çek (örnek endpoint)
curl -s http://localhost:3000/api/admin/onesignal-ids > onesignal_ids.json

REM onesignal_ids.json dosyasından id'leri oku ve virgülle ayır
for /f "delims=" %%i in (onesignal_ids.json) do set IDS=%%i

REM Bildirim gönder
curl -X POST https://onesignal.com/api/v1/notifications ^
  -H "Authorization: Basic %ONESIGNAL_API_KEY%" ^
  -H "Content-Type: application/json" ^
  -d "{ ^
    \"app_id\": \"%ONESIGNAL_APP_ID%\", ^
    \"include_player_ids\": %IDS%, ^
    \"headings\": {\"en\": \"%TITLE%\"}, ^
    \"contents\": {\"en\": \"%MESSAGE%\"} ^
  }"

echo Bildirim gönderildi!
endlocal
