package com.example.weather_app.presenter

import com.example.weather_app.common.WeatherContract
import com.example.weather_app.model.WeatherRepository

class WeatherPresenter(private val view: WeatherContract.View, private val localRepository: WeatherRepository.LocalRepository, private val remoteRepository: WeatherRepository.RemoteRepository): WeatherContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
    }

    override fun onClickButton(text: String) {

        localRepository.getAreaId(text)

    }
}