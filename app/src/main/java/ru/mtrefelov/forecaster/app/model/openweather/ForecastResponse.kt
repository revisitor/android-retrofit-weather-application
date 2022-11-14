package ru.mtrefelov.forecaster.app.model.openweather

import com.squareup.moshi.Json

class ForecastResponse(
    val city: City,
    @Json(name = "list") val details: List<Detail>,
) {
    class Detail(
        @Json(name = "dt_txt") val timestamp: String,
        @Json(name = "main") val temperature: Temperature,
    )

    class Temperature(
        @Json(name = "temp") val value: Double,
    )

    class City(
        val name: String
    )
}