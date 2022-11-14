package ru.mtrefelov.forecaster.app

import ru.mtrefelov.forecaster.app.model.core.Forecast
import ru.mtrefelov.forecaster.app.model.openweather.ForecastResponse

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val timestampFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

fun List<ForecastResponse.Detail>.toForecasts(): List<Forecast> {
    return map { it.toForecast() }
}

fun ForecastResponse.Detail.toForecast(): Forecast {
    val temperature = temperature.value
    val timestamp = LocalDateTime.parse(timestamp, timestampFormat)
    return Forecast(temperature, timestamp)
}