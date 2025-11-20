const mongoose = require('mongoose');

const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
  uid: {
    type: String,
    required: true,
    unique: true,
    index: true
  },
  onesignalId: {
    type: String,
    default: null,
    index: true
  },
  email: {
    type: String,
    required: true,
    unique: true,
    lowercase: true,
    trim: true
  },
  displayName: {
    type: String,
    required: true,
    trim: true
  },
  photoURL: {
    type: String,
    default: null
  },
  shareCode: {
    type: String,
    required: true,
    unique: true,
    uppercase: true,
    length: 6,
    index: true
  },
  location: {
    type: {
      type: String,
      enum: ['Point'],
      default: 'Point'
    },
    coordinates: {
      type: [Number], // [longitude, latitude]
      default: null,
      index: '2dsphere' // Geospatial index for location queries
    },
    address: {
      type: String,
      default: ''
    },
    lastUpdate: {
      type: Date,
      default: null
    }
  },
  friends: [{
    type: String, // Friend's UID
    ref: 'User'
  }],
  isActive: {
    type: Boolean,
    default: true
  },
  deviceInfo: {
    deviceId: String,
    platform: String,
    appVersion: String,
    lastSeen: {
      type: Date,
      default: Date.now
    }
  },
  notificationPreferences: {
    enabled: { type: Boolean, default: true, index: true },
    radiusKm: { type: Number, default: 50 },
    minMagnitude: { type: Number, default: 4.0 }
  },
  notificationSettings: {
    notificationRadius: { type: Number, default: 100 }, // km
    minMagnitude: { type: Number, default: 2.5 },
    maxMagnitude: { type: Number, default: 10.0 }
  },
  deviceTokens: [{
    token: String,
    platform: String, // 'android', 'ios'
    addedAt: { type: Date, default: Date.now }
  }],
  settings: {
    minMagnitude: { type: Number, default: 2.5 },
    maxMagnitude: { type: Number, default: 10.0 },
    notificationRadius: { type: Number, default: 50 },
    notificationsEnabled: { type: Boolean, default: true },
    soundEnabled: { type: Boolean, default: true },
    vibrationEnabled: { type: Boolean, default: true },
    darkMode: { type: Boolean, default: false },
    language: { type: String, default: 'tr' },
    shareLocationWithFriends: { type: Boolean, default: true }
  },
  createdAt: {
    type: Date,
    default: Date.now
  },
  updatedAt: {
    type: Date,
    default: Date.now
  }
}, {
  timestamps: true
});

// Indexes for performance
userSchema.index({ shareCode: 1 });
userSchema.index({ email: 1 });
userSchema.index({ uid: 1 });
userSchema.index({ 'location.lastUpdate': -1 });
userSchema.index({ friends: 1 });

// Generate unique share code
userSchema.statics.generateShareCode = function() {
  const chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
  let result = '';
  for (let i = 0; i < 6; i++) {
    result += chars.charAt(Math.floor(Math.random() * chars.length));
  }
  return result;
};

// Check if share code is unique
userSchema.statics.isShareCodeUnique = async function(shareCode) {
  const existing = await this.findOne({ shareCode });
  return !existing;
};

// Update last seen
userSchema.methods.updateLastSeen = function() {
  this.deviceInfo.lastSeen = new Date();
  return this.save();
};

// Update location
userSchema.methods.updateLocation = function(latitude, longitude, address = '') {
  this.location = {
    type: 'Point',
    coordinates: [longitude, latitude], // GeoJSON format: [lon, lat]
    address,
    lastUpdate: new Date()
  };
  this.updatedAt = new Date();
  return this.save();
};

// Add device token
userSchema.methods.addDeviceToken = function(token, platform) {
  // Token zaten varsa güncelle
  const existingToken = this.deviceTokens.find(t => t.token === token);
  if (existingToken) {
    existingToken.addedAt = new Date();
  } else {
    this.deviceTokens.push({ token, platform, addedAt: new Date() });
  }
  return this.save();
};

// Remove device token
userSchema.methods.removeDeviceToken = function(token) {
  this.deviceTokens = this.deviceTokens.filter(t => t.token !== token);
  return this.save();
};

module.exports = mongoose.model('User', userSchema);
