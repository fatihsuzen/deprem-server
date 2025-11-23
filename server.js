
const express = require('express');
const http = require('http');
const socketIo = require('socket.io');
const cors = require('cors');
const helmet = require('helmet');
const compression = require('compression');
const cron = require('node-cron');
require('dotenv').config();

const EarthquakeMonitor = require('./services/earthquakeMonitor');
const DeviceManager = require('./services/deviceManager');
const GeoService = require('./services/geoService');
const NotificationService = require('./services/notificationService');
const PriorityNotificationService = require('./services/priorityNotificationService');
const P2PEarthquakeAnalyzer = require('./services/p2pEarthquakeAnalyzer');
const ValidationService = require('./services/validationService');
const databaseService = require('./services/databaseService');

// Models
const User = require('./models/User');
const FriendRequest = require('./models/FriendRequest');
const Device = require('./models/Device');

// Routes
const friendsRoutes = require('./routes/friends');
const chatRoutes = require('./routes/chat');
const earthquakesRoutes = require('./routes/earthquakes');
const usersRouter = require('./routes/users');

const app = express();
const server = http.createServer(app);
app.use(express.json());
app.use('/api/users', usersRouter);
const io = socketIo(server, {
  cors: {
    origin: "*",
    methods: ["GET", "POST"]
  },
  pingTimeout: 60000,
  pingInterval: 25000
});

// Admin: Tüm kullanıcıların OneSignal ID listesini döndür
app.get('/api/admin/onesignal-ids', async (req, res) => {
  try {
    const User = require('./models/User');
    const users = await User.find({ onesignalId: { $ne: null } }).select('onesignalId');
    const ids = users.map(u => u.onesignalId);
    res.json(ids);
  } catch (error) {
    console.error('❌ OneSignal ID listesi hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});
// OneSignal ID kaydetme endpointi
app.post('/api/users/onesignal-id', async (req, res) => {
  try {
    const { userId, onesignalId } = req.body;
    if (!userId || !onesignalId) {
      return res.status(400).json({ error: 'userId ve onesignalId gerekli' });
    }
    const User = require('./models/User');
    const user = await User.findOne({ uid: userId });
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }
    user.onesignalId = onesignalId;
    await user.save();
    console.log(`✅ OneSignal ID kaydedildi: ${user.displayName} (${onesignalId})`);
    res.json({ success: true });
  } catch (error) {
    console.error('❌ OneSignal ID kaydetme hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Middleware
app.use(helmet({
  contentSecurityPolicy: false, // Monitoring sayfası için
}));
app.use(compression());
app.use(cors());
app.use(express.json({ limit: '50mb' }));
app.use(express.urlencoded({ extended: true, limit: '50mb' }));

// Static files for monitoring dashboard
app.use(express.static('public'));

// Routes
const settingsRoutes = require('./routes/settings');
const { router: fcmRoutes } = require('./routes/fcm');
app.use('/api/friends', friendsRoutes);
app.use('/api/chat', chatRoutes);
app.use('/api/earthquakes', earthquakesRoutes);
app.use('/api/settings', settingsRoutes);
  app.use('/fcm', fcmRoutes);

// User routes for location updates
app.post('/api/users/update-location', async (req, res) => {
    console.log('--- [DEBUG] /api/users/update-location ---');
    console.log('Headers:', JSON.stringify(req.headers, null, 2));
    console.log('Body:', JSON.stringify(req.body, null, 2));
    console.log('Gelen UID header sunucu:', req.headers['x-firebase-uid'], 'Body userId:', req.body.userId);
  try {
      const { latitude, longitude, address, notificationRadius, minMagnitude, maxMagnitude, uid, fcmToken, platform } = req.body;
    const userUid = req.headers['x-firebase-uid'] || uid;

    if (!userUid) {
      return res.status(401).json({ error: 'Firebase UID gerekli' });
    }

    if (!latitude || !longitude) {
      return res.status(400).json({ error: 'Latitude ve longitude gerekli' });
    }

    // Koordinat validasyonu
    if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
      return res.status(400).json({ error: 'Geçersiz koordinatlar' });
    }

    const User = require('./models/User');
    console.log('Aranan UID:', userUid);
    const user = await User.findOne({ uid: userUid });
    console.log('Bulunan user:', user);
    
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    await user.updateLocation(latitude, longitude, address || '');

    // FCM token kaydetme
      if (fcmToken) {
        if (!user.deviceTokens) user.deviceTokens = [];
        if (!user.deviceTokens.some(dt => dt.token === fcmToken)) {
          user.deviceTokens.push({ token: fcmToken, platform: platform || 'android', addedAt: new Date() });
          await user.save();
          console.log('FCM token başarıyla kaydedildi (update-location):', fcmToken);
        } else {
          console.log('FCM token zaten kayıtlı (update-location):', fcmToken);
        }
    }

    // Bildirim ayarlarını da güncelle (eğer gönderildiyse)
    if (notificationRadius !== undefined || minMagnitude !== undefined || maxMagnitude !== undefined) {
      if (!user.notificationSettings) {
        user.notificationSettings = {};
      }
      if (notificationRadius !== undefined) user.notificationSettings.notificationRadius = notificationRadius;
      if (minMagnitude !== undefined) user.notificationSettings.minMagnitude = minMagnitude;
      if (maxMagnitude !== undefined) user.notificationSettings.maxMagnitude = maxMagnitude;
      await user.save();
      console.log(`⚙️  Bildirim ayarları güncellendi: ${user.displayName} - ${notificationRadius}km, M${minMagnitude}-${maxMagnitude}`);
    }

    console.log(`📍 Konum güncellendi: ${user.displayName} - ${latitude}, ${longitude}`);

    res.json({
      success: true,
      location: {
        latitude,
        longitude,
        address: address || '',
        lastUpdate: user.location.lastUpdate
      },
      notificationSettings: user.notificationSettings
    });

  } catch (error) {
    console.error('❌ Location update hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// User notification settings update
app.post('/api/users/notification-settings', async (req, res) => {
  try {
    const { notificationRadius, minMagnitude, maxMagnitude } = req.body;
    const uid = req.headers['x-firebase-uid'];

    if (!uid) {
      return res.status(401).json({ error: 'Firebase UID gerekli' });
    }

    const User = require('./models/User');
    const user = await User.findOne({ uid });
    
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    // Ayarları güncelle
    if (!user.notificationSettings) {
      user.notificationSettings = {};
    }

    if (notificationRadius !== undefined) {
      user.notificationSettings.notificationRadius = notificationRadius;
    }
    if (minMagnitude !== undefined) {
      user.notificationSettings.minMagnitude = minMagnitude;
    }
    if (maxMagnitude !== undefined) {
      user.notificationSettings.maxMagnitude = maxMagnitude;
    }

    await user.save();
    
    console.log(`⚙️  Bildirim ayarları güncellendi: ${user.displayName}`);
    console.log(`   Yarıçap: ${user.notificationSettings.notificationRadius} km`);
    console.log(`   Büyüklük: ${user.notificationSettings.minMagnitude}-${user.notificationSettings.maxMagnitude}`);

    res.json({
      success: true,
      settings: user.notificationSettings
    });

  } catch (error) {
    console.error('❌ Notification settings update hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Get user info and settings
app.get('/api/users/me', async (req, res) => {
  try {
    const uid = req.headers['x-firebase-uid'];

    if (!uid) {
      return res.status(401).json({ error: 'Firebase UID gerekli' });
    }

    const User = require('./models/User');
    const user = await User.findOne({ uid });
    
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    res.json({
      success: true,
      user: {
        uid: user.uid,
        displayName: user.displayName,
        email: user.email,
        location: user.location,
        notificationSettings: user.notificationSettings || {
          notificationRadius: 100,
          minMagnitude: 2.5,
          maxMagnitude: 9.7,
        },
        lastLocationUpdate: user.lastLocationUpdate,
      }
    });

  } catch (error) {
    console.error('❌ User info hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Get all users with their settings (for monitoring)
app.get('/api/users/all-settings', async (req, res) => {
  try {
    const User = require('./models/User');
    const users = await User.find({})
      .select('displayName email location notificationSettings settings createdAt')
      .sort({ 'location.lastUpdate': -1 })
      .limit(100);

    const userList = users.map(user => {
      const userData = {
        name: user.displayName,
        email: user.email,
        location: user.location?.coordinates ? {
          lat: user.location.coordinates[1],
          lon: user.location.coordinates[0],
          lastUpdate: user.location.lastUpdate
        } : null,
        notificationSettings: user.notificationSettings || user.settings || {
          notificationRadius: 100,
          minMagnitude: 2.5,
          maxMagnitude: 9.7
        },
        createdAt: user.createdAt
      };
      
      // DEBUG: Her kullanıcının ayarlarını logla
      console.log(`📊 ${user.displayName}: notificationSettings =`, JSON.stringify(user.notificationSettings));
      
      return userData;
    });

    res.json({
      success: true,
      count: userList.length,
      users: userList
    });

  } catch (error) {
    console.error('❌ Users list hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Add device token
app.post('/api/users/device-token', async (req, res) => {
  try {
    const { token, platform } = req.body;
    const uid = req.headers['x-firebase-uid'];

    if (!uid) {
      return res.status(401).json({ error: 'Firebase UID gerekli' });
    }

    if (!token) {
      return res.status(400).json({ error: 'Device token gerekli' });
    }

    const User = require('./models/User');
    const user = await User.findOne({ uid });
    
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    await user.addDeviceToken(token, platform || 'unknown');
    
    console.log(`📱 Device token eklendi: ${user.displayName} (${platform})`);

    res.json({
      success: true,
      message: 'Device token kaydedildi'
    });

  } catch (error) {
    console.error('❌ Device token hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Test: Öncelikli bildirim gönder
app.post('/api/test/priority-notification', async (req, res) => {
  try {
    const { lat, lon, magnitude, location, depth } = req.body;

    if (!lat || !lon || !magnitude || !location) {
      return res.status(400).json({ error: 'lat, lon, magnitude, location gerekli' });
    }

    const earthquake = {
      lat: parseFloat(lat),
      lon: parseFloat(lon),
      magnitude: parseFloat(magnitude),
      location,
      depth: depth || 10,
      time: new Date()
    };

    console.log('🧪 Test bildirimi başlatılıyor...');
    const result = await priorityNotificationService.sendPriorityEarthquakeNotifications(earthquake);

    res.json(result);

  } catch (error) {
    console.error('❌ Test bildirim hatası:', error);
    res.status(500).json({ error: error.message });
  }
});

// P2P Shake Report Endpoint
app.post('/api/p2p/shake-report', async (req, res) => {
  try {
    const report = req.body;
    
    // Validasyon
    if (!report.location || !report.sensorData) {
      return res.status(400).json({ error: 'Geçersiz rapor formatı' });
    }
    
    console.log(`📥 P2P Rapor alındı: ${report.userId || 'Unknown'}`);
    
    // Analiz et
    const result = await p2pEarthquakeAnalyzer.processShakeReport(report);
    
    res.json(result);
    
  } catch (error) {
    console.error('❌ P2P rapor hatası:', error);
    res.status(500).json({ error: error.message });
  }
});

// P2P Statistics Endpoint
app.get('/api/p2p/statistics', (req, res) => {
  try {
    const stats = p2pEarthquakeAnalyzer.getStatistics();
    res.json({
      success: true,
      statistics: stats
    });
  } catch (error) {
    console.error('❌ P2P istatistik hatası:', error);
    res.status(500).json({ error: error.message });
  }
});

// P2P Stats (kısa yol)
app.get('/api/p2p/stats', (req, res) => {
  try {
    const stats = p2pEarthquakeAnalyzer.getStatistics();
    res.json(stats);
  } catch (error) {
    console.error('❌ P2P istatistik hatası:', error);
    res.status(500).json({ error: error.message });
  }
});

// Register user endpoint
app.post('/api/register', async (req, res) => {
  try {
    const { firebaseUid, email, displayName, shareCode } = req.body;

    if (!firebaseUid || !email || !displayName || !shareCode) {
      return res.status(400).json({ error: 'Tüm alanlar gerekli' });
    }

    const User = require('./models/User');
    let user = await User.findOne({ uid: firebaseUid });
    
    if (!user) {
      user = new User({
        uid: firebaseUid,
        email,
        displayName,
        shareCode
      });
      await user.save();
      console.log(`✅ Yeni kullanıcı oluşturuldu: ${displayName} (${shareCode})`);
    } else {
      user.displayName = displayName;
      user.shareCode = shareCode;
      user.updatedAt = new Date();
      await user.save();
      console.log(`✅ Kullanıcı güncellendi: ${displayName} (${shareCode})`);
    }

    res.json({
      success: true,
      user: {
        uid: user.uid,
        email: user.email,
        displayName: user.displayName,
        shareCode: user.shareCode
      }
    });

  } catch (error) {
    console.error('❌ Register hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Admin endpoint: Get all users with location data
app.get('/api/admin/users', async (req, res) => {
  try {
    const User = require('./models/User');
    const users = await User.find({})
      .select('uid displayName email location notificationSettings createdAt')
      .sort({ 'location.lastUpdate': -1 })
      .limit(100);
    
    res.json({
      success: true,
      users: users,
      count: users.length
    });
  } catch (error) {
    console.error('❌ Kullanıcı listesi hatası:', error);
    res.status(500).json({ error: error.message });
  }
});

// Admin endpoint: Get system statistics
app.get('/api/admin/stats', async (req, res) => {
  try {
    const User = require('./models/User');
    const Earthquake = require('./models/Earthquake');
    
    const [userCount, earthquakeCount, usersWithLocation] = await Promise.all([
      User.countDocuments(),
      Earthquake.countDocuments(),
      User.countDocuments({ 'location.coordinates': { $ne: null } })
    ]);
    
    res.json({
      success: true,
      stats: {
        totalUsers: userCount,
        totalEarthquakes: earthquakeCount,
        usersWithLocation: usersWithLocation,
        activeConnections: io.engine.clientsCount || 0
      }
    });
  } catch (error) {
    console.error('❌ İstatistik hatası:', error);
    res.status(500).json({ error: error.message });
  }
});

// Monitoring dashboard route
app.get('/monitor', (req, res) => {
  res.sendFile(__dirname + '/public/monitor.html');
});

// Health check endpoint
app.get('/health', (req, res) => {
  res.json({
    status: 'OK',
    timestamp: new Date().toISOString(),
    database: databaseService.getConnectionStatus(),
    uptime: process.uptime()
  });
});

// Global services
const earthquakeMonitor = new EarthquakeMonitor();
const deviceManager = new DeviceManager();
const geoService = new GeoService();
const notificationService = new NotificationService(io);
const priorityNotificationService = new PriorityNotificationService(notificationService);
const p2pEarthquakeAnalyzer = new P2PEarthquakeAnalyzer();
const validationService = new ValidationService();

// Set earthquakeMonitor in routes after initialization
earthquakesRoutes.setEarthquakeMonitor(earthquakeMonitor);
console.log('✅ earthquakeMonitor injected into earthquakes routes');

// Socket.io Connection Handler
io.on('connection', (socket) => {
  console.log(`📱 Client connected: ${socket.id}`);

  // Device Registration
  socket.on('register_device', async (data) => {
    try {
      const { deviceId, latitude, longitude, deviceInfo } = data;
      
      await deviceManager.registerDevice({
        socketId: socket.id,
        deviceId,
        latitude,
        longitude,
        deviceInfo,
        lastSeen: new Date()
      });

      socket.join(`geo_${Math.floor(latitude)}_${Math.floor(longitude)}`);
      
      socket.emit('registration_success', {
        message: 'Device registered successfully',
        serverId: socket.id
      });

      console.log(`✅ Device registered: ${deviceId} at (${latitude}, ${longitude})`);
    } catch (error) {
      console.error('Device registration error:', error);
      socket.emit('registration_error', { message: 'Registration failed' });
    }
  });

  // Jiroskop Data Reception (Critical for P2P Early Warning)
  socket.on('seismic_data', async (data) => {
    try {
      const { deviceId, accelerometer, gyroscope, timestamp, location } = data;
      
      // Real-time validation
      const isEarthquakePattern = await validationService.analyzeSeismicData({
        deviceId,
        accelerometer,
        gyroscope,
        timestamp,
        location
      });

      if (isEarthquakePattern.isPotentialEarthquake) {
        console.log(`🚨 Potential earthquake detected by device: ${deviceId}`);
        
        // Multi-device validation
        const validation = await validationService.crossValidateEarthquake({
          location,
          magnitude: isEarthquakePattern.estimatedMagnitude,
          deviceId
        });

        if (validation.isConfirmed) {
          console.log(`🔥 EARTHQUAKE CONFIRMED - Broadcasting early warning!`);
          
          // Instant broadcast to affected area
          await notificationService.broadcastEarlyWarning({
            epicenter: validation.epicenter,
            magnitude: validation.magnitude,
            estimatedArrival: validation.sWaveArrivalTime,
            affectedRadius: validation.affectedRadius
          });
        }
      }

      // Store seismic data for ML training
      await deviceManager.storeSeismicData(data);

    } catch (error) {
      console.error('Seismic data processing error:', error);
    }
  });

  // User Earthquake Report
  socket.on('user_report', async (data) => {
    try {
      const { deviceId, location, intensity, description, timestamp } = data;
      
      await deviceManager.storeUserReport({
        deviceId,
        location,
        intensity,
        description,
        timestamp,
        socketId: socket.id
      });

      console.log(`📝 User report received from ${deviceId}: Intensity ${intensity}`);
      
      socket.emit('report_received', { 
        message: 'Report received successfully',
        reportId: Date.now()
      });

    } catch (error) {
      console.error('User report error:', error);
    }
  });

  // Heartbeat
  socket.on('heartbeat', async (data) => {
    const { deviceId, location } = data;
    await deviceManager.updateDeviceHeartbeat(deviceId, location);
    socket.emit('heartbeat_ack', { timestamp: Date.now() });
  });

  // Disconnection
  socket.on('disconnect', () => {
    console.log(`📱 Client disconnected: ${socket.id}`);
    deviceManager.removeDevice(socket.id);
  });
});

// REST API Endpoints
app.get('/api/health', (req, res) => {
  res.json({
    status: 'OK',
    timestamp: new Date(),
    connectedDevices: deviceManager.getDeviceCount(),
    uptime: process.uptime()
  });
});

// Arkadaş ekleme API'si
app.post('/api/friends/send-request', async (req, res) => {
  try {
    const { fromUserId, toUserShareCode, message } = req.body;
    
    if (!fromUserId || !toUserShareCode) {
      return res.status(400).json({ error: 'fromUserId ve toUserShareCode gerekli' });
    }

    // Share code ile kullanıcıyı bul
    const toUser = await User.findOne({ shareCode: toUserShareCode });
    if (!toUser) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    // Kendi kendine arkadaş eklemeyi engelle
    if (fromUserId === toUser._id.toString()) {
      return res.status(400).json({ error: 'Kendi kendinize arkadaş olamazsınız' });
    }

    // Zaten arkadaş mı kontrol et
    const fromUser = await User.findById(fromUserId);
    if (fromUser.friends && fromUser.friends.includes(toUser._id)) {
      return res.status(400).json({ error: 'Zaten arkadaşsınız' });
    }

    // Zaten istek gönderilmiş mi kontrol et
    const existingRequest = await FriendRequest.findOne({
      fromUser: fromUserId,
      toUser: toUser._id,
      status: 'pending'
    });

    if (existingRequest) {
      return res.status(400).json({ error: 'Zaten arkadaşlık isteği gönderilmiş' });
    }

    // Yeni arkadaş isteği oluştur
    const friendRequest = new FriendRequest({
      fromUser: fromUserId,
      toUser: toUser._id,
      message: message || 'Arkadaş olmak istiyor',
      status: 'pending',
      createdAt: new Date()
    });

    await friendRequest.save();
    
    console.log(`✅ Arkadaşlık isteği gönderildi: ${fromUserId} -> ${toUser._id}`);
    res.json({ 
      success: true, 
      message: 'Arkadaşlık isteği gönderildi',
      requestId: friendRequest._id
    });
    
  } catch (error) {
    console.error('❌ Arkadaş ekleme hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// User notification preferences
app.get('/api/users/:userId/notification-preferences', async (req, res) => {
  try {
    const { userId } = req.params;
    const user = await User.findOne({ uid: userId }).lean();
    if (!user) return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    res.json({ success: true, preferences: user.notificationPreferences || {} });
  } catch (error) {
    console.error('❌ Get notification prefs error:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

app.post('/api/users/:userId/notification-preferences', async (req, res) => {
  try {
    const { userId } = req.params;
    const { enabled, radiusKm, minMagnitude } = req.body;

    const user = await User.findOne({ uid: userId });
    if (!user) return res.status(404).json({ error: 'Kullanıcı bulunamadı' });

    user.notificationPreferences = user.notificationPreferences || {};
    if (typeof enabled === 'boolean') user.notificationPreferences.enabled = enabled;
    if (typeof radiusKm === 'number') user.notificationPreferences.radiusKm = radiusKm;
    if (typeof minMagnitude === 'number') user.notificationPreferences.minMagnitude = minMagnitude;

    await user.save();
    res.json({ success: true, preferences: user.notificationPreferences });
  } catch (error) {
    console.error('❌ Update notification prefs error:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Arkadaş isteklerini kabul/reddet
app.post('/api/friends/respond-request', async (req, res) => {
  try {
    const { requestId, response, userId } = req.body; // response: 'accept' or 'reject'
    
    const friendRequest = await FriendRequest.findById(requestId);
    if (!friendRequest) {
      return res.status(404).json({ error: 'İstek bulunamadı' });
    }

    if (friendRequest.toUser.toString() !== userId) {
      return res.status(403).json({ error: 'Bu isteği cevaplayamazsınız' });
    }

    friendRequest.status = response === 'accept' ? 'accepted' : 'rejected';
    friendRequest.respondedAt = new Date();
    await friendRequest.save();

    // Eğer kabul edildiyse her iki kullanıcının arkadaş listesine ekle
    if (response === 'accept') {
      await User.findByIdAndUpdate(friendRequest.fromUser, {
        $addToSet: { friends: friendRequest.toUser }
      });
      
      await User.findByIdAndUpdate(friendRequest.toUser, {
        $addToSet: { friends: friendRequest.fromUser }
      });
    }

    res.json({ 
      success: true, 
      message: response === 'accept' ? 'Arkadaşlık kabul edildi' : 'Arkadaşlık reddedildi'
    });
    
  } catch (error) {
    console.error('❌ Arkadaşlık yanıtı hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Bekleyen arkadaş isteklerini getir
app.get('/api/friends/pending-requests/:userId', async (req, res) => {
  try {
    const { userId } = req.params;
    
    const requests = await FriendRequest.find({
      toUser: userId,
      status: 'pending'
    }).populate('fromUser', 'name email shareCode').sort({ createdAt: -1 });
    
    res.json(requests);
  } catch (error) {
    console.error('❌ Bekleyen istekler hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Arkadaş konumlarını getir
app.get('/api/friends/locations/:userId', async (req, res) => {
  try {
    const { userId } = req.params;
    
    const user = await User.findOne({ uid: userId }).populate({
      path: 'friends',
      select: 'uid displayName photoURL location'
    });
    
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    // Arkadaşların konum bilgilerini filtrele (son 24 saat içindeki)
    const friendsWithLocations = user.friends
      .filter(friend => {
        if (!friend.location || !friend.location.lastUpdate) return false;
        
        const lastUpdate = new Date(friend.location.lastUpdate);
        const now = new Date();
        const diffHours = (now - lastUpdate) / (1000 * 60 * 60);
        
        return diffHours <= 24; // Son 24 saat içindeki konumlar
      })
      .map(friend => ({
        uid: friend.uid,
        displayName: friend.displayName,
        photoURL: friend.photoURL,
        location: {
          latitude: friend.location.latitude,
          longitude: friend.location.longitude,
          address: friend.location.address,
          lastUpdate: friend.location.lastUpdate
        }
      }));

    res.json({
      success: true,
      friendsLocations: friendsWithLocations
    });
    
  } catch (error) {
    console.error('❌ Arkadaş konumları hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

app.get('/api/earthquakes/recent', async (req, res) => {
  try {
    const earthquakes = await earthquakeMonitor.getRecentEarthquakes();
    res.json(earthquakes);
  } catch (error) {
    res.status(500).json({ error: 'Failed to fetch earthquakes' });
  }
});

app.get('/api/reports/:city', async (req, res) => {
  try {
    const { city } = req.params;
    const reports = await deviceManager.getCityReports(city);
    res.json(reports);
  } catch (error) {
    res.status(500).json({ error: 'Failed to fetch reports' });
  }
});

app.post('/api/test/earthquake', async (req, res) => {
  try {
    const { latitude, longitude, magnitude } = req.body;
    
    await notificationService.broadcastEarlyWarning({
      epicenter: { latitude, longitude },
      magnitude,
      estimatedArrival: new Date(Date.now() + 30000), // 30 seconds
      affectedRadius: magnitude * 50 // km
    });

    res.json({ message: 'Test earthquake broadcast sent' });
  } catch (error) {
    res.status(500).json({ error: 'Failed to send test earthquake' });
  }
});

// Test push endpoint - manually trigger APNs or MQTT publish
app.post('/api/test/push', async (req, res) => {
  try {
    const { target, title, body, userId, latitude, longitude, radiusKm } = req.body;
    // target: optional string like 'apn_<token>' or 'mqtt_<clientId>'
    // If target provided, send single push
    if (target) {
      const payload = { title: title || 'Test Bildirimi', body: body || 'Test mesajı', data: {} };
      const result = await notificationService.sendPush(target, payload);
      return res.json({ success: true, result });
    }

    // Otherwise, if userId provided, send to that user's devices
    if (userId) {
      const DeviceModel = require('./models/Device');
      const devices = await DeviceModel.find({ userId }).lean();
      if (!devices || devices.length === 0) return res.status(404).json({ error: 'Cihaz bulunamadı' });

      const pushDispatcher = require('./services/pushDispatcher');
      const payload = { title: title || 'Test Bildirimi', body: body || 'Test mesajı', data: {} };
      const dispatchResult = await pushDispatcher.sendPushToDeviceEntries(devices, payload, notificationService, { concurrency: 10 });
      return res.json({ success: true, dispatchResult });
    }

    // Otherwise, if lat/lon provided, find nearby device sockets via deviceManager and dispatch
    if (latitude && longitude) {
      const serverExports = require('./server');
      const devicesNear = serverExports.deviceManager.getDevicesInRadius(latitude, longitude, radiusKm || 50);
      if (!devicesNear || devicesNear.length === 0) return res.status(404).json({ error: 'Yakın cihaz bulunamadı' });

      // Map to Device model entries
      const DeviceModel = require('./models/Device');
      const allDeviceEntries = [];
      for (const d of devicesNear) {
        const deviceEntries = await DeviceModel.find({ $or: [{ deviceId: d.deviceId }, { 'location.latitude': d.location.latitude, 'location.longitude': d.location.longitude }] }).lean();
        if (deviceEntries && deviceEntries.length > 0) allDeviceEntries.push(...deviceEntries);
      }

      if (allDeviceEntries.length === 0) return res.status(404).json({ error: 'Kayıtlı bildirim cihazı bulunamadı' });

      const pushDispatcher = require('./services/pushDispatcher');
      const payload = { title: title || 'Bölge Testi', body: body || 'Bölgeye test bildirimi', data: {} };
      const dispatchResult = await pushDispatcher.sendPushToDeviceEntries(allDeviceEntries, payload, notificationService, { concurrency: 20 });
      return res.json({ success: true, dispatchResult });
    }

    res.status(400).json({ error: 'target veya userId veya latitude/longitude verin' });
  } catch (error) {
    console.error('Test push error:', error);
    res.status(500).json({ error: 'Test push hata' });
  }
});

// Device registration for push tokens
app.post('/api/devices/register', async (req, res) => {
  try {
    const { userId, deviceId, token, platform, latitude, longitude, deviceInfo, mqttClientId } = req.body;

    if (!token && !mqttClientId) return res.status(400).json({ error: 'token veya mqttClientId gerekli' });

    // Upsert device

    // Prefer to upsert by token or mqttClientId
    const query = token ? { token } : { mqttClientId };
    const existing = await Device.findOne(query);
    if (existing) {
      existing.userId = userId || existing.userId;
      existing.deviceId = deviceId || existing.deviceId;
      existing.platform = platform || existing.platform;
      existing.mqttClientId = mqttClientId || existing.mqttClientId;
      existing.token = token || existing.token;
      existing.lastSeen = new Date();
      if (latitude && longitude) existing.location = { latitude, longitude };
      if (deviceInfo) existing.deviceInfo = deviceInfo;
      await existing.save();
      return res.json({ success: true, device: existing });
    }

    const device = new Device({
      userId,
      deviceId,
      token,
      mqttClientId,
      platform: platform || 'android',
      location: latitude && longitude ? { latitude, longitude } : undefined,
      deviceInfo
    });

    await device.save();
    res.json({ success: true, device });
  } catch (error) {
    console.error('Device register error:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// TEST ENDPOINT - Deprem uyarısı test et
app.post('/api/test/earthquake', async (req, res) => {
  try {
    const {
      magnitude = 5.5,
      latitude = 41.0082,
      longitude = 28.9784,
      place = 'Istanbul, Turkey (TEST)',
      source = 'TEST'
    } = req.body;

    console.log('🧪 TEST EARTHQUAKE ALERT TRIGGERED');
    console.log(`   Magnitude: M${magnitude}`);
    console.log(`   Location: ${place} (${latitude}, ${longitude})`);

    const testEarthquake = {
      magnitude: parseFloat(magnitude),
      epicenter: {
        latitude: parseFloat(latitude),
        longitude: parseFloat(longitude)
      },
      place,
      source,
      estimatedArrival: new Date(Date.now() + 30000),
      affectedRadius: Math.pow(10, magnitude * 0.5) * 10,
      timestamp: new Date().toISOString()
    };

    // WebSocket üzerinden tüm bağlı cihazlara gönder
    io.emit('earthquake_warning', testEarthquake);
    
    console.log(`✅ Test earthquake broadcast to ${io.engine.clientsCount} connected clients`);

    res.json({
      success: true,
      message: 'Test earthquake alert sent',
      earthquake: testEarthquake,
      clientsNotified: io.engine.clientsCount
    });
  } catch (error) {
    console.error('❌ Test earthquake error:', error);
    res.status(500).json({ error: 'Test failed', message: error.message });
  }
});

// AFAD/Kandilli Monitoring (Every 10 seconds)
cron.schedule('*/10 * * * * *', async () => {
  try {
    await earthquakeMonitor.checkForNewEarthquakes();
  } catch (error) {
    console.error('Earthquake monitoring error:', error);
  }
});

// Device cleanup (Every 5 minutes)
cron.schedule('*/5 * * * *', async () => {
  try {
    await deviceManager.cleanupInactiveDevices();
  } catch (error) {
    console.error('Device cleanup error:', error);
  }
});

// Error Handling
process.on('unhandledRejection', (reason, promise) => {
  console.error('Unhandled Rejection at:', promise, 'reason:', reason);
});

process.on('uncaughtException', (error) => {
  console.error('Uncaught Exception:', error);
  process.exit(1);
});

// Server Start
const PORT = process.env.PORT || 3000;

async function startServer() {
  try {
    // Database bağlantısını başlat
    const dbConnected = await databaseService.connect();
    if (!dbConnected) {
      console.warn('⚠️ Database bağlantısı kurulamadı, sadece real-time özellikler çalışacak');
    }

    // Server'ı başlat
    server.listen(PORT, () => {
      console.log(`🚀 Earthquake Early Warning Server running on port ${PORT}`);
      console.log(`📡 WebSocket ready for real-time connections`);
      console.log(`⚡ P2P Early Warning System ACTIVE`);
      console.log(`🗄️ Database: ${databaseService.isHealthy() ? 'Connected' : 'Disconnected'}`);
      console.log(`🔗 API Endpoints: http://localhost:${PORT}/api/friends`);
    });
  } catch (error) {
    console.error('❌ Server başlatma hatası:', error);
    process.exit(1);
  }
}

// TEST ENDPOINT - Deprem bildirimi test et
app.post('/api/test/earthquake-notification', async (req, res) => {
  try {
    console.log('\n🧪 ===== TEST BİLDİRİMİ BAŞLADI =====');
    
    const testEarthquake = req.body.earthquake || {
      lat: 40.9593768,
      lon: 29.2197328,
      magnitude: 4.5,
      location: 'TEST DEPREMI - İstanbul (Kadıköy)',
      depth: 10,
      time: new Date()
    };
    
    console.log('📍 Test Depremi:', testEarthquake.location);
    console.log('📊 Büyüklük:', testEarthquake.magnitude);
    
    const PriorityNotificationService = require('./services/priorityNotificationService');
    const priorityService = new PriorityNotificationService(notificationService);
    
    const result = await priorityService.sendPriorityEarthquakeNotifications(testEarthquake);
    
    console.log('\n📊 TEST SONUÇLARI:');
    console.log('════════════════════════════════════════');
    console.log(`✅ Gönderilen: ${result.stats.sent}`);
    console.log(`⏭️  Atlanan: ${result.stats.skipped}`);
    console.log(`❌ Hatalı: ${result.stats.failed}`);
    console.log('════════════════════════════════════════\n');
    
    res.json({
      success: true,
      message: 'Test bildirimi gönderildi',
      earthquake: testEarthquake,
      results: result
    });
  } catch (error) {
    console.error('❌ Test bildirimi hatası:', error);
    res.status(500).json({ error: error.message });
  }
});

// GET endpoint - Browser'dan kolay tetikleme
app.get('/api/test/earthquake-notification', async (req, res) => {
  try {
    console.log('\n🧪 ===== TEST BİLDİRİMİ BAŞLADI (GET) =====');
    
    const testEarthquake = {
      lat: 40.9593768,
      lon: 29.2197328,
      magnitude: 4.5,
      location: 'TEST DEPREMI - İstanbul (Kadıköy)',
      depth: 10,
      time: new Date()
    };
    
    console.log('📍 Test Depremi:', testEarthquake.location);
    console.log('📊 Büyüklük:', testEarthquake.magnitude);
    
    // 1. FCM ile bildirim gönder (öncelikli - uygulama kapalıyken çalışır)
    console.log('🔥 FCM ile bildirim gönderiliyor...');
    const { sendEarthquakeNotificationToAll } = require('./routes/fcm');
    const fcmResult = await sendEarthquakeNotificationToAll(testEarthquake);
    
    if (fcmResult.success) {
      console.log('✅ FCM bildirimi gönderildi!');
    } else {
      console.log('❌ FCM hatası:', fcmResult.error);
    }
    
    // 2. WebSocket ile TÜM bağlı cihazlara gönder (harita güncellemesi için)
    console.log('📡 WebSocket ile bildirim gönderiliyor...');
    io.emit('earthquake_alert', {
      magnitude: testEarthquake.magnitude,
      location: testEarthquake.location,
      lat: testEarthquake.lat,
      lon: testEarthquake.lon,
      depth: testEarthquake.depth,
      time: testEarthquake.time,
      source: 'TEST'
    });
    console.log('✅ WebSocket bildirimi gönderildi!');
    
    // 2. FCM ile de dene (varsa)
    const PriorityNotificationService = require('./services/priorityNotificationService');
    const priorityService = new PriorityNotificationService(notificationService);
    
    const result = await priorityService.sendPriorityEarthquakeNotifications(testEarthquake);
    
    console.log('\n📊 TEST SONUÇLARI:');
    console.log('════════════════════════════════════════');
    console.log(`✅ Gönderilen: ${result.stats.sent}`);
    console.log(`⏭️  Atlanan: ${result.stats.skipped}`);
    console.log(`❌ Hatalı: ${result.stats.failed}`);
    console.log('════════════════════════════════════════\n');
    
    res.send(`
      <!DOCTYPE html>
      <html>
      <head>
        <title>Deprem Bildirimi Test</title>
        <style>
          body { font-family: system-ui; max-width: 600px; margin: 50px auto; padding: 20px; background: #0f1419; color: #fff; }
          .card { background: #1e2732; padding: 30px; border-radius: 12px; margin-bottom: 20px; }
          .success { color: #4CAF50; }
          .warning { color: #FF9800; }
          .error { color: #f44336; }
          h1 { margin: 0 0 20px 0; }
          .stat { font-size: 32px; font-weight: bold; margin: 10px 0; }
          button { background: #FF3333; color: white; border: none; padding: 12px 24px; border-radius: 8px; cursor: pointer; font-size: 16px; }
          button:hover { background: #cc0000; }
        </style>
      </head>
      <body>
        <div class="card">
          <h1>🧪 Deprem Bildirimi Test Sonucu</h1>
          <p><strong>📍 Konum:</strong> ${testEarthquake.location}</p>
          <p><strong>📊 Büyüklük:</strong> M${testEarthquake.magnitude}</p>
          <p><strong>🌍 Koordinatlar:</strong> ${testEarthquake.lat}, ${testEarthquake.lon}</p>
          <p><strong>⏰ Zaman:</strong> ${testEarthquake.time.toLocaleString('tr-TR')}</p>
        </div>
        
        <div class="card">
          <h2>📊 Bildirim İstatistikleri</h2>
          <p class="success">✅ Gönderilen: <span class="stat">${result.stats.sent}</span></p>
          <p class="warning">⏭️ Atlanan: <span class="stat">${result.stats.skipped}</span></p>
          <p class="error">❌ Hatalı: <span class="stat">${result.stats.failed}</span></p>
          
          ${result.stats.sent > 0 
            ? '<p class="success" style="margin-top: 20px; font-size: 18px;">🎉 BAŞARILI! Bildirimi telefonunuzda kontrol edin.</p>' 
            : '<p class="warning" style="margin-top: 20px; font-size: 18px;">⚠️ Hiç bildirim gönderilmedi. Range veya magnitude ayarlarını kontrol edin.</p>'}
        </div>
        
        <button onclick="location.reload()">🔄 Tekrar Test Et</button>
      </body>
      </html>
    `);
  } catch (error) {
    console.error('❌ Test bildirimi hatası:', error);
    res.status(500).send(`<h1>❌ Hata</h1><p>${error.message}</p>`);
  }
});

startServer();

// Export app and key services so other modules (like earthquakeMonitor) can access deviceManager and notificationService
module.exports = {
  app,
  server,
  deviceManager,
  notificationService,
  earthquakeMonitor
};
