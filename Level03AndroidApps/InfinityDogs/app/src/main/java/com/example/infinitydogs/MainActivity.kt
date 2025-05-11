package com.example.infinitydogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.infinitydogs.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    //https://dog.ceo/api/breeds/image/random
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
//        Glide
//            .with(this)
//            .load("https://goo.gl/gEgYUd")
//            .placeholder(R.drawable.ic_launcher_background)
//            .error(ColorDrawable(Color.GRAY))
//            .into(binding.image)
        val resources = Retrofit
            .Builder()
            .baseUrl("https://dog.ceo")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val receiveData = resources.create(DogAPICallable::class.java)

        receiveData.getDogImage().enqueue(object : Callback<DogModel> {
            override fun onResponse(p0: Call<DogModel>, p1: Response<DogModel>) {
                if (p1.isSuccessful) {
                    val dogImg = p1.body()
                    Glide
                        .with(this@MainActivity)
                        .load(dogImg?.picLink)
                        .placeholder(android.R.drawable.progress_indeterminate_horizontal)
                        .error(ColorDrawable(Color.GRAY))
                        .into(binding.image)
                }
            }

            override fun onFailure(p0: Call<DogModel>, p1: Throwable) {
                Log.d("trace","Error: ${p1.message}")
            }
        })
    }
}