const User = require('../models/User');
const geolib = require('geolib');
const { getT } = require('./notificationI18n');

class PriorityNotificationService {
  constructor(notificationService) {
    this.notificationService = notificationService;
    this.isReady = false; // Server başlangıcında bildirim göndermeyi engelle
    this.startupTime = Date.now();
    
    // 10 saniye sonra bildirimleri aktif et (sunucu başlangıcındaki eski depremler için)
    setTimeout(() => {
      this.isReady = true;
      const readyTime = new Date().toLocaleTimeString('tr-TR');
      console.log('\n═══════════════════════════════════════════════════');
      console.log('✅ BİLDİRİM SİSTEMİ AKTİF EDİLDİ');
      console.log('═══════════════════════════════════════════════════');
      console.log(`🕐 Aktif olma zamanı: ${readyTime}`);
      console.log('📢 Deprem bildirimleri artık gönderilecek');
      console.log('🚨 Yeni depremler için kullanıcılara anlık bildirim yapılacak');
      console.log('═══════════════════════════════════════════════════\n');
    }, 10000); // 10000ms = 10 saniye
    
    const startTime = new Date().toLocaleTimeString('tr-TR');
    console.log('\n⏳ Bildirim sistemi başlatıldı - 10 saniye bekleme modunda');
    console.log(`   Başlangıç: ${startTime}`);
  }

  /**
   * Mesafe hesaplama (Haversine formülü)
   */
  calculateDistance(lat1, lon1, lat2, lon2) {
    const R = 6371; // Earth radius in km
    const dLat = this.toRadians(lat2 - lat1);
    const dLon = this.toRadians(lon2 - lon1);
    
    const a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
              Math.cos(this.toRadians(lat1)) * Math.cos(this.toRadians(lat2)) *
              Math.sin(dLon / 2) * Math.sin(dLon / 2);
    
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    
    return R * c; // Distance in km
  }

  toRadians(degrees) {
    return degrees * (Math.PI / 180);
  }

  /**
   * Deprem bildirimi gönder - Mesafeye göre öncelikli
   * @param {Object} earthquake - Deprem bilgileri
   * @param {number} earthquake.lat - Deprem enlemi
   * @param {number} earthquake.lon - Deprem boylamı
   * @param {number} earthquake.magnitude - Deprem büyüklüğü
   * @param {string} earthquake.location - Deprem yeri
   * @param {number} earthquake.depth - Deprem derinliği
   * @param {Date} earthquake.time - Deprem zamanı
   */
  async sendPriorityEarthquakeNotifications(earthquake) {
    try {
      // Server başlangıcından 10 saniye geçmeden bildirim gönderme (eski depremler için)
      if (!this.isReady) {
        const elapsedSeconds = Math.floor((Date.now() - this.startupTime) / 1000);
        console.log(`⏸️  Bildirim sistemi henüz hazır değil (${elapsedSeconds}s geçti, 10s bekleniyor)`);
        console.log(`   Atlanan deprem: M${earthquake.magnitude} - ${earthquake.location}`);
        return {
          success: false,
          message: 'Notification system not ready yet (startup delay)',
          skipped: true
        };
      }
      
      console.log('🚨 Öncelikli bildirim sistemi başlatıldı');
      console.log(`📍 Deprem: M${earthquake.magnitude} - ${earthquake.location}`);
      console.log(`📍 Koordinatlar: ${earthquake.lat}, ${earthquake.lon}`);
      console.log(`📡 Kaynak: ${earthquake.source || 'Unknown'}`);

      // Deprem için benzersiz ID oluştur (duplicate kontrolü için)
      const earthquakeId = this.generateEarthquakeId(earthquake);
      console.log(`🆔 Deprem ID: ${earthquakeId} (0.1° konum + 0.5M tolerans)`);

      // Tüm kullanıcıları al
      const users = await User.find({
        location: { $exists: true },
        'location.coordinates': { $exists: true, $ne: null }
      }).select('uid displayName location notificationSettings deviceTokens');

      if (!users || users.length === 0) {
        console.log('⚠️  Konum bilgisi olan kullanıcı bulunamadı');
        return {
          success: false,
          message: 'No users with location found'
        };
      }

      console.log(`👥 ${users.length} kullanıcı bulundu`);

      // Kullanıcıları mesafeye göre sırala
      const usersWithDistance = users.map(user => {
        const userLat = user.location.coordinates[1]; // GeoJSON: [lon, lat]
        const userLon = user.location.coordinates[0];
        
        const distance = this.calculateDistance(
          earthquake.lat,
          earthquake.lon,
          userLat,
          userLon
        );

        return {
          user,
          distance,
          userLat,
          userLon
        };
      });

      // Yakından uzağa sırala
      usersWithDistance.sort((a, b) => a.distance - b.distance);

      console.log('📊 Mesafe sıralaması:');
      usersWithDistance.slice(0, 5).forEach((item, index) => {
        console.log(`  ${index + 1}. ${item.user.displayName}: ${item.distance.toFixed(2)} km`);
      });

      // Bildirim istatistikleri
      let sentCount = 0;
      let skippedCount = 0;
      let errorCount = 0;

      // Sırayla bildirim gönder (yakından uzağa)
      for (const item of usersWithDistance) {
        const { user, distance, userLat, userLon } = item;

        try {
          // Kullanıcının notification settings kontrolü
          const notificationRadius = user.notificationSettings?.notificationRadius || 100; // Default 100 km
          const minMagnitude = user.notificationSettings?.minMagnitude || 2.5; // Default 2.5
          const maxMagnitude = user.notificationSettings?.maxMagnitude || 10.0; // Default 10.0

          // 1. MESAFE FİLTRESİ: Range dışında mı?
          if (distance > notificationRadius) {
            console.log(`⏭️  ${user.displayName}: ${distance.toFixed(2)} km > ${notificationRadius} km (range dışı)`);
            skippedCount++;
            continue;
          }

          // 2. MAGNITUDE FİLTRESİ: Büyüklük aralığında mı?
          if (earthquake.magnitude < minMagnitude || earthquake.magnitude > maxMagnitude) {
            console.log(`⏭️  ${user.displayName}: M${earthquake.magnitude} (${minMagnitude}-${maxMagnitude} dışında)`);
            skippedCount++;
            continue;
          }

          // 3. DUPLICATE KONTROLÜ: Bu deprem için daha önce bildirim gönderilmiş mi?
          if (user.lastEarthquakeNotification) {
            const lastNotif = user.lastEarthquakeNotification;
            const timeSinceLastNotif = Date.now() - new Date(lastNotif.timestamp).getTime();
            
            // A) Aynı deprem ID'si (coarse-grained match)
            if (lastNotif.earthquakeId === earthquakeId) {
              console.log(`🔁 ${user.displayName}: Duplicate deprem (ID: ${earthquakeId}) - ATLANDI`);
              skippedCount++;
              continue;
            }
            
            // B) 2 dakika içinde benzer deprem (fine-grained match)
            // Farklı kaynaklar (AFAD, Kandilli, USGS, EMSC) 1-3 dakika içinde aynı depremi bildiriyor
            // 2 dakika yeterli - asıl sorun aynı anda 4-6 bildirimin gitmesiydi
            if (timeSinceLastNotif < 2 * 60 * 1000) {
              const lastLat = parseFloat(lastNotif.location?.split(',')[0] || 0);
              const lastLon = parseFloat(lastNotif.location?.split(',')[1] || 0);
              
              // Magnitude farkı (farklı kaynaklar ±0.5 fark verebilir)
              const magDiff = Math.abs(lastNotif.magnitude - earthquake.magnitude);
              
              // Mesafe hesapla (Haversine yerine basit Euclidean - daha hızlı)
              const latDiff = Math.abs(lastLat - earthquake.lat);
              const lonDiff = Math.abs(lastLon - earthquake.lon);
              const approxDistance = Math.sqrt(latDiff * latDiff + lonDiff * lonDiff) * 111; // ~km
              
              // Toleranslar:
              // - 0.3 derece = ~33 km (farklı kaynaklar bu kadar fark verebilir)
              // - Magnitude: ±0.6 (AFAD 5.0, Kandilli 5.3, USGS 4.8 olabilir)
              if (magDiff <= 0.6 && approxDistance <= 35) {
                console.log(`🔁 ${user.displayName}: Benzer deprem (${(timeSinceLastNotif/1000).toFixed(0)}s önce, ΔM=${magDiff.toFixed(1)}, ΔD=${approxDistance.toFixed(1)}km) - ATLANDI`);
                skippedCount++;
                continue;
              }
            }
          }

          // Bildirim gönder
          const distanceText = distance < 1 
            ? `${(distance * 1000).toFixed(0)}m` 
            : `${distance.toFixed(1)}km`;

          const isP2P = earthquake.source === 'P2P' || (earthquake.place && String(earthquake.place).includes('P2P'));
          const regionStr = typeof earthquake.location === 'string'
            ? earthquake.location
            : (earthquake.location?.name || 'Bilinmeyen');

          const lang = user.settings?.language || 'tr';
          const t = getT(lang);

          const notificationData = {
            type: 'earthquake_alert',
            title: isP2P
              ? t.p2pDetected
              : t.earthquakeWarning(distanceText),
            body: isP2P
              ? t.p2pBody(regionStr, parseFloat(earthquake.magnitude).toFixed(1), distanceText)
              : t.earthquakeBody(parseFloat(earthquake.magnitude).toFixed(1), regionStr, parseFloat(earthquake.depth).toFixed(1), distanceText),
            magnitude: String(parseFloat(earthquake.magnitude).toFixed(1)),
            location: `${parseFloat(earthquake.lat)},${parseFloat(earthquake.lon)}`,
            location_str: `${parseFloat(earthquake.lat)},${parseFloat(earthquake.lon)}`,
            region: regionStr,
            depth: String(parseFloat(earthquake.depth).toFixed(1)),
            distance: String(parseFloat(distance).toFixed(1)),
            earthquakeLat: String(parseFloat(earthquake.lat)),
            earthquakeLon: String(parseFloat(earthquake.lon)),
            userLat: String(parseFloat(userLat)),
            userLon: String(parseFloat(userLon)),
            time: String(earthquake.time),
            priority: 'high',
            source: String(earthquake.source || 'AFAD'),
            p2p_circle: isP2P ? 'true' : 'false',
            epicenter_lat: String(parseFloat(earthquake.lat)),
            epicenter_lon: String(parseFloat(earthquake.lon)),
          };

          // FCM token varsa gönder
          if (user.deviceTokens && user.deviceTokens.length > 0) {
            let pushSent = 0;
            const tokensToRemove = []; // Geçersiz token'ları topla
            const { sendFcmHttpV1Notification } = require('./fcmHttpV1');
            for (const tokenObj of user.deviceTokens) {
              // tokenObj: string veya obje olabilir, normalize et
              let token = tokenObj;
              let platform = 'android';
              if (typeof tokenObj === 'object') {
                token = tokenObj.token;
                platform = tokenObj.platform || 'android';
              }
              try {
                if (platform === 'android' || platform === 'ios') {
                  await sendFcmHttpV1Notification({
                    // Her zaman notification göster, priority data içinde
                    title: notificationData.title,
                    body: notificationData.body,
                    token,
                    data: notificationData
                  });
                  pushSent++;
                } else {
                  await this.notificationService.sendPush(token, notificationData);
                  pushSent++;
                }
              } catch (pushErr) {
                console.error(`❌ Push gönderilemedi: ${user.displayName} - Token: ${token} - Hata:`, pushErr.message);
                
                // NOT_FOUND veya UNREGISTERED hatası = geçersiz token, sil
                const errorData = pushErr.response?.data?.error;
                if (errorData && (errorData.code === 404 || errorData.status === 'NOT_FOUND' || 
                    errorData.message?.includes('not registered') || errorData.message?.includes('not found'))) {
                  console.log(`🗑️  Geçersiz token siliniyor: ${token.substring(0, 20)}...`);
                  tokensToRemove.push(token);
                }
              }
            }
            
            // Geçersiz token'ları sil
            if (tokensToRemove.length > 0) {
              try {
                for (const token of tokensToRemove) {
                  await user.removeDeviceToken(token);
                }
                console.log(`✅ ${tokensToRemove.length} geçersiz token silindi: ${user.displayName}`);
              } catch (removeErr) {
                console.error(`⚠️ Token silme hatası: ${removeErr.message}`);
              }
            }
            
            if (pushSent > 0) {
              console.log(`✅ ${user.displayName}: ${distanceText} (bildirim gönderildi)`);
              
              // Son gönderilen deprem bilgisini kaydet (duplicate önleme için)
              user.lastEarthquakeNotification = {
                earthquakeId,
                timestamp: new Date(),
                magnitude: earthquake.magnitude,
                location: `${earthquake.lat},${earthquake.lon}`
              };
              await user.save();
              
              sentCount++;
            } else {
              console.log(`❌ ${user.displayName}: Hiçbir tokena push gönderilemedi`);
              errorCount++;
            }
          } else {
            console.log(`⚠️  ${user.displayName}: Device token yok`);
            skippedCount++;
          }

          // Rate limiting için küçük gecikme
          await this.delay(100);

        } catch (userError) {
          console.error(`❌ ${user.displayName} için bildirim hatası:`, userError.message);
          errorCount++;
        }
      }

      const summary = {
        success: true,
        earthquake: {
          magnitude: earthquake.magnitude,
          location: earthquake.location,
          coordinates: [earthquake.lat, earthquake.lon]
        },
        stats: {
          totalUsers: users.length,
          sent: sentCount,
          skipped: skippedCount,
          errors: errorCount
        },
        closestUsers: usersWithDistance.slice(0, 10).map(item => ({
          name: item.user.displayName,
          distance: item.distance.toFixed(2) + ' km'
        }))
      };

      console.log('\n📈 Bildirim Özeti:');
      console.log(`  ✅ Gönderilen: ${sentCount}`);
      console.log(`  ⏭️  Atlanan: ${skippedCount}`);
      console.log(`  ❌ Hata: ${errorCount}`);
      console.log(`  📊 Toplam: ${users.length} kullanıcı`);

      return summary;

    } catch (error) {
      console.error('❌ Öncelikli bildirim sistemi hatası:', error);
      throw error;
    }
  }

  /**
   * Deprem için benzersiz ID oluştur (duplicate kontrol için)
   * NOT: Farklı kaynaklar (AFAD, Kandilli, USGS) aynı depremi farklı ölçer.
   * Bu yüzden daha esnek toleranslar kullanıyoruz.
   */
  generateEarthquakeId(earthquake) {
    // Konum: 0.1 derece hassasiyet (~11 km tolerans)
    const lat = parseFloat(earthquake.lat).toFixed(1);
    const lon = parseFloat(earthquake.lon).toFixed(1);
    // Magnitude: 0.5 tolerans (M5.0 ile M5.4 aynı sayılır)
    const mag = Math.floor(parseFloat(earthquake.magnitude) * 2) / 2; // 0.5'lik bloklar
    // Zaman: 10 dakikalık bloklar
    const time = Math.floor(new Date(earthquake.time).getTime() / (1000 * 60 * 10));
    
    return `${lat}_${lon}_${mag}_${time}`;
  }

  /**
   * Gecikme fonksiyonu
   */
  delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

  /**
   * Deprem kaynaklarının güvenilirlik önceliği
   * Farklı kaynaklar farklı doğruluk seviyeleri sunar
   */
  getSourcePriority(source) {
    const priorities = {
      'Kandilli': 1,    // Türkiye için en güvenilir
      'AFAD': 2,        // Resmi kaynak
      'USGS': 3,        // Global güvenilir
      'EMSC': 4,        // Avrupa-Akdeniz
      'P2P': 5          // P2P algılama (en düşük öncelik)
    };
    return priorities[source] || 99;
  }

  /**
   * İki deprem objesini karşılaştır ve daha güvenilir olanı seç
   * Farklı kaynaklar aynı depremi farklı ölçer, en doğrusunu seçmeliyiz
   */
  selectBetterEarthquakeData(eq1, eq2) {
    if (!eq1) return eq2;
    if (!eq2) return eq1;

    // Kaynak önceliğine göre seç
    const priority1 = this.getSourcePriority(eq1.source);
    const priority2 = this.getSourcePriority(eq2.source);

    if (priority1 < priority2) {
      console.log(`🔄 Kaynak seçimi: ${eq1.source} (öncelik:${priority1}) > ${eq2.source} (öncelik:${priority2})`);
      return eq1;
    } else if (priority2 < priority1) {
      console.log(`🔄 Kaynak seçimi: ${eq2.source} (öncelik:${priority2}) > ${eq1.source} (öncelik:${priority1})`);
      return eq2;
    }

    // Aynı öncelikte ise, magnitude yüksek olanı seç (genelde daha doğru)
    return eq1.magnitude >= eq2.magnitude ? eq1 : eq2;
  }

  /**
   * Test: En yakın kullanıcıları bul
   */
  async findClosestUsers(lat, lon, limit = 10) {
    try {
      const users = await User.find({
        location: { $exists: true },
        'location.coordinates': { $exists: true, $ne: null }
      }).select('uid displayName location');

      const usersWithDistance = users.map(user => {
        const userLat = user.location.coordinates[1];
        const userLon = user.location.coordinates[0];
        
        const distance = this.calculateDistance(lat, lon, userLat, userLon);

        return {
          uid: user.uid,
          name: user.displayName,
          distance: distance,
          location: [userLat, userLon]
        };
      });

      // Sırala ve limitle
      usersWithDistance.sort((a, b) => a.distance - b.distance);

      return usersWithDistance.slice(0, limit);

    } catch (error) {
      console.error('❌ En yakın kullanıcıları bulma hatası:', error);
      throw error;
    }
  }

  /**
   * Kullanıcı range ayarını güncelle
   */
  async updateUserNotificationRange(uid, radiusKm) {
    try {
      const user = await User.findOne({ uid });
      
      if (!user) {
        throw new Error('Kullanıcı bulunamadı');
      }

      if (!user.notificationSettings) {
        user.notificationSettings = {};
      }

      user.notificationSettings.notificationRadius = radiusKm;
      await user.save();

      console.log(`✅ ${user.displayName} bildirim yarıçapı: ${radiusKm} km`);

      return {
        success: true,
        user: user.displayName,
        radius: radiusKm
      };

    } catch (error) {
      console.error('❌ Range güncelleme hatası:', error);
      throw error;
    }
  }
}

module.exports = PriorityNotificationService;
