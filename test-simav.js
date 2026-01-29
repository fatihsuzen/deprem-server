// Simav depremini test et
const now = new Date();
console.log('Şu an (UTC):', now.toISOString());
console.log('Şu an (ms):', now.getTime());
console.log('');

// Simav depremi
const simavStr = '2026-01-29 05:28:53'; // AFAD verisi (Türkiye saati)
console.log('Simav AFAD string:', simavStr);

// Format kontrolü
const hasT = simavStr.includes('T');
console.log('T var mı?', hasT);

let quakeDate;
if (!hasT) {
  // Boşluğu T ile değiştir
  const isoStr = simavStr.replace(' ', 'T') + '+03:00';
  console.log('ISO format:', isoStr);
  quakeDate = new Date(isoStr);
} else {
  quakeDate = new Date(simavStr + '+03:00');
}

console.log('Parse sonucu (UTC):', quakeDate.toISOString());
console.log('Parse sonucu (ms):', quakeDate.getTime());
console.log('');

const minutesAgo = Math.floor((now.getTime() - quakeDate.getTime()) / 60000);
const hoursAgo = Math.floor(minutesAgo / 60);

console.log('Fark (dakika):', minutesAgo);
console.log('Fark (saat:dakika):', hoursAgo, 'saat', minutesAgo % 60, 'dakika');
console.log('');
console.log('Beklenen: ~1 saat 15 dakika');
console.log('Gerçek:', minutesAgo, 'dakika');
