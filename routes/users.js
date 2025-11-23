const express = require('express');
const router = express.Router();
const User = require('../models/User');

// FCM token kaydet
router.post('/fcm-token', async (req, res) => {
  const { userId, fcmToken } = req.body;
  if (!userId || !fcmToken) {
    return res.status(400).json({ error: 'userId ve fcmToken gerekli' });
  }
  try {
    const user = await User.findById(userId);
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }
    if (!user.deviceTokens) user.deviceTokens = [];
    if (!user.deviceTokens.includes(fcmToken)) {
      user.deviceTokens.push(fcmToken);
      await user.save();
    }
    return res.json({ success: true });
  } catch (err) {
    return res.status(500).json({ error: 'Sunucu hatası', details: err });
  }
});

module.exports = router;