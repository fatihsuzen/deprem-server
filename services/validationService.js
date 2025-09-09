class ValidationService {
  constructor() {
    this.earthquakeThresholds = {
      magnitude: {
        minor: 1.0,      // Barely detectable
        light: 2.5,      // Weak, felt by few
        moderate: 4.0,   // Felt by many
        strong: 6.0,     // Damaging
        major: 7.0,      // Serious damage
        great: 8.0       // Devastating
      },
      acceleration: {
        pWave: 0.02,     // m/s² - P-wave detection threshold
        sWave: 0.05,     // m/s² - S-wave detection threshold
        strong: 0.1      // m/s² - Strong motion threshold
      },
      frequency: {
        pWave: [5, 15],  // Hz - P-wave frequency range
        sWave: [1, 5],   // Hz - S-wave frequency range
        noise: [20, 100] // Hz - Noise frequency range
      }
    };

    this.validationBuffer = new Map(); // Store recent validations
    this.deviceReliability = new Map(); // Track device accuracy
  }

  async analyzeSeismicData(data) {
    const { deviceId, accelerometer, gyroscope, timestamp, location } = data;
    
    try {
      // Calculate total acceleration magnitude
      const accMagnitude = Math.sqrt(
        Math.pow(accelerometer.x, 2) + 
        Math.pow(accelerometer.y, 2) + 
        Math.pow(accelerometer.z, 2)
      );

      // Calculate gyroscope magnitude
      const gyroMagnitude = Math.sqrt(
        Math.pow(gyroscope.x, 2) + 
        Math.pow(gyroscope.y, 2) + 
        Math.pow(gyroscope.z, 2)
      );

      // Earthquake pattern analysis
      const analysis = {
        isPotentialEarthquake: false,
        confidence: 0,
        estimatedMagnitude: 0,
        waveType: 'unknown',
        deviceId,
        timestamp,
        location
      };

      // P-Wave Detection (Initial, faster, lower amplitude)
      if (accMagnitude >= this.earthquakeThresholds.acceleration.pWave && 
          accMagnitude < this.earthquakeThresholds.acceleration.sWave) {
        
        analysis.isPotentialEarthquake = true;
        analysis.waveType = 'P-wave';
        analysis.confidence = this.calculatePWaveConfidence(accMagnitude, gyroMagnitude);
        analysis.estimatedMagnitude = this.estimateMagnitudeFromPWave(accMagnitude);
      }

      // S-Wave Detection (Secondary, slower, higher amplitude)
      else if (accMagnitude >= this.earthquakeThresholds.acceleration.sWave) {
        analysis.isPotentialEarthquake = true;
        analysis.waveType = 'S-wave';
        analysis.confidence = this.calculateSWaveConfidence(accMagnitude, gyroMagnitude);
        analysis.estimatedMagnitude = this.estimateMagnitudeFromSWave(accMagnitude);
      }

      // Filter out non-earthquake patterns
      if (analysis.isPotentialEarthquake) {
        const isNoise = this.detectNoise(accelerometer, gyroscope);
        const isWalking = this.detectWalking(accelerometer, gyroscope);
        const isVehicle = this.detectVehicle(accelerometer, gyroscope);

        if (isNoise || isWalking || isVehicle) {
          analysis.isPotentialEarthquake = false;
          analysis.confidence = 0;
        }
      }

      // Store analysis for ML training
      this.storeAnalysisForTraining(deviceId, data, analysis);

      return analysis;

    } catch (error) {
      console.error('Seismic analysis error:', error);
      return {
        isPotentialEarthquake: false,
        confidence: 0,
        error: error.message
      };
    }
  }

  async crossValidateEarthquake(data) {
    const { location, magnitude, deviceId } = data;
    const validationRadius = this.getValidationRadius(magnitude);
    
    // Find nearby devices (within validation radius)
    const nearbyDevices = this.getNearbyDevices(location, validationRadius);
    
    if (nearbyDevices.length < 2) {
      return {
        isConfirmed: false,
        reason: 'Insufficient nearby devices for validation',
        requiredDevices: 3,
        foundDevices: nearbyDevices.length
      };
    }

    // Check if other devices detected similar patterns
    const confirmingDevices = await this.checkNearbyDetections(
      location, validationRadius, deviceId
    );

    const confirmationRatio = confirmingDevices.length / nearbyDevices.length;
    const isConfirmed = confirmationRatio >= 0.3; // 30% of nearby devices must confirm

    if (isConfirmed) {
      const epicenter = this.calculateEpicenter(confirmingDevices);
      const validatedMagnitude = this.calculateValidatedMagnitude(confirmingDevices);
      const affectedRadius = this.calculateAffectedRadius(validatedMagnitude);
      const sWaveArrivalTime = this.calculateSWaveArrival(epicenter, validatedMagnitude);

      return {
        isConfirmed: true,
        epicenter,
        magnitude: validatedMagnitude,
        affectedRadius,
        sWaveArrivalTime,
        confirmingDevices: confirmingDevices.length,
        totalNearbyDevices: nearbyDevices.length,
        confirmationRatio
      };
    }

    return {
      isConfirmed: false,
      reason: 'Insufficient device confirmation',
      confirmingDevices: confirmingDevices.length,
      requiredRatio: 0.3,
      actualRatio: confirmationRatio
    };
  }

  calculatePWaveConfidence(accMagnitude, gyroMagnitude) {
    // P-wave characteristics: Low amplitude, high frequency, compressional
    let confidence = 0;

    // Amplitude check
    if (accMagnitude >= 0.02 && accMagnitude <= 0.08) {
      confidence += 0.4;
    }

    // Low gyroscope activity (P-waves are compressional, less rotational)
    if (gyroMagnitude < 0.1) {
      confidence += 0.3;
    }

    // Additional pattern checks can be added here
    confidence += 0.3; // Base confidence for meeting threshold

    return Math.min(confidence, 1.0);
  }

  calculateSWaveConfidence(accMagnitude, gyroMagnitude) {
    // S-wave characteristics: Higher amplitude, lower frequency, shear motion
    let confidence = 0;

    // Amplitude check
    if (accMagnitude >= 0.05) {
      confidence += 0.5;
    }

    // Higher gyroscope activity (S-waves are shear, more rotational)
    if (gyroMagnitude >= 0.05) {
      confidence += 0.3;
    }

    confidence += 0.2; // Base confidence

    return Math.min(confidence, 1.0);
  }

  estimateMagnitudeFromPWave(accMagnitude) {
    // Simplified magnitude estimation from P-wave amplitude
    // Real implementation would use more complex seismological formulas
    return Math.max(1.0, 2.0 + Math.log10(accMagnitude * 100));
  }

  estimateMagnitudeFromSWave(accMagnitude) {
    // Simplified magnitude estimation from S-wave amplitude
    return Math.max(1.0, 1.5 + Math.log10(accMagnitude * 50));
  }

  detectNoise(accelerometer, gyroscope) {
    // High frequency, random patterns typically indicate electronic noise
    const totalVariation = Math.abs(accelerometer.x) + Math.abs(accelerometer.y) + Math.abs(accelerometer.z);
    const gyroVariation = Math.abs(gyroscope.x) + Math.abs(gyroscope.y) + Math.abs(gyroscope.z);
    
    return totalVariation > 10 || gyroVariation > 10; // Very high values = likely noise
  }

  detectWalking(accelerometer, gyroscope) {
    // Walking patterns: rhythmic, vertical acceleration dominance
    const verticalAcc = Math.abs(accelerometer.z);
    const horizontalAcc = Math.sqrt(Math.pow(accelerometer.x, 2) + Math.pow(accelerometer.y, 2));
    
    // Walking typically has strong vertical component
    return verticalAcc > horizontalAcc * 2 && verticalAcc < 5;
  }

  detectVehicle(accelerometer, gyroscope) {
    // Vehicle patterns: continuous low-frequency vibrations
    const totalAcc = Math.sqrt(
      Math.pow(accelerometer.x, 2) + 
      Math.pow(accelerometer.y, 2) + 
      Math.pow(accelerometer.z, 2)
    );
    
    // Vehicles: steady, moderate vibrations with high gyroscope activity
    return totalAcc > 0.5 && totalAcc < 2.0 && 
           Math.abs(gyroscope.x) > 0.5 || Math.abs(gyroscope.y) > 0.5;
  }

  getValidationRadius(magnitude) {
    // Validation radius based on magnitude (km)
    return Math.max(5, magnitude * 10);
  }

  getNearbyDevices(location, radiusKm) {
    // This would integrate with DeviceManager to get actual nearby devices
    // For now, return mock data
    return Array.from({length: Math.floor(Math.random() * 10) + 1}, (_, i) => ({
      deviceId: `device_${i}`,
      distance: Math.random() * radiusKm
    }));
  }

  async checkNearbyDetections(location, radiusKm, originDeviceId) {
    // Check if nearby devices detected similar seismic activity in last 10 seconds
    const timeWindow = 10000; // 10 seconds
    const now = Date.now();
    
    // Mock implementation - in real app, query DeviceManager's seismic data
    const mockConfirmingDevices = Array.from({length: Math.floor(Math.random() * 5)}, (_, i) => ({
      deviceId: `confirming_device_${i}`,
      magnitude: 2.0 + Math.random() * 3.0,
      timestamp: now - Math.random() * timeWindow,
      location: {
        latitude: location.latitude + (Math.random() - 0.5) * 0.1,
        longitude: location.longitude + (Math.random() - 0.5) * 0.1
      }
    }));

    return mockConfirmingDevices;
  }

  calculateEpicenter(confirmingDevices) {
    // Calculate weighted average of confirming device locations
    let totalLat = 0, totalLon = 0, totalWeight = 0;

    confirmingDevices.forEach(device => {
      const weight = device.magnitude || 1;
      totalLat += device.location.latitude * weight;
      totalLon += device.location.longitude * weight;
      totalWeight += weight;
    });

    return {
      latitude: totalLat / totalWeight,
      longitude: totalLon / totalWeight
    };
  }

  calculateValidatedMagnitude(confirmingDevices) {
    // Calculate average magnitude from confirming devices
    const magnitudes = confirmingDevices.map(d => d.magnitude || 0);
    return magnitudes.reduce((sum, mag) => sum + mag, 0) / magnitudes.length;
  }

  calculateAffectedRadius(magnitude) {
    // Estimate affected radius based on magnitude (km)
    return Math.pow(10, magnitude * 0.5) * 5;
  }

  calculateSWaveArrival(epicenter, magnitude) {
    // Estimate S-wave arrival time based on distance and magnitude
    // S-waves travel at ~3.5 km/s
    const sWaveSpeed = 3.5; // km/s
    const estimatedDistance = magnitude * 20; // rough estimate
    const arrivalDelaySeconds = estimatedDistance / sWaveSpeed;
    
    return new Date(Date.now() + arrivalDelaySeconds * 1000);
  }

  storeAnalysisForTraining(deviceId, originalData, analysis) {
    // Store for ML model training - could be sent to ML service
    console.log(`📊 ML Training Data: Device ${deviceId}, Earthquake: ${analysis.isPotentialEarthquake}, Confidence: ${analysis.confidence}`);
  }
}

module.exports = ValidationService;
