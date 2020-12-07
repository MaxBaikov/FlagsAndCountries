package ru.selfmadeperson.flagscountries.navigation

import ru.selfmadeperson.flagscountries.ui.fragments.FlagGuessFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class FlagGuessScreen() : SupportAppScreen() {
        override fun getFragment() = FlagGuessFragment.newInstance()
    }
}


