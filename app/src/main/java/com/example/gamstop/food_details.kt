package com.example.gamstop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FoodDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_food_details, container, false)

        val tvFoodName = view.findViewById<TextView>(R.id.foodTitle)
        val tvFoodDesc = view.findViewById<TextView>(R.id.foodDescription)
        val tvCalorieCount = view.findViewById<TextView>(R.id.txtCalorieCount)
        val tvProteinCount = view.findViewById<TextView>(R.id.txtProteinCount)
        val tvCarbsCount = view.findViewById<TextView>(R.id.txtCarbsCount)
        val tvFatCount = view.findViewById<TextView>(R.id.txtFatCount)
        val imgFood = view.findViewById<ImageView>(R.id.foodImage)

        val foodNameData = FoodShowcaseFragment.selectedFoodName

        tvFoodName.text = foodNameData
        tvFoodDesc.text = FoodShowcaseFragment.selectedFoodDesc
        tvCalorieCount.text = FoodShowcaseFragment.selectedFoodCal
        tvProteinCount.text = FoodShowcaseFragment.selectedFoodProtein
        tvCarbsCount.text = FoodShowcaseFragment.selectedFoodCarbs
        tvFatCount.text = FoodShowcaseFragment.selectedFoodFat

        if (foodNameData == "Pad Thai") {
            imgFood.setImageResource(R.drawable.padthai)
        } else if (foodNameData == "Tom Yum Soup") {
            imgFood.setImageResource(R.drawable.tomyum)
        } else if (foodNameData == "Mango Sticky Rice") {
            imgFood.setImageResource(R.drawable.stickyrice)
        } else if (foodNameData == "Chicken Adobo") {
            imgFood.setImageResource(R.drawable.chickenadobo)
        } else if (foodNameData == "Sinigang na Baboy") {
            imgFood.setImageResource(R.drawable.sinigang)
        } else if (foodNameData == "Halo-Halo") {
            imgFood.setImageResource(R.drawable.halohalo)
        }



        return view
    }
}