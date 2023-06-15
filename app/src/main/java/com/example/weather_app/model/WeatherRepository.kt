package com.example.weather_app.model

import retrofit2.Callback

interface WeatherRepository {

    interface LocalRepository {

        fun getAreaId(key: String): String
    }

    interface RemoteRepository {

        fun getWeather(id: String, callback: Callback<WeatherEntity.RemoteData>)
    }
}