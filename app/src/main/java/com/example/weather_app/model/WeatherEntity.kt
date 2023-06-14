package com.example.weather_app.model

data class WeatherEntity (

    val LocalItem: ArrayList<LocalData>?,

    val RemoteItem: ArrayList<RemoteData>?
) {
    data class LocalData (

        val prefecture: Map<String, Int>
    )

    data class RemoteData (

        var areaTitle: String = "",

        var areaWeather: String = "",
    )
}