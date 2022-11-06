package ru.mtrefelov.retrofitforecaster.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import ru.mtrefelov.retrofitforecaster.BuildConfig
import ru.mtrefelov.retrofitforecaster.main.MainContract

import ru.mtrefelov.retrofitforecaster.R
import ru.mtrefelov.retrofitforecaster.main.model.core.Forecast
import ru.mtrefelov.retrofitforecaster.main.presenter.MainPresenter
import ru.mtrefelov.retrofitforecaster.main.view.adapter.WeatherAdapter

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var weatherAdapter: WeatherAdapter
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.main_toolbar))

        weatherAdapter = WeatherAdapter()
        findViewById<RecyclerView>(R.id.weather_recycler_view).apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        presenter = MainPresenter(this, BuildConfig.API_KEY_OPEN_WEATHER)
        with(presenter) {
            if (savedInstanceState == null) {
                onFirstTimeCreated()
            } else {
                onRecreated()
            }
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setToolbarTitle(title: CharSequence) {
        supportActionBar!!.title = title
    }

    override fun setForecastDetails(forecasts: List<Forecast>) {
        weatherAdapter.submitList(forecasts)
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }
}