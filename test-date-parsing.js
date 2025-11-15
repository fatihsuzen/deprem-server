// Test date parsing from Kandilli format

const dateStr = "2025.11.15";
const timeStr = "05:55:23";

console.log('Kandilli formatı:');
console.log('Tarih:', dateStr);
console.log('Saat:', timeStr);
console.log('');

// Current parsing method
const [year, month, day] = dateStr.split('.').map(Number);
const [hour, minute, second] = timeStr.split(':').map(Number);

console.log('Parse edilen değerler:');
console.log('Year:', year);
console.log('Month:', month, '(0-indexed olacak:', month - 1, ')');
console.log('Day:', day);
console.log('Hour:', hour);
console.log('Minute:', minute);
console.log('Second:', second);
console.log('');

// Create date as local time
const timestamp1 = new Date(year, month - 1, day, hour, minute, second);
console.log('Oluşturulan timestamp (local):', timestamp1);
console.log('ISO format:', timestamp1.toISOString());
console.log('');

// Current time
const now = new Date();
console.log('Şu anki zaman:', now);
console.log('ISO format:', now.toISOString());
console.log('');

// Calculate age
const ageMs = now - timestamp1;
const ageMinutes = ageMs / (1000 * 60);
const ageHours = ageMs / (1000 * 60 * 60);

console.log('Yaş hesaplaması:');
console.log('Fark (ms):', ageMs);
console.log('Fark (dakika):', Math.floor(ageMinutes));
console.log('Fark (saat):', ageHours.toFixed(2));
console.log('');

if (ageHours < 1) {
  console.log(`✅ Gösterim: ${Math.floor(ageMinutes)} dakika önce`);
} else if (ageHours < 24) {
  console.log(`✅ Gösterim: ${Math.floor(ageHours)} saat önce`);
} else {
  console.log(`❌ SORUN: ${Math.floor(ageHours / 24)} gün önce`);
}
console.log('');

// Test with timezone offset
console.log('Timezone bilgisi:');
console.log('Local timezone offset (dakika):', now.getTimezoneOffset());
console.log('Local timezone offset (saat):', now.getTimezoneOffset() / 60);
console.log('');

// Try parsing as UTC+3 (Turkey time)
const turkeyOffset = 3; // UTC+3
const utcTimestamp = new Date(Date.UTC(year, month - 1, day, hour - turkeyOffset, minute, second));
console.log('Türkiye saati olarak (UTC+3):', utcTimestamp);
console.log('ISO format:', utcTimestamp.toISOString());

const ageHours2 = (now - utcTimestamp) / (1000 * 60 * 60);
console.log('Yaş (saat):', ageHours2.toFixed(2));
