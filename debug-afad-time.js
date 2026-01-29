const axios = require('axios');

async function testAFADTime() {
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
    console.log('🕒 Sistem Zamanı (UTC):', now.toISOString());
    console.log('🕒 Türkiye Zamanı (UTC+3):', new Date(now.getTime() + (3 * 60 * 60 * 1000)).toISOString());
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
      
      // İlk 3 depremi incele
      for (let i = 0; i < Math.min(3, earthquakes.length); i++) {
        const eq = earthquakes[i];
        const afadDateStr = eq.date || eq.event_date_time || eq.timestamp;
        
        console.log(`\n━━━ Deprem ${i + 1} ━━━`);
        console.log('📍 Lokasyon:', eq.location || eq.place);
        console.log('📊 Büyüklük:', eq.mag || eq.magnitude);
        console.log('');
        console.log('🔍 AFAD\'tan gelen tarih string:', afadDateStr);
        
        if (afadDateStr) {
          const afadDate = new Date(afadDateStr);
          console.log('🕐 Parse edilmiş (olduğu gibi):', afadDate.toISOString());
          
          // Türkiye saati varsayımı - 3 saat çıkar
          const utcConverted = new Date(afadDate.getTime() - (3 * 60 * 60 * 1000));
          console.log('🕑 UTC\'ye çevrilmiş (-3 saat):', utcConverted.toISOString());
          
          // Şimdiden ne kadar önce (UTC converted ile)
          const minutesAgo = Math.floor((Date.now() - utcConverted.getTime()) / (1000 * 60));
          console.log('⏰ Kaç dakika önce (UTC):', minutesAgo, 'dakika');
          
          // Eğer + 3 saat yaparsak ne olur?
          const wrongConversion = new Date(afadDate.getTime() + (3 * 60 * 60 * 1000));
          const wrongMinutesAgo = Math.floor((Date.now() - wrongConversion.getTime()) / (1000 * 60));
          console.log('❌ Yanlış dönüşüm (+3 saat):', wrongConversion.toISOString());
          console.log('❌ Yanlış hesaplama:', wrongMinutesAgo, 'dakika önce');
        }
      }
    } else {
      console.log('⚠️ Deprem verisi bulunamadı');
    }
  } catch (error) {
    console.error('❌ Hata:', error.message);
  }
}

testAFADTime();
