package ru.mtrefelov.retrofitforecaster.main.view.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.mtrefelov.retrofitforecaster.main.model.core.Forecast

class WeatherItemCallback : DiffUtil.ItemCallback<Forecast>() {
    override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast): Boolean {
        return oldItem == newItem
    }
}
