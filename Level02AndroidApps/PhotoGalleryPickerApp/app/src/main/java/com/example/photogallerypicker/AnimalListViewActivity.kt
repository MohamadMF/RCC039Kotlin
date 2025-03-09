package com.example.photogallerypicker

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AnimalListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animal_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val animals = arrayOf("Lion", "Tiger", "Elephant", "Zipper", "Cat","Lion", "Tiger", "Elephant", "Zipper", "Cat","Lion", "Tiger", "Elephant", "Zipper", "Cat")
        val animalAdapter = ArrayAdapter(this,R.layout.custom_list_item,animals) //android.R.layout.simple_list_item_1
        val animalsViewLayout: ListView = findViewById(R.id.animals)
        animalsViewLayout.adapter = animalAdapter
        // Lambda means parameters has named without parentheses and nor fun
        animalsViewLayout.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${animals[position]} clicked!", Toast.LENGTH_SHORT).show()

        }
    }
}