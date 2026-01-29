const axios = require('axios');

async function testCurrentAFAD() {
  try {
    const now = new Date();
    const yesterday = new Date(Date.now() - 24 * 60 * 60 * 1000);
    
    function formatDate(date) {
      return date.toISOString().split('T')[0];
    }
    
    console.log('🕐 Şu an sistem zamanı (UTC):', now.toISOString());
    console.log('🕐 Şu an Türkiye (UTC+3):', new Date(now.getTime() + (3 * 60 * 60 * 1000)).toISOString());
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
      // En yeni 3 depremi sırala
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
        console.log('🔍 AFAD\'tan gelen string:', afadDateStr);
        
        // Şu anki kodumuz
        const withTimezone = afadDateStr + '+03:00';
        const parsed = new Date(withTimezone);
        console.log('✅ Şu anki parse (+03:00):', parsed.toISOString());
        
        const minutesAgo = Math.floor((Date.now() - parsed.getTime()) / 60000);
        const hoursAgo = Math.floor(minutesAgo / 60);
        console.log('⏰ Kaç zaman önce:', hoursAgo > 0 ? `${hoursAgo} saat ${minutesAgo % 60} dakika önce` : `${minutesAgo} dakika önce`);
        
        // Alternatif: timezone olmadan
        const parsedNoTz = new Date(afadDateStr);
        console.log('🔄 Timezone olmadan parse:', parsedNoTz.toISOString());
        const minutesAgoNoTz = Math.floor((Date.now() - parsedNoTz.getTime()) / 60000);
        const hoursAgoNoTz = Math.floor(minutesAgoNoTz / 60);
        console.log('🔄 Timezone olmadan:', hoursAgoNoTz > 0 ? `${hoursAgoNoTz} saat ${minutesAgoNoTz % 60} dakika önce` : `${minutesAgoNoTz} dakika önce`);
        console.log('');
      });
    }
  } catch (error) {
    console.error('❌ Hata:', error.message);
  }
}

testCurrentAFAD();
