const express = require('express');
const router = express.Router();

// FCM push notification endpoint örneği
router.post('/send', async (req, res) => {
  // Burada FCM push mantığı olacak
  // Örnek cevap:
  res.json({ success: true, message: 'FCM bildirimi gönderildi (dummy endpoint)' });
});

module.exports = { router };
