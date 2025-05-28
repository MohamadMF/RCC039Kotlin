package com.example.sildesmission

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.sildesmission.databinding.ActivityButtonsBinding

class ButtonsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityButtonsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityButtonsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.page1.setOnClickListener {
            showFragment(Page1Fragment())
        }
        binding.page2.setOnClickListener {
            showFragment(Page2Fragment())
        }
        binding.page3.setOnClickListener {
            showFragment(Page3Fragment())
        }
        binding.page4.setOnClickListener {
            showFragment(Page4Fragment())
        }
    }
    private fun showFragment(f: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container_view_tag,f)
        transaction.commit()
    }
}