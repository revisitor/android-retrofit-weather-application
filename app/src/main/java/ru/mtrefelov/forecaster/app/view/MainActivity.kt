package ru.mtrefelov.forecaster.app.view

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import ru.mtrefelov.forecaster.R
import ru.mtrefelov.forecaster.BuildConfig
import ru.mtrefelov.forecaster.app.model.core.Forecast
import ru.mtrefelov.forecaster.app.model.openweather.OpenWeatherService
import ru.mtrefelov.forecaster.app.toForecasts

class MainActivity : AppCompatActivity() {
    private lateinit var forecastsAdapter: ForecastsAdapter
    private lateinit var forecastFragment: ForecastFragment

    private lateinit var forecastService: OpenWeatherService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.main_toolbar))

        forecastsAdapter = ForecastsAdapter()
        findViewById<RecyclerView>(R.id.weather_recycler_view).apply {
            adapter = forecastsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        forecastService = OpenWeatherService(BuildConfig.API_KEY_OPEN_WEATHER)

        val retainFragment: ForecastFragment? = supportFragmentManager
            .findFragmentByTag("FORECAST_FRAGMENT") as ForecastFragment?

        if (retainFragment != null) {
            forecastFragment = retainFragment.also {
                setToolbarTitle(it.city)
                setForecasts(it.forecasts)
            }
        } else {
            forecastService.getWeatherData(55.030204, 82.920430) { response ->
                val city = response.city.name.also(::setToolbarTitle)
                val forecasts = response.details.toForecasts().also(::setForecasts)
                setUpRetainFragment(city, forecasts)
            }
        }
    }

    private fun setToolbarTitle(title: CharSequence) {
        supportActionBar!!.title = title
    }

    private fun setForecasts(forecasts: List<Forecast>) {
        forecastsAdapter.submitList(forecasts)
    }

    private fun setUpRetainFragment(city: String, forecasts: List<Forecast>) {
        forecastFragment = ForecastFragment().apply {
            arguments = Bundle().apply {
                putString(ForecastFragment.CITY, city)
                putParcelableArrayList(ForecastFragment.FORECASTS, ArrayList(forecasts))
            }

            supportFragmentManager.beginTransaction().add(this, "FORECAST_FRAGMENT").commit()
        }
    }
}