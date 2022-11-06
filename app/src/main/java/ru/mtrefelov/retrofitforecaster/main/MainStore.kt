package ru.mtrefelov.retrofitforecaster.main

import ru.mtrefelov.retrofitforecaster.main.model.core.Forecast

object MainStore {
    val forecastDetails: MutableList<Forecast> = mutableListOf()
    var city: String = ""
}