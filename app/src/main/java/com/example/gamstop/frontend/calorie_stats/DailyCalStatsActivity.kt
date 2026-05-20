package com.example.gamstop.frontend.calorie_stats

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamstop.databinding.ActivityDailyCalStatsBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DailyCalStatsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDailyCalStatsBinding
    private lateinit var adapter: CalorieRecordAdapter

    private var dailyCalorieGoal = 2000
    private val mockRecords = mutableListOf<CalorieEntity>()

    private val addMealLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val foodName = data?.getStringExtra("FOOD_NAME") ?: "Unknown Meal"
            val calories = data?.getIntExtra("CALORIES", 0) ?: 0

            val currentTotal = mockRecords.sumOf { it.calories }

            if (currentTotal + calories > dailyCalorieGoal) {
                val remaining = dailyCalorieGoal - currentTotal
                Toast.makeText(
                    this,
                    "Cannot log $foodName ($calories kcal). You only have $remaining kcal left!",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val currentTime = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
                val newMeal = CalorieEntity(
                    time = currentTime,
                    foodName = foodName,
                    calories = calories
                )
                mockRecords.add(newMeal)
                updateUI()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyCalStatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("GreenStopPrefs", Context.MODE_PRIVATE)
        dailyCalorieGoal = sharedPreferences.getInt("DAILY_CALORIE_GOAL", 2000)

        setupRecyclerView()
        loadInitialFakeData()

        binding.addButton.setOnClickListener {
            val intent = Intent(this, AddMealActivity::class.java)
            addMealLauncher.launch(intent)
        }
    }

    private fun setupRecyclerView() {
        binding.recordsRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CalorieRecordAdapter(emptyList()) { recordToDelete ->
            mockRecords.remove(recordToDelete)
            updateUI()
        }

        binding.recordsRecyclerView.adapter = adapter
    }

    private fun loadInitialFakeData() {
        if (mockRecords.isEmpty()) {
            mockRecords.add(CalorieEntity(time = "08:30 AM", foodName = "Oatmeal & Fruits", calories = 350))
            mockRecords.add(CalorieEntity(time = "12:15 PM", foodName = "Grilled Chicken Salad", calories = 450))
        }
        updateUI()
    }

    private fun updateUI() {
        adapter.updateData(mockRecords.toList())

        val totalCalories = mockRecords.sumOf { it.calories }

        binding.calorieProgressBar.max = dailyCalorieGoal
        binding.calorieProgressBar.progress = totalCalories
        binding.calorieProgressText.text = "$totalCalories / $dailyCalorieGoal kcal"
    }
}