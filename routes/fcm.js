const express = require('express');
const router = express.Router();

// Tüm cihazları ve tokenları listele (test/debug)
router.get('/list-tokens', async (req, res) => {
  try {
    const Device = require('../models/Device');
    const devices = await Device.find({ token: { $exists: true, $ne: null } });
    res.json({
      count: devices.length,
      tokens: devices.map(d => ({ token: d.token, platform: d.platform, userId: d.userId }))
    });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Tek bir cihaza push bildirimi gönder (test)
router.post('/send-one', async (req, res) => {
  try {
    const Device = require('../models/Device');
    const pushDispatcher = require('../services/pushDispatcher');
    const { token } = req.body;
    if (!token) return res.status(400).json({ error: 'Token gerekli' });

    const device = await Device.findOne({ token });
    if (!device) return res.status(404).json({ error: 'Cihaz bulunamadı' });

    const payload = {
      notification: {
        title: req.body.title || 'Test Bildirimi',
        body: req.body.body || 'Bu bir test mesajıdır'
      },
      data: req.body.data || { type: 'test' }
    };
    const result = await pushDispatcher.sendPushToDeviceEntries([device], payload);
    res.json({ success: true, sent: result.sent });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});


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
