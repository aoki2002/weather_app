package com.example.weather_app.model

data class WeatherEntity (

    var LocalItem: ArrayList<LocalData>?,

    var RemoteItem: ArrayList<RemoteData>?
) {
    data class LocalData (

        var areaKey: String = ""
    )

    data class RemoteData (

        var areaTitle: String = "",

        var areaWeather: String = "",
    )
}