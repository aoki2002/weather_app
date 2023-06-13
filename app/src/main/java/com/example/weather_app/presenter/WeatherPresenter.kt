package com.example.weather_app.presenter

import com.example.weather_app.common.WeatherContract

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