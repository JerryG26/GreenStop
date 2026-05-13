package com.example.gamstop.frontend.calorie_stats

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamstop.databinding.ActivityDailyCalStatsBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DailyCalStatsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDailyCalStatsBinding
    private lateinit var adapter: CalorieRecordAdapter
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyCalStatsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = AppDatabase.getDatabase(this)
        setupRecyclerView()
        loadDatabaseRecords()
        binding.addButton.setOnClickListener {
            insertNewMeal()
        }
    }

    private fun setupRecyclerView() {
        binding.recordsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CalorieRecordAdapter(emptyList())
        binding.recordsRecyclerView.adapter = adapter
    }

    private fun loadDatabaseRecords() {
        lifecycleScope.launch {
            val records = database.calorieDao().getAllRecords()
            adapter.updateData(records)
        }
    }
    private fun insertNewMeal() {
        val currentTime = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
        val newMeal = CalorieEntity(
            time = currentTime,
            foodName = "Healthy Snack",
            calories = 250
        )
        lifecycleScope.launch {
            database.calorieDao().insertRecord(newMeal)
            loadDatabaseRecords()
        }
    }
}