const express = require('express');
const router = express.Router();
const axios = require('axios');

// Get earthquakeMonitor from server module (will be set after server initializes)
let earthquakeMonitor = null;

// Function to set earthquakeMonitor after server initializes it
function setEarthquakeMonitor(monitor) {
  earthquakeMonitor = monitor;
  console.log('✅ earthquakeMonitor set in routes/earthquakes.js');
}

// Export the setter function
router.setEarthquakeMonitor = setEarthquakeMonitor;

// Mesafe hesaplama (Haversine formülü)
function calculateDistance(lat1, lon1, lat2, lon2) {
  const R = 6371; // Dünya yarıçapı (km)
  const dLat = (lat2 - lat1) * Math.PI / 180;
  const dLon = (lon2 - lon1) * Math.PI / 180;
  const a = 
    Math.sin(dLat/2) * Math.sin(dLat/2) +
    Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) *
    Math.sin(dLon/2) * Math.sin(dLon/2);
  const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
  return R * c;
}

// Bölge adı belirleme
function getRegionName(lat, lon) {
  // Türkiye
  if (lat >= 36 && lat <= 42 && lon >= 26 && lon <= 45) return 'Turkey';
  // Japonya
  if (lat >= 24 && lat <= 46 && lon >= 122 && lon <= 154) return 'Japan';
  // Endonezya
  if (lat >= -11 && lat <= 6 && lon >= 95 && lon <= 141) return 'Indonesia';
  // Şili
  if (lat >= -56 && lat <= -17 && lon >= -76 && lon <= -66) return 'Chile';
  // Kaliforniya
  if (lat >= 32 && lat <= 42 && lon >= -125 && lon <= -114) return 'California';
  // İtalya
  if (lat >= 36 && lat <= 47 && lon >= 6 && lon <= 19) return 'Italy';
  // Meksika
  if (lat >= 14 && lat <= 33 && lon >= -118 && lon <= -86) return 'Mexico';
  // Yeni Zelanda
  if (lat >= -47 && lat <= -34 && lon >= 166 && lon <= 179) return 'New Zealand';
  // Hindistan/Nepal
  if (lat >= 8 && lat <= 35 && lon >= 68 && lon <= 97) return 'South Asia';
  // Alaska
  if (lat >= 51 && lat <= 71 && lon >= -180 && lon <= -130) return 'Alaska';
  
  // Genel bölgeler
  if (lat >= -90 && lat <= -60) return 'Antarctica';
  if (lat >= 60 && lat <= 90) return 'Arctic';
  
  return 'Global';
}

// USGS Global verilerini çekmek için (ANA KAYNAK)
async function fetchUSGSData(period = 'day') {
  try {
    // Periyotlar: hour, day, week, month
    const url = `https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_${period}.geojson`;
    
    console.log(`📡 USGS verisi çekiliyor: ${period}`);
    
    const response = await axios.get(url, { timeout: 15000 });

    const earthquakes = response.data.features.map(feature => {
      const props = feature.properties;
      const coords = feature.geometry.coordinates;
      const quakeDate = new Date(props.time);
      const minutesAgo = Math.floor((Date.now() - quakeDate.getTime()) / (1000 * 60));

      const lat = coords[1];
      const lon = coords[0];
      const region = getRegionName(lat, lon);

      return {
        id: feature.id,
        lat,
        lon,
        mag: props.mag || 0,
        depth: Math.abs(coords[2]) || 0,
        place: props.place || 'Unknown location',
        region,
        date: quakeDate.toLocaleDateString('en-US', { 
          day: 'numeric', 
          month: 'long', 
          year: 'numeric' 
        }),
        time: quakeDate.toLocaleTimeString('en-US', { 
          hour: '2-digit', 
          minute: '2-digit',
          hour12: false
        }),
        timestamp: quakeDate.toISOString(),
        minutesAgo,
        felt: props.felt || 0,
        tsunami: props.tsunami || 0,
        alert: props.alert || null,
        type: props.type || 'earthquake',
        source: 'USGS'
      };
    });

    console.log(`✅ ${earthquakes.length} USGS deprem verisi alındı`);
    return earthquakes;
  } catch (error) {
    console.error('❌ USGS hatası:', error.message);
    return [];
  }
}

// EMSC (European-Mediterranean Seismological Centre) verilerini çekmek için
async function fetchEMSCData() {
  try {
    // EMSC FDSN web service - son 24 saat
    const now = new Date();
    const yesterday = new Date(Date.now() - 24 * 60 * 60 * 1000);
    
    const response = await axios.get('http://www.seismicportal.eu/fdsnws/event/1/query', {
      params: {
        format: 'json',
        limit: 100,
        orderby: 'time-desc',
        starttime: yesterday.toISOString(),
        endtime: now.toISOString()
      },
      timeout: 15000,
      headers: {
        'User-Agent': 'DepremApp/1.0'
      }
    });

    // EMSC returns GeoJSON format
    if (!response.data || !response.data.features) {
      console.warn('⚠️ EMSC yanıt formatı beklenmiyor');
      return [];
    }

    const earthquakes = response.data.features.map(feature => {
      const props = feature.properties;
      const coords = feature.geometry.coordinates;
      const quakeDate = new Date(props.time);
      const minutesAgo = Math.floor((Date.now() - quakeDate.getTime()) / (1000 * 60));

      const lat = coords[1];
      const lon = coords[0];
      const region = getRegionName(lat, lon);

      return {
        id: `emsc_${props.unid || feature.id}`,
        lat,
        lon,
        mag: props.mag || 0,
        depth: Math.abs(coords[2]) || 0,
        place: props.flynn_region || props.place || 'Unknown location',
        region,
        date: quakeDate.toLocaleDateString('en-US', { 
          day: 'numeric', 
          month: 'long', 
          year: 'numeric' 
        }),
        time: quakeDate.toLocaleTimeString('en-US', { 
          hour: '2-digit', 
          minute: '2-digit',
          hour12: false
        }),
        timestamp: quakeDate.toISOString(),
        minutesAgo,
        source: 'EMSC'
      };
    });

    console.log(`✅ ${earthquakes.length} EMSC deprem verisi alındı`);
    return earthquakes;
  } catch (error) {
    console.error('❌ EMSC hatası:', error.message);
    if (error.response) {
      console.error('   Status:', error.response.status);
      console.error('   Data:', error.response.data);
    }
    return [];
  }
}

// AFAD verilerini çekmek için (Türkiye resmi)
async function fetchAFADData() {
  try {
    const now = new Date();
    const yesterday = new Date(Date.now() - 24 * 60 * 60 * 1000);
    
    const formatDate = (date) => {
      const pad = (n) => n.toString().padStart(2, '0');
      return `${pad(date.getMonth() + 1)}-${pad(date.getDate())}-${date.getFullYear()} ${pad(date.getHours())}:${pad(date.getMinutes())}:${pad(date.getSeconds())}`;
    };

    const params = {
      start: formatDate(yesterday),
      end: formatDate(now),
      format: 'json'
    };

    const response = await axios.get('https://deprem.afad.gov.tr/apiv2/event/filter', {
      params,
      timeout: 10000,
      headers: {
        'User-Agent': 'DepremApp/1.0',
        'Accept': 'application/json'
      }
    });

    const earthquakes = Array.isArray(response.data) ? response.data : (response.data.data || []);
    
    if (earthquakes && earthquakes.length > 0) {
      return earthquakes.map(eq => {
        const lat = parseFloat(eq.geojson?.coordinates?.[1] || eq.latitude || eq.lat);
        const lon = parseFloat(eq.geojson?.coordinates?.[0] || eq.longitude || eq.lon);
        const mag = parseFloat(eq.mag || eq.magnitude);
        const depth = parseFloat(eq.depth || eq.Depth);
        
        // AFAD tarihi Türkiye saati (UTC+3), 3 saat ekle
        const afadDateStr = eq.date || eq.event_date_time || eq.timestamp;
        let quakeDate;
        if (afadDateStr) {
          // AFAD bazen "2026-01-29 05:28:53" formatında geliyor (boşluk ile)
          const isoStr = afadDateStr.replace(' ', 'T');
          const turkeyDate = new Date(isoStr);
          // Türkiye saatine 3 saat EKLE
          quakeDate = new Date(turkeyDate.getTime() + (3 * 60 * 60 * 1000));
        } else {
          quakeDate = new Date();
        }
        const minutesAgo = Math.floor((Date.now() - quakeDate.getTime()) / (1000 * 60));

        return {
          id: `afad_${eq.eventID || eq.event_id || eq._id}`,
          lat,
          lon,
          mag,
          depth,
          place: eq.location || eq.place || eq.title || 'Unknown',
          region: 'Turkey',
          time: quakeDate.toISOString(),
          timestamp: quakeDate.toISOString(),
          minutesAgo,
          source: 'AFAD'
        };
      });
    }

    return [];
  } catch (error) {
    console.error('❌ AFAD hatası:', error.message);
    return [];
  }
}

// Kandilli verilerini çekmek için (Türkiye için detaylı)
// NOT: Artık earthquakeMonitor servisinden alıyoruz - doğru parser ile parse edilmiş veri
async function fetchKandilliData() {
  try {
    console.log('🔍 fetchKandilliData çağrıldı, earthquakeMonitor durumu:', !!earthquakeMonitor);
    
    if (!earthquakeMonitor) {
      console.log('⚠️  earthquakeMonitor henüz hazır değil');
      return [];
    }
    
    // earthquakeMonitor'den tüm depremleri al, sadece Kandilli olanları filtrele
    const allEarthquakes = earthquakeMonitor.getRecentEarthquakes(500);
    console.log(`📊 earthquakeMonitor'den ${allEarthquakes.length} toplam deprem alındı`);
    
    const kandilliEarthquakes = allEarthquakes
      .filter(eq => eq.source === 'Kandilli')
      .map(eq => {
        // Convert to route format
        const quakeDate = new Date(eq.timestamp);
        const minutesAgo = Math.floor((Date.now() - quakeDate.getTime()) / (1000 * 60));
        
        return {
          id: eq.id,
          lat: eq.location.latitude,
          lon: eq.location.longitude,
          mag: eq.magnitude,
          depth: eq.depth,
          place: eq.place,
          region: 'Turkey',
          date: quakeDate.toLocaleDateString('en-US', { 
            day: 'numeric', 
            month: 'long', 
            year: 'numeric' 
          }),
          time: quakeDate.toLocaleTimeString('en-US', { 
            hour: '2-digit', 
            minute: '2-digit',
            hour12: false
          }),
          timestamp: quakeDate.toISOString(),
          minutesAgo,
          source: 'Kandilli'
        };
      });
    
    console.log(`✅ Kandilli: ${kandilliEarthquakes.length} deprem hazır`);
    return kandilliEarthquakes;
  } catch (error) {
    console.error('❌ Kandilli hatası:', error.message);
    return [];
  }
}

// Son depremleri getir (Global veya konuma göre)
router.get('/', async (req, res) => {
  try {
    const limit = parseInt(req.query.limit) || 100;
    const minMag = parseFloat(req.query.minMagnitude) || 2.5;
    const period = req.query.period || 'day'; // hour, day, week, month
    const userLat = parseFloat(req.query.lat);
    const userLon = parseFloat(req.query.lon);
    const radius = parseFloat(req.query.radius) || null; // km cinsinden
    const region = req.query.region; // 'Turkey', 'Japan', 'Global' vs.
    const source = req.query.source; // 'USGS', 'AFAD', 'Kandilli', 'EMSC' filtresi

    console.log(`📡 Deprem verileri çekiliyor...`);
    console.log(`   Limit: ${limit}, MinMag: ${minMag}, Period: ${period}`);
    console.log(`   Konum: ${userLat}, ${userLon}, Radius: ${radius}km`);
    console.log(`   Bölge: ${region || 'All'}, Kaynak: ${source || 'All'}`);

    let earthquakes = [];

    // Source filtresi yoksa veya USGS ise
    if (!source || source === 'USGS') {
      const usgsData = await fetchUSGSData(period);
      earthquakes = earthquakes.concat(usgsData);
    }

    // Source filtresi yoksa veya AFAD ise
    if (!source || source === 'AFAD') {
      const afadData = await fetchAFADData();
      earthquakes = earthquakes.concat(afadData);
    }

    // Source filtresi yoksa veya Kandilli ise
    if (!source || source === 'Kandilli') {
      const kandilliData = await fetchKandilliData();
      earthquakes = earthquakes.concat(kandilliData);
    }
    
    // Source filtresi yoksa veya EMSC ise
    if (!source || source === 'EMSC') {
      const emscData = await fetchEMSCData();
      earthquakes = earthquakes.concat(emscData);
    }

    // Minimum büyüklük filtresi
    earthquakes = earthquakes.filter(eq => eq.mag >= minMag);

    // Bölge filtresi
    if (region && region !== 'Global') {
      earthquakes = earthquakes.filter(eq => eq.region === region);
    }

    // Konuma göre filtreleme (radius varsa)
    if (!isNaN(userLat) && !isNaN(userLon) && radius) {
      earthquakes = earthquakes.map(eq => {
        const distance = calculateDistance(userLat, userLon, eq.lat, eq.lon);
        return { ...eq, distance };
      }).filter(eq => eq.distance <= radius);
    }

    // Kullanıcı konumu varsa mesafe ekle ve sırala
    if (!isNaN(userLat) && !isNaN(userLon)) {
      earthquakes = earthquakes.map(eq => {
        if (!eq.distance) {
          eq.distance = calculateDistance(userLat, userLon, eq.lat, eq.lon);
        }
        return eq;
      });

      // Önceliklendirme: Yakın + büyük depremler önce
      earthquakes.sort((a, b) => {
        // Skorlama: magnitude * 100 - distance
        const scoreA = (a.mag * 100) - (a.distance / 10);
        const scoreB = (b.mag * 100) - (b.distance / 10);
        return scoreB - scoreA;
      });
    } else {
      // Konum yoksa zamana göre sırala (en yeni önce)
      earthquakes.sort((a, b) => a.minutesAgo - b.minutesAgo);
    }

    // Duplicate kontrolü (aynı lat/lon/mag/time)
    const seen = new Set();
    earthquakes = earthquakes.filter(eq => {
      const key = `${eq.lat.toFixed(2)}_${eq.lon.toFixed(2)}_${eq.mag.toFixed(1)}_${Math.floor(eq.minutesAgo / 5)}`;
      if (seen.has(key)) return false;
      seen.add(key);
      return true;
    });

    // Limit uygula
    earthquakes = earthquakes.slice(0, limit);

    console.log(`✅ ${earthquakes.length} deprem verisi hazır`);

    // İstatistikler
    const stats = {
      total: earthquakes.length,
      byRegion: {},
      byMagnitude: {
        minor: 0,      // < 3.0
        light: 0,      // 3.0 - 3.9
        moderate: 0,   // 4.0 - 4.9
        strong: 0,     // 5.0 - 5.9
        major: 0,      // 6.0 - 6.9
        great: 0       // >= 7.0
      }
    };

    earthquakes.forEach(eq => {
      // Bölge istatistikleri
      stats.byRegion[eq.region] = (stats.byRegion[eq.region] || 0) + 1;

      // Büyüklük istatistikleri
      if (eq.mag < 3.0) stats.byMagnitude.minor++;
      else if (eq.mag < 4.0) stats.byMagnitude.light++;
      else if (eq.mag < 5.0) stats.byMagnitude.moderate++;
      else if (eq.mag < 6.0) stats.byMagnitude.strong++;
      else if (eq.mag < 7.0) stats.byMagnitude.major++;
      else stats.byMagnitude.great++;
    });

    res.json({
      success: true,
      earthquakes,
      stats,
      timestamp: new Date().toISOString()
    });

  } catch (error) {
    console.error('❌ Deprem API hatası:', error);
    res.status(500).json({ 
      success: false, 
      error: 'Deprem verileri alınamadı',
      message: error.message 
    });
  }
});

// Belirli bir bölgedeki depremleri getir
router.get('/region/:regionName', async (req, res) => {
  try {
    const regionName = req.params.regionName;
    const limit = parseInt(req.query.limit) || 50;
    const minMag = parseFloat(req.query.minMagnitude) || 2.0;

    let earthquakes = await fetchUSGSData('week');

    // Bölge filtresi
    earthquakes = earthquakes.filter(eq => 
      eq.region === regionName && eq.mag >= minMag
    );

    earthquakes.sort((a, b) => a.minutesAgo - b.minutesAgo);
    earthquakes = earthquakes.slice(0, limit);

    res.json({
      success: true,
      region: regionName,
      earthquakes,
      total: earthquakes.length
    });

  } catch (error) {
    console.error('❌ Bölge depremleri hatası:', error);
    res.status(500).json({ 
      success: false, 
      error: 'Bölge depremleri alınamadı' 
    });
  }
});

// Son depremi getir (En yakın veya en büyük)
router.get('/latest', async (req, res) => {
  try {
    const userLat = parseFloat(req.query.lat);
    const userLon = parseFloat(req.query.lon);
    const sortBy = req.query.sortBy || 'time'; // 'time', 'magnitude', 'distance'

    let earthquakes = await fetchUSGSData('day');
    
    // Kandilli ekle
    const kandilliData = await fetchKandilliData();
    earthquakes = earthquakes.concat(kandilliData);

    if (earthquakes.length === 0) {
      return res.status(404).json({ 
        success: false, 
        error: 'Deprem verisi bulunamadı' 
      });
    }

    // Sıralama
    if (sortBy === 'magnitude') {
      // En büyük depremi bul
      earthquakes.sort((a, b) => b.mag - a.mag);
    } else if (sortBy === 'distance' && !isNaN(userLat) && !isNaN(userLon)) {
      // En yakın depremi bul
      earthquakes = earthquakes.map(eq => ({
        ...eq,
        distance: calculateDistance(userLat, userLon, eq.lat, eq.lon)
      }));
      earthquakes.sort((a, b) => a.distance - b.distance);
    } else {
      // En yeni depremi bul
      earthquakes.sort((a, b) => a.minutesAgo - b.minutesAgo);
    }

    const latest = earthquakes[0];

    res.json({ 
      success: true, 
      earthquake: latest 
    });

  } catch (error) {
    console.error('❌ Son deprem hatası:', error);
    res.status(500).json({ 
      success: false, 
      error: 'Son deprem alınamadı' 
    });
  }
});

// Significant earthquakes (M4.5+, son 7 gün)
router.get('/significant', async (req, res) => {
  try {
    let earthquakes = await fetchUSGSData('week');
    
    // M4.5+ filtresi
    earthquakes = earthquakes.filter(eq => eq.mag >= 4.5);
    earthquakes.sort((a, b) => b.mag - a.mag);

    res.json({
      success: true,
      earthquakes,
      total: earthquakes.length
    });

  } catch (error) {
    console.error('❌ Significant earthquakes hatası:', error);
    res.status(500).json({ 
      success: false, 
      error: 'Önemli depremler alınamadı' 
    });
  }
});

// Bölge listesi
router.get('/regions', (req, res) => {
  res.json({
    success: true,
    regions: [
      'Turkey', 'Japan', 'Indonesia', 'Chile', 'California',
      'Italy', 'Mexico', 'New Zealand', 'South Asia', 'Alaska',
      'Antarctica', 'Arctic', 'Global'
    ]
  });
});

module.exports = router;
