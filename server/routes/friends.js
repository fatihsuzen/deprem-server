const express = require('express');
const User = require('../models/User');
const FriendRequest = require('../models/FriendRequest');
const { body, validationResult } = require('express-validator');

const router = express.Router();

// Middleware to validate Firebase UID in header
const validateFirebaseUID = (req, res, next) => {
  const uid = req.headers['x-firebase-uid'];
  if (!uid) {
    return res.status(401).json({ error: 'Firebase UID gerekli' });
  }
  req.userUID = uid;
  next();
};

// Get or create user profile
router.post('/profile', validateFirebaseUID, [
  body('email').isEmail().normalizeEmail(),
  body('displayName').trim().isLength({ min: 1, max: 50 }),
  body('photoURL').optional().isURL()
], async (req, res) => {
  try {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }

    const { email, displayName, photoURL } = req.body;
    const uid = req.userUID;

    let user = await User.findOne({ uid });
    
    if (!user) {
      // Create new user
      let shareCode;
      let isUnique = false;
      
      // Generate unique share code
      while (!isUnique) {
        shareCode = User.generateShareCode();
        isUnique = await User.isShareCodeUnique(shareCode);
      }

      user = new User({
        uid,
        email,
        displayName,
        photoURL,
        shareCode
      });
      
      await user.save();
      console.log(`✅ Yeni kullanıcı oluşturuldu: ${email} (${shareCode})`);
    } else {
      // Update existing user
      user.displayName = displayName;
      user.photoURL = photoURL;
      user.updatedAt = new Date();
      await user.save();
      console.log(`✅ Kullanıcı güncellendi: ${email}`);
    }

    res.json({
      success: true,
      user: {
        uid: user.uid,
        email: user.email,
        displayName: user.displayName,
        photoURL: user.photoURL,
        shareCode: user.shareCode,
        friendCount: user.friends.length,
        location: user.location
      }
    });

  } catch (error) {
    console.error('❌ Profile hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Update user location
router.put('/location', validateFirebaseUID, [
  body('latitude').isFloat({ min: -90, max: 90 }),
  body('longitude').isFloat({ min: -180, max: 180 }),
  body('address').optional().trim().isLength({ max: 200 })
], async (req, res) => {
  try {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }

    const { latitude, longitude, address = '' } = req.body;
    const uid = req.userUID;

    const user = await User.findOne({ uid });
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    await user.updateLocation(latitude, longitude, address);
    
    console.log(`📍 Konum güncellendi: ${user.displayName} - ${address}`);

    res.json({
      success: true,
      location: user.location
    });

  } catch (error) {
    console.error('❌ Location update hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Get friends list with locations
router.get('/', validateFirebaseUID, async (req, res) => {
  try {
    const uid = req.userUID;

    const user = await User.findOne({ uid });
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    // Friends field'i UID string'leri içeriyor, manuel olarak user'ları alalım
    const friendUIDs = user.friends || [];
    const friendUsers = await User.find({ uid: { $in: friendUIDs } });

    // Format friends data
    const friends = friendUsers.map(friend => ({
      uid: friend.uid,
      displayName: friend.displayName,
      email: friend.email,
      photoURL: friend.photoURL,
      location: friend.location,
      lastSeen: friend.deviceInfo?.lastSeen,
      isOnline: friend.deviceInfo?.lastSeen && 
                (new Date() - friend.deviceInfo.lastSeen) < 5 * 60 * 1000 // 5 minutes
    }));

    console.log(`👥 ${uid} kullanıcısının ${friends.length} arkadaşı yüklendi`);
    friends.forEach(friend => {
      console.log(`   👤 ${friend.displayName} (${friend.uid})`);
    });

    res.json({
      success: true,
      friends,
      count: friends.length
    });

  } catch (error) {
    console.error('❌ Friends list hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Send friend request by share code
router.post('/friend-request', validateFirebaseUID, [
  body('shareCode').trim().isLength({ min: 6, max: 6 }).toUpperCase(),
  body('message').optional().trim().isLength({ max: 200 })
], async (req, res) => {
  try {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }

    const { shareCode, message = '' } = req.body;
    const fromUserUID = req.userUID;

    // Find target user by share code
    const targetUser = await User.findOne({ shareCode });
    if (!targetUser) {
      return res.status(404).json({ error: 'Bu koda sahip kullanıcı bulunamadı' });
    }

    const toUserUID = targetUser.uid;

    // Check if trying to add themselves
    if (fromUserUID === toUserUID) {
      return res.status(400).json({ error: 'Kendinize arkadaş isteği gönderemezsiniz' });
    }

    // Check if already friends
    const fromUser = await User.findOne({ uid: fromUserUID });
    if (fromUser.friends.includes(toUserUID)) {
      return res.status(400).json({ error: 'Bu kullanıcı zaten arkadaşınız' });
    }

    // Check if request already exists
    const existingRequest = await FriendRequest.requestExists(fromUserUID, toUserUID);
    if (existingRequest) {
      return res.status(400).json({ error: 'Bu kullanıcıya zaten istek gönderilmiş veya sizden istek bekliyor' });
    }

    // Create friend request
    const friendRequest = new FriendRequest({
      fromUser: fromUserUID,
      toUser: toUserUID,
      message
    });

    await friendRequest.save();

    console.log(`📤 Arkadaş isteği gönderildi: ${fromUser.displayName} -> ${targetUser.displayName}`);

    res.json({
      success: true,
      message: 'Arkadaş isteği gönderildi',
      targetUser: {
        displayName: targetUser.displayName,
        email: targetUser.email
      }
    });

  } catch (error) {
    console.error('❌ Friend request hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Get pending friend requests
router.get('/friend-requests', validateFirebaseUID, async (req, res) => {
  try {
    const uid = req.userUID;

    const [pendingRequests, sentRequests] = await Promise.all([
      FriendRequest.getPendingRequests(uid),
      FriendRequest.getSentRequests(uid)
    ]);

    // Manuel olarak kullanıcı bilgilerini al
    const pendingWithUserInfo = await Promise.all(
      pendingRequests.map(async (request) => {
        const fromUser = await User.findOne({ uid: request.fromUser });
        return {
          _id: request._id,
          fromUser: {
            uid: fromUser.uid,
            displayName: fromUser.displayName,
            email: fromUser.email,
            photoURL: fromUser.photoURL
          },
          message: request.message,
          sentAt: request.sentAt,
          status: request.status
        };
      })
    );

    const sentWithUserInfo = await Promise.all(
      sentRequests.map(async (request) => {
        const toUser = await User.findOne({ uid: request.toUser });
        return {
          _id: request._id,
          toUser: {
            uid: toUser.uid,
            displayName: toUser.displayName,
            email: toUser.email,
            photoURL: toUser.photoURL,
            shareCode: toUser.shareCode
          },
          message: request.message,
          sentAt: request.sentAt,
          status: request.status
        };
      })
    );

    res.json({
      success: true,
      pendingRequests: pendingWithUserInfo,
      sentRequests: sentWithUserInfo,
      pendingCount: pendingWithUserInfo.length,
      sentCount: sentWithUserInfo.length
    });

  } catch (error) {
    console.error('❌ Friend requests hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Respond to friend request
router.put('/friend-request/:requestId', validateFirebaseUID, [
  body('action').isIn(['accept', 'reject'])
], async (req, res) => {
  try {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }

    const { requestId } = req.params;
    const { action } = req.body;
    const uid = req.userUID;

    const friendRequest = await FriendRequest.findById(requestId);
    if (!friendRequest) {
      return res.status(404).json({ error: 'İstek bulunamadı' });
    }

    // Check if user is the recipient
    if (friendRequest.toUser !== uid) {
      return res.status(403).json({ error: 'Bu isteği yanıtlama yetkiniz yok' });
    }

    // Check if request is still pending
    if (friendRequest.status !== 'pending') {
      return res.status(400).json({ error: 'Bu istek zaten yanıtlanmış' });
    }

    if (action === 'accept') {
      // Add each other as friends
      await Promise.all([
        User.findOneAndUpdate(
          { uid: friendRequest.fromUser },
          { $addToSet: { friends: friendRequest.toUser } }
        ),
        User.findOneAndUpdate(
          { uid: friendRequest.toUser },
          { $addToSet: { friends: friendRequest.fromUser } }
        )
      ]);

      friendRequest.status = 'accepted';
      console.log(`✅ Arkadaş isteği kabul edildi: ${friendRequest.fromUser} <-> ${friendRequest.toUser}`);
    } else {
      friendRequest.status = 'rejected';
      console.log(`❌ Arkadaş isteği reddedildi: ${friendRequest.fromUser} -> ${friendRequest.toUser}`);
    }

    friendRequest.respondedAt = new Date();
    await friendRequest.save();

    res.json({
      success: true,
      message: action === 'accept' ? 'Arkadaş isteği kabul edildi' : 'Arkadaş isteği reddedildi',
      action
    });

  } catch (error) {
    console.error('❌ Friend request response hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Remove friend
router.delete('/friend/:friendUID', validateFirebaseUID, async (req, res) => {
  try {
    const { friendUID } = req.params;
    const uid = req.userUID;

    // Remove from both users' friend lists
    await Promise.all([
      User.findOneAndUpdate(
        { uid },
        { $pull: { friends: friendUID } }
      ),
      User.findOneAndUpdate(
        { uid: friendUID },
        { $pull: { friends: uid } }
      )
    ]);

    console.log(`🗑️ Arkadaşlık kaldırıldı: ${uid} <-> ${friendUID}`);

    res.json({
      success: true,
      message: 'Arkadaş listesinden kaldırıldı'
    });

  } catch (error) {
    console.error('❌ Remove friend hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Create or update user with Google data
router.post('/users/create-or-update', [
  body('googleId').notEmpty().trim(),
  body('email').isEmail().normalizeEmail(),
  body('displayName').trim().isLength({ min: 1, max: 50 }),
  body('photoURL').optional().isURL(),
  body('shareCode').notEmpty().trim()
], async (req, res) => {
  try {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }

    const { googleId, email, displayName, photoURL, shareCode } = req.body;

    // Mock database için in-memory storage kullan
    if (!global.mockUsers) {
      global.mockUsers = new Map();
    }

    let user = global.mockUsers.get(googleId);
    let isNew = !user;
    
    if (user) {
      // Mevcut kullanıcıyı güncelle
      user.email = email;
      user.displayName = displayName;
      user.photoURL = photoURL || user.photoURL;
      user.shareCode = shareCode;
      user.lastSeen = new Date();
      
      console.log(`✅ Kullanıcı güncellendi: ${displayName} (${shareCode})`);
    } else {
      // Yeni kullanıcı oluştur
      user = {
        uid: googleId,
        email,
        displayName,
        photoURL: photoURL || null,
        shareCode,
        friends: [],
        lastSeen: new Date()
      };
      global.mockUsers.set(googleId, user);
      
      console.log(`🆕 Yeni kullanıcı oluşturuldu: ${displayName} (${shareCode})`);
    }

    res.status(isNew ? 201 : 200).json({
      message: isNew ? 'Kullanıcı oluşturuldu' : 'Kullanıcı güncellendi',
      user: {
        uid: user.uid,
        email: user.email,
        displayName: user.displayName,
        photoURL: user.photoURL,
        shareCode: user.shareCode
      }
    });

  } catch (error) {
    console.error('❌ Kullanıcı kayıt hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Update last seen
router.post('/ping', validateFirebaseUID, async (req, res) => {
  try {
    const uid = req.userUID;

    const user = await User.findOne({ uid });
    if (user) {
      await user.updateLastSeen();
    }

    res.json({ success: true });
  } catch (error) {
    console.error('❌ Ping hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Test arkadaşlık ilişkisi oluştur (geliştirme amaçlı)
router.post('/add-test-friend', validateFirebaseUID, async (req, res) => {
  try {
    const { friendUID } = req.body;
    const currentUserUID = req.userUID;

    if (!friendUID) {
      return res.status(400).json({ error: 'Friend UID gerekli' });
    }

    // İki kullanıcıyı da bul
    const currentUser = await User.findOne({ uid: currentUserUID });
    const friendUser = await User.findOne({ uid: friendUID });

    if (!currentUser) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    if (!friendUser) {
      return res.status(404).json({ error: 'Arkadaş kullanıcı bulunamadı' });
    }

    // Zaten arkadaş olup olmadığını kontrol et
    const isAlreadyFriend = currentUser.friends.some(f => f.uid === friendUID);
    if (!isAlreadyFriend) {
      // Arkadaş ilişkisini iki taraflı kur
      currentUser.friends.push({
        uid: friendUser.uid,
        email: friendUser.email,
        displayName: friendUser.displayName,
        photoURL: friendUser.photoURL,
        addedAt: new Date()
      });

      friendUser.friends.push({
        uid: currentUser.uid,
        email: currentUser.email,
        displayName: currentUser.displayName,
        photoURL: currentUser.photoURL,
        addedAt: new Date()
      });

      await currentUser.save();
      await friendUser.save();

      console.log(`✅ Test arkadaşlığı kuruldu: ${currentUser.displayName} <-> ${friendUser.displayName}`);
    }

    res.json({
      success: true,
      message: 'Test arkadaşlığı başarıyla oluşturuldu',
      currentUser: {
        displayName: currentUser.displayName,
        friendsCount: currentUser.friends.length
      },
      friendUser: {
        displayName: friendUser.displayName,
        friendsCount: friendUser.friends.length
      }
    });

  } catch (error) {
    console.error('❌ Test arkadaşlığı oluşturma hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Add friend by share code
router.post('/add-by-code', validateFirebaseUID, [
  body('shareCode').trim().isLength({ min: 6, max: 6 }).isAlphanumeric()
], async (req, res) => {
  try {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ error: 'Geçersiz share code formatı' });
    }

    const { shareCode } = req.body;
    const currentUserUID = req.userUID;

    console.log(`📤 Arkadaş ekleme isteği: Share Code = ${shareCode}, User = ${currentUserUID}`);

    // Kendi share code'u ile eklemeye çalışıyor mu?
    const currentUser = await User.findOne({ uid: currentUserUID });
    if (!currentUser) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    if (currentUser.shareCode === shareCode) {
      return res.status(400).json({ error: 'Kendi share code\'unuzu ekleyemezsiniz' });
    }

    // Share code'a sahip kullanıcıyı bul
    const targetUser = await User.findOne({ shareCode });
    if (!targetUser) {
      return res.status(404).json({ error: 'Bu share code\'a sahip kullanıcı bulunamadı' });
    }

    // Zaten arkadaş olup olmadığını kontrol et
    const isAlreadyFriend = currentUser.friends.some(f => f.uid === targetUser.uid);
    if (isAlreadyFriend) {
      return res.status(400).json({ error: 'Bu kullanıcı zaten arkadaşınız' });
    }

    // Bekleyen istek var mı kontrol et
    const existingRequest = await FriendRequest.findOne({
      fromUser: currentUser.uid,
      toUser: targetUser.uid,
      status: 'pending'
    });

    if (existingRequest) {
      return res.status(400).json({ error: 'Bu kullanıcıya zaten arkadaşlık isteği gönderilmiş' });
    }

    // Arkadaşlık isteği oluştur
    const friendRequest = new FriendRequest({
      fromUser: currentUser.uid,
      toUser: targetUser.uid,
      message: `${currentUser.displayName} arkadaş olmak istiyor`
    });

    await friendRequest.save();

    console.log(`✅ Arkadaşlık isteği oluşturuldu: ${currentUser.displayName} -> ${targetUser.displayName}`);

    res.json({
      success: true,
      message: `${targetUser.displayName} kullanıcısına arkadaşlık isteği gönderildi`,
      targetUser: {
        displayName: targetUser.displayName,
        shareCode: targetUser.shareCode
      }
    });

  } catch (error) {
    console.error('❌ Share code ile arkadaş ekleme hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Debug: Tüm friend requests'i listele (test için)
router.get('/debug/friend-requests', async (req, res) => {
  try {
    const FriendRequest = require('../models/FriendRequest');
    const allRequests = await FriendRequest.find().lean();
    
    console.log(`🔍 Toplam ${allRequests.length} friend request bulundu:`);
    allRequests.forEach(req => {
      console.log(`   From: ${req.fromUser} → To: ${req.toUser} (${req.status})`);
    });
    
    res.json({
      success: true,
      totalRequests: allRequests.length,
      requests: allRequests
    });

  } catch (error) {
    console.error('❌ Debug friend requests hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Debug: Tüm friend requests'i temizle (test için)
router.delete('/debug/clear-friend-requests', async (req, res) => {
  try {
    const FriendRequest = require('../models/FriendRequest');
    const result = await FriendRequest.deleteMany({});
    
    console.log(`🗑️ ${result.deletedCount} friend request silindi`);
    
    res.json({
      success: true,
      message: `${result.deletedCount} friend request temizlendi`,
      deletedCount: result.deletedCount
    });

  } catch (error) {
    console.error('❌ Clear friend requests hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Debug: GET versiyonu ile friend requests'i temizle (browser test için)
router.get('/debug/clear-friend-requests-get', async (req, res) => {
  try {
    const FriendRequest = require('../models/FriendRequest');
    const result = await FriendRequest.deleteMany({});
    
    console.log(`🗑️ ${result.deletedCount} friend request silindi (GET)`);
    
    res.json({
      success: true,
      message: `${result.deletedCount} friend request temizlendi`,
      deletedCount: result.deletedCount
    });

  } catch (error) {
    console.error('❌ Clear friend requests hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

module.exports = router;
