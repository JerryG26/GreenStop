package com.example.gamstop.frontend.pre_resgistration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamstop.MainActivity
import com.example.gamstop.R
import com.example.gamstop.databinding.ActivityPreRegistrationBinding

class PreRegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreRegistrationBinding
    private var selectedGoal: String = "Muscle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPreRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set Muscle as default if needed
        binding.radioMuscleGain.isChecked = true

        binding.btnSave.setOnClickListener {
            val selectedId = binding.goalRadioGroup.checkedRadioButtonId
            selectedGoal = when (selectedId) {
                R.id.radioWeightLoss -> "Thin"
                R.id.radioMuscleGain -> "Muscle"
                R.id.radioMaintenance -> "Lean"
                else -> "Muscle"
            }

            val sharedPreferences = getSharedPreferences("GreenStopPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putString("USER_GOAL", selectedGoal)
            editor.apply()

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}