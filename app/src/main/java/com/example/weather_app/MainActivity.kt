package com.example.weather_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather_app.view.StartFragment
import android.text.TextUtils.replace

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}