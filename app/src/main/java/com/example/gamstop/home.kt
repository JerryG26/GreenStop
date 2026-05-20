package com.example.gamstop

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

// We inherit from Fragment and pass your home layout file directly into the constructor
class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // This is where your home logic goes!
        // If you need to find buttons or text views inside activity_home.xml, use 'view.findViewById'
        // Example:
        // val btnClickMe = view.findViewById<Button>(R.id.btn_click_me)
    }
}