package com.example.gamstop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamstop.databinding.ActivityMainBinding
import com.example.gamstop.frontend.pre_resgistration.PreRegistrationActivity
import com.example.gamstop.frontend.smart_recommendations.SmartRecommendationsActivity
import com.example.gamstop.frontend.calorie_stats.DailyCalStatsActivity
import com.example.gamstop.frontend.navigation.GpsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationButtons()
    }

    private fun setupNavigationButtons() {
        binding.btnPreRegistration.setOnClickListener {
            startActivity(Intent(this, PreRegistrationActivity::class.java))
        }

        binding.btnRecommendations.setOnClickListener {
            startActivity(Intent(this, SmartRecommendationsActivity::class.java))
        }

        binding.btnCalorieStats.setOnClickListener {
            startActivity(Intent(this, DailyCalStatsActivity::class.java))
        }

        binding.btnGpsNavigation.setOnClickListener {
            startActivity(Intent(this, GpsActivity::class.java))
        }
    }
}