package com.example.gamstop

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class RestaurantFragment : Fragment(R.layout.activity_restaurant_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardRestaurant2 = view.findViewById<CardView>(R.id.cardRestaurant2)

        cardRestaurant2.setOnClickListener {

            parentFragmentManager.beginTransaction()

                .replace(R.id.fragment_container, FoodShowcaseFragment())

                .addToBackStack(null)

                .commit()
        }
    }
}