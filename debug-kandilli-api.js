const axios = require('axios');

async function debugKandilliAPI() {
  try {
    console.log('🔍 VDS API test ediliyor...\n');
    
    // API'den veri çek
    const response = await axios.get('http://188.132.202.24:3000/api/earthquakes?limit=100&minMagnitude=1.0');
    const earthquakes = response.data.earthquakes || [];
    
    console.log(`📊 Toplam deprem sayısı: ${earthquakes.length}\n`);
    
    // Kaynak bazında grupla
    const bySource = {};
    earthquakes.forEach(eq => {
      bySource[eq.source] = (bySource[eq.source] || 0) + 1;
    });
    
    console.log('📈 Kaynak bazında dağılım:');
    Object.entries(bySource).forEach(([source, count]) => {
      console.log(`   ${source}: ${count} deprem`);
    });
    console.log('');
    
    // Kandilli depremlerini filtrele
    const kandilliEarthquakes = earthquakes.filter(eq => eq.source === 'Kandilli');
    
    if (kandilliEarthquakes.length === 0) {
      console.log('❌ Kandilli depremi bulunamadı!\n');
      console.log('Tüm kaynaklar:', Object.keys(bySource));
      return;
    }
    
    console.log(`✅ ${kandilliEarthquakes.length} Kandilli depremi bulundu\n`);
    
    // İlk 5 Kandilli depremini detaylı göster
    console.log('📋 İlk 5 Kandilli depremi:\n');
    
    kandilliEarthquakes.slice(0, 5).forEach((eq, index) => {
      console.log(`[${index + 1}] ${eq.place}`);
      console.log(`    Büyüklük: ${eq.mag}`);
      console.log(`    Konum: ${eq.lat}, ${eq.lon}`);
      console.log(`    Tarih: ${eq.date}`);
      console.log(`    Saat: ${eq.time}`);
      console.log(`    Timestamp: ${eq.timestamp}`);
      console.log(`    minutesAgo: ${eq.minutesAgo}`);
      
      // Zaman kontrolü
      const quakeDate = new Date(eq.timestamp);
      const now = new Date();
      const actualMinutesAgo = Math.floor((now - quakeDate) / (1000 * 60));
      const hours = Math.floor(actualMinutesAgo / 60);
      const minutes = actualMinutesAgo % 60;
      
      console.log(`    Gerçek yaş: ${hours} saat ${minutes} dakika önce`);
      
      if (hours >= 24) {
        console.log(`    ⚠️  SORUNLU: ${Math.floor(hours / 24)} gün önce gözükecek!`);
      } else if (hours < 1) {
        console.log(`    ✅ NORMAL: ${minutes} dakika önce`);
      } else {
        console.log(`    ✅ NORMAL: ${hours} saat ${minutes} dakika önce`);
      }
      
      console.log('');
    });
    
    // Zaman analizi
    console.log('⏰ Zaman analizi:\n');
    
    const ageGroups = {
      'Son 1 saat': 0,
      '1-6 saat': 0,
      '6-12 saat': 0,
      '12-24 saat': 0,
      '1+ gün': 0
    };
    
    kandilliEarthquakes.forEach(eq => {
      const hours = eq.minutesAgo / 60;
      
      if (hours < 1) ageGroups['Son 1 saat']++;
      else if (hours < 6) ageGroups['1-6 saat']++;
      else if (hours < 12) ageGroups['6-12 saat']++;
      else if (hours < 24) ageGroups['12-24 saat']++;
      else ageGroups['1+ gün']++;
    });
    
    Object.entries(ageGroups).forEach(([range, count]) => {
      console.log(`   ${range}: ${count} deprem`);
    });
    
    if (ageGroups['1+ gün'] > 0) {
      console.log(`\n❌ ${ageGroups['1+ gün']} deprem 1 günden eski görünüyor - SORUN VAR!`);
    } else {
      console.log('\n✅ Tüm Kandilli depremleri 24 saat içinde - SORUN YOK!');
    }
    
  } catch (error) {
    console.error('❌ Hata:', error.message);
    if (error.response) {
      console.error('Response status:', error.response.status);
      console.error('Response data:', error.response.data);
    }
  }
}

debugKandilliAPI();
