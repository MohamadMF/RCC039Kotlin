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

        //without .edit means, we will restore the putted data
        val reader = getSharedPreferences("user_data", MODE_PRIVATE)
        val rEmail = reader.getString("email",null)
        val rPassword = reader.getString("password",null)
        emailET.setText(rEmail)
        passET.setText(rPassword)

        loginBtn.setOnClickListener {
            val email = emailET.text.toString()
            val password = passET.text.toString()

            // to prevent repeat the code into if block.
            //the mode to prevent to steel the data. and .edit to put the data
            val writer = getSharedPreferences("user_data", MODE_PRIVATE).edit()
            if (cb.isChecked) {
                writer.putString("email", email)
                writer.putString("password", password)
            } else {
                //as replace when the user return back
                writer.putString("email", "")
                writer.putString("password", "")
            }
            writer.apply() //because it will run at all.
        }
    }
}