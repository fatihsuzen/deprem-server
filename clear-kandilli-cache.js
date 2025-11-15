// Clear old Kandilli data from database
const { MongoClient } = require('mongodb');

// Try localhost first, then remote
const MONGODB_URIS = [
  'mongodb://localhost:27017/deprem_app',
  'mongodb://127.0.0.1:27017/deprem_app',
  process.env.MONGODB_URI || 'mongodb://188.132.202.24:27017/deprem_app'
];

async function clearKandilliCache() {
  let client = null;
  let connected = false;
  
  // Try each URI until one connects
  for (const uri of MONGODB_URIS) {
    try {
      console.log(`🔄 Bağlanılıyor: ${uri.replace(/mongodb:\/\/(.+?)\//, 'mongodb://$1/')}`);
      client = new MongoClient(uri, { 
        serverSelectionTimeoutMS: 3000,
        connectTimeoutMS: 3000 
      });
      await client.connect();
      console.log('✅ MongoDB\'ye bağlanıldı');
      connected = true;
      break;
    } catch (error) {
      console.log(`❌ Bağlanılamadı: ${error.message}`);
      if (client) {
        try { await client.close(); } catch {}
      }
      client = null;
    }
  }
  
  if (!connected) {
    console.error('\n❌ Hiçbir MongoDB sunucusuna bağlanılamadı!');
    console.log('\n💡 Çözüm önerileri:');
    console.log('1. MongoDB servisinin çalıştığından emin olun');
    console.log('2. VDS üzerinde çalıştırıyorsanız: systemctl start mongod');
    console.log('3. Yerel test için MongoDB kurulu olmalı');
    console.log('4. Veya VDS\'ye bağlanın ve orada çalıştırın');
    return;
  }
  
  try {
    const db = client.db();
    const earthquakes = db.collection('earthquakes');
    
    // Count before deletion
    const beforeCount = await earthquakes.countDocuments({ source: 'Kandilli' });
    console.log(`📊 Silinecek Kandilli verisi: ${beforeCount}`);
    
    if (beforeCount === 0) {
      console.log('ℹ️  Silinecek Kandilli verisi yok');
    } else {
      // Delete all Kandilli earthquakes
      const result = await earthquakes.deleteMany({ source: 'Kandilli' });
      console.log(`🗑️  ${result.deletedCount} adet Kandilli verisi silindi`);
    }
    
    // Show remaining earthquakes count
    const remaining = await earthquakes.countDocuments();
    console.log(`📊 Kalan toplam deprem sayısı: ${remaining}`);
    
    console.log('\n✅ İşlem tamamlandı! Sunucuyu yeniden başlatın:');
    console.log('   pkill -f "node server.js"');
    console.log('   nohup node server.js > server.log 2>&1 &');
    
  } catch (error) {
    console.error('❌ İşlem hatası:', error.message);
  } finally {
    if (client) {
      await client.close();
    }
  }
}

clearKandilliCache();
