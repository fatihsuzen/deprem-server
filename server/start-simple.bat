@echo off
echo Starting Deprem Server...

cd C:\deprem-server

echo Starting MongoDB...
net start MongoDB

echo Starting Node.js Server...
node server.js

pause
