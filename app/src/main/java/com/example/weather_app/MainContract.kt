package com.example.weather_app

import com.example.weather_app.presenter.BasePresenter
import com.example.weather_app.view.BaseView

interface MainContract {
    interface View: BaseView<Presenter> {
        fun showTextView(text: String)
    }

    interface Presenter: BasePresenter {
        fun onClickButton(text: String)
    }
}