package com.example.gamstop.frontend.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamstop.databinding.FragmentCalendarCalorieTrackerBinding

class calendar_calorie_tracker : Fragment() {

    private var _binding: FragmentCalendarCalorieTrackerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarCalorieTrackerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Hardcode a static value for the presentation (e.g., they ate 420 calories so far)
        val dailyGoal = 2000
        val consumed = 420

        binding.staticProgressBar.max = dailyGoal
        binding.staticProgressBar.progress = consumed
        binding.staticCalorieText.text = "Total Consumed: $consumed / $dailyGoal kcal"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}