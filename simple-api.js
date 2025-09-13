const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware
app.use(cors());
app.use(express.json());

// MongoDB bağlantısı
mongoose.connect('mongodb://localhost:27017/deprem_app', {
    useNewUrlParser: true,
    useUnifiedTopology: true
}).then(() => {
    console.log('✅ MongoDB bağlantısı başarılı');
}).catch(err => {
    console.error('❌ MongoDB bağlantı hatası:', err);
});

// Basit User schema
const userSchema = new mongoose.Schema({
    firebaseUid: { type: String, required: true, unique: true },
    email: { type: String, required: true },
    displayName: { type: String, required: true },
    shareCode: { type: String, unique: true },
    location: {
        latitude: { type: Number, default: 0 },
        longitude: { type: Number, default: 0 },
        lastUpdated: { type: Date, default: Date.now }
    },
    createdAt: { type: Date, default: Date.now }
});

// Basit Friendship schema
const friendshipSchema = new mongoose.Schema({
    userId1: { type: String, required: true },
    userId2: { type: String, required: true },
    status: { type: String, enum: ['pending', 'accepted'], default: 'accepted' },
    createdAt: { type: Date, default: Date.now }
});

const User = mongoose.model('User', userSchema);
const Friendship = mongoose.model('Friendship', friendshipSchema);

// Health endpoint
app.get('/health', (req, res) => {
    res.json({ status: 'OK', message: 'Server çalışıyor' });
});

// Kullanıcı profili oluştur/güncelle
app.post('/api/profile', async (req, res) => {
    try {
        const { firebaseUid } = req.headers['x-firebase-uid'] ? { firebaseUid: req.headers['x-firebase-uid'] } : req.body;
        const { email, displayName } = req.body;

        if (!firebaseUid || !email || !displayName) {
            return res.status(400).json({ error: 'Eksik bilgiler' });
        }

        // ShareCode oluştur
        const shareCode = 'USR' + Math.random().toString(36).substr(2, 8).toUpperCase();

        const user = await User.findOneAndUpdate(
            { firebaseUid },
            { 
                email, 
                displayName, 
                shareCode: shareCode,
                $setOnInsert: { createdAt: new Date() }
            },
            { upsert: true, new: true }
        );

        res.json(user);
    } catch (error) {
        console.error('Profil hatası:', error);
        res.status(500).json({ error: 'Sunucu hatası' });
    }
});

// Arkadaşları getir
app.get('/api/friends', async (req, res) => {
    try {
        const firebaseUid = req.headers['x-firebase-uid'];
        if (!firebaseUid) {
            return res.status(400).json({ error: 'Kullanıcı ID gerekli' });
        }

        // Kullanıcının arkadaşlıklarını bul
        const friendships = await Friendship.find({
            $or: [{ userId1: firebaseUid }, { userId2: firebaseUid }],
            status: 'accepted'
        });

        // Arkadaş ID'lerini topla
        const friendIds = friendships.map(f => 
            f.userId1 === firebaseUid ? f.userId2 : f.userId1
        );

        // Arkadaş bilgilerini getir
        const friends = await User.find({ firebaseUid: { $in: friendIds } });

        res.json({ friends, total: friends.length });
    } catch (error) {
        console.error('Arkadaş listesi hatası:', error);
        res.status(500).json({ error: 'Sunucu hatası' });
    }
});

// Konum güncelle
app.post('/api/location', async (req, res) => {
    try {
        const firebaseUid = req.headers['x-firebase-uid'];
        const { latitude, longitude } = req.body;

        if (!firebaseUid) {
            return res.status(400).json({ error: 'Kullanıcı ID gerekli' });
        }

        const user = await User.findOneAndUpdate(
            { firebaseUid },
            { 
                'location.latitude': latitude,
                'location.longitude': longitude,
                'location.lastUpdated': new Date()
            },
            { new: true }
        );

        if (!user) {
            return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
        }

        res.json({ message: 'Konum güncellendi', location: user.location });
    } catch (error) {
        console.error('Konum güncelleme hatası:', error);
        res.status(500).json({ error: 'Sunucu hatası' });
    }
});

// Test kullanıcıları oluştur
app.post('/api/create-test-users', async (req, res) => {
    try {
        const testUsers = [
            {
                firebaseUid: 'test_user_1',
                email: 'ahmet@test.com',
                displayName: 'Ahmet Yılmaz',
                shareCode: 'AHMET123',
                location: {
                    latitude: 41.0082,
                    longitude: 28.9784,
                    lastUpdated: new Date()
                }
            },
            {
                firebaseUid: 'test_user_2',
                email: 'fatma@test.com',
                displayName: 'Fatma Kaya',
                shareCode: 'FATMA456',
                location: {
                    latitude: 41.0150,
                    longitude: 28.9850,
                    lastUpdated: new Date()
                }
            },
            {
                firebaseUid: 'test_user_3',
                email: 'mehmet@test.com',
                displayName: 'Mehmet Demir',
                shareCode: 'MEHMET789',
                location: {
                    latitude: 41.0200,
                    longitude: 28.9900,
                    lastUpdated: new Date()
                }
            }
        ];

        // Test kullanıcılarını oluştur
        for (const userData of testUsers) {
            await User.findOneAndUpdate(
                { firebaseUid: userData.firebaseUid },
                userData,
                { upsert: true, new: true }
            );
        }

        // Arkadaşlık ilişkileri oluştur
        const friendships = [
            { userId1: 'test_user_1', userId2: 'test_user_2', status: 'accepted' },
            { userId1: 'test_user_1', userId2: 'test_user_3', status: 'accepted' },
            { userId1: 'test_user_2', userId2: 'test_user_3', status: 'accepted' }
        ];

        for (const friendship of friendships) {
            await Friendship.findOneAndUpdate(
                {
                    $or: [
                        { userId1: friendship.userId1, userId2: friendship.userId2 },
                        { userId1: friendship.userId2, userId2: friendship.userId1 }
                    ]
                },
                friendship,
                { upsert: true, new: true }
            );
        }

        res.json({ 
            message: 'Test kullanıcıları oluşturuldu',
            users: testUsers.length,
            friendships: friendships.length 
        });
    } catch (error) {
        console.error('Test kullanıcısı oluşturma hatası:', error);
        res.status(500).json({ error: 'Sunucu hatası' });
    }
});

// Server başlat
app.listen(PORT, () => {
    console.log(`🚀 Basit API Server http://localhost:${PORT} portunda çalışıyor`);
    console.log(`📍 Health Check: http://localhost:${PORT}/health`);
});

// Graceful shutdown
process.on('SIGINT', async () => {
    console.log('\n⏹️ Server kapatılıyor...');
    await mongoose.connection.close();
    process.exit(0);
});
