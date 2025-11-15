const axios = require('axios');

class EarthquakeMonitor {
  constructor() {
    this.lastChecked = new Date();
    this.recentEarthquakes = new Map(); // Store recent earthquakes
    this.processedEarthquakes = new Set(); // Prevent duplicate processing
    this.sources = {
      afad: {
        url: 'https://deprem.afad.gov.tr/apiv2/event/filter',
        enabled: true,
        timeout: 10000 // Increased timeout for AFAD
      },
      kandilli: {
        url: 'http://www.koeri.boun.edu.tr/scripts/lst0.asp',
        enabled: true,
        timeout: 5000
      },
      usgs: {
        url: 'https://earthquake.usgs.gov/fdsnws/event/1/query',
        enabled: true,
        timeout: 5000
      }
    };
  }

  async checkForNewEarthquakes() {
    try {
      console.log('🔍 Checking for new earthquakes...');
      
      // Check multiple sources
      const promises = [];
      
      if (this.sources.afad.enabled) {
        promises.push(this.checkAFAD());
      }
      
      if (this.sources.kandilli.enabled) {
        promises.push(this.checkKandilli());
      }

      if (this.sources.usgs.enabled) {
        promises.push(this.checkUSGS());
      }

      const results = await Promise.allSettled(promises);
      
      let newEarthquakes = [];
      
      let successfulSources = 0;
      results.forEach((result, index) => {
        const sources = ['AFAD', 'Kandilli', 'USGS'];
        if (result.status === 'fulfilled' && result.value) {
          if (result.value.length > 0) {
            successfulSources++;
            console.log(`✅ ${sources[index]}: ${result.value.length} earthquakes`);
          }
          newEarthquakes = newEarthquakes.concat(result.value);
        } else if (result.status === 'rejected') {
          console.error(`❌ ${sources[index]} failed:`, result.reason.message);
        }
      });
      
      if (successfulSources === 0) {
        console.warn('⚠️ No earthquake sources available - relying on P2P detection');
      }

      // Process and deduplicate earthquakes
      const processedEarthquakes = this.processEarthquakes(newEarthquakes);
      
      if (processedEarthquakes.length > 0) {
        console.log(`📊 Found ${processedEarthquakes.length} new earthquakes`);
        
        // Trigger notifications for significant earthquakes
        for (const earthquake of processedEarthquakes) {
          if (earthquake.magnitude >= 4.0) { // Only notify for magnitude 4.0+
            await this.triggerEarthquakeNotification(earthquake);
          }
        }
        // Persist earthquakes to DB if model available
        try {
          const EarthquakeModel = require('../models/Earthquake');
          for (const eq of processedEarthquakes) {
            // Upsert by eventId or generated unique id
            await EarthquakeModel.updateOne(
              { eventId: eq.eventId || eq.id },
              { $setOnInsert: eq },
              { upsert: true }
            );
          }
        } catch (err) {
          console.warn('DB persist skipped (no DB available or error):', err.message);
        }
      }

      this.lastChecked = new Date();
      return processedEarthquakes;

    } catch (error) {
      console.error('Earthquake monitoring error:', error);
      return [];
    }
  }

  async checkAFAD() {
    try {
      // AFAD API parameters - correct format based on official API
      const now = new Date();
      const yesterday = new Date(Date.now() - 24 * 60 * 60 * 1000);
      
      // Format: MM-DD-YYYY HH:MM:SS
      const formatDate = (date) => {
        const pad = (n) => n.toString().padStart(2, '0');
        return `${pad(date.getMonth() + 1)}-${pad(date.getDate())}-${date.getFullYear()} ${pad(date.getHours())}:${pad(date.getMinutes())}:${pad(date.getSeconds())}`;
      };

      const params = {
        start: formatDate(yesterday),
        end: formatDate(now),
        format: 'json'
      };

      const response = await axios.get(this.sources.afad.url, {
        params,
        timeout: this.sources.afad.timeout,
        headers: {
          'User-Agent': 'DepremApp/1.0',
          'Accept': 'application/json'
        }
      });

      // AFAD returns array directly or in data property
      const earthquakes = Array.isArray(response.data) ? response.data : (response.data.data || []);
      
      if (earthquakes && earthquakes.length > 0) {
        console.log(`✅ AFAD API: ${earthquakes.length} earthquakes received`);
        return earthquakes.map(eq => ({
          id: `afad_${eq.eventID || eq.event_id || eq._id}`,
          source: 'AFAD',
          eventId: eq.eventID || eq.event_id || eq._id,
          magnitude: parseFloat(eq.mag || eq.magnitude),
          depth: parseFloat(eq.depth || eq.Depth),
          location: {
            latitude: parseFloat(eq.geojson?.coordinates?.[1] || eq.latitude || eq.lat),
            longitude: parseFloat(eq.geojson?.coordinates?.[0] || eq.longitude || eq.lon)
          },
          place: eq.location || eq.place || eq.title || 'Unknown',
          timestamp: new Date(eq.date || eq.event_date_time || eq.timestamp),
          url: `https://deprem.afad.gov.tr/event-detail/${eq.eventID || eq.event_id || eq._id}`,
          type: eq.type || 'earthquake'
        }));
      }

      return [];

    } catch (error) {
      // AFAD API temporarily unavailable - skip and rely on other sources
      console.warn('⚠️ AFAD API temporarily unavailable:', error.message);
      if (error.response) {
        console.warn(`   Status: ${error.response.status}`);
      }
      // Don't use mock data - rely on other sources (Kandilli, USGS)
      return [];
    }
  }

  async checkKandilli() {
    try {
      // Note: Kandilli often has CORS issues, so this might fail in browser
      // For production, you'd need a proxy or server-side scraping
      const response = await axios.get(this.sources.kandilli.url, {
        timeout: this.sources.kandilli.timeout,
        headers: {
          'User-Agent': 'DepremApp/1.0'
        }
      });

      // Parse Kandilli's HTML response (simplified)
      const earthquakes = this.parseKandilliData(response.data);
      return earthquakes;

    } catch (error) {
      console.warn('⚠️ Kandilli API failed:', error.message);
      // Don't use mock data - rely on other sources
      return [];
    }
  }

  async checkUSGS() {
    try {
      // USGS for international earthquakes affecting Turkey region
      const params = {
        format: 'geojson',
        starttime: this.getISO8601String(new Date(Date.now() - 24 * 60 * 60 * 1000)),
        minmagnitude: 4.0,
        minlatitude: 35,
        maxlatitude: 43,
        minlongitude: 25,
        maxlongitude: 45
      };

      const response = await axios.get(this.sources.usgs.url, {
        params,
        timeout: this.sources.usgs.timeout
      });

      if (response.data && response.data.features) {
        return response.data.features.map(feature => ({
          id: `usgs_${feature.id}`,
          source: 'USGS',
          eventId: feature.id,
          magnitude: feature.properties.mag,
          depth: feature.geometry.coordinates[2],
          location: {
            latitude: feature.geometry.coordinates[1],
            longitude: feature.geometry.coordinates[0]
          },
          place: feature.properties.place,
          timestamp: new Date(feature.properties.time),
          url: feature.properties.url,
          type: feature.properties.type
        }));
      }

      return [];

    } catch (error) {
      console.warn('⚠️ USGS API failed:', error.message);
      // Don't use mock data - rely on other sources and P2P
      return [];
    }
  }

  processEarthquakes(earthquakes) {
    const newEarthquakes = [];
    
    for (const earthquake of earthquakes) {
      const uniqueId = this.getEarthquakeUniqueId(earthquake);
      
      // Skip if already processed
      if (this.processedEarthquakes.has(uniqueId)) {
        continue;
      }

      // Skip if too old (older than 1 hour)
      const ageHours = (Date.now() - earthquake.timestamp.getTime()) / (1000 * 60 * 60);
      if (ageHours > 1) {
        continue;
      }

      // Add to processed set
      this.processedEarthquakes.add(uniqueId);
      
      // Store in recent earthquakes
      this.recentEarthquakes.set(uniqueId, earthquake);
      
      newEarthquakes.push(earthquake);
    }

    // Cleanup old processed earthquakes (older than 24 hours)
    this.cleanupOldEarthquakes();

    return newEarthquakes;
  }

  async triggerEarthquakeNotification(earthquake) {
    try {
      console.log(`🚨 Triggering notification for earthquake: M${earthquake.magnitude} at ${earthquake.place}`);
      
      console.log(`📍 Location: ${earthquake.location.latitude}, ${earthquake.location.longitude}`);
      console.log(`⏰ Time: ${earthquake.timestamp}`);
      console.log(`🌊 Depth: ${earthquake.depth} km`);

      // Calculate affected radius
      const affectedRadius = this.calculateAffectedRadius(earthquake.magnitude);

      // Server-side matching: find users whose preferences indicate they want notifications
      try {
        const User = require('../models/User');
        const NotificationService = require('./notificationService');
        const server = require('../server'); // to access deviceManager & notificationService via server module exports

        // Query users with notifications enabled and minMagnitude <= earthquake.magnitude
        const interestedUsers = await User.find({
          'notificationPreferences.enabled': true,
          $or: [
            { 'notificationPreferences.minMagnitude': { $lte: earthquake.magnitude } },
            { 'notificationPreferences.minMagnitude': { $exists: false } }
          ]
        }).lean();

        // For each interested user, check devices in radius and notify
        if (interestedUsers && interestedUsers.length > 0 && server && server.deviceManager) {
          for (const u of interestedUsers) {
            const prefs = u.notificationPreferences || { radiusKm: 50, minMagnitude: 4.0 };
            const radius = prefs.radiusKm || 50;

            // If user's minMagnitude is higher than quake mag, skip
            if ((prefs.minMagnitude || 0) > earthquake.magnitude) continue;

            const devices = server.deviceManager.getDevicesInRadius(
              earthquake.location.latitude, earthquake.location.longitude, radius
            );

            if (devices && devices.length > 0) {
              // Send a targeted broadcast to those device socketIds via notificationService
              const notificationSvc = server.notificationService;
              if (notificationSvc) {
                // prepare payload
                const payload = {
                  epicenter: earthquake.location,
                  magnitude: earthquake.magnitude,
                  estimatedArrival: new Date(Date.now() + 30000),
                  affectedRadius
                };

                // send to each device socket
                devices.forEach(d => {
                  try {
                    notificationSvc.sendUserAlert(d.socketId, {
                      type: 'earthquake_warning',
                      message: `Deprem uyarısı: M${earthquake.magnitude} yakında`,
                      data: payload
                    });
                  } catch (err) {
                    console.warn('Failed to send user alert to device:', d.socketId, err.message);
                  }
                });
                // Additionally, fetch registered push tokens for these users/devices and send FCM pushes via dispatcher
                try {
                  const DeviceModel = require('../models/Device');
                  const pushDispatcher = require('./pushDispatcher');

                  // Collect device entries for all matched devices
                  const allDeviceEntries = [];
                  for (const d of devices) {
                    const deviceEntries = await DeviceModel.find({
                      $or: [ { deviceId: d.deviceId }, { 'location.latitude': d.location.latitude, 'location.longitude': d.location.longitude } ]
                    }).lean();
                    if (deviceEntries && deviceEntries.length > 0) allDeviceEntries.push(...deviceEntries);
                  }

                  if (allDeviceEntries.length > 0) {
                    const payload = {
                      title: 'Deprem Uyarısı',
                      body: `Bölgenizde M${earthquake.magnitude} büyüklüğünde deprem tespit edildi`,
                      warning: notificationSvc.generateWarningMessage ? notificationSvc.generateWarningMessage(earthquake.magnitude) : undefined,
                      data: {
                        epicenter: JSON.stringify(earthquake.location),
                        magnitude: String(earthquake.magnitude),
                        id: earthquake.id || earthquake.eventId
                      }
                    };

                    const dispatchResult = await pushDispatcher.sendPushToDeviceEntries(allDeviceEntries, payload, notificationSvc, { concurrency: 50 });
                    console.log('Push dispatch result:', dispatchResult);
                  }
                } catch (err) {
                  console.warn('Push dispatcher failed:', err.message);
                }
              }
            }
          }
        }
      } catch (err) {
        console.warn('Server-side notification matching failed:', err.message);
      }

    } catch (error) {
      console.error('Failed to trigger earthquake notification:', error);
    }
  }

  calculateAffectedRadius(magnitude) {
    // Simplified calculation - in reality this would be more complex
    return Math.pow(10, magnitude * 0.5) * 10; // km
  }

  getEarthquakeUniqueId(earthquake) {
    // Create unique ID based on location, magnitude, and time
    const lat = earthquake.location.latitude.toFixed(2);
    const lon = earthquake.location.longitude.toFixed(2);
    const mag = earthquake.magnitude.toFixed(1);
    const time = Math.floor(earthquake.timestamp.getTime() / (1000 * 60 * 10)); // 10-minute blocks
    
    return `${lat}_${lon}_${mag}_${time}`;
  }

  getMockEarthquakeData(source) {
    // Return mock data for development/testing
    const mockEarthquakes = [
      {
        id: `${source.toLowerCase()}_mock_${Date.now()}`,
        source,
        eventId: `mock_${Date.now()}`,
        magnitude: 2.5 + Math.random() * 3.5,
        depth: 5 + Math.random() * 15,
        location: {
          latitude: 40 + Math.random() * 2,
          longitude: 28 + Math.random() * 4
        },
        place: 'Mock Earthquake Location',
        timestamp: new Date(Date.now() - Math.random() * 60 * 60 * 1000),
        url: '#',
        type: 'earthquake'
      }
    ];

    return Math.random() > 0.8 ? mockEarthquakes : []; // 20% chance of mock earthquake
  }

  parseKandilliData(htmlData) {
    // Kandilli HTML parsing - Real format (single long line):
    // 2025.11.15 05:55:23  39.2113   28.1335        8.9      -.-  1.1  -.-   MANDIRA-SINDIRGI (BALIKESIR)
    // Format: DATE TIME LAT LON DEPTH -.- MAG -.- LOCATION
    try {
      const lines = htmlData.split('\n');
      const earthquakes = [];
      
      for (const line of lines) {
        // Match the complete pattern in one line
        // Date, time, lat, lon, depth, -.- , mag, -.- , location
        const match = line.match(/(\d{4}\.\d{2}\.\d{2})\s+(\d{2}:\d{2}:\d{2})\s+([\d.]+)\s+([\d.]+)\s+([\d.]+)\s+-\.-\s+([\d.]+)\s+-\.-\s+(.+)$/);
        
        if (match) {
          try {
            const [_, dateStr, timeStr, latStr, lonStr, depthStr, magStr, place] = match;
            
            const lat = parseFloat(latStr);
            const lon = parseFloat(lonStr);
            const depth = parseFloat(depthStr);
            const mag = parseFloat(magStr);
            
            // Validate values
            if (isNaN(lat) || isNaN(lon) || isNaN(mag) || mag <= 0 || mag > 10) {
              continue;
            }
            
            // Parse date: 2025.11.15 05:55:23 → Date object
            const [year, month, day] = dateStr.split('.').map(Number);
            const [hour, minute, second] = timeStr.split(':').map(Number);
            
            // Kandilli uses Turkey time (UTC+3) - create as local time
            const timestamp = new Date(year, month - 1, day, hour, minute, second);
            
            // Validate date is reasonable (not in future, not too old)
            const now = new Date();
            const ageHours = (now - timestamp) / (1000 * 60 * 60);
            
            if (ageHours >= -1 && ageHours <= 72) { // Allow 1 hour in future (clock skew), up to 3 days old
              earthquakes.push({
                id: `kandilli_${dateStr.replace(/\./g, '')}_${timeStr.replace(/:/g, '')}_${lat.toFixed(2)}_${lon.toFixed(2)}`,
                source: 'Kandilli',
                magnitude: mag,
                location: {
                  latitude: lat,
                  longitude: lon
                },
                depth: isNaN(depth) ? 0 : depth,
                place: place.trim() || 'Turkey',
                timestamp: timestamp,
                type: 'earthquake',
                rawDate: dateStr,
                rawTime: timeStr
              });
            }
          } catch (parseError) {
            // Skip malformed lines
            console.error('Kandilli parse error:', parseError.message);
            continue;
          }
        }
      }
      
      console.log(`📊 Kandilli: ${earthquakes.length} deprem parse edildi`);
      
      // Return latest 20 earthquakes
      return earthquakes
        .sort((a, b) => b.timestamp - a.timestamp)
        .slice(0, 20);
      
    } catch (error) {
      console.error('❌ Kandilli parsing hatası:', error);
      return [];
    }
  }

  getRecentEarthquakes(limit = 50) {
    const earthquakes = Array.from(this.recentEarthquakes.values())
      .sort((a, b) => b.timestamp - a.timestamp)
      .slice(0, limit);
    
    return earthquakes;
  }

  cleanupOldEarthquakes() {
    const oneDayAgo = Date.now() - (24 * 60 * 60 * 1000);
    
    for (const [id, earthquake] of this.recentEarthquakes.entries()) {
      if (earthquake.timestamp.getTime() < oneDayAgo) {
        this.recentEarthquakes.delete(id);
        this.processedEarthquakes.delete(id);
      }
    }
  }

  getDateString(date) {
    return date.toISOString().split('T')[0];
  }

  getISO8601String(date) {
    return date.toISOString();
  }

  // Statistics
  getMonitoringStats() {
    return {
      lastChecked: this.lastChecked,
      recentEarthquakes: this.recentEarthquakes.size,
      processedEarthquakes: this.processedEarthquakes.size,
      sources: Object.keys(this.sources).map(key => ({
        name: key,
        enabled: this.sources[key].enabled,
        url: this.sources[key].url
      }))
    };
  }
}

module.exports = EarthquakeMonitor;
