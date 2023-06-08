package com.example.weather_app.view

import com.example.weather_app.WeatherContract
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class WeatherFragment : AppCompatActivity(), WeatherContract.View {

    lateinit var presenter: WeatherContract.Presenter
    lateinit var editText :EditText
    lateinit var button :Button
}