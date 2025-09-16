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
        timeout: 5000
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
      
      results.forEach((result, index) => {
        if (result.status === 'fulfilled' && result.value) {
          newEarthquakes = newEarthquakes.concat(result.value);
        } else if (result.status === 'rejected') {
          const sources = ['AFAD', 'Kandilli', 'USGS'];
          console.error(`❌ ${sources[index]} error:`, result.reason.message);
        }
      });

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
      // AFAD API parameters for recent earthquakes
      const params = {
        orderBy: 'event_date_time',
        orderDirection: 'desc',
        limit: 50,
        minMagnitude: 2.0,
        startDate: this.getDateString(new Date(Date.now() - 24 * 60 * 60 * 1000)) // Last 24 hours
      };

      const response = await axios.get(this.sources.afad.url, {
        params,
        timeout: this.sources.afad.timeout,
        headers: {
          'User-Agent': 'DepremApp/1.0',
          'Accept': 'application/json'
        }
      });

      if (response.data && response.data.data) {
        return response.data.data.map(eq => ({
          id: `afad_${eq.event_id}`,
          source: 'AFAD',
          eventId: eq.event_id,
          magnitude: parseFloat(eq.magnitude),
          depth: parseFloat(eq.depth),
          location: {
            latitude: parseFloat(eq.latitude),
            longitude: parseFloat(eq.longitude)
          },
          place: eq.location || eq.place,
          timestamp: new Date(eq.event_date_time),
          url: `https://deprem.afad.gov.tr/event-detail/${eq.event_id}`,
          type: eq.type || 'earthquake'
        }));
      }

      return [];

    } catch (error) {
      // If official API fails, return mock data for development
      console.warn('AFAD API failed, using mock data:', error.message);
      return this.getMockEarthquakeData('AFAD');
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
      console.warn('Kandilli API failed, using mock data:', error.message);
      return this.getMockEarthquakeData('Kandilli');
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
      console.warn('USGS API failed, using mock data:', error.message);
      return this.getMockEarthquakeData('USGS');
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
      
      // This would integrate with NotificationService
      // For now, just log the earthquake
      console.log(`📍 Location: ${earthquake.location.latitude}, ${earthquake.location.longitude}`);
      console.log(`⏰ Time: ${earthquake.timestamp}`);
      console.log(`🌊 Depth: ${earthquake.depth} km`);
      
      // Calculate affected radius
      const affectedRadius = this.calculateAffectedRadius(earthquake.magnitude);
      
      // This is where you'd call NotificationService.broadcastEarlyWarning()
      // const notificationService = require('./notificationService');
      // await notificationService.broadcastEarlyWarning({
      //   epicenter: earthquake.location,
      //   magnitude: earthquake.magnitude,
      //   estimatedArrival: new Date(Date.now() + 30000),
      //   affectedRadius
      // });

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
    // Simplified Kandilli HTML parsing
    // In production, you'd use a proper HTML parser like cheerio
    try {
      const lines = htmlData.split('\n');
      const earthquakes = [];
      
      for (const line of lines) {
        if (line.includes('M ') && line.includes('N ') && line.includes('E ')) {
          // Parse Kandilli format (this is simplified)
          const parts = line.trim().split(/\s+/);
          if (parts.length >= 6) {
            earthquakes.push({
              id: `kandilli_${Date.now()}_${Math.random()}`,
              source: 'Kandilli',
              magnitude: parseFloat(parts[6]) || 0,
              location: {
                latitude: parseFloat(parts[2]) || 0,
                longitude: parseFloat(parts[4]) || 0
              },
              depth: parseFloat(parts[3]) || 0,
              place: 'Kandilli Observatory',
              timestamp: new Date(),
              type: 'earthquake'
            });
          }
        }
      }
      
      return earthquakes.slice(0, 10); // Return max 10 earthquakes
      
    } catch (error) {
      console.error('Kandilli parsing error:', error);
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
