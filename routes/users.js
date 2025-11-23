const express = require('express');
const router = express.Router();
const User = require('../models/User');

// FCM token kaydet
router.post('/fcm-token', async (req, res) => {
  const { userId, fcmToken } = req.body;
  console.log('FCM token kaydetme isteği geldi:', { userId, fcmToken });
  if (!userId || !fcmToken) {
    return res.status(400).json({ error: 'userId ve fcmToken gerekli' });
  }
  try {
    // Tüm kullanıcıları logla (debug için)
    const allUsers = await User.find({});
    console.log('Veritabanındaki kullanıcılar:', allUsers.map(u => ({ uid: u.uid, email: u.email })));
    const user = await User.findOne({ uid: userId });
    if (!user) {
      console.log('Kullanıcı bulunamadı:', userId);
      return res.status(404).json({ error: 'Kullanıcı bulunamadı', userId });
    }
    if (!user.deviceTokens) user.deviceTokens = [];
    if (!user.deviceTokens.some(dt => dt.token === fcmToken)) {
      user.deviceTokens.push({ token: fcmToken, platform: 'android', addedAt: new Date() });
      await user.save();
      console.log('FCM token başarıyla kaydedildi:', fcmToken);
    } else {
      console.log('FCM token zaten kayıtlı:', fcmToken);
    }
    return res.json({ success: true });
  } catch (err) {
    console.error('FCM token kaydetme sunucu hatası:', err);
    return res.status(500).json({ error: 'Sunucu hatası', details: err });
  }
});

module.exports = router;