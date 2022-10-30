package ru.mtrefelov.retrofitforecaster.main.view.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.mtrefelov.retrofitforecaster.main.model.entity.ForecastDetail

class WeatherItemCallback : DiffUtil.ItemCallback<ForecastDetail>() {
    override fun areItemsTheSame(oldItem: ForecastDetail, newItem: ForecastDetail): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ForecastDetail, newItem: ForecastDetail): Boolean {
        return oldItem == newItem
    }
}
