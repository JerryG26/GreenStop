package com.example.gamstop.frontend.smart_recommendations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamstop.databinding.ItemFoodCardBinding // Adjust to your package

class FoodRecommendationAdapter(private var foodList: List<FoodItem>) :
    RecyclerView.Adapter<FoodRecommendationAdapter.FoodViewHolder>() {

    // ViewBinding makes this incredibly safe and easy
    class FoodViewHolder(val binding: ItemFoodCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.binding.foodNameText.text = food.name
        holder.binding.proteinText.text = "Protein: ${food.protein}g"
        holder.binding.caloriesText.text = "${food.calories} kcal"
    }

    override fun getItemCount(): Int = foodList.size

    // Function to update the list later
    fun updateData(newList: List<FoodItem>) {
        foodList = newList
        notifyDataSetChanged()
    }
}