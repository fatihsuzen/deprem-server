const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
  uid: {
    type: String,
    required: true,
    unique: true,
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
    latitude: {
      type: Number,
      required: false
    },
    longitude: {
      type: Number,
      required: false
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
userSchema.methods.updateLocation = function(latitude, longitude, address) {
  this.location = {
    latitude,
    longitude,
    address,
    lastUpdate: new Date()
  };
  return this.save();
};

module.exports = mongoose.model('User', userSchema);
