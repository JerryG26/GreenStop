package com.example.gamstop

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.gamstop.databinding.FragmentHomeBinding
import com.example.gamstop.frontend.smart_recommendations.SmartRecommendationsActivity
import com.example.gamstop.frontend.calorie_stats.DailyCalStatsActivity
import com.example.gamstop.frontend.navigation.GpsActivity

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        setupNavigationButtons()
    }

    private fun setupNavigationButtons() {
        binding.btnRecommendations.setOnClickListener {
            startActivity(Intent(requireContext(), SmartRecommendationsActivity::class.java))
        }

        binding.btnCalorieStats.setOnClickListener {
            startActivity(Intent(requireContext(), com.example.gamstop.frontend.calorie_stats.DailyCalStatsActivity::class.java))
        }

        binding.btnGpsNavigation.setOnClickListener {
            startActivity(Intent(requireContext(), GpsActivity::class.java))
        }

        binding.btnRewards.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RewardFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}