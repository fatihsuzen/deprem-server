package com.example.deprem_app
import java.io.File
import org.json.JSONObject

import android.os.PowerManager
import android.os.BatteryManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Data
import androidx.work.ExistingPeriodicWorkPolicy
import java.util.concurrent.TimeUnit

class MainActivity: FlutterActivity() {
	private var screenStateReceiver: ScreenStateReceiver? = null

			override fun onResume() {
				super.onResume()
				android.util.Log.d("DepremApp", "onResume called!")
				// Ekran durumunu güncelle
				ScreenStateReceiver.writeScreenState(this, true)
				val params = getEarthquakeParamsFromIntent(intent)
				android.util.Log.d("DepremApp", "onResume: params = $params")
				sendEarthquakeParamsToFlutter(params)
				// Eğer parametreler null ise, 500ms sonra tekrar dene
				if (params == null) {
					android.os.Handler().postDelayed({
						val delayedParams = getEarthquakeParamsFromIntent(intent)
						android.util.Log.d("DepremApp", "Delayed check: params = $delayedParams")
						sendEarthquakeParamsToFlutter(delayedParams)
					}, 500)
				}
			}

		override fun onPause() {
			super.onPause()
			// Uygulama arka plana geçtiğinde ekran durumunu güncelle
			android.util.Log.d("DepremApp", "onPause called!")
		}

		override fun onCreate(savedInstanceState: android.os.Bundle?) {
			super.onCreate(savedInstanceState)
			android.util.Log.d("DepremApp", "onCreate called!")
			
			// Screen state receiver'ı kaydet
			registerScreenStateReceiver()
			
			// Periyodik ekran durumu worker'ını başlat (her 15 dakikada bir)
			startScreenStateWorker()
			
			// Screen State Service'ı başlat (5 saniyede bir günceller)
			startScreenStateService()
			
			// Mevcut ekran durumunu yaz
			val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
			val isScreenOn = powerManager.isInteractive
			ScreenStateReceiver.writeScreenState(this, isScreenOn)
			android.util.Log.d("DepremApp", "Initial screen state: isScreenOn=$isScreenOn")
			
			val params = getEarthquakeParamsFromIntent(intent)
			android.util.Log.d("DepremApp", "onCreate: params = $params")
			sendEarthquakeParamsToFlutter(params)
		}

		override fun onDestroy() {
			super.onDestroy()
			// Screen state receiver'ı kaldır
			unregisterScreenStateReceiver()
		}

		private fun registerScreenStateReceiver() {
			if (screenStateReceiver == null) {
				screenStateReceiver = ScreenStateReceiver()
				val filter = IntentFilter().apply {
					addAction(Intent.ACTION_SCREEN_ON)
					addAction(Intent.ACTION_SCREEN_OFF)
					addAction(Intent.ACTION_USER_PRESENT)
				}
				registerReceiver(screenStateReceiver, filter)
				android.util.Log.d("DepremApp", "ScreenStateReceiver registered")
			}
		}

		private fun unregisterScreenStateReceiver() {
			screenStateReceiver?.let {
				try {
					unregisterReceiver(it)
					screenStateReceiver = null
					android.util.Log.d("DepremApp", "ScreenStateReceiver unregistered")
				} catch (e: Exception) {
					android.util.Log.e("DepremApp", "Error unregistering receiver: ${e.message}")
				}
			}
		}

		private fun startScreenStateWorker() {
			try {
				// Her 15 dakikada bir ekran durumunu kontrol et (WorkManager minimum)
				val workRequest = PeriodicWorkRequestBuilder<ScreenStateWorker>(15, TimeUnit.MINUTES)
					.build()
				
				WorkManager.getInstance(this).enqueueUniquePeriodicWork(
					"screen_state_worker",
					ExistingPeriodicWorkPolicy.KEEP,
					workRequest
				)
				android.util.Log.d("DepremApp", "ScreenStateWorker started (every 15 minutes)")
				
				// Hemen bir kez çalıştır
				val immediateWork = OneTimeWorkRequestBuilder<ScreenStateWorker>().build()
				WorkManager.getInstance(this).enqueue(immediateWork)
			} catch (e: Exception) {
				android.util.Log.e("DepremApp", "Error starting ScreenStateWorker: ${e.message}")
			}
		}

		private fun startScreenStateService() {
			try {
				val serviceIntent = Intent(this, ScreenStateService::class.java)
				startService(serviceIntent)
				android.util.Log.d("DepremApp", "ScreenStateService started")
			} catch (e: Exception) {
				android.util.Log.e("DepremApp", "Error starting ScreenStateService: ${e.message}")
			}
		}

	// Deprem parametrelerini intent'ten oku
	private fun getEarthquakeParamsFromIntent(intent: Intent?): Map<String, Any>? {
		if (intent == null) {
			android.util.Log.d("DepremApp", "getEarthquakeParamsFromIntent: intent is null!")
			return null
		}
		android.util.Log.d("DepremApp", "getEarthquakeParamsFromIntent: intent extras = " + intent.extras?.keySet()?.joinToString())
		if (intent.hasExtra("magnitude") || intent.hasExtra("location") || intent.hasExtra("distance")) {
			val params = mutableMapOf<String, Any>()
			params["magnitude"] = intent.getDoubleExtra("magnitude", 0.0)
			params["location"] = intent.getStringExtra("location") ?: ""
			params["distance"] = intent.getDoubleExtra("distance", 0.0)
			params["epicenter_lon"] = intent.getStringExtra("epicenter_lon") ?: ""
			params["epicenter_lat"] = intent.getStringExtra("epicenter_lat") ?: ""
			params["region"] = intent.getStringExtra("region") ?: ""
			params["source"] = intent.getStringExtra("source") ?: ""
			params["message"] = intent.getStringExtra("message") ?: ""
			params["arrival_seconds"] = intent.getStringExtra("arrival_seconds") ?: ""
			params["direction"] = intent.getStringExtra("direction") ?: ""
			android.util.Log.d("DepremApp", "Intent params: $params")
			return params
		}
		// Data URI'den de parametreleri oku
		intent.data?.let { uri ->
			if (uri.scheme == "deprem" && uri.host == "alert") {
				val magnitude = uri.getQueryParameter("magnitude")?.toDoubleOrNull() ?: 0.0
				val location = uri.getQueryParameter("location") ?: ""
				val distance = uri.getQueryParameter("distance")?.toDoubleOrNull() ?: 0.0
				android.util.Log.d("DepremApp", "Intent DATA URI params: magnitude=$magnitude, location=$location, distance=$distance")
				return mapOf(
					"magnitude" to magnitude,
					"location" to location,
					"distance" to distance
				)
			}
		}
		// SharedPreferences'tan parametreleri oku (fallback)
		val prefs = getSharedPreferences("deprem_alert", Context.MODE_PRIVATE)
		val magnitude = prefs.getFloat("magnitude", -1f)
		val location = prefs.getString("location", null)
		val distance = prefs.getFloat("distance", -1f)
		val timestamp = prefs.getLong("timestamp", 0L)
		val epicenterLon = prefs.getString("epicenter_lon", null)
		val epicenterLat = prefs.getString("epicenter_lat", null)
		val region = prefs.getString("region", null)
		val source = prefs.getString("source", null)
		val message = prefs.getString("message", null)
		val arrivalSeconds = prefs.getString("arrival_seconds", null)
		val direction = prefs.getString("direction", null)
		if (magnitude > 0 && location != null && distance > 0) {
			val params = mutableMapOf<String, Any>()
			params["magnitude"] = magnitude.toDouble()
			params["location"] = location
			params["distance"] = distance.toDouble()
			params["timestamp"] = timestamp
			params["epicenter_lon"] = epicenterLon ?: ""
			params["epicenter_lat"] = epicenterLat ?: ""
			params["region"] = region ?: ""
			params["source"] = source ?: ""
			params["message"] = message ?: ""
			params["arrival_seconds"] = arrivalSeconds ?: ""
			params["direction"] = direction ?: ""
			android.util.Log.d("DepremApp", "SharedPreferences params: $params")
			return params
		} else {
			android.util.Log.d("DepremApp", "getEarthquakeParamsFromIntent: No earthquake params found in intent or SharedPreferences!")
		}
		// Dosyadan parametreleri oku (en güvenli fallback)
		try {
			val file = File(filesDir, "deprem_alert.json")
			android.util.Log.d("DepremApp", "Dosya kontrol: path=${file.absolutePath}, exists=${file.exists()}")
			if (file.exists()) {
				val jsonStr = file.readText()
				android.util.Log.d("DepremApp", "Dosya içeriği: $jsonStr")
				val json = JSONObject(jsonStr)
				val params = mutableMapOf<String, Any>()
				params["magnitude"] = json.optDouble("magnitude", 0.0)
				params["location"] = json.optString("location", "")
				params["distance"] = json.optDouble("distance", 0.0)
				params["epicenter_lon"] = json.optString("epicenter_lon", "")
				params["epicenter_lat"] = json.optString("epicenter_lat", "")
				params["region"] = json.optString("region", "")
				params["source"] = json.optString("source", "")
				params["message"] = json.optString("message", "")
				params["arrival_seconds"] = json.optString("arrival_seconds", "")
				params["direction"] = json.optString("direction", "")
				android.util.Log.d("DepremApp", "File params: $params")
				return params
			}
		} catch (e: Exception) {
			android.util.Log.e("DepremApp", "Dosyadan okuma hatası: ${e.message}")
		}
		return null
	}

	override fun onNewIntent(intent: Intent) {
		super.onNewIntent(intent)
		android.util.Log.d("DepremApp", "onNewIntent called!")
		val params = getEarthquakeParamsFromIntent(intent)
		android.util.Log.d("DepremApp", "onNewIntent: params = $params")
		sendEarthquakeParamsToFlutter(params)
	}
	private val CHANNEL = "deprem_app/wake_lock"
	private val ALERT_CHANNEL = "deprem_app/alert_activity"
	private val HTTP_CHANNEL = "deprem_app/http"
	private val DEVICE_STATE_CHANNEL = "deprem_app/device_state"
	private val WHISTLE_CHANNEL = "deprem_app/whistle"
	
	// Whistle için ToneGenerator
	private var toneGenerator: android.media.ToneGenerator? = null
	private var whistleTimer: java.util.Timer? = null
	private var isWhistlePlaying = false

	override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
		super.configureFlutterEngine(flutterEngine)
		android.util.Log.d("DepremApp", "configureFlutterEngine called!")

		// Earthquake Report Service'i başlat
		val serviceIntent = Intent(this, EarthquakeReportService::class.java)
		startService(serviceIntent)
		android.util.Log.d("DepremApp", "✅ EarthquakeReportService başlatıldı!")

		// Wake lock channel
		MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
			if (call.method == "wakeUpScreen") {
				android.util.Log.d("DepremApp", "wakeUpScreen called from Flutter!")
				wakeUpScreen()
				result.success(null)
			} else {
				result.notImplemented()
			}
		}

		// HTTP channel (arka plan HTTP istekleri için - WorkManager ile)
		MethodChannel(flutterEngine.dartExecutor.binaryMessenger, HTTP_CHANNEL).setMethodCallHandler { call, result ->
			if (call.method == "sendHttpPost") {
				val url = call.argument<String>("url") ?: ""
				val jsonBody = call.argument<String>("jsonBody") ?: ""
				android.util.Log.d("DepremApp", "WorkManager ile HTTP POST: url=$url")
				android.util.Log.d("DepremApp", "WorkManager ile HTTP POST: body=$jsonBody")
				try {
					// WorkManager ile arka plan işi başlat
					val inputData = Data.Builder()
						.putString("url", url)
						.putString("jsonBody", jsonBody)
						.build()
					
					val workRequest = OneTimeWorkRequestBuilder<EarthquakeReportWorker>()
						.setInputData(inputData)
						.build()
					
					WorkManager.getInstance(applicationContext).enqueue(workRequest)
					android.util.Log.d("DepremApp", "✅ WorkManager görevi kuyruğa alındı!")
					result.success(true)
				} catch (e: Exception) {
					android.util.Log.e("DepremApp", "WorkManager hatası: ${e.message}")
					result.error("WORK_MANAGER_ERROR", e.message, null)
				}
			} else {
				result.notImplemented()
			}
		}

		// Device State Channel - Anlık ekran ve şarj durumu kontrolü
		MethodChannel(flutterEngine.dartExecutor.binaryMessenger, DEVICE_STATE_CHANNEL).setMethodCallHandler { call, result ->
			if (call.method == "getRealTimeDeviceState") {
				// ANLIK ekran durumu kontrolü
				val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
				val isScreenOn = powerManager.isInteractive
				
				// ANLIK şarj durumu kontrolü
				val batteryIntent = registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
				val batteryStatus = batteryIntent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
				val isCharging = batteryStatus == BatteryManager.BATTERY_STATUS_CHARGING ||
								 batteryStatus == BatteryManager.BATTERY_STATUS_FULL
				
				// Pil seviyesi
				val batteryLevel = batteryIntent?.let { intent ->
					val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
					val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
					if (level >= 0 && scale > 0) (level * 100 / scale) else -1
				} ?: -1
				
				android.util.Log.d("DepremApp", "📱 Anlık Durum: isScreenOn=$isScreenOn, isCharging=$isCharging, batteryLevel=$batteryLevel%")
				
				val stateMap = mapOf(
					"isScreenOn" to isScreenOn,
					"isCharging" to isCharging,
					"batteryLevel" to batteryLevel
				)
				result.success(stateMap)
			} else {
				result.notImplemented()
			}
		}

		// Whistle Channel - Düdük sesi için
		MethodChannel(flutterEngine.dartExecutor.binaryMessenger, WHISTLE_CHANNEL).setMethodCallHandler { call, result ->
			when (call.method) {
				"startWhistle" -> {
					startWhistle()
					result.success(true)
				}
				"stopWhistle" -> {
					stopWhistle()
					result.success(true)
				}
				else -> result.notImplemented()
			}
		}

		// Alert activity channel
		MethodChannel(flutterEngine.dartExecutor.binaryMessenger, ALERT_CHANNEL).setMethodCallHandler { call, result ->
			if (call.method == "showEarthquakeAlertActivity") {
				val magnitude = call.argument<Double>("magnitude") ?: 0.0
				val location = call.argument<String>("location") ?: ""
				val distance = call.argument<Double>("distance") ?: 0.0
				android.util.Log.d("DepremApp", "showEarthquakeAlertActivity called from Flutter! magnitude=$magnitude, location=$location, distance=$distance")
				showEarthquakeAlertActivity(magnitude, location, distance)
				result.success(null)
			} else {
				result.notImplemented()
			}
		}

		// Deprem parametrelerini intent'ten oku ve Flutter'a ilet
		val params = getEarthquakeParamsFromIntent(intent)
		android.util.Log.d("DepremApp", "configureFlutterEngine: params = $params")
		sendEarthquakeParamsToFlutter(params)

		// Earthquake params channel
		MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "deprem_app/earthquake_params").setMethodCallHandler { call, result ->
			android.util.Log.d("DepremApp", "EarthquakeParams channel called: method = ${call.method}")
			if (call.method == "getEarthquakeParams") {
				val params = getEarthquakeParamsFromIntent(intent)
				android.util.Log.d("DepremApp", "EarthquakeParams channel: getEarthquakeParams = $params")
				result.success(params)
			} else if (call.method == "clearEarthquakeParams") {
				// Dosya ve SharedPreferences temizle
				try {
					val file = File(filesDir, "deprem_alert.json")
					if (file.exists()) {
						file.delete()
						android.util.Log.d("DepremApp", "deprem_alert.json dosyası silindi!")
					}
				} catch (e: Exception) {
					android.util.Log.e("DepremApp", "deprem_alert.json silinirken hata: ${e.message}")
				}
				try {
					val prefs = getSharedPreferences("deprem_alert", Context.MODE_PRIVATE)
					prefs.edit().clear().commit()
					android.util.Log.d("DepremApp", "SharedPreferences deprem_alert temizlendi!")
				} catch (e: Exception) {
					android.util.Log.e("DepremApp", "SharedPreferences temizlenirken hata: ${e.message}")
				}
				result.success(true)
			} else {
				result.notImplemented()
			}
		}
	}

	// Deprem parametrelerini Flutter'a ilet
	private fun sendEarthquakeParamsToFlutter(params: Map<String, Any>?) {
		val engine = flutterEngine ?: run {
			android.util.Log.d("DepremApp", "sendEarthquakeParamsToFlutter: flutterEngine is null!")
			return
		}
		android.util.Log.d("DepremApp", "sendEarthquakeParamsToFlutter: params = $params")
		MethodChannel(engine.dartExecutor.binaryMessenger, "deprem_app/earthquake_params").invokeMethod("updateEarthquakeParams", params)
	}

	private fun wakeUpScreen() {
		val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
		val wakeLock = pm.newWakeLock(
			PowerManager.SCREEN_BRIGHT_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP or PowerManager.ON_AFTER_RELEASE,
			"DepremApp:WakeLock"
		)
		android.util.Log.d("DepremApp", "wakeUpScreen: Wake lock acquired for 5 seconds!")
		wakeLock.acquire(5000) // 5 saniye ekranı uyandır
	}

	private fun showEarthquakeAlertActivity(magnitude: Double, location: String, distance: Double) {
		val intent = Intent(this, Class.forName("com.example.deprem_app.EarthquakeAlertActivity"))
		intent.putExtra("magnitude", magnitude)
		intent.putExtra("location", location)
		intent.putExtra("distance", distance)
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
		android.util.Log.d("DepremApp", "showEarthquakeAlertActivity: intent extras = magnitude=$magnitude, location=$location, distance=$distance")
		startActivity(intent)
	}

	// Native HTTP POST request (arka plan için)
	private fun sendHttpPostRequest(url: String, jsonBody: String) {
		Thread {
			try {
				val connection = java.net.URL(url).openConnection() as java.net.HttpURLConnection
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
				android.util.Log.d("DepremApp", "Native HTTP POST response: $responseCode")
				
				if (responseCode == 200 || responseCode == 201) {
					android.util.Log.d("DepremApp", "✅ Native HTTP POST başarılı!")
				} else {
					android.util.Log.e("DepremApp", "❌ Native HTTP POST başarısız: $responseCode")
				}
				connection.disconnect()
			} catch (e: Exception) {
				android.util.Log.e("DepremApp", "❌ Native HTTP POST hatası: ${e.message}")
			}
		}.start()
	}

	// Düdük çalmaya başla - enkaz altı için yardım çağrısı
	private fun startWhistle() {
		if (isWhistlePlaying) return
		
		try {
			// ToneGenerator oluştur - maksimum ses
			toneGenerator = android.media.ToneGenerator(
				android.media.AudioManager.STREAM_ALARM,
				android.media.ToneGenerator.MAX_VOLUME
			)
			
			isWhistlePlaying = true
			
			// Timer ile periyodik olarak yüksek frekanslı ses çal
			whistleTimer = java.util.Timer()
			whistleTimer?.scheduleAtFixedRate(object : java.util.TimerTask() {
				override fun run() {
					if (isWhistlePlaying) {
						try {
							// DTMF_A tonu - yüksek frekanslı, dikkat çekici ses
							toneGenerator?.startTone(android.media.ToneGenerator.TONE_DTMF_A, 200)
						} catch (e: Exception) {
							android.util.Log.e("DepremApp", "Whistle tone error: ${e.message}")
						}
					}
				}
			}, 0, 300) // Her 300ms'de bir 200ms'lik ses çal
			
			android.util.Log.d("DepremApp", "🚨 Düdük sesi başlatıldı!")
		} catch (e: Exception) {
			android.util.Log.e("DepremApp", "Whistle start error: ${e.message}")
		}
	}

	// Düdük çalmayı durdur
	private fun stopWhistle() {
		isWhistlePlaying = false
		
		try {
			whistleTimer?.cancel()
			whistleTimer = null
			
			toneGenerator?.stopTone()
			toneGenerator?.release()
			toneGenerator = null
			
			android.util.Log.d("DepremApp", "🛑 Düdük sesi durduruldu!")
		} catch (e: Exception) {
			android.util.Log.e("DepremApp", "Whistle stop error: ${e.message}")
		}
	}
}
