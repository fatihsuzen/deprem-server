#!/bin/bash

# Deprem App - İlk Kurulum Script'i
# VDS'ye ilk kez kurulum için bu script'i çalıştırın

set -e

echo "🚀 Deprem App - İlk Kurulum"
echo "======================================"

# Renk kodları
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

log() {
    echo -e "${GREEN}[$(date +'%H:%M:%S')]${NC} $1"
}

error() {
    echo -e "${RED}[ERROR]${NC} $1"
    exit 1
}

warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

info() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

# Root kontrolü
if [ "$EUID" -ne 0 ]; then 
    error "Bu script'i sudo ile çalıştırın: sudo bash setup.sh"
fi

# Kullanıcı bilgileri al
if [ -z "$SUDO_USER" ]; then
    ACTUAL_USER=$USER
else
    ACTUAL_USER=$SUDO_USER
fi

log "Kullanıcı: $ACTUAL_USER"

# 1. Sistem güncellemesi
log "Sistem güncelleniyor..."
apt update && apt upgrade -y
log "✓ Sistem güncellendi"

# 2. Gerekli paketleri kur
log "Gerekli paketler kuruluyor..."
apt install -y curl git ufw software-properties-common build-essential
log "✓ Temel paketler kuruldu"

# 3. Node.js kurulumu
log "Node.js kuruluyor..."
if ! command -v node &> /dev/null; then
    curl -fsSL https://deb.nodesource.com/setup_18.x | bash -
    apt install -y nodejs
    log "✓ Node.js kuruldu: $(node --version)"
else
    log "✓ Node.js zaten kurulu: $(node --version)"
fi

# 4. PM2 kurulumu
log "PM2 kuruluyor..."
if ! command -v pm2 &> /dev/null; then
    npm install -g pm2
    log "✓ PM2 kuruldu"
else
    log "✓ PM2 zaten kurulu"
fi

# 5. Nginx kurulumu
log "Nginx kuruluyor..."
if ! command -v nginx &> /dev/null; then
    apt install -y nginx
    systemctl start nginx
    systemctl enable nginx
    log "✓ Nginx kuruldu ve başlatıldı"
else
    log "✓ Nginx zaten kurulu"
fi

# 6. Firewall ayarları
log "Firewall yapılandırılıyor..."
ufw --force enable
ufw allow 22/tcp    # SSH
ufw allow 80/tcp    # HTTP
ufw allow 443/tcp   # HTTPS
ufw allow 3000/tcp  # Node.js (geçici, test için)
log "✓ Firewall ayarlandı"

# 7. Proje dizini oluştur
PROJECT_DIR="/var/www/deprem-app"
log "Proje dizini oluşturuluyor: $PROJECT_DIR"

mkdir -p $PROJECT_DIR
chown -R $ACTUAL_USER:$ACTUAL_USER $PROJECT_DIR
chmod 755 $PROJECT_DIR
log "✓ Proje dizini hazır"

# 8. PM2 startup ayarları
log "PM2 startup yapılandırılıyor..."
env PATH=$PATH:/usr/bin /usr/lib/node_modules/pm2/bin/pm2 startup systemd -u $ACTUAL_USER --hp /home/$ACTUAL_USER
log "✓ PM2 startup ayarlandı"

# 9. Log rotation
log "Log rotation ayarlanıyor..."
cat > /etc/logrotate.d/deprem-app <<EOF
/var/www/deprem-app/logs/*.log {
    daily
    rotate 30
    compress
    delaycompress
    notifempty
    create 0640 $ACTUAL_USER $ACTUAL_USER
    sharedscripts
    postrotate
        pm2 reloadLogs
    endscript
}
EOF
log "✓ Log rotation ayarlandı"

# 10. Backup dizini oluştur
BACKUP_DIR="/var/backups/deprem-app"
mkdir -p $BACKUP_DIR
chown -R $ACTUAL_USER:$ACTUAL_USER $BACKUP_DIR
log "✓ Backup dizini oluşturuldu: $BACKUP_DIR"

# 11. Özet bilgiler
echo ""
echo "======================================"
log "✅ İlk kurulum tamamlandı!"
echo "======================================"
echo ""
echo "📋 Kurulu Bileşenler:"
echo "  • Node.js: $(node --version)"
echo "  • npm: $(npm --version)"
echo "  • PM2: $(pm2 --version)"
echo "  • Nginx: $(nginx -v 2>&1 | grep -oP '(?<=nginx/)[0-9.]+')"
echo ""
echo "📁 Dizinler:"
echo "  • Proje: $PROJECT_DIR"
echo "  • Backup: $BACKUP_DIR"
echo ""
echo "🔥 Firewall Durumu:"
ufw status numbered
echo ""
echo "📝 Sıradaki Adımlar:"
echo "======================================"
echo "1. Proje dosyalarını yükleyin:"
echo "   ${YELLOW}cd $PROJECT_DIR${NC}"
echo "   ${YELLOW}git clone <your-repo-url> .${NC}"
echo "   veya"
echo "   ${YELLOW}scp -r /local/path/* user@vds:$PROJECT_DIR/${NC}"
echo ""
echo "2. Bağımlılıkları kurun:"
echo "   ${YELLOW}cd $PROJECT_DIR${NC}"
echo "   ${YELLOW}npm install --production${NC}"
echo ""
echo "3. Environment dosyası oluşturun:"
echo "   ${YELLOW}cp .env.example .env${NC}"
echo "   ${YELLOW}nano .env${NC}"
echo ""
echo "4. Uygulamayı başlatın:"
echo "   ${YELLOW}pm2 start ecosystem.config.json${NC}"
echo "   ${YELLOW}pm2 save${NC}"
echo ""
echo "5. Nginx'i yapılandırın:"
echo "   ${YELLOW}sudo nano /etc/nginx/sites-available/deprem-app${NC}"
echo "   (VDS-DEPLOYMENT.md dosyasındaki örnek config'i kullanın)"
echo ""
echo "6. SSL sertifikası alın (opsiyonel):"
echo "   ${YELLOW}sudo apt install certbot python3-certbot-nginx${NC}"
echo "   ${YELLOW}sudo certbot --nginx -d your-domain.com${NC}"
echo ""
echo "📚 Detaylı kılavuz için VDS-DEPLOYMENT.md dosyasına bakın"
echo ""
