package com.fsapps.earthquake_line
import java.io.File
import org.json.JSONObject

import android.content.Context
import android.content.Intent
import android.os.PowerManager
import android.app.KeyguardManager
import android.os.Build
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    
    // Ekranı uyandırma fonksiyonu
    private fun wakeUpScreen() {
        try {
            val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
            
            // Ekran kapalıysa uyandır
            if (!pm.isInteractive) {
                android.util.Log.d("DepremApp", "MyFirebaseMessagingService: Ekran kapalı, uyandırılıyor...")
                
                // WakeLock ile ekranı uyandır
                @Suppress("DEPRECATION")
                val wakeLock = pm.newWakeLock(
                    PowerManager.SCREEN_BRIGHT_WAKE_LOCK or 
                    PowerManager.ACQUIRE_CAUSES_WAKEUP or 
                    PowerManager.ON_AFTER_RELEASE,
                    "DepremApp:FCMWakeLock"
                )
                wakeLock.acquire(10000) // 10 saniye ekranı açık tut
                android.util.Log.d("DepremApp", "MyFirebaseMessagingService: ✅ WakeLock acquired for 10 seconds!")
            } else {
                android.util.Log.d("DepremApp", "MyFirebaseMessagingService: Ekran zaten açık")
            }
        } catch (e: Exception) {
            android.util.Log.e("DepremApp", "MyFirebaseMessagingService: WakeLock hatası: ${e.message}")
        }
    }
    
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
            android.util.Log.d("DepremApp", "MyFirebaseMessagingService: onMessageReceived ÇAĞRILDI! remoteMessage = $remoteMessage")
        val data = remoteMessage.data
        android.util.Log.d("DepremApp", "MyFirebaseMessagingService: onMessageReceived, data = $data")
        
        // Sadece earthquake_alert tipindeki mesajları işle
        // Diğer mesajlar Flutter tarafında FCM plugin ile işlenecek
        if (data["type"] != "earthquake_alert") {
            android.util.Log.d("DepremApp", "MyFirebaseMessagingService: type != earthquake_alert, Flutter'a bırakılıyor")
            return // Uygulama açıkken Flutter tarafı zaten bildirimi alacak
        }
        
        if (data["type"] == "earthquake_alert") {
            // ÖNCELİKLE ekranı uyandır!
            wakeUpScreen()
            val magnitude = data["magnitude"]?.toDoubleOrNull() ?: 0.0
            val location = data["location"] ?: ""
            val distance = data["distance"]?.toDoubleOrNull() ?: 0.0
               val epicenterLon = data["epicenter_lon"] ?: ""
               val epicenterLat = data["epicenter_lat"] ?: ""
               val region = data["region"] ?: ""
               val source = data["source"] ?: ""
               val message = data["message"] ?: ""
               val arrivalSeconds = data["arrival_seconds"] ?: ""
               val direction = data["direction"] ?: ""
            android.util.Log.d("DepremApp", "MyFirebaseMessagingService: earthquake_alert received! magnitude=$magnitude, location=$location, distance=$distance")

            // Deprem parametrelerini SharedPreferences'a kaydet
            val prefs = getSharedPreferences("deprem_alert", MODE_PRIVATE)
            prefs.edit()
                .putFloat("magnitude", magnitude.toFloat())
                .putString("location", location)
                .putFloat("distance", distance.toFloat())
                .putLong("timestamp", System.currentTimeMillis())
                .putString("epicenter_lon", epicenterLon)
                .putString("epicenter_lat", epicenterLat)
                .putString("region", region)
                .putString("source", source)
                .putString("message", message)
                .putString("arrival_seconds", arrivalSeconds)
                .putString("direction", direction)
                .commit() // Senkron yaz

            // Deprem parametrelerini dosyaya yaz (güvenli fallback, applicationContext ile)
            try {
                val fileDir = applicationContext.filesDir
                if (fileDir != null) {
                    val file = java.io.File(fileDir, "deprem_alert.json")
                    val json = org.json.JSONObject()
                    json.put("magnitude", magnitude)
                    json.put("location", location)
                    json.put("distance", distance)
                    json.put("epicenter_lon", epicenterLon)
                    json.put("epicenter_lat", epicenterLat)
                    json.put("region", region)
                    json.put("source", source)
                    json.put("message", message)
                    json.put("arrival_seconds", arrivalSeconds)
                    json.put("direction", direction)
                    file.writeText(json.toString())
                    android.util.Log.d("DepremApp", "Dosya başarıyla yazıldı: path=${file.absolutePath}, content=${json.toString()}")
                } else {
                    android.util.Log.e("DepremApp", "filesDir null, dosya yazılamadı!")
                }
            } catch (e: Exception) {
                android.util.Log.e("DepremApp", "Dosya yazma hatası: ${e.message}")
            }
            // Kısa bir gecikme ekle (SharedPreferences'ın kesin yazılması için)
            try {
                Thread.sleep(100)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            val intent = Intent(this, MainActivity::class.java)
            intent.action = "com.fsapps.earthquake_line.ACTION_EARTHQUAKE_ALERT"
            intent.putExtra("magnitude", magnitude)
            intent.putExtra("location", location)
            intent.putExtra("distance", distance)
               intent.putExtra("epicenter_lon", epicenterLon)
               intent.putExtra("epicenter_lat", epicenterLat)
               intent.putExtra("region", region)
               intent.putExtra("source", source)
               intent.putExtra("message", message)
               intent.putExtra("arrival_seconds", arrivalSeconds)
               intent.putExtra("direction", direction)
            // Benzersiz data URI ekle
            intent.data = android.net.Uri.parse("deprem://alert?magnitude=$magnitude&location=$location&distance=$distance")
            // Ekranı uyandırmak ve kilit ekranı üzerinde göstermek için gerekli flag'ler
            intent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or 
                Intent.FLAG_ACTIVITY_CLEAR_TOP or 
                Intent.FLAG_ACTIVITY_SINGLE_TOP or
                Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            )
            // Android O ve üzeri için window flag'leri (API 26+)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION)
            }
            android.util.Log.d("DepremApp", "MyFirebaseMessagingService: starting MainActivity with intent extras: " + intent.extras?.keySet()?.joinToString())
            android.util.Log.d("DepremApp", "MyFirebaseMessagingService: intent data URI = " + intent.data)
            startActivity(intent)
        }
        // ...diğer bildirim işlemleri...
    }
}
