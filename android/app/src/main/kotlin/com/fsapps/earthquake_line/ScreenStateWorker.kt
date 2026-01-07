package com.fsapps.earthquake_line

import android.content.Context
import android.os.PowerManager
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.io.File
import org.json.JSONObject

/**
 * Ekran durumunu periyodik olarak kontrol eden ve dosyaya yazan Worker.
 * Bu sayede uygulama arka plandayken bile ekran durumu güncel kalır.
 */
class ScreenStateWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    
    companion object {
        private const val TAG = "ScreenStateWorker"
        private const val SCREEN_STATE_FILE = "screen_state.json"
    }
    
    override fun doWork(): Result {
        return try {
            val powerManager = applicationContext.getSystemService(Context.POWER_SERVICE) as PowerManager
            val isScreenOn = powerManager.isInteractive
            
            // Dosyaya yaz
            val file = File(applicationContext.filesDir, SCREEN_STATE_FILE)
            val json = JSONObject()
            json.put("isScreenOn", isScreenOn)
            json.put("timestamp", System.currentTimeMillis())
            json.put("source", "worker")
            file.writeText(json.toString())
            
            Log.d(TAG, "📱 Ekran durumu güncellendi: isScreenOn=$isScreenOn")
            
            Result.success()
        } catch (e: Exception) {
            Log.e(TAG, "❌ Ekran durumu güncellenirken hata: ${e.message}")
            Result.failure()
        }
    }
}
