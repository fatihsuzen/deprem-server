const { v4: uuidv4 } = require('uuid');

class DeviceManager {
  constructor() {
    this.devices = new Map(); // socketId -> device info
    this.deviceLocations = new Map(); // deviceId -> location
    this.seismicData = new Map(); // deviceId -> array of recent data
    this.userReports = new Map(); // deviceId -> array of reports
    this.heartbeats = new Map(); // deviceId -> last heartbeat
  }

  async registerDevice(deviceInfo) {
    const { socketId, deviceId, latitude, longitude, deviceInfo: info, lastSeen } = deviceInfo;
    
    const device = {
      socketId,
      deviceId: deviceId || uuidv4(),
      location: { latitude, longitude },
      deviceInfo: info,
      registeredAt: new Date(),
      lastSeen,
      isActive: true
    };

    this.devices.set(socketId, device);
    this.deviceLocations.set(device.deviceId, { latitude, longitude });
    this.heartbeats.set(device.deviceId, Date.now());

    console.log(`📱 Device registered: ${device.deviceId} (Total: ${this.devices.size})`);
    
    return device;
  }

  async removeDevice(socketId) {
    const device = this.devices.get(socketId);
    if (device) {
      this.devices.delete(socketId);
      this.deviceLocations.delete(device.deviceId);
      this.heartbeats.delete(device.deviceId);
      console.log(`📱 Device removed: ${device.deviceId} (Total: ${this.devices.size})`);
    }
  }

  async storeSeismicData(data) {
    const { deviceId, accelerometer, gyroscope, timestamp, location } = data;
    
    if (!this.seismicData.has(deviceId)) {
      this.seismicData.set(deviceId, []);
    }

    const seismicArray = this.seismicData.get(deviceId);
    
    // Store with timestamp
    seismicArray.push({
      timestamp,
      location,
      accelerometer: {
        x: accelerometer.x,
        y: accelerometer.y,
        z: accelerometer.z
      },
      gyroscope: {
        x: gyroscope.x,
        y: gyroscope.y,
        z: gyroscope.z
      }
    });

    // Keep only last 100 readings per device (memory management)
    if (seismicArray.length > 100) {
      seismicArray.shift();
    }

    this.seismicData.set(deviceId, seismicArray);
  }

  async storeUserReport(reportData) {
    const { deviceId, location, intensity, description, timestamp, socketId } = reportData;
    
    if (!this.userReports.has(deviceId)) {
      this.userReports.set(deviceId, []);
    }

    const report = {
      id: uuidv4(),
      deviceId,
      location,
      intensity,
      description,
      timestamp,
      socketId,
      createdAt: new Date()
    };

    this.userReports.get(deviceId).push(report);

    // Keep only last 50 reports per device
    const reports = this.userReports.get(deviceId);
    if (reports.length > 50) {
      reports.shift();
    }

    return report;
  }

  async updateDeviceHeartbeat(deviceId, location) {
    this.heartbeats.set(deviceId, Date.now());
    
    if (location) {
      this.deviceLocations.set(deviceId, location);
    }
  }

  async cleanupInactiveDevices() {
    const now = Date.now();
    const timeout = 5 * 60 * 1000; // 5 minutes

    let cleanedCount = 0;

    for (const [deviceId, lastHeartbeat] of this.heartbeats.entries()) {
      if (now - lastHeartbeat > timeout) {
        // Find and remove inactive device
        for (const [socketId, device] of this.devices.entries()) {
          if (device.deviceId === deviceId) {
            this.removeDevice(socketId);
            cleanedCount++;
            break;
          }
        }
      }
    }

    if (cleanedCount > 0) {
      console.log(`🧹 Cleaned up ${cleanedCount} inactive devices`);
    }
  }

  getDeviceCount() {
    return this.devices.size;
  }

  getDevicesInRadius(centerLat, centerLon, radiusKm) {
    const devicesInRadius = [];
    
    for (const [socketId, device] of this.devices.entries()) {
      const distance = this.calculateDistance(
        centerLat, centerLon,
        device.location.latitude, device.location.longitude
      );

      if (distance <= radiusKm) {
        devicesInRadius.push({
          ...device,
          distanceKm: distance
        });
      }
    }

    return devicesInRadius;
  }

  getSeismicDataInArea(centerLat, centerLon, radiusKm, timeWindowMs = 30000) {
    const now = Date.now();
    const areaData = [];

    for (const [deviceId, readings] of this.seismicData.entries()) {
      const deviceLocation = this.deviceLocations.get(deviceId);
      
      if (!deviceLocation) continue;

      const distance = this.calculateDistance(
        centerLat, centerLon,
        deviceLocation.latitude, deviceLocation.longitude
      );

      if (distance <= radiusKm) {
        // Get recent readings within time window
        const recentReadings = readings.filter(reading => 
          now - new Date(reading.timestamp).getTime() <= timeWindowMs
        );

        if (recentReadings.length > 0) {
          areaData.push({
            deviceId,
            location: deviceLocation,
            distance,
            readings: recentReadings
          });
        }
      }
    }

    return areaData;
  }

  async getCityReports(cityName) {
    // Mock implementation - in real app, use proper geo-coding
    const cityCoords = this.getCityCoordinates(cityName);
    if (!cityCoords) return [];

    const devicesInCity = this.getDevicesInRadius(
      cityCoords.lat, cityCoords.lon, 50 // 50km radius
    );

    let allReports = [];
    
    devicesInCity.forEach(device => {
      const deviceReports = this.userReports.get(device.deviceId) || [];
      allReports = allReports.concat(deviceReports);
    });

    // Sort by timestamp, most recent first
    allReports.sort((a, b) => new Date(b.timestamp) - new Date(a.timestamp));

    return allReports.slice(0, 100); // Return last 100 reports
  }

  getCityCoordinates(cityName) {
    const cities = {
      'istanbul': { lat: 41.0082, lon: 28.9784 },
      'ankara': { lat: 39.9334, lon: 32.8597 },
      'izmir': { lat: 38.4237, lon: 27.1428 },
      'bursa': { lat: 40.1826, lon: 29.0665 },
      'antalya': { lat: 36.8969, lon: 30.7133 },
      'adana': { lat: 37.0000, lon: 35.3213 },
      'gaziantep': { lat: 37.0662, lon: 37.3833 }
    };

    return cities[cityName.toLowerCase()];
  }

  calculateDistance(lat1, lon1, lat2, lon2) {
    const R = 6371; // Earth's radius in km
    const dLat = this.toRadians(lat2 - lat1);
    const dLon = this.toRadians(lon2 - lon1);
    
    const a = Math.sin(dLat/2) * Math.sin(dLat/2) +
              Math.cos(this.toRadians(lat1)) * Math.cos(this.toRadians(lat2)) *
              Math.sin(dLon/2) * Math.sin(dLon/2);
    
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    
    return R * c;
  }

  toRadians(degrees) {
    return degrees * (Math.PI / 180);
  }

  // Debug methods
  getDeviceStats() {
    return {
      totalDevices: this.devices.size,
      activeDevices: Array.from(this.devices.values()).filter(d => d.isActive).length,
      totalSeismicData: Array.from(this.seismicData.values()).reduce((sum, arr) => sum + arr.length, 0),
      totalReports: Array.from(this.userReports.values()).reduce((sum, arr) => sum + arr.length, 0)
    };
  }
}

module.exports = DeviceManager;
