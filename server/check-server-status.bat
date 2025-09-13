@echo off
title DEPREM APP - VDS Server Status
color 0B

echo.
echo ====================================
echo   📊 DEPREM VDS SERVER STATUS 📊  
echo ====================================
echo.

echo 📡 Server IP: 188.132.202.24:3000
echo ⏰ Kontrol: %date% %time%
echo.

echo [1] 🔍 HTTP Test...
curl -s -m 5 http://188.132.202.24:3000/ >nul 2>&1

if %ERRORLEVEL% EQU 0 (
    echo ✅ Server CALISIYOR
    set STATUS=ONLINE
) else (
    echo ❌ Server KAPALI
    set STATUS=OFFLINE
)

echo.
echo [2] 🌐 Port Test...
powershell -Command "Test-NetConnection -ComputerName 188.132.202.24 -Port 3000 | Select-Object TcpTestSucceeded"

echo.
echo [3] 📡 API Endpoints Test...
if "%STATUS%"=="ONLINE" (
    echo Testing /api/test...
    curl -s -m 3 http://188.132.202.24:3000/api/test
    echo.
    echo Testing /api/status...
    curl -s -m 3 http://188.132.202.24:3000/api/status
    echo.
) else (
    echo ⚠️  Server kapali oldugu icin API test edilemiyor
)

echo.
echo [4] 💡 Durum Ozeti:
echo ================
if "%STATUS%"=="ONLINE" (
    echo 🟢 Server Durumu: AKTIF
    echo 🌐 URL: http://188.132.202.24:3000/
    echo ✅ Flutter uygulamasi server ile iletisim kurabilir
) else (
    echo 🔴 Server Durumu: INAKTIF
    echo ❌ Flutter uygulamasi server ile iletisim kuramaz
    echo 🛠️  Server'i baslatmak icin: quick-start-server.bat
)

echo.
echo ====================================
echo        📈 STATUS RAPORU 📈
echo ====================================
pause
