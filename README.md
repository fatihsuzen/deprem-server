# 🚨 Deprem Erken Uyarı Sistemi

Bu proje, dünyada ilk **P2P (Peer-to-Peer) Deprem Erken Uyarı Sistemi**'dir. Flutter mobil uygulaması ve Node.js server backend'i içermektedir. Kullanıcıların telefonlarındaki jiroskop sensörlerini kullanarak P-dalgalarını tespit eder ve S-dalgası gelmeden önce çevredeki kullanıcılara uyarı gönderir.

## ⚡ Ana Özellikler

### � Flutter Mobil Uygulama
- **Dark Theme Sistemi** - Kullanıcı dostu karanlık tema
- **Deprem Haritası** - Gerçek zamanlı deprem görüntüleme
- **Konum Takibi** - 2 saatte bir otomatik konum güncellemesi
- **Chat Sistemi** - Global ve ülke bazlı chat odaları
- **Arkadaş Sistemi** - Harita üzerinde arkadaş konumları

### 🔧 Server Backend
- **WebSocket Real-time İletişim** - Anlık bildirim gönderimi
- **P2P Seismik Ağ** - Telefon jiroskopları ile deprem tespiti  
- **Multi-source Monitoring** - AFAD, Kandilli, USGS entegrasyonu
- **Chat API** - 20+ ülke chat odaları
- **Arkadaş API** - Konum paylaşım sistemi

### � Chat Sistemi
- **Global Chat** - Tüm dünyadan kullanıcılarla sohbet
- **Ülke Odaları** - 20+ ülke için ayrı chat odaları
- **Aktif Kullanıcı Sayısı** - Her odada kaç kişi aktif gösterimi
- **Firebase Authentication** - Güvenli giriş sistemi

### � Konum & Arkadaş Sistemi
- **Harita Görünümü** - Arkadaş konumları harita üzerinde
- **Otomatik Güncellemeler** - 2 saatte bir konum güncelleme
- **Konum Paylaşımı** - Arkadaşlarla güvenli konum paylaşımı

## 🚀 Kurulum

### Flutter Uygulaması
```bash
flutter pub get
flutter run
```

### Server Backend
```bash
cd server
npm install
npm start
```

## 📡 API Endpoints

### Chat API
```http
GET /api/chat/rooms - Chat odaları listesi
POST /api/chat/rooms/:roomId/join - Odaya katıl
POST /api/chat/rooms/:roomId/leave - Odadan çık
GET /api/chat/rooms/:roomId/messages - Mesajları getir
POST /api/chat/rooms/:roomId/messages - Mesaj gönder
```

### Arkadaş API
```http
GET /api/friends - Arkadaş listesi
POST /api/friends/add - Arkadaş ekle
DELETE /api/friends/:friendId - Arkadaşı sil
PUT /api/friends/location - Konum güncelle
```

### Deprem API
```http
GET /api/earthquakes/recent - Son depremler
GET /api/reports/:city - Şehir raporları
```

## � Chat Odaları

### Global & Ülke Odaları
- 🌍 **Global Chat** - Tüm dünyadan kullanıcılar
- 🇹🇷 **Türkiye** - Türkiye kullanıcıları
- 🇺🇸 **USA** - Amerika kullanıcıları
- 🇩🇪 **Germany** - Almanya kullanıcıları
- 🇫🇷 **France** - Fransa kullanıcıları
- 🇬🇧 **United Kingdom** - İngiltere kullanıcıları
- 🇮🇹 **Italy** - İtalya kullanıcıları
- 🇪🇸 **Spain** - İspanya kullanıcıları
- 🇯🇵 **Japan** - Japonya kullanıcıları
- 🇰🇷 **South Korea** - Güney Kore kullanıcıları
- 🇨🇳 **China** - Çin kullanıcıları
- 🇷🇺 **Russia** - Rusya kullanıcıları
- 🇧🇷 **Brazil** - Brezilya kullanıcıları
- 🇨🇦 **Canada** - Kanada kullanıcıları
- 🇦🇺 **Australia** - Avustralya kullanıcıları
- 🇮🇳 **India** - Hindistan kullanıcıları
- Ve daha fazlası...

## 🎨 Dark Theme

Uygulama tam dark theme desteğine sahiptir:
- Ana ekran, harita, chat ve tüm sayfalar
- Dinamik renk değişimi
- Material Design 3 uyumlu
- Göz dostu karanlık renkler

## 🔮 Gelecek Özellikler

- [ ] Machine Learning model training
- [ ] Satellite data integration  
- [ ] Tsunami early warning
- [ ] Building collapse prediction
- [ ] Emergency response coordination
- [ ] Video/ses mesajlaşma
- [ ] Grup chat odaları

## 📄 License

MIT License - see [LICENSE](LICENSE) file for details

---

**⚠️ UYARI**: Bu sistem hayat kurtarıcı teknoloji içermektedir. Production kullanımında maksimum dikkat ve test gereklidir.

**🔬 Bilimsel Not**: Bu P2P erken uyarı sistemi dünyada ilk kez uygulanmaktadır. Algoritmaların sürekli geliştirilmesi planlanmaktadır.
