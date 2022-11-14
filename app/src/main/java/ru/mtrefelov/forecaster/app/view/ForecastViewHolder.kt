package ru.mtrefelov.forecaster.app.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import ru.mtrefelov.forecaster.R
import ru.mtrefelov.forecaster.app.model.core.Forecast
import ru.mtrefelov.forecaster.app.timestampFormat

sealed class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected abstract val datetime: TextView
    protected abstract val temperature: TextView

    open fun bind(forecast: Forecast) {
        datetime.text = forecast.timestamp.format(timestampFormat)
        temperature.text = temperature.resources.getString(R.string.temperature_celsius, forecast.temperature)
    }

    class Cold(itemView: View) : ForecastViewHolder(itemView) {
        override val datetime: TextView = itemView.findViewById(R.id.cold_weather_datetime)
        override val temperature: TextView = itemView.findViewById(R.id.cold_weather_temperature)

        override fun bind(forecast: Forecast) {
            if (forecast.temperature <= 0) {
                super.bind(forecast)
            } else {
                throw IllegalArgumentException("temperature > 0")
            }
        }
    }

    class Hot(itemView: View) : ForecastViewHolder(itemView) {
        override val datetime: TextView = itemView.findViewById(R.id.hot_weather_datetime)
        override val temperature: TextView = itemView.findViewById(R.id.hot_weather_temperature)

        override fun bind(forecast: Forecast) {
            if (forecast.temperature > 0) {
                super.bind(forecast)
            } else {
                throw IllegalArgumentException("temperature <= 0")
            }
        }
    }
}