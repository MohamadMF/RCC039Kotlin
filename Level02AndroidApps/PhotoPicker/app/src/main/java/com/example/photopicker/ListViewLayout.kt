package com.example.photopicker

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val animals = arrayOf("Lion", "Tiger", "Elephant", "Zipper", "Cat","Lion", "Tiger", "Elephant", "Zipper", "Cat","Lion", "Tiger", "Elephant", "Zipper", "Cat")
        val animalAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,animals)
        val animalsViewLayout: ListView = findViewById(R.id.animals)
        animalsViewLayout.adapter = animalAdapter

    }
}