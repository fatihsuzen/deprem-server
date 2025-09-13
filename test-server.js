const express = require('express');
const app = express();
const PORT = process.env.PORT || 3005;

app.use(express.json());

// Health check
app.get('/health', (req, res) => {
  res.json({ status: 'OK', message: 'Test server running', port: PORT });
});

// Mock data
let users = [
  { _id: 'test_user_123', email: 'test@example.com', displayName: 'Test Kullanıcı (Mock)', shareCode: 'TEST123' },
  { _id: 'zeynep_001', email: 'zeynep@example.com', displayName: 'Zeynep Şahin', shareCode: 'ZEYNEP456' },
  { _id: 'can_002', email: 'can@example.com', displayName: 'Can Yılmaz', shareCode: 'CAN789' }
];

let friendships = [];

let friendRequests = [
  {
    _id: 'req_001',
    fromUser: { _id: 'zeynep_001', displayName: 'Zeynep Şahin', email: 'zeynep@example.com', photoURL: null },
    toUser: { _id: 'test_user_123' },
    message: 'Merhaba! Deprem uygulamasından arkadaş olmak ister misin?',
    sentAt: new Date(Date.now() - 3600000).toISOString(), // 1 hour ago
    status: 'pending'
  },
  {
    _id: 'req_002',
    fromUser: { _id: 'can_002', displayName: 'Can Yılmaz', email: 'can@example.com', photoURL: null },
    toUser: { _id: 'test_user_123' },
    message: 'Selam! Aynı şehirde yaşıyoruz, arkadaş olalım mı?',
    sentAt: new Date(Date.now() - 1800000).toISOString(), // 30 min ago
    status: 'pending'
  }
];

// Health check
app.get('/health', (req, res) => {
  res.json({ status: 'OK', timestamp: new Date().toISOString() });
});

// Get friends
app.get('/api/friends/friends', (req, res) => {
  const userId = req.headers['x-firebase-uid'];
  console.log(`📡 GET /api/friends/friends - User: ${userId}`);
  
  const userFriends = friendships
    .filter(f => f.user1 === userId || f.user2 === userId)
    .map(f => {
      const friendId = f.user1 === userId ? f.user2 : f.user1;
      const friend = users.find(u => u._id === friendId);
      return {
        _id: friend._id,
        displayName: friend.displayName,
        email: friend.email,
        shareCode: friend.shareCode,
        lastSeen: new Date()
      };
    });

  res.json({ success: true, friends: userFriends, count: userFriends.length });
});

// Get friend requests
app.get('/api/friends/requests', (req, res) => {
  const userId = req.headers['x-firebase-uid'];
  console.log(`📡 GET /api/friends/requests - User: ${userId}`);
  
  const userRequests = friendRequests.filter(r => r.toUser._id === userId && r.status === 'pending');
  
  res.json({ 
    success: true, 
    pendingRequests: userRequests,
    count: userRequests.length 
  });
});

// Send friend request
app.post('/api/friends/send-request', (req, res) => {
  const userId = req.headers['x-firebase-uid'];
  const { shareCode, message } = req.body;
  
  console.log(`📡 POST /api/friends/send-request - User: ${userId}, ShareCode: ${shareCode}`);
  
  const targetUser = users.find(u => u.shareCode === shareCode);
  if (!targetUser) {
    return res.status(404).json({ success: false, error: 'Kullanıcı bulunamadı' });
  }
  
  const fromUser = users.find(u => u._id === userId);
  
  const newRequest = {
    _id: `req_${Date.now()}`,
    fromUser: { _id: fromUser._id, displayName: fromUser.displayName, email: fromUser.email, photoURL: null },
    toUser: { _id: targetUser._id },
    message: message || '',
    sentAt: new Date().toISOString(),
    status: 'pending'
  };
  
  friendRequests.push(newRequest);
  
  res.json({ success: true, message: 'Arkadaş isteği gönderildi' });
});

// Respond to friend request
app.post('/api/friends/respond', (req, res) => {
  const userId = req.headers['x-firebase-uid'];
  const { requestId, accept } = req.body;
  
  console.log(`📡 POST /api/friends/respond - User: ${userId}, Request: ${requestId}, Accept: ${accept}`);
  
  const request = friendRequests.find(r => r._id === requestId);
  if (!request) {
    return res.status(404).json({ success: false, error: 'İstek bulunamadı' });
  }
  
  request.status = accept ? 'accepted' : 'rejected';
  
  if (accept) {
    // Add friendship
    friendships.push({
      _id: `friendship_${Date.now()}`,
      user1: request.fromUser._id,
      user2: request.toUser._id,
      createdAt: new Date().toISOString()
    });
  }
  
  res.json({ success: true, message: accept ? 'Arkadaş eklendi' : 'İstek reddedildi' });
});

// Create/update profile
app.post('/api/friends/profile', (req, res) => {
  const userId = req.headers['x-firebase-uid'];
  const { email, displayName } = req.body;
  
  console.log(`📡 POST /api/friends/profile - User: ${userId}`);
  
  let user = users.find(u => u._id === userId);
  if (!user) {
    user = {
      _id: userId,
      email,
      displayName,
      shareCode: `USER${Date.now().toString().slice(-4)}`
    };
    users.push(user);
  } else {
    user.email = email;
    user.displayName = displayName;
  }
  
  res.json({ success: true, user });
});

app.listen(PORT, () => {
  console.log(`🚀 Test Server running on port ${PORT}`);
  console.log(`📊 ${users.length} test users, ${friendRequests.length} pending requests ready`);
});
