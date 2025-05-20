package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.newsapp.databinding.ActivityLoginBinding
import com.example.newsapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize Firebase Auth
        Firebase.auth.also { auth = it }

        binding.newUser.setOnClickListener {
            goToSignUpActivity(this)
            finish()
        }

        binding.loginBtn.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            if (email.isBlank() || password.isBlank())
                Toast.makeText(this, "Empty field/s!", Toast.LENGTH_SHORT).show()
            else {
                binding.progressCircular.isVisible = true
                login(email,password)
            }

            binding.forgotPassQ.setOnClickListener {
                val emailAddress = binding.emailInput.text.toString()

                Firebase.auth.sendPasswordResetEmail(emailAddress)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this,
                                "Done. Check your email inbox!!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }

        }
    }

    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    if (auth.currentUser!!.isEmailVerified) {
                        goToHomeActivity(this)
                        binding.progressCircular.isVisible = false
                    } else {
                        Toast.makeText(this,
                            "Check your Email!!",
                            Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    binding.progressCircular.isVisible = false
                    Toast.makeText(this,
                        task.exception?.message,
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null && currentUser.isEmailVerified) {
            goToHomeActivity(this)
            finish()
        }
    }
}