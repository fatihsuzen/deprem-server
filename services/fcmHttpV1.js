const {google} = require('googleapis');
const axios = require('axios');
const key = require('../depremapp2-ffb95-902319aa6063.json');

const SCOPES = ['https://www.googleapis.com/auth/firebase.messaging'];
const PROJECT_ID = key.project_id;

async function getAccessToken() {
  const jwtClient = new google.auth.JWT();
  jwtClient.email = key.client_email;
  jwtClient.key = key.private_key;
  jwtClient.scopes = SCOPES;
  const tokens = await jwtClient.authorize();
  return tokens.access_token;
}

async function sendFcmHttpV1Notification({ title, body, token, topic, data }) {
  const accessToken = await getAccessToken();
  const url = `https://fcm.googleapis.com/v1/projects/${PROJECT_ID}/messages:send`;

  // FCM data alanındaki tüm değerler string olmalı
  const stringifiedData = {};
  if (data) {
    for (const [key, value] of Object.entries(data)) {
      stringifiedData[key] = value === undefined || value === null ? '' : String(value);
    }
  }
  
  const message = {
    message: {
      data: stringifiedData,
    }
  };
  
  // Her zaman notification alanını ekle
  if (title && body) {
    message.message.notification = {
      title: title,
      body: body
    };
  }

  if (token) message.message.token = token;
  if (topic) message.message.topic = topic;

  console.log('FCM HTTP v1 gönderilen payload:', JSON.stringify(message, null, 2));

  try {
    const res = await axios.post(url, message, {
      headers: {
        'Authorization': `Bearer ${accessToken}`,
        'Content-Type': 'application/json'
      }
    });
    console.log('FCM HTTP v1 yanıt:', res.data);
    return res.data;
  } catch (err) {
    if (err.response) {
      console.error('FCM HTTP v1 hata yanıtı:', err.response.data);
    } else {
      console.error('FCM HTTP v1 hata:', err.message);
    }
    throw err;
  }
}

module.exports = { sendFcmHttpV1Notification };
