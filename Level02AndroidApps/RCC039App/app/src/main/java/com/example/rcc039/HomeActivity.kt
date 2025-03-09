package com.example.rcc039

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val webBtn: Button = findViewById(R.id.website_btn)
        val userData: TextView = findViewById(R.id.username_data)

        webBtn.setOnClickListener {
            val website = "https://www.android.com".toUri() //Uniform Resource Identifier
            startActivity(Intent(Intent.ACTION_VIEW,website)) //Implicit Intent
        }

        val receivedUser = intent.getStringExtra("username")
        userData.text = "Hi! $receivedUser"
    }
}