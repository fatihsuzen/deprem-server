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

  const message = {
    message: {
      notification: {
        title: title || 'Deprem Uyarısı',
        body: body || 'Yeni deprem algılandı! Lütfen güvenli bir yere geçin.'
      },
      data: data || {},
    }
  };

  if (token) message.message.token = token;
  if (topic) message.message.topic = topic;

  const res = await axios.post(url, message, {
    headers: {
      'Authorization': `Bearer ${accessToken}`,
      'Content-Type': 'application/json'
    }
  });

  return res.data;
}

module.exports = { sendFcmHttpV1Notification };
