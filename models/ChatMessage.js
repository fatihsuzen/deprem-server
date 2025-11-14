const mongoose = require('mongoose');

const chatMessageSchema = new mongoose.Schema({
  roomId: {
    type: String,
    required: true,
    index: true
  },
  uid: {
    type: String,
    required: true,
    index: true
  },
  displayName: {
    type: String,
    required: true
  },
  message: {
    type: String,
    required: true,
    maxlength: 500
  },
  timestamp: {
    type: Date,
    default: Date.now,
    index: true
  }
}, {
  timestamps: true
});

// Index for efficient queries
chatMessageSchema.index({ roomId: 1, timestamp: -1 });
chatMessageSchema.index({ uid: 1, timestamp: -1 });

module.exports = mongoose.model('ChatMessage', chatMessageSchema);
