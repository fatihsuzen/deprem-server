# VDS Deployment Kılavuzu 🚀

## Sistem Gereksinimleri
- Ubuntu 20.04 veya üzeri (önerilir)
- Node.js 18.x veya üzeri
- PM2 (process manager)
- Nginx (reverse proxy)
- En az 2GB RAM
- En az 20GB disk alanı

---

## 1. VDS İlk Kurulum

### 1.1 Sistemi Güncelleme
```bash
sudo apt update && sudo apt upgrade -y
```

### 1.2 Node.js Kurulumu
```bash
# NodeSource repository ekle
curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash -

# Node.js ve npm kur
sudo apt install -y nodejs

# Versiyonları kontrol et
node --version  # v18.x.x olmalı
npm --version   # 9.x.x veya üzeri
```

### 1.3 PM2 Kurulumu (Global)
```bash
sudo npm install -g pm2

# PM2'yi sistem başlangıcına ekle
pm2 startup systemd
# Çıkan komutu kopyala ve çalıştır
```

### 1.4 Nginx Kurulumu
```bash
sudo apt install -y nginx

# Nginx'i başlat
sudo systemctl start nginx
sudo systemctl enable nginx
```

### 1.5 Firewall Ayarları
```bash
sudo ufw allow 22/tcp      # SSH
sudo ufw allow 80/tcp      # HTTP
sudo ufw allow 443/tcp     # HTTPS
sudo ufw allow 3000/tcp    # Node.js (geçici test için)
sudo ufw enable
```

---

## 2. Proje Kurulumu

### 2.1 Proje Dosyalarını Yükleme

**Seçenek A: Git ile (Önerilir)**
```bash
cd /var/www
sudo mkdir deprem-app
sudo chown -R $USER:$USER deprem-app
cd deprem-app

# GitHub'dan çek
git clone https://github.com/fatihsuzen/deprem-server.git .

# Veya manuel olarak
# - Tüm dosyaları WinSCP/FileZilla ile /var/www/deprem-app dizinine yükle
```

**Seçenek B: Manuel Yükleme**
- WinSCP, FileZilla veya scp komutu ile dosyaları yükle:
```bash
scp -r "C:\Users\Fatih\Desktop\Deprem App2\*" user@your-vds-ip:/var/www/deprem-app/
```

### 2.2 Bağımlılıkları Yükleme
```bash
cd /var/www/deprem-app
npm install --production
```

### 2.3 Environment Dosyası Oluşturma
```bash
cp .env.example .env
nano .env
```

**Production .env içeriği:**
```bash
# Server
PORT=3000
NODE_ENV=production

# MongoDB (yoksa kaldırabilirsin veya MongoDB kur)
# MONGODB_URI=mongodb://localhost:27017/deprem

# APNs (iOS push notifications - opsiyonel)
# APNS_KEY_PATH=./keys/AuthKey_XXXXXXXXXX.p8
# APNS_KEY_ID=XXXXXXXXXX
# APNS_TEAM_ID=YYYYYYYYYY
# APNS_BUNDLE_ID=com.yourorg.depremapp

# MQTT (Android push - opsiyonel)
# MQTT_BROKER_URL=mqtts://broker.example.com:8883
# MQTT_USERNAME=your_user
# MQTT_PASSWORD=your_pass
```

### 2.4 Logs Dizini Oluşturma
```bash
mkdir -p logs
chmod 755 logs
```

---

## 3. PM2 ile Başlatma

### 3.1 Uygulamayı Başlat
```bash
cd /var/www/deprem-app
pm2 start ecosystem.config.json
```

### 3.2 PM2 Komutları
```bash
# Durum kontrolü
pm2 status

# Logları görüntüle
pm2 logs deprem-server

# Uygulamayı yeniden başlat
pm2 restart deprem-server

# Uygulamayı durdur
pm2 stop deprem-server

# Uygulamayı sil
pm2 delete deprem-server

# PM2 süreçlerini kaydet (sistem yeniden başlatıldığında otomatik başlar)
pm2 save
```

### 3.3 Monitoring
```bash
# Gerçek zamanlı monitoring
pm2 monit

# Web dashboard (opsiyonel)
pm2 install pm2-server-monit
```

---

## 4. Nginx Reverse Proxy Kurulumu

### 4.1 Nginx Config Dosyası Oluştur
```bash
sudo nano /etc/nginx/sites-available/deprem-app
```

**İçerik:**
```nginx
server {
    listen 80;
    server_name your-domain.com www.your-domain.com;  # Domain adınızı yazın
    # Veya IP kullanacaksanız: server_name 123.456.789.012;

    # Güvenlik header'ları
    add_header X-Frame-Options "SAMEORIGIN" always;
    add_header X-Content-Type-Options "nosniff" always;
    add_header X-XSS-Protection "1; mode=block" always;

    # Upload limiti
    client_max_body_size 50M;

    # API endpoint
    location / {
        proxy_pass http://localhost:3000;
        proxy_http_version 1.1;
        
        # WebSocket desteği
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection 'upgrade';
        proxy_set_header Host $host;
        proxy_cache_bypass $http_upgrade;
        
        # Proxy header'ları
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        
        # Timeout ayarları
        proxy_connect_timeout 60s;
        proxy_send_timeout 60s;
        proxy_read_timeout 60s;
    }

    # Health check endpoint
    location /health {
        access_log off;
        proxy_pass http://localhost:3000/health;
    }

    # Access log
    access_log /var/log/nginx/deprem-app-access.log;
    error_log /var/log/nginx/deprem-app-error.log;
}
```

### 4.2 Config'i Aktifleştir
```bash
# Symlink oluştur
sudo ln -s /etc/nginx/sites-available/deprem-app /etc/nginx/sites-enabled/

# Default site'ı kaldır (opsiyonel)
sudo rm /etc/nginx/sites-enabled/default

# Nginx config'i test et
sudo nginx -t

# Nginx'i yeniden başlat
sudo systemctl restart nginx
```

---

## 5. SSL/HTTPS Kurulumu (Let's Encrypt - ÜCRETSİZ)

### 5.1 Certbot Kurulumu
```bash
sudo apt install -y certbot python3-certbot-nginx
```

### 5.2 SSL Sertifikası Al
```bash
# Domain ile
sudo certbot --nginx -d your-domain.com -d www.your-domain.com

# Sorulara cevaplar:
# - Email adresinizi girin
# - Terms of Service'i kabul edin (Y)
# - HTTP trafiğini HTTPS'e yönlendir (2)
```

### 5.3 Otomatik Yenileme Testi
```bash
# Certbot otomatik yenileme testi
sudo certbot renew --dry-run
```

---

## 6. Test ve Doğrulama

### 6.1 API Test
```bash
# Local test
curl http://localhost:3000/health

# Nginx üzerinden test
curl http://your-domain.com/health

# HTTPS test (SSL kurulumundan sonra)
curl https://your-domain.com/health

# Deprem API test
curl http://your-domain.com/api/earthquakes
```

### 6.2 Flutter App'ten Bağlantı

`lib/services/earthquake_service.dart` dosyasını güncelle:
```dart
class EarthquakeService {
  // DEĞİŞTİR: localhost yerine VDS IP veya domain
  static const String baseUrl = 'https://your-domain.com/api';
  
  // veya IP kullanıyorsan:
  // static const String baseUrl = 'http://123.456.789.012/api';
```

---

## 7. Güvenlik ve Bakım

### 7.1 Firewall (Port 3000'i Kapat)
```bash
# Artık port 3000'e dışarıdan erişim gerekmiyor (Nginx proxy kullanıyoruz)
sudo ufw delete allow 3000/tcp
sudo ufw status
```

### 7.2 Log Rotation
```bash
# PM2 otomatik log rotation
pm2 install pm2-logrotate
pm2 set pm2-logrotate:max_size 100M
pm2 set pm2-logrotate:retain 30
pm2 set pm2-logrotate:compress true
```

### 7.3 Düzenli Yedekleme
```bash
# Backup script oluştur
sudo nano /usr/local/bin/backup-deprem.sh
```

**Backup script içeriği:**
```bash
#!/bin/bash
BACKUP_DIR="/var/backups/deprem-app"
DATE=$(date +%Y%m%d_%H%M%S)

mkdir -p $BACKUP_DIR
cd /var/www/deprem-app

# Kod yedekle
tar -czf $BACKUP_DIR/code_$DATE.tar.gz \
    --exclude='node_modules' \
    --exclude='logs' \
    .

# Eski yedekleri temizle (30 günden eski)
find $BACKUP_DIR -name "*.tar.gz" -mtime +30 -delete

echo "Backup completed: $BACKUP_DIR/code_$DATE.tar.gz"
```

```bash
# Script'i executable yap
sudo chmod +x /usr/local/bin/backup-deprem.sh

# Cron job ekle (her gün saat 02:00)
sudo crontab -e
# Ekle: 0 2 * * * /usr/local/bin/backup-deprem.sh
```

### 7.4 Monitoring ve Alerting
```bash
# PM2 Plus (ücretsiz tier) - Opsiyonel
pm2 link <secret_key> <public_key>

# Veya kendi monitoring'inizi kurun
# - Uptime Robot (ücretsiz): https://uptimerobot.com
# - Status endpoint: https://your-domain.com/health
```

---

## 8. Güncelleme ve Deployment

### 8.1 Kod Güncellemesi (Git ile)
```bash
cd /var/www/deprem-app

# Son değişiklikleri çek
git pull origin main

# Bağımlılıkları güncelle (gerekirse)
npm install --production

# PM2'yi restart et
pm2 restart deprem-server

# Logları kontrol et
pm2 logs deprem-server --lines 50
```

### 8.2 Manuel Güncelleme
```bash
# Yeni dosyaları yükle (WinSCP/FileZilla ile)
# Ardından:
cd /var/www/deprem-app
npm install --production
pm2 restart deprem-server
```

---

## 9. Sorun Giderme

### 9.1 Uygulama Başlamıyor
```bash
# PM2 loglarını kontrol et
pm2 logs deprem-server --err --lines 100

# Manuel başlatma testi
cd /var/www/deprem-app
node server.js
# Hataları görebilirsin
```

### 9.2 Nginx Hataları
```bash
# Nginx error log'u kontrol et
sudo tail -f /var/log/nginx/deprem-app-error.log

# Nginx config test
sudo nginx -t

# Nginx restart
sudo systemctl restart nginx
```

### 9.3 Yüksek Memory Kullanımı
```bash
# PM2 monitoring
pm2 monit

# Memory limit artır (ecosystem.config.json)
"max_memory_restart": "2G"  # 1G -> 2G

pm2 restart deprem-server
```

### 9.4 Port Çakışması
```bash
# Port 3000'i kim kullanıyor?
sudo lsof -i :3000

# Process'i öldür
sudo kill -9 <PID>
```

---

## 10. Hızlı Başlangıç Özeti

```bash
# 1. VDS'ye bağlan
ssh user@your-vds-ip

# 2. Node.js + PM2 + Nginx kur
curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash -
sudo apt install -y nodejs nginx
sudo npm install -g pm2

# 3. Proje dosyalarını yükle
sudo mkdir -p /var/www/deprem-app
sudo chown -R $USER:$USER /var/www/deprem-app
cd /var/www/deprem-app
# Dosyaları yükle (git veya scp)

# 4. Kurulum
npm install --production
cp .env.example .env
nano .env  # Gerekli ayarları yap
mkdir logs

# 5. PM2 ile başlat
pm2 start ecosystem.config.json
pm2 save
pm2 startup systemd  # Çıkan komutu çalıştır

# 6. Nginx config
sudo nano /etc/nginx/sites-available/deprem-app
# Config'i yapıştır (yukarıdaki template)
sudo ln -s /etc/nginx/sites-available/deprem-app /etc/nginx/sites-enabled/
sudo nginx -t
sudo systemctl restart nginx

# 7. Firewall
sudo ufw allow 22,80,443/tcp
sudo ufw enable

# 8. SSL (opsiyonel ama önerilir)
sudo apt install -y certbot python3-certbot-nginx
sudo certbot --nginx -d your-domain.com

# 9. Test
curl http://localhost:3000/health
curl http://your-domain.com/api/earthquakes

# 10. Flutter app'i güncelle
# baseUrl'i VDS IP/domain olarak değiştir
```

---

## 📞 İletişim ve Destek

Sorun yaşarsan:
1. PM2 loglarını kontrol et: `pm2 logs deprem-server`
2. Nginx loglarını kontrol et: `sudo tail -f /var/log/nginx/deprem-app-error.log`
3. Server loglarını kontrol et: `tail -f /var/www/deprem-app/logs/error.log`

**Faydalı Komutlar:**
```bash
pm2 status              # Durum
pm2 restart all         # Tüm uygulamaları restart
pm2 logs --lines 100    # Son 100 satır log
pm2 monit               # Gerçek zamanlı monitoring
sudo systemctl status nginx  # Nginx durumu
sudo nginx -t           # Config test
```

Başarılar! 🚀
