const axios = require('axios');

async function testKandilliParser() {
  try {
    console.log('🔍 Kandilli verisi çekiliyor...\n');
    
    const response = await axios.get('http://www.koeri.boun.edu.tr/scripts/lst0.asp', {
      timeout: 5000
    });
    
    const htmlData = response.data;
    const lines = htmlData.split('\n');
    
    console.log(`📄 Toplam satır sayısı: ${lines.length}\n`);
    console.log('📋 İlk 20 satır:\n');
    
    for (let i = 0; i < Math.min(20, lines.length); i++) {
      console.log(`[${i}] ${lines[i]}`);
    }
    
    console.log('\n🔍 Tarih içeren satırlar:\n');
    
    let earthquakes = [];
    for (let i = 0; i < lines.length; i++) {
      const line = lines[i].trim();
      if (/\d{4}\.\d{2}\.\d{2}/.test(line)) {
        console.log(`[${i}] ${line}`);
        if (i + 1 < lines.length) {
          console.log(`[${i+1}] ${lines[i+1].trim()}`);
        }
        console.log('---');
        
        if (earthquakes.length >= 10) break;
      }
    }
    
    console.log('\n🧪 Parser testi:\n');
    
    earthquakes = [];
    for (let i = 0; i < lines.length - 1; i++) {
      const line1 = lines[i].trim();
      const line2 = lines[i + 1].trim();
      
      // Line 1: DATE TIME LAT LON DEPTH -.-
      const match1 = line1.match(/^(\d{4}\.\d{2}\.\d{2})\s+(\d{2}:\d{2}:\d{2})\s+([\d.]+)\s+([\d.]+)\s+([\d.]+)\s+-\.-\s*$/);
      
      if (match1) {
        console.log(`✅ Match1 bulundu: ${line1}`);
        
        // Line 2: MAG -.- LOCATION
        const match2 = line2.match(/^([\d.]+)\s+-\.-\s+(.+)$/);
        
        if (match2) {
          console.log(`✅ Match2 bulundu: ${line2}`);
          
          const [_, dateStr, timeStr, latStr, lonStr, depthStr] = match1;
          const [__, magStr, place] = match2;
          
          console.log(`   📅 Tarih: ${dateStr} ${timeStr}`);
          console.log(`   📍 Konum: ${latStr}, ${lonStr}`);
          console.log(`   📏 Derinlik: ${depthStr}`);
          console.log(`   📊 Büyüklük: ${magStr}`);
          console.log(`   🏙️  Yer: ${place}`);
          console.log('');
          
          earthquakes.push({ dateStr, timeStr, latStr, lonStr, depthStr, magStr, place });
          
          if (earthquakes.length >= 5) break;
        } else {
          console.log(`❌ Match2 BAŞARISIZ: ${line2}`);
        }
      }
    }
    
    console.log(`\n✅ Toplam parse edilen: ${earthquakes.length} deprem`);
    
  } catch (error) {
    console.error('❌ Hata:', error.message);
  }
}

testKandilliParser();
