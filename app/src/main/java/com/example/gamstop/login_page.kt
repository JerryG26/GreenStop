package com.example.gamstop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.net.Uri

class login_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val registerLink = findViewById<TextView>(R.id.registerLink)
        val submitButton = findViewById<Button>(R.id.submit)

        registerLink.setOnClickListener {
            val intent = Intent(this, registration::class.java)
            startActivity(intent)
        }

        submitButton.setOnClickListener {
            val intent = Intent(this, main_activity_container::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
    fun openFacebookLink(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"))
        startActivity(intent)
    }

    fun openGoogleLink(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        startActivity(intent)
    }

    fun openPhoneLink(view: View) {
        // This opens a webpage, but you can also use "tel:123456789" to open the dialer!
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        startActivity(intent)
    }
}