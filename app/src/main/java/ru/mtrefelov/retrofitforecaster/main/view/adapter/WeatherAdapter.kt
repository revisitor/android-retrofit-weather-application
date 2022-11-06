package ru.mtrefelov.retrofitforecaster.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.mtrefelov.retrofitforecaster.R
import ru.mtrefelov.retrofitforecaster.main.model.core.Forecast

class WeatherAdapter : ListAdapter<Forecast, WeatherItem>(WeatherItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherItem {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == HOT_WEATHER_TYPE) {
            val view = inflater.inflate(R.layout.hot_weather_item, parent, false)
            HotWeatherItem(view)
        } else {
            val view = inflater.inflate(R.layout.cold_weather_item, parent, false)
            ColdWeatherItem(view)
        }
    }

    companion object {
        private const val HOT_WEATHER_TYPE = 0
        private const val COLD_WEATHER_TYPE = 1
    }

    override fun onBindViewHolder(holder: WeatherItem, position: Int) {
        val forecast = getItem(position)
        holder.bind(forecast)
    }

    override fun getItemViewType(position: Int): Int {
        val forecast = getItem(position)
        return if (forecast.temperature > 0) {
            HOT_WEATHER_TYPE
        } else {
            COLD_WEATHER_TYPE
        }
    }
}