package com.example.theweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.Presenter
import com.WeatherModel
import com.WeatherView
import com.example.theweather.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), WeatherView {

    @Inject
    lateinit var presenter: Presenter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        presenter.getWeather()
    }

    override fun showWeather(weatherModel: WeatherModel) {
        binding.tvBishKyr.text = weatherModel.main.temp.toString()
        Log.e("Kad", "showWeather: $weatherModel", )
    }

    override fun showError(error: String) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
    }
}