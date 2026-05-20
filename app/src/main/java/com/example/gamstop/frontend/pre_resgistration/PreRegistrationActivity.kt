package com.example.gamstop.frontend.pre_resgistration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamstop.R
import com.example.gamstop.databinding.ActivityPreRegistrationBinding
import com.example.gamstop.main_activity_container

class PreRegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreRegistrationBinding
    private var selectedGoal: String = "Muscle"
    private var calorieTarget: Int = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPreRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioMuscleGain.isChecked = true

        binding.btnSave.setOnClickListener {
            val selectedId = binding.goalRadioGroup.checkedRadioButtonId

            when (selectedId) {
                R.id.radioWeightLoss -> {
                    selectedGoal = "Thin"
                    calorieTarget = 1000
                }
                R.id.radioMuscleGain -> {
                    selectedGoal = "Muscle"
                    calorieTarget = 2500
                }
                R.id.radioMaintenance -> {
                    selectedGoal = "Lean"
                    calorieTarget = 1500
                }
                else -> {
                    selectedGoal = "Muscle"
                    calorieTarget = 2500
                }
            }

            val sharedPreferences = getSharedPreferences("GreenStopPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putString("USER_GOAL", selectedGoal)
            editor.putInt("DAILY_CALORIE_GOAL", calorieTarget)
            editor.apply()

            val intent = Intent(this, main_activity_container::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}