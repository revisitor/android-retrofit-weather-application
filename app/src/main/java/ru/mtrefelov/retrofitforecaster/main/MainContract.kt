package ru.mtrefelov.retrofitforecaster.main

import ru.mtrefelov.retrofitforecaster.base.BaseContract
import ru.mtrefelov.retrofitforecaster.main.model.entity.ForecastDetail

interface MainContract {
    interface Presenter : BaseContract.Presenter {
        fun onViewCreated()
    }

    interface View : BaseContract.View<Presenter> {
        fun setToolbarTitle(title: CharSequence)
        fun setForecastDetails(forecastDetails: List<ForecastDetail>)
    }
}