/**
 * P2P Deprem Algılama Sistemi Test Suite
 * 
 * TEST SENARYOLARI:
 * 1. Telefon → Server: Sensör verisi gönderme
 * 2. Server Analiz: P2P algoritması çalışması
 * 3. Server → Kullanıcılar: Bildirim dağıtımı
 */

const axios = require('axios');
const readline = require('readline');

const BASE_URL = 'http://188.132.202.24:3000/api';
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Test kullanıcıları
const TEST_USERS = [
  {
    userId: 'test_user_1',
    deviceId: 'device_001',
    name: 'Ahmet - İstanbul Kadıköy',
    location: { latitude: 40.9880, longitude: 29.0256 }, // Kadıköy
  },
  {
    userId: 'test_user_2',
    deviceId: 'device_002',
    name: 'Mehmet - İstanbul Beşiktaş',
    location: { latitude: 41.0428, longitude: 29.0080 }, // Beşiktaş
  },
  {
    userId: 'test_user_3',
    deviceId: 'device_003',
    name: 'Ayşe - İstanbul Üsküdar',
    location: { latitude: 41.0223, longitude: 29.0155 }, // Üsküdar
  },
  {
    userId: 'test_user_4',
    deviceId: 'device_004',
    name: 'Fatma - İstanbul Bakırköy',
    location: { latitude: 40.9800, longitude: 28.8700 }, // Bakırköy
  },
  {
    userId: 'test_user_5',
    deviceId: 'device_005',
    name: 'Ali - İstanbul Kartal',
    location: { latitude: 40.9014, longitude: 29.1925 }, // Kartal
  },
  {
    userId: 'test_user_6',
    deviceId: 'device_006',
    name: 'Zeynep - İstanbul Şişli',
    location: { latitude: 41.0600, longitude: 28.9867 }, // Şişli
  },
  {
    userId: 'test_user_7',
    deviceId: 'device_007',
    name: 'Can - İstanbul Maltepe',
    location: { latitude: 40.9296, longitude: 29.1410 }, // Maltepe
  },
  {
    userId: 'test_user_8',
    deviceId: 'device_008',
    name: 'Elif - İstanbul Beylikdüzü',
    location: { latitude: 41.0031, longitude: 28.6422 }, // Beylikdüzü
  },
];

// Sensör verisi oluştur (simüle edilmiş deprem)
function generateShakeReport(user, magnitude = 5.0) {
  // Merkez üssüne olan mesafeye göre sarsıntı şiddeti azalt
  const distanceFromEpicenter = Math.random() * 5; // 0-5 km
  const attenuatedMagnitude = magnitude * (1 - distanceFromEpicenter * 0.1);
  
  return {
    userId: user.userId,
    deviceId: user.deviceId,
    location: user.location,
    sensorData: {
      maxMagnitude: attenuatedMagnitude + (Math.random() * 2 - 1), // ±1 varyasyon
      avgMagnitude: attenuatedMagnitude * 0.7,
      duration: 3000 + Math.random() * 2000, // 3-5 saniye
      shakeCount: 15 + Math.floor(Math.random() * 10), // 15-25 sarsıntı
      probabilityScore: 60 + Math.random() * 30, // 60-90%
      gyroData: {
        maxRotation: magnitude * 0.5,
        avgRotation: magnitude * 0.3,
      }
    },
    timestamp: new Date().toISOString(),
  };
}

// Rapor gönder
async function sendShakeReport(report) {
  try {
    const response = await axios.post(`${BASE_URL}/p2p/shake-report`, report, {
      headers: { 'Content-Type': 'application/json' }
    });
    return response.data;
  } catch (error) {
    console.error(`❌ ${report.userId} rapor gönderilemedi:`, error.response?.data || error.message);
    return { success: false, error: error.message };
  }
}

// Sistem istatistiklerini al
async function getSystemStats() {
  try {
    const response = await axios.get(`${BASE_URL}/p2p/stats`);
    return response.data;
  } catch (error) {
    console.error('❌ İstatistikler alınamadı:', error.message);
    return null;
  }
}

// TEST 1: Tek rapor gönder (deprem tetiklenmemeli)
async function test1_SingleReport() {
  console.log('\n' + '='.repeat(60));
  console.log('TEST 1: TEK RAPOR GÖNDER (Deprem Tetiklenmemeli)');
  console.log('='.repeat(60));
  
  const user = TEST_USERS[0];
  const report = generateShakeReport(user, 4.5);
  
  console.log(`\n📤 ${user.name} rapor gönderiyor...`);
  console.log(`   Konum: ${report.location.latitude}, ${report.location.longitude}`);
  console.log(`   Max Büyüklük: ${report.sensorData.maxMagnitude.toFixed(2)} m/s²`);
  console.log(`   Olasılık: ${report.sensorData.probabilityScore.toFixed(1)}%`);
  
  const result = await sendShakeReport(report);
  
  if (result.success) {
    console.log('\n✅ Rapor başarıyla gönderildi');
    console.log(`   Bölge: ${result.analysis.region}`);
    console.log(`   Toplam Rapor: ${result.analysis.totalReports}`);
    console.log(`   Deprem Olasılığı: ${result.analysis.earthquakeProbability.toFixed(1)}%`);
    console.log(`   Deprem Tespit: ${result.analysis.isEarthquakeDetected ? '🚨 EVET' : '❌ HAYIR'}`);
  }
  
  await sleep(2000);
}

// TEST 2: 3 rapor gönder (hala tetiklenmemeli - minimum 5 rapor gerekli)
async function test2_ThreeReports() {
  console.log('\n' + '='.repeat(60));
  console.log('TEST 2: 3 RAPOR GÖNDER (Hala Tetiklenmemeli - Min 5 Gerekli)');
  console.log('='.repeat(60));
  
  for (let i = 0; i < 3; i++) {
    const user = TEST_USERS[i];
    const report = generateShakeReport(user, 4.8);
    
    console.log(`\n📤 [${i+1}/3] ${user.name} rapor gönderiyor...`);
    
    const result = await sendShakeReport(report);
    
    if (result.success) {
      console.log(`   ✅ Gönderildi - Bölgesel Rapor: ${result.analysis.totalReports}`);
      console.log(`   📈 Olasılık: ${result.analysis.earthquakeProbability.toFixed(1)}%`);
      console.log(`   ${result.analysis.isEarthquakeDetected ? '🚨 DEPREM TESPİT!' : '⏳ Beklemede...'}`);
    }
    
    await sleep(500); // Raporlar arası 500ms
  }
  
  await sleep(2000);
}

// TEST 3: 8 rapor gönder (DEPREM TETİKLENMELİ!)
async function test3_EarthquakeDetection() {
  console.log('\n' + '='.repeat(60));
  console.log('TEST 3: 8 RAPOR GÖNDER - 🚨 DEPREM TETİKLENMELİ! 🚨');
  console.log('='.repeat(60));
  
  console.log('\n📊 Test Kullanıcıları:');
  TEST_USERS.slice(0, 8).forEach((user, i) => {
    console.log(`   ${i+1}. ${user.name} - ${user.location.latitude}, ${user.location.longitude}`);
  });
  
  console.log('\n🚀 Raporlar gönderiliyor (5 saniye içinde)...\n');
  
  const promises = TEST_USERS.slice(0, 8).map(async (user, i) => {
    // Raporları 0-3 saniye aralığında gönder (yüksek zaman korelasyonu)
    await sleep(Math.random() * 3000);
    
    const report = generateShakeReport(user, 5.5); // Güçlü deprem
    console.log(`📤 [${i+1}/8] ${user.name} rapor gönderiyor...`);
    
    const result = await sendShakeReport(report);
    
    if (result.success) {
      console.log(`   ✅ Rapor: ${result.analysis.totalReports} | Olasılık: ${result.analysis.earthquakeProbability.toFixed(1)}%`);
      
      if (result.analysis.isEarthquakeDetected) {
        console.log(`\n${'🚨'.repeat(20)}`);
        console.log(`🚨🚨🚨 DEPREM TESPİT EDİLDİ! 🚨🚨🚨`);
        console.log(`${'🚨'.repeat(20)}`);
        console.log(`\n📍 Bölge: ${result.analysis.region}`);
        console.log(`📊 Tahmini Büyüklük: M${result.analysis.estimatedMagnitude}`);
        console.log(`🎯 Merkez Üssü: ${result.analysis.estimatedEpicenter.latitude.toFixed(4)}, ${result.analysis.estimatedEpicenter.longitude.toFixed(4)}`);
        console.log(`👥 Toplam Rapor: ${result.analysis.totalReports}`);
        console.log(`📈 Olasılık: ${result.analysis.earthquakeProbability.toFixed(1)}%\n`);
      }
    }
  });
  
  await Promise.all(promises);
  
  await sleep(3000);
  
  // İstatistikleri göster
  console.log('\n📊 Sistem İstatistikleri:');
  const stats = await getSystemStats();
  if (stats) {
    console.log(`   Toplam Rapor (30sn içinde): ${stats.totalReports}`);
    console.log(`   Tespit Edilen Depremler: ${stats.detectedEarthquakes}`);
    if (stats.recentDetections && stats.recentDetections.length > 0) {
      console.log('\n   Son Tespitler:');
      stats.recentDetections.forEach((det, i) => {
        console.log(`   ${i+1}. ${det.regionName} - M${det.estimatedMagnitude} (${new Date(det.detectedAt).toLocaleTimeString()})`);
      });
    }
  }
}

// TEST 4: False Positive Test (aynı kullanıcı tekrar rapor)
async function test4_FalsePositive() {
  console.log('\n' + '='.repeat(60));
  console.log('TEST 4: FALSE POSITIVE TEST (Aynı Kullanıcı Tekrar Rapor)');
  console.log('='.repeat(60));
  
  const user = TEST_USERS[0];
  
  console.log(`\n📤 ${user.name} ilk rapor gönderiyor...`);
  const report1 = generateShakeReport(user, 5.0);
  await sendShakeReport(report1);
  
  console.log('\n⏳ 2 saniye bekleniyor...\n');
  await sleep(2000);
  
  console.log(`📤 ${user.name} tekrar rapor gönderiyor (aynı konum)...`);
  const report2 = generateShakeReport(user, 5.2);
  const result = await sendShakeReport(report2);
  
  if (result.success) {
    console.log('\n✅ Rapor kabul edildi (skor düşürüldü)');
    console.log(`   Bölgesel Olasılık: ${result.analysis.earthquakeProbability.toFixed(1)}%`);
    console.log(`   ⚠️ False positive filtresi çalıştı mı? ${result.analysis.earthquakeProbability < 70 ? 'EVET' : 'HAYIR'}`);
  }
}

// TEST 5: Zaman Korelasyonu Test (gecikmeli raporlar)
async function test5_TimeCorrelation() {
  console.log('\n' + '='.repeat(60));
  console.log('TEST 5: ZAMAN KORELASYONU TEST (Gecikmeli Raporlar)');
  console.log('='.repeat(60));
  
  console.log('\n📤 5 rapor 15 saniye aralıkla gönderiliyor (düşük korelasyon)...\n');
  
  for (let i = 0; i < 5; i++) {
    const user = TEST_USERS[i];
    const report = generateShakeReport(user, 5.0);
    
    console.log(`📤 [${i+1}/5] ${user.name} rapor gönderiyor...`);
    const result = await sendShakeReport(report);
    
    if (result.success) {
      console.log(`   Rapor: ${result.analysis.totalReports} | Olasılık: ${result.analysis.earthquakeProbability.toFixed(1)}%`);
    }
    
    if (i < 4) {
      console.log(`   ⏳ 15 saniye bekleniyor...`);
      await sleep(15000);
    }
  }
  
  console.log('\n⚠️ Düşük zaman korelasyonu nedeniyle deprem tetiklenmemeli');
}

// Yardımcı fonksiyon
function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

// Ana test menüsü
function showMenu() {
  console.log('\n' + '='.repeat(60));
  console.log('🧪 P2P DEPREM ALGILAMA SİSTEMİ TEST SUITE');
  console.log('='.repeat(60));
  console.log('\n1. TEST 1: Tek Rapor (Tetiklenmemeli)');
  console.log('2. TEST 2: 3 Rapor (Hala Tetiklenmemeli)');
  console.log('3. TEST 3: 8 Rapor - 🚨 DEPREM TETİKLE! 🚨');
  console.log('4. TEST 4: False Positive Test');
  console.log('5. TEST 5: Zaman Korelasyonu Test');
  console.log('6. 🔥 TÜM TESTLERİ ÇALIŞTIR');
  console.log('7. 📊 Sistem İstatistikleri');
  console.log('8. ❌ Çıkış');
  console.log('\n' + '='.repeat(60));
}

async function runTest(choice) {
  switch(choice) {
    case '1':
      await test1_SingleReport();
      break;
    case '2':
      await test2_ThreeReports();
      break;
    case '3':
      await test3_EarthquakeDetection();
      break;
    case '4':
      await test4_FalsePositive();
      break;
    case '5':
      await test5_TimeCorrelation();
      break;
    case '6':
      console.log('\n🔥 TÜM TESTLER BAŞLIYOR...\n');
      await test1_SingleReport();
      await test2_ThreeReports();
      await test3_EarthquakeDetection();
      await test4_FalsePositive();
      await test5_TimeCorrelation();
      console.log('\n✅ TÜM TESTLER TAMAMLANDI!');
      break;
    case '7':
      const stats = await getSystemStats();
      if (stats) {
        console.log('\n📊 SİSTEM İSTATİSTİKLERİ:');
        console.log(`   Aktif Raporlar (30sn): ${stats.totalReports}`);
        console.log(`   Tespit Edilen Depremler: ${stats.detectedEarthquakes}`);
        if (stats.recentDetections && stats.recentDetections.length > 0) {
          console.log('\n   Son Tespitler:');
          stats.recentDetections.forEach((det, i) => {
            console.log(`   ${i+1}. ${det.regionName} - M${det.estimatedMagnitude}`);
            console.log(`      Rapor: ${det.totalReports} | Olasılık: ${det.earthquakeProbability.toFixed(1)}%`);
            console.log(`      Zaman: ${new Date(det.detectedAt).toLocaleString()}`);
          });
        } else {
          console.log('   Henüz tespit edilen deprem yok');
        }
      }
      break;
    case '8':
      console.log('\n👋 Test suite kapatılıyor...\n');
      rl.close();
      process.exit(0);
      break;
    default:
      console.log('\n❌ Geçersiz seçim!');
  }
}

// Ana döngü
async function main() {
  console.log('\n🌍 P2P Deprem Algılama Test Suite');
  console.log('📡 Server: ' + BASE_URL);
  console.log('👥 Test Kullanıcı Sayısı: ' + TEST_USERS.length);
  
  function prompt() {
    showMenu();
    rl.question('\nSeçiminiz (1-8): ', async (answer) => {
      await runTest(answer.trim());
      if (answer.trim() !== '8') {
        prompt();
      }
    });
  }
  
  prompt();
}

// Başlat
if (require.main === module) {
  main().catch(console.error);
}

module.exports = {
  sendShakeReport,
  generateShakeReport,
  getSystemStats,
  TEST_USERS
};
