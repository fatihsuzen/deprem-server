@echo off
title DEPREM APP - VDS Server Durdur
color 0C

echo.
echo ====================================
echo   ⛔ DEPREM VDS SERVER DURDUR ⛔  
echo ====================================
echo.

echo 📡 Server IP: 188.132.202.24:3000
echo ⏰ Durdurma: %date% %time%
echo.

echo [1] 🔍 Server durumu kontrol ediliyor...
curl -s -m 3 http://188.132.202.24:3000/ >nul 2>&1

if %ERRORLEVEL% NEQ 0 (
    echo ✅ Server zaten kapali!
    goto :end
)

echo ❌ Server calisiyor. Durduruluyor...
echo.

echo [2] 🛑 PM2 ile server durduruluyor...
echo.
echo VDS'de su komutu calistirin:
echo    pm2 stop deprem-server
echo    pm2 delete deprem-server
echo.

echo [3] 🖥️  Remote Desktop baglantisi aciliyor...
start /min mstsc /v:188.132.202.24

echo [4] ⏳ 5 saniye bekleniyor...
timeout /t 5 /nobreak

echo [5] 🔄 Server durumu kontrol ediliyor...
curl -s -m 3 http://188.132.202.24:3000/ >nul 2>&1

if %ERRORLEVEL% NEQ 0 (
    echo ✅ Server basariyla durduruldu!
) else (
    echo ❌ Server hala calisiyor.
    echo 🛠️  Manuel mudahale gerekli:
    echo    1. VDS'ye RDP ile baglanin
    echo    2. PM2 komutlarini calistirin:
    echo       pm2 stop all
    echo       pm2 delete all
    echo    3. Veya Node process'lerini sonlandirin:
    echo       taskkill /im node.exe /f
)

:end
echo.
echo ====================================
echo        ✨ ISLEM TAMAMLANDI ✨
echo ====================================
echo.
pause
