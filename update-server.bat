@echo off
echo =========================================
echo     DEPREM SERVER UPDATE SCRIPT
echo =========================================
echo.

REM Mevcut dizini kontrol et
if not exist "package.json" (
    echo ❌ Hata: package.json bulunamadi!
    echo Bu script server klasorununde calistirilmali.
    pause
    exit /b 1
)

echo 📦 Mevcut server durumu kontrol ediliyor...
pm2 status

echo.
echo 🛑 Server durduruluyor...
pm2 stop deprem-server 2>nul
pm2 delete deprem-server 2>nul

echo.
echo 📥 Git repository'den son degisikliker cekilyor...
git fetch origin main
git reset --hard origin/main
git pull origin main

if %ERRORLEVEL% neq 0 (
    echo ❌ Git pull basarisiz! Error: %ERRORLEVEL%
    pause
    exit /b 1
)

echo.
echo 📦 NPM dependencies guncelleniyor...
npm install

if %ERRORLEVEL% neq 0 (
    echo ❌ NPM install basarisiz! Error: %ERRORLEVEL%
    pause
    exit /b 1
)

echo.
echo 🚀 Server yeniden baslatiliyor...
pm2 start ecosystem.config.json

if %ERRORLEVEL% neq 0 (
    echo ❌ PM2 start basarisiz! Error: %ERRORLEVEL%
    pause
    exit /b 1
)

echo.
echo ⏳ Server'in tamamen acilmasi bekleniyor... (10 saniye)
timeout /t 10 /nobreak

echo.
echo 🔍 Server durumu kontrol ediliyor...
pm2 status
pm2 logs deprem-server --lines 20

echo.
echo 🌐 Health check yapiliyor...
curl -s http://localhost:3000/health

echo.
echo.
echo ✅ SERVER GUNCELLEME TAMAMLANDI!
echo 🌐 Server URL: http://188.132.202.24:3000
echo 📊 Status: http://188.132.202.24:3000/health
echo 📋 Logs: pm2 logs deprem-server
echo.
pause
