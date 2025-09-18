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

const app = express();
const server = http.createServer(app);
const io = socketIo(server, {
  cors: {
    origin: "*",
    methods: ["GET", "POST"]
  },
  pingTimeout: 60000,
  pingInterval: 25000
});

// Middleware
app.use(helmet());
app.use(compression());
app.use(cors());
app.use(express.json({ limit: '50mb' }));
app.use(express.urlencoded({ extended: true, limit: '50mb' }));

// Routes
app.use('/api/friends', friendsRoutes);
app.use('/api/chat', chatRoutes);
app.use('/api/earthquakes', earthquakesRoutes);

// User routes for location updates
app.post('/api/users/update-location', async (req, res) => {
  try {
    const { latitude, longitude } = req.body;
    const uid = req.headers['x-firebase-uid'];

    if (!uid) {
      return res.status(401).json({ error: 'Firebase UID gerekli' });
    }

    if (!latitude || !longitude) {
      return res.status(400).json({ error: 'Latitude ve longitude gerekli' });
    }

    const User = require('./models/User');
    const user = await User.findOne({ uid });
    
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    await user.updateLocation(latitude, longitude);
    
    console.log(`📍 Konum güncellendi: ${user.displayName} - ${latitude}, ${longitude}`);

    res.json({
      success: true,
      location: user.location
    });

  } catch (error) {
    console.error('❌ Location update hatası:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
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
const validationService = new ValidationService();

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

// Konum güncelleme API'si
app.post('/api/users/update-location', async (req, res) => {
  try {
    const { userId, latitude, longitude, address } = req.body;
    
    if (!userId || !latitude || !longitude) {
      return res.status(400).json({ error: 'userId, latitude ve longitude gerekli' });
    }

    const user = await User.findOne({ uid: userId });
    if (!user) {
      return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
    }

    // Konumu güncelle
    await user.updateLocation(latitude, longitude, address || '');
    
    console.log(`📍 Konum güncellendi: ${user.displayName} (${latitude}, ${longitude})`);
    
    res.json({ 
      success: true, 
      message: 'Konum güncellendi',
      location: {
        latitude,
        longitude,
        address,
        lastUpdate: new Date()
      }
    });
    
  } catch (error) {
    console.error('❌ Konum güncelleme hatası:', error);
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

startServer();

// Export app and key services so other modules (like earthquakeMonitor) can access deviceManager and notificationService
module.exports = {
  app,
  server,
  deviceManager,
  notificationService
};
