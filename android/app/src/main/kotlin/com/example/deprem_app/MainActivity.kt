package com.example.deprem_app
import java.io.File
import org.json.JSONObject

import android.os.PowerManager
import android.content.Context
import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
			override fun onResume() {
				super.onResume()
				android.util.Log.d("DepremApp", "onResume called!")
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
		override fun onCreate(savedInstanceState: android.os.Bundle?) {
			super.onCreate(savedInstanceState)
			android.util.Log.d("DepremApp", "onCreate called!")
			val params = getEarthquakeParamsFromIntent(intent)
			android.util.Log.d("DepremApp", "onCreate: params = $params")
			sendEarthquakeParamsToFlutter(params)
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

	override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
		super.configureFlutterEngine(flutterEngine)
		android.util.Log.d("DepremApp", "configureFlutterEngine called!")

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
}
