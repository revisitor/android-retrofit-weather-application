package ru.mtrefelov.retrofitforecaster.main.model.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

import timber.log.Timber

import ru.mtrefelov.retrofitforecaster.main.model.entity.WeatherResponse

class OpenWeatherApi(private val apiKey: String) {
    private val service: OpenWeatherService = run {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.openweathermap.org/")
            .build()

        retrofit.create(OpenWeatherService::class.java)
    }

    fun getWeatherData(latitude: Double, longitude: Double, action: (WeatherResponse) -> Unit) {
        service
            .getWeatherData(latitude, longitude, apiKey)
            .enqueue(WeatherResponseCallback(action))
    }

    private class WeatherResponseCallback(private val action: (WeatherResponse) -> Unit) : Callback<WeatherResponse> {
        override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
            response.body()?.let {
                Timber.d(it.toString())
                action(it)
            }
        }

        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
            Timber.e(t)
        }
    }
}