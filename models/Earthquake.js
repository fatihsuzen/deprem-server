const mongoose = require('mongoose');

const earthquakeSchema = new mongoose.Schema({
  source: { type: String, index: true },
  eventId: { type: String, index: true },
  magnitude: { type: Number, index: true },
  depth: Number,
  location: {
    latitude: Number,
    longitude: Number
  },
  place: String,
  timestamp: { type: Date, index: true },
  url: String,
  type: String,
  createdAt: { type: Date, default: Date.now }
}, {
  timestamps: true
});

earthquakeSchema.index({ magnitude: -1, timestamp: -1 });
earthquakeSchema.index({ 'location.latitude': 1, 'location.longitude': 1 });

earthquakeSchema.statics.recent = function(limit = 50, minMag = 0, since = null) {
  const query = {};
  if (minMag) query.magnitude = { $gte: minMag };
  if (since) query.timestamp = { $gte: since };
  return this.find(query).sort({ timestamp: -1 }).limit(limit).lean();
};

module.exports = mongoose.model('Earthquake', earthquakeSchema);
