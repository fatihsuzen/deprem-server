@echo off
echo =========================================
echo        SERVER STATUS & DEPLOYMENT
echo =========================================
echo.

REM Git status
echo 📋 GIT STATUS:
git status --porcelain
echo.

REM Server status  
echo 🚀 PM2 SERVER STATUS:
pm2 status
echo.

REM Health check
echo 🌐 SERVER HEALTH CHECK:
curl -s http://localhost:3000/health 2>nul || echo "❌ Server not responding"
echo.

REM Recent logs
echo 📜 RECENT LOGS (last 10 lines):
pm2 logs deprem-server --lines 10
echo.

echo =========================================
echo Commands:
echo   update-server.bat  - Full update with npm install
echo   quick-update.bat   - Quick restart only  
echo   git add . ^&^& git commit -m "update" ^&^& git push
echo =========================================
pause
