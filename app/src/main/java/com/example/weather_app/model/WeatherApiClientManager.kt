package com.example.weather_app.model

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class WeatherApiClientManager: WeatherRepository.RemoteRepository {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.jma.go.jp/bosai/forecast/data/overview_forecast/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val apiClient = retrofit.create(WeatherApiService::class.java)

    override fun getWeather(keyword: String, callback: Callback<WeatherEntity>) {
        apiClient.getWeather(keyword).enqueue(callback)
    }
}