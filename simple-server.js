const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const { body, validationResult } = require('express-validator');

const app = express();
const PORT = 3000;

// Middleware
app.use(cors());
app.use(express.json());

// MongoDB bağlantısı
mongoose.connect('mongodb://localhost:27017/earthquake_db', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

// User Schema
const userSchema = new mongoose.Schema({
  googleId: { type: String, required: true, unique: true },
  email: { type: String, required: true },
  displayName: { type: String, required: true },
  photoURL: { type: String, default: '' },
  shareCode: { type: String, required: true, unique: true },
  location: {
    latitude: { type: Number, default: null },
    longitude: { type: Number, default: null },
    lastUpdate: { type: Date, default: Date.now }
  },
  status: { type: String, enum: ['online', 'offline'], default: 'online' },
  lastSeen: { type: Date, default: Date.now },
  createdAt: { type: Date, default: Date.now }
});

// FriendRequest Schema
const friendRequestSchema = new mongoose.Schema({
  fromUserId: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
  toUserId: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
  status: { type: String, enum: ['pending', 'accepted', 'rejected'], default: 'pending' },
  message: { type: String, default: '' },
  createdAt: { type: Date, default: Date.now }
});

// Friendship Schema
const friendshipSchema = new mongoose.Schema({
  user1Id: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
  user2Id: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
  createdAt: { type: Date, default: Date.now }
});

const User = mongoose.model('User', userSchema);
const FriendRequest = mongoose.model('FriendRequest', friendRequestSchema);
const Friendship = mongoose.model('Friendship', friendshipSchema);

// Health check
app.get('/health', (req, res) => {
  res.json({ status: 'OK', message: 'Simple server running' });
});

// Create or update user
app.post('/api/friends/users/create-or-update', [
  body('googleId').notEmpty(),
  body('email').isEmail(),
  body('displayName').notEmpty(),
  body('shareCode').notEmpty()
], async (req, res) => {
  try {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
    }

    const { googleId, email, displayName, photoURL, shareCode } = req.body;
    
    const user = await User.findOneAndUpdate(
      { googleId },
      { 
        email, 
        displayName, 
        photoURL: photoURL || '',
        shareCode,
        lastSeen: new Date()
      },
      { upsert: true, new: true }
    );

    res.json({ success: true, user });
  } catch (error) {
    console.error('Create/Update user error:', error);
    res.status(500).json({ success: false, message: error.message });
  }
});

// Update user location
app.post('/api/friends/users/:userId/location', async (req, res) => {
  try {
    const { userId } = req.params;
    const { latitude, longitude } = req.body;

    const user = await User.findOneAndUpdate(
      { googleId: userId },
      { 
        'location.latitude': latitude,
        'location.longitude': longitude,
        'location.lastUpdate': new Date(),
        lastSeen: new Date(),
        status: 'online'
      },
      { new: true }
    );

    if (!user) {
      return res.status(404).json({ success: false, message: 'User not found' });
    }

    res.json({ success: true, user });
  } catch (error) {
    console.error('Update location error:', error);
    res.status(500).json({ success: false, message: error.message });
  }
});

// Get friends
app.get('/api/friends/friends', async (req, res) => {
  try {
    const userId = req.headers['x-firebase-uid'];
    if (!userId) {
      return res.status(401).json({ success: false, message: 'User ID required' });
    }

    const user = await User.findOne({ googleId: userId });
    if (!user) {
      return res.status(404).json({ success: false, message: 'User not found' });
    }

    // Find all friendships where this user is involved
    const friendships = await Friendship.find({
      $or: [{ user1Id: user._id }, { user2Id: user._id }]
    }).populate('user1Id user2Id');

    const friends = friendships.map(friendship => {
      const friend = friendship.user1Id._id.toString() === user._id.toString() 
        ? friendship.user2Id 
        : friendship.user1Id;
      
      return {
        id: friend._id,
        name: friend.displayName,
        email: friend.email,
        status: friend.status,
        lastSeen: friend.lastSeen.getTime(),
        location: friend.location
      };
    });

    res.json({ success: true, friends });
  } catch (error) {
    console.error('Get friends error:', error);
    res.status(500).json({ success: false, message: error.message });
  }
});

// Get pending requests
app.get('/api/friends/requests', async (req, res) => {
  try {
    const userId = req.headers['x-firebase-uid'];
    if (!userId) {
      return res.status(401).json({ success: false, message: 'User ID required' });
    }

    const user = await User.findOne({ googleId: userId });
    if (!user) {
      return res.status(404).json({ success: false, message: 'User not found' });
    }

    const requests = await FriendRequest.find({
      toUserId: user._id,
      status: 'pending'
    }).populate('fromUserId');

    const formattedRequests = requests.map(request => ({
      id: request._id,
      fromUserName: request.fromUserId.displayName,
      fromUserEmail: request.fromUserId.email,
      message: request.message,
      timestamp: request.createdAt.toISOString()
    }));

    res.json({ success: true, requests: formattedRequests });
  } catch (error) {
    console.error('Get requests error:', error);
    res.status(500).json({ success: false, message: error.message });
  }
});

// Send friend request
app.post('/api/friends/send-request', async (req, res) => {
  try {
    const userId = req.headers['x-firebase-uid'];
    const { targetShareCode, message } = req.body;

    const fromUser = await User.findOne({ googleId: userId });
    const toUser = await User.findOne({ shareCode: targetShareCode });

    if (!fromUser || !toUser) {
      return res.status(404).json({ success: false, message: 'User not found' });
    }

    if (fromUser._id.toString() === toUser._id.toString()) {
      return res.status(400).json({ success: false, message: 'Cannot send request to yourself' });
    }

    // Check if already friends
    const existingFriendship = await Friendship.findOne({
      $or: [
        { user1Id: fromUser._id, user2Id: toUser._id },
        { user1Id: toUser._id, user2Id: fromUser._id }
      ]
    });

    if (existingFriendship) {
      return res.status(400).json({ success: false, message: 'Already friends' });
    }

    // Check if request already exists
    const existingRequest = await FriendRequest.findOne({
      fromUserId: fromUser._id,
      toUserId: toUser._id,
      status: 'pending'
    });

    if (existingRequest) {
      return res.status(400).json({ success: false, message: 'Request already sent' });
    }

    const friendRequest = new FriendRequest({
      fromUserId: fromUser._id,
      toUserId: toUser._id,
      message: message || '',
      status: 'pending'
    });

    await friendRequest.save();
    res.json({ success: true, message: 'Friend request sent' });
  } catch (error) {
    console.error('Send request error:', error);
    res.status(500).json({ success: false, message: error.message });
  }
});

// Respond to friend request
app.post('/api/friends/requests/:requestId/respond', async (req, res) => {
  try {
    const { requestId } = req.params;
    const { accept } = req.body;
    const userId = req.headers['x-firebase-uid'];

    const user = await User.findOne({ googleId: userId });
    if (!user) {
      return res.status(404).json({ success: false, message: 'User not found' });
    }

    const friendRequest = await FriendRequest.findById(requestId).populate('fromUserId');
    if (!friendRequest) {
      return res.status(404).json({ success: false, message: 'Request not found' });
    }

    if (friendRequest.toUserId.toString() !== user._id.toString()) {
      return res.status(403).json({ success: false, message: 'Unauthorized' });
    }

    if (accept) {
      // Create friendship
      const friendship = new Friendship({
        user1Id: friendRequest.fromUserId._id,
        user2Id: user._id
      });
      await friendship.save();
      
      friendRequest.status = 'accepted';
    } else {
      friendRequest.status = 'rejected';
    }

    await friendRequest.save();
    res.json({ success: true, message: accept ? 'Friend request accepted' : 'Friend request rejected' });
  } catch (error) {
    console.error('Respond to request error:', error);
    res.status(500).json({ success: false, message: error.message });
  }
});

// Start server
mongoose.connection.once('open', () => {
  console.log('✅ MongoDB bağlantısı başarılı');
  app.listen(PORT, () => {
    console.log(`🚀 Simple Friends API Server running on port ${PORT}`);
    console.log(`🔗 API Endpoints: http://localhost:${PORT}/api/friends`);
  });
});

mongoose.connection.on('error', (error) => {
  console.error('❌ MongoDB bağlantı hatası:', error);
});
