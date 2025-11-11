# 🚀 VDS Hızlı Başlangıç Kılavuzu

**VDS IP:** 188.132.202.24

## 1️⃣ VDS'ye Bağlan

```bash
ssh root@188.132.202.24
```

## 2️⃣ Projeyi İndir

```bash
cd /var/www
git clone https://github.com/fatihsuzen/deprem-server.git deprem-app
cd deprem-app
```

## 3️⃣ Otomatik Kurulum Çalıştır

```bash
chmod +x setup-vds.sh
sudo bash setup-vds.sh
```

Bu komut otomatik olarak kurar:
- ✅ Node.js 18.x
- ✅ MongoDB
- ✅ PM2 (Process Manager)
- ✅ Nginx
- ✅ UFW Firewall

## 4️⃣ Environment Ayarla

```bash
cat > .env << EOF
PORT=3000
NODE_ENV=production
MONGODB_URI=mongodb://localhost:27017/deprem
EOF
```

## 5️⃣ Dependencies Yükle

```bash
npm install --production
```

## 6️⃣ Server'ı Başlat

```bash
pm2 start ecosystem.config.json
pm2 save
pm2 startup
```

## ✅ Test Et

### Health Check
```bash
curl http://localhost:3000/health
```

### Monitoring Dashboard
Tarayıcıda aç: **http://188.132.202.24:3000/monitor**

### API Test
```bash
curl http://188.132.202.24:3000/api/earthquakes
```

### Priority Notification Test
```bash
curl -X POST http://188.132.202.24:3000/api/test/priority-notification \
  -H "Content-Type: application/json" \
  -d '{
    "lat": 41.0082,
    "lon": 28.9784,
    "magnitude": 5.2,
    "location": "İstanbul",
    "depth": 10
  }'
```

## 🔍 Server Yönetimi

### Durum Kontrolü
```bash
pm2 status
```

### Logları İzle (Canlı)
```bash
pm2 logs deprem-server
```

### Server Restart
```bash
pm2 restart deprem-server
```

### Server Stop
```bash
pm2 stop deprem-server
```

### Server Start
```bash
pm2 start deprem-server
```

## 🔄 Güncelleme

```bash
cd /var/www/deprem-app
git pull
npm install --production
pm2 restart deprem-server
```

Ya da otomatik güncelleme scripti:
```bash
chmod +x deploy.sh
./deploy.sh
```

## 📊 Monitoring Dashboard

**URL:** http://188.132.202.24:3000/monitor

Gösterilen Bilgiler:
- 📊 Toplam Deprem Sayısı
- 👥 Aktif Kullanıcı Sayısı
- 🔔 Gönderilen Bildirim Sayısı
- ⚡ Son Deprem Bilgisi
- 🌍 Son 50 Deprem Listesi
- 👥 Kullanıcı Konumları ve Ayarları

Dashboard otomatik olarak 30 saniyede bir güncellenir.

## 🔐 Güvenlik (Opsiyonel)

### Firewall Durumu
```bash
sudo ufw status
```

### Nginx Durumu
```bash
sudo systemctl status nginx
```

### MongoDB Durumu
```bash
sudo systemctl status mongod
```

## 📱 Flutter App'i Güncelle

App zaten VDS IP'si ile güncellenmiş:
- ✅ `location_update_service.dart` → `http://188.132.202.24:3000/api`
- ✅ `earthquake_service.dart` → `http://188.132.202.24:3000/api/earthquakes`
- ✅ `friends_service_backend.dart` → `http://188.132.202.24:3000/api/friends`

Şimdi APK build edebilirsiniz:
```bash
flutter build apk --release
```

## ⚠️ Önemli Notlar

1. **Port 3000** açık olmalı (UFW otomatik açar)
2. **MongoDB** local'de çalışıyor (port 27017)
3. **PM2** server'ı otomatik restart eder (crash durumunda)
4. **Nginx** opsiyonel (domain varsa kullanın)
5. **Monitoring dashboard** herkese açık (production'da koruma ekleyin)

## 🆘 Sorun Giderme

### Server başlamıyor
```bash
pm2 logs deprem-server --lines 50
```

### MongoDB bağlantı hatası
```bash
sudo systemctl status mongod
sudo systemctl start mongod
```

### Port zaten kullanımda
```bash
sudo lsof -i :3000
# Ya da farklı port kullan (.env dosyasında PORT=3001)
```

### Logları temizle
```bash
pm2 flush
```

## 📞 İletişim

Sorun olursa server loglarını kontrol edin:
```bash
pm2 logs deprem-server --lines 100
```

Başarılar! 🎉
