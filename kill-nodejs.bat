@echo off
echo ========================================
echo  Killing All Node.js Processes
echo ========================================
echo.

echo Stopping all Node.js processes...
taskkill /F /IM node.exe 2>nul

if %errorlevel% equ 0 (
    echo.
    echo ✅ All Node.js processes have been killed successfully.
) else (
    echo.
    echo ⚠️ No Node.js processes found or already stopped.
)

echo.
echo Done!
pause
