const express = require('express');
const router = express.Router();
const User = require('../models/User');

// Kullanıcı ayarlarını getir
router.get('/:userId', async (req, res) => {
  try {
    const { userId } = req.params;
    
    const user = await User.findById(userId);
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    res.json({
      success: true,
      settings: {
        minMagnitude: user.settings?.minMagnitude || 2.5,
        maxMagnitude: user.settings?.maxMagnitude || 10.0,
        notificationRadius: user.settings?.notificationRadius || 50,
        notificationsEnabled: user.settings?.notificationsEnabled !== false,
        soundEnabled: user.settings?.soundEnabled !== false,
        vibrationEnabled: user.settings?.vibrationEnabled !== false,
        darkMode: user.settings?.darkMode || false,
        language: user.settings?.language || 'tr',
        shareLocationWithFriends: user.settings?.shareLocationWithFriends !== false,
      }
    });
  } catch (error) {
    console.error('Ayarlar getirme hatası:', error);
    res.status(500).json({ error: 'Ayarlar getirilemedi' });
  }
});

// Kullanıcı ayarlarını güncelle
router.post('/:userId', async (req, res) => {
  try {
    const { userId } = req.params;
    const {
      minMagnitude,
      maxMagnitude,
      notificationRadius,
      notificationsEnabled,
      soundEnabled,
      vibrationEnabled,
      darkMode,
      language,
      shareLocationWithFriends
    } = req.body;

    const user = await User.findById(userId);
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    // Settings objesini güncelle
    if (!user.settings) {
      user.settings = {};
    }

    if (minMagnitude !== undefined) user.settings.minMagnitude = minMagnitude;
    if (maxMagnitude !== undefined) user.settings.maxMagnitude = maxMagnitude;
    if (notificationRadius !== undefined) user.settings.notificationRadius = notificationRadius;
    if (notificationsEnabled !== undefined) user.settings.notificationsEnabled = notificationsEnabled;
    if (soundEnabled !== undefined) user.settings.soundEnabled = soundEnabled;
    if (vibrationEnabled !== undefined) user.settings.vibrationEnabled = vibrationEnabled;
    if (darkMode !== undefined) user.settings.darkMode = darkMode;
    if (language !== undefined) user.settings.language = language;
    if (shareLocationWithFriends !== undefined) user.settings.shareLocationWithFriends = shareLocationWithFriends;

    await user.save();

    console.log(`✅ ${user.name} kullanıcısının ayarları güncellendi:`, user.settings);

    res.json({
      success: true,
      message: 'Ayarlar başarıyla güncellendi',
      settings: user.settings
    });
  } catch (error) {
    console.error('Ayarlar güncelleme hatası:', error);
    res.status(500).json({ error: 'Ayarlar güncellenemedi' });
  }
});

// Bildirim ayarlarını toplu güncelle (mevcut LocationUpdateService ile uyumlu)
router.post('/:userId/notification-settings', async (req, res) => {
  try {
    const { userId } = req.params;
    const { notificationRadius, minMagnitude, maxMagnitude, shareLocationWithFriends } = req.body;

    const user = await User.findById(userId);
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    if (!user.settings) {
      user.settings = {};
    }

    if (notificationRadius !== undefined) user.settings.notificationRadius = notificationRadius;
    if (minMagnitude !== undefined) user.settings.minMagnitude = minMagnitude;
    if (maxMagnitude !== undefined) user.settings.maxMagnitude = maxMagnitude;
    if (shareLocationWithFriends !== undefined) user.settings.shareLocationWithFriends = shareLocationWithFriends;

    await user.save();

    console.log(`📱 ${user.name} bildirim ayarları güncellendi:`, {
      radius: user.settings.notificationRadius,
      minMag: user.settings.minMagnitude,
      maxMag: user.settings.maxMagnitude,
      shareLocation: user.settings.shareLocationWithFriends
    });

    res.json({
      success: true,
      message: 'Bildirim ayarları güncellendi',
      settings: user.settings
    });
  } catch (error) {
    console.error('Bildirim ayarları güncelleme hatası:', error);
    res.status(500).json({ error: 'Ayarlar güncellenemedi' });
  }
});

module.exports = router;
