package ru.mtrefelov.retrofitforecaster.main.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import ru.mtrefelov.retrofitforecaster.R
import ru.mtrefelov.retrofitforecaster.main.ForecastDisplayConfig
import ru.mtrefelov.retrofitforecaster.main.model.core.Forecast

abstract class WeatherItem(root: View) : RecyclerView.ViewHolder(root) {
    protected abstract val datetimeTextView: TextView
    protected abstract val temperatureTextView: TextView

    open fun bind(forecast: Forecast) {
        datetimeTextView.text = forecast.timestamp.format(ForecastDisplayConfig.dateTimeFormatter)
        temperatureTextView.apply {
            text = resources.getString(R.string.temperature_celsius, forecast.temperature)
        }
    }
}