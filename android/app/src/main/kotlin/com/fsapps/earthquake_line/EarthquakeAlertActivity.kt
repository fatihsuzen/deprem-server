
package com.fsapps.earthquake_line

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class EarthquakeAlertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Parametreleri al
        val magnitude = intent.getDoubleExtra("magnitude", 0.0)
        val location = intent.getStringExtra("location") ?: ""
        val distance = intent.getDoubleExtra("distance", 0.0)
        // MainActivity'yi parametreyle başlat
        val mainIntent = Intent(this, MainActivity::class.java)
        mainIntent.putExtra("magnitude", magnitude)
        mainIntent.putExtra("location", location)
        mainIntent.putExtra("distance", distance)
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(mainIntent)
        // Bu activity'yi kapat
        finish()
    }
}
