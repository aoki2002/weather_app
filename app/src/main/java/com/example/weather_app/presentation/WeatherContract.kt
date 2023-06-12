package com.example.weather_app.presentation

interface WeatherContract {

    interface BaseView<T> {

        var presenter: T
    }

    interface BasePresenter {

        fun start()
    }

    interface View: BaseView<Presenter> {

        fun showTextView(text: String)
    }

    interface Presenter: BasePresenter {

        fun onClickButton(text: String)
    }
}