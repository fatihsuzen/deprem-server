@echo off
echo Installing Deprem Server as Windows Service...

cd C:\deprem-server

echo Starting MongoDB...
net start MongoDB

echo Installing PM2 Windows Service...
pm2-service-install -n "DepremServer"

echo Starting Node.js Server...
pm2 start server.js --name "deprem-api"

echo Saving PM2 configuration...
pm2 save

echo Setting up Windows Service...
pm2-service-install

echo Server installed successfully!
echo Access: http://localhost:3000/health

pause
