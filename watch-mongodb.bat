@echo off
setlocal EnableExtensions
title MongoDB Watchdog
set "SERVICE=MongoDB"
set "LOG=%~dp0mongodb-watch.log"
set "INTERVAL=15"

if /i "%~1"=="install" goto install
if /i "%~1"=="uninstall" goto uninstall
if /i "%~1"=="check" goto check

echo MongoDB watchdog basladi. Kontrol araligi: %INTERVAL% sn
echo Durdurmak icin Ctrl+C
echo.

:loop
call :check
ping -n %INTERVAL% 127.0.0.1 >nul
ping -n 2 127.0.0.1 >nul
goto loop

:check
sc query "%SERVICE%" | findstr /I /C:"RUNNING" >nul
if %ERRORLEVEL% EQU 0 (
  echo [%date% %time%] MongoDB calisiyor
  goto :eof
)

echo [%date% %time%] MongoDB durdu, baslatiliyor...
>> "%LOG%" echo [%date% %time%] MongoDB durdu, baslatiliyor...
net start "%SERVICE%" >nul 2>&1
if %ERRORLEVEL% EQU 0 (
  echo [%date% %time%] MongoDB baslatildi
  >> "%LOG%" echo [%date% %time%] MongoDB baslatildi
) else (
  echo [%date% %time%] MongoDB baslatilamadi
  >> "%LOG%" echo [%date% %time%] MongoDB baslatilamadi
)
goto :eof

:install
echo MongoDB watchdog gorevi kuruluyor...
schtasks /create /tn "MongoDB Watchdog" /tr "\"%~f0\" check" /sc minute /mo 1 /ru SYSTEM /rl HIGHEST /f
if %ERRORLEVEL% NEQ 0 (
  echo Gorev kurulamadi. Bu dosyayi Yonetici olarak calistirin.
  pause
  exit /b 1
)
schtasks /create /tn "MongoDB Watchdog Startup" /tr "\"%~f0\" check" /sc onstart /ru SYSTEM /rl HIGHEST /f >nul
echo.
echo Gorev kuruldu.
echo - Her 1 dakikada MongoDB kontrol edilir
echo - Durmussa otomatik baslatilir
echo - Log: %LOG%
echo.
echo Kaldirmak icin: watch-mongodb.bat uninstall
pause
exit /b 0

:uninstall
schtasks /delete /tn "MongoDB Watchdog" /f >nul 2>&1
schtasks /delete /tn "MongoDB Watchdog Startup" /f >nul 2>&1
echo MongoDB watchdog gorevleri kaldirildi.
pause
exit /b 0
