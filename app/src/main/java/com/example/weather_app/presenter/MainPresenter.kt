package com.example.weather_app.presenter

import com.example.weather_app.MainContract

class MainPresenter(private val view: MainContract.View): MainContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
    }

    override fun onClickButton(text: String) {
        view.showTextView(text)
    }
}