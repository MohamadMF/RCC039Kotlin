package com.example.dicerollapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dicePic: ImageView = findViewById(R.id.dice_pic)
        val dicePicOpps: ImageView = findViewById(R.id.dice_pic_opps)
        val diceBtn: Button = findViewById(R.id.dice_btn)

        diceBtn.setOnClickListener {
            val random = (1..6).random()
            when(random){
                1 -> {
                    dicePic.setImageResource(R.drawable.dice_1)
                    dicePicOpps.setImageResource(R.drawable.dice_6)
                }
                2 -> {
                    dicePic.setImageResource(R.drawable.dice_2)
                    dicePicOpps.setImageResource(R.drawable.dice_5)
                }
                3 -> {
                    dicePic.setImageResource(R.drawable.dice_3)
                    dicePicOpps.setImageResource(R.drawable.dice_4)
                }
                4 -> {
                    dicePic.setImageResource(R.drawable.dice_4)
                    dicePicOpps.setImageResource(R.drawable.dice_3)
                }
                5 -> {
                    dicePic.setImageResource(R.drawable.dice_5)
                    dicePicOpps.setImageResource(R.drawable.dice_2)
                }
                6 -> {
                    dicePic.setImageResource(R.drawable.dice_6)
                    dicePicOpps.setImageResource(R.drawable.dice_1)
                }
            }
            Toast.makeText(this, "Rolled! x2", Toast.LENGTH_SHORT).show()
        }
    }
}

/*
            val randRes = when (random) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            dicePic.setImageResource(randRes)
            dicePicOpps.setImageResource(randRes)
 */