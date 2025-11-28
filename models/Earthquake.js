const mongoose = require('mongoose');

const earthquakeSchema = new mongoose.Schema({
  // Unique identifier
  eventId: { 
    type: String, 
    required: true, 
    unique: true, 
    index: true 
  },
  
  // Magnitude (use 'mag' for consistency with routes)
  mag: { 
    type: Number, 
    required: true, 
    index: true 
  },
  magnitude: { type: Number }, // Keep for backward compatibility
  
  // Depth in km
  depth: { 
    type: Number, 
    required: true 
  },
  
  // GeoJSON Point for geospatial queries
  coordinates: {
    type: {
      type: String,
      enum: ['Point'],
      default: 'Point'
    },
    coordinates: {
      type: [Number], // [longitude, latitude]
      required: true,
      index: '2dsphere'
    }
  },
  
  // Legacy location format (backward compatibility)
  location: {
    latitude: Number,
    longitude: Number
  },
  
  // Location description
  place: String,
  region: String,
  
  // Time
  time: { 
    type: Date, 
    required: true, 
    index: true 
  },
  timestamp: { type: Date }, // Backward compatibility
  
  // Source
  source: {
    type: [String],
    enum: ['AFAD', 'Kandilli', 'USGS', 'EMSC', 'P2P'],
    required: true,
    index: true
  },
  
  // Additional fields
  url: String,
  type: String,
  magnitude_type: String,
  
  // Notification tracking
  notificationSent: {
    type: Boolean,
    default: false
  },
  
  notificationStats: {
    totalSent: { type: Number, default: 0 },
    totalSkipped: { type: Number, default: 0 },
    sentAt: Date
  }
}, {
  timestamps: true
});

// Indexes
earthquakeSchema.index({ mag: -1, time: -1 });
earthquakeSchema.index({ source: 1, time: -1 });
earthquakeSchema.index({ 'coordinates.coordinates': '2dsphere' });

// Pre-save: Sync mag and magnitude, time and timestamp
earthquakeSchema.pre('save', function(next) {
  if (this.mag && !this.magnitude) this.magnitude = this.mag;
  if (this.magnitude && !this.mag) this.mag = this.magnitude;
  if (this.time && !this.timestamp) this.timestamp = this.time;
  if (this.timestamp && !this.time) this.time = this.timestamp;
  
  // Sync GeoJSON and legacy location
  if (this.coordinates && this.coordinates.coordinates) {
    const [lon, lat] = this.coordinates.coordinates;
    if (!this.location) this.location = {};
    this.location.latitude = lat;
    this.location.longitude = lon;
  }
  next();
});

// Static: Find near location
earthquakeSchema.statics.findNearLocation = function(lat, lon, radiusKm, options = {}) {
  const query = {
    'coordinates.coordinates': {
      $near: {
        $geometry: {
          type: 'Point',
          coordinates: [lon, lat]
        },
        $maxDistance: radiusKm * 1000
      }
    }
  };
  
  if (options.minMagnitude) query.mag = { $gte: options.minMagnitude };
  if (options.maxMagnitude) query.mag = { ...query.mag, $lte: options.maxMagnitude };
  if (options.startTime) query.time = { $gte: new Date(options.startTime) };
  
  return this.find(query).limit(options.limit || 100).sort({ time: -1 });
};

// Static: Get recent earthquakes
earthquakeSchema.statics.recent = function(limit = 50, minMag = 0, since = null) {
  const query = {};
  if (minMag) query.mag = { $gte: minMag };
  if (since) query.time = { $gte: since };
  return this.find(query).sort({ time: -1 }).limit(limit).lean();
};

module.exports = mongoose.model('Earthquake', earthquakeSchema);
