const axios = require('axios');

axios.get('http://www.koeri.boun.edu.tr/scripts/lst0.asp').then(response => {
  const lines = response.data.split('\n');
  
  console.log('İlk tarih içeren 3 satırın detaylı analizi:\n');
  
  let found = 0;
  for (let i = 0; i < lines.length && found < 3; i++) {
    if (/\d{4}\.\d{2}\.\d{2}/.test(lines[i])) {
      found++;
      const line = lines[i];
      
      console.log(`=== Satır ${i} ===`);
      console.log('Metin:', line);
      console.log('Uzunluk:', line.length);
      console.log('İlk 20 karakter HEX:', Buffer.from(line.substring(0, 20)).toString('hex'));
      console.log('Son 20 karakter HEX:', Buffer.from(line.substring(line.length - 20)).toString('hex'));
      
      // Test regex
      const regex = /(\d{4}\.\d{2}\.\d{2})\s+(\d{2}:\d{2}:\d{2})\s+([\d.]+)\s+([\d.]+)\s+([\d.]+)\s+-\.-\s+([\d.]+)\s+-\.-\s+(.+)$/;
      const match = line.match(regex);
      
      if (match) {
        console.log('✅ REGEX MATCH!');
        console.log('   Tarih:', match[1], match[2]);
        console.log('   Mag:', match[6]);
      } else {
        console.log('❌ REGEX NO MATCH');
        
        // Try without trim
        const trimmed = line.trim();
        const match2 = trimmed.match(regex);
        if (match2) {
          console.log('✅ TRIM sonrası MATCH!');
        } else {
          console.log('❌ TRIM sonrası da NO MATCH');
        }
      }
      console.log('');
    }
  }
}).catch(err => console.error('Hata:', err.message));
