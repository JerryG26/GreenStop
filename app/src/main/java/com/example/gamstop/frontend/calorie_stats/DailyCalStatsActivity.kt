package com.example.gamstop.frontend.calorie_stats

import android.content.Context
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyCalStatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("GreenStopPrefs", Context.MODE_PRIVATE)
        dailyCalorieGoal = sharedPreferences.getInt("DAILY_CALORIE_GOAL", 2000)

        setupRecyclerView()
        loadInitialFakeData()

        binding.addButton.setOnClickListener {
            insertNewMeal()
        }
    }

    private fun setupRecyclerView() {
        binding.recordsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CalorieRecordAdapter(emptyList()) { record ->
            deleteMeal(record)
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

    private fun insertNewMeal() {
        val currentTime = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
        val newMeal = CalorieEntity(
            time = currentTime,
            foodName = "Healthy Snack",
            calories = 250
        )
        mockRecords.add(newMeal)
        updateUI()
    }

    private fun deleteMeal(record: CalorieEntity) {
        mockRecords.remove(record)
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