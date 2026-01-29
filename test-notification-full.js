// Test: 61 saniye bekle ve aktif olma logunu gör

const PriorityNotificationService = require('./services/priorityNotificationService');

const mockNotificationService = {
  sendToDevice: () => Promise.resolve({ success: true })
};

console.log('🧪 Bildirim sistemi tam test başlatılıyor...\n');
console.log('⏱️  61 saniye beklenecek (aktif olma logunu görmek için)\n');

const service = new PriorityNotificationService(mockNotificationService);

// Her 10 saniyede bir progress göster
let elapsed = 0;
const progressInterval = setInterval(() => {
  elapsed += 10;
  if (elapsed < 60) {
    console.log(`   ... ${elapsed} saniye geçti (${60 - elapsed} saniye kaldı)`);
  }
}, 10000);

// 61 saniye sonra bitir
setTimeout(() => {
  clearInterval(progressInterval);
  console.log('\n✅ Test tamamlandı - aktif olma logu yukarıda gösterildi');
  process.exit(0);
}, 61000);
