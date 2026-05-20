package com.example.gamstop.frontend.calorie_stats

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.gamstop.databinding.ActivityAddMealBinding

class AddMealActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddMealBinding

    private val foodDatabase = mapOf(
        "Chicken Adobo" to 420,
        "Sinigang na Baboy" to 310,
        "Halo-Halo" to 280,
        "Pad Thai" to 350,
        "Tom Yum Soup" to 220,
        "Mango Sticky Rice" to 300,
        "Roast Beef PitaCrunch" to 850,
        "Minced Beef Wrap" to 620,
        "Double Steak Bowl" to 750,
        "Grilled Chicken Salad" to 350,
        "Roast Beef Salad" to 400,
        "Tuna Lettuce Wrap" to 300,
        "Greek Yogurt Bowl" to 200,
        "Cucumber Salad" to 150,
        "Clear Broth Soup" to 100
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodList = foodDatabase.keys.toList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, foodList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.foodSpinner.adapter = adapter

        binding.btnSaveMeal.setOnClickListener {
            val selectedFood = binding.foodSpinner.selectedItem.toString()
            val calculatedCalories = foodDatabase[selectedFood] ?: 0

            val resultIntent = Intent()
            resultIntent.putExtra("FOOD_NAME", selectedFood)
            resultIntent.putExtra("CALORIES", calculatedCalories)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}