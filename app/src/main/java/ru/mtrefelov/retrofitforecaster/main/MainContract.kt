package ru.mtrefelov.retrofitforecaster.main

import ru.mtrefelov.retrofitforecaster.base.BaseContract
import ru.mtrefelov.retrofitforecaster.main.model.core.Forecast

interface MainContract {
    interface Presenter : BaseContract.Presenter {
        fun onFirstTimeCreated()
        fun onRecreated()
    }

    interface View : BaseContract.View<Presenter> {
        fun setToolbarTitle(title: CharSequence)
        fun setForecastDetails(forecasts: List<Forecast>)
    }
}