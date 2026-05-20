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

class Restaurant(val name: String, val details: String)

class RestaurantFragment : Fragment() {

    companion object {
        var currentRestaurantName: String = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_restaurant_page, container, false)

        val restaurantList = ArrayList<Restaurant>()
        restaurantList.add(Restaurant("Thai Foodies", "Thai • 4.8 ★"))
        restaurantList.add(Restaurant("Filipino Kusina", "Filipino • 5.0 ★"))

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRestaurants)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val myAdapter = RestaurantAdapter(restaurantList, this)
        recyclerView.adapter = myAdapter

        return view
    }

    fun onRestaurantClicked(clickedRestaurant: Restaurant) {
        currentRestaurantName = clickedRestaurant.name

        val manager = parentFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, FoodShowcaseFragment())
        transaction.addToBackStack(null)
        transaction.commit()

        val mainAct = activity as? main_activity_container
        if (mainAct != null) {
            val tvTitle = mainAct.findViewById<TextView>(R.id.tv_title)
            val btnBack = mainAct.findViewById<TextView>(R.id.btn_back)
            tvTitle.text = clickedRestaurant.name
            btnBack.text = "←"
        }
    }
}

class RestaurantAdapter(
    private val dataset: List<Restaurant>,
    private val fragmentRef: RestaurantFragment
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView = view.findViewById<CardView>(R.id.cardRestaurant)
        val nameTextView = view.findViewById<TextView>(R.id.textRestaurantName)
        val detailsTextView = view.findViewById<TextView>(R.id.textRestaurantDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = dataset[position]

        holder.nameTextView.text = currentItem.name
        holder.detailsTextView.text = currentItem.details

        holder.cardView.setOnClickListener {
            fragmentRef.onRestaurantClicked(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}