package ru.mtrefelov.retrofitforecaster.main.model.core

import java.time.LocalDateTime

data class Forecast(
    val timestamp: LocalDateTime,
    val temperature: Double,
)