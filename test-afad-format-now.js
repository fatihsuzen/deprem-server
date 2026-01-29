const axios = require('axios');

async function testCurrentAFADFormat() {
  try {
    const now = new Date();
    const yesterday = new Date(Date.now() - 24 * 60 * 60 * 1000);
    
    function formatDate(date) {
      return date.toISOString().split('T')[0];
    }
    
    const nowTurkey = new Date(now.getTime() + (3 * 60 * 60 * 1000));
    console.log('🕐 Şu an (UTC):', now.toISOString());
    console.log('🕐 Şu an (Türkiye UTC+3):', nowTurkey.toISOString().replace('Z', ''));
    console.log('');
    
    const params = {
      start: formatDate(yesterday),
      end: formatDate(now),
      format: 'json'
    };
    
    const response = await axios.get('https://deprem.afad.gov.tr/apiv2/event/filter', {
      params,
      timeout: 10000,
      headers: { 'User-Agent': 'DepremApp/1.0', 'Accept': 'application/json' }
    });
    
    const earthquakes = Array.isArray(response.data) ? response.data : (response.data.data || []);
    
    if (earthquakes.length > 0) {
      // Simav depremini bul veya en yeni 3'ü göster
      const sorted = earthquakes.sort((a, b) => {
        const dateA = new Date(a.date || a.event_date_time || a.timestamp);
        const dateB = new Date(b.date || b.event_date_time || b.timestamp);
        return dateB - dateA;
      }).slice(0, 3);
      
      console.log('📊 En yeni 3 deprem:\n');
      
      sorted.forEach((eq, idx) => {
        const afadDateStr = eq.date || eq.event_date_time || eq.timestamp;
        
        console.log(`━━━ Deprem ${idx + 1} ━━━`);
        console.log('📍', eq.location);
        console.log('📊 M' + (eq.mag || eq.magnitude));
        console.log('');
        console.log('🔍 AFAD string (RAW):', JSON.stringify(afadDateStr));
        console.log('🔍 String type:', typeof afadDateStr);
        console.log('');
        
        // Mevcut kodumuz
        const withTimezone = afadDateStr + '+03:00';
        console.log('📝 Timezone eklenmiş:', withTimezone);
        const parsed1 = new Date(withTimezone);
        console.log('✅ Parse sonucu:', parsed1.toISOString());
        console.log('✅ Valid mi?', !isNaN(parsed1.getTime()));
        
        if (!isNaN(parsed1.getTime())) {
          const minutesAgo = Math.floor((Date.now() - parsed1.getTime()) / 60000);
          const hoursAgo = Math.floor(minutesAgo / 60);
          console.log('⏰ Kaç zaman önce:', hoursAgo > 0 ? `${hoursAgo} saat ${minutesAgo % 60} dakika` : `${minutesAgo} dakika`);
        } else {
          console.log('❌ Parse başarısız!');
          
          // Alternatif: Boşluğu T ile değiştir
          const fixedStr = afadDateStr.replace(' ', 'T') + '+03:00';
          console.log('🔧 Düzeltilmiş format:', fixedStr);
          const parsed2 = new Date(fixedStr);
          console.log('✅ Parse sonucu:', parsed2.toISOString());
          
          if (!isNaN(parsed2.getTime())) {
            const minutesAgo = Math.floor((Date.now() - parsed2.getTime()) / 60000);
            const hoursAgo = Math.floor(minutesAgo / 60);
            console.log('⏰ Kaç zaman önce:', hoursAgo > 0 ? `${hoursAgo} saat ${minutesAgo % 60} dakika` : `${minutesAgo} dakika`);
          }
        }
        console.log('');
      });
    }
  } catch (error) {
    console.error('❌ Hata:', error.message);
  }
}

testCurrentAFADFormat();
