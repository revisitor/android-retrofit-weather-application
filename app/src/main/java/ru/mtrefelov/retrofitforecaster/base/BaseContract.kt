package ru.mtrefelov.retrofitforecaster.base

interface BaseContract {
    interface Presenter {
        fun onDestroy()
    }

    interface View<T : Presenter> {
        fun setPresenter(presenter: T)
    }
}