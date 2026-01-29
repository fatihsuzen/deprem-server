// Test: Bildirim sistemi aktif olduğunda log görünümü

const PriorityNotificationService = require('./services/priorityNotificationService');

// Mock notification service
const mockNotificationService = {
  sendToDevice: () => Promise.resolve({ success: true })
};

console.log('🧪 Bildirim sistemi log testi başlatılıyor...\n');

// Service oluştur (constructor'da başlangıç logları gösterilecek)
const service = new PriorityNotificationService(mockNotificationService);

console.log('\n⏱️  60 saniye bekleniyor (aktif olma için)...');
console.log('   (Test hızlandırılmış - 5 saniye bekleyecek)\n');

// Test için timeout'u 5 saniyeye indirdik (production'da 60 saniye)
setTimeout(() => {
  console.log('✨ Test tamamlandı - production\'da bu 60 saniye sonra olacak');
  process.exit(0);
}, 5000);
