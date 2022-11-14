package ru.mtrefelov.forecaster.app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.mtrefelov.forecaster.app.model.core.Forecast

class ForecastFragment : Fragment() {
    lateinit var forecasts: List<Forecast>
    lateinit var city: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        city = arguments?.getString(CITY) ?: ""
        forecasts = arguments?.getParcelableArrayList(FORECASTS) ?: emptyList()
    }

    companion object ARGUMENT {
        const val CITY = "CITY"
        const val FORECASTS = "FORECASTS"
    }
}