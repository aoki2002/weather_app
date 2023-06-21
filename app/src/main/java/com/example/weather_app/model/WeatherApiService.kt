package com.example.weather_app.model

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call
import retrofit2.http.Query

interface WeatherApiService {

    @GET("{id}.json")

    fun getWeather(

        @Path("id") id: String
    ): Call<WeatherEntity>
}