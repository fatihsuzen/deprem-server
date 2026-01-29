// Test: Server başlangıcında bildirim göndermeyi engelleme sistemi

const PriorityNotificationService = require('./services/priorityNotificationService');

// Mock notification service
const mockNotificationService = {
  sendToDevice: () => Promise.resolve({ success: true })
};

console.log('🧪 Test başlatılıyor...\n');

// Service oluştur
const service = new PriorityNotificationService(mockNotificationService);

// Mock deprem verisi
const testEarthquake = {
  lat: 38.0,
  lon: 27.5,
  magnitude: 4.5,
  location: 'İzmir',
  depth: 10,
  time: new Date(),
  source: 'TEST'
};

console.log('\n⏱️  İlk 5 saniye test (bildirim GÖNDERİLMEMELİ):');

// Her saniye test et
let counter = 0;
const interval = setInterval(async () => {
  counter++;
  console.log(`\n--- ${counter}. saniye ---`);
  
  const result = await service.sendPriorityEarthquakeNotifications(testEarthquake);
  
  if (result && result.skipped) {
    console.log('✅ Doğru: Bildirim atlandı (henüz hazır değil)');
  } else {
    console.log('❌ HATA: Bildirim gönderildi (gönderilmemeliydi!)');
  }
  
  if (counter >= 5) {
    clearInterval(interval);
    console.log('\n✅ Test tamamlandı. 60 saniye sonra bildirimler aktif olacak.');
    process.exit(0);
  }
}, 1000);
