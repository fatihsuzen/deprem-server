#!/bin/bash

# Deprem App - VDS Deployment Script
# Bu script'i VDS'de çalıştırın

set -e  # Hata durumunda dur

echo "🚀 Deprem App Deployment Başlıyor..."
echo "======================================"

# Renk kodları
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Değişkenler
PROJECT_DIR="/var/www/deprem-app"
BACKUP_DIR="/var/backups/deprem-app"
LOG_FILE="/tmp/deprem-deploy.log"

# Log fonksiyonu
log() {
    echo -e "${GREEN}[$(date +'%Y-%m-%d %H:%M:%S')]${NC} $1" | tee -a $LOG_FILE
}

error() {
    echo -e "${RED}[ERROR]${NC} $1" | tee -a $LOG_FILE
    exit 1
}

warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1" | tee -a $LOG_FILE
}

# Root kontrolü
if [ "$EUID" -eq 0 ]; then 
    error "Bu script'i root kullanıcısı ile çalıştırmayın!"
fi

# 1. Sistem kontrolleri
log "Sistem kontrolleri yapılıyor..."

# Node.js kontrolü
if ! command -v node &> /dev/null; then
    error "Node.js bulunamadı! Lütfen önce Node.js kurun."
fi
NODE_VERSION=$(node --version)
log "✓ Node.js version: $NODE_VERSION"

# PM2 kontrolü
if ! command -v pm2 &> /dev/null; then
    warning "PM2 bulunamadı. Kuruluyor..."
    sudo npm install -g pm2
fi
log "✓ PM2 kurulu"

# Nginx kontrolü
if ! command -v nginx &> /dev/null; then
    warning "Nginx bulunamadı. Kuruluyor..."
    sudo apt update && sudo apt install -y nginx
fi
log "✓ Nginx kurulu"

# 2. Proje dizini kontrol
if [ ! -d "$PROJECT_DIR" ]; then
    error "Proje dizini bulunamadı: $PROJECT_DIR"
fi

cd $PROJECT_DIR
log "✓ Proje dizinine geçildi: $PROJECT_DIR"

# 3. Backup al
log "Mevcut versiyondan backup alınıyor..."
TIMESTAMP=$(date +%Y%m%d_%H%M%S)
mkdir -p $BACKUP_DIR

if [ -f "server.js" ]; then
    tar -czf $BACKUP_DIR/backup_$TIMESTAMP.tar.gz \
        --exclude='node_modules' \
        --exclude='logs' \
        --exclude='.git' \
        . || warning "Backup alınamadı, devam ediliyor..."
    log "✓ Backup alındı: $BACKUP_DIR/backup_$TIMESTAMP.tar.gz"
fi

# 4. Git pull (eğer git repo ise)
if [ -d ".git" ]; then
    log "Git güncellemeleri çekiliyor..."
    git fetch origin
    
    # Değişiklik var mı kontrol et
    LOCAL=$(git rev-parse @)
    REMOTE=$(git rev-parse @{u})
    
    if [ $LOCAL != $REMOTE ]; then
        log "Yeni değişiklikler bulundu, çekiliyor..."
        git pull origin main || git pull origin master
        log "✓ Git güncellemeleri çekildi"
    else
        log "✓ Kod güncel, değişiklik yok"
    fi
fi

# 5. Dependencies güncelleme
log "NPM bağımlılıkları kontrol ediliyor..."
if [ -f "package.json" ]; then
    npm install --production
    log "✓ NPM bağımlılıkları güncellendi"
fi

# 6. Environment dosyası kontrolü
if [ ! -f ".env" ]; then
    warning ".env dosyası bulunamadı!"
    if [ -f ".env.example" ]; then
        log ".env.example'dan .env oluşturuluyor..."
        cp .env.example .env
        warning "⚠️  Lütfen .env dosyasını düzenleyin: nano .env"
    fi
fi

# 7. Logs dizini oluştur
mkdir -p logs
chmod 755 logs
log "✓ Logs dizini hazır"

# 8. PM2 restart
log "PM2 ile uygulama yeniden başlatılıyor..."

# PM2'de uygulama var mı kontrol et
if pm2 list | grep -q "deprem-server"; then
    pm2 restart deprem-server
    log "✓ Uygulama yeniden başlatıldı"
else
    # İlk kez başlatılıyor
    if [ -f "ecosystem.config.json" ]; then
        pm2 start ecosystem.config.json
    else
        pm2 start server.js --name deprem-server
    fi
    pm2 save
    log "✓ Uygulama başlatıldı"
fi

# 9. Nginx restart
log "Nginx yeniden başlatılıyor..."
sudo systemctl reload nginx
log "✓ Nginx reload edildi"

# 10. Health check
log "Uygulama sağlık kontrolü yapılıyor..."
sleep 5  # Uygulamanın başlaması için bekle

if curl -f http://localhost:3000/health &> /dev/null; then
    log "✓ Uygulama sağlıklı çalışıyor"
else
    warning "⚠️  Health check başarısız! Logları kontrol edin: pm2 logs deprem-server"
fi

# 11. Durum özeti
echo ""
echo "======================================"
log "✅ Deployment tamamlandı!"
echo "======================================"
echo ""
echo "📊 Durum Bilgileri:"
echo "-------------------"
pm2 status
echo ""
echo "📝 Son loglar:"
echo "-------------------"
pm2 logs deprem-server --lines 10 --nostream
echo ""
echo "🔗 Faydalı Komutlar:"
echo "-------------------"
echo "  pm2 logs deprem-server        # Logları izle"
echo "  pm2 monit                      # Real-time monitoring"
echo "  pm2 restart deprem-server      # Manuel restart"
echo "  pm2 stop deprem-server         # Uygulamayı durdur"
echo ""
echo "📍 API Endpoint: http://$(hostname -I | awk '{print $1}'):3000"
echo "📍 Nginx Proxy: http://$(hostname -I | awk '{print $1}')"
echo ""
log "Log dosyası: $LOG_FILE"
