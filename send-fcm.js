const {google} = require('googleapis');
const axios = require('axios');
const key = require('./depremapp2-ffb95-902319aa6063.json');

const SCOPES = ['https://www.googleapis.com/auth/firebase.messaging'];
const PROJECT_ID = 'depremapp2-ffb95';

async function getAccessToken() {
  const jwtClient = new google.auth.JWT(
    key.client_email,
    null,
    key.private_key,
    SCOPES,
    null
  );
  const tokens = await jwtClient.authorize();
  return tokens.access_token;
}

async function sendNotification() {
  const accessToken = await getAccessToken();
  const url = `https://fcm.googleapis.com/v1/projects/${PROJECT_ID}/messages:send`;

  const message = {
    message: {
      topic: 'all',
      notification: {
        title: 'Deprem Uyarısı',
        body: 'Yeni deprem algılandı! Lütfen güvenli bir yere geçin.'
      }
    }
  };

  const res = await axios.post(url, message, {
    headers: {
      'Authorization': `Bearer ${accessToken}`,
      'Content-Type': 'application/json'
    }
  });

  console.log('Bildirim sonucu:', res.data);
}

sendNotification().catch(console.error);