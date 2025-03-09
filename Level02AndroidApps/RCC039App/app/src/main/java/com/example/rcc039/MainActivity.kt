package com.example.rcc039

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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
        Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
        Log.d("lifecycle","onCreate() has called")

//        val emailInput: EditText = findViewById(R.id.email_text_id)
        val nameInput: EditText = findViewById(R.id.name_text_id)
        val loginBtn: Button = findViewById(R.id.login_btn)

        loginBtn.setOnClickListener { //TODO("Text Watcher")
            val writtenText = nameInput.text.toString()
            if (writtenText.isBlank()) {//if it was isEmpty, it won't ignore any spaces
                Toast.makeText(this,
                    "You didn't enter a name yet!",
                    Toast.LENGTH_SHORT)
                    .show()
                nameInput.error = "Required field"
            } else {
                val intent = Intent(this, HomeActivity::class.java) //Explicit Intent
                intent.putExtra("username",nameInput.text.toString())
                startActivity(intent)
                finish() //if I want just remove current activity I in. Before navigation
                //finishAffinity() // If I want to remove all opened activities then exit
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle","onStart() has called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifecycle","onRestart() has called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle","onResume() has called")
    }

    override fun onPause() {
        super.onPause()
        // for printing anything in app, we determine (Device - Category - Subcategory)

        // when I wanna display a message, I need two things:
        //   1. address --> key in Log.d() and that will go to receiver
        //   2. letter --> value in Log.d()
        Log.d("lifecycle","onPause() has called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle","onStop() has called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle","onDestroy() has called")
    }
}