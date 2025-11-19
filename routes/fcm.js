const express = require('express');
const router = express.Router();


// Tüm kullanıcılara test bildirimi gönder

const Device = require('../models/Device');
const pushDispatcher = require('../services/pushDispatcher');

router.post('/send-all', async (req, res) => {
  try {
    // Tüm cihazların tokenlarını çek
    const devices = await Device.find({ token: { $exists: true, $ne: null } });
    const deviceEntries = devices.map(d => ({ token: d.token, platform: d.platform }));
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
