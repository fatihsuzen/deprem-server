



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
      },
      emsc: {
        url: 'https://www.seismicportal.eu/fdsnws/event/1/query',
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
      if (this.sources.emsc.enabled) {
        promises.push(this.checkEMSC());
      }

      const results = await Promise.allSettled(promises);
      
      let newEarthquakes = [];
      
      let successfulSources = 0;
      results.forEach((result, index) => {
        let sourceName = 'Unknown';
        if (result.status === 'fulfilled' && result.value && result.value.length > 0) {
          sourceName = result.value[0].source || 'Unknown';
          successfulSources++;
          console.log(`✅ ${sourceName}: ${result.value.length} earthquakes`);
          newEarthquakes = newEarthquakes.concat(result.value);
        } else if (result.status === 'fulfilled' && result.value && result.value.length === 0) {
          // fulfilled ama veri yoksa, sourceName'i index ile tahmin et
          const sources = ['AFAD', 'Kandilli', 'USGS', 'EMSC'];
          sourceName = sources[index] || 'Unknown';
          console.log(`✅ ${sourceName}: 0 earthquakes`);
        } else if (result.status === 'rejected') {
          const sources = ['AFAD', 'Kandilli', 'USGS', 'EMSC'];
          sourceName = sources[index] || 'Unknown';
          console.error(`❌ ${sourceName} failed:`, result.reason.message);
        }
      });
      
      if (successfulSources === 0) {
        console.warn('⚠️ No earthquake sources available - relying on P2P detection');
      }

      // Process and deduplicate earthquakes
      const processedEarthquakes = this.processEarthquakes(newEarthquakes);
      
      if (processedEarthquakes.length > 0) {
        console.log(`📊 Found ${processedEarthquakes.length} new earthquakes`);
        
        // Trigger notifications using Priority Notification Service
        for (const earthquake of processedEarthquakes) {
          // Kullanıcı ayarlarına göre bildirim gönder (magnitude kontrolü serviste)
          await this.triggerEarthquakeNotification(earthquake);
        }
        // Persist earthquakes to DB if model available
        try {
          const EarthquakeModel = require('../models/Earthquake');
          // Deprem verisini Earthquake schema'ya uygun normalize et
          function normalizeEarthquake(eq) {
            // eventId
            const eventId = eq.eventId || eq.id || `${eq.source}_${eq.timestamp ? eq.timestamp.getTime() : Date.now()}_${eq.location?.latitude}_${eq.location?.longitude}`;
            // mag
            const mag = typeof eq.mag === 'number' ? eq.mag : (typeof eq.magnitude === 'number' ? eq.magnitude : parseFloat(eq.ml || eq.mw || eq.md || 0));
            // time
            const time = eq.time || eq.timestamp || new Date();
            // coordinates
            const longitude = eq.location?.longitude || (eq.coordinates?.coordinates?.[0]);
            const latitude = eq.location?.latitude || (eq.coordinates?.coordinates?.[1]);
            const coordinates = {
              type: 'Point',
              coordinates: [longitude, latitude]
            };
            return {
              eventId,
              mag,
              magnitude: mag,
              depth: eq.depth || 0,
              coordinates,
              location: {
                latitude,
                longitude
              },
              place: eq.place || 'Unknown',
              region: eq.region || '',
              time,
              timestamp: time,
              source: eq.source || 'Unknown',
              url: eq.url || '',
              type: eq.type || 'earthquake',
              magnitude_type: eq.magnitude_type || '',
              notificationSent: eq.notificationSent || false,
              notificationStats: eq.notificationStats || undefined
            };
          }
          for (const eqRaw of processedEarthquakes) {
            const eq = normalizeEarthquake(eqRaw);
            // Duplicate önleme: Zaman, konum ve büyüklük ile arama
            const timeWindowStart = new Date(eq.time.getTime() - 60 * 1000); // -1 dakika
            const timeWindowEnd = new Date(eq.time.getTime() + 60 * 1000);   // +1 dakika
            const magMin = eq.mag - 0.2;
            const magMax = eq.mag + 0.2;
            const latMin = eq.location.latitude - 0.1;
            const latMax = eq.location.latitude + 0.1;
            const lonMin = eq.location.longitude - 0.1;
            const lonMax = eq.location.longitude + 0.1;
            const existing = await EarthquakeModel.findOne({
              time: { $gte: timeWindowStart, $lte: timeWindowEnd },
              mag: { $gte: magMin, $lte: magMax },
              'location.latitude': { $gte: latMin, $lte: latMax },
              'location.longitude': { $gte: lonMin, $lte: lonMax }
            });
            if (existing) {
              // Kaynak ekle (varsa), güncelle
              if (!existing.source.includes(eq.source)) {
                existing.source += ',' + eq.source;
                await existing.save();
              }
              console.log(`🔁 Duplicate deprem: ${eq.mag} ${eq.place} (${eq.source})`);
            } else {
              // Yeni deprem kaydı
              await EarthquakeModel.create(eq);
              console.log(`✅ Yeni deprem kaydedildi: ${eq.mag} ${eq.place} (${eq.source})`);
              // Dosyaya log ekle
              const fs = require('fs');
              const logLine = `${new Date().toISOString()} | Mag:${eq.mag} | ${eq.place} | ${eq.source} | Lat:${eq.location.latitude} Lon:${eq.location.longitude}\n`;
              fs.appendFile('earthquake_log.txt', logLine, (err) => {
                if (err) console.error('Deprem log dosyasına yazılamadı:', err);
              });
            }
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
      console.log('🔍 Kandilli veri çekiliyor...');
      const response = await axios.get(this.sources.kandilli.url, {
        timeout: this.sources.kandilli.timeout,
        headers: {
          'User-Agent': 'DepremApp/1.0'
        }
      });
      console.log('✅ Kandilli veri çekildi, veri uzunluğu:', response.data.length);
      // Kandilli ham veri logu kaldırıldı
      const earthquakes = this.parseKandilliData(response.data);
      console.log('✅ Kandilli parse edilen deprem sayısı:', earthquakes.length);
      return earthquakes;
    } catch (error) {
      console.warn('⚠️ Kandilli API failed:', error.message);
      return [];
    }
  // Dosya doğrudan çalıştırılırsa Kandilli test fonksiyonu
  if (require.main === module) {
    console.log('--- Kandilli Test Başlatılıyor ---');
    const monitor = new EarthquakeMonitor();
    monitor.checkKandilli().then(result => {
      console.log('Kandilli parse sonucu:', result);
      console.log('--- Kandilli Test Bitti ---');
      process.exit(0);
    }).catch(err => {
      console.error('Kandilli test hatası:', err);
      process.exit(1);
    });
  }
  }

  async checkUSGS() {
  }

  async checkEMSC() {
    try {
      // EMSC for international earthquakes
      const params = {
        format: 'json',
        starttime: '2019-01-01T00:00:00',
        endtime: '2020-01-02T00:00:00',
        minmag: 2,
        minlat: 35,
        maxlat: 43,
        minlon: 25,
        maxlon: 45
      };
      const response = await axios.get('https://www.seismicportal.eu/fdsnws/event/1/query', {
        params,
        timeout: this.sources.emsc.timeout
      });
      if (response.data && response.data.features) {
        return response.data.features.map(feature => ({
          id: `emsc_${feature.id}`,
          source: 'EMSC',
          eventId: feature.id,
          magnitude: feature.properties.mag,
          depth: feature.geometry.coordinates[2],
          location: {
            latitude: feature.geometry.coordinates[1],
            longitude: feature.geometry.coordinates[0]
          },
          place: feature.properties.place || feature.properties.flynn_region || 'Unknown',
          timestamp: new Date(feature.properties.time),
          url: feature.properties.url || '',
          type: feature.properties.type || 'earthquake'
        }));
      }
      return [];
    } catch (error) {
      console.warn('⚠️ EMSC API failed:', error.message);
      return [];
    }
  }

  async checkUSGS() {
    try {
      // USGS for international earthquakes affecting Turkey region
      const now = new Date();
      const yesterday = new Date(now.getTime() - 24 * 60 * 60 * 1000);
      const params = {
        format: 'geojson',
        starttime: yesterday.toISOString().slice(0, 19),
        endtime: now.toISOString().slice(0, 19),
        minmagnitude: 5,
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
      } else {
        console.log('✅ USGS: 0 earthquakes');
      }
      return [];

    } catch (error) {
      console.warn('⚠️ USGS API failed:', error.message);
      if (error.response) {
        console.warn('USGS API response:', error.response.data);
      }
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
      console.log(`🚨 Yeni deprem algılandı: M${earthquake.magnitude} - ${earthquake.place}`);
      
      // Priority Notification Service kullan
      const PriorityNotificationService = require('./priorityNotificationService');
      const server = require('../server');
      
      if (!server.notificationService) {
        console.log('⚠️ Notification service hazır değil');
        return;
      }
      
      const priorityService = new PriorityNotificationService(server.notificationService);
      
      // Deprem verisini uygun formata çevir
      const earthquakeData = {
        lat: earthquake.location?.latitude || 0,
        lon: earthquake.location?.longitude || 0,
        magnitude: earthquake.magnitude,
        location: `${earthquake.location?.latitude || 0},${earthquake.location?.longitude || 0}`,
        location_str: `${earthquake.location?.latitude || 0},${earthquake.location?.longitude || 0}`,
        region: earthquake.place || 'Unknown',
        depth: earthquake.depth || 10,
        time: earthquake.timestamp ? new Date(earthquake.timestamp) : new Date()
      };
      
      // Kullanıcı ayarlarına göre (range + magnitude) bildirim gönder
      const result = await priorityService.sendPriorityEarthquakeNotifications(earthquakeData);
      
      if (result.success) {
        console.log(`✅ Bildirimler gönderildi: ${result.stats.sent} başarılı, ${result.stats.skipped} atlandı`);
      }
      
    } catch (error) {
      console.error('❌ Notification hatası:', error.message);
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
    // Kandilli HTML parsing - NEW FORMAT (Nov 2025):
    // [600] 2025.11.13 06:29:49  39.2547   28.0957       10.0      -.-  2.2  -.-   KARAGUR-SINDIRGI (BALIKESIR)                      İlksel
    // Format: [NUM] DATE TIME LAT LON DEPTH -.- MAG -.- LOCATION
    try {
      // <pre> bloğundaki satırları bul
      const preMatch = htmlData.match(/<pre>([\s\S]*?)<\/pre>/);
      if (!preMatch) {
        console.log('Kandilli <pre> bloğu bulunamadı!');
        return [];
      }
      const preText = preMatch[1];
      const lines = preText.split('\n').map(l => l.trimEnd());
      const earthquakes = [];
      for (const line of lines) {
        // Sadece tarih ile başlayan satırları al
        if (!/^\d{4}\.\d{2}\.\d{2}/.test(line)) continue;
        // Sabit genişlikli alanlar
        const tarih = line.substring(0, 10).trim();
        const saat = line.substring(11, 19).trim();
        const enlem = line.substring(20, 29).trim();
        const boylam = line.substring(30, 39).trim();
        const derinlik = line.substring(40, 52).trim();
        const md = line.substring(53, 57).trim();
        const ml = line.substring(58, 63).trim();
        const mw = line.substring(63, 67).trim();
        const yer = line.substring(68, 108).trim();
        const cozum = line.substring(109).trim();
        // Sayısal değerleri parse et
        const lat = parseFloat(enlem);
        const lon = parseFloat(boylam);
        const depth = parseFloat(derinlik);
        // Magnitude fallback: ml, mw, md
        // Magnitude fallback: ml > mw > md
        let mag = null;
        const magCandidates = [ml, mw, md];
        mag = parseFloat(ml);
        // Debug: Satırı ve seçilen mag değerini logla
        const [year, month, day] = tarih.split('.').map(Number);
        const [hour, minute, second] = saat.split(':').map(Number);
        const timestamp = new Date(year, month - 1, day, hour, minute, second);
        // Mantıklı değer kontrolü
        if (isNaN(lat) || isNaN(lon) || mag === null || isNaN(mag) || mag <= 0 || mag > 10) continue;
        earthquakes.push({
          id: `kandilli_${tarih.replace(/\./g, '')}_${saat.replace(/:/g, '')}_${lat.toFixed(2)}_${lon.toFixed(2)}`,
          source: 'Kandilli',
          magnitude: mag,
          location: {
            latitude: lat,
            longitude: lon
          },
          depth: isNaN(depth) ? 0 : depth,
          place: yer || 'Turkey',
          timestamp: timestamp,
          type: 'earthquake',
          rawDate: tarih,
          rawTime: saat,
          cozum
        });
      }
      console.log(`📊 Kandilli: ${earthquakes.length} deprem parse edildi`);
      // Tüm depremleri döndür (slice kaldırıldı)
      return earthquakes.sort((a, b) => b.timestamp - a.timestamp);
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
module.exports = EarthquakeMonitor;
