package ru.mtrefelov.retrofitforecaster.main.model.entity

import com.squareup.moshi.Json

data class TemperatureInfo(
    @Json(name = "temp")
    val temperature: Double,
)
