package ru.mtrefelov.retrofitforecaster.main.model.entity

import com.squareup.moshi.Json

data class WeatherResponse(
    @Json(name = "list")
    val forecast: List<ForecastDetail>,
    val city: City,
)