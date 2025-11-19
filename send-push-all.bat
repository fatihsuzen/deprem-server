@echo off
@echo off
REM Tüm kullanıcılara deprem bildirimi gönderir
setlocal
set TITLE=Deprem Uyarısı
set BODY=Bölgenizde deprem algılandı!

curl -X POST http://188.132.202.24:3000/fcm/send-all -H "Content-Type: application/json" -d "{\"title\":\"%TITLE%\",\"body\":\"%BODY%\",\"data\":{\"type\":\"earthquake\"}}"
endlocal
pause
