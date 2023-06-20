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

        remoteRepository.getWeather(id, object: retrofit2.Callback<WeatherEntity> {

            override fun onResponse(call: retrofit2.Call<WeatherEntity>, response: Response<WeatherEntity>) {

                if (response.isSuccessful) {

                    response.body()?.targetArea?.let {

                        view.showAreaTitleTextView(it + "の天気")
                    }

                    response.body()?.text?.let {

                        val index = it.indexOf("【")

                        val it = it.substring(0, index)

                        view.showAreaWeatherTextView(it)
                    }
                }
            }
            override fun onFailure(call: retrofit2.Call<WeatherEntity>, t: Throwable) {
            }
        })
    }
}