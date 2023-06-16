package com.example.weather_app.model

import android.content.Context
import com.google.gson.Gson
import java.io.File

class WeatherJsonManager(context: Context): WeatherRepository.LocalRepository {

    override fun getAreaId(key: String): String {

        val jsonFile = File("../assets/AreaNumber.json")

        val json = jsonFile.readText()

        val data = Gson().fromJson(json, WeatherEntity.LocalData::class.java)

        return data.prefecture[key].toString()
    }
}