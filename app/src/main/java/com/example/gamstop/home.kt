package com.example.gamstop

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.gamstop.databinding.FragmentHomeBinding
import com.example.gamstop.frontend.pre_resgistration.PreRegistrationActivity
import com.example.gamstop.frontend.smart_recommendations.SmartRecommendationsActivity
import com.example.gamstop.frontend.calorie_stats.DailyCalStatsActivity
import com.example.gamstop.frontend.navigation.GpsActivity

// Pass your layout layout file (R.layout.fragment_home) into the Fragment constructor
class HomeFragment : Fragment(R.layout.fragment_home) {

    // View Binding property for the fragment
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bind the layout view
        _binding = FragmentHomeBinding.bind(view)

        // Set up your button listeners
        setupNavigationButtons()
    }

    private fun setupNavigationButtons() {
        // We use requireContext() since 'this' cannot be used for Context inside a Fragment
        binding.btnPreRegistration.setOnClickListener {
            startActivity(Intent(requireContext(), PreRegistrationActivity::class.java))
        }

        binding.btnRecommendations.setOnClickListener {
            startActivity(Intent(requireContext(), SmartRecommendationsActivity::class.java))
        }

        binding.btnCalorieStats.setOnClickListener {
            startActivity(Intent(requireContext(), DailyCalStatsActivity::class.java))
        }

        binding.btnGpsNavigation.setOnClickListener {
            startActivity(Intent(requireContext(), GpsActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear binding to prevent memory leaks
        _binding = null
    }
}