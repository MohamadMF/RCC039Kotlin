package com.example.infinitydogs

import retrofit2.Call
import retrofit2.http.GET

// Like EntityDAO of Room database
interface DogAPICallable {

    @GET("/api/breeds/image/random")
    fun getDogImage(): Call<DogModel>
}