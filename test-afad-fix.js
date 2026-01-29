const axios = require('axios');

async function testAFADFix() {
  try {
    const now = new Date();
    const yesterday = new Date(Date.now() - 24 * 60 * 60 * 1000);
    
    function formatDate(date) {
      return date.toISOString().split('T')[0];
    }
    
    const params = {
      start: formatDate(yesterday),
      end: formatDate(now),
      format: 'json'
    };
    
    console.log('📡 AFAD API çağrısı yapılıyor...');
    console.log('🕒 Şu An (UTC):', now.toISOString());
    console.log('🕒 Şu An (Türkiye):', new Date(now.getTime() + (3 * 60 * 60 * 1000)).toLocaleString('tr-TR'));
    console.log('');
    
    const response = await axios.get('https://deprem.afad.gov.tr/apiv2/event/filter', {
      params,
      timeout: 10000,
      headers: {
        'User-Agent': 'DepremApp/1.0',
        'Accept': 'application/json'
      }
    });
    
    const earthquakes = Array.isArray(response.data) ? response.data : (response.data.data || []);
    
    if (earthquakes && earthquakes.length > 0) {
      console.log(`✅ ${earthquakes.length} AFAD deprem bulundu\n`);
      
      // En son 3 depremi göster
      const sorted = earthquakes.sort((a, b) => {
        const dateA = new Date((a.date || a.event_date_time || a.timestamp) + '+03:00');
        const dateB = new Date((b.date || b.event_date_time || b.timestamp) + '+03:00');
        return dateB - dateA;
      });
      
      for (let i = 0; i < Math.min(3, sorted.length); i++) {
        const eq = sorted[i];
        const afadDateStr = eq.date || eq.event_date_time || eq.timestamp;
        
        console.log(`\n━━━ Deprem ${i + 1} (En Yeni) ━━━`);
        console.log('📍 Lokasyon:', eq.location || eq.place);
        console.log('📊 Büyüklük:', eq.mag || eq.magnitude);
        console.log('');
        console.log('🔍 AFAD\'tan gelen:', afadDateStr);
        
        if (afadDateStr) {
          // YENİ YOL: Timezone ekle
          const utcDateStr = afadDateStr + '+03:00';
          const correctDate = new Date(utcDateStr);
          console.log('✅ Doğru parse (timezone ile):', correctDate.toISOString());
          
          const minutesAgo = Math.floor((Date.now() - correctDate.getTime()) / (1000 * 60));
          const hoursAgo = Math.floor(minutesAgo / 60);
          const daysAgo = Math.floor(hoursAgo / 24);
          
          if (daysAgo > 0) {
            console.log('⏰ Kaç zaman önce:', daysAgo, 'gün', hoursAgo % 24, 'saat önce');
          } else if (hoursAgo > 0) {
            console.log('⏰ Kaç zaman önce:', hoursAgo, 'saat', minutesAgo % 60, 'dakika önce');
          } else {
            console.log('⏰ Kaç zaman önce:', minutesAgo, 'dakika önce');
          }
        }
      }
    } else {
      console.log('⚠️ Deprem verisi bulunamadı');
    }
  } catch (error) {
    console.error('❌ Hata:', error.message);
  }
}

testAFADFix();
