package com.example.gamstop.frontend.pre_resgistration

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamstop.R
import com.example.gamstop.databinding.ActivityPreRegistrationBinding

class PreRegistrationActivity : AppCompatActivity(), PreRegistrationContract.View {

    private lateinit var binding: ActivityPreRegistrationBinding
    private lateinit var presenter: PreRegistrationContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPreRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = PreRegistrationPresenter(this)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnSubmit.setOnClickListener {
            val selectedBodyType = when (binding.toggleGroupBodyType.checkedButtonId) {
                R.id.btnThin -> "THIN"
                R.id.btnMuscle -> "MUSCLE"
                else -> "LEAN"
            }

            presenter.submitUserData(
                bodyType = selectedBodyType,
                heightStr = binding.etHeight.text.toString(),
                weightStr = binding.etWeight.text.toString(),
                ageStr = binding.etAge.text.toString()
            )
        }
    }

    override fun showLoading() {
        binding.btnSubmit.isEnabled = false
    }

    override fun hideLoading() {
        binding.btnSubmit.isEnabled = true
    }

    override fun showValidationError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToNextScreen() {
        Toast.makeText(this, "Registration Complete!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}