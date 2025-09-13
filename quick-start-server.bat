@echo off
title DEPREM APP - VDS Server Baslat
color 0A

echo.
echo ====================================
echo   🚀 DEPREM VDS SERVER BASLAT 🚀  
echo ====================================
echo.

echo 📡 Server IP: 188.132.202.24:3000
echo ⏰ Baslangic: %date% %time%
echo.

echo [1] 🔍 Server durumu kontrol ediliyor...
curl -s -m 5 http://188.132.202.24:3000/ >nul 2>&1

if %ERRORLEVEL% EQU 0 (
    echo ✅ Server zaten calisiyor!
    echo 🌐 Test URL: http://188.132.202.24:3000/
    goto :end
)

echo ❌ Server kapali. Baslat scripti calistiriliyor...
echo.

echo [2] 🖥️  Remote Desktop baglantisi aciliyor...
echo 💡 VDS'ye baglandiktan sonra su komutu calistirin:
echo.
echo    cd C:\server
echo    start-simple.bat
echo.
echo VEYA:
echo    pm2 start server.js --name deprem-server
echo.

REM Remote Desktop'u arka planda başlat
start /min mstsc /v:188.132.202.24

echo [3] ⏳ 10 saniye bekleniyor (server baslatma icin)...
timeout /t 10 /nobreak

echo [4] 🔄 Server durumu tekrar kontrol ediliyor...
curl -s -m 5 http://188.132.202.24:3000/ >nul 2>&1

if %ERRORLEVEL% EQU 0 (
    echo ✅ Server basariyla baslatildi!
    echo 🌐 Test URL: http://188.132.202.24:3000/
) else (
    echo ❌ Server hala yanit vermiyor.
    echo 🛠️  Manuel mudahale gerekli:
    echo    1. VDS'ye RDP ile baglanin
    echo    2. C:\server klasorune gidin  
    echo    3. start-simple.bat dosyasini calistirin
)

:end
echo.
echo ====================================
echo        ✨ ISLEM TAMAMLANDI ✨
echo ====================================
echo 📱 Simdi Flutter uygulamasini test edebilirsiniz!
echo.
pause
