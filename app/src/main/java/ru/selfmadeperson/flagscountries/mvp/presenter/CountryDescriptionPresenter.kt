package ru.selfmadeperson.flagscountries.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.selfmadeperson.flagscountries.mvp.view.CountryDescriptionView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class CountryDescriptionPresenter : MvpPresenter<CountryDescriptionView>() {

    @Inject lateinit var scheduler: Scheduler
    @Inject lateinit var router: Router


    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}