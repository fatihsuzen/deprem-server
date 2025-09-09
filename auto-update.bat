@echo off
echo ========================================
echo    DEPREM SERVER AUTO UPDATE
echo ========================================

cd /d C:\deprem-server

echo [%time%] Checking for updates...
git fetch origin main

FOR /F "tokens=*" %%i IN ('git rev-list HEAD...origin/main --count') DO SET commit_count=%%i

if %commit_count% GTR 0 (
    echo [%time%] Found %commit_count% new commits. Updating...
    
    echo [%time%] Stopping server...
    pm2 stop deprem-server
    
    echo [%time%] Pulling latest code...
    git pull origin main
    
    echo [%time%] Installing dependencies...
    npm install --production --silent
    
    echo [%time%] Starting server...
    pm2 start ecosystem.config.json
    
    echo [%time%] Update completed successfully!
) else (
    echo [%time%] No updates available.
)

echo ========================================
echo [%time%] Auto-update check completed
echo ========================================
