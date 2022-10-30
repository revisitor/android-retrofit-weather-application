package ru.mtrefelov.retrofitforecaster.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.*
import ru.mtrefelov.retrofitforecaster.BuildConfig
import ru.mtrefelov.retrofitforecaster.main.MainContract

import ru.mtrefelov.retrofitforecaster.R
import ru.mtrefelov.retrofitforecaster.main.model.entity.ForecastDetail
import ru.mtrefelov.retrofitforecaster.main.presenter.MainPresenter
import ru.mtrefelov.retrofitforecaster.main.view.adapter.WeatherAdapter

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var toolbar: Toolbar
    private lateinit var weatherRecyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapter

    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<Toolbar>(R.id.main_toolbar).also {
            setSupportActionBar(it)
        }

        weatherAdapter = WeatherAdapter()
        weatherRecyclerView = findViewById<RecyclerView>(R.id.weather_recycler_view).apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        presenter = MainPresenter(this, BuildConfig.API_KEY_OPEN_WEATHER)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setToolbarTitle(title: CharSequence) {
        toolbar.title = title
    }

    override fun setForecastDetails(forecastDetails: List<ForecastDetail>) {
        weatherAdapter.submitList(forecastDetails)
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }
}