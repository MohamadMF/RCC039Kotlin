package com.example.notesapp

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.databinding.ActivityEditingNoteBinding

class EditingNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityEditingNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("note",Note::class.java)!!
        }else{
            intent.getParcelableExtra("note")!!
        }
        binding.noteEditT.setText(data.details)

        val viewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        binding.updateBtn.setOnClickListener {
            val updatedDetails = binding.noteEditT.text.toString()
            viewModel.upsert(Note(data.id,updatedDetails))
            Toast.makeText(this, "Your entry has updated!", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.deleteBtn.setOnClickListener {
            viewModel.delete(data)
            Toast.makeText(this, "Your entry has deleted!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}