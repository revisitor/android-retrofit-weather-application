package ru.mtrefelov.retrofitforecaster.main.model.openweather

import com.squareup.moshi.Json

data class WeatherResponse(
    @Json(name = "list")
    val forecast: List<ForecastDetail>,
    val city: City,
)