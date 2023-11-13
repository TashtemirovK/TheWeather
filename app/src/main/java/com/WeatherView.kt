package com


interface WeatherView {
    fun showWeather(weatherModel: WeatherModel)
    fun showError(error: String)
}