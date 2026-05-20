
package com.example.gamstop // Make sure this matches your actual package path!
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// 1. THE DATA MODEL
data class Restaurant(val name: String, val details: String)

// 2. THE MAIN FRAGMENT CLASS (Matches your file name)
class RestaurantFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // This inflates your fragment_restaurant_list.xml layout
        val view = inflater.inflate(R.layout.activity_restaurant_page, container, false)

        val restaurantList = listOf(
            Restaurant("Thai Restaurant", "Thai • 4.8 ★")
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRestaurants)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RestaurantAdapter(restaurantList)

        return view
    }
}

// 3. THE ADAPTER
class RestaurantAdapter(private val dataset: List<Restaurant>) :
    RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.textRestaurantName)
        val detailsTextView: TextView = view.findViewById(R.id.textRestaurantDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = dataset[position]
        holder.nameTextView.text = item.name
        holder.detailsTextView.text = item.details
    }

    override fun getItemCount() = dataset.size
}