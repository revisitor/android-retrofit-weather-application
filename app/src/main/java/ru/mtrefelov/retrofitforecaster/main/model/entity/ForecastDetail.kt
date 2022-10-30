package ru.mtrefelov.retrofitforecaster.main.model.entity

import com.squareup.moshi.Json

data class ForecastDetail(
    @Json(name = "dt_txt")
    val timestamp: String,

    @Json(name = "main")
    val temperatureInfo: TemperatureInfo,
)
