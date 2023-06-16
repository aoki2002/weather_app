package com.example.weather_app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weather_app.common.WeatherContract
import com.example.weather_app.R
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.weather_app.model.WeatherApiClientManager
import com.example.weather_app.model.WeatherJsonManager
import com.example.weather_app.presenter.WeatherPresenter

class WeatherFragment: Fragment(), WeatherContract.View {

    override lateinit var presenter: WeatherContract.Presenter

    lateinit var editText :EditText
    lateinit var button :Button
    lateinit var areaTitleTextView :TextView
    lateinit var areaWeatherTextView :TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById<EditText>(R.id.weather_edit1)
        button = view.findViewById<Button>(R.id.weather_btn1)
        areaTitleTextView = view.findViewById<TextView>(R.id.weather_txt2)
        areaWeatherTextView = view.findViewById<TextView>(R.id.weather_txt3)

        presenter = WeatherPresenter(this, WeatherJsonManager(requireContext()), WeatherApiClientManager())

        presenter.start()

        button.setOnClickListener{
            presenter.onClickButton(editText.text.toString())
        }
    }

    override fun showAreaTitleTextView(text: String) {
        areaTitleTextView.text = text
    }

    override fun showAreaWeatherTextView(text: String) {
        areaWeatherTextView.text = text
    }
}