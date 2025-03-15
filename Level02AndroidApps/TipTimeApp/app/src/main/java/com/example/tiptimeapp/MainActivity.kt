package com.example.tiptimeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tiptimeapp.databinding.ActivityMainBinding
import kotlin.math.round
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private var totalCost = 0.0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // we wrote it in this line because when it be null, it will skip it. On landscape will keep it
        totalCost = savedInstanceState?.getDouble("total") ?: 0.0
        binding.resultView.text = totalCost.toString()

        binding.calculateBtn.setOnClickListener {
            val cost = binding.costField.text.toString().toDouble()
            val checkedBtn = binding.tipsGroup.checkedRadioButtonId
            val tip = when (checkedBtn) {
                R.id.amazing_click -> 0.2
                R.id.good_click -> 0.18
                else -> 0.15
            }
            totalCost = cost + (cost * tip)

            if (binding.roundTipSwitch.isChecked)
                totalCost = round(totalCost)

            binding.resultView.text = "$${"%.2f".format(totalCost)}"
        }



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("total", totalCost)
    }
}