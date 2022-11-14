package ru.mtrefelov.forecaster.app

import android.app.Application

import ru.mtrefelov.forecaster.BuildConfig

import timber.log.Timber

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}