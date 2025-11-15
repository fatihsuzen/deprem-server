// Clear old Kandilli data from database
const { MongoClient } = require('mongodb');

const MONGODB_URI = process.env.MONGODB_URI || 'mongodb://188.132.202.24:27017/deprem_app';

async function clearKandilliCache() {
  const client = new MongoClient(MONGODB_URI);
  
  try {
    await client.connect();
    console.log('📦 MongoDB\'ye bağlanıldı');
    
    const db = client.db();
    const earthquakes = db.collection('earthquakes');
    
    // Delete all Kandilli earthquakes
    const result = await earthquakes.deleteMany({ source: 'Kandilli' });
    console.log(`🗑️  ${result.deletedCount} adet Kandilli verisi silindi`);
    
    // Show remaining earthquakes count
    const remaining = await earthquakes.countDocuments();
    console.log(`📊 Kalan toplam deprem sayısı: ${remaining}`);
    
    console.log('✅ Kandilli cache temizlendi! Sunucu yeniden başlatıldığında yeni veriler çekilecek.');
    
  } catch (error) {
    console.error('❌ Hata:', error);
  } finally {
    await client.close();
  }
}

clearKandilliCache();
