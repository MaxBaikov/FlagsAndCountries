package ru.selfmadeperson.flagscountries.di

import dagger.Component
import ru.selfmadeperson.flagscountries.di.module.*
import ru.selfmadeperson.flagscountries.mvp.presenter.*
import ru.selfmadeperson.flagscountries.ui.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CiceroneModule::class,
        CountryModule::class,
        DatabaseModule::class,
        ImageModule::class,
        RepoModule::class

    ]
)

interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(flagGuessPresenter: FlagGuessPresenter)
    fun inject(countryDescriptionPresenter: CountryDescriptionPresenter)
    fun inject(countriesPresenter: CountriesPresenter)
    fun inject(citiesGuessPresenter: CitiesGuessPresenter)

}