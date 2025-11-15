// Test specific line format
const testLine = "2025.11.15 05:55:23  39.2113   28.1335        8.9      -.-  1.1  -.-   MANDIRA-SINDIRGI (BALIKESIR)";

console.log('Test satırı:', testLine);
console.log('');

// Current regex from parser
const regex = /(\d{4}\.\d{2}\.\d{2})\s+(\d{2}:\d{2}:\d{2})\s+([\d.]+)\s+([\d.]+)\s+([\d.]+)\s+-\.-\s+([\d.]+)\s+-\.-\s+(.+)$/;

console.log('Regex:', regex);
console.log('');

const match = testLine.match(regex);

if (match) {
  console.log('✅ MATCH BULUNDU!');
  console.log('');
  console.log('Groups:');
  match.forEach((group, index) => {
    console.log(`[${index}] ${group}`);
  });
} else {
  console.log('❌ MATCH BULUNAMADI!');
  console.log('');
  
  // Try simpler patterns
  console.log('Basit testler:');
  console.log('Tarih var mı?', /\d{4}\.\d{2}\.\d{2}/.test(testLine));
  console.log('Saat var mı?', /\d{2}:\d{2}:\d{2}/.test(testLine));
  console.log('-.- var mı?', /-\.-/.test(testLine));
  
  console.log('');
  console.log('Regex parça parça:');
  
  let pos = 0;
  const patterns = [
    ['Tarih', /\d{4}\.\d{2}\.\d{2}/],
    ['Saat', /\d{2}:\d{2}:\d{2}/],
    ['Lat', /[\d.]+/],
    ['Lon', /[\d.]+/],
    ['Depth', /[\d.]+/],
    ['Dash1', /-\.-/],
    ['Mag', /[\d.]+/],
    ['Dash2', /-\.-/],
    ['Place', /.+$/]
  ];
  
  let remaining = testLine;
  for (const [name, pattern] of patterns) {
    const match = remaining.match(pattern);
    if (match) {
      console.log(`✅ ${name}: "${match[0]}"`);
      remaining = remaining.slice(match.index + match[0].length).trim();
    } else {
      console.log(`❌ ${name}: BULUNAMADI`);
      break;
    }
  }
}
