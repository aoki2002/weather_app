package com.example.weather_app.model

import retrofit2.Callback

interface WeatherRepository {

    interface LocalRepository {

        fun getAreaNumbers(text: String)
    }

    interface RemoteRepository {

        fun getWeather(keyword: String, callback: Callback<WeatherEntity>)
    }
}