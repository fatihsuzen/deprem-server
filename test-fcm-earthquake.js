// FCM deprem afişi test scripti
const axios = require('axios');
const mongoose = require('mongoose');
const User = require('./models/User');

const FCM_SERVER_KEY = process.env.FCM_SERVER_KEY || 'YOUR_FCM_SERVER_KEY';

async function getActiveDeviceTokens() {
  await mongoose.connect(process.env.MONGO_URI || 'mongodb://localhost/deprem', { useNewUrlParser: true, useUnifiedTopology: true });
  const users = await User.find({ deviceTokens: { $exists: true, $not: { $size: 0 } } }).select('deviceTokens');
  const tokens = [];
  users.forEach(u => {
    if (Array.isArray(u.deviceTokens)) {
      u.deviceTokens.forEach(t => {
        if (typeof t === 'string') tokens.push(t);
        else if (t.token) tokens.push(t.token);
      });
    }
  });
  return tokens;
}

async function sendFCMTest() {
  const tokens = await getActiveDeviceTokens();
  if (tokens.length === 0) return console.log('Aktif cihaz tokenı bulunamadı!');
  const payload = {
    data: {
      type: 'earthquake_alert',
      magnitude: 5.7,
      distance: 473,
      direction: 'S',
      arrival_seconds: 25,
      epicenter_lat: 37.0,
      epicenter_lon: 27.0,
      region: 'Muğla',
      message: 'Deprem M5.7 (tahmini) size 473 km uzaklıkta. 25 saniyede sismik dalga.'
    }
  };
  for (const token of tokens) {
    try {
      const res = await axios.post('https://fcm.googleapis.com/fcm/send', { ...payload, to: token }, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'key=' + FCM_SERVER_KEY
        }
      });
      console.log('FCM yanıtı:', res.data);
    } catch (err) {
      console.error('FCM gönderim hatası:', err.response?.data || err.message);
    }
  }
  mongoose.disconnect();
}

sendFCMTest();
