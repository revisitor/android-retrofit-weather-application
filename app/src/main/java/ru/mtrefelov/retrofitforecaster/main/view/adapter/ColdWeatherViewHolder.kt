package ru.mtrefelov.retrofitforecaster.main.view.adapter

import android.view.View
import android.widget.TextView
import ru.mtrefelov.retrofitforecaster.R
import ru.mtrefelov.retrofitforecaster.main.model.entity.ForecastDetail

class ColdWeatherViewHolder(root: View) : WeatherViewHolder(root) {
    override val datetimeTextView: TextView = root.findViewById(R.id.cold_weather_datetime)
    override val temperatureTextView: TextView = root.findViewById(R.id.cold_weather_temperature)

    override fun bind(forecastDetail: ForecastDetail) {
        if (forecastDetail.temperatureInfo.temperature <= 0) {
            super.bind(forecastDetail)
        } else {
            throw IllegalArgumentException("temperature > 0")
        }
    }
}