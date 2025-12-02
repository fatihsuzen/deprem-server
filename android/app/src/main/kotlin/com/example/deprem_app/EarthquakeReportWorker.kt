package com.example.deprem_app

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.net.HttpURLConnection
import java.net.URL

class EarthquakeReportWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    
    override fun doWork(): Result {
        try {
            val url = inputData.getString("url") ?: return Result.failure()
            val jsonBody = inputData.getString("jsonBody") ?: return Result.failure()
            
            Log.d("EarthquakeWorker", "HTTP POST başlatılıyor: $url")
            Log.d("EarthquakeWorker", "Body: $jsonBody")
            
            val connection = URL(url).openConnection() as HttpURLConnection
            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true
            connection.connectTimeout = 10000
            connection.readTimeout = 10000
            
            val outputStream = connection.outputStream
            outputStream.write(jsonBody.toByteArray())
            outputStream.flush()
            outputStream.close()
            
            val responseCode = connection.responseCode
            Log.d("EarthquakeWorker", "Response: $responseCode")
            
            connection.disconnect()
            
            return if (responseCode == 200 || responseCode == 201) {
                Log.d("EarthquakeWorker", "✅ Deprem raporu başarıyla gönderildi!")
                Result.success()
            } else {
                Log.e("EarthquakeWorker", "❌ HTTP hatası: $responseCode")
                Result.retry()
            }
        } catch (e: Exception) {
            Log.e("EarthquakeWorker", "❌ Worker hatası: ${e.message}")
            return Result.retry()
        }
    }
}
