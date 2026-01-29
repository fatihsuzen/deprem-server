const axios = require('axios');

async function testAFADResponseFormat() {
  try {
    console.log('📡 Local API test ediliyor...\n');
    
    const response = await axios.get('http://localhost:3000/api/earthquakes', {
      params: {
        limit: 3,
        minMagnitude: 0,
        period: 'day'
      },
      timeout: 10000
    });
    
    if (response.data.success && response.data.earthquakes) {
      const earthquakes = response.data.earthquakes;
      console.log(`✅ ${earthquakes.length} deprem alındı\n`);
      
      // İlk AFAD depremini bul
      const afadQuake = earthquakes.find(eq => eq.source === 'AFAD');
      
      if (afadQuake) {
        console.log('━━━ AFAD Depremi ━━━');
        console.log('📍 Lokasyon:', afadQuake.place);
        console.log('📊 Büyüklük:', afadQuake.mag);
        console.log('');
        console.log('🕐 time field:', afadQuake.time);
        console.log('🕐 timestamp field:', afadQuake.timestamp);
        console.log('⏰ minutesAgo:', afadQuake.minutesAgo);
        console.log('');
        
        // Parse et
        const parsedTime = new Date(afadQuake.time);
        const now = new Date();
        const diffMinutes = Math.floor((now.getTime() - parsedTime.getTime()) / 60000);
        
        console.log('🔍 Flutter parse ederse:');
        console.log('   Parsed:', parsedTime.toISOString());
        console.log('   Şimdi:', now.toISOString());
        console.log('   Fark:', diffMinutes, 'dakika');
        console.log('');
        console.log(afadQuake.minutesAgo === diffMinutes ? '✅ DOĞRU' : `❌ YANLIŞ (${Math.abs(afadQuake.minutesAgo - diffMinutes)} dakika fark)`);
      } else {
        console.log('⚠️ AFAD depremi bulunamadı');
      }
    }
  } catch (error) {
    if (error.code === 'ECONNREFUSED') {
      console.log('❌ Server çalışmıyor. Önce `npm start` ile başlatın.');
    } else {
      console.error('❌ Hata:', error.message);
    }
  }
}

testAFADResponseFormat();
