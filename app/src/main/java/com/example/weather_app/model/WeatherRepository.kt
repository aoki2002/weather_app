package com.example.weather_app.model

import retrofit2.Callback

interface WeatherRepository {

    interface LocalRepository {

        fun getAreaId(key: String)
    }

    interface RemoteRepository {

        fun getWeather(keyword: String, callback: Callback<WeatherEntity>)
    }
}