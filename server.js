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

// Routes
const friendsRoutes = require('./routes/friends');

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

module.exports = app;
