const geolib = require('geolib');

/**
 * P2P Deprem Algılama Servisi (Server-Side)
 * Kullanıcı telefonlarından gelen sarsıntı raporlarını analiz eder
 * ve gerçek deprem olup olmadığını tespit eder
 */
class P2PEarthquakeAnalyzer {
  constructor() {
    // Son raporlar (memory cache - production'da Redis kullan)
    this.recentReports = [];
    
    // Algoritma parametreleri
    this.config = {
      MIN_REPORTS_FOR_DETECTION: 5,        // Minimum rapor sayısı
      MIN_REPORTS_FOR_ALERT: 10,           // Uyarı için minimum rapor
      MAX_REPORT_AGE_SECONDS: 30,          // Raporların max yaşı (30 saniye)
      CLUSTER_RADIUS_KM: 10,               // Kümelenme yarıçapı (10km)
      MIN_PROBABILITY_SCORE: 60,           // Minimum olasılık skoru
      MIN_AVG_MAGNITUDE: 3.0,              // Minimum ortalama büyüklük
      FALSE_POSITIVE_FILTER_RADIUS: 0.5,   // Aynı cihaz filtresi (500m)
      TIME_CORRELATION_WINDOW: 5,          // Zaman korelasyonu penceresi (5sn)
    };
    
    // Detected earthquakes cache
    this.detectedEarthquakes = new Map();
  }

  /**
   * Yeni rapor al ve analiz et
   */
  async processShakeReport(report) {
    try {
      console.log(`📥 Yeni rapor: ${report.userId} - Skor: ${report.sensorData.probabilityScore}`);
      
      // 1. Raporu kaydet
      this.recentReports.push({
        ...report,
        receivedAt: new Date(),
      });
      
      // 2. Eski raporları temizle
      this._cleanOldReports();
      
      // 3. False positive filtrele (aynı cihazın tekrar rapor vermesi)
      this._filterFalsePositives(report);
      
      // 4. Bölgesel analiz yap
      const analysis = await this._analyzeRegion(report.location);
      
      // 5. Deprem tespit edildiyse kaydet ve bildir
      if (analysis.isEarthquakeDetected) {
        await this._handleEarthquakeDetection(analysis);
      }
      
      return {
        success: true,
        message: 'Rapor alındı ve analiz edildi',
        analysis: {
          region: analysis.regionName,
          totalReports: analysis.totalReports,
          earthquakeProbability: analysis.earthquakeProbability,
          isEarthquakeDetected: analysis.isEarthquakeDetected,
          estimatedMagnitude: analysis.estimatedMagnitude,
          estimatedEpicenter: analysis.estimatedEpicenter,
        }
      };
      
    } catch (error) {
      console.error('❌ Rapor işleme hatası:', error);
      return {
        success: false,
        error: error.message
      };
    }
  }

  /**
   * Eski raporları temizle (30 saniyeden eski)
   */
  _cleanOldReports() {
    const cutoffTime = new Date(Date.now() - this.config.MAX_REPORT_AGE_SECONDS * 1000);
    
    const oldCount = this.recentReports.length;
    this.recentReports = this.recentReports.filter(r => r.receivedAt > cutoffTime);
    
    const removed = oldCount - this.recentReports.length;
    if (removed > 0) {
      console.log(`🗑️ ${removed} eski rapor temizlendi`);
    }
  }

  /**
   * False positive filtrele
   * - Aynı cihazın 500m içinde tekrar rapor vermesi
   * - Çok yüksek rotasyon (kasıtlı sallama)
   */
  _filterFalsePositives(newReport) {
    // Aynı kullanıcının yakın raporlarını bul
    const sameUserReports = this.recentReports.filter(r => 
      r.userId === newReport.userId &&
      r.receivedAt.getTime() !== newReport.receivedAt?.getTime()
    );
    
    for (const oldReport of sameUserReports) {
      const distance = geolib.getDistance(
        { latitude: oldReport.location.latitude, longitude: oldReport.location.longitude },
        { latitude: newReport.location.latitude, longitude: newReport.location.longitude }
      ) / 1000; // km
      
      // 500m içinde aynı kullanıcı = muhtemelen false positive
      if (distance < this.config.FALSE_POSITIVE_FILTER_RADIUS) {
        console.log(`⚠️ False positive şüphesi: ${newReport.userId} (${distance}km)`);
        newReport.sensorData.probabilityScore *= 0.7; // Skoru düşür
      }
    }
  }

  /**
   * Bölgesel analiz yap
   */
  async _analyzeRegion(location) {
    const { latitude, longitude } = location;
    
    // 1. 10km yarıçapındaki tüm raporları bul
    const nearbyReports = this._findNearbyReports(latitude, longitude, this.config.CLUSTER_RADIUS_KM);
    
    console.log(`📍 Bölge analizi: ${nearbyReports.length} rapor bulundu (${this.config.CLUSTER_RADIUS_KM}km yarıçap)`);
    
    if (nearbyReports.length === 0) {
      return {
        regionName: 'Unknown',
        totalReports: 0,
        earthquakeProbability: 0,
        isEarthquakeDetected: false,
      };
    }
    
    // 2. İstatistikleri hesapla
    const stats = this._calculateStatistics(nearbyReports);
    
    // 3. Deprem olasılığını hesapla
    const earthquakeProbability = this._calculateEarthquakeProbability(stats, nearbyReports);
    
    // 4. Deprem tespit kriterleri
    const isEarthquakeDetected = this._meetsDetectionCriteria(stats, earthquakeProbability, nearbyReports);
    
    // 5. Merkez üssü tahmin et (ağırlıklı ortalama)
    const estimatedEpicenter = this._estimateEpicenter(nearbyReports);
    
    // 6. Büyüklük tahmin et
    const estimatedMagnitude = this._estimateMagnitude(stats, nearbyReports);
    
    // 7. Bölge adı
    const regionName = await this._getRegionName(estimatedEpicenter.latitude, estimatedEpicenter.longitude);
    
    return {
      regionName,
      totalReports: nearbyReports.length,
      earthquakeProbability,
      isEarthquakeDetected,
      estimatedMagnitude,
      estimatedEpicenter,
      stats,
    };
  }

  /**
   * Yakındaki raporları bul
   */
  _findNearbyReports(lat, lon, radiusKm) {
    return this.recentReports.filter(report => {
      const distance = geolib.getDistance(
        { latitude: lat, longitude: lon },
        { latitude: report.location.latitude, longitude: report.location.longitude }
      ) / 1000; // km
      
      return distance <= radiusKm;
    });
  }

  /**
   * İstatistikleri hesapla
   */
  _calculateStatistics(reports) {
    if (reports.length === 0) return null;
    
    const magnitudes = reports.map(r => r.sensorData.maxMagnitude);
    const scores = reports.map(r => r.sensorData.probabilityScore);
    const avgMagnitudes = reports.map(r => r.sensorData.avgMagnitude);
    
    return {
      count: reports.length,
      avgMaxMagnitude: magnitudes.reduce((a, b) => a + b, 0) / magnitudes.length,
      maxMagnitude: Math.max(...magnitudes),
      avgProbabilityScore: scores.reduce((a, b) => a + b, 0) / scores.length,
      maxProbabilityScore: Math.max(...scores),
      avgAvgMagnitude: avgMagnitudes.reduce((a, b) => a + b, 0) / avgMagnitudes.length,
      uniqueUsers: new Set(reports.map(r => r.userId)).size,
      uniqueDevices: new Set(reports.map(r => r.deviceId)).size,
    };
  }

  /**
   * Deprem olasılığını hesapla (0-100%)
   */
  _calculateEarthquakeProbability(stats, reports) {
    if (!stats) return 0;
    
    let probability = 0;
    
    // 1. Rapor sayısı (0-30 puan)
    // 5+ rapor = 20 puan, 10+ rapor = 30 puan
    if (stats.count >= 20) probability += 30;
    else if (stats.count >= 10) probability += 25;
    else if (stats.count >= 5) probability += 15;
    else probability += (stats.count / 5) * 15;
    
    // 2. Ortalama olasılık skoru (0-25 puan) - NaN kontrolü
    const avgScore = stats.avgProbabilityScore || 0;
    probability += (avgScore / 100) * 25;
    
    // 3. Ortalama büyüklük (0-20 puan) - NaN kontrolü
    const avgMag = stats.avgAvgMagnitude || 0;
    if (avgMag >= 5.0) probability += 20;
    else if (avgMag >= 4.0) probability += 15;
    else if (avgMag >= 3.0) probability += 10;
    else probability += (avgMag / 5.0) * 20;
    
    // 4. Benzersiz kullanıcı sayısı (0-15 puan)
    // Farklı kullanıcılar = daha güvenilir
    if (stats.uniqueUsers >= 10) probability += 15;
    else if (stats.uniqueUsers >= 5) probability += 10;
    else probability += (stats.uniqueUsers / 10) * 15;
    
    // 5. Zaman korelasyonu (0-10 puan)
    // Raporlar aynı anda mı geldi?
    const timeCorrelation = this._calculateTimeCorrelation(reports);
    probability += timeCorrelation * 10;
    
    return Math.min(100, Math.max(0, probability));
  }

  /**
   * Zaman korelasyonunu hesapla (0-1)
   */
  _calculateTimeCorrelation(reports) {
    if (reports.length < 2) return 0;
    
    // İlk ve son raporun zaman farkı
    const times = reports.map(r => r.receivedAt.getTime()).sort((a, b) => a - b);
    const timeSpan = (times[times.length - 1] - times[0]) / 1000; // saniye
    
    // 5 saniye içinde geldi = yüksek korelasyon
    if (timeSpan <= this.config.TIME_CORRELATION_WINDOW) return 1.0;
    if (timeSpan <= 10) return 0.8;
    if (timeSpan <= 20) return 0.5;
    return 0.2;
  }

  /**
   * Deprem tespit kriterlerini kontrol et
   */
  _meetsDetectionCriteria(stats, probability, reports) {
    if (!stats) return false;
    
    // KRİTER 1: Minimum rapor sayısı
    if (stats.count < this.config.MIN_REPORTS_FOR_DETECTION) {
      console.log(`❌ Yetersiz rapor: ${stats.count} < ${this.config.MIN_REPORTS_FOR_DETECTION}`);
      return false;
    }
    
    // KRİTER 2: Minimum benzersiz kullanıcı
    if (stats.uniqueUsers < 3) {
      console.log(`❌ Yetersiz benzersiz kullanıcı: ${stats.uniqueUsers} < 3`);
      return false;
    }
    
    // KRİTER 3: Minimum olasılık skoru
    if (probability < this.config.MIN_PROBABILITY_SCORE) {
      console.log(`❌ Düşük olasılık: ${probability.toFixed(1)}% < ${this.config.MIN_PROBABILITY_SCORE}%`);
      return false;
    }
    
    // KRİTER 4: Minimum ortalama büyüklük
    if (stats.avgAvgMagnitude < this.config.MIN_AVG_MAGNITUDE) {
      console.log(`❌ Düşük büyüklük: ${stats.avgAvgMagnitude.toFixed(2)} < ${this.config.MIN_AVG_MAGNITUDE}`);
      return false;
    }
    
    // KRİTER 5: Zaman korelasyonu
    const timeCorrelation = this._calculateTimeCorrelation(reports);
    if (timeCorrelation < 0.3) {
      console.log(`❌ Düşük zaman korelasyonu: ${(timeCorrelation * 100).toFixed(1)}%`);
      return false;
    }
    
    console.log(`✅ TÜM KRİTERLER SAĞLANDI!`);
    console.log(`   📊 Rapor: ${stats.count}`);
    console.log(`   👥 Benzersiz Kullanıcı: ${stats.uniqueUsers}`);
    console.log(`   📈 Olasılık: ${probability.toFixed(1)}%`);
    console.log(`   📏 Ortalama Büyüklük: ${stats.avgAvgMagnitude.toFixed(2)} m/s²`);
    console.log(`   ⏱️ Zaman Korelasyonu: ${(timeCorrelation * 100).toFixed(1)}%`);
    // P2P deprem tespit logu dosyaya yaz
    const fs = require('fs');
    const detectionLogLine = `${new Date().toISOString()} | P2P DEPREM ALGILANDI | Rapor:${stats.count} | Benzersiz Kullanıcı:${stats.uniqueUsers} | Olasılık:${probability.toFixed(1)}% | Ortalama Büyüklük:${stats.avgAvgMagnitude.toFixed(2)} m/s² | Zaman Korelasyonu:${(timeCorrelation * 100).toFixed(1)}%\n`;
    fs.appendFile('p2p_detection_log.txt', detectionLogLine, (err) => {
      if (err) console.error('P2P detection log dosyasına yazılamadı:', err);
    });
    
    return true;
  }

  /**
   * Merkez üssü tahmin et (ağırlıklı ortalama)
   */
  _estimateEpicenter(reports) {
    if (reports.length === 0) return { latitude: 0, longitude: 0 };
    
    // En yüksek skor'a sahip raporlara daha fazla ağırlık ver
    let totalWeight = 0;
    let weightedLat = 0;
    let weightedLon = 0;
    
    for (const report of reports) {
      const weight = report.sensorData.probabilityScore;
      weightedLat += report.location.latitude * weight;
      weightedLon += report.location.longitude * weight;
      totalWeight += weight;
    }
    
    return {
      latitude: weightedLat / totalWeight,
      longitude: weightedLon / totalWeight,
    };
  }

  /**
   * Büyüklük tahmin et (Richter benzeri)
   */
  _estimateMagnitude(stats, reports) {
    if (!stats || !stats.avgMaxMagnitude || isNaN(stats.avgMaxMagnitude)) {
      console.log('⚠️ Geçersiz magnitude verisi, 3.0 varsayılan değeri kullanılıyor');
      return 3.0;
    }
    
    // İvmeölçer verilerinden Richter tahmini (yaklaşık formül)
    // M = log10(A) + f(distance)
    // A = maksimum ivme (m/s²)
    
    const avgMaxAcceleration = stats.avgMaxMagnitude;
    
    // Basit dönüşüm formülü (gerçek deprem için kalibre edilmeli)
    let magnitude = 0;
    
    if (avgMaxAcceleration >= 10.0) magnitude = 6.5; // Çok güçlü
    else if (avgMaxAcceleration >= 8.0) magnitude = 6.0;
    else if (avgMaxAcceleration >= 6.0) magnitude = 5.5;
    else if (avgMaxAcceleration >= 5.0) magnitude = 5.0;
    else if (avgMaxAcceleration >= 4.0) magnitude = 4.5;
    else if (avgMaxAcceleration >= 3.0) magnitude = 4.0;
    else magnitude = 3.0 + (avgMaxAcceleration / 3.0) * 1.0;
    
    // Rapor sayısına göre düzelt (fazla rapor = daha büyük)
    if (stats.count >= 20) magnitude += 0.3;
    else if (stats.count >= 10) magnitude += 0.2;
    
    return parseFloat(magnitude.toFixed(1));
  }

  /**
   * Bölge adını getir
   */
  async _getRegionName(lat, lon) {
    // Basit bölge tespiti (Production'da reverse geocoding API kullan)
    if (lat >= 36 && lat <= 42 && lon >= 26 && lon <= 45) {
      // Türkiye alt bölgeleri
      if (lat >= 40 && lat <= 42 && lon >= 28 && lon <= 30) return 'İstanbul';
      if (lat >= 38 && lat <= 39 && lon >= 27 && lon <= 28) return 'İzmir';
      if (lat >= 39 && lat <= 41 && lon >= 32 && lon <= 34) return 'Ankara';
      if (lat >= 40 && lat <= 42 && lon >= 39 && lon <= 42) return 'Erzurum';
      return 'Türkiye';
    }
    return 'Unknown';
  }

  /**
   * Deprem tespiti işle
   */
  async _handleEarthquakeDetection(analysis) {
    const earthquakeId = `P2P_${Date.now()}_${analysis.estimatedEpicenter.latitude.toFixed(4)}_${analysis.estimatedEpicenter.longitude.toFixed(4)}`;
    
    // Cache'de var mı kontrol et (duplike önleme)
    if (this.detectedEarthquakes.has(earthquakeId)) {
      console.log(`⚠️ Duplike deprem tespiti: ${earthquakeId}`);
      return;
    }
    
    console.log(`🚨🚨🚨 DEPREM TESPİT EDİLDİ! 🚨🚨🚨`);
    console.log(`   📍 Bölge: ${analysis.regionName}`);
    console.log(`   📊 Tahmini Büyüklük: M${analysis.estimatedMagnitude}`);
    console.log(`   🎯 Merkez Üssü: ${analysis.estimatedEpicenter.latitude.toFixed(4)}, ${analysis.estimatedEpicenter.longitude.toFixed(4)}`);
    console.log(`   👥 Rapor Sayısı: ${analysis.totalReports}`);
    console.log(`   📈 Olasılık: ${analysis.earthquakeProbability.toFixed(1)}%`);
    
    // Cache'e ekle (5 dakika)
    this.detectedEarthquakes.set(earthquakeId, {
      ...analysis,
      detectedAt: new Date(),
      id: earthquakeId,
    });
    
    setTimeout(() => {
      this.detectedEarthquakes.delete(earthquakeId);
    }, 5 * 60 * 1000);
    
    // Database'e kaydet
    try {
      const Earthquake = require('../models/Earthquake');
      await Earthquake.create({
        eventId: earthquakeId,
        mag: analysis.estimatedMagnitude,
        magnitude: analysis.estimatedMagnitude,
        coordinates: {
          type: 'Point',
          coordinates: [analysis.estimatedEpicenter.longitude, analysis.estimatedEpicenter.latitude]
        },
        location: {
          latitude: analysis.estimatedEpicenter.latitude,
          longitude: analysis.estimatedEpicenter.longitude
        },
        place: `${analysis.regionName} (P2P Detected)`,
        region: analysis.regionName,
        time: new Date(),
        timestamp: new Date(),
        source: 'P2P',
        depth: 10, // Varsayılan
        type: 'earthquake',
      });
      console.log(`✅ P2P depremi database'e kaydedildi`);
    } catch (dbError) {
      console.error('❌ Database kayıt hatası:', dbError);
    }
    
    // Priority notification sistemini tetikle
    try {
      const priorityNotificationService = require('./priorityNotificationService');
      if (priorityNotificationService && typeof priorityNotificationService.sendPriorityEarthquakeNotifications === 'function') {
        await priorityNotificationService.sendPriorityEarthquakeNotifications({
          eventId: earthquakeId,
          mag: analysis.estimatedMagnitude,
          magnitude: analysis.estimatedMagnitude,
          place: `${analysis.regionName} (P2P Detected)`,
          location: {
            latitude: analysis.estimatedEpicenter.latitude,
            longitude: analysis.estimatedEpicenter.longitude
          },
          coordinates: {
            type: 'Point',
            coordinates: [analysis.estimatedEpicenter.longitude, analysis.estimatedEpicenter.latitude]
          },
          time: new Date(),
          source: 'P2P',
          depth: 10,
        });
        console.log(`✅ Priority notifications gönderildi`);
      } else {
        console.log('⚠️ Priority notification servisi bulunamadı veya fonksiyon yok');
      }
    } catch (notifError) {
      console.error('❌ Notification hatası:', notifError.message);
    }
  }

  /**
   * İstatistikler
   */
  getStatistics() {
    return {
      totalReports: this.recentReports.length,
      detectedEarthquakes: this.detectedEarthquakes.size,
      recentDetections: Array.from(this.detectedEarthquakes.values()),
    };
  }
}

module.exports = P2PEarthquakeAnalyzer;
