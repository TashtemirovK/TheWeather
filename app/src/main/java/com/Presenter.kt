package com

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Presenter @Inject constructor(private val api: WeatherApi) {

    lateinit var view: WeatherView

    fun attachView(view: WeatherView) {
        this.view = view
    }

    fun getWeather(city: String = "Bishkek") {
        api.getWeather(city).enqueue(object : Callback<WeatherModel> {
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        view.showWeather(it)
                    }
                }
            }
            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                view.showError(t.message.toString())
            }

        })
    }

}