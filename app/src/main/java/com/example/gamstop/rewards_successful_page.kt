package com.example.gamstop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class TransactionSuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rewards_successful_page, container, false)

        val btnBack = view.findViewById<Button>(R.id.btnSuccessBack)

        btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}