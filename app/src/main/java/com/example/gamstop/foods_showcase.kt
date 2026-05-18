package com.example.gamstop

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class FoodShowcaseFragment : Fragment(R.layout.activity_foods_showcase) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardFood1 = view.findViewById<CardView>(R.id.foodItem1)

        cardFood1.setOnClickListener {

            parentFragmentManager.beginTransaction()

                 .replace(R.id.fragment_container, FoodDetailFragment())

                 .addToBackStack(null)

                .commit()
        }
    }
}