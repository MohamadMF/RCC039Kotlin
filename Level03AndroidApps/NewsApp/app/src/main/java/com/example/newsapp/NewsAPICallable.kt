package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPICallable {
    @GET("/v2/top-headlines?apiKey=d9e17e996caa435aae75ca77e76727b6")
    fun getNews(
        @Query("country") country: String,
        @Query("category") category: String
    ): Call<News>
}