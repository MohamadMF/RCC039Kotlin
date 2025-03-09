package com.example.sharedprefapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shared_preferences)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val emailET: EditText = findViewById(R.id.email_et)
        val passET: EditText = findViewById(R.id.pass_et)
        val cb: CheckBox = findViewById(R.id.remember_cb)
        val loginBtn: Button = findViewById(R.id.login_btn)

        loginBtn.setOnClickListener {
            val email = emailET.text.toString()
            val password = passET.text.toString()

            val writer = getSharedPreferences("user_data", MODE_PRIVATE).edit()
            if ( cb.isChecked) {
                writer.putString("email", email)
                writer.putString("password", password)
            }
            else {
                writer.putString("email", "")
                writer.putString("password", "")
            }
        }
    }
}