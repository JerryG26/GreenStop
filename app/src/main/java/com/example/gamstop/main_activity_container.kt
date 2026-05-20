package com.example.gamstop
import android.widget.ImageView
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gamstop.frontend.ProfileFragment
import com.example.gamstop.frontend.navigation.calendar_calorie_tracker

class main_activity_container : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_container)
        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvBack = findViewById<TextView>(R.id.btn_back)
        val btnNavbar = findViewById<LinearLayout>(R.id.navbar)
        val btnCalendar = btnNavbar.findViewById<ImageView>(R.id.btn_calendar_container)
        val btnReward = btnNavbar.findViewById<ImageView>(R.id.btn_rewards_container)
        val btnHome = btnNavbar.findViewById<ImageView>(R.id.btn_home_container)
        val btnProfile = btnNavbar.findViewById<ImageView>(R.id.btn_profile_container)
        val btnRestaurant = btnNavbar.findViewById<ImageView>(R.id.btn_restaurants_container)

        // Set default screen on app launch
        if (savedInstanceState == null) {
            tvTitle.text = "Home"
            tvBack.text = ""
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        // Listen for navigation clicks
        btnCalendar.setOnClickListener {
            tvTitle.text = "Calorie Tracking Calendar"
            tvBack.text = ""
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, calendar_calorie_tracker())
                .commit()
        }

        btnReward.setOnClickListener {
            tvTitle.text = "My Rewards"
            tvBack.text = ""
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RewardFragment())
                .commit()
        }

        btnHome.setOnClickListener {
            tvTitle.text = "Home"
            tvBack.text = ""
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }
        btnRestaurant.setOnClickListener {
            tvTitle.text = "Restaurant"
            tvBack.text = ""
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RestaurantFragment())
                .commit()
        }
        btnProfile.setOnClickListener {
            tvTitle.text = "Profile"
            tvBack.text = ""
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment())
                .commit()
        }
        tvBack.setOnClickListener {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()

                  if (supportFragmentManager.backStackEntryCount == 1) {
                    tvTitle.text = "Restaurant"
                    tvBack.text = ""
                }
            }
        }

    }
}