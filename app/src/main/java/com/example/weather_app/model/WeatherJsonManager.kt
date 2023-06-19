package com.example.weather_app.model

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader
import org.json.JSONObject

class WeatherJsonManager(private val context: Context): WeatherRepository.LocalRepository {

    override fun getAreaId(key: String): String {

        val assetManager = context.assets
        val inputStream = assetManager.open("AreaNumber.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val json: String? = bufferedReader.readText()

        val jsonObject = JSONObject(json)

        return jsonObject.optString(key)
    }
}