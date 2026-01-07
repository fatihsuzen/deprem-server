package com.fsapps.earthquake_line

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.FileObserver
import android.util.Log
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Data
import java.io.File
import org.json.JSONObject

class EarthquakeReportService : Service() {
    
    private var fileObserver: FileObserver? = null
    
    override fun onCreate() {
        super.onCreate()
        Log.d("EarthquakeService", "Service başlatıldı")
        startFileObserver()
    }
    
    private fun startFileObserver() {
        val reportDir = File(filesDir, "earthquake_reports")
        if (!reportDir.exists()) {
            reportDir.mkdirs()
        }
        
        fileObserver = object : FileObserver(reportDir.absolutePath, CREATE or MODIFY) {
            override fun onEvent(event: Int, path: String?) {
                if (path == null) return
                
                Log.d("EarthquakeService", "Dosya değişikliği algılandı: $path")
                
                if (path.endsWith(".json")) {
                    val file = File(reportDir, path)
                    if (file.exists()) {
                        try {
                            val jsonStr = file.readText()
                            val json = JSONObject(jsonStr)
                            
                            val url = json.optString("url", "http://188.132.202.24:3000/api/p2p/shake-report")
                            
                            // WorkManager ile HTTP isteği gönder
                            val inputData = Data.Builder()
                                .putString("url", url)
                                .putString("jsonBody", jsonStr)
                                .build()
                            
                            val workRequest = OneTimeWorkRequestBuilder<EarthquakeReportWorker>()
                                .setInputData(inputData)
                                .build()
                            
                            WorkManager.getInstance(applicationContext).enqueue(workRequest)
                            Log.d("EarthquakeService", "✅ Deprem raporu WorkManager'a gönderildi!")
                            
                            // Dosyayı sil
                            file.delete()
                        } catch (e: Exception) {
                            Log.e("EarthquakeService", "Dosya okuma hatası: ${e.message}")
                        }
                    }
                }
            }
        }
        fileObserver?.startWatching()
        Log.d("EarthquakeService", "FileObserver başlatıldı: ${reportDir.absolutePath}")
    }
    
    override fun onDestroy() {
        super.onDestroy()
        fileObserver?.stopWatching()
        Log.d("EarthquakeService", "Service durduruldu")
    }
    
    override fun onBind(intent: Intent?): IBinder? = null
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }
}
