package com.example.weather_app.presenter

import com.example.weather_app.common.WeatherContract
import com.example.weather_app.model.WeatherEntity
import com.example.weather_app.model.WeatherRepository
import retrofit2.Response

class WeatherPresenter(private val view: WeatherContract.View, private val localRepository: WeatherRepository.LocalRepository, private val remoteRepository: WeatherRepository.RemoteRepository): WeatherContract.Presenter {

    var id: String = ""
    var index: Int = 1
    var areaTitle: String = ""
    var areaWeather: String = ""

    init {
        view.presenter = this
    }

    override fun start() {
    }

    override fun onClickButton(text: String) {

        id = localRepository.getAreaId(text)

        remoteRepository.getWeather(id, object: retrofit2.Callback<WeatherEntity> {

            override fun onResponse(call: retrofit2.Call<WeatherEntity>, response: Response<WeatherEntity>) {

                if (response.isSuccessful) {

                    response.body()?.targetArea?.let {

                        areaTitle = it + "の天気"

                        view.showAreaTitleTextView(areaTitle)
                    }

                    response.body()?.text?.let {

                        areaWeather = it

                        if (areaWeather.contains("【")) {

                            index = areaWeather.indexOf("【")

                            areaWeather = areaWeather.substring(0, index)
                        }

                        view.showAreaWeatherTextView(areaWeather)
                    }
                }
            }
            override fun onFailure(call: retrofit2.Call<WeatherEntity>, t: Throwable) {
            }
        })
    }
}