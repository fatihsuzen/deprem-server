@echo off
REM Sunucuda cihazlara FCM push bildirimi göndermek için örnek komut
REM title ve body parametrelerini değiştirerek kullanabilirsin

curl -X POST http://localhost:3000/api/send-push -H "Content-Type: application/json" -d "{
  \"userId\": \"KULLANICI_ID\",
  \"title\": \"Deprem Uyarısı\",
  \"body\": \"Deprem algılandı! Lütfen güvenli bir yere geçin.\"
}"

pause
