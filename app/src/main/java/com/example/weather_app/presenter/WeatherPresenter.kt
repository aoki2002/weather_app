package com.example.weather_app.presenter

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

        remoteRepository.getWeather(id, object: retrofit2.Callback<WeatherEntity.RemoteData> {
            override fun onResponse(call: retrofit2.Call<WeatherEntity.RemoteData>, response: Response<WeatherEntity.RemoteData>) {

                if(response.isSuccessful) {

                    response.body()?.areaTitle?.get(0).let {
                        view.showAreaTitleTextView(it.toString()+"の天気")
                    }

                    response.body()?.areaWeather?.get(0).let {
                        view.showAreaWeatherTextView(it.toString())
                    }
                } else {

                }

            }
            override fun onFailure(call: retrofit2.Call<WeatherEntity.RemoteData>, t: Throwable) {
            }
        })
    }
}