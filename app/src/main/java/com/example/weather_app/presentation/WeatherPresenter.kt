package com.example.weather_app.presentation

import com.example.weather_app.presentation.WeatherContract

class WeatherPresenter(private val view: WeatherContract.View): WeatherContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
    }

    override fun onClickButton(text: String) {
        view.showTextView(text)
    }
}