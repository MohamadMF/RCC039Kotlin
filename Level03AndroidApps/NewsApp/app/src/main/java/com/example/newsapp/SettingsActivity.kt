package com.example.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newsapp.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.radioContainer.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.us_rb -> changeCountry("us")
                R.id.sa_rb -> changeCountry("sa")
            }
        }
    }

    private fun changeCountry(code: String) {
        val prefs = getSharedPreferences("settings", MODE_PRIVATE).edit()
        prefs.putString("code", code)
        prefs.apply()
        Toast.makeText(this, "Changed!", Toast.LENGTH_SHORT).show()
    }
}