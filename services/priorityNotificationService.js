const User = require('../models/User');
const geolib = require('geolib');

class PriorityNotificationService {
  constructor(notificationService) {
    this.notificationService = notificationService;
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
      console.log('🚨 Öncelikli bildirim sistemi başlatıldı');
      console.log(`📍 Deprem: M${earthquake.magnitude} - ${earthquake.location}`);
      console.log(`📍 Koordinatlar: ${earthquake.lat}, ${earthquake.lon}`);

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

          // Bildirim gönder
          const distanceText = distance < 1 
            ? `${(distance * 1000).toFixed(0)}m` 
            : `${distance.toFixed(1)}km`;

          const notificationData = {
            title: `🚨 DEPREM UYARISI - ${distanceText} uzaklıkta`,
            body: `Büyüklük: ${earthquake.magnitude}mw ${earthquake.location}\n- Derinlik: ${earthquake.depth}km\n- Mesafe: ${distanceText}`,
            magnitude: earthquake.magnitude,
            location: earthquake.location,
            depth: earthquake.depth,
            distance: distance,
            earthquakeLat: earthquake.lat,
            earthquakeLon: earthquake.lon,
            userLat: userLat,
            userLon: userLon,
            time: earthquake.time,
            priority: 'high'
          };

          // FCM token varsa gönder
          if (user.deviceTokens && user.deviceTokens.length > 0) {
            let pushSent = 0;
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
              }
            }
            if (pushSent > 0) {
              console.log(`✅ ${user.displayName}: ${distanceText} (bildirim gönderildi)`);
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
   * Gecikme fonksiyonu
   */
  delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
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
