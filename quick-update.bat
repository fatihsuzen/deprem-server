@echo off
echo 🔄 QUICK SERVER UPDATE
echo.

REM Quick restart without npm install
echo 🛑 Stopping server...
pm2 stop deprem-server

echo 📥 Pulling latest code...
git pull origin main

echo 🚀 Starting server...
pm2 start ecosystem.config.json

echo ✅ Done! Check: http://188.132.202.24:3000/health
timeout /t 3
