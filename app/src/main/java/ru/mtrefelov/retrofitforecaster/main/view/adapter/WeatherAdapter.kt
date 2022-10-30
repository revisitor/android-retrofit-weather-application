package ru.mtrefelov.retrofitforecaster.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.mtrefelov.retrofitforecaster.R
import ru.mtrefelov.retrofitforecaster.main.model.entity.ForecastDetail

class WeatherAdapter : ListAdapter<ForecastDetail, WeatherViewHolder>(WeatherItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == HOT_WEATHER_TYPE) {
            val view = inflater.inflate(R.layout.hot_weather_item, parent, false)
            HotWeatherViewHolder(view)
        } else {
            val view = inflater.inflate(R.layout.cold_weather_item, parent, false)
            ColdWeatherViewHolder(view)
        }
    }

    companion object {
        private const val HOT_WEATHER_TYPE = 0
        private const val COLD_WEATHER_TYPE = 1
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val forecast: ForecastDetail = getItem(position)
        holder.bind(forecast)
    }

    override fun getItemViewType(position: Int): Int {
        val forecast: ForecastDetail = getItem(position)
        return if (forecast.temperatureInfo.temperature > 0) {
            HOT_WEATHER_TYPE
        } else {
            COLD_WEATHER_TYPE
        }
    }
}