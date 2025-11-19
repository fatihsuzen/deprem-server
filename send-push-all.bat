@echo off
@echo off
REM Tüm kullanıcılara deprem bildirimi gönderir
setlocal
set TITLE=Deprem Uyarısı
set BODY=Bölgenizde deprem algılandı!
set DATA={"type":"earthquake"}

curl -X POST http://localhost:3000/send-all -H "Content-Type: application/json" -d "{\"title\":\"%TITLE%\",\"body\":\"%BODY%\",\"data\":%DATA%}" 
endlocal
pause
