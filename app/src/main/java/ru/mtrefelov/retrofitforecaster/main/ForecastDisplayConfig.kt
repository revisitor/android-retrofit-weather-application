package ru.mtrefelov.retrofitforecaster.main

import java.time.format.DateTimeFormatter

object ForecastDisplayConfig {
    val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
}