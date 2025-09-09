class GeoService {
  constructor() {
    this.turkishCities = this.initializeTurkishCities();
    this.regions = this.initializeRegions();
  }

  calculateDistance(lat1, lon1, lat2, lon2) {
    const R = 6371; // Earth's radius in kilometers
    const dLat = this.toRadians(lat2 - lat1);
    const dLon = this.toRadians(lon2 - lon1);
    
    const a = Math.sin(dLat/2) * Math.sin(dLat/2) +
              Math.cos(this.toRadians(lat1)) * Math.cos(this.toRadians(lat2)) *
              Math.sin(dLon/2) * Math.sin(dLon/2);
    
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    
    return R * c;
  }

  findNearestCity(latitude, longitude) {
    let nearestCity = null;
    let minDistance = Infinity;

    for (const city of this.turkishCities) {
      const distance = this.calculateDistance(
        latitude, longitude,
        city.latitude, city.longitude
      );

      if (distance < minDistance) {
        minDistance = distance;
        nearestCity = {
          ...city,
          distance: Math.round(distance)
        };
      }
    }

    return nearestCity;
  }

  getCitiesInRadius(centerLat, centerLon, radiusKm) {
    const citiesInRadius = [];

    for (const city of this.turkishCities) {
      const distance = this.calculateDistance(
        centerLat, centerLon,
        city.latitude, city.longitude
      );

      if (distance <= radiusKm) {
        citiesInRadius.push({
          ...city,
          distance: Math.round(distance)
        });
      }
    }

    return citiesInRadius.sort((a, b) => a.distance - b.distance);
  }

  getRegionByLocation(latitude, longitude) {
    for (const region of this.regions) {
      if (this.isPointInRegion(latitude, longitude, region)) {
        return region;
      }
    }

    return {
      name: 'Bilinmeyen Bölge',
      code: 'UNKNOWN',
      type: 'unknown'
    };
  }

  isPointInRegion(lat, lon, region) {
    // Simple bounding box check for regions
    return lat >= region.bounds.south &&
           lat <= region.bounds.north &&
           lon >= region.bounds.west &&
           lon <= region.bounds.east;
  }

  estimateIntensityByDistance(magnitude, distanceKm) {
    // Simplified intensity calculation based on magnitude and distance
    // Real seismology uses more complex formulas
    
    if (distanceKm === 0) distanceKm = 1; // Avoid division by zero
    
    const baseIntensity = magnitude;
    const attenuationFactor = Math.log10(distanceKm) * 0.5;
    const estimatedIntensity = Math.max(1, baseIntensity - attenuationFactor);
    
    return {
      intensity: Math.round(estimatedIntensity * 10) / 10,
      description: this.getIntensityDescription(estimatedIntensity),
      mercalli: this.convertToMercalli(estimatedIntensity)
    };
  }

  getIntensityDescription(intensity) {
    if (intensity >= 8) return 'Yıkıcı';
    if (intensity >= 7) return 'Çok Şiddetli';
    if (intensity >= 6) return 'Şiddetli';
    if (intensity >= 5) return 'Orta';
    if (intensity >= 4) return 'Hafif';
    if (intensity >= 3) return 'Zayıf';
    return 'Hissedilmez';
  }

  convertToMercalli(intensity) {
    const mercalliScale = [
      { min: 0, max: 1.9, level: 'I', description: 'Hissedilmez' },
      { min: 2.0, max: 2.9, level: 'II', description: 'Çok zayıf' },
      { min: 3.0, max: 3.9, level: 'III', description: 'Zayıf' },
      { min: 4.0, max: 4.9, level: 'IV', description: 'Hafif' },
      { min: 5.0, max: 5.9, level: 'V', description: 'Orta' },
      { min: 6.0, max: 6.9, level: 'VI', description: 'Güçlü' },
      { min: 7.0, max: 7.9, level: 'VII', description: 'Çok güçlü' },
      { min: 8.0, max: 8.9, level: 'VIII', description: 'Şiddetli' },
      { min: 9.0, max: 9.9, level: 'IX', description: 'Yıkıcı' },
      { min: 10.0, max: 10.9, level: 'X', description: 'Çok yıkıcı' },
      { min: 11.0, max: 11.9, level: 'XI', description: 'Felaket' },
      { min: 12.0, max: 15.0, level: 'XII', description: 'Tam yıkım' }
    ];

    for (const scale of mercalliScale) {
      if (intensity >= scale.min && intensity <= scale.max) {
        return scale;
      }
    }

    return mercalliScale[0]; // Default to minimum
  }

  calculateEpicenterFromMultiplePoints(detectionPoints) {
    if (detectionPoints.length === 0) return null;
    if (detectionPoints.length === 1) return detectionPoints[0].location;

    // Calculate weighted centroid based on magnitude/confidence
    let totalLat = 0, totalLon = 0, totalWeight = 0;

    for (const point of detectionPoints) {
      const weight = point.magnitude || point.confidence || 1;
      totalLat += point.location.latitude * weight;
      totalLon += point.location.longitude * weight;
      totalWeight += weight;
    }

    return {
      latitude: totalLat / totalWeight,
      longitude: totalLon / totalWeight,
      confidence: Math.min(1, detectionPoints.length / 5) // Higher confidence with more detection points
    };
  }

  createGeofence(centerLat, centerLon, radiusKm) {
    // Create a circular geofence for notification targeting
    const points = [];
    const numPoints = 16; // 16-sided polygon approximation
    
    for (let i = 0; i < numPoints; i++) {
      const angle = (i * 2 * Math.PI) / numPoints;
      const lat = centerLat + (radiusKm / 111) * Math.cos(angle);
      const lon = centerLon + (radiusKm / (111 * Math.cos(this.toRadians(centerLat)))) * Math.sin(angle);
      
      points.push({ latitude: lat, longitude: lon });
    }
    
    return {
      center: { latitude: centerLat, longitude: centerLon },
      radius: radiusKm,
      polygon: points,
      area: Math.PI * Math.pow(radiusKm, 2) // km²
    };
  }

  toRadians(degrees) {
    return degrees * (Math.PI / 180);
  }

  toDegrees(radians) {
    return radians * (180 / Math.PI);
  }

  initializeTurkishCities() {
    return [
      { name: 'İstanbul', latitude: 41.0082, longitude: 28.9784, population: 15462452, isCapital: false },
      { name: 'Ankara', latitude: 39.9334, longitude: 32.8597, population: 5503985, isCapital: true },
      { name: 'İzmir', latitude: 38.4237, longitude: 27.1428, population: 4367251, isCapital: false },
      { name: 'Bursa', latitude: 40.1826, longitude: 29.0665, population: 3056120, isCapital: false },
      { name: 'Antalya', latitude: 36.8969, longitude: 30.7133, population: 2511700, isCapital: false },
      { name: 'Adana', latitude: 37.0000, longitude: 35.3213, population: 2237940, isCapital: false },
      { name: 'Konya', latitude: 37.8746, longitude: 32.4932, population: 2205609, isCapital: false },
      { name: 'Şanlıurfa', latitude: 37.1674, longitude: 38.7955, population: 2073614, isCapital: false },
      { name: 'Gaziantep', latitude: 37.0662, longitude: 37.3833, population: 2028563, isCapital: false },
      { name: 'Kocaeli', latitude: 40.8533, longitude: 29.8815, population: 1953035, isCapital: false },
      { name: 'Mersin', latitude: 36.8000, longitude: 34.6333, population: 1840425, isCapital: false },
      { name: 'Diyarbakır', latitude: 37.9144, longitude: 40.2306, population: 1756353, isCapital: false },
      { name: 'Hatay', latitude: 36.4018, longitude: 36.3498, population: 1659320, isCapital: false },
      { name: 'Manisa', latitude: 38.6191, longitude: 27.4289, population: 1429643, isCapital: false },
      { name: 'Kayseri', latitude: 38.7312, longitude: 35.4787, population: 1421455, isCapital: false },
      { name: 'Samsun', latitude: 41.2928, longitude: 36.3313, population: 1356079, isCapital: false },
      { name: 'Balıkesir', latitude: 39.6484, longitude: 27.8826, population: 1257590, isCapital: false },
      { name: 'Malatya', latitude: 38.3552, longitude: 38.3095, population: 797036, isCapital: false },
      { name: 'Kahramanmaraş', latitude: 37.5858, longitude: 36.9371, population: 1168163, isCapital: false },
      { name: 'Van', latitude: 38.4891, longitude: 43.4089, population: 1136757, isCapital: false },
      { name: 'Aydın', latitude: 37.8560, longitude: 27.8416, population: 1119084, isCapital: false },
      { name: 'Denizli', latitude: 37.7765, longitude: 29.0864, population: 1037208, isCapital: false },
      { name: 'Sakarya', latitude: 40.6940, longitude: 30.4358, population: 1010700, isCapital: false },
      { name: 'Muğla', latitude: 37.2153, longitude: 28.3636, population: 967487, isCapital: false },
      { name: 'Tekirdağ', latitude: 40.9833, longitude: 27.5167, population: 1029927, isCapital: false }
    ];
  }

  initializeRegions() {
    return [
      {
        name: 'Marmara Bölgesi',
        code: 'TR1',
        type: 'region',
        bounds: {
          north: 42.0,
          south: 39.5,
          east: 30.5,
          west: 26.0
        },
        riskLevel: 'high',
        faultLines: ['Kuzey Anadolu Fayı', 'Marmara Fayı']
      },
      {
        name: 'Ege Bölgesi',
        code: 'TR3',
        type: 'region',
        bounds: {
          north: 40.0,
          south: 35.5,
          east: 30.0,
          west: 26.0
        },
        riskLevel: 'high',
        faultLines: ['Batı Anadolu Fayları']
      },
      {
        name: 'Akdeniz Bölgesi',
        code: 'TR6',
        type: 'region',
        bounds: {
          north: 38.0,
          south: 35.5,
          east: 37.0,
          west: 28.0
        },
        riskLevel: 'medium',
        faultLines: ['Doğu Anadolu Fayı']
      },
      {
        name: 'Doğu Anadolu Bölgesi',
        code: 'TRA',
        type: 'region',
        bounds: {
          north: 42.0,
          south: 37.0,
          east: 45.0,
          west: 38.0
        },
        riskLevel: 'very_high',
        faultLines: ['Doğu Anadolu Fayı', 'Kuzey Anadolu Fayı']
      }
    ];
  }

  // Utility methods for testing and debugging
  generateTestLocation(regionName = null) {
    if (regionName) {
      const region = this.regions.find(r => r.name.includes(regionName));
      if (region) {
        const lat = region.bounds.south + Math.random() * (region.bounds.north - region.bounds.south);
        const lon = region.bounds.west + Math.random() * (region.bounds.east - region.bounds.west);
        return { latitude: lat, longitude: lon };
      }
    }

    // Random location in Turkey
    return {
      latitude: 36 + Math.random() * 6, // 36-42 N
      longitude: 26 + Math.random() * 19 // 26-45 E
    };
  }

  getServiceStats() {
    return {
      totalCities: this.turkishCities.length,
      totalRegions: this.regions.length,
      majorCities: this.turkishCities.filter(c => c.population > 1000000).length,
      highRiskRegions: this.regions.filter(r => r.riskLevel === 'high' || r.riskLevel === 'very_high').length
    };
  }
}

module.exports = GeoService;
