const express = require('express');
const router = express.Router();


// Tüm kullanıcılara test bildirimi gönder
const User = require('../models/User');
const pushDispatcher = require('../services/pushDispatcher');

router.post('/send-all', async (req, res) => {
  try {
    // Tüm kullanıcıların cihaz tokenlarını çek
    const users = await User.find({ token: { $exists: true, $ne: null } });
    const deviceEntries = users.map(u => ({ token: u.token, platform: u.platform }));
    const payload = {
      notification: {
        title: req.body.title || 'Deprem Uyarısı',
        body: req.body.body || 'Bölgenizde deprem algılandı!',
      },
      data: req.body.data || { type: 'earthquake' }
    };
    const result = await pushDispatcher.sendPushToDeviceEntries(deviceEntries, payload);
    res.json({ success: true, sent: result.sent });
  } catch (err) {
    res.status(500).json({ success: false, error: err.message });
  }
});

module.exports = { router };
