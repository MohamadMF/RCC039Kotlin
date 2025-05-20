package com.example.newsapp

import android.content.Context
import android.content.Intent

fun goToSignUpActivity(context: Context) {
    val intent = Intent(context,SignUpActivity::class.java)
    context.startActivity(intent)
}

fun goToLoginActivity(context: Context) {
    val intent = Intent(context,LoginActivity::class.java)
    context.startActivity(intent)
}

fun goToSettingsActivity(context: Context) {
    val intent = Intent(context,SettingsActivity::class.java)
    context.startActivity(intent)
}

fun goToHomeActivity(context: Context) {
    val intent = Intent(context,HomeActivity::class.java)
    context.startActivity(intent)
}