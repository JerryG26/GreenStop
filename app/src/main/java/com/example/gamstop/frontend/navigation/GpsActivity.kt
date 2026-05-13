package com.example.gamstop.frontend.navigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamstop.databinding.ActivityGpsBinding

class GpsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGpsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGpsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantName = "SaladStop!"
        val destinationAddress = "Ayala Center Cebu"

        binding.locationName.text = restaurantName
        binding.locationStatus.text = "Open Now"
        binding.locationDistance.text = "Distance: 2.5km"

        binding.navigationButton.setOnClickListener {
            launchGoogleMaps(destinationAddress)
        }
    }

    private fun launchGoogleMaps(address: String) {
        val gmmIntentUri = Uri.parse("geo:0,0?q=${Uri.encode(address)}")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

        mapIntent.setPackage("com.google.android.apps.maps")

        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        } else {
            Toast.makeText(this, "Google Maps is not installed", Toast.LENGTH_SHORT).show()
        }
    }
}