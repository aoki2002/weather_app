package com.example.weather_app.model

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call
import retrofit2.http.Query

interface WeatherApiService {

    @GET("{keyword}.json")
    fun getWeather(
        @Path("keyword") keyword: String
    ): Call<WeatherEntity>
}