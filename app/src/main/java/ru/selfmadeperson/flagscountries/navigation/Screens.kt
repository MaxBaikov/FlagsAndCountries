package ru.selfmadeperson.flagscountries.navigation

import ru.selfmadeperson.flagscountries.ui.fragments.CitiesGuessFragment
import ru.selfmadeperson.flagscountries.ui.fragments.CountriesFragment
import ru.selfmadeperson.flagscountries.ui.fragments.CountryDescriptionFragment
import ru.selfmadeperson.flagscountries.ui.fragments.FlagGuessFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class FlagGuessScreen() : SupportAppScreen() {
        override fun getFragment() = FlagGuessFragment.newInstance()
    }

    class CitiesGuessScreen() : SupportAppScreen() {
        override fun getFragment() = CitiesGuessFragment.newInstance()
    }

    class CountriesScreen() : SupportAppScreen() {
        override fun getFragment() = CountriesFragment.newInstance()
    }

    class CountryDescriptionScreen() : SupportAppScreen() {
        override fun getFragment() = CountryDescriptionFragment.newInstance()
    }
}


