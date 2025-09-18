const mongoose = require('mongoose');

const DeviceSchema = new mongoose.Schema({
  userId: { type: String, index: true },
  deviceId: { type: String, index: true },
  token: { type: String, required: true, index: true },
  // For Android MQTT approach we may store mqtt client id here or in mqttClientId
  mqttClientId: { type: String, index: true },
  platform: { type: String, enum: ['android','ios','web'], default: 'android' },
  lastSeen: { type: Date, default: Date.now },
  location: {
    latitude: { type: Number },
    longitude: { type: Number }
  },
  deviceInfo: { type: mongoose.Schema.Types.Mixed }
}, { timestamps: true });

module.exports = mongoose.model('Device', DeviceSchema);
