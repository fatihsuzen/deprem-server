@echo off
echo =====================================
echo    DEPREM APP - VDS SERVER BASLAT
echo =====================================
echo.

echo [1] VDS Server'a baglaniliyor...
echo IP: 188.132.202.24
echo.

REM VDS'ye SSH ile baglanma denemesi (eger SSH aciksa)
echo [2] SSH ile server durumu kontrol ediliyor...
ssh -o ConnectTimeout=5 Administrator@188.132.202.24 "cd C:\server && pm2 status" 2>nul

if %ERRORLEVEL% EQU 0 (
    echo ✅ SSH baglantisi basarili!
    echo.
    echo [3] PM2 ile server baslatiliyor...
    ssh Administrator@188.132.202.24 "cd C:\server && pm2 start server.js --name deprem-server || pm2 restart deprem-server"
    
    echo [4] Server durumu kontrol ediliyor...
    ssh Administrator@188.132.202.24 "cd C:\server && pm2 status"
    
) else (
    echo ❌ SSH baglantisi basarisiz. Manuel baglanmaniz gerekiyor.
    echo.
    echo MANUEL BAGLANMA ADIMLARI:
    echo ========================
    echo 1. Remote Desktop ile baglanin:
    echo    mstsc /v:188.132.202.24
    echo.
    echo 2. VDS'de CMD/PowerShell acin ve sunlari calistirin:
    echo    cd C:\server
    echo    pm2 start server.js --name deprem-server
    echo    pm2 status
    echo.
    echo 3. Alternatif olarak direkt Node.js ile:
    echo    cd C:\server
    echo    node server.js
    echo.
    
    echo [OTOMATIK] Remote Desktop baglantisini aciyorum...
    start mstsc /v:188.132.202.24
)

echo.
echo [5] Server test ediliyor...
timeout /t 3 /nobreak >nul

echo Test URL: http://188.132.202.24:3000/
curl -s http://188.132.202.24:3000/ >nul 2>&1

if %ERRORLEVEL% EQU 0 (
    echo ✅ Server calisiyor!
) else (
    echo ❌ Server yanit vermiyor. Manuel baslatmaniz gerekiyor.
)

echo.
echo =====================================
echo     ISLEM TAMAMLANDI
echo =====================================
pause
