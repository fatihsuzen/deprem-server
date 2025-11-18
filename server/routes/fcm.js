// SERVER TARAFINDA - FCM ile deprem bildirimi gönderme
// routes/fcm.js

const express = require('express');
const router = express.Router();
const admin = require('firebase-admin');

// Firebase Admin SDK initialize (tek seferlik)
// NOT: Service account key dosyanız olmalı
// Firebase Console > Project Settings > Service Accounts > Generate New Private Key
/*
const serviceAccount = require('./path/to/serviceAccountKey.json');
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount)
});
*/

// FCM Token kaydetme
router.post('/register', async (req, res) => {
  try {
    const { userId, fcmToken, platform } = req.body;

    if (!userId || !fcmToken) {
      return res.status(400).json({ error: 'userId ve fcmToken gerekli' });
    }

    // Token'ı veritabanına kaydet
    await db.query(
      `INSERT INTO user_fcm_tokens (user_id, fcm_token, platform, updated_at) 
       VALUES (?, ?, ?, NOW())
       ON DUPLICATE KEY UPDATE 
       fcm_token = VALUES(fcm_token),
       platform = VALUES(platform),
       updated_at = NOW()`,
      [userId, fcmToken, platform]
    );

    console.log(`✅ FCM Token kaydedildi - User: ${userId}`);
    res.json({ success: true, message: 'FCM token kaydedildi' });
  } catch (error) {
    console.error('❌ FCM token kaydetme hatası:', error);
    res.status(500).json({ error: 'Token kaydetme hatası' });
  }
});

// Deprem bildirimi gönder (tüm kullanıcılara)
async function sendEarthquakeNotificationToAll(earthquakeData) {
  try {
    const { magnitude, location, lat, lon, depth, time } = earthquakeData;

    console.log(`🚨 FCM Deprem bildirimi gönderiliyor: M${magnitude} - ${location}`);

    // Topic'e mesaj gönder (tüm subscribe olan cihazlar alır)
    const message = {
      topic: 'earthquake_alerts',
      notification: {
        title: `🚨 DEPREM! M${magnitude}`,
        body: `${location} - ŞİMDİ`,
      },
      data: {
        type: 'earthquake',
        magnitude: magnitude.toString(),
        location: location,
        lat: lat.toString(),
        lon: lon.toString(),
        depth: depth.toString(),
        time: time.toString(),
        source: 'AFAD',
      },
      android: {
        priority: 'high',
        notification: {
          channelId: 'earthquake_alerts',
          priority: 'max',
          defaultSound: true,
          defaultVibrateTimings: true,
          visibility: 'public',
          tag: 'earthquake',
          color: '#D32F2F',
        },
      },
      apns: {
        payload: {
          aps: {
            sound: 'default',
            badge: 1,
            contentAvailable: true,
          },
        },
      },
    };

    const response = await admin.messaging().send(message);
    console.log(`✅ FCM mesaj gönderildi: ${response}`);
    
    return { success: true, messageId: response };
  } catch (error) {
    console.error('❌ FCM gönderme hatası:', error);
    return { success: false, error: error.message };
  }
}

// Belirli kullanıcılara deprem bildirimi gönder
async function sendEarthquakeNotificationToUsers(earthquakeData, userTokens) {
  try {
    const { magnitude, location, lat, lon, depth, time, distance } = earthquakeData;

    console.log(`🚨 FCM Deprem bildirimi gönderiliyor: M${magnitude} - ${location} (${userTokens.length} kullanıcı)`);

    const messages = userTokens.map(token => ({
      token: token,
      notification: {
        title: `🚨 DEPREM! M${magnitude}`,
        body: `${location} - ${distance.toFixed(1)} km uzakta`,
      },
      data: {
        type: 'earthquake',
        magnitude: magnitude.toString(),
        location: location,
        lat: lat.toString(),
        lon: lon.toString(),
        depth: depth.toString(),
        time: time.toString(),
        distance: distance.toString(),
        source: 'AFAD',
      },
      android: {
        priority: 'high',
        notification: {
          channelId: 'earthquake_alerts',
          priority: 'max',
          defaultSound: true,
          defaultVibrateTimings: true,
          visibility: 'public',
          tag: 'earthquake',
          color: '#D32F2F',
        },
      },
    }));

    const response = await admin.messaging().sendEach(messages);
    console.log(`✅ FCM mesajları gönderildi: ${response.successCount}/${messages.length}`);
    
    if (response.failureCount > 0) {
      console.log(`❌ Başarısız: ${response.failureCount}`);
      response.responses.forEach((resp, idx) => {
        if (!resp.success) {
          console.log(`   Token ${idx}: ${resp.error?.message}`);
        }
      });
    }
    
    return { 
      success: true, 
      successCount: response.successCount,
      failureCount: response.failureCount 
    };
  } catch (error) {
    console.error('❌ FCM gönderme hatası:', error);
    return { success: false, error: error.message };
  }
}

module.exports = { 
  router, 
  sendEarthquakeNotificationToAll,
  sendEarthquakeNotificationToUsers 
};
