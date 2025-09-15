const express = require('express');
const { body, validationResult } = require('express-validator');

const router = express.Router();

// User activity tracking - timeout için
const USER_ACTIVITY = new Map(); // uid -> lastActivity timestamp

// Basit middleware - Firebase gerekmez
const validateUser = (req, res, next) => {
  // HTTP headers lowercase olur - düzgün şekilde oku
  // Flutter'dan x-firebase-uid geliyor, onu kullan
  const uid = req.headers['user-id'] || req.headers['x-firebase-uid'] || req.body.userId || req.query.userId || 'anonymous-' + Date.now();
  const displayName = req.headers['display-name'] || req.body.displayName || req.query.displayName || 'Anonim Kullanıcı';
  
  req.userUID = uid;
  req.displayName = displayName;
  
  // User activity'yi güncelle
  USER_ACTIVITY.set(uid, Date.now());
  
  console.log(`👤 User: ${displayName} (${uid})`);
  console.log(`📋 Headers: user-id=${req.headers['user-id']}, display-name=${req.headers['display-name']}`);
  console.log(`📦 Body: userId=${req.body.userId}, displayName=${req.body.displayName}`);
  console.log(`🔥 Firebase UID: ${req.headers['x-firebase-uid']}`);
  
  next();

};

// Chat room'ları - Global + ülke odaları
const CHAT_ROOMS = {
  'global': {
    id: 'global',
    name: 'Global Chat',
    description: 'Tüm dünyadan kullanıcılarla sohbet edin',
    flag: '🌍',
    activeUsers: new Set(),
    messages: []
  },
  'turkey': {
    id: 'turkey',
    name: 'Türkiye',
    description: 'Türkiye\'den kullanıcılarla sohbet edin',
    flag: '🇹🇷',
    activeUsers: new Set(),
    messages: []
  },
  'usa': {
    id: 'usa',
    name: 'United States',
    description: 'Chat with users from USA',
    flag: '🇺🇸',
    activeUsers: new Set(),
    messages: []
  },
  'germany': {
    id: 'germany',
    name: 'Deutschland',
    description: 'Chat mit Nutzern aus Deutschland',
    flag: '🇩🇪',
    activeUsers: new Set(),
    messages: []
  },
  'france': {
    id: 'france',
    name: 'France',
    description: 'Chattez avec des utilisateurs de France',
    flag: '🇫🇷',
    activeUsers: new Set(),
    messages: []
  },
  'uk': {
    id: 'uk',
    name: 'United Kingdom',
    description: 'Chat with users from UK',
    flag: '🇬🇧',
    activeUsers: new Set(),
    messages: []
  },
  'italy': {
    id: 'italy',
    name: 'Italia',
    description: 'Chatta con utenti dall\'Italia',
    flag: '🇮🇹',
    activeUsers: new Set(),
    messages: []
  },
  'spain': {
    id: 'spain',
    name: 'España',
    description: 'Chatea con usuarios de España',
    flag: '🇪🇸',
    activeUsers: new Set(),
    messages: []
  },
  'japan': {
    id: 'japan',
    name: '日本',
    description: 'Chat with users from Japan',
    flag: '🇯🇵',
    activeUsers: new Set(),
    messages: []
  },
  'korea': {
    id: 'korea',
    name: '대한민국',
    description: 'Chat with users from South Korea',
    flag: '🇰🇷',
    activeUsers: new Set(),
    messages: []
  },
  'china': {
    id: 'china',
    name: '中国',
    description: 'Chat with users from China',
    flag: '🇨🇳',
    activeUsers: new Set(),
    messages: []
  },
  'russia': {
    id: 'russia',
    name: 'Россия',
    description: 'Чат с пользователями из России',
    flag: '🇷🇺',
    activeUsers: new Set(),
    messages: []
  },
  'brazil': {
    id: 'brazil',
    name: 'Brasil',
    description: 'Converse com usuários do Brasil',
    flag: '🇧🇷',
    activeUsers: new Set(),
    messages: []
  },
  'canada': {
    id: 'canada',
    name: 'Canada',
    description: 'Chat with users from Canada',
    flag: '🇨🇦',
    activeUsers: new Set(),
    messages: []
  },
  'australia': {
    id: 'australia',
    name: 'Australia',
    description: 'Chat with users from Australia',
    flag: '🇦🇺',
    activeUsers: new Set(),
    messages: []
  },
  'india': {
    id: 'india',
    name: 'भारत',
    description: 'Chat with users from India',
    flag: '🇮🇳',
    activeUsers: new Set(),
    messages: []
  },
  'mexico': {
    id: 'mexico',
    name: 'México',
    description: 'Chatea con usuarios de México',
    flag: '🇲🇽',
    activeUsers: new Set(),
    messages: []
  },
  'argentina': {
    id: 'argentina',
    name: 'Argentina',
    description: 'Chatea con usuarios de Argentina',
    flag: '🇦🇷',
    activeUsers: new Set(),
    messages: []
  },
  'greece': {
    id: 'greece',
    name: 'Ελλάδα',
    description: 'Συνομιλήστε με χρήστες από την Ελλάδα',
    flag: '🇬🇷',
    activeUsers: new Set(),
    messages: []
  },
  'iran': {
    id: 'iran',
    name: 'ایران',
    description: 'گپ با کاربران ایرانی',
    flag: '🇮🇷',
    activeUsers: new Set(),
    messages: []
  },
  'indonesia': {
    id: 'indonesia',
    name: 'Indonesia',
    description: 'Chat dengan pengguna dari Indonesia',
    flag: '🇮🇩',
    activeUsers: new Set(),
    messages: []
  }
};

// Kullanıcı bilgileri cache (gerçek production'da Redis kullanılabilir)
const userCache = new Map();

// Get all chat rooms with active user counts - Firebase gerekmez
router.get('/rooms', validateUser, async (req, res) => {
  try {
    const roomsData = Object.values(CHAT_ROOMS).map(room => ({
      id: room.id,
      name: room.name,
      description: room.description,
      flag: room.flag,
      activeUserCount: room.activeUsers.size,
      lastMessage: room.messages.length > 0 ? room.messages[room.messages.length - 1] : null
    }));

    console.log('📋 Chat rooms listesi gönderildi');
    
    res.json({
      success: true,
      rooms: roomsData,
      totalRooms: roomsData.length
    });

  } catch (error) {
    console.error('❌ Chat rooms hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Join a chat room
router.post('/rooms/:roomId/join', validateUser, [
  body('displayName').trim().isLength({ min: 1, max: 50 }),
  body('photoURL').optional({ nullable: true }).custom((value) => {
    // Eğer değer varsa ve boş string değilse URL kontrolü yap
    if (value && value.trim() !== '') {
      return /^https?:\/\/.+/.test(value);
    }
    return true;
  })
], async (req, res) => {
  try {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }

    const { roomId } = req.params;
    const { displayName, photoURL } = req.body;
    const uid = req.userUID;

    const room = CHAT_ROOMS[roomId];
    if (!room) {
      return res.status(404).json({ error: 'Chat room bulunamadı' });
    }

    // Kullanıcı bilgilerini cache'e kaydet
    userCache.set(uid, {
      uid,
      displayName,
      photoURL: photoURL || null,
      joinedAt: new Date()
    });

    // Kullanıcıyı odaya ekle
    room.activeUsers.add(uid);

    console.log(`👥 ${displayName} ${room.name} odasına katıldı (${room.activeUsers.size} kişi)`);

    res.json({
      success: true,
      message: `${room.name} odasına katıldınız`,
      room: {
        id: room.id,
        name: room.name,
        description: room.description,
        flag: room.flag,
        activeUserCount: room.activeUsers.size
      }
    });

  } catch (error) {
    console.error('❌ Chat room join hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Leave a chat room
router.post('/rooms/:roomId/leave', validateUser, async (req, res) => {
  try {
    const { roomId } = req.params;
    const uid = req.userUID;

    const room = CHAT_ROOMS[roomId];
    if (!room) {
      return res.status(404).json({ error: 'Chat room bulunamadı' });
    }

    // Kullanıcıyı odadan çıkar
    room.activeUsers.delete(uid);
    
    const user = userCache.get(uid);
    const displayName = user?.displayName || 'Kullanıcı';

    console.log(`👋 ${displayName} ${room.name} odasından ayrıldı (${room.activeUsers.size} kişi)`);

    res.json({
      success: true,
      message: `${room.name} odasından ayrıldınız`,
      activeUserCount: room.activeUsers.size
    });

  } catch (error) {
    console.error('❌ Chat room leave hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Get messages from a chat room
router.get('/rooms/:roomId/messages', validateUser, async (req, res) => {
  try {
    const { roomId } = req.params;
    const limit = parseInt(req.query.limit) || 50;
    const offset = parseInt(req.query.offset) || 0;

    const room = CHAT_ROOMS[roomId];
    if (!room) {
      return res.status(404).json({ error: 'Chat room bulunamadı' });
    }

    // Son mesajları al - reverse yapma, Flutter tarafında hallederiz
    const messages = room.messages
      .slice(-limit - offset, room.messages.length - offset);

    res.json({
      success: true,
      messages,
      totalMessages: room.messages.length,
      room: {
        id: room.id,
        name: room.name,
        flag: room.flag,
        activeUserCount: room.activeUsers.size
      }
    });

  } catch (error) {
    console.error('❌ Chat messages hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Send a message to a chat room
router.post('/rooms/:roomId/messages', validateUser, [
  body('message').trim().isLength({ min: 1, max: 500 }),
  body('displayName').trim().isLength({ min: 1, max: 50 })
], async (req, res) => {
  try {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }

    const { roomId } = req.params;
    const { message, displayName } = req.body;
    const uid = req.userUID;

    const room = CHAT_ROOMS[roomId];
    if (!room) {
      return res.status(404).json({ error: 'Chat room bulunamadı' });
    }

    // Kullanıcının odada olup olmadığını kontrol et
    if (!room.activeUsers.has(uid)) {
      return res.status(403).json({ error: 'Bu odaya üye olmalısınız' });
    }

    // Mesaj objesi oluştur
    const messageObj = {
      id: `msg_${Date.now()}_${uid}`,
      uid,
      displayName,
      message,
      timestamp: new Date().toISOString(),
      roomId
    };

    // Mesajı odaya ekle
    room.messages.push(messageObj);

    // Son 100 mesajı tut (memory tasarrufu için)
    if (room.messages.length > 100) {
      room.messages = room.messages.slice(-100);
    }

    console.log(`💬 ${displayName}: ${message} (${room.name})`);

    res.json({
      success: true,
      message: 'Mesaj gönderildi',
      messageObj
    });

  } catch (error) {
    console.error('❌ Send message hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Get active users in a room
router.get('/rooms/:roomId/users', validateUser, async (req, res) => {
  try {
    const { roomId } = req.params;

    const room = CHAT_ROOMS[roomId];
    if (!room) {
      return res.status(404).json({ error: 'Chat room bulunamadı' });
    }

    // Aktif kullanıcıları al
    const activeUsers = Array.from(room.activeUsers).map(uid => {
      const user = userCache.get(uid);
      return {
        uid,
        displayName: user?.displayName || 'Anonim',
        photoURL: user?.photoURL || null,
        joinedAt: user?.joinedAt || new Date()
      };
    });

    res.json({
      success: true,
      users: activeUsers,
      count: activeUsers.length,
      room: {
        id: room.id,
        name: room.name,
        flag: room.flag
      }
    });

  } catch (error) {
    console.error('❌ Get room users hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Global statistics
router.get('/stats', async (req, res) => {
  try {
    const totalActiveUsers = Object.values(CHAT_ROOMS)
      .reduce((sum, room) => sum + room.activeUsers.size, 0);
    
    const totalMessages = Object.values(CHAT_ROOMS)
      .reduce((sum, room) => sum + room.messages.length, 0);

    const roomStats = Object.values(CHAT_ROOMS).map(room => ({
      id: room.id,
      name: room.name,
      flag: room.flag,
      activeUsers: room.activeUsers.size,
      totalMessages: room.messages.length
    }));

    res.json({
      success: true,
      stats: {
        totalRooms: Object.keys(CHAT_ROOMS).length,
        totalActiveUsers,
        totalMessages,
        roomStats
      }
    });

  } catch (error) {
    console.error('❌ Stats hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Timeout-based user cleanup - inactive kullanıcıları otomatik kaldır
setInterval(() => {
  const now = Date.now();
  const TIMEOUT = 5 * 60 * 1000; // 5 dakika timeout
  let cleanedUsers = 0;

  console.log('🧹 Timeout-based user cleanup başlatıldı...');
  
  // Tüm odalarda timeout olan kullanıcıları temizle
  Object.values(CHAT_ROOMS).forEach(room => {
    const usersToRemove = [];
    
    room.activeUsers.forEach(uid => {
      const lastActivity = USER_ACTIVITY.get(uid);
      if (!lastActivity || (now - lastActivity) > TIMEOUT) {
        usersToRemove.push(uid);
        cleanedUsers++;
      }
    });

    // Timeout olan kullanıcıları kaldır
    usersToRemove.forEach(uid => {
      room.activeUsers.delete(uid);
      USER_ACTIVITY.delete(uid);
      console.log(`⏰ ${uid} timeout nedeniyle ${room.name} odasından kaldırıldı`);
    });
  });

  console.log(`🧹 Cleanup tamamlandı: ${cleanedUsers} kullanıcı kaldırıldı`);
  
  // Güncel durumu göster
  Object.values(CHAT_ROOMS).forEach(room => {
    if (room.activeUsers.size > 0) {
      console.log(`   ${room.name}: ${room.activeUsers.size} aktif kullanıcı`);
    }
  });
}, 2 * 60 * 1000); // Her 2 dakikada bir cleanup

module.exports = router;