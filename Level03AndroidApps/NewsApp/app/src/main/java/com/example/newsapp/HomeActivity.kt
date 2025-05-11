package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newsapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private var category = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.techBtn.setOnClickListener {
            category = "technology"
            openNewsPage()
        }
        binding.sportsBtn.setOnClickListener {
            category = "sports"
            openNewsPage()
        }
        binding.scienceBtn.setOnClickListener {
            category = "science"
            openNewsPage()
        }
        binding.toolBar.setOnMenuItemClickListener {
            if (it.itemId == R.id.settings_item){
                startActivity(Intent(this,SettingsActivity::class.java))
                true
            } else
                false

        }
    }

    private fun openNewsPage() {
        val i = Intent(this, MainActivity::class.java)
        i.putExtra("cat", category)
        startActivity(i)
    }
}