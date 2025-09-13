@echo off
echo Setting up automatic updates...

schtasks /create /tn "Deprem Server Auto Update" /tr "C:\deprem-server\auto-update.bat" /sc minute /mo 5 /ru SYSTEM

echo Task scheduled successfully!
echo - Updates will check every 5 minutes
echo - Automatic pull and restart if new code available
echo - No IDE or manual intervention needed

pause
