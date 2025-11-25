// FCM deprem afişi test scripti
// Kendi sunucu anahtarınızı ve cihaz tokenınızı girin

const axios = require('axios');

const FCM_SERVER_KEY = 'YOUR_FCM_SERVER_KEY'; // Sunucu anahtarı
const DEVICE_TOKEN = 'YOUR_DEVICE_TOKEN'; // Test cihazı tokenı

const payload = {
  to: DEVICE_TOKEN,
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

async function sendFCMTest() {
  try {
    const res = await axios.post('https://fcm.googleapis.com/fcm/send', payload, {
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

sendFCMTest();
