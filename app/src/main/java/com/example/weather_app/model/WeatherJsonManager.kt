package com.example.weather_app.model

import com.google.gson.Gson
import java.io.File

class WeatherJsonManager: WeatherRepository.LocalRepository {

    override fun getAreaId(key: String) {

        val jsonFile = File("../assets/AreaNumber.json")

        val json = jsonFile.readText()

        val data = Gson().fromJson(json, WeatherEntity.LocalData::class.java)

        val id = data.prefecture[key]
    }
}