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
