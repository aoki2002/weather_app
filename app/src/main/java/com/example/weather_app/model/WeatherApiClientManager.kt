package com.example.weather_app.model

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeatherApiClientManager: WeatherRepository.RemoteRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.jma.go.jp/bosai/forecast/data/overview_forecast/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiClient = retrofit.create(WeatherApiService::class.java)

    override fun getWeather(id: String, callback: Callback<WeatherEntity>) {

        apiClient.getWeather(id).enqueue(callback)
    }
}