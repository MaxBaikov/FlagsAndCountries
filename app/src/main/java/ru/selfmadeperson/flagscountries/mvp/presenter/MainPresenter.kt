package ru.selfmadeperson.flagscountries.mvp.presenter

import moxy.MvpPresenter
import ru.selfmadeperson.flagscountries.mvp.view.MainView
import ru.selfmadeperson.flagscountries.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter() : MvpPresenter<MainView>() {

    @Inject lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.FlagGuessScreen())
    }

    fun backClicked() {
        router.exit()
    }
}