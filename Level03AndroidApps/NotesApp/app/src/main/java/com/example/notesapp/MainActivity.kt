package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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
        val viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        binding.addFab.setOnClickListener {
            startActivity(
                Intent(this,AddingNoteActivity::class.java)
            )
            finish()
        }

        //this code to show the notes it already saved
        viewModel.getNotes().observe(this){ notes ->
            /*val fieldListRows = mutableListOf<String>()
            for (element in notes)
                fieldListRows.add(element.details)
            */
            val fieldListRows = notes.map { it.details }
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                fieldListRows)
            binding.notesList.adapter = adapter
        }
        binding.notesList.setOnItemClickListener { parent, view, position, id ->

        }
    }
}