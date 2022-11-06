package ru.mtrefelov.retrofitforecaster.main.view.adapter

import android.view.View
import android.widget.TextView
import ru.mtrefelov.retrofitforecaster.R
import ru.mtrefelov.retrofitforecaster.main.model.core.Forecast

class ColdWeatherItem(root: View) : WeatherItem(root) {
    override val datetimeTextView: TextView = root.findViewById(R.id.cold_weather_datetime)
    override val temperatureTextView: TextView = root.findViewById(R.id.cold_weather_temperature)

    override fun bind(forecast: Forecast) {
        if (forecast.temperature > 0) {
            throw IllegalArgumentException("temperature > 0")
        }

        super.bind(forecast)
    }
}