package ru.mtrefelov.forecaster.app.model.openweather

import retrofit2.Call
import retrofit2.http.*

internal interface OpenWeatherApi {
    @GET("data/2.5/forecast")
    fun getWeatherData(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric",
    ): Call<ForecastResponse>
}