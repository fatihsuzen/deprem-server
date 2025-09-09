const mongoose = require('mongoose');

const friendRequestSchema = new mongoose.Schema({
  fromUser: {
    type: String, // UID
    required: true,
    ref: 'User'
  },
  toUser: {
    type: String, // UID
    required: true,
    ref: 'User'
  },
  message: {
    type: String,
    default: '',
    maxlength: 200
  },
  status: {
    type: String,
    enum: ['pending', 'accepted', 'rejected', 'cancelled'],
    default: 'pending',
    index: true
  },
  sentAt: {
    type: Date,
    default: Date.now
  },
  respondedAt: {
    type: Date,
    default: null
  }
}, {
  timestamps: true
});

// Composite indexes
friendRequestSchema.index({ fromUser: 1, toUser: 1 });
friendRequestSchema.index({ toUser: 1, status: 1 });
friendRequestSchema.index({ fromUser: 1, status: 1 });
friendRequestSchema.index({ sentAt: -1 });

// Prevent duplicate friend requests
friendRequestSchema.index(
  { fromUser: 1, toUser: 1, status: 1 },
  { 
    unique: true,
    partialFilterExpression: { status: 'pending' }
  }
);

// Static methods
friendRequestSchema.statics.getPendingRequests = function(userId) {
  return this.find({ 
    toUser: userId, 
    status: 'pending' 
  })
  .populate('fromUser', 'displayName email photoURL')
  .sort({ sentAt: -1 });
};

friendRequestSchema.statics.getSentRequests = function(userId) {
  return this.find({ 
    fromUser: userId, 
    status: 'pending' 
  })
  .populate('toUser', 'displayName email photoURL shareCode')
  .sort({ sentAt: -1 });
};

// Check if friend request already exists
friendRequestSchema.statics.requestExists = function(fromUserId, toUserId) {
  return this.findOne({
    $or: [
      { fromUser: fromUserId, toUser: toUserId, status: 'pending' },
      { fromUser: toUserId, toUser: fromUserId, status: 'pending' }
    ]
  });
};

module.exports = mongoose.model('FriendRequest', friendRequestSchema);
