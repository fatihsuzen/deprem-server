const express = require('express');
const app = express();
const PORT = 3000;

// Middleware
app.use(express.json());
app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers', '*');
    res.header('Access-Control-Allow-Methods', '*');
    next();
});

// Mock data
let users = [
    {
        firebaseUid: 'test_user_1',
        email: 'ahmet@test.com',
        displayName: 'Ahmet Yılmaz',
        shareCode: 'AHMET123',
        location: {
            latitude: 41.0082,
            longitude: 28.9784,
            lastUpdated: new Date().toISOString()
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
            lastUpdated: new Date().toISOString()
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
            lastUpdated: new Date().toISOString()
        }
    }
];

let friendships = [
    { userId1: 'test_user_1', userId2: 'test_user_2', status: 'accepted' },
    { userId1: 'test_user_1', userId2: 'test_user_3', status: 'accepted' },
    { userId1: 'test_user_2', userId2: 'test_user_3', status: 'accepted' }
];

// Health endpoint
app.get('/health', (req, res) => {
    res.json({ status: 'OK', message: 'Basit server çalışıyor' });
});

// Kullanıcı profili oluştur/güncelle
app.post('/api/profile', (req, res) => {
    try {
        const firebaseUid = req.headers['x-firebase-uid'] || req.body.firebaseUid;
        const { email, displayName } = req.body;

        console.log('Profil isteği:', { firebaseUid, email, displayName });

        if (!firebaseUid || !email || !displayName) {
            return res.status(400).json({ error: 'Eksik bilgiler' });
        }

        let user = users.find(u => u.firebaseUid === firebaseUid);
        
        if (!user) {
            const shareCode = 'USR' + Math.random().toString(36).substr(2, 8).toUpperCase();
            user = {
                firebaseUid,
                email,
                displayName,
                shareCode,
                location: {
                    latitude: 41.0082,
                    longitude: 28.9784,
                    lastUpdated: new Date().toISOString()
                }
            };
            users.push(user);
        } else {
            user.email = email;
            user.displayName = displayName;
        }

        res.json(user);
    } catch (error) {
        console.error('Profil hatası:', error);
        res.status(500).json({ error: 'Sunucu hatası' });
    }
});

// Arkadaşları getir
app.get('/api/friends', (req, res) => {
    try {
        const firebaseUid = req.headers['x-firebase-uid'];
        console.log('Arkadaş listesi isteği:', firebaseUid);

        if (!firebaseUid) {
            return res.status(400).json({ error: 'Kullanıcı ID gerekli' });
        }

        // Kullanıcının arkadaşlıklarını bul
        const userFriendships = friendships.filter(f => 
            (f.userId1 === firebaseUid || f.userId2 === firebaseUid) && f.status === 'accepted'
        );

        // Arkadaş ID'lerini topla
        const friendIds = userFriendships.map(f => 
            f.userId1 === firebaseUid ? f.userId2 : f.userId1
        );

        // Arkadaş bilgilerini getir
        const friends = users.filter(u => friendIds.includes(u.firebaseUid));

        console.log('Bulunan arkadaşlar:', friends.length);
        res.json({ friends, total: friends.length });
    } catch (error) {
        console.error('Arkadaş listesi hatası:', error);
        res.status(500).json({ error: 'Sunucu hatası' });
    }
});

// Konum güncelle
app.post('/api/location', (req, res) => {
    try {
        const firebaseUid = req.headers['x-firebase-uid'];
        const { latitude, longitude } = req.body;

        console.log('Konum güncellemesi:', { firebaseUid, latitude, longitude });

        if (!firebaseUid) {
            return res.status(400).json({ error: 'Kullanıcı ID gerekli' });
        }

        const user = users.find(u => u.firebaseUid === firebaseUid);
        if (!user) {
            return res.status(404).json({ error: 'Kullanıcı bulunamadı' });
        }

        user.location = {
            latitude: latitude || user.location.latitude,
            longitude: longitude || user.location.longitude,
            lastUpdated: new Date().toISOString()
        };

        res.json({ message: 'Konum güncellendi', location: user.location });
    } catch (error) {
        console.error('Konum güncelleme hatası:', error);
        res.status(500).json({ error: 'Sunucu hatası' });
    }
});

// Tüm kullanıcıları listele (test için)
app.get('/api/users', (req, res) => {
    res.json({ users, total: users.length });
});

// Server başlat
const server = app.listen(PORT, '0.0.0.0', () => {
    console.log(`🚀 Basit Mock Server http://0.0.0.0:${PORT} portunda çalışıyor`);
    console.log(`📍 Health: http://localhost:${PORT}/health`);
    console.log(`👥 Users: http://localhost:${PORT}/api/users`);
    console.log(`📱 Gerçek Cihaz: http://192.168.1.104:${PORT}/api/friends`);
});

// Graceful shutdown
process.on('SIGINT', () => {
    console.log('\n⏹️ Server kapatılıyor...');
    server.close(() => {
        console.log('✅ Server kapatıldı');
        process.exit(0);
    });
});

// Handle exit
process.on('exit', () => {
    console.log('👋 Process sonlandırıldı');
});
