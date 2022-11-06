package ru.mtrefelov.retrofitforecaster.main.presenter

import ru.mtrefelov.retrofitforecaster.main.*
import ru.mtrefelov.retrofitforecaster.main.MainStore
import ru.mtrefelov.retrofitforecaster.main.model.openweather.OpenWeatherApi
import ru.mtrefelov.retrofitforecaster.main.model.core.Forecast
import ru.mtrefelov.retrofitforecaster.main.model.openweather.WeatherResponse

import java.time.LocalDateTime

class MainPresenter(private var view: MainContract.View?, apiKey: String) : MainContract.Presenter {
    private val weatherApi = OpenWeatherApi(apiKey)

    override fun onFirstTimeCreated() {
        view!!.run {
            weatherApi.getWeatherData(55.030204, 82.920430) { response ->
                MainStore.apply {
                    city = response.city.name
                    forecastDetails.addAll(response.getForecasts())
                }

                syncWithStore()
            }
        }
    }

    private fun MainContract.View.syncWithStore() {
        setToolbarTitle(MainStore.city)
        setForecastDetails(MainStore.forecastDetails)
    }

    private fun WeatherResponse.getForecasts(): List<Forecast> {
        return forecast.map {
            val timestamp = LocalDateTime.parse(it.timestamp, ForecastDisplayConfig.dateTimeFormatter)
            val temperature = it.temperatureInfo.temperature
            Forecast(timestamp, temperature)
        }
    }

    override fun onRecreated() = view!!.syncWithStore()

    override fun onDestroy() {
        view = null
    }
}