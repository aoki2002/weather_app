package com.example.weather_app.common

import com.example.weather_app.presenter.BasePresenter
import com.example.weather_app.view.BaseView

interface WeatherContract {

    interface View: BaseView<Presenter> {

        fun showAreaTitleTextView(text: String)

        fun showAreaWeatherTextView(text: String)
    }

    interface Presenter: BasePresenter {

        fun onClickButton(text: String)
    }
}