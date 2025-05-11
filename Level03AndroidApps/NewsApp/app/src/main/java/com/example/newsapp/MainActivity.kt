package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.newsapp.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //https://newsapi.org/v2/top-headlines?country=us&category=general&apiKey=d9e17e996caa435aae75ca77e76727b6
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadNews()
    }

    private fun loadNews() {
        val cat = intent.getStringExtra("cat") ?: "general"
        val country = getSharedPreferences("settings", MODE_PRIVATE)
            .getString("code", "us")!!
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val receiver = retrofit.create(NewsAPICallable::class.java)
        receiver.getNews(country, cat).enqueue(object : Callback<News> {
            override fun onResponse(p0: Call<News>, p1: Response<News>) {
                binding.progressCircular.isVisible = false
                if (p1.isSuccessful) {
                    val article = p1.body()?.articles
                    //Log.d("trace", "Error: ${article?.get(0)}")
                    val adapter = ArticleAdapter(this@MainActivity, article!!)
                    binding.articleList.adapter = adapter
                } else {
                    Log.d("trace", "Error: ${p1.code()}")
                }
            }

            override fun onFailure(p0: Call<News>, p1: Throwable) {
                binding.progressCircular.isVisible = false
                Log.d("trace", "Error: ${p1.message}")
            }
        })

    }
}