package com.example.weather_app.presenter

import android.util.Log
import com.example.weather_app.common.WeatherContract
import com.example.weather_app.model.WeatherEntity
import com.example.weather_app.model.WeatherRepository
import retrofit2.Response


class WeatherPresenter(private val view: WeatherContract.View, private val localRepository: WeatherRepository.LocalRepository, private val remoteRepository: WeatherRepository.RemoteRepository): WeatherContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
    }

    override fun onClickButton(text: String) {

        val id = localRepository.getAreaId(text)

//        view.showAreaTitleTextView(id)

        remoteRepository.getWeather(id, object: retrofit2.Callback<WeatherEntity> {
            override fun onResponse(call: retrofit2.Call<WeatherEntity>, response: Response<WeatherEntity>) {

                if (response.isSuccessful) {

                    response.body()?.targetArea?.get(0).let {
                        Log.d("WeatherPresenter", "都道府県 : " + it.toString())
                        view.showAreaTitleTextView(it.toString() + "の天気")
                    }

                    response.body()?.text?.get(0).let {
                        Log.d("WeatherPresenter", "概要 : " + it.toString())
                        view.showAreaWeatherTextView(it.toString())
                    }
                } else {

                }
            }
            override fun onFailure(call: retrofit2.Call<WeatherEntity>, t: Throwable) {
            }
        })
    }
}