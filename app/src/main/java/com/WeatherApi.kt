package com

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
//api.openweathermap.org/data/2.5/forecast?id=524901&appid={API key}

    @GET("data/2.5/forecast")
    fun getWeather(
        @Query("q") city: String = "Bishkek",
        @Query("appid") key: String = "36cbf21e77603d1848c9293fd5e5ba31",
        @Query("units") units: String = "metric"
    ): Call<WeatherModel>
}