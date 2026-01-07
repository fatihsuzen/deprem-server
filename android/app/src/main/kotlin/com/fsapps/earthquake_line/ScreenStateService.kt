package com.fsapps.earthquake_line

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.PowerManager
import android.util.Log

/**
 * Ekran durumunu sürekli izleyen ve dosyaya yazan Service.
 * Foreground service olmadan arka planda çalışır.
 */
class ScreenStateService : Service() {
    
    companion object {
        private const val TAG = "ScreenStateService"
        private const val UPDATE_INTERVAL = 5000L // 5 saniyede bir güncelle
    }
    
    private var screenStateReceiver: ScreenStateReceiver? = null
    private val handler = Handler(Looper.getMainLooper())
    private var isRunning = false
    
    private val updateRunnable = object : Runnable {
        override fun run() {
            if (isRunning) {
                updateScreenState()
                handler.postDelayed(this, UPDATE_INTERVAL)
            }
        }
    }
    
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "ScreenStateService created")
        
        // BroadcastReceiver'ı kaydet
        registerScreenReceiver()
        
        // Periyodik güncellemeyi başlat
        isRunning = true
        handler.post(updateRunnable)
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "ScreenStateService started")
        return START_STICKY // Service öldürülürse yeniden başlat
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ScreenStateService destroyed")
        isRunning = false
        handler.removeCallbacks(updateRunnable)
        unregisterScreenReceiver()
    }
    
    override fun onBind(intent: Intent?): IBinder? = null
    
    private fun registerScreenReceiver() {
        if (screenStateReceiver == null) {
            screenStateReceiver = ScreenStateReceiver()
            val filter = IntentFilter().apply {
                addAction(Intent.ACTION_SCREEN_ON)
                addAction(Intent.ACTION_SCREEN_OFF)
                addAction(Intent.ACTION_USER_PRESENT)
            }
            registerReceiver(screenStateReceiver, filter)
            Log.d(TAG, "ScreenStateReceiver registered in service")
        }
    }
    
    private fun unregisterScreenReceiver() {
        screenStateReceiver?.let {
            try {
                unregisterReceiver(it)
                screenStateReceiver = null
                Log.d(TAG, "ScreenStateReceiver unregistered from service")
            } catch (e: Exception) {
                Log.e(TAG, "Error unregistering receiver: ${e.message}")
            }
        }
    }
    
    private fun updateScreenState() {
        try {
            val powerManager = getSystemService(POWER_SERVICE) as PowerManager
            val isScreenOn = powerManager.isInteractive
            ScreenStateReceiver.writeScreenState(this, isScreenOn)
            Log.d(TAG, "📱 Screen state updated: isScreenOn=$isScreenOn")
        } catch (e: Exception) {
            Log.e(TAG, "Error updating screen state: ${e.message}")
        }
    }
}
