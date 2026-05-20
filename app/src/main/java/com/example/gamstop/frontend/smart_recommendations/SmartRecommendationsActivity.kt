package com.example.gamstop.frontend.smart_recommendations

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamstop.databinding.ActivitySmartRecommendationsBinding

class SmartRecommendationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySmartRecommendationsBinding
    private lateinit var recommendationAdapter: FoodRecommendationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySmartRecommendationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadRecommendations()
    }

    private fun setupRecyclerView() {
        // Changed to default vertical orientation
        binding.recommendationsRecyclerView.layoutManager = LinearLayoutManager(this)

        recommendationAdapter = FoodRecommendationAdapter(emptyList())
        binding.recommendationsRecyclerView.adapter = recommendationAdapter
    }

    private fun loadRecommendations() {
        val sharedPreferences = getSharedPreferences("GreenStopPrefs", Context.MODE_PRIVATE)
        val userGoal = sharedPreferences.getString("USER_GOAL", "Muscle")

        val recommendedMenu = when (userGoal) {
            "Muscle" -> listOf(
                FoodItem("Roast Beef PitaCrunch", 850, 55, "High Protein"),
                FoodItem("Minced Beef Wrap", 620, 42, "High Protein"),
                FoodItem("Double Steak Bowl", 750, 50, "High Protein")
            )
            "Lean" -> listOf(
                FoodItem("Grilled Chicken Salad", 350, 35, "Lean"),
                FoodItem("Roast Beef Salad", 400, 38, "Lean"),
                FoodItem("Tuna Lettuce Wrap", 300, 28, "Lean")
            )
            "Thin" -> listOf(
                FoodItem("Greek Yogurt Bowl", 200, 15, "Low Calorie"),
                FoodItem("Cucumber Salad", 150, 5, "Low Calorie"),
                FoodItem("Clear Broth Soup", 100, 8, "Low Calorie")
            )
            else -> emptyList()
        }

        recommendationAdapter.updateData(recommendedMenu)
    }
}