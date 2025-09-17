const fs = require('fs');
let admin = null;

try {
  if (process.env.FIREBASE_SERVICE_ACCOUNT_PATH && fs.existsSync(process.env.FIREBASE_SERVICE_ACCOUNT_PATH)) {
    admin = require('firebase-admin');
    const serviceAccount = require(process.env.FIREBASE_SERVICE_ACCOUNT_PATH);
    admin.initializeApp({ credential: admin.credential.cert(serviceAccount) });
    console.log('✅ Firebase Admin initialized for push notifications');
  } else if (process.env.FIREBASE_LEGACY_SERVER_KEY) {
    // We can still use HTTP legacy key path later if needed
    console.log('⚠️ Using legacy server key (set FIREBASE_SERVICE_ACCOUNT_PATH for recommended setup)');
  }
} catch (err) {
  console.error('Firebase admin init error:', err);
  admin = null;
}

class NotificationService {
  constructor(io) {
    this.io = io;
    this.notificationHistory = new Map(); // Store sent notifications
    this.duplicatePrevention = new Map(); // Prevent duplicate notifications
  }

  async broadcastEarlyWarning(earthquakeData) {
    const { epicenter, magnitude, estimatedArrival, affectedRadius } = earthquakeData;
    
    try {
      // Generate unique notification ID
      const notificationId = `eq_${Date.now()}_${Math.round(magnitude * 10)}`;
      
      // Prevent duplicate notifications for same earthquake
      if (this.duplicatePrevention.has(this.getEarthquakeKey(epicenter, magnitude))) {
        console.log('⚠️ Duplicate earthquake notification prevented');
        return;
      }

      // Calculate affected areas
      const affectedAreas = this.calculateAffectedAreas(epicenter, affectedRadius);
      
      // Prepare notification data
      const notification = {
        id: notificationId,
        type: 'earthquake_warning',
        priority: this.calculatePriority(magnitude),
        timestamp: new Date().toISOString(),
        earthquake: {
          epicenter,
          magnitude: parseFloat(magnitude.toFixed(1)),
          depth: '10 km', // Default depth
          estimatedArrival,
          affectedRadius: Math.round(affectedRadius)
        },
        warning: this.generateWarningMessage(magnitude),
        instructions: this.getEmergencyInstructions(magnitude),
        countdown: this.calculateCountdown(estimatedArrival)
      };

      // Broadcast to affected areas
      let totalSent = 0;
      
      for (const area of affectedAreas) {
        const roomName = `geo_${Math.floor(area.lat)}_${Math.floor(area.lon)}`;
        const roomSize = this.io.sockets.adapter.rooms.get(roomName)?.size || 0;
        
        if (roomSize > 0) {
          this.io.to(roomName).emit('earthquake_warning', {
            ...notification,
            localInfo: {
              distance: this.calculateDistance(epicenter, area),
              estimatedIntensity: this.estimateLocalIntensity(magnitude, area.distance),
              localArrivalTime: this.calculateLocalArrival(epicenter, area, estimatedArrival)
            }
          });
          
          totalSent += roomSize;
        }
      }

      // Also send to all connected devices within radius
      this.io.emit('earthquake_check_location', notification);

      // Additionally: P2P / immediate dispatch path
      try {
        // require server at runtime to avoid circular init issues
        const server = require('../server');
        const DeviceModel = require('../models/Device');
        const User = require('../models/User');
        const pushDispatcher = require('./pushDispatcher');

        if (server && server.deviceManager) {
          // Get connected devices in radius from deviceManager
          const devices = server.deviceManager.getDevicesInRadius(
            epicenter.latitude, epicenter.longitude, affectedRadius
          );

          if (devices && devices.length > 0) {
            // Map devices to Device DB entries to obtain tokens and userIds
            const allDeviceEntries = [];
            for (const d of devices) {
              try {
                const deviceEntries = await DeviceModel.find({
                  $or: [ { deviceId: d.deviceId }, { 'location.latitude': d.location.latitude, 'location.longitude': d.location.longitude } ]
                }).lean();
                if (deviceEntries && deviceEntries.length > 0) allDeviceEntries.push(...deviceEntries);
              } catch (err) {
                console.warn('Device DB lookup failed for device', d.deviceId, err.message);
              }
            }

            // Bulk fetch user preferences for unique userIds
            const userIds = Array.from(new Set(allDeviceEntries.map(e => e.userId).filter(Boolean)));
            const users = userIds.length > 0 ? await User.find({ uid: { $in: userIds } }).lean() : [];
            const userMap = new Map(users.map(u => [u.uid, u]));

            // Filter device entries by user preferences
            const finalDeviceEntries = allDeviceEntries.filter(dev => {
              if (!dev.userId) return true; // no user associated, notify by default
              const u = userMap.get(dev.userId);
              if (!u) return true;
              const prefs = u.notificationPreferences || {};
              if (prefs.enabled === false) return false;
              if (typeof prefs.minMagnitude === 'number' && prefs.minMagnitude > (notification.earthquake && notification.earthquake.magnitude ? notification.earthquake.magnitude : 0)) return false;
              return true;
            });

            // Send socket per-device alerts (for connected sockets)
            for (const d of devices) {
              try {
                this.io.to(d.socketId).emit('earthquake_warning', {
                  ...notification,
                  localInfo: {
                    distance: this.calculateDistance(epicenter, d.location),
                    estimatedIntensity: this.estimateLocalIntensity(notification.earthquake.magnitude, d.distance || 0)
                  }
                });
              } catch (err) {
                console.warn('Failed socket emit to', d.socketId, err.message);
              }
            }

            // Send pushes via dispatcher
            if (finalDeviceEntries.length > 0) {
              const payload = {
                title: notification.warning || 'Deprem Uyarısı',
                body: `Bölgenizde M${notification.earthquake.magnitude} depremi tespit edildi`,
                data: {
                  epicenter: JSON.stringify(epicenter),
                  magnitude: String(notification.earthquake.magnitude),
                  id: notification.id
                }
              };

              try {
                const dispatchResult = await pushDispatcher.sendPushToDeviceEntries(finalDeviceEntries, payload, this, { concurrency: 50 });
                console.log('P2P push dispatch result:', dispatchResult);
              } catch (err) {
                console.warn('P2P push dispatch failed:', err.message);
              }
            }
          }
        }
      } catch (err) {
        console.warn('P2P notification path failed:', err.message);
      }

      // Mark as sent to prevent duplicates
      this.duplicatePrevention.set(
        this.getEarthquakeKey(epicenter, magnitude), 
        Date.now()
      );

      // Store in history
      this.notificationHistory.set(notificationId, {
        ...notification,
        sentTo: totalSent,
        sentAt: new Date()
      });

      console.log(`🚨 EARTHQUAKE WARNING BROADCAST - Magnitude: ${magnitude}, Sent to: ${totalSent} devices`);
      console.log(`📍 Epicenter: ${epicenter.latitude}, ${epicenter.longitude}`);
      console.log(`⏰ Estimated arrival: ${estimatedArrival}`);

      // Clean up old duplicate prevention entries (after 10 minutes)
      setTimeout(() => {
        this.duplicatePrevention.delete(this.getEarthquakeKey(epicenter, magnitude));
      }, 10 * 60 * 1000);

      return {
        notificationId,
        sentTo: totalSent,
        affectedAreas: affectedAreas.length
      };

    } catch (error) {
      console.error('Broadcast error:', error);
      throw error;
    }
  }

  async sendTestNotification(targetLocation = null) {
    const testNotification = {
      id: `test_${Date.now()}`,
      type: 'test_notification',
      priority: 'normal',
      timestamp: new Date().toISOString(),
      message: 'Bu bir test bildirimidir',
      earthquake: {
        epicenter: { latitude: 41.0082, longitude: 28.9784 },
        magnitude: 5.2,
        depth: '12 km',
        estimatedArrival: new Date(Date.now() + 30000),
        affectedRadius: 100
      },
      warning: 'TEST: Deprem erken uyarı sistemi çalışıyor',
      instructions: ['Bu bir test mesajıdır', 'Gerçek bir deprem değildir'],
      isTest: true
    };

    if (targetLocation) {
      // Send to specific location
      const roomName = `geo_${Math.floor(targetLocation.lat)}_${Math.floor(targetLocation.lon)}`;
      this.io.to(roomName).emit('test_notification', testNotification);
    } else {
      // Broadcast to all
      this.io.emit('test_notification', testNotification);
    }

    console.log('📱 Test notification sent');
    return testNotification;
  }

  async sendUserAlert(socketId, alertData) {
    try {
      this.io.to(socketId).emit('user_alert', {
        id: `alert_${Date.now()}`,
        type: alertData.type || 'info',
        timestamp: new Date().toISOString(),
        message: alertData.message,
        data: alertData.data || {}
      });

      console.log(`📢 User alert sent to ${socketId}: ${alertData.message}`);
    } catch (error) {
      console.error('User alert error:', error);
    }
  }

  // Send FCM push (if admin initialized)
  async sendPush(token, payload) {
    try {
      if (!admin) {
        // fallback: log
        console.log('Push skipped (firebase-admin not initialized). Token:', token);
        return null;
      }

      const message = {
        token,
        notification: {
          title: payload.title || payload.notification?.title || 'Deprem Uyarısı',
          body: payload.body || payload.notification?.body || (payload.warning || 'Deprem uyarısı')
        },
        data: payload.data || {},
        android: {
          priority: 'high',
          notification: {
            channelId: 'earthquake_alerts',
            clickAction: 'FLUTTER_NOTIFICATION_CLICK'
          }
        },
        apns: {
          headers: {
            'apns-priority': '10'
          },
          payload: {
            aps: {
              alert: {
                title: payload.title || payload.notification?.title || 'Deprem Uyarısı',
                body: payload.body || payload.notification?.body || (payload.warning || 'Deprem uyarısı')
              },
              sound: 'default',
              badge: 1
            }
          }
        }
      };

      const res = await admin.messaging().send(message);
      console.log('FCM send result:', res);
      return res;
    } catch (error) {
      console.error('FCM send error:', error);
      return null;
    }
  }

  calculatePriority(magnitude) {
    if (magnitude >= 7.0) return 'critical';
    if (magnitude >= 5.5) return 'high';
    if (magnitude >= 4.0) return 'medium';
    return 'low';
  }

  generateWarningMessage(magnitude) {
    if (magnitude >= 7.0) {
      return 'ÇOK ŞİDDETLİ DEPREM! Hemen güvenli alana geçin!';
    } else if (magnitude >= 6.0) {
      return 'ŞİDDETLİ DEPREM! Güvenli alana geçin!';
    } else if (magnitude >= 5.0) {
      return 'ORTA ŞİDDETTE DEPREM! Dikkatli olun!';
    } else if (magnitude >= 4.0) {
      return 'HAFIF DEPREM tespit edildi.';
    }
    return 'Sismik aktivite tespit edildi.';
  }

  getEmergencyInstructions(magnitude) {
    const baseInstructions = [
      'Sakin olun, panik yapmayın',
      'Eğer içerideyseniz masa altına saklanın',
      'Camlardan ve düşebilecek objelerden uzak durun'
    ];

    if (magnitude >= 6.0) {
      return [
        ...baseInstructions,
        'Sarsıntı durduğunda dışarı çıkmaya çalışın',
        'Asansör kullanmayın',
        'Merdivenlerden dikkatli inin',
        'Açık alana geçin'
      ];
    } else if (magnitude >= 5.0) {
      return [
        ...baseInstructions,
        'Sarsıntı bitene kadar bekleyin',
        'Elektrik ve gazı kapatın'
      ];
    }

    return baseInstructions;
  }

  calculateCountdown(estimatedArrival) {
    const now = new Date();
    const arrival = new Date(estimatedArrival);
    const diffSeconds = Math.max(0, Math.floor((arrival - now) / 1000));
    
    return {
      seconds: diffSeconds,
      text: diffSeconds > 0 ? `${diffSeconds} saniye içinde ulaşacak` : 'Sarsıntı başladı'
    };
  }

  calculateAffectedAreas(epicenter, radius) {
    const areas = [];
    const gridSize = 0.5; // 0.5 degree grid
    const radiusDegrees = radius / 111; // Rough km to degrees conversion

    for (let lat = epicenter.latitude - radiusDegrees; 
         lat <= epicenter.latitude + radiusDegrees; 
         lat += gridSize) {
      for (let lon = epicenter.longitude - radiusDegrees; 
           lon <= epicenter.longitude + radiusDegrees; 
           lon += gridSize) {
        
        const distance = this.calculateDistance(epicenter, { latitude: lat, longitude: lon });
        
        if (distance <= radius) {
          areas.push({
            lat: parseFloat(lat.toFixed(1)),
            lon: parseFloat(lon.toFixed(1)),
            distance: Math.round(distance)
          });
        }
      }
    }

    return areas;
  }

  calculateDistance(point1, point2) {
    const R = 6371; // Earth's radius in km
    const dLat = this.toRadians(point2.latitude - point1.latitude);
    const dLon = this.toRadians(point2.longitude - point1.longitude);
    
    const a = Math.sin(dLat/2) * Math.sin(dLat/2) +
              Math.cos(this.toRadians(point1.latitude)) * Math.cos(this.toRadians(point2.latitude)) *
              Math.sin(dLon/2) * Math.sin(dLon/2);
    
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    
    return R * c;
  }

  estimateLocalIntensity(magnitude, distance) {
    // Simplified intensity calculation based on magnitude and distance
    const baseIntensity = magnitude;
    const distanceAttenuation = Math.log10(Math.max(1, distance)) * 0.5;
    return Math.max(1, baseIntensity - distanceAttenuation);
  }

  calculateLocalArrival(epicenter, area, baseArrival) {
    const distance = this.calculateDistance(epicenter, area);
    const sWaveSpeed = 3.5; // km/s
    const additionalDelay = (distance / sWaveSpeed) * 1000; // milliseconds
    
    return new Date(new Date(baseArrival).getTime() + additionalDelay);
  }

  toRadians(degrees) {
    return degrees * (Math.PI / 180);
  }

  getEarthquakeKey(epicenter, magnitude) {
    // Create unique key for earthquake to prevent duplicates
    return `${epicenter.latitude.toFixed(2)}_${epicenter.longitude.toFixed(2)}_${magnitude.toFixed(1)}`;
  }

  // Statistics and monitoring
  getNotificationStats() {
    return {
      totalSent: this.notificationHistory.size,
      recentNotifications: Array.from(this.notificationHistory.values())
        .sort((a, b) => b.sentAt - a.sentAt)
        .slice(0, 10),
      duplicatesPrevented: this.duplicatePrevention.size
    };
  }

  // Cleanup old notifications (call periodically)
  cleanupOldNotifications() {
    const oneHourAgo = Date.now() - (60 * 60 * 1000);
    
    for (const [id, notification] of this.notificationHistory.entries()) {
      if (notification.sentAt.getTime() < oneHourAgo) {
        this.notificationHistory.delete(id);
      }
    }
  }
}

module.exports = NotificationService;
