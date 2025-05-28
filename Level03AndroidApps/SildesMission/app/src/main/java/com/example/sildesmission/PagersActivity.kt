package com.example.sildesmission

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sildesmission.databinding.ActivityPagersBinding
import com.google.android.material.tabs.TabLayoutMediator

class PagersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPagersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPagersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = PagerAdapter(this)
        binding.viewPager.adapter = adapter

        val tabNames = arrayOf("Page1","Page2","Page3","Page4")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.setText(tabNames[position])
        }.attach()

    }
}