package com.example.gamstop.frontend.calorie_stats

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamstop.databinding.ActivityDailyCalStatsBinding

class DailyCalStatsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDailyCalStatsBinding
    private lateinit var adapter: CalorieRecordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyCalStatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadDummyData()
    }

    private fun setupRecyclerView() {
        binding.recordsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CalorieRecordAdapter(emptyList())
        binding.recordsRecyclerView.adapter = adapter
    }

    private fun loadDummyData() {
        val dummyRecords = listOf(
            CalorieRecord("08:00 AM", "Oatmeal & Berries", 350),
            CalorieRecord("12:30 PM", "Grilled Chicken Salad", 420),
            CalorieRecord("03:15 PM", "Protein Shake", 150),
            CalorieRecord("07:00 PM", "Steak & Sweet Potato", 600)
        )
        adapter.updateData(dummyRecords)
    }
}