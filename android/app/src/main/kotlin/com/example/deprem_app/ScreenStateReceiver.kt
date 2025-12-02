package com.example.deprem_app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.PowerManager
import android.util.Log
import java.io.File
import org.json.JSONObject

class ScreenStateReceiver : BroadcastReceiver() {
    companion object {
        private const val TAG = "ScreenStateReceiver"
        private const val SCREEN_STATE_FILE = "screen_state.json"
        
        fun writeScreenState(context: Context, isScreenOn: Boolean) {
            try {
                val file = File(context.filesDir, SCREEN_STATE_FILE)
                val json = JSONObject()
                json.put("isScreenOn", isScreenOn)
                json.put("timestamp", System.currentTimeMillis())
                file.writeText(json.toString())
                Log.d(TAG, "Screen state yazıldı: isScreenOn=$isScreenOn")
            } catch (e: Exception) {
                Log.e(TAG, "Screen state yazma hatası: ${e.message}")
            }
        }
        
        fun getScreenState(context: Context): Boolean {
            try {
                // Önce PowerManager'dan kontrol et (en güncel bilgi)
                val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
                return powerManager.isInteractive
            } catch (e: Exception) {
                Log.e(TAG, "PowerManager hatası: ${e.message}")
                // Fallback: dosyadan oku
                try {
                    val file = File(context.filesDir, SCREEN_STATE_FILE)
                    if (file.exists()) {
                        val json = JSONObject(file.readText())
                        return json.getBoolean("isScreenOn")
                    }
                } catch (e2: Exception) {
                    Log.e(TAG, "Dosyadan okuma hatası: ${e2.message}")
                }
                return true // Varsayılan: ekran açık
            }
        }
    }
    
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Intent.ACTION_SCREEN_ON -> {
                Log.d(TAG, "📱 Ekran açıldı")
                writeScreenState(context, true)
            }
            Intent.ACTION_SCREEN_OFF -> {
                Log.d(TAG, "📴 Ekran kapandı")
                writeScreenState(context, false)
            }
            Intent.ACTION_USER_PRESENT -> {
                Log.d(TAG, "👤 Kullanıcı kilit ekranını açtı")
                writeScreenState(context, true)
            }
        }
    }
}
