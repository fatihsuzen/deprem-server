const axios = require('axios');

// Test için sahte deprem verisi
const testEarthquake = {
  lat: 40.9593768, // İstanbul yakını
  lon: 29.2197328,
  magnitude: 4.5,
  location: 'TEST DEPREMI - İstanbul (Kadıköy)',
  depth: 10,
  time: new Date()
};

console.log('🧪 Test Depremi Gönderiliyor...');
console.log('📍 Konum:', testEarthquake.location);
console.log('📊 Büyüklük:', testEarthquake.magnitude);
console.log('🎯 Koordinatlar:', testEarthquake.lat, testEarthquake.lon);
console.log('');
console.log('⏳ Bildirim sistemi çalışıyor...');
console.log('');

// PriorityNotificationService'i simüle et
async function sendTestNotification() {
  try {
    // Server'a POST isteği gönder (earthquakeMonitor servisi tetiklenecek)
    const response = await axios.post('http://188.132.202.24:3000/api/test/earthquake-notification', {
      earthquake: testEarthquake
    });
    
    console.log('✅ Test başarılı!');
    console.log('📊 Sonuç:', response.data);
  } catch (error) {
    console.error('❌ Test hatası:', error.response?.data || error.message);
  }
}

// Manuel tetikleme için doğrudan PriorityNotificationService kullan
async function sendTestNotificationDirect() {
  console.log('📡 Doğrudan bildirim gönderiliyor...');
  
  const PriorityNotificationService = require('./services/priorityNotificationService');
  const NotificationService = require('./services/notificationService');
  
  const notificationService = new NotificationService();
  await notificationService.initialize();
  
  const priorityService = new PriorityNotificationService(notificationService);
  
  const result = await priorityService.sendPriorityEarthquakeNotifications(testEarthquake);
  
  console.log('');
  console.log('📊 SONUÇLAR:');
  console.log('════════════════════════════════════════');
  console.log(`✅ Gönderilen: ${result.stats.sent}`);
  console.log(`⏭️  Atlanan: ${result.stats.skipped}`);
  console.log(`❌ Hatalı: ${result.stats.failed}`);
  console.log('════════════════════════════════════════');
  
  if (result.stats.sent > 0) {
    console.log('');
    console.log('🎉 BAŞARILI! Bildirimi telefonunuzda kontrol edin.');
    console.log('💡 Uygulama kapalı olsa bile bildirim gelmelidir.');
  } else {
    console.log('');
    console.log('⚠️  HİÇBİR BİLDİRİM GÖNDERİLMEDİ!');
    console.log('Olası nedenler:');
    console.log('  - Kullanıcı range dışında (620 km)');
    console.log('  - Magnitude aralığı dışında (2.0-9.7)');
    console.log('  - FCM token kayıtlı değil');
  }
  
  process.exit(0);
}

// Direkt çalıştır
sendTestNotificationDirect();
