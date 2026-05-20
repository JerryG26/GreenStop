package com.example.gamstop.frontend.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamstop.databinding.ActivityGpsBinding

class GpsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGpsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGpsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}