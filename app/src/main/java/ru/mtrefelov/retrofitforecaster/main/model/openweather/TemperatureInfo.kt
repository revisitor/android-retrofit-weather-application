package ru.mtrefelov.retrofitforecaster.main.model.openweather

import com.squareup.moshi.Json

data class TemperatureInfo(
    @Json(name = "temp")
    val temperature: Double
)
