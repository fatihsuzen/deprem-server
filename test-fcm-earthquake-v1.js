const { GoogleAuth } = require('google-auth-library');
const axios = require('axios');

// Servis hesabı dosya yolunu belirtin
const SERVICE_ACCOUNT_PATH = './depremapp2-ffb95-902319aa6063.json';

// FCM endpoint ve proje id
const FCM_ENDPOINT = 'https://fcm.googleapis.com/v1/projects/depremapp2-ffb95/messages:send';

// Bildirim gönderilecek cihaz tokenı
const DEVICE_TOKEN = 'f3kH3tKpQhOfwroeDYMNGi:APA91bG-hs2YV0o3HOTpdSChm6dVEzriRClBLd7iqgOqfDjvy5UdzY3tYVABl1nRIl8HDxwzG8aGepET0zF_8xZuhi1t2DOpjyvNRkN7W3jZ7W9WGsHe86I';

async function sendFCM() {
  // Servis hesabı kimliği ile Google Auth oluştur
  const auth = new GoogleAuth({
    keyFile: SERVICE_ACCOUNT_PATH,
    scopes: ['https://www.googleapis.com/auth/firebase.messaging'],
  });

  // Access token al
  const client = await auth.getClient();
  const accessToken = await client.getAccessToken();

  // FCM HTTP v1 payload (notification + data)
  const message = {
    message: {
      token: DEVICE_TOKEN,
      notification: {
        title: 'Deprem Uyarısı',
        body: 'Deprem M5.7 (tahmini) size 473 km uzaklıkta. 25 saniyede sismik dalga.'
      },
      data: {
        type: 'earthquake_alert',
        magnitude: '5.7',
        distance: '473',
        direction: 'S',
        arrival_seconds: '25',
        epicenter_lat: '37.0',
        epicenter_lon: '27.0',
        region: 'Muğla',
        message: 'Deprem M5.7 (tahmini) size 473 km uzaklıkta. 25 saniyede sismik dalga.',
        source: 'P2P'
      }
    }
  };

  // FCM'ye POST isteği gönder
  try {
    const res = await axios.post(FCM_ENDPOINT, message, {
      headers: {
        'Authorization': `Bearer ${accessToken.token}`,
        'Content-Type': 'application/json'
      }
    });
    console.log('FCM yanıtı:', res.data);
  } catch (err) {
    console.error('FCM gönderim hatası:', err.response?.data || err.message);
  }
}

sendFCM();
