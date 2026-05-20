package com.example.gamstop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodItem(
    val name: String,
    val description: String,
    val calories: String,
    val protein: String,
    val carbs: String,
    val fat: String
)

class FoodShowcaseFragment : Fragment() {

    companion object {
        var selectedFoodName: String = ""
        var selectedFoodDesc: String = ""
        var selectedFoodCal: String = ""
        var selectedFoodProtein: String = ""
        var selectedFoodCarbs: String = ""
        var selectedFoodFat: String = ""

        var selectedFoodImage: Int = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_foods_showcase, container, false)

        val selectedRestaurant = RestaurantFragment.currentRestaurantName
        val foodList = ArrayList<FoodItem>()

        if (selectedRestaurant == "Thai Foodies") {
            foodList.add(FoodItem("Pad Thai", "Stir-fried noodles with shrimp and peanuts", "350", "18g", "55g", "10g"))
            foodList.add(FoodItem("Tom Yum Soup", "Spicy and sour soup with mushrooms", "220", "14g", "20g", "6g"))
            foodList.add(FoodItem("Mango Sticky Rice", "Sweet rice served with fresh mango", "300", "4g", "60g", "7g"))
        } else if (selectedRestaurant == "Filipino Kusina") {
            foodList.add(FoodItem("Chicken Adobo", "Chicken marinated in soy sauce, vinegar, and garlic", "420", "28g", "15g", "18g"))
            foodList.add(FoodItem("Sinigang na Baboy", "Sour pork soup cooked with tamarind and veggies", "310", "19g", "12g", "15g"))
            foodList.add(FoodItem("Halo-Halo", "Crushed ice dessert with mixed fruits and ube", "280", "5g", "50g", "4g"))
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewFoods)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val myAdapter = FoodAdapter(foodList, this)
        recyclerView.adapter = myAdapter

        return view
    }

    fun onFoodItemClicked(clickedFood: FoodItem) {
        selectedFoodName = clickedFood.name
        selectedFoodDesc = clickedFood.description
        selectedFoodCal = clickedFood.calories
        selectedFoodProtein = clickedFood.protein
        selectedFoodCarbs = clickedFood.carbs
        selectedFoodFat = clickedFood.fat

        val manager = parentFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, FoodDetailFragment())
        transaction.addToBackStack(null)
        transaction.commit()

        val mainAct = activity as? main_activity_container
        if (mainAct != null) {
            val tvTitle = mainAct.findViewById<TextView>(R.id.tv_title)
            tvTitle.text = clickedFood.name
        }
    }
}

class FoodAdapter(
    private val dataset: List<FoodItem>,
    private val fragmentRef: FoodShowcaseFragment
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView = view.findViewById<CardView>(R.id.foodCardContainer)
        val nameText = view.findViewById<TextView>(R.id.foodName)
        val descriptionText = view.findViewById<TextView>(R.id.foodDescription)
        val caloriesText = view.findViewById<TextView>(R.id.foodCalories)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_card, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentFood = dataset[position]

        holder.nameText.text = currentFood.name
        holder.descriptionText.text = currentFood.description
        holder.caloriesText.text = currentFood.calories + " kcal"

        holder.cardView.setOnClickListener {
            fragmentRef.onFoodItemClicked(currentFood)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}