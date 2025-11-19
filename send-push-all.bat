@echo off
REM Tüm cihazlara toplu FCM push bildirimi göndermek için
curl -X POST http://localhost:3000/api/send-push -H "Content-Type: application/json" -d "{\"title\":\"Deprem Uyarısı\",\"body\":\"Deprem algılandı! Lütfen güvenli bir yere geçin.\"}"
pause
