package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.databinding.ActivityAddingNoteBinding

class AddingNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityAddingNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        binding.saveBtn.setOnClickListener {
            val rowEditText = binding.noteEditT.text.toString()
            val fieldColumn = Note(details = rowEditText)
            viewModel.upsert(fieldColumn)
            binding.noteEditT.text?.clear()
            Toast.makeText(this, "Your Entry has saved!", Toast.LENGTH_SHORT).show()
        }
        binding.backBtn.setOnClickListener {
            startActivity(
                Intent(this,MainActivity::class.java)
            )
            finish()
        }
    }
}