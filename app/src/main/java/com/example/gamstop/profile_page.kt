package com.example.gamstop.frontend

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamstop.databinding.FragmentProfileBinding
import com.example.gamstop.login_page

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        populateUserData(
            firstName = "John",
            lastName = "Doe",
            email = "john.doe@example.com",
            targetGoal = "Build Muscle",
            dietPreference = "High Protein"
        )

        binding.logoutButton.setOnClickListener {
            handleLogout()
        }
    }

    private fun populateUserData(
        firstName: String,
        lastName: String,
        email: String,
        targetGoal: String,
        dietPreference: String
    ) {
        binding.nameText.text = "$firstName $lastName"
        binding.emailText.text = email
        binding.targetGoalText.text = "Target Goal: $targetGoal"
        binding.dietPreferenceText.text = "Diet: $dietPreference"
    }

    private fun handleLogout() {
        val intent = Intent(requireContext(), login_page::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
