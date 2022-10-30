package ru.mtrefelov.retrofitforecaster.main.presenter

import ru.mtrefelov.retrofitforecaster.main.MainContract
import ru.mtrefelov.retrofitforecaster.main.model.api.OpenWeatherApi

class MainPresenter(private var view: MainContract.View?, apiKey: String) : MainContract.Presenter {
    private val weatherApi = OpenWeatherApi(apiKey)

    override fun onViewCreated() {
        view!!.run {
            // Shklov:
            // latitude = 54.208585,
            // longitude = 30.291164
            weatherApi.getWeatherData(55.030204, 82.920430) {
                setToolbarTitle(it.city.name)
                setForecastDetails(it.forecast)
            }
        }
    }

    override fun onDestroy() {
        view = null
    }
}