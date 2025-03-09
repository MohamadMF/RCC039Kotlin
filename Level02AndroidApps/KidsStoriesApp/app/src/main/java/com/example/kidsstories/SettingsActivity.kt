package com.example.kidsstories

import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val group: RadioGroup = findViewById(R.id.sizes_group)
        group.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.med_view -> changeSize(20)
                R.id.large_view -> changeSize(28)
            }
        }
    }
    fun changeSize(sizeAfter: Int) {
        val pref = getSharedPreferences("settings", MODE_PRIVATE).edit()
        pref.putInt("size",sizeAfter)
        pref.apply()
        // Always make feedback to your user
        Toast.makeText(this, "Text Changed", Toast.LENGTH_SHORT).show()
    }
}