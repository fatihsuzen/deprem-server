/**
 * Server-side notification text translations.
 * Supported languages: tr, en, es, hi, fil, my
 */

const translations = {
  tr: {
    earthquakeWarning: (distanceText) => `🚨 DEPREM UYARISI - ${distanceText} uzaklıkta`,
    p2pDetected: '🟢 P2P Deprem Algılandı!',
    earthquakeBody: (mag, region, depth, distance) =>
      `Büyüklük: ${mag}mw ${region}\n- Derinlik: ${depth}km\n- Mesafe: ${distance}`,
    p2pBody: (region, mag, distance) =>
      `P2P algılama ile deprem tespit edildi! Bölge: ${region}\nBüyüklük: ${mag}mw\nMesafe: ${distance}`,
    warningByMagnitude: (mag) => {
      if (mag >= 7.0) return 'ÇOK ŞİDDETLİ DEPREM! Hemen güvenli alana geçin!';
      if (mag >= 6.0) return 'ŞİDDETLİ DEPREM! Güvenli alana geçin!';
      if (mag >= 5.0) return 'ORTA ŞİDDETTE DEPREM! Dikkatli olun!';
      if (mag >= 4.0) return 'HAFIF DEPREM tespit edildi.';
      return 'Sismik aktivite tespit edildi.';
    },
  },
  en: {
    earthquakeWarning: (distanceText) => `🚨 EARTHQUAKE WARNING - ${distanceText} away`,
    p2pDetected: '🟢 P2P Earthquake Detected!',
    earthquakeBody: (mag, region, depth, distance) =>
      `Magnitude: ${mag}mw ${region}\n- Depth: ${depth}km\n- Distance: ${distance}`,
    p2pBody: (region, mag, distance) =>
      `P2P detection earthquake! Region: ${region}\nMagnitude: ${mag}mw\nDistance: ${distance}`,
    warningByMagnitude: (mag) => {
      if (mag >= 7.0) return 'VERY STRONG EARTHQUAKE! Move to safety immediately!';
      if (mag >= 6.0) return 'STRONG EARTHQUAKE! Move to a safe area!';
      if (mag >= 5.0) return 'MODERATE EARTHQUAKE! Be careful!';
      if (mag >= 4.0) return 'LIGHT EARTHQUAKE detected.';
      return 'Seismic activity detected.';
    },
  },
  es: {
    earthquakeWarning: (distanceText) => `🚨 ALERTA DE TERREMOTO - a ${distanceText}`,
    p2pDetected: '🟢 ¡Terremoto P2P Detectado!',
    earthquakeBody: (mag, region, depth, distance) =>
      `Magnitud: ${mag}mw ${region}\n- Profundidad: ${depth}km\n- Distancia: ${distance}`,
    p2pBody: (region, mag, distance) =>
      `¡Terremoto detectado P2P! Región: ${region}\nMagnitud: ${mag}mw\nDistancia: ${distance}`,
    warningByMagnitude: (mag) => {
      if (mag >= 7.0) return '¡TERREMOTO MUY FUERTE! ¡Busca refugio inmediatamente!';
      if (mag >= 6.0) return '¡TERREMOTO FUERTE! ¡Ve a un lugar seguro!';
      if (mag >= 5.0) return '¡TERREMOTO MODERADO! ¡Ten cuidado!';
      if (mag >= 4.0) return 'Terremoto leve detectado.';
      return 'Actividad sísmica detectada.';
    },
  },
  hi: {
    earthquakeWarning: (distanceText) => `🚨 भूकंप चेतावनी - ${distanceText} दूर`,
    p2pDetected: '🟢 P2P भूकंप का पता चला!',
    earthquakeBody: (mag, region, depth, distance) =>
      `परिमाण: ${mag}mw ${region}\n- गहराई: ${depth}km\n- दूरी: ${distance}`,
    p2pBody: (region, mag, distance) =>
      `P2P द्वारा भूकंप का पता! क्षेत्र: ${region}\nपरिमाण: ${mag}mw\nदूरी: ${distance}`,
    warningByMagnitude: (mag) => {
      if (mag >= 7.0) return 'बहुत तीव्र भूकंप! तुरंत सुरक्षित स्थान पर जाएं!';
      if (mag >= 6.0) return 'तीव्र भूकंप! सुरक्षित स्थान पर जाएं!';
      if (mag >= 5.0) return 'मध्यम भूकंप! सावधान रहें!';
      if (mag >= 4.0) return 'हल्का भूकंप महसूस किया गया।';
      return 'भूकंपीय गतिविधि का पता चला।';
    },
  },
  fil: {
    earthquakeWarning: (distanceText) => `🚨 BABALA SA LINDOL - ${distanceText} ang layo`,
    p2pDetected: '🟢 Natukoy ang P2P na Lindol!',
    earthquakeBody: (mag, region, depth, distance) =>
      `Magnitude: ${mag}mw ${region}\n- Lalim: ${depth}km\n- Distansya: ${distance}`,
    p2pBody: (region, mag, distance) =>
      `Natukoy ng P2P ang lindol! Rehiyon: ${region}\nMagnitude: ${mag}mw\nDistansya: ${distance}`,
    warningByMagnitude: (mag) => {
      if (mag >= 7.0) return 'NAPAKALAKAS NA LINDOL! Pumunta sa ligtas na lugar agad!';
      if (mag >= 6.0) return 'MALAKAS NA LINDOL! Lumipat sa ligtas na lugar!';
      if (mag >= 5.0) return 'KATAMTAMANG LINDOL! Mag-ingat!';
      if (mag >= 4.0) return 'Banayad na lindol ang natukoy.';
      return 'Natukoy ang seismikong aktibidad.';
    },
  },
  my: {
    earthquakeWarning: (distanceText) => `🚨 ငလျင် သတိပေးချက် - ${distanceText} ကွာဝေး`,
    p2pDetected: '🟢 P2P ငလျင် တွေ့ရှိပြီ!',
    earthquakeBody: (mag, region, depth, distance) =>
      `အဆင့်: ${mag}mw ${region}\n- နက်မှု: ${depth}km\n- ကွာဝေး: ${distance}`,
    p2pBody: (region, mag, distance) =>
      `P2P ဖြင့် ငလျင် တွေ့ရှိ! ဒေသ: ${region}\nအဆင့်: ${mag}mw\nကွာဝေး: ${distance}`,
    warningByMagnitude: (mag) => {
      if (mag >= 7.0) return 'အလွန်ပြင်းထန်သော ငလျင်! ချက်ချင်း လုံခြုံသောနေရာသို့ သွားပါ!';
      if (mag >= 6.0) return 'ပြင်းထန်သော ငလျင်! လုံခြုံသောနေရာသို့ သွားပါ!';
      if (mag >= 5.0) return 'အလတ်စား ငလျင်! သတိထားပါ!';
      if (mag >= 4.0) return 'အပေါ့စား ငလျင် တွေ့ရှိ။';
      return 'ငလျင်လှုပ်ရှားမှု တွေ့ရှိ။';
    },
  },
};

/**
 * Get translations for a given language code.
 * Falls back to English if language not supported.
 */
function getT(lang) {
  return translations[lang] || translations['en'];
}

module.exports = { getT };
