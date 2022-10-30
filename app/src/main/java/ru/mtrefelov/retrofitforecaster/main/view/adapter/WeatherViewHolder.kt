package ru.mtrefelov.retrofitforecaster.main.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import ru.mtrefelov.retrofitforecaster.R
import ru.mtrefelov.retrofitforecaster.main.model.entity.ForecastDetail

abstract class WeatherViewHolder(root: View) : RecyclerView.ViewHolder(root) {
    protected abstract val datetimeTextView: TextView
    protected abstract val temperatureTextView: TextView

    open fun bind(forecastDetail: ForecastDetail) {
        datetimeTextView.text = forecastDetail.timestamp
        temperatureTextView.apply {
            val temperature = forecastDetail.temperatureInfo.temperature
            text = resources.getString(R.string.temperature_celsius, temperature)
        }
    }
}