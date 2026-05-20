// AFTER (Correct)
package com.example.gamstop

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

// We change AppCompatActivity to Fragment, and point it to your calendar layout file
class RewardFragment : Fragment(R.layout.fragment_reward_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}