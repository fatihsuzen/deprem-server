# Deprem Server VDS Kurulum Rehberi

## 1. Windows Server Hazırlık

### Node.js Kurulumu
1. https://nodejs.org/en/download/ adresinden LTS sürümü indirin
2. Kurulumu tamamlayın
3. CMD'de test edin: `node --version`

### MongoDB Kurulumu
1. https://www.mongodb.com/try/download/community adresinden indirin
2. Community Server seçin
3. Windows Service olarak kurun

### Git Kurulumu
1. https://git-scm.com/download/win adresinden indirin
2. Default ayarlarla kurun

## 2. PM2 Kurulumu
```cmd
npm install -g pm2
npm install -g pm2-windows-service
pm2-service-install
```

## 3. Proje Kurulumu
```cmd
cd C:\
git clone https://github.com/fatihsuzen/deprem-server.git
cd deprem-server
npm install
```

## 4. MongoDB Başlatma
```cmd
net start MongoDB
```

## 5. Server Başlatma
```cmd
# Önce proje dizinine gidin
cd C:\deprem-server

# Ecosystem dosyasının varlığını kontrol edin
dir ecosystem.config.json

# PM2 ile server'ı başlatın
pm2 start ecosystem.config.json

# Windows Service olarak kaydedin (startup yerine)
pm2-service-install -n "DepremServer"
pm2 save
```

## 6. Firewall Ayarları
- Port 3000'i açın
- MongoDB için Port 27017'yi local'e sınırlayın

## Test
http://188.132.202.24:3000/health

## 🔄 Otomatik Update Scriptleri

### Tam Güncelleme (Önerilen)
```cmd
cd C:\deprem-server
update-server.bat
```
- Git pull yapar
- NPM install çalıştırır
- Server'ı restart eder
- Health check yapar

### Hızlı Güncelleme
```cmd
cd C:\deprem-server
quick-update.bat
```
- Sadece git pull + restart

### Status Kontrolü
```cmd
cd C:\deprem-server
check-status.bat
```
- Git status, PM2 status, health check
- Logları gösterir

## Manuel Güncelleme (Alternatif)
```cmd
cd C:\deprem-server
pm2 stop deprem-server
git pull origin main
npm install
pm2 start ecosystem.config.json
```

## VDS Bilgileri
- IP: 188.132.202.24
- Port: 3000
- MongoDB: Port 27017 (local only)
