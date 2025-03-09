package com.example.recwithcardview

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView


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

        val animals = mutableListOf<Animal>()
        animals.add(Animal(R.drawable.bird,R.string.bird))
        animals.add(Animal(R.drawable.camel,R.string.camel))
        animals.add(Animal(R.drawable.cat,R.string.cat))
        animals.add(Animal(R.drawable.dog,R.string.dog))
        animals.add(Animal(R.drawable.elephant,R.string.elephant))
        animals.add(Animal(R.drawable.fish,R.string.fish))
        animals.add(Animal(R.drawable.monkey,R.string.monkey))
        animals.add(Animal(R.drawable.turtle,R.string.turtle))

        val animalList: RecyclerView = findViewById(R.id.animal_list)
        val adapter = CustomAdapter(this,animals)
        animalList.adapter = adapter
    }
}