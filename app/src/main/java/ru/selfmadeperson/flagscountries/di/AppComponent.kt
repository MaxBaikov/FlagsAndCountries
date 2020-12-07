package ru.selfmadeperson.flagscountries.di

import dagger.Component
import ru.selfmadeperson.flagscountries.di.module.AppModule
import ru.selfmadeperson.flagscountries.di.module.CiceroneModule
import ru.selfmadeperson.flagscountries.mvp.presenter.FlagGuessPresenter
import ru.selfmadeperson.flagscountries.mvp.presenter.MainPresenter
import ru.selfmadeperson.flagscountries.ui.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
    ]
)

interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(flagGuessPresenter: FlagGuessPresenter)

}